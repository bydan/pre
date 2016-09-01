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


import com.bydan.erp.puntoventa.util.report.ComprobanteTarjetaConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.ComprobanteTarjetaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteTarjetaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComprobanteTarjetaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ComprobanteTarjeta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComprobanteTarjeta"+ComprobanteTarjetaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComprobanteTarjetaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComprobanteTarjetaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComprobanteTarjetaConstantesFunciones.SCHEMA+"_"+ComprobanteTarjetaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComprobanteTarjetaConstantesFunciones.SCHEMA+"_"+ComprobanteTarjetaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComprobanteTarjetaConstantesFunciones.SCHEMA+"_"+ComprobanteTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComprobanteTarjetaConstantesFunciones.SCHEMA+"_"+ComprobanteTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteTarjetaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteTarjetaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComprobanteTarjetaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComprobanteTarjetaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComprobanteTarjetaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComprobanteTarjetaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comprobante Tarjetas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comprobante Tarjeta";
	public static final String SCLASSWEBTITULO_LOWER="Comprobante Tarjeta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComprobanteTarjeta";
	public static final String OBJECTNAME="comprobantetarjeta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="comprobante_tarjeta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comprobantetarjeta from "+ComprobanteTarjetaConstantesFunciones.SPERSISTENCENAME+" comprobantetarjeta";
	public static String QUERYSELECTNATIVE="select "+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".id,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".version_row,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".id_empresa,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".id_sucursal,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".id_cliente,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".id_caja,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".fecha_inicio,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".fecha_fin,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".nombre_caja,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".secuencial,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".fecha,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".codigo_cliente,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".nombre_cliente,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".subtotal,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".iva,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".descuento,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".financiamiento,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".flete,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".ice,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".total,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".valor,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".fecha_forma_pago,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".numero,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".tarjeta_habiente,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".autorizacion,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".voucher,"+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME+".lote from "+ComprobanteTarjetaConstantesFunciones.SCHEMA+"."+ComprobanteTarjetaConstantesFunciones.TABLENAME;//+" as "+ComprobanteTarjetaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDCAJA= "id_caja";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NOMBRECAJA= "nombre_caja";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHA= "fecha";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String SUBTOTAL= "subtotal";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String FLETE= "flete";
    public static final String ICE= "ice";
    public static final String TOTAL= "total";
    public static final String VALOR= "valor";
    public static final String FECHAFORMAPAGO= "fecha_forma_pago";
    public static final String NUMERO= "numero";
    public static final String TARJETAHABIENTE= "tarjeta_habiente";
    public static final String AUTORIZACION= "autorizacion";
    public static final String VOUCHER= "voucher";
    public static final String LOTE= "lote";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NOMBRECAJA= "Nombre Caja";
		public static final String LABEL_NOMBRECAJA_LOWER= "Nombre Caja";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHAFORMAPAGO= "Fecha Forma Pago";
		public static final String LABEL_FECHAFORMAPAGO_LOWER= "Fecha Forma Pago";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_TARJETAHABIENTE= "Tarjeta Habiente";
		public static final String LABEL_TARJETAHABIENTE_LOWER= "Tarjeta Habiente";
    	public static final String LABEL_AUTORIZACION= "Autorizacion";
		public static final String LABEL_AUTORIZACION_LOWER= "Autorizacion";
    	public static final String LABEL_VOUCHER= "Voucher";
		public static final String LABEL_VOUCHER_LOWER= "Voucher";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTARJETA_HABIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTARJETA_HABIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXVOUCHER=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXVOUCHER=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComprobanteTarjetaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.IDCLIENTE)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.IDCAJA)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.FECHAINICIO)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.FECHAFIN)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECAJA)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECAJA;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.SECUENCIAL)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.FECHA)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.SUBTOTAL)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.IVA)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.DESCUENTO)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.FLETE)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.ICE)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.TOTAL)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.VALOR)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFORMAPAGO;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.NUMERO)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_TARJETAHABIENTE;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.AUTORIZACION)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_AUTORIZACION;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.VOUCHER)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_VOUCHER;}
		if(sNombreColumna.equals(ComprobanteTarjetaConstantesFunciones.LOTE)) {sLabelColumna=ComprobanteTarjetaConstantesFunciones.LABEL_LOTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComprobanteTarjetaDescripcion(ComprobanteTarjeta comprobantetarjeta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comprobantetarjeta !=null/* && comprobantetarjeta.getId()!=0*/) {
			if(comprobantetarjeta.getId()!=null) {
				sDescripcion=comprobantetarjeta.getId().toString();
			}//comprobantetarjetacomprobantetarjeta.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComprobanteTarjetaDescripcionDetallado(ComprobanteTarjeta comprobantetarjeta) {
		String sDescripcion="";
			
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.ID+"=";
		sDescripcion+=comprobantetarjeta.getId().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comprobantetarjeta.getVersionRow().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comprobantetarjeta.getid_empresa().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=comprobantetarjeta.getid_sucursal().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=comprobantetarjeta.getid_cliente().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=comprobantetarjeta.getid_caja().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=comprobantetarjeta.getfecha_inicio().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=comprobantetarjeta.getfecha_fin().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.NOMBRECAJA+"=";
		sDescripcion+=comprobantetarjeta.getnombre_caja()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=comprobantetarjeta.getsecuencial()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.FECHA+"=";
		sDescripcion+=comprobantetarjeta.getfecha().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=comprobantetarjeta.getcodigo_cliente()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=comprobantetarjeta.getnombre_cliente()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=comprobantetarjeta.getsubtotal().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.IVA+"=";
		sDescripcion+=comprobantetarjeta.getiva().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=comprobantetarjeta.getdescuento().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=comprobantetarjeta.getfinanciamiento().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.FLETE+"=";
		sDescripcion+=comprobantetarjeta.getflete().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.ICE+"=";
		sDescripcion+=comprobantetarjeta.getice().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.TOTAL+"=";
		sDescripcion+=comprobantetarjeta.gettotal().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.VALOR+"=";
		sDescripcion+=comprobantetarjeta.getvalor().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO+"=";
		sDescripcion+=comprobantetarjeta.getfecha_forma_pago().toString()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.NUMERO+"=";
		sDescripcion+=comprobantetarjeta.getnumero()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE+"=";
		sDescripcion+=comprobantetarjeta.gettarjeta_habiente()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.AUTORIZACION+"=";
		sDescripcion+=comprobantetarjeta.getautorizacion()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.VOUCHER+"=";
		sDescripcion+=comprobantetarjeta.getvoucher()+",";
		sDescripcion+=ComprobanteTarjetaConstantesFunciones.LOTE+"=";
		sDescripcion+=comprobantetarjeta.getlote()+",";
			
		return sDescripcion;
	}
	
	public static void setComprobanteTarjetaDescripcion(ComprobanteTarjeta comprobantetarjeta,String sValor) throws Exception {			
		if(comprobantetarjeta !=null) {
			//comprobantetarjetacomprobantetarjeta.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaComprobanteTarjeta")) {
			sNombreIndice="Tipo=  Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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

	public static String getDetalleIndiceBusquedaComprobanteTarjeta(Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosComprobanteTarjeta(ComprobanteTarjeta comprobantetarjeta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantetarjeta.setnombre_caja(comprobantetarjeta.getnombre_caja().trim());
		comprobantetarjeta.setsecuencial(comprobantetarjeta.getsecuencial().trim());
		comprobantetarjeta.setcodigo_cliente(comprobantetarjeta.getcodigo_cliente().trim());
		comprobantetarjeta.setnombre_cliente(comprobantetarjeta.getnombre_cliente().trim());
		comprobantetarjeta.setnumero(comprobantetarjeta.getnumero().trim());
		comprobantetarjeta.settarjeta_habiente(comprobantetarjeta.gettarjeta_habiente().trim());
		comprobantetarjeta.setautorizacion(comprobantetarjeta.getautorizacion().trim());
		comprobantetarjeta.setvoucher(comprobantetarjeta.getvoucher().trim());
		comprobantetarjeta.setlote(comprobantetarjeta.getlote().trim());
	}
	
	public static void quitarEspaciosComprobanteTarjetas(List<ComprobanteTarjeta> comprobantetarjetas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteTarjeta comprobantetarjeta: comprobantetarjetas) {
			comprobantetarjeta.setnombre_caja(comprobantetarjeta.getnombre_caja().trim());
			comprobantetarjeta.setsecuencial(comprobantetarjeta.getsecuencial().trim());
			comprobantetarjeta.setcodigo_cliente(comprobantetarjeta.getcodigo_cliente().trim());
			comprobantetarjeta.setnombre_cliente(comprobantetarjeta.getnombre_cliente().trim());
			comprobantetarjeta.setnumero(comprobantetarjeta.getnumero().trim());
			comprobantetarjeta.settarjeta_habiente(comprobantetarjeta.gettarjeta_habiente().trim());
			comprobantetarjeta.setautorizacion(comprobantetarjeta.getautorizacion().trim());
			comprobantetarjeta.setvoucher(comprobantetarjeta.getvoucher().trim());
			comprobantetarjeta.setlote(comprobantetarjeta.getlote().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteTarjeta(ComprobanteTarjeta comprobantetarjeta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comprobantetarjeta.getConCambioAuxiliar()) {
			comprobantetarjeta.setIsDeleted(comprobantetarjeta.getIsDeletedAuxiliar());	
			comprobantetarjeta.setIsNew(comprobantetarjeta.getIsNewAuxiliar());	
			comprobantetarjeta.setIsChanged(comprobantetarjeta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comprobantetarjeta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comprobantetarjeta.setIsDeletedAuxiliar(false);	
			comprobantetarjeta.setIsNewAuxiliar(false);	
			comprobantetarjeta.setIsChangedAuxiliar(false);
			
			comprobantetarjeta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteTarjetas(List<ComprobanteTarjeta> comprobantetarjetas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComprobanteTarjeta comprobantetarjeta : comprobantetarjetas) {
			if(conAsignarBase && comprobantetarjeta.getConCambioAuxiliar()) {
				comprobantetarjeta.setIsDeleted(comprobantetarjeta.getIsDeletedAuxiliar());	
				comprobantetarjeta.setIsNew(comprobantetarjeta.getIsNewAuxiliar());	
				comprobantetarjeta.setIsChanged(comprobantetarjeta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comprobantetarjeta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comprobantetarjeta.setIsDeletedAuxiliar(false);	
				comprobantetarjeta.setIsNewAuxiliar(false);	
				comprobantetarjeta.setIsChangedAuxiliar(false);
				
				comprobantetarjeta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComprobanteTarjeta(ComprobanteTarjeta comprobantetarjeta,Boolean conEnteros) throws Exception  {
		comprobantetarjeta.setsubtotal(0.0);
		comprobantetarjeta.setiva(0.0);
		comprobantetarjeta.setdescuento(0.0);
		comprobantetarjeta.setfinanciamiento(0.0);
		comprobantetarjeta.setflete(0.0);
		comprobantetarjeta.setice(0.0);
		comprobantetarjeta.settotal(0.0);
		comprobantetarjeta.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComprobanteTarjetas(List<ComprobanteTarjeta> comprobantetarjetas,Boolean conEnteros) throws Exception  {
		
		for(ComprobanteTarjeta comprobantetarjeta: comprobantetarjetas) {
			comprobantetarjeta.setsubtotal(0.0);
			comprobantetarjeta.setiva(0.0);
			comprobantetarjeta.setdescuento(0.0);
			comprobantetarjeta.setfinanciamiento(0.0);
			comprobantetarjeta.setflete(0.0);
			comprobantetarjeta.setice(0.0);
			comprobantetarjeta.settotal(0.0);
			comprobantetarjeta.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComprobanteTarjeta(List<ComprobanteTarjeta> comprobantetarjetas,ComprobanteTarjeta comprobantetarjetaAux) throws Exception  {
		ComprobanteTarjetaConstantesFunciones.InicializarValoresComprobanteTarjeta(comprobantetarjetaAux,true);
		
		for(ComprobanteTarjeta comprobantetarjeta: comprobantetarjetas) {
			if(comprobantetarjeta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comprobantetarjetaAux.setsubtotal(comprobantetarjetaAux.getsubtotal()+comprobantetarjeta.getsubtotal());			
			comprobantetarjetaAux.setiva(comprobantetarjetaAux.getiva()+comprobantetarjeta.getiva());			
			comprobantetarjetaAux.setdescuento(comprobantetarjetaAux.getdescuento()+comprobantetarjeta.getdescuento());			
			comprobantetarjetaAux.setfinanciamiento(comprobantetarjetaAux.getfinanciamiento()+comprobantetarjeta.getfinanciamiento());			
			comprobantetarjetaAux.setflete(comprobantetarjetaAux.getflete()+comprobantetarjeta.getflete());			
			comprobantetarjetaAux.setice(comprobantetarjetaAux.getice()+comprobantetarjeta.getice());			
			comprobantetarjetaAux.settotal(comprobantetarjetaAux.gettotal()+comprobantetarjeta.gettotal());			
			comprobantetarjetaAux.setvalor(comprobantetarjetaAux.getvalor()+comprobantetarjeta.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteTarjeta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComprobanteTarjetaConstantesFunciones.getArrayColumnasGlobalesComprobanteTarjeta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteTarjeta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobanteTarjetaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobanteTarjetaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobanteTarjetaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobanteTarjetaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComprobanteTarjeta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteTarjeta> comprobantetarjetas,ComprobanteTarjeta comprobantetarjeta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteTarjeta comprobantetarjetaAux: comprobantetarjetas) {
			if(comprobantetarjetaAux!=null && comprobantetarjeta!=null) {
				if((comprobantetarjetaAux.getId()==null && comprobantetarjeta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comprobantetarjetaAux.getId()!=null && comprobantetarjeta.getId()!=null){
					if(comprobantetarjetaAux.getId().equals(comprobantetarjeta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteTarjeta(List<ComprobanteTarjeta> comprobantetarjetas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
		Double valorTotal=0.0;
	
		for(ComprobanteTarjeta comprobantetarjeta: comprobantetarjetas) {			
			if(comprobantetarjeta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subtotalTotal+=comprobantetarjeta.getsubtotal();
			ivaTotal+=comprobantetarjeta.getiva();
			descuentoTotal+=comprobantetarjeta.getdescuento();
			financiamientoTotal+=comprobantetarjeta.getfinanciamiento();
			fleteTotal+=comprobantetarjeta.getflete();
			iceTotal+=comprobantetarjeta.getice();
			totalTotal+=comprobantetarjeta.gettotal();
			valorTotal+=comprobantetarjeta.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComprobanteTarjeta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_ID, ComprobanteTarjetaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_VERSIONROW, ComprobanteTarjetaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_IDCLIENTE, ComprobanteTarjetaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_IDCAJA, ComprobanteTarjetaConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECAJA, ComprobanteTarjetaConstantesFunciones.NOMBRECAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_SECUENCIAL, ComprobanteTarjetaConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_FECHA, ComprobanteTarjetaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_CODIGOCLIENTE, ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECLIENTE, ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_SUBTOTAL, ComprobanteTarjetaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_IVA, ComprobanteTarjetaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_DESCUENTO, ComprobanteTarjetaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_FINANCIAMIENTO, ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_FLETE, ComprobanteTarjetaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_ICE, ComprobanteTarjetaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_TOTAL, ComprobanteTarjetaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_VALOR, ComprobanteTarjetaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFORMAPAGO, ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_NUMERO, ComprobanteTarjetaConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_TARJETAHABIENTE, ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_AUTORIZACION, ComprobanteTarjetaConstantesFunciones.AUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_VOUCHER, ComprobanteTarjetaConstantesFunciones.VOUCHER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteTarjetaConstantesFunciones.LABEL_LOTE, ComprobanteTarjetaConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComprobanteTarjeta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.NOMBRECAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.AUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.VOUCHER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteTarjetaConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteTarjeta() throws Exception  {
		return ComprobanteTarjetaConstantesFunciones.getTiposSeleccionarComprobanteTarjeta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteTarjeta(Boolean conFk) throws Exception  {
		return ComprobanteTarjetaConstantesFunciones.getTiposSeleccionarComprobanteTarjeta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteTarjeta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECAJA);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFORMAPAGO);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_TARJETAHABIENTE);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_TARJETAHABIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_AUTORIZACION);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_AUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_VOUCHER);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_VOUCHER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteTarjetaConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComprobanteTarjeta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteTarjeta(ComprobanteTarjeta comprobantetarjetaAux) throws Exception {
		
			comprobantetarjetaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantetarjetaAux.getEmpresa()));
			comprobantetarjetaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantetarjetaAux.getSucursal()));
			comprobantetarjetaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobantetarjetaAux.getCliente()));
			comprobantetarjetaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(comprobantetarjetaAux.getCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteTarjeta(List<ComprobanteTarjeta> comprobantetarjetasTemp) throws Exception {
		for(ComprobanteTarjeta comprobantetarjetaAux:comprobantetarjetasTemp) {
			
			comprobantetarjetaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantetarjetaAux.getEmpresa()));
			comprobantetarjetaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobantetarjetaAux.getSucursal()));
			comprobantetarjetaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobantetarjetaAux.getCliente()));
			comprobantetarjetaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(comprobantetarjetaAux.getCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComprobanteTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Caja.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComprobanteTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteTarjetaConstantesFunciones.getClassesRelationshipsOfComprobanteTarjeta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteTarjeta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteTarjetaConstantesFunciones.getClassesRelationshipsFromStringsOfComprobanteTarjeta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteTarjeta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComprobanteTarjeta comprobantetarjeta,List<ComprobanteTarjeta> comprobantetarjetas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ComprobanteTarjeta comprobantetarjeta,List<ComprobanteTarjeta> comprobantetarjetas) throws Exception {
		try	{			
			for(ComprobanteTarjeta comprobantetarjetaLocal:comprobantetarjetas) {
				if(comprobantetarjetaLocal.getId().equals(comprobantetarjeta.getId())) {
					comprobantetarjetaLocal.setIsSelected(comprobantetarjeta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComprobanteTarjeta(List<ComprobanteTarjeta> comprobantetarjetasAux) throws Exception {
		//this.comprobantetarjetasAux=comprobantetarjetasAux;
		
		for(ComprobanteTarjeta comprobantetarjetaAux:comprobantetarjetasAux) {
			if(comprobantetarjetaAux.getIsChanged()) {
				comprobantetarjetaAux.setIsChanged(false);
			}		
			
			if(comprobantetarjetaAux.getIsNew()) {
				comprobantetarjetaAux.setIsNew(false);
			}	
			
			if(comprobantetarjetaAux.getIsDeleted()) {
				comprobantetarjetaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComprobanteTarjeta(ComprobanteTarjeta comprobantetarjetaAux) throws Exception {
		//this.comprobantetarjetaAux=comprobantetarjetaAux;
		
			if(comprobantetarjetaAux.getIsChanged()) {
				comprobantetarjetaAux.setIsChanged(false);
			}		
			
			if(comprobantetarjetaAux.getIsNew()) {
				comprobantetarjetaAux.setIsNew(false);
			}	
			
			if(comprobantetarjetaAux.getIsDeleted()) {
				comprobantetarjetaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComprobanteTarjeta comprobantetarjetaAsignar,ComprobanteTarjeta comprobantetarjeta) throws Exception {
		comprobantetarjetaAsignar.setId(comprobantetarjeta.getId());	
		comprobantetarjetaAsignar.setVersionRow(comprobantetarjeta.getVersionRow());	
		comprobantetarjetaAsignar.setid_cliente(comprobantetarjeta.getid_cliente());
		comprobantetarjetaAsignar.setcliente_descripcion(comprobantetarjeta.getcliente_descripcion());	
		comprobantetarjetaAsignar.setid_caja(comprobantetarjeta.getid_caja());
		comprobantetarjetaAsignar.setcaja_descripcion(comprobantetarjeta.getcaja_descripcion());	
		comprobantetarjetaAsignar.setnombre_caja(comprobantetarjeta.getnombre_caja());	
		comprobantetarjetaAsignar.setsecuencial(comprobantetarjeta.getsecuencial());	
		comprobantetarjetaAsignar.setfecha(comprobantetarjeta.getfecha());	
		comprobantetarjetaAsignar.setcodigo_cliente(comprobantetarjeta.getcodigo_cliente());	
		comprobantetarjetaAsignar.setnombre_cliente(comprobantetarjeta.getnombre_cliente());	
		comprobantetarjetaAsignar.setsubtotal(comprobantetarjeta.getsubtotal());	
		comprobantetarjetaAsignar.setiva(comprobantetarjeta.getiva());	
		comprobantetarjetaAsignar.setdescuento(comprobantetarjeta.getdescuento());	
		comprobantetarjetaAsignar.setfinanciamiento(comprobantetarjeta.getfinanciamiento());	
		comprobantetarjetaAsignar.setflete(comprobantetarjeta.getflete());	
		comprobantetarjetaAsignar.setice(comprobantetarjeta.getice());	
		comprobantetarjetaAsignar.settotal(comprobantetarjeta.gettotal());	
		comprobantetarjetaAsignar.setvalor(comprobantetarjeta.getvalor());	
		comprobantetarjetaAsignar.setfecha_forma_pago(comprobantetarjeta.getfecha_forma_pago());	
		comprobantetarjetaAsignar.setnumero(comprobantetarjeta.getnumero());	
		comprobantetarjetaAsignar.settarjeta_habiente(comprobantetarjeta.gettarjeta_habiente());	
		comprobantetarjetaAsignar.setautorizacion(comprobantetarjeta.getautorizacion());	
		comprobantetarjetaAsignar.setvoucher(comprobantetarjeta.getvoucher());	
		comprobantetarjetaAsignar.setlote(comprobantetarjeta.getlote());	
	}
	
	public static void inicializarComprobanteTarjeta(ComprobanteTarjeta comprobantetarjeta) throws Exception {
		try {
				comprobantetarjeta.setId(0L);	
					
				comprobantetarjeta.setid_cliente(-1L);	
				comprobantetarjeta.setid_caja(-1L);	
				comprobantetarjeta.setnombre_caja("");	
				comprobantetarjeta.setsecuencial("");	
				comprobantetarjeta.setfecha(new Date());	
				comprobantetarjeta.setcodigo_cliente("");	
				comprobantetarjeta.setnombre_cliente("");	
				comprobantetarjeta.setsubtotal(0.0);	
				comprobantetarjeta.setiva(0.0);	
				comprobantetarjeta.setdescuento(0.0);	
				comprobantetarjeta.setfinanciamiento(0.0);	
				comprobantetarjeta.setflete(0.0);	
				comprobantetarjeta.setice(0.0);	
				comprobantetarjeta.settotal(0.0);	
				comprobantetarjeta.setvalor(0.0);	
				comprobantetarjeta.setfecha_forma_pago(new Date());	
				comprobantetarjeta.setnumero("");	
				comprobantetarjeta.settarjeta_habiente("");	
				comprobantetarjeta.setautorizacion("");	
				comprobantetarjeta.setvoucher("");	
				comprobantetarjeta.setlote("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComprobanteTarjeta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_FECHAFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_TARJETAHABIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_AUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_VOUCHER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteTarjetaConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComprobanteTarjeta(String sTipo,Row row,Workbook workbook,ComprobanteTarjeta comprobantetarjeta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getnombre_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getfecha_forma_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.gettarjeta_habiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getautorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getvoucher());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantetarjeta.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComprobanteTarjeta="";
	
	public String getsFinalQueryComprobanteTarjeta() {
		return this.sFinalQueryComprobanteTarjeta;
	}
	
	public void setsFinalQueryComprobanteTarjeta(String sFinalQueryComprobanteTarjeta) {
		this.sFinalQueryComprobanteTarjeta= sFinalQueryComprobanteTarjeta;
	}
	
	public Border resaltarSeleccionarComprobanteTarjeta=null;
	
	public Border setResaltarSeleccionarComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComprobanteTarjeta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComprobanteTarjeta() {
		return this.resaltarSeleccionarComprobanteTarjeta;
	}
	
	public void setResaltarSeleccionarComprobanteTarjeta(Border borderResaltarSeleccionarComprobanteTarjeta) {
		this.resaltarSeleccionarComprobanteTarjeta= borderResaltarSeleccionarComprobanteTarjeta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComprobanteTarjeta=null;
	public Boolean mostraridComprobanteTarjeta=true;
	public Boolean activaridComprobanteTarjeta=true;

	public Border resaltarid_empresaComprobanteTarjeta=null;
	public Boolean mostrarid_empresaComprobanteTarjeta=true;
	public Boolean activarid_empresaComprobanteTarjeta=true;
	public Boolean cargarid_empresaComprobanteTarjeta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComprobanteTarjeta=false;//ConEventDepend=true

	public Border resaltarid_sucursalComprobanteTarjeta=null;
	public Boolean mostrarid_sucursalComprobanteTarjeta=true;
	public Boolean activarid_sucursalComprobanteTarjeta=true;
	public Boolean cargarid_sucursalComprobanteTarjeta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalComprobanteTarjeta=false;//ConEventDepend=true

	public Border resaltarid_clienteComprobanteTarjeta=null;
	public Boolean mostrarid_clienteComprobanteTarjeta=true;
	public Boolean activarid_clienteComprobanteTarjeta=false;
	public Boolean cargarid_clienteComprobanteTarjeta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteComprobanteTarjeta=false;//ConEventDepend=true

	public Border resaltarid_cajaComprobanteTarjeta=null;
	public Boolean mostrarid_cajaComprobanteTarjeta=true;
	public Boolean activarid_cajaComprobanteTarjeta=false;
	public Boolean cargarid_cajaComprobanteTarjeta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaComprobanteTarjeta=false;//ConEventDepend=true

	public Border resaltarfecha_inicioComprobanteTarjeta=null;
	public Boolean mostrarfecha_inicioComprobanteTarjeta=true;
	public Boolean activarfecha_inicioComprobanteTarjeta=true;

	public Border resaltarfecha_finComprobanteTarjeta=null;
	public Boolean mostrarfecha_finComprobanteTarjeta=true;
	public Boolean activarfecha_finComprobanteTarjeta=true;

	public Border resaltarnombre_cajaComprobanteTarjeta=null;
	public Boolean mostrarnombre_cajaComprobanteTarjeta=true;
	public Boolean activarnombre_cajaComprobanteTarjeta=true;

	public Border resaltarsecuencialComprobanteTarjeta=null;
	public Boolean mostrarsecuencialComprobanteTarjeta=true;
	public Boolean activarsecuencialComprobanteTarjeta=true;

	public Border resaltarfechaComprobanteTarjeta=null;
	public Boolean mostrarfechaComprobanteTarjeta=true;
	public Boolean activarfechaComprobanteTarjeta=true;

	public Border resaltarcodigo_clienteComprobanteTarjeta=null;
	public Boolean mostrarcodigo_clienteComprobanteTarjeta=true;
	public Boolean activarcodigo_clienteComprobanteTarjeta=true;

	public Border resaltarnombre_clienteComprobanteTarjeta=null;
	public Boolean mostrarnombre_clienteComprobanteTarjeta=true;
	public Boolean activarnombre_clienteComprobanteTarjeta=true;

	public Border resaltarsubtotalComprobanteTarjeta=null;
	public Boolean mostrarsubtotalComprobanteTarjeta=true;
	public Boolean activarsubtotalComprobanteTarjeta=true;

	public Border resaltarivaComprobanteTarjeta=null;
	public Boolean mostrarivaComprobanteTarjeta=true;
	public Boolean activarivaComprobanteTarjeta=true;

	public Border resaltardescuentoComprobanteTarjeta=null;
	public Boolean mostrardescuentoComprobanteTarjeta=true;
	public Boolean activardescuentoComprobanteTarjeta=true;

	public Border resaltarfinanciamientoComprobanteTarjeta=null;
	public Boolean mostrarfinanciamientoComprobanteTarjeta=true;
	public Boolean activarfinanciamientoComprobanteTarjeta=true;

	public Border resaltarfleteComprobanteTarjeta=null;
	public Boolean mostrarfleteComprobanteTarjeta=true;
	public Boolean activarfleteComprobanteTarjeta=true;

	public Border resaltariceComprobanteTarjeta=null;
	public Boolean mostrariceComprobanteTarjeta=true;
	public Boolean activariceComprobanteTarjeta=true;

	public Border resaltartotalComprobanteTarjeta=null;
	public Boolean mostrartotalComprobanteTarjeta=true;
	public Boolean activartotalComprobanteTarjeta=true;

	public Border resaltarvalorComprobanteTarjeta=null;
	public Boolean mostrarvalorComprobanteTarjeta=true;
	public Boolean activarvalorComprobanteTarjeta=true;

	public Border resaltarfecha_forma_pagoComprobanteTarjeta=null;
	public Boolean mostrarfecha_forma_pagoComprobanteTarjeta=true;
	public Boolean activarfecha_forma_pagoComprobanteTarjeta=true;

	public Border resaltarnumeroComprobanteTarjeta=null;
	public Boolean mostrarnumeroComprobanteTarjeta=true;
	public Boolean activarnumeroComprobanteTarjeta=true;

	public Border resaltartarjeta_habienteComprobanteTarjeta=null;
	public Boolean mostrartarjeta_habienteComprobanteTarjeta=true;
	public Boolean activartarjeta_habienteComprobanteTarjeta=true;

	public Border resaltarautorizacionComprobanteTarjeta=null;
	public Boolean mostrarautorizacionComprobanteTarjeta=true;
	public Boolean activarautorizacionComprobanteTarjeta=true;

	public Border resaltarvoucherComprobanteTarjeta=null;
	public Boolean mostrarvoucherComprobanteTarjeta=true;
	public Boolean activarvoucherComprobanteTarjeta=true;

	public Border resaltarloteComprobanteTarjeta=null;
	public Boolean mostrarloteComprobanteTarjeta=true;
	public Boolean activarloteComprobanteTarjeta=true;

	
	

	public Border setResaltaridComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltaridComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComprobanteTarjeta() {
		return this.resaltaridComprobanteTarjeta;
	}

	public void setResaltaridComprobanteTarjeta(Border borderResaltar) {
		this.resaltaridComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostraridComprobanteTarjeta() {
		return this.mostraridComprobanteTarjeta;
	}

	public void setMostraridComprobanteTarjeta(Boolean mostraridComprobanteTarjeta) {
		this.mostraridComprobanteTarjeta= mostraridComprobanteTarjeta;
	}

	public Boolean getActivaridComprobanteTarjeta() {
		return this.activaridComprobanteTarjeta;
	}

	public void setActivaridComprobanteTarjeta(Boolean activaridComprobanteTarjeta) {
		this.activaridComprobanteTarjeta= activaridComprobanteTarjeta;
	}

	public Border setResaltarid_empresaComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarid_empresaComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComprobanteTarjeta() {
		return this.resaltarid_empresaComprobanteTarjeta;
	}

	public void setResaltarid_empresaComprobanteTarjeta(Border borderResaltar) {
		this.resaltarid_empresaComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarid_empresaComprobanteTarjeta() {
		return this.mostrarid_empresaComprobanteTarjeta;
	}

	public void setMostrarid_empresaComprobanteTarjeta(Boolean mostrarid_empresaComprobanteTarjeta) {
		this.mostrarid_empresaComprobanteTarjeta= mostrarid_empresaComprobanteTarjeta;
	}

	public Boolean getActivarid_empresaComprobanteTarjeta() {
		return this.activarid_empresaComprobanteTarjeta;
	}

	public void setActivarid_empresaComprobanteTarjeta(Boolean activarid_empresaComprobanteTarjeta) {
		this.activarid_empresaComprobanteTarjeta= activarid_empresaComprobanteTarjeta;
	}

	public Boolean getCargarid_empresaComprobanteTarjeta() {
		return this.cargarid_empresaComprobanteTarjeta;
	}

	public void setCargarid_empresaComprobanteTarjeta(Boolean cargarid_empresaComprobanteTarjeta) {
		this.cargarid_empresaComprobanteTarjeta= cargarid_empresaComprobanteTarjeta;
	}

	public Border setResaltarid_sucursalComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarid_sucursalComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalComprobanteTarjeta() {
		return this.resaltarid_sucursalComprobanteTarjeta;
	}

	public void setResaltarid_sucursalComprobanteTarjeta(Border borderResaltar) {
		this.resaltarid_sucursalComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalComprobanteTarjeta() {
		return this.mostrarid_sucursalComprobanteTarjeta;
	}

	public void setMostrarid_sucursalComprobanteTarjeta(Boolean mostrarid_sucursalComprobanteTarjeta) {
		this.mostrarid_sucursalComprobanteTarjeta= mostrarid_sucursalComprobanteTarjeta;
	}

	public Boolean getActivarid_sucursalComprobanteTarjeta() {
		return this.activarid_sucursalComprobanteTarjeta;
	}

	public void setActivarid_sucursalComprobanteTarjeta(Boolean activarid_sucursalComprobanteTarjeta) {
		this.activarid_sucursalComprobanteTarjeta= activarid_sucursalComprobanteTarjeta;
	}

	public Boolean getCargarid_sucursalComprobanteTarjeta() {
		return this.cargarid_sucursalComprobanteTarjeta;
	}

	public void setCargarid_sucursalComprobanteTarjeta(Boolean cargarid_sucursalComprobanteTarjeta) {
		this.cargarid_sucursalComprobanteTarjeta= cargarid_sucursalComprobanteTarjeta;
	}

	public Border setResaltarid_clienteComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarid_clienteComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteComprobanteTarjeta() {
		return this.resaltarid_clienteComprobanteTarjeta;
	}

	public void setResaltarid_clienteComprobanteTarjeta(Border borderResaltar) {
		this.resaltarid_clienteComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarid_clienteComprobanteTarjeta() {
		return this.mostrarid_clienteComprobanteTarjeta;
	}

	public void setMostrarid_clienteComprobanteTarjeta(Boolean mostrarid_clienteComprobanteTarjeta) {
		this.mostrarid_clienteComprobanteTarjeta= mostrarid_clienteComprobanteTarjeta;
	}

	public Boolean getActivarid_clienteComprobanteTarjeta() {
		return this.activarid_clienteComprobanteTarjeta;
	}

	public void setActivarid_clienteComprobanteTarjeta(Boolean activarid_clienteComprobanteTarjeta) {
		this.activarid_clienteComprobanteTarjeta= activarid_clienteComprobanteTarjeta;
	}

	public Boolean getCargarid_clienteComprobanteTarjeta() {
		return this.cargarid_clienteComprobanteTarjeta;
	}

	public void setCargarid_clienteComprobanteTarjeta(Boolean cargarid_clienteComprobanteTarjeta) {
		this.cargarid_clienteComprobanteTarjeta= cargarid_clienteComprobanteTarjeta;
	}

	public Border setResaltarid_cajaComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarid_cajaComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaComprobanteTarjeta() {
		return this.resaltarid_cajaComprobanteTarjeta;
	}

	public void setResaltarid_cajaComprobanteTarjeta(Border borderResaltar) {
		this.resaltarid_cajaComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarid_cajaComprobanteTarjeta() {
		return this.mostrarid_cajaComprobanteTarjeta;
	}

	public void setMostrarid_cajaComprobanteTarjeta(Boolean mostrarid_cajaComprobanteTarjeta) {
		this.mostrarid_cajaComprobanteTarjeta= mostrarid_cajaComprobanteTarjeta;
	}

	public Boolean getActivarid_cajaComprobanteTarjeta() {
		return this.activarid_cajaComprobanteTarjeta;
	}

	public void setActivarid_cajaComprobanteTarjeta(Boolean activarid_cajaComprobanteTarjeta) {
		this.activarid_cajaComprobanteTarjeta= activarid_cajaComprobanteTarjeta;
	}

	public Boolean getCargarid_cajaComprobanteTarjeta() {
		return this.cargarid_cajaComprobanteTarjeta;
	}

	public void setCargarid_cajaComprobanteTarjeta(Boolean cargarid_cajaComprobanteTarjeta) {
		this.cargarid_cajaComprobanteTarjeta= cargarid_cajaComprobanteTarjeta;
	}

	public Border setResaltarfecha_inicioComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioComprobanteTarjeta() {
		return this.resaltarfecha_inicioComprobanteTarjeta;
	}

	public void setResaltarfecha_inicioComprobanteTarjeta(Border borderResaltar) {
		this.resaltarfecha_inicioComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioComprobanteTarjeta() {
		return this.mostrarfecha_inicioComprobanteTarjeta;
	}

	public void setMostrarfecha_inicioComprobanteTarjeta(Boolean mostrarfecha_inicioComprobanteTarjeta) {
		this.mostrarfecha_inicioComprobanteTarjeta= mostrarfecha_inicioComprobanteTarjeta;
	}

	public Boolean getActivarfecha_inicioComprobanteTarjeta() {
		return this.activarfecha_inicioComprobanteTarjeta;
	}

	public void setActivarfecha_inicioComprobanteTarjeta(Boolean activarfecha_inicioComprobanteTarjeta) {
		this.activarfecha_inicioComprobanteTarjeta= activarfecha_inicioComprobanteTarjeta;
	}

	public Border setResaltarfecha_finComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarfecha_finComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finComprobanteTarjeta() {
		return this.resaltarfecha_finComprobanteTarjeta;
	}

	public void setResaltarfecha_finComprobanteTarjeta(Border borderResaltar) {
		this.resaltarfecha_finComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarfecha_finComprobanteTarjeta() {
		return this.mostrarfecha_finComprobanteTarjeta;
	}

	public void setMostrarfecha_finComprobanteTarjeta(Boolean mostrarfecha_finComprobanteTarjeta) {
		this.mostrarfecha_finComprobanteTarjeta= mostrarfecha_finComprobanteTarjeta;
	}

	public Boolean getActivarfecha_finComprobanteTarjeta() {
		return this.activarfecha_finComprobanteTarjeta;
	}

	public void setActivarfecha_finComprobanteTarjeta(Boolean activarfecha_finComprobanteTarjeta) {
		this.activarfecha_finComprobanteTarjeta= activarfecha_finComprobanteTarjeta;
	}

	public Border setResaltarnombre_cajaComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarnombre_cajaComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cajaComprobanteTarjeta() {
		return this.resaltarnombre_cajaComprobanteTarjeta;
	}

	public void setResaltarnombre_cajaComprobanteTarjeta(Border borderResaltar) {
		this.resaltarnombre_cajaComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarnombre_cajaComprobanteTarjeta() {
		return this.mostrarnombre_cajaComprobanteTarjeta;
	}

	public void setMostrarnombre_cajaComprobanteTarjeta(Boolean mostrarnombre_cajaComprobanteTarjeta) {
		this.mostrarnombre_cajaComprobanteTarjeta= mostrarnombre_cajaComprobanteTarjeta;
	}

	public Boolean getActivarnombre_cajaComprobanteTarjeta() {
		return this.activarnombre_cajaComprobanteTarjeta;
	}

	public void setActivarnombre_cajaComprobanteTarjeta(Boolean activarnombre_cajaComprobanteTarjeta) {
		this.activarnombre_cajaComprobanteTarjeta= activarnombre_cajaComprobanteTarjeta;
	}

	public Border setResaltarsecuencialComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarsecuencialComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialComprobanteTarjeta() {
		return this.resaltarsecuencialComprobanteTarjeta;
	}

	public void setResaltarsecuencialComprobanteTarjeta(Border borderResaltar) {
		this.resaltarsecuencialComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarsecuencialComprobanteTarjeta() {
		return this.mostrarsecuencialComprobanteTarjeta;
	}

	public void setMostrarsecuencialComprobanteTarjeta(Boolean mostrarsecuencialComprobanteTarjeta) {
		this.mostrarsecuencialComprobanteTarjeta= mostrarsecuencialComprobanteTarjeta;
	}

	public Boolean getActivarsecuencialComprobanteTarjeta() {
		return this.activarsecuencialComprobanteTarjeta;
	}

	public void setActivarsecuencialComprobanteTarjeta(Boolean activarsecuencialComprobanteTarjeta) {
		this.activarsecuencialComprobanteTarjeta= activarsecuencialComprobanteTarjeta;
	}

	public Border setResaltarfechaComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarfechaComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaComprobanteTarjeta() {
		return this.resaltarfechaComprobanteTarjeta;
	}

	public void setResaltarfechaComprobanteTarjeta(Border borderResaltar) {
		this.resaltarfechaComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarfechaComprobanteTarjeta() {
		return this.mostrarfechaComprobanteTarjeta;
	}

	public void setMostrarfechaComprobanteTarjeta(Boolean mostrarfechaComprobanteTarjeta) {
		this.mostrarfechaComprobanteTarjeta= mostrarfechaComprobanteTarjeta;
	}

	public Boolean getActivarfechaComprobanteTarjeta() {
		return this.activarfechaComprobanteTarjeta;
	}

	public void setActivarfechaComprobanteTarjeta(Boolean activarfechaComprobanteTarjeta) {
		this.activarfechaComprobanteTarjeta= activarfechaComprobanteTarjeta;
	}

	public Border setResaltarcodigo_clienteComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteComprobanteTarjeta() {
		return this.resaltarcodigo_clienteComprobanteTarjeta;
	}

	public void setResaltarcodigo_clienteComprobanteTarjeta(Border borderResaltar) {
		this.resaltarcodigo_clienteComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteComprobanteTarjeta() {
		return this.mostrarcodigo_clienteComprobanteTarjeta;
	}

	public void setMostrarcodigo_clienteComprobanteTarjeta(Boolean mostrarcodigo_clienteComprobanteTarjeta) {
		this.mostrarcodigo_clienteComprobanteTarjeta= mostrarcodigo_clienteComprobanteTarjeta;
	}

	public Boolean getActivarcodigo_clienteComprobanteTarjeta() {
		return this.activarcodigo_clienteComprobanteTarjeta;
	}

	public void setActivarcodigo_clienteComprobanteTarjeta(Boolean activarcodigo_clienteComprobanteTarjeta) {
		this.activarcodigo_clienteComprobanteTarjeta= activarcodigo_clienteComprobanteTarjeta;
	}

	public Border setResaltarnombre_clienteComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteComprobanteTarjeta() {
		return this.resaltarnombre_clienteComprobanteTarjeta;
	}

	public void setResaltarnombre_clienteComprobanteTarjeta(Border borderResaltar) {
		this.resaltarnombre_clienteComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteComprobanteTarjeta() {
		return this.mostrarnombre_clienteComprobanteTarjeta;
	}

	public void setMostrarnombre_clienteComprobanteTarjeta(Boolean mostrarnombre_clienteComprobanteTarjeta) {
		this.mostrarnombre_clienteComprobanteTarjeta= mostrarnombre_clienteComprobanteTarjeta;
	}

	public Boolean getActivarnombre_clienteComprobanteTarjeta() {
		return this.activarnombre_clienteComprobanteTarjeta;
	}

	public void setActivarnombre_clienteComprobanteTarjeta(Boolean activarnombre_clienteComprobanteTarjeta) {
		this.activarnombre_clienteComprobanteTarjeta= activarnombre_clienteComprobanteTarjeta;
	}

	public Border setResaltarsubtotalComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarsubtotalComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalComprobanteTarjeta() {
		return this.resaltarsubtotalComprobanteTarjeta;
	}

	public void setResaltarsubtotalComprobanteTarjeta(Border borderResaltar) {
		this.resaltarsubtotalComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarsubtotalComprobanteTarjeta() {
		return this.mostrarsubtotalComprobanteTarjeta;
	}

	public void setMostrarsubtotalComprobanteTarjeta(Boolean mostrarsubtotalComprobanteTarjeta) {
		this.mostrarsubtotalComprobanteTarjeta= mostrarsubtotalComprobanteTarjeta;
	}

	public Boolean getActivarsubtotalComprobanteTarjeta() {
		return this.activarsubtotalComprobanteTarjeta;
	}

	public void setActivarsubtotalComprobanteTarjeta(Boolean activarsubtotalComprobanteTarjeta) {
		this.activarsubtotalComprobanteTarjeta= activarsubtotalComprobanteTarjeta;
	}

	public Border setResaltarivaComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarivaComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaComprobanteTarjeta() {
		return this.resaltarivaComprobanteTarjeta;
	}

	public void setResaltarivaComprobanteTarjeta(Border borderResaltar) {
		this.resaltarivaComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarivaComprobanteTarjeta() {
		return this.mostrarivaComprobanteTarjeta;
	}

	public void setMostrarivaComprobanteTarjeta(Boolean mostrarivaComprobanteTarjeta) {
		this.mostrarivaComprobanteTarjeta= mostrarivaComprobanteTarjeta;
	}

	public Boolean getActivarivaComprobanteTarjeta() {
		return this.activarivaComprobanteTarjeta;
	}

	public void setActivarivaComprobanteTarjeta(Boolean activarivaComprobanteTarjeta) {
		this.activarivaComprobanteTarjeta= activarivaComprobanteTarjeta;
	}

	public Border setResaltardescuentoComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltardescuentoComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoComprobanteTarjeta() {
		return this.resaltardescuentoComprobanteTarjeta;
	}

	public void setResaltardescuentoComprobanteTarjeta(Border borderResaltar) {
		this.resaltardescuentoComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrardescuentoComprobanteTarjeta() {
		return this.mostrardescuentoComprobanteTarjeta;
	}

	public void setMostrardescuentoComprobanteTarjeta(Boolean mostrardescuentoComprobanteTarjeta) {
		this.mostrardescuentoComprobanteTarjeta= mostrardescuentoComprobanteTarjeta;
	}

	public Boolean getActivardescuentoComprobanteTarjeta() {
		return this.activardescuentoComprobanteTarjeta;
	}

	public void setActivardescuentoComprobanteTarjeta(Boolean activardescuentoComprobanteTarjeta) {
		this.activardescuentoComprobanteTarjeta= activardescuentoComprobanteTarjeta;
	}

	public Border setResaltarfinanciamientoComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoComprobanteTarjeta() {
		return this.resaltarfinanciamientoComprobanteTarjeta;
	}

	public void setResaltarfinanciamientoComprobanteTarjeta(Border borderResaltar) {
		this.resaltarfinanciamientoComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoComprobanteTarjeta() {
		return this.mostrarfinanciamientoComprobanteTarjeta;
	}

	public void setMostrarfinanciamientoComprobanteTarjeta(Boolean mostrarfinanciamientoComprobanteTarjeta) {
		this.mostrarfinanciamientoComprobanteTarjeta= mostrarfinanciamientoComprobanteTarjeta;
	}

	public Boolean getActivarfinanciamientoComprobanteTarjeta() {
		return this.activarfinanciamientoComprobanteTarjeta;
	}

	public void setActivarfinanciamientoComprobanteTarjeta(Boolean activarfinanciamientoComprobanteTarjeta) {
		this.activarfinanciamientoComprobanteTarjeta= activarfinanciamientoComprobanteTarjeta;
	}

	public Border setResaltarfleteComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarfleteComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteComprobanteTarjeta() {
		return this.resaltarfleteComprobanteTarjeta;
	}

	public void setResaltarfleteComprobanteTarjeta(Border borderResaltar) {
		this.resaltarfleteComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarfleteComprobanteTarjeta() {
		return this.mostrarfleteComprobanteTarjeta;
	}

	public void setMostrarfleteComprobanteTarjeta(Boolean mostrarfleteComprobanteTarjeta) {
		this.mostrarfleteComprobanteTarjeta= mostrarfleteComprobanteTarjeta;
	}

	public Boolean getActivarfleteComprobanteTarjeta() {
		return this.activarfleteComprobanteTarjeta;
	}

	public void setActivarfleteComprobanteTarjeta(Boolean activarfleteComprobanteTarjeta) {
		this.activarfleteComprobanteTarjeta= activarfleteComprobanteTarjeta;
	}

	public Border setResaltariceComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltariceComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceComprobanteTarjeta() {
		return this.resaltariceComprobanteTarjeta;
	}

	public void setResaltariceComprobanteTarjeta(Border borderResaltar) {
		this.resaltariceComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrariceComprobanteTarjeta() {
		return this.mostrariceComprobanteTarjeta;
	}

	public void setMostrariceComprobanteTarjeta(Boolean mostrariceComprobanteTarjeta) {
		this.mostrariceComprobanteTarjeta= mostrariceComprobanteTarjeta;
	}

	public Boolean getActivariceComprobanteTarjeta() {
		return this.activariceComprobanteTarjeta;
	}

	public void setActivariceComprobanteTarjeta(Boolean activariceComprobanteTarjeta) {
		this.activariceComprobanteTarjeta= activariceComprobanteTarjeta;
	}

	public Border setResaltartotalComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltartotalComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalComprobanteTarjeta() {
		return this.resaltartotalComprobanteTarjeta;
	}

	public void setResaltartotalComprobanteTarjeta(Border borderResaltar) {
		this.resaltartotalComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrartotalComprobanteTarjeta() {
		return this.mostrartotalComprobanteTarjeta;
	}

	public void setMostrartotalComprobanteTarjeta(Boolean mostrartotalComprobanteTarjeta) {
		this.mostrartotalComprobanteTarjeta= mostrartotalComprobanteTarjeta;
	}

	public Boolean getActivartotalComprobanteTarjeta() {
		return this.activartotalComprobanteTarjeta;
	}

	public void setActivartotalComprobanteTarjeta(Boolean activartotalComprobanteTarjeta) {
		this.activartotalComprobanteTarjeta= activartotalComprobanteTarjeta;
	}

	public Border setResaltarvalorComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarvalorComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorComprobanteTarjeta() {
		return this.resaltarvalorComprobanteTarjeta;
	}

	public void setResaltarvalorComprobanteTarjeta(Border borderResaltar) {
		this.resaltarvalorComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarvalorComprobanteTarjeta() {
		return this.mostrarvalorComprobanteTarjeta;
	}

	public void setMostrarvalorComprobanteTarjeta(Boolean mostrarvalorComprobanteTarjeta) {
		this.mostrarvalorComprobanteTarjeta= mostrarvalorComprobanteTarjeta;
	}

	public Boolean getActivarvalorComprobanteTarjeta() {
		return this.activarvalorComprobanteTarjeta;
	}

	public void setActivarvalorComprobanteTarjeta(Boolean activarvalorComprobanteTarjeta) {
		this.activarvalorComprobanteTarjeta= activarvalorComprobanteTarjeta;
	}

	public Border setResaltarfecha_forma_pagoComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarfecha_forma_pagoComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_forma_pagoComprobanteTarjeta() {
		return this.resaltarfecha_forma_pagoComprobanteTarjeta;
	}

	public void setResaltarfecha_forma_pagoComprobanteTarjeta(Border borderResaltar) {
		this.resaltarfecha_forma_pagoComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarfecha_forma_pagoComprobanteTarjeta() {
		return this.mostrarfecha_forma_pagoComprobanteTarjeta;
	}

	public void setMostrarfecha_forma_pagoComprobanteTarjeta(Boolean mostrarfecha_forma_pagoComprobanteTarjeta) {
		this.mostrarfecha_forma_pagoComprobanteTarjeta= mostrarfecha_forma_pagoComprobanteTarjeta;
	}

	public Boolean getActivarfecha_forma_pagoComprobanteTarjeta() {
		return this.activarfecha_forma_pagoComprobanteTarjeta;
	}

	public void setActivarfecha_forma_pagoComprobanteTarjeta(Boolean activarfecha_forma_pagoComprobanteTarjeta) {
		this.activarfecha_forma_pagoComprobanteTarjeta= activarfecha_forma_pagoComprobanteTarjeta;
	}

	public Border setResaltarnumeroComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarnumeroComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroComprobanteTarjeta() {
		return this.resaltarnumeroComprobanteTarjeta;
	}

	public void setResaltarnumeroComprobanteTarjeta(Border borderResaltar) {
		this.resaltarnumeroComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarnumeroComprobanteTarjeta() {
		return this.mostrarnumeroComprobanteTarjeta;
	}

	public void setMostrarnumeroComprobanteTarjeta(Boolean mostrarnumeroComprobanteTarjeta) {
		this.mostrarnumeroComprobanteTarjeta= mostrarnumeroComprobanteTarjeta;
	}

	public Boolean getActivarnumeroComprobanteTarjeta() {
		return this.activarnumeroComprobanteTarjeta;
	}

	public void setActivarnumeroComprobanteTarjeta(Boolean activarnumeroComprobanteTarjeta) {
		this.activarnumeroComprobanteTarjeta= activarnumeroComprobanteTarjeta;
	}

	public Border setResaltartarjeta_habienteComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltartarjeta_habienteComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartarjeta_habienteComprobanteTarjeta() {
		return this.resaltartarjeta_habienteComprobanteTarjeta;
	}

	public void setResaltartarjeta_habienteComprobanteTarjeta(Border borderResaltar) {
		this.resaltartarjeta_habienteComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrartarjeta_habienteComprobanteTarjeta() {
		return this.mostrartarjeta_habienteComprobanteTarjeta;
	}

	public void setMostrartarjeta_habienteComprobanteTarjeta(Boolean mostrartarjeta_habienteComprobanteTarjeta) {
		this.mostrartarjeta_habienteComprobanteTarjeta= mostrartarjeta_habienteComprobanteTarjeta;
	}

	public Boolean getActivartarjeta_habienteComprobanteTarjeta() {
		return this.activartarjeta_habienteComprobanteTarjeta;
	}

	public void setActivartarjeta_habienteComprobanteTarjeta(Boolean activartarjeta_habienteComprobanteTarjeta) {
		this.activartarjeta_habienteComprobanteTarjeta= activartarjeta_habienteComprobanteTarjeta;
	}

	public Border setResaltarautorizacionComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarautorizacionComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacionComprobanteTarjeta() {
		return this.resaltarautorizacionComprobanteTarjeta;
	}

	public void setResaltarautorizacionComprobanteTarjeta(Border borderResaltar) {
		this.resaltarautorizacionComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarautorizacionComprobanteTarjeta() {
		return this.mostrarautorizacionComprobanteTarjeta;
	}

	public void setMostrarautorizacionComprobanteTarjeta(Boolean mostrarautorizacionComprobanteTarjeta) {
		this.mostrarautorizacionComprobanteTarjeta= mostrarautorizacionComprobanteTarjeta;
	}

	public Boolean getActivarautorizacionComprobanteTarjeta() {
		return this.activarautorizacionComprobanteTarjeta;
	}

	public void setActivarautorizacionComprobanteTarjeta(Boolean activarautorizacionComprobanteTarjeta) {
		this.activarautorizacionComprobanteTarjeta= activarautorizacionComprobanteTarjeta;
	}

	public Border setResaltarvoucherComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarvoucherComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvoucherComprobanteTarjeta() {
		return this.resaltarvoucherComprobanteTarjeta;
	}

	public void setResaltarvoucherComprobanteTarjeta(Border borderResaltar) {
		this.resaltarvoucherComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarvoucherComprobanteTarjeta() {
		return this.mostrarvoucherComprobanteTarjeta;
	}

	public void setMostrarvoucherComprobanteTarjeta(Boolean mostrarvoucherComprobanteTarjeta) {
		this.mostrarvoucherComprobanteTarjeta= mostrarvoucherComprobanteTarjeta;
	}

	public Boolean getActivarvoucherComprobanteTarjeta() {
		return this.activarvoucherComprobanteTarjeta;
	}

	public void setActivarvoucherComprobanteTarjeta(Boolean activarvoucherComprobanteTarjeta) {
		this.activarvoucherComprobanteTarjeta= activarvoucherComprobanteTarjeta;
	}

	public Border setResaltarloteComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantetarjetaBeanSwingJInternalFrame.jTtoolBarComprobanteTarjeta.setBorder(borderResaltar);
		
		this.resaltarloteComprobanteTarjeta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteComprobanteTarjeta() {
		return this.resaltarloteComprobanteTarjeta;
	}

	public void setResaltarloteComprobanteTarjeta(Border borderResaltar) {
		this.resaltarloteComprobanteTarjeta= borderResaltar;
	}

	public Boolean getMostrarloteComprobanteTarjeta() {
		return this.mostrarloteComprobanteTarjeta;
	}

	public void setMostrarloteComprobanteTarjeta(Boolean mostrarloteComprobanteTarjeta) {
		this.mostrarloteComprobanteTarjeta= mostrarloteComprobanteTarjeta;
	}

	public Boolean getActivarloteComprobanteTarjeta() {
		return this.activarloteComprobanteTarjeta;
	}

	public void setActivarloteComprobanteTarjeta(Boolean activarloteComprobanteTarjeta) {
		this.activarloteComprobanteTarjeta= activarloteComprobanteTarjeta;
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
		
		
		this.setMostraridComprobanteTarjeta(esInicial);
		this.setMostrarid_empresaComprobanteTarjeta(esInicial);
		this.setMostrarid_sucursalComprobanteTarjeta(esInicial);
		this.setMostrarid_clienteComprobanteTarjeta(esInicial);
		this.setMostrarid_cajaComprobanteTarjeta(esInicial);
		this.setMostrarfecha_inicioComprobanteTarjeta(esInicial);
		this.setMostrarfecha_finComprobanteTarjeta(esInicial);
		this.setMostrarnombre_cajaComprobanteTarjeta(esInicial);
		this.setMostrarsecuencialComprobanteTarjeta(esInicial);
		this.setMostrarfechaComprobanteTarjeta(esInicial);
		this.setMostrarcodigo_clienteComprobanteTarjeta(esInicial);
		this.setMostrarnombre_clienteComprobanteTarjeta(esInicial);
		this.setMostrarsubtotalComprobanteTarjeta(esInicial);
		this.setMostrarivaComprobanteTarjeta(esInicial);
		this.setMostrardescuentoComprobanteTarjeta(esInicial);
		this.setMostrarfinanciamientoComprobanteTarjeta(esInicial);
		this.setMostrarfleteComprobanteTarjeta(esInicial);
		this.setMostrariceComprobanteTarjeta(esInicial);
		this.setMostrartotalComprobanteTarjeta(esInicial);
		this.setMostrarvalorComprobanteTarjeta(esInicial);
		this.setMostrarfecha_forma_pagoComprobanteTarjeta(esInicial);
		this.setMostrarnumeroComprobanteTarjeta(esInicial);
		this.setMostrartarjeta_habienteComprobanteTarjeta(esInicial);
		this.setMostrarautorizacionComprobanteTarjeta(esInicial);
		this.setMostrarvoucherComprobanteTarjeta(esInicial);
		this.setMostrarloteComprobanteTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.ID)) {
				this.setMostraridComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECAJA)) {
				this.setMostrarnombre_cajaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHA)) {
				this.setMostrarfechaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IVA)) {
				this.setMostrarivaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FLETE)) {
				this.setMostrarfleteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.ICE)) {
				this.setMostrariceComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.TOTAL)) {
				this.setMostrartotalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.VALOR)) {
				this.setMostrarvalorComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO)) {
				this.setMostrarfecha_forma_pagoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE)) {
				this.setMostrartarjeta_habienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.AUTORIZACION)) {
				this.setMostrarautorizacionComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.VOUCHER)) {
				this.setMostrarvoucherComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.LOTE)) {
				this.setMostrarloteComprobanteTarjeta(esAsigna);
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
		
		
		this.setActivaridComprobanteTarjeta(esInicial);
		this.setActivarid_empresaComprobanteTarjeta(esInicial);
		this.setActivarid_sucursalComprobanteTarjeta(esInicial);
		this.setActivarid_clienteComprobanteTarjeta(esInicial);
		this.setActivarid_cajaComprobanteTarjeta(esInicial);
		this.setActivarfecha_inicioComprobanteTarjeta(esInicial);
		this.setActivarfecha_finComprobanteTarjeta(esInicial);
		this.setActivarnombre_cajaComprobanteTarjeta(esInicial);
		this.setActivarsecuencialComprobanteTarjeta(esInicial);
		this.setActivarfechaComprobanteTarjeta(esInicial);
		this.setActivarcodigo_clienteComprobanteTarjeta(esInicial);
		this.setActivarnombre_clienteComprobanteTarjeta(esInicial);
		this.setActivarsubtotalComprobanteTarjeta(esInicial);
		this.setActivarivaComprobanteTarjeta(esInicial);
		this.setActivardescuentoComprobanteTarjeta(esInicial);
		this.setActivarfinanciamientoComprobanteTarjeta(esInicial);
		this.setActivarfleteComprobanteTarjeta(esInicial);
		this.setActivariceComprobanteTarjeta(esInicial);
		this.setActivartotalComprobanteTarjeta(esInicial);
		this.setActivarvalorComprobanteTarjeta(esInicial);
		this.setActivarfecha_forma_pagoComprobanteTarjeta(esInicial);
		this.setActivarnumeroComprobanteTarjeta(esInicial);
		this.setActivartarjeta_habienteComprobanteTarjeta(esInicial);
		this.setActivarautorizacionComprobanteTarjeta(esInicial);
		this.setActivarvoucherComprobanteTarjeta(esInicial);
		this.setActivarloteComprobanteTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.ID)) {
				this.setActivaridComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECAJA)) {
				this.setActivarnombre_cajaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHA)) {
				this.setActivarfechaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IVA)) {
				this.setActivarivaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FLETE)) {
				this.setActivarfleteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.ICE)) {
				this.setActivariceComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.TOTAL)) {
				this.setActivartotalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.VALOR)) {
				this.setActivarvalorComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO)) {
				this.setActivarfecha_forma_pagoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NUMERO)) {
				this.setActivarnumeroComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE)) {
				this.setActivartarjeta_habienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.AUTORIZACION)) {
				this.setActivarautorizacionComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.VOUCHER)) {
				this.setActivarvoucherComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.LOTE)) {
				this.setActivarloteComprobanteTarjeta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComprobanteTarjeta(esInicial);
		this.setResaltarid_empresaComprobanteTarjeta(esInicial);
		this.setResaltarid_sucursalComprobanteTarjeta(esInicial);
		this.setResaltarid_clienteComprobanteTarjeta(esInicial);
		this.setResaltarid_cajaComprobanteTarjeta(esInicial);
		this.setResaltarfecha_inicioComprobanteTarjeta(esInicial);
		this.setResaltarfecha_finComprobanteTarjeta(esInicial);
		this.setResaltarnombre_cajaComprobanteTarjeta(esInicial);
		this.setResaltarsecuencialComprobanteTarjeta(esInicial);
		this.setResaltarfechaComprobanteTarjeta(esInicial);
		this.setResaltarcodigo_clienteComprobanteTarjeta(esInicial);
		this.setResaltarnombre_clienteComprobanteTarjeta(esInicial);
		this.setResaltarsubtotalComprobanteTarjeta(esInicial);
		this.setResaltarivaComprobanteTarjeta(esInicial);
		this.setResaltardescuentoComprobanteTarjeta(esInicial);
		this.setResaltarfinanciamientoComprobanteTarjeta(esInicial);
		this.setResaltarfleteComprobanteTarjeta(esInicial);
		this.setResaltariceComprobanteTarjeta(esInicial);
		this.setResaltartotalComprobanteTarjeta(esInicial);
		this.setResaltarvalorComprobanteTarjeta(esInicial);
		this.setResaltarfecha_forma_pagoComprobanteTarjeta(esInicial);
		this.setResaltarnumeroComprobanteTarjeta(esInicial);
		this.setResaltartarjeta_habienteComprobanteTarjeta(esInicial);
		this.setResaltarautorizacionComprobanteTarjeta(esInicial);
		this.setResaltarvoucherComprobanteTarjeta(esInicial);
		this.setResaltarloteComprobanteTarjeta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.ID)) {
				this.setResaltaridComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECAJA)) {
				this.setResaltarnombre_cajaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHA)) {
				this.setResaltarfechaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.IVA)) {
				this.setResaltarivaComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FLETE)) {
				this.setResaltarfleteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.ICE)) {
				this.setResaltariceComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.TOTAL)) {
				this.setResaltartotalComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.VALOR)) {
				this.setResaltarvalorComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.FECHAFORMAPAGO)) {
				this.setResaltarfecha_forma_pagoComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.TARJETAHABIENTE)) {
				this.setResaltartarjeta_habienteComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.AUTORIZACION)) {
				this.setResaltarautorizacionComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.VOUCHER)) {
				this.setResaltarvoucherComprobanteTarjeta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteTarjetaConstantesFunciones.LOTE)) {
				this.setResaltarloteComprobanteTarjeta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaComprobanteTarjetaComprobanteTarjeta=true;

	public Boolean getMostrarBusquedaComprobanteTarjetaComprobanteTarjeta() {
		return this.mostrarBusquedaComprobanteTarjetaComprobanteTarjeta;
	}

	public void setMostrarBusquedaComprobanteTarjetaComprobanteTarjeta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaComprobanteTarjetaComprobanteTarjeta= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaComprobanteTarjetaComprobanteTarjeta=true;

	public Boolean getActivarBusquedaComprobanteTarjetaComprobanteTarjeta() {
		return this.activarBusquedaComprobanteTarjetaComprobanteTarjeta;
	}

	public void setActivarBusquedaComprobanteTarjetaComprobanteTarjeta(Boolean habilitarResaltar) {
		this.activarBusquedaComprobanteTarjetaComprobanteTarjeta= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaComprobanteTarjetaComprobanteTarjeta=null;

	public Border getResaltarBusquedaComprobanteTarjetaComprobanteTarjeta() {
		return this.resaltarBusquedaComprobanteTarjetaComprobanteTarjeta;
	}

	public void setResaltarBusquedaComprobanteTarjetaComprobanteTarjeta(Border borderResaltar) {
		this.resaltarBusquedaComprobanteTarjetaComprobanteTarjeta= borderResaltar;
	}

	public void setResaltarBusquedaComprobanteTarjetaComprobanteTarjeta(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteTarjetaBeanSwingJInternalFrame comprobantetarjetaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaComprobanteTarjetaComprobanteTarjeta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}