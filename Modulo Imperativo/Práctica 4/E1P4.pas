Program E1P4;
{a. Almacene los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados la cantidad total de
unidades vendidas y el monto total. De cada venta se lee código de venta, código del
producto vendido, cantidad de unidades vendidas y precio unitario. El ingreso de las
ventas finaliza cuando se lee el código de venta -1.

b. Imprima el contenido del árbol ordenado por código de producto.

c. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.

d. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.

e. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir).}

Type
	venta=record
		codeV:integer;
		codeP:integer;
		cant:integer;
		precioU:real;
	end;
	
	totales=record
		unidadesT:integer;
		montosT:real;
	end;
	
	arbol=^nodoA;
	
	nodoA=record
		code:integer;
		dato:totales;
		HI:arbol;
		HD:arbol;
	end;
{------------------------------------------------------------}
Procedure LeerVenta (var v:venta);
begin
	write('Ingrese codigo de venta: ');readln(v.codeV);
	if (v.codeV>-1) then begin
		write('Ingrese codigo de producto: ');readln(v.codeP);
		write('Ingrese cantidad vendida: ');readln(v.cant);
		write('Ingrese precio por unidad: ');readln(v.precioU);
	end;
end;
{------------------------------------------------------------}
Procedure AgregarAcumulando (var a:arbol; v:venta);
begin
	if (a=nil) then begin
		new(a);
		a^.dato.unidadesT:=v.cant;
		a^.dato.montosT:=v.cant*v.precioU;
		a^.code:=v.codeP;
		a^.HI:=nil;
		a^.HD:=nil
	end
	else if (a^.code=v.codeP) then begin
		a^.dato.unidadesT:=a^.dato.unidadesT+v.cant;
		a^.dato.montosT:=a^.dato.montosT+v.cant*v.precioU
	end
	else if (v.codeP<a^.code) then
		AgregarAcumulando(a^.HI,v)
	else
		AgregarAcumulando(a^.HD,v)
end;
{------------------------------------------------------------}
Procedure CrearArbol(var a:arbol);
var
	v:venta;
begin
	LeerVenta(v);
	while (v.codeV<>-1) do begin
		AgregarAcumulando(a,v);
		LeerVenta(v)
	end;
end;
{------------------------------------------------------------}
Procedure ImprimirArbol (a:arbol);
begin
	if (a<>nil) then begin
		ImprimirArbol(a^.HI);
		writeln('-------------------------');
		writeln('El monto recaudado del producto con codigo ',a^.code,' es de: $',a^.dato.montosT:0:2,'.');
		writeln('La cantidad de unidades vendidas del mismo es de: ',a^.dato.unidadesT,'.');
		writeln('-------------------------');
		ImprimirArbol(a^.HD)
	end;
end;
{------------------------------------------------------------}
Function CODEMasVendido(a:arbol):integer;
	Procedure BuscarMasVendido (a:arbol ; var uTOP:integer; var cTOP:integer);
	begin
		if (a<>nil) then begin
			BuscarMasVendido(a^.HI,uTOP,cTOP);
			if (a^.dato.unidadesT>uTOP) then begin
				uTOP:=a^.dato.unidadesT;
				cTOP:=a^.code
			end;
			BuscarMasVendido(a^.HD,uTOP,cTOP)
		end;
	end;
var
	uTOP,cTOP:integer;
begin
	uTOP:=0;
	cTOP:=0;
	BuscarMasVendido(a,uTOP,cTOP);
	if (uTOP<>0) then begin
		writeln('El codigo del producto más vendido es: ',cTOP,'.');
		CODEMasVendido:=cTOP
	end
	else
		writeln('No hay productos.');
end;
{------------------------------------------------------------}
Function CODEMenoresQUEx (a:arbol):integer;
	Procedure ContarMenoresQUEx (a:arbol ; var contador:integer; var x:integer);
	begin
		if (a<>nil) then begin
			if (x<a^.code) then
				contador:=contador+1;
			ContarMenoresQUEx(a^.HI,contador,x);
			ContarMenoresQUEx(a^.HD,contador,x)
		end;
	end;
var
	contador,x:integer;
begin
	contador:=0;
	write('Ingrese un código del cual determinar cuántos son menores que él: ');readln(x);
	ContarMenoresQUEx(a,contador,x);
	if (contador<>0) then begin
		writeln('La cantidad de códigos que cumplen la condición es de: ',contador,'.');
		CODEMenoresQUEx:=contador
	end
	else
		writeln('No hay códigos cumpliendo la condición, o no se cargaron datos.');
end;
{------------------------------------------------------------}
Function MontoEntreXeY(a:arbol):real;
	Procedure ArreglarMenorMayor(var x:integer ; var y:integer);
	var
		AUX:integer;
	begin
		AUX:=y;
		y:=x;
		x:=AUX;
	end;
	{------------------------------------------------------------}
	Function InformarMontosEnRango (a:arbol; menor:integer; mayor:integer):real;
	begin
		if (a=nil) then
			InformarMontosEnRango:=0
		else if (menor<a^.code) AND (mayor>a^.code) then
			InformarMontosEnRango:=a^.dato.montosT +
			InformarMontosEnRango(a^.HI,menor,mayor) +
			InformarMontosEnRango(a^.HD,menor,mayor)
		else if (menor>a^.code) then
			InformarMontosEnRango:=InformarMontosEnRango(a^.HD,menor,mayor)
		else if (mayor<a^.code) then
			InformarMontosEnRango:=InformarMontosEnRango(a^.HI,menor,mayor);
	end;
var
	mayor,menor:integer;
	AUX:real;
begin
	write('Ingrese el valor limite menor: ');readln(menor);
	write('Ingrese el valor limite mayor: ');readln(mayor);
	if (menor>mayor) then begin
		writeln('AVISO: Los valores se ingresaron al revés. Se corregirá su orden automáticamente.');
		ArreglarMenorMayor(menor,mayor)
	end;
	AUX:=InformarMontosEnRango(a,menor,mayor);
	if (AUX<>0) then begin
		writeln('El monto total recaudado dentro del rango dado es de: $',AUX:0:2,'.');
		MontoEntreXeY:=AUX
	end
	else
		writeln('No hay códigos en el rango, o no se cargaron datos.');
end;
		
	
{------------------------------------------------------------}
var
	a:arbol;
begin
	a:=nil; //INICIALIZA ARBOLES Y LISTAS
	CrearArbol(a);
	ImprimirArbol(a);
	CODEMasVendido(a);
	{CODEMenoresQUEx(a);}
	MontoEntreXeY(a);
end.

function DNI (a: arbol; dni1: integer): integer;
begin
	if (a = nil) then 
		DNI:= 0 //si llegue a nil, entonces la funcion devuelve 0;
	else begin
			if (a^.dni < dni1) then
			DNI= DNI (a^.HD, dni1) +DNI (a^.HI, dni1)+1;
			else
				  DNI:= DNI (a^.HI, dni1) //si el dato que estoy leyendo es mayor al dato, me voy a la izquierda
	End;
