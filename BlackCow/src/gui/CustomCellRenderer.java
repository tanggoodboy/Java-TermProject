package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CustomCellRenderer extends DefaultTableCellRenderer
{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{
		
		Component c = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
		
		String str;
		double num;
		Color color;
		
		str = table.getValueAt(row, 2).toString().replaceAll("%", "").replaceAll(",", "");
		num = Double.parseDouble(str);
		
		color = getColor(num);

		switch (column)
		{
		case 0:
			c.setFont(new Font("���� ����", Font.BOLD, 12));
			break;
			
		case 1:
			c.setForeground(color);
			c.setFont(new Font("���� ����", Font.BOLD, 12));
			setHorizontalAlignment(SwingConstants.RIGHT);
			break;
			
		case 2:
			c.setForeground(color);
			c.setFont(new Font("���� ����", Font.BOLD, 12));
			setHorizontalAlignment(SwingConstants.RIGHT);
			break;
			
		case 3:
			setHorizontalAlignment(SwingConstants.RIGHT);
			break;
		}
		
		return c;
		

//
//		switch (column)
//		{
//		case 0:
//			break;
//			
//		case 1:
//			setHorizontalAlignment(SwingConstants.RIGHT);
//			break;
//			
//		case 2:
//			str = table.getValueAt(row, column).toString().replaceAll("%", "");
//			num = Double.parseDouble(str);
//			
//			c.setForeground(getColor(num));
//			setHorizontalAlignment(SwingConstants.RIGHT);
//			break;
//			
//		case 3:
//			setHorizontalAlignment(SwingConstants.RIGHT);
//			break;
//		}
//		
//		return c;
	}
	
	public Color getColor(double num)
	{
		if (num > 0)
		{
			return Color.RED;
		}
		else if (num < 0)
		{
			return Color.BLUE;
		}
		else
		{
			return Color.BLACK;
		}
	}
}