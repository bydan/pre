/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.cartera.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.util.RutaConstantesFunciones;
import com.bydan.erp.cartera.util.RutaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RutaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RutaConstantesFunciones extends RutaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Ruta";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Ruta"+RutaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RutaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RutaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RutaConstantesFunciones.SCHEMA+"_"+RutaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RutaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RutaConstantesFunciones.SCHEMA+"_"+RutaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RutaConstantesFunciones.SCHEMA+"_"+RutaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RutaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RutaConstantesFunciones.SCHEMA+"_"+RutaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RutaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RutaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RutaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RutaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RutaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RutaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rutas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Ruta";
	public static final String SCLASSWEBTITULO_LOWER="Ruta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Ruta";
	public static final String OBJECTNAME="ruta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="ruta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ruta from "+RutaConstantesFunciones.SPERSISTENCENAME+" ruta";
	public static String QUERYSELECTNATIVE="select "+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".id,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".version_row,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".id_empresa,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".id_pais,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".id_ciudad,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".id_sector_origen,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".id_sector_destino,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".nombre,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".origen,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".destino,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".precio,"+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME+".direccion from "+RutaConstantesFunciones.SCHEMA+"."+RutaConstantesFunciones.TABLENAME;//+" as "+RutaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RutaConstantesFuncionesAdditional rutaConstantesFuncionesAdditional=null;
	
	public RutaConstantesFuncionesAdditional getRutaConstantesFuncionesAdditional() {
		return this.rutaConstantesFuncionesAdditional;
	}
	
	public void setRutaConstantesFuncionesAdditional(RutaConstantesFuncionesAdditional rutaConstantesFuncionesAdditional) {
		try {
			this.rutaConstantesFuncionesAdditional=rutaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDSECTORORIGEN= "id_sector_origen";
    public static final String IDSECTORDESTINO= "id_sector_destino";
    public static final String NOMBRE= "nombre";
    public static final String ORIGEN= "origen";
    public static final String DESTINO= "destino";
    public static final String PRECIO= "precio";
    public static final String DIRECCION= "direccion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDSECTORORIGEN= "Sector Origen";
		public static final String LABEL_IDSECTORORIGEN_LOWER= "Sector Origen";
    	public static final String LABEL_IDSECTORDESTINO= "Sector Destino";
		public static final String LABEL_IDSECTORDESTINO_LOWER= "Sector Destino";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ORIGEN= "Origen";
		public static final String LABEL_ORIGEN_LOWER= "Origen";
    	public static final String LABEL_DESTINO= "Destino";
		public static final String LABEL_DESTINO_LOWER= "Destino";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getRutaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RutaConstantesFunciones.IDEMPRESA)) {sLabelColumna=RutaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RutaConstantesFunciones.IDPAIS)) {sLabelColumna=RutaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(RutaConstantesFunciones.IDCIUDAD)) {sLabelColumna=RutaConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(RutaConstantesFunciones.IDSECTORORIGEN)) {sLabelColumna=RutaConstantesFunciones.LABEL_IDSECTORORIGEN;}
		if(sNombreColumna.equals(RutaConstantesFunciones.IDSECTORDESTINO)) {sLabelColumna=RutaConstantesFunciones.LABEL_IDSECTORDESTINO;}
		if(sNombreColumna.equals(RutaConstantesFunciones.NOMBRE)) {sLabelColumna=RutaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(RutaConstantesFunciones.ORIGEN)) {sLabelColumna=RutaConstantesFunciones.LABEL_ORIGEN;}
		if(sNombreColumna.equals(RutaConstantesFunciones.DESTINO)) {sLabelColumna=RutaConstantesFunciones.LABEL_DESTINO;}
		if(sNombreColumna.equals(RutaConstantesFunciones.PRECIO)) {sLabelColumna=RutaConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(RutaConstantesFunciones.DIRECCION)) {sLabelColumna=RutaConstantesFunciones.LABEL_DIRECCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRutaDescripcion(Ruta ruta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ruta !=null/* && ruta.getId()!=0*/) {
			sDescripcion=ruta.getnombre();//rutaruta.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRutaDescripcionDetallado(Ruta ruta) {
		String sDescripcion="";
			
		sDescripcion+=RutaConstantesFunciones.ID+"=";
		sDescripcion+=ruta.getId().toString()+",";
		sDescripcion+=RutaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ruta.getVersionRow().toString()+",";
		sDescripcion+=RutaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ruta.getid_empresa().toString()+",";
		sDescripcion+=RutaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=ruta.getid_pais().toString()+",";
		sDescripcion+=RutaConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=ruta.getid_ciudad().toString()+",";
		sDescripcion+=RutaConstantesFunciones.IDSECTORORIGEN+"=";
		sDescripcion+=ruta.getid_sector_origen().toString()+",";
		sDescripcion+=RutaConstantesFunciones.IDSECTORDESTINO+"=";
		sDescripcion+=ruta.getid_sector_destino().toString()+",";
		sDescripcion+=RutaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=ruta.getnombre()+",";
		sDescripcion+=RutaConstantesFunciones.ORIGEN+"=";
		sDescripcion+=ruta.getorigen()+",";
		sDescripcion+=RutaConstantesFunciones.DESTINO+"=";
		sDescripcion+=ruta.getdestino()+",";
		sDescripcion+=RutaConstantesFunciones.PRECIO+"=";
		sDescripcion+=ruta.getprecio().toString()+",";
		sDescripcion+=RutaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=ruta.getdireccion()+",";
			
		return sDescripcion;
	}
	
	public static void setRutaDescripcion(Ruta ruta,String sValor) throws Exception {			
		if(ruta !=null) {
			ruta.setnombre(sValor);;//rutaruta.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getSectorOrigenDescripcion(Sector sector) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sector!=null/*&&sector.getId()>0*/) {
			sDescripcion=SectorConstantesFunciones.getSectorDescripcion(sector);
		}

		return sDescripcion;
	}

	public static String getSectorDestinoDescripcion(Sector sector) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sector!=null/*&&sector.getId()>0*/) {
			sDescripcion=SectorConstantesFunciones.getSectorDescripcion(sector);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorDestino")) {
			sNombreIndice="Tipo=  Por Destino";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorOrigen")) {
			sNombreIndice="Tipo=  Por Origen";
		} else if(sNombreIndice.equals("BusquedaPorPrecio")) {
			sNombreIndice="Tipo=  Por Precio";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdSectorDestino")) {
			sNombreIndice="Tipo=  Por Sector Destino";
		} else if(sNombreIndice.equals("FK_IdSectorOrigen")) {
			sNombreIndice="Tipo=  Por Sector Origen";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorDestino(String destino) {
		String sDetalleIndice=" Parametros->";
		if(destino!=null) {sDetalleIndice+=" Destino="+destino;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorOrigen(String origen) {
		String sDetalleIndice=" Parametros->";
		if(origen!=null) {sDetalleIndice+=" Origen="+origen;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorPrecio(Double precio) {
		String sDetalleIndice=" Parametros->";
		if(precio!=null) {sDetalleIndice+=" Precio="+precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSectorDestino(Long id_sector_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_sector_destino!=null) {sDetalleIndice+=" Codigo Unico De Sector Destino="+id_sector_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSectorOrigen(Long id_sector_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_sector_origen!=null) {sDetalleIndice+=" Codigo Unico De Sector Origen="+id_sector_origen.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRuta(Ruta ruta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ruta.setnombre(ruta.getnombre().trim());
		ruta.setorigen(ruta.getorigen().trim());
		ruta.setdestino(ruta.getdestino().trim());
		ruta.setdireccion(ruta.getdireccion().trim());
	}
	
	public static void quitarEspaciosRutas(List<Ruta> rutas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Ruta ruta: rutas) {
			ruta.setnombre(ruta.getnombre().trim());
			ruta.setorigen(ruta.getorigen().trim());
			ruta.setdestino(ruta.getdestino().trim());
			ruta.setdireccion(ruta.getdireccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRuta(Ruta ruta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ruta.getConCambioAuxiliar()) {
			ruta.setIsDeleted(ruta.getIsDeletedAuxiliar());	
			ruta.setIsNew(ruta.getIsNewAuxiliar());	
			ruta.setIsChanged(ruta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ruta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ruta.setIsDeletedAuxiliar(false);	
			ruta.setIsNewAuxiliar(false);	
			ruta.setIsChangedAuxiliar(false);
			
			ruta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRutas(List<Ruta> rutas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Ruta ruta : rutas) {
			if(conAsignarBase && ruta.getConCambioAuxiliar()) {
				ruta.setIsDeleted(ruta.getIsDeletedAuxiliar());	
				ruta.setIsNew(ruta.getIsNewAuxiliar());	
				ruta.setIsChanged(ruta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ruta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ruta.setIsDeletedAuxiliar(false);	
				ruta.setIsNewAuxiliar(false);	
				ruta.setIsChangedAuxiliar(false);
				
				ruta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRuta(Ruta ruta,Boolean conEnteros) throws Exception  {
		ruta.setprecio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRutas(List<Ruta> rutas,Boolean conEnteros) throws Exception  {
		
		for(Ruta ruta: rutas) {
			ruta.setprecio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRuta(List<Ruta> rutas,Ruta rutaAux) throws Exception  {
		RutaConstantesFunciones.InicializarValoresRuta(rutaAux,true);
		
		for(Ruta ruta: rutas) {
			if(ruta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			rutaAux.setprecio(rutaAux.getprecio()+ruta.getprecio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRuta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RutaConstantesFunciones.getArrayColumnasGlobalesRuta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRuta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RutaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RutaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRuta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Ruta> rutas,Ruta ruta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Ruta rutaAux: rutas) {
			if(rutaAux!=null && ruta!=null) {
				if((rutaAux.getId()==null && ruta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rutaAux.getId()!=null && ruta.getId()!=null){
					if(rutaAux.getId().equals(ruta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRuta(List<Ruta> rutas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(Ruta ruta: rutas) {			
			if(ruta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=ruta.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RutaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(RutaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRuta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_ID, RutaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_VERSIONROW, RutaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_IDEMPRESA, RutaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_IDPAIS, RutaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_IDCIUDAD, RutaConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_IDSECTORORIGEN, RutaConstantesFunciones.IDSECTORORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_IDSECTORDESTINO, RutaConstantesFunciones.IDSECTORDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_NOMBRE, RutaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_ORIGEN, RutaConstantesFunciones.ORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_DESTINO, RutaConstantesFunciones.DESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_PRECIO, RutaConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaConstantesFunciones.LABEL_DIRECCION, RutaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRuta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.IDSECTORORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.IDSECTORDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.ORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.DESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRuta() throws Exception  {
		return RutaConstantesFunciones.getTiposSeleccionarRuta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRuta(Boolean conFk) throws Exception  {
		return RutaConstantesFunciones.getTiposSeleccionarRuta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRuta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_IDSECTORORIGEN);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_IDSECTORORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_IDSECTORDESTINO);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_IDSECTORDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_ORIGEN);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_ORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_DESTINO);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_DESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(RutaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRuta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRuta(Ruta rutaAux) throws Exception {
		
			rutaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rutaAux.getEmpresa()));
			rutaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(rutaAux.getPais()));
			rutaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(rutaAux.getCiudad()));
			rutaAux.setsectororigen_descripcion(SectorConstantesFunciones.getSectorDescripcion(rutaAux.getSectorOrigen()));
			rutaAux.setsectordestino_descripcion(SectorConstantesFunciones.getSectorDescripcion(rutaAux.getSectorDestino()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRuta(List<Ruta> rutasTemp) throws Exception {
		for(Ruta rutaAux:rutasTemp) {
			
			rutaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rutaAux.getEmpresa()));
			rutaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(rutaAux.getPais()));
			rutaAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(rutaAux.getCiudad()));
			rutaAux.setsectororigen_descripcion(SectorConstantesFunciones.getSectorDescripcion(rutaAux.getSectorOrigen()));
			rutaAux.setsectordestino_descripcion(SectorConstantesFunciones.getSectorDescripcion(rutaAux.getSectorDestino()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRuta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Sector.class));
				classes.add(new Classe(Sector.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sector.class)) {
						classes.add(new Classe(Sector.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sector.class)) {
						classes.add(new Classe(Sector.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRuta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Sector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sector.class)); continue;
					}

					if(Sector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sector.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Sector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sector.class)); continue;
					}

					if(Sector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sector.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRuta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RutaConstantesFunciones.getClassesRelationshipsOfRuta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRuta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRuta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RutaConstantesFunciones.getClassesRelationshipsFromStringsOfRuta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRuta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Ruta ruta,List<Ruta> rutas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Ruta rutaEncontrado=null;
			
			for(Ruta rutaLocal:rutas) {
				if(rutaLocal.getId().equals(ruta.getId())) {
					rutaEncontrado=rutaLocal;
					
					rutaLocal.setIsChanged(ruta.getIsChanged());
					rutaLocal.setIsNew(ruta.getIsNew());
					rutaLocal.setIsDeleted(ruta.getIsDeleted());
					
					rutaLocal.setGeneralEntityOriginal(ruta.getGeneralEntityOriginal());
					
					rutaLocal.setId(ruta.getId());	
					rutaLocal.setVersionRow(ruta.getVersionRow());	
					rutaLocal.setid_empresa(ruta.getid_empresa());	
					rutaLocal.setid_pais(ruta.getid_pais());	
					rutaLocal.setid_ciudad(ruta.getid_ciudad());	
					rutaLocal.setid_sector_origen(ruta.getid_sector_origen());	
					rutaLocal.setid_sector_destino(ruta.getid_sector_destino());	
					rutaLocal.setnombre(ruta.getnombre());	
					rutaLocal.setorigen(ruta.getorigen());	
					rutaLocal.setdestino(ruta.getdestino());	
					rutaLocal.setprecio(ruta.getprecio());	
					rutaLocal.setdireccion(ruta.getdireccion());	
					
					
					rutaLocal.setClientes(ruta.getClientes());
					rutaLocal.setParametroCarteraDefectos(ruta.getParametroCarteraDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!ruta.getIsDeleted()) {
				if(!existe) {
					rutas.add(ruta);
				}
			} else {
				if(rutaEncontrado!=null && permiteQuitar)  {
					rutas.remove(rutaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Ruta ruta,List<Ruta> rutas) throws Exception {
		try	{			
			for(Ruta rutaLocal:rutas) {
				if(rutaLocal.getId().equals(ruta.getId())) {
					rutaLocal.setIsSelected(ruta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRuta(List<Ruta> rutasAux) throws Exception {
		//this.rutasAux=rutasAux;
		
		for(Ruta rutaAux:rutasAux) {
			if(rutaAux.getIsChanged()) {
				rutaAux.setIsChanged(false);
			}		
			
			if(rutaAux.getIsNew()) {
				rutaAux.setIsNew(false);
			}	
			
			if(rutaAux.getIsDeleted()) {
				rutaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRuta(Ruta rutaAux) throws Exception {
		//this.rutaAux=rutaAux;
		
			if(rutaAux.getIsChanged()) {
				rutaAux.setIsChanged(false);
			}		
			
			if(rutaAux.getIsNew()) {
				rutaAux.setIsNew(false);
			}	
			
			if(rutaAux.getIsDeleted()) {
				rutaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Ruta rutaAsignar,Ruta ruta) throws Exception {
		rutaAsignar.setId(ruta.getId());	
		rutaAsignar.setVersionRow(ruta.getVersionRow());	
		rutaAsignar.setid_empresa(ruta.getid_empresa());
		rutaAsignar.setempresa_descripcion(ruta.getempresa_descripcion());	
		rutaAsignar.setid_pais(ruta.getid_pais());
		rutaAsignar.setpais_descripcion(ruta.getpais_descripcion());	
		rutaAsignar.setid_ciudad(ruta.getid_ciudad());
		rutaAsignar.setciudad_descripcion(ruta.getciudad_descripcion());	
		rutaAsignar.setid_sector_origen(ruta.getid_sector_origen());
		rutaAsignar.setsectororigen_descripcion(ruta.getsectororigen_descripcion());	
		rutaAsignar.setid_sector_destino(ruta.getid_sector_destino());
		rutaAsignar.setsectordestino_descripcion(ruta.getsectordestino_descripcion());	
		rutaAsignar.setnombre(ruta.getnombre());	
		rutaAsignar.setorigen(ruta.getorigen());	
		rutaAsignar.setdestino(ruta.getdestino());	
		rutaAsignar.setprecio(ruta.getprecio());	
		rutaAsignar.setdireccion(ruta.getdireccion());	
	}
	
	public static void inicializarRuta(Ruta ruta) throws Exception {
		try {
				ruta.setId(0L);	
					
				ruta.setid_empresa(-1L);	
				ruta.setid_pais(-1L);	
				ruta.setid_ciudad(-1L);	
				ruta.setid_sector_origen(-1L);	
				ruta.setid_sector_destino(-1L);	
				ruta.setnombre("");	
				ruta.setorigen("");	
				ruta.setdestino("");	
				ruta.setprecio(0.0);	
				ruta.setdireccion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRuta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_IDSECTORORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_IDSECTORDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_ORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_DESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRuta(String sTipo,Row row,Workbook workbook,Ruta ruta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getsectororigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getsectordestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getorigen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getdestino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ruta.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRuta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRuta() {
		return this.sFinalQueryRuta;
	}
	
	public void setsFinalQueryRuta(String sFinalQueryRuta) {
		this.sFinalQueryRuta= sFinalQueryRuta;
	}
	
	public Border resaltarSeleccionarRuta=null;
	
	public Border setResaltarSeleccionarRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRuta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRuta() {
		return this.resaltarSeleccionarRuta;
	}
	
	public void setResaltarSeleccionarRuta(Border borderResaltarSeleccionarRuta) {
		this.resaltarSeleccionarRuta= borderResaltarSeleccionarRuta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRuta=null;
	public Boolean mostraridRuta=true;
	public Boolean activaridRuta=true;

	public Border resaltarid_empresaRuta=null;
	public Boolean mostrarid_empresaRuta=true;
	public Boolean activarid_empresaRuta=true;
	public Boolean cargarid_empresaRuta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRuta=false;//ConEventDepend=true

	public Border resaltarid_paisRuta=null;
	public Boolean mostrarid_paisRuta=true;
	public Boolean activarid_paisRuta=true;
	public Boolean cargarid_paisRuta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisRuta=false;//ConEventDepend=true

	public Border resaltarid_ciudadRuta=null;
	public Boolean mostrarid_ciudadRuta=true;
	public Boolean activarid_ciudadRuta=true;
	public Boolean cargarid_ciudadRuta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadRuta=true;//ConEventDepend=true

	public Border resaltarid_sector_origenRuta=null;
	public Boolean mostrarid_sector_origenRuta=true;
	public Boolean activarid_sector_origenRuta=true;
	public Boolean cargarid_sector_origenRuta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sector_origenRuta=false;//ConEventDepend=true

	public Border resaltarid_sector_destinoRuta=null;
	public Boolean mostrarid_sector_destinoRuta=true;
	public Boolean activarid_sector_destinoRuta=true;
	public Boolean cargarid_sector_destinoRuta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sector_destinoRuta=false;//ConEventDepend=true

	public Border resaltarnombreRuta=null;
	public Boolean mostrarnombreRuta=true;
	public Boolean activarnombreRuta=true;

	public Border resaltarorigenRuta=null;
	public Boolean mostrarorigenRuta=true;
	public Boolean activarorigenRuta=true;

	public Border resaltardestinoRuta=null;
	public Boolean mostrardestinoRuta=true;
	public Boolean activardestinoRuta=true;

	public Border resaltarprecioRuta=null;
	public Boolean mostrarprecioRuta=true;
	public Boolean activarprecioRuta=true;

	public Border resaltardireccionRuta=null;
	public Boolean mostrardireccionRuta=true;
	public Boolean activardireccionRuta=true;

	
	

	public Border setResaltaridRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltaridRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRuta() {
		return this.resaltaridRuta;
	}

	public void setResaltaridRuta(Border borderResaltar) {
		this.resaltaridRuta= borderResaltar;
	}

	public Boolean getMostraridRuta() {
		return this.mostraridRuta;
	}

	public void setMostraridRuta(Boolean mostraridRuta) {
		this.mostraridRuta= mostraridRuta;
	}

	public Boolean getActivaridRuta() {
		return this.activaridRuta;
	}

	public void setActivaridRuta(Boolean activaridRuta) {
		this.activaridRuta= activaridRuta;
	}

	public Border setResaltarid_empresaRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarid_empresaRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRuta() {
		return this.resaltarid_empresaRuta;
	}

	public void setResaltarid_empresaRuta(Border borderResaltar) {
		this.resaltarid_empresaRuta= borderResaltar;
	}

	public Boolean getMostrarid_empresaRuta() {
		return this.mostrarid_empresaRuta;
	}

	public void setMostrarid_empresaRuta(Boolean mostrarid_empresaRuta) {
		this.mostrarid_empresaRuta= mostrarid_empresaRuta;
	}

	public Boolean getActivarid_empresaRuta() {
		return this.activarid_empresaRuta;
	}

	public void setActivarid_empresaRuta(Boolean activarid_empresaRuta) {
		this.activarid_empresaRuta= activarid_empresaRuta;
	}

	public Boolean getCargarid_empresaRuta() {
		return this.cargarid_empresaRuta;
	}

	public void setCargarid_empresaRuta(Boolean cargarid_empresaRuta) {
		this.cargarid_empresaRuta= cargarid_empresaRuta;
	}

	public Border setResaltarid_paisRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarid_paisRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisRuta() {
		return this.resaltarid_paisRuta;
	}

	public void setResaltarid_paisRuta(Border borderResaltar) {
		this.resaltarid_paisRuta= borderResaltar;
	}

	public Boolean getMostrarid_paisRuta() {
		return this.mostrarid_paisRuta;
	}

	public void setMostrarid_paisRuta(Boolean mostrarid_paisRuta) {
		this.mostrarid_paisRuta= mostrarid_paisRuta;
	}

	public Boolean getActivarid_paisRuta() {
		return this.activarid_paisRuta;
	}

	public void setActivarid_paisRuta(Boolean activarid_paisRuta) {
		this.activarid_paisRuta= activarid_paisRuta;
	}

	public Boolean getCargarid_paisRuta() {
		return this.cargarid_paisRuta;
	}

	public void setCargarid_paisRuta(Boolean cargarid_paisRuta) {
		this.cargarid_paisRuta= cargarid_paisRuta;
	}

	public Border setResaltarid_ciudadRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarid_ciudadRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadRuta() {
		return this.resaltarid_ciudadRuta;
	}

	public void setResaltarid_ciudadRuta(Border borderResaltar) {
		this.resaltarid_ciudadRuta= borderResaltar;
	}

	public Boolean getMostrarid_ciudadRuta() {
		return this.mostrarid_ciudadRuta;
	}

	public void setMostrarid_ciudadRuta(Boolean mostrarid_ciudadRuta) {
		this.mostrarid_ciudadRuta= mostrarid_ciudadRuta;
	}

	public Boolean getActivarid_ciudadRuta() {
		return this.activarid_ciudadRuta;
	}

	public void setActivarid_ciudadRuta(Boolean activarid_ciudadRuta) {
		this.activarid_ciudadRuta= activarid_ciudadRuta;
	}

	public Boolean getCargarid_ciudadRuta() {
		return this.cargarid_ciudadRuta;
	}

	public void setCargarid_ciudadRuta(Boolean cargarid_ciudadRuta) {
		this.cargarid_ciudadRuta= cargarid_ciudadRuta;
	}

	public Border setResaltarid_sector_origenRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarid_sector_origenRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sector_origenRuta() {
		return this.resaltarid_sector_origenRuta;
	}

	public void setResaltarid_sector_origenRuta(Border borderResaltar) {
		this.resaltarid_sector_origenRuta= borderResaltar;
	}

	public Boolean getMostrarid_sector_origenRuta() {
		return this.mostrarid_sector_origenRuta;
	}

	public void setMostrarid_sector_origenRuta(Boolean mostrarid_sector_origenRuta) {
		this.mostrarid_sector_origenRuta= mostrarid_sector_origenRuta;
	}

	public Boolean getActivarid_sector_origenRuta() {
		return this.activarid_sector_origenRuta;
	}

	public void setActivarid_sector_origenRuta(Boolean activarid_sector_origenRuta) {
		this.activarid_sector_origenRuta= activarid_sector_origenRuta;
	}

	public Boolean getCargarid_sector_origenRuta() {
		return this.cargarid_sector_origenRuta;
	}

	public void setCargarid_sector_origenRuta(Boolean cargarid_sector_origenRuta) {
		this.cargarid_sector_origenRuta= cargarid_sector_origenRuta;
	}

	public Border setResaltarid_sector_destinoRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarid_sector_destinoRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sector_destinoRuta() {
		return this.resaltarid_sector_destinoRuta;
	}

	public void setResaltarid_sector_destinoRuta(Border borderResaltar) {
		this.resaltarid_sector_destinoRuta= borderResaltar;
	}

	public Boolean getMostrarid_sector_destinoRuta() {
		return this.mostrarid_sector_destinoRuta;
	}

	public void setMostrarid_sector_destinoRuta(Boolean mostrarid_sector_destinoRuta) {
		this.mostrarid_sector_destinoRuta= mostrarid_sector_destinoRuta;
	}

	public Boolean getActivarid_sector_destinoRuta() {
		return this.activarid_sector_destinoRuta;
	}

	public void setActivarid_sector_destinoRuta(Boolean activarid_sector_destinoRuta) {
		this.activarid_sector_destinoRuta= activarid_sector_destinoRuta;
	}

	public Boolean getCargarid_sector_destinoRuta() {
		return this.cargarid_sector_destinoRuta;
	}

	public void setCargarid_sector_destinoRuta(Boolean cargarid_sector_destinoRuta) {
		this.cargarid_sector_destinoRuta= cargarid_sector_destinoRuta;
	}

	public Border setResaltarnombreRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarnombreRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreRuta() {
		return this.resaltarnombreRuta;
	}

	public void setResaltarnombreRuta(Border borderResaltar) {
		this.resaltarnombreRuta= borderResaltar;
	}

	public Boolean getMostrarnombreRuta() {
		return this.mostrarnombreRuta;
	}

	public void setMostrarnombreRuta(Boolean mostrarnombreRuta) {
		this.mostrarnombreRuta= mostrarnombreRuta;
	}

	public Boolean getActivarnombreRuta() {
		return this.activarnombreRuta;
	}

	public void setActivarnombreRuta(Boolean activarnombreRuta) {
		this.activarnombreRuta= activarnombreRuta;
	}

	public Border setResaltarorigenRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarorigenRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorigenRuta() {
		return this.resaltarorigenRuta;
	}

	public void setResaltarorigenRuta(Border borderResaltar) {
		this.resaltarorigenRuta= borderResaltar;
	}

	public Boolean getMostrarorigenRuta() {
		return this.mostrarorigenRuta;
	}

	public void setMostrarorigenRuta(Boolean mostrarorigenRuta) {
		this.mostrarorigenRuta= mostrarorigenRuta;
	}

	public Boolean getActivarorigenRuta() {
		return this.activarorigenRuta;
	}

	public void setActivarorigenRuta(Boolean activarorigenRuta) {
		this.activarorigenRuta= activarorigenRuta;
	}

	public Border setResaltardestinoRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltardestinoRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardestinoRuta() {
		return this.resaltardestinoRuta;
	}

	public void setResaltardestinoRuta(Border borderResaltar) {
		this.resaltardestinoRuta= borderResaltar;
	}

	public Boolean getMostrardestinoRuta() {
		return this.mostrardestinoRuta;
	}

	public void setMostrardestinoRuta(Boolean mostrardestinoRuta) {
		this.mostrardestinoRuta= mostrardestinoRuta;
	}

	public Boolean getActivardestinoRuta() {
		return this.activardestinoRuta;
	}

	public void setActivardestinoRuta(Boolean activardestinoRuta) {
		this.activardestinoRuta= activardestinoRuta;
	}

	public Border setResaltarprecioRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltarprecioRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioRuta() {
		return this.resaltarprecioRuta;
	}

	public void setResaltarprecioRuta(Border borderResaltar) {
		this.resaltarprecioRuta= borderResaltar;
	}

	public Boolean getMostrarprecioRuta() {
		return this.mostrarprecioRuta;
	}

	public void setMostrarprecioRuta(Boolean mostrarprecioRuta) {
		this.mostrarprecioRuta= mostrarprecioRuta;
	}

	public Boolean getActivarprecioRuta() {
		return this.activarprecioRuta;
	}

	public void setActivarprecioRuta(Boolean activarprecioRuta) {
		this.activarprecioRuta= activarprecioRuta;
	}

	public Border setResaltardireccionRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltar);
		
		this.resaltardireccionRuta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionRuta() {
		return this.resaltardireccionRuta;
	}

	public void setResaltardireccionRuta(Border borderResaltar) {
		this.resaltardireccionRuta= borderResaltar;
	}

	public Boolean getMostrardireccionRuta() {
		return this.mostrardireccionRuta;
	}

	public void setMostrardireccionRuta(Boolean mostrardireccionRuta) {
		this.mostrardireccionRuta= mostrardireccionRuta;
	}

	public Boolean getActivardireccionRuta() {
		return this.activardireccionRuta;
	}

	public void setActivardireccionRuta(Boolean activardireccionRuta) {
		this.activardireccionRuta= activardireccionRuta;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridRuta(esInicial);
		this.setMostrarid_empresaRuta(esInicial);
		this.setMostrarid_paisRuta(esInicial);
		this.setMostrarid_ciudadRuta(esInicial);
		this.setMostrarid_sector_origenRuta(esInicial);
		this.setMostrarid_sector_destinoRuta(esInicial);
		this.setMostrarnombreRuta(esInicial);
		this.setMostrarorigenRuta(esInicial);
		this.setMostrardestinoRuta(esInicial);
		this.setMostrarprecioRuta(esInicial);
		this.setMostrardireccionRuta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RutaConstantesFunciones.ID)) {
				this.setMostraridRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDSECTORORIGEN)) {
				this.setMostrarid_sector_origenRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDSECTORDESTINO)) {
				this.setMostrarid_sector_destinoRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.ORIGEN)) {
				this.setMostrarorigenRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.DESTINO)) {
				this.setMostrardestinoRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.PRECIO)) {
				this.setMostrarprecioRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionRuta(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridRuta(esInicial);
		this.setActivarid_empresaRuta(esInicial);
		this.setActivarid_paisRuta(esInicial);
		this.setActivarid_ciudadRuta(esInicial);
		this.setActivarid_sector_origenRuta(esInicial);
		this.setActivarid_sector_destinoRuta(esInicial);
		this.setActivarnombreRuta(esInicial);
		this.setActivarorigenRuta(esInicial);
		this.setActivardestinoRuta(esInicial);
		this.setActivarprecioRuta(esInicial);
		this.setActivardireccionRuta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RutaConstantesFunciones.ID)) {
				this.setActivaridRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDSECTORORIGEN)) {
				this.setActivarid_sector_origenRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDSECTORDESTINO)) {
				this.setActivarid_sector_destinoRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.ORIGEN)) {
				this.setActivarorigenRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.DESTINO)) {
				this.setActivardestinoRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.PRECIO)) {
				this.setActivarprecioRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionRuta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRuta(esInicial);
		this.setResaltarid_empresaRuta(esInicial);
		this.setResaltarid_paisRuta(esInicial);
		this.setResaltarid_ciudadRuta(esInicial);
		this.setResaltarid_sector_origenRuta(esInicial);
		this.setResaltarid_sector_destinoRuta(esInicial);
		this.setResaltarnombreRuta(esInicial);
		this.setResaltarorigenRuta(esInicial);
		this.setResaltardestinoRuta(esInicial);
		this.setResaltarprecioRuta(esInicial);
		this.setResaltardireccionRuta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RutaConstantesFunciones.ID)) {
				this.setResaltaridRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDSECTORORIGEN)) {
				this.setResaltarid_sector_origenRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.IDSECTORDESTINO)) {
				this.setResaltarid_sector_destinoRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.ORIGEN)) {
				this.setResaltarorigenRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.DESTINO)) {
				this.setResaltardestinoRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.PRECIO)) {
				this.setResaltarprecioRuta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionRuta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteRuta=null;

	public Border getResaltarClienteRuta() {
		return this.resaltarClienteRuta;
	}

	public void setResaltarClienteRuta(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteRuta= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltarCliente);
			
		this.resaltarClienteRuta= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteRuta=true;

	public Boolean getMostrarClienteRuta() {
		return this.mostrarClienteRuta;
	}

	public void setMostrarClienteRuta(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteRuta= visibilidadResaltarCliente;
	}



	public Boolean activarClienteRuta=true;

	public Boolean gethabilitarResaltarClienteRuta() {
		return this.activarClienteRuta;
	}

	public void setActivarClienteRuta(Boolean habilitarResaltarCliente) {
		this.activarClienteRuta= habilitarResaltarCliente;
	}


	public Border resaltarParametroCarteraDefectoRuta=null;

	public Border getResaltarParametroCarteraDefectoRuta() {
		return this.resaltarParametroCarteraDefectoRuta;
	}

	public void setResaltarParametroCarteraDefectoRuta(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoRuta= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rutaBeanSwingJInternalFrame.jTtoolBarRuta.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoRuta= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoRuta=true;

	public Boolean getMostrarParametroCarteraDefectoRuta() {
		return this.mostrarParametroCarteraDefectoRuta;
	}

	public void setMostrarParametroCarteraDefectoRuta(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoRuta= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoRuta=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoRuta() {
		return this.activarParametroCarteraDefectoRuta;
	}

	public void setActivarParametroCarteraDefectoRuta(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoRuta= habilitarResaltarParametroCarteraDefecto;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarClienteRuta(esInicial);
		this.setMostrarParametroCarteraDefectoRuta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteRuta(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoRuta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarClienteRuta(esInicial);
		this.setActivarParametroCarteraDefectoRuta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteRuta(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoRuta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteRuta(esInicial);
		this.setResaltarParametroCarteraDefectoRuta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteRuta(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoRuta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorDestinoRuta=true;

	public Boolean getMostrarBusquedaPorDestinoRuta() {
		return this.mostrarBusquedaPorDestinoRuta;
	}

	public void setMostrarBusquedaPorDestinoRuta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorDestinoRuta= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreRuta=true;

	public Boolean getMostrarBusquedaPorNombreRuta() {
		return this.mostrarBusquedaPorNombreRuta;
	}

	public void setMostrarBusquedaPorNombreRuta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreRuta= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorOrigenRuta=true;

	public Boolean getMostrarBusquedaPorOrigenRuta() {
		return this.mostrarBusquedaPorOrigenRuta;
	}

	public void setMostrarBusquedaPorOrigenRuta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorOrigenRuta= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorPrecioRuta=true;

	public Boolean getMostrarBusquedaPorPrecioRuta() {
		return this.mostrarBusquedaPorPrecioRuta;
	}

	public void setMostrarBusquedaPorPrecioRuta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorPrecioRuta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRuta=true;

	public Boolean getMostrarFK_IdEmpresaRuta() {
		return this.mostrarFK_IdEmpresaRuta;
	}

	public void setMostrarFK_IdEmpresaRuta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRuta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisRuta=true;

	public Boolean getMostrarFK_IdPaisRuta() {
		return this.mostrarFK_IdPaisRuta;
	}

	public void setMostrarFK_IdPaisRuta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisRuta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSectorDestinoRuta=true;

	public Boolean getMostrarFK_IdSectorDestinoRuta() {
		return this.mostrarFK_IdSectorDestinoRuta;
	}

	public void setMostrarFK_IdSectorDestinoRuta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSectorDestinoRuta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSectorOrigenRuta=true;

	public Boolean getMostrarFK_IdSectorOrigenRuta() {
		return this.mostrarFK_IdSectorOrigenRuta;
	}

	public void setMostrarFK_IdSectorOrigenRuta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSectorOrigenRuta= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorDestinoRuta=true;

	public Boolean getActivarBusquedaPorDestinoRuta() {
		return this.activarBusquedaPorDestinoRuta;
	}

	public void setActivarBusquedaPorDestinoRuta(Boolean habilitarResaltar) {
		this.activarBusquedaPorDestinoRuta= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreRuta=true;

	public Boolean getActivarBusquedaPorNombreRuta() {
		return this.activarBusquedaPorNombreRuta;
	}

	public void setActivarBusquedaPorNombreRuta(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreRuta= habilitarResaltar;
	}

	public Boolean activarBusquedaPorOrigenRuta=true;

	public Boolean getActivarBusquedaPorOrigenRuta() {
		return this.activarBusquedaPorOrigenRuta;
	}

	public void setActivarBusquedaPorOrigenRuta(Boolean habilitarResaltar) {
		this.activarBusquedaPorOrigenRuta= habilitarResaltar;
	}

	public Boolean activarBusquedaPorPrecioRuta=true;

	public Boolean getActivarBusquedaPorPrecioRuta() {
		return this.activarBusquedaPorPrecioRuta;
	}

	public void setActivarBusquedaPorPrecioRuta(Boolean habilitarResaltar) {
		this.activarBusquedaPorPrecioRuta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRuta=true;

	public Boolean getActivarFK_IdEmpresaRuta() {
		return this.activarFK_IdEmpresaRuta;
	}

	public void setActivarFK_IdEmpresaRuta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRuta= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisRuta=true;

	public Boolean getActivarFK_IdPaisRuta() {
		return this.activarFK_IdPaisRuta;
	}

	public void setActivarFK_IdPaisRuta(Boolean habilitarResaltar) {
		this.activarFK_IdPaisRuta= habilitarResaltar;
	}

	public Boolean activarFK_IdSectorDestinoRuta=true;

	public Boolean getActivarFK_IdSectorDestinoRuta() {
		return this.activarFK_IdSectorDestinoRuta;
	}

	public void setActivarFK_IdSectorDestinoRuta(Boolean habilitarResaltar) {
		this.activarFK_IdSectorDestinoRuta= habilitarResaltar;
	}

	public Boolean activarFK_IdSectorOrigenRuta=true;

	public Boolean getActivarFK_IdSectorOrigenRuta() {
		return this.activarFK_IdSectorOrigenRuta;
	}

	public void setActivarFK_IdSectorOrigenRuta(Boolean habilitarResaltar) {
		this.activarFK_IdSectorOrigenRuta= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorDestinoRuta=null;

	public Border getResaltarBusquedaPorDestinoRuta() {
		return this.resaltarBusquedaPorDestinoRuta;
	}

	public void setResaltarBusquedaPorDestinoRuta(Border borderResaltar) {
		this.resaltarBusquedaPorDestinoRuta= borderResaltar;
	}

	public void setResaltarBusquedaPorDestinoRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorDestinoRuta= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreRuta=null;

	public Border getResaltarBusquedaPorNombreRuta() {
		return this.resaltarBusquedaPorNombreRuta;
	}

	public void setResaltarBusquedaPorNombreRuta(Border borderResaltar) {
		this.resaltarBusquedaPorNombreRuta= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreRuta= borderResaltar;
	}

	public Border resaltarBusquedaPorOrigenRuta=null;

	public Border getResaltarBusquedaPorOrigenRuta() {
		return this.resaltarBusquedaPorOrigenRuta;
	}

	public void setResaltarBusquedaPorOrigenRuta(Border borderResaltar) {
		this.resaltarBusquedaPorOrigenRuta= borderResaltar;
	}

	public void setResaltarBusquedaPorOrigenRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorOrigenRuta= borderResaltar;
	}

	public Border resaltarBusquedaPorPrecioRuta=null;

	public Border getResaltarBusquedaPorPrecioRuta() {
		return this.resaltarBusquedaPorPrecioRuta;
	}

	public void setResaltarBusquedaPorPrecioRuta(Border borderResaltar) {
		this.resaltarBusquedaPorPrecioRuta= borderResaltar;
	}

	public void setResaltarBusquedaPorPrecioRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorPrecioRuta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRuta=null;

	public Border getResaltarFK_IdEmpresaRuta() {
		return this.resaltarFK_IdEmpresaRuta;
	}

	public void setResaltarFK_IdEmpresaRuta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRuta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRuta= borderResaltar;
	}

	public Border resaltarFK_IdPaisRuta=null;

	public Border getResaltarFK_IdPaisRuta() {
		return this.resaltarFK_IdPaisRuta;
	}

	public void setResaltarFK_IdPaisRuta(Border borderResaltar) {
		this.resaltarFK_IdPaisRuta= borderResaltar;
	}

	public void setResaltarFK_IdPaisRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisRuta= borderResaltar;
	}

	public Border resaltarFK_IdSectorDestinoRuta=null;

	public Border getResaltarFK_IdSectorDestinoRuta() {
		return this.resaltarFK_IdSectorDestinoRuta;
	}

	public void setResaltarFK_IdSectorDestinoRuta(Border borderResaltar) {
		this.resaltarFK_IdSectorDestinoRuta= borderResaltar;
	}

	public void setResaltarFK_IdSectorDestinoRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSectorDestinoRuta= borderResaltar;
	}

	public Border resaltarFK_IdSectorOrigenRuta=null;

	public Border getResaltarFK_IdSectorOrigenRuta() {
		return this.resaltarFK_IdSectorOrigenRuta;
	}

	public void setResaltarFK_IdSectorOrigenRuta(Border borderResaltar) {
		this.resaltarFK_IdSectorOrigenRuta= borderResaltar;
	}

	public void setResaltarFK_IdSectorOrigenRuta(ParametroGeneralUsuario parametroGeneralUsuario/*RutaBeanSwingJInternalFrame rutaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSectorOrigenRuta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}