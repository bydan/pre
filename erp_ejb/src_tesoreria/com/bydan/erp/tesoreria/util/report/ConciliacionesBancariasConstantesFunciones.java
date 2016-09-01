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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConciliacionesBancariasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ConciliacionesBancarias";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConciliacionesBancarias"+ConciliacionesBancariasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConciliacionesBancariasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConciliacionesBancariasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+ConciliacionesBancariasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+ConciliacionesBancariasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+ConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+ConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConciliacionesBancariasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConciliacionesBancariasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConciliacionesBancariasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConciliacionesBancariasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Conciliaciones Bancariases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Conciliaciones Bancarias";
	public static final String SCLASSWEBTITULO_LOWER="Conciliaciones Bancarias";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConciliacionesBancarias";
	public static final String OBJECTNAME="conciliacionesbancarias";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="conciliaciones_bancarias";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select conciliacionesbancarias from "+ConciliacionesBancariasConstantesFunciones.SPERSISTENCENAME+" conciliacionesbancarias";
	public static String QUERYSELECTNATIVE="select "+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".id,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".version_row,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".id_empresa,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".id_cuenta_contable,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".fecha_desde,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".fecha_hasta,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".numero_mayor,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".codigo_cuenta,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".nombre_cuenta,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".debito_local,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".credito_local,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".numero_deposito,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".debito_extran,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".credito_extran,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".fecha,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".detalle,"+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME+".beneficiario from "+ConciliacionesBancariasConstantesFunciones.SCHEMA+"."+ConciliacionesBancariasConstantesFunciones.TABLENAME;//+" as "+ConciliacionesBancariasConstantesFunciones.TABLENAME;
	
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
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String CODIGOCUENTA= "codigo_cuenta";
    public static final String NOMBRECUENTA= "nombre_cuenta";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String NUMERODEPOSITO= "numero_deposito";
    public static final String DEBITOEXTRAN= "debito_extran";
    public static final String CREDITOEXTRAN= "credito_extran";
    public static final String FECHA= "fecha";
    public static final String DETALLE= "detalle";
    public static final String BENEFICIARIO= "beneficiario";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_CODIGOCUENTA= "Codigo Cuenta";
		public static final String LABEL_CODIGOCUENTA_LOWER= "Codigo Cuenta";
    	public static final String LABEL_NOMBRECUENTA= "Nombre Cuenta";
		public static final String LABEL_NOMBRECUENTA_LOWER= "Nombre Cuenta";
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_NUMERODEPOSITO= "Numero Deposito";
		public static final String LABEL_NUMERODEPOSITO_LOWER= "Numero Deposito";
    	public static final String LABEL_DEBITOEXTRAN= "Debito Extran";
		public static final String LABEL_DEBITOEXTRAN_LOWER= "Debito Extran";
    	public static final String LABEL_CREDITOEXTRAN= "Credito Extran";
		public static final String LABEL_CREDITOEXTRAN_LOWER= "Credito Extran";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_DEPOSITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DEPOSITO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getConciliacionesBancariasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.FECHADESDE)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_NUMERODEPOSITO;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOEXTRAN;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOEXTRAN;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.FECHA)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.DETALLE)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(ConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {sLabelColumna=ConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConciliacionesBancariasDescripcion(ConciliacionesBancarias conciliacionesbancarias) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(conciliacionesbancarias !=null/* && conciliacionesbancarias.getId()!=0*/) {
			sDescripcion=conciliacionesbancarias.getfecha_desde().toString();//conciliacionesbancariasconciliacionesbancarias.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getConciliacionesBancariasDescripcionDetallado(ConciliacionesBancarias conciliacionesbancarias) {
		String sDescripcion="";
			
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.ID+"=";
		sDescripcion+=conciliacionesbancarias.getId().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=conciliacionesbancarias.getVersionRow().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=conciliacionesbancarias.getid_empresa().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=conciliacionesbancarias.getid_cuenta_contable().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=conciliacionesbancarias.getfecha_desde().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=conciliacionesbancarias.getfecha_hasta().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=conciliacionesbancarias.getnumero_mayor()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA+"=";
		sDescripcion+=conciliacionesbancarias.getcodigo_cuenta()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA+"=";
		sDescripcion+=conciliacionesbancarias.getnombre_cuenta()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=conciliacionesbancarias.getdebito_local().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=conciliacionesbancarias.getcredito_local().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO+"=";
		sDescripcion+=conciliacionesbancarias.getnumero_deposito()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN+"=";
		sDescripcion+=conciliacionesbancarias.getdebito_extran().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN+"=";
		sDescripcion+=conciliacionesbancarias.getcredito_extran().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.FECHA+"=";
		sDescripcion+=conciliacionesbancarias.getfecha().toString()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.DETALLE+"=";
		sDescripcion+=conciliacionesbancarias.getdetalle()+",";
		sDescripcion+=ConciliacionesBancariasConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=conciliacionesbancarias.getbeneficiario()+",";
			
		return sDescripcion;
	}
	
	public static void setConciliacionesBancariasDescripcion(ConciliacionesBancarias conciliacionesbancarias,String sValor) throws Exception {			
		if(conciliacionesbancarias !=null) {
			//conciliacionesbancariasconciliacionesbancarias.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaConciliacionesBancarias")) {
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

	public static String getDetalleIndiceBusquedaConciliacionesBancarias(Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosConciliacionesBancarias(ConciliacionesBancarias conciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		conciliacionesbancarias.setnumero_mayor(conciliacionesbancarias.getnumero_mayor().trim());
		conciliacionesbancarias.setcodigo_cuenta(conciliacionesbancarias.getcodigo_cuenta().trim());
		conciliacionesbancarias.setnombre_cuenta(conciliacionesbancarias.getnombre_cuenta().trim());
		conciliacionesbancarias.setnumero_deposito(conciliacionesbancarias.getnumero_deposito().trim());
		conciliacionesbancarias.setdetalle(conciliacionesbancarias.getdetalle().trim());
		conciliacionesbancarias.setbeneficiario(conciliacionesbancarias.getbeneficiario().trim());
	}
	
	public static void quitarEspaciosConciliacionesBancariass(List<ConciliacionesBancarias> conciliacionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConciliacionesBancarias conciliacionesbancarias: conciliacionesbancariass) {
			conciliacionesbancarias.setnumero_mayor(conciliacionesbancarias.getnumero_mayor().trim());
			conciliacionesbancarias.setcodigo_cuenta(conciliacionesbancarias.getcodigo_cuenta().trim());
			conciliacionesbancarias.setnombre_cuenta(conciliacionesbancarias.getnombre_cuenta().trim());
			conciliacionesbancarias.setnumero_deposito(conciliacionesbancarias.getnumero_deposito().trim());
			conciliacionesbancarias.setdetalle(conciliacionesbancarias.getdetalle().trim());
			conciliacionesbancarias.setbeneficiario(conciliacionesbancarias.getbeneficiario().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConciliacionesBancarias(ConciliacionesBancarias conciliacionesbancarias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && conciliacionesbancarias.getConCambioAuxiliar()) {
			conciliacionesbancarias.setIsDeleted(conciliacionesbancarias.getIsDeletedAuxiliar());	
			conciliacionesbancarias.setIsNew(conciliacionesbancarias.getIsNewAuxiliar());	
			conciliacionesbancarias.setIsChanged(conciliacionesbancarias.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			conciliacionesbancarias.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			conciliacionesbancarias.setIsDeletedAuxiliar(false);	
			conciliacionesbancarias.setIsNewAuxiliar(false);	
			conciliacionesbancarias.setIsChangedAuxiliar(false);
			
			conciliacionesbancarias.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConciliacionesBancariass(List<ConciliacionesBancarias> conciliacionesbancariass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConciliacionesBancarias conciliacionesbancarias : conciliacionesbancariass) {
			if(conAsignarBase && conciliacionesbancarias.getConCambioAuxiliar()) {
				conciliacionesbancarias.setIsDeleted(conciliacionesbancarias.getIsDeletedAuxiliar());	
				conciliacionesbancarias.setIsNew(conciliacionesbancarias.getIsNewAuxiliar());	
				conciliacionesbancarias.setIsChanged(conciliacionesbancarias.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				conciliacionesbancarias.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				conciliacionesbancarias.setIsDeletedAuxiliar(false);	
				conciliacionesbancarias.setIsNewAuxiliar(false);	
				conciliacionesbancarias.setIsChangedAuxiliar(false);
				
				conciliacionesbancarias.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConciliacionesBancarias(ConciliacionesBancarias conciliacionesbancarias,Boolean conEnteros) throws Exception  {
		conciliacionesbancarias.setdebito_local(0.0);
		conciliacionesbancarias.setcredito_local(0.0);
		conciliacionesbancarias.setdebito_extran(0.0);
		conciliacionesbancarias.setcredito_extran(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConciliacionesBancariass(List<ConciliacionesBancarias> conciliacionesbancariass,Boolean conEnteros) throws Exception  {
		
		for(ConciliacionesBancarias conciliacionesbancarias: conciliacionesbancariass) {
			conciliacionesbancarias.setdebito_local(0.0);
			conciliacionesbancarias.setcredito_local(0.0);
			conciliacionesbancarias.setdebito_extran(0.0);
			conciliacionesbancarias.setcredito_extran(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConciliacionesBancarias(List<ConciliacionesBancarias> conciliacionesbancariass,ConciliacionesBancarias conciliacionesbancariasAux) throws Exception  {
		ConciliacionesBancariasConstantesFunciones.InicializarValoresConciliacionesBancarias(conciliacionesbancariasAux,true);
		
		for(ConciliacionesBancarias conciliacionesbancarias: conciliacionesbancariass) {
			if(conciliacionesbancarias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			conciliacionesbancariasAux.setdebito_local(conciliacionesbancariasAux.getdebito_local()+conciliacionesbancarias.getdebito_local());			
			conciliacionesbancariasAux.setcredito_local(conciliacionesbancariasAux.getcredito_local()+conciliacionesbancarias.getcredito_local());			
			conciliacionesbancariasAux.setdebito_extran(conciliacionesbancariasAux.getdebito_extran()+conciliacionesbancarias.getdebito_extran());			
			conciliacionesbancariasAux.setcredito_extran(conciliacionesbancariasAux.getcredito_extran()+conciliacionesbancarias.getcredito_extran());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConciliacionesBancariasConstantesFunciones.getArrayColumnasGlobalesConciliacionesBancarias(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConciliacionesBancariasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConciliacionesBancarias> conciliacionesbancariass,ConciliacionesBancarias conciliacionesbancarias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConciliacionesBancarias conciliacionesbancariasAux: conciliacionesbancariass) {
			if(conciliacionesbancariasAux!=null && conciliacionesbancarias!=null) {
				if((conciliacionesbancariasAux.getId()==null && conciliacionesbancarias.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(conciliacionesbancariasAux.getId()!=null && conciliacionesbancarias.getId()!=null){
					if(conciliacionesbancariasAux.getId().equals(conciliacionesbancarias.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConciliacionesBancarias(List<ConciliacionesBancarias> conciliacionesbancariass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double debito_extranTotal=0.0;
		Double credito_extranTotal=0.0;
	
		for(ConciliacionesBancarias conciliacionesbancarias: conciliacionesbancariass) {			
			if(conciliacionesbancarias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=conciliacionesbancarias.getdebito_local();
			credito_localTotal+=conciliacionesbancarias.getcredito_local();
			debito_extranTotal+=conciliacionesbancarias.getdebito_extran();
			credito_extranTotal+=conciliacionesbancarias.getcredito_extran();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOEXTRAN);
		datoGeneral.setdValorDouble(debito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOEXTRAN);
		datoGeneral.setdValorDouble(credito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConciliacionesBancarias() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_ID, ConciliacionesBancariasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_VERSIONROW, ConciliacionesBancariasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR, ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA, ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA, ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL, ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL, ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_NUMERODEPOSITO, ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOEXTRAN, ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOEXTRAN, ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_FECHA, ConciliacionesBancariasConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_DETALLE, ConciliacionesBancariasConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO, ConciliacionesBancariasConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConciliacionesBancarias() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConciliacionesBancariasConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConciliacionesBancarias() throws Exception  {
		return ConciliacionesBancariasConstantesFunciones.getTiposSeleccionarConciliacionesBancarias(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConciliacionesBancarias(Boolean conFk) throws Exception  {
		return ConciliacionesBancariasConstantesFunciones.getTiposSeleccionarConciliacionesBancarias(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConciliacionesBancarias(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_NUMERODEPOSITO);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_NUMERODEPOSITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOEXTRAN);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOEXTRAN);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConciliacionesBancarias(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConciliacionesBancarias(ConciliacionesBancarias conciliacionesbancariasAux) throws Exception {
		
			conciliacionesbancariasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conciliacionesbancariasAux.getEmpresa()));
			conciliacionesbancariasAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(conciliacionesbancariasAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConciliacionesBancarias(List<ConciliacionesBancarias> conciliacionesbancariassTemp) throws Exception {
		for(ConciliacionesBancarias conciliacionesbancariasAux:conciliacionesbancariassTemp) {
			
			conciliacionesbancariasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conciliacionesbancariasAux.getEmpresa()));
			conciliacionesbancariasAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(conciliacionesbancariasAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConciliacionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConciliacionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConciliacionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConciliacionesBancariasConstantesFunciones.getClassesRelationshipsOfConciliacionesBancarias(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConciliacionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConciliacionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConciliacionesBancariasConstantesFunciones.getClassesRelationshipsFromStringsOfConciliacionesBancarias(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConciliacionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConciliacionesBancarias conciliacionesbancarias,List<ConciliacionesBancarias> conciliacionesbancariass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ConciliacionesBancarias conciliacionesbancarias,List<ConciliacionesBancarias> conciliacionesbancariass) throws Exception {
		try	{			
			for(ConciliacionesBancarias conciliacionesbancariasLocal:conciliacionesbancariass) {
				if(conciliacionesbancariasLocal.getId().equals(conciliacionesbancarias.getId())) {
					conciliacionesbancariasLocal.setIsSelected(conciliacionesbancarias.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConciliacionesBancarias(List<ConciliacionesBancarias> conciliacionesbancariassAux) throws Exception {
		//this.conciliacionesbancariassAux=conciliacionesbancariassAux;
		
		for(ConciliacionesBancarias conciliacionesbancariasAux:conciliacionesbancariassAux) {
			if(conciliacionesbancariasAux.getIsChanged()) {
				conciliacionesbancariasAux.setIsChanged(false);
			}		
			
			if(conciliacionesbancariasAux.getIsNew()) {
				conciliacionesbancariasAux.setIsNew(false);
			}	
			
			if(conciliacionesbancariasAux.getIsDeleted()) {
				conciliacionesbancariasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConciliacionesBancarias(ConciliacionesBancarias conciliacionesbancariasAux) throws Exception {
		//this.conciliacionesbancariasAux=conciliacionesbancariasAux;
		
			if(conciliacionesbancariasAux.getIsChanged()) {
				conciliacionesbancariasAux.setIsChanged(false);
			}		
			
			if(conciliacionesbancariasAux.getIsNew()) {
				conciliacionesbancariasAux.setIsNew(false);
			}	
			
			if(conciliacionesbancariasAux.getIsDeleted()) {
				conciliacionesbancariasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConciliacionesBancarias conciliacionesbancariasAsignar,ConciliacionesBancarias conciliacionesbancarias) throws Exception {
		conciliacionesbancariasAsignar.setId(conciliacionesbancarias.getId());	
		conciliacionesbancariasAsignar.setVersionRow(conciliacionesbancarias.getVersionRow());	
		conciliacionesbancariasAsignar.setnumero_mayor(conciliacionesbancarias.getnumero_mayor());	
		conciliacionesbancariasAsignar.setcodigo_cuenta(conciliacionesbancarias.getcodigo_cuenta());	
		conciliacionesbancariasAsignar.setnombre_cuenta(conciliacionesbancarias.getnombre_cuenta());	
		conciliacionesbancariasAsignar.setdebito_local(conciliacionesbancarias.getdebito_local());	
		conciliacionesbancariasAsignar.setcredito_local(conciliacionesbancarias.getcredito_local());	
		conciliacionesbancariasAsignar.setnumero_deposito(conciliacionesbancarias.getnumero_deposito());	
		conciliacionesbancariasAsignar.setdebito_extran(conciliacionesbancarias.getdebito_extran());	
		conciliacionesbancariasAsignar.setcredito_extran(conciliacionesbancarias.getcredito_extran());	
		conciliacionesbancariasAsignar.setfecha(conciliacionesbancarias.getfecha());	
		conciliacionesbancariasAsignar.setdetalle(conciliacionesbancarias.getdetalle());	
		conciliacionesbancariasAsignar.setbeneficiario(conciliacionesbancarias.getbeneficiario());	
	}
	
	public static void inicializarConciliacionesBancarias(ConciliacionesBancarias conciliacionesbancarias) throws Exception {
		try {
				conciliacionesbancarias.setId(0L);	
					
				conciliacionesbancarias.setnumero_mayor("");	
				conciliacionesbancarias.setcodigo_cuenta("");	
				conciliacionesbancarias.setnombre_cuenta("");	
				conciliacionesbancarias.setdebito_local(0.0);	
				conciliacionesbancarias.setcredito_local(0.0);	
				conciliacionesbancarias.setnumero_deposito("");	
				conciliacionesbancarias.setdebito_extran(0.0);	
				conciliacionesbancarias.setcredito_extran(0.0);	
				conciliacionesbancarias.setfecha(new Date());	
				conciliacionesbancarias.setdetalle("");	
				conciliacionesbancarias.setbeneficiario("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConciliacionesBancarias(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_CODIGOCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_NUMERODEPOSITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOEXTRAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOEXTRAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConciliacionesBancarias(String sTipo,Row row,Workbook workbook,ConciliacionesBancarias conciliacionesbancarias,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getcodigo_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getnombre_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getnumero_deposito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getdebito_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getcredito_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conciliacionesbancarias.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConciliacionesBancarias="";
	
	public String getsFinalQueryConciliacionesBancarias() {
		return this.sFinalQueryConciliacionesBancarias;
	}
	
	public void setsFinalQueryConciliacionesBancarias(String sFinalQueryConciliacionesBancarias) {
		this.sFinalQueryConciliacionesBancarias= sFinalQueryConciliacionesBancarias;
	}
	
	public Border resaltarSeleccionarConciliacionesBancarias=null;
	
	public Border setResaltarSeleccionarConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConciliacionesBancarias= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConciliacionesBancarias() {
		return this.resaltarSeleccionarConciliacionesBancarias;
	}
	
	public void setResaltarSeleccionarConciliacionesBancarias(Border borderResaltarSeleccionarConciliacionesBancarias) {
		this.resaltarSeleccionarConciliacionesBancarias= borderResaltarSeleccionarConciliacionesBancarias;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConciliacionesBancarias=null;
	public Boolean mostraridConciliacionesBancarias=true;
	public Boolean activaridConciliacionesBancarias=true;

	public Border resaltarid_empresaConciliacionesBancarias=null;
	public Boolean mostrarid_empresaConciliacionesBancarias=true;
	public Boolean activarid_empresaConciliacionesBancarias=true;
	public Boolean cargarid_empresaConciliacionesBancarias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConciliacionesBancarias=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableConciliacionesBancarias=null;
	public Boolean mostrarid_cuenta_contableConciliacionesBancarias=true;
	public Boolean activarid_cuenta_contableConciliacionesBancarias=true;
	public Boolean cargarid_cuenta_contableConciliacionesBancarias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableConciliacionesBancarias=false;//ConEventDepend=true

	public Border resaltarfecha_desdeConciliacionesBancarias=null;
	public Boolean mostrarfecha_desdeConciliacionesBancarias=true;
	public Boolean activarfecha_desdeConciliacionesBancarias=true;

	public Border resaltarfecha_hastaConciliacionesBancarias=null;
	public Boolean mostrarfecha_hastaConciliacionesBancarias=true;
	public Boolean activarfecha_hastaConciliacionesBancarias=true;

	public Border resaltarnumero_mayorConciliacionesBancarias=null;
	public Boolean mostrarnumero_mayorConciliacionesBancarias=true;
	public Boolean activarnumero_mayorConciliacionesBancarias=true;

	public Border resaltarcodigo_cuentaConciliacionesBancarias=null;
	public Boolean mostrarcodigo_cuentaConciliacionesBancarias=true;
	public Boolean activarcodigo_cuentaConciliacionesBancarias=true;

	public Border resaltarnombre_cuentaConciliacionesBancarias=null;
	public Boolean mostrarnombre_cuentaConciliacionesBancarias=true;
	public Boolean activarnombre_cuentaConciliacionesBancarias=true;

	public Border resaltardebito_localConciliacionesBancarias=null;
	public Boolean mostrardebito_localConciliacionesBancarias=true;
	public Boolean activardebito_localConciliacionesBancarias=true;

	public Border resaltarcredito_localConciliacionesBancarias=null;
	public Boolean mostrarcredito_localConciliacionesBancarias=true;
	public Boolean activarcredito_localConciliacionesBancarias=true;

	public Border resaltarnumero_depositoConciliacionesBancarias=null;
	public Boolean mostrarnumero_depositoConciliacionesBancarias=true;
	public Boolean activarnumero_depositoConciliacionesBancarias=true;

	public Border resaltardebito_extranConciliacionesBancarias=null;
	public Boolean mostrardebito_extranConciliacionesBancarias=true;
	public Boolean activardebito_extranConciliacionesBancarias=true;

	public Border resaltarcredito_extranConciliacionesBancarias=null;
	public Boolean mostrarcredito_extranConciliacionesBancarias=true;
	public Boolean activarcredito_extranConciliacionesBancarias=true;

	public Border resaltarfechaConciliacionesBancarias=null;
	public Boolean mostrarfechaConciliacionesBancarias=true;
	public Boolean activarfechaConciliacionesBancarias=true;

	public Border resaltardetalleConciliacionesBancarias=null;
	public Boolean mostrardetalleConciliacionesBancarias=true;
	public Boolean activardetalleConciliacionesBancarias=true;

	public Border resaltarbeneficiarioConciliacionesBancarias=null;
	public Boolean mostrarbeneficiarioConciliacionesBancarias=true;
	public Boolean activarbeneficiarioConciliacionesBancarias=true;

	
	

	public Border setResaltaridConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltaridConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConciliacionesBancarias() {
		return this.resaltaridConciliacionesBancarias;
	}

	public void setResaltaridConciliacionesBancarias(Border borderResaltar) {
		this.resaltaridConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostraridConciliacionesBancarias() {
		return this.mostraridConciliacionesBancarias;
	}

	public void setMostraridConciliacionesBancarias(Boolean mostraridConciliacionesBancarias) {
		this.mostraridConciliacionesBancarias= mostraridConciliacionesBancarias;
	}

	public Boolean getActivaridConciliacionesBancarias() {
		return this.activaridConciliacionesBancarias;
	}

	public void setActivaridConciliacionesBancarias(Boolean activaridConciliacionesBancarias) {
		this.activaridConciliacionesBancarias= activaridConciliacionesBancarias;
	}

	public Border setResaltarid_empresaConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarid_empresaConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConciliacionesBancarias() {
		return this.resaltarid_empresaConciliacionesBancarias;
	}

	public void setResaltarid_empresaConciliacionesBancarias(Border borderResaltar) {
		this.resaltarid_empresaConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarid_empresaConciliacionesBancarias() {
		return this.mostrarid_empresaConciliacionesBancarias;
	}

	public void setMostrarid_empresaConciliacionesBancarias(Boolean mostrarid_empresaConciliacionesBancarias) {
		this.mostrarid_empresaConciliacionesBancarias= mostrarid_empresaConciliacionesBancarias;
	}

	public Boolean getActivarid_empresaConciliacionesBancarias() {
		return this.activarid_empresaConciliacionesBancarias;
	}

	public void setActivarid_empresaConciliacionesBancarias(Boolean activarid_empresaConciliacionesBancarias) {
		this.activarid_empresaConciliacionesBancarias= activarid_empresaConciliacionesBancarias;
	}

	public Boolean getCargarid_empresaConciliacionesBancarias() {
		return this.cargarid_empresaConciliacionesBancarias;
	}

	public void setCargarid_empresaConciliacionesBancarias(Boolean cargarid_empresaConciliacionesBancarias) {
		this.cargarid_empresaConciliacionesBancarias= cargarid_empresaConciliacionesBancarias;
	}

	public Border setResaltarid_cuenta_contableConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableConciliacionesBancarias() {
		return this.resaltarid_cuenta_contableConciliacionesBancarias;
	}

	public void setResaltarid_cuenta_contableConciliacionesBancarias(Border borderResaltar) {
		this.resaltarid_cuenta_contableConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableConciliacionesBancarias() {
		return this.mostrarid_cuenta_contableConciliacionesBancarias;
	}

	public void setMostrarid_cuenta_contableConciliacionesBancarias(Boolean mostrarid_cuenta_contableConciliacionesBancarias) {
		this.mostrarid_cuenta_contableConciliacionesBancarias= mostrarid_cuenta_contableConciliacionesBancarias;
	}

	public Boolean getActivarid_cuenta_contableConciliacionesBancarias() {
		return this.activarid_cuenta_contableConciliacionesBancarias;
	}

	public void setActivarid_cuenta_contableConciliacionesBancarias(Boolean activarid_cuenta_contableConciliacionesBancarias) {
		this.activarid_cuenta_contableConciliacionesBancarias= activarid_cuenta_contableConciliacionesBancarias;
	}

	public Boolean getCargarid_cuenta_contableConciliacionesBancarias() {
		return this.cargarid_cuenta_contableConciliacionesBancarias;
	}

	public void setCargarid_cuenta_contableConciliacionesBancarias(Boolean cargarid_cuenta_contableConciliacionesBancarias) {
		this.cargarid_cuenta_contableConciliacionesBancarias= cargarid_cuenta_contableConciliacionesBancarias;
	}

	public Border setResaltarfecha_desdeConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeConciliacionesBancarias() {
		return this.resaltarfecha_desdeConciliacionesBancarias;
	}

	public void setResaltarfecha_desdeConciliacionesBancarias(Border borderResaltar) {
		this.resaltarfecha_desdeConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeConciliacionesBancarias() {
		return this.mostrarfecha_desdeConciliacionesBancarias;
	}

	public void setMostrarfecha_desdeConciliacionesBancarias(Boolean mostrarfecha_desdeConciliacionesBancarias) {
		this.mostrarfecha_desdeConciliacionesBancarias= mostrarfecha_desdeConciliacionesBancarias;
	}

	public Boolean getActivarfecha_desdeConciliacionesBancarias() {
		return this.activarfecha_desdeConciliacionesBancarias;
	}

	public void setActivarfecha_desdeConciliacionesBancarias(Boolean activarfecha_desdeConciliacionesBancarias) {
		this.activarfecha_desdeConciliacionesBancarias= activarfecha_desdeConciliacionesBancarias;
	}

	public Border setResaltarfecha_hastaConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaConciliacionesBancarias() {
		return this.resaltarfecha_hastaConciliacionesBancarias;
	}

	public void setResaltarfecha_hastaConciliacionesBancarias(Border borderResaltar) {
		this.resaltarfecha_hastaConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaConciliacionesBancarias() {
		return this.mostrarfecha_hastaConciliacionesBancarias;
	}

	public void setMostrarfecha_hastaConciliacionesBancarias(Boolean mostrarfecha_hastaConciliacionesBancarias) {
		this.mostrarfecha_hastaConciliacionesBancarias= mostrarfecha_hastaConciliacionesBancarias;
	}

	public Boolean getActivarfecha_hastaConciliacionesBancarias() {
		return this.activarfecha_hastaConciliacionesBancarias;
	}

	public void setActivarfecha_hastaConciliacionesBancarias(Boolean activarfecha_hastaConciliacionesBancarias) {
		this.activarfecha_hastaConciliacionesBancarias= activarfecha_hastaConciliacionesBancarias;
	}

	public Border setResaltarnumero_mayorConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorConciliacionesBancarias() {
		return this.resaltarnumero_mayorConciliacionesBancarias;
	}

	public void setResaltarnumero_mayorConciliacionesBancarias(Border borderResaltar) {
		this.resaltarnumero_mayorConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorConciliacionesBancarias() {
		return this.mostrarnumero_mayorConciliacionesBancarias;
	}

	public void setMostrarnumero_mayorConciliacionesBancarias(Boolean mostrarnumero_mayorConciliacionesBancarias) {
		this.mostrarnumero_mayorConciliacionesBancarias= mostrarnumero_mayorConciliacionesBancarias;
	}

	public Boolean getActivarnumero_mayorConciliacionesBancarias() {
		return this.activarnumero_mayorConciliacionesBancarias;
	}

	public void setActivarnumero_mayorConciliacionesBancarias(Boolean activarnumero_mayorConciliacionesBancarias) {
		this.activarnumero_mayorConciliacionesBancarias= activarnumero_mayorConciliacionesBancarias;
	}

	public Border setResaltarcodigo_cuentaConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuentaConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuentaConciliacionesBancarias() {
		return this.resaltarcodigo_cuentaConciliacionesBancarias;
	}

	public void setResaltarcodigo_cuentaConciliacionesBancarias(Border borderResaltar) {
		this.resaltarcodigo_cuentaConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuentaConciliacionesBancarias() {
		return this.mostrarcodigo_cuentaConciliacionesBancarias;
	}

	public void setMostrarcodigo_cuentaConciliacionesBancarias(Boolean mostrarcodigo_cuentaConciliacionesBancarias) {
		this.mostrarcodigo_cuentaConciliacionesBancarias= mostrarcodigo_cuentaConciliacionesBancarias;
	}

	public Boolean getActivarcodigo_cuentaConciliacionesBancarias() {
		return this.activarcodigo_cuentaConciliacionesBancarias;
	}

	public void setActivarcodigo_cuentaConciliacionesBancarias(Boolean activarcodigo_cuentaConciliacionesBancarias) {
		this.activarcodigo_cuentaConciliacionesBancarias= activarcodigo_cuentaConciliacionesBancarias;
	}

	public Border setResaltarnombre_cuentaConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnombre_cuentaConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuentaConciliacionesBancarias() {
		return this.resaltarnombre_cuentaConciliacionesBancarias;
	}

	public void setResaltarnombre_cuentaConciliacionesBancarias(Border borderResaltar) {
		this.resaltarnombre_cuentaConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnombre_cuentaConciliacionesBancarias() {
		return this.mostrarnombre_cuentaConciliacionesBancarias;
	}

	public void setMostrarnombre_cuentaConciliacionesBancarias(Boolean mostrarnombre_cuentaConciliacionesBancarias) {
		this.mostrarnombre_cuentaConciliacionesBancarias= mostrarnombre_cuentaConciliacionesBancarias;
	}

	public Boolean getActivarnombre_cuentaConciliacionesBancarias() {
		return this.activarnombre_cuentaConciliacionesBancarias;
	}

	public void setActivarnombre_cuentaConciliacionesBancarias(Boolean activarnombre_cuentaConciliacionesBancarias) {
		this.activarnombre_cuentaConciliacionesBancarias= activarnombre_cuentaConciliacionesBancarias;
	}

	public Border setResaltardebito_localConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltardebito_localConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localConciliacionesBancarias() {
		return this.resaltardebito_localConciliacionesBancarias;
	}

	public void setResaltardebito_localConciliacionesBancarias(Border borderResaltar) {
		this.resaltardebito_localConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrardebito_localConciliacionesBancarias() {
		return this.mostrardebito_localConciliacionesBancarias;
	}

	public void setMostrardebito_localConciliacionesBancarias(Boolean mostrardebito_localConciliacionesBancarias) {
		this.mostrardebito_localConciliacionesBancarias= mostrardebito_localConciliacionesBancarias;
	}

	public Boolean getActivardebito_localConciliacionesBancarias() {
		return this.activardebito_localConciliacionesBancarias;
	}

	public void setActivardebito_localConciliacionesBancarias(Boolean activardebito_localConciliacionesBancarias) {
		this.activardebito_localConciliacionesBancarias= activardebito_localConciliacionesBancarias;
	}

	public Border setResaltarcredito_localConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcredito_localConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localConciliacionesBancarias() {
		return this.resaltarcredito_localConciliacionesBancarias;
	}

	public void setResaltarcredito_localConciliacionesBancarias(Border borderResaltar) {
		this.resaltarcredito_localConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcredito_localConciliacionesBancarias() {
		return this.mostrarcredito_localConciliacionesBancarias;
	}

	public void setMostrarcredito_localConciliacionesBancarias(Boolean mostrarcredito_localConciliacionesBancarias) {
		this.mostrarcredito_localConciliacionesBancarias= mostrarcredito_localConciliacionesBancarias;
	}

	public Boolean getActivarcredito_localConciliacionesBancarias() {
		return this.activarcredito_localConciliacionesBancarias;
	}

	public void setActivarcredito_localConciliacionesBancarias(Boolean activarcredito_localConciliacionesBancarias) {
		this.activarcredito_localConciliacionesBancarias= activarcredito_localConciliacionesBancarias;
	}

	public Border setResaltarnumero_depositoConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnumero_depositoConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_depositoConciliacionesBancarias() {
		return this.resaltarnumero_depositoConciliacionesBancarias;
	}

	public void setResaltarnumero_depositoConciliacionesBancarias(Border borderResaltar) {
		this.resaltarnumero_depositoConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnumero_depositoConciliacionesBancarias() {
		return this.mostrarnumero_depositoConciliacionesBancarias;
	}

	public void setMostrarnumero_depositoConciliacionesBancarias(Boolean mostrarnumero_depositoConciliacionesBancarias) {
		this.mostrarnumero_depositoConciliacionesBancarias= mostrarnumero_depositoConciliacionesBancarias;
	}

	public Boolean getActivarnumero_depositoConciliacionesBancarias() {
		return this.activarnumero_depositoConciliacionesBancarias;
	}

	public void setActivarnumero_depositoConciliacionesBancarias(Boolean activarnumero_depositoConciliacionesBancarias) {
		this.activarnumero_depositoConciliacionesBancarias= activarnumero_depositoConciliacionesBancarias;
	}

	public Border setResaltardebito_extranConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltardebito_extranConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_extranConciliacionesBancarias() {
		return this.resaltardebito_extranConciliacionesBancarias;
	}

	public void setResaltardebito_extranConciliacionesBancarias(Border borderResaltar) {
		this.resaltardebito_extranConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrardebito_extranConciliacionesBancarias() {
		return this.mostrardebito_extranConciliacionesBancarias;
	}

	public void setMostrardebito_extranConciliacionesBancarias(Boolean mostrardebito_extranConciliacionesBancarias) {
		this.mostrardebito_extranConciliacionesBancarias= mostrardebito_extranConciliacionesBancarias;
	}

	public Boolean getActivardebito_extranConciliacionesBancarias() {
		return this.activardebito_extranConciliacionesBancarias;
	}

	public void setActivardebito_extranConciliacionesBancarias(Boolean activardebito_extranConciliacionesBancarias) {
		this.activardebito_extranConciliacionesBancarias= activardebito_extranConciliacionesBancarias;
	}

	public Border setResaltarcredito_extranConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcredito_extranConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_extranConciliacionesBancarias() {
		return this.resaltarcredito_extranConciliacionesBancarias;
	}

	public void setResaltarcredito_extranConciliacionesBancarias(Border borderResaltar) {
		this.resaltarcredito_extranConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcredito_extranConciliacionesBancarias() {
		return this.mostrarcredito_extranConciliacionesBancarias;
	}

	public void setMostrarcredito_extranConciliacionesBancarias(Boolean mostrarcredito_extranConciliacionesBancarias) {
		this.mostrarcredito_extranConciliacionesBancarias= mostrarcredito_extranConciliacionesBancarias;
	}

	public Boolean getActivarcredito_extranConciliacionesBancarias() {
		return this.activarcredito_extranConciliacionesBancarias;
	}

	public void setActivarcredito_extranConciliacionesBancarias(Boolean activarcredito_extranConciliacionesBancarias) {
		this.activarcredito_extranConciliacionesBancarias= activarcredito_extranConciliacionesBancarias;
	}

	public Border setResaltarfechaConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfechaConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaConciliacionesBancarias() {
		return this.resaltarfechaConciliacionesBancarias;
	}

	public void setResaltarfechaConciliacionesBancarias(Border borderResaltar) {
		this.resaltarfechaConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfechaConciliacionesBancarias() {
		return this.mostrarfechaConciliacionesBancarias;
	}

	public void setMostrarfechaConciliacionesBancarias(Boolean mostrarfechaConciliacionesBancarias) {
		this.mostrarfechaConciliacionesBancarias= mostrarfechaConciliacionesBancarias;
	}

	public Boolean getActivarfechaConciliacionesBancarias() {
		return this.activarfechaConciliacionesBancarias;
	}

	public void setActivarfechaConciliacionesBancarias(Boolean activarfechaConciliacionesBancarias) {
		this.activarfechaConciliacionesBancarias= activarfechaConciliacionesBancarias;
	}

	public Border setResaltardetalleConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltardetalleConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleConciliacionesBancarias() {
		return this.resaltardetalleConciliacionesBancarias;
	}

	public void setResaltardetalleConciliacionesBancarias(Border borderResaltar) {
		this.resaltardetalleConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrardetalleConciliacionesBancarias() {
		return this.mostrardetalleConciliacionesBancarias;
	}

	public void setMostrardetalleConciliacionesBancarias(Boolean mostrardetalleConciliacionesBancarias) {
		this.mostrardetalleConciliacionesBancarias= mostrardetalleConciliacionesBancarias;
	}

	public Boolean getActivardetalleConciliacionesBancarias() {
		return this.activardetalleConciliacionesBancarias;
	}

	public void setActivardetalleConciliacionesBancarias(Boolean activardetalleConciliacionesBancarias) {
		this.activardetalleConciliacionesBancarias= activardetalleConciliacionesBancarias;
	}

	public Border setResaltarbeneficiarioConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioConciliacionesBancarias() {
		return this.resaltarbeneficiarioConciliacionesBancarias;
	}

	public void setResaltarbeneficiarioConciliacionesBancarias(Border borderResaltar) {
		this.resaltarbeneficiarioConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioConciliacionesBancarias() {
		return this.mostrarbeneficiarioConciliacionesBancarias;
	}

	public void setMostrarbeneficiarioConciliacionesBancarias(Boolean mostrarbeneficiarioConciliacionesBancarias) {
		this.mostrarbeneficiarioConciliacionesBancarias= mostrarbeneficiarioConciliacionesBancarias;
	}

	public Boolean getActivarbeneficiarioConciliacionesBancarias() {
		return this.activarbeneficiarioConciliacionesBancarias;
	}

	public void setActivarbeneficiarioConciliacionesBancarias(Boolean activarbeneficiarioConciliacionesBancarias) {
		this.activarbeneficiarioConciliacionesBancarias= activarbeneficiarioConciliacionesBancarias;
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
		
		
		this.setMostraridConciliacionesBancarias(esInicial);
		this.setMostrarid_empresaConciliacionesBancarias(esInicial);
		this.setMostrarid_cuenta_contableConciliacionesBancarias(esInicial);
		this.setMostrarfecha_desdeConciliacionesBancarias(esInicial);
		this.setMostrarfecha_hastaConciliacionesBancarias(esInicial);
		this.setMostrarnumero_mayorConciliacionesBancarias(esInicial);
		this.setMostrarcodigo_cuentaConciliacionesBancarias(esInicial);
		this.setMostrarnombre_cuentaConciliacionesBancarias(esInicial);
		this.setMostrardebito_localConciliacionesBancarias(esInicial);
		this.setMostrarcredito_localConciliacionesBancarias(esInicial);
		this.setMostrarnumero_depositoConciliacionesBancarias(esInicial);
		this.setMostrardebito_extranConciliacionesBancarias(esInicial);
		this.setMostrarcredito_extranConciliacionesBancarias(esInicial);
		this.setMostrarfechaConciliacionesBancarias(esInicial);
		this.setMostrardetalleConciliacionesBancarias(esInicial);
		this.setMostrarbeneficiarioConciliacionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.ID)) {
				this.setMostraridConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA)) {
				this.setMostrarcodigo_cuentaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA)) {
				this.setMostrarnombre_cuentaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO)) {
				this.setMostrarnumero_depositoConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN)) {
				this.setMostrardebito_extranConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN)) {
				this.setMostrarcredito_extranConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHA)) {
				this.setMostrarfechaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DETALLE)) {
				this.setMostrardetalleConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioConciliacionesBancarias(esAsigna);
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
		
		
		this.setActivaridConciliacionesBancarias(esInicial);
		this.setActivarid_empresaConciliacionesBancarias(esInicial);
		this.setActivarid_cuenta_contableConciliacionesBancarias(esInicial);
		this.setActivarfecha_desdeConciliacionesBancarias(esInicial);
		this.setActivarfecha_hastaConciliacionesBancarias(esInicial);
		this.setActivarnumero_mayorConciliacionesBancarias(esInicial);
		this.setActivarcodigo_cuentaConciliacionesBancarias(esInicial);
		this.setActivarnombre_cuentaConciliacionesBancarias(esInicial);
		this.setActivardebito_localConciliacionesBancarias(esInicial);
		this.setActivarcredito_localConciliacionesBancarias(esInicial);
		this.setActivarnumero_depositoConciliacionesBancarias(esInicial);
		this.setActivardebito_extranConciliacionesBancarias(esInicial);
		this.setActivarcredito_extranConciliacionesBancarias(esInicial);
		this.setActivarfechaConciliacionesBancarias(esInicial);
		this.setActivardetalleConciliacionesBancarias(esInicial);
		this.setActivarbeneficiarioConciliacionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.ID)) {
				this.setActivaridConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA)) {
				this.setActivarcodigo_cuentaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA)) {
				this.setActivarnombre_cuentaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO)) {
				this.setActivarnumero_depositoConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN)) {
				this.setActivardebito_extranConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN)) {
				this.setActivarcredito_extranConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHA)) {
				this.setActivarfechaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DETALLE)) {
				this.setActivardetalleConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioConciliacionesBancarias(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConciliacionesBancarias(esInicial);
		this.setResaltarid_empresaConciliacionesBancarias(esInicial);
		this.setResaltarid_cuenta_contableConciliacionesBancarias(esInicial);
		this.setResaltarfecha_desdeConciliacionesBancarias(esInicial);
		this.setResaltarfecha_hastaConciliacionesBancarias(esInicial);
		this.setResaltarnumero_mayorConciliacionesBancarias(esInicial);
		this.setResaltarcodigo_cuentaConciliacionesBancarias(esInicial);
		this.setResaltarnombre_cuentaConciliacionesBancarias(esInicial);
		this.setResaltardebito_localConciliacionesBancarias(esInicial);
		this.setResaltarcredito_localConciliacionesBancarias(esInicial);
		this.setResaltarnumero_depositoConciliacionesBancarias(esInicial);
		this.setResaltardebito_extranConciliacionesBancarias(esInicial);
		this.setResaltarcredito_extranConciliacionesBancarias(esInicial);
		this.setResaltarfechaConciliacionesBancarias(esInicial);
		this.setResaltardetalleConciliacionesBancarias(esInicial);
		this.setResaltarbeneficiarioConciliacionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.ID)) {
				this.setResaltaridConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CODIGOCUENTA)) {
				this.setResaltarcodigo_cuentaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NOMBRECUENTA)) {
				this.setResaltarnombre_cuentaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.NUMERODEPOSITO)) {
				this.setResaltarnumero_depositoConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN)) {
				this.setResaltardebito_extranConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN)) {
				this.setResaltarcredito_extranConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.FECHA)) {
				this.setResaltarfechaConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.DETALLE)) {
				this.setResaltardetalleConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioConciliacionesBancarias(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaConciliacionesBancariasConciliacionesBancarias=true;

	public Boolean getMostrarBusquedaConciliacionesBancariasConciliacionesBancarias() {
		return this.mostrarBusquedaConciliacionesBancariasConciliacionesBancarias;
	}

	public void setMostrarBusquedaConciliacionesBancariasConciliacionesBancarias(Boolean visibilidadResaltar) {
		this.mostrarBusquedaConciliacionesBancariasConciliacionesBancarias= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaConciliacionesBancariasConciliacionesBancarias=true;

	public Boolean getActivarBusquedaConciliacionesBancariasConciliacionesBancarias() {
		return this.activarBusquedaConciliacionesBancariasConciliacionesBancarias;
	}

	public void setActivarBusquedaConciliacionesBancariasConciliacionesBancarias(Boolean habilitarResaltar) {
		this.activarBusquedaConciliacionesBancariasConciliacionesBancarias= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaConciliacionesBancariasConciliacionesBancarias=null;

	public Border getResaltarBusquedaConciliacionesBancariasConciliacionesBancarias() {
		return this.resaltarBusquedaConciliacionesBancariasConciliacionesBancarias;
	}

	public void setResaltarBusquedaConciliacionesBancariasConciliacionesBancarias(Border borderResaltar) {
		this.resaltarBusquedaConciliacionesBancariasConciliacionesBancarias= borderResaltar;
	}

	public void setResaltarBusquedaConciliacionesBancariasConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*ConciliacionesBancariasBeanSwingJInternalFrame conciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaConciliacionesBancariasConciliacionesBancarias= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}