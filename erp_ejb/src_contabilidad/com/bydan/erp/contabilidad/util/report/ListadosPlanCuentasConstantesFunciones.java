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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.ListadosPlanCuentasConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ListadosPlanCuentasParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ListadosPlanCuentasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ListadosPlanCuentasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ListadosPlanCuentas";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadosPlanCuentas"+ListadosPlanCuentasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadosPlanCuentasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadosPlanCuentasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadosPlanCuentasConstantesFunciones.SCHEMA+"_"+ListadosPlanCuentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadosPlanCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadosPlanCuentasConstantesFunciones.SCHEMA+"_"+ListadosPlanCuentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadosPlanCuentasConstantesFunciones.SCHEMA+"_"+ListadosPlanCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadosPlanCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadosPlanCuentasConstantesFunciones.SCHEMA+"_"+ListadosPlanCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosPlanCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosPlanCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosPlanCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosPlanCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadosPlanCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadosPlanCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadosPlanCuentasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadosPlanCuentasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadosPlanCuentasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadosPlanCuentasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listados Plan Cuentases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listados Plan Cuentas";
	public static final String SCLASSWEBTITULO_LOWER="Listados Plan Cuentas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadosPlanCuentas";
	public static final String OBJECTNAME="listadosplancuentas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="listados_plan_cuentas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadosplancuentas from "+ListadosPlanCuentasConstantesFunciones.SPERSISTENCENAME+" listadosplancuentas";
	public static String QUERYSELECTNATIVE="select "+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".id,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".version_row,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".id_empresa,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".nombre_moneda,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".codigo,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".nombre,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".nombre_nivel_cuenta,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".es_movimiento,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".es_centro_costo,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".es_centro_actividad,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".es_para_f52,"+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME+".orden from "+ListadosPlanCuentasConstantesFunciones.SCHEMA+"."+ListadosPlanCuentasConstantesFunciones.TABLENAME;//+" as "+ListadosPlanCuentasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBREMONEDA= "nombre_moneda";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBRENIVELCUENTA= "nombre_nivel_cuenta";
    public static final String ESMOVIMIENTO= "es_movimiento";
    public static final String ESCENTROCOSTO= "es_centro_costo";
    public static final String ESCENTROACTIVIDAD= "es_centro_actividad";
    public static final String ESPARAF52= "es_para_f52";
    public static final String ORDEN= "orden";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBREMONEDA= "Nombre Moneda";
		public static final String LABEL_NOMBREMONEDA_LOWER= "Nombre Moneda";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBRENIVELCUENTA= "Nombre Nivel Cuenta";
		public static final String LABEL_NOMBRENIVELCUENTA_LOWER= "Nombre Nivel Cuenta";
    	public static final String LABEL_ESMOVIMIENTO= "Es Movimiento";
		public static final String LABEL_ESMOVIMIENTO_LOWER= "Es Movimiento";
    	public static final String LABEL_ESCENTROCOSTO= "Es Centro Costo";
		public static final String LABEL_ESCENTROCOSTO_LOWER= "Es Centro Costo";
    	public static final String LABEL_ESCENTROACTIVIDAD= "Es Centro Activad";
		public static final String LABEL_ESCENTROACTIVIDAD_LOWER= "Es Centro Actividad";
    	public static final String LABEL_ESPARAF52= "Es Para F52";
		public static final String LABEL_ESPARAF52_LOWER= "Es Para F52";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
	
		
		
		
	public static final String SREGEXNOMBRE_MONEDA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MONEDA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_NIVEL_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_NIVEL_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getListadosPlanCuentasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.NOMBREMONEDA)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_NOMBREMONEDA;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.CODIGO)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.NOMBRE)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.NOMBRENIVELCUENTA)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRENIVELCUENTA;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.ESMOVIMIENTO)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_ESMOVIMIENTO;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROCOSTO)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROCOSTO;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROACTIVIDAD)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROACTIVIDAD;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.ESPARAF52)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_ESPARAF52;}
		if(sNombreColumna.equals(ListadosPlanCuentasConstantesFunciones.ORDEN)) {sLabelColumna=ListadosPlanCuentasConstantesFunciones.LABEL_ORDEN;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getes_movimientoDescripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!listadosplancuentas.getes_movimiento()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_movimientoHtmlDescripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(listadosplancuentas.getId(),listadosplancuentas.getes_movimiento());

		return sDescripcion;
	}	
		
	public static String getes_centro_costoDescripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!listadosplancuentas.getes_centro_costo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_centro_costoHtmlDescripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(listadosplancuentas.getId(),listadosplancuentas.getes_centro_costo());

		return sDescripcion;
	}	
		
	public static String getes_centro_actividadDescripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!listadosplancuentas.getes_centro_actividad()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_centro_actividadHtmlDescripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(listadosplancuentas.getId(),listadosplancuentas.getes_centro_actividad());

		return sDescripcion;
	}	
		
	public static String getes_para_f52Descripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!listadosplancuentas.getes_para_f52()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_para_f52HtmlDescripcion(ListadosPlanCuentas listadosplancuentas) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(listadosplancuentas.getId(),listadosplancuentas.getes_para_f52());

		return sDescripcion;
	}	
			
	
	public static String getListadosPlanCuentasDescripcion(ListadosPlanCuentas listadosplancuentas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadosplancuentas !=null/* && listadosplancuentas.getId()!=0*/) {
			sDescripcion=listadosplancuentas.getcodigo();//listadosplancuentaslistadosplancuentas.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getListadosPlanCuentasDescripcionDetallado(ListadosPlanCuentas listadosplancuentas) {
		String sDescripcion="";
			
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.ID+"=";
		sDescripcion+=listadosplancuentas.getId().toString()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadosplancuentas.getVersionRow().toString()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadosplancuentas.getid_empresa().toString()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.NOMBREMONEDA+"=";
		sDescripcion+=listadosplancuentas.getnombre_moneda()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.CODIGO+"=";
		sDescripcion+=listadosplancuentas.getcodigo()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.NOMBRE+"=";
		sDescripcion+=listadosplancuentas.getnombre()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.NOMBRENIVELCUENTA+"=";
		sDescripcion+=listadosplancuentas.getnombre_nivel_cuenta()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.ESMOVIMIENTO+"=";
		sDescripcion+=listadosplancuentas.getes_movimiento().toString()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.ESCENTROCOSTO+"=";
		sDescripcion+=listadosplancuentas.getes_centro_costo().toString()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.ESCENTROACTIVIDAD+"=";
		sDescripcion+=listadosplancuentas.getes_centro_actividad().toString()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.ESPARAF52+"=";
		sDescripcion+=listadosplancuentas.getes_para_f52().toString()+",";
		sDescripcion+=ListadosPlanCuentasConstantesFunciones.ORDEN+"=";
		sDescripcion+=listadosplancuentas.getorden().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setListadosPlanCuentasDescripcion(ListadosPlanCuentas listadosplancuentas,String sValor) throws Exception {			
		if(listadosplancuentas !=null) {
			listadosplancuentas.setcodigo(sValor);;//listadosplancuentaslistadosplancuentas.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaListadosPlanCuentas")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadosPlanCuentas(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadosPlanCuentas(ListadosPlanCuentas listadosplancuentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadosplancuentas.setnombre_moneda(listadosplancuentas.getnombre_moneda().trim());
		listadosplancuentas.setcodigo(listadosplancuentas.getcodigo().trim());
		listadosplancuentas.setnombre(listadosplancuentas.getnombre().trim());
		listadosplancuentas.setnombre_nivel_cuenta(listadosplancuentas.getnombre_nivel_cuenta().trim());
	}
	
	public static void quitarEspaciosListadosPlanCuentass(List<ListadosPlanCuentas> listadosplancuentass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosPlanCuentas listadosplancuentas: listadosplancuentass) {
			listadosplancuentas.setnombre_moneda(listadosplancuentas.getnombre_moneda().trim());
			listadosplancuentas.setcodigo(listadosplancuentas.getcodigo().trim());
			listadosplancuentas.setnombre(listadosplancuentas.getnombre().trim());
			listadosplancuentas.setnombre_nivel_cuenta(listadosplancuentas.getnombre_nivel_cuenta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosPlanCuentas(ListadosPlanCuentas listadosplancuentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadosplancuentas.getConCambioAuxiliar()) {
			listadosplancuentas.setIsDeleted(listadosplancuentas.getIsDeletedAuxiliar());	
			listadosplancuentas.setIsNew(listadosplancuentas.getIsNewAuxiliar());	
			listadosplancuentas.setIsChanged(listadosplancuentas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadosplancuentas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadosplancuentas.setIsDeletedAuxiliar(false);	
			listadosplancuentas.setIsNewAuxiliar(false);	
			listadosplancuentas.setIsChangedAuxiliar(false);
			
			listadosplancuentas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadosPlanCuentass(List<ListadosPlanCuentas> listadosplancuentass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadosPlanCuentas listadosplancuentas : listadosplancuentass) {
			if(conAsignarBase && listadosplancuentas.getConCambioAuxiliar()) {
				listadosplancuentas.setIsDeleted(listadosplancuentas.getIsDeletedAuxiliar());	
				listadosplancuentas.setIsNew(listadosplancuentas.getIsNewAuxiliar());	
				listadosplancuentas.setIsChanged(listadosplancuentas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadosplancuentas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadosplancuentas.setIsDeletedAuxiliar(false);	
				listadosplancuentas.setIsNewAuxiliar(false);	
				listadosplancuentas.setIsChangedAuxiliar(false);
				
				listadosplancuentas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadosPlanCuentas(ListadosPlanCuentas listadosplancuentas,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			listadosplancuentas.setorden(0);
		}
	}		
	
	public static void InicializarValoresListadosPlanCuentass(List<ListadosPlanCuentas> listadosplancuentass,Boolean conEnteros) throws Exception  {
		
		for(ListadosPlanCuentas listadosplancuentas: listadosplancuentass) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				listadosplancuentas.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadosPlanCuentas(List<ListadosPlanCuentas> listadosplancuentass,ListadosPlanCuentas listadosplancuentasAux) throws Exception  {
		ListadosPlanCuentasConstantesFunciones.InicializarValoresListadosPlanCuentas(listadosplancuentasAux,true);
		
		for(ListadosPlanCuentas listadosplancuentas: listadosplancuentass) {
			if(listadosplancuentas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			listadosplancuentasAux.setorden(listadosplancuentasAux.getorden()+listadosplancuentas.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosPlanCuentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadosPlanCuentasConstantesFunciones.getArrayColumnasGlobalesListadosPlanCuentas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosPlanCuentas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadosPlanCuentasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadosPlanCuentasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadosPlanCuentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosPlanCuentas> listadosplancuentass,ListadosPlanCuentas listadosplancuentas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosPlanCuentas listadosplancuentasAux: listadosplancuentass) {
			if(listadosplancuentasAux!=null && listadosplancuentas!=null) {
				if((listadosplancuentasAux.getId()==null && listadosplancuentas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadosplancuentasAux.getId()!=null && listadosplancuentas.getId()!=null){
					if(listadosplancuentasAux.getId().equals(listadosplancuentas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosPlanCuentas(List<ListadosPlanCuentas> listadosplancuentass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ListadosPlanCuentas listadosplancuentas: listadosplancuentass) {			
			if(listadosplancuentas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadosPlanCuentas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_VERSIONROW, ListadosPlanCuentasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_NOMBREMONEDA, ListadosPlanCuentasConstantesFunciones.NOMBREMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_CODIGO, ListadosPlanCuentasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRE, ListadosPlanCuentasConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRENIVELCUENTA, ListadosPlanCuentasConstantesFunciones.NOMBRENIVELCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_ESMOVIMIENTO, ListadosPlanCuentasConstantesFunciones.ESMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROCOSTO, ListadosPlanCuentasConstantesFunciones.ESCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROACTIVIDAD, ListadosPlanCuentasConstantesFunciones.ESCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_ESPARAF52, ListadosPlanCuentasConstantesFunciones.ESPARAF52,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadosPlanCuentasConstantesFunciones.LABEL_ORDEN, ListadosPlanCuentasConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadosPlanCuentas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.NOMBREMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.NOMBRENIVELCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.ESMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.ESCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.ESCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.ESPARAF52;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadosPlanCuentasConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosPlanCuentas() throws Exception  {
		return ListadosPlanCuentasConstantesFunciones.getTiposSeleccionarListadosPlanCuentas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosPlanCuentas(Boolean conFk) throws Exception  {
		return ListadosPlanCuentasConstantesFunciones.getTiposSeleccionarListadosPlanCuentas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadosPlanCuentas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBREMONEDA);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBREMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRENIVELCUENTA);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRENIVELCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_ESMOVIMIENTO);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_ESMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROCOSTO);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROACTIVIDAD);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_ESPARAF52);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_ESPARAF52);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadosPlanCuentasConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(ListadosPlanCuentasConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadosPlanCuentas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadosPlanCuentas(ListadosPlanCuentas listadosplancuentasAux) throws Exception {
		
			listadosplancuentasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadosplancuentasAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadosPlanCuentas(List<ListadosPlanCuentas> listadosplancuentassTemp) throws Exception {
		for(ListadosPlanCuentas listadosplancuentasAux:listadosplancuentassTemp) {
			
			listadosplancuentasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadosplancuentasAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadosPlanCuentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadosPlanCuentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosPlanCuentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosPlanCuentasConstantesFunciones.getClassesRelationshipsOfListadosPlanCuentas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadosPlanCuentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosPlanCuentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadosPlanCuentasConstantesFunciones.getClassesRelationshipsFromStringsOfListadosPlanCuentas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadosPlanCuentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadosPlanCuentas listadosplancuentas,List<ListadosPlanCuentas> listadosplancuentass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadosPlanCuentas listadosplancuentas,List<ListadosPlanCuentas> listadosplancuentass) throws Exception {
		try	{			
			for(ListadosPlanCuentas listadosplancuentasLocal:listadosplancuentass) {
				if(listadosplancuentasLocal.getId().equals(listadosplancuentas.getId())) {
					listadosplancuentasLocal.setIsSelected(listadosplancuentas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadosPlanCuentas(List<ListadosPlanCuentas> listadosplancuentassAux) throws Exception {
		//this.listadosplancuentassAux=listadosplancuentassAux;
		
		for(ListadosPlanCuentas listadosplancuentasAux:listadosplancuentassAux) {
			if(listadosplancuentasAux.getIsChanged()) {
				listadosplancuentasAux.setIsChanged(false);
			}		
			
			if(listadosplancuentasAux.getIsNew()) {
				listadosplancuentasAux.setIsNew(false);
			}	
			
			if(listadosplancuentasAux.getIsDeleted()) {
				listadosplancuentasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadosPlanCuentas(ListadosPlanCuentas listadosplancuentasAux) throws Exception {
		//this.listadosplancuentasAux=listadosplancuentasAux;
		
			if(listadosplancuentasAux.getIsChanged()) {
				listadosplancuentasAux.setIsChanged(false);
			}		
			
			if(listadosplancuentasAux.getIsNew()) {
				listadosplancuentasAux.setIsNew(false);
			}	
			
			if(listadosplancuentasAux.getIsDeleted()) {
				listadosplancuentasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadosPlanCuentas listadosplancuentasAsignar,ListadosPlanCuentas listadosplancuentas) throws Exception {
		listadosplancuentasAsignar.setVersionRow(listadosplancuentas.getVersionRow());	
		listadosplancuentasAsignar.setnombre_moneda(listadosplancuentas.getnombre_moneda());	
		listadosplancuentasAsignar.setcodigo(listadosplancuentas.getcodigo());	
		listadosplancuentasAsignar.setnombre(listadosplancuentas.getnombre());	
		listadosplancuentasAsignar.setnombre_nivel_cuenta(listadosplancuentas.getnombre_nivel_cuenta());	
		listadosplancuentasAsignar.setes_movimiento(listadosplancuentas.getes_movimiento());	
		listadosplancuentasAsignar.setes_centro_costo(listadosplancuentas.getes_centro_costo());	
		listadosplancuentasAsignar.setes_centro_actividad(listadosplancuentas.getes_centro_actividad());	
		listadosplancuentasAsignar.setes_para_f52(listadosplancuentas.getes_para_f52());	
		listadosplancuentasAsignar.setorden(listadosplancuentas.getorden());	
	}
	
	public static void inicializarListadosPlanCuentas(ListadosPlanCuentas listadosplancuentas) throws Exception {
		try {
					
				listadosplancuentas.setnombre_moneda("");	
				listadosplancuentas.setcodigo("");	
				listadosplancuentas.setnombre("");	
				listadosplancuentas.setnombre_nivel_cuenta("");	
				listadosplancuentas.setes_movimiento(false);	
				listadosplancuentas.setes_centro_costo(false);	
				listadosplancuentas.setes_centro_actividad(false);	
				listadosplancuentas.setes_para_f52(false);	
				listadosplancuentas.setorden(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadosPlanCuentas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBREMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_NOMBRENIVELCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_ESMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_ESCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_ESPARAF52);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadosPlanCuentasConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadosPlanCuentas(String sTipo,Row row,Workbook workbook,ListadosPlanCuentas listadosplancuentas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosplancuentas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosplancuentas.getnombre_moneda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosplancuentas.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosplancuentas.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosplancuentas.getnombre_nivel_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(listadosplancuentas.getes_movimiento()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(listadosplancuentas.getes_centro_costo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(listadosplancuentas.getes_centro_actividad()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(listadosplancuentas.getes_para_f52()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadosplancuentas.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadosPlanCuentas="";
	
	public String getsFinalQueryListadosPlanCuentas() {
		return this.sFinalQueryListadosPlanCuentas;
	}
	
	public void setsFinalQueryListadosPlanCuentas(String sFinalQueryListadosPlanCuentas) {
		this.sFinalQueryListadosPlanCuentas= sFinalQueryListadosPlanCuentas;
	}
	
	public Border resaltarSeleccionarListadosPlanCuentas=null;
	
	public Border setResaltarSeleccionarListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadosPlanCuentas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadosPlanCuentas() {
		return this.resaltarSeleccionarListadosPlanCuentas;
	}
	
	public void setResaltarSeleccionarListadosPlanCuentas(Border borderResaltarSeleccionarListadosPlanCuentas) {
		this.resaltarSeleccionarListadosPlanCuentas= borderResaltarSeleccionarListadosPlanCuentas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadosPlanCuentas=null;
	public Boolean mostraridListadosPlanCuentas=true;
	public Boolean activaridListadosPlanCuentas=true;

	public Border resaltarid_empresaListadosPlanCuentas=null;
	public Boolean mostrarid_empresaListadosPlanCuentas=true;
	public Boolean activarid_empresaListadosPlanCuentas=true;
	public Boolean cargarid_empresaListadosPlanCuentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadosPlanCuentas=false;//ConEventDepend=true

	public Border resaltarnombre_monedaListadosPlanCuentas=null;
	public Boolean mostrarnombre_monedaListadosPlanCuentas=true;
	public Boolean activarnombre_monedaListadosPlanCuentas=true;

	public Border resaltarcodigoListadosPlanCuentas=null;
	public Boolean mostrarcodigoListadosPlanCuentas=true;
	public Boolean activarcodigoListadosPlanCuentas=true;

	public Border resaltarnombreListadosPlanCuentas=null;
	public Boolean mostrarnombreListadosPlanCuentas=true;
	public Boolean activarnombreListadosPlanCuentas=true;

	public Border resaltarnombre_nivel_cuentaListadosPlanCuentas=null;
	public Boolean mostrarnombre_nivel_cuentaListadosPlanCuentas=true;
	public Boolean activarnombre_nivel_cuentaListadosPlanCuentas=true;

	public Border resaltares_movimientoListadosPlanCuentas=null;
	public Boolean mostrares_movimientoListadosPlanCuentas=true;
	public Boolean activares_movimientoListadosPlanCuentas=true;

	public Border resaltares_centro_costoListadosPlanCuentas=null;
	public Boolean mostrares_centro_costoListadosPlanCuentas=true;
	public Boolean activares_centro_costoListadosPlanCuentas=true;

	public Border resaltares_centro_actividadListadosPlanCuentas=null;
	public Boolean mostrares_centro_actividadListadosPlanCuentas=true;
	public Boolean activares_centro_actividadListadosPlanCuentas=true;

	public Border resaltares_para_f52ListadosPlanCuentas=null;
	public Boolean mostrares_para_f52ListadosPlanCuentas=true;
	public Boolean activares_para_f52ListadosPlanCuentas=true;

	public Border resaltarordenListadosPlanCuentas=null;
	public Boolean mostrarordenListadosPlanCuentas=true;
	public Boolean activarordenListadosPlanCuentas=true;

	
	

	public Border setResaltaridListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltaridListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadosPlanCuentas() {
		return this.resaltaridListadosPlanCuentas;
	}

	public void setResaltaridListadosPlanCuentas(Border borderResaltar) {
		this.resaltaridListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostraridListadosPlanCuentas() {
		return this.mostraridListadosPlanCuentas;
	}

	public void setMostraridListadosPlanCuentas(Boolean mostraridListadosPlanCuentas) {
		this.mostraridListadosPlanCuentas= mostraridListadosPlanCuentas;
	}

	public Boolean getActivaridListadosPlanCuentas() {
		return this.activaridListadosPlanCuentas;
	}

	public void setActivaridListadosPlanCuentas(Boolean activaridListadosPlanCuentas) {
		this.activaridListadosPlanCuentas= activaridListadosPlanCuentas;
	}

	public Border setResaltarid_empresaListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadosPlanCuentas() {
		return this.resaltarid_empresaListadosPlanCuentas;
	}

	public void setResaltarid_empresaListadosPlanCuentas(Border borderResaltar) {
		this.resaltarid_empresaListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadosPlanCuentas() {
		return this.mostrarid_empresaListadosPlanCuentas;
	}

	public void setMostrarid_empresaListadosPlanCuentas(Boolean mostrarid_empresaListadosPlanCuentas) {
		this.mostrarid_empresaListadosPlanCuentas= mostrarid_empresaListadosPlanCuentas;
	}

	public Boolean getActivarid_empresaListadosPlanCuentas() {
		return this.activarid_empresaListadosPlanCuentas;
	}

	public void setActivarid_empresaListadosPlanCuentas(Boolean activarid_empresaListadosPlanCuentas) {
		this.activarid_empresaListadosPlanCuentas= activarid_empresaListadosPlanCuentas;
	}

	public Boolean getCargarid_empresaListadosPlanCuentas() {
		return this.cargarid_empresaListadosPlanCuentas;
	}

	public void setCargarid_empresaListadosPlanCuentas(Boolean cargarid_empresaListadosPlanCuentas) {
		this.cargarid_empresaListadosPlanCuentas= cargarid_empresaListadosPlanCuentas;
	}

	public Border setResaltarnombre_monedaListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltarnombre_monedaListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_monedaListadosPlanCuentas() {
		return this.resaltarnombre_monedaListadosPlanCuentas;
	}

	public void setResaltarnombre_monedaListadosPlanCuentas(Border borderResaltar) {
		this.resaltarnombre_monedaListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrarnombre_monedaListadosPlanCuentas() {
		return this.mostrarnombre_monedaListadosPlanCuentas;
	}

	public void setMostrarnombre_monedaListadosPlanCuentas(Boolean mostrarnombre_monedaListadosPlanCuentas) {
		this.mostrarnombre_monedaListadosPlanCuentas= mostrarnombre_monedaListadosPlanCuentas;
	}

	public Boolean getActivarnombre_monedaListadosPlanCuentas() {
		return this.activarnombre_monedaListadosPlanCuentas;
	}

	public void setActivarnombre_monedaListadosPlanCuentas(Boolean activarnombre_monedaListadosPlanCuentas) {
		this.activarnombre_monedaListadosPlanCuentas= activarnombre_monedaListadosPlanCuentas;
	}

	public Border setResaltarcodigoListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltarcodigoListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoListadosPlanCuentas() {
		return this.resaltarcodigoListadosPlanCuentas;
	}

	public void setResaltarcodigoListadosPlanCuentas(Border borderResaltar) {
		this.resaltarcodigoListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrarcodigoListadosPlanCuentas() {
		return this.mostrarcodigoListadosPlanCuentas;
	}

	public void setMostrarcodigoListadosPlanCuentas(Boolean mostrarcodigoListadosPlanCuentas) {
		this.mostrarcodigoListadosPlanCuentas= mostrarcodigoListadosPlanCuentas;
	}

	public Boolean getActivarcodigoListadosPlanCuentas() {
		return this.activarcodigoListadosPlanCuentas;
	}

	public void setActivarcodigoListadosPlanCuentas(Boolean activarcodigoListadosPlanCuentas) {
		this.activarcodigoListadosPlanCuentas= activarcodigoListadosPlanCuentas;
	}

	public Border setResaltarnombreListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltarnombreListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreListadosPlanCuentas() {
		return this.resaltarnombreListadosPlanCuentas;
	}

	public void setResaltarnombreListadosPlanCuentas(Border borderResaltar) {
		this.resaltarnombreListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrarnombreListadosPlanCuentas() {
		return this.mostrarnombreListadosPlanCuentas;
	}

	public void setMostrarnombreListadosPlanCuentas(Boolean mostrarnombreListadosPlanCuentas) {
		this.mostrarnombreListadosPlanCuentas= mostrarnombreListadosPlanCuentas;
	}

	public Boolean getActivarnombreListadosPlanCuentas() {
		return this.activarnombreListadosPlanCuentas;
	}

	public void setActivarnombreListadosPlanCuentas(Boolean activarnombreListadosPlanCuentas) {
		this.activarnombreListadosPlanCuentas= activarnombreListadosPlanCuentas;
	}

	public Border setResaltarnombre_nivel_cuentaListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltarnombre_nivel_cuentaListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_nivel_cuentaListadosPlanCuentas() {
		return this.resaltarnombre_nivel_cuentaListadosPlanCuentas;
	}

	public void setResaltarnombre_nivel_cuentaListadosPlanCuentas(Border borderResaltar) {
		this.resaltarnombre_nivel_cuentaListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrarnombre_nivel_cuentaListadosPlanCuentas() {
		return this.mostrarnombre_nivel_cuentaListadosPlanCuentas;
	}

	public void setMostrarnombre_nivel_cuentaListadosPlanCuentas(Boolean mostrarnombre_nivel_cuentaListadosPlanCuentas) {
		this.mostrarnombre_nivel_cuentaListadosPlanCuentas= mostrarnombre_nivel_cuentaListadosPlanCuentas;
	}

	public Boolean getActivarnombre_nivel_cuentaListadosPlanCuentas() {
		return this.activarnombre_nivel_cuentaListadosPlanCuentas;
	}

	public void setActivarnombre_nivel_cuentaListadosPlanCuentas(Boolean activarnombre_nivel_cuentaListadosPlanCuentas) {
		this.activarnombre_nivel_cuentaListadosPlanCuentas= activarnombre_nivel_cuentaListadosPlanCuentas;
	}

	public Border setResaltares_movimientoListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltares_movimientoListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_movimientoListadosPlanCuentas() {
		return this.resaltares_movimientoListadosPlanCuentas;
	}

	public void setResaltares_movimientoListadosPlanCuentas(Border borderResaltar) {
		this.resaltares_movimientoListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrares_movimientoListadosPlanCuentas() {
		return this.mostrares_movimientoListadosPlanCuentas;
	}

	public void setMostrares_movimientoListadosPlanCuentas(Boolean mostrares_movimientoListadosPlanCuentas) {
		this.mostrares_movimientoListadosPlanCuentas= mostrares_movimientoListadosPlanCuentas;
	}

	public Boolean getActivares_movimientoListadosPlanCuentas() {
		return this.activares_movimientoListadosPlanCuentas;
	}

	public void setActivares_movimientoListadosPlanCuentas(Boolean activares_movimientoListadosPlanCuentas) {
		this.activares_movimientoListadosPlanCuentas= activares_movimientoListadosPlanCuentas;
	}

	public Border setResaltares_centro_costoListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltares_centro_costoListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_centro_costoListadosPlanCuentas() {
		return this.resaltares_centro_costoListadosPlanCuentas;
	}

	public void setResaltares_centro_costoListadosPlanCuentas(Border borderResaltar) {
		this.resaltares_centro_costoListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrares_centro_costoListadosPlanCuentas() {
		return this.mostrares_centro_costoListadosPlanCuentas;
	}

	public void setMostrares_centro_costoListadosPlanCuentas(Boolean mostrares_centro_costoListadosPlanCuentas) {
		this.mostrares_centro_costoListadosPlanCuentas= mostrares_centro_costoListadosPlanCuentas;
	}

	public Boolean getActivares_centro_costoListadosPlanCuentas() {
		return this.activares_centro_costoListadosPlanCuentas;
	}

	public void setActivares_centro_costoListadosPlanCuentas(Boolean activares_centro_costoListadosPlanCuentas) {
		this.activares_centro_costoListadosPlanCuentas= activares_centro_costoListadosPlanCuentas;
	}

	public Border setResaltares_centro_actividadListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltares_centro_actividadListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_centro_actividadListadosPlanCuentas() {
		return this.resaltares_centro_actividadListadosPlanCuentas;
	}

	public void setResaltares_centro_actividadListadosPlanCuentas(Border borderResaltar) {
		this.resaltares_centro_actividadListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrares_centro_actividadListadosPlanCuentas() {
		return this.mostrares_centro_actividadListadosPlanCuentas;
	}

	public void setMostrares_centro_actividadListadosPlanCuentas(Boolean mostrares_centro_actividadListadosPlanCuentas) {
		this.mostrares_centro_actividadListadosPlanCuentas= mostrares_centro_actividadListadosPlanCuentas;
	}

	public Boolean getActivares_centro_actividadListadosPlanCuentas() {
		return this.activares_centro_actividadListadosPlanCuentas;
	}

	public void setActivares_centro_actividadListadosPlanCuentas(Boolean activares_centro_actividadListadosPlanCuentas) {
		this.activares_centro_actividadListadosPlanCuentas= activares_centro_actividadListadosPlanCuentas;
	}

	public Border setResaltares_para_f52ListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltares_para_f52ListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_para_f52ListadosPlanCuentas() {
		return this.resaltares_para_f52ListadosPlanCuentas;
	}

	public void setResaltares_para_f52ListadosPlanCuentas(Border borderResaltar) {
		this.resaltares_para_f52ListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrares_para_f52ListadosPlanCuentas() {
		return this.mostrares_para_f52ListadosPlanCuentas;
	}

	public void setMostrares_para_f52ListadosPlanCuentas(Boolean mostrares_para_f52ListadosPlanCuentas) {
		this.mostrares_para_f52ListadosPlanCuentas= mostrares_para_f52ListadosPlanCuentas;
	}

	public Boolean getActivares_para_f52ListadosPlanCuentas() {
		return this.activares_para_f52ListadosPlanCuentas;
	}

	public void setActivares_para_f52ListadosPlanCuentas(Boolean activares_para_f52ListadosPlanCuentas) {
		this.activares_para_f52ListadosPlanCuentas= activares_para_f52ListadosPlanCuentas;
	}

	public Border setResaltarordenListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadosplancuentasBeanSwingJInternalFrame.jTtoolBarListadosPlanCuentas.setBorder(borderResaltar);
		
		this.resaltarordenListadosPlanCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenListadosPlanCuentas() {
		return this.resaltarordenListadosPlanCuentas;
	}

	public void setResaltarordenListadosPlanCuentas(Border borderResaltar) {
		this.resaltarordenListadosPlanCuentas= borderResaltar;
	}

	public Boolean getMostrarordenListadosPlanCuentas() {
		return this.mostrarordenListadosPlanCuentas;
	}

	public void setMostrarordenListadosPlanCuentas(Boolean mostrarordenListadosPlanCuentas) {
		this.mostrarordenListadosPlanCuentas= mostrarordenListadosPlanCuentas;
	}

	public Boolean getActivarordenListadosPlanCuentas() {
		return this.activarordenListadosPlanCuentas;
	}

	public void setActivarordenListadosPlanCuentas(Boolean activarordenListadosPlanCuentas) {
		this.activarordenListadosPlanCuentas= activarordenListadosPlanCuentas;
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
		
		
		this.setMostraridListadosPlanCuentas(esInicial);
		this.setMostrarid_empresaListadosPlanCuentas(esInicial);
		this.setMostrarnombre_monedaListadosPlanCuentas(esInicial);
		this.setMostrarcodigoListadosPlanCuentas(esInicial);
		this.setMostrarnombreListadosPlanCuentas(esInicial);
		this.setMostrarnombre_nivel_cuentaListadosPlanCuentas(esInicial);
		this.setMostrares_movimientoListadosPlanCuentas(esInicial);
		this.setMostrares_centro_costoListadosPlanCuentas(esInicial);
		this.setMostrares_centro_actividadListadosPlanCuentas(esInicial);
		this.setMostrares_para_f52ListadosPlanCuentas(esInicial);
		this.setMostrarordenListadosPlanCuentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ID)) {
				this.setMostraridListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBREMONEDA)) {
				this.setMostrarnombre_monedaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBRENIVELCUENTA)) {
				this.setMostrarnombre_nivel_cuentaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESMOVIMIENTO)) {
				this.setMostrares_movimientoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROCOSTO)) {
				this.setMostrares_centro_costoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROACTIVIDAD)) {
				this.setMostrares_centro_actividadListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESPARAF52)) {
				this.setMostrares_para_f52ListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ORDEN)) {
				this.setMostrarordenListadosPlanCuentas(esAsigna);
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
		
		
		this.setActivaridListadosPlanCuentas(esInicial);
		this.setActivarid_empresaListadosPlanCuentas(esInicial);
		this.setActivarnombre_monedaListadosPlanCuentas(esInicial);
		this.setActivarcodigoListadosPlanCuentas(esInicial);
		this.setActivarnombreListadosPlanCuentas(esInicial);
		this.setActivarnombre_nivel_cuentaListadosPlanCuentas(esInicial);
		this.setActivares_movimientoListadosPlanCuentas(esInicial);
		this.setActivares_centro_costoListadosPlanCuentas(esInicial);
		this.setActivares_centro_actividadListadosPlanCuentas(esInicial);
		this.setActivares_para_f52ListadosPlanCuentas(esInicial);
		this.setActivarordenListadosPlanCuentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ID)) {
				this.setActivaridListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBREMONEDA)) {
				this.setActivarnombre_monedaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBRE)) {
				this.setActivarnombreListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBRENIVELCUENTA)) {
				this.setActivarnombre_nivel_cuentaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESMOVIMIENTO)) {
				this.setActivares_movimientoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROCOSTO)) {
				this.setActivares_centro_costoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROACTIVIDAD)) {
				this.setActivares_centro_actividadListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESPARAF52)) {
				this.setActivares_para_f52ListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ORDEN)) {
				this.setActivarordenListadosPlanCuentas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadosPlanCuentas(esInicial);
		this.setResaltarid_empresaListadosPlanCuentas(esInicial);
		this.setResaltarnombre_monedaListadosPlanCuentas(esInicial);
		this.setResaltarcodigoListadosPlanCuentas(esInicial);
		this.setResaltarnombreListadosPlanCuentas(esInicial);
		this.setResaltarnombre_nivel_cuentaListadosPlanCuentas(esInicial);
		this.setResaltares_movimientoListadosPlanCuentas(esInicial);
		this.setResaltares_centro_costoListadosPlanCuentas(esInicial);
		this.setResaltares_centro_actividadListadosPlanCuentas(esInicial);
		this.setResaltares_para_f52ListadosPlanCuentas(esInicial);
		this.setResaltarordenListadosPlanCuentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ID)) {
				this.setResaltaridListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBREMONEDA)) {
				this.setResaltarnombre_monedaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.NOMBRENIVELCUENTA)) {
				this.setResaltarnombre_nivel_cuentaListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESMOVIMIENTO)) {
				this.setResaltares_movimientoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROCOSTO)) {
				this.setResaltares_centro_costoListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESCENTROACTIVIDAD)) {
				this.setResaltares_centro_actividadListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ESPARAF52)) {
				this.setResaltares_para_f52ListadosPlanCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadosPlanCuentasConstantesFunciones.ORDEN)) {
				this.setResaltarordenListadosPlanCuentas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadosPlanCuentasListadosPlanCuentas=true;

	public Boolean getMostrarBusquedaListadosPlanCuentasListadosPlanCuentas() {
		return this.mostrarBusquedaListadosPlanCuentasListadosPlanCuentas;
	}

	public void setMostrarBusquedaListadosPlanCuentasListadosPlanCuentas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadosPlanCuentasListadosPlanCuentas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadosPlanCuentasListadosPlanCuentas=true;

	public Boolean getActivarBusquedaListadosPlanCuentasListadosPlanCuentas() {
		return this.activarBusquedaListadosPlanCuentasListadosPlanCuentas;
	}

	public void setActivarBusquedaListadosPlanCuentasListadosPlanCuentas(Boolean habilitarResaltar) {
		this.activarBusquedaListadosPlanCuentasListadosPlanCuentas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadosPlanCuentasListadosPlanCuentas=null;

	public Border getResaltarBusquedaListadosPlanCuentasListadosPlanCuentas() {
		return this.resaltarBusquedaListadosPlanCuentasListadosPlanCuentas;
	}

	public void setResaltarBusquedaListadosPlanCuentasListadosPlanCuentas(Border borderResaltar) {
		this.resaltarBusquedaListadosPlanCuentasListadosPlanCuentas= borderResaltar;
	}

	public void setResaltarBusquedaListadosPlanCuentasListadosPlanCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*ListadosPlanCuentasBeanSwingJInternalFrame listadosplancuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadosPlanCuentasListadosPlanCuentas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}