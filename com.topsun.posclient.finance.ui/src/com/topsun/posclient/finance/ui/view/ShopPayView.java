package com.topsun.posclient.finance.ui.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import com.topsun.posclient.common.POSClientApp;
import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.ui.utils.ImageUtils;
import com.topsun.posclient.datamodel.PayRecord;
import com.topsun.posclient.datamodel.User;
import com.topsun.posclient.datamodel.dto.PayRecordDTO;
import com.topsun.posclient.finance.service.IShopPayService;
import com.topsun.posclient.finance.service.impl.ShopPayServiceImpl;
import com.topsun.posclient.finance.ui.FinanceUIActivator;
import com.topsun.posclient.finance.ui.cell.DateCellEditor;

/**
 * 店铺缴款视图
 * 
 * @author Dong
 *
 */
public class ShopPayView extends ViewPart {
	
	public IShopPayService shopPayService = new ShopPayServiceImpl();

	public List<PayRecord> payRecords = new ArrayList<PayRecord>();
	
	/**
	 * 店铺缴款记录列表
	 */
	public TableViewer tableViewer;

	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,false));
		Composite opertaionArea = new Composite(parent, SWT.NONE);
		Composite payRecodeArea = new Composite(parent, SWT.NONE);
		Composite saveAndCancelArea = new Composite(parent, SWT.NONE);
		buildOperation(opertaionArea);
		buildTableViewer(payRecodeArea);
	}
	
	public void buildOperation(Composite parent){
		GridLayout gridLayout = new GridLayout(3,true);
		parent.setLayout(gridLayout);
		{
			Button button = new Button(parent, SWT.NONE);
			button.setText("新增");
			button.setImage(ImageUtils.createImage(FinanceUIActivator.PLUGIN_ID, "icons//ok.gif"));
			GridData data = new GridData();
			data.heightHint = 28;
			data.widthHint = 120;
			button.setLayoutData(data);
			button.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
				
					
					User user = POSClientApp.get().getLoginUser();
					
					if(tableViewer.getInput()!=null){
						PayRecord input = new PayRecord();

						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						
						String date = dateFormat.format(Calendar.getInstance().getTime());
						input.setApproveDate(date);
						input.setApprove(user.getUserName());
						
						payRecords.add(input);
						tableViewer.setInput(payRecords);
					}else{
						PayRecord input = new PayRecord();

						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						
						String date = dateFormat.format(Calendar.getInstance().getTime());
						input.setApproveDate(date);
						input.setApprove(user.getUserName());
						payRecords.add(input);
						tableViewer.setInput(payRecords);
					}
					
			
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		{
			Button button = new Button(parent, SWT.NONE);
			button.setText("删除");
			button.setImage(ImageUtils.createImage(FinanceUIActivator.PLUGIN_ID, "icons//nook.png"));
			GridData data = new GridData();
			data.heightHint = 28;
			data.widthHint = 120;
			button.setLayoutData(data);
			
			button.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					ISelection iSelection = tableViewer.getSelection();
					if(!iSelection.isEmpty()){
						Object obj = ((StructuredSelection)iSelection).getFirstElement();
						if(obj instanceof PayRecord){
							PayRecord item = (PayRecord)obj;
							List<PayRecord> items = (List<PayRecord>)tableViewer.getInput();
							items.remove(item);
							tableViewer.setInput(items);
						}
					}
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		{
			Button button = new Button(parent, SWT.NONE);
			button.setText("保存");
			button.setImage(ImageUtils.createImage(FinanceUIActivator.PLUGIN_ID, "icons//ok.gif"));
			GridData data = new GridData();
			data.heightHint = 28;
			data.widthHint = 120;
			button.setLayoutData(data);
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					try {
						PayRecordDTO payRecordDTO = new PayRecordDTO();
						payRecordDTO.setPayRecordList(payRecords);
						shopPayService.saveShopPay(payRecordDTO);
					} catch (POSException e1) {
						Button saveButton = (Button)e.getSource();
						MessageDialog.openError(saveButton.getShell(), "提示", e1.getErrorMessage());
						return;
					}
				}
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}
			});
		}
		
	}

	public void setFocus() {}
	
	public void buildTableViewer(Composite parent){
		GridLayout gridLayout = new GridLayout(1,false);
		parent.setLayout(gridLayout);
		GridData data = new GridData(GridData.FILL_BOTH);
		parent.setLayoutData(data);
		
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER|SWT.FULL_SELECTION);
		tableViewer.setContentProvider(new PayRecordTableContentProvider());
		tableViewer.setLabelProvider(new PayRecordTableLableProvider());
		Table table = tableViewer.getTable();
		{
			GridData tableData = new GridData(GridData.FILL_BOTH);
			table.setLayoutData(tableData);
			table.setHeaderVisible(true);
			table.setLinesVisible(false);
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(120);
			column.setText("缴款时间");
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(100);
			column.setText("存款银行 ");
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(100);
			column.setText("银行帐号");
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(100);
			column.setText("存款金额");
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(100);
			column.setText("存款人");
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(120);
			column.setText("审核人");
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(120);
			column.setText("审核时间");
		}
		{
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setWidth(120);
			column.setText("备注");
		}
		
		table.addListener(SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				//鼠标双击事件
			} 
		});
		
	    CellEditor[] cellEditor = new CellEditor[8];
	    cellEditor[0] = new DateCellEditor(this.tableViewer.getTable());
	    cellEditor[1] = new TextCellEditor(this.tableViewer.getTable());
	    cellEditor[2] = new TextCellEditor(this.tableViewer.getTable());
	    cellEditor[3] = new TextCellEditor(this.tableViewer.getTable());
	    cellEditor[4] = new TextCellEditor(this.tableViewer.getTable());
	    cellEditor[5] = new TextCellEditor(this.tableViewer.getTable());
	    cellEditor[6] = new DateCellEditor(this.tableViewer.getTable());
	    cellEditor[7] = new TextCellEditor(this.tableViewer.getTable());
	    tableViewer.setCellEditors(cellEditor);
	    String[] properties =  new String[] { "payDate", "bankName", "account", "amount", "payer", "approve", "approveDate", "remark" };
	    tableViewer.setColumnProperties(properties);
	    ICellModifier modifier = new PayReCordCellModifier(tableViewer, parent);
		tableViewer.setCellModifier(modifier);
	}
}
