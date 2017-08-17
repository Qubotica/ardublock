Qublock
=======

Qublock programador gráfico de qubótica.

* Versiones para [descargas](https://github.com/Qubotica/qublock/releases/)

Desarrolladores
----

Dependencias
---

* maven
* openblocks

~~~
apt-get install maven
./install_openblocks
~~~

Compilar
---

Modificar /src/main/resources/com/ardublock/block/ardublock_def.xml para agregar nuevos bloques

~~~
mvn validate
mvn clean package
mvn compile exec:java -Dexec.mainClass="com.ardublock.Main"
~~~

Limpiar
----

~~~
mvn clean package
~~~

Copiar `target/ardublock-all.jar` a `Arduino/tools/ArduBlockTool/tool`

Autores
----
* David Li taweili@gmail.com
* HE Qichen heqichen@gmail.com
* Ernesto Bazzano

Licensia
----

Copyright (C) 2011 David Li and He Qichen

This file is part of ArduBlock.

ArduBlock is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

ArduBlock is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with ArduBlock.  If not, see <http://www.gnu.org/licenses/>.
