package com.faitmain.domain.user.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class UserBan {
	boolean  banplatform;
	boolean  bansell;
	boolean  banreview;
	boolean  banchart;
}
