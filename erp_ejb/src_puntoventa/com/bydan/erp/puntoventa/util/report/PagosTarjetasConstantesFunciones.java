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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.PagosTarjetasConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.PagosTarjetasParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.PagosTarjetasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PagosTarjetasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PagosTarjetas";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PagosTarjetas"+PagosTarjetasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PagosTarjetasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PagosTarjetasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PagosTarjetasConstantesFunciones.SCHEMA+"_"+PagosTarjetasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PagosTarjetasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PagosTarjetasConstantesFunciones.SCHEMA+"_"+PagosTarjetasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PagosTarjetasConstantesFunciones.SCHEMA+"_"+PagosTarjetasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PagosTarjetasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PagosTarjetasConstantesFunciones.SCHEMA+"_"+PagosTarjetasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosTarjetasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosTarjetasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosTarjetasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosTarjetasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosTarjetasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosTarjetasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PagosTarjetasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PagosTarjetasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PagosTarjetasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PagosTarjetasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pagos Tarjetases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pagos Tarjetas";
	public static final String SCLASSWEBTITULO_LOWER="Pagos Tarjetas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PagosTarjetas";
	public static final String OBJECTNAME="pagostarjetas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="pagos_tarjetas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pagostarjetas from "+PagosTarjetasConstantesFunciones.SPERSISTENCENAME+" pagostarjetas";
	public static String QUERYSELECTNATIVE="select "+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".id,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".version_row,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".id_empresa,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".fecha_hasta,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".codigo_asiento_contable,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".codigo_tarjeta_credito,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".nombre_tipo_interes_tarjeta,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".nombre_conexion,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".nombre_mes,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".numero,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".lote,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".valor,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".valor_retencion,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".valor_comision,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".valor_calculado,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".valor_cancelado,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".valor_difiere,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".numero_retencion,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".numero_liquidacion,"+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME+".fecha from "+PagosTarjetasConstantesFunciones.SCHEMA+"."+PagosTarjetasConstantesFunciones.TABLENAME;//+" as "+PagosTarjetasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGOASIENTOCONTABLE= "codigo_asiento_contable";
    public static final String CODIGOTARJETACREDITO= "codigo_tarjeta_credito";
    public static final String NOMBRETIPOINTERESTARJETA= "nombre_tipo_interes_tarjeta";
    public static final String NOMBRECONEXION= "nombre_conexion";
    public static final String NOMBREMES= "nombre_mes";
    public static final String NUMERO= "numero";
    public static final String LOTE= "lote";
    public static final String VALOR= "valor";
    public static final String VALORRETENCION= "valor_retencion";
    public static final String VALORCOMISION= "valor_comision";
    public static final String VALORCALCULADO= "valor_calculado";
    public static final String VALORCANCELADO= "valor_cancelado";
    public static final String VALORDIFIERE= "valor_difiere";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String NUMEROLIQUIDACION= "numero_liquidacion";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGOASIENTOCONTABLE= "Codigo Asiento Contable";
		public static final String LABEL_CODIGOASIENTOCONTABLE_LOWER= "Codigo Asiento Contable";
    	public static final String LABEL_CODIGOTARJETACREDITO= "Codigo Tarjeta Credito";
		public static final String LABEL_CODIGOTARJETACREDITO_LOWER= "Codigo Tarjeta Credito";
    	public static final String LABEL_NOMBRETIPOINTERESTARJETA= "Nombre Tipo Interes Tarjeta";
		public static final String LABEL_NOMBRETIPOINTERESTARJETA_LOWER= "Nombre Tipo Interes Tarjeta";
    	public static final String LABEL_NOMBRECONEXION= "Nombre Conexion";
		public static final String LABEL_NOMBRECONEXION_LOWER= "Nombre Conexion";
    	public static final String LABEL_NOMBREMES= "Nombre Mes";
		public static final String LABEL_NOMBREMES_LOWER= "Nombre Mes";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_VALORRETENCION= "Valor Retencion";
		public static final String LABEL_VALORRETENCION_LOWER= "Valor Retencion";
    	public static final String LABEL_VALORCOMISION= "Valor Comision";
		public static final String LABEL_VALORCOMISION_LOWER= "Valor Comision";
    	public static final String LABEL_VALORCALCULADO= "Valor Calculado";
		public static final String LABEL_VALORCALCULADO_LOWER= "Valor Calculado";
    	public static final String LABEL_VALORCANCELADO= "Valor Cancelado";
		public static final String LABEL_VALORCANCELADO_LOWER= "Valor Cancelado";
    	public static final String LABEL_VALORDIFIERE= "Valor Difiere";
		public static final String LABEL_VALORDIFIERE_LOWER= "Valor Difiere";
    	public static final String LABEL_NUMERORETENCION= "Numero Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_NUMEROLIQUIDACION= "Numero Liquidacion";
		public static final String LABEL_NUMEROLIQUIDACION_LOWER= "Numero Liquidacion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
	public static final String SREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_TARJETA_CREDITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TARJETA_CREDITO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_INTERES_TARJETA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_INTERES_TARJETA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CONEXION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CONEXION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MES=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_LIQUIDACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_LIQUIDACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getPagosTarjetasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.IDEMPRESA)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.FECHAHASTA)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_CODIGOTARJETACREDITO;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_NOMBRETIPOINTERESTARJETA;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.NOMBRECONEXION)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_NOMBRECONEXION;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.NOMBREMES)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_NOMBREMES;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.NUMERO)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.LOTE)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.VALOR)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.VALORRETENCION)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_VALORRETENCION;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.VALORCOMISION)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_VALORCOMISION;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.VALORCALCULADO)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_VALORCALCULADO;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.VALORCANCELADO)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_VALORCANCELADO;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.VALORDIFIERE)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_VALORDIFIERE;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.NUMERORETENCION)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_NUMEROLIQUIDACION;}
		if(sNombreColumna.equals(PagosTarjetasConstantesFunciones.FECHA)) {sLabelColumna=PagosTarjetasConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPagosTarjetasDescripcion(PagosTarjetas pagostarjetas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pagostarjetas !=null/* && pagostarjetas.getId()!=0*/) {
			sDescripcion=pagostarjetas.getcodigo_asiento_contable();//pagostarjetaspagostarjetas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPagosTarjetasDescripcionDetallado(PagosTarjetas pagostarjetas) {
		String sDescripcion="";
			
		sDescripcion+=PagosTarjetasConstantesFunciones.ID+"=";
		sDescripcion+=pagostarjetas.getId().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pagostarjetas.getVersionRow().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pagostarjetas.getid_empresa().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=pagostarjetas.getfecha_hasta().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE+"=";
		sDescripcion+=pagostarjetas.getcodigo_asiento_contable()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO+"=";
		sDescripcion+=pagostarjetas.getcodigo_tarjeta_credito()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA+"=";
		sDescripcion+=pagostarjetas.getnombre_tipo_interes_tarjeta()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.NOMBRECONEXION+"=";
		sDescripcion+=pagostarjetas.getnombre_conexion()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.NOMBREMES+"=";
		sDescripcion+=pagostarjetas.getnombre_mes()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.NUMERO+"=";
		sDescripcion+=pagostarjetas.getnumero()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.LOTE+"=";
		sDescripcion+=pagostarjetas.getlote()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.VALOR+"=";
		sDescripcion+=pagostarjetas.getvalor().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.VALORRETENCION+"=";
		sDescripcion+=pagostarjetas.getvalor_retencion().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.VALORCOMISION+"=";
		sDescripcion+=pagostarjetas.getvalor_comision().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.VALORCALCULADO+"=";
		sDescripcion+=pagostarjetas.getvalor_calculado().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.VALORCANCELADO+"=";
		sDescripcion+=pagostarjetas.getvalor_cancelado().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.VALORDIFIERE+"=";
		sDescripcion+=pagostarjetas.getvalor_difiere().toString()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=pagostarjetas.getnumero_retencion()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION+"=";
		sDescripcion+=pagostarjetas.getnumero_liquidacion()+",";
		sDescripcion+=PagosTarjetasConstantesFunciones.FECHA+"=";
		sDescripcion+=pagostarjetas.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPagosTarjetasDescripcion(PagosTarjetas pagostarjetas,String sValor) throws Exception {			
		if(pagostarjetas !=null) {
			pagostarjetas.setcodigo_asiento_contable(sValor);//pagostarjetaspagostarjetas.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaPagosTarjetas")) {
			sNombreIndice="Tipo=  Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPagosTarjetas(Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPagosTarjetas(PagosTarjetas pagostarjetas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagostarjetas.setcodigo_asiento_contable(pagostarjetas.getcodigo_asiento_contable().trim());
		pagostarjetas.setcodigo_tarjeta_credito(pagostarjetas.getcodigo_tarjeta_credito().trim());
		pagostarjetas.setnombre_tipo_interes_tarjeta(pagostarjetas.getnombre_tipo_interes_tarjeta().trim());
		pagostarjetas.setnombre_conexion(pagostarjetas.getnombre_conexion().trim());
		pagostarjetas.setnombre_mes(pagostarjetas.getnombre_mes().trim());
		pagostarjetas.setnumero(pagostarjetas.getnumero().trim());
		pagostarjetas.setlote(pagostarjetas.getlote().trim());
		pagostarjetas.setnumero_retencion(pagostarjetas.getnumero_retencion().trim());
		pagostarjetas.setnumero_liquidacion(pagostarjetas.getnumero_liquidacion().trim());
	}
	
	public static void quitarEspaciosPagosTarjetass(List<PagosTarjetas> pagostarjetass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagosTarjetas pagostarjetas: pagostarjetass) {
			pagostarjetas.setcodigo_asiento_contable(pagostarjetas.getcodigo_asiento_contable().trim());
			pagostarjetas.setcodigo_tarjeta_credito(pagostarjetas.getcodigo_tarjeta_credito().trim());
			pagostarjetas.setnombre_tipo_interes_tarjeta(pagostarjetas.getnombre_tipo_interes_tarjeta().trim());
			pagostarjetas.setnombre_conexion(pagostarjetas.getnombre_conexion().trim());
			pagostarjetas.setnombre_mes(pagostarjetas.getnombre_mes().trim());
			pagostarjetas.setnumero(pagostarjetas.getnumero().trim());
			pagostarjetas.setlote(pagostarjetas.getlote().trim());
			pagostarjetas.setnumero_retencion(pagostarjetas.getnumero_retencion().trim());
			pagostarjetas.setnumero_liquidacion(pagostarjetas.getnumero_liquidacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosTarjetas(PagosTarjetas pagostarjetas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pagostarjetas.getConCambioAuxiliar()) {
			pagostarjetas.setIsDeleted(pagostarjetas.getIsDeletedAuxiliar());	
			pagostarjetas.setIsNew(pagostarjetas.getIsNewAuxiliar());	
			pagostarjetas.setIsChanged(pagostarjetas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pagostarjetas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pagostarjetas.setIsDeletedAuxiliar(false);	
			pagostarjetas.setIsNewAuxiliar(false);	
			pagostarjetas.setIsChangedAuxiliar(false);
			
			pagostarjetas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosTarjetass(List<PagosTarjetas> pagostarjetass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PagosTarjetas pagostarjetas : pagostarjetass) {
			if(conAsignarBase && pagostarjetas.getConCambioAuxiliar()) {
				pagostarjetas.setIsDeleted(pagostarjetas.getIsDeletedAuxiliar());	
				pagostarjetas.setIsNew(pagostarjetas.getIsNewAuxiliar());	
				pagostarjetas.setIsChanged(pagostarjetas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pagostarjetas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pagostarjetas.setIsDeletedAuxiliar(false);	
				pagostarjetas.setIsNewAuxiliar(false);	
				pagostarjetas.setIsChangedAuxiliar(false);
				
				pagostarjetas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPagosTarjetas(PagosTarjetas pagostarjetas,Boolean conEnteros) throws Exception  {
		pagostarjetas.setvalor(0.0);
		pagostarjetas.setvalor_retencion(0.0);
		pagostarjetas.setvalor_comision(0.0);
		pagostarjetas.setvalor_calculado(0.0);
		pagostarjetas.setvalor_cancelado(0.0);
		pagostarjetas.setvalor_difiere(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPagosTarjetass(List<PagosTarjetas> pagostarjetass,Boolean conEnteros) throws Exception  {
		
		for(PagosTarjetas pagostarjetas: pagostarjetass) {
			pagostarjetas.setvalor(0.0);
			pagostarjetas.setvalor_retencion(0.0);
			pagostarjetas.setvalor_comision(0.0);
			pagostarjetas.setvalor_calculado(0.0);
			pagostarjetas.setvalor_cancelado(0.0);
			pagostarjetas.setvalor_difiere(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPagosTarjetas(List<PagosTarjetas> pagostarjetass,PagosTarjetas pagostarjetasAux) throws Exception  {
		PagosTarjetasConstantesFunciones.InicializarValoresPagosTarjetas(pagostarjetasAux,true);
		
		for(PagosTarjetas pagostarjetas: pagostarjetass) {
			if(pagostarjetas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pagostarjetasAux.setvalor(pagostarjetasAux.getvalor()+pagostarjetas.getvalor());			
			pagostarjetasAux.setvalor_retencion(pagostarjetasAux.getvalor_retencion()+pagostarjetas.getvalor_retencion());			
			pagostarjetasAux.setvalor_comision(pagostarjetasAux.getvalor_comision()+pagostarjetas.getvalor_comision());			
			pagostarjetasAux.setvalor_calculado(pagostarjetasAux.getvalor_calculado()+pagostarjetas.getvalor_calculado());			
			pagostarjetasAux.setvalor_cancelado(pagostarjetasAux.getvalor_cancelado()+pagostarjetas.getvalor_cancelado());			
			pagostarjetasAux.setvalor_difiere(pagostarjetasAux.getvalor_difiere()+pagostarjetas.getvalor_difiere());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosTarjetas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PagosTarjetasConstantesFunciones.getArrayColumnasGlobalesPagosTarjetas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosTarjetas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagosTarjetasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagosTarjetasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPagosTarjetas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagosTarjetas> pagostarjetass,PagosTarjetas pagostarjetas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagosTarjetas pagostarjetasAux: pagostarjetass) {
			if(pagostarjetasAux!=null && pagostarjetas!=null) {
				if((pagostarjetasAux.getId()==null && pagostarjetas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pagostarjetasAux.getId()!=null && pagostarjetas.getId()!=null){
					if(pagostarjetasAux.getId().equals(pagostarjetas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagosTarjetas(List<PagosTarjetas> pagostarjetass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double valor_retencionTotal=0.0;
		Double valor_comisionTotal=0.0;
		Double valor_calculadoTotal=0.0;
		Double valor_canceladoTotal=0.0;
		Double valor_difiereTotal=0.0;
	
		for(PagosTarjetas pagostarjetas: pagostarjetass) {			
			if(pagostarjetas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=pagostarjetas.getvalor();
			valor_retencionTotal+=pagostarjetas.getvalor_retencion();
			valor_comisionTotal+=pagostarjetas.getvalor_comision();
			valor_calculadoTotal+=pagostarjetas.getvalor_calculado();
			valor_canceladoTotal+=pagostarjetas.getvalor_cancelado();
			valor_difiereTotal+=pagostarjetas.getvalor_difiere();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosTarjetasConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosTarjetasConstantesFunciones.VALORRETENCION);
		datoGeneral.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORRETENCION);
		datoGeneral.setdValorDouble(valor_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosTarjetasConstantesFunciones.VALORCOMISION);
		datoGeneral.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORCOMISION);
		datoGeneral.setdValorDouble(valor_comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosTarjetasConstantesFunciones.VALORCALCULADO);
		datoGeneral.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORCALCULADO);
		datoGeneral.setdValorDouble(valor_calculadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosTarjetasConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosTarjetasConstantesFunciones.VALORDIFIERE);
		datoGeneral.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORDIFIERE);
		datoGeneral.setdValorDouble(valor_difiereTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPagosTarjetas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_ID, PagosTarjetasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_VERSIONROW, PagosTarjetasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE, PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_CODIGOTARJETACREDITO, PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_NOMBRETIPOINTERESTARJETA, PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_NOMBRECONEXION, PagosTarjetasConstantesFunciones.NOMBRECONEXION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_NOMBREMES, PagosTarjetasConstantesFunciones.NOMBREMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_NUMERO, PagosTarjetasConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_LOTE, PagosTarjetasConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_VALOR, PagosTarjetasConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_VALORRETENCION, PagosTarjetasConstantesFunciones.VALORRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_VALORCOMISION, PagosTarjetasConstantesFunciones.VALORCOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_VALORCALCULADO, PagosTarjetasConstantesFunciones.VALORCALCULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_VALORCANCELADO, PagosTarjetasConstantesFunciones.VALORCANCELADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_VALORDIFIERE, PagosTarjetasConstantesFunciones.VALORDIFIERE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_NUMERORETENCION, PagosTarjetasConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_NUMEROLIQUIDACION, PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosTarjetasConstantesFunciones.LABEL_FECHA, PagosTarjetasConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPagosTarjetas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.NOMBRECONEXION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.NOMBREMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.VALORRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.VALORCOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.VALORCALCULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.VALORCANCELADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.VALORDIFIERE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosTarjetasConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosTarjetas() throws Exception  {
		return PagosTarjetasConstantesFunciones.getTiposSeleccionarPagosTarjetas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosTarjetas(Boolean conFk) throws Exception  {
		return PagosTarjetasConstantesFunciones.getTiposSeleccionarPagosTarjetas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosTarjetas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_CODIGOTARJETACREDITO);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_CODIGOTARJETACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_NOMBRETIPOINTERESTARJETA);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_NOMBRETIPOINTERESTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_NOMBRECONEXION);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_NOMBRECONEXION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_NOMBREMES);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_NOMBREMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_VALORRETENCION);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_VALORCOMISION);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORCOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_VALORCALCULADO);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORCALCULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_VALORCANCELADO);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORCANCELADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_VALORDIFIERE);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_VALORDIFIERE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_NUMEROLIQUIDACION);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_NUMEROLIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosTarjetasConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PagosTarjetasConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPagosTarjetas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPagosTarjetas(PagosTarjetas pagostarjetasAux) throws Exception {
		
			pagostarjetasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagostarjetasAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPagosTarjetas(List<PagosTarjetas> pagostarjetassTemp) throws Exception {
		for(PagosTarjetas pagostarjetasAux:pagostarjetassTemp) {
			
			pagostarjetasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagostarjetasAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPagosTarjetas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPagosTarjetas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosTarjetas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosTarjetasConstantesFunciones.getClassesRelationshipsOfPagosTarjetas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosTarjetas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosTarjetas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosTarjetasConstantesFunciones.getClassesRelationshipsFromStringsOfPagosTarjetas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosTarjetas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PagosTarjetas pagostarjetas,List<PagosTarjetas> pagostarjetass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PagosTarjetas pagostarjetas,List<PagosTarjetas> pagostarjetass) throws Exception {
		try	{			
			for(PagosTarjetas pagostarjetasLocal:pagostarjetass) {
				if(pagostarjetasLocal.getId().equals(pagostarjetas.getId())) {
					pagostarjetasLocal.setIsSelected(pagostarjetas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPagosTarjetas(List<PagosTarjetas> pagostarjetassAux) throws Exception {
		//this.pagostarjetassAux=pagostarjetassAux;
		
		for(PagosTarjetas pagostarjetasAux:pagostarjetassAux) {
			if(pagostarjetasAux.getIsChanged()) {
				pagostarjetasAux.setIsChanged(false);
			}		
			
			if(pagostarjetasAux.getIsNew()) {
				pagostarjetasAux.setIsNew(false);
			}	
			
			if(pagostarjetasAux.getIsDeleted()) {
				pagostarjetasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPagosTarjetas(PagosTarjetas pagostarjetasAux) throws Exception {
		//this.pagostarjetasAux=pagostarjetasAux;
		
			if(pagostarjetasAux.getIsChanged()) {
				pagostarjetasAux.setIsChanged(false);
			}		
			
			if(pagostarjetasAux.getIsNew()) {
				pagostarjetasAux.setIsNew(false);
			}	
			
			if(pagostarjetasAux.getIsDeleted()) {
				pagostarjetasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PagosTarjetas pagostarjetasAsignar,PagosTarjetas pagostarjetas) throws Exception {
		pagostarjetasAsignar.setId(pagostarjetas.getId());	
		pagostarjetasAsignar.setVersionRow(pagostarjetas.getVersionRow());	
		pagostarjetasAsignar.setcodigo_asiento_contable(pagostarjetas.getcodigo_asiento_contable());	
		pagostarjetasAsignar.setcodigo_tarjeta_credito(pagostarjetas.getcodigo_tarjeta_credito());	
		pagostarjetasAsignar.setnombre_tipo_interes_tarjeta(pagostarjetas.getnombre_tipo_interes_tarjeta());	
		pagostarjetasAsignar.setnombre_conexion(pagostarjetas.getnombre_conexion());	
		pagostarjetasAsignar.setnombre_mes(pagostarjetas.getnombre_mes());	
		pagostarjetasAsignar.setnumero(pagostarjetas.getnumero());	
		pagostarjetasAsignar.setlote(pagostarjetas.getlote());	
		pagostarjetasAsignar.setvalor(pagostarjetas.getvalor());	
		pagostarjetasAsignar.setvalor_retencion(pagostarjetas.getvalor_retencion());	
		pagostarjetasAsignar.setvalor_comision(pagostarjetas.getvalor_comision());	
		pagostarjetasAsignar.setvalor_calculado(pagostarjetas.getvalor_calculado());	
		pagostarjetasAsignar.setvalor_cancelado(pagostarjetas.getvalor_cancelado());	
		pagostarjetasAsignar.setvalor_difiere(pagostarjetas.getvalor_difiere());	
		pagostarjetasAsignar.setnumero_retencion(pagostarjetas.getnumero_retencion());	
		pagostarjetasAsignar.setnumero_liquidacion(pagostarjetas.getnumero_liquidacion());	
		pagostarjetasAsignar.setfecha(pagostarjetas.getfecha());	
	}
	
	public static void inicializarPagosTarjetas(PagosTarjetas pagostarjetas) throws Exception {
		try {
				pagostarjetas.setId(0L);	
					
				pagostarjetas.setcodigo_asiento_contable("");	
				pagostarjetas.setcodigo_tarjeta_credito("");	
				pagostarjetas.setnombre_tipo_interes_tarjeta("");	
				pagostarjetas.setnombre_conexion("");	
				pagostarjetas.setnombre_mes("");	
				pagostarjetas.setnumero("");	
				pagostarjetas.setlote("");	
				pagostarjetas.setvalor(0.0);	
				pagostarjetas.setvalor_retencion(0.0);	
				pagostarjetas.setvalor_comision(0.0);	
				pagostarjetas.setvalor_calculado(0.0);	
				pagostarjetas.setvalor_cancelado(0.0);	
				pagostarjetas.setvalor_difiere(0.0);	
				pagostarjetas.setnumero_retencion("");	
				pagostarjetas.setnumero_liquidacion("");	
				pagostarjetas.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPagosTarjetas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_CODIGOTARJETACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_NOMBRETIPOINTERESTARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_NOMBRECONEXION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_NOMBREMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_VALORRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_VALORCOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_VALORCALCULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_VALORCANCELADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_VALORDIFIERE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_NUMEROLIQUIDACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosTarjetasConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPagosTarjetas(String sTipo,Row row,Workbook workbook,PagosTarjetas pagostarjetas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getcodigo_asiento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getcodigo_tarjeta_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getnombre_tipo_interes_tarjeta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getnombre_conexion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getnombre_mes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getvalor_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getvalor_comision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getvalor_calculado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getvalor_cancelado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getvalor_difiere());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getnumero_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagostarjetas.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPagosTarjetas="";
	
	public String getsFinalQueryPagosTarjetas() {
		return this.sFinalQueryPagosTarjetas;
	}
	
	public void setsFinalQueryPagosTarjetas(String sFinalQueryPagosTarjetas) {
		this.sFinalQueryPagosTarjetas= sFinalQueryPagosTarjetas;
	}
	
	public Border resaltarSeleccionarPagosTarjetas=null;
	
	public Border setResaltarSeleccionarPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPagosTarjetas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPagosTarjetas() {
		return this.resaltarSeleccionarPagosTarjetas;
	}
	
	public void setResaltarSeleccionarPagosTarjetas(Border borderResaltarSeleccionarPagosTarjetas) {
		this.resaltarSeleccionarPagosTarjetas= borderResaltarSeleccionarPagosTarjetas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPagosTarjetas=null;
	public Boolean mostraridPagosTarjetas=true;
	public Boolean activaridPagosTarjetas=true;

	public Border resaltarid_empresaPagosTarjetas=null;
	public Boolean mostrarid_empresaPagosTarjetas=true;
	public Boolean activarid_empresaPagosTarjetas=true;
	public Boolean cargarid_empresaPagosTarjetas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPagosTarjetas=false;//ConEventDepend=true

	public Border resaltarfecha_hastaPagosTarjetas=null;
	public Boolean mostrarfecha_hastaPagosTarjetas=true;
	public Boolean activarfecha_hastaPagosTarjetas=true;

	public Border resaltarcodigo_asiento_contablePagosTarjetas=null;
	public Boolean mostrarcodigo_asiento_contablePagosTarjetas=true;
	public Boolean activarcodigo_asiento_contablePagosTarjetas=true;

	public Border resaltarcodigo_tarjeta_creditoPagosTarjetas=null;
	public Boolean mostrarcodigo_tarjeta_creditoPagosTarjetas=true;
	public Boolean activarcodigo_tarjeta_creditoPagosTarjetas=true;

	public Border resaltarnombre_tipo_interes_tarjetaPagosTarjetas=null;
	public Boolean mostrarnombre_tipo_interes_tarjetaPagosTarjetas=true;
	public Boolean activarnombre_tipo_interes_tarjetaPagosTarjetas=true;

	public Border resaltarnombre_conexionPagosTarjetas=null;
	public Boolean mostrarnombre_conexionPagosTarjetas=true;
	public Boolean activarnombre_conexionPagosTarjetas=true;

	public Border resaltarnombre_mesPagosTarjetas=null;
	public Boolean mostrarnombre_mesPagosTarjetas=true;
	public Boolean activarnombre_mesPagosTarjetas=true;

	public Border resaltarnumeroPagosTarjetas=null;
	public Boolean mostrarnumeroPagosTarjetas=true;
	public Boolean activarnumeroPagosTarjetas=true;

	public Border resaltarlotePagosTarjetas=null;
	public Boolean mostrarlotePagosTarjetas=true;
	public Boolean activarlotePagosTarjetas=true;

	public Border resaltarvalorPagosTarjetas=null;
	public Boolean mostrarvalorPagosTarjetas=true;
	public Boolean activarvalorPagosTarjetas=true;

	public Border resaltarvalor_retencionPagosTarjetas=null;
	public Boolean mostrarvalor_retencionPagosTarjetas=true;
	public Boolean activarvalor_retencionPagosTarjetas=true;

	public Border resaltarvalor_comisionPagosTarjetas=null;
	public Boolean mostrarvalor_comisionPagosTarjetas=true;
	public Boolean activarvalor_comisionPagosTarjetas=true;

	public Border resaltarvalor_calculadoPagosTarjetas=null;
	public Boolean mostrarvalor_calculadoPagosTarjetas=true;
	public Boolean activarvalor_calculadoPagosTarjetas=true;

	public Border resaltarvalor_canceladoPagosTarjetas=null;
	public Boolean mostrarvalor_canceladoPagosTarjetas=true;
	public Boolean activarvalor_canceladoPagosTarjetas=true;

	public Border resaltarvalor_difierePagosTarjetas=null;
	public Boolean mostrarvalor_difierePagosTarjetas=true;
	public Boolean activarvalor_difierePagosTarjetas=true;

	public Border resaltarnumero_retencionPagosTarjetas=null;
	public Boolean mostrarnumero_retencionPagosTarjetas=true;
	public Boolean activarnumero_retencionPagosTarjetas=true;

	public Border resaltarnumero_liquidacionPagosTarjetas=null;
	public Boolean mostrarnumero_liquidacionPagosTarjetas=true;
	public Boolean activarnumero_liquidacionPagosTarjetas=true;

	public Border resaltarfechaPagosTarjetas=null;
	public Boolean mostrarfechaPagosTarjetas=true;
	public Boolean activarfechaPagosTarjetas=true;

	
	

	public Border setResaltaridPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltaridPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPagosTarjetas() {
		return this.resaltaridPagosTarjetas;
	}

	public void setResaltaridPagosTarjetas(Border borderResaltar) {
		this.resaltaridPagosTarjetas= borderResaltar;
	}

	public Boolean getMostraridPagosTarjetas() {
		return this.mostraridPagosTarjetas;
	}

	public void setMostraridPagosTarjetas(Boolean mostraridPagosTarjetas) {
		this.mostraridPagosTarjetas= mostraridPagosTarjetas;
	}

	public Boolean getActivaridPagosTarjetas() {
		return this.activaridPagosTarjetas;
	}

	public void setActivaridPagosTarjetas(Boolean activaridPagosTarjetas) {
		this.activaridPagosTarjetas= activaridPagosTarjetas;
	}

	public Border setResaltarid_empresaPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarid_empresaPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPagosTarjetas() {
		return this.resaltarid_empresaPagosTarjetas;
	}

	public void setResaltarid_empresaPagosTarjetas(Border borderResaltar) {
		this.resaltarid_empresaPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarid_empresaPagosTarjetas() {
		return this.mostrarid_empresaPagosTarjetas;
	}

	public void setMostrarid_empresaPagosTarjetas(Boolean mostrarid_empresaPagosTarjetas) {
		this.mostrarid_empresaPagosTarjetas= mostrarid_empresaPagosTarjetas;
	}

	public Boolean getActivarid_empresaPagosTarjetas() {
		return this.activarid_empresaPagosTarjetas;
	}

	public void setActivarid_empresaPagosTarjetas(Boolean activarid_empresaPagosTarjetas) {
		this.activarid_empresaPagosTarjetas= activarid_empresaPagosTarjetas;
	}

	public Boolean getCargarid_empresaPagosTarjetas() {
		return this.cargarid_empresaPagosTarjetas;
	}

	public void setCargarid_empresaPagosTarjetas(Boolean cargarid_empresaPagosTarjetas) {
		this.cargarid_empresaPagosTarjetas= cargarid_empresaPagosTarjetas;
	}

	public Border setResaltarfecha_hastaPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaPagosTarjetas() {
		return this.resaltarfecha_hastaPagosTarjetas;
	}

	public void setResaltarfecha_hastaPagosTarjetas(Border borderResaltar) {
		this.resaltarfecha_hastaPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaPagosTarjetas() {
		return this.mostrarfecha_hastaPagosTarjetas;
	}

	public void setMostrarfecha_hastaPagosTarjetas(Boolean mostrarfecha_hastaPagosTarjetas) {
		this.mostrarfecha_hastaPagosTarjetas= mostrarfecha_hastaPagosTarjetas;
	}

	public Boolean getActivarfecha_hastaPagosTarjetas() {
		return this.activarfecha_hastaPagosTarjetas;
	}

	public void setActivarfecha_hastaPagosTarjetas(Boolean activarfecha_hastaPagosTarjetas) {
		this.activarfecha_hastaPagosTarjetas= activarfecha_hastaPagosTarjetas;
	}

	public Border setResaltarcodigo_asiento_contablePagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarcodigo_asiento_contablePagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asiento_contablePagosTarjetas() {
		return this.resaltarcodigo_asiento_contablePagosTarjetas;
	}

	public void setResaltarcodigo_asiento_contablePagosTarjetas(Border borderResaltar) {
		this.resaltarcodigo_asiento_contablePagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarcodigo_asiento_contablePagosTarjetas() {
		return this.mostrarcodigo_asiento_contablePagosTarjetas;
	}

	public void setMostrarcodigo_asiento_contablePagosTarjetas(Boolean mostrarcodigo_asiento_contablePagosTarjetas) {
		this.mostrarcodigo_asiento_contablePagosTarjetas= mostrarcodigo_asiento_contablePagosTarjetas;
	}

	public Boolean getActivarcodigo_asiento_contablePagosTarjetas() {
		return this.activarcodigo_asiento_contablePagosTarjetas;
	}

	public void setActivarcodigo_asiento_contablePagosTarjetas(Boolean activarcodigo_asiento_contablePagosTarjetas) {
		this.activarcodigo_asiento_contablePagosTarjetas= activarcodigo_asiento_contablePagosTarjetas;
	}

	public Border setResaltarcodigo_tarjeta_creditoPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarcodigo_tarjeta_creditoPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tarjeta_creditoPagosTarjetas() {
		return this.resaltarcodigo_tarjeta_creditoPagosTarjetas;
	}

	public void setResaltarcodigo_tarjeta_creditoPagosTarjetas(Border borderResaltar) {
		this.resaltarcodigo_tarjeta_creditoPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarcodigo_tarjeta_creditoPagosTarjetas() {
		return this.mostrarcodigo_tarjeta_creditoPagosTarjetas;
	}

	public void setMostrarcodigo_tarjeta_creditoPagosTarjetas(Boolean mostrarcodigo_tarjeta_creditoPagosTarjetas) {
		this.mostrarcodigo_tarjeta_creditoPagosTarjetas= mostrarcodigo_tarjeta_creditoPagosTarjetas;
	}

	public Boolean getActivarcodigo_tarjeta_creditoPagosTarjetas() {
		return this.activarcodigo_tarjeta_creditoPagosTarjetas;
	}

	public void setActivarcodigo_tarjeta_creditoPagosTarjetas(Boolean activarcodigo_tarjeta_creditoPagosTarjetas) {
		this.activarcodigo_tarjeta_creditoPagosTarjetas= activarcodigo_tarjeta_creditoPagosTarjetas;
	}

	public Border setResaltarnombre_tipo_interes_tarjetaPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_interes_tarjetaPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_interes_tarjetaPagosTarjetas() {
		return this.resaltarnombre_tipo_interes_tarjetaPagosTarjetas;
	}

	public void setResaltarnombre_tipo_interes_tarjetaPagosTarjetas(Border borderResaltar) {
		this.resaltarnombre_tipo_interes_tarjetaPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_interes_tarjetaPagosTarjetas() {
		return this.mostrarnombre_tipo_interes_tarjetaPagosTarjetas;
	}

	public void setMostrarnombre_tipo_interes_tarjetaPagosTarjetas(Boolean mostrarnombre_tipo_interes_tarjetaPagosTarjetas) {
		this.mostrarnombre_tipo_interes_tarjetaPagosTarjetas= mostrarnombre_tipo_interes_tarjetaPagosTarjetas;
	}

	public Boolean getActivarnombre_tipo_interes_tarjetaPagosTarjetas() {
		return this.activarnombre_tipo_interes_tarjetaPagosTarjetas;
	}

	public void setActivarnombre_tipo_interes_tarjetaPagosTarjetas(Boolean activarnombre_tipo_interes_tarjetaPagosTarjetas) {
		this.activarnombre_tipo_interes_tarjetaPagosTarjetas= activarnombre_tipo_interes_tarjetaPagosTarjetas;
	}

	public Border setResaltarnombre_conexionPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarnombre_conexionPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_conexionPagosTarjetas() {
		return this.resaltarnombre_conexionPagosTarjetas;
	}

	public void setResaltarnombre_conexionPagosTarjetas(Border borderResaltar) {
		this.resaltarnombre_conexionPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarnombre_conexionPagosTarjetas() {
		return this.mostrarnombre_conexionPagosTarjetas;
	}

	public void setMostrarnombre_conexionPagosTarjetas(Boolean mostrarnombre_conexionPagosTarjetas) {
		this.mostrarnombre_conexionPagosTarjetas= mostrarnombre_conexionPagosTarjetas;
	}

	public Boolean getActivarnombre_conexionPagosTarjetas() {
		return this.activarnombre_conexionPagosTarjetas;
	}

	public void setActivarnombre_conexionPagosTarjetas(Boolean activarnombre_conexionPagosTarjetas) {
		this.activarnombre_conexionPagosTarjetas= activarnombre_conexionPagosTarjetas;
	}

	public Border setResaltarnombre_mesPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarnombre_mesPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_mesPagosTarjetas() {
		return this.resaltarnombre_mesPagosTarjetas;
	}

	public void setResaltarnombre_mesPagosTarjetas(Border borderResaltar) {
		this.resaltarnombre_mesPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarnombre_mesPagosTarjetas() {
		return this.mostrarnombre_mesPagosTarjetas;
	}

	public void setMostrarnombre_mesPagosTarjetas(Boolean mostrarnombre_mesPagosTarjetas) {
		this.mostrarnombre_mesPagosTarjetas= mostrarnombre_mesPagosTarjetas;
	}

	public Boolean getActivarnombre_mesPagosTarjetas() {
		return this.activarnombre_mesPagosTarjetas;
	}

	public void setActivarnombre_mesPagosTarjetas(Boolean activarnombre_mesPagosTarjetas) {
		this.activarnombre_mesPagosTarjetas= activarnombre_mesPagosTarjetas;
	}

	public Border setResaltarnumeroPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarnumeroPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroPagosTarjetas() {
		return this.resaltarnumeroPagosTarjetas;
	}

	public void setResaltarnumeroPagosTarjetas(Border borderResaltar) {
		this.resaltarnumeroPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarnumeroPagosTarjetas() {
		return this.mostrarnumeroPagosTarjetas;
	}

	public void setMostrarnumeroPagosTarjetas(Boolean mostrarnumeroPagosTarjetas) {
		this.mostrarnumeroPagosTarjetas= mostrarnumeroPagosTarjetas;
	}

	public Boolean getActivarnumeroPagosTarjetas() {
		return this.activarnumeroPagosTarjetas;
	}

	public void setActivarnumeroPagosTarjetas(Boolean activarnumeroPagosTarjetas) {
		this.activarnumeroPagosTarjetas= activarnumeroPagosTarjetas;
	}

	public Border setResaltarlotePagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarlotePagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlotePagosTarjetas() {
		return this.resaltarlotePagosTarjetas;
	}

	public void setResaltarlotePagosTarjetas(Border borderResaltar) {
		this.resaltarlotePagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarlotePagosTarjetas() {
		return this.mostrarlotePagosTarjetas;
	}

	public void setMostrarlotePagosTarjetas(Boolean mostrarlotePagosTarjetas) {
		this.mostrarlotePagosTarjetas= mostrarlotePagosTarjetas;
	}

	public Boolean getActivarlotePagosTarjetas() {
		return this.activarlotePagosTarjetas;
	}

	public void setActivarlotePagosTarjetas(Boolean activarlotePagosTarjetas) {
		this.activarlotePagosTarjetas= activarlotePagosTarjetas;
	}

	public Border setResaltarvalorPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarvalorPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPagosTarjetas() {
		return this.resaltarvalorPagosTarjetas;
	}

	public void setResaltarvalorPagosTarjetas(Border borderResaltar) {
		this.resaltarvalorPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarvalorPagosTarjetas() {
		return this.mostrarvalorPagosTarjetas;
	}

	public void setMostrarvalorPagosTarjetas(Boolean mostrarvalorPagosTarjetas) {
		this.mostrarvalorPagosTarjetas= mostrarvalorPagosTarjetas;
	}

	public Boolean getActivarvalorPagosTarjetas() {
		return this.activarvalorPagosTarjetas;
	}

	public void setActivarvalorPagosTarjetas(Boolean activarvalorPagosTarjetas) {
		this.activarvalorPagosTarjetas= activarvalorPagosTarjetas;
	}

	public Border setResaltarvalor_retencionPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarvalor_retencionPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_retencionPagosTarjetas() {
		return this.resaltarvalor_retencionPagosTarjetas;
	}

	public void setResaltarvalor_retencionPagosTarjetas(Border borderResaltar) {
		this.resaltarvalor_retencionPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarvalor_retencionPagosTarjetas() {
		return this.mostrarvalor_retencionPagosTarjetas;
	}

	public void setMostrarvalor_retencionPagosTarjetas(Boolean mostrarvalor_retencionPagosTarjetas) {
		this.mostrarvalor_retencionPagosTarjetas= mostrarvalor_retencionPagosTarjetas;
	}

	public Boolean getActivarvalor_retencionPagosTarjetas() {
		return this.activarvalor_retencionPagosTarjetas;
	}

	public void setActivarvalor_retencionPagosTarjetas(Boolean activarvalor_retencionPagosTarjetas) {
		this.activarvalor_retencionPagosTarjetas= activarvalor_retencionPagosTarjetas;
	}

	public Border setResaltarvalor_comisionPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarvalor_comisionPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_comisionPagosTarjetas() {
		return this.resaltarvalor_comisionPagosTarjetas;
	}

	public void setResaltarvalor_comisionPagosTarjetas(Border borderResaltar) {
		this.resaltarvalor_comisionPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarvalor_comisionPagosTarjetas() {
		return this.mostrarvalor_comisionPagosTarjetas;
	}

	public void setMostrarvalor_comisionPagosTarjetas(Boolean mostrarvalor_comisionPagosTarjetas) {
		this.mostrarvalor_comisionPagosTarjetas= mostrarvalor_comisionPagosTarjetas;
	}

	public Boolean getActivarvalor_comisionPagosTarjetas() {
		return this.activarvalor_comisionPagosTarjetas;
	}

	public void setActivarvalor_comisionPagosTarjetas(Boolean activarvalor_comisionPagosTarjetas) {
		this.activarvalor_comisionPagosTarjetas= activarvalor_comisionPagosTarjetas;
	}

	public Border setResaltarvalor_calculadoPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarvalor_calculadoPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_calculadoPagosTarjetas() {
		return this.resaltarvalor_calculadoPagosTarjetas;
	}

	public void setResaltarvalor_calculadoPagosTarjetas(Border borderResaltar) {
		this.resaltarvalor_calculadoPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarvalor_calculadoPagosTarjetas() {
		return this.mostrarvalor_calculadoPagosTarjetas;
	}

	public void setMostrarvalor_calculadoPagosTarjetas(Boolean mostrarvalor_calculadoPagosTarjetas) {
		this.mostrarvalor_calculadoPagosTarjetas= mostrarvalor_calculadoPagosTarjetas;
	}

	public Boolean getActivarvalor_calculadoPagosTarjetas() {
		return this.activarvalor_calculadoPagosTarjetas;
	}

	public void setActivarvalor_calculadoPagosTarjetas(Boolean activarvalor_calculadoPagosTarjetas) {
		this.activarvalor_calculadoPagosTarjetas= activarvalor_calculadoPagosTarjetas;
	}

	public Border setResaltarvalor_canceladoPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarvalor_canceladoPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_canceladoPagosTarjetas() {
		return this.resaltarvalor_canceladoPagosTarjetas;
	}

	public void setResaltarvalor_canceladoPagosTarjetas(Border borderResaltar) {
		this.resaltarvalor_canceladoPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarvalor_canceladoPagosTarjetas() {
		return this.mostrarvalor_canceladoPagosTarjetas;
	}

	public void setMostrarvalor_canceladoPagosTarjetas(Boolean mostrarvalor_canceladoPagosTarjetas) {
		this.mostrarvalor_canceladoPagosTarjetas= mostrarvalor_canceladoPagosTarjetas;
	}

	public Boolean getActivarvalor_canceladoPagosTarjetas() {
		return this.activarvalor_canceladoPagosTarjetas;
	}

	public void setActivarvalor_canceladoPagosTarjetas(Boolean activarvalor_canceladoPagosTarjetas) {
		this.activarvalor_canceladoPagosTarjetas= activarvalor_canceladoPagosTarjetas;
	}

	public Border setResaltarvalor_difierePagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarvalor_difierePagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_difierePagosTarjetas() {
		return this.resaltarvalor_difierePagosTarjetas;
	}

	public void setResaltarvalor_difierePagosTarjetas(Border borderResaltar) {
		this.resaltarvalor_difierePagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarvalor_difierePagosTarjetas() {
		return this.mostrarvalor_difierePagosTarjetas;
	}

	public void setMostrarvalor_difierePagosTarjetas(Boolean mostrarvalor_difierePagosTarjetas) {
		this.mostrarvalor_difierePagosTarjetas= mostrarvalor_difierePagosTarjetas;
	}

	public Boolean getActivarvalor_difierePagosTarjetas() {
		return this.activarvalor_difierePagosTarjetas;
	}

	public void setActivarvalor_difierePagosTarjetas(Boolean activarvalor_difierePagosTarjetas) {
		this.activarvalor_difierePagosTarjetas= activarvalor_difierePagosTarjetas;
	}

	public Border setResaltarnumero_retencionPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionPagosTarjetas() {
		return this.resaltarnumero_retencionPagosTarjetas;
	}

	public void setResaltarnumero_retencionPagosTarjetas(Border borderResaltar) {
		this.resaltarnumero_retencionPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionPagosTarjetas() {
		return this.mostrarnumero_retencionPagosTarjetas;
	}

	public void setMostrarnumero_retencionPagosTarjetas(Boolean mostrarnumero_retencionPagosTarjetas) {
		this.mostrarnumero_retencionPagosTarjetas= mostrarnumero_retencionPagosTarjetas;
	}

	public Boolean getActivarnumero_retencionPagosTarjetas() {
		return this.activarnumero_retencionPagosTarjetas;
	}

	public void setActivarnumero_retencionPagosTarjetas(Boolean activarnumero_retencionPagosTarjetas) {
		this.activarnumero_retencionPagosTarjetas= activarnumero_retencionPagosTarjetas;
	}

	public Border setResaltarnumero_liquidacionPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarnumero_liquidacionPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_liquidacionPagosTarjetas() {
		return this.resaltarnumero_liquidacionPagosTarjetas;
	}

	public void setResaltarnumero_liquidacionPagosTarjetas(Border borderResaltar) {
		this.resaltarnumero_liquidacionPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarnumero_liquidacionPagosTarjetas() {
		return this.mostrarnumero_liquidacionPagosTarjetas;
	}

	public void setMostrarnumero_liquidacionPagosTarjetas(Boolean mostrarnumero_liquidacionPagosTarjetas) {
		this.mostrarnumero_liquidacionPagosTarjetas= mostrarnumero_liquidacionPagosTarjetas;
	}

	public Boolean getActivarnumero_liquidacionPagosTarjetas() {
		return this.activarnumero_liquidacionPagosTarjetas;
	}

	public void setActivarnumero_liquidacionPagosTarjetas(Boolean activarnumero_liquidacionPagosTarjetas) {
		this.activarnumero_liquidacionPagosTarjetas= activarnumero_liquidacionPagosTarjetas;
	}

	public Border setResaltarfechaPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagostarjetasBeanSwingJInternalFrame.jTtoolBarPagosTarjetas.setBorder(borderResaltar);
		
		this.resaltarfechaPagosTarjetas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPagosTarjetas() {
		return this.resaltarfechaPagosTarjetas;
	}

	public void setResaltarfechaPagosTarjetas(Border borderResaltar) {
		this.resaltarfechaPagosTarjetas= borderResaltar;
	}

	public Boolean getMostrarfechaPagosTarjetas() {
		return this.mostrarfechaPagosTarjetas;
	}

	public void setMostrarfechaPagosTarjetas(Boolean mostrarfechaPagosTarjetas) {
		this.mostrarfechaPagosTarjetas= mostrarfechaPagosTarjetas;
	}

	public Boolean getActivarfechaPagosTarjetas() {
		return this.activarfechaPagosTarjetas;
	}

	public void setActivarfechaPagosTarjetas(Boolean activarfechaPagosTarjetas) {
		this.activarfechaPagosTarjetas= activarfechaPagosTarjetas;
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
		
		
		this.setMostraridPagosTarjetas(esInicial);
		this.setMostrarid_empresaPagosTarjetas(esInicial);
		this.setMostrarfecha_hastaPagosTarjetas(esInicial);
		this.setMostrarcodigo_asiento_contablePagosTarjetas(esInicial);
		this.setMostrarcodigo_tarjeta_creditoPagosTarjetas(esInicial);
		this.setMostrarnombre_tipo_interes_tarjetaPagosTarjetas(esInicial);
		this.setMostrarnombre_conexionPagosTarjetas(esInicial);
		this.setMostrarnombre_mesPagosTarjetas(esInicial);
		this.setMostrarnumeroPagosTarjetas(esInicial);
		this.setMostrarlotePagosTarjetas(esInicial);
		this.setMostrarvalorPagosTarjetas(esInicial);
		this.setMostrarvalor_retencionPagosTarjetas(esInicial);
		this.setMostrarvalor_comisionPagosTarjetas(esInicial);
		this.setMostrarvalor_calculadoPagosTarjetas(esInicial);
		this.setMostrarvalor_canceladoPagosTarjetas(esInicial);
		this.setMostrarvalor_difierePagosTarjetas(esInicial);
		this.setMostrarnumero_retencionPagosTarjetas(esInicial);
		this.setMostrarnumero_liquidacionPagosTarjetas(esInicial);
		this.setMostrarfechaPagosTarjetas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.ID)) {
				this.setMostraridPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setMostrarcodigo_asiento_contablePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO)) {
				this.setMostrarcodigo_tarjeta_creditoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA)) {
				this.setMostrarnombre_tipo_interes_tarjetaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBRECONEXION)) {
				this.setMostrarnombre_conexionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBREMES)) {
				this.setMostrarnombre_mesPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.LOTE)) {
				this.setMostrarlotePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALOR)) {
				this.setMostrarvalorPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORRETENCION)) {
				this.setMostrarvalor_retencionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCOMISION)) {
				this.setMostrarvalor_comisionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCALCULADO)) {
				this.setMostrarvalor_calculadoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCANCELADO)) {
				this.setMostrarvalor_canceladoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORDIFIERE)) {
				this.setMostrarvalor_difierePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION)) {
				this.setMostrarnumero_liquidacionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.FECHA)) {
				this.setMostrarfechaPagosTarjetas(esAsigna);
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
		
		
		this.setActivaridPagosTarjetas(esInicial);
		this.setActivarid_empresaPagosTarjetas(esInicial);
		this.setActivarfecha_hastaPagosTarjetas(esInicial);
		this.setActivarcodigo_asiento_contablePagosTarjetas(esInicial);
		this.setActivarcodigo_tarjeta_creditoPagosTarjetas(esInicial);
		this.setActivarnombre_tipo_interes_tarjetaPagosTarjetas(esInicial);
		this.setActivarnombre_conexionPagosTarjetas(esInicial);
		this.setActivarnombre_mesPagosTarjetas(esInicial);
		this.setActivarnumeroPagosTarjetas(esInicial);
		this.setActivarlotePagosTarjetas(esInicial);
		this.setActivarvalorPagosTarjetas(esInicial);
		this.setActivarvalor_retencionPagosTarjetas(esInicial);
		this.setActivarvalor_comisionPagosTarjetas(esInicial);
		this.setActivarvalor_calculadoPagosTarjetas(esInicial);
		this.setActivarvalor_canceladoPagosTarjetas(esInicial);
		this.setActivarvalor_difierePagosTarjetas(esInicial);
		this.setActivarnumero_retencionPagosTarjetas(esInicial);
		this.setActivarnumero_liquidacionPagosTarjetas(esInicial);
		this.setActivarfechaPagosTarjetas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.ID)) {
				this.setActivaridPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setActivarcodigo_asiento_contablePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO)) {
				this.setActivarcodigo_tarjeta_creditoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA)) {
				this.setActivarnombre_tipo_interes_tarjetaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBRECONEXION)) {
				this.setActivarnombre_conexionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBREMES)) {
				this.setActivarnombre_mesPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMERO)) {
				this.setActivarnumeroPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.LOTE)) {
				this.setActivarlotePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALOR)) {
				this.setActivarvalorPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORRETENCION)) {
				this.setActivarvalor_retencionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCOMISION)) {
				this.setActivarvalor_comisionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCALCULADO)) {
				this.setActivarvalor_calculadoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCANCELADO)) {
				this.setActivarvalor_canceladoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORDIFIERE)) {
				this.setActivarvalor_difierePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION)) {
				this.setActivarnumero_liquidacionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.FECHA)) {
				this.setActivarfechaPagosTarjetas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPagosTarjetas(esInicial);
		this.setResaltarid_empresaPagosTarjetas(esInicial);
		this.setResaltarfecha_hastaPagosTarjetas(esInicial);
		this.setResaltarcodigo_asiento_contablePagosTarjetas(esInicial);
		this.setResaltarcodigo_tarjeta_creditoPagosTarjetas(esInicial);
		this.setResaltarnombre_tipo_interes_tarjetaPagosTarjetas(esInicial);
		this.setResaltarnombre_conexionPagosTarjetas(esInicial);
		this.setResaltarnombre_mesPagosTarjetas(esInicial);
		this.setResaltarnumeroPagosTarjetas(esInicial);
		this.setResaltarlotePagosTarjetas(esInicial);
		this.setResaltarvalorPagosTarjetas(esInicial);
		this.setResaltarvalor_retencionPagosTarjetas(esInicial);
		this.setResaltarvalor_comisionPagosTarjetas(esInicial);
		this.setResaltarvalor_calculadoPagosTarjetas(esInicial);
		this.setResaltarvalor_canceladoPagosTarjetas(esInicial);
		this.setResaltarvalor_difierePagosTarjetas(esInicial);
		this.setResaltarnumero_retencionPagosTarjetas(esInicial);
		this.setResaltarnumero_liquidacionPagosTarjetas(esInicial);
		this.setResaltarfechaPagosTarjetas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.ID)) {
				this.setResaltaridPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setResaltarcodigo_asiento_contablePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.CODIGOTARJETACREDITO)) {
				this.setResaltarcodigo_tarjeta_creditoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBRETIPOINTERESTARJETA)) {
				this.setResaltarnombre_tipo_interes_tarjetaPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBRECONEXION)) {
				this.setResaltarnombre_conexionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NOMBREMES)) {
				this.setResaltarnombre_mesPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.LOTE)) {
				this.setResaltarlotePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALOR)) {
				this.setResaltarvalorPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORRETENCION)) {
				this.setResaltarvalor_retencionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCOMISION)) {
				this.setResaltarvalor_comisionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCALCULADO)) {
				this.setResaltarvalor_calculadoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORCANCELADO)) {
				this.setResaltarvalor_canceladoPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.VALORDIFIERE)) {
				this.setResaltarvalor_difierePagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.NUMEROLIQUIDACION)) {
				this.setResaltarnumero_liquidacionPagosTarjetas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosTarjetasConstantesFunciones.FECHA)) {
				this.setResaltarfechaPagosTarjetas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPagosTarjetasPagosTarjetas=true;

	public Boolean getMostrarBusquedaPagosTarjetasPagosTarjetas() {
		return this.mostrarBusquedaPagosTarjetasPagosTarjetas;
	}

	public void setMostrarBusquedaPagosTarjetasPagosTarjetas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPagosTarjetasPagosTarjetas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPagosTarjetasPagosTarjetas=true;

	public Boolean getActivarBusquedaPagosTarjetasPagosTarjetas() {
		return this.activarBusquedaPagosTarjetasPagosTarjetas;
	}

	public void setActivarBusquedaPagosTarjetasPagosTarjetas(Boolean habilitarResaltar) {
		this.activarBusquedaPagosTarjetasPagosTarjetas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPagosTarjetasPagosTarjetas=null;

	public Border getResaltarBusquedaPagosTarjetasPagosTarjetas() {
		return this.resaltarBusquedaPagosTarjetasPagosTarjetas;
	}

	public void setResaltarBusquedaPagosTarjetasPagosTarjetas(Border borderResaltar) {
		this.resaltarBusquedaPagosTarjetasPagosTarjetas= borderResaltar;
	}

	public void setResaltarBusquedaPagosTarjetasPagosTarjetas(ParametroGeneralUsuario parametroGeneralUsuario/*PagosTarjetasBeanSwingJInternalFrame pagostarjetasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPagosTarjetasPagosTarjetas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}