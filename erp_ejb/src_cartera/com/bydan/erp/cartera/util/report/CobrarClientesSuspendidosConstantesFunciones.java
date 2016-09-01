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


import com.bydan.erp.cartera.util.report.CobrarClientesSuspendidosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarClientesSuspendidosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesSuspendidosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarClientesSuspendidosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarClientesSuspendidos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarClientesSuspendidos"+CobrarClientesSuspendidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarClientesSuspendidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarClientesSuspendidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"_"+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesSuspendidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"_"+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"_"+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesSuspendidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"_"+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesSuspendidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesSuspendidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesSuspendidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarClientesSuspendidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarClientesSuspendidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarClientesSuspendidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarClientesSuspendidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Clientes Suspendidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Clientes Suspendidos";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Clientes Suspendidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarClientesSuspendidos";
	public static final String OBJECTNAME="cobrarclientessuspendidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_clientes_suspendidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarclientessuspendidos from "+CobrarClientesSuspendidosConstantesFunciones.SPERSISTENCENAME+" cobrarclientessuspendidos";
	public static String QUERYSELECTNATIVE="select "+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".id,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".version_row,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".nombre_ciudad,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".codigo,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".nombre_completo,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".nombre_comercial,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".ruc,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".detalle_estado,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".direccion_direccion,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".telefono_telefono,"+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME+".saldo from "+CobrarClientesSuspendidosConstantesFunciones.SCHEMA+"."+CobrarClientesSuspendidosConstantesFunciones.TABLENAME;//+" as "+CobrarClientesSuspendidosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBRECOMERCIAL= "nombre_comercial";
    public static final String RUC= "ruc";
    public static final String DETALLEESTADO= "detalle_estado";
    public static final String DIRECCIONDIRECCION= "direccion_direccion";
    public static final String TELEFONOTELEFONO= "telefono_telefono";
    public static final String SALDO= "saldo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "id Empresa";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NOMBRECOMERCIAL= "Nombre Comercial";
		public static final String LABEL_NOMBRECOMERCIAL_LOWER= "Nombre Comercial";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_DETALLEESTADO= "Detalle Estado";
		public static final String LABEL_DETALLEESTADO_LOWER= "Detalle Estado";
    	public static final String LABEL_DIRECCIONDIRECCION= "Direccion Direccion";
		public static final String LABEL_DIRECCIONDIRECCION_LOWER= "Direccion Direccion";
    	public static final String LABEL_TELEFONOTELEFONO= "Telefono Telefono";
		public static final String LABEL_TELEFONOTELEFONO_LOWER= "Telefono Telefono";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
	
		
		
		
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMERCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE_ESTADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE_ESTADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_DIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_TELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_TELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getCobrarClientesSuspendidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMERCIAL;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.RUC)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_DETALLEESTADO;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_DIRECCIONDIRECCION;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_TELEFONOTELEFONO;}
		if(sNombreColumna.equals(CobrarClientesSuspendidosConstantesFunciones.SALDO)) {sLabelColumna=CobrarClientesSuspendidosConstantesFunciones.LABEL_SALDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarClientesSuspendidosDescripcion(CobrarClientesSuspendidos cobrarclientessuspendidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarclientessuspendidos !=null/* && cobrarclientessuspendidos.getId()!=0*/) {
			sDescripcion=cobrarclientessuspendidos.getcodigo();//cobrarclientessuspendidoscobrarclientessuspendidos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarClientesSuspendidosDescripcionDetallado(CobrarClientesSuspendidos cobrarclientessuspendidos) {
		String sDescripcion="";
			
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.ID+"=";
		sDescripcion+=cobrarclientessuspendidos.getId().toString()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarclientessuspendidos.getVersionRow().toString()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarclientessuspendidos.getid_empresa().toString()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=cobrarclientessuspendidos.getnombre_ciudad()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarclientessuspendidos.getcodigo()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cobrarclientessuspendidos.getnombre_completo()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL+"=";
		sDescripcion+=cobrarclientessuspendidos.getnombre_comercial()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.RUC+"=";
		sDescripcion+=cobrarclientessuspendidos.getruc()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO+"=";
		sDescripcion+=cobrarclientessuspendidos.getdetalle_estado()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION+"=";
		sDescripcion+=cobrarclientessuspendidos.getdireccion_direccion()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO+"=";
		sDescripcion+=cobrarclientessuspendidos.gettelefono_telefono()+",";
		sDescripcion+=CobrarClientesSuspendidosConstantesFunciones.SALDO+"=";
		sDescripcion+=cobrarclientessuspendidos.getsaldo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarClientesSuspendidosDescripcion(CobrarClientesSuspendidos cobrarclientessuspendidos,String sValor) throws Exception {			
		if(cobrarclientessuspendidos !=null) {
			cobrarclientessuspendidos.setcodigo(sValor);;//cobrarclientessuspendidoscobrarclientessuspendidos.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarClientesSuspendidos")) {
			sNombreIndice="Tipo=  Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarClientesSuspendidos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarClientesSuspendidos(CobrarClientesSuspendidos cobrarclientessuspendidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientessuspendidos.setnombre_ciudad(cobrarclientessuspendidos.getnombre_ciudad().trim());
		cobrarclientessuspendidos.setcodigo(cobrarclientessuspendidos.getcodigo().trim());
		cobrarclientessuspendidos.setnombre_completo(cobrarclientessuspendidos.getnombre_completo().trim());
		cobrarclientessuspendidos.setnombre_comercial(cobrarclientessuspendidos.getnombre_comercial().trim());
		cobrarclientessuspendidos.setruc(cobrarclientessuspendidos.getruc().trim());
		cobrarclientessuspendidos.setdetalle_estado(cobrarclientessuspendidos.getdetalle_estado().trim());
		cobrarclientessuspendidos.setdireccion_direccion(cobrarclientessuspendidos.getdireccion_direccion().trim());
		cobrarclientessuspendidos.settelefono_telefono(cobrarclientessuspendidos.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarClientesSuspendidoss(List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesSuspendidos cobrarclientessuspendidos: cobrarclientessuspendidoss) {
			cobrarclientessuspendidos.setnombre_ciudad(cobrarclientessuspendidos.getnombre_ciudad().trim());
			cobrarclientessuspendidos.setcodigo(cobrarclientessuspendidos.getcodigo().trim());
			cobrarclientessuspendidos.setnombre_completo(cobrarclientessuspendidos.getnombre_completo().trim());
			cobrarclientessuspendidos.setnombre_comercial(cobrarclientessuspendidos.getnombre_comercial().trim());
			cobrarclientessuspendidos.setruc(cobrarclientessuspendidos.getruc().trim());
			cobrarclientessuspendidos.setdetalle_estado(cobrarclientessuspendidos.getdetalle_estado().trim());
			cobrarclientessuspendidos.setdireccion_direccion(cobrarclientessuspendidos.getdireccion_direccion().trim());
			cobrarclientessuspendidos.settelefono_telefono(cobrarclientessuspendidos.gettelefono_telefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesSuspendidos(CobrarClientesSuspendidos cobrarclientessuspendidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarclientessuspendidos.getConCambioAuxiliar()) {
			cobrarclientessuspendidos.setIsDeleted(cobrarclientessuspendidos.getIsDeletedAuxiliar());	
			cobrarclientessuspendidos.setIsNew(cobrarclientessuspendidos.getIsNewAuxiliar());	
			cobrarclientessuspendidos.setIsChanged(cobrarclientessuspendidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarclientessuspendidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarclientessuspendidos.setIsDeletedAuxiliar(false);	
			cobrarclientessuspendidos.setIsNewAuxiliar(false);	
			cobrarclientessuspendidos.setIsChangedAuxiliar(false);
			
			cobrarclientessuspendidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesSuspendidoss(List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarClientesSuspendidos cobrarclientessuspendidos : cobrarclientessuspendidoss) {
			if(conAsignarBase && cobrarclientessuspendidos.getConCambioAuxiliar()) {
				cobrarclientessuspendidos.setIsDeleted(cobrarclientessuspendidos.getIsDeletedAuxiliar());	
				cobrarclientessuspendidos.setIsNew(cobrarclientessuspendidos.getIsNewAuxiliar());	
				cobrarclientessuspendidos.setIsChanged(cobrarclientessuspendidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarclientessuspendidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarclientessuspendidos.setIsDeletedAuxiliar(false);	
				cobrarclientessuspendidos.setIsNewAuxiliar(false);	
				cobrarclientessuspendidos.setIsChangedAuxiliar(false);
				
				cobrarclientessuspendidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarClientesSuspendidos(CobrarClientesSuspendidos cobrarclientessuspendidos,Boolean conEnteros) throws Exception  {
		cobrarclientessuspendidos.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarClientesSuspendidoss(List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,Boolean conEnteros) throws Exception  {
		
		for(CobrarClientesSuspendidos cobrarclientessuspendidos: cobrarclientessuspendidoss) {
			cobrarclientessuspendidos.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarClientesSuspendidos(List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,CobrarClientesSuspendidos cobrarclientessuspendidosAux) throws Exception  {
		CobrarClientesSuspendidosConstantesFunciones.InicializarValoresCobrarClientesSuspendidos(cobrarclientessuspendidosAux,true);
		
		for(CobrarClientesSuspendidos cobrarclientessuspendidos: cobrarclientessuspendidoss) {
			if(cobrarclientessuspendidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarclientessuspendidosAux.setsaldo(cobrarclientessuspendidosAux.getsaldo()+cobrarclientessuspendidos.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesSuspendidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarClientesSuspendidosConstantesFunciones.getArrayColumnasGlobalesCobrarClientesSuspendidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesSuspendidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarClientesSuspendidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,CobrarClientesSuspendidos cobrarclientessuspendidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesSuspendidos cobrarclientessuspendidosAux: cobrarclientessuspendidoss) {
			if(cobrarclientessuspendidosAux!=null && cobrarclientessuspendidos!=null) {
				if((cobrarclientessuspendidosAux.getId()==null && cobrarclientessuspendidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarclientessuspendidosAux.getId()!=null && cobrarclientessuspendidos.getId()!=null){
					if(cobrarclientessuspendidosAux.getId().equals(cobrarclientessuspendidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesSuspendidos(List<CobrarClientesSuspendidos> cobrarclientessuspendidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
	
		for(CobrarClientesSuspendidos cobrarclientessuspendidos: cobrarclientessuspendidoss) {			
			if(cobrarclientessuspendidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoTotal+=cobrarclientessuspendidos.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarClientesSuspendidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_VERSIONROW, CobrarClientesSuspendidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECIUDAD, CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_CODIGO, CobrarClientesSuspendidosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMPLETO, CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMERCIAL, CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_RUC, CobrarClientesSuspendidosConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_DETALLEESTADO, CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_DIRECCIONDIRECCION, CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_TELEFONOTELEFONO, CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesSuspendidosConstantesFunciones.LABEL_SALDO, CobrarClientesSuspendidosConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarClientesSuspendidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesSuspendidosConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesSuspendidos() throws Exception  {
		return CobrarClientesSuspendidosConstantesFunciones.getTiposSeleccionarCobrarClientesSuspendidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesSuspendidos(Boolean conFk) throws Exception  {
		return CobrarClientesSuspendidosConstantesFunciones.getTiposSeleccionarCobrarClientesSuspendidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesSuspendidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMERCIAL);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMERCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_DETALLEESTADO);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_DETALLEESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_DIRECCIONDIRECCION);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_DIRECCIONDIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_TELEFONOTELEFONO);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_TELEFONOTELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesSuspendidosConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(CobrarClientesSuspendidosConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarClientesSuspendidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesSuspendidos(CobrarClientesSuspendidos cobrarclientessuspendidosAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesSuspendidos(List<CobrarClientesSuspendidos> cobrarclientessuspendidossTemp) throws Exception {
		for(CobrarClientesSuspendidos cobrarclientessuspendidosAux:cobrarclientessuspendidossTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarClientesSuspendidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarClientesSuspendidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesSuspendidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesSuspendidosConstantesFunciones.getClassesRelationshipsOfCobrarClientesSuspendidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesSuspendidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesSuspendidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesSuspendidosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarClientesSuspendidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesSuspendidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarClientesSuspendidos cobrarclientessuspendidos,List<CobrarClientesSuspendidos> cobrarclientessuspendidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarClientesSuspendidos cobrarclientessuspendidos,List<CobrarClientesSuspendidos> cobrarclientessuspendidoss) throws Exception {
		try	{			
			for(CobrarClientesSuspendidos cobrarclientessuspendidosLocal:cobrarclientessuspendidoss) {
				if(cobrarclientessuspendidosLocal.getId().equals(cobrarclientessuspendidos.getId())) {
					cobrarclientessuspendidosLocal.setIsSelected(cobrarclientessuspendidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarClientesSuspendidos(List<CobrarClientesSuspendidos> cobrarclientessuspendidossAux) throws Exception {
		//this.cobrarclientessuspendidossAux=cobrarclientessuspendidossAux;
		
		for(CobrarClientesSuspendidos cobrarclientessuspendidosAux:cobrarclientessuspendidossAux) {
			if(cobrarclientessuspendidosAux.getIsChanged()) {
				cobrarclientessuspendidosAux.setIsChanged(false);
			}		
			
			if(cobrarclientessuspendidosAux.getIsNew()) {
				cobrarclientessuspendidosAux.setIsNew(false);
			}	
			
			if(cobrarclientessuspendidosAux.getIsDeleted()) {
				cobrarclientessuspendidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarClientesSuspendidos(CobrarClientesSuspendidos cobrarclientessuspendidosAux) throws Exception {
		//this.cobrarclientessuspendidosAux=cobrarclientessuspendidosAux;
		
			if(cobrarclientessuspendidosAux.getIsChanged()) {
				cobrarclientessuspendidosAux.setIsChanged(false);
			}		
			
			if(cobrarclientessuspendidosAux.getIsNew()) {
				cobrarclientessuspendidosAux.setIsNew(false);
			}	
			
			if(cobrarclientessuspendidosAux.getIsDeleted()) {
				cobrarclientessuspendidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarClientesSuspendidos cobrarclientessuspendidosAsignar,CobrarClientesSuspendidos cobrarclientessuspendidos) throws Exception {
		cobrarclientessuspendidosAsignar.setVersionRow(cobrarclientessuspendidos.getVersionRow());	
		cobrarclientessuspendidosAsignar.setnombre_ciudad(cobrarclientessuspendidos.getnombre_ciudad());	
		cobrarclientessuspendidosAsignar.setcodigo(cobrarclientessuspendidos.getcodigo());	
		cobrarclientessuspendidosAsignar.setnombre_completo(cobrarclientessuspendidos.getnombre_completo());	
		cobrarclientessuspendidosAsignar.setnombre_comercial(cobrarclientessuspendidos.getnombre_comercial());	
		cobrarclientessuspendidosAsignar.setruc(cobrarclientessuspendidos.getruc());	
		cobrarclientessuspendidosAsignar.setdetalle_estado(cobrarclientessuspendidos.getdetalle_estado());	
		cobrarclientessuspendidosAsignar.setdireccion_direccion(cobrarclientessuspendidos.getdireccion_direccion());	
		cobrarclientessuspendidosAsignar.settelefono_telefono(cobrarclientessuspendidos.gettelefono_telefono());	
		cobrarclientessuspendidosAsignar.setsaldo(cobrarclientessuspendidos.getsaldo());	
	}
	
	public static void inicializarCobrarClientesSuspendidos(CobrarClientesSuspendidos cobrarclientessuspendidos) throws Exception {
		try {
					
				cobrarclientessuspendidos.setnombre_ciudad("");	
				cobrarclientessuspendidos.setcodigo("");	
				cobrarclientessuspendidos.setnombre_completo("");	
				cobrarclientessuspendidos.setnombre_comercial("");	
				cobrarclientessuspendidos.setruc("");	
				cobrarclientessuspendidos.setdetalle_estado("");	
				cobrarclientessuspendidos.setdireccion_direccion("");	
				cobrarclientessuspendidos.settelefono_telefono("");	
				cobrarclientessuspendidos.setsaldo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarClientesSuspendidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_NOMBRECOMERCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_DETALLEESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_DIRECCIONDIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_TELEFONOTELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesSuspendidosConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarClientesSuspendidos(String sTipo,Row row,Workbook workbook,CobrarClientesSuspendidos cobrarclientessuspendidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getid_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getnombre_comercial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getdetalle_estado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getdireccion_direccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.gettelefono_telefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientessuspendidos.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarClientesSuspendidos="";
	
	public String getsFinalQueryCobrarClientesSuspendidos() {
		return this.sFinalQueryCobrarClientesSuspendidos;
	}
	
	public void setsFinalQueryCobrarClientesSuspendidos(String sFinalQueryCobrarClientesSuspendidos) {
		this.sFinalQueryCobrarClientesSuspendidos= sFinalQueryCobrarClientesSuspendidos;
	}
	
	public Border resaltarSeleccionarCobrarClientesSuspendidos=null;
	
	public Border setResaltarSeleccionarCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarClientesSuspendidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarClientesSuspendidos() {
		return this.resaltarSeleccionarCobrarClientesSuspendidos;
	}
	
	public void setResaltarSeleccionarCobrarClientesSuspendidos(Border borderResaltarSeleccionarCobrarClientesSuspendidos) {
		this.resaltarSeleccionarCobrarClientesSuspendidos= borderResaltarSeleccionarCobrarClientesSuspendidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarClientesSuspendidos=null;
	public Boolean mostraridCobrarClientesSuspendidos=true;
	public Boolean activaridCobrarClientesSuspendidos=true;

	public Border resaltarid_empresaCobrarClientesSuspendidos=null;
	public Boolean mostrarid_empresaCobrarClientesSuspendidos=true;
	public Boolean activarid_empresaCobrarClientesSuspendidos=true;

	public Border resaltarnombre_ciudadCobrarClientesSuspendidos=null;
	public Boolean mostrarnombre_ciudadCobrarClientesSuspendidos=true;
	public Boolean activarnombre_ciudadCobrarClientesSuspendidos=true;

	public Border resaltarcodigoCobrarClientesSuspendidos=null;
	public Boolean mostrarcodigoCobrarClientesSuspendidos=true;
	public Boolean activarcodigoCobrarClientesSuspendidos=true;

	public Border resaltarnombre_completoCobrarClientesSuspendidos=null;
	public Boolean mostrarnombre_completoCobrarClientesSuspendidos=true;
	public Boolean activarnombre_completoCobrarClientesSuspendidos=true;

	public Border resaltarnombre_comercialCobrarClientesSuspendidos=null;
	public Boolean mostrarnombre_comercialCobrarClientesSuspendidos=true;
	public Boolean activarnombre_comercialCobrarClientesSuspendidos=true;

	public Border resaltarrucCobrarClientesSuspendidos=null;
	public Boolean mostrarrucCobrarClientesSuspendidos=true;
	public Boolean activarrucCobrarClientesSuspendidos=true;

	public Border resaltardetalle_estadoCobrarClientesSuspendidos=null;
	public Boolean mostrardetalle_estadoCobrarClientesSuspendidos=true;
	public Boolean activardetalle_estadoCobrarClientesSuspendidos=true;

	public Border resaltardireccion_direccionCobrarClientesSuspendidos=null;
	public Boolean mostrardireccion_direccionCobrarClientesSuspendidos=true;
	public Boolean activardireccion_direccionCobrarClientesSuspendidos=true;

	public Border resaltartelefono_telefonoCobrarClientesSuspendidos=null;
	public Boolean mostrartelefono_telefonoCobrarClientesSuspendidos=true;
	public Boolean activartelefono_telefonoCobrarClientesSuspendidos=true;

	public Border resaltarsaldoCobrarClientesSuspendidos=null;
	public Boolean mostrarsaldoCobrarClientesSuspendidos=true;
	public Boolean activarsaldoCobrarClientesSuspendidos=true;

	
	

	public Border setResaltaridCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltaridCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarClientesSuspendidos() {
		return this.resaltaridCobrarClientesSuspendidos;
	}

	public void setResaltaridCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltaridCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostraridCobrarClientesSuspendidos() {
		return this.mostraridCobrarClientesSuspendidos;
	}

	public void setMostraridCobrarClientesSuspendidos(Boolean mostraridCobrarClientesSuspendidos) {
		this.mostraridCobrarClientesSuspendidos= mostraridCobrarClientesSuspendidos;
	}

	public Boolean getActivaridCobrarClientesSuspendidos() {
		return this.activaridCobrarClientesSuspendidos;
	}

	public void setActivaridCobrarClientesSuspendidos(Boolean activaridCobrarClientesSuspendidos) {
		this.activaridCobrarClientesSuspendidos= activaridCobrarClientesSuspendidos;
	}

	public Border setResaltarid_empresaCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarClientesSuspendidos() {
		return this.resaltarid_empresaCobrarClientesSuspendidos;
	}

	public void setResaltarid_empresaCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarid_empresaCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarClientesSuspendidos() {
		return this.mostrarid_empresaCobrarClientesSuspendidos;
	}

	public void setMostrarid_empresaCobrarClientesSuspendidos(Boolean mostrarid_empresaCobrarClientesSuspendidos) {
		this.mostrarid_empresaCobrarClientesSuspendidos= mostrarid_empresaCobrarClientesSuspendidos;
	}

	public Boolean getActivarid_empresaCobrarClientesSuspendidos() {
		return this.activarid_empresaCobrarClientesSuspendidos;
	}

	public void setActivarid_empresaCobrarClientesSuspendidos(Boolean activarid_empresaCobrarClientesSuspendidos) {
		this.activarid_empresaCobrarClientesSuspendidos= activarid_empresaCobrarClientesSuspendidos;
	}

	public Border setResaltarnombre_ciudadCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadCobrarClientesSuspendidos() {
		return this.resaltarnombre_ciudadCobrarClientesSuspendidos;
	}

	public void setResaltarnombre_ciudadCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarnombre_ciudadCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadCobrarClientesSuspendidos() {
		return this.mostrarnombre_ciudadCobrarClientesSuspendidos;
	}

	public void setMostrarnombre_ciudadCobrarClientesSuspendidos(Boolean mostrarnombre_ciudadCobrarClientesSuspendidos) {
		this.mostrarnombre_ciudadCobrarClientesSuspendidos= mostrarnombre_ciudadCobrarClientesSuspendidos;
	}

	public Boolean getActivarnombre_ciudadCobrarClientesSuspendidos() {
		return this.activarnombre_ciudadCobrarClientesSuspendidos;
	}

	public void setActivarnombre_ciudadCobrarClientesSuspendidos(Boolean activarnombre_ciudadCobrarClientesSuspendidos) {
		this.activarnombre_ciudadCobrarClientesSuspendidos= activarnombre_ciudadCobrarClientesSuspendidos;
	}

	public Border setResaltarcodigoCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarClientesSuspendidos() {
		return this.resaltarcodigoCobrarClientesSuspendidos;
	}

	public void setResaltarcodigoCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarcodigoCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarClientesSuspendidos() {
		return this.mostrarcodigoCobrarClientesSuspendidos;
	}

	public void setMostrarcodigoCobrarClientesSuspendidos(Boolean mostrarcodigoCobrarClientesSuspendidos) {
		this.mostrarcodigoCobrarClientesSuspendidos= mostrarcodigoCobrarClientesSuspendidos;
	}

	public Boolean getActivarcodigoCobrarClientesSuspendidos() {
		return this.activarcodigoCobrarClientesSuspendidos;
	}

	public void setActivarcodigoCobrarClientesSuspendidos(Boolean activarcodigoCobrarClientesSuspendidos) {
		this.activarcodigoCobrarClientesSuspendidos= activarcodigoCobrarClientesSuspendidos;
	}

	public Border setResaltarnombre_completoCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCobrarClientesSuspendidos() {
		return this.resaltarnombre_completoCobrarClientesSuspendidos;
	}

	public void setResaltarnombre_completoCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarnombre_completoCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCobrarClientesSuspendidos() {
		return this.mostrarnombre_completoCobrarClientesSuspendidos;
	}

	public void setMostrarnombre_completoCobrarClientesSuspendidos(Boolean mostrarnombre_completoCobrarClientesSuspendidos) {
		this.mostrarnombre_completoCobrarClientesSuspendidos= mostrarnombre_completoCobrarClientesSuspendidos;
	}

	public Boolean getActivarnombre_completoCobrarClientesSuspendidos() {
		return this.activarnombre_completoCobrarClientesSuspendidos;
	}

	public void setActivarnombre_completoCobrarClientesSuspendidos(Boolean activarnombre_completoCobrarClientesSuspendidos) {
		this.activarnombre_completoCobrarClientesSuspendidos= activarnombre_completoCobrarClientesSuspendidos;
	}

	public Border setResaltarnombre_comercialCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarnombre_comercialCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_comercialCobrarClientesSuspendidos() {
		return this.resaltarnombre_comercialCobrarClientesSuspendidos;
	}

	public void setResaltarnombre_comercialCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarnombre_comercialCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrarnombre_comercialCobrarClientesSuspendidos() {
		return this.mostrarnombre_comercialCobrarClientesSuspendidos;
	}

	public void setMostrarnombre_comercialCobrarClientesSuspendidos(Boolean mostrarnombre_comercialCobrarClientesSuspendidos) {
		this.mostrarnombre_comercialCobrarClientesSuspendidos= mostrarnombre_comercialCobrarClientesSuspendidos;
	}

	public Boolean getActivarnombre_comercialCobrarClientesSuspendidos() {
		return this.activarnombre_comercialCobrarClientesSuspendidos;
	}

	public void setActivarnombre_comercialCobrarClientesSuspendidos(Boolean activarnombre_comercialCobrarClientesSuspendidos) {
		this.activarnombre_comercialCobrarClientesSuspendidos= activarnombre_comercialCobrarClientesSuspendidos;
	}

	public Border setResaltarrucCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarrucCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucCobrarClientesSuspendidos() {
		return this.resaltarrucCobrarClientesSuspendidos;
	}

	public void setResaltarrucCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarrucCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrarrucCobrarClientesSuspendidos() {
		return this.mostrarrucCobrarClientesSuspendidos;
	}

	public void setMostrarrucCobrarClientesSuspendidos(Boolean mostrarrucCobrarClientesSuspendidos) {
		this.mostrarrucCobrarClientesSuspendidos= mostrarrucCobrarClientesSuspendidos;
	}

	public Boolean getActivarrucCobrarClientesSuspendidos() {
		return this.activarrucCobrarClientesSuspendidos;
	}

	public void setActivarrucCobrarClientesSuspendidos(Boolean activarrucCobrarClientesSuspendidos) {
		this.activarrucCobrarClientesSuspendidos= activarrucCobrarClientesSuspendidos;
	}

	public Border setResaltardetalle_estadoCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltardetalle_estadoCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalle_estadoCobrarClientesSuspendidos() {
		return this.resaltardetalle_estadoCobrarClientesSuspendidos;
	}

	public void setResaltardetalle_estadoCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltardetalle_estadoCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrardetalle_estadoCobrarClientesSuspendidos() {
		return this.mostrardetalle_estadoCobrarClientesSuspendidos;
	}

	public void setMostrardetalle_estadoCobrarClientesSuspendidos(Boolean mostrardetalle_estadoCobrarClientesSuspendidos) {
		this.mostrardetalle_estadoCobrarClientesSuspendidos= mostrardetalle_estadoCobrarClientesSuspendidos;
	}

	public Boolean getActivardetalle_estadoCobrarClientesSuspendidos() {
		return this.activardetalle_estadoCobrarClientesSuspendidos;
	}

	public void setActivardetalle_estadoCobrarClientesSuspendidos(Boolean activardetalle_estadoCobrarClientesSuspendidos) {
		this.activardetalle_estadoCobrarClientesSuspendidos= activardetalle_estadoCobrarClientesSuspendidos;
	}

	public Border setResaltardireccion_direccionCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltardireccion_direccionCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_direccionCobrarClientesSuspendidos() {
		return this.resaltardireccion_direccionCobrarClientesSuspendidos;
	}

	public void setResaltardireccion_direccionCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltardireccion_direccionCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrardireccion_direccionCobrarClientesSuspendidos() {
		return this.mostrardireccion_direccionCobrarClientesSuspendidos;
	}

	public void setMostrardireccion_direccionCobrarClientesSuspendidos(Boolean mostrardireccion_direccionCobrarClientesSuspendidos) {
		this.mostrardireccion_direccionCobrarClientesSuspendidos= mostrardireccion_direccionCobrarClientesSuspendidos;
	}

	public Boolean getActivardireccion_direccionCobrarClientesSuspendidos() {
		return this.activardireccion_direccionCobrarClientesSuspendidos;
	}

	public void setActivardireccion_direccionCobrarClientesSuspendidos(Boolean activardireccion_direccionCobrarClientesSuspendidos) {
		this.activardireccion_direccionCobrarClientesSuspendidos= activardireccion_direccionCobrarClientesSuspendidos;
	}

	public Border setResaltartelefono_telefonoCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltartelefono_telefonoCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_telefonoCobrarClientesSuspendidos() {
		return this.resaltartelefono_telefonoCobrarClientesSuspendidos;
	}

	public void setResaltartelefono_telefonoCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltartelefono_telefonoCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrartelefono_telefonoCobrarClientesSuspendidos() {
		return this.mostrartelefono_telefonoCobrarClientesSuspendidos;
	}

	public void setMostrartelefono_telefonoCobrarClientesSuspendidos(Boolean mostrartelefono_telefonoCobrarClientesSuspendidos) {
		this.mostrartelefono_telefonoCobrarClientesSuspendidos= mostrartelefono_telefonoCobrarClientesSuspendidos;
	}

	public Boolean getActivartelefono_telefonoCobrarClientesSuspendidos() {
		return this.activartelefono_telefonoCobrarClientesSuspendidos;
	}

	public void setActivartelefono_telefonoCobrarClientesSuspendidos(Boolean activartelefono_telefonoCobrarClientesSuspendidos) {
		this.activartelefono_telefonoCobrarClientesSuspendidos= activartelefono_telefonoCobrarClientesSuspendidos;
	}

	public Border setResaltarsaldoCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientessuspendidosBeanSwingJInternalFrame.jTtoolBarCobrarClientesSuspendidos.setBorder(borderResaltar);
		
		this.resaltarsaldoCobrarClientesSuspendidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoCobrarClientesSuspendidos() {
		return this.resaltarsaldoCobrarClientesSuspendidos;
	}

	public void setResaltarsaldoCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarsaldoCobrarClientesSuspendidos= borderResaltar;
	}

	public Boolean getMostrarsaldoCobrarClientesSuspendidos() {
		return this.mostrarsaldoCobrarClientesSuspendidos;
	}

	public void setMostrarsaldoCobrarClientesSuspendidos(Boolean mostrarsaldoCobrarClientesSuspendidos) {
		this.mostrarsaldoCobrarClientesSuspendidos= mostrarsaldoCobrarClientesSuspendidos;
	}

	public Boolean getActivarsaldoCobrarClientesSuspendidos() {
		return this.activarsaldoCobrarClientesSuspendidos;
	}

	public void setActivarsaldoCobrarClientesSuspendidos(Boolean activarsaldoCobrarClientesSuspendidos) {
		this.activarsaldoCobrarClientesSuspendidos= activarsaldoCobrarClientesSuspendidos;
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
		
		
		this.setMostraridCobrarClientesSuspendidos(esInicial);
		this.setMostrarid_empresaCobrarClientesSuspendidos(esInicial);
		this.setMostrarnombre_ciudadCobrarClientesSuspendidos(esInicial);
		this.setMostrarcodigoCobrarClientesSuspendidos(esInicial);
		this.setMostrarnombre_completoCobrarClientesSuspendidos(esInicial);
		this.setMostrarnombre_comercialCobrarClientesSuspendidos(esInicial);
		this.setMostrarrucCobrarClientesSuspendidos(esInicial);
		this.setMostrardetalle_estadoCobrarClientesSuspendidos(esInicial);
		this.setMostrardireccion_direccionCobrarClientesSuspendidos(esInicial);
		this.setMostrartelefono_telefonoCobrarClientesSuspendidos(esInicial);
		this.setMostrarsaldoCobrarClientesSuspendidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.ID)) {
				this.setMostraridCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setMostrarnombre_comercialCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.RUC)) {
				this.setMostrarrucCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO)) {
				this.setMostrardetalle_estadoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setMostrardireccion_direccionCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setMostrartelefono_telefonoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.SALDO)) {
				this.setMostrarsaldoCobrarClientesSuspendidos(esAsigna);
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
		
		
		this.setActivaridCobrarClientesSuspendidos(esInicial);
		this.setActivarid_empresaCobrarClientesSuspendidos(esInicial);
		this.setActivarnombre_ciudadCobrarClientesSuspendidos(esInicial);
		this.setActivarcodigoCobrarClientesSuspendidos(esInicial);
		this.setActivarnombre_completoCobrarClientesSuspendidos(esInicial);
		this.setActivarnombre_comercialCobrarClientesSuspendidos(esInicial);
		this.setActivarrucCobrarClientesSuspendidos(esInicial);
		this.setActivardetalle_estadoCobrarClientesSuspendidos(esInicial);
		this.setActivardireccion_direccionCobrarClientesSuspendidos(esInicial);
		this.setActivartelefono_telefonoCobrarClientesSuspendidos(esInicial);
		this.setActivarsaldoCobrarClientesSuspendidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.ID)) {
				this.setActivaridCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setActivarnombre_comercialCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.RUC)) {
				this.setActivarrucCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO)) {
				this.setActivardetalle_estadoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setActivardireccion_direccionCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setActivartelefono_telefonoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.SALDO)) {
				this.setActivarsaldoCobrarClientesSuspendidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarClientesSuspendidos(esInicial);
		this.setResaltarid_empresaCobrarClientesSuspendidos(esInicial);
		this.setResaltarnombre_ciudadCobrarClientesSuspendidos(esInicial);
		this.setResaltarcodigoCobrarClientesSuspendidos(esInicial);
		this.setResaltarnombre_completoCobrarClientesSuspendidos(esInicial);
		this.setResaltarnombre_comercialCobrarClientesSuspendidos(esInicial);
		this.setResaltarrucCobrarClientesSuspendidos(esInicial);
		this.setResaltardetalle_estadoCobrarClientesSuspendidos(esInicial);
		this.setResaltardireccion_direccionCobrarClientesSuspendidos(esInicial);
		this.setResaltartelefono_telefonoCobrarClientesSuspendidos(esInicial);
		this.setResaltarsaldoCobrarClientesSuspendidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.ID)) {
				this.setResaltaridCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.NOMBRECOMERCIAL)) {
				this.setResaltarnombre_comercialCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.RUC)) {
				this.setResaltarrucCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.DETALLEESTADO)) {
				this.setResaltardetalle_estadoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setResaltardireccion_direccionCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.TELEFONOTELEFONO)) {
				this.setResaltartelefono_telefonoCobrarClientesSuspendidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesSuspendidosConstantesFunciones.SALDO)) {
				this.setResaltarsaldoCobrarClientesSuspendidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos=true;

	public Boolean getMostrarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos() {
		return this.mostrarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos;
	}

	public void setMostrarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos=true;

	public Boolean getActivarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos() {
		return this.activarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos;
	}

	public void setActivarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos=null;

	public Border getResaltarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos() {
		return this.resaltarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos;
	}

	public void setResaltarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos(Border borderResaltar) {
		this.resaltarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos= borderResaltar;
	}

	public void setResaltarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesSuspendidosBeanSwingJInternalFrame cobrarclientessuspendidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarClientesSuspendidosCobrarClientesSuspendidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}