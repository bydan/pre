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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.DetalleProveConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleProveParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleProveConstantesFunciones extends DetalleProveConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleProve";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleProve"+DetalleProveConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleProveHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleProveHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleProveConstantesFunciones.SCHEMA+"_"+DetalleProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleProveHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleProveConstantesFunciones.SCHEMA+"_"+DetalleProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleProveConstantesFunciones.SCHEMA+"_"+DetalleProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleProveConstantesFunciones.SCHEMA+"_"+DetalleProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleProveHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleProveConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleProveConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleProveConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleProveConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Proves";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Prove";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Prove";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleProve";
	public static final String OBJECTNAME="detalleprove";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_prove";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleprove from "+DetalleProveConstantesFunciones.SPERSISTENCENAME+" detalleprove";
	public static String QUERYSELECTNATIVE="select "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".version_row,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_empresa,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_sucursal_movimiento,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_periodo,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_modulo,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_moneda,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_cliente,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_factura,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_orden_compra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_estado_detalle_cliente,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_venta,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_pago,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".fecha_vencimiento,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".monto_mone_local,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".monto_mone_extra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".numero_factura,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".debito_mone_local,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".credito_mone_local,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".debito_mone_extra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".credito_mone_extra,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".descripcion,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_anio,"+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME+".id_mes from "+DetalleProveConstantesFunciones.SCHEMA+"."+DetalleProveConstantesFunciones.TABLENAME;//+" as "+DetalleProveConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleProveConstantesFuncionesAdditional detalleproveConstantesFuncionesAdditional=null;
	
	public DetalleProveConstantesFuncionesAdditional getDetalleProveConstantesFuncionesAdditional() {
		return this.detalleproveConstantesFuncionesAdditional;
	}
	
	public void setDetalleProveConstantesFuncionesAdditional(DetalleProveConstantesFuncionesAdditional detalleproveConstantesFuncionesAdditional) {
		try {
			this.detalleproveConstantesFuncionesAdditional=detalleproveConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDSUCURSALMOVIMIENTO= "id_sucursal_movimiento";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDMODULO= "id_modulo";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDFACTURA= "id_factura";
    public static final String IDORDENCOMPRA= "id_orden_compra";
    public static final String IDESTADODETALLECLIENTE= "id_estado_detalle_cliente";
    public static final String FECHAVENTA= "fecha_venta";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAPAGO= "fecha_pago";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String MONTOMONELOCAL= "monto_mone_local";
    public static final String MONTOMONEEXTRA= "monto_mone_extra";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DEBITOMONEEXTRA= "debito_mone_extra";
    public static final String CREDITOMONEEXTRA= "credito_mone_extra";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDSUCURSALMOVIMIENTO= "Sucursal Movimiento";
		public static final String LABEL_IDSUCURSALMOVIMIENTO_LOWER= "Sucursal Movimiento";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDORDENCOMPRA= "Orden Compra";
		public static final String LABEL_IDORDENCOMPRA_LOWER= "Orden Compra";
    	public static final String LABEL_IDESTADODETALLECLIENTE= "Estado Detalle Cliente";
		public static final String LABEL_IDESTADODETALLECLIENTE_LOWER= "Estado Detalle Cliente";
    	public static final String LABEL_FECHAVENTA= "Fecha Venta";
		public static final String LABEL_FECHAVENTA_LOWER= "Fecha Venta";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAPAGO= "Fecha Pago";
		public static final String LABEL_FECHAPAGO_LOWER= "Fecha Pago";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_MONTOMONELOCAL= "Monto Mone Local";
		public static final String LABEL_MONTOMONELOCAL_LOWER= "Monto Mone Local";
    	public static final String LABEL_MONTOMONEEXTRA= "Monto Mone Extra";
		public static final String LABEL_MONTOMONEEXTRA_LOWER= "Monto Mone Extra";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NUMEROFACTURA= "Num Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DEBITOMONEEXTRA= "Debito Mone Extra";
		public static final String LABEL_DEBITOMONEEXTRA_LOWER= "Debito Mone Extra";
    	public static final String LABEL_CREDITOMONEEXTRA= "Credito Mone Extra";
		public static final String LABEL_CREDITOMONEEXTRA_LOWER= "Credito Mone Extra";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getDetalleProveLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDMODULO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDMONEDA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDCLIENTE)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDTRANSACCION)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDFACTURA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDORDENCOMPRA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDORDENCOMPRA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.FECHAVENTA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_FECHAVENTA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.FECHAEMISION)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.FECHAPAGO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_FECHAPAGO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.MONTOMONELOCAL)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_MONTOMONELOCAL;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.MONTOMONEEXTRA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_MONTOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.DEBITOMONEEXTRA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_DEBITOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.CREDITOMONEEXTRA)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_CREDITOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDANIO)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleProveConstantesFunciones.IDMES)) {sLabelColumna=DetalleProveConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleProveDescripcion(DetalleProve detalleprove) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleprove !=null/* && detalleprove.getId()!=0*/) {
			if(detalleprove.getId()!=null) {
				sDescripcion=detalleprove.getId().toString();
			}//detalleprovedetalleprove.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleProveDescripcionDetallado(DetalleProve detalleprove) {
		String sDescripcion="";
			
		sDescripcion+=DetalleProveConstantesFunciones.ID+"=";
		sDescripcion+=detalleprove.getId().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleprove.getVersionRow().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleprove.getid_empresa().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleprove.getid_sucursal().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO+"=";
		sDescripcion+=detalleprove.getid_sucursal_movimiento().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleprove.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleprove.getid_periodo().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDMODULO+"=";
		sDescripcion+=detalleprove.getid_modulo().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=detalleprove.getid_moneda().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=detalleprove.getid_cliente().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=detalleprove.getid_transaccion().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=detalleprove.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detalleprove.getid_asiento_contable().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=detalleprove.getid_factura().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDORDENCOMPRA+"=";
		sDescripcion+=detalleprove.getid_orden_compra().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE+"=";
		sDescripcion+=detalleprove.getid_estado_detalle_cliente().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.FECHAVENTA+"=";
		sDescripcion+=detalleprove.getfecha_venta().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=detalleprove.getfecha_emision().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.FECHAPAGO+"=";
		sDescripcion+=detalleprove.getfecha_pago().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=detalleprove.getfecha_vencimiento().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.MONTOMONELOCAL+"=";
		sDescripcion+=detalleprove.getmonto_mone_local().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.MONTOMONEEXTRA+"=";
		sDescripcion+=detalleprove.getmonto_mone_extra().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detalleprove.getnumero_comprobante()+",";
		sDescripcion+=DetalleProveConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=detalleprove.getnumero_factura()+",";
		sDescripcion+=DetalleProveConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=detalleprove.getdebito_mone_local().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=detalleprove.getcredito_mone_local().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.DEBITOMONEEXTRA+"=";
		sDescripcion+=detalleprove.getdebito_mone_extra().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.CREDITOMONEEXTRA+"=";
		sDescripcion+=detalleprove.getcredito_mone_extra().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleprove.getdescripcion()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalleprove.getid_anio().toString()+",";
		sDescripcion+=DetalleProveConstantesFunciones.IDMES+"=";
		sDescripcion+=detalleprove.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleProveDescripcion(DetalleProve detalleprove,String sValor) throws Exception {			
		if(detalleprove !=null) {
			//detalleprovedetalleprove.getId().toString();
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

	public static String getSucursalMovimientoDescripcion(Sucursal sucursal) {
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getOrdenCompraDescripcion(OrdenCompra ordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ordencompra!=null/*&&ordencompra.getId()>0*/) {
			sDescripcion=OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(ordencompra);
		}

		return sDescripcion;
	}

	public static String getEstadoDetalleClienteDescripcion(EstadoDetalleCliente estadodetallecliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetallecliente!=null/*&&estadodetallecliente.getId()>0*/) {
			sDescripcion=EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(estadodetallecliente);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdDetalleProve")) {
			sNombreIndice="Tipo=  Por Sucursal Movimiento";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetalleCliente")) {
			sNombreIndice="Tipo=  Por Estado Detalle Cliente";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdOrdenCompra")) {
			sNombreIndice="Tipo=  Por Orden Compra";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleProve(Long id_sucursal_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Sucursal Movimiento="+id_sucursal_movimiento.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoDetalleCliente(Long id_estado_detalle_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_cliente!=null) {sDetalleIndice+=" Codigo Unico De Estado Detalle Cliente="+id_estado_detalle_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdOrdenCompra(Long id_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Orden Compra="+id_orden_compra.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleProve(DetalleProve detalleprove,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleprove.setnumero_comprobante(detalleprove.getnumero_comprobante().trim());
		detalleprove.setnumero_factura(detalleprove.getnumero_factura().trim());
		detalleprove.setdescripcion(detalleprove.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleProves(List<DetalleProve> detalleproves,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleProve detalleprove: detalleproves) {
			detalleprove.setnumero_comprobante(detalleprove.getnumero_comprobante().trim());
			detalleprove.setnumero_factura(detalleprove.getnumero_factura().trim());
			detalleprove.setdescripcion(detalleprove.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleProve(DetalleProve detalleprove,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleprove.getConCambioAuxiliar()) {
			detalleprove.setIsDeleted(detalleprove.getIsDeletedAuxiliar());	
			detalleprove.setIsNew(detalleprove.getIsNewAuxiliar());	
			detalleprove.setIsChanged(detalleprove.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleprove.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleprove.setIsDeletedAuxiliar(false);	
			detalleprove.setIsNewAuxiliar(false);	
			detalleprove.setIsChangedAuxiliar(false);
			
			detalleprove.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleProves(List<DetalleProve> detalleproves,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleProve detalleprove : detalleproves) {
			if(conAsignarBase && detalleprove.getConCambioAuxiliar()) {
				detalleprove.setIsDeleted(detalleprove.getIsDeletedAuxiliar());	
				detalleprove.setIsNew(detalleprove.getIsNewAuxiliar());	
				detalleprove.setIsChanged(detalleprove.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleprove.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleprove.setIsDeletedAuxiliar(false);	
				detalleprove.setIsNewAuxiliar(false);	
				detalleprove.setIsChangedAuxiliar(false);
				
				detalleprove.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleProve(DetalleProve detalleprove,Boolean conEnteros) throws Exception  {
		detalleprove.setmonto_mone_local(0.0);
		detalleprove.setmonto_mone_extra(0.0);
		detalleprove.setdebito_mone_local(0.0);
		detalleprove.setcredito_mone_local(0.0);
		detalleprove.setdebito_mone_extra(0.0);
		detalleprove.setcredito_mone_extra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleProves(List<DetalleProve> detalleproves,Boolean conEnteros) throws Exception  {
		
		for(DetalleProve detalleprove: detalleproves) {
			detalleprove.setmonto_mone_local(0.0);
			detalleprove.setmonto_mone_extra(0.0);
			detalleprove.setdebito_mone_local(0.0);
			detalleprove.setcredito_mone_local(0.0);
			detalleprove.setdebito_mone_extra(0.0);
			detalleprove.setcredito_mone_extra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleProve(List<DetalleProve> detalleproves,DetalleProve detalleproveAux) throws Exception  {
		DetalleProveConstantesFunciones.InicializarValoresDetalleProve(detalleproveAux,true);
		
		for(DetalleProve detalleprove: detalleproves) {
			if(detalleprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleproveAux.setmonto_mone_local(detalleproveAux.getmonto_mone_local()+detalleprove.getmonto_mone_local());			
			detalleproveAux.setmonto_mone_extra(detalleproveAux.getmonto_mone_extra()+detalleprove.getmonto_mone_extra());			
			detalleproveAux.setdebito_mone_local(detalleproveAux.getdebito_mone_local()+detalleprove.getdebito_mone_local());			
			detalleproveAux.setcredito_mone_local(detalleproveAux.getcredito_mone_local()+detalleprove.getcredito_mone_local());			
			detalleproveAux.setdebito_mone_extra(detalleproveAux.getdebito_mone_extra()+detalleprove.getdebito_mone_extra());			
			detalleproveAux.setcredito_mone_extra(detalleproveAux.getcredito_mone_extra()+detalleprove.getcredito_mone_extra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleProveConstantesFunciones.getArrayColumnasGlobalesDetalleProve(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleProve(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProveConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProveConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProveConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProveConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProveConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProveConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProveConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProveConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProveConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProveConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleProveConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleProveConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleProve> detalleproves,DetalleProve detalleprove,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleProve detalleproveAux: detalleproves) {
			if(detalleproveAux!=null && detalleprove!=null) {
				if((detalleproveAux.getId()==null && detalleprove.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleproveAux.getId()!=null && detalleprove.getId()!=null){
					if(detalleproveAux.getId().equals(detalleprove.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleProve(List<DetalleProve> detalleproves) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double monto_mone_localTotal=0.0;
		Double monto_mone_extraTotal=0.0;
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double debito_mone_extraTotal=0.0;
		Double credito_mone_extraTotal=0.0;
	
		for(DetalleProve detalleprove: detalleproves) {			
			if(detalleprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			monto_mone_localTotal+=detalleprove.getmonto_mone_local();
			monto_mone_extraTotal+=detalleprove.getmonto_mone_extra();
			debito_mone_localTotal+=detalleprove.getdebito_mone_local();
			credito_mone_localTotal+=detalleprove.getcredito_mone_local();
			debito_mone_extraTotal+=detalleprove.getdebito_mone_extra();
			credito_mone_extraTotal+=detalleprove.getcredito_mone_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProveConstantesFunciones.MONTOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleProveConstantesFunciones.LABEL_MONTOMONELOCAL);
		datoGeneral.setdValorDouble(monto_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProveConstantesFunciones.MONTOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleProveConstantesFunciones.LABEL_MONTOMONEEXTRA);
		datoGeneral.setdValorDouble(monto_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProveConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleProveConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProveConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleProveConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProveConstantesFunciones.DEBITOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		datoGeneral.setdValorDouble(debito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleProveConstantesFunciones.CREDITOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		datoGeneral.setdValorDouble(credito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleProve() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_ID, DetalleProveConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_VERSIONROW, DetalleProveConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDEMPRESA, DetalleProveConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDSUCURSAL, DetalleProveConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO, DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDEJERCICIO, DetalleProveConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDPERIODO, DetalleProveConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDMODULO, DetalleProveConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDMONEDA, DetalleProveConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDCLIENTE, DetalleProveConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDTRANSACCION, DetalleProveConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetalleProveConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDFACTURA, DetalleProveConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDORDENCOMPRA, DetalleProveConstantesFunciones.IDORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE, DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_FECHAVENTA, DetalleProveConstantesFunciones.FECHAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_FECHAEMISION, DetalleProveConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_FECHAPAGO, DetalleProveConstantesFunciones.FECHAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_FECHAVENCIMIENTO, DetalleProveConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_MONTOMONELOCAL, DetalleProveConstantesFunciones.MONTOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_MONTOMONEEXTRA, DetalleProveConstantesFunciones.MONTOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleProveConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_NUMEROFACTURA, DetalleProveConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_DEBITOMONELOCAL, DetalleProveConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_CREDITOMONELOCAL, DetalleProveConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_DEBITOMONEEXTRA, DetalleProveConstantesFunciones.DEBITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_CREDITOMONEEXTRA, DetalleProveConstantesFunciones.CREDITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_DESCRIPCION, DetalleProveConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDANIO, DetalleProveConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleProveConstantesFunciones.LABEL_IDMES, DetalleProveConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleProve() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.FECHAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.FECHAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.MONTOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.MONTOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.DEBITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.CREDITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleProveConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleProve() throws Exception  {
		return DetalleProveConstantesFunciones.getTiposSeleccionarDetalleProve(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleProve(Boolean conFk) throws Exception  {
		return DetalleProveConstantesFunciones.getTiposSeleccionarDetalleProve(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleProve(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDORDENCOMPRA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_FECHAVENTA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_FECHAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_FECHAPAGO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_FECHAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_MONTOMONELOCAL);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_MONTOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_MONTOMONEEXTRA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_MONTOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleProveConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleProveConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleProve(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleProve(DetalleProve detalleproveAux) throws Exception {
		
			detalleproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleproveAux.getEmpresa()));
			detalleproveAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleproveAux.getSucursal()));
			detalleproveAux.setsucursalmovimiento_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleproveAux.getSucursalMovimiento()));
			detalleproveAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleproveAux.getEjercicio()));
			detalleproveAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleproveAux.getPeriodo()));
			detalleproveAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalleproveAux.getModulo()));
			detalleproveAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(detalleproveAux.getMoneda()));
			detalleproveAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalleproveAux.getCliente()));
			detalleproveAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detalleproveAux.getTransaccion()));
			detalleproveAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalleproveAux.getTipoTransaccionModulo()));
			detalleproveAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleproveAux.getAsientoContable()));
			detalleproveAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detalleproveAux.getFactura()));
			detalleproveAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(detalleproveAux.getOrdenCompra()));
			detalleproveAux.setestadodetallecliente_descripcion(EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(detalleproveAux.getEstadoDetalleCliente()));
			detalleproveAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleproveAux.getAnio()));
			detalleproveAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleproveAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleProve(List<DetalleProve> detalleprovesTemp) throws Exception {
		for(DetalleProve detalleproveAux:detalleprovesTemp) {
			
			detalleproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleproveAux.getEmpresa()));
			detalleproveAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleproveAux.getSucursal()));
			detalleproveAux.setsucursalmovimiento_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleproveAux.getSucursalMovimiento()));
			detalleproveAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleproveAux.getEjercicio()));
			detalleproveAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleproveAux.getPeriodo()));
			detalleproveAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalleproveAux.getModulo()));
			detalleproveAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(detalleproveAux.getMoneda()));
			detalleproveAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalleproveAux.getCliente()));
			detalleproveAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detalleproveAux.getTransaccion()));
			detalleproveAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalleproveAux.getTipoTransaccionModulo()));
			detalleproveAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleproveAux.getAsientoContable()));
			detalleproveAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detalleproveAux.getFactura()));
			detalleproveAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(detalleproveAux.getOrdenCompra()));
			detalleproveAux.setestadodetallecliente_descripcion(EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(detalleproveAux.getEstadoDetalleCliente()));
			detalleproveAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleproveAux.getAnio()));
			detalleproveAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleproveAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(OrdenCompra.class));
				classes.add(new Classe(EstadoDetalleCliente.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDetalleCliente.class)) {
						classes.add(new Classe(EstadoDetalleCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(EstadoDetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleCliente.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(EstadoDetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleCliente.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleProveConstantesFunciones.getClassesRelationshipsOfDetalleProve(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PagoAuto.class));
				classes.add(new Classe(AutoriPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PagoAuto.class)) {
						classes.add(new Classe(PagoAuto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPago.class)) {
						classes.add(new Classe(AutoriPago.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleProveConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleProve(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DetalleProve detalleprove,List<DetalleProve> detalleproves,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleProve detalleproveEncontrado=null;
			
			for(DetalleProve detalleproveLocal:detalleproves) {
				if(detalleproveLocal.getId().equals(detalleprove.getId())) {
					detalleproveEncontrado=detalleproveLocal;
					
					detalleproveLocal.setIsChanged(detalleprove.getIsChanged());
					detalleproveLocal.setIsNew(detalleprove.getIsNew());
					detalleproveLocal.setIsDeleted(detalleprove.getIsDeleted());
					
					detalleproveLocal.setGeneralEntityOriginal(detalleprove.getGeneralEntityOriginal());
					
					detalleproveLocal.setId(detalleprove.getId());	
					detalleproveLocal.setVersionRow(detalleprove.getVersionRow());	
					detalleproveLocal.setid_empresa(detalleprove.getid_empresa());	
					detalleproveLocal.setid_sucursal(detalleprove.getid_sucursal());	
					detalleproveLocal.setid_sucursal_movimiento(detalleprove.getid_sucursal_movimiento());	
					detalleproveLocal.setid_ejercicio(detalleprove.getid_ejercicio());	
					detalleproveLocal.setid_periodo(detalleprove.getid_periodo());	
					detalleproveLocal.setid_modulo(detalleprove.getid_modulo());	
					detalleproveLocal.setid_moneda(detalleprove.getid_moneda());	
					detalleproveLocal.setid_cliente(detalleprove.getid_cliente());	
					detalleproveLocal.setid_transaccion(detalleprove.getid_transaccion());	
					detalleproveLocal.setid_tipo_transaccion_modulo(detalleprove.getid_tipo_transaccion_modulo());	
					detalleproveLocal.setid_asiento_contable(detalleprove.getid_asiento_contable());	
					detalleproveLocal.setid_factura(detalleprove.getid_factura());	
					detalleproveLocal.setid_orden_compra(detalleprove.getid_orden_compra());	
					detalleproveLocal.setid_estado_detalle_cliente(detalleprove.getid_estado_detalle_cliente());	
					detalleproveLocal.setfecha_venta(detalleprove.getfecha_venta());	
					detalleproveLocal.setfecha_emision(detalleprove.getfecha_emision());	
					detalleproveLocal.setfecha_pago(detalleprove.getfecha_pago());	
					detalleproveLocal.setfecha_vencimiento(detalleprove.getfecha_vencimiento());	
					detalleproveLocal.setmonto_mone_local(detalleprove.getmonto_mone_local());	
					detalleproveLocal.setmonto_mone_extra(detalleprove.getmonto_mone_extra());	
					detalleproveLocal.setnumero_comprobante(detalleprove.getnumero_comprobante());	
					detalleproveLocal.setnumero_factura(detalleprove.getnumero_factura());	
					detalleproveLocal.setdebito_mone_local(detalleprove.getdebito_mone_local());	
					detalleproveLocal.setcredito_mone_local(detalleprove.getcredito_mone_local());	
					detalleproveLocal.setdebito_mone_extra(detalleprove.getdebito_mone_extra());	
					detalleproveLocal.setcredito_mone_extra(detalleprove.getcredito_mone_extra());	
					detalleproveLocal.setdescripcion(detalleprove.getdescripcion());	
					detalleproveLocal.setid_anio(detalleprove.getid_anio());	
					detalleproveLocal.setid_mes(detalleprove.getid_mes());	
					
					
					detalleproveLocal.setPagoAutos(detalleprove.getPagoAutos());
					detalleproveLocal.setAutoriPagos(detalleprove.getAutoriPagos());
					
					existe=true;
					break;
				}
			}
			
			if(!detalleprove.getIsDeleted()) {
				if(!existe) {
					detalleproves.add(detalleprove);
				}
			} else {
				if(detalleproveEncontrado!=null && permiteQuitar)  {
					detalleproves.remove(detalleproveEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleProve detalleprove,List<DetalleProve> detalleproves) throws Exception {
		try	{			
			for(DetalleProve detalleproveLocal:detalleproves) {
				if(detalleproveLocal.getId().equals(detalleprove.getId())) {
					detalleproveLocal.setIsSelected(detalleprove.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleProve(List<DetalleProve> detalleprovesAux) throws Exception {
		//this.detalleprovesAux=detalleprovesAux;
		
		for(DetalleProve detalleproveAux:detalleprovesAux) {
			if(detalleproveAux.getIsChanged()) {
				detalleproveAux.setIsChanged(false);
			}		
			
			if(detalleproveAux.getIsNew()) {
				detalleproveAux.setIsNew(false);
			}	
			
			if(detalleproveAux.getIsDeleted()) {
				detalleproveAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleProve(DetalleProve detalleproveAux) throws Exception {
		//this.detalleproveAux=detalleproveAux;
		
			if(detalleproveAux.getIsChanged()) {
				detalleproveAux.setIsChanged(false);
			}		
			
			if(detalleproveAux.getIsNew()) {
				detalleproveAux.setIsNew(false);
			}	
			
			if(detalleproveAux.getIsDeleted()) {
				detalleproveAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleProve detalleproveAsignar,DetalleProve detalleprove) throws Exception {
		detalleproveAsignar.setId(detalleprove.getId());	
		detalleproveAsignar.setVersionRow(detalleprove.getVersionRow());	
		detalleproveAsignar.setid_empresa(detalleprove.getid_empresa());
		detalleproveAsignar.setempresa_descripcion(detalleprove.getempresa_descripcion());	
		detalleproveAsignar.setid_sucursal(detalleprove.getid_sucursal());
		detalleproveAsignar.setsucursal_descripcion(detalleprove.getsucursal_descripcion());	
		detalleproveAsignar.setid_sucursal_movimiento(detalleprove.getid_sucursal_movimiento());
		detalleproveAsignar.setsucursalmovimiento_descripcion(detalleprove.getsucursalmovimiento_descripcion());	
		detalleproveAsignar.setid_ejercicio(detalleprove.getid_ejercicio());
		detalleproveAsignar.setejercicio_descripcion(detalleprove.getejercicio_descripcion());	
		detalleproveAsignar.setid_periodo(detalleprove.getid_periodo());
		detalleproveAsignar.setperiodo_descripcion(detalleprove.getperiodo_descripcion());	
		detalleproveAsignar.setid_modulo(detalleprove.getid_modulo());
		detalleproveAsignar.setmodulo_descripcion(detalleprove.getmodulo_descripcion());	
		detalleproveAsignar.setid_moneda(detalleprove.getid_moneda());
		detalleproveAsignar.setmoneda_descripcion(detalleprove.getmoneda_descripcion());	
		detalleproveAsignar.setid_cliente(detalleprove.getid_cliente());
		detalleproveAsignar.setcliente_descripcion(detalleprove.getcliente_descripcion());	
		detalleproveAsignar.setid_transaccion(detalleprove.getid_transaccion());
		detalleproveAsignar.settransaccion_descripcion(detalleprove.gettransaccion_descripcion());	
		detalleproveAsignar.setid_tipo_transaccion_modulo(detalleprove.getid_tipo_transaccion_modulo());
		detalleproveAsignar.settipotransaccionmodulo_descripcion(detalleprove.gettipotransaccionmodulo_descripcion());	
		detalleproveAsignar.setid_asiento_contable(detalleprove.getid_asiento_contable());
		detalleproveAsignar.setasientocontable_descripcion(detalleprove.getasientocontable_descripcion());	
		detalleproveAsignar.setid_factura(detalleprove.getid_factura());
		detalleproveAsignar.setfactura_descripcion(detalleprove.getfactura_descripcion());	
		detalleproveAsignar.setid_orden_compra(detalleprove.getid_orden_compra());
		detalleproveAsignar.setordencompra_descripcion(detalleprove.getordencompra_descripcion());	
		detalleproveAsignar.setid_estado_detalle_cliente(detalleprove.getid_estado_detalle_cliente());
		detalleproveAsignar.setestadodetallecliente_descripcion(detalleprove.getestadodetallecliente_descripcion());	
		detalleproveAsignar.setfecha_venta(detalleprove.getfecha_venta());	
		detalleproveAsignar.setfecha_emision(detalleprove.getfecha_emision());	
		detalleproveAsignar.setfecha_pago(detalleprove.getfecha_pago());	
		detalleproveAsignar.setfecha_vencimiento(detalleprove.getfecha_vencimiento());	
		detalleproveAsignar.setmonto_mone_local(detalleprove.getmonto_mone_local());	
		detalleproveAsignar.setmonto_mone_extra(detalleprove.getmonto_mone_extra());	
		detalleproveAsignar.setnumero_comprobante(detalleprove.getnumero_comprobante());	
		detalleproveAsignar.setnumero_factura(detalleprove.getnumero_factura());	
		detalleproveAsignar.setdebito_mone_local(detalleprove.getdebito_mone_local());	
		detalleproveAsignar.setcredito_mone_local(detalleprove.getcredito_mone_local());	
		detalleproveAsignar.setdebito_mone_extra(detalleprove.getdebito_mone_extra());	
		detalleproveAsignar.setcredito_mone_extra(detalleprove.getcredito_mone_extra());	
		detalleproveAsignar.setdescripcion(detalleprove.getdescripcion());	
		detalleproveAsignar.setid_anio(detalleprove.getid_anio());
		detalleproveAsignar.setanio_descripcion(detalleprove.getanio_descripcion());	
		detalleproveAsignar.setid_mes(detalleprove.getid_mes());
		detalleproveAsignar.setmes_descripcion(detalleprove.getmes_descripcion());	
	}
	
	public static void inicializarDetalleProve(DetalleProve detalleprove) throws Exception {
		try {
				detalleprove.setId(0L);	
					
				detalleprove.setid_empresa(-1L);	
				detalleprove.setid_sucursal(-1L);	
				detalleprove.setid_sucursal_movimiento(-1L);	
				detalleprove.setid_ejercicio(-1L);	
				detalleprove.setid_periodo(-1L);	
				detalleprove.setid_modulo(-1L);	
				detalleprove.setid_moneda(-1L);	
				detalleprove.setid_cliente(-1L);	
				detalleprove.setid_transaccion(-1L);	
				detalleprove.setid_tipo_transaccion_modulo(null);	
				detalleprove.setid_asiento_contable(-1L);	
				detalleprove.setid_factura(-1L);	
				detalleprove.setid_orden_compra(null);	
				detalleprove.setid_estado_detalle_cliente(-1L);	
				detalleprove.setfecha_venta(new Date());	
				detalleprove.setfecha_emision(new Date());	
				detalleprove.setfecha_pago(new Date());	
				detalleprove.setfecha_vencimiento(new Date());	
				detalleprove.setmonto_mone_local(0.0);	
				detalleprove.setmonto_mone_extra(0.0);	
				detalleprove.setnumero_comprobante("");	
				detalleprove.setnumero_factura("");	
				detalleprove.setdebito_mone_local(0.0);	
				detalleprove.setcredito_mone_local(0.0);	
				detalleprove.setdebito_mone_extra(0.0);	
				detalleprove.setcredito_mone_extra(0.0);	
				detalleprove.setdescripcion("");	
				detalleprove.setid_anio(null);	
				detalleprove.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleProve(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_FECHAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_FECHAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_MONTOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_MONTOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleProveConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleProve(String sTipo,Row row,Workbook workbook,DetalleProve detalleprove,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getsucursalmovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getestadodetallecliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getfecha_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getfecha_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getmonto_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getmonto_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getdebito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getcredito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleprove.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleProve=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleProve() {
		return this.sFinalQueryDetalleProve;
	}
	
	public void setsFinalQueryDetalleProve(String sFinalQueryDetalleProve) {
		this.sFinalQueryDetalleProve= sFinalQueryDetalleProve;
	}
	
	public Border resaltarSeleccionarDetalleProve=null;
	
	public Border setResaltarSeleccionarDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleProve= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleProve() {
		return this.resaltarSeleccionarDetalleProve;
	}
	
	public void setResaltarSeleccionarDetalleProve(Border borderResaltarSeleccionarDetalleProve) {
		this.resaltarSeleccionarDetalleProve= borderResaltarSeleccionarDetalleProve;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleProve=null;
	public Boolean mostraridDetalleProve=true;
	public Boolean activaridDetalleProve=true;

	public Border resaltarid_empresaDetalleProve=null;
	public Boolean mostrarid_empresaDetalleProve=true;
	public Boolean activarid_empresaDetalleProve=true;
	public Boolean cargarid_empresaDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleProve=null;
	public Boolean mostrarid_sucursalDetalleProve=true;
	public Boolean activarid_sucursalDetalleProve=true;
	public Boolean cargarid_sucursalDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_sucursal_movimientoDetalleProve=null;
	public Boolean mostrarid_sucursal_movimientoDetalleProve=true;
	public Boolean activarid_sucursal_movimientoDetalleProve=true;
	public Boolean cargarid_sucursal_movimientoDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursal_movimientoDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleProve=null;
	public Boolean mostrarid_ejercicioDetalleProve=true;
	public Boolean activarid_ejercicioDetalleProve=true;
	public Boolean cargarid_ejercicioDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleProve=null;
	public Boolean mostrarid_periodoDetalleProve=true;
	public Boolean activarid_periodoDetalleProve=true;
	public Boolean cargarid_periodoDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_moduloDetalleProve=null;
	public Boolean mostrarid_moduloDetalleProve=true;
	public Boolean activarid_moduloDetalleProve=true;
	public Boolean cargarid_moduloDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_monedaDetalleProve=null;
	public Boolean mostrarid_monedaDetalleProve=true;
	public Boolean activarid_monedaDetalleProve=true;
	public Boolean cargarid_monedaDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_clienteDetalleProve=null;
	public Boolean mostrarid_clienteDetalleProve=true;
	public Boolean activarid_clienteDetalleProve=true;
	public Boolean cargarid_clienteDetalleProve=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_transaccionDetalleProve=null;
	public Boolean mostrarid_transaccionDetalleProve=true;
	public Boolean activarid_transaccionDetalleProve=true;
	public Boolean cargarid_transaccionDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloDetalleProve=null;
	public Boolean mostrarid_tipo_transaccion_moduloDetalleProve=true;
	public Boolean activarid_tipo_transaccion_moduloDetalleProve=false;
	public Boolean cargarid_tipo_transaccion_moduloDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDetalleProve=null;
	public Boolean mostrarid_asiento_contableDetalleProve=true;
	public Boolean activarid_asiento_contableDetalleProve=true;
	public Boolean cargarid_asiento_contableDetalleProve=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_facturaDetalleProve=null;
	public Boolean mostrarid_facturaDetalleProve=true;
	public Boolean activarid_facturaDetalleProve=true;
	public Boolean cargarid_facturaDetalleProve=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_orden_compraDetalleProve=null;
	public Boolean mostrarid_orden_compraDetalleProve=true;
	public Boolean activarid_orden_compraDetalleProve=true;
	public Boolean cargarid_orden_compraDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_compraDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_estado_detalle_clienteDetalleProve=null;
	public Boolean mostrarid_estado_detalle_clienteDetalleProve=true;
	public Boolean activarid_estado_detalle_clienteDetalleProve=true;
	public Boolean cargarid_estado_detalle_clienteDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_clienteDetalleProve=false;//ConEventDepend=true

	public Border resaltarfecha_ventaDetalleProve=null;
	public Boolean mostrarfecha_ventaDetalleProve=true;
	public Boolean activarfecha_ventaDetalleProve=false;

	public Border resaltarfecha_emisionDetalleProve=null;
	public Boolean mostrarfecha_emisionDetalleProve=true;
	public Boolean activarfecha_emisionDetalleProve=false;

	public Border resaltarfecha_pagoDetalleProve=null;
	public Boolean mostrarfecha_pagoDetalleProve=true;
	public Boolean activarfecha_pagoDetalleProve=false;

	public Border resaltarfecha_vencimientoDetalleProve=null;
	public Boolean mostrarfecha_vencimientoDetalleProve=true;
	public Boolean activarfecha_vencimientoDetalleProve=false;

	public Border resaltarmonto_mone_localDetalleProve=null;
	public Boolean mostrarmonto_mone_localDetalleProve=true;
	public Boolean activarmonto_mone_localDetalleProve=true;

	public Border resaltarmonto_mone_extraDetalleProve=null;
	public Boolean mostrarmonto_mone_extraDetalleProve=true;
	public Boolean activarmonto_mone_extraDetalleProve=true;

	public Border resaltarnumero_comprobanteDetalleProve=null;
	public Boolean mostrarnumero_comprobanteDetalleProve=true;
	public Boolean activarnumero_comprobanteDetalleProve=true;

	public Border resaltarnumero_facturaDetalleProve=null;
	public Boolean mostrarnumero_facturaDetalleProve=true;
	public Boolean activarnumero_facturaDetalleProve=true;

	public Border resaltardebito_mone_localDetalleProve=null;
	public Boolean mostrardebito_mone_localDetalleProve=true;
	public Boolean activardebito_mone_localDetalleProve=true;

	public Border resaltarcredito_mone_localDetalleProve=null;
	public Boolean mostrarcredito_mone_localDetalleProve=true;
	public Boolean activarcredito_mone_localDetalleProve=true;

	public Border resaltardebito_mone_extraDetalleProve=null;
	public Boolean mostrardebito_mone_extraDetalleProve=true;
	public Boolean activardebito_mone_extraDetalleProve=true;

	public Border resaltarcredito_mone_extraDetalleProve=null;
	public Boolean mostrarcredito_mone_extraDetalleProve=true;
	public Boolean activarcredito_mone_extraDetalleProve=true;

	public Border resaltardescripcionDetalleProve=null;
	public Boolean mostrardescripcionDetalleProve=true;
	public Boolean activardescripcionDetalleProve=true;

	public Border resaltarid_anioDetalleProve=null;
	public Boolean mostrarid_anioDetalleProve=true;
	public Boolean activarid_anioDetalleProve=false;
	public Boolean cargarid_anioDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleProve=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleProve=null;
	public Boolean mostrarid_mesDetalleProve=true;
	public Boolean activarid_mesDetalleProve=false;
	public Boolean cargarid_mesDetalleProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleProve=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltaridDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleProve() {
		return this.resaltaridDetalleProve;
	}

	public void setResaltaridDetalleProve(Border borderResaltar) {
		this.resaltaridDetalleProve= borderResaltar;
	}

	public Boolean getMostraridDetalleProve() {
		return this.mostraridDetalleProve;
	}

	public void setMostraridDetalleProve(Boolean mostraridDetalleProve) {
		this.mostraridDetalleProve= mostraridDetalleProve;
	}

	public Boolean getActivaridDetalleProve() {
		return this.activaridDetalleProve;
	}

	public void setActivaridDetalleProve(Boolean activaridDetalleProve) {
		this.activaridDetalleProve= activaridDetalleProve;
	}

	public Border setResaltarid_empresaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleProve() {
		return this.resaltarid_empresaDetalleProve;
	}

	public void setResaltarid_empresaDetalleProve(Border borderResaltar) {
		this.resaltarid_empresaDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleProve() {
		return this.mostrarid_empresaDetalleProve;
	}

	public void setMostrarid_empresaDetalleProve(Boolean mostrarid_empresaDetalleProve) {
		this.mostrarid_empresaDetalleProve= mostrarid_empresaDetalleProve;
	}

	public Boolean getActivarid_empresaDetalleProve() {
		return this.activarid_empresaDetalleProve;
	}

	public void setActivarid_empresaDetalleProve(Boolean activarid_empresaDetalleProve) {
		this.activarid_empresaDetalleProve= activarid_empresaDetalleProve;
	}

	public Boolean getCargarid_empresaDetalleProve() {
		return this.cargarid_empresaDetalleProve;
	}

	public void setCargarid_empresaDetalleProve(Boolean cargarid_empresaDetalleProve) {
		this.cargarid_empresaDetalleProve= cargarid_empresaDetalleProve;
	}

	public Border setResaltarid_sucursalDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleProve() {
		return this.resaltarid_sucursalDetalleProve;
	}

	public void setResaltarid_sucursalDetalleProve(Border borderResaltar) {
		this.resaltarid_sucursalDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleProve() {
		return this.mostrarid_sucursalDetalleProve;
	}

	public void setMostrarid_sucursalDetalleProve(Boolean mostrarid_sucursalDetalleProve) {
		this.mostrarid_sucursalDetalleProve= mostrarid_sucursalDetalleProve;
	}

	public Boolean getActivarid_sucursalDetalleProve() {
		return this.activarid_sucursalDetalleProve;
	}

	public void setActivarid_sucursalDetalleProve(Boolean activarid_sucursalDetalleProve) {
		this.activarid_sucursalDetalleProve= activarid_sucursalDetalleProve;
	}

	public Boolean getCargarid_sucursalDetalleProve() {
		return this.cargarid_sucursalDetalleProve;
	}

	public void setCargarid_sucursalDetalleProve(Boolean cargarid_sucursalDetalleProve) {
		this.cargarid_sucursalDetalleProve= cargarid_sucursalDetalleProve;
	}

	public Border setResaltarid_sucursal_movimientoDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_sucursal_movimientoDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursal_movimientoDetalleProve() {
		return this.resaltarid_sucursal_movimientoDetalleProve;
	}

	public void setResaltarid_sucursal_movimientoDetalleProve(Border borderResaltar) {
		this.resaltarid_sucursal_movimientoDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_sucursal_movimientoDetalleProve() {
		return this.mostrarid_sucursal_movimientoDetalleProve;
	}

	public void setMostrarid_sucursal_movimientoDetalleProve(Boolean mostrarid_sucursal_movimientoDetalleProve) {
		this.mostrarid_sucursal_movimientoDetalleProve= mostrarid_sucursal_movimientoDetalleProve;
	}

	public Boolean getActivarid_sucursal_movimientoDetalleProve() {
		return this.activarid_sucursal_movimientoDetalleProve;
	}

	public void setActivarid_sucursal_movimientoDetalleProve(Boolean activarid_sucursal_movimientoDetalleProve) {
		this.activarid_sucursal_movimientoDetalleProve= activarid_sucursal_movimientoDetalleProve;
	}

	public Boolean getCargarid_sucursal_movimientoDetalleProve() {
		return this.cargarid_sucursal_movimientoDetalleProve;
	}

	public void setCargarid_sucursal_movimientoDetalleProve(Boolean cargarid_sucursal_movimientoDetalleProve) {
		this.cargarid_sucursal_movimientoDetalleProve= cargarid_sucursal_movimientoDetalleProve;
	}

	public Border setResaltarid_ejercicioDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleProve() {
		return this.resaltarid_ejercicioDetalleProve;
	}

	public void setResaltarid_ejercicioDetalleProve(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleProve() {
		return this.mostrarid_ejercicioDetalleProve;
	}

	public void setMostrarid_ejercicioDetalleProve(Boolean mostrarid_ejercicioDetalleProve) {
		this.mostrarid_ejercicioDetalleProve= mostrarid_ejercicioDetalleProve;
	}

	public Boolean getActivarid_ejercicioDetalleProve() {
		return this.activarid_ejercicioDetalleProve;
	}

	public void setActivarid_ejercicioDetalleProve(Boolean activarid_ejercicioDetalleProve) {
		this.activarid_ejercicioDetalleProve= activarid_ejercicioDetalleProve;
	}

	public Boolean getCargarid_ejercicioDetalleProve() {
		return this.cargarid_ejercicioDetalleProve;
	}

	public void setCargarid_ejercicioDetalleProve(Boolean cargarid_ejercicioDetalleProve) {
		this.cargarid_ejercicioDetalleProve= cargarid_ejercicioDetalleProve;
	}

	public Border setResaltarid_periodoDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleProve() {
		return this.resaltarid_periodoDetalleProve;
	}

	public void setResaltarid_periodoDetalleProve(Border borderResaltar) {
		this.resaltarid_periodoDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleProve() {
		return this.mostrarid_periodoDetalleProve;
	}

	public void setMostrarid_periodoDetalleProve(Boolean mostrarid_periodoDetalleProve) {
		this.mostrarid_periodoDetalleProve= mostrarid_periodoDetalleProve;
	}

	public Boolean getActivarid_periodoDetalleProve() {
		return this.activarid_periodoDetalleProve;
	}

	public void setActivarid_periodoDetalleProve(Boolean activarid_periodoDetalleProve) {
		this.activarid_periodoDetalleProve= activarid_periodoDetalleProve;
	}

	public Boolean getCargarid_periodoDetalleProve() {
		return this.cargarid_periodoDetalleProve;
	}

	public void setCargarid_periodoDetalleProve(Boolean cargarid_periodoDetalleProve) {
		this.cargarid_periodoDetalleProve= cargarid_periodoDetalleProve;
	}

	public Border setResaltarid_moduloDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_moduloDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDetalleProve() {
		return this.resaltarid_moduloDetalleProve;
	}

	public void setResaltarid_moduloDetalleProve(Border borderResaltar) {
		this.resaltarid_moduloDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_moduloDetalleProve() {
		return this.mostrarid_moduloDetalleProve;
	}

	public void setMostrarid_moduloDetalleProve(Boolean mostrarid_moduloDetalleProve) {
		this.mostrarid_moduloDetalleProve= mostrarid_moduloDetalleProve;
	}

	public Boolean getActivarid_moduloDetalleProve() {
		return this.activarid_moduloDetalleProve;
	}

	public void setActivarid_moduloDetalleProve(Boolean activarid_moduloDetalleProve) {
		this.activarid_moduloDetalleProve= activarid_moduloDetalleProve;
	}

	public Boolean getCargarid_moduloDetalleProve() {
		return this.cargarid_moduloDetalleProve;
	}

	public void setCargarid_moduloDetalleProve(Boolean cargarid_moduloDetalleProve) {
		this.cargarid_moduloDetalleProve= cargarid_moduloDetalleProve;
	}

	public Border setResaltarid_monedaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_monedaDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaDetalleProve() {
		return this.resaltarid_monedaDetalleProve;
	}

	public void setResaltarid_monedaDetalleProve(Border borderResaltar) {
		this.resaltarid_monedaDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_monedaDetalleProve() {
		return this.mostrarid_monedaDetalleProve;
	}

	public void setMostrarid_monedaDetalleProve(Boolean mostrarid_monedaDetalleProve) {
		this.mostrarid_monedaDetalleProve= mostrarid_monedaDetalleProve;
	}

	public Boolean getActivarid_monedaDetalleProve() {
		return this.activarid_monedaDetalleProve;
	}

	public void setActivarid_monedaDetalleProve(Boolean activarid_monedaDetalleProve) {
		this.activarid_monedaDetalleProve= activarid_monedaDetalleProve;
	}

	public Boolean getCargarid_monedaDetalleProve() {
		return this.cargarid_monedaDetalleProve;
	}

	public void setCargarid_monedaDetalleProve(Boolean cargarid_monedaDetalleProve) {
		this.cargarid_monedaDetalleProve= cargarid_monedaDetalleProve;
	}

	public Border setResaltarid_clienteDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_clienteDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteDetalleProve() {
		return this.resaltarid_clienteDetalleProve;
	}

	public void setResaltarid_clienteDetalleProve(Border borderResaltar) {
		this.resaltarid_clienteDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_clienteDetalleProve() {
		return this.mostrarid_clienteDetalleProve;
	}

	public void setMostrarid_clienteDetalleProve(Boolean mostrarid_clienteDetalleProve) {
		this.mostrarid_clienteDetalleProve= mostrarid_clienteDetalleProve;
	}

	public Boolean getActivarid_clienteDetalleProve() {
		return this.activarid_clienteDetalleProve;
	}

	public void setActivarid_clienteDetalleProve(Boolean activarid_clienteDetalleProve) {
		this.activarid_clienteDetalleProve= activarid_clienteDetalleProve;
	}

	public Boolean getCargarid_clienteDetalleProve() {
		return this.cargarid_clienteDetalleProve;
	}

	public void setCargarid_clienteDetalleProve(Boolean cargarid_clienteDetalleProve) {
		this.cargarid_clienteDetalleProve= cargarid_clienteDetalleProve;
	}

	public Border setResaltarid_transaccionDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_transaccionDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionDetalleProve() {
		return this.resaltarid_transaccionDetalleProve;
	}

	public void setResaltarid_transaccionDetalleProve(Border borderResaltar) {
		this.resaltarid_transaccionDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_transaccionDetalleProve() {
		return this.mostrarid_transaccionDetalleProve;
	}

	public void setMostrarid_transaccionDetalleProve(Boolean mostrarid_transaccionDetalleProve) {
		this.mostrarid_transaccionDetalleProve= mostrarid_transaccionDetalleProve;
	}

	public Boolean getActivarid_transaccionDetalleProve() {
		return this.activarid_transaccionDetalleProve;
	}

	public void setActivarid_transaccionDetalleProve(Boolean activarid_transaccionDetalleProve) {
		this.activarid_transaccionDetalleProve= activarid_transaccionDetalleProve;
	}

	public Boolean getCargarid_transaccionDetalleProve() {
		return this.cargarid_transaccionDetalleProve;
	}

	public void setCargarid_transaccionDetalleProve(Boolean cargarid_transaccionDetalleProve) {
		this.cargarid_transaccionDetalleProve= cargarid_transaccionDetalleProve;
	}

	public Border setResaltarid_tipo_transaccion_moduloDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloDetalleProve() {
		return this.resaltarid_tipo_transaccion_moduloDetalleProve;
	}

	public void setResaltarid_tipo_transaccion_moduloDetalleProve(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloDetalleProve() {
		return this.mostrarid_tipo_transaccion_moduloDetalleProve;
	}

	public void setMostrarid_tipo_transaccion_moduloDetalleProve(Boolean mostrarid_tipo_transaccion_moduloDetalleProve) {
		this.mostrarid_tipo_transaccion_moduloDetalleProve= mostrarid_tipo_transaccion_moduloDetalleProve;
	}

	public Boolean getActivarid_tipo_transaccion_moduloDetalleProve() {
		return this.activarid_tipo_transaccion_moduloDetalleProve;
	}

	public void setActivarid_tipo_transaccion_moduloDetalleProve(Boolean activarid_tipo_transaccion_moduloDetalleProve) {
		this.activarid_tipo_transaccion_moduloDetalleProve= activarid_tipo_transaccion_moduloDetalleProve;
	}

	public Boolean getCargarid_tipo_transaccion_moduloDetalleProve() {
		return this.cargarid_tipo_transaccion_moduloDetalleProve;
	}

	public void setCargarid_tipo_transaccion_moduloDetalleProve(Boolean cargarid_tipo_transaccion_moduloDetalleProve) {
		this.cargarid_tipo_transaccion_moduloDetalleProve= cargarid_tipo_transaccion_moduloDetalleProve;
	}

	public Border setResaltarid_asiento_contableDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetalleProve() {
		return this.resaltarid_asiento_contableDetalleProve;
	}

	public void setResaltarid_asiento_contableDetalleProve(Border borderResaltar) {
		this.resaltarid_asiento_contableDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetalleProve() {
		return this.mostrarid_asiento_contableDetalleProve;
	}

	public void setMostrarid_asiento_contableDetalleProve(Boolean mostrarid_asiento_contableDetalleProve) {
		this.mostrarid_asiento_contableDetalleProve= mostrarid_asiento_contableDetalleProve;
	}

	public Boolean getActivarid_asiento_contableDetalleProve() {
		return this.activarid_asiento_contableDetalleProve;
	}

	public void setActivarid_asiento_contableDetalleProve(Boolean activarid_asiento_contableDetalleProve) {
		this.activarid_asiento_contableDetalleProve= activarid_asiento_contableDetalleProve;
	}

	public Boolean getCargarid_asiento_contableDetalleProve() {
		return this.cargarid_asiento_contableDetalleProve;
	}

	public void setCargarid_asiento_contableDetalleProve(Boolean cargarid_asiento_contableDetalleProve) {
		this.cargarid_asiento_contableDetalleProve= cargarid_asiento_contableDetalleProve;
	}

	public Border setResaltarid_facturaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_facturaDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaDetalleProve() {
		return this.resaltarid_facturaDetalleProve;
	}

	public void setResaltarid_facturaDetalleProve(Border borderResaltar) {
		this.resaltarid_facturaDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_facturaDetalleProve() {
		return this.mostrarid_facturaDetalleProve;
	}

	public void setMostrarid_facturaDetalleProve(Boolean mostrarid_facturaDetalleProve) {
		this.mostrarid_facturaDetalleProve= mostrarid_facturaDetalleProve;
	}

	public Boolean getActivarid_facturaDetalleProve() {
		return this.activarid_facturaDetalleProve;
	}

	public void setActivarid_facturaDetalleProve(Boolean activarid_facturaDetalleProve) {
		this.activarid_facturaDetalleProve= activarid_facturaDetalleProve;
	}

	public Boolean getCargarid_facturaDetalleProve() {
		return this.cargarid_facturaDetalleProve;
	}

	public void setCargarid_facturaDetalleProve(Boolean cargarid_facturaDetalleProve) {
		this.cargarid_facturaDetalleProve= cargarid_facturaDetalleProve;
	}

	public Border setResaltarid_orden_compraDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_orden_compraDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_compraDetalleProve() {
		return this.resaltarid_orden_compraDetalleProve;
	}

	public void setResaltarid_orden_compraDetalleProve(Border borderResaltar) {
		this.resaltarid_orden_compraDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_orden_compraDetalleProve() {
		return this.mostrarid_orden_compraDetalleProve;
	}

	public void setMostrarid_orden_compraDetalleProve(Boolean mostrarid_orden_compraDetalleProve) {
		this.mostrarid_orden_compraDetalleProve= mostrarid_orden_compraDetalleProve;
	}

	public Boolean getActivarid_orden_compraDetalleProve() {
		return this.activarid_orden_compraDetalleProve;
	}

	public void setActivarid_orden_compraDetalleProve(Boolean activarid_orden_compraDetalleProve) {
		this.activarid_orden_compraDetalleProve= activarid_orden_compraDetalleProve;
	}

	public Boolean getCargarid_orden_compraDetalleProve() {
		return this.cargarid_orden_compraDetalleProve;
	}

	public void setCargarid_orden_compraDetalleProve(Boolean cargarid_orden_compraDetalleProve) {
		this.cargarid_orden_compraDetalleProve= cargarid_orden_compraDetalleProve;
	}

	public Border setResaltarid_estado_detalle_clienteDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_estado_detalle_clienteDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_clienteDetalleProve() {
		return this.resaltarid_estado_detalle_clienteDetalleProve;
	}

	public void setResaltarid_estado_detalle_clienteDetalleProve(Border borderResaltar) {
		this.resaltarid_estado_detalle_clienteDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_clienteDetalleProve() {
		return this.mostrarid_estado_detalle_clienteDetalleProve;
	}

	public void setMostrarid_estado_detalle_clienteDetalleProve(Boolean mostrarid_estado_detalle_clienteDetalleProve) {
		this.mostrarid_estado_detalle_clienteDetalleProve= mostrarid_estado_detalle_clienteDetalleProve;
	}

	public Boolean getActivarid_estado_detalle_clienteDetalleProve() {
		return this.activarid_estado_detalle_clienteDetalleProve;
	}

	public void setActivarid_estado_detalle_clienteDetalleProve(Boolean activarid_estado_detalle_clienteDetalleProve) {
		this.activarid_estado_detalle_clienteDetalleProve= activarid_estado_detalle_clienteDetalleProve;
	}

	public Boolean getCargarid_estado_detalle_clienteDetalleProve() {
		return this.cargarid_estado_detalle_clienteDetalleProve;
	}

	public void setCargarid_estado_detalle_clienteDetalleProve(Boolean cargarid_estado_detalle_clienteDetalleProve) {
		this.cargarid_estado_detalle_clienteDetalleProve= cargarid_estado_detalle_clienteDetalleProve;
	}

	public Border setResaltarfecha_ventaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarfecha_ventaDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ventaDetalleProve() {
		return this.resaltarfecha_ventaDetalleProve;
	}

	public void setResaltarfecha_ventaDetalleProve(Border borderResaltar) {
		this.resaltarfecha_ventaDetalleProve= borderResaltar;
	}

	public Boolean getMostrarfecha_ventaDetalleProve() {
		return this.mostrarfecha_ventaDetalleProve;
	}

	public void setMostrarfecha_ventaDetalleProve(Boolean mostrarfecha_ventaDetalleProve) {
		this.mostrarfecha_ventaDetalleProve= mostrarfecha_ventaDetalleProve;
	}

	public Boolean getActivarfecha_ventaDetalleProve() {
		return this.activarfecha_ventaDetalleProve;
	}

	public void setActivarfecha_ventaDetalleProve(Boolean activarfecha_ventaDetalleProve) {
		this.activarfecha_ventaDetalleProve= activarfecha_ventaDetalleProve;
	}

	public Border setResaltarfecha_emisionDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionDetalleProve() {
		return this.resaltarfecha_emisionDetalleProve;
	}

	public void setResaltarfecha_emisionDetalleProve(Border borderResaltar) {
		this.resaltarfecha_emisionDetalleProve= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionDetalleProve() {
		return this.mostrarfecha_emisionDetalleProve;
	}

	public void setMostrarfecha_emisionDetalleProve(Boolean mostrarfecha_emisionDetalleProve) {
		this.mostrarfecha_emisionDetalleProve= mostrarfecha_emisionDetalleProve;
	}

	public Boolean getActivarfecha_emisionDetalleProve() {
		return this.activarfecha_emisionDetalleProve;
	}

	public void setActivarfecha_emisionDetalleProve(Boolean activarfecha_emisionDetalleProve) {
		this.activarfecha_emisionDetalleProve= activarfecha_emisionDetalleProve;
	}

	public Border setResaltarfecha_pagoDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarfecha_pagoDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pagoDetalleProve() {
		return this.resaltarfecha_pagoDetalleProve;
	}

	public void setResaltarfecha_pagoDetalleProve(Border borderResaltar) {
		this.resaltarfecha_pagoDetalleProve= borderResaltar;
	}

	public Boolean getMostrarfecha_pagoDetalleProve() {
		return this.mostrarfecha_pagoDetalleProve;
	}

	public void setMostrarfecha_pagoDetalleProve(Boolean mostrarfecha_pagoDetalleProve) {
		this.mostrarfecha_pagoDetalleProve= mostrarfecha_pagoDetalleProve;
	}

	public Boolean getActivarfecha_pagoDetalleProve() {
		return this.activarfecha_pagoDetalleProve;
	}

	public void setActivarfecha_pagoDetalleProve(Boolean activarfecha_pagoDetalleProve) {
		this.activarfecha_pagoDetalleProve= activarfecha_pagoDetalleProve;
	}

	public Border setResaltarfecha_vencimientoDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoDetalleProve() {
		return this.resaltarfecha_vencimientoDetalleProve;
	}

	public void setResaltarfecha_vencimientoDetalleProve(Border borderResaltar) {
		this.resaltarfecha_vencimientoDetalleProve= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoDetalleProve() {
		return this.mostrarfecha_vencimientoDetalleProve;
	}

	public void setMostrarfecha_vencimientoDetalleProve(Boolean mostrarfecha_vencimientoDetalleProve) {
		this.mostrarfecha_vencimientoDetalleProve= mostrarfecha_vencimientoDetalleProve;
	}

	public Boolean getActivarfecha_vencimientoDetalleProve() {
		return this.activarfecha_vencimientoDetalleProve;
	}

	public void setActivarfecha_vencimientoDetalleProve(Boolean activarfecha_vencimientoDetalleProve) {
		this.activarfecha_vencimientoDetalleProve= activarfecha_vencimientoDetalleProve;
	}

	public Border setResaltarmonto_mone_localDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarmonto_mone_localDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_localDetalleProve() {
		return this.resaltarmonto_mone_localDetalleProve;
	}

	public void setResaltarmonto_mone_localDetalleProve(Border borderResaltar) {
		this.resaltarmonto_mone_localDetalleProve= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_localDetalleProve() {
		return this.mostrarmonto_mone_localDetalleProve;
	}

	public void setMostrarmonto_mone_localDetalleProve(Boolean mostrarmonto_mone_localDetalleProve) {
		this.mostrarmonto_mone_localDetalleProve= mostrarmonto_mone_localDetalleProve;
	}

	public Boolean getActivarmonto_mone_localDetalleProve() {
		return this.activarmonto_mone_localDetalleProve;
	}

	public void setActivarmonto_mone_localDetalleProve(Boolean activarmonto_mone_localDetalleProve) {
		this.activarmonto_mone_localDetalleProve= activarmonto_mone_localDetalleProve;
	}

	public Border setResaltarmonto_mone_extraDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarmonto_mone_extraDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_extraDetalleProve() {
		return this.resaltarmonto_mone_extraDetalleProve;
	}

	public void setResaltarmonto_mone_extraDetalleProve(Border borderResaltar) {
		this.resaltarmonto_mone_extraDetalleProve= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_extraDetalleProve() {
		return this.mostrarmonto_mone_extraDetalleProve;
	}

	public void setMostrarmonto_mone_extraDetalleProve(Boolean mostrarmonto_mone_extraDetalleProve) {
		this.mostrarmonto_mone_extraDetalleProve= mostrarmonto_mone_extraDetalleProve;
	}

	public Boolean getActivarmonto_mone_extraDetalleProve() {
		return this.activarmonto_mone_extraDetalleProve;
	}

	public void setActivarmonto_mone_extraDetalleProve(Boolean activarmonto_mone_extraDetalleProve) {
		this.activarmonto_mone_extraDetalleProve= activarmonto_mone_extraDetalleProve;
	}

	public Border setResaltarnumero_comprobanteDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleProve() {
		return this.resaltarnumero_comprobanteDetalleProve;
	}

	public void setResaltarnumero_comprobanteDetalleProve(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleProve= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleProve() {
		return this.mostrarnumero_comprobanteDetalleProve;
	}

	public void setMostrarnumero_comprobanteDetalleProve(Boolean mostrarnumero_comprobanteDetalleProve) {
		this.mostrarnumero_comprobanteDetalleProve= mostrarnumero_comprobanteDetalleProve;
	}

	public Boolean getActivarnumero_comprobanteDetalleProve() {
		return this.activarnumero_comprobanteDetalleProve;
	}

	public void setActivarnumero_comprobanteDetalleProve(Boolean activarnumero_comprobanteDetalleProve) {
		this.activarnumero_comprobanteDetalleProve= activarnumero_comprobanteDetalleProve;
	}

	public Border setResaltarnumero_facturaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaDetalleProve() {
		return this.resaltarnumero_facturaDetalleProve;
	}

	public void setResaltarnumero_facturaDetalleProve(Border borderResaltar) {
		this.resaltarnumero_facturaDetalleProve= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaDetalleProve() {
		return this.mostrarnumero_facturaDetalleProve;
	}

	public void setMostrarnumero_facturaDetalleProve(Boolean mostrarnumero_facturaDetalleProve) {
		this.mostrarnumero_facturaDetalleProve= mostrarnumero_facturaDetalleProve;
	}

	public Boolean getActivarnumero_facturaDetalleProve() {
		return this.activarnumero_facturaDetalleProve;
	}

	public void setActivarnumero_facturaDetalleProve(Boolean activarnumero_facturaDetalleProve) {
		this.activarnumero_facturaDetalleProve= activarnumero_facturaDetalleProve;
	}

	public Border setResaltardebito_mone_localDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localDetalleProve() {
		return this.resaltardebito_mone_localDetalleProve;
	}

	public void setResaltardebito_mone_localDetalleProve(Border borderResaltar) {
		this.resaltardebito_mone_localDetalleProve= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localDetalleProve() {
		return this.mostrardebito_mone_localDetalleProve;
	}

	public void setMostrardebito_mone_localDetalleProve(Boolean mostrardebito_mone_localDetalleProve) {
		this.mostrardebito_mone_localDetalleProve= mostrardebito_mone_localDetalleProve;
	}

	public Boolean getActivardebito_mone_localDetalleProve() {
		return this.activardebito_mone_localDetalleProve;
	}

	public void setActivardebito_mone_localDetalleProve(Boolean activardebito_mone_localDetalleProve) {
		this.activardebito_mone_localDetalleProve= activardebito_mone_localDetalleProve;
	}

	public Border setResaltarcredito_mone_localDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localDetalleProve() {
		return this.resaltarcredito_mone_localDetalleProve;
	}

	public void setResaltarcredito_mone_localDetalleProve(Border borderResaltar) {
		this.resaltarcredito_mone_localDetalleProve= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localDetalleProve() {
		return this.mostrarcredito_mone_localDetalleProve;
	}

	public void setMostrarcredito_mone_localDetalleProve(Boolean mostrarcredito_mone_localDetalleProve) {
		this.mostrarcredito_mone_localDetalleProve= mostrarcredito_mone_localDetalleProve;
	}

	public Boolean getActivarcredito_mone_localDetalleProve() {
		return this.activarcredito_mone_localDetalleProve;
	}

	public void setActivarcredito_mone_localDetalleProve(Boolean activarcredito_mone_localDetalleProve) {
		this.activarcredito_mone_localDetalleProve= activarcredito_mone_localDetalleProve;
	}

	public Border setResaltardebito_mone_extraDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltardebito_mone_extraDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_extraDetalleProve() {
		return this.resaltardebito_mone_extraDetalleProve;
	}

	public void setResaltardebito_mone_extraDetalleProve(Border borderResaltar) {
		this.resaltardebito_mone_extraDetalleProve= borderResaltar;
	}

	public Boolean getMostrardebito_mone_extraDetalleProve() {
		return this.mostrardebito_mone_extraDetalleProve;
	}

	public void setMostrardebito_mone_extraDetalleProve(Boolean mostrardebito_mone_extraDetalleProve) {
		this.mostrardebito_mone_extraDetalleProve= mostrardebito_mone_extraDetalleProve;
	}

	public Boolean getActivardebito_mone_extraDetalleProve() {
		return this.activardebito_mone_extraDetalleProve;
	}

	public void setActivardebito_mone_extraDetalleProve(Boolean activardebito_mone_extraDetalleProve) {
		this.activardebito_mone_extraDetalleProve= activardebito_mone_extraDetalleProve;
	}

	public Border setResaltarcredito_mone_extraDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_extraDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_extraDetalleProve() {
		return this.resaltarcredito_mone_extraDetalleProve;
	}

	public void setResaltarcredito_mone_extraDetalleProve(Border borderResaltar) {
		this.resaltarcredito_mone_extraDetalleProve= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_extraDetalleProve() {
		return this.mostrarcredito_mone_extraDetalleProve;
	}

	public void setMostrarcredito_mone_extraDetalleProve(Boolean mostrarcredito_mone_extraDetalleProve) {
		this.mostrarcredito_mone_extraDetalleProve= mostrarcredito_mone_extraDetalleProve;
	}

	public Boolean getActivarcredito_mone_extraDetalleProve() {
		return this.activarcredito_mone_extraDetalleProve;
	}

	public void setActivarcredito_mone_extraDetalleProve(Boolean activarcredito_mone_extraDetalleProve) {
		this.activarcredito_mone_extraDetalleProve= activarcredito_mone_extraDetalleProve;
	}

	public Border setResaltardescripcionDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleProve() {
		return this.resaltardescripcionDetalleProve;
	}

	public void setResaltardescripcionDetalleProve(Border borderResaltar) {
		this.resaltardescripcionDetalleProve= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleProve() {
		return this.mostrardescripcionDetalleProve;
	}

	public void setMostrardescripcionDetalleProve(Boolean mostrardescripcionDetalleProve) {
		this.mostrardescripcionDetalleProve= mostrardescripcionDetalleProve;
	}

	public Boolean getActivardescripcionDetalleProve() {
		return this.activardescripcionDetalleProve;
	}

	public void setActivardescripcionDetalleProve(Boolean activardescripcionDetalleProve) {
		this.activardescripcionDetalleProve= activardescripcionDetalleProve;
	}

	public Border setResaltarid_anioDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleProve() {
		return this.resaltarid_anioDetalleProve;
	}

	public void setResaltarid_anioDetalleProve(Border borderResaltar) {
		this.resaltarid_anioDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleProve() {
		return this.mostrarid_anioDetalleProve;
	}

	public void setMostrarid_anioDetalleProve(Boolean mostrarid_anioDetalleProve) {
		this.mostrarid_anioDetalleProve= mostrarid_anioDetalleProve;
	}

	public Boolean getActivarid_anioDetalleProve() {
		return this.activarid_anioDetalleProve;
	}

	public void setActivarid_anioDetalleProve(Boolean activarid_anioDetalleProve) {
		this.activarid_anioDetalleProve= activarid_anioDetalleProve;
	}

	public Boolean getCargarid_anioDetalleProve() {
		return this.cargarid_anioDetalleProve;
	}

	public void setCargarid_anioDetalleProve(Boolean cargarid_anioDetalleProve) {
		this.cargarid_anioDetalleProve= cargarid_anioDetalleProve;
	}

	public Border setResaltarid_mesDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleProve() {
		return this.resaltarid_mesDetalleProve;
	}

	public void setResaltarid_mesDetalleProve(Border borderResaltar) {
		this.resaltarid_mesDetalleProve= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleProve() {
		return this.mostrarid_mesDetalleProve;
	}

	public void setMostrarid_mesDetalleProve(Boolean mostrarid_mesDetalleProve) {
		this.mostrarid_mesDetalleProve= mostrarid_mesDetalleProve;
	}

	public Boolean getActivarid_mesDetalleProve() {
		return this.activarid_mesDetalleProve;
	}

	public void setActivarid_mesDetalleProve(Boolean activarid_mesDetalleProve) {
		this.activarid_mesDetalleProve= activarid_mesDetalleProve;
	}

	public Boolean getCargarid_mesDetalleProve() {
		return this.cargarid_mesDetalleProve;
	}

	public void setCargarid_mesDetalleProve(Boolean cargarid_mesDetalleProve) {
		this.cargarid_mesDetalleProve= cargarid_mesDetalleProve;
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
		
		
		this.setMostraridDetalleProve(esInicial);
		this.setMostrarid_empresaDetalleProve(esInicial);
		this.setMostrarid_sucursalDetalleProve(esInicial);
		this.setMostrarid_sucursal_movimientoDetalleProve(esInicial);
		this.setMostrarid_ejercicioDetalleProve(esInicial);
		this.setMostrarid_periodoDetalleProve(esInicial);
		this.setMostrarid_moduloDetalleProve(esInicial);
		this.setMostrarid_monedaDetalleProve(esInicial);
		this.setMostrarid_clienteDetalleProve(esInicial);
		this.setMostrarid_transaccionDetalleProve(esInicial);
		this.setMostrarid_tipo_transaccion_moduloDetalleProve(esInicial);
		this.setMostrarid_asiento_contableDetalleProve(esInicial);
		this.setMostrarid_facturaDetalleProve(esInicial);
		this.setMostrarid_orden_compraDetalleProve(esInicial);
		this.setMostrarid_estado_detalle_clienteDetalleProve(esInicial);
		this.setMostrarfecha_ventaDetalleProve(esInicial);
		this.setMostrarfecha_emisionDetalleProve(esInicial);
		this.setMostrarfecha_pagoDetalleProve(esInicial);
		this.setMostrarfecha_vencimientoDetalleProve(esInicial);
		this.setMostrarmonto_mone_localDetalleProve(esInicial);
		this.setMostrarmonto_mone_extraDetalleProve(esInicial);
		this.setMostrarnumero_comprobanteDetalleProve(esInicial);
		this.setMostrarnumero_facturaDetalleProve(esInicial);
		this.setMostrardebito_mone_localDetalleProve(esInicial);
		this.setMostrarcredito_mone_localDetalleProve(esInicial);
		this.setMostrardebito_mone_extraDetalleProve(esInicial);
		this.setMostrarcredito_mone_extraDetalleProve(esInicial);
		this.setMostrardescripcionDetalleProve(esInicial);
		this.setMostrarid_anioDetalleProve(esInicial);
		this.setMostrarid_mesDetalleProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleProveConstantesFunciones.ID)) {
				this.setMostraridDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setMostrarid_sucursal_movimientoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDORDENCOMPRA)) {
				this.setMostrarid_orden_compraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setMostrarid_estado_detalle_clienteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAVENTA)) {
				this.setMostrarfecha_ventaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAPAGO)) {
				this.setMostrarfecha_pagoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.MONTOMONELOCAL)) {
				this.setMostrarmonto_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.MONTOMONEEXTRA)) {
				this.setMostrarmonto_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setMostrardebito_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setMostrarcredito_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleProve(esAsigna);
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
		
		
		this.setActivaridDetalleProve(esInicial);
		this.setActivarid_empresaDetalleProve(esInicial);
		this.setActivarid_sucursalDetalleProve(esInicial);
		this.setActivarid_sucursal_movimientoDetalleProve(esInicial);
		this.setActivarid_ejercicioDetalleProve(esInicial);
		this.setActivarid_periodoDetalleProve(esInicial);
		this.setActivarid_moduloDetalleProve(esInicial);
		this.setActivarid_monedaDetalleProve(esInicial);
		this.setActivarid_clienteDetalleProve(esInicial);
		this.setActivarid_transaccionDetalleProve(esInicial);
		this.setActivarid_tipo_transaccion_moduloDetalleProve(esInicial);
		this.setActivarid_asiento_contableDetalleProve(esInicial);
		this.setActivarid_facturaDetalleProve(esInicial);
		this.setActivarid_orden_compraDetalleProve(esInicial);
		this.setActivarid_estado_detalle_clienteDetalleProve(esInicial);
		this.setActivarfecha_ventaDetalleProve(esInicial);
		this.setActivarfecha_emisionDetalleProve(esInicial);
		this.setActivarfecha_pagoDetalleProve(esInicial);
		this.setActivarfecha_vencimientoDetalleProve(esInicial);
		this.setActivarmonto_mone_localDetalleProve(esInicial);
		this.setActivarmonto_mone_extraDetalleProve(esInicial);
		this.setActivarnumero_comprobanteDetalleProve(esInicial);
		this.setActivarnumero_facturaDetalleProve(esInicial);
		this.setActivardebito_mone_localDetalleProve(esInicial);
		this.setActivarcredito_mone_localDetalleProve(esInicial);
		this.setActivardebito_mone_extraDetalleProve(esInicial);
		this.setActivarcredito_mone_extraDetalleProve(esInicial);
		this.setActivardescripcionDetalleProve(esInicial);
		this.setActivarid_anioDetalleProve(esInicial);
		this.setActivarid_mesDetalleProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleProveConstantesFunciones.ID)) {
				this.setActivaridDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setActivarid_sucursal_movimientoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDORDENCOMPRA)) {
				this.setActivarid_orden_compraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setActivarid_estado_detalle_clienteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAVENTA)) {
				this.setActivarfecha_ventaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAPAGO)) {
				this.setActivarfecha_pagoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.MONTOMONELOCAL)) {
				this.setActivarmonto_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.MONTOMONEEXTRA)) {
				this.setActivarmonto_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setActivardebito_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setActivarcredito_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleProve(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleProve(esInicial);
		this.setResaltarid_empresaDetalleProve(esInicial);
		this.setResaltarid_sucursalDetalleProve(esInicial);
		this.setResaltarid_sucursal_movimientoDetalleProve(esInicial);
		this.setResaltarid_ejercicioDetalleProve(esInicial);
		this.setResaltarid_periodoDetalleProve(esInicial);
		this.setResaltarid_moduloDetalleProve(esInicial);
		this.setResaltarid_monedaDetalleProve(esInicial);
		this.setResaltarid_clienteDetalleProve(esInicial);
		this.setResaltarid_transaccionDetalleProve(esInicial);
		this.setResaltarid_tipo_transaccion_moduloDetalleProve(esInicial);
		this.setResaltarid_asiento_contableDetalleProve(esInicial);
		this.setResaltarid_facturaDetalleProve(esInicial);
		this.setResaltarid_orden_compraDetalleProve(esInicial);
		this.setResaltarid_estado_detalle_clienteDetalleProve(esInicial);
		this.setResaltarfecha_ventaDetalleProve(esInicial);
		this.setResaltarfecha_emisionDetalleProve(esInicial);
		this.setResaltarfecha_pagoDetalleProve(esInicial);
		this.setResaltarfecha_vencimientoDetalleProve(esInicial);
		this.setResaltarmonto_mone_localDetalleProve(esInicial);
		this.setResaltarmonto_mone_extraDetalleProve(esInicial);
		this.setResaltarnumero_comprobanteDetalleProve(esInicial);
		this.setResaltarnumero_facturaDetalleProve(esInicial);
		this.setResaltardebito_mone_localDetalleProve(esInicial);
		this.setResaltarcredito_mone_localDetalleProve(esInicial);
		this.setResaltardebito_mone_extraDetalleProve(esInicial);
		this.setResaltarcredito_mone_extraDetalleProve(esInicial);
		this.setResaltardescripcionDetalleProve(esInicial);
		this.setResaltarid_anioDetalleProve(esInicial);
		this.setResaltarid_mesDetalleProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleProveConstantesFunciones.ID)) {
				this.setResaltaridDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setResaltarid_sucursal_movimientoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDORDENCOMPRA)) {
				this.setResaltarid_orden_compraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setResaltarid_estado_detalle_clienteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAVENTA)) {
				this.setResaltarfecha_ventaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAPAGO)) {
				this.setResaltarfecha_pagoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.MONTOMONELOCAL)) {
				this.setResaltarmonto_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.MONTOMONEEXTRA)) {
				this.setResaltarmonto_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setResaltardebito_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setResaltarcredito_mone_extraDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleProveConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleProve(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPagoAutoDetalleProve=null;

	public Border getResaltarPagoAutoDetalleProve() {
		return this.resaltarPagoAutoDetalleProve;
	}

	public void setResaltarPagoAutoDetalleProve(Border borderResaltarPagoAuto) {
		if(borderResaltarPagoAuto!=null) {
			this.resaltarPagoAutoDetalleProve= borderResaltarPagoAuto;
		}
	}

	public Border setResaltarPagoAutoDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltarPagoAuto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltarPagoAuto);
			
		this.resaltarPagoAutoDetalleProve= borderResaltarPagoAuto;

		 return borderResaltarPagoAuto;
	}



	public Boolean mostrarPagoAutoDetalleProve=true;

	public Boolean getMostrarPagoAutoDetalleProve() {
		return this.mostrarPagoAutoDetalleProve;
	}

	public void setMostrarPagoAutoDetalleProve(Boolean visibilidadResaltarPagoAuto) {
		this.mostrarPagoAutoDetalleProve= visibilidadResaltarPagoAuto;
	}



	public Boolean activarPagoAutoDetalleProve=true;

	public Boolean gethabilitarResaltarPagoAutoDetalleProve() {
		return this.activarPagoAutoDetalleProve;
	}

	public void setActivarPagoAutoDetalleProve(Boolean habilitarResaltarPagoAuto) {
		this.activarPagoAutoDetalleProve= habilitarResaltarPagoAuto;
	}


	public Border resaltarAutoriPagoDetalleProve=null;

	public Border getResaltarAutoriPagoDetalleProve() {
		return this.resaltarAutoriPagoDetalleProve;
	}

	public void setResaltarAutoriPagoDetalleProve(Border borderResaltarAutoriPago) {
		if(borderResaltarAutoriPago!=null) {
			this.resaltarAutoriPagoDetalleProve= borderResaltarAutoriPago;
		}
	}

	public Border setResaltarAutoriPagoDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleproveBeanSwingJInternalFrame.jTtoolBarDetalleProve.setBorder(borderResaltarAutoriPago);
			
		this.resaltarAutoriPagoDetalleProve= borderResaltarAutoriPago;

		 return borderResaltarAutoriPago;
	}



	public Boolean mostrarAutoriPagoDetalleProve=true;

	public Boolean getMostrarAutoriPagoDetalleProve() {
		return this.mostrarAutoriPagoDetalleProve;
	}

	public void setMostrarAutoriPagoDetalleProve(Boolean visibilidadResaltarAutoriPago) {
		this.mostrarAutoriPagoDetalleProve= visibilidadResaltarAutoriPago;
	}



	public Boolean activarAutoriPagoDetalleProve=true;

	public Boolean gethabilitarResaltarAutoriPagoDetalleProve() {
		return this.activarAutoriPagoDetalleProve;
	}

	public void setActivarAutoriPagoDetalleProve(Boolean habilitarResaltarAutoriPago) {
		this.activarAutoriPagoDetalleProve= habilitarResaltarAutoriPago;
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

		this.setMostrarPagoAutoDetalleProve(esInicial);
		this.setMostrarAutoriPagoDetalleProve(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setMostrarPagoAutoDetalleProve(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setMostrarAutoriPagoDetalleProve(esAsigna);
				continue;
			}
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

		this.setActivarPagoAutoDetalleProve(esInicial);
		this.setActivarAutoriPagoDetalleProve(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setActivarPagoAutoDetalleProve(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setActivarAutoriPagoDetalleProve(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPagoAutoDetalleProve(esInicial);
		this.setResaltarAutoriPagoDetalleProve(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setResaltarPagoAutoDetalleProve(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setResaltarAutoriPagoDetalleProve(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableDetalleProve=true;

	public Boolean getMostrarFK_IdAsientoContableDetalleProve() {
		return this.mostrarFK_IdAsientoContableDetalleProve;
	}

	public void setMostrarFK_IdAsientoContableDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteDetalleProve=true;

	public Boolean getMostrarFK_IdClienteDetalleProve() {
		return this.mostrarFK_IdClienteDetalleProve;
	}

	public void setMostrarFK_IdClienteDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleProveDetalleProve=true;

	public Boolean getMostrarFK_IdDetalleProveDetalleProve() {
		return this.mostrarFK_IdDetalleProveDetalleProve;
	}

	public void setMostrarFK_IdDetalleProveDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleProveDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleProve=true;

	public Boolean getMostrarFK_IdEjercicioDetalleProve() {
		return this.mostrarFK_IdEjercicioDetalleProve;
	}

	public void setMostrarFK_IdEjercicioDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleProve=true;

	public Boolean getMostrarFK_IdEmpresaDetalleProve() {
		return this.mostrarFK_IdEmpresaDetalleProve;
	}

	public void setMostrarFK_IdEmpresaDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleClienteDetalleProve=true;

	public Boolean getMostrarFK_IdEstadoDetalleClienteDetalleProve() {
		return this.mostrarFK_IdEstadoDetalleClienteDetalleProve;
	}

	public void setMostrarFK_IdEstadoDetalleClienteDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleClienteDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaDetalleProve=true;

	public Boolean getMostrarFK_IdFacturaDetalleProve() {
		return this.mostrarFK_IdFacturaDetalleProve;
	}

	public void setMostrarFK_IdFacturaDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDetalleProve=true;

	public Boolean getMostrarFK_IdModuloDetalleProve() {
		return this.mostrarFK_IdModuloDetalleProve;
	}

	public void setMostrarFK_IdModuloDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaDetalleProve=true;

	public Boolean getMostrarFK_IdMonedaDetalleProve() {
		return this.mostrarFK_IdMonedaDetalleProve;
	}

	public void setMostrarFK_IdMonedaDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenCompraDetalleProve=true;

	public Boolean getMostrarFK_IdOrdenCompraDetalleProve() {
		return this.mostrarFK_IdOrdenCompraDetalleProve;
	}

	public void setMostrarFK_IdOrdenCompraDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenCompraDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleProve=true;

	public Boolean getMostrarFK_IdPeriodoDetalleProve() {
		return this.mostrarFK_IdPeriodoDetalleProve;
	}

	public void setMostrarFK_IdPeriodoDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleProve=true;

	public Boolean getMostrarFK_IdSucursalDetalleProve() {
		return this.mostrarFK_IdSucursalDetalleProve;
	}

	public void setMostrarFK_IdSucursalDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloDetalleProve=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloDetalleProve() {
		return this.mostrarFK_IdTipoTransaccionModuloDetalleProve;
	}

	public void setMostrarFK_IdTipoTransaccionModuloDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloDetalleProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionDetalleProve=true;

	public Boolean getMostrarFK_IdTransaccionDetalleProve() {
		return this.mostrarFK_IdTransaccionDetalleProve;
	}

	public void setMostrarFK_IdTransaccionDetalleProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionDetalleProve= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDetalleProve=true;

	public Boolean getActivarFK_IdAsientoContableDetalleProve() {
		return this.activarFK_IdAsientoContableDetalleProve;
	}

	public void setActivarFK_IdAsientoContableDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteDetalleProve=true;

	public Boolean getActivarFK_IdClienteDetalleProve() {
		return this.activarFK_IdClienteDetalleProve;
	}

	public void setActivarFK_IdClienteDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleProveDetalleProve=true;

	public Boolean getActivarFK_IdDetalleProveDetalleProve() {
		return this.activarFK_IdDetalleProveDetalleProve;
	}

	public void setActivarFK_IdDetalleProveDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleProveDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleProve=true;

	public Boolean getActivarFK_IdEjercicioDetalleProve() {
		return this.activarFK_IdEjercicioDetalleProve;
	}

	public void setActivarFK_IdEjercicioDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleProve=true;

	public Boolean getActivarFK_IdEmpresaDetalleProve() {
		return this.activarFK_IdEmpresaDetalleProve;
	}

	public void setActivarFK_IdEmpresaDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleClienteDetalleProve=true;

	public Boolean getActivarFK_IdEstadoDetalleClienteDetalleProve() {
		return this.activarFK_IdEstadoDetalleClienteDetalleProve;
	}

	public void setActivarFK_IdEstadoDetalleClienteDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleClienteDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaDetalleProve=true;

	public Boolean getActivarFK_IdFacturaDetalleProve() {
		return this.activarFK_IdFacturaDetalleProve;
	}

	public void setActivarFK_IdFacturaDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDetalleProve=true;

	public Boolean getActivarFK_IdModuloDetalleProve() {
		return this.activarFK_IdModuloDetalleProve;
	}

	public void setActivarFK_IdModuloDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaDetalleProve=true;

	public Boolean getActivarFK_IdMonedaDetalleProve() {
		return this.activarFK_IdMonedaDetalleProve;
	}

	public void setActivarFK_IdMonedaDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenCompraDetalleProve=true;

	public Boolean getActivarFK_IdOrdenCompraDetalleProve() {
		return this.activarFK_IdOrdenCompraDetalleProve;
	}

	public void setActivarFK_IdOrdenCompraDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenCompraDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleProve=true;

	public Boolean getActivarFK_IdPeriodoDetalleProve() {
		return this.activarFK_IdPeriodoDetalleProve;
	}

	public void setActivarFK_IdPeriodoDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleProve=true;

	public Boolean getActivarFK_IdSucursalDetalleProve() {
		return this.activarFK_IdSucursalDetalleProve;
	}

	public void setActivarFK_IdSucursalDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloDetalleProve=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloDetalleProve() {
		return this.activarFK_IdTipoTransaccionModuloDetalleProve;
	}

	public void setActivarFK_IdTipoTransaccionModuloDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloDetalleProve= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionDetalleProve=true;

	public Boolean getActivarFK_IdTransaccionDetalleProve() {
		return this.activarFK_IdTransaccionDetalleProve;
	}

	public void setActivarFK_IdTransaccionDetalleProve(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionDetalleProve= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDetalleProve=null;

	public Border getResaltarFK_IdAsientoContableDetalleProve() {
		return this.resaltarFK_IdAsientoContableDetalleProve;
	}

	public void setResaltarFK_IdAsientoContableDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdClienteDetalleProve=null;

	public Border getResaltarFK_IdClienteDetalleProve() {
		return this.resaltarFK_IdClienteDetalleProve;
	}

	public void setResaltarFK_IdClienteDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdClienteDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdClienteDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdDetalleProveDetalleProve=null;

	public Border getResaltarFK_IdDetalleProveDetalleProve() {
		return this.resaltarFK_IdDetalleProveDetalleProve;
	}

	public void setResaltarFK_IdDetalleProveDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdDetalleProveDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdDetalleProveDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleProveDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleProve=null;

	public Border getResaltarFK_IdEjercicioDetalleProve() {
		return this.resaltarFK_IdEjercicioDetalleProve;
	}

	public void setResaltarFK_IdEjercicioDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleProve=null;

	public Border getResaltarFK_IdEmpresaDetalleProve() {
		return this.resaltarFK_IdEmpresaDetalleProve;
	}

	public void setResaltarFK_IdEmpresaDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleClienteDetalleProve=null;

	public Border getResaltarFK_IdEstadoDetalleClienteDetalleProve() {
		return this.resaltarFK_IdEstadoDetalleClienteDetalleProve;
	}

	public void setResaltarFK_IdEstadoDetalleClienteDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleClienteDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleClienteDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleClienteDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdFacturaDetalleProve=null;

	public Border getResaltarFK_IdFacturaDetalleProve() {
		return this.resaltarFK_IdFacturaDetalleProve;
	}

	public void setResaltarFK_IdFacturaDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdFacturaDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdFacturaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdModuloDetalleProve=null;

	public Border getResaltarFK_IdModuloDetalleProve() {
		return this.resaltarFK_IdModuloDetalleProve;
	}

	public void setResaltarFK_IdModuloDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdModuloDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdModuloDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdMonedaDetalleProve=null;

	public Border getResaltarFK_IdMonedaDetalleProve() {
		return this.resaltarFK_IdMonedaDetalleProve;
	}

	public void setResaltarFK_IdMonedaDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdMonedaDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdMonedaDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdOrdenCompraDetalleProve=null;

	public Border getResaltarFK_IdOrdenCompraDetalleProve() {
		return this.resaltarFK_IdOrdenCompraDetalleProve;
	}

	public void setResaltarFK_IdOrdenCompraDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdOrdenCompraDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdOrdenCompraDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenCompraDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleProve=null;

	public Border getResaltarFK_IdPeriodoDetalleProve() {
		return this.resaltarFK_IdPeriodoDetalleProve;
	}

	public void setResaltarFK_IdPeriodoDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleProve=null;

	public Border getResaltarFK_IdSucursalDetalleProve() {
		return this.resaltarFK_IdSucursalDetalleProve;
	}

	public void setResaltarFK_IdSucursalDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloDetalleProve=null;

	public Border getResaltarFK_IdTipoTransaccionModuloDetalleProve() {
		return this.resaltarFK_IdTipoTransaccionModuloDetalleProve;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloDetalleProve= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionDetalleProve=null;

	public Border getResaltarFK_IdTransaccionDetalleProve() {
		return this.resaltarFK_IdTransaccionDetalleProve;
	}

	public void setResaltarFK_IdTransaccionDetalleProve(Border borderResaltar) {
		this.resaltarFK_IdTransaccionDetalleProve= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionDetalleProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleProveBeanSwingJInternalFrame detalleproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionDetalleProve= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}