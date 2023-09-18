Program E2P3;
{a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee
código de producto y cantidad de unidades vendidas. La lectura finaliza con el código de
producto 0. Un producto puede estar en más de una venta. Se pide:

1- Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto.

2- Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendida.
Nota: El módulo debe retornar los dos árboles.

b. Implemente un módulo que reciba el árbol generado en 1- y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.}

Type
	venta=record
		code:integer;
		cant:integer;
	end;
	arbol=^nodo;
	nodo=record
		dato:venta;
		HI:arbol;
		HD:arbol;
	end;

{~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~}
Procedure LeerVenta (var v:venta);
begin
	write('Ingrese el codigo de producto vendido: ');readln(v.code);
	if (v.code>0) then begin
		write('Ingrese la cantidad vendida del producto: ');readln(v.cant)
	end;
end;
{~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~}
Procedure Agregar (var a:arbol ; v:venta);
begin
	if (a=nil) then begin
		new (a);
		a^.dato:=v;
		a^.HI:=nil;
		a^.HD:=nil
	end
	else if (v.code<=a^.dato.code) then Agregar(a^.HI,v)
	else Agregar (a^.HD,v);
end;
{~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~}
Procedure Agregar2 (var a2:arbol; v:venta);
begin
	if (a2=nil) then begin
		new (a2);
		a2^.dato:=v;
		a2^.HI:=nil;
		a2^.HD:=nil
	end
	else if (a2^.dato.code=v.code) then
		a2^.dato.cant:=a2^.dato.cant + v.cant
		else if (v.code<a2^.dato.code) then
			Agregar2(a2^.HI,v)
			else
				Agregar2(a2^.HD,v)
end;
{~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~}
Procedure CrearArboles (var a1:arbol; var a2:arbol);
var
	v:venta;
begin
	LeerVenta(v);
	while (v.code>0) do begin
		Agregar(a1,v);
		Agregar2(a2,v);
		LeerVenta(v)
	end;
end;
{~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~}
Function TotalA1 (a1:arbol ; code:integer):integer;
begin
	if (a1=nil) then
		TotalA1:=0
	else if (code=a1^.dato.code) then
		TotalA1:=a1^.dato.cant+TotalA1(a1^.HI,code)
		else if (code<a1^.dato.code) then
			TotalA1:=TotalA1(a1^.HI,code)
		else
			TotalA1:=TotalA1(a1^.HD,code)
end;
{~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~}
Function TotalA2 (a2:arbol ; CODE:integer):integer;
begin
	if (a2=nil) then
		TotalA2:=0
	else if (code=a2^.dato.code) then
		TotalA2:=a2^.dato.cant
		else if (code<a2^.dato.code) then
			TotalA2:=TotalA2(a2^.HI,CODE)
			else
				TotalA2:=TotalA2(a2^.HD,CODE);
end;
{~~~~~~~~~~~~~~~~~~~~~~~~~Programa Principal~~~~~~~~~~~~~~~~~~~~~~~~~~~~}
var
	a1,a2:arbol;
	CODE:integer;
begin
	a1:=nil; a2:=nil;
	CrearArboles(a1,a2);
	write('Ingrese un codigo del que pedir las ventas totales: ');
	readln(CODE);
	writeln('La cantidad de ventas del producto con código (TA1) ',CODE,' es de: ',TotalA1(a1,CODE),'.');
	writeln('La cantidad de ventas del producto con código (TA2) ',CODE,' es de: ',TotalA2(a2,CODE),'.');
end.
