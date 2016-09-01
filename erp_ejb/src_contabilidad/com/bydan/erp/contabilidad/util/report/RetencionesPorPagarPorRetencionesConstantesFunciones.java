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


import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorRetencionesConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorRetencionesParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorRetencionesParameterGeneral;

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
final public class RetencionesPorPagarPorRetencionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="RetencionesPorPagarPorRetenciones";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RetencionesPorPagarPorRetenciones"+RetencionesPorPagarPorRetencionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RetencionesPorPagarPorRetencionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RetencionesPorPagarPorRetencionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"_"+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RetencionesPorPagarPorRetencionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RetencionesPorPagarPorRetencionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RetencionesPorPagarPorRetencionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RetencionesPorPagarPorRetencionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RetencionesPorPagarPorRetencionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RetencionesPorPagarPorRetencionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Retenciones Por Pagar Por Retencioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Retenciones Por Pagar Por Retenciones";
	public static final String SCLASSWEBTITULO_LOWER="Retenciones Por Pagar Por Retenciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RetencionesPorPagarPorRetenciones";
	public static final String OBJECTNAME="retencionesporpagarporretenciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="retenciones_por_pagar_por_retenciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select retencionesporpagarporretenciones from "+RetencionesPorPagarPorRetencionesConstantesFunciones.SPERSISTENCENAME+" retencionesporpagarporretenciones";
	public static String QUERYSELECTNATIVE="select "+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".id,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".version_row,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".id_empresa,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".id_sucursal,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".id_ejercicio,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".id_periodo,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".es_debito,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".fecha_emision,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".nombre_tipo_movimiento,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".numero_mayor,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".nombre_cuenta_contable_retencion,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".numero_pre_impreso_factura,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".porcentaje,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".base_imponible,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".valor,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".numero,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".nombre_benef,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".ruc_benef,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".nombre_cuenta_contable_credito,"+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME+".es_debito_dato from "+RetencionesPorPagarPorRetencionesConstantesFunciones.SCHEMA+"."+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME;//+" as "+RetencionesPorPagarPorRetencionesConstantesFunciones.TABLENAME;
	
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
		
	
	public static String getRetencionesPorPagarPorRetencionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITO)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_BASEIMPONIBLE;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBREBENEF;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_RUCBENEF;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO)) {sLabelColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITODATO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getes_debitoDescripcion(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!retencionesporpagarporretenciones.getes_debito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debitoHtmlDescripcion(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(retencionesporpagarporretenciones.getId(),retencionesporpagarporretenciones.getes_debito());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_debito_datoDescripcion(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!retencionesporpagarporretenciones.getes_debito_dato()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debito_datoHtmlDescripcion(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(retencionesporpagarporretenciones.getId(),retencionesporpagarporretenciones.getes_debito_dato());

		return sDescripcion;
	}	
	
	public static String getRetencionesPorPagarPorRetencionesDescripcion(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(retencionesporpagarporretenciones !=null/* && retencionesporpagarporretenciones.getId()!=0*/) {
			if(retencionesporpagarporretenciones.getId()!=null) {
				sDescripcion=retencionesporpagarporretenciones.getId().toString();
			}//retencionesporpagarporretencionesretencionesporpagarporretenciones.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRetencionesPorPagarPorRetencionesDescripcionDetallado(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) {
		String sDescripcion="";
			
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.ID+"=";
		sDescripcion+=retencionesporpagarporretenciones.getId().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=retencionesporpagarporretenciones.getVersionRow().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=retencionesporpagarporretenciones.getid_empresa().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=retencionesporpagarporretenciones.getid_sucursal().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=retencionesporpagarporretenciones.getid_ejercicio().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=retencionesporpagarporretenciones.getid_periodo().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITO+"=";
		sDescripcion+=retencionesporpagarporretenciones.getes_debito().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=retencionesporpagarporretenciones.getfecha_emision().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnombre_tipo_movimiento()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnumero_mayor()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnombre_cuenta_contable_retencion()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnumero_pre_impreso_factura()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=retencionesporpagarporretenciones.getporcentaje().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE+"=";
		sDescripcion+=retencionesporpagarporretenciones.getbase_imponible().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR+"=";
		sDescripcion+=retencionesporpagarporretenciones.getvalor().toString()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnumero()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnombre_benef()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF+"=";
		sDescripcion+=retencionesporpagarporretenciones.getruc_benef()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnombre_cuenta_contable()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO+"=";
		sDescripcion+=retencionesporpagarporretenciones.getnombre_cuenta_contable_credito()+",";
		sDescripcion+=RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO+"=";
		sDescripcion+=retencionesporpagarporretenciones.getes_debito_dato().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRetencionesPorPagarPorRetencionesDescripcion(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,String sValor) throws Exception {			
		if(retencionesporpagarporretenciones !=null) {
			//retencionesporpagarporretencionesretencionesporpagarporretenciones.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaRetencionesPorPagarPorRetenciones")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Periodo Por Es Debito";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaRetencionesPorPagarPorRetenciones(Long id_ejercicio,Long id_periodo,Boolean es_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();}
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
	
	
	
	
	
	
	public static void quitarEspaciosRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencionesporpagarporretenciones.setnombre_tipo_movimiento(retencionesporpagarporretenciones.getnombre_tipo_movimiento().trim());
		retencionesporpagarporretenciones.setnumero_mayor(retencionesporpagarporretenciones.getnumero_mayor().trim());
		retencionesporpagarporretenciones.setnombre_cuenta_contable_retencion(retencionesporpagarporretenciones.getnombre_cuenta_contable_retencion().trim());
		retencionesporpagarporretenciones.setnumero_pre_impreso_factura(retencionesporpagarporretenciones.getnumero_pre_impreso_factura().trim());
		retencionesporpagarporretenciones.setnumero(retencionesporpagarporretenciones.getnumero().trim());
		retencionesporpagarporretenciones.setnombre_benef(retencionesporpagarporretenciones.getnombre_benef().trim());
		retencionesporpagarporretenciones.setruc_benef(retencionesporpagarporretenciones.getruc_benef().trim());
		retencionesporpagarporretenciones.setnombre_cuenta_contable(retencionesporpagarporretenciones.getnombre_cuenta_contable().trim());
		retencionesporpagarporretenciones.setnombre_cuenta_contable_credito(retencionesporpagarporretenciones.getnombre_cuenta_contable_credito().trim());
	}
	
	public static void quitarEspaciosRetencionesPorPagarPorRetencioness(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones: retencionesporpagarporretencioness) {
			retencionesporpagarporretenciones.setnombre_tipo_movimiento(retencionesporpagarporretenciones.getnombre_tipo_movimiento().trim());
			retencionesporpagarporretenciones.setnumero_mayor(retencionesporpagarporretenciones.getnumero_mayor().trim());
			retencionesporpagarporretenciones.setnombre_cuenta_contable_retencion(retencionesporpagarporretenciones.getnombre_cuenta_contable_retencion().trim());
			retencionesporpagarporretenciones.setnumero_pre_impreso_factura(retencionesporpagarporretenciones.getnumero_pre_impreso_factura().trim());
			retencionesporpagarporretenciones.setnumero(retencionesporpagarporretenciones.getnumero().trim());
			retencionesporpagarporretenciones.setnombre_benef(retencionesporpagarporretenciones.getnombre_benef().trim());
			retencionesporpagarporretenciones.setruc_benef(retencionesporpagarporretenciones.getruc_benef().trim());
			retencionesporpagarporretenciones.setnombre_cuenta_contable(retencionesporpagarporretenciones.getnombre_cuenta_contable().trim());
			retencionesporpagarporretenciones.setnombre_cuenta_contable_credito(retencionesporpagarporretenciones.getnombre_cuenta_contable_credito().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && retencionesporpagarporretenciones.getConCambioAuxiliar()) {
			retencionesporpagarporretenciones.setIsDeleted(retencionesporpagarporretenciones.getIsDeletedAuxiliar());	
			retencionesporpagarporretenciones.setIsNew(retencionesporpagarporretenciones.getIsNewAuxiliar());	
			retencionesporpagarporretenciones.setIsChanged(retencionesporpagarporretenciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			retencionesporpagarporretenciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			retencionesporpagarporretenciones.setIsDeletedAuxiliar(false);	
			retencionesporpagarporretenciones.setIsNewAuxiliar(false);	
			retencionesporpagarporretenciones.setIsChangedAuxiliar(false);
			
			retencionesporpagarporretenciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRetencionesPorPagarPorRetencioness(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones : retencionesporpagarporretencioness) {
			if(conAsignarBase && retencionesporpagarporretenciones.getConCambioAuxiliar()) {
				retencionesporpagarporretenciones.setIsDeleted(retencionesporpagarporretenciones.getIsDeletedAuxiliar());	
				retencionesporpagarporretenciones.setIsNew(retencionesporpagarporretenciones.getIsNewAuxiliar());	
				retencionesporpagarporretenciones.setIsChanged(retencionesporpagarporretenciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				retencionesporpagarporretenciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				retencionesporpagarporretenciones.setIsDeletedAuxiliar(false);	
				retencionesporpagarporretenciones.setIsNewAuxiliar(false);	
				retencionesporpagarporretenciones.setIsChangedAuxiliar(false);
				
				retencionesporpagarporretenciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,Boolean conEnteros) throws Exception  {
		retencionesporpagarporretenciones.setporcentaje(0.0);
		retencionesporpagarporretenciones.setbase_imponible(0.0);
		retencionesporpagarporretenciones.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRetencionesPorPagarPorRetencioness(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,Boolean conEnteros) throws Exception  {
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones: retencionesporpagarporretencioness) {
			retencionesporpagarporretenciones.setporcentaje(0.0);
			retencionesporpagarporretenciones.setbase_imponible(0.0);
			retencionesporpagarporretenciones.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRetencionesPorPagarPorRetenciones(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAux) throws Exception  {
		RetencionesPorPagarPorRetencionesConstantesFunciones.InicializarValoresRetencionesPorPagarPorRetenciones(retencionesporpagarporretencionesAux,true);
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones: retencionesporpagarporretencioness) {
			if(retencionesporpagarporretenciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			retencionesporpagarporretencionesAux.setporcentaje(retencionesporpagarporretencionesAux.getporcentaje()+retencionesporpagarporretenciones.getporcentaje());			
			retencionesporpagarporretencionesAux.setbase_imponible(retencionesporpagarporretencionesAux.getbase_imponible()+retencionesporpagarporretenciones.getbase_imponible());			
			retencionesporpagarporretencionesAux.setvalor(retencionesporpagarporretencionesAux.getvalor()+retencionesporpagarporretenciones.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionesPorPagarPorRetenciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RetencionesPorPagarPorRetencionesConstantesFunciones.getArrayColumnasGlobalesRetencionesPorPagarPorRetenciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionesPorPagarPorRetenciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRetencionesPorPagarPorRetenciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAux: retencionesporpagarporretencioness) {
			if(retencionesporpagarporretencionesAux!=null && retencionesporpagarporretenciones!=null) {
				if((retencionesporpagarporretencionesAux.getId()==null && retencionesporpagarporretenciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(retencionesporpagarporretencionesAux.getId()!=null && retencionesporpagarporretenciones.getId()!=null){
					if(retencionesporpagarporretencionesAux.getId().equals(retencionesporpagarporretenciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRetencionesPorPagarPorRetenciones(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valorTotal=0.0;
	
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones: retencionesporpagarporretencioness) {			
			if(retencionesporpagarporretenciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=retencionesporpagarporretenciones.getporcentaje();
			base_imponibleTotal+=retencionesporpagarporretenciones.getbase_imponible();
			valorTotal+=retencionesporpagarporretenciones.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRetencionesPorPagarPorRetenciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ID, RetencionesPorPagarPorRetencionesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VERSIONROW, RetencionesPorPagarPorRetencionesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_FECHAEMISION, RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO, RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROMAYOR, RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION, RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA, RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_PORCENTAJE, RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_BASEIMPONIBLE, RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VALOR, RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMERO, RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBREBENEF, RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_RUCBENEF, RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO, RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITODATO, RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRetencionesPorPagarPorRetenciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionesPorPagarPorRetenciones() throws Exception  {
		return RetencionesPorPagarPorRetencionesConstantesFunciones.getTiposSeleccionarRetencionesPorPagarPorRetenciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionesPorPagarPorRetenciones(Boolean conFk) throws Exception  {
		return RetencionesPorPagarPorRetencionesConstantesFunciones.getTiposSeleccionarRetencionesPorPagarPorRetenciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRetencionesPorPagarPorRetenciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITO);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_BASEIMPONIBLE);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_BASEIMPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBREBENEF);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBREBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_RUCBENEF);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_RUCBENEF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITODATO);
			reporte.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRetencionesPorPagarPorRetenciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAux) throws Exception {
		
			retencionesporpagarporretencionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionesporpagarporretencionesAux.getEmpresa()));
			retencionesporpagarporretencionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencionesporpagarporretencionesAux.getSucursal()));
			retencionesporpagarporretencionesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencionesporpagarporretencionesAux.getEjercicio()));
			retencionesporpagarporretencionesAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencionesporpagarporretencionesAux.getPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRetencionesPorPagarPorRetenciones(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencionessTemp) throws Exception {
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAux:retencionesporpagarporretencionessTemp) {
			
			retencionesporpagarporretencionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(retencionesporpagarporretencionesAux.getEmpresa()));
			retencionesporpagarporretencionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(retencionesporpagarporretencionesAux.getSucursal()));
			retencionesporpagarporretencionesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(retencionesporpagarporretencionesAux.getEjercicio()));
			retencionesporpagarporretencionesAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(retencionesporpagarporretencionesAux.getPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRetencionesPorPagarPorRetenciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRetencionesPorPagarPorRetenciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionesPorPagarPorRetenciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionesPorPagarPorRetencionesConstantesFunciones.getClassesRelationshipsOfRetencionesPorPagarPorRetenciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRetencionesPorPagarPorRetenciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionesPorPagarPorRetenciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RetencionesPorPagarPorRetencionesConstantesFunciones.getClassesRelationshipsFromStringsOfRetencionesPorPagarPorRetenciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRetencionesPorPagarPorRetenciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness) throws Exception {
		try	{			
			for(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesLocal:retencionesporpagarporretencioness) {
				if(retencionesporpagarporretencionesLocal.getId().equals(retencionesporpagarporretenciones.getId())) {
					retencionesporpagarporretencionesLocal.setIsSelected(retencionesporpagarporretenciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRetencionesPorPagarPorRetenciones(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencionessAux) throws Exception {
		//this.retencionesporpagarporretencionessAux=retencionesporpagarporretencionessAux;
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAux:retencionesporpagarporretencionessAux) {
			if(retencionesporpagarporretencionesAux.getIsChanged()) {
				retencionesporpagarporretencionesAux.setIsChanged(false);
			}		
			
			if(retencionesporpagarporretencionesAux.getIsNew()) {
				retencionesporpagarporretencionesAux.setIsNew(false);
			}	
			
			if(retencionesporpagarporretencionesAux.getIsDeleted()) {
				retencionesporpagarporretencionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAux) throws Exception {
		//this.retencionesporpagarporretencionesAux=retencionesporpagarporretencionesAux;
		
			if(retencionesporpagarporretencionesAux.getIsChanged()) {
				retencionesporpagarporretencionesAux.setIsChanged(false);
			}		
			
			if(retencionesporpagarporretencionesAux.getIsNew()) {
				retencionesporpagarporretencionesAux.setIsNew(false);
			}	
			
			if(retencionesporpagarporretencionesAux.getIsDeleted()) {
				retencionesporpagarporretencionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAsignar,RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) throws Exception {
		retencionesporpagarporretencionesAsignar.setId(retencionesporpagarporretenciones.getId());	
		retencionesporpagarporretencionesAsignar.setVersionRow(retencionesporpagarporretenciones.getVersionRow());	
		retencionesporpagarporretencionesAsignar.setfecha_emision(retencionesporpagarporretenciones.getfecha_emision());	
		retencionesporpagarporretencionesAsignar.setnombre_tipo_movimiento(retencionesporpagarporretenciones.getnombre_tipo_movimiento());	
		retencionesporpagarporretencionesAsignar.setnumero_mayor(retencionesporpagarporretenciones.getnumero_mayor());	
		retencionesporpagarporretencionesAsignar.setnombre_cuenta_contable_retencion(retencionesporpagarporretenciones.getnombre_cuenta_contable_retencion());	
		retencionesporpagarporretencionesAsignar.setnumero_pre_impreso_factura(retencionesporpagarporretenciones.getnumero_pre_impreso_factura());	
		retencionesporpagarporretencionesAsignar.setporcentaje(retencionesporpagarporretenciones.getporcentaje());	
		retencionesporpagarporretencionesAsignar.setbase_imponible(retencionesporpagarporretenciones.getbase_imponible());	
		retencionesporpagarporretencionesAsignar.setvalor(retencionesporpagarporretenciones.getvalor());	
		retencionesporpagarporretencionesAsignar.setnumero(retencionesporpagarporretenciones.getnumero());	
		retencionesporpagarporretencionesAsignar.setnombre_benef(retencionesporpagarporretenciones.getnombre_benef());	
		retencionesporpagarporretencionesAsignar.setruc_benef(retencionesporpagarporretenciones.getruc_benef());	
		retencionesporpagarporretencionesAsignar.setnombre_cuenta_contable(retencionesporpagarporretenciones.getnombre_cuenta_contable());	
		retencionesporpagarporretencionesAsignar.setnombre_cuenta_contable_credito(retencionesporpagarporretenciones.getnombre_cuenta_contable_credito());	
		retencionesporpagarporretencionesAsignar.setes_debito_dato(retencionesporpagarporretenciones.getes_debito_dato());	
	}
	
	public static void inicializarRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones) throws Exception {
		try {
				retencionesporpagarporretenciones.setId(0L);	
					
				retencionesporpagarporretenciones.setfecha_emision(new Date());	
				retencionesporpagarporretenciones.setnombre_tipo_movimiento("");	
				retencionesporpagarporretenciones.setnumero_mayor("");	
				retencionesporpagarporretenciones.setnombre_cuenta_contable_retencion("");	
				retencionesporpagarporretenciones.setnumero_pre_impreso_factura("");	
				retencionesporpagarporretenciones.setporcentaje(0.0);	
				retencionesporpagarporretenciones.setbase_imponible(0.0);	
				retencionesporpagarporretenciones.setvalor(0.0);	
				retencionesporpagarporretenciones.setnumero("");	
				retencionesporpagarporretenciones.setnombre_benef("");	
				retencionesporpagarporretenciones.setruc_benef("");	
				retencionesporpagarporretenciones.setnombre_cuenta_contable("");	
				retencionesporpagarporretenciones.setnombre_cuenta_contable_credito("");	
				retencionesporpagarporretenciones.setes_debito_dato(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRetencionesPorPagarPorRetenciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRETIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_BASEIMPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBREBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_RUCBENEF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_NOMBRECUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_ESDEBITODATO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRetencionesPorPagarPorRetenciones(String sTipo,Row row,Workbook workbook,RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(retencionesporpagarporretenciones.getes_debito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnombre_tipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnombre_cuenta_contable_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnumero_pre_impreso_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getbase_imponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnombre_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getruc_benef());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(retencionesporpagarporretenciones.getnombre_cuenta_contable_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(retencionesporpagarporretenciones.getes_debito_dato()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRetencionesPorPagarPorRetenciones="";
	
	public String getsFinalQueryRetencionesPorPagarPorRetenciones() {
		return this.sFinalQueryRetencionesPorPagarPorRetenciones;
	}
	
	public void setsFinalQueryRetencionesPorPagarPorRetenciones(String sFinalQueryRetencionesPorPagarPorRetenciones) {
		this.sFinalQueryRetencionesPorPagarPorRetenciones= sFinalQueryRetencionesPorPagarPorRetenciones;
	}
	
	public Border resaltarSeleccionarRetencionesPorPagarPorRetenciones=null;
	
	public Border setResaltarSeleccionarRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRetencionesPorPagarPorRetenciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRetencionesPorPagarPorRetenciones() {
		return this.resaltarSeleccionarRetencionesPorPagarPorRetenciones;
	}
	
	public void setResaltarSeleccionarRetencionesPorPagarPorRetenciones(Border borderResaltarSeleccionarRetencionesPorPagarPorRetenciones) {
		this.resaltarSeleccionarRetencionesPorPagarPorRetenciones= borderResaltarSeleccionarRetencionesPorPagarPorRetenciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRetencionesPorPagarPorRetenciones=null;
	public Boolean mostraridRetencionesPorPagarPorRetenciones=true;
	public Boolean activaridRetencionesPorPagarPorRetenciones=true;

	public Border resaltarid_empresaRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarid_empresaRetencionesPorPagarPorRetenciones=true;
	public Boolean activarid_empresaRetencionesPorPagarPorRetenciones=true;
	public Boolean cargarid_empresaRetencionesPorPagarPorRetenciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRetencionesPorPagarPorRetenciones=false;//ConEventDepend=true

	public Border resaltarid_sucursalRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarid_sucursalRetencionesPorPagarPorRetenciones=true;
	public Boolean activarid_sucursalRetencionesPorPagarPorRetenciones=true;
	public Boolean cargarid_sucursalRetencionesPorPagarPorRetenciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRetencionesPorPagarPorRetenciones=false;//ConEventDepend=true

	public Border resaltarid_ejercicioRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarid_ejercicioRetencionesPorPagarPorRetenciones=true;
	public Boolean activarid_ejercicioRetencionesPorPagarPorRetenciones=true;
	public Boolean cargarid_ejercicioRetencionesPorPagarPorRetenciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioRetencionesPorPagarPorRetenciones=false;//ConEventDepend=true

	public Border resaltarid_periodoRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarid_periodoRetencionesPorPagarPorRetenciones=true;
	public Boolean activarid_periodoRetencionesPorPagarPorRetenciones=true;
	public Boolean cargarid_periodoRetencionesPorPagarPorRetenciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoRetencionesPorPagarPorRetenciones=false;//ConEventDepend=true

	public Border resaltares_debitoRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrares_debitoRetencionesPorPagarPorRetenciones=true;
	public Boolean activares_debitoRetencionesPorPagarPorRetenciones=true;

	public Border resaltarfecha_emisionRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarfecha_emisionRetencionesPorPagarPorRetenciones=true;
	public Boolean activarfecha_emisionRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnumero_mayorRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnumero_mayorRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnumero_mayorRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones=true;

	public Border resaltarporcentajeRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarporcentajeRetencionesPorPagarPorRetenciones=true;
	public Boolean activarporcentajeRetencionesPorPagarPorRetenciones=true;

	public Border resaltarbase_imponibleRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarbase_imponibleRetencionesPorPagarPorRetenciones=true;
	public Boolean activarbase_imponibleRetencionesPorPagarPorRetenciones=true;

	public Border resaltarvalorRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarvalorRetencionesPorPagarPorRetenciones=true;
	public Boolean activarvalorRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnumeroRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnumeroRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnumeroRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnombre_benefRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnombre_benefRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnombre_benefRetencionesPorPagarPorRetenciones=true;

	public Border resaltarruc_benefRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarruc_benefRetencionesPorPagarPorRetenciones=true;
	public Boolean activarruc_benefRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnombre_cuenta_contableRetencionesPorPagarPorRetenciones=true;

	public Border resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones=true;
	public Boolean activarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones=true;

	public Border resaltares_debito_datoRetencionesPorPagarPorRetenciones=null;
	public Boolean mostrares_debito_datoRetencionesPorPagarPorRetenciones=true;
	public Boolean activares_debito_datoRetencionesPorPagarPorRetenciones=true;

	
	

	public Border setResaltaridRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltaridRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRetencionesPorPagarPorRetenciones() {
		return this.resaltaridRetencionesPorPagarPorRetenciones;
	}

	public void setResaltaridRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltaridRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostraridRetencionesPorPagarPorRetenciones() {
		return this.mostraridRetencionesPorPagarPorRetenciones;
	}

	public void setMostraridRetencionesPorPagarPorRetenciones(Boolean mostraridRetencionesPorPagarPorRetenciones) {
		this.mostraridRetencionesPorPagarPorRetenciones= mostraridRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivaridRetencionesPorPagarPorRetenciones() {
		return this.activaridRetencionesPorPagarPorRetenciones;
	}

	public void setActivaridRetencionesPorPagarPorRetenciones(Boolean activaridRetencionesPorPagarPorRetenciones) {
		this.activaridRetencionesPorPagarPorRetenciones= activaridRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarid_empresaRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarid_empresaRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRetencionesPorPagarPorRetenciones() {
		return this.resaltarid_empresaRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarid_empresaRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarid_empresaRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarid_empresaRetencionesPorPagarPorRetenciones() {
		return this.mostrarid_empresaRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarid_empresaRetencionesPorPagarPorRetenciones(Boolean mostrarid_empresaRetencionesPorPagarPorRetenciones) {
		this.mostrarid_empresaRetencionesPorPagarPorRetenciones= mostrarid_empresaRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarid_empresaRetencionesPorPagarPorRetenciones() {
		return this.activarid_empresaRetencionesPorPagarPorRetenciones;
	}

	public void setActivarid_empresaRetencionesPorPagarPorRetenciones(Boolean activarid_empresaRetencionesPorPagarPorRetenciones) {
		this.activarid_empresaRetencionesPorPagarPorRetenciones= activarid_empresaRetencionesPorPagarPorRetenciones;
	}

	public Boolean getCargarid_empresaRetencionesPorPagarPorRetenciones() {
		return this.cargarid_empresaRetencionesPorPagarPorRetenciones;
	}

	public void setCargarid_empresaRetencionesPorPagarPorRetenciones(Boolean cargarid_empresaRetencionesPorPagarPorRetenciones) {
		this.cargarid_empresaRetencionesPorPagarPorRetenciones= cargarid_empresaRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarid_sucursalRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRetencionesPorPagarPorRetenciones() {
		return this.resaltarid_sucursalRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarid_sucursalRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarid_sucursalRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRetencionesPorPagarPorRetenciones() {
		return this.mostrarid_sucursalRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarid_sucursalRetencionesPorPagarPorRetenciones(Boolean mostrarid_sucursalRetencionesPorPagarPorRetenciones) {
		this.mostrarid_sucursalRetencionesPorPagarPorRetenciones= mostrarid_sucursalRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarid_sucursalRetencionesPorPagarPorRetenciones() {
		return this.activarid_sucursalRetencionesPorPagarPorRetenciones;
	}

	public void setActivarid_sucursalRetencionesPorPagarPorRetenciones(Boolean activarid_sucursalRetencionesPorPagarPorRetenciones) {
		this.activarid_sucursalRetencionesPorPagarPorRetenciones= activarid_sucursalRetencionesPorPagarPorRetenciones;
	}

	public Boolean getCargarid_sucursalRetencionesPorPagarPorRetenciones() {
		return this.cargarid_sucursalRetencionesPorPagarPorRetenciones;
	}

	public void setCargarid_sucursalRetencionesPorPagarPorRetenciones(Boolean cargarid_sucursalRetencionesPorPagarPorRetenciones) {
		this.cargarid_sucursalRetencionesPorPagarPorRetenciones= cargarid_sucursalRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarid_ejercicioRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioRetencionesPorPagarPorRetenciones() {
		return this.resaltarid_ejercicioRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarid_ejercicioRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarid_ejercicioRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioRetencionesPorPagarPorRetenciones() {
		return this.mostrarid_ejercicioRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarid_ejercicioRetencionesPorPagarPorRetenciones(Boolean mostrarid_ejercicioRetencionesPorPagarPorRetenciones) {
		this.mostrarid_ejercicioRetencionesPorPagarPorRetenciones= mostrarid_ejercicioRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarid_ejercicioRetencionesPorPagarPorRetenciones() {
		return this.activarid_ejercicioRetencionesPorPagarPorRetenciones;
	}

	public void setActivarid_ejercicioRetencionesPorPagarPorRetenciones(Boolean activarid_ejercicioRetencionesPorPagarPorRetenciones) {
		this.activarid_ejercicioRetencionesPorPagarPorRetenciones= activarid_ejercicioRetencionesPorPagarPorRetenciones;
	}

	public Boolean getCargarid_ejercicioRetencionesPorPagarPorRetenciones() {
		return this.cargarid_ejercicioRetencionesPorPagarPorRetenciones;
	}

	public void setCargarid_ejercicioRetencionesPorPagarPorRetenciones(Boolean cargarid_ejercicioRetencionesPorPagarPorRetenciones) {
		this.cargarid_ejercicioRetencionesPorPagarPorRetenciones= cargarid_ejercicioRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarid_periodoRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarid_periodoRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoRetencionesPorPagarPorRetenciones() {
		return this.resaltarid_periodoRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarid_periodoRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarid_periodoRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarid_periodoRetencionesPorPagarPorRetenciones() {
		return this.mostrarid_periodoRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarid_periodoRetencionesPorPagarPorRetenciones(Boolean mostrarid_periodoRetencionesPorPagarPorRetenciones) {
		this.mostrarid_periodoRetencionesPorPagarPorRetenciones= mostrarid_periodoRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarid_periodoRetencionesPorPagarPorRetenciones() {
		return this.activarid_periodoRetencionesPorPagarPorRetenciones;
	}

	public void setActivarid_periodoRetencionesPorPagarPorRetenciones(Boolean activarid_periodoRetencionesPorPagarPorRetenciones) {
		this.activarid_periodoRetencionesPorPagarPorRetenciones= activarid_periodoRetencionesPorPagarPorRetenciones;
	}

	public Boolean getCargarid_periodoRetencionesPorPagarPorRetenciones() {
		return this.cargarid_periodoRetencionesPorPagarPorRetenciones;
	}

	public void setCargarid_periodoRetencionesPorPagarPorRetenciones(Boolean cargarid_periodoRetencionesPorPagarPorRetenciones) {
		this.cargarid_periodoRetencionesPorPagarPorRetenciones= cargarid_periodoRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltares_debitoRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltares_debitoRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debitoRetencionesPorPagarPorRetenciones() {
		return this.resaltares_debitoRetencionesPorPagarPorRetenciones;
	}

	public void setResaltares_debitoRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltares_debitoRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrares_debitoRetencionesPorPagarPorRetenciones() {
		return this.mostrares_debitoRetencionesPorPagarPorRetenciones;
	}

	public void setMostrares_debitoRetencionesPorPagarPorRetenciones(Boolean mostrares_debitoRetencionesPorPagarPorRetenciones) {
		this.mostrares_debitoRetencionesPorPagarPorRetenciones= mostrares_debitoRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivares_debitoRetencionesPorPagarPorRetenciones() {
		return this.activares_debitoRetencionesPorPagarPorRetenciones;
	}

	public void setActivares_debitoRetencionesPorPagarPorRetenciones(Boolean activares_debitoRetencionesPorPagarPorRetenciones) {
		this.activares_debitoRetencionesPorPagarPorRetenciones= activares_debitoRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarfecha_emisionRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionRetencionesPorPagarPorRetenciones() {
		return this.resaltarfecha_emisionRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarfecha_emisionRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarfecha_emisionRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionRetencionesPorPagarPorRetenciones() {
		return this.mostrarfecha_emisionRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarfecha_emisionRetencionesPorPagarPorRetenciones(Boolean mostrarfecha_emisionRetencionesPorPagarPorRetenciones) {
		this.mostrarfecha_emisionRetencionesPorPagarPorRetenciones= mostrarfecha_emisionRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarfecha_emisionRetencionesPorPagarPorRetenciones() {
		return this.activarfecha_emisionRetencionesPorPagarPorRetenciones;
	}

	public void setActivarfecha_emisionRetencionesPorPagarPorRetenciones(Boolean activarfecha_emisionRetencionesPorPagarPorRetenciones) {
		this.activarfecha_emisionRetencionesPorPagarPorRetenciones= activarfecha_emisionRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones() {
		return this.resaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones() {
		return this.mostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(Boolean mostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones) {
		this.mostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones= mostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones() {
		return this.activarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(Boolean activarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones) {
		this.activarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones= activarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnumero_mayorRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorRetencionesPorPagarPorRetenciones() {
		return this.resaltarnumero_mayorRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnumero_mayorRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnumero_mayorRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorRetencionesPorPagarPorRetenciones() {
		return this.mostrarnumero_mayorRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnumero_mayorRetencionesPorPagarPorRetenciones(Boolean mostrarnumero_mayorRetencionesPorPagarPorRetenciones) {
		this.mostrarnumero_mayorRetencionesPorPagarPorRetenciones= mostrarnumero_mayorRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnumero_mayorRetencionesPorPagarPorRetenciones() {
		return this.activarnumero_mayorRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnumero_mayorRetencionesPorPagarPorRetenciones(Boolean activarnumero_mayorRetencionesPorPagarPorRetenciones) {
		this.activarnumero_mayorRetencionesPorPagarPorRetenciones= activarnumero_mayorRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones() {
		return this.resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones() {
		return this.mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(Boolean mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones) {
		this.mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones= mostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones() {
		return this.activarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(Boolean activarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones) {
		this.activarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones= activarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones() {
		return this.resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones() {
		return this.mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(Boolean mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones) {
		this.mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones= mostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones() {
		return this.activarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(Boolean activarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones) {
		this.activarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones= activarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarporcentajeRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarporcentajeRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeRetencionesPorPagarPorRetenciones() {
		return this.resaltarporcentajeRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarporcentajeRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarporcentajeRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarporcentajeRetencionesPorPagarPorRetenciones() {
		return this.mostrarporcentajeRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarporcentajeRetencionesPorPagarPorRetenciones(Boolean mostrarporcentajeRetencionesPorPagarPorRetenciones) {
		this.mostrarporcentajeRetencionesPorPagarPorRetenciones= mostrarporcentajeRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarporcentajeRetencionesPorPagarPorRetenciones() {
		return this.activarporcentajeRetencionesPorPagarPorRetenciones;
	}

	public void setActivarporcentajeRetencionesPorPagarPorRetenciones(Boolean activarporcentajeRetencionesPorPagarPorRetenciones) {
		this.activarporcentajeRetencionesPorPagarPorRetenciones= activarporcentajeRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarbase_imponibleRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarbase_imponibleRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_imponibleRetencionesPorPagarPorRetenciones() {
		return this.resaltarbase_imponibleRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarbase_imponibleRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarbase_imponibleRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarbase_imponibleRetencionesPorPagarPorRetenciones() {
		return this.mostrarbase_imponibleRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarbase_imponibleRetencionesPorPagarPorRetenciones(Boolean mostrarbase_imponibleRetencionesPorPagarPorRetenciones) {
		this.mostrarbase_imponibleRetencionesPorPagarPorRetenciones= mostrarbase_imponibleRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarbase_imponibleRetencionesPorPagarPorRetenciones() {
		return this.activarbase_imponibleRetencionesPorPagarPorRetenciones;
	}

	public void setActivarbase_imponibleRetencionesPorPagarPorRetenciones(Boolean activarbase_imponibleRetencionesPorPagarPorRetenciones) {
		this.activarbase_imponibleRetencionesPorPagarPorRetenciones= activarbase_imponibleRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarvalorRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarvalorRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorRetencionesPorPagarPorRetenciones() {
		return this.resaltarvalorRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarvalorRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarvalorRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarvalorRetencionesPorPagarPorRetenciones() {
		return this.mostrarvalorRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarvalorRetencionesPorPagarPorRetenciones(Boolean mostrarvalorRetencionesPorPagarPorRetenciones) {
		this.mostrarvalorRetencionesPorPagarPorRetenciones= mostrarvalorRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarvalorRetencionesPorPagarPorRetenciones() {
		return this.activarvalorRetencionesPorPagarPorRetenciones;
	}

	public void setActivarvalorRetencionesPorPagarPorRetenciones(Boolean activarvalorRetencionesPorPagarPorRetenciones) {
		this.activarvalorRetencionesPorPagarPorRetenciones= activarvalorRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnumeroRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnumeroRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroRetencionesPorPagarPorRetenciones() {
		return this.resaltarnumeroRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnumeroRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnumeroRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnumeroRetencionesPorPagarPorRetenciones() {
		return this.mostrarnumeroRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnumeroRetencionesPorPagarPorRetenciones(Boolean mostrarnumeroRetencionesPorPagarPorRetenciones) {
		this.mostrarnumeroRetencionesPorPagarPorRetenciones= mostrarnumeroRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnumeroRetencionesPorPagarPorRetenciones() {
		return this.activarnumeroRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnumeroRetencionesPorPagarPorRetenciones(Boolean activarnumeroRetencionesPorPagarPorRetenciones) {
		this.activarnumeroRetencionesPorPagarPorRetenciones= activarnumeroRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnombre_benefRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_benefRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_benefRetencionesPorPagarPorRetenciones() {
		return this.resaltarnombre_benefRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnombre_benefRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnombre_benefRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_benefRetencionesPorPagarPorRetenciones() {
		return this.mostrarnombre_benefRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnombre_benefRetencionesPorPagarPorRetenciones(Boolean mostrarnombre_benefRetencionesPorPagarPorRetenciones) {
		this.mostrarnombre_benefRetencionesPorPagarPorRetenciones= mostrarnombre_benefRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnombre_benefRetencionesPorPagarPorRetenciones() {
		return this.activarnombre_benefRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnombre_benefRetencionesPorPagarPorRetenciones(Boolean activarnombre_benefRetencionesPorPagarPorRetenciones) {
		this.activarnombre_benefRetencionesPorPagarPorRetenciones= activarnombre_benefRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarruc_benefRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarruc_benefRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_benefRetencionesPorPagarPorRetenciones() {
		return this.resaltarruc_benefRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarruc_benefRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarruc_benefRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarruc_benefRetencionesPorPagarPorRetenciones() {
		return this.mostrarruc_benefRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarruc_benefRetencionesPorPagarPorRetenciones(Boolean mostrarruc_benefRetencionesPorPagarPorRetenciones) {
		this.mostrarruc_benefRetencionesPorPagarPorRetenciones= mostrarruc_benefRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarruc_benefRetencionesPorPagarPorRetenciones() {
		return this.activarruc_benefRetencionesPorPagarPorRetenciones;
	}

	public void setActivarruc_benefRetencionesPorPagarPorRetenciones(Boolean activarruc_benefRetencionesPorPagarPorRetenciones) {
		this.activarruc_benefRetencionesPorPagarPorRetenciones= activarruc_benefRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones() {
		return this.resaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones() {
		return this.mostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(Boolean mostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones) {
		this.mostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones= mostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnombre_cuenta_contableRetencionesPorPagarPorRetenciones() {
		return this.activarnombre_cuenta_contableRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(Boolean activarnombre_cuenta_contableRetencionesPorPagarPorRetenciones) {
		this.activarnombre_cuenta_contableRetencionesPorPagarPorRetenciones= activarnombre_cuenta_contableRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones() {
		return this.resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones() {
		return this.mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(Boolean mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones) {
		this.mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones= mostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones() {
		return this.activarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones;
	}

	public void setActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(Boolean activarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones) {
		this.activarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones= activarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones;
	}

	public Border setResaltares_debito_datoRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//retencionesporpagarporretencionesBeanSwingJInternalFrame.jTtoolBarRetencionesPorPagarPorRetenciones.setBorder(borderResaltar);
		
		this.resaltares_debito_datoRetencionesPorPagarPorRetenciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debito_datoRetencionesPorPagarPorRetenciones() {
		return this.resaltares_debito_datoRetencionesPorPagarPorRetenciones;
	}

	public void setResaltares_debito_datoRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltares_debito_datoRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public Boolean getMostrares_debito_datoRetencionesPorPagarPorRetenciones() {
		return this.mostrares_debito_datoRetencionesPorPagarPorRetenciones;
	}

	public void setMostrares_debito_datoRetencionesPorPagarPorRetenciones(Boolean mostrares_debito_datoRetencionesPorPagarPorRetenciones) {
		this.mostrares_debito_datoRetencionesPorPagarPorRetenciones= mostrares_debito_datoRetencionesPorPagarPorRetenciones;
	}

	public Boolean getActivares_debito_datoRetencionesPorPagarPorRetenciones() {
		return this.activares_debito_datoRetencionesPorPagarPorRetenciones;
	}

	public void setActivares_debito_datoRetencionesPorPagarPorRetenciones(Boolean activares_debito_datoRetencionesPorPagarPorRetenciones) {
		this.activares_debito_datoRetencionesPorPagarPorRetenciones= activares_debito_datoRetencionesPorPagarPorRetenciones;
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
		
		
		this.setMostraridRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarid_empresaRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarid_sucursalRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarid_ejercicioRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarid_periodoRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrares_debitoRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarfecha_emisionRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnumero_mayorRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarporcentajeRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarbase_imponibleRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarvalorRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnumeroRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnombre_benefRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarruc_benefRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(esInicial);
		this.setMostrares_debito_datoRetencionesPorPagarPorRetenciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ID)) {
				this.setMostraridRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITO)) {
				this.setMostrares_debitoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {
				this.setMostrarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setMostrarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setMostrarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE)) {
				this.setMostrarbase_imponibleRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR)) {
				this.setMostrarvalorRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF)) {
				this.setMostrarnombre_benefRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF)) {
				this.setMostrarruc_benefRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {
				this.setMostrarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO)) {
				this.setMostrares_debito_datoRetencionesPorPagarPorRetenciones(esAsigna);
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
		
		
		this.setActivaridRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarid_empresaRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarid_sucursalRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarid_ejercicioRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarid_periodoRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivares_debitoRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarfecha_emisionRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnumero_mayorRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarporcentajeRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarbase_imponibleRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarvalorRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnumeroRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnombre_benefRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarruc_benefRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(esInicial);
		this.setActivares_debito_datoRetencionesPorPagarPorRetenciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ID)) {
				this.setActivaridRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITO)) {
				this.setActivares_debitoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {
				this.setActivarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setActivarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setActivarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE)) {
				this.setActivarbase_imponibleRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR)) {
				this.setActivarvalorRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO)) {
				this.setActivarnumeroRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF)) {
				this.setActivarnombre_benefRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF)) {
				this.setActivarruc_benefRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {
				this.setActivarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO)) {
				this.setActivares_debito_datoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarid_empresaRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarid_sucursalRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarid_ejercicioRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarid_periodoRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltares_debitoRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarfecha_emisionRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnumero_mayorRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarporcentajeRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarbase_imponibleRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarvalorRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnumeroRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnombre_benefRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarruc_benefRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(esInicial);
		this.setResaltares_debito_datoRetencionesPorPagarPorRetenciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ID)) {
				this.setResaltaridRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITO)) {
				this.setResaltares_debitoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRETIPOMOVIMIENTO)) {
				this.setResaltarnombre_tipo_movimientoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLERETENCION)) {
				this.setResaltarnombre_cuenta_contable_retencionRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setResaltarnumero_pre_impreso_facturaRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE)) {
				this.setResaltarbase_imponibleRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR)) {
				this.setResaltarvalorRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBREBENEF)) {
				this.setResaltarnombre_benefRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.RUCBENEF)) {
				this.setResaltarruc_benefRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.NOMBRECUENTACONTABLECREDITO)) {
				this.setResaltarnombre_cuenta_contable_creditoRetencionesPorPagarPorRetenciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(RetencionesPorPagarPorRetencionesConstantesFunciones.ESDEBITODATO)) {
				this.setResaltares_debito_datoRetencionesPorPagarPorRetenciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones=true;

	public Boolean getMostrarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones() {
		return this.mostrarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones;
	}

	public void setMostrarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones=true;

	public Boolean getActivarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones() {
		return this.activarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones;
	}

	public void setActivarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones(Boolean habilitarResaltar) {
		this.activarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones=null;

	public Border getResaltarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones() {
		return this.resaltarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones;
	}

	public void setResaltarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones(Border borderResaltar) {
		this.resaltarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones= borderResaltar;
	}

	public void setResaltarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones(ParametroGeneralUsuario parametroGeneralUsuario/*RetencionesPorPagarPorRetencionesBeanSwingJInternalFrame retencionesporpagarporretencionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaRetencionesPorPagarPorRetencionesRetencionesPorPagarPorRetenciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}