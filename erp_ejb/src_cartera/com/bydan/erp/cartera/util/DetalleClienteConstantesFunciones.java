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


import com.bydan.erp.cartera.util.DetalleClienteConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleClienteConstantesFunciones extends DetalleClienteConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=" order by fecha_emision desc" ;	
	public static final String SNOMBREOPCION="DetalleCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleCliente"+DetalleClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleClienteConstantesFunciones.SCHEMA+"_"+DetalleClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleClienteConstantesFunciones.SCHEMA+"_"+DetalleClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleClienteConstantesFunciones.SCHEMA+"_"+DetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleClienteConstantesFunciones.SCHEMA+"_"+DetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleCliente";
	public static final String OBJECTNAME="detallecliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallecliente from "+DetalleClienteConstantesFunciones.SPERSISTENCENAME+" detallecliente";
	public static String QUERYSELECTNATIVE="select "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".version_row,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_empresa,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_periodo,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_anio,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_mes,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_modulo,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_cliente,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_factura,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".numero_factura,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".fecha_vence,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".descripcion,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".debito_mone_local,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".credito_mone_local,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".debito_mone_extra,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".credito_mone_extra,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_moneda,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".cotizacion,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_sucursal_movimiento,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".beneficiario,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".monto_mone_local,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".monto_mone_extra,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME+".id_estado_detalle_cliente from "+DetalleClienteConstantesFunciones.SCHEMA+"."+DetalleClienteConstantesFunciones.TABLENAME;//+" as "+DetalleClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleClienteConstantesFuncionesAdditional detalleclienteConstantesFuncionesAdditional=null;
	
	public DetalleClienteConstantesFuncionesAdditional getDetalleClienteConstantesFuncionesAdditional() {
		return this.detalleclienteConstantesFuncionesAdditional;
	}
	
	public void setDetalleClienteConstantesFuncionesAdditional(DetalleClienteConstantesFuncionesAdditional detalleclienteConstantesFuncionesAdditional) {
		try {
			this.detalleclienteConstantesFuncionesAdditional=detalleclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDMODULO= "id_modulo";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDFACTURA= "id_factura";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String DESCRIPCION= "descripcion";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DEBITOMONEEXTRA= "debito_mone_extra";
    public static final String CREDITOMONEEXTRA= "credito_mone_extra";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String IDSUCURSALMOVIMIENTO= "id_sucursal_movimiento";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String MONTOMONELOCAL= "monto_mone_local";
    public static final String MONTOMONEEXTRA= "monto_mone_extra";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String IDESTADODETALLECLIENTE= "id_estado_detalle_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DEBITOMONEEXTRA= "Debito Mone Extra";
		public static final String LABEL_DEBITOMONEEXTRA_LOWER= "Debito Mone Extra";
    	public static final String LABEL_CREDITOMONEEXTRA= "Credito Mone Extra";
		public static final String LABEL_CREDITOMONEEXTRA_LOWER= "Credito Mone Extra";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_IDSUCURSALMOVIMIENTO= "Sucursal Movimiento";
		public static final String LABEL_IDSUCURSALMOVIMIENTO_LOWER= "Sucursal Movimiento";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_MONTOMONELOCAL= "Monto Mone Local";
		public static final String LABEL_MONTOMONELOCAL_LOWER= "Monto Mone Local";
    	public static final String LABEL_MONTOMONEEXTRA= "Monto Mone Extra";
		public static final String LABEL_MONTOMONEEXTRA_LOWER= "Monto Mone Extra";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_IDESTADODETALLECLIENTE= "Estado Detalle Cliente";
		public static final String LABEL_IDESTADODETALLECLIENTE_LOWER= "Estado Detalle Cliente";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getDetalleClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDANIO)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDMES)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDMODULO)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDTRANSACCION)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDFACTURA)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.FECHAVENCE)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.DEBITOMONEEXTRA)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_DEBITOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.CREDITOMONEEXTRA)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_CREDITOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDMONEDA)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.COTIZACION)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.FECHAEMISION)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.BENEFICIARIO)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.MONTOMONELOCAL)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_MONTOMONELOCAL;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.MONTOMONEEXTRA)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_MONTOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE)) {sLabelColumna=DetalleClienteConstantesFunciones.LABEL_IDESTADODETALLECLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleClienteDescripcion(DetalleCliente detallecliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallecliente !=null/* && detallecliente.getId()!=0*/) {
			if(detallecliente.getId()!=null) {
				sDescripcion=detallecliente.getId().toString();
			}//detalleclientedetallecliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleClienteDescripcionDetallado(DetalleCliente detallecliente) {
		String sDescripcion="";
			
		sDescripcion+=DetalleClienteConstantesFunciones.ID+"=";
		sDescripcion+=detallecliente.getId().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallecliente.getVersionRow().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallecliente.getid_empresa().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallecliente.getid_sucursal().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallecliente.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallecliente.getid_periodo().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallecliente.getid_anio().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDMES+"=";
		sDescripcion+=detallecliente.getid_mes().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDMODULO+"=";
		sDescripcion+=detallecliente.getid_modulo().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detallecliente.getid_asiento_contable().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=detallecliente.getid_cliente().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=detallecliente.getid_transaccion().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=detallecliente.getid_factura().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=detallecliente.getnumero_factura()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=detallecliente.getfecha_vence().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallecliente.getdescripcion()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=detallecliente.getdebito_mone_local().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=detallecliente.getcredito_mone_local().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.DEBITOMONEEXTRA+"=";
		sDescripcion+=detallecliente.getdebito_mone_extra().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.CREDITOMONEEXTRA+"=";
		sDescripcion+=detallecliente.getcredito_mone_extra().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=detallecliente.getid_moneda().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.COTIZACION+"=";
		sDescripcion+=detallecliente.getcotizacion().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO+"=";
		sDescripcion+=detallecliente.getid_sucursal_movimiento().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=detallecliente.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=detallecliente.getfecha_emision().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=detallecliente.getbeneficiario()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.MONTOMONELOCAL+"=";
		sDescripcion+=detallecliente.getmonto_mone_local().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.MONTOMONEEXTRA+"=";
		sDescripcion+=detallecliente.getmonto_mone_extra().toString()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detallecliente.getnumero_comprobante()+",";
		sDescripcion+=DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE+"=";
		sDescripcion+=detallecliente.getid_estado_detalle_cliente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleClienteDescripcion(DetalleCliente detallecliente,String sValor) throws Exception {			
		if(detallecliente !=null) {
			//detalleclientedetallecliente.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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

	public static String getSucursalMovimientoDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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

	public static String getEstadoDetalleClienteDescripcion(EstadoDetalleCliente estadodetallecliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetallecliente!=null/*&&estadodetallecliente.getId()>0*/) {
			sDescripcion=EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(estadodetallecliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorFechaEmision")) {
			sNombreIndice="Tipo=  Por Fecha Emision";
		} else if(sNombreIndice.equals("BusquedaPorFechaVence")) {
			sNombreIndice="Tipo=  Por Fecha Vence";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdSucursalMovimiento")) {
			sNombreIndice="Tipo=  Por Sucursal Movimiento";
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

	public static String getDetalleIndiceBusquedaPorFechaEmision(Date fecha_emision,Date fecha_emisionFinal) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision!=null) {sDetalleIndice+=" Fecha Emision="+fecha_emision.toString();}
		if(fecha_emisionFinal!=null) {sDetalleIndice+=" Fecha Emision FINAL="+fecha_emisionFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaVence(Date fecha_vence,Date fecha_venceFinal) {
		String sDetalleIndice=" Parametros->";
		if(fecha_vence!=null) {sDetalleIndice+=" Fecha Vence="+fecha_vence.toString();}
		if(fecha_venceFinal!=null) {sDetalleIndice+=" Fecha Vence FINAL="+fecha_venceFinal.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdSucursalMovimiento(Long id_sucursal_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Sucursal Movimiento="+id_sucursal_movimiento.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleCliente(DetalleCliente detallecliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallecliente.setnumero_factura(detallecliente.getnumero_factura().trim());
		detallecliente.setdescripcion(detallecliente.getdescripcion().trim());
		detallecliente.setbeneficiario(detallecliente.getbeneficiario().trim());
		detallecliente.setnumero_comprobante(detallecliente.getnumero_comprobante().trim());
	}
	
	public static void quitarEspaciosDetalleClientes(List<DetalleCliente> detalleclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleCliente detallecliente: detalleclientes) {
			detallecliente.setnumero_factura(detallecliente.getnumero_factura().trim());
			detallecliente.setdescripcion(detallecliente.getdescripcion().trim());
			detallecliente.setbeneficiario(detallecliente.getbeneficiario().trim());
			detallecliente.setnumero_comprobante(detallecliente.getnumero_comprobante().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCliente(DetalleCliente detallecliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallecliente.getConCambioAuxiliar()) {
			detallecliente.setIsDeleted(detallecliente.getIsDeletedAuxiliar());	
			detallecliente.setIsNew(detallecliente.getIsNewAuxiliar());	
			detallecliente.setIsChanged(detallecliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallecliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallecliente.setIsDeletedAuxiliar(false);	
			detallecliente.setIsNewAuxiliar(false);	
			detallecliente.setIsChangedAuxiliar(false);
			
			detallecliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleClientes(List<DetalleCliente> detalleclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleCliente detallecliente : detalleclientes) {
			if(conAsignarBase && detallecliente.getConCambioAuxiliar()) {
				detallecliente.setIsDeleted(detallecliente.getIsDeletedAuxiliar());	
				detallecliente.setIsNew(detallecliente.getIsNewAuxiliar());	
				detallecliente.setIsChanged(detallecliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallecliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallecliente.setIsDeletedAuxiliar(false);	
				detallecliente.setIsNewAuxiliar(false);	
				detallecliente.setIsChangedAuxiliar(false);
				
				detallecliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleCliente(DetalleCliente detallecliente,Boolean conEnteros) throws Exception  {
		detallecliente.setdebito_mone_local(0.0);
		detallecliente.setcredito_mone_local(0.0);
		detallecliente.setdebito_mone_extra(0.0);
		detallecliente.setcredito_mone_extra(0.0);
		detallecliente.setcotizacion(0.0);
		detallecliente.setmonto_mone_local(0.0);
		detallecliente.setmonto_mone_extra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleClientes(List<DetalleCliente> detalleclientes,Boolean conEnteros) throws Exception  {
		
		for(DetalleCliente detallecliente: detalleclientes) {
			detallecliente.setdebito_mone_local(0.0);
			detallecliente.setcredito_mone_local(0.0);
			detallecliente.setdebito_mone_extra(0.0);
			detallecliente.setcredito_mone_extra(0.0);
			detallecliente.setcotizacion(0.0);
			detallecliente.setmonto_mone_local(0.0);
			detallecliente.setmonto_mone_extra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleCliente(List<DetalleCliente> detalleclientes,DetalleCliente detalleclienteAux) throws Exception  {
		DetalleClienteConstantesFunciones.InicializarValoresDetalleCliente(detalleclienteAux,true);
		
		for(DetalleCliente detallecliente: detalleclientes) {
			if(detallecliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleclienteAux.setdebito_mone_local(detalleclienteAux.getdebito_mone_local()+detallecliente.getdebito_mone_local());			
			detalleclienteAux.setcredito_mone_local(detalleclienteAux.getcredito_mone_local()+detallecliente.getcredito_mone_local());			
			detalleclienteAux.setdebito_mone_extra(detalleclienteAux.getdebito_mone_extra()+detallecliente.getdebito_mone_extra());			
			detalleclienteAux.setcredito_mone_extra(detalleclienteAux.getcredito_mone_extra()+detallecliente.getcredito_mone_extra());			
			detalleclienteAux.setcotizacion(detalleclienteAux.getcotizacion()+detallecliente.getcotizacion());			
			detalleclienteAux.setmonto_mone_local(detalleclienteAux.getmonto_mone_local()+detallecliente.getmonto_mone_local());			
			detalleclienteAux.setmonto_mone_extra(detalleclienteAux.getmonto_mone_extra()+detallecliente.getmonto_mone_extra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleClienteConstantesFunciones.getArrayColumnasGlobalesDetalleCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleClienteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleClienteConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleClienteConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleClienteConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleClienteConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleClienteConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleClienteConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleClienteConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleClienteConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleClienteConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleCliente> detalleclientes,DetalleCliente detallecliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleCliente detalleclienteAux: detalleclientes) {
			if(detalleclienteAux!=null && detallecliente!=null) {
				if((detalleclienteAux.getId()==null && detallecliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleclienteAux.getId()!=null && detallecliente.getId()!=null){
					if(detalleclienteAux.getId().equals(detallecliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleCliente(List<DetalleCliente> detalleclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double debito_mone_extraTotal=0.0;
		Double credito_mone_extraTotal=0.0;
		Double cotizacionTotal=0.0;
		Double monto_mone_localTotal=0.0;
		Double monto_mone_extraTotal=0.0;
	
		for(DetalleCliente detallecliente: detalleclientes) {			
			if(detallecliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=detallecliente.getdebito_mone_local();
			credito_mone_localTotal+=detallecliente.getcredito_mone_local();
			debito_mone_extraTotal+=detallecliente.getdebito_mone_extra();
			credito_mone_extraTotal+=detallecliente.getcredito_mone_extra();
			cotizacionTotal+=detallecliente.getcotizacion();
			monto_mone_localTotal+=detallecliente.getmonto_mone_local();
			monto_mone_extraTotal+=detallecliente.getmonto_mone_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleClienteConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleClienteConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleClienteConstantesFunciones.DEBITOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		datoGeneral.setdValorDouble(debito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleClienteConstantesFunciones.CREDITOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		datoGeneral.setdValorDouble(credito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleClienteConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleClienteConstantesFunciones.MONTOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_MONTOMONELOCAL);
		datoGeneral.setdValorDouble(monto_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleClienteConstantesFunciones.MONTOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_MONTOMONEEXTRA);
		datoGeneral.setdValorDouble(monto_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_ID, DetalleClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_VERSIONROW, DetalleClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDEMPRESA, DetalleClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDSUCURSAL, DetalleClienteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDEJERCICIO, DetalleClienteConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDPERIODO, DetalleClienteConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDANIO, DetalleClienteConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDMES, DetalleClienteConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDMODULO, DetalleClienteConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetalleClienteConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDCLIENTE, DetalleClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDTRANSACCION, DetalleClienteConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDFACTURA, DetalleClienteConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_NUMEROFACTURA, DetalleClienteConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_FECHAVENCE, DetalleClienteConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_DESCRIPCION, DetalleClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_DEBITOMONELOCAL, DetalleClienteConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_CREDITOMONELOCAL, DetalleClienteConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_DEBITOMONEEXTRA, DetalleClienteConstantesFunciones.DEBITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_CREDITOMONEEXTRA, DetalleClienteConstantesFunciones.CREDITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDMONEDA, DetalleClienteConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_COTIZACION, DetalleClienteConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO, DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_FECHAEMISION, DetalleClienteConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_BENEFICIARIO, DetalleClienteConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_MONTOMONELOCAL, DetalleClienteConstantesFunciones.MONTOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_MONTOMONEEXTRA, DetalleClienteConstantesFunciones.MONTOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleClienteConstantesFunciones.LABEL_IDESTADODETALLECLIENTE, DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.DEBITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.CREDITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.MONTOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.MONTOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCliente() throws Exception  {
		return DetalleClienteConstantesFunciones.getTiposSeleccionarDetalleCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCliente(Boolean conFk) throws Exception  {
		return DetalleClienteConstantesFunciones.getTiposSeleccionarDetalleCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_DEBITOMONEEXTRA);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_DEBITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_CREDITOMONEEXTRA);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_CREDITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_MONTOMONELOCAL);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_MONTOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_MONTOMONEEXTRA);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_MONTOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleClienteConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);
			reporte.setsDescripcion(DetalleClienteConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCliente(DetalleCliente detalleclienteAux) throws Exception {
		
			detalleclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleclienteAux.getEmpresa()));
			detalleclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleclienteAux.getSucursal()));
			detalleclienteAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleclienteAux.getEjercicio()));
			detalleclienteAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleclienteAux.getPeriodo()));
			detalleclienteAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleclienteAux.getAnio()));
			detalleclienteAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleclienteAux.getMes()));
			detalleclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalleclienteAux.getModulo()));
			detalleclienteAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleclienteAux.getAsientoContable()));
			detalleclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalleclienteAux.getCliente()));
			detalleclienteAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detalleclienteAux.getTransaccion()));
			detalleclienteAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detalleclienteAux.getFactura()));
			detalleclienteAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(detalleclienteAux.getMoneda()));
			detalleclienteAux.setsucursalmovimiento_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleclienteAux.getSucursalMovimiento()));
			detalleclienteAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalleclienteAux.getTipoTransaccionModulo()));
			detalleclienteAux.setestadodetallecliente_descripcion(EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(detalleclienteAux.getEstadoDetalleCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCliente(List<DetalleCliente> detalleclientesTemp) throws Exception {
		for(DetalleCliente detalleclienteAux:detalleclientesTemp) {
			
			detalleclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleclienteAux.getEmpresa()));
			detalleclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleclienteAux.getSucursal()));
			detalleclienteAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleclienteAux.getEjercicio()));
			detalleclienteAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleclienteAux.getPeriodo()));
			detalleclienteAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleclienteAux.getAnio()));
			detalleclienteAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleclienteAux.getMes()));
			detalleclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalleclienteAux.getModulo()));
			detalleclienteAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleclienteAux.getAsientoContable()));
			detalleclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalleclienteAux.getCliente()));
			detalleclienteAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detalleclienteAux.getTransaccion()));
			detalleclienteAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detalleclienteAux.getFactura()));
			detalleclienteAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(detalleclienteAux.getMoneda()));
			detalleclienteAux.setsucursalmovimiento_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleclienteAux.getSucursalMovimiento()));
			detalleclienteAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalleclienteAux.getTipoTransaccionModulo()));
			detalleclienteAux.setestadodetallecliente_descripcion(EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(detalleclienteAux.getEstadoDetalleCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(EstadoDetalleCliente.class));
				
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
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDetalleCliente.class)) {
						classes.add(new Classe(EstadoDetalleCliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(EstadoDetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleCliente.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(EstadoDetalleCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleCliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleClienteConstantesFunciones.getClassesRelationshipsOfDetalleCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleRecap.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleRecap.class)) {
						classes.add(new Classe(DetalleRecap.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleClienteConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRecap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRecap.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRecap.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRecap.class)); continue;
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
	public static void actualizarLista(DetalleCliente detallecliente,List<DetalleCliente> detalleclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleCliente detalleclienteEncontrado=null;
			
			for(DetalleCliente detalleclienteLocal:detalleclientes) {
				if(detalleclienteLocal.getId().equals(detallecliente.getId())) {
					detalleclienteEncontrado=detalleclienteLocal;
					
					detalleclienteLocal.setIsChanged(detallecliente.getIsChanged());
					detalleclienteLocal.setIsNew(detallecliente.getIsNew());
					detalleclienteLocal.setIsDeleted(detallecliente.getIsDeleted());
					
					detalleclienteLocal.setGeneralEntityOriginal(detallecliente.getGeneralEntityOriginal());
					
					detalleclienteLocal.setId(detallecliente.getId());	
					detalleclienteLocal.setVersionRow(detallecliente.getVersionRow());	
					detalleclienteLocal.setid_empresa(detallecliente.getid_empresa());	
					detalleclienteLocal.setid_sucursal(detallecliente.getid_sucursal());	
					detalleclienteLocal.setid_ejercicio(detallecliente.getid_ejercicio());	
					detalleclienteLocal.setid_periodo(detallecliente.getid_periodo());	
					detalleclienteLocal.setid_anio(detallecliente.getid_anio());	
					detalleclienteLocal.setid_mes(detallecliente.getid_mes());	
					detalleclienteLocal.setid_modulo(detallecliente.getid_modulo());	
					detalleclienteLocal.setid_asiento_contable(detallecliente.getid_asiento_contable());	
					detalleclienteLocal.setid_cliente(detallecliente.getid_cliente());	
					detalleclienteLocal.setid_transaccion(detallecliente.getid_transaccion());	
					detalleclienteLocal.setid_factura(detallecliente.getid_factura());	
					detalleclienteLocal.setnumero_factura(detallecliente.getnumero_factura());	
					detalleclienteLocal.setfecha_vence(detallecliente.getfecha_vence());	
					detalleclienteLocal.setdescripcion(detallecliente.getdescripcion());	
					detalleclienteLocal.setdebito_mone_local(detallecliente.getdebito_mone_local());	
					detalleclienteLocal.setcredito_mone_local(detallecliente.getcredito_mone_local());	
					detalleclienteLocal.setdebito_mone_extra(detallecliente.getdebito_mone_extra());	
					detalleclienteLocal.setcredito_mone_extra(detallecliente.getcredito_mone_extra());	
					detalleclienteLocal.setid_moneda(detallecliente.getid_moneda());	
					detalleclienteLocal.setcotizacion(detallecliente.getcotizacion());	
					detalleclienteLocal.setid_sucursal_movimiento(detallecliente.getid_sucursal_movimiento());	
					detalleclienteLocal.setid_tipo_transaccion_modulo(detallecliente.getid_tipo_transaccion_modulo());	
					detalleclienteLocal.setfecha_emision(detallecliente.getfecha_emision());	
					detalleclienteLocal.setbeneficiario(detallecliente.getbeneficiario());	
					detalleclienteLocal.setmonto_mone_local(detallecliente.getmonto_mone_local());	
					detalleclienteLocal.setmonto_mone_extra(detallecliente.getmonto_mone_extra());	
					detalleclienteLocal.setnumero_comprobante(detallecliente.getnumero_comprobante());	
					detalleclienteLocal.setid_estado_detalle_cliente(detallecliente.getid_estado_detalle_cliente());	
					
					
					detalleclienteLocal.setDetalleRecaps(detallecliente.getDetalleRecaps());
					
					existe=true;
					break;
				}
			}
			
			if(!detallecliente.getIsDeleted()) {
				if(!existe) {
					detalleclientes.add(detallecliente);
				}
			} else {
				if(detalleclienteEncontrado!=null && permiteQuitar)  {
					detalleclientes.remove(detalleclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleCliente detallecliente,List<DetalleCliente> detalleclientes) throws Exception {
		try	{			
			for(DetalleCliente detalleclienteLocal:detalleclientes) {
				if(detalleclienteLocal.getId().equals(detallecliente.getId())) {
					detalleclienteLocal.setIsSelected(detallecliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleCliente(List<DetalleCliente> detalleclientesAux) throws Exception {
		//this.detalleclientesAux=detalleclientesAux;
		
		for(DetalleCliente detalleclienteAux:detalleclientesAux) {
			if(detalleclienteAux.getIsChanged()) {
				detalleclienteAux.setIsChanged(false);
			}		
			
			if(detalleclienteAux.getIsNew()) {
				detalleclienteAux.setIsNew(false);
			}	
			
			if(detalleclienteAux.getIsDeleted()) {
				detalleclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleCliente(DetalleCliente detalleclienteAux) throws Exception {
		//this.detalleclienteAux=detalleclienteAux;
		
			if(detalleclienteAux.getIsChanged()) {
				detalleclienteAux.setIsChanged(false);
			}		
			
			if(detalleclienteAux.getIsNew()) {
				detalleclienteAux.setIsNew(false);
			}	
			
			if(detalleclienteAux.getIsDeleted()) {
				detalleclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleCliente detalleclienteAsignar,DetalleCliente detallecliente) throws Exception {
		detalleclienteAsignar.setId(detallecliente.getId());	
		detalleclienteAsignar.setVersionRow(detallecliente.getVersionRow());	
		detalleclienteAsignar.setid_empresa(detallecliente.getid_empresa());
		detalleclienteAsignar.setempresa_descripcion(detallecliente.getempresa_descripcion());	
		detalleclienteAsignar.setid_sucursal(detallecliente.getid_sucursal());
		detalleclienteAsignar.setsucursal_descripcion(detallecliente.getsucursal_descripcion());	
		detalleclienteAsignar.setid_ejercicio(detallecliente.getid_ejercicio());
		detalleclienteAsignar.setejercicio_descripcion(detallecliente.getejercicio_descripcion());	
		detalleclienteAsignar.setid_periodo(detallecliente.getid_periodo());
		detalleclienteAsignar.setperiodo_descripcion(detallecliente.getperiodo_descripcion());	
		detalleclienteAsignar.setid_anio(detallecliente.getid_anio());
		detalleclienteAsignar.setanio_descripcion(detallecliente.getanio_descripcion());	
		detalleclienteAsignar.setid_mes(detallecliente.getid_mes());
		detalleclienteAsignar.setmes_descripcion(detallecliente.getmes_descripcion());	
		detalleclienteAsignar.setid_modulo(detallecliente.getid_modulo());
		detalleclienteAsignar.setmodulo_descripcion(detallecliente.getmodulo_descripcion());	
		detalleclienteAsignar.setid_asiento_contable(detallecliente.getid_asiento_contable());
		detalleclienteAsignar.setasientocontable_descripcion(detallecliente.getasientocontable_descripcion());	
		detalleclienteAsignar.setid_cliente(detallecliente.getid_cliente());
		detalleclienteAsignar.setcliente_descripcion(detallecliente.getcliente_descripcion());	
		detalleclienteAsignar.setid_transaccion(detallecliente.getid_transaccion());
		detalleclienteAsignar.settransaccion_descripcion(detallecliente.gettransaccion_descripcion());	
		detalleclienteAsignar.setid_factura(detallecliente.getid_factura());
		detalleclienteAsignar.setfactura_descripcion(detallecliente.getfactura_descripcion());	
		detalleclienteAsignar.setnumero_factura(detallecliente.getnumero_factura());	
		detalleclienteAsignar.setfecha_vence(detallecliente.getfecha_vence());	
		detalleclienteAsignar.setdescripcion(detallecliente.getdescripcion());	
		detalleclienteAsignar.setdebito_mone_local(detallecliente.getdebito_mone_local());	
		detalleclienteAsignar.setcredito_mone_local(detallecliente.getcredito_mone_local());	
		detalleclienteAsignar.setdebito_mone_extra(detallecliente.getdebito_mone_extra());	
		detalleclienteAsignar.setcredito_mone_extra(detallecliente.getcredito_mone_extra());	
		detalleclienteAsignar.setid_moneda(detallecliente.getid_moneda());
		detalleclienteAsignar.setmoneda_descripcion(detallecliente.getmoneda_descripcion());	
		detalleclienteAsignar.setcotizacion(detallecliente.getcotizacion());	
		detalleclienteAsignar.setid_sucursal_movimiento(detallecliente.getid_sucursal_movimiento());
		detalleclienteAsignar.setsucursalmovimiento_descripcion(detallecliente.getsucursalmovimiento_descripcion());	
		detalleclienteAsignar.setid_tipo_transaccion_modulo(detallecliente.getid_tipo_transaccion_modulo());
		detalleclienteAsignar.settipotransaccionmodulo_descripcion(detallecliente.gettipotransaccionmodulo_descripcion());	
		detalleclienteAsignar.setfecha_emision(detallecliente.getfecha_emision());	
		detalleclienteAsignar.setbeneficiario(detallecliente.getbeneficiario());	
		detalleclienteAsignar.setmonto_mone_local(detallecliente.getmonto_mone_local());	
		detalleclienteAsignar.setmonto_mone_extra(detallecliente.getmonto_mone_extra());	
		detalleclienteAsignar.setnumero_comprobante(detallecliente.getnumero_comprobante());	
		detalleclienteAsignar.setid_estado_detalle_cliente(detallecliente.getid_estado_detalle_cliente());
		detalleclienteAsignar.setestadodetallecliente_descripcion(detallecliente.getestadodetallecliente_descripcion());	
	}
	
	public static void inicializarDetalleCliente(DetalleCliente detallecliente) throws Exception {
		try {
				detallecliente.setId(0L);	
					
				detallecliente.setid_empresa(-1L);	
				detallecliente.setid_sucursal(-1L);	
				detallecliente.setid_ejercicio(-1L);	
				detallecliente.setid_periodo(-1L);	
				detallecliente.setid_anio(null);	
				detallecliente.setid_mes(null);	
				detallecliente.setid_modulo(-1L);	
				detallecliente.setid_asiento_contable(-1L);	
				detallecliente.setid_cliente(-1L);	
				detallecliente.setid_transaccion(-1L);	
				detallecliente.setid_factura(-1L);	
				detallecliente.setnumero_factura("");	
				detallecliente.setfecha_vence(new Date());	
				detallecliente.setdescripcion("");	
				detallecliente.setdebito_mone_local(0.0);	
				detallecliente.setcredito_mone_local(0.0);	
				detallecliente.setdebito_mone_extra(0.0);	
				detallecliente.setcredito_mone_extra(0.0);	
				detallecliente.setid_moneda(-1L);	
				detallecliente.setcotizacion(0.0);	
				detallecliente.setid_sucursal_movimiento(-1L);	
				detallecliente.setid_tipo_transaccion_modulo(null);	
				detallecliente.setfecha_emision(new Date());	
				detallecliente.setbeneficiario("");	
				detallecliente.setmonto_mone_local(0.0);	
				detallecliente.setmonto_mone_extra(0.0);	
				detallecliente.setnumero_comprobante("");	
				detallecliente.setid_estado_detalle_cliente(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_MONTOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_MONTOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleClienteConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleCliente(String sTipo,Row row,Workbook workbook,DetalleCliente detallecliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getdebito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getcredito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getsucursalmovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getmonto_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getmonto_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecliente.getestadodetallecliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleCliente=" order by fecha_emision desc" ;
	
	public String getsFinalQueryDetalleCliente() {
		return this.sFinalQueryDetalleCliente;
	}
	
	public void setsFinalQueryDetalleCliente(String sFinalQueryDetalleCliente) {
		this.sFinalQueryDetalleCliente= sFinalQueryDetalleCliente;
	}
	
	public Border resaltarSeleccionarDetalleCliente=null;
	
	public Border setResaltarSeleccionarDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleCliente() {
		return this.resaltarSeleccionarDetalleCliente;
	}
	
	public void setResaltarSeleccionarDetalleCliente(Border borderResaltarSeleccionarDetalleCliente) {
		this.resaltarSeleccionarDetalleCliente= borderResaltarSeleccionarDetalleCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleCliente=null;
	public Boolean mostraridDetalleCliente=true;
	public Boolean activaridDetalleCliente=true;

	public Border resaltarid_empresaDetalleCliente=null;
	public Boolean mostrarid_empresaDetalleCliente=true;
	public Boolean activarid_empresaDetalleCliente=true;
	public Boolean cargarid_empresaDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleCliente=null;
	public Boolean mostrarid_sucursalDetalleCliente=true;
	public Boolean activarid_sucursalDetalleCliente=true;
	public Boolean cargarid_sucursalDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleCliente=null;
	public Boolean mostrarid_ejercicioDetalleCliente=true;
	public Boolean activarid_ejercicioDetalleCliente=true;
	public Boolean cargarid_ejercicioDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleCliente=null;
	public Boolean mostrarid_periodoDetalleCliente=true;
	public Boolean activarid_periodoDetalleCliente=true;
	public Boolean cargarid_periodoDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleCliente=null;
	public Boolean mostrarid_anioDetalleCliente=true;
	public Boolean activarid_anioDetalleCliente=false;
	public Boolean cargarid_anioDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleCliente=null;
	public Boolean mostrarid_mesDetalleCliente=true;
	public Boolean activarid_mesDetalleCliente=false;
	public Boolean cargarid_mesDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_moduloDetalleCliente=null;
	public Boolean mostrarid_moduloDetalleCliente=true;
	public Boolean activarid_moduloDetalleCliente=true;
	public Boolean cargarid_moduloDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDetalleCliente=null;
	public Boolean mostrarid_asiento_contableDetalleCliente=true;
	public Boolean activarid_asiento_contableDetalleCliente=true;
	public Boolean cargarid_asiento_contableDetalleCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteDetalleCliente=null;
	public Boolean mostrarid_clienteDetalleCliente=true;
	public Boolean activarid_clienteDetalleCliente=true;
	public Boolean cargarid_clienteDetalleCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccionDetalleCliente=null;
	public Boolean mostrarid_transaccionDetalleCliente=true;
	public Boolean activarid_transaccionDetalleCliente=true;
	public Boolean cargarid_transaccionDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_facturaDetalleCliente=null;
	public Boolean mostrarid_facturaDetalleCliente=true;
	public Boolean activarid_facturaDetalleCliente=true;
	public Boolean cargarid_facturaDetalleCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaDetalleCliente=false;//ConEventDepend=true

	public Border resaltarnumero_facturaDetalleCliente=null;
	public Boolean mostrarnumero_facturaDetalleCliente=true;
	public Boolean activarnumero_facturaDetalleCliente=true;

	public Border resaltarfecha_venceDetalleCliente=null;
	public Boolean mostrarfecha_venceDetalleCliente=true;
	public Boolean activarfecha_venceDetalleCliente=false;

	public Border resaltardescripcionDetalleCliente=null;
	public Boolean mostrardescripcionDetalleCliente=true;
	public Boolean activardescripcionDetalleCliente=true;

	public Border resaltardebito_mone_localDetalleCliente=null;
	public Boolean mostrardebito_mone_localDetalleCliente=true;
	public Boolean activardebito_mone_localDetalleCliente=true;

	public Border resaltarcredito_mone_localDetalleCliente=null;
	public Boolean mostrarcredito_mone_localDetalleCliente=true;
	public Boolean activarcredito_mone_localDetalleCliente=true;

	public Border resaltardebito_mone_extraDetalleCliente=null;
	public Boolean mostrardebito_mone_extraDetalleCliente=true;
	public Boolean activardebito_mone_extraDetalleCliente=true;

	public Border resaltarcredito_mone_extraDetalleCliente=null;
	public Boolean mostrarcredito_mone_extraDetalleCliente=true;
	public Boolean activarcredito_mone_extraDetalleCliente=true;

	public Border resaltarid_monedaDetalleCliente=null;
	public Boolean mostrarid_monedaDetalleCliente=true;
	public Boolean activarid_monedaDetalleCliente=true;
	public Boolean cargarid_monedaDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaDetalleCliente=false;//ConEventDepend=true

	public Border resaltarcotizacionDetalleCliente=null;
	public Boolean mostrarcotizacionDetalleCliente=true;
	public Boolean activarcotizacionDetalleCliente=true;

	public Border resaltarid_sucursal_movimientoDetalleCliente=null;
	public Boolean mostrarid_sucursal_movimientoDetalleCliente=true;
	public Boolean activarid_sucursal_movimientoDetalleCliente=false;
	public Boolean cargarid_sucursal_movimientoDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursal_movimientoDetalleCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloDetalleCliente=null;
	public Boolean mostrarid_tipo_transaccion_moduloDetalleCliente=true;
	public Boolean activarid_tipo_transaccion_moduloDetalleCliente=false;
	public Boolean cargarid_tipo_transaccion_moduloDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloDetalleCliente=false;//ConEventDepend=true

	public Border resaltarfecha_emisionDetalleCliente=null;
	public Boolean mostrarfecha_emisionDetalleCliente=true;
	public Boolean activarfecha_emisionDetalleCliente=false;

	public Border resaltarbeneficiarioDetalleCliente=null;
	public Boolean mostrarbeneficiarioDetalleCliente=true;
	public Boolean activarbeneficiarioDetalleCliente=false;

	public Border resaltarmonto_mone_localDetalleCliente=null;
	public Boolean mostrarmonto_mone_localDetalleCliente=true;
	public Boolean activarmonto_mone_localDetalleCliente=false;

	public Border resaltarmonto_mone_extraDetalleCliente=null;
	public Boolean mostrarmonto_mone_extraDetalleCliente=true;
	public Boolean activarmonto_mone_extraDetalleCliente=false;

	public Border resaltarnumero_comprobanteDetalleCliente=null;
	public Boolean mostrarnumero_comprobanteDetalleCliente=true;
	public Boolean activarnumero_comprobanteDetalleCliente=false;

	public Border resaltarid_estado_detalle_clienteDetalleCliente=null;
	public Boolean mostrarid_estado_detalle_clienteDetalleCliente=true;
	public Boolean activarid_estado_detalle_clienteDetalleCliente=false;
	public Boolean cargarid_estado_detalle_clienteDetalleCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_clienteDetalleCliente=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltaridDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleCliente() {
		return this.resaltaridDetalleCliente;
	}

	public void setResaltaridDetalleCliente(Border borderResaltar) {
		this.resaltaridDetalleCliente= borderResaltar;
	}

	public Boolean getMostraridDetalleCliente() {
		return this.mostraridDetalleCliente;
	}

	public void setMostraridDetalleCliente(Boolean mostraridDetalleCliente) {
		this.mostraridDetalleCliente= mostraridDetalleCliente;
	}

	public Boolean getActivaridDetalleCliente() {
		return this.activaridDetalleCliente;
	}

	public void setActivaridDetalleCliente(Boolean activaridDetalleCliente) {
		this.activaridDetalleCliente= activaridDetalleCliente;
	}

	public Border setResaltarid_empresaDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleCliente() {
		return this.resaltarid_empresaDetalleCliente;
	}

	public void setResaltarid_empresaDetalleCliente(Border borderResaltar) {
		this.resaltarid_empresaDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleCliente() {
		return this.mostrarid_empresaDetalleCliente;
	}

	public void setMostrarid_empresaDetalleCliente(Boolean mostrarid_empresaDetalleCliente) {
		this.mostrarid_empresaDetalleCliente= mostrarid_empresaDetalleCliente;
	}

	public Boolean getActivarid_empresaDetalleCliente() {
		return this.activarid_empresaDetalleCliente;
	}

	public void setActivarid_empresaDetalleCliente(Boolean activarid_empresaDetalleCliente) {
		this.activarid_empresaDetalleCliente= activarid_empresaDetalleCliente;
	}

	public Boolean getCargarid_empresaDetalleCliente() {
		return this.cargarid_empresaDetalleCliente;
	}

	public void setCargarid_empresaDetalleCliente(Boolean cargarid_empresaDetalleCliente) {
		this.cargarid_empresaDetalleCliente= cargarid_empresaDetalleCliente;
	}

	public Border setResaltarid_sucursalDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleCliente() {
		return this.resaltarid_sucursalDetalleCliente;
	}

	public void setResaltarid_sucursalDetalleCliente(Border borderResaltar) {
		this.resaltarid_sucursalDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleCliente() {
		return this.mostrarid_sucursalDetalleCliente;
	}

	public void setMostrarid_sucursalDetalleCliente(Boolean mostrarid_sucursalDetalleCliente) {
		this.mostrarid_sucursalDetalleCliente= mostrarid_sucursalDetalleCliente;
	}

	public Boolean getActivarid_sucursalDetalleCliente() {
		return this.activarid_sucursalDetalleCliente;
	}

	public void setActivarid_sucursalDetalleCliente(Boolean activarid_sucursalDetalleCliente) {
		this.activarid_sucursalDetalleCliente= activarid_sucursalDetalleCliente;
	}

	public Boolean getCargarid_sucursalDetalleCliente() {
		return this.cargarid_sucursalDetalleCliente;
	}

	public void setCargarid_sucursalDetalleCliente(Boolean cargarid_sucursalDetalleCliente) {
		this.cargarid_sucursalDetalleCliente= cargarid_sucursalDetalleCliente;
	}

	public Border setResaltarid_ejercicioDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleCliente() {
		return this.resaltarid_ejercicioDetalleCliente;
	}

	public void setResaltarid_ejercicioDetalleCliente(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleCliente() {
		return this.mostrarid_ejercicioDetalleCliente;
	}

	public void setMostrarid_ejercicioDetalleCliente(Boolean mostrarid_ejercicioDetalleCliente) {
		this.mostrarid_ejercicioDetalleCliente= mostrarid_ejercicioDetalleCliente;
	}

	public Boolean getActivarid_ejercicioDetalleCliente() {
		return this.activarid_ejercicioDetalleCliente;
	}

	public void setActivarid_ejercicioDetalleCliente(Boolean activarid_ejercicioDetalleCliente) {
		this.activarid_ejercicioDetalleCliente= activarid_ejercicioDetalleCliente;
	}

	public Boolean getCargarid_ejercicioDetalleCliente() {
		return this.cargarid_ejercicioDetalleCliente;
	}

	public void setCargarid_ejercicioDetalleCliente(Boolean cargarid_ejercicioDetalleCliente) {
		this.cargarid_ejercicioDetalleCliente= cargarid_ejercicioDetalleCliente;
	}

	public Border setResaltarid_periodoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleCliente() {
		return this.resaltarid_periodoDetalleCliente;
	}

	public void setResaltarid_periodoDetalleCliente(Border borderResaltar) {
		this.resaltarid_periodoDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleCliente() {
		return this.mostrarid_periodoDetalleCliente;
	}

	public void setMostrarid_periodoDetalleCliente(Boolean mostrarid_periodoDetalleCliente) {
		this.mostrarid_periodoDetalleCliente= mostrarid_periodoDetalleCliente;
	}

	public Boolean getActivarid_periodoDetalleCliente() {
		return this.activarid_periodoDetalleCliente;
	}

	public void setActivarid_periodoDetalleCliente(Boolean activarid_periodoDetalleCliente) {
		this.activarid_periodoDetalleCliente= activarid_periodoDetalleCliente;
	}

	public Boolean getCargarid_periodoDetalleCliente() {
		return this.cargarid_periodoDetalleCliente;
	}

	public void setCargarid_periodoDetalleCliente(Boolean cargarid_periodoDetalleCliente) {
		this.cargarid_periodoDetalleCliente= cargarid_periodoDetalleCliente;
	}

	public Border setResaltarid_anioDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleCliente() {
		return this.resaltarid_anioDetalleCliente;
	}

	public void setResaltarid_anioDetalleCliente(Border borderResaltar) {
		this.resaltarid_anioDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleCliente() {
		return this.mostrarid_anioDetalleCliente;
	}

	public void setMostrarid_anioDetalleCliente(Boolean mostrarid_anioDetalleCliente) {
		this.mostrarid_anioDetalleCliente= mostrarid_anioDetalleCliente;
	}

	public Boolean getActivarid_anioDetalleCliente() {
		return this.activarid_anioDetalleCliente;
	}

	public void setActivarid_anioDetalleCliente(Boolean activarid_anioDetalleCliente) {
		this.activarid_anioDetalleCliente= activarid_anioDetalleCliente;
	}

	public Boolean getCargarid_anioDetalleCliente() {
		return this.cargarid_anioDetalleCliente;
	}

	public void setCargarid_anioDetalleCliente(Boolean cargarid_anioDetalleCliente) {
		this.cargarid_anioDetalleCliente= cargarid_anioDetalleCliente;
	}

	public Border setResaltarid_mesDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleCliente() {
		return this.resaltarid_mesDetalleCliente;
	}

	public void setResaltarid_mesDetalleCliente(Border borderResaltar) {
		this.resaltarid_mesDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleCliente() {
		return this.mostrarid_mesDetalleCliente;
	}

	public void setMostrarid_mesDetalleCliente(Boolean mostrarid_mesDetalleCliente) {
		this.mostrarid_mesDetalleCliente= mostrarid_mesDetalleCliente;
	}

	public Boolean getActivarid_mesDetalleCliente() {
		return this.activarid_mesDetalleCliente;
	}

	public void setActivarid_mesDetalleCliente(Boolean activarid_mesDetalleCliente) {
		this.activarid_mesDetalleCliente= activarid_mesDetalleCliente;
	}

	public Boolean getCargarid_mesDetalleCliente() {
		return this.cargarid_mesDetalleCliente;
	}

	public void setCargarid_mesDetalleCliente(Boolean cargarid_mesDetalleCliente) {
		this.cargarid_mesDetalleCliente= cargarid_mesDetalleCliente;
	}

	public Border setResaltarid_moduloDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_moduloDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDetalleCliente() {
		return this.resaltarid_moduloDetalleCliente;
	}

	public void setResaltarid_moduloDetalleCliente(Border borderResaltar) {
		this.resaltarid_moduloDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_moduloDetalleCliente() {
		return this.mostrarid_moduloDetalleCliente;
	}

	public void setMostrarid_moduloDetalleCliente(Boolean mostrarid_moduloDetalleCliente) {
		this.mostrarid_moduloDetalleCliente= mostrarid_moduloDetalleCliente;
	}

	public Boolean getActivarid_moduloDetalleCliente() {
		return this.activarid_moduloDetalleCliente;
	}

	public void setActivarid_moduloDetalleCliente(Boolean activarid_moduloDetalleCliente) {
		this.activarid_moduloDetalleCliente= activarid_moduloDetalleCliente;
	}

	public Boolean getCargarid_moduloDetalleCliente() {
		return this.cargarid_moduloDetalleCliente;
	}

	public void setCargarid_moduloDetalleCliente(Boolean cargarid_moduloDetalleCliente) {
		this.cargarid_moduloDetalleCliente= cargarid_moduloDetalleCliente;
	}

	public Border setResaltarid_asiento_contableDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetalleCliente() {
		return this.resaltarid_asiento_contableDetalleCliente;
	}

	public void setResaltarid_asiento_contableDetalleCliente(Border borderResaltar) {
		this.resaltarid_asiento_contableDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetalleCliente() {
		return this.mostrarid_asiento_contableDetalleCliente;
	}

	public void setMostrarid_asiento_contableDetalleCliente(Boolean mostrarid_asiento_contableDetalleCliente) {
		this.mostrarid_asiento_contableDetalleCliente= mostrarid_asiento_contableDetalleCliente;
	}

	public Boolean getActivarid_asiento_contableDetalleCliente() {
		return this.activarid_asiento_contableDetalleCliente;
	}

	public void setActivarid_asiento_contableDetalleCliente(Boolean activarid_asiento_contableDetalleCliente) {
		this.activarid_asiento_contableDetalleCliente= activarid_asiento_contableDetalleCliente;
	}

	public Boolean getCargarid_asiento_contableDetalleCliente() {
		return this.cargarid_asiento_contableDetalleCliente;
	}

	public void setCargarid_asiento_contableDetalleCliente(Boolean cargarid_asiento_contableDetalleCliente) {
		this.cargarid_asiento_contableDetalleCliente= cargarid_asiento_contableDetalleCliente;
	}

	public Border setResaltarid_clienteDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteDetalleCliente() {
		return this.resaltarid_clienteDetalleCliente;
	}

	public void setResaltarid_clienteDetalleCliente(Border borderResaltar) {
		this.resaltarid_clienteDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteDetalleCliente() {
		return this.mostrarid_clienteDetalleCliente;
	}

	public void setMostrarid_clienteDetalleCliente(Boolean mostrarid_clienteDetalleCliente) {
		this.mostrarid_clienteDetalleCliente= mostrarid_clienteDetalleCliente;
	}

	public Boolean getActivarid_clienteDetalleCliente() {
		return this.activarid_clienteDetalleCliente;
	}

	public void setActivarid_clienteDetalleCliente(Boolean activarid_clienteDetalleCliente) {
		this.activarid_clienteDetalleCliente= activarid_clienteDetalleCliente;
	}

	public Boolean getCargarid_clienteDetalleCliente() {
		return this.cargarid_clienteDetalleCliente;
	}

	public void setCargarid_clienteDetalleCliente(Boolean cargarid_clienteDetalleCliente) {
		this.cargarid_clienteDetalleCliente= cargarid_clienteDetalleCliente;
	}

	public Border setResaltarid_transaccionDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccionDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionDetalleCliente() {
		return this.resaltarid_transaccionDetalleCliente;
	}

	public void setResaltarid_transaccionDetalleCliente(Border borderResaltar) {
		this.resaltarid_transaccionDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccionDetalleCliente() {
		return this.mostrarid_transaccionDetalleCliente;
	}

	public void setMostrarid_transaccionDetalleCliente(Boolean mostrarid_transaccionDetalleCliente) {
		this.mostrarid_transaccionDetalleCliente= mostrarid_transaccionDetalleCliente;
	}

	public Boolean getActivarid_transaccionDetalleCliente() {
		return this.activarid_transaccionDetalleCliente;
	}

	public void setActivarid_transaccionDetalleCliente(Boolean activarid_transaccionDetalleCliente) {
		this.activarid_transaccionDetalleCliente= activarid_transaccionDetalleCliente;
	}

	public Boolean getCargarid_transaccionDetalleCliente() {
		return this.cargarid_transaccionDetalleCliente;
	}

	public void setCargarid_transaccionDetalleCliente(Boolean cargarid_transaccionDetalleCliente) {
		this.cargarid_transaccionDetalleCliente= cargarid_transaccionDetalleCliente;
	}

	public Border setResaltarid_facturaDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_facturaDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaDetalleCliente() {
		return this.resaltarid_facturaDetalleCliente;
	}

	public void setResaltarid_facturaDetalleCliente(Border borderResaltar) {
		this.resaltarid_facturaDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_facturaDetalleCliente() {
		return this.mostrarid_facturaDetalleCliente;
	}

	public void setMostrarid_facturaDetalleCliente(Boolean mostrarid_facturaDetalleCliente) {
		this.mostrarid_facturaDetalleCliente= mostrarid_facturaDetalleCliente;
	}

	public Boolean getActivarid_facturaDetalleCliente() {
		return this.activarid_facturaDetalleCliente;
	}

	public void setActivarid_facturaDetalleCliente(Boolean activarid_facturaDetalleCliente) {
		this.activarid_facturaDetalleCliente= activarid_facturaDetalleCliente;
	}

	public Boolean getCargarid_facturaDetalleCliente() {
		return this.cargarid_facturaDetalleCliente;
	}

	public void setCargarid_facturaDetalleCliente(Boolean cargarid_facturaDetalleCliente) {
		this.cargarid_facturaDetalleCliente= cargarid_facturaDetalleCliente;
	}

	public Border setResaltarnumero_facturaDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaDetalleCliente() {
		return this.resaltarnumero_facturaDetalleCliente;
	}

	public void setResaltarnumero_facturaDetalleCliente(Border borderResaltar) {
		this.resaltarnumero_facturaDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaDetalleCliente() {
		return this.mostrarnumero_facturaDetalleCliente;
	}

	public void setMostrarnumero_facturaDetalleCliente(Boolean mostrarnumero_facturaDetalleCliente) {
		this.mostrarnumero_facturaDetalleCliente= mostrarnumero_facturaDetalleCliente;
	}

	public Boolean getActivarnumero_facturaDetalleCliente() {
		return this.activarnumero_facturaDetalleCliente;
	}

	public void setActivarnumero_facturaDetalleCliente(Boolean activarnumero_facturaDetalleCliente) {
		this.activarnumero_facturaDetalleCliente= activarnumero_facturaDetalleCliente;
	}

	public Border setResaltarfecha_venceDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_venceDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceDetalleCliente() {
		return this.resaltarfecha_venceDetalleCliente;
	}

	public void setResaltarfecha_venceDetalleCliente(Border borderResaltar) {
		this.resaltarfecha_venceDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_venceDetalleCliente() {
		return this.mostrarfecha_venceDetalleCliente;
	}

	public void setMostrarfecha_venceDetalleCliente(Boolean mostrarfecha_venceDetalleCliente) {
		this.mostrarfecha_venceDetalleCliente= mostrarfecha_venceDetalleCliente;
	}

	public Boolean getActivarfecha_venceDetalleCliente() {
		return this.activarfecha_venceDetalleCliente;
	}

	public void setActivarfecha_venceDetalleCliente(Boolean activarfecha_venceDetalleCliente) {
		this.activarfecha_venceDetalleCliente= activarfecha_venceDetalleCliente;
	}

	public Border setResaltardescripcionDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleCliente() {
		return this.resaltardescripcionDetalleCliente;
	}

	public void setResaltardescripcionDetalleCliente(Border borderResaltar) {
		this.resaltardescripcionDetalleCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleCliente() {
		return this.mostrardescripcionDetalleCliente;
	}

	public void setMostrardescripcionDetalleCliente(Boolean mostrardescripcionDetalleCliente) {
		this.mostrardescripcionDetalleCliente= mostrardescripcionDetalleCliente;
	}

	public Boolean getActivardescripcionDetalleCliente() {
		return this.activardescripcionDetalleCliente;
	}

	public void setActivardescripcionDetalleCliente(Boolean activardescripcionDetalleCliente) {
		this.activardescripcionDetalleCliente= activardescripcionDetalleCliente;
	}

	public Border setResaltardebito_mone_localDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localDetalleCliente() {
		return this.resaltardebito_mone_localDetalleCliente;
	}

	public void setResaltardebito_mone_localDetalleCliente(Border borderResaltar) {
		this.resaltardebito_mone_localDetalleCliente= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localDetalleCliente() {
		return this.mostrardebito_mone_localDetalleCliente;
	}

	public void setMostrardebito_mone_localDetalleCliente(Boolean mostrardebito_mone_localDetalleCliente) {
		this.mostrardebito_mone_localDetalleCliente= mostrardebito_mone_localDetalleCliente;
	}

	public Boolean getActivardebito_mone_localDetalleCliente() {
		return this.activardebito_mone_localDetalleCliente;
	}

	public void setActivardebito_mone_localDetalleCliente(Boolean activardebito_mone_localDetalleCliente) {
		this.activardebito_mone_localDetalleCliente= activardebito_mone_localDetalleCliente;
	}

	public Border setResaltarcredito_mone_localDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localDetalleCliente() {
		return this.resaltarcredito_mone_localDetalleCliente;
	}

	public void setResaltarcredito_mone_localDetalleCliente(Border borderResaltar) {
		this.resaltarcredito_mone_localDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localDetalleCliente() {
		return this.mostrarcredito_mone_localDetalleCliente;
	}

	public void setMostrarcredito_mone_localDetalleCliente(Boolean mostrarcredito_mone_localDetalleCliente) {
		this.mostrarcredito_mone_localDetalleCliente= mostrarcredito_mone_localDetalleCliente;
	}

	public Boolean getActivarcredito_mone_localDetalleCliente() {
		return this.activarcredito_mone_localDetalleCliente;
	}

	public void setActivarcredito_mone_localDetalleCliente(Boolean activarcredito_mone_localDetalleCliente) {
		this.activarcredito_mone_localDetalleCliente= activarcredito_mone_localDetalleCliente;
	}

	public Border setResaltardebito_mone_extraDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltardebito_mone_extraDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_extraDetalleCliente() {
		return this.resaltardebito_mone_extraDetalleCliente;
	}

	public void setResaltardebito_mone_extraDetalleCliente(Border borderResaltar) {
		this.resaltardebito_mone_extraDetalleCliente= borderResaltar;
	}

	public Boolean getMostrardebito_mone_extraDetalleCliente() {
		return this.mostrardebito_mone_extraDetalleCliente;
	}

	public void setMostrardebito_mone_extraDetalleCliente(Boolean mostrardebito_mone_extraDetalleCliente) {
		this.mostrardebito_mone_extraDetalleCliente= mostrardebito_mone_extraDetalleCliente;
	}

	public Boolean getActivardebito_mone_extraDetalleCliente() {
		return this.activardebito_mone_extraDetalleCliente;
	}

	public void setActivardebito_mone_extraDetalleCliente(Boolean activardebito_mone_extraDetalleCliente) {
		this.activardebito_mone_extraDetalleCliente= activardebito_mone_extraDetalleCliente;
	}

	public Border setResaltarcredito_mone_extraDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_extraDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_extraDetalleCliente() {
		return this.resaltarcredito_mone_extraDetalleCliente;
	}

	public void setResaltarcredito_mone_extraDetalleCliente(Border borderResaltar) {
		this.resaltarcredito_mone_extraDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_extraDetalleCliente() {
		return this.mostrarcredito_mone_extraDetalleCliente;
	}

	public void setMostrarcredito_mone_extraDetalleCliente(Boolean mostrarcredito_mone_extraDetalleCliente) {
		this.mostrarcredito_mone_extraDetalleCliente= mostrarcredito_mone_extraDetalleCliente;
	}

	public Boolean getActivarcredito_mone_extraDetalleCliente() {
		return this.activarcredito_mone_extraDetalleCliente;
	}

	public void setActivarcredito_mone_extraDetalleCliente(Boolean activarcredito_mone_extraDetalleCliente) {
		this.activarcredito_mone_extraDetalleCliente= activarcredito_mone_extraDetalleCliente;
	}

	public Border setResaltarid_monedaDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_monedaDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaDetalleCliente() {
		return this.resaltarid_monedaDetalleCliente;
	}

	public void setResaltarid_monedaDetalleCliente(Border borderResaltar) {
		this.resaltarid_monedaDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_monedaDetalleCliente() {
		return this.mostrarid_monedaDetalleCliente;
	}

	public void setMostrarid_monedaDetalleCliente(Boolean mostrarid_monedaDetalleCliente) {
		this.mostrarid_monedaDetalleCliente= mostrarid_monedaDetalleCliente;
	}

	public Boolean getActivarid_monedaDetalleCliente() {
		return this.activarid_monedaDetalleCliente;
	}

	public void setActivarid_monedaDetalleCliente(Boolean activarid_monedaDetalleCliente) {
		this.activarid_monedaDetalleCliente= activarid_monedaDetalleCliente;
	}

	public Boolean getCargarid_monedaDetalleCliente() {
		return this.cargarid_monedaDetalleCliente;
	}

	public void setCargarid_monedaDetalleCliente(Boolean cargarid_monedaDetalleCliente) {
		this.cargarid_monedaDetalleCliente= cargarid_monedaDetalleCliente;
	}

	public Border setResaltarcotizacionDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarcotizacionDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionDetalleCliente() {
		return this.resaltarcotizacionDetalleCliente;
	}

	public void setResaltarcotizacionDetalleCliente(Border borderResaltar) {
		this.resaltarcotizacionDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarcotizacionDetalleCliente() {
		return this.mostrarcotizacionDetalleCliente;
	}

	public void setMostrarcotizacionDetalleCliente(Boolean mostrarcotizacionDetalleCliente) {
		this.mostrarcotizacionDetalleCliente= mostrarcotizacionDetalleCliente;
	}

	public Boolean getActivarcotizacionDetalleCliente() {
		return this.activarcotizacionDetalleCliente;
	}

	public void setActivarcotizacionDetalleCliente(Boolean activarcotizacionDetalleCliente) {
		this.activarcotizacionDetalleCliente= activarcotizacionDetalleCliente;
	}

	public Border setResaltarid_sucursal_movimientoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_sucursal_movimientoDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursal_movimientoDetalleCliente() {
		return this.resaltarid_sucursal_movimientoDetalleCliente;
	}

	public void setResaltarid_sucursal_movimientoDetalleCliente(Border borderResaltar) {
		this.resaltarid_sucursal_movimientoDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_sucursal_movimientoDetalleCliente() {
		return this.mostrarid_sucursal_movimientoDetalleCliente;
	}

	public void setMostrarid_sucursal_movimientoDetalleCliente(Boolean mostrarid_sucursal_movimientoDetalleCliente) {
		this.mostrarid_sucursal_movimientoDetalleCliente= mostrarid_sucursal_movimientoDetalleCliente;
	}

	public Boolean getActivarid_sucursal_movimientoDetalleCliente() {
		return this.activarid_sucursal_movimientoDetalleCliente;
	}

	public void setActivarid_sucursal_movimientoDetalleCliente(Boolean activarid_sucursal_movimientoDetalleCliente) {
		this.activarid_sucursal_movimientoDetalleCliente= activarid_sucursal_movimientoDetalleCliente;
	}

	public Boolean getCargarid_sucursal_movimientoDetalleCliente() {
		return this.cargarid_sucursal_movimientoDetalleCliente;
	}

	public void setCargarid_sucursal_movimientoDetalleCliente(Boolean cargarid_sucursal_movimientoDetalleCliente) {
		this.cargarid_sucursal_movimientoDetalleCliente= cargarid_sucursal_movimientoDetalleCliente;
	}

	public Border setResaltarid_tipo_transaccion_moduloDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloDetalleCliente() {
		return this.resaltarid_tipo_transaccion_moduloDetalleCliente;
	}

	public void setResaltarid_tipo_transaccion_moduloDetalleCliente(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloDetalleCliente() {
		return this.mostrarid_tipo_transaccion_moduloDetalleCliente;
	}

	public void setMostrarid_tipo_transaccion_moduloDetalleCliente(Boolean mostrarid_tipo_transaccion_moduloDetalleCliente) {
		this.mostrarid_tipo_transaccion_moduloDetalleCliente= mostrarid_tipo_transaccion_moduloDetalleCliente;
	}

	public Boolean getActivarid_tipo_transaccion_moduloDetalleCliente() {
		return this.activarid_tipo_transaccion_moduloDetalleCliente;
	}

	public void setActivarid_tipo_transaccion_moduloDetalleCliente(Boolean activarid_tipo_transaccion_moduloDetalleCliente) {
		this.activarid_tipo_transaccion_moduloDetalleCliente= activarid_tipo_transaccion_moduloDetalleCliente;
	}

	public Boolean getCargarid_tipo_transaccion_moduloDetalleCliente() {
		return this.cargarid_tipo_transaccion_moduloDetalleCliente;
	}

	public void setCargarid_tipo_transaccion_moduloDetalleCliente(Boolean cargarid_tipo_transaccion_moduloDetalleCliente) {
		this.cargarid_tipo_transaccion_moduloDetalleCliente= cargarid_tipo_transaccion_moduloDetalleCliente;
	}

	public Border setResaltarfecha_emisionDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionDetalleCliente() {
		return this.resaltarfecha_emisionDetalleCliente;
	}

	public void setResaltarfecha_emisionDetalleCliente(Border borderResaltar) {
		this.resaltarfecha_emisionDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionDetalleCliente() {
		return this.mostrarfecha_emisionDetalleCliente;
	}

	public void setMostrarfecha_emisionDetalleCliente(Boolean mostrarfecha_emisionDetalleCliente) {
		this.mostrarfecha_emisionDetalleCliente= mostrarfecha_emisionDetalleCliente;
	}

	public Boolean getActivarfecha_emisionDetalleCliente() {
		return this.activarfecha_emisionDetalleCliente;
	}

	public void setActivarfecha_emisionDetalleCliente(Boolean activarfecha_emisionDetalleCliente) {
		this.activarfecha_emisionDetalleCliente= activarfecha_emisionDetalleCliente;
	}

	public Border setResaltarbeneficiarioDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioDetalleCliente() {
		return this.resaltarbeneficiarioDetalleCliente;
	}

	public void setResaltarbeneficiarioDetalleCliente(Border borderResaltar) {
		this.resaltarbeneficiarioDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioDetalleCliente() {
		return this.mostrarbeneficiarioDetalleCliente;
	}

	public void setMostrarbeneficiarioDetalleCliente(Boolean mostrarbeneficiarioDetalleCliente) {
		this.mostrarbeneficiarioDetalleCliente= mostrarbeneficiarioDetalleCliente;
	}

	public Boolean getActivarbeneficiarioDetalleCliente() {
		return this.activarbeneficiarioDetalleCliente;
	}

	public void setActivarbeneficiarioDetalleCliente(Boolean activarbeneficiarioDetalleCliente) {
		this.activarbeneficiarioDetalleCliente= activarbeneficiarioDetalleCliente;
	}

	public Border setResaltarmonto_mone_localDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarmonto_mone_localDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_localDetalleCliente() {
		return this.resaltarmonto_mone_localDetalleCliente;
	}

	public void setResaltarmonto_mone_localDetalleCliente(Border borderResaltar) {
		this.resaltarmonto_mone_localDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_localDetalleCliente() {
		return this.mostrarmonto_mone_localDetalleCliente;
	}

	public void setMostrarmonto_mone_localDetalleCliente(Boolean mostrarmonto_mone_localDetalleCliente) {
		this.mostrarmonto_mone_localDetalleCliente= mostrarmonto_mone_localDetalleCliente;
	}

	public Boolean getActivarmonto_mone_localDetalleCliente() {
		return this.activarmonto_mone_localDetalleCliente;
	}

	public void setActivarmonto_mone_localDetalleCliente(Boolean activarmonto_mone_localDetalleCliente) {
		this.activarmonto_mone_localDetalleCliente= activarmonto_mone_localDetalleCliente;
	}

	public Border setResaltarmonto_mone_extraDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarmonto_mone_extraDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_extraDetalleCliente() {
		return this.resaltarmonto_mone_extraDetalleCliente;
	}

	public void setResaltarmonto_mone_extraDetalleCliente(Border borderResaltar) {
		this.resaltarmonto_mone_extraDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_extraDetalleCliente() {
		return this.mostrarmonto_mone_extraDetalleCliente;
	}

	public void setMostrarmonto_mone_extraDetalleCliente(Boolean mostrarmonto_mone_extraDetalleCliente) {
		this.mostrarmonto_mone_extraDetalleCliente= mostrarmonto_mone_extraDetalleCliente;
	}

	public Boolean getActivarmonto_mone_extraDetalleCliente() {
		return this.activarmonto_mone_extraDetalleCliente;
	}

	public void setActivarmonto_mone_extraDetalleCliente(Boolean activarmonto_mone_extraDetalleCliente) {
		this.activarmonto_mone_extraDetalleCliente= activarmonto_mone_extraDetalleCliente;
	}

	public Border setResaltarnumero_comprobanteDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleCliente() {
		return this.resaltarnumero_comprobanteDetalleCliente;
	}

	public void setResaltarnumero_comprobanteDetalleCliente(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleCliente() {
		return this.mostrarnumero_comprobanteDetalleCliente;
	}

	public void setMostrarnumero_comprobanteDetalleCliente(Boolean mostrarnumero_comprobanteDetalleCliente) {
		this.mostrarnumero_comprobanteDetalleCliente= mostrarnumero_comprobanteDetalleCliente;
	}

	public Boolean getActivarnumero_comprobanteDetalleCliente() {
		return this.activarnumero_comprobanteDetalleCliente;
	}

	public void setActivarnumero_comprobanteDetalleCliente(Boolean activarnumero_comprobanteDetalleCliente) {
		this.activarnumero_comprobanteDetalleCliente= activarnumero_comprobanteDetalleCliente;
	}

	public Border setResaltarid_estado_detalle_clienteDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_detalle_clienteDetalleCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_clienteDetalleCliente() {
		return this.resaltarid_estado_detalle_clienteDetalleCliente;
	}

	public void setResaltarid_estado_detalle_clienteDetalleCliente(Border borderResaltar) {
		this.resaltarid_estado_detalle_clienteDetalleCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_clienteDetalleCliente() {
		return this.mostrarid_estado_detalle_clienteDetalleCliente;
	}

	public void setMostrarid_estado_detalle_clienteDetalleCliente(Boolean mostrarid_estado_detalle_clienteDetalleCliente) {
		this.mostrarid_estado_detalle_clienteDetalleCliente= mostrarid_estado_detalle_clienteDetalleCliente;
	}

	public Boolean getActivarid_estado_detalle_clienteDetalleCliente() {
		return this.activarid_estado_detalle_clienteDetalleCliente;
	}

	public void setActivarid_estado_detalle_clienteDetalleCliente(Boolean activarid_estado_detalle_clienteDetalleCliente) {
		this.activarid_estado_detalle_clienteDetalleCliente= activarid_estado_detalle_clienteDetalleCliente;
	}

	public Boolean getCargarid_estado_detalle_clienteDetalleCliente() {
		return this.cargarid_estado_detalle_clienteDetalleCliente;
	}

	public void setCargarid_estado_detalle_clienteDetalleCliente(Boolean cargarid_estado_detalle_clienteDetalleCliente) {
		this.cargarid_estado_detalle_clienteDetalleCliente= cargarid_estado_detalle_clienteDetalleCliente;
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
		
		
		this.setMostraridDetalleCliente(esInicial);
		this.setMostrarid_empresaDetalleCliente(esInicial);
		this.setMostrarid_sucursalDetalleCliente(esInicial);
		this.setMostrarid_ejercicioDetalleCliente(esInicial);
		this.setMostrarid_periodoDetalleCliente(esInicial);
		this.setMostrarid_anioDetalleCliente(esInicial);
		this.setMostrarid_mesDetalleCliente(esInicial);
		this.setMostrarid_moduloDetalleCliente(esInicial);
		this.setMostrarid_asiento_contableDetalleCliente(esInicial);
		this.setMostrarid_clienteDetalleCliente(esInicial);
		this.setMostrarid_transaccionDetalleCliente(esInicial);
		this.setMostrarid_facturaDetalleCliente(esInicial);
		this.setMostrarnumero_facturaDetalleCliente(esInicial);
		this.setMostrarfecha_venceDetalleCliente(esInicial);
		this.setMostrardescripcionDetalleCliente(esInicial);
		this.setMostrardebito_mone_localDetalleCliente(esInicial);
		this.setMostrarcredito_mone_localDetalleCliente(esInicial);
		this.setMostrardebito_mone_extraDetalleCliente(esInicial);
		this.setMostrarcredito_mone_extraDetalleCliente(esInicial);
		this.setMostrarid_monedaDetalleCliente(esInicial);
		this.setMostrarcotizacionDetalleCliente(esInicial);
		this.setMostrarid_sucursal_movimientoDetalleCliente(esInicial);
		this.setMostrarid_tipo_transaccion_moduloDetalleCliente(esInicial);
		this.setMostrarfecha_emisionDetalleCliente(esInicial);
		this.setMostrarbeneficiarioDetalleCliente(esInicial);
		this.setMostrarmonto_mone_localDetalleCliente(esInicial);
		this.setMostrarmonto_mone_extraDetalleCliente(esInicial);
		this.setMostrarnumero_comprobanteDetalleCliente(esInicial);
		this.setMostrarid_estado_detalle_clienteDetalleCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleClienteConstantesFunciones.ID)) {
				this.setMostraridDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setMostrardebito_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setMostrarcredito_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setMostrarid_sucursal_movimientoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.MONTOMONELOCAL)) {
				this.setMostrarmonto_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.MONTOMONEEXTRA)) {
				this.setMostrarmonto_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setMostrarid_estado_detalle_clienteDetalleCliente(esAsigna);
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
		
		
		this.setActivaridDetalleCliente(esInicial);
		this.setActivarid_empresaDetalleCliente(esInicial);
		this.setActivarid_sucursalDetalleCliente(esInicial);
		this.setActivarid_ejercicioDetalleCliente(esInicial);
		this.setActivarid_periodoDetalleCliente(esInicial);
		this.setActivarid_anioDetalleCliente(esInicial);
		this.setActivarid_mesDetalleCliente(esInicial);
		this.setActivarid_moduloDetalleCliente(esInicial);
		this.setActivarid_asiento_contableDetalleCliente(esInicial);
		this.setActivarid_clienteDetalleCliente(esInicial);
		this.setActivarid_transaccionDetalleCliente(esInicial);
		this.setActivarid_facturaDetalleCliente(esInicial);
		this.setActivarnumero_facturaDetalleCliente(esInicial);
		this.setActivarfecha_venceDetalleCliente(esInicial);
		this.setActivardescripcionDetalleCliente(esInicial);
		this.setActivardebito_mone_localDetalleCliente(esInicial);
		this.setActivarcredito_mone_localDetalleCliente(esInicial);
		this.setActivardebito_mone_extraDetalleCliente(esInicial);
		this.setActivarcredito_mone_extraDetalleCliente(esInicial);
		this.setActivarid_monedaDetalleCliente(esInicial);
		this.setActivarcotizacionDetalleCliente(esInicial);
		this.setActivarid_sucursal_movimientoDetalleCliente(esInicial);
		this.setActivarid_tipo_transaccion_moduloDetalleCliente(esInicial);
		this.setActivarfecha_emisionDetalleCliente(esInicial);
		this.setActivarbeneficiarioDetalleCliente(esInicial);
		this.setActivarmonto_mone_localDetalleCliente(esInicial);
		this.setActivarmonto_mone_extraDetalleCliente(esInicial);
		this.setActivarnumero_comprobanteDetalleCliente(esInicial);
		this.setActivarid_estado_detalle_clienteDetalleCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleClienteConstantesFunciones.ID)) {
				this.setActivaridDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setActivardebito_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setActivarcredito_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setActivarid_sucursal_movimientoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.MONTOMONELOCAL)) {
				this.setActivarmonto_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.MONTOMONEEXTRA)) {
				this.setActivarmonto_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setActivarid_estado_detalle_clienteDetalleCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleCliente(esInicial);
		this.setResaltarid_empresaDetalleCliente(esInicial);
		this.setResaltarid_sucursalDetalleCliente(esInicial);
		this.setResaltarid_ejercicioDetalleCliente(esInicial);
		this.setResaltarid_periodoDetalleCliente(esInicial);
		this.setResaltarid_anioDetalleCliente(esInicial);
		this.setResaltarid_mesDetalleCliente(esInicial);
		this.setResaltarid_moduloDetalleCliente(esInicial);
		this.setResaltarid_asiento_contableDetalleCliente(esInicial);
		this.setResaltarid_clienteDetalleCliente(esInicial);
		this.setResaltarid_transaccionDetalleCliente(esInicial);
		this.setResaltarid_facturaDetalleCliente(esInicial);
		this.setResaltarnumero_facturaDetalleCliente(esInicial);
		this.setResaltarfecha_venceDetalleCliente(esInicial);
		this.setResaltardescripcionDetalleCliente(esInicial);
		this.setResaltardebito_mone_localDetalleCliente(esInicial);
		this.setResaltarcredito_mone_localDetalleCliente(esInicial);
		this.setResaltardebito_mone_extraDetalleCliente(esInicial);
		this.setResaltarcredito_mone_extraDetalleCliente(esInicial);
		this.setResaltarid_monedaDetalleCliente(esInicial);
		this.setResaltarcotizacionDetalleCliente(esInicial);
		this.setResaltarid_sucursal_movimientoDetalleCliente(esInicial);
		this.setResaltarid_tipo_transaccion_moduloDetalleCliente(esInicial);
		this.setResaltarfecha_emisionDetalleCliente(esInicial);
		this.setResaltarbeneficiarioDetalleCliente(esInicial);
		this.setResaltarmonto_mone_localDetalleCliente(esInicial);
		this.setResaltarmonto_mone_extraDetalleCliente(esInicial);
		this.setResaltarnumero_comprobanteDetalleCliente(esInicial);
		this.setResaltarid_estado_detalle_clienteDetalleCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleClienteConstantesFunciones.ID)) {
				this.setResaltaridDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setResaltardebito_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setResaltarcredito_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setResaltarid_sucursal_movimientoDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.MONTOMONELOCAL)) {
				this.setResaltarmonto_mone_localDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.MONTOMONEEXTRA)) {
				this.setResaltarmonto_mone_extraDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setResaltarid_estado_detalle_clienteDetalleCliente(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleRecapDetalleCliente=null;

	public Border getResaltarDetalleRecapDetalleCliente() {
		return this.resaltarDetalleRecapDetalleCliente;
	}

	public void setResaltarDetalleRecapDetalleCliente(Border borderResaltarDetalleRecap) {
		if(borderResaltarDetalleRecap!=null) {
			this.resaltarDetalleRecapDetalleCliente= borderResaltarDetalleRecap;
		}
	}

	public Border setResaltarDetalleRecapDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleRecap=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleclienteBeanSwingJInternalFrame.jTtoolBarDetalleCliente.setBorder(borderResaltarDetalleRecap);
			
		this.resaltarDetalleRecapDetalleCliente= borderResaltarDetalleRecap;

		 return borderResaltarDetalleRecap;
	}



	public Boolean mostrarDetalleRecapDetalleCliente=true;

	public Boolean getMostrarDetalleRecapDetalleCliente() {
		return this.mostrarDetalleRecapDetalleCliente;
	}

	public void setMostrarDetalleRecapDetalleCliente(Boolean visibilidadResaltarDetalleRecap) {
		this.mostrarDetalleRecapDetalleCliente= visibilidadResaltarDetalleRecap;
	}



	public Boolean activarDetalleRecapDetalleCliente=true;

	public Boolean gethabilitarResaltarDetalleRecapDetalleCliente() {
		return this.activarDetalleRecapDetalleCliente;
	}

	public void setActivarDetalleRecapDetalleCliente(Boolean habilitarResaltarDetalleRecap) {
		this.activarDetalleRecapDetalleCliente= habilitarResaltarDetalleRecap;
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

		this.setMostrarDetalleRecapDetalleCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRecap.class)) {
				this.setMostrarDetalleRecapDetalleCliente(esAsigna);
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

		this.setActivarDetalleRecapDetalleCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRecap.class)) {
				this.setActivarDetalleRecapDetalleCliente(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleRecapDetalleCliente(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRecap.class)) {
				this.setResaltarDetalleRecapDetalleCliente(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorFechaEmisionDetalleCliente=true;

	public Boolean getMostrarBusquedaPorFechaEmisionDetalleCliente() {
		return this.mostrarBusquedaPorFechaEmisionDetalleCliente;
	}

	public void setMostrarBusquedaPorFechaEmisionDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaEmisionDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaVenceDetalleCliente=true;

	public Boolean getMostrarBusquedaPorFechaVenceDetalleCliente() {
		return this.mostrarBusquedaPorFechaVenceDetalleCliente;
	}

	public void setMostrarBusquedaPorFechaVenceDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaVenceDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAsientoContableDetalleCliente=true;

	public Boolean getMostrarFK_IdAsientoContableDetalleCliente() {
		return this.mostrarFK_IdAsientoContableDetalleCliente;
	}

	public void setMostrarFK_IdAsientoContableDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteDetalleCliente=true;

	public Boolean getMostrarFK_IdClienteDetalleCliente() {
		return this.mostrarFK_IdClienteDetalleCliente;
	}

	public void setMostrarFK_IdClienteDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleCliente=true;

	public Boolean getMostrarFK_IdEjercicioDetalleCliente() {
		return this.mostrarFK_IdEjercicioDetalleCliente;
	}

	public void setMostrarFK_IdEjercicioDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleCliente=true;

	public Boolean getMostrarFK_IdEmpresaDetalleCliente() {
		return this.mostrarFK_IdEmpresaDetalleCliente;
	}

	public void setMostrarFK_IdEmpresaDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleClienteDetalleCliente=true;

	public Boolean getMostrarFK_IdEstadoDetalleClienteDetalleCliente() {
		return this.mostrarFK_IdEstadoDetalleClienteDetalleCliente;
	}

	public void setMostrarFK_IdEstadoDetalleClienteDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleClienteDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaDetalleCliente=true;

	public Boolean getMostrarFK_IdFacturaDetalleCliente() {
		return this.mostrarFK_IdFacturaDetalleCliente;
	}

	public void setMostrarFK_IdFacturaDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDetalleCliente=true;

	public Boolean getMostrarFK_IdModuloDetalleCliente() {
		return this.mostrarFK_IdModuloDetalleCliente;
	}

	public void setMostrarFK_IdModuloDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleCliente=true;

	public Boolean getMostrarFK_IdPeriodoDetalleCliente() {
		return this.mostrarFK_IdPeriodoDetalleCliente;
	}

	public void setMostrarFK_IdPeriodoDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleCliente=true;

	public Boolean getMostrarFK_IdSucursalDetalleCliente() {
		return this.mostrarFK_IdSucursalDetalleCliente;
	}

	public void setMostrarFK_IdSucursalDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloDetalleCliente=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloDetalleCliente() {
		return this.mostrarFK_IdTipoTransaccionModuloDetalleCliente;
	}

	public void setMostrarFK_IdTipoTransaccionModuloDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloDetalleCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionDetalleCliente=true;

	public Boolean getMostrarFK_IdTransaccionDetalleCliente() {
		return this.mostrarFK_IdTransaccionDetalleCliente;
	}

	public void setMostrarFK_IdTransaccionDetalleCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionDetalleCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorFechaEmisionDetalleCliente=true;

	public Boolean getActivarBusquedaPorFechaEmisionDetalleCliente() {
		return this.activarBusquedaPorFechaEmisionDetalleCliente;
	}

	public void setActivarBusquedaPorFechaEmisionDetalleCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaEmisionDetalleCliente= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaVenceDetalleCliente=true;

	public Boolean getActivarBusquedaPorFechaVenceDetalleCliente() {
		return this.activarBusquedaPorFechaVenceDetalleCliente;
	}

	public void setActivarBusquedaPorFechaVenceDetalleCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaVenceDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdAsientoContableDetalleCliente=true;

	public Boolean getActivarFK_IdAsientoContableDetalleCliente() {
		return this.activarFK_IdAsientoContableDetalleCliente;
	}

	public void setActivarFK_IdAsientoContableDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteDetalleCliente=true;

	public Boolean getActivarFK_IdClienteDetalleCliente() {
		return this.activarFK_IdClienteDetalleCliente;
	}

	public void setActivarFK_IdClienteDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleCliente=true;

	public Boolean getActivarFK_IdEjercicioDetalleCliente() {
		return this.activarFK_IdEjercicioDetalleCliente;
	}

	public void setActivarFK_IdEjercicioDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleCliente=true;

	public Boolean getActivarFK_IdEmpresaDetalleCliente() {
		return this.activarFK_IdEmpresaDetalleCliente;
	}

	public void setActivarFK_IdEmpresaDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleClienteDetalleCliente=true;

	public Boolean getActivarFK_IdEstadoDetalleClienteDetalleCliente() {
		return this.activarFK_IdEstadoDetalleClienteDetalleCliente;
	}

	public void setActivarFK_IdEstadoDetalleClienteDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleClienteDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaDetalleCliente=true;

	public Boolean getActivarFK_IdFacturaDetalleCliente() {
		return this.activarFK_IdFacturaDetalleCliente;
	}

	public void setActivarFK_IdFacturaDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDetalleCliente=true;

	public Boolean getActivarFK_IdModuloDetalleCliente() {
		return this.activarFK_IdModuloDetalleCliente;
	}

	public void setActivarFK_IdModuloDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleCliente=true;

	public Boolean getActivarFK_IdPeriodoDetalleCliente() {
		return this.activarFK_IdPeriodoDetalleCliente;
	}

	public void setActivarFK_IdPeriodoDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleCliente=true;

	public Boolean getActivarFK_IdSucursalDetalleCliente() {
		return this.activarFK_IdSucursalDetalleCliente;
	}

	public void setActivarFK_IdSucursalDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloDetalleCliente=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloDetalleCliente() {
		return this.activarFK_IdTipoTransaccionModuloDetalleCliente;
	}

	public void setActivarFK_IdTipoTransaccionModuloDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloDetalleCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionDetalleCliente=true;

	public Boolean getActivarFK_IdTransaccionDetalleCliente() {
		return this.activarFK_IdTransaccionDetalleCliente;
	}

	public void setActivarFK_IdTransaccionDetalleCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionDetalleCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorFechaEmisionDetalleCliente=null;

	public Border getResaltarBusquedaPorFechaEmisionDetalleCliente() {
		return this.resaltarBusquedaPorFechaEmisionDetalleCliente;
	}

	public void setResaltarBusquedaPorFechaEmisionDetalleCliente(Border borderResaltar) {
		this.resaltarBusquedaPorFechaEmisionDetalleCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaEmisionDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaEmisionDetalleCliente= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaVenceDetalleCliente=null;

	public Border getResaltarBusquedaPorFechaVenceDetalleCliente() {
		return this.resaltarBusquedaPorFechaVenceDetalleCliente;
	}

	public void setResaltarBusquedaPorFechaVenceDetalleCliente(Border borderResaltar) {
		this.resaltarBusquedaPorFechaVenceDetalleCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaVenceDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaVenceDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdAsientoContableDetalleCliente=null;

	public Border getResaltarFK_IdAsientoContableDetalleCliente() {
		return this.resaltarFK_IdAsientoContableDetalleCliente;
	}

	public void setResaltarFK_IdAsientoContableDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdClienteDetalleCliente=null;

	public Border getResaltarFK_IdClienteDetalleCliente() {
		return this.resaltarFK_IdClienteDetalleCliente;
	}

	public void setResaltarFK_IdClienteDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleCliente=null;

	public Border getResaltarFK_IdEjercicioDetalleCliente() {
		return this.resaltarFK_IdEjercicioDetalleCliente;
	}

	public void setResaltarFK_IdEjercicioDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleCliente=null;

	public Border getResaltarFK_IdEmpresaDetalleCliente() {
		return this.resaltarFK_IdEmpresaDetalleCliente;
	}

	public void setResaltarFK_IdEmpresaDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleClienteDetalleCliente=null;

	public Border getResaltarFK_IdEstadoDetalleClienteDetalleCliente() {
		return this.resaltarFK_IdEstadoDetalleClienteDetalleCliente;
	}

	public void setResaltarFK_IdEstadoDetalleClienteDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleClienteDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleClienteDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleClienteDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdFacturaDetalleCliente=null;

	public Border getResaltarFK_IdFacturaDetalleCliente() {
		return this.resaltarFK_IdFacturaDetalleCliente;
	}

	public void setResaltarFK_IdFacturaDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdFacturaDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdFacturaDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdModuloDetalleCliente=null;

	public Border getResaltarFK_IdModuloDetalleCliente() {
		return this.resaltarFK_IdModuloDetalleCliente;
	}

	public void setResaltarFK_IdModuloDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdModuloDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdModuloDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleCliente=null;

	public Border getResaltarFK_IdPeriodoDetalleCliente() {
		return this.resaltarFK_IdPeriodoDetalleCliente;
	}

	public void setResaltarFK_IdPeriodoDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleCliente=null;

	public Border getResaltarFK_IdSucursalDetalleCliente() {
		return this.resaltarFK_IdSucursalDetalleCliente;
	}

	public void setResaltarFK_IdSucursalDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloDetalleCliente=null;

	public Border getResaltarFK_IdTipoTransaccionModuloDetalleCliente() {
		return this.resaltarFK_IdTipoTransaccionModuloDetalleCliente;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloDetalleCliente= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionDetalleCliente=null;

	public Border getResaltarFK_IdTransaccionDetalleCliente() {
		return this.resaltarFK_IdTransaccionDetalleCliente;
	}

	public void setResaltarFK_IdTransaccionDetalleCliente(Border borderResaltar) {
		this.resaltarFK_IdTransaccionDetalleCliente= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionDetalleCliente(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleClienteBeanSwingJInternalFrame detalleclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionDetalleCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}