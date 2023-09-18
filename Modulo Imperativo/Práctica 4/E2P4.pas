Program E2P4;
{Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:

a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.

i. En una estructura cada préstamo debe estar en un nodo.

ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).}
Type
	prestamo=record
		ISBN:integer;
		socio:integer;
		dia:integer;
		mes:integer;
		duracion:integer;
	end;
	
	arbol1=^nodoA1;
	
	nodoA1=record
		dato:prestamo;
		HI:arbol1;
		HD:arbol1;
	end;
	
	prestamo2=record
		socio:integer;
		dia:integer;
		mes:integer;
		duracion:integer;
	end;
	
	lista=^nodoL;
	
	nodoL=record
		dato:prestamo2;
		sig:lista;
	end;
	
	arbol2=^nodoA2;
	
	nodoA2=record
		ISBN:integer;
		listapres:lista;
		HI:arbol2;
		HD:arbol2;
	end;
{-----------------------------------------------------------------------}
Procedure LeerPrestamo (var p:prestamo);
begin
	write('Ingrese ISBN del producto: ');readln(p.ISBN);
	if (p.ISBN<>-1) then begin
		write('Ingrese socio solicitante: ');readln(p.socio);
		write('Ingrese dia de efecto del préstamo: ');readln(p.dia);
		write('Ingrese mes de efecto del préstamo: ');readln(p.mes);
		write('Ingrese la duración del préstamo: ');readln(p.duracion)
	end;
end;
{-----------------------------------------------------------------------}
Procedure Agregar1(var a:arbol1; p:prestamo);
begin
	if (a=nil) then begin
		new(a);
		a^.dato:=p;
		a^.HI:=nil;
		a^.HD:=nil
	end
	else if (p.ISBN<=a^.dato.ISBN) then
		Agregar1(a^.HI,p)
	else
		Agregar1(a^.HD,p);
end;
{-----------------------------------------------------------------------}
Procedure AgregarAdelante(var L:lista ; p:prestamo);
var
	AUX:lista;
begin
	new (AUX);
	AUX^.dato.socio:=p.socio;
	AUX^.dato.dia:=p.dia;
	AUX^.dato.mes:=p.mes;
	AUX^.dato.duracion:=p.duracion;
	AUX^.sig:=L;
	L:=AUX;
end;
{-----------------------------------------------------------------------}
Procedure Agregar2 (var a2:arbol2; p:prestamo);
begin
	if (a2=nil) then begin
		new(a2);
		a2^.ISBN:=p.ISBN;
		new(a2^.listapres);
		a2^.listapres:=nil;
		AgregarAdelante(a2^.listapres,p);
		a2^.HI:=nil;
		a2^.HD:=nil
	end;
	
	if (p.ISBN=a2^.ISBN) then
		AgregarAdelante(a2^.listapres,p)
	else if (p.ISBN<a2^.ISBN) then
		Agregar2(a2^.HI,p)
	else
		Agregar2(a2^.HD,p)
end;
{-----------------------------------------------------------------------}
Procedure CrearArboles (var a1:arbol1 ; var a2:arbol2);
var
	p:prestamo;
begin
	LeerPrestamo(p);
	while (p.ISBN>-1) do begin
		Agregar1(a1,p);
		Agregar2(a2,p);
		LeerPrestamo(p)
	end;
end;
	
{-----------------------------------------------------------------------}
var
	a1:arbol1;
	a2:arbol2;
begin
	a1:=nil;
	a2:=nil;
	CrearArboles(a1,a2);
end.
