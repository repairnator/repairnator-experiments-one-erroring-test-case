/*
    This file is part of RouteConverter.

    RouteConverter is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    RouteConverter is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with RouteConverter; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Copyright (C) 2007 Christian Pesch. All Rights Reserved.
*/
package slash.navigation.converter.gui.actions;

import slash.navigation.converter.gui.models.PositionsModel;
import slash.navigation.converter.gui.panels.ConvertPanel;
import slash.navigation.gui.actions.FrameAction;

import javax.swing.*;

import static slash.navigation.gui.events.Range.increment;

/**
 * {@link Action} that moves the selected rows of a {@link JTable} one position up in the {@link PositionsModel}.
 *
 * @author Christian Pesch
 */

public class UpAction extends FrameAction {
    private final ConvertPanel convertPanel;

    public UpAction(ConvertPanel convertPanel) {
        this.convertPanel = convertPanel;
    }

    public void run() {
        int[] selectedRows = convertPanel.getPositionsView().getSelectedRows();
        if (selectedRows.length > 0) {
            convertPanel.getPositionsModel().up(selectedRows, 1);
            convertPanel.selectPositions(increment(selectedRows, -1));
        }
    }
}
