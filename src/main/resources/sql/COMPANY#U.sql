UPDATE T_COMPANY 
SET 
	UPDATED = :updated,
	UPDATED_BY = :updatedBy,
	CONTACT_NUM = CASE WHEN :contactNumber IS NULL THEN CONTACT_NUM ELSE :contactNumber END,
	NAME = CASE WHEN :name IS NULL THEN NAME ELSE :name END,
	ADDR_LINE_1 = CASE WHEN :addressLine1 IS NULL THEN ADDR_LINE_1 ELSE :addressLine1 END,
	ADDR_LINE_2 = CASE WHEN :addressLine2 IS NULL THEN ADDR_LINE_2 ELSE :addressLine2 END,
	ADDR_LINE_3 = CASE WHEN :addressLine3 IS NULL THEN ADDR_LINE_3 ELSE :addressLine3 END,
	POSTCODE = CASE WHEN :postcode IS NULL THEN POSTCODE ELSE :postcode END,
	MT_STATE_ID = CASE WHEN :stateId IS NULL THEN MT_STATE_ID ELSE :stateId END, 
	MT_CTRY_ID = CASE WHEN :countryId IS NULL THEN MT_CTRY_ID ELSE :countryId END,
	BRN = CASE WHEN :brn IS NULL THEN BRN ELSE :brn END,
	STATUS = CASE WHEN :status IS NULL THEN STATUS ELSE :status END,
	IS_DEL = CASE WHEN :delete IS NULL THEN IS_DEL ELSE :delete END

	
WHERE ID = :id