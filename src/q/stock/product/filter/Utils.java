package q.stock.product.filter;

import java.util.List;

import q.stock.product.dto.SearchDto;

public class Utils {

	/**
	 * get sql query from filters criteria.
	 * 
	 * @param filterValue
	 * @param filters
	 */
	public static String getCriteria(List<SearchDto> filters) {
		String filterValue = "";
		for (SearchDto filter : filters) {
			if (filter.getOperation().equals("like"))
				filterValue += filter.getFieldName() + " like '%" + filter.getValue() + "%'" + " or ";
			else if (filter.getOperation().equals("equal"))
				filterValue += filter.getFieldName() + "='" + filter.getValue() + "' or ";
			else if (filter.getOperation().equals("between"))
				filterValue += filter.getFieldName() + " between '" + filter.getValue().split(",")[0] + "' and '"
						+ filter.getValue().split(",")[0] + "' or ";
			else if (filter.getOperation().equals("gt"))
				filterValue += filter.getFieldName() + ">='" + filter.getValue() + "' or ";
			else if (filter.getOperation().equals("lt"))
				filterValue += filter.getFieldName() + "<='" + filter.getValue() + "' or ";
			else if (filter.getOperation().equals("in"))
				filterValue += filter.getFieldName() + " in " + filter.getValue() + " or ";
		}

		if (filterValue != "") {
			int lastindex = filterValue.lastIndexOf("or");
			filterValue = filterValue.substring(0, lastindex - 1);
		}

		return filterValue;

	}

}
