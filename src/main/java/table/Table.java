package table;

import java.util.ArrayList;
import java.util.List;

public class Table {

	List<Row> rows = new ArrayList<Row>();

	public Row addRow() {
		Row r = new Row();
		rows.add(r);
		return r;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (Row row : rows) {
			sb.append(row.toString());
		}
		sb.append("]");

		return sb.toString();
	}

	static class Row {
		List<Column> cols = new ArrayList<Column>();

		public void addColumn(String name, String value) {
			cols.add(new Column(name, value));
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("(");
			boolean first = true;

			for (Column col : cols) {
				if (!first)
					sb.append(",");
				sb.append(col.toString());
				first = false;
			}
			sb.append(")");

			return sb.toString();
		}
	}

	static class Column {

		String name;
		String value;

		public Column(String name, String value) {
			this.name = name;
			this.value = value;
		}

		@Override
		public String toString() {
			return name + ":" + value;
		}
	}

	public static void main(String[] args) {

		Table table = new Table();
		Row r = table.addRow();

		r.addColumn("id", "1");
		r.addColumn("name", "Kiran");
		r.addColumn("phone", "123-456-789");
		r.addColumn("address", "test123");

		System.out.println(table);
	}
}
