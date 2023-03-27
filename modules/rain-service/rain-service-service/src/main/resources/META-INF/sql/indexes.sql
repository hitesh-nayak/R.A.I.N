create index IX_22F0B689 on Rain_Doctor (contactNumber[$COLUMN_LENGTH:75$]);
create index IX_1C12CAB6 on Rain_Doctor (department[$COLUMN_LENGTH:75$]);
create index IX_5DEFE3DC on Rain_Doctor (email[$COLUMN_LENGTH:75$]);
create index IX_BDFD2205 on Rain_Doctor (govtId[$COLUMN_LENGTH:75$]);
create index IX_F34A0B7C on Rain_Doctor (nationality[$COLUMN_LENGTH:75$]);
create index IX_DFF3C55B on Rain_Doctor (payGroup[$COLUMN_LENGTH:75$]);
create index IX_87A489DB on Rain_Doctor (surname[$COLUMN_LENGTH:75$]);

create index IX_48DAACCF on Rain_Patient (age);
create index IX_48712F59 on Rain_Patient (contactNumber[$COLUMN_LENGTH:75$]);
create index IX_5A9E2CAC on Rain_Patient (email[$COLUMN_LENGTH:75$]);
create index IX_A19C89E5 on Rain_Patient (insuranceId[$COLUMN_LENGTH:75$]);
create index IX_F132784C on Rain_Patient (nationality[$COLUMN_LENGTH:75$]);
create index IX_7928AF91 on Rain_Patient (primaryDoctor);
create index IX_11E3DEAB on Rain_Patient (surname[$COLUMN_LENGTH:75$]);