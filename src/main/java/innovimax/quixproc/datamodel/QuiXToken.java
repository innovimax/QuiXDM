/*
QuiXProc: efficient evaluation of XProc Pipelines.
Copyright (C) 2011-2015 Innovimax
All rights reserved.

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 3
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package innovimax.quixproc.datamodel;

/**
 * The {@code QuiXToken} is the central enum of QuiXDM It contains all the
 * Events that a full QuiXDM implementation must support
 */
public enum QuiXToken implements IQuiXToken {
	// Here is the grammar of events
	// sequence := START_SEQUENCE, (document|json_yaml|table|semantic)*,
	// END_SEQUENCE
	// document := START_DOCUMENT, (PROCESSING-INSTRUCTION|COMMENT)*, element,
	// (PROCESSING-INSTRUCTION|COMMENT)*, END_DOCUMENT
	// json_yaml := START_JSON, object, END_JSON
	// table := START_TABLE, header*, array_of_array, END_TABLE
	// semantic := START_RDF, statement*, END_RDF
	// element := START_ELEMENT, (NAMESPACE|ATTRIBUTE)*,
	// (TEXT|element|PROCESSING-INSTRUCTION|COMMENT)*, END_ELEMENT
	// object := START_OBJECT, (KEY_NAME, value)*, END_OBJECT
	// value := object|array|flat_value
	// header := COLNAME
	// array := START_ARRAY, value*, END_ARRAY
	// array_of_array := START_ARRAY, flat_array+, END_ARRAY
	// flat_array := START_ARRAY, flat_value*, END_ARRAY
	// flat_value := VALUE_FALSE|VALUE_TRUE|VALUE_NUMBER|VALUE_NULL|VALUE_STRING
	// statement := START_PREDICATE, SUBJECT, OBJECT, GRAPH?, END_PREDICATE

	// To support BSON add VALUE_BIN and VALUE_EPOCH (or add a property on
	// VALUE_STRING isBin and VALUD_NUMBER isEpoch)
	// To support UBSON no need to add anything
	// To support SMILE no need to add anything

	// in RDF, we may need to store prefix mapping

	// SEQUENCE
	START_SEQUENCE, END_SEQUENCE,
	// XML and HTML
	START_DOCUMENT, END_DOCUMENT, START_ELEMENT, END_ELEMENT, NAMESPACE, ATTRIBUTE, TEXT, PROCESSING_INSTRUCTION, COMMENT,
	// JSON or YAML
	START_JSON, END_JSON, START_ARRAY, END_ARRAY, START_OBJECT, END_OBJECT, KEY_NAME, VALUE_FALSE, VALUE_TRUE, VALUE_NUMBER, VALUE_NULL, VALUE_STRING,
	// CSV, TSV
	START_TABLE, END_TABLE, COLNAME,
	// RDF triple or quad
	START_RDF, END_RDF, START_PREDICATE, END_PREDICATE, SUBJECT, OBJECT, GRAPH;
	@Override
	public QuiXToken getType() {
		return this;
	}
}