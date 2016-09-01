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


import com.bydan.erp.puntoventa.util.report.ComprobanteFormaPagoConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.ComprobanteFormaPagoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteFormaPagoParameterGeneral;

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
final public class ComprobanteFormaPagoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ComprobanteFormaPago";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComprobanteFormaPago"+ComprobanteFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComprobanteFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComprobanteFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComprobanteFormaPagoConstantesFunciones.SCHEMA+"_"+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComprobanteFormaPagoConstantesFunciones.SCHEMA+"_"+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComprobanteFormaPagoConstantesFunciones.SCHEMA+"_"+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComprobanteFormaPagoConstantesFunciones.SCHEMA+"_"+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComprobanteFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComprobanteFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComprobanteFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComprobanteFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comprobante Forma Pagos";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comprobante Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Comprobante Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComprobanteFormaPago";
	public static final String OBJECTNAME="comprobanteformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="comprobante_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comprobanteformapago from "+ComprobanteFormaPagoConstantesFunciones.SPERSISTENCENAME+" comprobanteformapago";
	public static String QUERYSELECTNATIVE="select "+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".id,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".version_row,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".id_cliente,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".id_caja,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".fecha_inicio,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".fecha_fin,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".nombre_caja,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".secuencial,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".fecha,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".codigo_cliente,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".nombre_cliente,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".subtotal,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".iva,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".descuento,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".financiamiento,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".flete,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".ice,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".total,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".tipo,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".valor,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".fecha_forma_pago,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".numero_cuenta,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".numero_cheque,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".girador,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".numero_dias_plazo,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".numero_tarjeta,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".autorizacion,"+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME+".lote from "+ComprobanteFormaPagoConstantesFunciones.SCHEMA+"."+ComprobanteFormaPagoConstantesFunciones.TABLENAME;//+" as "+ComprobanteFormaPagoConstantesFunciones.TABLENAME;
	
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
    public static final String TIPO= "tipo";
    public static final String VALOR= "valor";
    public static final String FECHAFORMAPAGO= "fecha_forma_pago";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String GIRADOR= "girador";
    public static final String NUMERODIASPLAZO= "numero_dias_plazo";
    public static final String NUMEROTARJETA= "numero_tarjeta";
    public static final String AUTORIZACION= "autorizacion";
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
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHAFORMAPAGO= "Fecha Forma Pago";
		public static final String LABEL_FECHAFORMAPAGO_LOWER= "Fecha Forma Pago";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_GIRADOR= "Girador";
		public static final String LABEL_GIRADOR_LOWER= "Girador";
    	public static final String LABEL_NUMERODIASPLAZO= "Numero Dias Plazo";
		public static final String LABEL_NUMERODIASPLAZO_LOWER= "Numero Dias Plazo";
    	public static final String LABEL_NUMEROTARJETA= "Numero Tarjeta";
		public static final String LABEL_NUMEROTARJETA_LOWER= "Numero Tarjeta";
    	public static final String LABEL_AUTORIZACION= "Autorizacion";
		public static final String LABEL_AUTORIZACION_LOWER= "Autorizacion";
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
		
		
		
		
		
		
		
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXGIRADOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGIRADOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_TARJETA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_TARJETA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComprobanteFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.IDCLIENTE)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.IDCAJA)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.FECHAINICIO)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFIN)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECAJA;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.SECUENCIAL)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.FECHA)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.SUBTOTAL)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.IVA)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.DESCUENTO)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.FLETE)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.ICE)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.TOTAL)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.TIPO)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_TIPO;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.VALOR)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFORMAPAGO;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.GIRADOR)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_GIRADOR;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_NUMERODIASPLAZO;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROTARJETA;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.AUTORIZACION)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_AUTORIZACION;}
		if(sNombreColumna.equals(ComprobanteFormaPagoConstantesFunciones.LOTE)) {sLabelColumna=ComprobanteFormaPagoConstantesFunciones.LABEL_LOTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComprobanteFormaPagoDescripcion(ComprobanteFormaPago comprobanteformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comprobanteformapago !=null/* && comprobanteformapago.getId()!=0*/) {
			if(comprobanteformapago.getId()!=null) {
				sDescripcion=comprobanteformapago.getId().toString();
			}//comprobanteformapagocomprobanteformapago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComprobanteFormaPagoDescripcionDetallado(ComprobanteFormaPago comprobanteformapago) {
		String sDescripcion="";
			
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=comprobanteformapago.getId().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comprobanteformapago.getVersionRow().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comprobanteformapago.getid_empresa().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=comprobanteformapago.getid_sucursal().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=comprobanteformapago.getid_cliente().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.IDCAJA+"=";
		sDescripcion+=comprobanteformapago.getid_caja().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=comprobanteformapago.getfecha_inicio().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=comprobanteformapago.getfecha_fin().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA+"=";
		sDescripcion+=comprobanteformapago.getnombre_caja()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=comprobanteformapago.getsecuencial()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.FECHA+"=";
		sDescripcion+=comprobanteformapago.getfecha().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=comprobanteformapago.getcodigo_cliente()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=comprobanteformapago.getnombre_cliente()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=comprobanteformapago.getsubtotal().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.IVA+"=";
		sDescripcion+=comprobanteformapago.getiva().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=comprobanteformapago.getdescuento().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=comprobanteformapago.getfinanciamiento().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.FLETE+"=";
		sDescripcion+=comprobanteformapago.getflete().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.ICE+"=";
		sDescripcion+=comprobanteformapago.getice().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.TOTAL+"=";
		sDescripcion+=comprobanteformapago.gettotal().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.TIPO+"=";
		sDescripcion+=comprobanteformapago.gettipo()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.VALOR+"=";
		sDescripcion+=comprobanteformapago.getvalor().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO+"=";
		sDescripcion+=comprobanteformapago.getfecha_forma_pago().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=comprobanteformapago.getnumero_cuenta()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=comprobanteformapago.getnumero_cheque()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.GIRADOR+"=";
		sDescripcion+=comprobanteformapago.getgirador()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO+"=";
		sDescripcion+=comprobanteformapago.getnumero_dias_plazo().toString()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA+"=";
		sDescripcion+=comprobanteformapago.getnumero_tarjeta()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.AUTORIZACION+"=";
		sDescripcion+=comprobanteformapago.getautorizacion()+",";
		sDescripcion+=ComprobanteFormaPagoConstantesFunciones.LOTE+"=";
		sDescripcion+=comprobanteformapago.getlote()+",";
			
		return sDescripcion;
	}
	
	public static void setComprobanteFormaPagoDescripcion(ComprobanteFormaPago comprobanteformapago,String sValor) throws Exception {			
		if(comprobanteformapago !=null) {
			//comprobanteformapagocomprobanteformapago.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaComprobanteFormaPago")) {
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

	public static String getDetalleIndiceBusquedaComprobanteFormaPago(Date fecha_inicio,Date fecha_fin) {
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
	
	
	
	
	
	
	public static void quitarEspaciosComprobanteFormaPago(ComprobanteFormaPago comprobanteformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobanteformapago.setnombre_caja(comprobanteformapago.getnombre_caja().trim());
		comprobanteformapago.setsecuencial(comprobanteformapago.getsecuencial().trim());
		comprobanteformapago.setcodigo_cliente(comprobanteformapago.getcodigo_cliente().trim());
		comprobanteformapago.setnombre_cliente(comprobanteformapago.getnombre_cliente().trim());
		comprobanteformapago.settipo(comprobanteformapago.gettipo().trim());
		comprobanteformapago.setnumero_cuenta(comprobanteformapago.getnumero_cuenta().trim());
		comprobanteformapago.setnumero_cheque(comprobanteformapago.getnumero_cheque().trim());
		comprobanteformapago.setgirador(comprobanteformapago.getgirador().trim());
		comprobanteformapago.setnumero_tarjeta(comprobanteformapago.getnumero_tarjeta().trim());
		comprobanteformapago.setautorizacion(comprobanteformapago.getautorizacion().trim());
		comprobanteformapago.setlote(comprobanteformapago.getlote().trim());
	}
	
	public static void quitarEspaciosComprobanteFormaPagos(List<ComprobanteFormaPago> comprobanteformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteFormaPago comprobanteformapago: comprobanteformapagos) {
			comprobanteformapago.setnombre_caja(comprobanteformapago.getnombre_caja().trim());
			comprobanteformapago.setsecuencial(comprobanteformapago.getsecuencial().trim());
			comprobanteformapago.setcodigo_cliente(comprobanteformapago.getcodigo_cliente().trim());
			comprobanteformapago.setnombre_cliente(comprobanteformapago.getnombre_cliente().trim());
			comprobanteformapago.settipo(comprobanteformapago.gettipo().trim());
			comprobanteformapago.setnumero_cuenta(comprobanteformapago.getnumero_cuenta().trim());
			comprobanteformapago.setnumero_cheque(comprobanteformapago.getnumero_cheque().trim());
			comprobanteformapago.setgirador(comprobanteformapago.getgirador().trim());
			comprobanteformapago.setnumero_tarjeta(comprobanteformapago.getnumero_tarjeta().trim());
			comprobanteformapago.setautorizacion(comprobanteformapago.getautorizacion().trim());
			comprobanteformapago.setlote(comprobanteformapago.getlote().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteFormaPago(ComprobanteFormaPago comprobanteformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comprobanteformapago.getConCambioAuxiliar()) {
			comprobanteformapago.setIsDeleted(comprobanteformapago.getIsDeletedAuxiliar());	
			comprobanteformapago.setIsNew(comprobanteformapago.getIsNewAuxiliar());	
			comprobanteformapago.setIsChanged(comprobanteformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comprobanteformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comprobanteformapago.setIsDeletedAuxiliar(false);	
			comprobanteformapago.setIsNewAuxiliar(false);	
			comprobanteformapago.setIsChangedAuxiliar(false);
			
			comprobanteformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteFormaPagos(List<ComprobanteFormaPago> comprobanteformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComprobanteFormaPago comprobanteformapago : comprobanteformapagos) {
			if(conAsignarBase && comprobanteformapago.getConCambioAuxiliar()) {
				comprobanteformapago.setIsDeleted(comprobanteformapago.getIsDeletedAuxiliar());	
				comprobanteformapago.setIsNew(comprobanteformapago.getIsNewAuxiliar());	
				comprobanteformapago.setIsChanged(comprobanteformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comprobanteformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comprobanteformapago.setIsDeletedAuxiliar(false);	
				comprobanteformapago.setIsNewAuxiliar(false);	
				comprobanteformapago.setIsChangedAuxiliar(false);
				
				comprobanteformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComprobanteFormaPago(ComprobanteFormaPago comprobanteformapago,Boolean conEnteros) throws Exception  {
		comprobanteformapago.setsubtotal(0.0);
		comprobanteformapago.setiva(0.0);
		comprobanteformapago.setdescuento(0.0);
		comprobanteformapago.setfinanciamiento(0.0);
		comprobanteformapago.setflete(0.0);
		comprobanteformapago.setice(0.0);
		comprobanteformapago.settotal(0.0);
		comprobanteformapago.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			comprobanteformapago.setnumero_dias_plazo(0);
		}
	}		
	
	public static void InicializarValoresComprobanteFormaPagos(List<ComprobanteFormaPago> comprobanteformapagos,Boolean conEnteros) throws Exception  {
		
		for(ComprobanteFormaPago comprobanteformapago: comprobanteformapagos) {
			comprobanteformapago.setsubtotal(0.0);
			comprobanteformapago.setiva(0.0);
			comprobanteformapago.setdescuento(0.0);
			comprobanteformapago.setfinanciamiento(0.0);
			comprobanteformapago.setflete(0.0);
			comprobanteformapago.setice(0.0);
			comprobanteformapago.settotal(0.0);
			comprobanteformapago.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				comprobanteformapago.setnumero_dias_plazo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaComprobanteFormaPago(List<ComprobanteFormaPago> comprobanteformapagos,ComprobanteFormaPago comprobanteformapagoAux) throws Exception  {
		ComprobanteFormaPagoConstantesFunciones.InicializarValoresComprobanteFormaPago(comprobanteformapagoAux,true);
		
		for(ComprobanteFormaPago comprobanteformapago: comprobanteformapagos) {
			if(comprobanteformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comprobanteformapagoAux.setsubtotal(comprobanteformapagoAux.getsubtotal()+comprobanteformapago.getsubtotal());			
			comprobanteformapagoAux.setiva(comprobanteformapagoAux.getiva()+comprobanteformapago.getiva());			
			comprobanteformapagoAux.setdescuento(comprobanteformapagoAux.getdescuento()+comprobanteformapago.getdescuento());			
			comprobanteformapagoAux.setfinanciamiento(comprobanteformapagoAux.getfinanciamiento()+comprobanteformapago.getfinanciamiento());			
			comprobanteformapagoAux.setflete(comprobanteformapagoAux.getflete()+comprobanteformapago.getflete());			
			comprobanteformapagoAux.setice(comprobanteformapagoAux.getice()+comprobanteformapago.getice());			
			comprobanteformapagoAux.settotal(comprobanteformapagoAux.gettotal()+comprobanteformapago.gettotal());			
			comprobanteformapagoAux.setvalor(comprobanteformapagoAux.getvalor()+comprobanteformapago.getvalor());			
			comprobanteformapagoAux.setnumero_dias_plazo(comprobanteformapagoAux.getnumero_dias_plazo()+comprobanteformapago.getnumero_dias_plazo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComprobanteFormaPagoConstantesFunciones.getArrayColumnasGlobalesComprobanteFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobanteFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobanteFormaPagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComprobanteFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteFormaPago> comprobanteformapagos,ComprobanteFormaPago comprobanteformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteFormaPago comprobanteformapagoAux: comprobanteformapagos) {
			if(comprobanteformapagoAux!=null && comprobanteformapago!=null) {
				if((comprobanteformapagoAux.getId()==null && comprobanteformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comprobanteformapagoAux.getId()!=null && comprobanteformapago.getId()!=null){
					if(comprobanteformapagoAux.getId().equals(comprobanteformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteFormaPago(List<ComprobanteFormaPago> comprobanteformapagos) throws Exception  {
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
	
		for(ComprobanteFormaPago comprobanteformapago: comprobanteformapagos) {			
			if(comprobanteformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subtotalTotal+=comprobanteformapago.getsubtotal();
			ivaTotal+=comprobanteformapago.getiva();
			descuentoTotal+=comprobanteformapago.getdescuento();
			financiamientoTotal+=comprobanteformapago.getfinanciamiento();
			fleteTotal+=comprobanteformapago.getflete();
			iceTotal+=comprobanteformapago.getice();
			totalTotal+=comprobanteformapago.gettotal();
			valorTotal+=comprobanteformapago.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComprobanteFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_ID, ComprobanteFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_VERSIONROW, ComprobanteFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_IDCLIENTE, ComprobanteFormaPagoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_IDCAJA, ComprobanteFormaPagoConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECAJA, ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_SECUENCIAL, ComprobanteFormaPagoConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_FECHA, ComprobanteFormaPagoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_CODIGOCLIENTE, ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECLIENTE, ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_SUBTOTAL, ComprobanteFormaPagoConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_IVA, ComprobanteFormaPagoConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_DESCUENTO, ComprobanteFormaPagoConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_FINANCIAMIENTO, ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_FLETE, ComprobanteFormaPagoConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_ICE, ComprobanteFormaPagoConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_TOTAL, ComprobanteFormaPagoConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_TIPO, ComprobanteFormaPagoConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_VALOR, ComprobanteFormaPagoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFORMAPAGO, ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCUENTA, ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE, ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_GIRADOR, ComprobanteFormaPagoConstantesFunciones.GIRADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_NUMERODIASPLAZO, ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROTARJETA, ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_AUTORIZACION, ComprobanteFormaPagoConstantesFunciones.AUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFormaPagoConstantesFunciones.LABEL_LOTE, ComprobanteFormaPagoConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComprobanteFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.GIRADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.AUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFormaPagoConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFormaPago() throws Exception  {
		return ComprobanteFormaPagoConstantesFunciones.getTiposSeleccionarComprobanteFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFormaPago(Boolean conFk) throws Exception  {
		return ComprobanteFormaPagoConstantesFunciones.getTiposSeleccionarComprobanteFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECAJA);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFORMAPAGO);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_GIRADOR);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_GIRADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMERODIASPLAZO);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMERODIASPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROTARJETA);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_AUTORIZACION);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_AUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFormaPagoConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComprobanteFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteFormaPago(ComprobanteFormaPago comprobanteformapagoAux) throws Exception {
		
			comprobanteformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobanteformapagoAux.getEmpresa()));
			comprobanteformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobanteformapagoAux.getSucursal()));
			comprobanteformapagoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobanteformapagoAux.getCliente()));
			comprobanteformapagoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(comprobanteformapagoAux.getCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteFormaPago(List<ComprobanteFormaPago> comprobanteformapagosTemp) throws Exception {
		for(ComprobanteFormaPago comprobanteformapagoAux:comprobanteformapagosTemp) {
			
			comprobanteformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobanteformapagoAux.getEmpresa()));
			comprobanteformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(comprobanteformapagoAux.getSucursal()));
			comprobanteformapagoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobanteformapagoAux.getCliente()));
			comprobanteformapagoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(comprobanteformapagoAux.getCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComprobanteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComprobanteFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteFormaPagoConstantesFunciones.getClassesRelationshipsOfComprobanteFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfComprobanteFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComprobanteFormaPago comprobanteformapago,List<ComprobanteFormaPago> comprobanteformapagos,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ComprobanteFormaPago comprobanteformapago,List<ComprobanteFormaPago> comprobanteformapagos) throws Exception {
		try	{			
			for(ComprobanteFormaPago comprobanteformapagoLocal:comprobanteformapagos) {
				if(comprobanteformapagoLocal.getId().equals(comprobanteformapago.getId())) {
					comprobanteformapagoLocal.setIsSelected(comprobanteformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComprobanteFormaPago(List<ComprobanteFormaPago> comprobanteformapagosAux) throws Exception {
		//this.comprobanteformapagosAux=comprobanteformapagosAux;
		
		for(ComprobanteFormaPago comprobanteformapagoAux:comprobanteformapagosAux) {
			if(comprobanteformapagoAux.getIsChanged()) {
				comprobanteformapagoAux.setIsChanged(false);
			}		
			
			if(comprobanteformapagoAux.getIsNew()) {
				comprobanteformapagoAux.setIsNew(false);
			}	
			
			if(comprobanteformapagoAux.getIsDeleted()) {
				comprobanteformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComprobanteFormaPago(ComprobanteFormaPago comprobanteformapagoAux) throws Exception {
		//this.comprobanteformapagoAux=comprobanteformapagoAux;
		
			if(comprobanteformapagoAux.getIsChanged()) {
				comprobanteformapagoAux.setIsChanged(false);
			}		
			
			if(comprobanteformapagoAux.getIsNew()) {
				comprobanteformapagoAux.setIsNew(false);
			}	
			
			if(comprobanteformapagoAux.getIsDeleted()) {
				comprobanteformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComprobanteFormaPago comprobanteformapagoAsignar,ComprobanteFormaPago comprobanteformapago) throws Exception {
		comprobanteformapagoAsignar.setId(comprobanteformapago.getId());	
		comprobanteformapagoAsignar.setVersionRow(comprobanteformapago.getVersionRow());	
		comprobanteformapagoAsignar.setid_cliente(comprobanteformapago.getid_cliente());
		comprobanteformapagoAsignar.setcliente_descripcion(comprobanteformapago.getcliente_descripcion());	
		comprobanteformapagoAsignar.setid_caja(comprobanteformapago.getid_caja());
		comprobanteformapagoAsignar.setcaja_descripcion(comprobanteformapago.getcaja_descripcion());	
		comprobanteformapagoAsignar.setnombre_caja(comprobanteformapago.getnombre_caja());	
		comprobanteformapagoAsignar.setsecuencial(comprobanteformapago.getsecuencial());	
		comprobanteformapagoAsignar.setfecha(comprobanteformapago.getfecha());	
		comprobanteformapagoAsignar.setcodigo_cliente(comprobanteformapago.getcodigo_cliente());	
		comprobanteformapagoAsignar.setnombre_cliente(comprobanteformapago.getnombre_cliente());	
		comprobanteformapagoAsignar.setsubtotal(comprobanteformapago.getsubtotal());	
		comprobanteformapagoAsignar.setiva(comprobanteformapago.getiva());	
		comprobanteformapagoAsignar.setdescuento(comprobanteformapago.getdescuento());	
		comprobanteformapagoAsignar.setfinanciamiento(comprobanteformapago.getfinanciamiento());	
		comprobanteformapagoAsignar.setflete(comprobanteformapago.getflete());	
		comprobanteformapagoAsignar.setice(comprobanteformapago.getice());	
		comprobanteformapagoAsignar.settotal(comprobanteformapago.gettotal());	
		comprobanteformapagoAsignar.settipo(comprobanteformapago.gettipo());	
		comprobanteformapagoAsignar.setvalor(comprobanteformapago.getvalor());	
		comprobanteformapagoAsignar.setfecha_forma_pago(comprobanteformapago.getfecha_forma_pago());	
		comprobanteformapagoAsignar.setnumero_cuenta(comprobanteformapago.getnumero_cuenta());	
		comprobanteformapagoAsignar.setnumero_cheque(comprobanteformapago.getnumero_cheque());	
		comprobanteformapagoAsignar.setgirador(comprobanteformapago.getgirador());	
		comprobanteformapagoAsignar.setnumero_dias_plazo(comprobanteformapago.getnumero_dias_plazo());	
		comprobanteformapagoAsignar.setnumero_tarjeta(comprobanteformapago.getnumero_tarjeta());	
		comprobanteformapagoAsignar.setautorizacion(comprobanteformapago.getautorizacion());	
		comprobanteformapagoAsignar.setlote(comprobanteformapago.getlote());	
	}
	
	public static void inicializarComprobanteFormaPago(ComprobanteFormaPago comprobanteformapago) throws Exception {
		try {
				comprobanteformapago.setId(0L);	
					
				comprobanteformapago.setid_cliente(-1L);	
				comprobanteformapago.setid_caja(-1L);	
				comprobanteformapago.setnombre_caja("");	
				comprobanteformapago.setsecuencial("");	
				comprobanteformapago.setfecha(new Date());	
				comprobanteformapago.setcodigo_cliente("");	
				comprobanteformapago.setnombre_cliente("");	
				comprobanteformapago.setsubtotal(0.0);	
				comprobanteformapago.setiva(0.0);	
				comprobanteformapago.setdescuento(0.0);	
				comprobanteformapago.setfinanciamiento(0.0);	
				comprobanteformapago.setflete(0.0);	
				comprobanteformapago.setice(0.0);	
				comprobanteformapago.settotal(0.0);	
				comprobanteformapago.settipo("");	
				comprobanteformapago.setvalor(0.0);	
				comprobanteformapago.setfecha_forma_pago(new Date());	
				comprobanteformapago.setnumero_cuenta("");	
				comprobanteformapago.setnumero_cheque("");	
				comprobanteformapago.setgirador("");	
				comprobanteformapago.setnumero_dias_plazo(0);	
				comprobanteformapago.setnumero_tarjeta("");	
				comprobanteformapago.setautorizacion("");	
				comprobanteformapago.setlote("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComprobanteFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_FECHAFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_GIRADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMERODIASPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_NUMEROTARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_AUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFormaPagoConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComprobanteFormaPago(String sTipo,Row row,Workbook workbook,ComprobanteFormaPago comprobanteformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getnombre_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getfecha_forma_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getgirador());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getnumero_dias_plazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getnumero_tarjeta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getautorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobanteformapago.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComprobanteFormaPago="";
	
	public String getsFinalQueryComprobanteFormaPago() {
		return this.sFinalQueryComprobanteFormaPago;
	}
	
	public void setsFinalQueryComprobanteFormaPago(String sFinalQueryComprobanteFormaPago) {
		this.sFinalQueryComprobanteFormaPago= sFinalQueryComprobanteFormaPago;
	}
	
	public Border resaltarSeleccionarComprobanteFormaPago=null;
	
	public Border setResaltarSeleccionarComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComprobanteFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComprobanteFormaPago() {
		return this.resaltarSeleccionarComprobanteFormaPago;
	}
	
	public void setResaltarSeleccionarComprobanteFormaPago(Border borderResaltarSeleccionarComprobanteFormaPago) {
		this.resaltarSeleccionarComprobanteFormaPago= borderResaltarSeleccionarComprobanteFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComprobanteFormaPago=null;
	public Boolean mostraridComprobanteFormaPago=true;
	public Boolean activaridComprobanteFormaPago=true;

	public Border resaltarid_empresaComprobanteFormaPago=null;
	public Boolean mostrarid_empresaComprobanteFormaPago=true;
	public Boolean activarid_empresaComprobanteFormaPago=true;
	public Boolean cargarid_empresaComprobanteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComprobanteFormaPago=false;//ConEventDepend=true

	public Border resaltarid_sucursalComprobanteFormaPago=null;
	public Boolean mostrarid_sucursalComprobanteFormaPago=true;
	public Boolean activarid_sucursalComprobanteFormaPago=true;
	public Boolean cargarid_sucursalComprobanteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalComprobanteFormaPago=false;//ConEventDepend=true

	public Border resaltarid_clienteComprobanteFormaPago=null;
	public Boolean mostrarid_clienteComprobanteFormaPago=true;
	public Boolean activarid_clienteComprobanteFormaPago=false;
	public Boolean cargarid_clienteComprobanteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteComprobanteFormaPago=false;//ConEventDepend=true

	public Border resaltarid_cajaComprobanteFormaPago=null;
	public Boolean mostrarid_cajaComprobanteFormaPago=true;
	public Boolean activarid_cajaComprobanteFormaPago=false;
	public Boolean cargarid_cajaComprobanteFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaComprobanteFormaPago=false;//ConEventDepend=true

	public Border resaltarfecha_inicioComprobanteFormaPago=null;
	public Boolean mostrarfecha_inicioComprobanteFormaPago=true;
	public Boolean activarfecha_inicioComprobanteFormaPago=true;

	public Border resaltarfecha_finComprobanteFormaPago=null;
	public Boolean mostrarfecha_finComprobanteFormaPago=true;
	public Boolean activarfecha_finComprobanteFormaPago=true;

	public Border resaltarnombre_cajaComprobanteFormaPago=null;
	public Boolean mostrarnombre_cajaComprobanteFormaPago=true;
	public Boolean activarnombre_cajaComprobanteFormaPago=true;

	public Border resaltarsecuencialComprobanteFormaPago=null;
	public Boolean mostrarsecuencialComprobanteFormaPago=true;
	public Boolean activarsecuencialComprobanteFormaPago=true;

	public Border resaltarfechaComprobanteFormaPago=null;
	public Boolean mostrarfechaComprobanteFormaPago=true;
	public Boolean activarfechaComprobanteFormaPago=true;

	public Border resaltarcodigo_clienteComprobanteFormaPago=null;
	public Boolean mostrarcodigo_clienteComprobanteFormaPago=true;
	public Boolean activarcodigo_clienteComprobanteFormaPago=true;

	public Border resaltarnombre_clienteComprobanteFormaPago=null;
	public Boolean mostrarnombre_clienteComprobanteFormaPago=true;
	public Boolean activarnombre_clienteComprobanteFormaPago=true;

	public Border resaltarsubtotalComprobanteFormaPago=null;
	public Boolean mostrarsubtotalComprobanteFormaPago=true;
	public Boolean activarsubtotalComprobanteFormaPago=true;

	public Border resaltarivaComprobanteFormaPago=null;
	public Boolean mostrarivaComprobanteFormaPago=true;
	public Boolean activarivaComprobanteFormaPago=true;

	public Border resaltardescuentoComprobanteFormaPago=null;
	public Boolean mostrardescuentoComprobanteFormaPago=true;
	public Boolean activardescuentoComprobanteFormaPago=true;

	public Border resaltarfinanciamientoComprobanteFormaPago=null;
	public Boolean mostrarfinanciamientoComprobanteFormaPago=true;
	public Boolean activarfinanciamientoComprobanteFormaPago=true;

	public Border resaltarfleteComprobanteFormaPago=null;
	public Boolean mostrarfleteComprobanteFormaPago=true;
	public Boolean activarfleteComprobanteFormaPago=true;

	public Border resaltariceComprobanteFormaPago=null;
	public Boolean mostrariceComprobanteFormaPago=true;
	public Boolean activariceComprobanteFormaPago=true;

	public Border resaltartotalComprobanteFormaPago=null;
	public Boolean mostrartotalComprobanteFormaPago=true;
	public Boolean activartotalComprobanteFormaPago=true;

	public Border resaltartipoComprobanteFormaPago=null;
	public Boolean mostrartipoComprobanteFormaPago=true;
	public Boolean activartipoComprobanteFormaPago=true;

	public Border resaltarvalorComprobanteFormaPago=null;
	public Boolean mostrarvalorComprobanteFormaPago=true;
	public Boolean activarvalorComprobanteFormaPago=true;

	public Border resaltarfecha_forma_pagoComprobanteFormaPago=null;
	public Boolean mostrarfecha_forma_pagoComprobanteFormaPago=true;
	public Boolean activarfecha_forma_pagoComprobanteFormaPago=true;

	public Border resaltarnumero_cuentaComprobanteFormaPago=null;
	public Boolean mostrarnumero_cuentaComprobanteFormaPago=true;
	public Boolean activarnumero_cuentaComprobanteFormaPago=true;

	public Border resaltarnumero_chequeComprobanteFormaPago=null;
	public Boolean mostrarnumero_chequeComprobanteFormaPago=true;
	public Boolean activarnumero_chequeComprobanteFormaPago=true;

	public Border resaltargiradorComprobanteFormaPago=null;
	public Boolean mostrargiradorComprobanteFormaPago=true;
	public Boolean activargiradorComprobanteFormaPago=true;

	public Border resaltarnumero_dias_plazoComprobanteFormaPago=null;
	public Boolean mostrarnumero_dias_plazoComprobanteFormaPago=true;
	public Boolean activarnumero_dias_plazoComprobanteFormaPago=true;

	public Border resaltarnumero_tarjetaComprobanteFormaPago=null;
	public Boolean mostrarnumero_tarjetaComprobanteFormaPago=true;
	public Boolean activarnumero_tarjetaComprobanteFormaPago=true;

	public Border resaltarautorizacionComprobanteFormaPago=null;
	public Boolean mostrarautorizacionComprobanteFormaPago=true;
	public Boolean activarautorizacionComprobanteFormaPago=true;

	public Border resaltarloteComprobanteFormaPago=null;
	public Boolean mostrarloteComprobanteFormaPago=true;
	public Boolean activarloteComprobanteFormaPago=true;

	
	

	public Border setResaltaridComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltaridComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComprobanteFormaPago() {
		return this.resaltaridComprobanteFormaPago;
	}

	public void setResaltaridComprobanteFormaPago(Border borderResaltar) {
		this.resaltaridComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostraridComprobanteFormaPago() {
		return this.mostraridComprobanteFormaPago;
	}

	public void setMostraridComprobanteFormaPago(Boolean mostraridComprobanteFormaPago) {
		this.mostraridComprobanteFormaPago= mostraridComprobanteFormaPago;
	}

	public Boolean getActivaridComprobanteFormaPago() {
		return this.activaridComprobanteFormaPago;
	}

	public void setActivaridComprobanteFormaPago(Boolean activaridComprobanteFormaPago) {
		this.activaridComprobanteFormaPago= activaridComprobanteFormaPago;
	}

	public Border setResaltarid_empresaComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComprobanteFormaPago() {
		return this.resaltarid_empresaComprobanteFormaPago;
	}

	public void setResaltarid_empresaComprobanteFormaPago(Border borderResaltar) {
		this.resaltarid_empresaComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaComprobanteFormaPago() {
		return this.mostrarid_empresaComprobanteFormaPago;
	}

	public void setMostrarid_empresaComprobanteFormaPago(Boolean mostrarid_empresaComprobanteFormaPago) {
		this.mostrarid_empresaComprobanteFormaPago= mostrarid_empresaComprobanteFormaPago;
	}

	public Boolean getActivarid_empresaComprobanteFormaPago() {
		return this.activarid_empresaComprobanteFormaPago;
	}

	public void setActivarid_empresaComprobanteFormaPago(Boolean activarid_empresaComprobanteFormaPago) {
		this.activarid_empresaComprobanteFormaPago= activarid_empresaComprobanteFormaPago;
	}

	public Boolean getCargarid_empresaComprobanteFormaPago() {
		return this.cargarid_empresaComprobanteFormaPago;
	}

	public void setCargarid_empresaComprobanteFormaPago(Boolean cargarid_empresaComprobanteFormaPago) {
		this.cargarid_empresaComprobanteFormaPago= cargarid_empresaComprobanteFormaPago;
	}

	public Border setResaltarid_sucursalComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalComprobanteFormaPago() {
		return this.resaltarid_sucursalComprobanteFormaPago;
	}

	public void setResaltarid_sucursalComprobanteFormaPago(Border borderResaltar) {
		this.resaltarid_sucursalComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalComprobanteFormaPago() {
		return this.mostrarid_sucursalComprobanteFormaPago;
	}

	public void setMostrarid_sucursalComprobanteFormaPago(Boolean mostrarid_sucursalComprobanteFormaPago) {
		this.mostrarid_sucursalComprobanteFormaPago= mostrarid_sucursalComprobanteFormaPago;
	}

	public Boolean getActivarid_sucursalComprobanteFormaPago() {
		return this.activarid_sucursalComprobanteFormaPago;
	}

	public void setActivarid_sucursalComprobanteFormaPago(Boolean activarid_sucursalComprobanteFormaPago) {
		this.activarid_sucursalComprobanteFormaPago= activarid_sucursalComprobanteFormaPago;
	}

	public Boolean getCargarid_sucursalComprobanteFormaPago() {
		return this.cargarid_sucursalComprobanteFormaPago;
	}

	public void setCargarid_sucursalComprobanteFormaPago(Boolean cargarid_sucursalComprobanteFormaPago) {
		this.cargarid_sucursalComprobanteFormaPago= cargarid_sucursalComprobanteFormaPago;
	}

	public Border setResaltarid_clienteComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_clienteComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteComprobanteFormaPago() {
		return this.resaltarid_clienteComprobanteFormaPago;
	}

	public void setResaltarid_clienteComprobanteFormaPago(Border borderResaltar) {
		this.resaltarid_clienteComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_clienteComprobanteFormaPago() {
		return this.mostrarid_clienteComprobanteFormaPago;
	}

	public void setMostrarid_clienteComprobanteFormaPago(Boolean mostrarid_clienteComprobanteFormaPago) {
		this.mostrarid_clienteComprobanteFormaPago= mostrarid_clienteComprobanteFormaPago;
	}

	public Boolean getActivarid_clienteComprobanteFormaPago() {
		return this.activarid_clienteComprobanteFormaPago;
	}

	public void setActivarid_clienteComprobanteFormaPago(Boolean activarid_clienteComprobanteFormaPago) {
		this.activarid_clienteComprobanteFormaPago= activarid_clienteComprobanteFormaPago;
	}

	public Boolean getCargarid_clienteComprobanteFormaPago() {
		return this.cargarid_clienteComprobanteFormaPago;
	}

	public void setCargarid_clienteComprobanteFormaPago(Boolean cargarid_clienteComprobanteFormaPago) {
		this.cargarid_clienteComprobanteFormaPago= cargarid_clienteComprobanteFormaPago;
	}

	public Border setResaltarid_cajaComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_cajaComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaComprobanteFormaPago() {
		return this.resaltarid_cajaComprobanteFormaPago;
	}

	public void setResaltarid_cajaComprobanteFormaPago(Border borderResaltar) {
		this.resaltarid_cajaComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_cajaComprobanteFormaPago() {
		return this.mostrarid_cajaComprobanteFormaPago;
	}

	public void setMostrarid_cajaComprobanteFormaPago(Boolean mostrarid_cajaComprobanteFormaPago) {
		this.mostrarid_cajaComprobanteFormaPago= mostrarid_cajaComprobanteFormaPago;
	}

	public Boolean getActivarid_cajaComprobanteFormaPago() {
		return this.activarid_cajaComprobanteFormaPago;
	}

	public void setActivarid_cajaComprobanteFormaPago(Boolean activarid_cajaComprobanteFormaPago) {
		this.activarid_cajaComprobanteFormaPago= activarid_cajaComprobanteFormaPago;
	}

	public Boolean getCargarid_cajaComprobanteFormaPago() {
		return this.cargarid_cajaComprobanteFormaPago;
	}

	public void setCargarid_cajaComprobanteFormaPago(Boolean cargarid_cajaComprobanteFormaPago) {
		this.cargarid_cajaComprobanteFormaPago= cargarid_cajaComprobanteFormaPago;
	}

	public Border setResaltarfecha_inicioComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioComprobanteFormaPago() {
		return this.resaltarfecha_inicioComprobanteFormaPago;
	}

	public void setResaltarfecha_inicioComprobanteFormaPago(Border borderResaltar) {
		this.resaltarfecha_inicioComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioComprobanteFormaPago() {
		return this.mostrarfecha_inicioComprobanteFormaPago;
	}

	public void setMostrarfecha_inicioComprobanteFormaPago(Boolean mostrarfecha_inicioComprobanteFormaPago) {
		this.mostrarfecha_inicioComprobanteFormaPago= mostrarfecha_inicioComprobanteFormaPago;
	}

	public Boolean getActivarfecha_inicioComprobanteFormaPago() {
		return this.activarfecha_inicioComprobanteFormaPago;
	}

	public void setActivarfecha_inicioComprobanteFormaPago(Boolean activarfecha_inicioComprobanteFormaPago) {
		this.activarfecha_inicioComprobanteFormaPago= activarfecha_inicioComprobanteFormaPago;
	}

	public Border setResaltarfecha_finComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarfecha_finComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finComprobanteFormaPago() {
		return this.resaltarfecha_finComprobanteFormaPago;
	}

	public void setResaltarfecha_finComprobanteFormaPago(Border borderResaltar) {
		this.resaltarfecha_finComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarfecha_finComprobanteFormaPago() {
		return this.mostrarfecha_finComprobanteFormaPago;
	}

	public void setMostrarfecha_finComprobanteFormaPago(Boolean mostrarfecha_finComprobanteFormaPago) {
		this.mostrarfecha_finComprobanteFormaPago= mostrarfecha_finComprobanteFormaPago;
	}

	public Boolean getActivarfecha_finComprobanteFormaPago() {
		return this.activarfecha_finComprobanteFormaPago;
	}

	public void setActivarfecha_finComprobanteFormaPago(Boolean activarfecha_finComprobanteFormaPago) {
		this.activarfecha_finComprobanteFormaPago= activarfecha_finComprobanteFormaPago;
	}

	public Border setResaltarnombre_cajaComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombre_cajaComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cajaComprobanteFormaPago() {
		return this.resaltarnombre_cajaComprobanteFormaPago;
	}

	public void setResaltarnombre_cajaComprobanteFormaPago(Border borderResaltar) {
		this.resaltarnombre_cajaComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombre_cajaComprobanteFormaPago() {
		return this.mostrarnombre_cajaComprobanteFormaPago;
	}

	public void setMostrarnombre_cajaComprobanteFormaPago(Boolean mostrarnombre_cajaComprobanteFormaPago) {
		this.mostrarnombre_cajaComprobanteFormaPago= mostrarnombre_cajaComprobanteFormaPago;
	}

	public Boolean getActivarnombre_cajaComprobanteFormaPago() {
		return this.activarnombre_cajaComprobanteFormaPago;
	}

	public void setActivarnombre_cajaComprobanteFormaPago(Boolean activarnombre_cajaComprobanteFormaPago) {
		this.activarnombre_cajaComprobanteFormaPago= activarnombre_cajaComprobanteFormaPago;
	}

	public Border setResaltarsecuencialComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarsecuencialComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialComprobanteFormaPago() {
		return this.resaltarsecuencialComprobanteFormaPago;
	}

	public void setResaltarsecuencialComprobanteFormaPago(Border borderResaltar) {
		this.resaltarsecuencialComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarsecuencialComprobanteFormaPago() {
		return this.mostrarsecuencialComprobanteFormaPago;
	}

	public void setMostrarsecuencialComprobanteFormaPago(Boolean mostrarsecuencialComprobanteFormaPago) {
		this.mostrarsecuencialComprobanteFormaPago= mostrarsecuencialComprobanteFormaPago;
	}

	public Boolean getActivarsecuencialComprobanteFormaPago() {
		return this.activarsecuencialComprobanteFormaPago;
	}

	public void setActivarsecuencialComprobanteFormaPago(Boolean activarsecuencialComprobanteFormaPago) {
		this.activarsecuencialComprobanteFormaPago= activarsecuencialComprobanteFormaPago;
	}

	public Border setResaltarfechaComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarfechaComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaComprobanteFormaPago() {
		return this.resaltarfechaComprobanteFormaPago;
	}

	public void setResaltarfechaComprobanteFormaPago(Border borderResaltar) {
		this.resaltarfechaComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarfechaComprobanteFormaPago() {
		return this.mostrarfechaComprobanteFormaPago;
	}

	public void setMostrarfechaComprobanteFormaPago(Boolean mostrarfechaComprobanteFormaPago) {
		this.mostrarfechaComprobanteFormaPago= mostrarfechaComprobanteFormaPago;
	}

	public Boolean getActivarfechaComprobanteFormaPago() {
		return this.activarfechaComprobanteFormaPago;
	}

	public void setActivarfechaComprobanteFormaPago(Boolean activarfechaComprobanteFormaPago) {
		this.activarfechaComprobanteFormaPago= activarfechaComprobanteFormaPago;
	}

	public Border setResaltarcodigo_clienteComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteComprobanteFormaPago() {
		return this.resaltarcodigo_clienteComprobanteFormaPago;
	}

	public void setResaltarcodigo_clienteComprobanteFormaPago(Border borderResaltar) {
		this.resaltarcodigo_clienteComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteComprobanteFormaPago() {
		return this.mostrarcodigo_clienteComprobanteFormaPago;
	}

	public void setMostrarcodigo_clienteComprobanteFormaPago(Boolean mostrarcodigo_clienteComprobanteFormaPago) {
		this.mostrarcodigo_clienteComprobanteFormaPago= mostrarcodigo_clienteComprobanteFormaPago;
	}

	public Boolean getActivarcodigo_clienteComprobanteFormaPago() {
		return this.activarcodigo_clienteComprobanteFormaPago;
	}

	public void setActivarcodigo_clienteComprobanteFormaPago(Boolean activarcodigo_clienteComprobanteFormaPago) {
		this.activarcodigo_clienteComprobanteFormaPago= activarcodigo_clienteComprobanteFormaPago;
	}

	public Border setResaltarnombre_clienteComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteComprobanteFormaPago() {
		return this.resaltarnombre_clienteComprobanteFormaPago;
	}

	public void setResaltarnombre_clienteComprobanteFormaPago(Border borderResaltar) {
		this.resaltarnombre_clienteComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteComprobanteFormaPago() {
		return this.mostrarnombre_clienteComprobanteFormaPago;
	}

	public void setMostrarnombre_clienteComprobanteFormaPago(Boolean mostrarnombre_clienteComprobanteFormaPago) {
		this.mostrarnombre_clienteComprobanteFormaPago= mostrarnombre_clienteComprobanteFormaPago;
	}

	public Boolean getActivarnombre_clienteComprobanteFormaPago() {
		return this.activarnombre_clienteComprobanteFormaPago;
	}

	public void setActivarnombre_clienteComprobanteFormaPago(Boolean activarnombre_clienteComprobanteFormaPago) {
		this.activarnombre_clienteComprobanteFormaPago= activarnombre_clienteComprobanteFormaPago;
	}

	public Border setResaltarsubtotalComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarsubtotalComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalComprobanteFormaPago() {
		return this.resaltarsubtotalComprobanteFormaPago;
	}

	public void setResaltarsubtotalComprobanteFormaPago(Border borderResaltar) {
		this.resaltarsubtotalComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarsubtotalComprobanteFormaPago() {
		return this.mostrarsubtotalComprobanteFormaPago;
	}

	public void setMostrarsubtotalComprobanteFormaPago(Boolean mostrarsubtotalComprobanteFormaPago) {
		this.mostrarsubtotalComprobanteFormaPago= mostrarsubtotalComprobanteFormaPago;
	}

	public Boolean getActivarsubtotalComprobanteFormaPago() {
		return this.activarsubtotalComprobanteFormaPago;
	}

	public void setActivarsubtotalComprobanteFormaPago(Boolean activarsubtotalComprobanteFormaPago) {
		this.activarsubtotalComprobanteFormaPago= activarsubtotalComprobanteFormaPago;
	}

	public Border setResaltarivaComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarivaComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaComprobanteFormaPago() {
		return this.resaltarivaComprobanteFormaPago;
	}

	public void setResaltarivaComprobanteFormaPago(Border borderResaltar) {
		this.resaltarivaComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarivaComprobanteFormaPago() {
		return this.mostrarivaComprobanteFormaPago;
	}

	public void setMostrarivaComprobanteFormaPago(Boolean mostrarivaComprobanteFormaPago) {
		this.mostrarivaComprobanteFormaPago= mostrarivaComprobanteFormaPago;
	}

	public Boolean getActivarivaComprobanteFormaPago() {
		return this.activarivaComprobanteFormaPago;
	}

	public void setActivarivaComprobanteFormaPago(Boolean activarivaComprobanteFormaPago) {
		this.activarivaComprobanteFormaPago= activarivaComprobanteFormaPago;
	}

	public Border setResaltardescuentoComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltardescuentoComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoComprobanteFormaPago() {
		return this.resaltardescuentoComprobanteFormaPago;
	}

	public void setResaltardescuentoComprobanteFormaPago(Border borderResaltar) {
		this.resaltardescuentoComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrardescuentoComprobanteFormaPago() {
		return this.mostrardescuentoComprobanteFormaPago;
	}

	public void setMostrardescuentoComprobanteFormaPago(Boolean mostrardescuentoComprobanteFormaPago) {
		this.mostrardescuentoComprobanteFormaPago= mostrardescuentoComprobanteFormaPago;
	}

	public Boolean getActivardescuentoComprobanteFormaPago() {
		return this.activardescuentoComprobanteFormaPago;
	}

	public void setActivardescuentoComprobanteFormaPago(Boolean activardescuentoComprobanteFormaPago) {
		this.activardescuentoComprobanteFormaPago= activardescuentoComprobanteFormaPago;
	}

	public Border setResaltarfinanciamientoComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoComprobanteFormaPago() {
		return this.resaltarfinanciamientoComprobanteFormaPago;
	}

	public void setResaltarfinanciamientoComprobanteFormaPago(Border borderResaltar) {
		this.resaltarfinanciamientoComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoComprobanteFormaPago() {
		return this.mostrarfinanciamientoComprobanteFormaPago;
	}

	public void setMostrarfinanciamientoComprobanteFormaPago(Boolean mostrarfinanciamientoComprobanteFormaPago) {
		this.mostrarfinanciamientoComprobanteFormaPago= mostrarfinanciamientoComprobanteFormaPago;
	}

	public Boolean getActivarfinanciamientoComprobanteFormaPago() {
		return this.activarfinanciamientoComprobanteFormaPago;
	}

	public void setActivarfinanciamientoComprobanteFormaPago(Boolean activarfinanciamientoComprobanteFormaPago) {
		this.activarfinanciamientoComprobanteFormaPago= activarfinanciamientoComprobanteFormaPago;
	}

	public Border setResaltarfleteComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarfleteComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteComprobanteFormaPago() {
		return this.resaltarfleteComprobanteFormaPago;
	}

	public void setResaltarfleteComprobanteFormaPago(Border borderResaltar) {
		this.resaltarfleteComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarfleteComprobanteFormaPago() {
		return this.mostrarfleteComprobanteFormaPago;
	}

	public void setMostrarfleteComprobanteFormaPago(Boolean mostrarfleteComprobanteFormaPago) {
		this.mostrarfleteComprobanteFormaPago= mostrarfleteComprobanteFormaPago;
	}

	public Boolean getActivarfleteComprobanteFormaPago() {
		return this.activarfleteComprobanteFormaPago;
	}

	public void setActivarfleteComprobanteFormaPago(Boolean activarfleteComprobanteFormaPago) {
		this.activarfleteComprobanteFormaPago= activarfleteComprobanteFormaPago;
	}

	public Border setResaltariceComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltariceComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceComprobanteFormaPago() {
		return this.resaltariceComprobanteFormaPago;
	}

	public void setResaltariceComprobanteFormaPago(Border borderResaltar) {
		this.resaltariceComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrariceComprobanteFormaPago() {
		return this.mostrariceComprobanteFormaPago;
	}

	public void setMostrariceComprobanteFormaPago(Boolean mostrariceComprobanteFormaPago) {
		this.mostrariceComprobanteFormaPago= mostrariceComprobanteFormaPago;
	}

	public Boolean getActivariceComprobanteFormaPago() {
		return this.activariceComprobanteFormaPago;
	}

	public void setActivariceComprobanteFormaPago(Boolean activariceComprobanteFormaPago) {
		this.activariceComprobanteFormaPago= activariceComprobanteFormaPago;
	}

	public Border setResaltartotalComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltartotalComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalComprobanteFormaPago() {
		return this.resaltartotalComprobanteFormaPago;
	}

	public void setResaltartotalComprobanteFormaPago(Border borderResaltar) {
		this.resaltartotalComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrartotalComprobanteFormaPago() {
		return this.mostrartotalComprobanteFormaPago;
	}

	public void setMostrartotalComprobanteFormaPago(Boolean mostrartotalComprobanteFormaPago) {
		this.mostrartotalComprobanteFormaPago= mostrartotalComprobanteFormaPago;
	}

	public Boolean getActivartotalComprobanteFormaPago() {
		return this.activartotalComprobanteFormaPago;
	}

	public void setActivartotalComprobanteFormaPago(Boolean activartotalComprobanteFormaPago) {
		this.activartotalComprobanteFormaPago= activartotalComprobanteFormaPago;
	}

	public Border setResaltartipoComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltartipoComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoComprobanteFormaPago() {
		return this.resaltartipoComprobanteFormaPago;
	}

	public void setResaltartipoComprobanteFormaPago(Border borderResaltar) {
		this.resaltartipoComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrartipoComprobanteFormaPago() {
		return this.mostrartipoComprobanteFormaPago;
	}

	public void setMostrartipoComprobanteFormaPago(Boolean mostrartipoComprobanteFormaPago) {
		this.mostrartipoComprobanteFormaPago= mostrartipoComprobanteFormaPago;
	}

	public Boolean getActivartipoComprobanteFormaPago() {
		return this.activartipoComprobanteFormaPago;
	}

	public void setActivartipoComprobanteFormaPago(Boolean activartipoComprobanteFormaPago) {
		this.activartipoComprobanteFormaPago= activartipoComprobanteFormaPago;
	}

	public Border setResaltarvalorComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarvalorComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorComprobanteFormaPago() {
		return this.resaltarvalorComprobanteFormaPago;
	}

	public void setResaltarvalorComprobanteFormaPago(Border borderResaltar) {
		this.resaltarvalorComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarvalorComprobanteFormaPago() {
		return this.mostrarvalorComprobanteFormaPago;
	}

	public void setMostrarvalorComprobanteFormaPago(Boolean mostrarvalorComprobanteFormaPago) {
		this.mostrarvalorComprobanteFormaPago= mostrarvalorComprobanteFormaPago;
	}

	public Boolean getActivarvalorComprobanteFormaPago() {
		return this.activarvalorComprobanteFormaPago;
	}

	public void setActivarvalorComprobanteFormaPago(Boolean activarvalorComprobanteFormaPago) {
		this.activarvalorComprobanteFormaPago= activarvalorComprobanteFormaPago;
	}

	public Border setResaltarfecha_forma_pagoComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarfecha_forma_pagoComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_forma_pagoComprobanteFormaPago() {
		return this.resaltarfecha_forma_pagoComprobanteFormaPago;
	}

	public void setResaltarfecha_forma_pagoComprobanteFormaPago(Border borderResaltar) {
		this.resaltarfecha_forma_pagoComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarfecha_forma_pagoComprobanteFormaPago() {
		return this.mostrarfecha_forma_pagoComprobanteFormaPago;
	}

	public void setMostrarfecha_forma_pagoComprobanteFormaPago(Boolean mostrarfecha_forma_pagoComprobanteFormaPago) {
		this.mostrarfecha_forma_pagoComprobanteFormaPago= mostrarfecha_forma_pagoComprobanteFormaPago;
	}

	public Boolean getActivarfecha_forma_pagoComprobanteFormaPago() {
		return this.activarfecha_forma_pagoComprobanteFormaPago;
	}

	public void setActivarfecha_forma_pagoComprobanteFormaPago(Boolean activarfecha_forma_pagoComprobanteFormaPago) {
		this.activarfecha_forma_pagoComprobanteFormaPago= activarfecha_forma_pagoComprobanteFormaPago;
	}

	public Border setResaltarnumero_cuentaComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaComprobanteFormaPago() {
		return this.resaltarnumero_cuentaComprobanteFormaPago;
	}

	public void setResaltarnumero_cuentaComprobanteFormaPago(Border borderResaltar) {
		this.resaltarnumero_cuentaComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaComprobanteFormaPago() {
		return this.mostrarnumero_cuentaComprobanteFormaPago;
	}

	public void setMostrarnumero_cuentaComprobanteFormaPago(Boolean mostrarnumero_cuentaComprobanteFormaPago) {
		this.mostrarnumero_cuentaComprobanteFormaPago= mostrarnumero_cuentaComprobanteFormaPago;
	}

	public Boolean getActivarnumero_cuentaComprobanteFormaPago() {
		return this.activarnumero_cuentaComprobanteFormaPago;
	}

	public void setActivarnumero_cuentaComprobanteFormaPago(Boolean activarnumero_cuentaComprobanteFormaPago) {
		this.activarnumero_cuentaComprobanteFormaPago= activarnumero_cuentaComprobanteFormaPago;
	}

	public Border setResaltarnumero_chequeComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeComprobanteFormaPago() {
		return this.resaltarnumero_chequeComprobanteFormaPago;
	}

	public void setResaltarnumero_chequeComprobanteFormaPago(Border borderResaltar) {
		this.resaltarnumero_chequeComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeComprobanteFormaPago() {
		return this.mostrarnumero_chequeComprobanteFormaPago;
	}

	public void setMostrarnumero_chequeComprobanteFormaPago(Boolean mostrarnumero_chequeComprobanteFormaPago) {
		this.mostrarnumero_chequeComprobanteFormaPago= mostrarnumero_chequeComprobanteFormaPago;
	}

	public Boolean getActivarnumero_chequeComprobanteFormaPago() {
		return this.activarnumero_chequeComprobanteFormaPago;
	}

	public void setActivarnumero_chequeComprobanteFormaPago(Boolean activarnumero_chequeComprobanteFormaPago) {
		this.activarnumero_chequeComprobanteFormaPago= activarnumero_chequeComprobanteFormaPago;
	}

	public Border setResaltargiradorComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltargiradorComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargiradorComprobanteFormaPago() {
		return this.resaltargiradorComprobanteFormaPago;
	}

	public void setResaltargiradorComprobanteFormaPago(Border borderResaltar) {
		this.resaltargiradorComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrargiradorComprobanteFormaPago() {
		return this.mostrargiradorComprobanteFormaPago;
	}

	public void setMostrargiradorComprobanteFormaPago(Boolean mostrargiradorComprobanteFormaPago) {
		this.mostrargiradorComprobanteFormaPago= mostrargiradorComprobanteFormaPago;
	}

	public Boolean getActivargiradorComprobanteFormaPago() {
		return this.activargiradorComprobanteFormaPago;
	}

	public void setActivargiradorComprobanteFormaPago(Boolean activargiradorComprobanteFormaPago) {
		this.activargiradorComprobanteFormaPago= activargiradorComprobanteFormaPago;
	}

	public Border setResaltarnumero_dias_plazoComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_dias_plazoComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_dias_plazoComprobanteFormaPago() {
		return this.resaltarnumero_dias_plazoComprobanteFormaPago;
	}

	public void setResaltarnumero_dias_plazoComprobanteFormaPago(Border borderResaltar) {
		this.resaltarnumero_dias_plazoComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_dias_plazoComprobanteFormaPago() {
		return this.mostrarnumero_dias_plazoComprobanteFormaPago;
	}

	public void setMostrarnumero_dias_plazoComprobanteFormaPago(Boolean mostrarnumero_dias_plazoComprobanteFormaPago) {
		this.mostrarnumero_dias_plazoComprobanteFormaPago= mostrarnumero_dias_plazoComprobanteFormaPago;
	}

	public Boolean getActivarnumero_dias_plazoComprobanteFormaPago() {
		return this.activarnumero_dias_plazoComprobanteFormaPago;
	}

	public void setActivarnumero_dias_plazoComprobanteFormaPago(Boolean activarnumero_dias_plazoComprobanteFormaPago) {
		this.activarnumero_dias_plazoComprobanteFormaPago= activarnumero_dias_plazoComprobanteFormaPago;
	}

	public Border setResaltarnumero_tarjetaComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_tarjetaComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_tarjetaComprobanteFormaPago() {
		return this.resaltarnumero_tarjetaComprobanteFormaPago;
	}

	public void setResaltarnumero_tarjetaComprobanteFormaPago(Border borderResaltar) {
		this.resaltarnumero_tarjetaComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_tarjetaComprobanteFormaPago() {
		return this.mostrarnumero_tarjetaComprobanteFormaPago;
	}

	public void setMostrarnumero_tarjetaComprobanteFormaPago(Boolean mostrarnumero_tarjetaComprobanteFormaPago) {
		this.mostrarnumero_tarjetaComprobanteFormaPago= mostrarnumero_tarjetaComprobanteFormaPago;
	}

	public Boolean getActivarnumero_tarjetaComprobanteFormaPago() {
		return this.activarnumero_tarjetaComprobanteFormaPago;
	}

	public void setActivarnumero_tarjetaComprobanteFormaPago(Boolean activarnumero_tarjetaComprobanteFormaPago) {
		this.activarnumero_tarjetaComprobanteFormaPago= activarnumero_tarjetaComprobanteFormaPago;
	}

	public Border setResaltarautorizacionComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarautorizacionComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacionComprobanteFormaPago() {
		return this.resaltarautorizacionComprobanteFormaPago;
	}

	public void setResaltarautorizacionComprobanteFormaPago(Border borderResaltar) {
		this.resaltarautorizacionComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarautorizacionComprobanteFormaPago() {
		return this.mostrarautorizacionComprobanteFormaPago;
	}

	public void setMostrarautorizacionComprobanteFormaPago(Boolean mostrarautorizacionComprobanteFormaPago) {
		this.mostrarautorizacionComprobanteFormaPago= mostrarautorizacionComprobanteFormaPago;
	}

	public Boolean getActivarautorizacionComprobanteFormaPago() {
		return this.activarautorizacionComprobanteFormaPago;
	}

	public void setActivarautorizacionComprobanteFormaPago(Boolean activarautorizacionComprobanteFormaPago) {
		this.activarautorizacionComprobanteFormaPago= activarautorizacionComprobanteFormaPago;
	}

	public Border setResaltarloteComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobanteformapagoBeanSwingJInternalFrame.jTtoolBarComprobanteFormaPago.setBorder(borderResaltar);
		
		this.resaltarloteComprobanteFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteComprobanteFormaPago() {
		return this.resaltarloteComprobanteFormaPago;
	}

	public void setResaltarloteComprobanteFormaPago(Border borderResaltar) {
		this.resaltarloteComprobanteFormaPago= borderResaltar;
	}

	public Boolean getMostrarloteComprobanteFormaPago() {
		return this.mostrarloteComprobanteFormaPago;
	}

	public void setMostrarloteComprobanteFormaPago(Boolean mostrarloteComprobanteFormaPago) {
		this.mostrarloteComprobanteFormaPago= mostrarloteComprobanteFormaPago;
	}

	public Boolean getActivarloteComprobanteFormaPago() {
		return this.activarloteComprobanteFormaPago;
	}

	public void setActivarloteComprobanteFormaPago(Boolean activarloteComprobanteFormaPago) {
		this.activarloteComprobanteFormaPago= activarloteComprobanteFormaPago;
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
		
		
		this.setMostraridComprobanteFormaPago(esInicial);
		this.setMostrarid_empresaComprobanteFormaPago(esInicial);
		this.setMostrarid_sucursalComprobanteFormaPago(esInicial);
		this.setMostrarid_clienteComprobanteFormaPago(esInicial);
		this.setMostrarid_cajaComprobanteFormaPago(esInicial);
		this.setMostrarfecha_inicioComprobanteFormaPago(esInicial);
		this.setMostrarfecha_finComprobanteFormaPago(esInicial);
		this.setMostrarnombre_cajaComprobanteFormaPago(esInicial);
		this.setMostrarsecuencialComprobanteFormaPago(esInicial);
		this.setMostrarfechaComprobanteFormaPago(esInicial);
		this.setMostrarcodigo_clienteComprobanteFormaPago(esInicial);
		this.setMostrarnombre_clienteComprobanteFormaPago(esInicial);
		this.setMostrarsubtotalComprobanteFormaPago(esInicial);
		this.setMostrarivaComprobanteFormaPago(esInicial);
		this.setMostrardescuentoComprobanteFormaPago(esInicial);
		this.setMostrarfinanciamientoComprobanteFormaPago(esInicial);
		this.setMostrarfleteComprobanteFormaPago(esInicial);
		this.setMostrariceComprobanteFormaPago(esInicial);
		this.setMostrartotalComprobanteFormaPago(esInicial);
		this.setMostrartipoComprobanteFormaPago(esInicial);
		this.setMostrarvalorComprobanteFormaPago(esInicial);
		this.setMostrarfecha_forma_pagoComprobanteFormaPago(esInicial);
		this.setMostrarnumero_cuentaComprobanteFormaPago(esInicial);
		this.setMostrarnumero_chequeComprobanteFormaPago(esInicial);
		this.setMostrargiradorComprobanteFormaPago(esInicial);
		this.setMostrarnumero_dias_plazoComprobanteFormaPago(esInicial);
		this.setMostrarnumero_tarjetaComprobanteFormaPago(esInicial);
		this.setMostrarautorizacionComprobanteFormaPago(esInicial);
		this.setMostrarloteComprobanteFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.ID)) {
				this.setMostraridComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA)) {
				this.setMostrarnombre_cajaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHA)) {
				this.setMostrarfechaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IVA)) {
				this.setMostrarivaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FLETE)) {
				this.setMostrarfleteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.ICE)) {
				this.setMostrariceComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.TOTAL)) {
				this.setMostrartotalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.TIPO)) {
				this.setMostrartipoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.VALOR)) {
				this.setMostrarvalorComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO)) {
				this.setMostrarfecha_forma_pagoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.GIRADOR)) {
				this.setMostrargiradorComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO)) {
				this.setMostrarnumero_dias_plazoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA)) {
				this.setMostrarnumero_tarjetaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.AUTORIZACION)) {
				this.setMostrarautorizacionComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.LOTE)) {
				this.setMostrarloteComprobanteFormaPago(esAsigna);
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
		
		
		this.setActivaridComprobanteFormaPago(esInicial);
		this.setActivarid_empresaComprobanteFormaPago(esInicial);
		this.setActivarid_sucursalComprobanteFormaPago(esInicial);
		this.setActivarid_clienteComprobanteFormaPago(esInicial);
		this.setActivarid_cajaComprobanteFormaPago(esInicial);
		this.setActivarfecha_inicioComprobanteFormaPago(esInicial);
		this.setActivarfecha_finComprobanteFormaPago(esInicial);
		this.setActivarnombre_cajaComprobanteFormaPago(esInicial);
		this.setActivarsecuencialComprobanteFormaPago(esInicial);
		this.setActivarfechaComprobanteFormaPago(esInicial);
		this.setActivarcodigo_clienteComprobanteFormaPago(esInicial);
		this.setActivarnombre_clienteComprobanteFormaPago(esInicial);
		this.setActivarsubtotalComprobanteFormaPago(esInicial);
		this.setActivarivaComprobanteFormaPago(esInicial);
		this.setActivardescuentoComprobanteFormaPago(esInicial);
		this.setActivarfinanciamientoComprobanteFormaPago(esInicial);
		this.setActivarfleteComprobanteFormaPago(esInicial);
		this.setActivariceComprobanteFormaPago(esInicial);
		this.setActivartotalComprobanteFormaPago(esInicial);
		this.setActivartipoComprobanteFormaPago(esInicial);
		this.setActivarvalorComprobanteFormaPago(esInicial);
		this.setActivarfecha_forma_pagoComprobanteFormaPago(esInicial);
		this.setActivarnumero_cuentaComprobanteFormaPago(esInicial);
		this.setActivarnumero_chequeComprobanteFormaPago(esInicial);
		this.setActivargiradorComprobanteFormaPago(esInicial);
		this.setActivarnumero_dias_plazoComprobanteFormaPago(esInicial);
		this.setActivarnumero_tarjetaComprobanteFormaPago(esInicial);
		this.setActivarautorizacionComprobanteFormaPago(esInicial);
		this.setActivarloteComprobanteFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.ID)) {
				this.setActivaridComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA)) {
				this.setActivarnombre_cajaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHA)) {
				this.setActivarfechaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IVA)) {
				this.setActivarivaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FLETE)) {
				this.setActivarfleteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.ICE)) {
				this.setActivariceComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.TOTAL)) {
				this.setActivartotalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.TIPO)) {
				this.setActivartipoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.VALOR)) {
				this.setActivarvalorComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO)) {
				this.setActivarfecha_forma_pagoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.GIRADOR)) {
				this.setActivargiradorComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO)) {
				this.setActivarnumero_dias_plazoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA)) {
				this.setActivarnumero_tarjetaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.AUTORIZACION)) {
				this.setActivarautorizacionComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.LOTE)) {
				this.setActivarloteComprobanteFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComprobanteFormaPago(esInicial);
		this.setResaltarid_empresaComprobanteFormaPago(esInicial);
		this.setResaltarid_sucursalComprobanteFormaPago(esInicial);
		this.setResaltarid_clienteComprobanteFormaPago(esInicial);
		this.setResaltarid_cajaComprobanteFormaPago(esInicial);
		this.setResaltarfecha_inicioComprobanteFormaPago(esInicial);
		this.setResaltarfecha_finComprobanteFormaPago(esInicial);
		this.setResaltarnombre_cajaComprobanteFormaPago(esInicial);
		this.setResaltarsecuencialComprobanteFormaPago(esInicial);
		this.setResaltarfechaComprobanteFormaPago(esInicial);
		this.setResaltarcodigo_clienteComprobanteFormaPago(esInicial);
		this.setResaltarnombre_clienteComprobanteFormaPago(esInicial);
		this.setResaltarsubtotalComprobanteFormaPago(esInicial);
		this.setResaltarivaComprobanteFormaPago(esInicial);
		this.setResaltardescuentoComprobanteFormaPago(esInicial);
		this.setResaltarfinanciamientoComprobanteFormaPago(esInicial);
		this.setResaltarfleteComprobanteFormaPago(esInicial);
		this.setResaltariceComprobanteFormaPago(esInicial);
		this.setResaltartotalComprobanteFormaPago(esInicial);
		this.setResaltartipoComprobanteFormaPago(esInicial);
		this.setResaltarvalorComprobanteFormaPago(esInicial);
		this.setResaltarfecha_forma_pagoComprobanteFormaPago(esInicial);
		this.setResaltarnumero_cuentaComprobanteFormaPago(esInicial);
		this.setResaltarnumero_chequeComprobanteFormaPago(esInicial);
		this.setResaltargiradorComprobanteFormaPago(esInicial);
		this.setResaltarnumero_dias_plazoComprobanteFormaPago(esInicial);
		this.setResaltarnumero_tarjetaComprobanteFormaPago(esInicial);
		this.setResaltarautorizacionComprobanteFormaPago(esInicial);
		this.setResaltarloteComprobanteFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECAJA)) {
				this.setResaltarnombre_cajaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHA)) {
				this.setResaltarfechaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.IVA)) {
				this.setResaltarivaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FLETE)) {
				this.setResaltarfleteComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.ICE)) {
				this.setResaltariceComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.TOTAL)) {
				this.setResaltartotalComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.TIPO)) {
				this.setResaltartipoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.VALOR)) {
				this.setResaltarvalorComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.FECHAFORMAPAGO)) {
				this.setResaltarfecha_forma_pagoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.GIRADOR)) {
				this.setResaltargiradorComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMERODIASPLAZO)) {
				this.setResaltarnumero_dias_plazoComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.NUMEROTARJETA)) {
				this.setResaltarnumero_tarjetaComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.AUTORIZACION)) {
				this.setResaltarautorizacionComprobanteFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFormaPagoConstantesFunciones.LOTE)) {
				this.setResaltarloteComprobanteFormaPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaComprobanteFormaPagoComprobanteFormaPago=true;

	public Boolean getMostrarBusquedaComprobanteFormaPagoComprobanteFormaPago() {
		return this.mostrarBusquedaComprobanteFormaPagoComprobanteFormaPago;
	}

	public void setMostrarBusquedaComprobanteFormaPagoComprobanteFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaComprobanteFormaPagoComprobanteFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaComprobanteFormaPagoComprobanteFormaPago=true;

	public Boolean getActivarBusquedaComprobanteFormaPagoComprobanteFormaPago() {
		return this.activarBusquedaComprobanteFormaPagoComprobanteFormaPago;
	}

	public void setActivarBusquedaComprobanteFormaPagoComprobanteFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaComprobanteFormaPagoComprobanteFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaComprobanteFormaPagoComprobanteFormaPago=null;

	public Border getResaltarBusquedaComprobanteFormaPagoComprobanteFormaPago() {
		return this.resaltarBusquedaComprobanteFormaPagoComprobanteFormaPago;
	}

	public void setResaltarBusquedaComprobanteFormaPagoComprobanteFormaPago(Border borderResaltar) {
		this.resaltarBusquedaComprobanteFormaPagoComprobanteFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaComprobanteFormaPagoComprobanteFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFormaPagoBeanSwingJInternalFrame comprobanteformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaComprobanteFormaPagoComprobanteFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}