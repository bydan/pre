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


import com.bydan.erp.cartera.util.report.CobrarClientesNovedadesConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarClientesNovedadesParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarClientesNovedadesParameterGeneral;

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
final public class CobrarClientesNovedadesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarClientesNovedades";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarClientesNovedades"+CobrarClientesNovedadesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarClientesNovedadesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarClientesNovedadesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarClientesNovedadesConstantesFunciones.SCHEMA+"_"+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesNovedadesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarClientesNovedadesConstantesFunciones.SCHEMA+"_"+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarClientesNovedadesConstantesFunciones.SCHEMA+"_"+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarClientesNovedadesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarClientesNovedadesConstantesFunciones.SCHEMA+"_"+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesNovedadesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarClientesNovedadesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarClientesNovedadesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarClientesNovedadesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarClientesNovedadesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarClientesNovedadesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarClientesNovedadesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Clientes Novedadeses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Clientes Novedades";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Clientes Novedades";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarClientesNovedades";
	public static final String OBJECTNAME="cobrarclientesnovedades";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_clientes_novedades";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarclientesnovedades from "+CobrarClientesNovedadesConstantesFunciones.SPERSISTENCENAME+" cobrarclientesnovedades";
	public static String QUERYSELECTNATIVE="select "+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".id,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".version_row,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".id_empresa,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".id_sucursal,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".feha_atencion_hasta,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".codigo,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".nombre,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".apellido,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".feha_atencion,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".hora_atencion,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".accion_tomada,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".descripcion,"+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME+".esta_activo from "+CobrarClientesNovedadesConstantesFunciones.SCHEMA+"."+CobrarClientesNovedadesConstantesFunciones.TABLENAME;//+" as "+CobrarClientesNovedadesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FEHAATENCIONHASTA= "feha_atencion_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String APELLIDO= "apellido";
    public static final String FEHAATENCION= "feha_atencion";
    public static final String HORAATENCION= "hora_atencion";
    public static final String ACCIONTOMADA= "accion_tomada";
    public static final String DESCRIPCION= "descripcion";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FEHAATENCIONHASTA= "Feha Atencion Hasta";
		public static final String LABEL_FEHAATENCIONHASTA_LOWER= "Feha Atencion Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_APELLIDO= "Apello";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_FEHAATENCION= "Feha Atencion";
		public static final String LABEL_FEHAATENCION_LOWER= "Feha Atencion";
    	public static final String LABEL_HORAATENCION= "Hora Atencion";
		public static final String LABEL_HORAATENCION_LOWER= "Hora Atencion";
    	public static final String LABEL_ACCIONTOMADA= "Accion Tomada";
		public static final String LABEL_ACCIONTOMADA_LOWER= "Accion Tomada";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXACCION_TOMADA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXACCION_TOMADA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getCobrarClientesNovedadesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCIONHASTA)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCIONHASTA;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.CODIGO)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.NOMBRE)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.APELLIDO)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCION)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCION;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.HORAATENCION)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_HORAATENCION;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_ACCIONTOMADA;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.DESCRIPCION)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO)) {sLabelColumna=CobrarClientesNovedadesConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(CobrarClientesNovedades cobrarclientesnovedades) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cobrarclientesnovedades.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(CobrarClientesNovedades cobrarclientesnovedades) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cobrarclientesnovedades.getId(),cobrarclientesnovedades.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getCobrarClientesNovedadesDescripcion(CobrarClientesNovedades cobrarclientesnovedades) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarclientesnovedades !=null/* && cobrarclientesnovedades.getId()!=0*/) {
			sDescripcion=cobrarclientesnovedades.getcodigo();//cobrarclientesnovedadescobrarclientesnovedades.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarClientesNovedadesDescripcionDetallado(CobrarClientesNovedades cobrarclientesnovedades) {
		String sDescripcion="";
			
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.ID+"=";
		sDescripcion+=cobrarclientesnovedades.getId().toString()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarclientesnovedades.getVersionRow().toString()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarclientesnovedades.getid_empresa().toString()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cobrarclientesnovedades.getid_sucursal().toString()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.FEHAATENCIONHASTA+"=";
		sDescripcion+=cobrarclientesnovedades.getfeha_atencion_hasta().toString()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarclientesnovedades.getcodigo()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cobrarclientesnovedades.getnombre()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.APELLIDO+"=";
		sDescripcion+=cobrarclientesnovedades.getapellido()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.FEHAATENCION+"=";
		sDescripcion+=cobrarclientesnovedades.getfeha_atencion().toString()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.HORAATENCION+"=";
		sDescripcion+=cobrarclientesnovedades.gethora_atencion().toString()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA+"=";
		sDescripcion+=cobrarclientesnovedades.getaccion_tomada()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=cobrarclientesnovedades.getdescripcion()+",";
		sDescripcion+=CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=cobrarclientesnovedades.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarClientesNovedadesDescripcion(CobrarClientesNovedades cobrarclientesnovedades,String sValor) throws Exception {			
		if(cobrarclientesnovedades !=null) {
			cobrarclientesnovedades.setcodigo(sValor);;//cobrarclientesnovedadescobrarclientesnovedades.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarClientesNovedades")) {
			sNombreIndice="Tipo=  Por Feha Atencion Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarClientesNovedades(Date feha_atencion_hasta) {
		String sDetalleIndice=" Parametros->";
		if(feha_atencion_hasta!=null) {sDetalleIndice+=" Feha Atencion Hasta="+feha_atencion_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarClientesNovedades(CobrarClientesNovedades cobrarclientesnovedades,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientesnovedades.setcodigo(cobrarclientesnovedades.getcodigo().trim());
		cobrarclientesnovedades.setnombre(cobrarclientesnovedades.getnombre().trim());
		cobrarclientesnovedades.setapellido(cobrarclientesnovedades.getapellido().trim());
		cobrarclientesnovedades.setaccion_tomada(cobrarclientesnovedades.getaccion_tomada().trim());
		cobrarclientesnovedades.setdescripcion(cobrarclientesnovedades.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCobrarClientesNovedadess(List<CobrarClientesNovedades> cobrarclientesnovedadess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesNovedades cobrarclientesnovedades: cobrarclientesnovedadess) {
			cobrarclientesnovedades.setcodigo(cobrarclientesnovedades.getcodigo().trim());
			cobrarclientesnovedades.setnombre(cobrarclientesnovedades.getnombre().trim());
			cobrarclientesnovedades.setapellido(cobrarclientesnovedades.getapellido().trim());
			cobrarclientesnovedades.setaccion_tomada(cobrarclientesnovedades.getaccion_tomada().trim());
			cobrarclientesnovedades.setdescripcion(cobrarclientesnovedades.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesNovedades(CobrarClientesNovedades cobrarclientesnovedades,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarclientesnovedades.getConCambioAuxiliar()) {
			cobrarclientesnovedades.setIsDeleted(cobrarclientesnovedades.getIsDeletedAuxiliar());	
			cobrarclientesnovedades.setIsNew(cobrarclientesnovedades.getIsNewAuxiliar());	
			cobrarclientesnovedades.setIsChanged(cobrarclientesnovedades.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarclientesnovedades.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarclientesnovedades.setIsDeletedAuxiliar(false);	
			cobrarclientesnovedades.setIsNewAuxiliar(false);	
			cobrarclientesnovedades.setIsChangedAuxiliar(false);
			
			cobrarclientesnovedades.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarClientesNovedadess(List<CobrarClientesNovedades> cobrarclientesnovedadess,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarClientesNovedades cobrarclientesnovedades : cobrarclientesnovedadess) {
			if(conAsignarBase && cobrarclientesnovedades.getConCambioAuxiliar()) {
				cobrarclientesnovedades.setIsDeleted(cobrarclientesnovedades.getIsDeletedAuxiliar());	
				cobrarclientesnovedades.setIsNew(cobrarclientesnovedades.getIsNewAuxiliar());	
				cobrarclientesnovedades.setIsChanged(cobrarclientesnovedades.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarclientesnovedades.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarclientesnovedades.setIsDeletedAuxiliar(false);	
				cobrarclientesnovedades.setIsNewAuxiliar(false);	
				cobrarclientesnovedades.setIsChangedAuxiliar(false);
				
				cobrarclientesnovedades.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarClientesNovedades(CobrarClientesNovedades cobrarclientesnovedades,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarClientesNovedadess(List<CobrarClientesNovedades> cobrarclientesnovedadess,Boolean conEnteros) throws Exception  {
		
		for(CobrarClientesNovedades cobrarclientesnovedades: cobrarclientesnovedadess) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarClientesNovedades(List<CobrarClientesNovedades> cobrarclientesnovedadess,CobrarClientesNovedades cobrarclientesnovedadesAux) throws Exception  {
		CobrarClientesNovedadesConstantesFunciones.InicializarValoresCobrarClientesNovedades(cobrarclientesnovedadesAux,true);
		
		for(CobrarClientesNovedades cobrarclientesnovedades: cobrarclientesnovedadess) {
			if(cobrarclientesnovedades.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesNovedades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarClientesNovedadesConstantesFunciones.getArrayColumnasGlobalesCobrarClientesNovedades(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesNovedades(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesNovedadesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesNovedadesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarClientesNovedades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesNovedades> cobrarclientesnovedadess,CobrarClientesNovedades cobrarclientesnovedades,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesNovedades cobrarclientesnovedadesAux: cobrarclientesnovedadess) {
			if(cobrarclientesnovedadesAux!=null && cobrarclientesnovedades!=null) {
				if((cobrarclientesnovedadesAux.getId()==null && cobrarclientesnovedades.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarclientesnovedadesAux.getId()!=null && cobrarclientesnovedades.getId()!=null){
					if(cobrarclientesnovedadesAux.getId().equals(cobrarclientesnovedades.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesNovedades(List<CobrarClientesNovedades> cobrarclientesnovedadess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarClientesNovedades cobrarclientesnovedades: cobrarclientesnovedadess) {			
			if(cobrarclientesnovedades.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarClientesNovedades() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_ID, CobrarClientesNovedadesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_VERSIONROW, CobrarClientesNovedadesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_CODIGO, CobrarClientesNovedadesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_NOMBRE, CobrarClientesNovedadesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_APELLIDO, CobrarClientesNovedadesConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCION, CobrarClientesNovedadesConstantesFunciones.FEHAATENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_HORAATENCION, CobrarClientesNovedadesConstantesFunciones.HORAATENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_ACCIONTOMADA, CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_DESCRIPCION, CobrarClientesNovedadesConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarClientesNovedadesConstantesFunciones.LABEL_ESTAACTIVO, CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarClientesNovedades() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.FEHAATENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.HORAATENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesNovedades() throws Exception  {
		return CobrarClientesNovedadesConstantesFunciones.getTiposSeleccionarCobrarClientesNovedades(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesNovedades(Boolean conFk) throws Exception  {
		return CobrarClientesNovedadesConstantesFunciones.getTiposSeleccionarCobrarClientesNovedades(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarClientesNovedades(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCIONHASTA);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCION);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_HORAATENCION);
		reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_HORAATENCION);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_ACCIONTOMADA);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_ACCIONTOMADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarClientesNovedadesConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(CobrarClientesNovedadesConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarClientesNovedades(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesNovedades(CobrarClientesNovedades cobrarclientesnovedadesAux) throws Exception {
		
			cobrarclientesnovedadesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientesnovedadesAux.getEmpresa()));
			cobrarclientesnovedadesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclientesnovedadesAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarClientesNovedades(List<CobrarClientesNovedades> cobrarclientesnovedadessTemp) throws Exception {
		for(CobrarClientesNovedades cobrarclientesnovedadesAux:cobrarclientesnovedadessTemp) {
			
			cobrarclientesnovedadesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarclientesnovedadesAux.getEmpresa()));
			cobrarclientesnovedadesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarclientesnovedadesAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarClientesNovedades(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarClientesNovedades(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesNovedades(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesNovedadesConstantesFunciones.getClassesRelationshipsOfCobrarClientesNovedades(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarClientesNovedades(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesNovedades(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarClientesNovedadesConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarClientesNovedades(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarClientesNovedades(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarClientesNovedades cobrarclientesnovedades,List<CobrarClientesNovedades> cobrarclientesnovedadess,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarClientesNovedades cobrarclientesnovedades,List<CobrarClientesNovedades> cobrarclientesnovedadess) throws Exception {
		try	{			
			for(CobrarClientesNovedades cobrarclientesnovedadesLocal:cobrarclientesnovedadess) {
				if(cobrarclientesnovedadesLocal.getId().equals(cobrarclientesnovedades.getId())) {
					cobrarclientesnovedadesLocal.setIsSelected(cobrarclientesnovedades.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarClientesNovedades(List<CobrarClientesNovedades> cobrarclientesnovedadessAux) throws Exception {
		//this.cobrarclientesnovedadessAux=cobrarclientesnovedadessAux;
		
		for(CobrarClientesNovedades cobrarclientesnovedadesAux:cobrarclientesnovedadessAux) {
			if(cobrarclientesnovedadesAux.getIsChanged()) {
				cobrarclientesnovedadesAux.setIsChanged(false);
			}		
			
			if(cobrarclientesnovedadesAux.getIsNew()) {
				cobrarclientesnovedadesAux.setIsNew(false);
			}	
			
			if(cobrarclientesnovedadesAux.getIsDeleted()) {
				cobrarclientesnovedadesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarClientesNovedades(CobrarClientesNovedades cobrarclientesnovedadesAux) throws Exception {
		//this.cobrarclientesnovedadesAux=cobrarclientesnovedadesAux;
		
			if(cobrarclientesnovedadesAux.getIsChanged()) {
				cobrarclientesnovedadesAux.setIsChanged(false);
			}		
			
			if(cobrarclientesnovedadesAux.getIsNew()) {
				cobrarclientesnovedadesAux.setIsNew(false);
			}	
			
			if(cobrarclientesnovedadesAux.getIsDeleted()) {
				cobrarclientesnovedadesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarClientesNovedades cobrarclientesnovedadesAsignar,CobrarClientesNovedades cobrarclientesnovedades) throws Exception {
		cobrarclientesnovedadesAsignar.setId(cobrarclientesnovedades.getId());	
		cobrarclientesnovedadesAsignar.setVersionRow(cobrarclientesnovedades.getVersionRow());	
		cobrarclientesnovedadesAsignar.setcodigo(cobrarclientesnovedades.getcodigo());	
		cobrarclientesnovedadesAsignar.setnombre(cobrarclientesnovedades.getnombre());	
		cobrarclientesnovedadesAsignar.setapellido(cobrarclientesnovedades.getapellido());	
		cobrarclientesnovedadesAsignar.setfeha_atencion(cobrarclientesnovedades.getfeha_atencion());	
		cobrarclientesnovedadesAsignar.sethora_atencion(cobrarclientesnovedades.gethora_atencion());	
		cobrarclientesnovedadesAsignar.setaccion_tomada(cobrarclientesnovedades.getaccion_tomada());	
		cobrarclientesnovedadesAsignar.setdescripcion(cobrarclientesnovedades.getdescripcion());	
		cobrarclientesnovedadesAsignar.setesta_activo(cobrarclientesnovedades.getesta_activo());	
	}
	
	public static void inicializarCobrarClientesNovedades(CobrarClientesNovedades cobrarclientesnovedades) throws Exception {
		try {
				cobrarclientesnovedades.setId(0L);	
					
				cobrarclientesnovedades.setcodigo("");	
				cobrarclientesnovedades.setnombre("");	
				cobrarclientesnovedades.setapellido("");	
				cobrarclientesnovedades.setfeha_atencion(new Date());	
				cobrarclientesnovedades.sethora_atencion(new Time((new Date()).getTime()));	
				cobrarclientesnovedades.setaccion_tomada("");	
				cobrarclientesnovedades.setdescripcion("");	
				cobrarclientesnovedades.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarClientesNovedades(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_FEHAATENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_HORAATENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_ACCIONTOMADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarClientesNovedadesConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarClientesNovedades(String sTipo,Row row,Workbook workbook,CobrarClientesNovedades cobrarclientesnovedades,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getfeha_atencion_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getfeha_atencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.gethora_atencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getaccion_tomada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarclientesnovedades.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cobrarclientesnovedades.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarClientesNovedades="";
	
	public String getsFinalQueryCobrarClientesNovedades() {
		return this.sFinalQueryCobrarClientesNovedades;
	}
	
	public void setsFinalQueryCobrarClientesNovedades(String sFinalQueryCobrarClientesNovedades) {
		this.sFinalQueryCobrarClientesNovedades= sFinalQueryCobrarClientesNovedades;
	}
	
	public Border resaltarSeleccionarCobrarClientesNovedades=null;
	
	public Border setResaltarSeleccionarCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarClientesNovedades= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarClientesNovedades() {
		return this.resaltarSeleccionarCobrarClientesNovedades;
	}
	
	public void setResaltarSeleccionarCobrarClientesNovedades(Border borderResaltarSeleccionarCobrarClientesNovedades) {
		this.resaltarSeleccionarCobrarClientesNovedades= borderResaltarSeleccionarCobrarClientesNovedades;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarClientesNovedades=null;
	public Boolean mostraridCobrarClientesNovedades=true;
	public Boolean activaridCobrarClientesNovedades=true;

	public Border resaltarid_empresaCobrarClientesNovedades=null;
	public Boolean mostrarid_empresaCobrarClientesNovedades=true;
	public Boolean activarid_empresaCobrarClientesNovedades=true;
	public Boolean cargarid_empresaCobrarClientesNovedades=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarClientesNovedades=false;//ConEventDepend=true

	public Border resaltarid_sucursalCobrarClientesNovedades=null;
	public Boolean mostrarid_sucursalCobrarClientesNovedades=true;
	public Boolean activarid_sucursalCobrarClientesNovedades=true;
	public Boolean cargarid_sucursalCobrarClientesNovedades=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCobrarClientesNovedades=false;//ConEventDepend=true

	public Border resaltarfeha_atencion_hastaCobrarClientesNovedades=null;
	public Boolean mostrarfeha_atencion_hastaCobrarClientesNovedades=true;
	public Boolean activarfeha_atencion_hastaCobrarClientesNovedades=true;

	public Border resaltarcodigoCobrarClientesNovedades=null;
	public Boolean mostrarcodigoCobrarClientesNovedades=true;
	public Boolean activarcodigoCobrarClientesNovedades=true;

	public Border resaltarnombreCobrarClientesNovedades=null;
	public Boolean mostrarnombreCobrarClientesNovedades=true;
	public Boolean activarnombreCobrarClientesNovedades=true;

	public Border resaltarapellidoCobrarClientesNovedades=null;
	public Boolean mostrarapellidoCobrarClientesNovedades=true;
	public Boolean activarapellidoCobrarClientesNovedades=true;

	public Border resaltarfeha_atencionCobrarClientesNovedades=null;
	public Boolean mostrarfeha_atencionCobrarClientesNovedades=true;
	public Boolean activarfeha_atencionCobrarClientesNovedades=true;

	public Border resaltarhora_atencionCobrarClientesNovedades=null;
	public Boolean mostrarhora_atencionCobrarClientesNovedades=true;
	public Boolean activarhora_atencionCobrarClientesNovedades=true;

	public Border resaltaraccion_tomadaCobrarClientesNovedades=null;
	public Boolean mostraraccion_tomadaCobrarClientesNovedades=true;
	public Boolean activaraccion_tomadaCobrarClientesNovedades=true;

	public Border resaltardescripcionCobrarClientesNovedades=null;
	public Boolean mostrardescripcionCobrarClientesNovedades=true;
	public Boolean activardescripcionCobrarClientesNovedades=true;

	public Border resaltaresta_activoCobrarClientesNovedades=null;
	public Boolean mostraresta_activoCobrarClientesNovedades=true;
	public Boolean activaresta_activoCobrarClientesNovedades=true;

	
	

	public Border setResaltaridCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltaridCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarClientesNovedades() {
		return this.resaltaridCobrarClientesNovedades;
	}

	public void setResaltaridCobrarClientesNovedades(Border borderResaltar) {
		this.resaltaridCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostraridCobrarClientesNovedades() {
		return this.mostraridCobrarClientesNovedades;
	}

	public void setMostraridCobrarClientesNovedades(Boolean mostraridCobrarClientesNovedades) {
		this.mostraridCobrarClientesNovedades= mostraridCobrarClientesNovedades;
	}

	public Boolean getActivaridCobrarClientesNovedades() {
		return this.activaridCobrarClientesNovedades;
	}

	public void setActivaridCobrarClientesNovedades(Boolean activaridCobrarClientesNovedades) {
		this.activaridCobrarClientesNovedades= activaridCobrarClientesNovedades;
	}

	public Border setResaltarid_empresaCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarClientesNovedades() {
		return this.resaltarid_empresaCobrarClientesNovedades;
	}

	public void setResaltarid_empresaCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarid_empresaCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarClientesNovedades() {
		return this.mostrarid_empresaCobrarClientesNovedades;
	}

	public void setMostrarid_empresaCobrarClientesNovedades(Boolean mostrarid_empresaCobrarClientesNovedades) {
		this.mostrarid_empresaCobrarClientesNovedades= mostrarid_empresaCobrarClientesNovedades;
	}

	public Boolean getActivarid_empresaCobrarClientesNovedades() {
		return this.activarid_empresaCobrarClientesNovedades;
	}

	public void setActivarid_empresaCobrarClientesNovedades(Boolean activarid_empresaCobrarClientesNovedades) {
		this.activarid_empresaCobrarClientesNovedades= activarid_empresaCobrarClientesNovedades;
	}

	public Boolean getCargarid_empresaCobrarClientesNovedades() {
		return this.cargarid_empresaCobrarClientesNovedades;
	}

	public void setCargarid_empresaCobrarClientesNovedades(Boolean cargarid_empresaCobrarClientesNovedades) {
		this.cargarid_empresaCobrarClientesNovedades= cargarid_empresaCobrarClientesNovedades;
	}

	public Border setResaltarid_sucursalCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCobrarClientesNovedades() {
		return this.resaltarid_sucursalCobrarClientesNovedades;
	}

	public void setResaltarid_sucursalCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarid_sucursalCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCobrarClientesNovedades() {
		return this.mostrarid_sucursalCobrarClientesNovedades;
	}

	public void setMostrarid_sucursalCobrarClientesNovedades(Boolean mostrarid_sucursalCobrarClientesNovedades) {
		this.mostrarid_sucursalCobrarClientesNovedades= mostrarid_sucursalCobrarClientesNovedades;
	}

	public Boolean getActivarid_sucursalCobrarClientesNovedades() {
		return this.activarid_sucursalCobrarClientesNovedades;
	}

	public void setActivarid_sucursalCobrarClientesNovedades(Boolean activarid_sucursalCobrarClientesNovedades) {
		this.activarid_sucursalCobrarClientesNovedades= activarid_sucursalCobrarClientesNovedades;
	}

	public Boolean getCargarid_sucursalCobrarClientesNovedades() {
		return this.cargarid_sucursalCobrarClientesNovedades;
	}

	public void setCargarid_sucursalCobrarClientesNovedades(Boolean cargarid_sucursalCobrarClientesNovedades) {
		this.cargarid_sucursalCobrarClientesNovedades= cargarid_sucursalCobrarClientesNovedades;
	}

	public Border setResaltarfeha_atencion_hastaCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarfeha_atencion_hastaCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfeha_atencion_hastaCobrarClientesNovedades() {
		return this.resaltarfeha_atencion_hastaCobrarClientesNovedades;
	}

	public void setResaltarfeha_atencion_hastaCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarfeha_atencion_hastaCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarfeha_atencion_hastaCobrarClientesNovedades() {
		return this.mostrarfeha_atencion_hastaCobrarClientesNovedades;
	}

	public void setMostrarfeha_atencion_hastaCobrarClientesNovedades(Boolean mostrarfeha_atencion_hastaCobrarClientesNovedades) {
		this.mostrarfeha_atencion_hastaCobrarClientesNovedades= mostrarfeha_atencion_hastaCobrarClientesNovedades;
	}

	public Boolean getActivarfeha_atencion_hastaCobrarClientesNovedades() {
		return this.activarfeha_atencion_hastaCobrarClientesNovedades;
	}

	public void setActivarfeha_atencion_hastaCobrarClientesNovedades(Boolean activarfeha_atencion_hastaCobrarClientesNovedades) {
		this.activarfeha_atencion_hastaCobrarClientesNovedades= activarfeha_atencion_hastaCobrarClientesNovedades;
	}

	public Border setResaltarcodigoCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarClientesNovedades() {
		return this.resaltarcodigoCobrarClientesNovedades;
	}

	public void setResaltarcodigoCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarcodigoCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarClientesNovedades() {
		return this.mostrarcodigoCobrarClientesNovedades;
	}

	public void setMostrarcodigoCobrarClientesNovedades(Boolean mostrarcodigoCobrarClientesNovedades) {
		this.mostrarcodigoCobrarClientesNovedades= mostrarcodigoCobrarClientesNovedades;
	}

	public Boolean getActivarcodigoCobrarClientesNovedades() {
		return this.activarcodigoCobrarClientesNovedades;
	}

	public void setActivarcodigoCobrarClientesNovedades(Boolean activarcodigoCobrarClientesNovedades) {
		this.activarcodigoCobrarClientesNovedades= activarcodigoCobrarClientesNovedades;
	}

	public Border setResaltarnombreCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarnombreCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCobrarClientesNovedades() {
		return this.resaltarnombreCobrarClientesNovedades;
	}

	public void setResaltarnombreCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarnombreCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarnombreCobrarClientesNovedades() {
		return this.mostrarnombreCobrarClientesNovedades;
	}

	public void setMostrarnombreCobrarClientesNovedades(Boolean mostrarnombreCobrarClientesNovedades) {
		this.mostrarnombreCobrarClientesNovedades= mostrarnombreCobrarClientesNovedades;
	}

	public Boolean getActivarnombreCobrarClientesNovedades() {
		return this.activarnombreCobrarClientesNovedades;
	}

	public void setActivarnombreCobrarClientesNovedades(Boolean activarnombreCobrarClientesNovedades) {
		this.activarnombreCobrarClientesNovedades= activarnombreCobrarClientesNovedades;
	}

	public Border setResaltarapellidoCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarapellidoCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoCobrarClientesNovedades() {
		return this.resaltarapellidoCobrarClientesNovedades;
	}

	public void setResaltarapellidoCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarapellidoCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarapellidoCobrarClientesNovedades() {
		return this.mostrarapellidoCobrarClientesNovedades;
	}

	public void setMostrarapellidoCobrarClientesNovedades(Boolean mostrarapellidoCobrarClientesNovedades) {
		this.mostrarapellidoCobrarClientesNovedades= mostrarapellidoCobrarClientesNovedades;
	}

	public Boolean getActivarapellidoCobrarClientesNovedades() {
		return this.activarapellidoCobrarClientesNovedades;
	}

	public void setActivarapellidoCobrarClientesNovedades(Boolean activarapellidoCobrarClientesNovedades) {
		this.activarapellidoCobrarClientesNovedades= activarapellidoCobrarClientesNovedades;
	}

	public Border setResaltarfeha_atencionCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarfeha_atencionCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfeha_atencionCobrarClientesNovedades() {
		return this.resaltarfeha_atencionCobrarClientesNovedades;
	}

	public void setResaltarfeha_atencionCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarfeha_atencionCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarfeha_atencionCobrarClientesNovedades() {
		return this.mostrarfeha_atencionCobrarClientesNovedades;
	}

	public void setMostrarfeha_atencionCobrarClientesNovedades(Boolean mostrarfeha_atencionCobrarClientesNovedades) {
		this.mostrarfeha_atencionCobrarClientesNovedades= mostrarfeha_atencionCobrarClientesNovedades;
	}

	public Boolean getActivarfeha_atencionCobrarClientesNovedades() {
		return this.activarfeha_atencionCobrarClientesNovedades;
	}

	public void setActivarfeha_atencionCobrarClientesNovedades(Boolean activarfeha_atencionCobrarClientesNovedades) {
		this.activarfeha_atencionCobrarClientesNovedades= activarfeha_atencionCobrarClientesNovedades;
	}

	public Border setResaltarhora_atencionCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltarhora_atencionCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_atencionCobrarClientesNovedades() {
		return this.resaltarhora_atencionCobrarClientesNovedades;
	}

	public void setResaltarhora_atencionCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarhora_atencionCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrarhora_atencionCobrarClientesNovedades() {
		return this.mostrarhora_atencionCobrarClientesNovedades;
	}

	public void setMostrarhora_atencionCobrarClientesNovedades(Boolean mostrarhora_atencionCobrarClientesNovedades) {
		this.mostrarhora_atencionCobrarClientesNovedades= mostrarhora_atencionCobrarClientesNovedades;
	}

	public Boolean getActivarhora_atencionCobrarClientesNovedades() {
		return this.activarhora_atencionCobrarClientesNovedades;
	}

	public void setActivarhora_atencionCobrarClientesNovedades(Boolean activarhora_atencionCobrarClientesNovedades) {
		this.activarhora_atencionCobrarClientesNovedades= activarhora_atencionCobrarClientesNovedades;
	}

	public Border setResaltaraccion_tomadaCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltaraccion_tomadaCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraccion_tomadaCobrarClientesNovedades() {
		return this.resaltaraccion_tomadaCobrarClientesNovedades;
	}

	public void setResaltaraccion_tomadaCobrarClientesNovedades(Border borderResaltar) {
		this.resaltaraccion_tomadaCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostraraccion_tomadaCobrarClientesNovedades() {
		return this.mostraraccion_tomadaCobrarClientesNovedades;
	}

	public void setMostraraccion_tomadaCobrarClientesNovedades(Boolean mostraraccion_tomadaCobrarClientesNovedades) {
		this.mostraraccion_tomadaCobrarClientesNovedades= mostraraccion_tomadaCobrarClientesNovedades;
	}

	public Boolean getActivaraccion_tomadaCobrarClientesNovedades() {
		return this.activaraccion_tomadaCobrarClientesNovedades;
	}

	public void setActivaraccion_tomadaCobrarClientesNovedades(Boolean activaraccion_tomadaCobrarClientesNovedades) {
		this.activaraccion_tomadaCobrarClientesNovedades= activaraccion_tomadaCobrarClientesNovedades;
	}

	public Border setResaltardescripcionCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltardescripcionCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCobrarClientesNovedades() {
		return this.resaltardescripcionCobrarClientesNovedades;
	}

	public void setResaltardescripcionCobrarClientesNovedades(Border borderResaltar) {
		this.resaltardescripcionCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostrardescripcionCobrarClientesNovedades() {
		return this.mostrardescripcionCobrarClientesNovedades;
	}

	public void setMostrardescripcionCobrarClientesNovedades(Boolean mostrardescripcionCobrarClientesNovedades) {
		this.mostrardescripcionCobrarClientesNovedades= mostrardescripcionCobrarClientesNovedades;
	}

	public Boolean getActivardescripcionCobrarClientesNovedades() {
		return this.activardescripcionCobrarClientesNovedades;
	}

	public void setActivardescripcionCobrarClientesNovedades(Boolean activardescripcionCobrarClientesNovedades) {
		this.activardescripcionCobrarClientesNovedades= activardescripcionCobrarClientesNovedades;
	}

	public Border setResaltaresta_activoCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarclientesnovedadesBeanSwingJInternalFrame.jTtoolBarCobrarClientesNovedades.setBorder(borderResaltar);
		
		this.resaltaresta_activoCobrarClientesNovedades= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoCobrarClientesNovedades() {
		return this.resaltaresta_activoCobrarClientesNovedades;
	}

	public void setResaltaresta_activoCobrarClientesNovedades(Border borderResaltar) {
		this.resaltaresta_activoCobrarClientesNovedades= borderResaltar;
	}

	public Boolean getMostraresta_activoCobrarClientesNovedades() {
		return this.mostraresta_activoCobrarClientesNovedades;
	}

	public void setMostraresta_activoCobrarClientesNovedades(Boolean mostraresta_activoCobrarClientesNovedades) {
		this.mostraresta_activoCobrarClientesNovedades= mostraresta_activoCobrarClientesNovedades;
	}

	public Boolean getActivaresta_activoCobrarClientesNovedades() {
		return this.activaresta_activoCobrarClientesNovedades;
	}

	public void setActivaresta_activoCobrarClientesNovedades(Boolean activaresta_activoCobrarClientesNovedades) {
		this.activaresta_activoCobrarClientesNovedades= activaresta_activoCobrarClientesNovedades;
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
		
		
		this.setMostraridCobrarClientesNovedades(esInicial);
		this.setMostrarid_empresaCobrarClientesNovedades(esInicial);
		this.setMostrarid_sucursalCobrarClientesNovedades(esInicial);
		this.setMostrarfeha_atencion_hastaCobrarClientesNovedades(esInicial);
		this.setMostrarcodigoCobrarClientesNovedades(esInicial);
		this.setMostrarnombreCobrarClientesNovedades(esInicial);
		this.setMostrarapellidoCobrarClientesNovedades(esInicial);
		this.setMostrarfeha_atencionCobrarClientesNovedades(esInicial);
		this.setMostrarhora_atencionCobrarClientesNovedades(esInicial);
		this.setMostraraccion_tomadaCobrarClientesNovedades(esInicial);
		this.setMostrardescripcionCobrarClientesNovedades(esInicial);
		this.setMostraresta_activoCobrarClientesNovedades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ID)) {
				this.setMostraridCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCIONHASTA)) {
				this.setMostrarfeha_atencion_hastaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCION)) {
				this.setMostrarfeha_atencionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.HORAATENCION)) {
				this.setMostrarhora_atencionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA)) {
				this.setMostraraccion_tomadaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoCobrarClientesNovedades(esAsigna);
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
		
		
		this.setActivaridCobrarClientesNovedades(esInicial);
		this.setActivarid_empresaCobrarClientesNovedades(esInicial);
		this.setActivarid_sucursalCobrarClientesNovedades(esInicial);
		this.setActivarfeha_atencion_hastaCobrarClientesNovedades(esInicial);
		this.setActivarcodigoCobrarClientesNovedades(esInicial);
		this.setActivarnombreCobrarClientesNovedades(esInicial);
		this.setActivarapellidoCobrarClientesNovedades(esInicial);
		this.setActivarfeha_atencionCobrarClientesNovedades(esInicial);
		this.setActivarhora_atencionCobrarClientesNovedades(esInicial);
		this.setActivaraccion_tomadaCobrarClientesNovedades(esInicial);
		this.setActivardescripcionCobrarClientesNovedades(esInicial);
		this.setActivaresta_activoCobrarClientesNovedades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ID)) {
				this.setActivaridCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCIONHASTA)) {
				this.setActivarfeha_atencion_hastaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCION)) {
				this.setActivarfeha_atencionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.HORAATENCION)) {
				this.setActivarhora_atencionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA)) {
				this.setActivaraccion_tomadaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoCobrarClientesNovedades(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarClientesNovedades(esInicial);
		this.setResaltarid_empresaCobrarClientesNovedades(esInicial);
		this.setResaltarid_sucursalCobrarClientesNovedades(esInicial);
		this.setResaltarfeha_atencion_hastaCobrarClientesNovedades(esInicial);
		this.setResaltarcodigoCobrarClientesNovedades(esInicial);
		this.setResaltarnombreCobrarClientesNovedades(esInicial);
		this.setResaltarapellidoCobrarClientesNovedades(esInicial);
		this.setResaltarfeha_atencionCobrarClientesNovedades(esInicial);
		this.setResaltarhora_atencionCobrarClientesNovedades(esInicial);
		this.setResaltaraccion_tomadaCobrarClientesNovedades(esInicial);
		this.setResaltardescripcionCobrarClientesNovedades(esInicial);
		this.setResaltaresta_activoCobrarClientesNovedades(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ID)) {
				this.setResaltaridCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCIONHASTA)) {
				this.setResaltarfeha_atencion_hastaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.FEHAATENCION)) {
				this.setResaltarfeha_atencionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.HORAATENCION)) {
				this.setResaltarhora_atencionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ACCIONTOMADA)) {
				this.setResaltaraccion_tomadaCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCobrarClientesNovedades(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarClientesNovedadesConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoCobrarClientesNovedades(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarClientesNovedadesCobrarClientesNovedades=true;

	public Boolean getMostrarBusquedaCobrarClientesNovedadesCobrarClientesNovedades() {
		return this.mostrarBusquedaCobrarClientesNovedadesCobrarClientesNovedades;
	}

	public void setMostrarBusquedaCobrarClientesNovedadesCobrarClientesNovedades(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarClientesNovedadesCobrarClientesNovedades= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarClientesNovedadesCobrarClientesNovedades=true;

	public Boolean getActivarBusquedaCobrarClientesNovedadesCobrarClientesNovedades() {
		return this.activarBusquedaCobrarClientesNovedadesCobrarClientesNovedades;
	}

	public void setActivarBusquedaCobrarClientesNovedadesCobrarClientesNovedades(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarClientesNovedadesCobrarClientesNovedades= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarClientesNovedadesCobrarClientesNovedades=null;

	public Border getResaltarBusquedaCobrarClientesNovedadesCobrarClientesNovedades() {
		return this.resaltarBusquedaCobrarClientesNovedadesCobrarClientesNovedades;
	}

	public void setResaltarBusquedaCobrarClientesNovedadesCobrarClientesNovedades(Border borderResaltar) {
		this.resaltarBusquedaCobrarClientesNovedadesCobrarClientesNovedades= borderResaltar;
	}

	public void setResaltarBusquedaCobrarClientesNovedadesCobrarClientesNovedades(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarClientesNovedadesBeanSwingJInternalFrame cobrarclientesnovedadesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarClientesNovedadesCobrarClientesNovedades= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}