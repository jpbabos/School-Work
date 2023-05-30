%-----------------------------------------------------------------------------------------------
% No conflict base case
nc(_,[],_).

%---------------------------------------------------------------
% No conflict/3
% int v (row value for new column to be added to solution list)
% list p (existing solution list)
% int d (number of coulmns between v and head of p)
%---------------------------------------------------------------
nc(V,P,D) :-
	P = [H|T],
	V =\= H, %no row conflict
	D =\= abs(V - H), %no diagonal conflicts
	DP1 is D+1,
	nc(V,T,DP1). %recursive call on tail of p and D+1

%-----------------------------------------------------------------------------------------------
% solve/2
% int n (number of columns/rows)
% list qp (list of solutions)
%---------------------------------------------------------------
solve(N,QP):-
	solve(N,[],QP).

%---------------------------------------------------------------
% solve/3
% list qpt (list of partial solutions
% finds a row value for a new column and adds it to QPT if it does not have any conflicts
%---------------------------------------------------------------
solve(N,QPT,QP):-
	length(QPT,L),
	L<N,
	NM1 is N-1,
	between(0,NM1,V),
	nc(V,QPT,1),
	QPT1 = [V|QPT], %appends row value to temp qp list
	solve(N,QPT1,QP).
%---------------------------------------------------------------
% stoping condition. Once the length of possible solutions is the same as the size of problem, it matches QP to QPT
%---------------------------------------------------------------
solve(N,QPT,QP):-
	length(QPT,L),
	L=:=N,
	QP=QPT.