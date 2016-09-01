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


import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorCuentasConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorCuentasParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorCuentasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RetencionesPorPagarPorCuentasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="RetencionesPorPagarPorCuentas";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RetencionesPorPagarPorCuentas"+RetencionesPorPagarPorCuentasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RetencionesPorPagarPorCuentasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RetencionesPorPagarPorCuentasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorCuentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorCuentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RetencionesPorPagarPorCuentasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RetencionesPorPagarPorCuentasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RetencionesPorPagarPorCuentasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RetencionesPorPagarPorCuentasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Retenciones Por Pagar Por Cuentases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Retenciones Por Pagar Por Cuentas";
	public static final String SCLASSWEBTITULO_LOWER="Retenciones Por Pagar Por Cuentas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RetencionesPorPagarPorCuentas";
	public static final String OBJECTNAME="retencionesporpagarporcuentas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="retenciones_por_pagar_por_cuentas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select retencionesporpagarporcuentas from "+RetencionesPorPagarPorCuentasConstantesFunciones.SPERSISTENCENAME+" retencionesporpagarporcuentas";
	public static String QUERYSELECTNATIVE="select "+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".id,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".version_row,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".id_empresa,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".id_sucursal,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".id_ejercicio,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".id_periodo,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".id_tipo_retencion,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".es_debito,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".fecha_emision,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".nombre_tipo_movimiento,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".numero_mayor,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".nombre_cuenta_contable_retencion,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".numero_pre_impreso_factura,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".porcentaje,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".base_imponible,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".valor,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".numero,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".nombre_benef,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".ruc_benef,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".nombre_cuenta_contable_credito,"+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME+".es_debito_dato from "+RetencionesPorPagarPorCuentasConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME;//+" as "+RetencionesPorPagarPorCuentasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String ESDEBITO= "es_debito";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NOMBRETIPOMOVIMIENTO= "nombre_tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String NOMBRECUENTACONTABLERETENCION= "nombre_cuenta_contable_retencion";
    public static final String NUMEROPREIMPRESOFACTURA= "numero_pre_impreso_factura";
    public static final String PORCENTAJE= "porcentaje";
    public static final String BASEIMPONIBLE= "base_imponible";
    public static final String VALOR= "valor";
    public static final String NUMERO= "numero";
    public static final String NOMBREBENEF= "nombre_benef";
    public static final String RUCBENEF= "ruc_benef";
    public static final String NOMBRECUENTACONTABLE= "nombre_cuenta_contable";
    public static final String NOMBRECUENTACONTABLECREDITO= "nombre_cuenta_contable_credito";
    public static final String ESDEBITODATO= "es_debito_dato";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_ESDEBITO= "Es Debito";
		public static final String LABEL_ESDEBITO_LOWER= "Es Debito";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NOMBRETIPOMOVIMIENTO= "Nombre Tipo Movimiento";
		public static final String LABEL_NOMBRETIPOMOVIMIENTO_LOWER= "Nombre Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_NOMBRECUENTACONTABLERETENCION= "Nombre Cuenta Contable Retencion";
		public static final String LABEL_NOMBRECUENTACONTABLERETENCION_LOWER= "Nombre Cuenta Contable Retencion";
    	public static final String LABEL_NUMEROPREIMPRESOFACTURA= "Numero Pre Impreso Factura";
		public static final String LABEL_NUMEROPREIMPRESOFACTURA_LOWER= "Numero Pre Impreso Factura";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_BASEIMPONIBLE= "Base Imponible";
		public static final String LABEL_BASEIMPONIBLE_LOWER= "Base Imponible";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NOMBREBENEF= "Nombre Benef";
		public static final String LABEL_NOMBREBENEF_LOWER= "Nombre Benef";
    	public static final String LABEL_RUCBENEF= "Ruc Benef";
		public static final String LABEL_RUCBENEF_LOWER= "Ruc Benef";
    	public static final String LABEL_NOMBRECUENTACONTABLE= "Nombre Cuenta Contable";
		public static final String LABEL_NOMBRECUENTACONTABLE_LOWER= "Nombre Cuenta Contable";
    	public static final String LABEL_NOMBRECUENTACONTABLECREDITO= "Nombre Cuenta Contable Credito";
		public static final String LABEL_NOMBRECUENTACONTABLECREDITO_LOWER= "Nombre Cuenta Contable Credito";
    	public static final String LABEL_ESDEBITODATO= "Es Debito Dato";
		public static final String LABEL_ESDEBITODATO_LOWER= "Es Debito Dato";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_TIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_BENEF=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_BENEF=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getRetencionesPorPagarPorCuentasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITO)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.VALOR)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBREBENEF;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_RUCBENEF;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO)) {sLabelColumna=RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITODATO;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getes_debitoDescripcion(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!retencionesporpagarporcuentas.getes_debito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debitoHtmlDescripcion(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(retencionesporpagarporcuentas.getId(),retencionesporpagarporcuentas.getes_debito());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_debito_datoDescripcion(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!retencionesporpagarporcuentas.getes_debito_dato()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debito_datoHtmlDescripcion(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(retencionesporpagarporcuentas.getId(),retencionesporpagarporcuentas.getes_debito_dato());

		return sDescripcion;
	}	
	
	public static String getRetencionesPorPagarPorCuentasDescripcion(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(retencionesporpagarporcuentas !=null/* && retencionesporpagarporcuentas.getId()!=0*/) {
			if(retencionesporpagarporcuentas.getId()!=null) {
				sDescripcion=retencionesporpagarporcuentas.getId().toString();
			}//retencionesporpagarporcuentasretencionesporpagarporcuentas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRetencionesPorPagarPorCuentasDescripcionDetallado(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) {
		String sDescripcion="";
			
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.ID+"=";
		sDescripcion+=retencionesporpagarporcuentas.getId().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=retencionesporpagarporcuentas.getVersionRow().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=retencionesporpagarporcuentas.getid_empresa().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=retencionesporpagarporcuentas.getid_sucursal().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=retencionesporpagarporcuentas.getid_ejercicio().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=retencionesporpagarporcuentas.getid_periodo().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=retencionesporpagarporcuentas.getid_tipo_retencion().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITO+"=";
		sDescripcion+=retencionesporpagarporcuentas.getes_debito().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=retencionesporpagarporcuentas.getfecha_emision().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnombre_tipo_movimiento()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnumero_mayor()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnombre_cuenta_contable_retencion()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnumero_pre_impreso_factura()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=retencionesporpagarporcuentas.getporcentaje().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=retencionesporpagarporcuentas.getbase_imponible().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.VALOR+"=";
		sDescripcion+=retencionesporpagarporcuentas.getvalor().toString()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnumero()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnombre_benef()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF+"=";
		sDescripcion+=retencionesporpagarporcuentas.getruc_benef()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnombre_cuenta_contable()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO+"=";
		sDescripcion+=retencionesporpagarporcuentas.getnombre_cuenta_contable_credito()+",";
		sDescripcion+=RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO+"=";
		sDescripcion+=retencionesporpagarporcuentas.getes_debito_dato().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRetencionesPorPagarPorCuentasDescripcion(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,String sValor) throws Exception {			
		if(retencionesporpagarporcuentas !=null) {
			//retencionesporpagarporcuentasretencionesporpagarporcuentas.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaRetencionesPorPagarPorCuentas")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo Por Tipo Retencion Por Es Debito";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaRetencionesPorPagarPorCuentas(Long id_ejercicio,Long id_periodo,Long id_tipo_retencion,Boolean es_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();}
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();}
		if(es_debito!=null) {sDetalleIndice+=" Es Debito="+es_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencionesporpagarporcuentas.setnombre_tipo_movimiento(retencionesporpagarporcuentas.getnombre_tipo_movimiento().trim());
		retencionesporpagarporcuentas.setnumero_mayor(retencionesporpagarporcuentas.getnumero_mayor().trim());
		retencionesporpagarporcuentas.setnombre_cuenta_contable_retencion(retencionesporpagarporcuentas.getnombre_cuenta_contable_retencion().trim());
		retencionesporpagarporcuentas.setnumero_pre_impreso_factura(retencionesporpagarporcuentas.getnumero_pre_impreso_factura().trim());
		retencionesporpagarporcuentas.setnumero(retencionesporpagarporcuentas.getnumero().trim());
		retencionesporpagarporcuentas.setnombre_benef(retencionesporpagarporcuentas.getnombre_benef().trim());
		retencionesporpagarporcuentas.setruc_benef(retencionesporpagarporcuentas.getruc_benef().trim());
		retencionesporpagarporcuentas.setnombre_cuenta_contable(retencionesporpagarporcuentas.getnombre_cuenta_contable().trim());
		retencionesporpagarporcuentas.setnombre_cuenta_contable_credito(retencionesporpagarporcuentas.getnombre_cuenta_contable_credito().trim());
	}
	
	public static void quitarEspaciosRetencionesPorPagarPorCuentass(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas: retencionesporpagarporcuentass) {
			retencionesporpagarporcuentas.setnombre_tipo_movimiento(retencionesporpagarporcuentas.getnombre_tipo_movimiento().trim());
			retencionesporpagarporcuentas.setnumero_mayor(retencionesporpagarporcuentas.getnumero_mayor().trim());
			retencionesporpagarporcuentas.setnombre_cuenta_contable_retencion(retencionesporpagarporcuentas.getnombre_cuenta_contable_retencion().trim());
			retencionesporpagarporcuentas.setnumero_pre_impreso_factura(retencionesporpagarporcuentas.getnumero_pre_impreso_factura().trim());
			retencionesporpagarporcuentas.setnumero(retencionesporpagarporcuentas.getnumero().trim());
			retencionesporpagarporcuentas.setnombre_benef(retencionesporpagarporcuentas.getnombre_benef().trim());
			retencionesporpagarporcuentas.setruc_benef(retencionesporpagarporcuentas.getruc_benef().trim());
			retencionesporpagarporcuentas.setnombre_cuenta_contable(retencionesporpagarporcuentas.getnombre_cuenta_contable().trim());
			retencionesporpagarporcuentas.setnombre_cuenta_contable_credito(retencionesporpagarporcuentas.getnombre_cuenta_contable_credito().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && retencionesporpagarporcuentas.getConCambioAuxiliar()) {
			retencionesporpagarporcuentas.setIsDeleted(retencionesporpagarporcuentas.getIsDeletedAuxiliar());	
			retencionesporpagarporcuentas.setIsNew(retencionesporpagarporcuentas.getIsNewAuxiliar());	
			retencionesporpagarporcuentas.setIsChanged(retencionesporpagarporcuentas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			retencionesporpagarporcuentas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			retencionesporpagarporcuentas.setIsDeletedAuxiliar(false);	
			retencionesporpagarporcuentas.setIsNewAuxiliar(false);	
			retencionesporpagarporcuentas.setIsChangedAuxiliar(false);
			
			retencionesporpagarporcuentas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionesPorPagarPorCuentass(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas : retencionesporpagarporcuentass) {
			if(conAsignarBase && retencionesporpagarporcuentas.getConCambioAuxiliar()) {
				retencionesporpagarporcuentas.setIsDeleted(retencionesporpagarporcuentas.getIsDeletedAuxiliar());	
				retencionesporpagarporcuentas.setIsNew(retencionesporpagarporcuentas.getIsNewAuxiliar());	
				retencionesporpagarporcuentas.setIsChanged(retencionesporpagarporcuentas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				retencionesporpagarporcuentas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				retencionesporpagarporcuentas.setIsDeletedAuxiliar(false);	
				retencionesporpagarporcuentas.setIsNewAuxiliar(false);	
				retencionesporpagarporcuentas.setIsChangedAuxiliar(false);
				
				retencionesporpagarporcuentas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,Boolean conEnteros) throws Exception  {
		retencionesporpagarporcuentas.setporcentaje(0.0);
		retencionesporpagarporcuentas.setbase_imponible(0.0);
		retencionesporpagarporcuentas.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRetencionesPorPagarPorCuentass(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,Boolean conEnteros) throws Exception  {
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas: retencionesporpagarporcuentass) {
			retencionesporpagarporcuentas.setporcentaje(0.0);
			retencionesporpagarporcuentas.setbase_imponible(0.0);
			retencionesporpagarporcuentas.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRetencionesPorPagarPorCuentas(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAux) throws Exception  {
		RetencionesPorPagarPorCuentasConstantesFunciones.InicializarValoresRetencionesPorPagarPorCuentas(retencionesporpagarporcuentasAux,true);
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas: retencionesporpagarporcuentass) {
			if(retencionesporpagarporcuentas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			retencionesporpagarporcuentasAux.setporcentaje(retencionesporpagarporcuentasAux.getporcentaje()+retencionesporpagarporcuentas.getporcentaje());			
			retencionesporpagarporcuentasAux.setbase_imponible(retencionesporpagarporcuentasAux.getbase_imponible()+retencionesporpagarporcuentas.getbase_imponible());			
			retencionesporpagarporcuentasAux.setvalor(retencionesporpagarporcuentasAux.getvalor()+retencionesporpagarporcuentas.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionesPorPagarPorCuentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RetencionesPorPagarPorCuentasConstantesFunciones.getArrayColumnasGlobalesRetencionesPorPagarPorCuentas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionesPorPagarPorCuentas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRetencionesPorPagarPorCuentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAux: retencionesporpagarporcuentass) {
			if(retencionesporpagarporcuentasAux!=null && retencionesporpagarporcuentas!=null) {
				if((retencionesporpagarporcuentasAux.getId()==null && retencionesporpagarporcuentas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(retencionesporpagarporcuentasAux.getId()!=null && retencionesporpagarporcuentas.getId()!=null){
					if(retencionesporpagarporcuentasAux.getId().equals(retencionesporpagarporcuentas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRetencionesPorPagarPorCuentas(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valorTotal=0.0;
	
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas: retencionesporpagarporcuentass) {			
			if(retencionesporpagarporcuentas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=retencionesporpagarporcuentas.getporcentaje();
			base_imponibleTotal+=retencionesporpagarporcuentas.getbase_imponible();
			valorTotal+=retencionesporpagarporcuentas.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRetencionesPorPagarPorCuentas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ID, RetencionesPorPagarPorCuentasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VERSIONROW, RetencionesPorPagarPorCuentasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_FECHAEMISION, RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO, RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROMAYOR, RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION, RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA, RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_PORCENTAJE, RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_BASEIMPONIBLE, RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VALOR, RetencionesPorPagarPorCuentasConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMERO, RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBREBENEF, RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_RUCBENEF, RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO, RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITODATO, RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRetencionesPorPagarPorCuentas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionesPorPagarPorCuentas() throws Exception  {
		return RetencionesPorPagarPorCuentasConstantesFunciones.getTiposSeleccionarRetencionesPorPagarPorCuentas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionesPorPagarPorCuentas(Boolean conFk) throws Exception  {
		return RetencionesPorPagarPorCuentasConstantesFunciones.getTiposSeleccionarRetencionesPorPagarPorCuentas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionesPorPagarPorCuentas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITO);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBREBENEF);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBREBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_RUCBENEF);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_RUCBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITODATO);
			reporte.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRetencionesPorPagarPorCuentas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAux) throws Exception {
		
			retencionesporpagarporcuentasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionesporpagarporcuentasAux.getEmpresa()));
			retencionesporpagarporcuentasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencionesporpagarporcuentasAux.getSucursal()));
			retencionesporpagarporcuentasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencionesporpagarporcuentasAux.getEjercicio()));
			retencionesporpagarporcuentasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencionesporpagarporcuentasAux.getPeriodo()));
			retencionesporpagarporcuentasAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencionesporpagarporcuentasAux.getTipoRetencion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionesPorPagarPorCuentas(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentassTemp) throws Exception {
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAux:retencionesporpagarporcuentassTemp) {
			
			retencionesporpagarporcuentasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionesporpagarporcuentasAux.getEmpresa()));
			retencionesporpagarporcuentasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencionesporpagarporcuentasAux.getSucursal()));
			retencionesporpagarporcuentasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencionesporpagarporcuentasAux.getEjercicio()));
			retencionesporpagarporcuentasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencionesporpagarporcuentasAux.getPeriodo()));
			retencionesporpagarporcuentasAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(retencionesporpagarporcuentasAux.getTipoRetencion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRetencionesPorPagarPorCuentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(TipoRetencion.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRetencionesPorPagarPorCuentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionesPorPagarPorCuentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionesPorPagarPorCuentasConstantesFunciones.getClassesRelationshipsOfRetencionesPorPagarPorCuentas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionesPorPagarPorCuentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionesPorPagarPorCuentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionesPorPagarPorCuentasConstantesFunciones.getClassesRelationshipsFromStringsOfRetencionesPorPagarPorCuentas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionesPorPagarPorCuentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass) throws Exception {
		try	{			
			for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasLocal:retencionesporpagarporcuentass) {
				if(retencionesporpagarporcuentasLocal.getId().equals(retencionesporpagarporcuentas.getId())) {
					retencionesporpagarporcuentasLocal.setIsSelected(retencionesporpagarporcuentas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRetencionesPorPagarPorCuentas(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentassAux) throws Exception {
		//this.retencionesporpagarporcuentassAux=retencionesporpagarporcuentassAux;
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAux:retencionesporpagarporcuentassAux) {
			if(retencionesporpagarporcuentasAux.getIsChanged()) {
				retencionesporpagarporcuentasAux.setIsChanged(false);
			}		
			
			if(retencionesporpagarporcuentasAux.getIsNew()) {
				retencionesporpagarporcuentasAux.setIsNew(false);
			}	
			
			if(retencionesporpagarporcuentasAux.getIsDeleted()) {
				retencionesporpagarporcuentasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAux) throws Exception {
		//this.retencionesporpagarporcuentasAux=retencionesporpagarporcuentasAux;
		
			if(retencionesporpagarporcuentasAux.getIsChanged()) {
				retencionesporpagarporcuentasAux.setIsChanged(false);
			}		
			
			if(retencionesporpagarporcuentasAux.getIsNew()) {
				retencionesporpagarporcuentasAux.setIsNew(false);
			}	
			
			if(retencionesporpagarporcuentasAux.getIsDeleted()) {
				retencionesporpagarporcuentasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAsignar,RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) throws Exception {
		retencionesporpagarporcuentasAsignar.setId(retencionesporpagarporcuentas.getId());	
		retencionesporpagarporcuentasAsignar.setVersionRow(retencionesporpagarporcuentas.getVersionRow());	
		retencionesporpagarporcuentasAsignar.setfecha_emision(retencionesporpagarporcuentas.getfecha_emision());	
		retencionesporpagarporcuentasAsignar.setnombre_tipo_movimiento(retencionesporpagarporcuentas.getnombre_tipo_movimiento());	
		retencionesporpagarporcuentasAsignar.setnumero_mayor(retencionesporpagarporcuentas.getnumero_mayor());	
		retencionesporpagarporcuentasAsignar.setnombre_cuenta_contable_retencion(retencionesporpagarporcuentas.getnombre_cuenta_contable_retencion());	
		retencionesporpagarporcuentasAsignar.setnumero_pre_impreso_factura(retencionesporpagarporcuentas.getnumero_pre_impreso_factura());	
		retencionesporpagarporcuentasAsignar.setporcentaje(retencionesporpagarporcuentas.getporcentaje());	
		retencionesporpagarporcuentasAsignar.setbase_imponible(retencionesporpagarporcuentas.getbase_imponible());	
		retencionesporpagarporcuentasAsignar.setvalor(retencionesporpagarporcuentas.getvalor());	
		retencionesporpagarporcuentasAsignar.setnumero(retencionesporpagarporcuentas.getnumero());	
		retencionesporpagarporcuentasAsignar.setnombre_benef(retencionesporpagarporcuentas.getnombre_benef());	
		retencionesporpagarporcuentasAsignar.setruc_benef(retencionesporpagarporcuentas.getruc_benef());	
		retencionesporpagarporcuentasAsignar.setnombre_cuenta_contable(retencionesporpagarporcuentas.getnombre_cuenta_contable());	
		retencionesporpagarporcuentasAsignar.setnombre_cuenta_contable_credito(retencionesporpagarporcuentas.getnombre_cuenta_contable_credito());	
		retencionesporpagarporcuentasAsignar.setes_debito_dato(retencionesporpagarporcuentas.getes_debito_dato());	
	}
	
	public static void inicializarRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) throws Exception {
		try {
				retencionesporpagarporcuentas.setId(0L);	
					
				retencionesporpagarporcuentas.setfecha_emision(new Date());	
				retencionesporpagarporcuentas.setnombre_tipo_movimiento("");	
				retencionesporpagarporcuentas.setnumero_mayor("");	
				retencionesporpagarporcuentas.setnombre_cuenta_contable_retencion("");	
				retencionesporpagarporcuentas.setnumero_pre_impreso_factura("");	
				retencionesporpagarporcuentas.setporcentaje(0.0);	
				retencionesporpagarporcuentas.setbase_imponible(0.0);	
				retencionesporpagarporcuentas.setvalor(0.0);	
				retencionesporpagarporcuentas.setnumero("");	
				retencionesporpagarporcuentas.setnombre_benef("");	
				retencionesporpagarporcuentas.setruc_benef("");	
				retencionesporpagarporcuentas.setnombre_cuenta_contable("");	
				retencionesporpagarporcuentas.setnombre_cuenta_contable_credito("");	
				retencionesporpagarporcuentas.setes_debito_dato(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRetencionesPorPagarPorCuentas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBREBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_RUCBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_ESDEBITODATO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRetencionesPorPagarPorCuentas(String sTipo,Row row,Workbook workbook,RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(retencionesporpagarporcuentas.getes_debito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnombre_tipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnombre_cuenta_contable_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnumero_pre_impreso_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnombre_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getruc_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporcuentas.getnombre_cuenta_contable_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(retencionesporpagarporcuentas.getes_debito_dato()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRetencionesPorPagarPorCuentas="";
	
	public String getsFinalQueryRetencionesPorPagarPorCuentas() {
		return this.sFinalQueryRetencionesPorPagarPorCuentas;
	}
	
	public void setsFinalQueryRetencionesPorPagarPorCuentas(String sFinalQueryRetencionesPorPagarPorCuentas) {
		this.sFinalQueryRetencionesPorPagarPorCuentas= sFinalQueryRetencionesPorPagarPorCuentas;
	}
	
	public Border resaltarSeleccionarRetencionesPorPagarPorCuentas=null;
	
	public Border setResaltarSeleccionarRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRetencionesPorPagarPorCuentas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRetencionesPorPagarPorCuentas() {
		return this.resaltarSeleccionarRetencionesPorPagarPorCuentas;
	}
	
	public void setResaltarSeleccionarRetencionesPorPagarPorCuentas(Border borderResaltarSeleccionarRetencionesPorPagarPorCuentas) {
		this.resaltarSeleccionarRetencionesPorPagarPorCuentas= borderResaltarSeleccionarRetencionesPorPagarPorCuentas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRetencionesPorPagarPorCuentas=null;
	public Boolean mostraridRetencionesPorPagarPorCuentas=true;
	public Boolean activaridRetencionesPorPagarPorCuentas=true;

	public Border resaltarid_empresaRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarid_empresaRetencionesPorPagarPorCuentas=true;
	public Boolean activarid_empresaRetencionesPorPagarPorCuentas=true;
	public Boolean cargarid_empresaRetencionesPorPagarPorCuentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRetencionesPorPagarPorCuentas=false;//ConEventDepend=true

	public Border resaltarid_sucursalRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarid_sucursalRetencionesPorPagarPorCuentas=true;
	public Boolean activarid_sucursalRetencionesPorPagarPorCuentas=true;
	public Boolean cargarid_sucursalRetencionesPorPagarPorCuentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRetencionesPorPagarPorCuentas=false;//ConEventDepend=true

	public Border resaltarid_ejercicioRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarid_ejercicioRetencionesPorPagarPorCuentas=true;
	public Boolean activarid_ejercicioRetencionesPorPagarPorCuentas=true;
	public Boolean cargarid_ejercicioRetencionesPorPagarPorCuentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioRetencionesPorPagarPorCuentas=false;//ConEventDepend=true

	public Border resaltarid_periodoRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarid_periodoRetencionesPorPagarPorCuentas=true;
	public Boolean activarid_periodoRetencionesPorPagarPorCuentas=true;
	public Boolean cargarid_periodoRetencionesPorPagarPorCuentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoRetencionesPorPagarPorCuentas=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarid_tipo_retencionRetencionesPorPagarPorCuentas=true;
	public Boolean activarid_tipo_retencionRetencionesPorPagarPorCuentas=true;
	public Boolean cargarid_tipo_retencionRetencionesPorPagarPorCuentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionRetencionesPorPagarPorCuentas=false;//ConEventDepend=true

	public Border resaltares_debitoRetencionesPorPagarPorCuentas=null;
	public Boolean mostrares_debitoRetencionesPorPagarPorCuentas=true;
	public Boolean activares_debitoRetencionesPorPagarPorCuentas=true;

	public Border resaltarfecha_emisionRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarfecha_emisionRetencionesPorPagarPorCuentas=true;
	public Boolean activarfecha_emisionRetencionesPorPagarPorCuentas=true;

	public Border resaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas=true;
	public Boolean activarnombre_tipo_movimientoRetencionesPorPagarPorCuentas=true;

	public Border resaltarnumero_mayorRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnumero_mayorRetencionesPorPagarPorCuentas=true;
	public Boolean activarnumero_mayorRetencionesPorPagarPorCuentas=true;

	public Border resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas=true;
	public Boolean activarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas=true;

	public Border resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas=true;
	public Boolean activarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas=true;

	public Border resaltarporcentajeRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarporcentajeRetencionesPorPagarPorCuentas=true;
	public Boolean activarporcentajeRetencionesPorPagarPorCuentas=true;

	public Border resaltarbase_imponibleRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarbase_imponibleRetencionesPorPagarPorCuentas=true;
	public Boolean activarbase_imponibleRetencionesPorPagarPorCuentas=true;

	public Border resaltarvalorRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarvalorRetencionesPorPagarPorCuentas=true;
	public Boolean activarvalorRetencionesPorPagarPorCuentas=true;

	public Border resaltarnumeroRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnumeroRetencionesPorPagarPorCuentas=true;
	public Boolean activarnumeroRetencionesPorPagarPorCuentas=true;

	public Border resaltarnombre_benefRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnombre_benefRetencionesPorPagarPorCuentas=true;
	public Boolean activarnombre_benefRetencionesPorPagarPorCuentas=true;

	public Border resaltarruc_benefRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarruc_benefRetencionesPorPagarPorCuentas=true;
	public Boolean activarruc_benefRetencionesPorPagarPorCuentas=true;

	public Border resaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas=true;
	public Boolean activarnombre_cuenta_contableRetencionesPorPagarPorCuentas=true;

	public Border resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas=null;
	public Boolean mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas=true;
	public Boolean activarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas=true;

	public Border resaltares_debito_datoRetencionesPorPagarPorCuentas=null;
	public Boolean mostrares_debito_datoRetencionesPorPagarPorCuentas=true;
	public Boolean activares_debito_datoRetencionesPorPagarPorCuentas=true;

	
	

	public Border setResaltaridRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltaridRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRetencionesPorPagarPorCuentas() {
		return this.resaltaridRetencionesPorPagarPorCuentas;
	}

	public void setResaltaridRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltaridRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostraridRetencionesPorPagarPorCuentas() {
		return this.mostraridRetencionesPorPagarPorCuentas;
	}

	public void setMostraridRetencionesPorPagarPorCuentas(Boolean mostraridRetencionesPorPagarPorCuentas) {
		this.mostraridRetencionesPorPagarPorCuentas= mostraridRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivaridRetencionesPorPagarPorCuentas() {
		return this.activaridRetencionesPorPagarPorCuentas;
	}

	public void setActivaridRetencionesPorPagarPorCuentas(Boolean activaridRetencionesPorPagarPorCuentas) {
		this.activaridRetencionesPorPagarPorCuentas= activaridRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarid_empresaRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarid_empresaRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRetencionesPorPagarPorCuentas() {
		return this.resaltarid_empresaRetencionesPorPagarPorCuentas;
	}

	public void setResaltarid_empresaRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarid_empresaRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarid_empresaRetencionesPorPagarPorCuentas() {
		return this.mostrarid_empresaRetencionesPorPagarPorCuentas;
	}

	public void setMostrarid_empresaRetencionesPorPagarPorCuentas(Boolean mostrarid_empresaRetencionesPorPagarPorCuentas) {
		this.mostrarid_empresaRetencionesPorPagarPorCuentas= mostrarid_empresaRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarid_empresaRetencionesPorPagarPorCuentas() {
		return this.activarid_empresaRetencionesPorPagarPorCuentas;
	}

	public void setActivarid_empresaRetencionesPorPagarPorCuentas(Boolean activarid_empresaRetencionesPorPagarPorCuentas) {
		this.activarid_empresaRetencionesPorPagarPorCuentas= activarid_empresaRetencionesPorPagarPorCuentas;
	}

	public Boolean getCargarid_empresaRetencionesPorPagarPorCuentas() {
		return this.cargarid_empresaRetencionesPorPagarPorCuentas;
	}

	public void setCargarid_empresaRetencionesPorPagarPorCuentas(Boolean cargarid_empresaRetencionesPorPagarPorCuentas) {
		this.cargarid_empresaRetencionesPorPagarPorCuentas= cargarid_empresaRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarid_sucursalRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRetencionesPorPagarPorCuentas() {
		return this.resaltarid_sucursalRetencionesPorPagarPorCuentas;
	}

	public void setResaltarid_sucursalRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarid_sucursalRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRetencionesPorPagarPorCuentas() {
		return this.mostrarid_sucursalRetencionesPorPagarPorCuentas;
	}

	public void setMostrarid_sucursalRetencionesPorPagarPorCuentas(Boolean mostrarid_sucursalRetencionesPorPagarPorCuentas) {
		this.mostrarid_sucursalRetencionesPorPagarPorCuentas= mostrarid_sucursalRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarid_sucursalRetencionesPorPagarPorCuentas() {
		return this.activarid_sucursalRetencionesPorPagarPorCuentas;
	}

	public void setActivarid_sucursalRetencionesPorPagarPorCuentas(Boolean activarid_sucursalRetencionesPorPagarPorCuentas) {
		this.activarid_sucursalRetencionesPorPagarPorCuentas= activarid_sucursalRetencionesPorPagarPorCuentas;
	}

	public Boolean getCargarid_sucursalRetencionesPorPagarPorCuentas() {
		return this.cargarid_sucursalRetencionesPorPagarPorCuentas;
	}

	public void setCargarid_sucursalRetencionesPorPagarPorCuentas(Boolean cargarid_sucursalRetencionesPorPagarPorCuentas) {
		this.cargarid_sucursalRetencionesPorPagarPorCuentas= cargarid_sucursalRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarid_ejercicioRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioRetencionesPorPagarPorCuentas() {
		return this.resaltarid_ejercicioRetencionesPorPagarPorCuentas;
	}

	public void setResaltarid_ejercicioRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarid_ejercicioRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioRetencionesPorPagarPorCuentas() {
		return this.mostrarid_ejercicioRetencionesPorPagarPorCuentas;
	}

	public void setMostrarid_ejercicioRetencionesPorPagarPorCuentas(Boolean mostrarid_ejercicioRetencionesPorPagarPorCuentas) {
		this.mostrarid_ejercicioRetencionesPorPagarPorCuentas= mostrarid_ejercicioRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarid_ejercicioRetencionesPorPagarPorCuentas() {
		return this.activarid_ejercicioRetencionesPorPagarPorCuentas;
	}

	public void setActivarid_ejercicioRetencionesPorPagarPorCuentas(Boolean activarid_ejercicioRetencionesPorPagarPorCuentas) {
		this.activarid_ejercicioRetencionesPorPagarPorCuentas= activarid_ejercicioRetencionesPorPagarPorCuentas;
	}

	public Boolean getCargarid_ejercicioRetencionesPorPagarPorCuentas() {
		return this.cargarid_ejercicioRetencionesPorPagarPorCuentas;
	}

	public void setCargarid_ejercicioRetencionesPorPagarPorCuentas(Boolean cargarid_ejercicioRetencionesPorPagarPorCuentas) {
		this.cargarid_ejercicioRetencionesPorPagarPorCuentas= cargarid_ejercicioRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarid_periodoRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarid_periodoRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoRetencionesPorPagarPorCuentas() {
		return this.resaltarid_periodoRetencionesPorPagarPorCuentas;
	}

	public void setResaltarid_periodoRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarid_periodoRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarid_periodoRetencionesPorPagarPorCuentas() {
		return this.mostrarid_periodoRetencionesPorPagarPorCuentas;
	}

	public void setMostrarid_periodoRetencionesPorPagarPorCuentas(Boolean mostrarid_periodoRetencionesPorPagarPorCuentas) {
		this.mostrarid_periodoRetencionesPorPagarPorCuentas= mostrarid_periodoRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarid_periodoRetencionesPorPagarPorCuentas() {
		return this.activarid_periodoRetencionesPorPagarPorCuentas;
	}

	public void setActivarid_periodoRetencionesPorPagarPorCuentas(Boolean activarid_periodoRetencionesPorPagarPorCuentas) {
		this.activarid_periodoRetencionesPorPagarPorCuentas= activarid_periodoRetencionesPorPagarPorCuentas;
	}

	public Boolean getCargarid_periodoRetencionesPorPagarPorCuentas() {
		return this.cargarid_periodoRetencionesPorPagarPorCuentas;
	}

	public void setCargarid_periodoRetencionesPorPagarPorCuentas(Boolean cargarid_periodoRetencionesPorPagarPorCuentas) {
		this.cargarid_periodoRetencionesPorPagarPorCuentas= cargarid_periodoRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarid_tipo_retencionRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionRetencionesPorPagarPorCuentas() {
		return this.resaltarid_tipo_retencionRetencionesPorPagarPorCuentas;
	}

	public void setResaltarid_tipo_retencionRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarid_tipo_retencionRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionRetencionesPorPagarPorCuentas() {
		return this.mostrarid_tipo_retencionRetencionesPorPagarPorCuentas;
	}

	public void setMostrarid_tipo_retencionRetencionesPorPagarPorCuentas(Boolean mostrarid_tipo_retencionRetencionesPorPagarPorCuentas) {
		this.mostrarid_tipo_retencionRetencionesPorPagarPorCuentas= mostrarid_tipo_retencionRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarid_tipo_retencionRetencionesPorPagarPorCuentas() {
		return this.activarid_tipo_retencionRetencionesPorPagarPorCuentas;
	}

	public void setActivarid_tipo_retencionRetencionesPorPagarPorCuentas(Boolean activarid_tipo_retencionRetencionesPorPagarPorCuentas) {
		this.activarid_tipo_retencionRetencionesPorPagarPorCuentas= activarid_tipo_retencionRetencionesPorPagarPorCuentas;
	}

	public Boolean getCargarid_tipo_retencionRetencionesPorPagarPorCuentas() {
		return this.cargarid_tipo_retencionRetencionesPorPagarPorCuentas;
	}

	public void setCargarid_tipo_retencionRetencionesPorPagarPorCuentas(Boolean cargarid_tipo_retencionRetencionesPorPagarPorCuentas) {
		this.cargarid_tipo_retencionRetencionesPorPagarPorCuentas= cargarid_tipo_retencionRetencionesPorPagarPorCuentas;
	}

	public Border setResaltares_debitoRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltares_debitoRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debitoRetencionesPorPagarPorCuentas() {
		return this.resaltares_debitoRetencionesPorPagarPorCuentas;
	}

	public void setResaltares_debitoRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltares_debitoRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrares_debitoRetencionesPorPagarPorCuentas() {
		return this.mostrares_debitoRetencionesPorPagarPorCuentas;
	}

	public void setMostrares_debitoRetencionesPorPagarPorCuentas(Boolean mostrares_debitoRetencionesPorPagarPorCuentas) {
		this.mostrares_debitoRetencionesPorPagarPorCuentas= mostrares_debitoRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivares_debitoRetencionesPorPagarPorCuentas() {
		return this.activares_debitoRetencionesPorPagarPorCuentas;
	}

	public void setActivares_debitoRetencionesPorPagarPorCuentas(Boolean activares_debitoRetencionesPorPagarPorCuentas) {
		this.activares_debitoRetencionesPorPagarPorCuentas= activares_debitoRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarfecha_emisionRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionRetencionesPorPagarPorCuentas() {
		return this.resaltarfecha_emisionRetencionesPorPagarPorCuentas;
	}

	public void setResaltarfecha_emisionRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarfecha_emisionRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionRetencionesPorPagarPorCuentas() {
		return this.mostrarfecha_emisionRetencionesPorPagarPorCuentas;
	}

	public void setMostrarfecha_emisionRetencionesPorPagarPorCuentas(Boolean mostrarfecha_emisionRetencionesPorPagarPorCuentas) {
		this.mostrarfecha_emisionRetencionesPorPagarPorCuentas= mostrarfecha_emisionRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarfecha_emisionRetencionesPorPagarPorCuentas() {
		return this.activarfecha_emisionRetencionesPorPagarPorCuentas;
	}

	public void setActivarfecha_emisionRetencionesPorPagarPorCuentas(Boolean activarfecha_emisionRetencionesPorPagarPorCuentas) {
		this.activarfecha_emisionRetencionesPorPagarPorCuentas= activarfecha_emisionRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas() {
		return this.resaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas() {
		return this.mostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(Boolean mostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas) {
		this.mostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas= mostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnombre_tipo_movimientoRetencionesPorPagarPorCuentas() {
		return this.activarnombre_tipo_movimientoRetencionesPorPagarPorCuentas;
	}

	public void setActivarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(Boolean activarnombre_tipo_movimientoRetencionesPorPagarPorCuentas) {
		this.activarnombre_tipo_movimientoRetencionesPorPagarPorCuentas= activarnombre_tipo_movimientoRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnumero_mayorRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorRetencionesPorPagarPorCuentas() {
		return this.resaltarnumero_mayorRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnumero_mayorRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnumero_mayorRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorRetencionesPorPagarPorCuentas() {
		return this.mostrarnumero_mayorRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnumero_mayorRetencionesPorPagarPorCuentas(Boolean mostrarnumero_mayorRetencionesPorPagarPorCuentas) {
		this.mostrarnumero_mayorRetencionesPorPagarPorCuentas= mostrarnumero_mayorRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnumero_mayorRetencionesPorPagarPorCuentas() {
		return this.activarnumero_mayorRetencionesPorPagarPorCuentas;
	}

	public void setActivarnumero_mayorRetencionesPorPagarPorCuentas(Boolean activarnumero_mayorRetencionesPorPagarPorCuentas) {
		this.activarnumero_mayorRetencionesPorPagarPorCuentas= activarnumero_mayorRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas() {
		return this.resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas() {
		return this.mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(Boolean mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas) {
		this.mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas= mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas() {
		return this.activarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas;
	}

	public void setActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(Boolean activarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas) {
		this.activarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas= activarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas() {
		return this.resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas() {
		return this.mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(Boolean mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas) {
		this.mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas= mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas() {
		return this.activarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas;
	}

	public void setActivarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(Boolean activarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas) {
		this.activarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas= activarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarporcentajeRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarporcentajeRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeRetencionesPorPagarPorCuentas() {
		return this.resaltarporcentajeRetencionesPorPagarPorCuentas;
	}

	public void setResaltarporcentajeRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarporcentajeRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarporcentajeRetencionesPorPagarPorCuentas() {
		return this.mostrarporcentajeRetencionesPorPagarPorCuentas;
	}

	public void setMostrarporcentajeRetencionesPorPagarPorCuentas(Boolean mostrarporcentajeRetencionesPorPagarPorCuentas) {
		this.mostrarporcentajeRetencionesPorPagarPorCuentas= mostrarporcentajeRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarporcentajeRetencionesPorPagarPorCuentas() {
		return this.activarporcentajeRetencionesPorPagarPorCuentas;
	}

	public void setActivarporcentajeRetencionesPorPagarPorCuentas(Boolean activarporcentajeRetencionesPorPagarPorCuentas) {
		this.activarporcentajeRetencionesPorPagarPorCuentas= activarporcentajeRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarbase_imponibleRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleRetencionesPorPagarPorCuentas() {
		return this.resaltarbase_imponibleRetencionesPorPagarPorCuentas;
	}

	public void setResaltarbase_imponibleRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarbase_imponibleRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleRetencionesPorPagarPorCuentas() {
		return this.mostrarbase_imponibleRetencionesPorPagarPorCuentas;
	}

	public void setMostrarbase_imponibleRetencionesPorPagarPorCuentas(Boolean mostrarbase_imponibleRetencionesPorPagarPorCuentas) {
		this.mostrarbase_imponibleRetencionesPorPagarPorCuentas= mostrarbase_imponibleRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarbase_imponibleRetencionesPorPagarPorCuentas() {
		return this.activarbase_imponibleRetencionesPorPagarPorCuentas;
	}

	public void setActivarbase_imponibleRetencionesPorPagarPorCuentas(Boolean activarbase_imponibleRetencionesPorPagarPorCuentas) {
		this.activarbase_imponibleRetencionesPorPagarPorCuentas= activarbase_imponibleRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarvalorRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarvalorRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorRetencionesPorPagarPorCuentas() {
		return this.resaltarvalorRetencionesPorPagarPorCuentas;
	}

	public void setResaltarvalorRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarvalorRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarvalorRetencionesPorPagarPorCuentas() {
		return this.mostrarvalorRetencionesPorPagarPorCuentas;
	}

	public void setMostrarvalorRetencionesPorPagarPorCuentas(Boolean mostrarvalorRetencionesPorPagarPorCuentas) {
		this.mostrarvalorRetencionesPorPagarPorCuentas= mostrarvalorRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarvalorRetencionesPorPagarPorCuentas() {
		return this.activarvalorRetencionesPorPagarPorCuentas;
	}

	public void setActivarvalorRetencionesPorPagarPorCuentas(Boolean activarvalorRetencionesPorPagarPorCuentas) {
		this.activarvalorRetencionesPorPagarPorCuentas= activarvalorRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnumeroRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnumeroRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroRetencionesPorPagarPorCuentas() {
		return this.resaltarnumeroRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnumeroRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnumeroRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnumeroRetencionesPorPagarPorCuentas() {
		return this.mostrarnumeroRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnumeroRetencionesPorPagarPorCuentas(Boolean mostrarnumeroRetencionesPorPagarPorCuentas) {
		this.mostrarnumeroRetencionesPorPagarPorCuentas= mostrarnumeroRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnumeroRetencionesPorPagarPorCuentas() {
		return this.activarnumeroRetencionesPorPagarPorCuentas;
	}

	public void setActivarnumeroRetencionesPorPagarPorCuentas(Boolean activarnumeroRetencionesPorPagarPorCuentas) {
		this.activarnumeroRetencionesPorPagarPorCuentas= activarnumeroRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnombre_benefRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnombre_benefRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_benefRetencionesPorPagarPorCuentas() {
		return this.resaltarnombre_benefRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnombre_benefRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnombre_benefRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnombre_benefRetencionesPorPagarPorCuentas() {
		return this.mostrarnombre_benefRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnombre_benefRetencionesPorPagarPorCuentas(Boolean mostrarnombre_benefRetencionesPorPagarPorCuentas) {
		this.mostrarnombre_benefRetencionesPorPagarPorCuentas= mostrarnombre_benefRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnombre_benefRetencionesPorPagarPorCuentas() {
		return this.activarnombre_benefRetencionesPorPagarPorCuentas;
	}

	public void setActivarnombre_benefRetencionesPorPagarPorCuentas(Boolean activarnombre_benefRetencionesPorPagarPorCuentas) {
		this.activarnombre_benefRetencionesPorPagarPorCuentas= activarnombre_benefRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarruc_benefRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarruc_benefRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_benefRetencionesPorPagarPorCuentas() {
		return this.resaltarruc_benefRetencionesPorPagarPorCuentas;
	}

	public void setResaltarruc_benefRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarruc_benefRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarruc_benefRetencionesPorPagarPorCuentas() {
		return this.mostrarruc_benefRetencionesPorPagarPorCuentas;
	}

	public void setMostrarruc_benefRetencionesPorPagarPorCuentas(Boolean mostrarruc_benefRetencionesPorPagarPorCuentas) {
		this.mostrarruc_benefRetencionesPorPagarPorCuentas= mostrarruc_benefRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarruc_benefRetencionesPorPagarPorCuentas() {
		return this.activarruc_benefRetencionesPorPagarPorCuentas;
	}

	public void setActivarruc_benefRetencionesPorPagarPorCuentas(Boolean activarruc_benefRetencionesPorPagarPorCuentas) {
		this.activarruc_benefRetencionesPorPagarPorCuentas= activarruc_benefRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas() {
		return this.resaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas() {
		return this.mostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas(Boolean mostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas) {
		this.mostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas= mostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnombre_cuenta_contableRetencionesPorPagarPorCuentas() {
		return this.activarnombre_cuenta_contableRetencionesPorPagarPorCuentas;
	}

	public void setActivarnombre_cuenta_contableRetencionesPorPagarPorCuentas(Boolean activarnombre_cuenta_contableRetencionesPorPagarPorCuentas) {
		this.activarnombre_cuenta_contableRetencionesPorPagarPorCuentas= activarnombre_cuenta_contableRetencionesPorPagarPorCuentas;
	}

	public Border setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas() {
		return this.resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas;
	}

	public void setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas() {
		return this.mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas;
	}

	public void setMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(Boolean mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas) {
		this.mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas= mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas() {
		return this.activarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas;
	}

	public void setActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(Boolean activarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas) {
		this.activarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas= activarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas;
	}

	public Border setResaltares_debito_datoRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporcuentasBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorCuentas.setBorder(borderResaltar);
		
		this.resaltares_debito_datoRetencionesPorPagarPorCuentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debito_datoRetencionesPorPagarPorCuentas() {
		return this.resaltares_debito_datoRetencionesPorPagarPorCuentas;
	}

	public void setResaltares_debito_datoRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltares_debito_datoRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public Boolean getMostrares_debito_datoRetencionesPorPagarPorCuentas() {
		return this.mostrares_debito_datoRetencionesPorPagarPorCuentas;
	}

	public void setMostrares_debito_datoRetencionesPorPagarPorCuentas(Boolean mostrares_debito_datoRetencionesPorPagarPorCuentas) {
		this.mostrares_debito_datoRetencionesPorPagarPorCuentas= mostrares_debito_datoRetencionesPorPagarPorCuentas;
	}

	public Boolean getActivares_debito_datoRetencionesPorPagarPorCuentas() {
		return this.activares_debito_datoRetencionesPorPagarPorCuentas;
	}

	public void setActivares_debito_datoRetencionesPorPagarPorCuentas(Boolean activares_debito_datoRetencionesPorPagarPorCuentas) {
		this.activares_debito_datoRetencionesPorPagarPorCuentas= activares_debito_datoRetencionesPorPagarPorCuentas;
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
		
		
		this.setMostraridRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarid_empresaRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarid_sucursalRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarid_ejercicioRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarid_periodoRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarid_tipo_retencionRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrares_debitoRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarfecha_emisionRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnumero_mayorRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarporcentajeRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarbase_imponibleRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarvalorRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnumeroRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnombre_benefRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarruc_benefRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(esInicial);
		this.setMostrares_debito_datoRetencionesPorPagarPorCuentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ID)) {
				this.setMostraridRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITO)) {
				this.setMostrares_debitoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {
				this.setMostrarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.VALOR)) {
				this.setMostrarvalorRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF)) {
				this.setMostrarnombre_benefRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF)) {
				this.setMostrarruc_benefRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {
				this.setMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO)) {
				this.setMostrares_debito_datoRetencionesPorPagarPorCuentas(esAsigna);
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
		
		
		this.setActivaridRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarid_empresaRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarid_sucursalRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarid_ejercicioRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarid_periodoRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarid_tipo_retencionRetencionesPorPagarPorCuentas(esInicial);
		this.setActivares_debitoRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarfecha_emisionRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnumero_mayorRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarporcentajeRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarbase_imponibleRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarvalorRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnumeroRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnombre_benefRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarruc_benefRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnombre_cuenta_contableRetencionesPorPagarPorCuentas(esInicial);
		this.setActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(esInicial);
		this.setActivares_debito_datoRetencionesPorPagarPorCuentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ID)) {
				this.setActivaridRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITO)) {
				this.setActivares_debitoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {
				this.setActivarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setActivarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.VALOR)) {
				this.setActivarvalorRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO)) {
				this.setActivarnumeroRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF)) {
				this.setActivarnombre_benefRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF)) {
				this.setActivarruc_benefRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {
				this.setActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO)) {
				this.setActivares_debito_datoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarid_empresaRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarid_sucursalRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarid_ejercicioRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarid_periodoRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarid_tipo_retencionRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltares_debitoRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarfecha_emisionRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnumero_mayorRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarporcentajeRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarbase_imponibleRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarvalorRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnumeroRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnombre_benefRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarruc_benefRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(esInicial);
		this.setResaltares_debito_datoRetencionesPorPagarPorCuentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ID)) {
				this.setResaltaridRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITO)) {
				this.setResaltares_debitoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {
				this.setResaltarnombre_tipo_movimientoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.VALOR)) {
				this.setResaltarvalorRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBREBENEF)) {
				this.setResaltarnombre_benefRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.RUCBENEF)) {
				this.setResaltarruc_benefRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {
				this.setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorCuentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorCuentasConstantesFunciones.ESDEBITODATO)) {
				this.setResaltares_debito_datoRetencionesPorPagarPorCuentas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas=true;

	public Boolean getMostrarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas() {
		return this.mostrarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas;
	}

	public void setMostrarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas=true;

	public Boolean getActivarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas() {
		return this.activarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas;
	}

	public void setActivarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas(Boolean habilitarResaltar) {
		this.activarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas=null;

	public Border getResaltarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas() {
		return this.resaltarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas;
	}

	public void setResaltarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas(Border borderResaltar) {
		this.resaltarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas= borderResaltar;
	}

	public void setResaltarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorCuentasBeanSwingJInternalFrame retencionesporpagarporcuentasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaRetencionesPorPagarPorCuentasRetencionesPorPagarPorCuentas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}