/****************************************************************************
Copyright (c) 2004, Colorado School of Mines and others. All rights reserved.
This program and accompanying materials are made available under the terms of
the Common Public License - v1.0, which accompanies this distribution, and is 
available at http://www.eclipse.org/legal/cpl-v10.html
****************************************************************************/
package edu.mines.jtk.mosaic.test;

import java.awt.*;
import javax.swing.*;
import edu.mines.jtk.mosaic.*;

/**
 * Test {@link edu.mines.jtk.mosaic.Mosaic} and associates.
 * @author Dave Hale, Colorado School of Mines
 * @version 2004.12.27
 */
public class MosaicTest {

  public static void main(String[] args) {
    int nrow = 2;
    int ncol = 3;
    int axesPlacement =
      Mosaic.AXES_TOP |
      Mosaic.AXES_LEFT |
      Mosaic.AXES_BOTTOM |
      Mosaic.AXES_RIGHT;
    int borderStyle = Mosaic.BORDER_SHADOW;
    Mosaic mosaic = new Mosaic(nrow,ncol,axesPlacement,borderStyle);
    mosaic.setWidthMinimum(1,200);
    mosaic.setWidthElastic(1,200);
    mosaic.setHeightElastic(0,0);
    mosaic.setPreferredSize(new Dimension(600,600));
    Tile tile11 = mosaic.getTile(1,1);
    tile11.setViewRectangle(new DRectangle(0.1,0.1,0.8,0.8));
    //TileAxis axist1 = mosaic.getTileAxisTop(1);
    //axist1.setFont(new Font("Helvetica",Font.PLAIN,18));
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(mosaic);
    frame.pack();
    frame.setVisible(true);
  }
}
