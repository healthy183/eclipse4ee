
package test;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class SVNToExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		SAXReader reader = new SAXReader();
		Document document = reader.read(new FileInputStream("d:/svnlog.xml"));

		Element root = document.getRootElement();

		XLSExport e = new XLSExport("d:/svnlog.xls");
		e.createRow(0);
		
		short index0 = 0;
		e.setCell(index0, "Revision");
		
		short index1 = 1;
		e.setCell(index1, "Author");
		
		short index2 = 2;
		e.setCell(index2, "Date");
		
		short index3 = 3;
		e.setCell(index3, "Message(related issue)");
		
		short index4 = 4;
		e.setCell(index4, "Modifications");

		int row = 1;
		List elements = root.elements("logentry");
		Iterator iter = elements.iterator();
		while (iter.hasNext()) {
			Element element = (Element) iter.next();
			System.out.println(element.asXML());
			e.createRow(row);
			e.setCell(index0, element.attributeValue("revision"));
			Element author = element.element("author");
			if (author != null)
				e.setCell(index1, author.getText());
			Element date = element.element("date");
			if (date != null)
				e.setCell(index2, date.getText());
			Element message = element.element("msg");
			if (message != null)
				e.setCell(index3, message.getText());

			Element path = element.element("paths");

			if (path != null) {
				List<Element> ps = path.elements();
				StringBuilder sb = new StringBuilder();
				for (Element p : ps) {
					String action = p.attributeValue("action");
					sb.append("["+action+"] "+p.getText() + "\n");
				}

				if(sb.length()>5000){
					e.setCell(index4, sb.toString().substring(0,5000));
				}else{
					e.setCell(index4, sb.toString());
				}
			}
			row++;
		}
		try {
			e.exportXLS();
			System.out.println(" 导出Excel文件[成功] ");
		} catch (Exception e1) {
			System.out.println(" 导出Excel文件[失败] ");
			e1.printStackTrace();
		}
	}

}
