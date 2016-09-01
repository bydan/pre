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


import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasParameterGeneral;

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
final public class HistorialConciliacionesBancariasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="HistorialConciliacionesBancarias";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="HistorialConciliacionesBancarias"+HistorialConciliacionesBancariasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HistorialConciliacionesBancariasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HistorialConciliacionesBancariasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HistorialConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HistorialConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"_"+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HistorialConciliacionesBancariasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HistorialConciliacionesBancariasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HistorialConciliacionesBancariasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HistorialConciliacionesBancariasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HistorialConciliacionesBancariasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HistorialConciliacionesBancariasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Historial Conciliaciones Bancariases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Historial Conciliaciones Bancarias";
	public static final String SCLASSWEBTITULO_LOWER="Historial Conciliaciones Bancarias";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="HistorialConciliacionesBancarias";
	public static final String OBJECTNAME="historialconciliacionesbancarias";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="historial_conciliaciones_bancarias";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select historialconciliacionesbancarias from "+HistorialConciliacionesBancariasConstantesFunciones.SPERSISTENCENAME+" historialconciliacionesbancarias";
	public static String QUERYSELECTNATIVE="select "+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".id,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".version_row,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".id_empresa,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".id_cuenta_contable,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".fecha_desde,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".fecha_hasta,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".debito_local,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".credito_local,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".numero_cheque,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".codigo,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".beneficiario,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".detalle,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".cuenta,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".tipo_documento,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".numero_mayor,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".fecha_finalizacion,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".tipo_movimiento,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".saldo_libros,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".fecha,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".numero_cuenta,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME+".anterior from "+HistorialConciliacionesBancariasConstantesFunciones.SCHEMA+"."+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME;//+" as "+HistorialConciliacionesBancariasConstantesFunciones.TABLENAME;
	
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
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String CODIGO= "codigo";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String DETALLE= "detalle";
    public static final String CUENTA= "cuenta";
    public static final String TIPODOCUMENTO= "tipo_documento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String FECHAFINALIZACION= "fecha_finalizacion";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String SALDOLIBROS= "saldo_libros";
    public static final String FECHA= "fecha";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String NOMBRECUENTACONTABLE= "nombre_cuenta_contable";
    public static final String ANTERIOR= "anterior";
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
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_CUENTA= "Cuenta";
		public static final String LABEL_CUENTA_LOWER= "Cuenta";
    	public static final String LABEL_TIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_TIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_FECHAFINALIZACION= "Fecha Finalizacion";
		public static final String LABEL_FECHAFINALIZACION_LOWER= "Fecha Finalizacion";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_SALDOLIBROS= "Saldo Libros";
		public static final String LABEL_SALDOLIBROS_LOWER= "Saldo Libros";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_NOMBRECUENTACONTABLE= "Nombre Cuenta Contable";
		public static final String LABEL_NOMBRECUENTACONTABLE_LOWER= "Nombre Cuenta Contable";
    	public static final String LABEL_ANTERIOR= "Anterior";
		public static final String LABEL_ANTERIOR_LOWER= "Anterior";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getHistorialConciliacionesBancariasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHADESDE)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.CODIGO)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.DETALLE)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.CUENTA)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_CUENTA;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAFINALIZACION;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_SALDOLIBROS;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHA)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR)) {sLabelColumna=HistorialConciliacionesBancariasConstantesFunciones.LABEL_ANTERIOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getHistorialConciliacionesBancariasDescripcion(HistorialConciliacionesBancarias historialconciliacionesbancarias) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(historialconciliacionesbancarias !=null/* && historialconciliacionesbancarias.getId()!=0*/) {
			sDescripcion=historialconciliacionesbancarias.getcodigo();//historialconciliacionesbancariashistorialconciliacionesbancarias.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getHistorialConciliacionesBancariasDescripcionDetallado(HistorialConciliacionesBancarias historialconciliacionesbancarias) {
		String sDescripcion="";
			
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.ID+"=";
		sDescripcion+=historialconciliacionesbancarias.getId().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=historialconciliacionesbancarias.getVersionRow().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=historialconciliacionesbancarias.getid_empresa().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=historialconciliacionesbancarias.getid_cuenta_contable().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=historialconciliacionesbancarias.getfecha_desde().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=historialconciliacionesbancarias.getfecha_hasta().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=historialconciliacionesbancarias.getdebito_local().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=historialconciliacionesbancarias.getcredito_local().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=historialconciliacionesbancarias.getnumero_cheque()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.CODIGO+"=";
		sDescripcion+=historialconciliacionesbancarias.getcodigo()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=historialconciliacionesbancarias.getbeneficiario()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.DETALLE+"=";
		sDescripcion+=historialconciliacionesbancarias.getdetalle()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.CUENTA+"=";
		sDescripcion+=historialconciliacionesbancarias.getcuenta()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO+"=";
		sDescripcion+=historialconciliacionesbancarias.gettipo_documento()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=historialconciliacionesbancarias.getnumero_mayor()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION+"=";
		sDescripcion+=historialconciliacionesbancarias.getfecha_finalizacion().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=historialconciliacionesbancarias.gettipo_movimiento()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS+"=";
		sDescripcion+=historialconciliacionesbancarias.getsaldo_libros().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.FECHA+"=";
		sDescripcion+=historialconciliacionesbancarias.getfecha().toString()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=historialconciliacionesbancarias.getnumero_cuenta()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=historialconciliacionesbancarias.getnombre_cuenta_contable()+",";
		sDescripcion+=HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR+"=";
		sDescripcion+=historialconciliacionesbancarias.getanterior().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setHistorialConciliacionesBancariasDescripcion(HistorialConciliacionesBancarias historialconciliacionesbancarias,String sValor) throws Exception {			
		if(historialconciliacionesbancarias !=null) {
			historialconciliacionesbancarias.setcodigo(sValor);;//historialconciliacionesbancariashistorialconciliacionesbancarias.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaHistorialConciliacionesBancarias")) {
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

	public static String getDetalleIndiceBusquedaHistorialConciliacionesBancarias(Long id_cuenta_contable,Date fecha_desde,Date fecha_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosHistorialConciliacionesBancarias(HistorialConciliacionesBancarias historialconciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		historialconciliacionesbancarias.setnumero_cheque(historialconciliacionesbancarias.getnumero_cheque().trim());
		historialconciliacionesbancarias.setcodigo(historialconciliacionesbancarias.getcodigo().trim());
		historialconciliacionesbancarias.setbeneficiario(historialconciliacionesbancarias.getbeneficiario().trim());
		historialconciliacionesbancarias.setdetalle(historialconciliacionesbancarias.getdetalle().trim());
		historialconciliacionesbancarias.setcuenta(historialconciliacionesbancarias.getcuenta().trim());
		historialconciliacionesbancarias.settipo_documento(historialconciliacionesbancarias.gettipo_documento().trim());
		historialconciliacionesbancarias.setnumero_mayor(historialconciliacionesbancarias.getnumero_mayor().trim());
		historialconciliacionesbancarias.settipo_movimiento(historialconciliacionesbancarias.gettipo_movimiento().trim());
		historialconciliacionesbancarias.setnumero_cuenta(historialconciliacionesbancarias.getnumero_cuenta().trim());
		historialconciliacionesbancarias.setnombre_cuenta_contable(historialconciliacionesbancarias.getnombre_cuenta_contable().trim());
	}
	
	public static void quitarEspaciosHistorialConciliacionesBancariass(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias: historialconciliacionesbancariass) {
			historialconciliacionesbancarias.setnumero_cheque(historialconciliacionesbancarias.getnumero_cheque().trim());
			historialconciliacionesbancarias.setcodigo(historialconciliacionesbancarias.getcodigo().trim());
			historialconciliacionesbancarias.setbeneficiario(historialconciliacionesbancarias.getbeneficiario().trim());
			historialconciliacionesbancarias.setdetalle(historialconciliacionesbancarias.getdetalle().trim());
			historialconciliacionesbancarias.setcuenta(historialconciliacionesbancarias.getcuenta().trim());
			historialconciliacionesbancarias.settipo_documento(historialconciliacionesbancarias.gettipo_documento().trim());
			historialconciliacionesbancarias.setnumero_mayor(historialconciliacionesbancarias.getnumero_mayor().trim());
			historialconciliacionesbancarias.settipo_movimiento(historialconciliacionesbancarias.gettipo_movimiento().trim());
			historialconciliacionesbancarias.setnumero_cuenta(historialconciliacionesbancarias.getnumero_cuenta().trim());
			historialconciliacionesbancarias.setnombre_cuenta_contable(historialconciliacionesbancarias.getnombre_cuenta_contable().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialConciliacionesBancarias(HistorialConciliacionesBancarias historialconciliacionesbancarias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && historialconciliacionesbancarias.getConCambioAuxiliar()) {
			historialconciliacionesbancarias.setIsDeleted(historialconciliacionesbancarias.getIsDeletedAuxiliar());	
			historialconciliacionesbancarias.setIsNew(historialconciliacionesbancarias.getIsNewAuxiliar());	
			historialconciliacionesbancarias.setIsChanged(historialconciliacionesbancarias.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			historialconciliacionesbancarias.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			historialconciliacionesbancarias.setIsDeletedAuxiliar(false);	
			historialconciliacionesbancarias.setIsNewAuxiliar(false);	
			historialconciliacionesbancarias.setIsChangedAuxiliar(false);
			
			historialconciliacionesbancarias.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHistorialConciliacionesBancariass(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias : historialconciliacionesbancariass) {
			if(conAsignarBase && historialconciliacionesbancarias.getConCambioAuxiliar()) {
				historialconciliacionesbancarias.setIsDeleted(historialconciliacionesbancarias.getIsDeletedAuxiliar());	
				historialconciliacionesbancarias.setIsNew(historialconciliacionesbancarias.getIsNewAuxiliar());	
				historialconciliacionesbancarias.setIsChanged(historialconciliacionesbancarias.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				historialconciliacionesbancarias.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				historialconciliacionesbancarias.setIsDeletedAuxiliar(false);	
				historialconciliacionesbancarias.setIsNewAuxiliar(false);	
				historialconciliacionesbancarias.setIsChangedAuxiliar(false);
				
				historialconciliacionesbancarias.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHistorialConciliacionesBancarias(HistorialConciliacionesBancarias historialconciliacionesbancarias,Boolean conEnteros) throws Exception  {
		historialconciliacionesbancarias.setdebito_local(0.0);
		historialconciliacionesbancarias.setcredito_local(0.0);
		historialconciliacionesbancarias.setsaldo_libros(0.0);
		historialconciliacionesbancarias.setanterior(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHistorialConciliacionesBancariass(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,Boolean conEnteros) throws Exception  {
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias: historialconciliacionesbancariass) {
			historialconciliacionesbancarias.setdebito_local(0.0);
			historialconciliacionesbancarias.setcredito_local(0.0);
			historialconciliacionesbancarias.setsaldo_libros(0.0);
			historialconciliacionesbancarias.setanterior(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHistorialConciliacionesBancarias(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,HistorialConciliacionesBancarias historialconciliacionesbancariasAux) throws Exception  {
		HistorialConciliacionesBancariasConstantesFunciones.InicializarValoresHistorialConciliacionesBancarias(historialconciliacionesbancariasAux,true);
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias: historialconciliacionesbancariass) {
			if(historialconciliacionesbancarias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			historialconciliacionesbancariasAux.setdebito_local(historialconciliacionesbancariasAux.getdebito_local()+historialconciliacionesbancarias.getdebito_local());			
			historialconciliacionesbancariasAux.setcredito_local(historialconciliacionesbancariasAux.getcredito_local()+historialconciliacionesbancarias.getcredito_local());			
			historialconciliacionesbancariasAux.setsaldo_libros(historialconciliacionesbancariasAux.getsaldo_libros()+historialconciliacionesbancarias.getsaldo_libros());			
			historialconciliacionesbancariasAux.setanterior(historialconciliacionesbancariasAux.getanterior()+historialconciliacionesbancarias.getanterior());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HistorialConciliacionesBancariasConstantesFunciones.getArrayColumnasGlobalesHistorialConciliacionesBancarias(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHistorialConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,HistorialConciliacionesBancarias historialconciliacionesbancarias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancariasAux: historialconciliacionesbancariass) {
			if(historialconciliacionesbancariasAux!=null && historialconciliacionesbancarias!=null) {
				if((historialconciliacionesbancariasAux.getId()==null && historialconciliacionesbancarias.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(historialconciliacionesbancariasAux.getId()!=null && historialconciliacionesbancarias.getId()!=null){
					if(historialconciliacionesbancariasAux.getId().equals(historialconciliacionesbancarias.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialConciliacionesBancarias(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double saldo_librosTotal=0.0;
		Double anteriorTotal=0.0;
	
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias: historialconciliacionesbancariass) {			
			if(historialconciliacionesbancarias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=historialconciliacionesbancarias.getdebito_local();
			credito_localTotal+=historialconciliacionesbancarias.getcredito_local();
			saldo_librosTotal+=historialconciliacionesbancarias.getsaldo_libros();
			anteriorTotal+=historialconciliacionesbancarias.getanterior();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_SALDOLIBROS);
		datoGeneral.setdValorDouble(saldo_librosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_ANTERIOR);
		datoGeneral.setdValorDouble(anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHistorialConciliacionesBancarias() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_ID, HistorialConciliacionesBancariasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_VERSIONROW, HistorialConciliacionesBancariasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL, HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL, HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCHEQUE, HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_CODIGO, HistorialConciliacionesBancariasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO, HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_DETALLE, HistorialConciliacionesBancariasConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_CUENTA, HistorialConciliacionesBancariasConstantesFunciones.CUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO, HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR, HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAFINALIZACION, HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO, HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_SALDOLIBROS, HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHA, HistorialConciliacionesBancariasConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCUENTA, HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HistorialConciliacionesBancariasConstantesFunciones.LABEL_ANTERIOR, HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHistorialConciliacionesBancarias() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.CUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialConciliacionesBancarias() throws Exception  {
		return HistorialConciliacionesBancariasConstantesFunciones.getTiposSeleccionarHistorialConciliacionesBancarias(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialConciliacionesBancarias(Boolean conFk) throws Exception  {
		return HistorialConciliacionesBancariasConstantesFunciones.getTiposSeleccionarHistorialConciliacionesBancarias(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHistorialConciliacionesBancarias(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CUENTA);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAFINALIZACION);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAFINALIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_SALDOLIBROS);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_SALDOLIBROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.LABEL_ANTERIOR);
			reporte.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_ANTERIOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHistorialConciliacionesBancarias(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialConciliacionesBancarias(HistorialConciliacionesBancarias historialconciliacionesbancariasAux) throws Exception {
		
			historialconciliacionesbancariasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialconciliacionesbancariasAux.getEmpresa()));
			historialconciliacionesbancariasAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(historialconciliacionesbancariasAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHistorialConciliacionesBancarias(List<HistorialConciliacionesBancarias> historialconciliacionesbancariassTemp) throws Exception {
		for(HistorialConciliacionesBancarias historialconciliacionesbancariasAux:historialconciliacionesbancariassTemp) {
			
			historialconciliacionesbancariasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(historialconciliacionesbancariasAux.getEmpresa()));
			historialconciliacionesbancariasAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(historialconciliacionesbancariasAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialConciliacionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHistorialConciliacionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialConciliacionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialConciliacionesBancariasConstantesFunciones.getClassesRelationshipsOfHistorialConciliacionesBancarias(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialConciliacionesBancarias(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialConciliacionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HistorialConciliacionesBancariasConstantesFunciones.getClassesRelationshipsFromStringsOfHistorialConciliacionesBancarias(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHistorialConciliacionesBancarias(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(HistorialConciliacionesBancarias historialconciliacionesbancarias,List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(HistorialConciliacionesBancarias historialconciliacionesbancarias,List<HistorialConciliacionesBancarias> historialconciliacionesbancariass) throws Exception {
		try	{			
			for(HistorialConciliacionesBancarias historialconciliacionesbancariasLocal:historialconciliacionesbancariass) {
				if(historialconciliacionesbancariasLocal.getId().equals(historialconciliacionesbancarias.getId())) {
					historialconciliacionesbancariasLocal.setIsSelected(historialconciliacionesbancarias.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHistorialConciliacionesBancarias(List<HistorialConciliacionesBancarias> historialconciliacionesbancariassAux) throws Exception {
		//this.historialconciliacionesbancariassAux=historialconciliacionesbancariassAux;
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancariasAux:historialconciliacionesbancariassAux) {
			if(historialconciliacionesbancariasAux.getIsChanged()) {
				historialconciliacionesbancariasAux.setIsChanged(false);
			}		
			
			if(historialconciliacionesbancariasAux.getIsNew()) {
				historialconciliacionesbancariasAux.setIsNew(false);
			}	
			
			if(historialconciliacionesbancariasAux.getIsDeleted()) {
				historialconciliacionesbancariasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHistorialConciliacionesBancarias(HistorialConciliacionesBancarias historialconciliacionesbancariasAux) throws Exception {
		//this.historialconciliacionesbancariasAux=historialconciliacionesbancariasAux;
		
			if(historialconciliacionesbancariasAux.getIsChanged()) {
				historialconciliacionesbancariasAux.setIsChanged(false);
			}		
			
			if(historialconciliacionesbancariasAux.getIsNew()) {
				historialconciliacionesbancariasAux.setIsNew(false);
			}	
			
			if(historialconciliacionesbancariasAux.getIsDeleted()) {
				historialconciliacionesbancariasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(HistorialConciliacionesBancarias historialconciliacionesbancariasAsignar,HistorialConciliacionesBancarias historialconciliacionesbancarias) throws Exception {
		historialconciliacionesbancariasAsignar.setId(historialconciliacionesbancarias.getId());	
		historialconciliacionesbancariasAsignar.setVersionRow(historialconciliacionesbancarias.getVersionRow());	
		historialconciliacionesbancariasAsignar.setdebito_local(historialconciliacionesbancarias.getdebito_local());	
		historialconciliacionesbancariasAsignar.setcredito_local(historialconciliacionesbancarias.getcredito_local());	
		historialconciliacionesbancariasAsignar.setnumero_cheque(historialconciliacionesbancarias.getnumero_cheque());	
		historialconciliacionesbancariasAsignar.setcodigo(historialconciliacionesbancarias.getcodigo());	
		historialconciliacionesbancariasAsignar.setbeneficiario(historialconciliacionesbancarias.getbeneficiario());	
		historialconciliacionesbancariasAsignar.setdetalle(historialconciliacionesbancarias.getdetalle());	
		historialconciliacionesbancariasAsignar.setcuenta(historialconciliacionesbancarias.getcuenta());	
		historialconciliacionesbancariasAsignar.settipo_documento(historialconciliacionesbancarias.gettipo_documento());	
		historialconciliacionesbancariasAsignar.setnumero_mayor(historialconciliacionesbancarias.getnumero_mayor());	
		historialconciliacionesbancariasAsignar.setfecha_finalizacion(historialconciliacionesbancarias.getfecha_finalizacion());	
		historialconciliacionesbancariasAsignar.settipo_movimiento(historialconciliacionesbancarias.gettipo_movimiento());	
		historialconciliacionesbancariasAsignar.setsaldo_libros(historialconciliacionesbancarias.getsaldo_libros());	
		historialconciliacionesbancariasAsignar.setfecha(historialconciliacionesbancarias.getfecha());	
		historialconciliacionesbancariasAsignar.setnumero_cuenta(historialconciliacionesbancarias.getnumero_cuenta());	
		historialconciliacionesbancariasAsignar.setnombre_cuenta_contable(historialconciliacionesbancarias.getnombre_cuenta_contable());	
		historialconciliacionesbancariasAsignar.setanterior(historialconciliacionesbancarias.getanterior());	
	}
	
	public static void inicializarHistorialConciliacionesBancarias(HistorialConciliacionesBancarias historialconciliacionesbancarias) throws Exception {
		try {
				historialconciliacionesbancarias.setId(0L);	
					
				historialconciliacionesbancarias.setdebito_local(0.0);	
				historialconciliacionesbancarias.setcredito_local(0.0);	
				historialconciliacionesbancarias.setnumero_cheque("");	
				historialconciliacionesbancarias.setcodigo("");	
				historialconciliacionesbancarias.setbeneficiario("");	
				historialconciliacionesbancarias.setdetalle("");	
				historialconciliacionesbancarias.setcuenta("");	
				historialconciliacionesbancarias.settipo_documento("");	
				historialconciliacionesbancarias.setnumero_mayor("");	
				historialconciliacionesbancarias.setfecha_finalizacion(new Date());	
				historialconciliacionesbancarias.settipo_movimiento("");	
				historialconciliacionesbancarias.setsaldo_libros(0.0);	
				historialconciliacionesbancarias.setfecha(new Date());	
				historialconciliacionesbancarias.setnumero_cuenta("");	
				historialconciliacionesbancarias.setnombre_cuenta_contable("");	
				historialconciliacionesbancarias.setanterior(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHistorialConciliacionesBancarias(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHAFINALIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_SALDOLIBROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HistorialConciliacionesBancariasConstantesFunciones.LABEL_ANTERIOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHistorialConciliacionesBancarias(String sTipo,Row row,Workbook workbook,HistorialConciliacionesBancarias historialconciliacionesbancarias,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getcuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.gettipo_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getfecha_finalizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getsaldo_libros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(historialconciliacionesbancarias.getanterior());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHistorialConciliacionesBancarias="";
	
	public String getsFinalQueryHistorialConciliacionesBancarias() {
		return this.sFinalQueryHistorialConciliacionesBancarias;
	}
	
	public void setsFinalQueryHistorialConciliacionesBancarias(String sFinalQueryHistorialConciliacionesBancarias) {
		this.sFinalQueryHistorialConciliacionesBancarias= sFinalQueryHistorialConciliacionesBancarias;
	}
	
	public Border resaltarSeleccionarHistorialConciliacionesBancarias=null;
	
	public Border setResaltarSeleccionarHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHistorialConciliacionesBancarias= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHistorialConciliacionesBancarias() {
		return this.resaltarSeleccionarHistorialConciliacionesBancarias;
	}
	
	public void setResaltarSeleccionarHistorialConciliacionesBancarias(Border borderResaltarSeleccionarHistorialConciliacionesBancarias) {
		this.resaltarSeleccionarHistorialConciliacionesBancarias= borderResaltarSeleccionarHistorialConciliacionesBancarias;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHistorialConciliacionesBancarias=null;
	public Boolean mostraridHistorialConciliacionesBancarias=true;
	public Boolean activaridHistorialConciliacionesBancarias=true;

	public Border resaltarid_empresaHistorialConciliacionesBancarias=null;
	public Boolean mostrarid_empresaHistorialConciliacionesBancarias=true;
	public Boolean activarid_empresaHistorialConciliacionesBancarias=true;
	public Boolean cargarid_empresaHistorialConciliacionesBancarias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHistorialConciliacionesBancarias=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableHistorialConciliacionesBancarias=null;
	public Boolean mostrarid_cuenta_contableHistorialConciliacionesBancarias=true;
	public Boolean activarid_cuenta_contableHistorialConciliacionesBancarias=true;
	public Boolean cargarid_cuenta_contableHistorialConciliacionesBancarias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableHistorialConciliacionesBancarias=false;//ConEventDepend=true

	public Border resaltarfecha_desdeHistorialConciliacionesBancarias=null;
	public Boolean mostrarfecha_desdeHistorialConciliacionesBancarias=true;
	public Boolean activarfecha_desdeHistorialConciliacionesBancarias=true;

	public Border resaltarfecha_hastaHistorialConciliacionesBancarias=null;
	public Boolean mostrarfecha_hastaHistorialConciliacionesBancarias=true;
	public Boolean activarfecha_hastaHistorialConciliacionesBancarias=true;

	public Border resaltardebito_localHistorialConciliacionesBancarias=null;
	public Boolean mostrardebito_localHistorialConciliacionesBancarias=true;
	public Boolean activardebito_localHistorialConciliacionesBancarias=true;

	public Border resaltarcredito_localHistorialConciliacionesBancarias=null;
	public Boolean mostrarcredito_localHistorialConciliacionesBancarias=true;
	public Boolean activarcredito_localHistorialConciliacionesBancarias=true;

	public Border resaltarnumero_chequeHistorialConciliacionesBancarias=null;
	public Boolean mostrarnumero_chequeHistorialConciliacionesBancarias=true;
	public Boolean activarnumero_chequeHistorialConciliacionesBancarias=true;

	public Border resaltarcodigoHistorialConciliacionesBancarias=null;
	public Boolean mostrarcodigoHistorialConciliacionesBancarias=true;
	public Boolean activarcodigoHistorialConciliacionesBancarias=true;

	public Border resaltarbeneficiarioHistorialConciliacionesBancarias=null;
	public Boolean mostrarbeneficiarioHistorialConciliacionesBancarias=true;
	public Boolean activarbeneficiarioHistorialConciliacionesBancarias=true;

	public Border resaltardetalleHistorialConciliacionesBancarias=null;
	public Boolean mostrardetalleHistorialConciliacionesBancarias=true;
	public Boolean activardetalleHistorialConciliacionesBancarias=true;

	public Border resaltarcuentaHistorialConciliacionesBancarias=null;
	public Boolean mostrarcuentaHistorialConciliacionesBancarias=true;
	public Boolean activarcuentaHistorialConciliacionesBancarias=true;

	public Border resaltartipo_documentoHistorialConciliacionesBancarias=null;
	public Boolean mostrartipo_documentoHistorialConciliacionesBancarias=true;
	public Boolean activartipo_documentoHistorialConciliacionesBancarias=true;

	public Border resaltarnumero_mayorHistorialConciliacionesBancarias=null;
	public Boolean mostrarnumero_mayorHistorialConciliacionesBancarias=true;
	public Boolean activarnumero_mayorHistorialConciliacionesBancarias=true;

	public Border resaltarfecha_finalizacionHistorialConciliacionesBancarias=null;
	public Boolean mostrarfecha_finalizacionHistorialConciliacionesBancarias=true;
	public Boolean activarfecha_finalizacionHistorialConciliacionesBancarias=true;

	public Border resaltartipo_movimientoHistorialConciliacionesBancarias=null;
	public Boolean mostrartipo_movimientoHistorialConciliacionesBancarias=true;
	public Boolean activartipo_movimientoHistorialConciliacionesBancarias=true;

	public Border resaltarsaldo_librosHistorialConciliacionesBancarias=null;
	public Boolean mostrarsaldo_librosHistorialConciliacionesBancarias=true;
	public Boolean activarsaldo_librosHistorialConciliacionesBancarias=true;

	public Border resaltarfechaHistorialConciliacionesBancarias=null;
	public Boolean mostrarfechaHistorialConciliacionesBancarias=true;
	public Boolean activarfechaHistorialConciliacionesBancarias=true;

	public Border resaltarnumero_cuentaHistorialConciliacionesBancarias=null;
	public Boolean mostrarnumero_cuentaHistorialConciliacionesBancarias=true;
	public Boolean activarnumero_cuentaHistorialConciliacionesBancarias=true;

	public Border resaltarnombre_cuenta_contableHistorialConciliacionesBancarias=null;
	public Boolean mostrarnombre_cuenta_contableHistorialConciliacionesBancarias=true;
	public Boolean activarnombre_cuenta_contableHistorialConciliacionesBancarias=true;

	public Border resaltaranteriorHistorialConciliacionesBancarias=null;
	public Boolean mostraranteriorHistorialConciliacionesBancarias=true;
	public Boolean activaranteriorHistorialConciliacionesBancarias=true;

	
	

	public Border setResaltaridHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltaridHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHistorialConciliacionesBancarias() {
		return this.resaltaridHistorialConciliacionesBancarias;
	}

	public void setResaltaridHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltaridHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostraridHistorialConciliacionesBancarias() {
		return this.mostraridHistorialConciliacionesBancarias;
	}

	public void setMostraridHistorialConciliacionesBancarias(Boolean mostraridHistorialConciliacionesBancarias) {
		this.mostraridHistorialConciliacionesBancarias= mostraridHistorialConciliacionesBancarias;
	}

	public Boolean getActivaridHistorialConciliacionesBancarias() {
		return this.activaridHistorialConciliacionesBancarias;
	}

	public void setActivaridHistorialConciliacionesBancarias(Boolean activaridHistorialConciliacionesBancarias) {
		this.activaridHistorialConciliacionesBancarias= activaridHistorialConciliacionesBancarias;
	}

	public Border setResaltarid_empresaHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarid_empresaHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHistorialConciliacionesBancarias() {
		return this.resaltarid_empresaHistorialConciliacionesBancarias;
	}

	public void setResaltarid_empresaHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarid_empresaHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarid_empresaHistorialConciliacionesBancarias() {
		return this.mostrarid_empresaHistorialConciliacionesBancarias;
	}

	public void setMostrarid_empresaHistorialConciliacionesBancarias(Boolean mostrarid_empresaHistorialConciliacionesBancarias) {
		this.mostrarid_empresaHistorialConciliacionesBancarias= mostrarid_empresaHistorialConciliacionesBancarias;
	}

	public Boolean getActivarid_empresaHistorialConciliacionesBancarias() {
		return this.activarid_empresaHistorialConciliacionesBancarias;
	}

	public void setActivarid_empresaHistorialConciliacionesBancarias(Boolean activarid_empresaHistorialConciliacionesBancarias) {
		this.activarid_empresaHistorialConciliacionesBancarias= activarid_empresaHistorialConciliacionesBancarias;
	}

	public Boolean getCargarid_empresaHistorialConciliacionesBancarias() {
		return this.cargarid_empresaHistorialConciliacionesBancarias;
	}

	public void setCargarid_empresaHistorialConciliacionesBancarias(Boolean cargarid_empresaHistorialConciliacionesBancarias) {
		this.cargarid_empresaHistorialConciliacionesBancarias= cargarid_empresaHistorialConciliacionesBancarias;
	}

	public Border setResaltarid_cuenta_contableHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableHistorialConciliacionesBancarias() {
		return this.resaltarid_cuenta_contableHistorialConciliacionesBancarias;
	}

	public void setResaltarid_cuenta_contableHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarid_cuenta_contableHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableHistorialConciliacionesBancarias() {
		return this.mostrarid_cuenta_contableHistorialConciliacionesBancarias;
	}

	public void setMostrarid_cuenta_contableHistorialConciliacionesBancarias(Boolean mostrarid_cuenta_contableHistorialConciliacionesBancarias) {
		this.mostrarid_cuenta_contableHistorialConciliacionesBancarias= mostrarid_cuenta_contableHistorialConciliacionesBancarias;
	}

	public Boolean getActivarid_cuenta_contableHistorialConciliacionesBancarias() {
		return this.activarid_cuenta_contableHistorialConciliacionesBancarias;
	}

	public void setActivarid_cuenta_contableHistorialConciliacionesBancarias(Boolean activarid_cuenta_contableHistorialConciliacionesBancarias) {
		this.activarid_cuenta_contableHistorialConciliacionesBancarias= activarid_cuenta_contableHistorialConciliacionesBancarias;
	}

	public Boolean getCargarid_cuenta_contableHistorialConciliacionesBancarias() {
		return this.cargarid_cuenta_contableHistorialConciliacionesBancarias;
	}

	public void setCargarid_cuenta_contableHistorialConciliacionesBancarias(Boolean cargarid_cuenta_contableHistorialConciliacionesBancarias) {
		this.cargarid_cuenta_contableHistorialConciliacionesBancarias= cargarid_cuenta_contableHistorialConciliacionesBancarias;
	}

	public Border setResaltarfecha_desdeHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeHistorialConciliacionesBancarias() {
		return this.resaltarfecha_desdeHistorialConciliacionesBancarias;
	}

	public void setResaltarfecha_desdeHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarfecha_desdeHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeHistorialConciliacionesBancarias() {
		return this.mostrarfecha_desdeHistorialConciliacionesBancarias;
	}

	public void setMostrarfecha_desdeHistorialConciliacionesBancarias(Boolean mostrarfecha_desdeHistorialConciliacionesBancarias) {
		this.mostrarfecha_desdeHistorialConciliacionesBancarias= mostrarfecha_desdeHistorialConciliacionesBancarias;
	}

	public Boolean getActivarfecha_desdeHistorialConciliacionesBancarias() {
		return this.activarfecha_desdeHistorialConciliacionesBancarias;
	}

	public void setActivarfecha_desdeHistorialConciliacionesBancarias(Boolean activarfecha_desdeHistorialConciliacionesBancarias) {
		this.activarfecha_desdeHistorialConciliacionesBancarias= activarfecha_desdeHistorialConciliacionesBancarias;
	}

	public Border setResaltarfecha_hastaHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaHistorialConciliacionesBancarias() {
		return this.resaltarfecha_hastaHistorialConciliacionesBancarias;
	}

	public void setResaltarfecha_hastaHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarfecha_hastaHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaHistorialConciliacionesBancarias() {
		return this.mostrarfecha_hastaHistorialConciliacionesBancarias;
	}

	public void setMostrarfecha_hastaHistorialConciliacionesBancarias(Boolean mostrarfecha_hastaHistorialConciliacionesBancarias) {
		this.mostrarfecha_hastaHistorialConciliacionesBancarias= mostrarfecha_hastaHistorialConciliacionesBancarias;
	}

	public Boolean getActivarfecha_hastaHistorialConciliacionesBancarias() {
		return this.activarfecha_hastaHistorialConciliacionesBancarias;
	}

	public void setActivarfecha_hastaHistorialConciliacionesBancarias(Boolean activarfecha_hastaHistorialConciliacionesBancarias) {
		this.activarfecha_hastaHistorialConciliacionesBancarias= activarfecha_hastaHistorialConciliacionesBancarias;
	}

	public Border setResaltardebito_localHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltardebito_localHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localHistorialConciliacionesBancarias() {
		return this.resaltardebito_localHistorialConciliacionesBancarias;
	}

	public void setResaltardebito_localHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltardebito_localHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrardebito_localHistorialConciliacionesBancarias() {
		return this.mostrardebito_localHistorialConciliacionesBancarias;
	}

	public void setMostrardebito_localHistorialConciliacionesBancarias(Boolean mostrardebito_localHistorialConciliacionesBancarias) {
		this.mostrardebito_localHistorialConciliacionesBancarias= mostrardebito_localHistorialConciliacionesBancarias;
	}

	public Boolean getActivardebito_localHistorialConciliacionesBancarias() {
		return this.activardebito_localHistorialConciliacionesBancarias;
	}

	public void setActivardebito_localHistorialConciliacionesBancarias(Boolean activardebito_localHistorialConciliacionesBancarias) {
		this.activardebito_localHistorialConciliacionesBancarias= activardebito_localHistorialConciliacionesBancarias;
	}

	public Border setResaltarcredito_localHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcredito_localHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localHistorialConciliacionesBancarias() {
		return this.resaltarcredito_localHistorialConciliacionesBancarias;
	}

	public void setResaltarcredito_localHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarcredito_localHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcredito_localHistorialConciliacionesBancarias() {
		return this.mostrarcredito_localHistorialConciliacionesBancarias;
	}

	public void setMostrarcredito_localHistorialConciliacionesBancarias(Boolean mostrarcredito_localHistorialConciliacionesBancarias) {
		this.mostrarcredito_localHistorialConciliacionesBancarias= mostrarcredito_localHistorialConciliacionesBancarias;
	}

	public Boolean getActivarcredito_localHistorialConciliacionesBancarias() {
		return this.activarcredito_localHistorialConciliacionesBancarias;
	}

	public void setActivarcredito_localHistorialConciliacionesBancarias(Boolean activarcredito_localHistorialConciliacionesBancarias) {
		this.activarcredito_localHistorialConciliacionesBancarias= activarcredito_localHistorialConciliacionesBancarias;
	}

	public Border setResaltarnumero_chequeHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeHistorialConciliacionesBancarias() {
		return this.resaltarnumero_chequeHistorialConciliacionesBancarias;
	}

	public void setResaltarnumero_chequeHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarnumero_chequeHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeHistorialConciliacionesBancarias() {
		return this.mostrarnumero_chequeHistorialConciliacionesBancarias;
	}

	public void setMostrarnumero_chequeHistorialConciliacionesBancarias(Boolean mostrarnumero_chequeHistorialConciliacionesBancarias) {
		this.mostrarnumero_chequeHistorialConciliacionesBancarias= mostrarnumero_chequeHistorialConciliacionesBancarias;
	}

	public Boolean getActivarnumero_chequeHistorialConciliacionesBancarias() {
		return this.activarnumero_chequeHistorialConciliacionesBancarias;
	}

	public void setActivarnumero_chequeHistorialConciliacionesBancarias(Boolean activarnumero_chequeHistorialConciliacionesBancarias) {
		this.activarnumero_chequeHistorialConciliacionesBancarias= activarnumero_chequeHistorialConciliacionesBancarias;
	}

	public Border setResaltarcodigoHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcodigoHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoHistorialConciliacionesBancarias() {
		return this.resaltarcodigoHistorialConciliacionesBancarias;
	}

	public void setResaltarcodigoHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarcodigoHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcodigoHistorialConciliacionesBancarias() {
		return this.mostrarcodigoHistorialConciliacionesBancarias;
	}

	public void setMostrarcodigoHistorialConciliacionesBancarias(Boolean mostrarcodigoHistorialConciliacionesBancarias) {
		this.mostrarcodigoHistorialConciliacionesBancarias= mostrarcodigoHistorialConciliacionesBancarias;
	}

	public Boolean getActivarcodigoHistorialConciliacionesBancarias() {
		return this.activarcodigoHistorialConciliacionesBancarias;
	}

	public void setActivarcodigoHistorialConciliacionesBancarias(Boolean activarcodigoHistorialConciliacionesBancarias) {
		this.activarcodigoHistorialConciliacionesBancarias= activarcodigoHistorialConciliacionesBancarias;
	}

	public Border setResaltarbeneficiarioHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioHistorialConciliacionesBancarias() {
		return this.resaltarbeneficiarioHistorialConciliacionesBancarias;
	}

	public void setResaltarbeneficiarioHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarbeneficiarioHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioHistorialConciliacionesBancarias() {
		return this.mostrarbeneficiarioHistorialConciliacionesBancarias;
	}

	public void setMostrarbeneficiarioHistorialConciliacionesBancarias(Boolean mostrarbeneficiarioHistorialConciliacionesBancarias) {
		this.mostrarbeneficiarioHistorialConciliacionesBancarias= mostrarbeneficiarioHistorialConciliacionesBancarias;
	}

	public Boolean getActivarbeneficiarioHistorialConciliacionesBancarias() {
		return this.activarbeneficiarioHistorialConciliacionesBancarias;
	}

	public void setActivarbeneficiarioHistorialConciliacionesBancarias(Boolean activarbeneficiarioHistorialConciliacionesBancarias) {
		this.activarbeneficiarioHistorialConciliacionesBancarias= activarbeneficiarioHistorialConciliacionesBancarias;
	}

	public Border setResaltardetalleHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltardetalleHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleHistorialConciliacionesBancarias() {
		return this.resaltardetalleHistorialConciliacionesBancarias;
	}

	public void setResaltardetalleHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltardetalleHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrardetalleHistorialConciliacionesBancarias() {
		return this.mostrardetalleHistorialConciliacionesBancarias;
	}

	public void setMostrardetalleHistorialConciliacionesBancarias(Boolean mostrardetalleHistorialConciliacionesBancarias) {
		this.mostrardetalleHistorialConciliacionesBancarias= mostrardetalleHistorialConciliacionesBancarias;
	}

	public Boolean getActivardetalleHistorialConciliacionesBancarias() {
		return this.activardetalleHistorialConciliacionesBancarias;
	}

	public void setActivardetalleHistorialConciliacionesBancarias(Boolean activardetalleHistorialConciliacionesBancarias) {
		this.activardetalleHistorialConciliacionesBancarias= activardetalleHistorialConciliacionesBancarias;
	}

	public Border setResaltarcuentaHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarcuentaHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcuentaHistorialConciliacionesBancarias() {
		return this.resaltarcuentaHistorialConciliacionesBancarias;
	}

	public void setResaltarcuentaHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarcuentaHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarcuentaHistorialConciliacionesBancarias() {
		return this.mostrarcuentaHistorialConciliacionesBancarias;
	}

	public void setMostrarcuentaHistorialConciliacionesBancarias(Boolean mostrarcuentaHistorialConciliacionesBancarias) {
		this.mostrarcuentaHistorialConciliacionesBancarias= mostrarcuentaHistorialConciliacionesBancarias;
	}

	public Boolean getActivarcuentaHistorialConciliacionesBancarias() {
		return this.activarcuentaHistorialConciliacionesBancarias;
	}

	public void setActivarcuentaHistorialConciliacionesBancarias(Boolean activarcuentaHistorialConciliacionesBancarias) {
		this.activarcuentaHistorialConciliacionesBancarias= activarcuentaHistorialConciliacionesBancarias;
	}

	public Border setResaltartipo_documentoHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltartipo_documentoHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_documentoHistorialConciliacionesBancarias() {
		return this.resaltartipo_documentoHistorialConciliacionesBancarias;
	}

	public void setResaltartipo_documentoHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltartipo_documentoHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrartipo_documentoHistorialConciliacionesBancarias() {
		return this.mostrartipo_documentoHistorialConciliacionesBancarias;
	}

	public void setMostrartipo_documentoHistorialConciliacionesBancarias(Boolean mostrartipo_documentoHistorialConciliacionesBancarias) {
		this.mostrartipo_documentoHistorialConciliacionesBancarias= mostrartipo_documentoHistorialConciliacionesBancarias;
	}

	public Boolean getActivartipo_documentoHistorialConciliacionesBancarias() {
		return this.activartipo_documentoHistorialConciliacionesBancarias;
	}

	public void setActivartipo_documentoHistorialConciliacionesBancarias(Boolean activartipo_documentoHistorialConciliacionesBancarias) {
		this.activartipo_documentoHistorialConciliacionesBancarias= activartipo_documentoHistorialConciliacionesBancarias;
	}

	public Border setResaltarnumero_mayorHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorHistorialConciliacionesBancarias() {
		return this.resaltarnumero_mayorHistorialConciliacionesBancarias;
	}

	public void setResaltarnumero_mayorHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarnumero_mayorHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorHistorialConciliacionesBancarias() {
		return this.mostrarnumero_mayorHistorialConciliacionesBancarias;
	}

	public void setMostrarnumero_mayorHistorialConciliacionesBancarias(Boolean mostrarnumero_mayorHistorialConciliacionesBancarias) {
		this.mostrarnumero_mayorHistorialConciliacionesBancarias= mostrarnumero_mayorHistorialConciliacionesBancarias;
	}

	public Boolean getActivarnumero_mayorHistorialConciliacionesBancarias() {
		return this.activarnumero_mayorHistorialConciliacionesBancarias;
	}

	public void setActivarnumero_mayorHistorialConciliacionesBancarias(Boolean activarnumero_mayorHistorialConciliacionesBancarias) {
		this.activarnumero_mayorHistorialConciliacionesBancarias= activarnumero_mayorHistorialConciliacionesBancarias;
	}

	public Border setResaltarfecha_finalizacionHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfecha_finalizacionHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalizacionHistorialConciliacionesBancarias() {
		return this.resaltarfecha_finalizacionHistorialConciliacionesBancarias;
	}

	public void setResaltarfecha_finalizacionHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarfecha_finalizacionHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfecha_finalizacionHistorialConciliacionesBancarias() {
		return this.mostrarfecha_finalizacionHistorialConciliacionesBancarias;
	}

	public void setMostrarfecha_finalizacionHistorialConciliacionesBancarias(Boolean mostrarfecha_finalizacionHistorialConciliacionesBancarias) {
		this.mostrarfecha_finalizacionHistorialConciliacionesBancarias= mostrarfecha_finalizacionHistorialConciliacionesBancarias;
	}

	public Boolean getActivarfecha_finalizacionHistorialConciliacionesBancarias() {
		return this.activarfecha_finalizacionHistorialConciliacionesBancarias;
	}

	public void setActivarfecha_finalizacionHistorialConciliacionesBancarias(Boolean activarfecha_finalizacionHistorialConciliacionesBancarias) {
		this.activarfecha_finalizacionHistorialConciliacionesBancarias= activarfecha_finalizacionHistorialConciliacionesBancarias;
	}

	public Border setResaltartipo_movimientoHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoHistorialConciliacionesBancarias() {
		return this.resaltartipo_movimientoHistorialConciliacionesBancarias;
	}

	public void setResaltartipo_movimientoHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltartipo_movimientoHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoHistorialConciliacionesBancarias() {
		return this.mostrartipo_movimientoHistorialConciliacionesBancarias;
	}

	public void setMostrartipo_movimientoHistorialConciliacionesBancarias(Boolean mostrartipo_movimientoHistorialConciliacionesBancarias) {
		this.mostrartipo_movimientoHistorialConciliacionesBancarias= mostrartipo_movimientoHistorialConciliacionesBancarias;
	}

	public Boolean getActivartipo_movimientoHistorialConciliacionesBancarias() {
		return this.activartipo_movimientoHistorialConciliacionesBancarias;
	}

	public void setActivartipo_movimientoHistorialConciliacionesBancarias(Boolean activartipo_movimientoHistorialConciliacionesBancarias) {
		this.activartipo_movimientoHistorialConciliacionesBancarias= activartipo_movimientoHistorialConciliacionesBancarias;
	}

	public Border setResaltarsaldo_librosHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarsaldo_librosHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_librosHistorialConciliacionesBancarias() {
		return this.resaltarsaldo_librosHistorialConciliacionesBancarias;
	}

	public void setResaltarsaldo_librosHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarsaldo_librosHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarsaldo_librosHistorialConciliacionesBancarias() {
		return this.mostrarsaldo_librosHistorialConciliacionesBancarias;
	}

	public void setMostrarsaldo_librosHistorialConciliacionesBancarias(Boolean mostrarsaldo_librosHistorialConciliacionesBancarias) {
		this.mostrarsaldo_librosHistorialConciliacionesBancarias= mostrarsaldo_librosHistorialConciliacionesBancarias;
	}

	public Boolean getActivarsaldo_librosHistorialConciliacionesBancarias() {
		return this.activarsaldo_librosHistorialConciliacionesBancarias;
	}

	public void setActivarsaldo_librosHistorialConciliacionesBancarias(Boolean activarsaldo_librosHistorialConciliacionesBancarias) {
		this.activarsaldo_librosHistorialConciliacionesBancarias= activarsaldo_librosHistorialConciliacionesBancarias;
	}

	public Border setResaltarfechaHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarfechaHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaHistorialConciliacionesBancarias() {
		return this.resaltarfechaHistorialConciliacionesBancarias;
	}

	public void setResaltarfechaHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarfechaHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarfechaHistorialConciliacionesBancarias() {
		return this.mostrarfechaHistorialConciliacionesBancarias;
	}

	public void setMostrarfechaHistorialConciliacionesBancarias(Boolean mostrarfechaHistorialConciliacionesBancarias) {
		this.mostrarfechaHistorialConciliacionesBancarias= mostrarfechaHistorialConciliacionesBancarias;
	}

	public Boolean getActivarfechaHistorialConciliacionesBancarias() {
		return this.activarfechaHistorialConciliacionesBancarias;
	}

	public void setActivarfechaHistorialConciliacionesBancarias(Boolean activarfechaHistorialConciliacionesBancarias) {
		this.activarfechaHistorialConciliacionesBancarias= activarfechaHistorialConciliacionesBancarias;
	}

	public Border setResaltarnumero_cuentaHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaHistorialConciliacionesBancarias() {
		return this.resaltarnumero_cuentaHistorialConciliacionesBancarias;
	}

	public void setResaltarnumero_cuentaHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarnumero_cuentaHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaHistorialConciliacionesBancarias() {
		return this.mostrarnumero_cuentaHistorialConciliacionesBancarias;
	}

	public void setMostrarnumero_cuentaHistorialConciliacionesBancarias(Boolean mostrarnumero_cuentaHistorialConciliacionesBancarias) {
		this.mostrarnumero_cuentaHistorialConciliacionesBancarias= mostrarnumero_cuentaHistorialConciliacionesBancarias;
	}

	public Boolean getActivarnumero_cuentaHistorialConciliacionesBancarias() {
		return this.activarnumero_cuentaHistorialConciliacionesBancarias;
	}

	public void setActivarnumero_cuentaHistorialConciliacionesBancarias(Boolean activarnumero_cuentaHistorialConciliacionesBancarias) {
		this.activarnumero_cuentaHistorialConciliacionesBancarias= activarnumero_cuentaHistorialConciliacionesBancarias;
	}

	public Border setResaltarnombre_cuenta_contableHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableHistorialConciliacionesBancarias() {
		return this.resaltarnombre_cuenta_contableHistorialConciliacionesBancarias;
	}

	public void setResaltarnombre_cuenta_contableHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableHistorialConciliacionesBancarias() {
		return this.mostrarnombre_cuenta_contableHistorialConciliacionesBancarias;
	}

	public void setMostrarnombre_cuenta_contableHistorialConciliacionesBancarias(Boolean mostrarnombre_cuenta_contableHistorialConciliacionesBancarias) {
		this.mostrarnombre_cuenta_contableHistorialConciliacionesBancarias= mostrarnombre_cuenta_contableHistorialConciliacionesBancarias;
	}

	public Boolean getActivarnombre_cuenta_contableHistorialConciliacionesBancarias() {
		return this.activarnombre_cuenta_contableHistorialConciliacionesBancarias;
	}

	public void setActivarnombre_cuenta_contableHistorialConciliacionesBancarias(Boolean activarnombre_cuenta_contableHistorialConciliacionesBancarias) {
		this.activarnombre_cuenta_contableHistorialConciliacionesBancarias= activarnombre_cuenta_contableHistorialConciliacionesBancarias;
	}

	public Border setResaltaranteriorHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//historialconciliacionesbancariasBeanSwingJInternalFrame.jTtoolBarHistorialConciliacionesBancarias.setBorder(borderResaltar);
		
		this.resaltaranteriorHistorialConciliacionesBancarias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranteriorHistorialConciliacionesBancarias() {
		return this.resaltaranteriorHistorialConciliacionesBancarias;
	}

	public void setResaltaranteriorHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltaranteriorHistorialConciliacionesBancarias= borderResaltar;
	}

	public Boolean getMostraranteriorHistorialConciliacionesBancarias() {
		return this.mostraranteriorHistorialConciliacionesBancarias;
	}

	public void setMostraranteriorHistorialConciliacionesBancarias(Boolean mostraranteriorHistorialConciliacionesBancarias) {
		this.mostraranteriorHistorialConciliacionesBancarias= mostraranteriorHistorialConciliacionesBancarias;
	}

	public Boolean getActivaranteriorHistorialConciliacionesBancarias() {
		return this.activaranteriorHistorialConciliacionesBancarias;
	}

	public void setActivaranteriorHistorialConciliacionesBancarias(Boolean activaranteriorHistorialConciliacionesBancarias) {
		this.activaranteriorHistorialConciliacionesBancarias= activaranteriorHistorialConciliacionesBancarias;
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
		
		
		this.setMostraridHistorialConciliacionesBancarias(esInicial);
		this.setMostrarid_empresaHistorialConciliacionesBancarias(esInicial);
		this.setMostrarid_cuenta_contableHistorialConciliacionesBancarias(esInicial);
		this.setMostrarfecha_desdeHistorialConciliacionesBancarias(esInicial);
		this.setMostrarfecha_hastaHistorialConciliacionesBancarias(esInicial);
		this.setMostrardebito_localHistorialConciliacionesBancarias(esInicial);
		this.setMostrarcredito_localHistorialConciliacionesBancarias(esInicial);
		this.setMostrarnumero_chequeHistorialConciliacionesBancarias(esInicial);
		this.setMostrarcodigoHistorialConciliacionesBancarias(esInicial);
		this.setMostrarbeneficiarioHistorialConciliacionesBancarias(esInicial);
		this.setMostrardetalleHistorialConciliacionesBancarias(esInicial);
		this.setMostrarcuentaHistorialConciliacionesBancarias(esInicial);
		this.setMostrartipo_documentoHistorialConciliacionesBancarias(esInicial);
		this.setMostrarnumero_mayorHistorialConciliacionesBancarias(esInicial);
		this.setMostrarfecha_finalizacionHistorialConciliacionesBancarias(esInicial);
		this.setMostrartipo_movimientoHistorialConciliacionesBancarias(esInicial);
		this.setMostrarsaldo_librosHistorialConciliacionesBancarias(esInicial);
		this.setMostrarfechaHistorialConciliacionesBancarias(esInicial);
		this.setMostrarnumero_cuentaHistorialConciliacionesBancarias(esInicial);
		this.setMostrarnombre_cuenta_contableHistorialConciliacionesBancarias(esInicial);
		this.setMostraranteriorHistorialConciliacionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.ID)) {
				this.setMostraridHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.DETALLE)) {
				this.setMostrardetalleHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CUENTA)) {
				this.setMostrarcuentaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO)) {
				this.setMostrartipo_documentoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION)) {
				this.setMostrarfecha_finalizacionHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS)) {
				this.setMostrarsaldo_librosHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHA)) {
				this.setMostrarfechaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR)) {
				this.setMostraranteriorHistorialConciliacionesBancarias(esAsigna);
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
		
		
		this.setActivaridHistorialConciliacionesBancarias(esInicial);
		this.setActivarid_empresaHistorialConciliacionesBancarias(esInicial);
		this.setActivarid_cuenta_contableHistorialConciliacionesBancarias(esInicial);
		this.setActivarfecha_desdeHistorialConciliacionesBancarias(esInicial);
		this.setActivarfecha_hastaHistorialConciliacionesBancarias(esInicial);
		this.setActivardebito_localHistorialConciliacionesBancarias(esInicial);
		this.setActivarcredito_localHistorialConciliacionesBancarias(esInicial);
		this.setActivarnumero_chequeHistorialConciliacionesBancarias(esInicial);
		this.setActivarcodigoHistorialConciliacionesBancarias(esInicial);
		this.setActivarbeneficiarioHistorialConciliacionesBancarias(esInicial);
		this.setActivardetalleHistorialConciliacionesBancarias(esInicial);
		this.setActivarcuentaHistorialConciliacionesBancarias(esInicial);
		this.setActivartipo_documentoHistorialConciliacionesBancarias(esInicial);
		this.setActivarnumero_mayorHistorialConciliacionesBancarias(esInicial);
		this.setActivarfecha_finalizacionHistorialConciliacionesBancarias(esInicial);
		this.setActivartipo_movimientoHistorialConciliacionesBancarias(esInicial);
		this.setActivarsaldo_librosHistorialConciliacionesBancarias(esInicial);
		this.setActivarfechaHistorialConciliacionesBancarias(esInicial);
		this.setActivarnumero_cuentaHistorialConciliacionesBancarias(esInicial);
		this.setActivarnombre_cuenta_contableHistorialConciliacionesBancarias(esInicial);
		this.setActivaranteriorHistorialConciliacionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.ID)) {
				this.setActivaridHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.DETALLE)) {
				this.setActivardetalleHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CUENTA)) {
				this.setActivarcuentaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO)) {
				this.setActivartipo_documentoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION)) {
				this.setActivarfecha_finalizacionHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS)) {
				this.setActivarsaldo_librosHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHA)) {
				this.setActivarfechaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR)) {
				this.setActivaranteriorHistorialConciliacionesBancarias(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHistorialConciliacionesBancarias(esInicial);
		this.setResaltarid_empresaHistorialConciliacionesBancarias(esInicial);
		this.setResaltarid_cuenta_contableHistorialConciliacionesBancarias(esInicial);
		this.setResaltarfecha_desdeHistorialConciliacionesBancarias(esInicial);
		this.setResaltarfecha_hastaHistorialConciliacionesBancarias(esInicial);
		this.setResaltardebito_localHistorialConciliacionesBancarias(esInicial);
		this.setResaltarcredito_localHistorialConciliacionesBancarias(esInicial);
		this.setResaltarnumero_chequeHistorialConciliacionesBancarias(esInicial);
		this.setResaltarcodigoHistorialConciliacionesBancarias(esInicial);
		this.setResaltarbeneficiarioHistorialConciliacionesBancarias(esInicial);
		this.setResaltardetalleHistorialConciliacionesBancarias(esInicial);
		this.setResaltarcuentaHistorialConciliacionesBancarias(esInicial);
		this.setResaltartipo_documentoHistorialConciliacionesBancarias(esInicial);
		this.setResaltarnumero_mayorHistorialConciliacionesBancarias(esInicial);
		this.setResaltarfecha_finalizacionHistorialConciliacionesBancarias(esInicial);
		this.setResaltartipo_movimientoHistorialConciliacionesBancarias(esInicial);
		this.setResaltarsaldo_librosHistorialConciliacionesBancarias(esInicial);
		this.setResaltarfechaHistorialConciliacionesBancarias(esInicial);
		this.setResaltarnumero_cuentaHistorialConciliacionesBancarias(esInicial);
		this.setResaltarnombre_cuenta_contableHistorialConciliacionesBancarias(esInicial);
		this.setResaltaranteriorHistorialConciliacionesBancarias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.ID)) {
				this.setResaltaridHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.DETALLE)) {
				this.setResaltardetalleHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.CUENTA)) {
				this.setResaltarcuentaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPODOCUMENTO)) {
				this.setResaltartipo_documentoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHAFINALIZACION)) {
				this.setResaltarfecha_finalizacionHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS)) {
				this.setResaltarsaldo_librosHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.FECHA)) {
				this.setResaltarfechaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableHistorialConciliacionesBancarias(esAsigna);
				continue;
			}

			if(campo.clase.equals(HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR)) {
				this.setResaltaranteriorHistorialConciliacionesBancarias(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias=true;

	public Boolean getMostrarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias() {
		return this.mostrarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias;
	}

	public void setMostrarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias(Boolean visibilidadResaltar) {
		this.mostrarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias=true;

	public Boolean getActivarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias() {
		return this.activarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias;
	}

	public void setActivarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias(Boolean habilitarResaltar) {
		this.activarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias=null;

	public Border getResaltarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias() {
		return this.resaltarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias;
	}

	public void setResaltarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias(Border borderResaltar) {
		this.resaltarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias= borderResaltar;
	}

	public void setResaltarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias(ParametroGeneralUsuario parametroGeneralUsuario/*HistorialConciliacionesBancariasBeanSwingJInternalFrame historialconciliacionesbancariasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaHistorialConciliacionesBancariasHistorialConciliacionesBancarias= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}