package com.topsun.posclient.common.ui.menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.topsun.posclient.common.ui.utils.ColorUtils;
import com.topsun.posclient.widget.pshelf.PShelf;

public class TopSunMenuTree extends ViewPart{


	/**
	 * 
	 */
	public TopSunMenuTree() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setBackground(ColorUtils.getSystemColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(1,false);
		gridLayout.marginBottom = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginLeft = 0;
		gridLayout.marginRight = 0 ;
		gridLayout.marginTop = 0;
		gridLayout.marginWidth = 0;
		composite.setLayout(gridLayout);
		PShelf pShelf = new PShelf(composite, SWT.NONE);
		
		pShelf.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		MenuTreeManagerFacede.getInstance().loadMenuExtension();
		MenuTreeManagerFacede.getInstance().initMenu(pShelf);

	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}


}
