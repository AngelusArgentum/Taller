Program E3P3;
Type
	finales=record
		code:integer;
		nota:integer;
	end;
	
	lista=^nodoL;
	
	nodoL=record
		dato:finales;
		sig:lista;
	end;
	
	alumno=record
		notas:lista;
		legajo:integer;
		DNI:integer;
		ingreso:integer;
	end;
	
	arbol=^nodoA;
	nodoA=record
		dato:alumno;
		HI:arbol;
		HD:arbol;
	end;

{--------------------------}

Procedure ImprimirArbol (ar:arbol);
var
	Ltemp:lista;
begin
	if(ar<>nil) then begin
		ImprimirArbol(ar^.HI);
		writeln('DNI del alumno: ',ar^.dato.DNI,'.');
		writeln('Legajo del alumno: ',ar^.dato.legajo,'.');
		writeln('Ingreso del alumno: ',ar^.dato.ingreso,'.');
			Ltemp:=ar^.dato.notas;
			writeln('----NOTAS----');
			while (Ltemp<>nil) do begin
				writeln('Codigo de final: ',Ltemp^.dato.code,'.');
				writeln('Nota de final: ',Ltemp^.dato.nota,'.');
				Ltemp:=Ltemp^.sig
			end;
		ImprimirArbol(ar^.HD);
	end;
end;

{--------------------------}

Procedure AgregarAdelante (var l:lista ; f:finales);
var
	AUX:lista;
begin
	new(AUX);
	AUX^.dato:=f;
	AUX^.sig:=l;
	if (l=nil) then
		l:=AUX
	else begin
		AUX^.sig:=l;
		l:=AUX
	end;
end;

{--------------------------}

Procedure LeerNotas (var f:finales);
begin
	write ('Codigo del final: ');
	readln(f.code);
	if (f.code<>-1) then begin
		write('Nota obtenida: ');
		readln(f.nota);
	end;
end;

{--------------------------}

Procedure LeerAlumno (var al:alumno);
var
	f:finales;
	code:integer;
begin
	code:=0;
	write('Legajo: ');
	readln(al.legajo);
	if (al.legajo<>0) then begin
		write('DNI: ');
		readln(al.DNI);
		write('Año de ingreso: ');
		readln(al.ingreso);
		while (code<>-1) do begin
			LeerNotas(f);
			code:=f.code;
			if (f.code<>-1) then
				AgregarAdelante(al.notas,f);
		end;
	end;
end;

{--------------------------}

Procedure Agregar (var ar:arbol ; al:alumno);
begin
	if (ar=nil) then begin
		new(ar);
		ar^.dato:=al;
		ar^.HI:=nil;
		ar^.HD:=nil
	end
	else if (al.legajo<=ar^.dato.legajo) then
		Agregar(ar^.HI,al)
	else 
		Agregar(ar^.HD,al);
end;

{--------------------------}

Procedure ArmarArbol (var ar:arbol);
var
	al:alumno;
	numAUX:integer;
begin
	numAUX:=-1;
	while (numAUX<>0) do begin
		al.notas:=nil;
		LeerAlumno(al);
		numAUX:=al.legajo;
		if (numAUX<>0) then
			Agregar(ar,al)
	end;
end;

{--------------------------}

Procedure IngresoDNIMenorQue (a:arbol);
	Procedure InOrder(a:arbol;x:integer);
	begin
		if(a<>nil) then begin
			InOrder (a^.HI,x);
			if (a^.dato.legajo<x) then begin
				writeln('DNI: ',a^.dato.DNI,'.');
				writeln('Ingreso: ',a^.dato.ingreso,'.')
			end;
			InOrder (a^.HD,x)
		end;
	end;		
var
	x:integer;
begin
	write('Ingrese un número de legajo del que buscar año de Ingreso y DNI asociados a todo legajo menor: ');
	readln(x);
	InOrder(a,x);
end;

{--------------------------}

Function MayorLegajo (a:arbol):integer;
begin
	if(a=nil) then MayorLegajo:=a^.dato.legajo
	else MayorLegajo:=MayorLegajo(a^.HD)
end;

{--------------------------}

Function MayorDNI (a:arbol):integer;
	Procedure EsMayor (a:arbol ; x:integer);
	begin
		if(a<>nil) then begin
			EsMayor(a^.HI,x);
			if (a^.dato.DNI>x) then
				x:=a^.dato.DNI;
			EsMayor(a^.HD,x);
		end;
	end;
var
	x:integer;
begin
	x:=0;
	EsMayor(a,x);
	if (x<>0) then
		MayorDNI:=x
	else
	writeln('No hay datos cargados. Mayor DNI indeterminable.');
end;

{--------------------------}

Function LegajoMayorPromedio (a:arbol):integer;
	Procedure ObtenerPromedioNotasLista (L:lista; var promedio:real);
	var
		SumaNotas:integer;
		CantNotas:integer;
	begin
		SumaNotas:=0;
		CantNotas:=0;
		while (L<>nil) do begin
			SumaNotas:=SumaNotas+L^.dato.nota;
			CantNotas:=CantNotas+1
		end;
		promedio:=SumaNotas/CantNotas
	end;
	
	Procedure RecorrerArbolBuscandoMAXProm (a:arbol ; var lMAX:integer; var pMAX:real);
		var
			Ltemp:lista;
			prom:real;
	begin
		if (a<>nil) then begin
			RecorrerArbolBuscandoMAXProm(a^.HI,lMAX,pMAX);
			Ltemp:=a^.dato.notas;
			ObtenerPromedioNotasLista(Ltemp,prom);
			if (prom>pMAX) then begin
				pMAX:=prom;
				lMAX:=a^.dato.legajo
			end;
			RecorrerArbolBuscandoMAXProm(a^.HD,lMAX,pMAX);
		end;
	end;
var
	lMAX:integer;
	pMAX:real;
begin
	lMAX:=0;
	pMAX:=0;
	RecorrerArbolBuscandoMAXProm(a,lMAX,pMAX);
	LegajoMayorPromedio:=lMAX;
end;
{--------------------------}

var
	a:arbol;
begin
	a:=nil;
	ArmarArbol(a);
	ImprimirArbol(a);
	IngresoDNIMenorQue(a);
	MayorLegajo(a);
	MayorDNI(a);
	LegajoMayorPromedio(a);
end.
