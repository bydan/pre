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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.CobrarClientesPorRegionConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarClientesPorRegionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesPorRegionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarClientesPorRegionConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="CobrarClientesPorRegion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarClientesPorRegion"+CobrarClientesPorRegionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarClientesPorRegionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarClientesPorRegionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarClientesPorRegionConstantesFunciones.SCHEMA+"_"+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesPorRegionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarClientesPorRegionConstantesFunciones.SCHEMA+"_"+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarClientesPorRegionConstantesFunciones.SCHEMA+"_"+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesPorRegionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarClientesPorRegionConstantesFunciones.SCHEMA+"_"+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesPorRegionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesPorRegionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesPorRegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarClientesPorRegionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarClientesPorRegionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarClientesPorRegionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarClientesPorRegionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Clientes Por Regiones";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Clientes Por Region";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Clientes Por Region";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarClientesPorRegion";
	public static final String OBJECTNAME="cobrarclientesporregion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_clientes_por_region";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarclientesporregion from "+CobrarClientesPorRegionConstantesFunciones.SPERSISTENCENAME+" cobrarclientesporregion";
	public static String QUERYSELECTNATIVE="select "+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".id,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".version_row,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".id_empresa,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".id_sucursal,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".id_pais,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".id_region,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".id_provincia,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".id_ciudad,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".nombre_region,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".nombre_provincia,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".nombre_ciudad,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".nombre_zona,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".nombre_ruta,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".nombre_vendedor,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".codigo,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".nombre,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".apellido,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".direccion_direccion,"+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME+".telefono_telefono from "+CobrarClientesPorRegionConstantesFunciones.SCHEMA+"."+CobrarClientesPorRegionConstantesFunciones.TABLENAME;//+" as "+CobrarClientesPorRegionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPAIS= "id_pais";
    public static final String IDREGION= "id_region";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String NOMBREREGION= "nombre_region";
    public static final String NOMBREPROVINCIA= "nombre_provincia";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBRERUTA= "nombre_ruta";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String DIRECCIONDIRECCION= "direccion_direccion";
    public static final String TELEFONOTELEFONO= "telefono_telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDREGION= "Region";
		public static final String LABEL_IDREGION_LOWER= "Region";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_NOMBREREGION= "Nombre Region";
		public static final String LABEL_NOMBREREGION_LOWER= "Nombre Region";
    	public static final String LABEL_NOMBREPROVINCIA= "Nombre Provincia";
		public static final String LABEL_NOMBREPROVINCIA_LOWER= "Nombre Provincia";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBRERUTA= "Nombre Ruta";
		public static final String LABEL_NOMBRERUTA_LOWER= "Nombre Ruta";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apello";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_DIRECCIONDIRECCION= "Direccion Direccion";
		public static final String LABEL_DIRECCIONDIRECCION_LOWER= "Direccion Direccion";
    	public static final String LABEL_TELEFONOTELEFONO= "Telefono Telefono";
		public static final String LABEL_TELEFONOTELEFONO_LOWER= "Telefono Telefono";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_REGION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_REGION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PROVINCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PROVINCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_RUTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_RUTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_DIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_TELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_TELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCobrarClientesPorRegionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.IDPAIS)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.IDREGION)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_IDREGION;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.IDPROVINCIA)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.IDCIUDAD)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREREGION)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREREGION;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREPROVINCIA;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREZONA)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRERUTA;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.CODIGO)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRE)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.APELLIDO)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_DIRECCIONDIRECCION;}
		if(sNombreColumna.equals(CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO)) {sLabelColumna=CobrarClientesPorRegionConstantesFunciones.LABEL_TELEFONOTELEFONO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarClientesPorRegionDescripcion(CobrarClientesPorRegion cobrarclientesporregion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarclientesporregion !=null/* && cobrarclientesporregion.getId()!=0*/) {
			sDescripcion=cobrarclientesporregion.getcodigo();//cobrarclientesporregioncobrarclientesporregion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarClientesPorRegionDescripcionDetallado(CobrarClientesPorRegion cobrarclientesporregion) {
		String sDescripcion="";
			
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.ID+"=";
		sDescripcion+=cobrarclientesporregion.getId().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarclientesporregion.getVersionRow().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarclientesporregion.getid_empresa().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cobrarclientesporregion.getid_sucursal().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.IDPAIS+"=";
		sDescripcion+=cobrarclientesporregion.getid_pais().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.IDREGION+"=";
		sDescripcion+=cobrarclientesporregion.getid_region().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=cobrarclientesporregion.getid_provincia().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=cobrarclientesporregion.getid_ciudad().toString()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.NOMBREREGION+"=";
		sDescripcion+=cobrarclientesporregion.getnombre_region()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA+"=";
		sDescripcion+=cobrarclientesporregion.getnombre_provincia()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=cobrarclientesporregion.getnombre_ciudad()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=cobrarclientesporregion.getnombre_zona()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA+"=";
		sDescripcion+=cobrarclientesporregion.getnombre_ruta()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=cobrarclientesporregion.getnombre_vendedor()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarclientesporregion.getcodigo()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cobrarclientesporregion.getnombre()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cobrarclientesporregion.getapellido()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION+"=";
		sDescripcion+=cobrarclientesporregion.getdireccion_direccion()+",";
		sDescripcion+=CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO+"=";
		sDescripcion+=cobrarclientesporregion.gettelefono_telefono()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarClientesPorRegionDescripcion(CobrarClientesPorRegion cobrarclientesporregion,String sValor) throws Exception {			
		if(cobrarclientesporregion !=null) {
			cobrarclientesporregion.setcodigo(sValor);;//cobrarclientesporregioncobrarclientesporregion.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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

	public static String getRegionDescripcion(Region region) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(region!=null/*&&region.getId()>0*/) {
			sDescripcion=RegionConstantesFunciones.getRegionDescripcion(region);
		}

		return sDescripcion;
	}

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarClientesPorRegion")) {
			sNombreIndice="Tipo=  Por Pais Por Region Por Provincia Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("FK_IdRegion")) {
			sNombreIndice="Tipo=  Por Region";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarClientesPorRegion(Long id_pais,Long id_region,Long id_provincia,Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(id_region!=null) {sDetalleIndice+=" Codigo Unico De Region="+id_region.toString();}
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();}
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

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

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRegion(Long id_region) {
		String sDetalleIndice=" Parametros->";
		if(id_region!=null) {sDetalleIndice+=" Codigo Unico De Region="+id_region.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarClientesPorRegion(CobrarClientesPorRegion cobrarclientesporregion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientesporregion.setnombre_region(cobrarclientesporregion.getnombre_region().trim());
		cobrarclientesporregion.setnombre_provincia(cobrarclientesporregion.getnombre_provincia().trim());
		cobrarclientesporregion.setnombre_ciudad(cobrarclientesporregion.getnombre_ciudad().trim());
		cobrarclientesporregion.setnombre_zona(cobrarclientesporregion.getnombre_zona().trim());
		cobrarclientesporregion.setnombre_ruta(cobrarclientesporregion.getnombre_ruta().trim());
		cobrarclientesporregion.setnombre_vendedor(cobrarclientesporregion.getnombre_vendedor().trim());
		cobrarclientesporregion.setcodigo(cobrarclientesporregion.getcodigo().trim());
		cobrarclientesporregion.setnombre(cobrarclientesporregion.getnombre().trim());
		cobrarclientesporregion.setapellido(cobrarclientesporregion.getapellido().trim());
		cobrarclientesporregion.setdireccion_direccion(cobrarclientesporregion.getdireccion_direccion().trim());
		cobrarclientesporregion.settelefono_telefono(cobrarclientesporregion.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarClientesPorRegions(List<CobrarClientesPorRegion> cobrarclientesporregions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesPorRegion cobrarclientesporregion: cobrarclientesporregions) {
			cobrarclientesporregion.setnombre_region(cobrarclientesporregion.getnombre_region().trim());
			cobrarclientesporregion.setnombre_provincia(cobrarclientesporregion.getnombre_provincia().trim());
			cobrarclientesporregion.setnombre_ciudad(cobrarclientesporregion.getnombre_ciudad().trim());
			cobrarclientesporregion.setnombre_zona(cobrarclientesporregion.getnombre_zona().trim());
			cobrarclientesporregion.setnombre_ruta(cobrarclientesporregion.getnombre_ruta().trim());
			cobrarclientesporregion.setnombre_vendedor(cobrarclientesporregion.getnombre_vendedor().trim());
			cobrarclientesporregion.setcodigo(cobrarclientesporregion.getcodigo().trim());
			cobrarclientesporregion.setnombre(cobrarclientesporregion.getnombre().trim());
			cobrarclientesporregion.setapellido(cobrarclientesporregion.getapellido().trim());
			cobrarclientesporregion.setdireccion_direccion(cobrarclientesporregion.getdireccion_direccion().trim());
			cobrarclientesporregion.settelefono_telefono(cobrarclientesporregion.gettelefono_telefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesPorRegion(CobrarClientesPorRegion cobrarclientesporregion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarclientesporregion.getConCambioAuxiliar()) {
			cobrarclientesporregion.setIsDeleted(cobrarclientesporregion.getIsDeletedAuxiliar());	
			cobrarclientesporregion.setIsNew(cobrarclientesporregion.getIsNewAuxiliar());	
			cobrarclientesporregion.setIsChanged(cobrarclientesporregion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarclientesporregion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarclientesporregion.setIsDeletedAuxiliar(false);	
			cobrarclientesporregion.setIsNewAuxiliar(false);	
			cobrarclientesporregion.setIsChangedAuxiliar(false);
			
			cobrarclientesporregion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesPorRegions(List<CobrarClientesPorRegion> cobrarclientesporregions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarClientesPorRegion cobrarclientesporregion : cobrarclientesporregions) {
			if(conAsignarBase && cobrarclientesporregion.getConCambioAuxiliar()) {
				cobrarclientesporregion.setIsDeleted(cobrarclientesporregion.getIsDeletedAuxiliar());	
				cobrarclientesporregion.setIsNew(cobrarclientesporregion.getIsNewAuxiliar());	
				cobrarclientesporregion.setIsChanged(cobrarclientesporregion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarclientesporregion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarclientesporregion.setIsDeletedAuxiliar(false);	
				cobrarclientesporregion.setIsNewAuxiliar(false);	
				cobrarclientesporregion.setIsChangedAuxiliar(false);
				
				cobrarclientesporregion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarClientesPorRegion(CobrarClientesPorRegion cobrarclientesporregion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarClientesPorRegions(List<CobrarClientesPorRegion> cobrarclientesporregions,Boolean conEnteros) throws Exception  {
		
		for(CobrarClientesPorRegion cobrarclientesporregion: cobrarclientesporregions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarClientesPorRegion(List<CobrarClientesPorRegion> cobrarclientesporregions,CobrarClientesPorRegion cobrarclientesporregionAux) throws Exception  {
		CobrarClientesPorRegionConstantesFunciones.InicializarValoresCobrarClientesPorRegion(cobrarclientesporregionAux,true);
		
		for(CobrarClientesPorRegion cobrarclientesporregion: cobrarclientesporregions) {
			if(cobrarclientesporregion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesPorRegion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarClientesPorRegionConstantesFunciones.getArrayColumnasGlobalesCobrarClientesPorRegion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesPorRegion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesPorRegionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesPorRegionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarClientesPorRegion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesPorRegion> cobrarclientesporregions,CobrarClientesPorRegion cobrarclientesporregion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesPorRegion cobrarclientesporregionAux: cobrarclientesporregions) {
			if(cobrarclientesporregionAux!=null && cobrarclientesporregion!=null) {
				if((cobrarclientesporregionAux.getId()==null && cobrarclientesporregion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarclientesporregionAux.getId()!=null && cobrarclientesporregion.getId()!=null){
					if(cobrarclientesporregionAux.getId().equals(cobrarclientesporregion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesPorRegion(List<CobrarClientesPorRegion> cobrarclientesporregions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarClientesPorRegion cobrarclientesporregion: cobrarclientesporregions) {			
			if(cobrarclientesporregion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarClientesPorRegion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_ID, CobrarClientesPorRegionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_VERSIONROW, CobrarClientesPorRegionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREREGION, CobrarClientesPorRegionConstantesFunciones.NOMBREREGION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREPROVINCIA, CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRECIUDAD, CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREZONA, CobrarClientesPorRegionConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRERUTA, CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREVENDEDOR, CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_CODIGO, CobrarClientesPorRegionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRE, CobrarClientesPorRegionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_APELLIDO, CobrarClientesPorRegionConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_DIRECCIONDIRECCION, CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesPorRegionConstantesFunciones.LABEL_TELEFONOTELEFONO, CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarClientesPorRegion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.NOMBREREGION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesPorRegion() throws Exception  {
		return CobrarClientesPorRegionConstantesFunciones.getTiposSeleccionarCobrarClientesPorRegion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesPorRegion(Boolean conFk) throws Exception  {
		return CobrarClientesPorRegionConstantesFunciones.getTiposSeleccionarCobrarClientesPorRegion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesPorRegion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_IDREGION);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_IDREGION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREREGION);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREREGION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREPROVINCIA);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRERUTA);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRERUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_DIRECCIONDIRECCION);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_DIRECCIONDIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesPorRegionConstantesFunciones.LABEL_TELEFONOTELEFONO);
			reporte.setsDescripcion(CobrarClientesPorRegionConstantesFunciones.LABEL_TELEFONOTELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarClientesPorRegion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesPorRegion(CobrarClientesPorRegion cobrarclientesporregionAux) throws Exception {
		
			cobrarclientesporregionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientesporregionAux.getEmpresa()));
			cobrarclientesporregionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclientesporregionAux.getSucursal()));
			cobrarclientesporregionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cobrarclientesporregionAux.getPais()));
			cobrarclientesporregionAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(cobrarclientesporregionAux.getRegion()));
			cobrarclientesporregionAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(cobrarclientesporregionAux.getProvincia()));
			cobrarclientesporregionAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cobrarclientesporregionAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesPorRegion(List<CobrarClientesPorRegion> cobrarclientesporregionsTemp) throws Exception {
		for(CobrarClientesPorRegion cobrarclientesporregionAux:cobrarclientesporregionsTemp) {
			
			cobrarclientesporregionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientesporregionAux.getEmpresa()));
			cobrarclientesporregionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclientesporregionAux.getSucursal()));
			cobrarclientesporregionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(cobrarclientesporregionAux.getPais()));
			cobrarclientesporregionAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(cobrarclientesporregionAux.getRegion()));
			cobrarclientesporregionAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(cobrarclientesporregionAux.getProvincia()));
			cobrarclientesporregionAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(cobrarclientesporregionAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarClientesPorRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Region.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Region.class)) {
						classes.add(new Classe(Region.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarClientesPorRegion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesPorRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesPorRegionConstantesFunciones.getClassesRelationshipsOfCobrarClientesPorRegion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesPorRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesPorRegion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesPorRegionConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarClientesPorRegion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesPorRegion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(CobrarClientesPorRegion cobrarclientesporregion,List<CobrarClientesPorRegion> cobrarclientesporregions,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarClientesPorRegion cobrarclientesporregion,List<CobrarClientesPorRegion> cobrarclientesporregions) throws Exception {
		try	{			
			for(CobrarClientesPorRegion cobrarclientesporregionLocal:cobrarclientesporregions) {
				if(cobrarclientesporregionLocal.getId().equals(cobrarclientesporregion.getId())) {
					cobrarclientesporregionLocal.setIsSelected(cobrarclientesporregion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarClientesPorRegion(List<CobrarClientesPorRegion> cobrarclientesporregionsAux) throws Exception {
		//this.cobrarclientesporregionsAux=cobrarclientesporregionsAux;
		
		for(CobrarClientesPorRegion cobrarclientesporregionAux:cobrarclientesporregionsAux) {
			if(cobrarclientesporregionAux.getIsChanged()) {
				cobrarclientesporregionAux.setIsChanged(false);
			}		
			
			if(cobrarclientesporregionAux.getIsNew()) {
				cobrarclientesporregionAux.setIsNew(false);
			}	
			
			if(cobrarclientesporregionAux.getIsDeleted()) {
				cobrarclientesporregionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarClientesPorRegion(CobrarClientesPorRegion cobrarclientesporregionAux) throws Exception {
		//this.cobrarclientesporregionAux=cobrarclientesporregionAux;
		
			if(cobrarclientesporregionAux.getIsChanged()) {
				cobrarclientesporregionAux.setIsChanged(false);
			}		
			
			if(cobrarclientesporregionAux.getIsNew()) {
				cobrarclientesporregionAux.setIsNew(false);
			}	
			
			if(cobrarclientesporregionAux.getIsDeleted()) {
				cobrarclientesporregionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarClientesPorRegion cobrarclientesporregionAsignar,CobrarClientesPorRegion cobrarclientesporregion) throws Exception {
		cobrarclientesporregionAsignar.setId(cobrarclientesporregion.getId());	
		cobrarclientesporregionAsignar.setVersionRow(cobrarclientesporregion.getVersionRow());	
		cobrarclientesporregionAsignar.setnombre_region(cobrarclientesporregion.getnombre_region());	
		cobrarclientesporregionAsignar.setnombre_provincia(cobrarclientesporregion.getnombre_provincia());	
		cobrarclientesporregionAsignar.setnombre_ciudad(cobrarclientesporregion.getnombre_ciudad());	
		cobrarclientesporregionAsignar.setnombre_zona(cobrarclientesporregion.getnombre_zona());	
		cobrarclientesporregionAsignar.setnombre_ruta(cobrarclientesporregion.getnombre_ruta());	
		cobrarclientesporregionAsignar.setnombre_vendedor(cobrarclientesporregion.getnombre_vendedor());	
		cobrarclientesporregionAsignar.setcodigo(cobrarclientesporregion.getcodigo());	
		cobrarclientesporregionAsignar.setnombre(cobrarclientesporregion.getnombre());	
		cobrarclientesporregionAsignar.setapellido(cobrarclientesporregion.getapellido());	
		cobrarclientesporregionAsignar.setdireccion_direccion(cobrarclientesporregion.getdireccion_direccion());	
		cobrarclientesporregionAsignar.settelefono_telefono(cobrarclientesporregion.gettelefono_telefono());	
	}
	
	public static void inicializarCobrarClientesPorRegion(CobrarClientesPorRegion cobrarclientesporregion) throws Exception {
		try {
				cobrarclientesporregion.setId(0L);	
					
				cobrarclientesporregion.setnombre_region("");	
				cobrarclientesporregion.setnombre_provincia("");	
				cobrarclientesporregion.setnombre_ciudad("");	
				cobrarclientesporregion.setnombre_zona("");	
				cobrarclientesporregion.setnombre_ruta("");	
				cobrarclientesporregion.setnombre_vendedor("");	
				cobrarclientesporregion.setcodigo("");	
				cobrarclientesporregion.setnombre("");	
				cobrarclientesporregion.setapellido("");	
				cobrarclientesporregion.setdireccion_direccion("");	
				cobrarclientesporregion.settelefono_telefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarClientesPorRegion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_IDREGION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREREGION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRERUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_DIRECCIONDIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesPorRegionConstantesFunciones.LABEL_TELEFONOTELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarClientesPorRegion(String sTipo,Row row,Workbook workbook,CobrarClientesPorRegion cobrarclientesporregion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getregion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getnombre_region());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getnombre_provincia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getnombre_ruta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.getdireccion_direccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesporregion.gettelefono_telefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarClientesPorRegion="";
	
	public String getsFinalQueryCobrarClientesPorRegion() {
		return this.sFinalQueryCobrarClientesPorRegion;
	}
	
	public void setsFinalQueryCobrarClientesPorRegion(String sFinalQueryCobrarClientesPorRegion) {
		this.sFinalQueryCobrarClientesPorRegion= sFinalQueryCobrarClientesPorRegion;
	}
	
	public Border resaltarSeleccionarCobrarClientesPorRegion=null;
	
	public Border setResaltarSeleccionarCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarClientesPorRegion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarClientesPorRegion() {
		return this.resaltarSeleccionarCobrarClientesPorRegion;
	}
	
	public void setResaltarSeleccionarCobrarClientesPorRegion(Border borderResaltarSeleccionarCobrarClientesPorRegion) {
		this.resaltarSeleccionarCobrarClientesPorRegion= borderResaltarSeleccionarCobrarClientesPorRegion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarClientesPorRegion=null;
	public Boolean mostraridCobrarClientesPorRegion=true;
	public Boolean activaridCobrarClientesPorRegion=true;

	public Border resaltarid_empresaCobrarClientesPorRegion=null;
	public Boolean mostrarid_empresaCobrarClientesPorRegion=true;
	public Boolean activarid_empresaCobrarClientesPorRegion=true;
	public Boolean cargarid_empresaCobrarClientesPorRegion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarClientesPorRegion=false;//ConEventDepend=true

	public Border resaltarid_sucursalCobrarClientesPorRegion=null;
	public Boolean mostrarid_sucursalCobrarClientesPorRegion=true;
	public Boolean activarid_sucursalCobrarClientesPorRegion=true;
	public Boolean cargarid_sucursalCobrarClientesPorRegion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCobrarClientesPorRegion=false;//ConEventDepend=true

	public Border resaltarid_paisCobrarClientesPorRegion=null;
	public Boolean mostrarid_paisCobrarClientesPorRegion=true;
	public Boolean activarid_paisCobrarClientesPorRegion=true;
	public Boolean cargarid_paisCobrarClientesPorRegion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisCobrarClientesPorRegion=false;//ConEventDepend=true

	public Border resaltarid_regionCobrarClientesPorRegion=null;
	public Boolean mostrarid_regionCobrarClientesPorRegion=true;
	public Boolean activarid_regionCobrarClientesPorRegion=true;
	public Boolean cargarid_regionCobrarClientesPorRegion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_regionCobrarClientesPorRegion=false;//ConEventDepend=true

	public Border resaltarid_provinciaCobrarClientesPorRegion=null;
	public Boolean mostrarid_provinciaCobrarClientesPorRegion=true;
	public Boolean activarid_provinciaCobrarClientesPorRegion=true;
	public Boolean cargarid_provinciaCobrarClientesPorRegion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaCobrarClientesPorRegion=false;//ConEventDepend=true

	public Border resaltarid_ciudadCobrarClientesPorRegion=null;
	public Boolean mostrarid_ciudadCobrarClientesPorRegion=true;
	public Boolean activarid_ciudadCobrarClientesPorRegion=true;
	public Boolean cargarid_ciudadCobrarClientesPorRegion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadCobrarClientesPorRegion=false;//ConEventDepend=true

	public Border resaltarnombre_regionCobrarClientesPorRegion=null;
	public Boolean mostrarnombre_regionCobrarClientesPorRegion=true;
	public Boolean activarnombre_regionCobrarClientesPorRegion=true;

	public Border resaltarnombre_provinciaCobrarClientesPorRegion=null;
	public Boolean mostrarnombre_provinciaCobrarClientesPorRegion=true;
	public Boolean activarnombre_provinciaCobrarClientesPorRegion=true;

	public Border resaltarnombre_ciudadCobrarClientesPorRegion=null;
	public Boolean mostrarnombre_ciudadCobrarClientesPorRegion=true;
	public Boolean activarnombre_ciudadCobrarClientesPorRegion=true;

	public Border resaltarnombre_zonaCobrarClientesPorRegion=null;
	public Boolean mostrarnombre_zonaCobrarClientesPorRegion=true;
	public Boolean activarnombre_zonaCobrarClientesPorRegion=true;

	public Border resaltarnombre_rutaCobrarClientesPorRegion=null;
	public Boolean mostrarnombre_rutaCobrarClientesPorRegion=true;
	public Boolean activarnombre_rutaCobrarClientesPorRegion=true;

	public Border resaltarnombre_vendedorCobrarClientesPorRegion=null;
	public Boolean mostrarnombre_vendedorCobrarClientesPorRegion=true;
	public Boolean activarnombre_vendedorCobrarClientesPorRegion=true;

	public Border resaltarcodigoCobrarClientesPorRegion=null;
	public Boolean mostrarcodigoCobrarClientesPorRegion=true;
	public Boolean activarcodigoCobrarClientesPorRegion=true;

	public Border resaltarnombreCobrarClientesPorRegion=null;
	public Boolean mostrarnombreCobrarClientesPorRegion=true;
	public Boolean activarnombreCobrarClientesPorRegion=true;

	public Border resaltarapellidoCobrarClientesPorRegion=null;
	public Boolean mostrarapellidoCobrarClientesPorRegion=true;
	public Boolean activarapellidoCobrarClientesPorRegion=true;

	public Border resaltardireccion_direccionCobrarClientesPorRegion=null;
	public Boolean mostrardireccion_direccionCobrarClientesPorRegion=true;
	public Boolean activardireccion_direccionCobrarClientesPorRegion=true;

	public Border resaltartelefono_telefonoCobrarClientesPorRegion=null;
	public Boolean mostrartelefono_telefonoCobrarClientesPorRegion=true;
	public Boolean activartelefono_telefonoCobrarClientesPorRegion=true;

	
	

	public Border setResaltaridCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltaridCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarClientesPorRegion() {
		return this.resaltaridCobrarClientesPorRegion;
	}

	public void setResaltaridCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltaridCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostraridCobrarClientesPorRegion() {
		return this.mostraridCobrarClientesPorRegion;
	}

	public void setMostraridCobrarClientesPorRegion(Boolean mostraridCobrarClientesPorRegion) {
		this.mostraridCobrarClientesPorRegion= mostraridCobrarClientesPorRegion;
	}

	public Boolean getActivaridCobrarClientesPorRegion() {
		return this.activaridCobrarClientesPorRegion;
	}

	public void setActivaridCobrarClientesPorRegion(Boolean activaridCobrarClientesPorRegion) {
		this.activaridCobrarClientesPorRegion= activaridCobrarClientesPorRegion;
	}

	public Border setResaltarid_empresaCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarClientesPorRegion() {
		return this.resaltarid_empresaCobrarClientesPorRegion;
	}

	public void setResaltarid_empresaCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarid_empresaCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarClientesPorRegion() {
		return this.mostrarid_empresaCobrarClientesPorRegion;
	}

	public void setMostrarid_empresaCobrarClientesPorRegion(Boolean mostrarid_empresaCobrarClientesPorRegion) {
		this.mostrarid_empresaCobrarClientesPorRegion= mostrarid_empresaCobrarClientesPorRegion;
	}

	public Boolean getActivarid_empresaCobrarClientesPorRegion() {
		return this.activarid_empresaCobrarClientesPorRegion;
	}

	public void setActivarid_empresaCobrarClientesPorRegion(Boolean activarid_empresaCobrarClientesPorRegion) {
		this.activarid_empresaCobrarClientesPorRegion= activarid_empresaCobrarClientesPorRegion;
	}

	public Boolean getCargarid_empresaCobrarClientesPorRegion() {
		return this.cargarid_empresaCobrarClientesPorRegion;
	}

	public void setCargarid_empresaCobrarClientesPorRegion(Boolean cargarid_empresaCobrarClientesPorRegion) {
		this.cargarid_empresaCobrarClientesPorRegion= cargarid_empresaCobrarClientesPorRegion;
	}

	public Border setResaltarid_sucursalCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCobrarClientesPorRegion() {
		return this.resaltarid_sucursalCobrarClientesPorRegion;
	}

	public void setResaltarid_sucursalCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarid_sucursalCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCobrarClientesPorRegion() {
		return this.mostrarid_sucursalCobrarClientesPorRegion;
	}

	public void setMostrarid_sucursalCobrarClientesPorRegion(Boolean mostrarid_sucursalCobrarClientesPorRegion) {
		this.mostrarid_sucursalCobrarClientesPorRegion= mostrarid_sucursalCobrarClientesPorRegion;
	}

	public Boolean getActivarid_sucursalCobrarClientesPorRegion() {
		return this.activarid_sucursalCobrarClientesPorRegion;
	}

	public void setActivarid_sucursalCobrarClientesPorRegion(Boolean activarid_sucursalCobrarClientesPorRegion) {
		this.activarid_sucursalCobrarClientesPorRegion= activarid_sucursalCobrarClientesPorRegion;
	}

	public Boolean getCargarid_sucursalCobrarClientesPorRegion() {
		return this.cargarid_sucursalCobrarClientesPorRegion;
	}

	public void setCargarid_sucursalCobrarClientesPorRegion(Boolean cargarid_sucursalCobrarClientesPorRegion) {
		this.cargarid_sucursalCobrarClientesPorRegion= cargarid_sucursalCobrarClientesPorRegion;
	}

	public Border setResaltarid_paisCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarid_paisCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisCobrarClientesPorRegion() {
		return this.resaltarid_paisCobrarClientesPorRegion;
	}

	public void setResaltarid_paisCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarid_paisCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarid_paisCobrarClientesPorRegion() {
		return this.mostrarid_paisCobrarClientesPorRegion;
	}

	public void setMostrarid_paisCobrarClientesPorRegion(Boolean mostrarid_paisCobrarClientesPorRegion) {
		this.mostrarid_paisCobrarClientesPorRegion= mostrarid_paisCobrarClientesPorRegion;
	}

	public Boolean getActivarid_paisCobrarClientesPorRegion() {
		return this.activarid_paisCobrarClientesPorRegion;
	}

	public void setActivarid_paisCobrarClientesPorRegion(Boolean activarid_paisCobrarClientesPorRegion) {
		this.activarid_paisCobrarClientesPorRegion= activarid_paisCobrarClientesPorRegion;
	}

	public Boolean getCargarid_paisCobrarClientesPorRegion() {
		return this.cargarid_paisCobrarClientesPorRegion;
	}

	public void setCargarid_paisCobrarClientesPorRegion(Boolean cargarid_paisCobrarClientesPorRegion) {
		this.cargarid_paisCobrarClientesPorRegion= cargarid_paisCobrarClientesPorRegion;
	}

	public Border setResaltarid_regionCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarid_regionCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_regionCobrarClientesPorRegion() {
		return this.resaltarid_regionCobrarClientesPorRegion;
	}

	public void setResaltarid_regionCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarid_regionCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarid_regionCobrarClientesPorRegion() {
		return this.mostrarid_regionCobrarClientesPorRegion;
	}

	public void setMostrarid_regionCobrarClientesPorRegion(Boolean mostrarid_regionCobrarClientesPorRegion) {
		this.mostrarid_regionCobrarClientesPorRegion= mostrarid_regionCobrarClientesPorRegion;
	}

	public Boolean getActivarid_regionCobrarClientesPorRegion() {
		return this.activarid_regionCobrarClientesPorRegion;
	}

	public void setActivarid_regionCobrarClientesPorRegion(Boolean activarid_regionCobrarClientesPorRegion) {
		this.activarid_regionCobrarClientesPorRegion= activarid_regionCobrarClientesPorRegion;
	}

	public Boolean getCargarid_regionCobrarClientesPorRegion() {
		return this.cargarid_regionCobrarClientesPorRegion;
	}

	public void setCargarid_regionCobrarClientesPorRegion(Boolean cargarid_regionCobrarClientesPorRegion) {
		this.cargarid_regionCobrarClientesPorRegion= cargarid_regionCobrarClientesPorRegion;
	}

	public Border setResaltarid_provinciaCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarid_provinciaCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaCobrarClientesPorRegion() {
		return this.resaltarid_provinciaCobrarClientesPorRegion;
	}

	public void setResaltarid_provinciaCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarid_provinciaCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarid_provinciaCobrarClientesPorRegion() {
		return this.mostrarid_provinciaCobrarClientesPorRegion;
	}

	public void setMostrarid_provinciaCobrarClientesPorRegion(Boolean mostrarid_provinciaCobrarClientesPorRegion) {
		this.mostrarid_provinciaCobrarClientesPorRegion= mostrarid_provinciaCobrarClientesPorRegion;
	}

	public Boolean getActivarid_provinciaCobrarClientesPorRegion() {
		return this.activarid_provinciaCobrarClientesPorRegion;
	}

	public void setActivarid_provinciaCobrarClientesPorRegion(Boolean activarid_provinciaCobrarClientesPorRegion) {
		this.activarid_provinciaCobrarClientesPorRegion= activarid_provinciaCobrarClientesPorRegion;
	}

	public Boolean getCargarid_provinciaCobrarClientesPorRegion() {
		return this.cargarid_provinciaCobrarClientesPorRegion;
	}

	public void setCargarid_provinciaCobrarClientesPorRegion(Boolean cargarid_provinciaCobrarClientesPorRegion) {
		this.cargarid_provinciaCobrarClientesPorRegion= cargarid_provinciaCobrarClientesPorRegion;
	}

	public Border setResaltarid_ciudadCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarid_ciudadCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadCobrarClientesPorRegion() {
		return this.resaltarid_ciudadCobrarClientesPorRegion;
	}

	public void setResaltarid_ciudadCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarid_ciudadCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarid_ciudadCobrarClientesPorRegion() {
		return this.mostrarid_ciudadCobrarClientesPorRegion;
	}

	public void setMostrarid_ciudadCobrarClientesPorRegion(Boolean mostrarid_ciudadCobrarClientesPorRegion) {
		this.mostrarid_ciudadCobrarClientesPorRegion= mostrarid_ciudadCobrarClientesPorRegion;
	}

	public Boolean getActivarid_ciudadCobrarClientesPorRegion() {
		return this.activarid_ciudadCobrarClientesPorRegion;
	}

	public void setActivarid_ciudadCobrarClientesPorRegion(Boolean activarid_ciudadCobrarClientesPorRegion) {
		this.activarid_ciudadCobrarClientesPorRegion= activarid_ciudadCobrarClientesPorRegion;
	}

	public Boolean getCargarid_ciudadCobrarClientesPorRegion() {
		return this.cargarid_ciudadCobrarClientesPorRegion;
	}

	public void setCargarid_ciudadCobrarClientesPorRegion(Boolean cargarid_ciudadCobrarClientesPorRegion) {
		this.cargarid_ciudadCobrarClientesPorRegion= cargarid_ciudadCobrarClientesPorRegion;
	}

	public Border setResaltarnombre_regionCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarnombre_regionCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_regionCobrarClientesPorRegion() {
		return this.resaltarnombre_regionCobrarClientesPorRegion;
	}

	public void setResaltarnombre_regionCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarnombre_regionCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarnombre_regionCobrarClientesPorRegion() {
		return this.mostrarnombre_regionCobrarClientesPorRegion;
	}

	public void setMostrarnombre_regionCobrarClientesPorRegion(Boolean mostrarnombre_regionCobrarClientesPorRegion) {
		this.mostrarnombre_regionCobrarClientesPorRegion= mostrarnombre_regionCobrarClientesPorRegion;
	}

	public Boolean getActivarnombre_regionCobrarClientesPorRegion() {
		return this.activarnombre_regionCobrarClientesPorRegion;
	}

	public void setActivarnombre_regionCobrarClientesPorRegion(Boolean activarnombre_regionCobrarClientesPorRegion) {
		this.activarnombre_regionCobrarClientesPorRegion= activarnombre_regionCobrarClientesPorRegion;
	}

	public Border setResaltarnombre_provinciaCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarnombre_provinciaCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_provinciaCobrarClientesPorRegion() {
		return this.resaltarnombre_provinciaCobrarClientesPorRegion;
	}

	public void setResaltarnombre_provinciaCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarnombre_provinciaCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarnombre_provinciaCobrarClientesPorRegion() {
		return this.mostrarnombre_provinciaCobrarClientesPorRegion;
	}

	public void setMostrarnombre_provinciaCobrarClientesPorRegion(Boolean mostrarnombre_provinciaCobrarClientesPorRegion) {
		this.mostrarnombre_provinciaCobrarClientesPorRegion= mostrarnombre_provinciaCobrarClientesPorRegion;
	}

	public Boolean getActivarnombre_provinciaCobrarClientesPorRegion() {
		return this.activarnombre_provinciaCobrarClientesPorRegion;
	}

	public void setActivarnombre_provinciaCobrarClientesPorRegion(Boolean activarnombre_provinciaCobrarClientesPorRegion) {
		this.activarnombre_provinciaCobrarClientesPorRegion= activarnombre_provinciaCobrarClientesPorRegion;
	}

	public Border setResaltarnombre_ciudadCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadCobrarClientesPorRegion() {
		return this.resaltarnombre_ciudadCobrarClientesPorRegion;
	}

	public void setResaltarnombre_ciudadCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarnombre_ciudadCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadCobrarClientesPorRegion() {
		return this.mostrarnombre_ciudadCobrarClientesPorRegion;
	}

	public void setMostrarnombre_ciudadCobrarClientesPorRegion(Boolean mostrarnombre_ciudadCobrarClientesPorRegion) {
		this.mostrarnombre_ciudadCobrarClientesPorRegion= mostrarnombre_ciudadCobrarClientesPorRegion;
	}

	public Boolean getActivarnombre_ciudadCobrarClientesPorRegion() {
		return this.activarnombre_ciudadCobrarClientesPorRegion;
	}

	public void setActivarnombre_ciudadCobrarClientesPorRegion(Boolean activarnombre_ciudadCobrarClientesPorRegion) {
		this.activarnombre_ciudadCobrarClientesPorRegion= activarnombre_ciudadCobrarClientesPorRegion;
	}

	public Border setResaltarnombre_zonaCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaCobrarClientesPorRegion() {
		return this.resaltarnombre_zonaCobrarClientesPorRegion;
	}

	public void setResaltarnombre_zonaCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarnombre_zonaCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaCobrarClientesPorRegion() {
		return this.mostrarnombre_zonaCobrarClientesPorRegion;
	}

	public void setMostrarnombre_zonaCobrarClientesPorRegion(Boolean mostrarnombre_zonaCobrarClientesPorRegion) {
		this.mostrarnombre_zonaCobrarClientesPorRegion= mostrarnombre_zonaCobrarClientesPorRegion;
	}

	public Boolean getActivarnombre_zonaCobrarClientesPorRegion() {
		return this.activarnombre_zonaCobrarClientesPorRegion;
	}

	public void setActivarnombre_zonaCobrarClientesPorRegion(Boolean activarnombre_zonaCobrarClientesPorRegion) {
		this.activarnombre_zonaCobrarClientesPorRegion= activarnombre_zonaCobrarClientesPorRegion;
	}

	public Border setResaltarnombre_rutaCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarnombre_rutaCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_rutaCobrarClientesPorRegion() {
		return this.resaltarnombre_rutaCobrarClientesPorRegion;
	}

	public void setResaltarnombre_rutaCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarnombre_rutaCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarnombre_rutaCobrarClientesPorRegion() {
		return this.mostrarnombre_rutaCobrarClientesPorRegion;
	}

	public void setMostrarnombre_rutaCobrarClientesPorRegion(Boolean mostrarnombre_rutaCobrarClientesPorRegion) {
		this.mostrarnombre_rutaCobrarClientesPorRegion= mostrarnombre_rutaCobrarClientesPorRegion;
	}

	public Boolean getActivarnombre_rutaCobrarClientesPorRegion() {
		return this.activarnombre_rutaCobrarClientesPorRegion;
	}

	public void setActivarnombre_rutaCobrarClientesPorRegion(Boolean activarnombre_rutaCobrarClientesPorRegion) {
		this.activarnombre_rutaCobrarClientesPorRegion= activarnombre_rutaCobrarClientesPorRegion;
	}

	public Border setResaltarnombre_vendedorCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorCobrarClientesPorRegion() {
		return this.resaltarnombre_vendedorCobrarClientesPorRegion;
	}

	public void setResaltarnombre_vendedorCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarnombre_vendedorCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorCobrarClientesPorRegion() {
		return this.mostrarnombre_vendedorCobrarClientesPorRegion;
	}

	public void setMostrarnombre_vendedorCobrarClientesPorRegion(Boolean mostrarnombre_vendedorCobrarClientesPorRegion) {
		this.mostrarnombre_vendedorCobrarClientesPorRegion= mostrarnombre_vendedorCobrarClientesPorRegion;
	}

	public Boolean getActivarnombre_vendedorCobrarClientesPorRegion() {
		return this.activarnombre_vendedorCobrarClientesPorRegion;
	}

	public void setActivarnombre_vendedorCobrarClientesPorRegion(Boolean activarnombre_vendedorCobrarClientesPorRegion) {
		this.activarnombre_vendedorCobrarClientesPorRegion= activarnombre_vendedorCobrarClientesPorRegion;
	}

	public Border setResaltarcodigoCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarClientesPorRegion() {
		return this.resaltarcodigoCobrarClientesPorRegion;
	}

	public void setResaltarcodigoCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarcodigoCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarClientesPorRegion() {
		return this.mostrarcodigoCobrarClientesPorRegion;
	}

	public void setMostrarcodigoCobrarClientesPorRegion(Boolean mostrarcodigoCobrarClientesPorRegion) {
		this.mostrarcodigoCobrarClientesPorRegion= mostrarcodigoCobrarClientesPorRegion;
	}

	public Boolean getActivarcodigoCobrarClientesPorRegion() {
		return this.activarcodigoCobrarClientesPorRegion;
	}

	public void setActivarcodigoCobrarClientesPorRegion(Boolean activarcodigoCobrarClientesPorRegion) {
		this.activarcodigoCobrarClientesPorRegion= activarcodigoCobrarClientesPorRegion;
	}

	public Border setResaltarnombreCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarnombreCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCobrarClientesPorRegion() {
		return this.resaltarnombreCobrarClientesPorRegion;
	}

	public void setResaltarnombreCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarnombreCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarnombreCobrarClientesPorRegion() {
		return this.mostrarnombreCobrarClientesPorRegion;
	}

	public void setMostrarnombreCobrarClientesPorRegion(Boolean mostrarnombreCobrarClientesPorRegion) {
		this.mostrarnombreCobrarClientesPorRegion= mostrarnombreCobrarClientesPorRegion;
	}

	public Boolean getActivarnombreCobrarClientesPorRegion() {
		return this.activarnombreCobrarClientesPorRegion;
	}

	public void setActivarnombreCobrarClientesPorRegion(Boolean activarnombreCobrarClientesPorRegion) {
		this.activarnombreCobrarClientesPorRegion= activarnombreCobrarClientesPorRegion;
	}

	public Border setResaltarapellidoCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltarapellidoCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCobrarClientesPorRegion() {
		return this.resaltarapellidoCobrarClientesPorRegion;
	}

	public void setResaltarapellidoCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarapellidoCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrarapellidoCobrarClientesPorRegion() {
		return this.mostrarapellidoCobrarClientesPorRegion;
	}

	public void setMostrarapellidoCobrarClientesPorRegion(Boolean mostrarapellidoCobrarClientesPorRegion) {
		this.mostrarapellidoCobrarClientesPorRegion= mostrarapellidoCobrarClientesPorRegion;
	}

	public Boolean getActivarapellidoCobrarClientesPorRegion() {
		return this.activarapellidoCobrarClientesPorRegion;
	}

	public void setActivarapellidoCobrarClientesPorRegion(Boolean activarapellidoCobrarClientesPorRegion) {
		this.activarapellidoCobrarClientesPorRegion= activarapellidoCobrarClientesPorRegion;
	}

	public Border setResaltardireccion_direccionCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltardireccion_direccionCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_direccionCobrarClientesPorRegion() {
		return this.resaltardireccion_direccionCobrarClientesPorRegion;
	}

	public void setResaltardireccion_direccionCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltardireccion_direccionCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrardireccion_direccionCobrarClientesPorRegion() {
		return this.mostrardireccion_direccionCobrarClientesPorRegion;
	}

	public void setMostrardireccion_direccionCobrarClientesPorRegion(Boolean mostrardireccion_direccionCobrarClientesPorRegion) {
		this.mostrardireccion_direccionCobrarClientesPorRegion= mostrardireccion_direccionCobrarClientesPorRegion;
	}

	public Boolean getActivardireccion_direccionCobrarClientesPorRegion() {
		return this.activardireccion_direccionCobrarClientesPorRegion;
	}

	public void setActivardireccion_direccionCobrarClientesPorRegion(Boolean activardireccion_direccionCobrarClientesPorRegion) {
		this.activardireccion_direccionCobrarClientesPorRegion= activardireccion_direccionCobrarClientesPorRegion;
	}

	public Border setResaltartelefono_telefonoCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesporregionBeanSwingJInternalFrame.jTtoolBarCobrarClientesPorRegion.setBorder(borderResaltar);
		
		this.resaltartelefono_telefonoCobrarClientesPorRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_telefonoCobrarClientesPorRegion() {
		return this.resaltartelefono_telefonoCobrarClientesPorRegion;
	}

	public void setResaltartelefono_telefonoCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltartelefono_telefonoCobrarClientesPorRegion= borderResaltar;
	}

	public Boolean getMostrartelefono_telefonoCobrarClientesPorRegion() {
		return this.mostrartelefono_telefonoCobrarClientesPorRegion;
	}

	public void setMostrartelefono_telefonoCobrarClientesPorRegion(Boolean mostrartelefono_telefonoCobrarClientesPorRegion) {
		this.mostrartelefono_telefonoCobrarClientesPorRegion= mostrartelefono_telefonoCobrarClientesPorRegion;
	}

	public Boolean getActivartelefono_telefonoCobrarClientesPorRegion() {
		return this.activartelefono_telefonoCobrarClientesPorRegion;
	}

	public void setActivartelefono_telefonoCobrarClientesPorRegion(Boolean activartelefono_telefonoCobrarClientesPorRegion) {
		this.activartelefono_telefonoCobrarClientesPorRegion= activartelefono_telefonoCobrarClientesPorRegion;
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
		
		
		this.setMostraridCobrarClientesPorRegion(esInicial);
		this.setMostrarid_empresaCobrarClientesPorRegion(esInicial);
		this.setMostrarid_sucursalCobrarClientesPorRegion(esInicial);
		this.setMostrarid_paisCobrarClientesPorRegion(esInicial);
		this.setMostrarid_regionCobrarClientesPorRegion(esInicial);
		this.setMostrarid_provinciaCobrarClientesPorRegion(esInicial);
		this.setMostrarid_ciudadCobrarClientesPorRegion(esInicial);
		this.setMostrarnombre_regionCobrarClientesPorRegion(esInicial);
		this.setMostrarnombre_provinciaCobrarClientesPorRegion(esInicial);
		this.setMostrarnombre_ciudadCobrarClientesPorRegion(esInicial);
		this.setMostrarnombre_zonaCobrarClientesPorRegion(esInicial);
		this.setMostrarnombre_rutaCobrarClientesPorRegion(esInicial);
		this.setMostrarnombre_vendedorCobrarClientesPorRegion(esInicial);
		this.setMostrarcodigoCobrarClientesPorRegion(esInicial);
		this.setMostrarnombreCobrarClientesPorRegion(esInicial);
		this.setMostrarapellidoCobrarClientesPorRegion(esInicial);
		this.setMostrardireccion_direccionCobrarClientesPorRegion(esInicial);
		this.setMostrartelefono_telefonoCobrarClientesPorRegion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.ID)) {
				this.setMostraridCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDREGION)) {
				this.setMostrarid_regionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREREGION)) {
				this.setMostrarnombre_regionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA)) {
				this.setMostrarnombre_provinciaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA)) {
				this.setMostrarnombre_rutaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setMostrardireccion_direccionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO)) {
				this.setMostrartelefono_telefonoCobrarClientesPorRegion(esAsigna);
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
		
		
		this.setActivaridCobrarClientesPorRegion(esInicial);
		this.setActivarid_empresaCobrarClientesPorRegion(esInicial);
		this.setActivarid_sucursalCobrarClientesPorRegion(esInicial);
		this.setActivarid_paisCobrarClientesPorRegion(esInicial);
		this.setActivarid_regionCobrarClientesPorRegion(esInicial);
		this.setActivarid_provinciaCobrarClientesPorRegion(esInicial);
		this.setActivarid_ciudadCobrarClientesPorRegion(esInicial);
		this.setActivarnombre_regionCobrarClientesPorRegion(esInicial);
		this.setActivarnombre_provinciaCobrarClientesPorRegion(esInicial);
		this.setActivarnombre_ciudadCobrarClientesPorRegion(esInicial);
		this.setActivarnombre_zonaCobrarClientesPorRegion(esInicial);
		this.setActivarnombre_rutaCobrarClientesPorRegion(esInicial);
		this.setActivarnombre_vendedorCobrarClientesPorRegion(esInicial);
		this.setActivarcodigoCobrarClientesPorRegion(esInicial);
		this.setActivarnombreCobrarClientesPorRegion(esInicial);
		this.setActivarapellidoCobrarClientesPorRegion(esInicial);
		this.setActivardireccion_direccionCobrarClientesPorRegion(esInicial);
		this.setActivartelefono_telefonoCobrarClientesPorRegion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.ID)) {
				this.setActivaridCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDREGION)) {
				this.setActivarid_regionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREREGION)) {
				this.setActivarnombre_regionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA)) {
				this.setActivarnombre_provinciaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA)) {
				this.setActivarnombre_rutaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setActivardireccion_direccionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO)) {
				this.setActivartelefono_telefonoCobrarClientesPorRegion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarClientesPorRegion(esInicial);
		this.setResaltarid_empresaCobrarClientesPorRegion(esInicial);
		this.setResaltarid_sucursalCobrarClientesPorRegion(esInicial);
		this.setResaltarid_paisCobrarClientesPorRegion(esInicial);
		this.setResaltarid_regionCobrarClientesPorRegion(esInicial);
		this.setResaltarid_provinciaCobrarClientesPorRegion(esInicial);
		this.setResaltarid_ciudadCobrarClientesPorRegion(esInicial);
		this.setResaltarnombre_regionCobrarClientesPorRegion(esInicial);
		this.setResaltarnombre_provinciaCobrarClientesPorRegion(esInicial);
		this.setResaltarnombre_ciudadCobrarClientesPorRegion(esInicial);
		this.setResaltarnombre_zonaCobrarClientesPorRegion(esInicial);
		this.setResaltarnombre_rutaCobrarClientesPorRegion(esInicial);
		this.setResaltarnombre_vendedorCobrarClientesPorRegion(esInicial);
		this.setResaltarcodigoCobrarClientesPorRegion(esInicial);
		this.setResaltarnombreCobrarClientesPorRegion(esInicial);
		this.setResaltarapellidoCobrarClientesPorRegion(esInicial);
		this.setResaltardireccion_direccionCobrarClientesPorRegion(esInicial);
		this.setResaltartelefono_telefonoCobrarClientesPorRegion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.ID)) {
				this.setResaltaridCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDREGION)) {
				this.setResaltarid_regionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREREGION)) {
				this.setResaltarnombre_regionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREPROVINCIA)) {
				this.setResaltarnombre_provinciaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRERUTA)) {
				this.setResaltarnombre_rutaCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setResaltardireccion_direccionCobrarClientesPorRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesPorRegionConstantesFunciones.TELEFONOTELEFONO)) {
				this.setResaltartelefono_telefonoCobrarClientesPorRegion(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion=true;

	public Boolean getMostrarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion() {
		return this.mostrarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion;
	}

	public void setMostrarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion=true;

	public Boolean getActivarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion() {
		return this.activarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion;
	}

	public void setActivarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion=null;

	public Border getResaltarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion() {
		return this.resaltarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion;
	}

	public void setResaltarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion(Border borderResaltar) {
		this.resaltarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion= borderResaltar;
	}

	public void setResaltarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesPorRegionBeanSwingJInternalFrame cobrarclientesporregionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarClientesPorRegionCobrarClientesPorRegion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}