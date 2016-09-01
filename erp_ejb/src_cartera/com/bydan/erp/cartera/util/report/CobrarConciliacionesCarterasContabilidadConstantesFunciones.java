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


import com.bydan.erp.cartera.util.report.CobrarConciliacionesCarterasContabilidadConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarConciliacionesCarterasContabilidadParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarConciliacionesCarterasContabilidadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarConciliacionesCarterasContabilidadConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarConciliacionesCarterasContabilidad";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarConciliacionesCarterasContabilidad"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarConciliacionesCarterasContabilidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarConciliacionesCarterasContabilidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"_"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarConciliacionesCarterasContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"_"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"_"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarConciliacionesCarterasContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"_"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarConciliacionesCarterasContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarConciliacionesCarterasContabilidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarConciliacionesCarterasContabilidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarConciliacionesCarterasContabilidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Conciliaciones Carteras Contabilidades";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Conciliaciones Carteras Contabilidad";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Conciliaciones Carteras Contabilidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarConciliacionesCarterasContabilidad";
	public static final String OBJECTNAME="cobrarconciliacionescarterascontabilidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_conciliaciones_carteras_contabilidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarconciliacionescarterascontabilidad from "+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SPERSISTENCENAME+" cobrarconciliacionescarterascontabilidad";
	public static String QUERYSELECTNATIVE="select "+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".id,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".version_row,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".id_empresa,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".fecha_desde,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".fecha_hasta,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".codigo,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".codigo_tipo_movimiento,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".numero_mayor,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".debito_asiento,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".credito_asiento,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".debito_cuentas,"+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME+".credito_cuentas from "+CobrarConciliacionesCarterasContabilidadConstantesFunciones.SCHEMA+"."+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME;//+" as "+CobrarConciliacionesCarterasContabilidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGO= "codigo";
    public static final String CODIGOTIPOMOVIMIENTO= "codigo_tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String DEBITOASIENTO= "debito_asiento";
    public static final String CREDITOASIENTO= "credito_asiento";
    public static final String DEBITOCUENTAS= "debito_cuentas";
    public static final String CREDITOCUENTAS= "credito_cuentas";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_CODIGOTIPOMOVIMIENTO= "Codigo Tipo Movimiento";
		public static final String LABEL_CODIGOTIPOMOVIMIENTO_LOWER= "Codigo Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_DEBITOASIENTO= "Debito Asiento";
		public static final String LABEL_DEBITOASIENTO_LOWER= "Debito Asiento";
    	public static final String LABEL_CREDITOASIENTO= "Credito Asiento";
		public static final String LABEL_CREDITOASIENTO_LOWER= "Credito Asiento";
    	public static final String LABEL_DEBITOCUENTAS= "Debito Cuentas";
		public static final String LABEL_DEBITOCUENTAS_LOWER= "Debito Cuentas";
    	public static final String LABEL_CREDITOCUENTAS= "Credito Cuentas";
		public static final String LABEL_CREDITOCUENTAS_LOWER= "Credito Cuentas";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getCobrarConciliacionesCarterasContabilidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHADESDE)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHAHASTA)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOASIENTO;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOASIENTO;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOCUENTAS;}
		if(sNombreColumna.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS)) {sLabelColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOCUENTAS;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarConciliacionesCarterasContabilidadDescripcion(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarconciliacionescarterascontabilidad !=null/* && cobrarconciliacionescarterascontabilidad.getId()!=0*/) {
			sDescripcion=cobrarconciliacionescarterascontabilidad.getcodigo();//cobrarconciliacionescarterascontabilidadcobrarconciliacionescarterascontabilidad.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarConciliacionesCarterasContabilidadDescripcionDetallado(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad) {
		String sDescripcion="";
			
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.ID+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getId().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getVersionRow().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getid_empresa().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getid_cuenta_contable().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getfecha_desde().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getfecha_hasta().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getcodigo()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getcodigo_tipo_movimiento()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getnumero_mayor()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getdebito_asiento().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getcredito_asiento().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getdebito_cuentas().toString()+",";
		sDescripcion+=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS+"=";
		sDescripcion+=cobrarconciliacionescarterascontabilidad.getcredito_cuentas().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarConciliacionesCarterasContabilidadDescripcion(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,String sValor) throws Exception {			
		if(cobrarconciliacionescarterascontabilidad !=null) {
			cobrarconciliacionescarterascontabilidad.setcodigo(sValor);;//cobrarconciliacionescarterascontabilidadcobrarconciliacionescarterascontabilidad.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarConciliacionesCarterasContabilidad")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarConciliacionesCarterasContabilidad(Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarconciliacionescarterascontabilidad.setcodigo(cobrarconciliacionescarterascontabilidad.getcodigo().trim());
		cobrarconciliacionescarterascontabilidad.setcodigo_tipo_movimiento(cobrarconciliacionescarterascontabilidad.getcodigo_tipo_movimiento().trim());
		cobrarconciliacionescarterascontabilidad.setnumero_mayor(cobrarconciliacionescarterascontabilidad.getnumero_mayor().trim());
	}
	
	public static void quitarEspaciosCobrarConciliacionesCarterasContabilidads(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad: cobrarconciliacionescarterascontabilidads) {
			cobrarconciliacionescarterascontabilidad.setcodigo(cobrarconciliacionescarterascontabilidad.getcodigo().trim());
			cobrarconciliacionescarterascontabilidad.setcodigo_tipo_movimiento(cobrarconciliacionescarterascontabilidad.getcodigo_tipo_movimiento().trim());
			cobrarconciliacionescarterascontabilidad.setnumero_mayor(cobrarconciliacionescarterascontabilidad.getnumero_mayor().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarconciliacionescarterascontabilidad.getConCambioAuxiliar()) {
			cobrarconciliacionescarterascontabilidad.setIsDeleted(cobrarconciliacionescarterascontabilidad.getIsDeletedAuxiliar());	
			cobrarconciliacionescarterascontabilidad.setIsNew(cobrarconciliacionescarterascontabilidad.getIsNewAuxiliar());	
			cobrarconciliacionescarterascontabilidad.setIsChanged(cobrarconciliacionescarterascontabilidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarconciliacionescarterascontabilidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarconciliacionescarterascontabilidad.setIsDeletedAuxiliar(false);	
			cobrarconciliacionescarterascontabilidad.setIsNewAuxiliar(false);	
			cobrarconciliacionescarterascontabilidad.setIsChangedAuxiliar(false);
			
			cobrarconciliacionescarterascontabilidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarConciliacionesCarterasContabilidads(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad : cobrarconciliacionescarterascontabilidads) {
			if(conAsignarBase && cobrarconciliacionescarterascontabilidad.getConCambioAuxiliar()) {
				cobrarconciliacionescarterascontabilidad.setIsDeleted(cobrarconciliacionescarterascontabilidad.getIsDeletedAuxiliar());	
				cobrarconciliacionescarterascontabilidad.setIsNew(cobrarconciliacionescarterascontabilidad.getIsNewAuxiliar());	
				cobrarconciliacionescarterascontabilidad.setIsChanged(cobrarconciliacionescarterascontabilidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarconciliacionescarterascontabilidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarconciliacionescarterascontabilidad.setIsDeletedAuxiliar(false);	
				cobrarconciliacionescarterascontabilidad.setIsNewAuxiliar(false);	
				cobrarconciliacionescarterascontabilidad.setIsChangedAuxiliar(false);
				
				cobrarconciliacionescarterascontabilidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,Boolean conEnteros) throws Exception  {
		cobrarconciliacionescarterascontabilidad.setdebito_asiento(0.0);
		cobrarconciliacionescarterascontabilidad.setcredito_asiento(0.0);
		cobrarconciliacionescarterascontabilidad.setdebito_cuentas(0.0);
		cobrarconciliacionescarterascontabilidad.setcredito_cuentas(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarConciliacionesCarterasContabilidads(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,Boolean conEnteros) throws Exception  {
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad: cobrarconciliacionescarterascontabilidads) {
			cobrarconciliacionescarterascontabilidad.setdebito_asiento(0.0);
			cobrarconciliacionescarterascontabilidad.setcredito_asiento(0.0);
			cobrarconciliacionescarterascontabilidad.setdebito_cuentas(0.0);
			cobrarconciliacionescarterascontabilidad.setcredito_cuentas(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarConciliacionesCarterasContabilidad(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAux) throws Exception  {
		CobrarConciliacionesCarterasContabilidadConstantesFunciones.InicializarValoresCobrarConciliacionesCarterasContabilidad(cobrarconciliacionescarterascontabilidadAux,true);
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad: cobrarconciliacionescarterascontabilidads) {
			if(cobrarconciliacionescarterascontabilidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarconciliacionescarterascontabilidadAux.setdebito_asiento(cobrarconciliacionescarterascontabilidadAux.getdebito_asiento()+cobrarconciliacionescarterascontabilidad.getdebito_asiento());			
			cobrarconciliacionescarterascontabilidadAux.setcredito_asiento(cobrarconciliacionescarterascontabilidadAux.getcredito_asiento()+cobrarconciliacionescarterascontabilidad.getcredito_asiento());			
			cobrarconciliacionescarterascontabilidadAux.setdebito_cuentas(cobrarconciliacionescarterascontabilidadAux.getdebito_cuentas()+cobrarconciliacionescarterascontabilidad.getdebito_cuentas());			
			cobrarconciliacionescarterascontabilidadAux.setcredito_cuentas(cobrarconciliacionescarterascontabilidadAux.getcredito_cuentas()+cobrarconciliacionescarterascontabilidad.getcredito_cuentas());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarConciliacionesCarterasContabilidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarConciliacionesCarterasContabilidadConstantesFunciones.getArrayColumnasGlobalesCobrarConciliacionesCarterasContabilidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarConciliacionesCarterasContabilidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarConciliacionesCarterasContabilidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAux: cobrarconciliacionescarterascontabilidads) {
			if(cobrarconciliacionescarterascontabilidadAux!=null && cobrarconciliacionescarterascontabilidad!=null) {
				if((cobrarconciliacionescarterascontabilidadAux.getId()==null && cobrarconciliacionescarterascontabilidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarconciliacionescarterascontabilidadAux.getId()!=null && cobrarconciliacionescarterascontabilidad.getId()!=null){
					if(cobrarconciliacionescarterascontabilidadAux.getId().equals(cobrarconciliacionescarterascontabilidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarConciliacionesCarterasContabilidad(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_asientoTotal=0.0;
		Double credito_asientoTotal=0.0;
		Double debito_cuentasTotal=0.0;
		Double credito_cuentasTotal=0.0;
	
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad: cobrarconciliacionescarterascontabilidads) {			
			if(cobrarconciliacionescarterascontabilidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_asientoTotal+=cobrarconciliacionescarterascontabilidad.getdebito_asiento();
			credito_asientoTotal+=cobrarconciliacionescarterascontabilidad.getcredito_asiento();
			debito_cuentasTotal+=cobrarconciliacionescarterascontabilidad.getdebito_cuentas();
			credito_cuentasTotal+=cobrarconciliacionescarterascontabilidad.getcredito_cuentas();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOASIENTO);
		datoGeneral.setdValorDouble(debito_asientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOASIENTO);
		datoGeneral.setdValorDouble(credito_asientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOCUENTAS);
		datoGeneral.setdValorDouble(debito_cuentasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOCUENTAS);
		datoGeneral.setdValorDouble(credito_cuentasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarConciliacionesCarterasContabilidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_ID, CobrarConciliacionesCarterasContabilidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_VERSIONROW, CobrarConciliacionesCarterasContabilidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGO, CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO, CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_NUMEROMAYOR, CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOASIENTO, CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOASIENTO, CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOCUENTAS, CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOCUENTAS, CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarConciliacionesCarterasContabilidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarConciliacionesCarterasContabilidad() throws Exception  {
		return CobrarConciliacionesCarterasContabilidadConstantesFunciones.getTiposSeleccionarCobrarConciliacionesCarterasContabilidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarConciliacionesCarterasContabilidad(Boolean conFk) throws Exception  {
		return CobrarConciliacionesCarterasContabilidadConstantesFunciones.getTiposSeleccionarCobrarConciliacionesCarterasContabilidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarConciliacionesCarterasContabilidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOASIENTO);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOASIENTO);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOCUENTAS);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOCUENTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOCUENTAS);
			reporte.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOCUENTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarConciliacionesCarterasContabilidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAux) throws Exception {
		
			cobrarconciliacionescarterascontabilidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarconciliacionescarterascontabilidadAux.getEmpresa()));
			cobrarconciliacionescarterascontabilidadAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cobrarconciliacionescarterascontabilidadAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarConciliacionesCarterasContabilidad(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidadsTemp) throws Exception {
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAux:cobrarconciliacionescarterascontabilidadsTemp) {
			
			cobrarconciliacionescarterascontabilidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarconciliacionescarterascontabilidadAux.getEmpresa()));
			cobrarconciliacionescarterascontabilidadAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cobrarconciliacionescarterascontabilidadAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarConciliacionesCarterasContabilidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarConciliacionesCarterasContabilidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarConciliacionesCarterasContabilidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarConciliacionesCarterasContabilidadConstantesFunciones.getClassesRelationshipsOfCobrarConciliacionesCarterasContabilidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarConciliacionesCarterasContabilidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarConciliacionesCarterasContabilidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarConciliacionesCarterasContabilidadConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarConciliacionesCarterasContabilidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarConciliacionesCarterasContabilidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads) throws Exception {
		try	{			
			for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadLocal:cobrarconciliacionescarterascontabilidads) {
				if(cobrarconciliacionescarterascontabilidadLocal.getId().equals(cobrarconciliacionescarterascontabilidad.getId())) {
					cobrarconciliacionescarterascontabilidadLocal.setIsSelected(cobrarconciliacionescarterascontabilidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarConciliacionesCarterasContabilidad(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidadsAux) throws Exception {
		//this.cobrarconciliacionescarterascontabilidadsAux=cobrarconciliacionescarterascontabilidadsAux;
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAux:cobrarconciliacionescarterascontabilidadsAux) {
			if(cobrarconciliacionescarterascontabilidadAux.getIsChanged()) {
				cobrarconciliacionescarterascontabilidadAux.setIsChanged(false);
			}		
			
			if(cobrarconciliacionescarterascontabilidadAux.getIsNew()) {
				cobrarconciliacionescarterascontabilidadAux.setIsNew(false);
			}	
			
			if(cobrarconciliacionescarterascontabilidadAux.getIsDeleted()) {
				cobrarconciliacionescarterascontabilidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAux) throws Exception {
		//this.cobrarconciliacionescarterascontabilidadAux=cobrarconciliacionescarterascontabilidadAux;
		
			if(cobrarconciliacionescarterascontabilidadAux.getIsChanged()) {
				cobrarconciliacionescarterascontabilidadAux.setIsChanged(false);
			}		
			
			if(cobrarconciliacionescarterascontabilidadAux.getIsNew()) {
				cobrarconciliacionescarterascontabilidadAux.setIsNew(false);
			}	
			
			if(cobrarconciliacionescarterascontabilidadAux.getIsDeleted()) {
				cobrarconciliacionescarterascontabilidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAsignar,CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad) throws Exception {
		cobrarconciliacionescarterascontabilidadAsignar.setId(cobrarconciliacionescarterascontabilidad.getId());	
		cobrarconciliacionescarterascontabilidadAsignar.setVersionRow(cobrarconciliacionescarterascontabilidad.getVersionRow());	
		cobrarconciliacionescarterascontabilidadAsignar.setcodigo(cobrarconciliacionescarterascontabilidad.getcodigo());	
		cobrarconciliacionescarterascontabilidadAsignar.setcodigo_tipo_movimiento(cobrarconciliacionescarterascontabilidad.getcodigo_tipo_movimiento());	
		cobrarconciliacionescarterascontabilidadAsignar.setnumero_mayor(cobrarconciliacionescarterascontabilidad.getnumero_mayor());	
		cobrarconciliacionescarterascontabilidadAsignar.setdebito_asiento(cobrarconciliacionescarterascontabilidad.getdebito_asiento());	
		cobrarconciliacionescarterascontabilidadAsignar.setcredito_asiento(cobrarconciliacionescarterascontabilidad.getcredito_asiento());	
		cobrarconciliacionescarterascontabilidadAsignar.setdebito_cuentas(cobrarconciliacionescarterascontabilidad.getdebito_cuentas());	
		cobrarconciliacionescarterascontabilidadAsignar.setcredito_cuentas(cobrarconciliacionescarterascontabilidad.getcredito_cuentas());	
	}
	
	public static void inicializarCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad) throws Exception {
		try {
				cobrarconciliacionescarterascontabilidad.setId(0L);	
					
				cobrarconciliacionescarterascontabilidad.setcodigo("");	
				cobrarconciliacionescarterascontabilidad.setcodigo_tipo_movimiento("");	
				cobrarconciliacionescarterascontabilidad.setnumero_mayor("");	
				cobrarconciliacionescarterascontabilidad.setdebito_asiento(0.0);	
				cobrarconciliacionescarterascontabilidad.setcredito_asiento(0.0);	
				cobrarconciliacionescarterascontabilidad.setdebito_cuentas(0.0);	
				cobrarconciliacionescarterascontabilidad.setcredito_cuentas(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarConciliacionesCarterasContabilidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOCUENTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOCUENTAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarConciliacionesCarterasContabilidad(String sTipo,Row row,Workbook workbook,CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getcodigo_tipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getdebito_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getcredito_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getdebito_cuentas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarconciliacionescarterascontabilidad.getcredito_cuentas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarConciliacionesCarterasContabilidad="";
	
	public String getsFinalQueryCobrarConciliacionesCarterasContabilidad() {
		return this.sFinalQueryCobrarConciliacionesCarterasContabilidad;
	}
	
	public void setsFinalQueryCobrarConciliacionesCarterasContabilidad(String sFinalQueryCobrarConciliacionesCarterasContabilidad) {
		this.sFinalQueryCobrarConciliacionesCarterasContabilidad= sFinalQueryCobrarConciliacionesCarterasContabilidad;
	}
	
	public Border resaltarSeleccionarCobrarConciliacionesCarterasContabilidad=null;
	
	public Border setResaltarSeleccionarCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarConciliacionesCarterasContabilidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarSeleccionarCobrarConciliacionesCarterasContabilidad;
	}
	
	public void setResaltarSeleccionarCobrarConciliacionesCarterasContabilidad(Border borderResaltarSeleccionarCobrarConciliacionesCarterasContabilidad) {
		this.resaltarSeleccionarCobrarConciliacionesCarterasContabilidad= borderResaltarSeleccionarCobrarConciliacionesCarterasContabilidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostraridCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activaridCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltarid_empresaCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarid_empresaCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarid_empresaCobrarConciliacionesCarterasContabilidad=true;
	public Boolean cargarid_empresaCobrarConciliacionesCarterasContabilidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarConciliacionesCarterasContabilidad=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarid_cuenta_contableCobrarConciliacionesCarterasContabilidad=true;
	public Boolean cargarid_cuenta_contableCobrarConciliacionesCarterasContabilidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCobrarConciliacionesCarterasContabilidad=false;//ConEventDepend=true

	public Border resaltarfecha_desdeCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarfecha_desdeCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarfecha_desdeCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltarfecha_hastaCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarfecha_hastaCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarfecha_hastaCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltarcodigoCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarcodigoCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarcodigoCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltarnumero_mayorCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarnumero_mayorCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarnumero_mayorCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltardebito_asientoCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrardebito_asientoCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activardebito_asientoCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltarcredito_asientoCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarcredito_asientoCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarcredito_asientoCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltardebito_cuentasCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrardebito_cuentasCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activardebito_cuentasCobrarConciliacionesCarterasContabilidad=true;

	public Border resaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad=null;
	public Boolean mostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad=true;
	public Boolean activarcredito_cuentasCobrarConciliacionesCarterasContabilidad=true;

	
	

	public Border setResaltaridCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltaridCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarConciliacionesCarterasContabilidad() {
		return this.resaltaridCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltaridCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltaridCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostraridCobrarConciliacionesCarterasContabilidad() {
		return this.mostraridCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostraridCobrarConciliacionesCarterasContabilidad(Boolean mostraridCobrarConciliacionesCarterasContabilidad) {
		this.mostraridCobrarConciliacionesCarterasContabilidad= mostraridCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivaridCobrarConciliacionesCarterasContabilidad() {
		return this.activaridCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivaridCobrarConciliacionesCarterasContabilidad(Boolean activaridCobrarConciliacionesCarterasContabilidad) {
		this.activaridCobrarConciliacionesCarterasContabilidad= activaridCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarid_empresaCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarid_empresaCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarid_empresaCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarid_empresaCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarid_empresaCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarid_empresaCobrarConciliacionesCarterasContabilidad(Boolean mostrarid_empresaCobrarConciliacionesCarterasContabilidad) {
		this.mostrarid_empresaCobrarConciliacionesCarterasContabilidad= mostrarid_empresaCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarid_empresaCobrarConciliacionesCarterasContabilidad() {
		return this.activarid_empresaCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarid_empresaCobrarConciliacionesCarterasContabilidad(Boolean activarid_empresaCobrarConciliacionesCarterasContabilidad) {
		this.activarid_empresaCobrarConciliacionesCarterasContabilidad= activarid_empresaCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getCargarid_empresaCobrarConciliacionesCarterasContabilidad() {
		return this.cargarid_empresaCobrarConciliacionesCarterasContabilidad;
	}

	public void setCargarid_empresaCobrarConciliacionesCarterasContabilidad(Boolean cargarid_empresaCobrarConciliacionesCarterasContabilidad) {
		this.cargarid_empresaCobrarConciliacionesCarterasContabilidad= cargarid_empresaCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(Boolean mostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad) {
		this.mostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad= mostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarid_cuenta_contableCobrarConciliacionesCarterasContabilidad() {
		return this.activarid_cuenta_contableCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(Boolean activarid_cuenta_contableCobrarConciliacionesCarterasContabilidad) {
		this.activarid_cuenta_contableCobrarConciliacionesCarterasContabilidad= activarid_cuenta_contableCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getCargarid_cuenta_contableCobrarConciliacionesCarterasContabilidad() {
		return this.cargarid_cuenta_contableCobrarConciliacionesCarterasContabilidad;
	}

	public void setCargarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(Boolean cargarid_cuenta_contableCobrarConciliacionesCarterasContabilidad) {
		this.cargarid_cuenta_contableCobrarConciliacionesCarterasContabilidad= cargarid_cuenta_contableCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarfecha_desdeCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarfecha_desdeCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarfecha_desdeCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarfecha_desdeCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarfecha_desdeCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarfecha_desdeCobrarConciliacionesCarterasContabilidad(Boolean mostrarfecha_desdeCobrarConciliacionesCarterasContabilidad) {
		this.mostrarfecha_desdeCobrarConciliacionesCarterasContabilidad= mostrarfecha_desdeCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarfecha_desdeCobrarConciliacionesCarterasContabilidad() {
		return this.activarfecha_desdeCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarfecha_desdeCobrarConciliacionesCarterasContabilidad(Boolean activarfecha_desdeCobrarConciliacionesCarterasContabilidad) {
		this.activarfecha_desdeCobrarConciliacionesCarterasContabilidad= activarfecha_desdeCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarfecha_hastaCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarfecha_hastaCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarfecha_hastaCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarfecha_hastaCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarfecha_hastaCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarfecha_hastaCobrarConciliacionesCarterasContabilidad(Boolean mostrarfecha_hastaCobrarConciliacionesCarterasContabilidad) {
		this.mostrarfecha_hastaCobrarConciliacionesCarterasContabilidad= mostrarfecha_hastaCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarfecha_hastaCobrarConciliacionesCarterasContabilidad() {
		return this.activarfecha_hastaCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarfecha_hastaCobrarConciliacionesCarterasContabilidad(Boolean activarfecha_hastaCobrarConciliacionesCarterasContabilidad) {
		this.activarfecha_hastaCobrarConciliacionesCarterasContabilidad= activarfecha_hastaCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarcodigoCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarcodigoCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarcodigoCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarcodigoCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarcodigoCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarcodigoCobrarConciliacionesCarterasContabilidad(Boolean mostrarcodigoCobrarConciliacionesCarterasContabilidad) {
		this.mostrarcodigoCobrarConciliacionesCarterasContabilidad= mostrarcodigoCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarcodigoCobrarConciliacionesCarterasContabilidad() {
		return this.activarcodigoCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarcodigoCobrarConciliacionesCarterasContabilidad(Boolean activarcodigoCobrarConciliacionesCarterasContabilidad) {
		this.activarcodigoCobrarConciliacionesCarterasContabilidad= activarcodigoCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(Boolean mostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad) {
		this.mostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad= mostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad() {
		return this.activarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(Boolean activarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad) {
		this.activarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad= activarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarnumero_mayorCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarnumero_mayorCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarnumero_mayorCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarnumero_mayorCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarnumero_mayorCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarnumero_mayorCobrarConciliacionesCarterasContabilidad(Boolean mostrarnumero_mayorCobrarConciliacionesCarterasContabilidad) {
		this.mostrarnumero_mayorCobrarConciliacionesCarterasContabilidad= mostrarnumero_mayorCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarnumero_mayorCobrarConciliacionesCarterasContabilidad() {
		return this.activarnumero_mayorCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarnumero_mayorCobrarConciliacionesCarterasContabilidad(Boolean activarnumero_mayorCobrarConciliacionesCarterasContabilidad) {
		this.activarnumero_mayorCobrarConciliacionesCarterasContabilidad= activarnumero_mayorCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltardebito_asientoCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltardebito_asientoCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_asientoCobrarConciliacionesCarterasContabilidad() {
		return this.resaltardebito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltardebito_asientoCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltardebito_asientoCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrardebito_asientoCobrarConciliacionesCarterasContabilidad() {
		return this.mostrardebito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrardebito_asientoCobrarConciliacionesCarterasContabilidad(Boolean mostrardebito_asientoCobrarConciliacionesCarterasContabilidad) {
		this.mostrardebito_asientoCobrarConciliacionesCarterasContabilidad= mostrardebito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivardebito_asientoCobrarConciliacionesCarterasContabilidad() {
		return this.activardebito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivardebito_asientoCobrarConciliacionesCarterasContabilidad(Boolean activardebito_asientoCobrarConciliacionesCarterasContabilidad) {
		this.activardebito_asientoCobrarConciliacionesCarterasContabilidad= activardebito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarcredito_asientoCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarcredito_asientoCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_asientoCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarcredito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarcredito_asientoCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarcredito_asientoCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarcredito_asientoCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarcredito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarcredito_asientoCobrarConciliacionesCarterasContabilidad(Boolean mostrarcredito_asientoCobrarConciliacionesCarterasContabilidad) {
		this.mostrarcredito_asientoCobrarConciliacionesCarterasContabilidad= mostrarcredito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarcredito_asientoCobrarConciliacionesCarterasContabilidad() {
		return this.activarcredito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarcredito_asientoCobrarConciliacionesCarterasContabilidad(Boolean activarcredito_asientoCobrarConciliacionesCarterasContabilidad) {
		this.activarcredito_asientoCobrarConciliacionesCarterasContabilidad= activarcredito_asientoCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltardebito_cuentasCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltardebito_cuentasCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_cuentasCobrarConciliacionesCarterasContabilidad() {
		return this.resaltardebito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltardebito_cuentasCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltardebito_cuentasCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrardebito_cuentasCobrarConciliacionesCarterasContabilidad() {
		return this.mostrardebito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrardebito_cuentasCobrarConciliacionesCarterasContabilidad(Boolean mostrardebito_cuentasCobrarConciliacionesCarterasContabilidad) {
		this.mostrardebito_cuentasCobrarConciliacionesCarterasContabilidad= mostrardebito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivardebito_cuentasCobrarConciliacionesCarterasContabilidad() {
		return this.activardebito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivardebito_cuentasCobrarConciliacionesCarterasContabilidad(Boolean activardebito_cuentasCobrarConciliacionesCarterasContabilidad) {
		this.activardebito_cuentasCobrarConciliacionesCarterasContabilidad= activardebito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public Border setResaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame.jTtoolBarCobrarConciliacionesCarterasContabilidad.setBorder(borderResaltar);
		
		this.resaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public Boolean getMostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad(Boolean mostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad) {
		this.mostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad= mostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public Boolean getActivarcredito_cuentasCobrarConciliacionesCarterasContabilidad() {
		return this.activarcredito_cuentasCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarcredito_cuentasCobrarConciliacionesCarterasContabilidad(Boolean activarcredito_cuentasCobrarConciliacionesCarterasContabilidad) {
		this.activarcredito_cuentasCobrarConciliacionesCarterasContabilidad= activarcredito_cuentasCobrarConciliacionesCarterasContabilidad;
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
		
		
		this.setMostraridCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarid_empresaCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarfecha_desdeCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarfecha_hastaCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarcodigoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarnumero_mayorCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrardebito_asientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarcredito_asientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrardebito_cuentasCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setMostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.ID)) {
				this.setMostraridCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setMostrarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO)) {
				this.setMostrardebito_asientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO)) {
				this.setMostrarcredito_asientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS)) {
				this.setMostrardebito_cuentasCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS)) {
				this.setMostrarcredito_cuentasCobrarConciliacionesCarterasContabilidad(esAsigna);
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
		
		
		this.setActivaridCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarid_empresaCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarfecha_desdeCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarfecha_hastaCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarcodigoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarnumero_mayorCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivardebito_asientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarcredito_asientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivardebito_cuentasCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setActivarcredito_cuentasCobrarConciliacionesCarterasContabilidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.ID)) {
				this.setActivaridCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setActivarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO)) {
				this.setActivardebito_asientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO)) {
				this.setActivarcredito_asientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS)) {
				this.setActivardebito_cuentasCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS)) {
				this.setActivarcredito_cuentasCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarid_empresaCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarfecha_desdeCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarfecha_hastaCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarcodigoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarnumero_mayorCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltardebito_asientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarcredito_asientoCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltardebito_cuentasCobrarConciliacionesCarterasContabilidad(esInicial);
		this.setResaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.ID)) {
				this.setResaltaridCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setResaltarcodigo_tipo_movimientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO)) {
				this.setResaltardebito_asientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO)) {
				this.setResaltarcredito_asientoCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS)) {
				this.setResaltardebito_cuentasCobrarConciliacionesCarterasContabilidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS)) {
				this.setResaltarcredito_cuentasCobrarConciliacionesCarterasContabilidad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad=true;

	public Boolean getMostrarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad() {
		return this.mostrarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad;
	}

	public void setMostrarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad=true;

	public Boolean getActivarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad() {
		return this.activarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad;
	}

	public void setActivarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad=null;

	public Border getResaltarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad() {
		return this.resaltarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad;
	}

	public void setResaltarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad(Border borderResaltar) {
		this.resaltarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}

	public void setResaltarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarConciliacionesCarterasContabilidadBeanSwingJInternalFrame cobrarconciliacionescarterascontabilidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarConciliacionesCarterasContabilidadCobrarConciliacionesCarterasContabilidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}