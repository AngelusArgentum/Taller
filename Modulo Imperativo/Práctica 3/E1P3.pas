program E1P3;
Type
	socio=record
		numero:integer;
		nombre:string;
		edad:integer;
	end;
	
	arbol=^nodo;
	nodo=record
		dato:socio;
		HI:arbol;
		HD:arbol;
	end;
{---------------------------------------------------------------}
Procedure LeerSocio (var s:socio);
begin
	write('Ingrese el número de socio: ');readln(s.numero);
	if (s.numero<>0) then begin
	 write('Ingrese el nombre del socio: ');readln(s.nombre);
	 write('Ingrese la edad del socio: ');readln(s.edad);
	end;
end;
{---------------------------------------------------------------}
Procedure Agregar (var a:arbol; s:socio);
begin
	if (a=nil) then begin
		new(a);
		a^.dato:=s;
		a^.HI:=nil;
		a^.HD:=nil;
	end
	else if (s.numero<=a^.dato.numero) then Agregar (a^.HI,s)
		else Agregar (a^.HD,s);
end;
{---------------------------------------------------------------}
Function NroSocioMayor (a:arbol):integer;
begin
	if (a=nil) then 
		writeln('No hay socios cargados para definir el mayor número de socio')
	else if (a^.HD=nil) then begin
		writeln('El mayor número de socio es: ',a^.dato.numero,'.');
		NroSocioMayor:=a^.dato.numero;
		end
		else NroSocioMayor(a^.HD);
end;
{---------------------------------------------------------------}
Procedure InformarSocio (s:socio);
begin
	writeln('Código: ',s.numero,'.');
	writeln('Nombre: ',s.nombre,'.');
	writeln('Edad: ',s.edad,'.');
end;
{---------------------------------------------------------------}
Procedure CodigoSocioMayor (a:arbol;var eMAX:integer; var cMAX:integer);
begin
	if (a<>nil) then begin
		if (a^.dato.edad>eMAX) then begin
			eMAX:=a^.dato.edad;
			cMAX:=a^.dato.numero
		end;
		CodigoSocioMayor(a^.HI,eMAX,cMAX);
		CodigoSocioMayor(a^.HD,eMAX,cMAX);
	end;
end;
{---------------------------------------------------------------}
Procedure DatosNroSocioMenor (a:arbol ; var s:socio);
begin
	if (a=nil) then
		writeln('No hay socios cargados. Imposible retornar datos.')
	else if (a^.HI=nil) then begin
		s:=a^.dato;
		writeln('Los datos del socio con menor codigo son:');
		InformarSocio(s)
		end
		else DatosNroSocioMenor(a^.HI,s);
end;
{---------------------------------------------------------------}
Procedure Sumar1Edad (var a:arbol);
begin
	if(a<>nil) then begin
		a^.dato.edad:=a^.dato.edad+1;
		Sumar1Edad(a^.HI);
		Sumar1Edad(a^.HD);
	end;
end;
{---------------------------------------------------------------}
Procedure InformarArbol (a:arbol);
begin
	if(a<>nil) then begin
		InformarSocio(a^.dato);
		InformarArbol(a^.HI);
		InformarArbol(a^.HD);
	end;
end;
{---------------------------------------------------------------}
Function BuscarCodigo (a:arbol; C:integer):boolean;
begin
	if (a=nil) then begin
		BuscarCodigo:=false;
		writeln('No se encuentra el código o no se cargaron datos.')
	end
	else if (C=a^.dato.numero) then begin
		BuscarCodigo:=true;
		writeln('El código se encuentra cargado.')
	end
	else if (C>a^.dato.numero) then
		BuscarCodigo:=BuscarCodigo(a^.HD,C)
	else
		BuscarCodigo:=BuscarCodigo(a^.HI,C)
end;
{---------------------------------------------------------------}
Function BuscarNombre (a:arbol; name:string):boolean;
begin
	if (a = nil) then
		BuscarNombre:=false
	else BuscarNombre:=(a^.dato.nombre = name)OR BuscarNombre(a^.HI, name)OR BuscarNombre(a^.HD, name);
end;
{---------------------------------------------------------------}
Function ContarNodos (a:arbol):integer;
begin
	if (a=nil) then
		ContarNodos:=0
	else
		ContarNodos:=ContarNodos(a^.HI)+ContarNodos(a^.HD)+1;
end;
{---------------------------------------------------------------}
Function SumarEdades (a:arbol):integer;
begin
	if (a=nil) then
		SumarEdades:=0
	else
		SumarEdades:=SumarEdades(a^.HI) + SumarEdades(a^.HD) + a^.dato.edad;
end; 
{---------------------------------------------------------------}
Procedure InformarCodigoCreciente (a:arbol);
begin
	if (a<>nil) then begin
		InformarCodigoCreciente(a^.HI);
		writeln(a^.dato.numero);
		InformarCodigoCreciente(a^.HD)
	end;
end;

Procedure InformarCodigoDecreciente (a:arbol);
begin
	if (a<>nil) then begin
		InformarCodigoCreciente(a^.HD);
		writeln(a^.dato.numero);
		InformarCodigoCreciente(a^.HI)
	end;
end;
{---------------------Programa Principal------------------------}
var
	a:arbol; s:socio; s1:socio;
	eMAX,cMAX,CODE:integer;
	NAME:string;
	promedio:real;
begin
	eMAX:=0; cMAX:=0;
	a:=nil;
	LeerSocio(s);
	while (s.numero<>0) do begin
		Agregar (a,s);
		LeerSocio(s);
	end;
	{NroSocioMayor(a);
	DatosNroSocioMenor(a,s1);
	CodigoSocioMayor(a,eMAX,cMAX);
	writeln('El codigo de socio con mayor edad es: ',cMAX,'.');
	InformarArbol(a);
	Sumar1Edad(a);
	InformarArbol(a);
	write('Ingrese un código a buscar: ');readln(CODE);
	BuscarCodigo(a,CODE);
	write('Ingrese el nombre a buscar: ');readln(NAME);
	if (BuscarNombre(a,NAME)) then writeln('El nombre está registrado.')
	else writeln('El nombre no se registró o no hay datos.');
	writeln('La cantidad de nodos del árbol es: ',ContarNodos(a),'.');
	writeln('La suma de las edades registradas es de: ',SumarEdades(a),'.');
	writeln('El promedio de edades registradas es igual a ',SumarEdades(a)/ContarNodos(a):0:2,'.');}
	InformarCodigoCreciente(a);
	InformarCodigoDecreciente(a);
end.
