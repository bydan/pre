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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ParametroCompraConstantesFunciones;
import com.bydan.erp.inventario.util.ParametroCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ParametroCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroCompraConstantesFunciones extends ParametroCompraConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="ParametroCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroCompra"+ParametroCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroCompraConstantesFunciones.SCHEMA+"_"+ParametroCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroCompraConstantesFunciones.SCHEMA+"_"+ParametroCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroCompraConstantesFunciones.SCHEMA+"_"+ParametroCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroCompraConstantesFunciones.SCHEMA+"_"+ParametroCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Compraes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro Compra";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroCompra";
	public static final String OBJECTNAME="parametrocompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="parametro_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrocompra from "+ParametroCompraConstantesFunciones.SPERSISTENCENAME+" parametrocompra";
	public static String QUERYSELECTNATIVE="select "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".version_row,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_empresa,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".secuencial_pedido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".secuencial_cotizacion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".secuencial_produccion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_tipo_documento,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_bodega,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_bodega_reserva,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_empleado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_embarcador,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".con_centro_costo,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".texto_mail,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_modulo,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".descripcion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_pedido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_pendiente,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_cotizacion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_cotizado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_autorizacion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_autorizado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_item,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_anulado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_prioridad_pedido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_suspendido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_regularizado from "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME;//+" as "+ParametroCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroCompraConstantesFuncionesAdditional parametrocompraConstantesFuncionesAdditional=null;
	
	public ParametroCompraConstantesFuncionesAdditional getParametroCompraConstantesFuncionesAdditional() {
		return this.parametrocompraConstantesFuncionesAdditional;
	}
	
	public void setParametroCompraConstantesFuncionesAdditional(ParametroCompraConstantesFuncionesAdditional parametrocompraConstantesFuncionesAdditional) {
		try {
			this.parametrocompraConstantesFuncionesAdditional=parametrocompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String SECUENCIALPEDIDO= "secuencial_pedido";
    public static final String SECUENCIALCOTIZACION= "secuencial_cotizacion";
    public static final String SECUENCIALPRODUCCION= "secuencial_produccion";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDBODEGARESERVA= "id_bodega_reserva";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEMBARCADOR= "id_embarcador";
    public static final String CONCENTROCOSTO= "con_centro_costo";
    public static final String TEXTOMAIL= "texto_mail";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMOVIMIENTOMODULO= "id_tipo_movimiento_modulo";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDFORMATOPEDIDO= "id_formato_pedido";
    public static final String IDESTADOPEDIDOPENDIENTE= "id_estado_pedido_pendiente";
    public static final String IDFORMATOCOTIZACION= "id_formato_cotizacion";
    public static final String IDESTADOPEDIDOCOTIZADO= "id_estado_pedido_cotizado";
    public static final String IDFORMATOAUTORIZACION= "id_formato_autorizacion";
    public static final String IDESTADOPEDIDOAUTORIZADO= "id_estado_pedido_autorizado";
    public static final String IDFORMATOITEM= "id_formato_item";
    public static final String IDESTADOPEDIDOANULADO= "id_estado_pedido_anulado";
    public static final String IDPRIORIDADPEDIDO= "id_prioridad_pedido";
    public static final String IDESTADOPEDIDOSUSPENDIDO= "id_estado_pedido_suspendido";
    public static final String IDESTADOPEDIDOREGULARIZADO= "id_estado_pedido_regularizado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_SECUENCIALPEDIDO= "Secuencial Pedido";
		public static final String LABEL_SECUENCIALPEDIDO_LOWER= "Secuencial Pedido";
    	public static final String LABEL_SECUENCIALCOTIZACION= "Secuencial Cotizacion";
		public static final String LABEL_SECUENCIALCOTIZACION_LOWER= "Secuencial Cotizacion";
    	public static final String LABEL_SECUENCIALPRODUCCION= "Secuencial Produccion";
		public static final String LABEL_SECUENCIALPRODUCCION_LOWER= "Secuencial Produccion";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDBODEGARESERVA= "Bodega Reserva";
		public static final String LABEL_IDBODEGARESERVA_LOWER= "Bodega Reserva";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEMBARCADOR= "Embarcador";
		public static final String LABEL_IDEMBARCADOR_LOWER= "Embarcador";
    	public static final String LABEL_CONCENTROCOSTO= "Con Centro Costo";
		public static final String LABEL_CONCENTROCOSTO_LOWER= "Con Centro Costo";
    	public static final String LABEL_TEXTOMAIL= "Texto Mail";
		public static final String LABEL_TEXTOMAIL_LOWER= "Texto Mail";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTOMODULO= "Tipo Movimiento Modulo";
		public static final String LABEL_IDTIPOMOVIMIENTOMODULO_LOWER= "Tipo Movimiento Modulo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDFORMATOPEDIDO= "Formato Pedido";
		public static final String LABEL_IDFORMATOPEDIDO_LOWER= "Formato Pedido";
    	public static final String LABEL_IDESTADOPEDIDOPENDIENTE= "Estado Pedido Pendiente";
		public static final String LABEL_IDESTADOPEDIDOPENDIENTE_LOWER= "Estado Pedido Pendiente";
    	public static final String LABEL_IDFORMATOCOTIZACION= "Formato Cotizacion";
		public static final String LABEL_IDFORMATOCOTIZACION_LOWER= "Formato Cotizacion";
    	public static final String LABEL_IDESTADOPEDIDOCOTIZADO= "Estado Pedido Cotizado";
		public static final String LABEL_IDESTADOPEDIDOCOTIZADO_LOWER= "Estado Pedido Cotizado";
    	public static final String LABEL_IDFORMATOAUTORIZACION= "Formato Autorizacion";
		public static final String LABEL_IDFORMATOAUTORIZACION_LOWER= "Formato Autorizacion";
    	public static final String LABEL_IDESTADOPEDIDOAUTORIZADO= "Estado Pedido Autorizado";
		public static final String LABEL_IDESTADOPEDIDOAUTORIZADO_LOWER= "Estado Pedido Autorizado";
    	public static final String LABEL_IDFORMATOITEM= "Formato Item";
		public static final String LABEL_IDFORMATOITEM_LOWER= "Formato Item";
    	public static final String LABEL_IDESTADOPEDIDOANULADO= "Estado Pedido Anulado";
		public static final String LABEL_IDESTADOPEDIDOANULADO_LOWER= "Estado Pedido Anulado";
    	public static final String LABEL_IDPRIORIDADPEDIDO= "Prioridad Pedido";
		public static final String LABEL_IDPRIORIDADPEDIDO_LOWER= "Prioridad Pedido";
    	public static final String LABEL_IDESTADOPEDIDOSUSPENDIDO= "Estado Pedido Suspendo";
		public static final String LABEL_IDESTADOPEDIDOSUSPENDIDO_LOWER= "Estado Pedido Suspendido";
    	public static final String LABEL_IDESTADOPEDIDOREGULARIZADO= "Estado Pedido Regularizado";
		public static final String LABEL_IDESTADOPEDIDOREGULARIZADO_LOWER= "Estado Pedido Regularizado";
	
		
		
		
	public static final String SREGEXSECUENCIAL_PEDIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_PEDIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL_COTIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_COTIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL_PRODUCCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_PRODUCCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXTEXTO_MAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTEXTO_MAIL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.SECUENCIALPEDIDO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_SECUENCIALPEDIDO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_SECUENCIALCOTIZACION;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_SECUENCIALPRODUCCION;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDBODEGA)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDBODEGARESERVA)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDBODEGARESERVA;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDEMBARCADOR)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDEMBARCADOR;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.CONCENTROCOSTO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_CONCENTROCOSTO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.TEXTOMAIL)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_TEXTOMAIL;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDMODULO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDFORMATOPEDIDO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDFORMATOPEDIDO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOPENDIENTE;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDFORMATOCOTIZACION;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOTIZADO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDFORMATOAUTORIZACION;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOAUTORIZADO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDFORMATOITEM)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDFORMATOITEM;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOANULADO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDPRIORIDADPEDIDO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOSUSPENDIDO;}
		if(sNombreColumna.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO)) {sLabelColumna=ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOREGULARIZADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_centro_costoDescripcion(ParametroCompra parametrocompra) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrocompra.getcon_centro_costo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_centro_costoHtmlDescripcion(ParametroCompra parametrocompra) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrocompra.getId(),parametrocompra.getcon_centro_costo());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroCompraDescripcion(ParametroCompra parametrocompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrocompra !=null/* && parametrocompra.getId()!=0*/) {
			sDescripcion=parametrocompra.getsecuencial_cotizacion();//parametrocompraparametrocompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroCompraDescripcionDetallado(ParametroCompra parametrocompra) {
		String sDescripcion="";
			
		sDescripcion+=ParametroCompraConstantesFunciones.ID+"=";
		sDescripcion+=parametrocompra.getId().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrocompra.getVersionRow().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrocompra.getid_empresa().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.SECUENCIALPEDIDO+"=";
		sDescripcion+=parametrocompra.getsecuencial_pedido()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION+"=";
		sDescripcion+=parametrocompra.getsecuencial_cotizacion()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION+"=";
		sDescripcion+=parametrocompra.getsecuencial_produccion()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=parametrocompra.getid_tipo_documento().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=parametrocompra.getid_tipo_movimiento().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=parametrocompra.getid_bodega().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDBODEGARESERVA+"=";
		sDescripcion+=parametrocompra.getid_bodega_reserva().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=parametrocompra.getid_empleado().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDEMBARCADOR+"=";
		sDescripcion+=parametrocompra.getid_embarcador().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.CONCENTROCOSTO+"=";
		sDescripcion+=parametrocompra.getcon_centro_costo().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.TEXTOMAIL+"=";
		sDescripcion+=parametrocompra.gettexto_mail()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDMODULO+"=";
		sDescripcion+=parametrocompra.getid_modulo().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=parametrocompra.getid_tipo_movimiento_modulo().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=parametrocompra.getdescripcion()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDFORMATOPEDIDO+"=";
		sDescripcion+=parametrocompra.getid_formato_pedido().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE+"=";
		sDescripcion+=parametrocompra.getid_estado_pedido_pendiente().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION+"=";
		sDescripcion+=parametrocompra.getid_formato_cotizacion().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO+"=";
		sDescripcion+=parametrocompra.getid_estado_pedido_cotizado().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION+"=";
		sDescripcion+=parametrocompra.getid_formato_autorizacion().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO+"=";
		sDescripcion+=parametrocompra.getid_estado_pedido_autorizado().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDFORMATOITEM+"=";
		sDescripcion+=parametrocompra.getid_formato_item().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO+"=";
		sDescripcion+=parametrocompra.getid_estado_pedido_anulado().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO+"=";
		sDescripcion+=parametrocompra.getid_prioridad_pedido().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO+"=";
		sDescripcion+=parametrocompra.getid_estado_pedido_suspendido().toString()+",";
		sDescripcion+=ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO+"=";
		sDescripcion+=parametrocompra.getid_estado_pedido_regularizado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroCompraDescripcion(ParametroCompra parametrocompra,String sValor) throws Exception {			
		if(parametrocompra !=null) {
			parametrocompra.setsecuencial_cotizacion(sValor);//parametrocompraparametrocompra.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getBodegaReservaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEmbarcadorDescripcion(Embarcador embarcador) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(embarcador!=null/*&&embarcador.getId()>0*/) {
			sDescripcion=EmbarcadorConstantesFunciones.getEmbarcadorDescripcion(embarcador);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoModuloDescripcion(TipoMovimientoModulo tipomovimientomodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimientomodulo!=null/*&&tipomovimientomodulo.getId()>0*/) {
			sDescripcion=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(tipomovimientomodulo);
		}

		return sDescripcion;
	}

	public static String getFormatoPedidoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoPendienteDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}

	public static String getFormatoCotizacionDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoCotizadoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}

	public static String getFormatoAutorizacionDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoAutorizadoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}

	public static String getFormatoItemDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoAnuladoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}

	public static String getPrioridadPedidoDescripcion(PrioridadPedido prioridadpedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(prioridadpedido!=null/*&&prioridadpedido.getId()>0*/) {
			sDescripcion=PrioridadPedidoConstantesFunciones.getPrioridadPedidoDescripcion(prioridadpedido);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoSuspendidoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoRegularizadoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdBodegaReserva")) {
			sNombreIndice="Tipo=  Por Bodega Reserva";
		} else if(sNombreIndice.equals("FK_IdEmbarcador")) {
			sNombreIndice="Tipo=  Por Embarcador";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoAnulado")) {
			sNombreIndice="Tipo=  Por Estado Pedido Anulado";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoAutorizado")) {
			sNombreIndice="Tipo=  Por Estado Pedido Autorizado";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoCotizado")) {
			sNombreIndice="Tipo=  Por Estado Pedido Cotizado";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoPendiente")) {
			sNombreIndice="Tipo=  Por Estado Pedido Pendiente";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoRegularizado")) {
			sNombreIndice="Tipo=  Por Estado Pedido Regularizado";
		} else if(sNombreIndice.equals("FK_IdEstadoPedidoSuspendo")) {
			sNombreIndice="Tipo=  Por Estado Pedido Suspendo";
		} else if(sNombreIndice.equals("FK_IdFormatoAutorizacion")) {
			sNombreIndice="Tipo=  Por Formato Autorizacion";
		} else if(sNombreIndice.equals("FK_IdFormatoCotizacion")) {
			sNombreIndice="Tipo=  Por Formato Cotizacion";
		} else if(sNombreIndice.equals("FK_IdFormatoItem")) {
			sNombreIndice="Tipo=  Por Formato Item";
		} else if(sNombreIndice.equals("FK_IdFormatoPedido")) {
			sNombreIndice="Tipo=  Por Formato Pedido";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdPrioridadPedido")) {
			sNombreIndice="Tipo=  Por Prioridad Pedido";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Modulo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaReserva(Long id_bodega_reserva) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_reserva!=null) {sDetalleIndice+=" Codigo Unico De Bodega Reserva="+id_bodega_reserva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmbarcador(Long id_embarcador) {
		String sDetalleIndice=" Parametros->";
		if(id_embarcador!=null) {sDetalleIndice+=" Codigo Unico De Embarcador="+id_embarcador.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoAnulado(Long id_estado_pedido_anulado) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_anulado!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedido Anulado="+id_estado_pedido_anulado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoAutorizado(Long id_estado_pedido_autorizado) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_autorizado!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedido Autorizado="+id_estado_pedido_autorizado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoCotizado(Long id_estado_pedido_cotizado) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_cotizado!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedido Cotizado="+id_estado_pedido_cotizado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoPendiente(Long id_estado_pedido_pendiente) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_pendiente!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedido Pendiente="+id_estado_pedido_pendiente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoRegularizado(Long id_estado_pedido_regularizado) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_regularizado!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedido Regularizado="+id_estado_pedido_regularizado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedidoSuspendo(Long id_estado_pedido_suspendido) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido_suspendido!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedido Suspendo="+id_estado_pedido_suspendido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoAutorizacion(Long id_formato_autorizacion) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_autorizacion!=null) {sDetalleIndice+=" Codigo Unico De Formato Autorizacion="+id_formato_autorizacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoCotizacion(Long id_formato_cotizacion) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_cotizacion!=null) {sDetalleIndice+=" Codigo Unico De Formato Cotizacion="+id_formato_cotizacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoItem(Long id_formato_item) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_item!=null) {sDetalleIndice+=" Codigo Unico De Formato Item="+id_formato_item.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoPedido(Long id_formato_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_pedido!=null) {sDetalleIndice+=" Codigo Unico De Formato Pedido="+id_formato_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPrioridadPedido(Long id_prioridad_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_prioridad_pedido!=null) {sDetalleIndice+=" Codigo Unico De Prioridad Pedido="+id_prioridad_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimientoModulo(Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroCompra(ParametroCompra parametrocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrocompra.setsecuencial_pedido(parametrocompra.getsecuencial_pedido().trim());
		parametrocompra.setsecuencial_cotizacion(parametrocompra.getsecuencial_cotizacion().trim());
		parametrocompra.setsecuencial_produccion(parametrocompra.getsecuencial_produccion().trim());
		parametrocompra.settexto_mail(parametrocompra.gettexto_mail().trim());
		parametrocompra.setdescripcion(parametrocompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosParametroCompras(List<ParametroCompra> parametrocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroCompra parametrocompra: parametrocompras) {
			parametrocompra.setsecuencial_pedido(parametrocompra.getsecuencial_pedido().trim());
			parametrocompra.setsecuencial_cotizacion(parametrocompra.getsecuencial_cotizacion().trim());
			parametrocompra.setsecuencial_produccion(parametrocompra.getsecuencial_produccion().trim());
			parametrocompra.settexto_mail(parametrocompra.gettexto_mail().trim());
			parametrocompra.setdescripcion(parametrocompra.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroCompra(ParametroCompra parametrocompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrocompra.getConCambioAuxiliar()) {
			parametrocompra.setIsDeleted(parametrocompra.getIsDeletedAuxiliar());	
			parametrocompra.setIsNew(parametrocompra.getIsNewAuxiliar());	
			parametrocompra.setIsChanged(parametrocompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrocompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrocompra.setIsDeletedAuxiliar(false);	
			parametrocompra.setIsNewAuxiliar(false);	
			parametrocompra.setIsChangedAuxiliar(false);
			
			parametrocompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroCompras(List<ParametroCompra> parametrocompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroCompra parametrocompra : parametrocompras) {
			if(conAsignarBase && parametrocompra.getConCambioAuxiliar()) {
				parametrocompra.setIsDeleted(parametrocompra.getIsDeletedAuxiliar());	
				parametrocompra.setIsNew(parametrocompra.getIsNewAuxiliar());	
				parametrocompra.setIsChanged(parametrocompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrocompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrocompra.setIsDeletedAuxiliar(false);	
				parametrocompra.setIsNewAuxiliar(false);	
				parametrocompra.setIsChangedAuxiliar(false);
				
				parametrocompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroCompra(ParametroCompra parametrocompra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroCompras(List<ParametroCompra> parametrocompras,Boolean conEnteros) throws Exception  {
		
		for(ParametroCompra parametrocompra: parametrocompras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroCompra(List<ParametroCompra> parametrocompras,ParametroCompra parametrocompraAux) throws Exception  {
		ParametroCompraConstantesFunciones.InicializarValoresParametroCompra(parametrocompraAux,true);
		
		for(ParametroCompra parametrocompra: parametrocompras) {
			if(parametrocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroCompraConstantesFunciones.getArrayColumnasGlobalesParametroCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroCompraConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroCompraConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroCompra> parametrocompras,ParametroCompra parametrocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroCompra parametrocompraAux: parametrocompras) {
			if(parametrocompraAux!=null && parametrocompra!=null) {
				if((parametrocompraAux.getId()==null && parametrocompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrocompraAux.getId()!=null && parametrocompra.getId()!=null){
					if(parametrocompraAux.getId().equals(parametrocompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroCompra(List<ParametroCompra> parametrocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroCompra parametrocompra: parametrocompras) {			
			if(parametrocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_ID, ParametroCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_VERSIONROW, ParametroCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDEMPRESA, ParametroCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_SECUENCIALPEDIDO, ParametroCompraConstantesFunciones.SECUENCIALPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_SECUENCIALCOTIZACION, ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_SECUENCIALPRODUCCION, ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDTIPODOCUMENTO, ParametroCompraConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDBODEGA, ParametroCompraConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDBODEGARESERVA, ParametroCompraConstantesFunciones.IDBODEGARESERVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDEMPLEADO, ParametroCompraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDEMBARCADOR, ParametroCompraConstantesFunciones.IDEMBARCADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_CONCENTROCOSTO, ParametroCompraConstantesFunciones.CONCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_TEXTOMAIL, ParametroCompraConstantesFunciones.TEXTOMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDMODULO, ParametroCompraConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO, ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_DESCRIPCION, ParametroCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDFORMATOPEDIDO, ParametroCompraConstantesFunciones.IDFORMATOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOPENDIENTE, ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDFORMATOCOTIZACION, ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOTIZADO, ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDFORMATOAUTORIZACION, ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOAUTORIZADO, ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDFORMATOITEM, ParametroCompraConstantesFunciones.IDFORMATOITEM,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOANULADO, ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDPRIORIDADPEDIDO, ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOSUSPENDIDO, ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOREGULARIZADO, ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.SECUENCIALPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDBODEGARESERVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDEMBARCADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.CONCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.TEXTOMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDFORMATOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDFORMATOITEM;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCompra() throws Exception  {
		return ParametroCompraConstantesFunciones.getTiposSeleccionarParametroCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCompra(Boolean conFk) throws Exception  {
		return ParametroCompraConstantesFunciones.getTiposSeleccionarParametroCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_SECUENCIALPEDIDO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_SECUENCIALPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_SECUENCIALCOTIZACION);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_SECUENCIALCOTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_SECUENCIALPRODUCCION);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_SECUENCIALPRODUCCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDBODEGARESERVA);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDBODEGARESERVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDEMBARCADOR);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDEMBARCADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_CONCENTROCOSTO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_CONCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_TEXTOMAIL);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_TEXTOMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDFORMATOPEDIDO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDFORMATOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOPENDIENTE);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDFORMATOCOTIZACION);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDFORMATOCOTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOTIZADO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOTIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDFORMATOAUTORIZACION);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDFORMATOAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOAUTORIZADO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOAUTORIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDFORMATOITEM);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDFORMATOITEM);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOANULADO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOANULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDPRIORIDADPEDIDO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDPRIORIDADPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOSUSPENDIDO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOSUSPENDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOREGULARIZADO);
			reporte.setsDescripcion(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOREGULARIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroCompra(ParametroCompra parametrocompraAux) throws Exception {
		
			parametrocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocompraAux.getEmpresa()));
			parametrocompraAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrocompraAux.getTipoDocumento()));
			parametrocompraAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(parametrocompraAux.getTipoMovimiento()));
			parametrocompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrocompraAux.getBodega()));
			parametrocompraAux.setbodegareserva_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrocompraAux.getBodegaReserva()));
			parametrocompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(parametrocompraAux.getEmpleado()));
			parametrocompraAux.setembarcador_descripcion(EmbarcadorConstantesFunciones.getEmbarcadorDescripcion(parametrocompraAux.getEmbarcador()));
			parametrocompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametrocompraAux.getModulo()));
			parametrocompraAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(parametrocompraAux.getTipoMovimientoModulo()));
			parametrocompraAux.setformatopedido_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoPedido()));
			parametrocompraAux.setestadopedidopendiente_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoPendiente()));
			parametrocompraAux.setformatocotizacion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoCotizacion()));
			parametrocompraAux.setestadopedidocotizado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoCotizado()));
			parametrocompraAux.setformatoautorizacion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoAutorizacion()));
			parametrocompraAux.setestadopedidoautorizado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoAutorizado()));
			parametrocompraAux.setformatoitem_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoItem()));
			parametrocompraAux.setestadopedidoanulado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoAnulado()));
			parametrocompraAux.setprioridadpedido_descripcion(PrioridadPedidoConstantesFunciones.getPrioridadPedidoDescripcion(parametrocompraAux.getPrioridadPedido()));
			parametrocompraAux.setestadopedidosuspendido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoSuspendido()));
			parametrocompraAux.setestadopedidoregularizado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoRegularizado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroCompra(List<ParametroCompra> parametrocomprasTemp) throws Exception {
		for(ParametroCompra parametrocompraAux:parametrocomprasTemp) {
			
			parametrocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocompraAux.getEmpresa()));
			parametrocompraAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrocompraAux.getTipoDocumento()));
			parametrocompraAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(parametrocompraAux.getTipoMovimiento()));
			parametrocompraAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrocompraAux.getBodega()));
			parametrocompraAux.setbodegareserva_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrocompraAux.getBodegaReserva()));
			parametrocompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(parametrocompraAux.getEmpleado()));
			parametrocompraAux.setembarcador_descripcion(EmbarcadorConstantesFunciones.getEmbarcadorDescripcion(parametrocompraAux.getEmbarcador()));
			parametrocompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametrocompraAux.getModulo()));
			parametrocompraAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(parametrocompraAux.getTipoMovimientoModulo()));
			parametrocompraAux.setformatopedido_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoPedido()));
			parametrocompraAux.setestadopedidopendiente_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoPendiente()));
			parametrocompraAux.setformatocotizacion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoCotizacion()));
			parametrocompraAux.setestadopedidocotizado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoCotizado()));
			parametrocompraAux.setformatoautorizacion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoAutorizacion()));
			parametrocompraAux.setestadopedidoautorizado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoAutorizado()));
			parametrocompraAux.setformatoitem_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrocompraAux.getFormatoItem()));
			parametrocompraAux.setestadopedidoanulado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoAnulado()));
			parametrocompraAux.setprioridadpedido_descripcion(PrioridadPedidoConstantesFunciones.getPrioridadPedidoDescripcion(parametrocompraAux.getPrioridadPedido()));
			parametrocompraAux.setestadopedidosuspendido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoSuspendido()));
			parametrocompraAux.setestadopedidoregularizado_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(parametrocompraAux.getEstadoPedidoRegularizado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Embarcador.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMovimientoModulo.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(PrioridadPedido.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(EstadoPedido.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Embarcador.class)) {
						classes.add(new Classe(Embarcador.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimientoModulo.class)) {
						classes.add(new Classe(TipoMovimientoModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PrioridadPedido.class)) {
						classes.add(new Classe(PrioridadPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Embarcador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Embarcador.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(PrioridadPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PrioridadPedido.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Embarcador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Embarcador.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(PrioridadPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PrioridadPedido.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroCompraConstantesFunciones.getClassesRelationshipsOfParametroCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroCompraConstantesFunciones.getClassesRelationshipsFromStringsOfParametroCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroCompra parametrocompra,List<ParametroCompra> parametrocompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroCompra parametrocompraEncontrado=null;
			
			for(ParametroCompra parametrocompraLocal:parametrocompras) {
				if(parametrocompraLocal.getId().equals(parametrocompra.getId())) {
					parametrocompraEncontrado=parametrocompraLocal;
					
					parametrocompraLocal.setIsChanged(parametrocompra.getIsChanged());
					parametrocompraLocal.setIsNew(parametrocompra.getIsNew());
					parametrocompraLocal.setIsDeleted(parametrocompra.getIsDeleted());
					
					parametrocompraLocal.setGeneralEntityOriginal(parametrocompra.getGeneralEntityOriginal());
					
					parametrocompraLocal.setId(parametrocompra.getId());	
					parametrocompraLocal.setVersionRow(parametrocompra.getVersionRow());	
					parametrocompraLocal.setid_empresa(parametrocompra.getid_empresa());	
					parametrocompraLocal.setsecuencial_pedido(parametrocompra.getsecuencial_pedido());	
					parametrocompraLocal.setsecuencial_cotizacion(parametrocompra.getsecuencial_cotizacion());	
					parametrocompraLocal.setsecuencial_produccion(parametrocompra.getsecuencial_produccion());	
					parametrocompraLocal.setid_tipo_documento(parametrocompra.getid_tipo_documento());	
					parametrocompraLocal.setid_tipo_movimiento(parametrocompra.getid_tipo_movimiento());	
					parametrocompraLocal.setid_bodega(parametrocompra.getid_bodega());	
					parametrocompraLocal.setid_bodega_reserva(parametrocompra.getid_bodega_reserva());	
					parametrocompraLocal.setid_empleado(parametrocompra.getid_empleado());	
					parametrocompraLocal.setid_embarcador(parametrocompra.getid_embarcador());	
					parametrocompraLocal.setcon_centro_costo(parametrocompra.getcon_centro_costo());	
					parametrocompraLocal.settexto_mail(parametrocompra.gettexto_mail());	
					parametrocompraLocal.setid_modulo(parametrocompra.getid_modulo());	
					parametrocompraLocal.setid_tipo_movimiento_modulo(parametrocompra.getid_tipo_movimiento_modulo());	
					parametrocompraLocal.setdescripcion(parametrocompra.getdescripcion());	
					parametrocompraLocal.setid_formato_pedido(parametrocompra.getid_formato_pedido());	
					parametrocompraLocal.setid_estado_pedido_pendiente(parametrocompra.getid_estado_pedido_pendiente());	
					parametrocompraLocal.setid_formato_cotizacion(parametrocompra.getid_formato_cotizacion());	
					parametrocompraLocal.setid_estado_pedido_cotizado(parametrocompra.getid_estado_pedido_cotizado());	
					parametrocompraLocal.setid_formato_autorizacion(parametrocompra.getid_formato_autorizacion());	
					parametrocompraLocal.setid_estado_pedido_autorizado(parametrocompra.getid_estado_pedido_autorizado());	
					parametrocompraLocal.setid_formato_item(parametrocompra.getid_formato_item());	
					parametrocompraLocal.setid_estado_pedido_anulado(parametrocompra.getid_estado_pedido_anulado());	
					parametrocompraLocal.setid_prioridad_pedido(parametrocompra.getid_prioridad_pedido());	
					parametrocompraLocal.setid_estado_pedido_suspendido(parametrocompra.getid_estado_pedido_suspendido());	
					parametrocompraLocal.setid_estado_pedido_regularizado(parametrocompra.getid_estado_pedido_regularizado());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrocompra.getIsDeleted()) {
				if(!existe) {
					parametrocompras.add(parametrocompra);
				}
			} else {
				if(parametrocompraEncontrado!=null && permiteQuitar)  {
					parametrocompras.remove(parametrocompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroCompra parametrocompra,List<ParametroCompra> parametrocompras) throws Exception {
		try	{			
			for(ParametroCompra parametrocompraLocal:parametrocompras) {
				if(parametrocompraLocal.getId().equals(parametrocompra.getId())) {
					parametrocompraLocal.setIsSelected(parametrocompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroCompra(List<ParametroCompra> parametrocomprasAux) throws Exception {
		//this.parametrocomprasAux=parametrocomprasAux;
		
		for(ParametroCompra parametrocompraAux:parametrocomprasAux) {
			if(parametrocompraAux.getIsChanged()) {
				parametrocompraAux.setIsChanged(false);
			}		
			
			if(parametrocompraAux.getIsNew()) {
				parametrocompraAux.setIsNew(false);
			}	
			
			if(parametrocompraAux.getIsDeleted()) {
				parametrocompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroCompra(ParametroCompra parametrocompraAux) throws Exception {
		//this.parametrocompraAux=parametrocompraAux;
		
			if(parametrocompraAux.getIsChanged()) {
				parametrocompraAux.setIsChanged(false);
			}		
			
			if(parametrocompraAux.getIsNew()) {
				parametrocompraAux.setIsNew(false);
			}	
			
			if(parametrocompraAux.getIsDeleted()) {
				parametrocompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroCompra parametrocompraAsignar,ParametroCompra parametrocompra) throws Exception {
		parametrocompraAsignar.setId(parametrocompra.getId());	
		parametrocompraAsignar.setVersionRow(parametrocompra.getVersionRow());	
		parametrocompraAsignar.setid_empresa(parametrocompra.getid_empresa());
		parametrocompraAsignar.setempresa_descripcion(parametrocompra.getempresa_descripcion());	
		parametrocompraAsignar.setsecuencial_pedido(parametrocompra.getsecuencial_pedido());	
		parametrocompraAsignar.setsecuencial_cotizacion(parametrocompra.getsecuencial_cotizacion());	
		parametrocompraAsignar.setsecuencial_produccion(parametrocompra.getsecuencial_produccion());	
		parametrocompraAsignar.setid_tipo_documento(parametrocompra.getid_tipo_documento());
		parametrocompraAsignar.settipodocumento_descripcion(parametrocompra.gettipodocumento_descripcion());	
		parametrocompraAsignar.setid_tipo_movimiento(parametrocompra.getid_tipo_movimiento());
		parametrocompraAsignar.settipomovimiento_descripcion(parametrocompra.gettipomovimiento_descripcion());	
		parametrocompraAsignar.setid_bodega(parametrocompra.getid_bodega());
		parametrocompraAsignar.setbodega_descripcion(parametrocompra.getbodega_descripcion());	
		parametrocompraAsignar.setid_bodega_reserva(parametrocompra.getid_bodega_reserva());
		parametrocompraAsignar.setbodegareserva_descripcion(parametrocompra.getbodegareserva_descripcion());	
		parametrocompraAsignar.setid_empleado(parametrocompra.getid_empleado());
		parametrocompraAsignar.setempleado_descripcion(parametrocompra.getempleado_descripcion());	
		parametrocompraAsignar.setid_embarcador(parametrocompra.getid_embarcador());
		parametrocompraAsignar.setembarcador_descripcion(parametrocompra.getembarcador_descripcion());	
		parametrocompraAsignar.setcon_centro_costo(parametrocompra.getcon_centro_costo());	
		parametrocompraAsignar.settexto_mail(parametrocompra.gettexto_mail());	
		parametrocompraAsignar.setid_modulo(parametrocompra.getid_modulo());
		parametrocompraAsignar.setmodulo_descripcion(parametrocompra.getmodulo_descripcion());	
		parametrocompraAsignar.setid_tipo_movimiento_modulo(parametrocompra.getid_tipo_movimiento_modulo());
		parametrocompraAsignar.settipomovimientomodulo_descripcion(parametrocompra.gettipomovimientomodulo_descripcion());	
		parametrocompraAsignar.setdescripcion(parametrocompra.getdescripcion());	
		parametrocompraAsignar.setid_formato_pedido(parametrocompra.getid_formato_pedido());
		parametrocompraAsignar.setformatopedido_descripcion(parametrocompra.getformatopedido_descripcion());	
		parametrocompraAsignar.setid_estado_pedido_pendiente(parametrocompra.getid_estado_pedido_pendiente());
		parametrocompraAsignar.setestadopedidopendiente_descripcion(parametrocompra.getestadopedidopendiente_descripcion());	
		parametrocompraAsignar.setid_formato_cotizacion(parametrocompra.getid_formato_cotizacion());
		parametrocompraAsignar.setformatocotizacion_descripcion(parametrocompra.getformatocotizacion_descripcion());	
		parametrocompraAsignar.setid_estado_pedido_cotizado(parametrocompra.getid_estado_pedido_cotizado());
		parametrocompraAsignar.setestadopedidocotizado_descripcion(parametrocompra.getestadopedidocotizado_descripcion());	
		parametrocompraAsignar.setid_formato_autorizacion(parametrocompra.getid_formato_autorizacion());
		parametrocompraAsignar.setformatoautorizacion_descripcion(parametrocompra.getformatoautorizacion_descripcion());	
		parametrocompraAsignar.setid_estado_pedido_autorizado(parametrocompra.getid_estado_pedido_autorizado());
		parametrocompraAsignar.setestadopedidoautorizado_descripcion(parametrocompra.getestadopedidoautorizado_descripcion());	
		parametrocompraAsignar.setid_formato_item(parametrocompra.getid_formato_item());
		parametrocompraAsignar.setformatoitem_descripcion(parametrocompra.getformatoitem_descripcion());	
		parametrocompraAsignar.setid_estado_pedido_anulado(parametrocompra.getid_estado_pedido_anulado());
		parametrocompraAsignar.setestadopedidoanulado_descripcion(parametrocompra.getestadopedidoanulado_descripcion());	
		parametrocompraAsignar.setid_prioridad_pedido(parametrocompra.getid_prioridad_pedido());
		parametrocompraAsignar.setprioridadpedido_descripcion(parametrocompra.getprioridadpedido_descripcion());	
		parametrocompraAsignar.setid_estado_pedido_suspendido(parametrocompra.getid_estado_pedido_suspendido());
		parametrocompraAsignar.setestadopedidosuspendido_descripcion(parametrocompra.getestadopedidosuspendido_descripcion());	
		parametrocompraAsignar.setid_estado_pedido_regularizado(parametrocompra.getid_estado_pedido_regularizado());
		parametrocompraAsignar.setestadopedidoregularizado_descripcion(parametrocompra.getestadopedidoregularizado_descripcion());	
	}
	
	public static void inicializarParametroCompra(ParametroCompra parametrocompra) throws Exception {
		try {
				parametrocompra.setId(0L);	
					
				parametrocompra.setid_empresa(-1L);	
				parametrocompra.setsecuencial_pedido("");	
				parametrocompra.setsecuencial_cotizacion("");	
				parametrocompra.setsecuencial_produccion("");	
				parametrocompra.setid_tipo_documento(-1L);	
				parametrocompra.setid_tipo_movimiento(-1L);	
				parametrocompra.setid_bodega(-1L);	
				parametrocompra.setid_bodega_reserva(-1L);	
				parametrocompra.setid_empleado(-1L);	
				parametrocompra.setid_embarcador(-1L);	
				parametrocompra.setcon_centro_costo(false);	
				parametrocompra.settexto_mail("");	
				parametrocompra.setid_modulo(-1L);	
				parametrocompra.setid_tipo_movimiento_modulo(-1L);	
				parametrocompra.setdescripcion("");	
				parametrocompra.setid_formato_pedido(-1L);	
				parametrocompra.setid_estado_pedido_pendiente(-1L);	
				parametrocompra.setid_formato_cotizacion(-1L);	
				parametrocompra.setid_estado_pedido_cotizado(-1L);	
				parametrocompra.setid_formato_autorizacion(-1L);	
				parametrocompra.setid_estado_pedido_autorizado(-1L);	
				parametrocompra.setid_formato_item(-1L);	
				parametrocompra.setid_estado_pedido_anulado(-1L);	
				parametrocompra.setid_prioridad_pedido(-1L);	
				parametrocompra.setid_estado_pedido_suspendido(-1L);	
				parametrocompra.setid_estado_pedido_regularizado(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_SECUENCIALPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_SECUENCIALCOTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_SECUENCIALPRODUCCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDBODEGARESERVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDEMBARCADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_CONCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_TEXTOMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDFORMATOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOPENDIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDFORMATOCOTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOCOTIZADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDFORMATOAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOAUTORIZADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDFORMATOITEM);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOANULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDPRIORIDADPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOSUSPENDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroCompraConstantesFunciones.LABEL_IDESTADOPEDIDOREGULARIZADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroCompra(String sTipo,Row row,Workbook workbook,ParametroCompra parametrocompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getsecuencial_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getsecuencial_cotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getsecuencial_produccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getbodegareserva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getembarcador_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrocompra.getcon_centro_costo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.gettexto_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.gettipomovimientomodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getformatopedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getestadopedidopendiente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getformatocotizacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getestadopedidocotizado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getformatoautorizacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getestadopedidoautorizado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getformatoitem_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getestadopedidoanulado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getprioridadpedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getestadopedidosuspendido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocompra.getestadopedidoregularizado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroCompra() {
		return this.sFinalQueryParametroCompra;
	}
	
	public void setsFinalQueryParametroCompra(String sFinalQueryParametroCompra) {
		this.sFinalQueryParametroCompra= sFinalQueryParametroCompra;
	}
	
	public Border resaltarSeleccionarParametroCompra=null;
	
	public Border setResaltarSeleccionarParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroCompra() {
		return this.resaltarSeleccionarParametroCompra;
	}
	
	public void setResaltarSeleccionarParametroCompra(Border borderResaltarSeleccionarParametroCompra) {
		this.resaltarSeleccionarParametroCompra= borderResaltarSeleccionarParametroCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroCompra=null;
	public Boolean mostraridParametroCompra=true;
	public Boolean activaridParametroCompra=true;

	public Border resaltarid_empresaParametroCompra=null;
	public Boolean mostrarid_empresaParametroCompra=true;
	public Boolean activarid_empresaParametroCompra=true;
	public Boolean cargarid_empresaParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroCompra=false;//ConEventDepend=true

	public Border resaltarsecuencial_pedidoParametroCompra=null;
	public Boolean mostrarsecuencial_pedidoParametroCompra=true;
	public Boolean activarsecuencial_pedidoParametroCompra=true;

	public Border resaltarsecuencial_cotizacionParametroCompra=null;
	public Boolean mostrarsecuencial_cotizacionParametroCompra=true;
	public Boolean activarsecuencial_cotizacionParametroCompra=true;

	public Border resaltarsecuencial_produccionParametroCompra=null;
	public Boolean mostrarsecuencial_produccionParametroCompra=true;
	public Boolean activarsecuencial_produccionParametroCompra=true;

	public Border resaltarid_tipo_documentoParametroCompra=null;
	public Boolean mostrarid_tipo_documentoParametroCompra=true;
	public Boolean activarid_tipo_documentoParametroCompra=true;
	public Boolean cargarid_tipo_documentoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoParametroCompra=null;
	public Boolean mostrarid_tipo_movimientoParametroCompra=true;
	public Boolean activarid_tipo_movimientoParametroCompra=true;
	public Boolean cargarid_tipo_movimientoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_bodegaParametroCompra=null;
	public Boolean mostrarid_bodegaParametroCompra=true;
	public Boolean activarid_bodegaParametroCompra=true;
	public Boolean cargarid_bodegaParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_bodega_reservaParametroCompra=null;
	public Boolean mostrarid_bodega_reservaParametroCompra=true;
	public Boolean activarid_bodega_reservaParametroCompra=true;
	public Boolean cargarid_bodega_reservaParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_reservaParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_empleadoParametroCompra=null;
	public Boolean mostrarid_empleadoParametroCompra=true;
	public Boolean activarid_empleadoParametroCompra=true;
	public Boolean cargarid_empleadoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_embarcadorParametroCompra=null;
	public Boolean mostrarid_embarcadorParametroCompra=true;
	public Boolean activarid_embarcadorParametroCompra=true;
	public Boolean cargarid_embarcadorParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_embarcadorParametroCompra=false;//ConEventDepend=true

	public Border resaltarcon_centro_costoParametroCompra=null;
	public Boolean mostrarcon_centro_costoParametroCompra=true;
	public Boolean activarcon_centro_costoParametroCompra=true;

	public Border resaltartexto_mailParametroCompra=null;
	public Boolean mostrartexto_mailParametroCompra=true;
	public Boolean activartexto_mailParametroCompra=true;

	public Border resaltarid_moduloParametroCompra=null;
	public Boolean mostrarid_moduloParametroCompra=true;
	public Boolean activarid_moduloParametroCompra=true;
	public Boolean cargarid_moduloParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimiento_moduloParametroCompra=null;
	public Boolean mostrarid_tipo_movimiento_moduloParametroCompra=true;
	public Boolean activarid_tipo_movimiento_moduloParametroCompra=false;
	public Boolean cargarid_tipo_movimiento_moduloParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimiento_moduloParametroCompra=false;//ConEventDepend=true

	public Border resaltardescripcionParametroCompra=null;
	public Boolean mostrardescripcionParametroCompra=true;
	public Boolean activardescripcionParametroCompra=true;

	public Border resaltarid_formato_pedidoParametroCompra=null;
	public Boolean mostrarid_formato_pedidoParametroCompra=true;
	public Boolean activarid_formato_pedidoParametroCompra=true;
	public Boolean cargarid_formato_pedidoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_pedidoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_pendienteParametroCompra=null;
	public Boolean mostrarid_estado_pedido_pendienteParametroCompra=true;
	public Boolean activarid_estado_pedido_pendienteParametroCompra=true;
	public Boolean cargarid_estado_pedido_pendienteParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_pendienteParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_formato_cotizacionParametroCompra=null;
	public Boolean mostrarid_formato_cotizacionParametroCompra=true;
	public Boolean activarid_formato_cotizacionParametroCompra=true;
	public Boolean cargarid_formato_cotizacionParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_cotizacionParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_cotizadoParametroCompra=null;
	public Boolean mostrarid_estado_pedido_cotizadoParametroCompra=true;
	public Boolean activarid_estado_pedido_cotizadoParametroCompra=true;
	public Boolean cargarid_estado_pedido_cotizadoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_cotizadoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_formato_autorizacionParametroCompra=null;
	public Boolean mostrarid_formato_autorizacionParametroCompra=true;
	public Boolean activarid_formato_autorizacionParametroCompra=true;
	public Boolean cargarid_formato_autorizacionParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_autorizacionParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_autorizadoParametroCompra=null;
	public Boolean mostrarid_estado_pedido_autorizadoParametroCompra=true;
	public Boolean activarid_estado_pedido_autorizadoParametroCompra=true;
	public Boolean cargarid_estado_pedido_autorizadoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_autorizadoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_formato_itemParametroCompra=null;
	public Boolean mostrarid_formato_itemParametroCompra=true;
	public Boolean activarid_formato_itemParametroCompra=true;
	public Boolean cargarid_formato_itemParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_itemParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_anuladoParametroCompra=null;
	public Boolean mostrarid_estado_pedido_anuladoParametroCompra=true;
	public Boolean activarid_estado_pedido_anuladoParametroCompra=true;
	public Boolean cargarid_estado_pedido_anuladoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_anuladoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_prioridad_pedidoParametroCompra=null;
	public Boolean mostrarid_prioridad_pedidoParametroCompra=true;
	public Boolean activarid_prioridad_pedidoParametroCompra=true;
	public Boolean cargarid_prioridad_pedidoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_prioridad_pedidoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_suspendidoParametroCompra=null;
	public Boolean mostrarid_estado_pedido_suspendidoParametroCompra=true;
	public Boolean activarid_estado_pedido_suspendidoParametroCompra=true;
	public Boolean cargarid_estado_pedido_suspendidoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_suspendidoParametroCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_pedido_regularizadoParametroCompra=null;
	public Boolean mostrarid_estado_pedido_regularizadoParametroCompra=true;
	public Boolean activarid_estado_pedido_regularizadoParametroCompra=true;
	public Boolean cargarid_estado_pedido_regularizadoParametroCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedido_regularizadoParametroCompra=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltaridParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroCompra() {
		return this.resaltaridParametroCompra;
	}

	public void setResaltaridParametroCompra(Border borderResaltar) {
		this.resaltaridParametroCompra= borderResaltar;
	}

	public Boolean getMostraridParametroCompra() {
		return this.mostraridParametroCompra;
	}

	public void setMostraridParametroCompra(Boolean mostraridParametroCompra) {
		this.mostraridParametroCompra= mostraridParametroCompra;
	}

	public Boolean getActivaridParametroCompra() {
		return this.activaridParametroCompra;
	}

	public void setActivaridParametroCompra(Boolean activaridParametroCompra) {
		this.activaridParametroCompra= activaridParametroCompra;
	}

	public Border setResaltarid_empresaParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroCompra() {
		return this.resaltarid_empresaParametroCompra;
	}

	public void setResaltarid_empresaParametroCompra(Border borderResaltar) {
		this.resaltarid_empresaParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroCompra() {
		return this.mostrarid_empresaParametroCompra;
	}

	public void setMostrarid_empresaParametroCompra(Boolean mostrarid_empresaParametroCompra) {
		this.mostrarid_empresaParametroCompra= mostrarid_empresaParametroCompra;
	}

	public Boolean getActivarid_empresaParametroCompra() {
		return this.activarid_empresaParametroCompra;
	}

	public void setActivarid_empresaParametroCompra(Boolean activarid_empresaParametroCompra) {
		this.activarid_empresaParametroCompra= activarid_empresaParametroCompra;
	}

	public Boolean getCargarid_empresaParametroCompra() {
		return this.cargarid_empresaParametroCompra;
	}

	public void setCargarid_empresaParametroCompra(Boolean cargarid_empresaParametroCompra) {
		this.cargarid_empresaParametroCompra= cargarid_empresaParametroCompra;
	}

	public Border setResaltarsecuencial_pedidoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarsecuencial_pedidoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_pedidoParametroCompra() {
		return this.resaltarsecuencial_pedidoParametroCompra;
	}

	public void setResaltarsecuencial_pedidoParametroCompra(Border borderResaltar) {
		this.resaltarsecuencial_pedidoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarsecuencial_pedidoParametroCompra() {
		return this.mostrarsecuencial_pedidoParametroCompra;
	}

	public void setMostrarsecuencial_pedidoParametroCompra(Boolean mostrarsecuencial_pedidoParametroCompra) {
		this.mostrarsecuencial_pedidoParametroCompra= mostrarsecuencial_pedidoParametroCompra;
	}

	public Boolean getActivarsecuencial_pedidoParametroCompra() {
		return this.activarsecuencial_pedidoParametroCompra;
	}

	public void setActivarsecuencial_pedidoParametroCompra(Boolean activarsecuencial_pedidoParametroCompra) {
		this.activarsecuencial_pedidoParametroCompra= activarsecuencial_pedidoParametroCompra;
	}

	public Border setResaltarsecuencial_cotizacionParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarsecuencial_cotizacionParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_cotizacionParametroCompra() {
		return this.resaltarsecuencial_cotizacionParametroCompra;
	}

	public void setResaltarsecuencial_cotizacionParametroCompra(Border borderResaltar) {
		this.resaltarsecuencial_cotizacionParametroCompra= borderResaltar;
	}

	public Boolean getMostrarsecuencial_cotizacionParametroCompra() {
		return this.mostrarsecuencial_cotizacionParametroCompra;
	}

	public void setMostrarsecuencial_cotizacionParametroCompra(Boolean mostrarsecuencial_cotizacionParametroCompra) {
		this.mostrarsecuencial_cotizacionParametroCompra= mostrarsecuencial_cotizacionParametroCompra;
	}

	public Boolean getActivarsecuencial_cotizacionParametroCompra() {
		return this.activarsecuencial_cotizacionParametroCompra;
	}

	public void setActivarsecuencial_cotizacionParametroCompra(Boolean activarsecuencial_cotizacionParametroCompra) {
		this.activarsecuencial_cotizacionParametroCompra= activarsecuencial_cotizacionParametroCompra;
	}

	public Border setResaltarsecuencial_produccionParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarsecuencial_produccionParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_produccionParametroCompra() {
		return this.resaltarsecuencial_produccionParametroCompra;
	}

	public void setResaltarsecuencial_produccionParametroCompra(Border borderResaltar) {
		this.resaltarsecuencial_produccionParametroCompra= borderResaltar;
	}

	public Boolean getMostrarsecuencial_produccionParametroCompra() {
		return this.mostrarsecuencial_produccionParametroCompra;
	}

	public void setMostrarsecuencial_produccionParametroCompra(Boolean mostrarsecuencial_produccionParametroCompra) {
		this.mostrarsecuencial_produccionParametroCompra= mostrarsecuencial_produccionParametroCompra;
	}

	public Boolean getActivarsecuencial_produccionParametroCompra() {
		return this.activarsecuencial_produccionParametroCompra;
	}

	public void setActivarsecuencial_produccionParametroCompra(Boolean activarsecuencial_produccionParametroCompra) {
		this.activarsecuencial_produccionParametroCompra= activarsecuencial_produccionParametroCompra;
	}

	public Border setResaltarid_tipo_documentoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoParametroCompra() {
		return this.resaltarid_tipo_documentoParametroCompra;
	}

	public void setResaltarid_tipo_documentoParametroCompra(Border borderResaltar) {
		this.resaltarid_tipo_documentoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoParametroCompra() {
		return this.mostrarid_tipo_documentoParametroCompra;
	}

	public void setMostrarid_tipo_documentoParametroCompra(Boolean mostrarid_tipo_documentoParametroCompra) {
		this.mostrarid_tipo_documentoParametroCompra= mostrarid_tipo_documentoParametroCompra;
	}

	public Boolean getActivarid_tipo_documentoParametroCompra() {
		return this.activarid_tipo_documentoParametroCompra;
	}

	public void setActivarid_tipo_documentoParametroCompra(Boolean activarid_tipo_documentoParametroCompra) {
		this.activarid_tipo_documentoParametroCompra= activarid_tipo_documentoParametroCompra;
	}

	public Boolean getCargarid_tipo_documentoParametroCompra() {
		return this.cargarid_tipo_documentoParametroCompra;
	}

	public void setCargarid_tipo_documentoParametroCompra(Boolean cargarid_tipo_documentoParametroCompra) {
		this.cargarid_tipo_documentoParametroCompra= cargarid_tipo_documentoParametroCompra;
	}

	public Border setResaltarid_tipo_movimientoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoParametroCompra() {
		return this.resaltarid_tipo_movimientoParametroCompra;
	}

	public void setResaltarid_tipo_movimientoParametroCompra(Border borderResaltar) {
		this.resaltarid_tipo_movimientoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoParametroCompra() {
		return this.mostrarid_tipo_movimientoParametroCompra;
	}

	public void setMostrarid_tipo_movimientoParametroCompra(Boolean mostrarid_tipo_movimientoParametroCompra) {
		this.mostrarid_tipo_movimientoParametroCompra= mostrarid_tipo_movimientoParametroCompra;
	}

	public Boolean getActivarid_tipo_movimientoParametroCompra() {
		return this.activarid_tipo_movimientoParametroCompra;
	}

	public void setActivarid_tipo_movimientoParametroCompra(Boolean activarid_tipo_movimientoParametroCompra) {
		this.activarid_tipo_movimientoParametroCompra= activarid_tipo_movimientoParametroCompra;
	}

	public Boolean getCargarid_tipo_movimientoParametroCompra() {
		return this.cargarid_tipo_movimientoParametroCompra;
	}

	public void setCargarid_tipo_movimientoParametroCompra(Boolean cargarid_tipo_movimientoParametroCompra) {
		this.cargarid_tipo_movimientoParametroCompra= cargarid_tipo_movimientoParametroCompra;
	}

	public Border setResaltarid_bodegaParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_bodegaParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaParametroCompra() {
		return this.resaltarid_bodegaParametroCompra;
	}

	public void setResaltarid_bodegaParametroCompra(Border borderResaltar) {
		this.resaltarid_bodegaParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_bodegaParametroCompra() {
		return this.mostrarid_bodegaParametroCompra;
	}

	public void setMostrarid_bodegaParametroCompra(Boolean mostrarid_bodegaParametroCompra) {
		this.mostrarid_bodegaParametroCompra= mostrarid_bodegaParametroCompra;
	}

	public Boolean getActivarid_bodegaParametroCompra() {
		return this.activarid_bodegaParametroCompra;
	}

	public void setActivarid_bodegaParametroCompra(Boolean activarid_bodegaParametroCompra) {
		this.activarid_bodegaParametroCompra= activarid_bodegaParametroCompra;
	}

	public Boolean getCargarid_bodegaParametroCompra() {
		return this.cargarid_bodegaParametroCompra;
	}

	public void setCargarid_bodegaParametroCompra(Boolean cargarid_bodegaParametroCompra) {
		this.cargarid_bodegaParametroCompra= cargarid_bodegaParametroCompra;
	}

	public Border setResaltarid_bodega_reservaParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_bodega_reservaParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_reservaParametroCompra() {
		return this.resaltarid_bodega_reservaParametroCompra;
	}

	public void setResaltarid_bodega_reservaParametroCompra(Border borderResaltar) {
		this.resaltarid_bodega_reservaParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_bodega_reservaParametroCompra() {
		return this.mostrarid_bodega_reservaParametroCompra;
	}

	public void setMostrarid_bodega_reservaParametroCompra(Boolean mostrarid_bodega_reservaParametroCompra) {
		this.mostrarid_bodega_reservaParametroCompra= mostrarid_bodega_reservaParametroCompra;
	}

	public Boolean getActivarid_bodega_reservaParametroCompra() {
		return this.activarid_bodega_reservaParametroCompra;
	}

	public void setActivarid_bodega_reservaParametroCompra(Boolean activarid_bodega_reservaParametroCompra) {
		this.activarid_bodega_reservaParametroCompra= activarid_bodega_reservaParametroCompra;
	}

	public Boolean getCargarid_bodega_reservaParametroCompra() {
		return this.cargarid_bodega_reservaParametroCompra;
	}

	public void setCargarid_bodega_reservaParametroCompra(Boolean cargarid_bodega_reservaParametroCompra) {
		this.cargarid_bodega_reservaParametroCompra= cargarid_bodega_reservaParametroCompra;
	}

	public Border setResaltarid_empleadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoParametroCompra() {
		return this.resaltarid_empleadoParametroCompra;
	}

	public void setResaltarid_empleadoParametroCompra(Border borderResaltar) {
		this.resaltarid_empleadoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoParametroCompra() {
		return this.mostrarid_empleadoParametroCompra;
	}

	public void setMostrarid_empleadoParametroCompra(Boolean mostrarid_empleadoParametroCompra) {
		this.mostrarid_empleadoParametroCompra= mostrarid_empleadoParametroCompra;
	}

	public Boolean getActivarid_empleadoParametroCompra() {
		return this.activarid_empleadoParametroCompra;
	}

	public void setActivarid_empleadoParametroCompra(Boolean activarid_empleadoParametroCompra) {
		this.activarid_empleadoParametroCompra= activarid_empleadoParametroCompra;
	}

	public Boolean getCargarid_empleadoParametroCompra() {
		return this.cargarid_empleadoParametroCompra;
	}

	public void setCargarid_empleadoParametroCompra(Boolean cargarid_empleadoParametroCompra) {
		this.cargarid_empleadoParametroCompra= cargarid_empleadoParametroCompra;
	}

	public Border setResaltarid_embarcadorParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_embarcadorParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_embarcadorParametroCompra() {
		return this.resaltarid_embarcadorParametroCompra;
	}

	public void setResaltarid_embarcadorParametroCompra(Border borderResaltar) {
		this.resaltarid_embarcadorParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_embarcadorParametroCompra() {
		return this.mostrarid_embarcadorParametroCompra;
	}

	public void setMostrarid_embarcadorParametroCompra(Boolean mostrarid_embarcadorParametroCompra) {
		this.mostrarid_embarcadorParametroCompra= mostrarid_embarcadorParametroCompra;
	}

	public Boolean getActivarid_embarcadorParametroCompra() {
		return this.activarid_embarcadorParametroCompra;
	}

	public void setActivarid_embarcadorParametroCompra(Boolean activarid_embarcadorParametroCompra) {
		this.activarid_embarcadorParametroCompra= activarid_embarcadorParametroCompra;
	}

	public Boolean getCargarid_embarcadorParametroCompra() {
		return this.cargarid_embarcadorParametroCompra;
	}

	public void setCargarid_embarcadorParametroCompra(Boolean cargarid_embarcadorParametroCompra) {
		this.cargarid_embarcadorParametroCompra= cargarid_embarcadorParametroCompra;
	}

	public Border setResaltarcon_centro_costoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarcon_centro_costoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_centro_costoParametroCompra() {
		return this.resaltarcon_centro_costoParametroCompra;
	}

	public void setResaltarcon_centro_costoParametroCompra(Border borderResaltar) {
		this.resaltarcon_centro_costoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarcon_centro_costoParametroCompra() {
		return this.mostrarcon_centro_costoParametroCompra;
	}

	public void setMostrarcon_centro_costoParametroCompra(Boolean mostrarcon_centro_costoParametroCompra) {
		this.mostrarcon_centro_costoParametroCompra= mostrarcon_centro_costoParametroCompra;
	}

	public Boolean getActivarcon_centro_costoParametroCompra() {
		return this.activarcon_centro_costoParametroCompra;
	}

	public void setActivarcon_centro_costoParametroCompra(Boolean activarcon_centro_costoParametroCompra) {
		this.activarcon_centro_costoParametroCompra= activarcon_centro_costoParametroCompra;
	}

	public Border setResaltartexto_mailParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltartexto_mailParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartexto_mailParametroCompra() {
		return this.resaltartexto_mailParametroCompra;
	}

	public void setResaltartexto_mailParametroCompra(Border borderResaltar) {
		this.resaltartexto_mailParametroCompra= borderResaltar;
	}

	public Boolean getMostrartexto_mailParametroCompra() {
		return this.mostrartexto_mailParametroCompra;
	}

	public void setMostrartexto_mailParametroCompra(Boolean mostrartexto_mailParametroCompra) {
		this.mostrartexto_mailParametroCompra= mostrartexto_mailParametroCompra;
	}

	public Boolean getActivartexto_mailParametroCompra() {
		return this.activartexto_mailParametroCompra;
	}

	public void setActivartexto_mailParametroCompra(Boolean activartexto_mailParametroCompra) {
		this.activartexto_mailParametroCompra= activartexto_mailParametroCompra;
	}

	public Border setResaltarid_moduloParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_moduloParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloParametroCompra() {
		return this.resaltarid_moduloParametroCompra;
	}

	public void setResaltarid_moduloParametroCompra(Border borderResaltar) {
		this.resaltarid_moduloParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_moduloParametroCompra() {
		return this.mostrarid_moduloParametroCompra;
	}

	public void setMostrarid_moduloParametroCompra(Boolean mostrarid_moduloParametroCompra) {
		this.mostrarid_moduloParametroCompra= mostrarid_moduloParametroCompra;
	}

	public Boolean getActivarid_moduloParametroCompra() {
		return this.activarid_moduloParametroCompra;
	}

	public void setActivarid_moduloParametroCompra(Boolean activarid_moduloParametroCompra) {
		this.activarid_moduloParametroCompra= activarid_moduloParametroCompra;
	}

	public Boolean getCargarid_moduloParametroCompra() {
		return this.cargarid_moduloParametroCompra;
	}

	public void setCargarid_moduloParametroCompra(Boolean cargarid_moduloParametroCompra) {
		this.cargarid_moduloParametroCompra= cargarid_moduloParametroCompra;
	}

	public Border setResaltarid_tipo_movimiento_moduloParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimiento_moduloParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimiento_moduloParametroCompra() {
		return this.resaltarid_tipo_movimiento_moduloParametroCompra;
	}

	public void setResaltarid_tipo_movimiento_moduloParametroCompra(Border borderResaltar) {
		this.resaltarid_tipo_movimiento_moduloParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimiento_moduloParametroCompra() {
		return this.mostrarid_tipo_movimiento_moduloParametroCompra;
	}

	public void setMostrarid_tipo_movimiento_moduloParametroCompra(Boolean mostrarid_tipo_movimiento_moduloParametroCompra) {
		this.mostrarid_tipo_movimiento_moduloParametroCompra= mostrarid_tipo_movimiento_moduloParametroCompra;
	}

	public Boolean getActivarid_tipo_movimiento_moduloParametroCompra() {
		return this.activarid_tipo_movimiento_moduloParametroCompra;
	}

	public void setActivarid_tipo_movimiento_moduloParametroCompra(Boolean activarid_tipo_movimiento_moduloParametroCompra) {
		this.activarid_tipo_movimiento_moduloParametroCompra= activarid_tipo_movimiento_moduloParametroCompra;
	}

	public Boolean getCargarid_tipo_movimiento_moduloParametroCompra() {
		return this.cargarid_tipo_movimiento_moduloParametroCompra;
	}

	public void setCargarid_tipo_movimiento_moduloParametroCompra(Boolean cargarid_tipo_movimiento_moduloParametroCompra) {
		this.cargarid_tipo_movimiento_moduloParametroCompra= cargarid_tipo_movimiento_moduloParametroCompra;
	}

	public Border setResaltardescripcionParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionParametroCompra() {
		return this.resaltardescripcionParametroCompra;
	}

	public void setResaltardescripcionParametroCompra(Border borderResaltar) {
		this.resaltardescripcionParametroCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionParametroCompra() {
		return this.mostrardescripcionParametroCompra;
	}

	public void setMostrardescripcionParametroCompra(Boolean mostrardescripcionParametroCompra) {
		this.mostrardescripcionParametroCompra= mostrardescripcionParametroCompra;
	}

	public Boolean getActivardescripcionParametroCompra() {
		return this.activardescripcionParametroCompra;
	}

	public void setActivardescripcionParametroCompra(Boolean activardescripcionParametroCompra) {
		this.activardescripcionParametroCompra= activardescripcionParametroCompra;
	}

	public Border setResaltarid_formato_pedidoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_formato_pedidoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_pedidoParametroCompra() {
		return this.resaltarid_formato_pedidoParametroCompra;
	}

	public void setResaltarid_formato_pedidoParametroCompra(Border borderResaltar) {
		this.resaltarid_formato_pedidoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_formato_pedidoParametroCompra() {
		return this.mostrarid_formato_pedidoParametroCompra;
	}

	public void setMostrarid_formato_pedidoParametroCompra(Boolean mostrarid_formato_pedidoParametroCompra) {
		this.mostrarid_formato_pedidoParametroCompra= mostrarid_formato_pedidoParametroCompra;
	}

	public Boolean getActivarid_formato_pedidoParametroCompra() {
		return this.activarid_formato_pedidoParametroCompra;
	}

	public void setActivarid_formato_pedidoParametroCompra(Boolean activarid_formato_pedidoParametroCompra) {
		this.activarid_formato_pedidoParametroCompra= activarid_formato_pedidoParametroCompra;
	}

	public Boolean getCargarid_formato_pedidoParametroCompra() {
		return this.cargarid_formato_pedidoParametroCompra;
	}

	public void setCargarid_formato_pedidoParametroCompra(Boolean cargarid_formato_pedidoParametroCompra) {
		this.cargarid_formato_pedidoParametroCompra= cargarid_formato_pedidoParametroCompra;
	}

	public Border setResaltarid_estado_pedido_pendienteParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_pendienteParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_pendienteParametroCompra() {
		return this.resaltarid_estado_pedido_pendienteParametroCompra;
	}

	public void setResaltarid_estado_pedido_pendienteParametroCompra(Border borderResaltar) {
		this.resaltarid_estado_pedido_pendienteParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_pendienteParametroCompra() {
		return this.mostrarid_estado_pedido_pendienteParametroCompra;
	}

	public void setMostrarid_estado_pedido_pendienteParametroCompra(Boolean mostrarid_estado_pedido_pendienteParametroCompra) {
		this.mostrarid_estado_pedido_pendienteParametroCompra= mostrarid_estado_pedido_pendienteParametroCompra;
	}

	public Boolean getActivarid_estado_pedido_pendienteParametroCompra() {
		return this.activarid_estado_pedido_pendienteParametroCompra;
	}

	public void setActivarid_estado_pedido_pendienteParametroCompra(Boolean activarid_estado_pedido_pendienteParametroCompra) {
		this.activarid_estado_pedido_pendienteParametroCompra= activarid_estado_pedido_pendienteParametroCompra;
	}

	public Boolean getCargarid_estado_pedido_pendienteParametroCompra() {
		return this.cargarid_estado_pedido_pendienteParametroCompra;
	}

	public void setCargarid_estado_pedido_pendienteParametroCompra(Boolean cargarid_estado_pedido_pendienteParametroCompra) {
		this.cargarid_estado_pedido_pendienteParametroCompra= cargarid_estado_pedido_pendienteParametroCompra;
	}

	public Border setResaltarid_formato_cotizacionParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_formato_cotizacionParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_cotizacionParametroCompra() {
		return this.resaltarid_formato_cotizacionParametroCompra;
	}

	public void setResaltarid_formato_cotizacionParametroCompra(Border borderResaltar) {
		this.resaltarid_formato_cotizacionParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_formato_cotizacionParametroCompra() {
		return this.mostrarid_formato_cotizacionParametroCompra;
	}

	public void setMostrarid_formato_cotizacionParametroCompra(Boolean mostrarid_formato_cotizacionParametroCompra) {
		this.mostrarid_formato_cotizacionParametroCompra= mostrarid_formato_cotizacionParametroCompra;
	}

	public Boolean getActivarid_formato_cotizacionParametroCompra() {
		return this.activarid_formato_cotizacionParametroCompra;
	}

	public void setActivarid_formato_cotizacionParametroCompra(Boolean activarid_formato_cotizacionParametroCompra) {
		this.activarid_formato_cotizacionParametroCompra= activarid_formato_cotizacionParametroCompra;
	}

	public Boolean getCargarid_formato_cotizacionParametroCompra() {
		return this.cargarid_formato_cotizacionParametroCompra;
	}

	public void setCargarid_formato_cotizacionParametroCompra(Boolean cargarid_formato_cotizacionParametroCompra) {
		this.cargarid_formato_cotizacionParametroCompra= cargarid_formato_cotizacionParametroCompra;
	}

	public Border setResaltarid_estado_pedido_cotizadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_cotizadoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_cotizadoParametroCompra() {
		return this.resaltarid_estado_pedido_cotizadoParametroCompra;
	}

	public void setResaltarid_estado_pedido_cotizadoParametroCompra(Border borderResaltar) {
		this.resaltarid_estado_pedido_cotizadoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_cotizadoParametroCompra() {
		return this.mostrarid_estado_pedido_cotizadoParametroCompra;
	}

	public void setMostrarid_estado_pedido_cotizadoParametroCompra(Boolean mostrarid_estado_pedido_cotizadoParametroCompra) {
		this.mostrarid_estado_pedido_cotizadoParametroCompra= mostrarid_estado_pedido_cotizadoParametroCompra;
	}

	public Boolean getActivarid_estado_pedido_cotizadoParametroCompra() {
		return this.activarid_estado_pedido_cotizadoParametroCompra;
	}

	public void setActivarid_estado_pedido_cotizadoParametroCompra(Boolean activarid_estado_pedido_cotizadoParametroCompra) {
		this.activarid_estado_pedido_cotizadoParametroCompra= activarid_estado_pedido_cotizadoParametroCompra;
	}

	public Boolean getCargarid_estado_pedido_cotizadoParametroCompra() {
		return this.cargarid_estado_pedido_cotizadoParametroCompra;
	}

	public void setCargarid_estado_pedido_cotizadoParametroCompra(Boolean cargarid_estado_pedido_cotizadoParametroCompra) {
		this.cargarid_estado_pedido_cotizadoParametroCompra= cargarid_estado_pedido_cotizadoParametroCompra;
	}

	public Border setResaltarid_formato_autorizacionParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_formato_autorizacionParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_autorizacionParametroCompra() {
		return this.resaltarid_formato_autorizacionParametroCompra;
	}

	public void setResaltarid_formato_autorizacionParametroCompra(Border borderResaltar) {
		this.resaltarid_formato_autorizacionParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_formato_autorizacionParametroCompra() {
		return this.mostrarid_formato_autorizacionParametroCompra;
	}

	public void setMostrarid_formato_autorizacionParametroCompra(Boolean mostrarid_formato_autorizacionParametroCompra) {
		this.mostrarid_formato_autorizacionParametroCompra= mostrarid_formato_autorizacionParametroCompra;
	}

	public Boolean getActivarid_formato_autorizacionParametroCompra() {
		return this.activarid_formato_autorizacionParametroCompra;
	}

	public void setActivarid_formato_autorizacionParametroCompra(Boolean activarid_formato_autorizacionParametroCompra) {
		this.activarid_formato_autorizacionParametroCompra= activarid_formato_autorizacionParametroCompra;
	}

	public Boolean getCargarid_formato_autorizacionParametroCompra() {
		return this.cargarid_formato_autorizacionParametroCompra;
	}

	public void setCargarid_formato_autorizacionParametroCompra(Boolean cargarid_formato_autorizacionParametroCompra) {
		this.cargarid_formato_autorizacionParametroCompra= cargarid_formato_autorizacionParametroCompra;
	}

	public Border setResaltarid_estado_pedido_autorizadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_autorizadoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_autorizadoParametroCompra() {
		return this.resaltarid_estado_pedido_autorizadoParametroCompra;
	}

	public void setResaltarid_estado_pedido_autorizadoParametroCompra(Border borderResaltar) {
		this.resaltarid_estado_pedido_autorizadoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_autorizadoParametroCompra() {
		return this.mostrarid_estado_pedido_autorizadoParametroCompra;
	}

	public void setMostrarid_estado_pedido_autorizadoParametroCompra(Boolean mostrarid_estado_pedido_autorizadoParametroCompra) {
		this.mostrarid_estado_pedido_autorizadoParametroCompra= mostrarid_estado_pedido_autorizadoParametroCompra;
	}

	public Boolean getActivarid_estado_pedido_autorizadoParametroCompra() {
		return this.activarid_estado_pedido_autorizadoParametroCompra;
	}

	public void setActivarid_estado_pedido_autorizadoParametroCompra(Boolean activarid_estado_pedido_autorizadoParametroCompra) {
		this.activarid_estado_pedido_autorizadoParametroCompra= activarid_estado_pedido_autorizadoParametroCompra;
	}

	public Boolean getCargarid_estado_pedido_autorizadoParametroCompra() {
		return this.cargarid_estado_pedido_autorizadoParametroCompra;
	}

	public void setCargarid_estado_pedido_autorizadoParametroCompra(Boolean cargarid_estado_pedido_autorizadoParametroCompra) {
		this.cargarid_estado_pedido_autorizadoParametroCompra= cargarid_estado_pedido_autorizadoParametroCompra;
	}

	public Border setResaltarid_formato_itemParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_formato_itemParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_itemParametroCompra() {
		return this.resaltarid_formato_itemParametroCompra;
	}

	public void setResaltarid_formato_itemParametroCompra(Border borderResaltar) {
		this.resaltarid_formato_itemParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_formato_itemParametroCompra() {
		return this.mostrarid_formato_itemParametroCompra;
	}

	public void setMostrarid_formato_itemParametroCompra(Boolean mostrarid_formato_itemParametroCompra) {
		this.mostrarid_formato_itemParametroCompra= mostrarid_formato_itemParametroCompra;
	}

	public Boolean getActivarid_formato_itemParametroCompra() {
		return this.activarid_formato_itemParametroCompra;
	}

	public void setActivarid_formato_itemParametroCompra(Boolean activarid_formato_itemParametroCompra) {
		this.activarid_formato_itemParametroCompra= activarid_formato_itemParametroCompra;
	}

	public Boolean getCargarid_formato_itemParametroCompra() {
		return this.cargarid_formato_itemParametroCompra;
	}

	public void setCargarid_formato_itemParametroCompra(Boolean cargarid_formato_itemParametroCompra) {
		this.cargarid_formato_itemParametroCompra= cargarid_formato_itemParametroCompra;
	}

	public Border setResaltarid_estado_pedido_anuladoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_anuladoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_anuladoParametroCompra() {
		return this.resaltarid_estado_pedido_anuladoParametroCompra;
	}

	public void setResaltarid_estado_pedido_anuladoParametroCompra(Border borderResaltar) {
		this.resaltarid_estado_pedido_anuladoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_anuladoParametroCompra() {
		return this.mostrarid_estado_pedido_anuladoParametroCompra;
	}

	public void setMostrarid_estado_pedido_anuladoParametroCompra(Boolean mostrarid_estado_pedido_anuladoParametroCompra) {
		this.mostrarid_estado_pedido_anuladoParametroCompra= mostrarid_estado_pedido_anuladoParametroCompra;
	}

	public Boolean getActivarid_estado_pedido_anuladoParametroCompra() {
		return this.activarid_estado_pedido_anuladoParametroCompra;
	}

	public void setActivarid_estado_pedido_anuladoParametroCompra(Boolean activarid_estado_pedido_anuladoParametroCompra) {
		this.activarid_estado_pedido_anuladoParametroCompra= activarid_estado_pedido_anuladoParametroCompra;
	}

	public Boolean getCargarid_estado_pedido_anuladoParametroCompra() {
		return this.cargarid_estado_pedido_anuladoParametroCompra;
	}

	public void setCargarid_estado_pedido_anuladoParametroCompra(Boolean cargarid_estado_pedido_anuladoParametroCompra) {
		this.cargarid_estado_pedido_anuladoParametroCompra= cargarid_estado_pedido_anuladoParametroCompra;
	}

	public Border setResaltarid_prioridad_pedidoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_prioridad_pedidoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_prioridad_pedidoParametroCompra() {
		return this.resaltarid_prioridad_pedidoParametroCompra;
	}

	public void setResaltarid_prioridad_pedidoParametroCompra(Border borderResaltar) {
		this.resaltarid_prioridad_pedidoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_prioridad_pedidoParametroCompra() {
		return this.mostrarid_prioridad_pedidoParametroCompra;
	}

	public void setMostrarid_prioridad_pedidoParametroCompra(Boolean mostrarid_prioridad_pedidoParametroCompra) {
		this.mostrarid_prioridad_pedidoParametroCompra= mostrarid_prioridad_pedidoParametroCompra;
	}

	public Boolean getActivarid_prioridad_pedidoParametroCompra() {
		return this.activarid_prioridad_pedidoParametroCompra;
	}

	public void setActivarid_prioridad_pedidoParametroCompra(Boolean activarid_prioridad_pedidoParametroCompra) {
		this.activarid_prioridad_pedidoParametroCompra= activarid_prioridad_pedidoParametroCompra;
	}

	public Boolean getCargarid_prioridad_pedidoParametroCompra() {
		return this.cargarid_prioridad_pedidoParametroCompra;
	}

	public void setCargarid_prioridad_pedidoParametroCompra(Boolean cargarid_prioridad_pedidoParametroCompra) {
		this.cargarid_prioridad_pedidoParametroCompra= cargarid_prioridad_pedidoParametroCompra;
	}

	public Border setResaltarid_estado_pedido_suspendidoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_suspendidoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_suspendidoParametroCompra() {
		return this.resaltarid_estado_pedido_suspendidoParametroCompra;
	}

	public void setResaltarid_estado_pedido_suspendidoParametroCompra(Border borderResaltar) {
		this.resaltarid_estado_pedido_suspendidoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_suspendidoParametroCompra() {
		return this.mostrarid_estado_pedido_suspendidoParametroCompra;
	}

	public void setMostrarid_estado_pedido_suspendidoParametroCompra(Boolean mostrarid_estado_pedido_suspendidoParametroCompra) {
		this.mostrarid_estado_pedido_suspendidoParametroCompra= mostrarid_estado_pedido_suspendidoParametroCompra;
	}

	public Boolean getActivarid_estado_pedido_suspendidoParametroCompra() {
		return this.activarid_estado_pedido_suspendidoParametroCompra;
	}

	public void setActivarid_estado_pedido_suspendidoParametroCompra(Boolean activarid_estado_pedido_suspendidoParametroCompra) {
		this.activarid_estado_pedido_suspendidoParametroCompra= activarid_estado_pedido_suspendidoParametroCompra;
	}

	public Boolean getCargarid_estado_pedido_suspendidoParametroCompra() {
		return this.cargarid_estado_pedido_suspendidoParametroCompra;
	}

	public void setCargarid_estado_pedido_suspendidoParametroCompra(Boolean cargarid_estado_pedido_suspendidoParametroCompra) {
		this.cargarid_estado_pedido_suspendidoParametroCompra= cargarid_estado_pedido_suspendidoParametroCompra;
	}

	public Border setResaltarid_estado_pedido_regularizadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocompraBeanSwingJInternalFrame.jTtoolBarParametroCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedido_regularizadoParametroCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedido_regularizadoParametroCompra() {
		return this.resaltarid_estado_pedido_regularizadoParametroCompra;
	}

	public void setResaltarid_estado_pedido_regularizadoParametroCompra(Border borderResaltar) {
		this.resaltarid_estado_pedido_regularizadoParametroCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedido_regularizadoParametroCompra() {
		return this.mostrarid_estado_pedido_regularizadoParametroCompra;
	}

	public void setMostrarid_estado_pedido_regularizadoParametroCompra(Boolean mostrarid_estado_pedido_regularizadoParametroCompra) {
		this.mostrarid_estado_pedido_regularizadoParametroCompra= mostrarid_estado_pedido_regularizadoParametroCompra;
	}

	public Boolean getActivarid_estado_pedido_regularizadoParametroCompra() {
		return this.activarid_estado_pedido_regularizadoParametroCompra;
	}

	public void setActivarid_estado_pedido_regularizadoParametroCompra(Boolean activarid_estado_pedido_regularizadoParametroCompra) {
		this.activarid_estado_pedido_regularizadoParametroCompra= activarid_estado_pedido_regularizadoParametroCompra;
	}

	public Boolean getCargarid_estado_pedido_regularizadoParametroCompra() {
		return this.cargarid_estado_pedido_regularizadoParametroCompra;
	}

	public void setCargarid_estado_pedido_regularizadoParametroCompra(Boolean cargarid_estado_pedido_regularizadoParametroCompra) {
		this.cargarid_estado_pedido_regularizadoParametroCompra= cargarid_estado_pedido_regularizadoParametroCompra;
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
		
		
		this.setMostraridParametroCompra(esInicial);
		this.setMostrarid_empresaParametroCompra(esInicial);
		this.setMostrarsecuencial_pedidoParametroCompra(esInicial);
		this.setMostrarsecuencial_cotizacionParametroCompra(esInicial);
		this.setMostrarsecuencial_produccionParametroCompra(esInicial);
		this.setMostrarid_tipo_documentoParametroCompra(esInicial);
		this.setMostrarid_tipo_movimientoParametroCompra(esInicial);
		this.setMostrarid_bodegaParametroCompra(esInicial);
		this.setMostrarid_bodega_reservaParametroCompra(esInicial);
		this.setMostrarid_empleadoParametroCompra(esInicial);
		this.setMostrarid_embarcadorParametroCompra(esInicial);
		this.setMostrarcon_centro_costoParametroCompra(esInicial);
		this.setMostrartexto_mailParametroCompra(esInicial);
		this.setMostrarid_moduloParametroCompra(esInicial);
		this.setMostrarid_tipo_movimiento_moduloParametroCompra(esInicial);
		this.setMostrardescripcionParametroCompra(esInicial);
		this.setMostrarid_formato_pedidoParametroCompra(esInicial);
		this.setMostrarid_estado_pedido_pendienteParametroCompra(esInicial);
		this.setMostrarid_formato_cotizacionParametroCompra(esInicial);
		this.setMostrarid_estado_pedido_cotizadoParametroCompra(esInicial);
		this.setMostrarid_formato_autorizacionParametroCompra(esInicial);
		this.setMostrarid_estado_pedido_autorizadoParametroCompra(esInicial);
		this.setMostrarid_formato_itemParametroCompra(esInicial);
		this.setMostrarid_estado_pedido_anuladoParametroCompra(esInicial);
		this.setMostrarid_prioridad_pedidoParametroCompra(esInicial);
		this.setMostrarid_estado_pedido_suspendidoParametroCompra(esInicial);
		this.setMostrarid_estado_pedido_regularizadoParametroCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCompraConstantesFunciones.ID)) {
				this.setMostraridParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setMostrarsecuencial_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION)) {
				this.setMostrarsecuencial_cotizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION)) {
				this.setMostrarsecuencial_produccionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDBODEGARESERVA)) {
				this.setMostrarid_bodega_reservaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMBARCADOR)) {
				this.setMostrarid_embarcadorParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.CONCENTROCOSTO)) {
				this.setMostrarcon_centro_costoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.TEXTOMAIL)) {
				this.setMostrartexto_mailParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setMostrarid_tipo_movimiento_moduloParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setMostrarid_formato_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE)) {
				this.setMostrarid_estado_pedido_pendienteParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION)) {
				this.setMostrarid_formato_cotizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO)) {
				this.setMostrarid_estado_pedido_cotizadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION)) {
				this.setMostrarid_formato_autorizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO)) {
				this.setMostrarid_estado_pedido_autorizadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOITEM)) {
				this.setMostrarid_formato_itemParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO)) {
				this.setMostrarid_estado_pedido_anuladoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO)) {
				this.setMostrarid_prioridad_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO)) {
				this.setMostrarid_estado_pedido_suspendidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO)) {
				this.setMostrarid_estado_pedido_regularizadoParametroCompra(esAsigna);
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
		
		
		this.setActivaridParametroCompra(esInicial);
		this.setActivarid_empresaParametroCompra(esInicial);
		this.setActivarsecuencial_pedidoParametroCompra(esInicial);
		this.setActivarsecuencial_cotizacionParametroCompra(esInicial);
		this.setActivarsecuencial_produccionParametroCompra(esInicial);
		this.setActivarid_tipo_documentoParametroCompra(esInicial);
		this.setActivarid_tipo_movimientoParametroCompra(esInicial);
		this.setActivarid_bodegaParametroCompra(esInicial);
		this.setActivarid_bodega_reservaParametroCompra(esInicial);
		this.setActivarid_empleadoParametroCompra(esInicial);
		this.setActivarid_embarcadorParametroCompra(esInicial);
		this.setActivarcon_centro_costoParametroCompra(esInicial);
		this.setActivartexto_mailParametroCompra(esInicial);
		this.setActivarid_moduloParametroCompra(esInicial);
		this.setActivarid_tipo_movimiento_moduloParametroCompra(esInicial);
		this.setActivardescripcionParametroCompra(esInicial);
		this.setActivarid_formato_pedidoParametroCompra(esInicial);
		this.setActivarid_estado_pedido_pendienteParametroCompra(esInicial);
		this.setActivarid_formato_cotizacionParametroCompra(esInicial);
		this.setActivarid_estado_pedido_cotizadoParametroCompra(esInicial);
		this.setActivarid_formato_autorizacionParametroCompra(esInicial);
		this.setActivarid_estado_pedido_autorizadoParametroCompra(esInicial);
		this.setActivarid_formato_itemParametroCompra(esInicial);
		this.setActivarid_estado_pedido_anuladoParametroCompra(esInicial);
		this.setActivarid_prioridad_pedidoParametroCompra(esInicial);
		this.setActivarid_estado_pedido_suspendidoParametroCompra(esInicial);
		this.setActivarid_estado_pedido_regularizadoParametroCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCompraConstantesFunciones.ID)) {
				this.setActivaridParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setActivarsecuencial_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION)) {
				this.setActivarsecuencial_cotizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION)) {
				this.setActivarsecuencial_produccionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDBODEGARESERVA)) {
				this.setActivarid_bodega_reservaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMBARCADOR)) {
				this.setActivarid_embarcadorParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.CONCENTROCOSTO)) {
				this.setActivarcon_centro_costoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.TEXTOMAIL)) {
				this.setActivartexto_mailParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setActivarid_tipo_movimiento_moduloParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setActivarid_formato_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE)) {
				this.setActivarid_estado_pedido_pendienteParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION)) {
				this.setActivarid_formato_cotizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO)) {
				this.setActivarid_estado_pedido_cotizadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION)) {
				this.setActivarid_formato_autorizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO)) {
				this.setActivarid_estado_pedido_autorizadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOITEM)) {
				this.setActivarid_formato_itemParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO)) {
				this.setActivarid_estado_pedido_anuladoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO)) {
				this.setActivarid_prioridad_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO)) {
				this.setActivarid_estado_pedido_suspendidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO)) {
				this.setActivarid_estado_pedido_regularizadoParametroCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroCompra(esInicial);
		this.setResaltarid_empresaParametroCompra(esInicial);
		this.setResaltarsecuencial_pedidoParametroCompra(esInicial);
		this.setResaltarsecuencial_cotizacionParametroCompra(esInicial);
		this.setResaltarsecuencial_produccionParametroCompra(esInicial);
		this.setResaltarid_tipo_documentoParametroCompra(esInicial);
		this.setResaltarid_tipo_movimientoParametroCompra(esInicial);
		this.setResaltarid_bodegaParametroCompra(esInicial);
		this.setResaltarid_bodega_reservaParametroCompra(esInicial);
		this.setResaltarid_empleadoParametroCompra(esInicial);
		this.setResaltarid_embarcadorParametroCompra(esInicial);
		this.setResaltarcon_centro_costoParametroCompra(esInicial);
		this.setResaltartexto_mailParametroCompra(esInicial);
		this.setResaltarid_moduloParametroCompra(esInicial);
		this.setResaltarid_tipo_movimiento_moduloParametroCompra(esInicial);
		this.setResaltardescripcionParametroCompra(esInicial);
		this.setResaltarid_formato_pedidoParametroCompra(esInicial);
		this.setResaltarid_estado_pedido_pendienteParametroCompra(esInicial);
		this.setResaltarid_formato_cotizacionParametroCompra(esInicial);
		this.setResaltarid_estado_pedido_cotizadoParametroCompra(esInicial);
		this.setResaltarid_formato_autorizacionParametroCompra(esInicial);
		this.setResaltarid_estado_pedido_autorizadoParametroCompra(esInicial);
		this.setResaltarid_formato_itemParametroCompra(esInicial);
		this.setResaltarid_estado_pedido_anuladoParametroCompra(esInicial);
		this.setResaltarid_prioridad_pedidoParametroCompra(esInicial);
		this.setResaltarid_estado_pedido_suspendidoParametroCompra(esInicial);
		this.setResaltarid_estado_pedido_regularizadoParametroCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroCompraConstantesFunciones.ID)) {
				this.setResaltaridParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setResaltarsecuencial_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION)) {
				this.setResaltarsecuencial_cotizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION)) {
				this.setResaltarsecuencial_produccionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDBODEGARESERVA)) {
				this.setResaltarid_bodega_reservaParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDEMBARCADOR)) {
				this.setResaltarid_embarcadorParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.CONCENTROCOSTO)) {
				this.setResaltarcon_centro_costoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.TEXTOMAIL)) {
				this.setResaltartexto_mailParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setResaltarid_tipo_movimiento_moduloParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setResaltarid_formato_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE)) {
				this.setResaltarid_estado_pedido_pendienteParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION)) {
				this.setResaltarid_formato_cotizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO)) {
				this.setResaltarid_estado_pedido_cotizadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION)) {
				this.setResaltarid_formato_autorizacionParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO)) {
				this.setResaltarid_estado_pedido_autorizadoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDFORMATOITEM)) {
				this.setResaltarid_formato_itemParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO)) {
				this.setResaltarid_estado_pedido_anuladoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO)) {
				this.setResaltarid_prioridad_pedidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO)) {
				this.setResaltarid_estado_pedido_suspendidoParametroCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO)) {
				this.setResaltarid_estado_pedido_regularizadoParametroCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaParametroCompra=true;

	public Boolean getMostrarFK_IdBodegaParametroCompra() {
		return this.mostrarFK_IdBodegaParametroCompra;
	}

	public void setMostrarFK_IdBodegaParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaReservaParametroCompra=true;

	public Boolean getMostrarFK_IdBodegaReservaParametroCompra() {
		return this.mostrarFK_IdBodegaReservaParametroCompra;
	}

	public void setMostrarFK_IdBodegaReservaParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaReservaParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmbarcadorParametroCompra=true;

	public Boolean getMostrarFK_IdEmbarcadorParametroCompra() {
		return this.mostrarFK_IdEmbarcadorParametroCompra;
	}

	public void setMostrarFK_IdEmbarcadorParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmbarcadorParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoParametroCompra=true;

	public Boolean getMostrarFK_IdEmpleadoParametroCompra() {
		return this.mostrarFK_IdEmpleadoParametroCompra;
	}

	public void setMostrarFK_IdEmpleadoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroCompra=true;

	public Boolean getMostrarFK_IdEmpresaParametroCompra() {
		return this.mostrarFK_IdEmpresaParametroCompra;
	}

	public void setMostrarFK_IdEmpresaParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoAnuladoParametroCompra=true;

	public Boolean getMostrarFK_IdEstadoPedidoAnuladoParametroCompra() {
		return this.mostrarFK_IdEstadoPedidoAnuladoParametroCompra;
	}

	public void setMostrarFK_IdEstadoPedidoAnuladoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoAnuladoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoAutorizadoParametroCompra=true;

	public Boolean getMostrarFK_IdEstadoPedidoAutorizadoParametroCompra() {
		return this.mostrarFK_IdEstadoPedidoAutorizadoParametroCompra;
	}

	public void setMostrarFK_IdEstadoPedidoAutorizadoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoAutorizadoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoCotizadoParametroCompra=true;

	public Boolean getMostrarFK_IdEstadoPedidoCotizadoParametroCompra() {
		return this.mostrarFK_IdEstadoPedidoCotizadoParametroCompra;
	}

	public void setMostrarFK_IdEstadoPedidoCotizadoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoCotizadoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoPendienteParametroCompra=true;

	public Boolean getMostrarFK_IdEstadoPedidoPendienteParametroCompra() {
		return this.mostrarFK_IdEstadoPedidoPendienteParametroCompra;
	}

	public void setMostrarFK_IdEstadoPedidoPendienteParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoPendienteParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoRegularizadoParametroCompra=true;

	public Boolean getMostrarFK_IdEstadoPedidoRegularizadoParametroCompra() {
		return this.mostrarFK_IdEstadoPedidoRegularizadoParametroCompra;
	}

	public void setMostrarFK_IdEstadoPedidoRegularizadoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoRegularizadoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoSuspendoParametroCompra=true;

	public Boolean getMostrarFK_IdEstadoPedidoSuspendoParametroCompra() {
		return this.mostrarFK_IdEstadoPedidoSuspendoParametroCompra;
	}

	public void setMostrarFK_IdEstadoPedidoSuspendoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoSuspendoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoAutorizacionParametroCompra=true;

	public Boolean getMostrarFK_IdFormatoAutorizacionParametroCompra() {
		return this.mostrarFK_IdFormatoAutorizacionParametroCompra;
	}

	public void setMostrarFK_IdFormatoAutorizacionParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoAutorizacionParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoCotizacionParametroCompra=true;

	public Boolean getMostrarFK_IdFormatoCotizacionParametroCompra() {
		return this.mostrarFK_IdFormatoCotizacionParametroCompra;
	}

	public void setMostrarFK_IdFormatoCotizacionParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoCotizacionParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoItemParametroCompra=true;

	public Boolean getMostrarFK_IdFormatoItemParametroCompra() {
		return this.mostrarFK_IdFormatoItemParametroCompra;
	}

	public void setMostrarFK_IdFormatoItemParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoItemParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoPedidoParametroCompra=true;

	public Boolean getMostrarFK_IdFormatoPedidoParametroCompra() {
		return this.mostrarFK_IdFormatoPedidoParametroCompra;
	}

	public void setMostrarFK_IdFormatoPedidoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoPedidoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloParametroCompra=true;

	public Boolean getMostrarFK_IdModuloParametroCompra() {
		return this.mostrarFK_IdModuloParametroCompra;
	}

	public void setMostrarFK_IdModuloParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPrioridadPedidoParametroCompra=true;

	public Boolean getMostrarFK_IdPrioridadPedidoParametroCompra() {
		return this.mostrarFK_IdPrioridadPedidoParametroCompra;
	}

	public void setMostrarFK_IdPrioridadPedidoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPrioridadPedidoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoParametroCompra=true;

	public Boolean getMostrarFK_IdTipoDocumentoParametroCompra() {
		return this.mostrarFK_IdTipoDocumentoParametroCompra;
	}

	public void setMostrarFK_IdTipoDocumentoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoParametroCompra=true;

	public Boolean getMostrarFK_IdTipoMovimientoParametroCompra() {
		return this.mostrarFK_IdTipoMovimientoParametroCompra;
	}

	public void setMostrarFK_IdTipoMovimientoParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoParametroCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoModuloParametroCompra=true;

	public Boolean getMostrarFK_IdTipoMovimientoModuloParametroCompra() {
		return this.mostrarFK_IdTipoMovimientoModuloParametroCompra;
	}

	public void setMostrarFK_IdTipoMovimientoModuloParametroCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoModuloParametroCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaParametroCompra=true;

	public Boolean getActivarFK_IdBodegaParametroCompra() {
		return this.activarFK_IdBodegaParametroCompra;
	}

	public void setActivarFK_IdBodegaParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaReservaParametroCompra=true;

	public Boolean getActivarFK_IdBodegaReservaParametroCompra() {
		return this.activarFK_IdBodegaReservaParametroCompra;
	}

	public void setActivarFK_IdBodegaReservaParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaReservaParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmbarcadorParametroCompra=true;

	public Boolean getActivarFK_IdEmbarcadorParametroCompra() {
		return this.activarFK_IdEmbarcadorParametroCompra;
	}

	public void setActivarFK_IdEmbarcadorParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmbarcadorParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoParametroCompra=true;

	public Boolean getActivarFK_IdEmpleadoParametroCompra() {
		return this.activarFK_IdEmpleadoParametroCompra;
	}

	public void setActivarFK_IdEmpleadoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroCompra=true;

	public Boolean getActivarFK_IdEmpresaParametroCompra() {
		return this.activarFK_IdEmpresaParametroCompra;
	}

	public void setActivarFK_IdEmpresaParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoAnuladoParametroCompra=true;

	public Boolean getActivarFK_IdEstadoPedidoAnuladoParametroCompra() {
		return this.activarFK_IdEstadoPedidoAnuladoParametroCompra;
	}

	public void setActivarFK_IdEstadoPedidoAnuladoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoAnuladoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoAutorizadoParametroCompra=true;

	public Boolean getActivarFK_IdEstadoPedidoAutorizadoParametroCompra() {
		return this.activarFK_IdEstadoPedidoAutorizadoParametroCompra;
	}

	public void setActivarFK_IdEstadoPedidoAutorizadoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoAutorizadoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoCotizadoParametroCompra=true;

	public Boolean getActivarFK_IdEstadoPedidoCotizadoParametroCompra() {
		return this.activarFK_IdEstadoPedidoCotizadoParametroCompra;
	}

	public void setActivarFK_IdEstadoPedidoCotizadoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoCotizadoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoPendienteParametroCompra=true;

	public Boolean getActivarFK_IdEstadoPedidoPendienteParametroCompra() {
		return this.activarFK_IdEstadoPedidoPendienteParametroCompra;
	}

	public void setActivarFK_IdEstadoPedidoPendienteParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoPendienteParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoRegularizadoParametroCompra=true;

	public Boolean getActivarFK_IdEstadoPedidoRegularizadoParametroCompra() {
		return this.activarFK_IdEstadoPedidoRegularizadoParametroCompra;
	}

	public void setActivarFK_IdEstadoPedidoRegularizadoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoRegularizadoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoSuspendoParametroCompra=true;

	public Boolean getActivarFK_IdEstadoPedidoSuspendoParametroCompra() {
		return this.activarFK_IdEstadoPedidoSuspendoParametroCompra;
	}

	public void setActivarFK_IdEstadoPedidoSuspendoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoSuspendoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoAutorizacionParametroCompra=true;

	public Boolean getActivarFK_IdFormatoAutorizacionParametroCompra() {
		return this.activarFK_IdFormatoAutorizacionParametroCompra;
	}

	public void setActivarFK_IdFormatoAutorizacionParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoAutorizacionParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoCotizacionParametroCompra=true;

	public Boolean getActivarFK_IdFormatoCotizacionParametroCompra() {
		return this.activarFK_IdFormatoCotizacionParametroCompra;
	}

	public void setActivarFK_IdFormatoCotizacionParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoCotizacionParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoItemParametroCompra=true;

	public Boolean getActivarFK_IdFormatoItemParametroCompra() {
		return this.activarFK_IdFormatoItemParametroCompra;
	}

	public void setActivarFK_IdFormatoItemParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoItemParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoPedidoParametroCompra=true;

	public Boolean getActivarFK_IdFormatoPedidoParametroCompra() {
		return this.activarFK_IdFormatoPedidoParametroCompra;
	}

	public void setActivarFK_IdFormatoPedidoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoPedidoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloParametroCompra=true;

	public Boolean getActivarFK_IdModuloParametroCompra() {
		return this.activarFK_IdModuloParametroCompra;
	}

	public void setActivarFK_IdModuloParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdModuloParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPrioridadPedidoParametroCompra=true;

	public Boolean getActivarFK_IdPrioridadPedidoParametroCompra() {
		return this.activarFK_IdPrioridadPedidoParametroCompra;
	}

	public void setActivarFK_IdPrioridadPedidoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPrioridadPedidoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoParametroCompra=true;

	public Boolean getActivarFK_IdTipoDocumentoParametroCompra() {
		return this.activarFK_IdTipoDocumentoParametroCompra;
	}

	public void setActivarFK_IdTipoDocumentoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoParametroCompra=true;

	public Boolean getActivarFK_IdTipoMovimientoParametroCompra() {
		return this.activarFK_IdTipoMovimientoParametroCompra;
	}

	public void setActivarFK_IdTipoMovimientoParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoParametroCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoModuloParametroCompra=true;

	public Boolean getActivarFK_IdTipoMovimientoModuloParametroCompra() {
		return this.activarFK_IdTipoMovimientoModuloParametroCompra;
	}

	public void setActivarFK_IdTipoMovimientoModuloParametroCompra(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoModuloParametroCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaParametroCompra=null;

	public Border getResaltarFK_IdBodegaParametroCompra() {
		return this.resaltarFK_IdBodegaParametroCompra;
	}

	public void setResaltarFK_IdBodegaParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdBodegaParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdBodegaParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdBodegaReservaParametroCompra=null;

	public Border getResaltarFK_IdBodegaReservaParametroCompra() {
		return this.resaltarFK_IdBodegaReservaParametroCompra;
	}

	public void setResaltarFK_IdBodegaReservaParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdBodegaReservaParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdBodegaReservaParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaReservaParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmbarcadorParametroCompra=null;

	public Border getResaltarFK_IdEmbarcadorParametroCompra() {
		return this.resaltarFK_IdEmbarcadorParametroCompra;
	}

	public void setResaltarFK_IdEmbarcadorParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEmbarcadorParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmbarcadorParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmbarcadorParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoParametroCompra=null;

	public Border getResaltarFK_IdEmpleadoParametroCompra() {
		return this.resaltarFK_IdEmpleadoParametroCompra;
	}

	public void setResaltarFK_IdEmpleadoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroCompra=null;

	public Border getResaltarFK_IdEmpresaParametroCompra() {
		return this.resaltarFK_IdEmpresaParametroCompra;
	}

	public void setResaltarFK_IdEmpresaParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoAnuladoParametroCompra=null;

	public Border getResaltarFK_IdEstadoPedidoAnuladoParametroCompra() {
		return this.resaltarFK_IdEstadoPedidoAnuladoParametroCompra;
	}

	public void setResaltarFK_IdEstadoPedidoAnuladoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoAnuladoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoAnuladoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoAnuladoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoAutorizadoParametroCompra=null;

	public Border getResaltarFK_IdEstadoPedidoAutorizadoParametroCompra() {
		return this.resaltarFK_IdEstadoPedidoAutorizadoParametroCompra;
	}

	public void setResaltarFK_IdEstadoPedidoAutorizadoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoAutorizadoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoAutorizadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoAutorizadoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoCotizadoParametroCompra=null;

	public Border getResaltarFK_IdEstadoPedidoCotizadoParametroCompra() {
		return this.resaltarFK_IdEstadoPedidoCotizadoParametroCompra;
	}

	public void setResaltarFK_IdEstadoPedidoCotizadoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoCotizadoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoCotizadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoCotizadoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoPendienteParametroCompra=null;

	public Border getResaltarFK_IdEstadoPedidoPendienteParametroCompra() {
		return this.resaltarFK_IdEstadoPedidoPendienteParametroCompra;
	}

	public void setResaltarFK_IdEstadoPedidoPendienteParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoPendienteParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoPendienteParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoPendienteParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoRegularizadoParametroCompra=null;

	public Border getResaltarFK_IdEstadoPedidoRegularizadoParametroCompra() {
		return this.resaltarFK_IdEstadoPedidoRegularizadoParametroCompra;
	}

	public void setResaltarFK_IdEstadoPedidoRegularizadoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoRegularizadoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoRegularizadoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoRegularizadoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoSuspendoParametroCompra=null;

	public Border getResaltarFK_IdEstadoPedidoSuspendoParametroCompra() {
		return this.resaltarFK_IdEstadoPedidoSuspendoParametroCompra;
	}

	public void setResaltarFK_IdEstadoPedidoSuspendoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoSuspendoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoSuspendoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoSuspendoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdFormatoAutorizacionParametroCompra=null;

	public Border getResaltarFK_IdFormatoAutorizacionParametroCompra() {
		return this.resaltarFK_IdFormatoAutorizacionParametroCompra;
	}

	public void setResaltarFK_IdFormatoAutorizacionParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdFormatoAutorizacionParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdFormatoAutorizacionParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoAutorizacionParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdFormatoCotizacionParametroCompra=null;

	public Border getResaltarFK_IdFormatoCotizacionParametroCompra() {
		return this.resaltarFK_IdFormatoCotizacionParametroCompra;
	}

	public void setResaltarFK_IdFormatoCotizacionParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdFormatoCotizacionParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdFormatoCotizacionParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoCotizacionParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdFormatoItemParametroCompra=null;

	public Border getResaltarFK_IdFormatoItemParametroCompra() {
		return this.resaltarFK_IdFormatoItemParametroCompra;
	}

	public void setResaltarFK_IdFormatoItemParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdFormatoItemParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdFormatoItemParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoItemParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdFormatoPedidoParametroCompra=null;

	public Border getResaltarFK_IdFormatoPedidoParametroCompra() {
		return this.resaltarFK_IdFormatoPedidoParametroCompra;
	}

	public void setResaltarFK_IdFormatoPedidoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdFormatoPedidoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdFormatoPedidoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoPedidoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdModuloParametroCompra=null;

	public Border getResaltarFK_IdModuloParametroCompra() {
		return this.resaltarFK_IdModuloParametroCompra;
	}

	public void setResaltarFK_IdModuloParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdModuloParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdModuloParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdPrioridadPedidoParametroCompra=null;

	public Border getResaltarFK_IdPrioridadPedidoParametroCompra() {
		return this.resaltarFK_IdPrioridadPedidoParametroCompra;
	}

	public void setResaltarFK_IdPrioridadPedidoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdPrioridadPedidoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdPrioridadPedidoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPrioridadPedidoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoParametroCompra=null;

	public Border getResaltarFK_IdTipoDocumentoParametroCompra() {
		return this.resaltarFK_IdTipoDocumentoParametroCompra;
	}

	public void setResaltarFK_IdTipoDocumentoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoParametroCompra=null;

	public Border getResaltarFK_IdTipoMovimientoParametroCompra() {
		return this.resaltarFK_IdTipoMovimientoParametroCompra;
	}

	public void setResaltarFK_IdTipoMovimientoParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoParametroCompra= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoModuloParametroCompra=null;

	public Border getResaltarFK_IdTipoMovimientoModuloParametroCompra() {
		return this.resaltarFK_IdTipoMovimientoModuloParametroCompra;
	}

	public void setResaltarFK_IdTipoMovimientoModuloParametroCompra(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoModuloParametroCompra= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoModuloParametroCompra(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroCompraBeanSwingJInternalFrame parametrocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoModuloParametroCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}