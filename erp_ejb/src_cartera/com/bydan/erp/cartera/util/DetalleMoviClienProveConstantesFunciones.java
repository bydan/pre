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


import com.bydan.erp.cartera.util.DetalleMoviClienProveConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleMoviClienProveParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleMoviClienProveParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleMoviClienProveConstantesFunciones extends DetalleMoviClienProveConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleMoviClienProve";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleMoviClienProve"+DetalleMoviClienProveConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleMoviClienProveHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleMoviClienProveHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleMoviClienProveConstantesFunciones.SCHEMA+"_"+DetalleMoviClienProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleMoviClienProveHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleMoviClienProveConstantesFunciones.SCHEMA+"_"+DetalleMoviClienProveConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleMoviClienProveConstantesFunciones.SCHEMA+"_"+DetalleMoviClienProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleMoviClienProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleMoviClienProveConstantesFunciones.SCHEMA+"_"+DetalleMoviClienProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMoviClienProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleMoviClienProveHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMoviClienProveConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMoviClienProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleMoviClienProveHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleMoviClienProveConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleMoviClienProveConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleMoviClienProveConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleMoviClienProveConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleMoviClienProveConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Movi Clien Prove";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleMoviClienProve";
	public static final String OBJECTNAME="detallemoviclienprove";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_movi_clien_prove";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallemoviclienprove from "+DetalleMoviClienProveConstantesFunciones.SPERSISTENCENAME+" detallemoviclienprove";
	public static String QUERYSELECTNATIVE="select "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".version_row,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_empresa,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_periodo,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_anio,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_mes,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_modulo,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".fecha_vence,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_cliente,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_factura,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".numero_factura,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".debito_mone_local,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".credito_mone_local,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".debito_mone_extra,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".credito_mone_extra,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_moneda,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".cotizacion,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".descripcion,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_sucursal_movimiento,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_estado_detalle_cliente,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".monto_mone_local,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".monto_mone_extra,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".numero_comprobante from "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME;//+" as "+DetalleMoviClienProveConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleMoviClienProveConstantesFuncionesAdditional detallemoviclienproveConstantesFuncionesAdditional=null;
	
	public DetalleMoviClienProveConstantesFuncionesAdditional getDetalleMoviClienProveConstantesFuncionesAdditional() {
		return this.detallemoviclienproveConstantesFuncionesAdditional;
	}
	
	public void setDetalleMoviClienProveConstantesFuncionesAdditional(DetalleMoviClienProveConstantesFuncionesAdditional detallemoviclienproveConstantesFuncionesAdditional) {
		try {
			this.detallemoviclienproveConstantesFuncionesAdditional=detallemoviclienproveConstantesFuncionesAdditional;
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
    public static final String FECHAVENCE= "fecha_vence";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DEBITOMONEEXTRA= "debito_mone_extra";
    public static final String CREDITOMONEEXTRA= "credito_mone_extra";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDSUCURSALMOVIMIENTO= "id_sucursal_movimiento";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDESTADODETALLECLIENTE= "id_estado_detalle_cliente";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String MONTOMONELOCAL= "monto_mone_local";
    public static final String MONTOMONEEXTRA= "monto_mone_extra";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
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
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento C.";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_IDCLIENTE= "Cliente/Prove";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_IDTRANSACCION= "Tipo";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DEBITOMONEEXTRA= "Debito Extra";
		public static final String LABEL_DEBITOMONEEXTRA_LOWER= "Debito Mone Extra";
    	public static final String LABEL_CREDITOMONEEXTRA= "Credito Extra";
		public static final String LABEL_CREDITOMONEEXTRA_LOWER= "Credito Mone Extra";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDSUCURSALMOVIMIENTO= "Sucursal Movimiento";
		public static final String LABEL_IDSUCURSALMOVIMIENTO_LOWER= "Sucursal Movimiento";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDESTADODETALLECLIENTE= "Estado Detalle Cliente";
		public static final String LABEL_IDESTADODETALLECLIENTE_LOWER= "Estado Detalle Cliente";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_MONTOMONELOCAL= "Monto Mone Local";
		public static final String LABEL_MONTOMONELOCAL_LOWER= "Monto Mone Local";
    	public static final String LABEL_MONTOMONEEXTRA= "Monto Mone Extra";
		public static final String LABEL_MONTOMONEEXTRA_LOWER= "Monto Mone Extra";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleMoviClienProveLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDANIO)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDMES)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDMODULO)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.FECHAVENCE)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDCLIENTE)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDFACTURA)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDTRANSACCION)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDMONEDA)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.COTIZACION)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.FECHAEMISION)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONELOCAL;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONEEXTRA;}
		if(sNombreColumna.equals(DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleMoviClienProveDescripcion(DetalleMoviClienProve detallemoviclienprove) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallemoviclienprove !=null/* && detallemoviclienprove.getId()!=0*/) {
			if(detallemoviclienprove.getId()!=null) {
				sDescripcion=detallemoviclienprove.getId().toString();
			}//detallemoviclienprovedetallemoviclienprove.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleMoviClienProveDescripcionDetallado(DetalleMoviClienProve detallemoviclienprove) {
		String sDescripcion="";
			
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.ID+"=";
		sDescripcion+=detallemoviclienprove.getId().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallemoviclienprove.getVersionRow().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallemoviclienprove.getid_empresa().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallemoviclienprove.getid_sucursal().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallemoviclienprove.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallemoviclienprove.getid_periodo().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallemoviclienprove.getid_anio().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDMES+"=";
		sDescripcion+=detallemoviclienprove.getid_mes().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDMODULO+"=";
		sDescripcion+=detallemoviclienprove.getid_modulo().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detallemoviclienprove.getid_asiento_contable().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=detallemoviclienprove.getfecha_vence().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=detallemoviclienprove.getid_cliente().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=detallemoviclienprove.getid_factura().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=detallemoviclienprove.getnumero_factura()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=detallemoviclienprove.getid_transaccion().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=detallemoviclienprove.getdebito_mone_local().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=detallemoviclienprove.getcredito_mone_local().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA+"=";
		sDescripcion+=detallemoviclienprove.getdebito_mone_extra().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA+"=";
		sDescripcion+=detallemoviclienprove.getcredito_mone_extra().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=detallemoviclienprove.getid_moneda().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.COTIZACION+"=";
		sDescripcion+=detallemoviclienprove.getcotizacion().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallemoviclienprove.getdescripcion()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO+"=";
		sDescripcion+=detallemoviclienprove.getid_sucursal_movimiento().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=detallemoviclienprove.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE+"=";
		sDescripcion+=detallemoviclienprove.getid_estado_detalle_cliente().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=detallemoviclienprove.getfecha_emision().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL+"=";
		sDescripcion+=detallemoviclienprove.getmonto_mone_local().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA+"=";
		sDescripcion+=detallemoviclienprove.getmonto_mone_extra().toString()+",";
		sDescripcion+=DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detallemoviclienprove.getnumero_comprobante()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleMoviClienProveDescripcion(DetalleMoviClienProve detallemoviclienprove,String sValor) throws Exception {			
		if(detallemoviclienprove !=null) {
			//detallemoviclienprovedetallemoviclienprove.getId().toString();
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento C.";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente/Prove";
		} else if(sNombreIndice.equals("FK_IdDetalleMoviClienProve")) {
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
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Tipo";
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
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento C.="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente/Prove="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleMoviClienProve(Long id_sucursal_movimiento) {
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
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienprove,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallemoviclienprove.setnumero_factura(detallemoviclienprove.getnumero_factura().trim());
		detallemoviclienprove.setdescripcion(detallemoviclienprove.getdescripcion().trim());
		detallemoviclienprove.setnumero_comprobante(detallemoviclienprove.getnumero_comprobante().trim());
	}
	
	public static void quitarEspaciosDetalleMoviClienProves(List<DetalleMoviClienProve> detallemoviclienproves,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleMoviClienProve detallemoviclienprove: detallemoviclienproves) {
			detallemoviclienprove.setnumero_factura(detallemoviclienprove.getnumero_factura().trim());
			detallemoviclienprove.setdescripcion(detallemoviclienprove.getdescripcion().trim());
			detallemoviclienprove.setnumero_comprobante(detallemoviclienprove.getnumero_comprobante().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienprove,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallemoviclienprove.getConCambioAuxiliar()) {
			detallemoviclienprove.setIsDeleted(detallemoviclienprove.getIsDeletedAuxiliar());	
			detallemoviclienprove.setIsNew(detallemoviclienprove.getIsNewAuxiliar());	
			detallemoviclienprove.setIsChanged(detallemoviclienprove.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallemoviclienprove.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallemoviclienprove.setIsDeletedAuxiliar(false);	
			detallemoviclienprove.setIsNewAuxiliar(false);	
			detallemoviclienprove.setIsChangedAuxiliar(false);
			
			detallemoviclienprove.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleMoviClienProves(List<DetalleMoviClienProve> detallemoviclienproves,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleMoviClienProve detallemoviclienprove : detallemoviclienproves) {
			if(conAsignarBase && detallemoviclienprove.getConCambioAuxiliar()) {
				detallemoviclienprove.setIsDeleted(detallemoviclienprove.getIsDeletedAuxiliar());	
				detallemoviclienprove.setIsNew(detallemoviclienprove.getIsNewAuxiliar());	
				detallemoviclienprove.setIsChanged(detallemoviclienprove.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallemoviclienprove.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallemoviclienprove.setIsDeletedAuxiliar(false);	
				detallemoviclienprove.setIsNewAuxiliar(false);	
				detallemoviclienprove.setIsChangedAuxiliar(false);
				
				detallemoviclienprove.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienprove,Boolean conEnteros) throws Exception  {
		detallemoviclienprove.setdebito_mone_local(0.0);
		detallemoviclienprove.setcredito_mone_local(0.0);
		detallemoviclienprove.setdebito_mone_extra(0.0);
		detallemoviclienprove.setcredito_mone_extra(0.0);
		detallemoviclienprove.setcotizacion(0.0);
		detallemoviclienprove.setmonto_mone_local(0.0);
		detallemoviclienprove.setmonto_mone_extra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleMoviClienProves(List<DetalleMoviClienProve> detallemoviclienproves,Boolean conEnteros) throws Exception  {
		
		for(DetalleMoviClienProve detallemoviclienprove: detallemoviclienproves) {
			detallemoviclienprove.setdebito_mone_local(0.0);
			detallemoviclienprove.setcredito_mone_local(0.0);
			detallemoviclienprove.setdebito_mone_extra(0.0);
			detallemoviclienprove.setcredito_mone_extra(0.0);
			detallemoviclienprove.setcotizacion(0.0);
			detallemoviclienprove.setmonto_mone_local(0.0);
			detallemoviclienprove.setmonto_mone_extra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleMoviClienProve(List<DetalleMoviClienProve> detallemoviclienproves,DetalleMoviClienProve detallemoviclienproveAux) throws Exception  {
		DetalleMoviClienProveConstantesFunciones.InicializarValoresDetalleMoviClienProve(detallemoviclienproveAux,true);
		
		for(DetalleMoviClienProve detallemoviclienprove: detallemoviclienproves) {
			if(detallemoviclienprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallemoviclienproveAux.setdebito_mone_local(detallemoviclienproveAux.getdebito_mone_local()+detallemoviclienprove.getdebito_mone_local());			
			detallemoviclienproveAux.setcredito_mone_local(detallemoviclienproveAux.getcredito_mone_local()+detallemoviclienprove.getcredito_mone_local());			
			detallemoviclienproveAux.setdebito_mone_extra(detallemoviclienproveAux.getdebito_mone_extra()+detallemoviclienprove.getdebito_mone_extra());			
			detallemoviclienproveAux.setcredito_mone_extra(detallemoviclienproveAux.getcredito_mone_extra()+detallemoviclienprove.getcredito_mone_extra());			
			detallemoviclienproveAux.setcotizacion(detallemoviclienproveAux.getcotizacion()+detallemoviclienprove.getcotizacion());			
			detallemoviclienproveAux.setmonto_mone_local(detallemoviclienproveAux.getmonto_mone_local()+detallemoviclienprove.getmonto_mone_local());			
			detallemoviclienproveAux.setmonto_mone_extra(detallemoviclienproveAux.getmonto_mone_extra()+detallemoviclienprove.getmonto_mone_extra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleMoviClienProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleMoviClienProveConstantesFunciones.getArrayColumnasGlobalesDetalleMoviClienProve(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleMoviClienProve(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMoviClienProveConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMoviClienProveConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMoviClienProveConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMoviClienProveConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMoviClienProveConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMoviClienProveConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMoviClienProveConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMoviClienProveConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMoviClienProveConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleMoviClienProveConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleMoviClienProveConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleMoviClienProve(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleMoviClienProve> detallemoviclienproves,DetalleMoviClienProve detallemoviclienprove,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleMoviClienProve detallemoviclienproveAux: detallemoviclienproves) {
			if(detallemoviclienproveAux!=null && detallemoviclienprove!=null) {
				if((detallemoviclienproveAux.getId()==null && detallemoviclienprove.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallemoviclienproveAux.getId()!=null && detallemoviclienprove.getId()!=null){
					if(detallemoviclienproveAux.getId().equals(detallemoviclienprove.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleMoviClienProve(List<DetalleMoviClienProve> detallemoviclienproves) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double debito_mone_extraTotal=0.0;
		Double credito_mone_extraTotal=0.0;
		Double cotizacionTotal=0.0;
		Double monto_mone_localTotal=0.0;
		Double monto_mone_extraTotal=0.0;
	
		for(DetalleMoviClienProve detallemoviclienprove: detallemoviclienproves) {			
			if(detallemoviclienprove.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=detallemoviclienprove.getdebito_mone_local();
			credito_mone_localTotal+=detallemoviclienprove.getcredito_mone_local();
			debito_mone_extraTotal+=detallemoviclienprove.getdebito_mone_extra();
			credito_mone_extraTotal+=detallemoviclienprove.getcredito_mone_extra();
			cotizacionTotal+=detallemoviclienprove.getcotizacion();
			monto_mone_localTotal+=detallemoviclienprove.getmonto_mone_local();
			monto_mone_extraTotal+=detallemoviclienprove.getmonto_mone_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		datoGeneral.setdValorDouble(debito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		datoGeneral.setdValorDouble(credito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMoviClienProveConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL);
		datoGeneral.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONELOCAL);
		datoGeneral.setdValorDouble(monto_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA);
		datoGeneral.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONEEXTRA);
		datoGeneral.setdValorDouble(monto_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleMoviClienProve() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_ID, DetalleMoviClienProveConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_VERSIONROW, DetalleMoviClienProveConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDEMPRESA, DetalleMoviClienProveConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSAL, DetalleMoviClienProveConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDEJERCICIO, DetalleMoviClienProveConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDPERIODO, DetalleMoviClienProveConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDANIO, DetalleMoviClienProveConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDMES, DetalleMoviClienProveConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDMODULO, DetalleMoviClienProveConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_FECHAVENCE, DetalleMoviClienProveConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDCLIENTE, DetalleMoviClienProveConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDFACTURA, DetalleMoviClienProveConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROFACTURA, DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDTRANSACCION, DetalleMoviClienProveConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONELOCAL, DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONELOCAL, DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONEEXTRA, DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONEEXTRA, DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDMONEDA, DetalleMoviClienProveConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_COTIZACION, DetalleMoviClienProveConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_DESCRIPCION, DetalleMoviClienProveConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO, DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE, DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_FECHAEMISION, DetalleMoviClienProveConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONELOCAL, DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONEEXTRA, DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleMoviClienProve() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMoviClienProve() throws Exception  {
		return DetalleMoviClienProveConstantesFunciones.getTiposSeleccionarDetalleMoviClienProve(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMoviClienProve(Boolean conFk) throws Exception  {
		return DetalleMoviClienProveConstantesFunciones.getTiposSeleccionarDetalleMoviClienProve(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleMoviClienProve(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONELOCAL);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONEEXTRA);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleMoviClienProve(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienproveAux) throws Exception {
		
			detallemoviclienproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallemoviclienproveAux.getEmpresa()));
			detallemoviclienproveAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemoviclienproveAux.getSucursal()));
			detallemoviclienproveAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallemoviclienproveAux.getEjercicio()));
			detallemoviclienproveAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallemoviclienproveAux.getPeriodo()));
			detallemoviclienproveAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallemoviclienproveAux.getAnio()));
			detallemoviclienproveAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallemoviclienproveAux.getMes()));
			detallemoviclienproveAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detallemoviclienproveAux.getModulo()));
			detallemoviclienproveAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallemoviclienproveAux.getAsientoContable()));
			detallemoviclienproveAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detallemoviclienproveAux.getCliente()));
			detallemoviclienproveAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detallemoviclienproveAux.getFactura()));
			detallemoviclienproveAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detallemoviclienproveAux.getTransaccion()));
			detallemoviclienproveAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(detallemoviclienproveAux.getMoneda()));
			detallemoviclienproveAux.setsucursalmovimiento_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemoviclienproveAux.getSucursalMovimiento()));
			detallemoviclienproveAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detallemoviclienproveAux.getTipoTransaccionModulo()));
			detallemoviclienproveAux.setestadodetallecliente_descripcion(EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(detallemoviclienproveAux.getEstadoDetalleCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleMoviClienProve(List<DetalleMoviClienProve> detallemoviclienprovesTemp) throws Exception {
		for(DetalleMoviClienProve detallemoviclienproveAux:detallemoviclienprovesTemp) {
			
			detallemoviclienproveAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallemoviclienproveAux.getEmpresa()));
			detallemoviclienproveAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemoviclienproveAux.getSucursal()));
			detallemoviclienproveAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallemoviclienproveAux.getEjercicio()));
			detallemoviclienproveAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallemoviclienproveAux.getPeriodo()));
			detallemoviclienproveAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallemoviclienproveAux.getAnio()));
			detallemoviclienproveAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallemoviclienproveAux.getMes()));
			detallemoviclienproveAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detallemoviclienproveAux.getModulo()));
			detallemoviclienproveAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallemoviclienproveAux.getAsientoContable()));
			detallemoviclienproveAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detallemoviclienproveAux.getCliente()));
			detallemoviclienproveAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detallemoviclienproveAux.getFactura()));
			detallemoviclienproveAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detallemoviclienproveAux.getTransaccion()));
			detallemoviclienproveAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(detallemoviclienproveAux.getMoneda()));
			detallemoviclienproveAux.setsucursalmovimiento_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallemoviclienproveAux.getSucursalMovimiento()));
			detallemoviclienproveAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detallemoviclienproveAux.getTipoTransaccionModulo()));
			detallemoviclienproveAux.setestadodetallecliente_descripcion(EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteDescripcion(detallemoviclienproveAux.getEstadoDetalleCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleMoviClienProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Transaccion.class));
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
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleMoviClienProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMoviClienProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleMoviClienProveConstantesFunciones.getClassesRelationshipsOfDetalleMoviClienProve(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleMoviClienProve(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleMoviClienProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleMoviClienProveConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleMoviClienProve(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleMoviClienProve(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleMoviClienProve detallemoviclienprove,List<DetalleMoviClienProve> detallemoviclienproves,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleMoviClienProve detallemoviclienproveEncontrado=null;
			
			for(DetalleMoviClienProve detallemoviclienproveLocal:detallemoviclienproves) {
				if(detallemoviclienproveLocal.getId().equals(detallemoviclienprove.getId())) {
					detallemoviclienproveEncontrado=detallemoviclienproveLocal;
					
					detallemoviclienproveLocal.setIsChanged(detallemoviclienprove.getIsChanged());
					detallemoviclienproveLocal.setIsNew(detallemoviclienprove.getIsNew());
					detallemoviclienproveLocal.setIsDeleted(detallemoviclienprove.getIsDeleted());
					
					detallemoviclienproveLocal.setGeneralEntityOriginal(detallemoviclienprove.getGeneralEntityOriginal());
					
					detallemoviclienproveLocal.setId(detallemoviclienprove.getId());	
					detallemoviclienproveLocal.setVersionRow(detallemoviclienprove.getVersionRow());	
					detallemoviclienproveLocal.setid_empresa(detallemoviclienprove.getid_empresa());	
					detallemoviclienproveLocal.setid_sucursal(detallemoviclienprove.getid_sucursal());	
					detallemoviclienproveLocal.setid_ejercicio(detallemoviclienprove.getid_ejercicio());	
					detallemoviclienproveLocal.setid_periodo(detallemoviclienprove.getid_periodo());	
					detallemoviclienproveLocal.setid_anio(detallemoviclienprove.getid_anio());	
					detallemoviclienproveLocal.setid_mes(detallemoviclienprove.getid_mes());	
					detallemoviclienproveLocal.setid_modulo(detallemoviclienprove.getid_modulo());	
					detallemoviclienproveLocal.setid_asiento_contable(detallemoviclienprove.getid_asiento_contable());	
					detallemoviclienproveLocal.setfecha_vence(detallemoviclienprove.getfecha_vence());	
					detallemoviclienproveLocal.setid_cliente(detallemoviclienprove.getid_cliente());	
					detallemoviclienproveLocal.setid_factura(detallemoviclienprove.getid_factura());	
					detallemoviclienproveLocal.setnumero_factura(detallemoviclienprove.getnumero_factura());	
					detallemoviclienproveLocal.setid_transaccion(detallemoviclienprove.getid_transaccion());	
					detallemoviclienproveLocal.setdebito_mone_local(detallemoviclienprove.getdebito_mone_local());	
					detallemoviclienproveLocal.setcredito_mone_local(detallemoviclienprove.getcredito_mone_local());	
					detallemoviclienproveLocal.setdebito_mone_extra(detallemoviclienprove.getdebito_mone_extra());	
					detallemoviclienproveLocal.setcredito_mone_extra(detallemoviclienprove.getcredito_mone_extra());	
					detallemoviclienproveLocal.setid_moneda(detallemoviclienprove.getid_moneda());	
					detallemoviclienproveLocal.setcotizacion(detallemoviclienprove.getcotizacion());	
					detallemoviclienproveLocal.setdescripcion(detallemoviclienprove.getdescripcion());	
					detallemoviclienproveLocal.setid_sucursal_movimiento(detallemoviclienprove.getid_sucursal_movimiento());	
					detallemoviclienproveLocal.setid_tipo_transaccion_modulo(detallemoviclienprove.getid_tipo_transaccion_modulo());	
					detallemoviclienproveLocal.setid_estado_detalle_cliente(detallemoviclienprove.getid_estado_detalle_cliente());	
					detallemoviclienproveLocal.setfecha_emision(detallemoviclienprove.getfecha_emision());	
					detallemoviclienproveLocal.setmonto_mone_local(detallemoviclienprove.getmonto_mone_local());	
					detallemoviclienproveLocal.setmonto_mone_extra(detallemoviclienprove.getmonto_mone_extra());	
					detallemoviclienproveLocal.setnumero_comprobante(detallemoviclienprove.getnumero_comprobante());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallemoviclienprove.getIsDeleted()) {
				if(!existe) {
					detallemoviclienproves.add(detallemoviclienprove);
				}
			} else {
				if(detallemoviclienproveEncontrado!=null && permiteQuitar)  {
					detallemoviclienproves.remove(detallemoviclienproveEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleMoviClienProve detallemoviclienprove,List<DetalleMoviClienProve> detallemoviclienproves) throws Exception {
		try	{			
			for(DetalleMoviClienProve detallemoviclienproveLocal:detallemoviclienproves) {
				if(detallemoviclienproveLocal.getId().equals(detallemoviclienprove.getId())) {
					detallemoviclienproveLocal.setIsSelected(detallemoviclienprove.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleMoviClienProve(List<DetalleMoviClienProve> detallemoviclienprovesAux) throws Exception {
		//this.detallemoviclienprovesAux=detallemoviclienprovesAux;
		
		for(DetalleMoviClienProve detallemoviclienproveAux:detallemoviclienprovesAux) {
			if(detallemoviclienproveAux.getIsChanged()) {
				detallemoviclienproveAux.setIsChanged(false);
			}		
			
			if(detallemoviclienproveAux.getIsNew()) {
				detallemoviclienproveAux.setIsNew(false);
			}	
			
			if(detallemoviclienproveAux.getIsDeleted()) {
				detallemoviclienproveAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienproveAux) throws Exception {
		//this.detallemoviclienproveAux=detallemoviclienproveAux;
		
			if(detallemoviclienproveAux.getIsChanged()) {
				detallemoviclienproveAux.setIsChanged(false);
			}		
			
			if(detallemoviclienproveAux.getIsNew()) {
				detallemoviclienproveAux.setIsNew(false);
			}	
			
			if(detallemoviclienproveAux.getIsDeleted()) {
				detallemoviclienproveAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleMoviClienProve detallemoviclienproveAsignar,DetalleMoviClienProve detallemoviclienprove) throws Exception {
		detallemoviclienproveAsignar.setId(detallemoviclienprove.getId());	
		detallemoviclienproveAsignar.setVersionRow(detallemoviclienprove.getVersionRow());	
		detallemoviclienproveAsignar.setid_empresa(detallemoviclienprove.getid_empresa());
		detallemoviclienproveAsignar.setempresa_descripcion(detallemoviclienprove.getempresa_descripcion());	
		detallemoviclienproveAsignar.setid_sucursal(detallemoviclienprove.getid_sucursal());
		detallemoviclienproveAsignar.setsucursal_descripcion(detallemoviclienprove.getsucursal_descripcion());	
		detallemoviclienproveAsignar.setid_ejercicio(detallemoviclienprove.getid_ejercicio());
		detallemoviclienproveAsignar.setejercicio_descripcion(detallemoviclienprove.getejercicio_descripcion());	
		detallemoviclienproveAsignar.setid_periodo(detallemoviclienprove.getid_periodo());
		detallemoviclienproveAsignar.setperiodo_descripcion(detallemoviclienprove.getperiodo_descripcion());	
		detallemoviclienproveAsignar.setid_anio(detallemoviclienprove.getid_anio());
		detallemoviclienproveAsignar.setanio_descripcion(detallemoviclienprove.getanio_descripcion());	
		detallemoviclienproveAsignar.setid_mes(detallemoviclienprove.getid_mes());
		detallemoviclienproveAsignar.setmes_descripcion(detallemoviclienprove.getmes_descripcion());	
		detallemoviclienproveAsignar.setid_modulo(detallemoviclienprove.getid_modulo());
		detallemoviclienproveAsignar.setmodulo_descripcion(detallemoviclienprove.getmodulo_descripcion());	
		detallemoviclienproveAsignar.setid_asiento_contable(detallemoviclienprove.getid_asiento_contable());
		detallemoviclienproveAsignar.setasientocontable_descripcion(detallemoviclienprove.getasientocontable_descripcion());	
		detallemoviclienproveAsignar.setfecha_vence(detallemoviclienprove.getfecha_vence());	
		detallemoviclienproveAsignar.setid_cliente(detallemoviclienprove.getid_cliente());
		detallemoviclienproveAsignar.setcliente_descripcion(detallemoviclienprove.getcliente_descripcion());	
		detallemoviclienproveAsignar.setid_factura(detallemoviclienprove.getid_factura());
		detallemoviclienproveAsignar.setfactura_descripcion(detallemoviclienprove.getfactura_descripcion());	
		detallemoviclienproveAsignar.setnumero_factura(detallemoviclienprove.getnumero_factura());	
		detallemoviclienproveAsignar.setid_transaccion(detallemoviclienprove.getid_transaccion());
		detallemoviclienproveAsignar.settransaccion_descripcion(detallemoviclienprove.gettransaccion_descripcion());	
		detallemoviclienproveAsignar.setdebito_mone_local(detallemoviclienprove.getdebito_mone_local());	
		detallemoviclienproveAsignar.setcredito_mone_local(detallemoviclienprove.getcredito_mone_local());	
		detallemoviclienproveAsignar.setdebito_mone_extra(detallemoviclienprove.getdebito_mone_extra());	
		detallemoviclienproveAsignar.setcredito_mone_extra(detallemoviclienprove.getcredito_mone_extra());	
		detallemoviclienproveAsignar.setid_moneda(detallemoviclienprove.getid_moneda());
		detallemoviclienproveAsignar.setmoneda_descripcion(detallemoviclienprove.getmoneda_descripcion());	
		detallemoviclienproveAsignar.setcotizacion(detallemoviclienprove.getcotizacion());	
		detallemoviclienproveAsignar.setdescripcion(detallemoviclienprove.getdescripcion());	
		detallemoviclienproveAsignar.setid_sucursal_movimiento(detallemoviclienprove.getid_sucursal_movimiento());
		detallemoviclienproveAsignar.setsucursalmovimiento_descripcion(detallemoviclienprove.getsucursalmovimiento_descripcion());	
		detallemoviclienproveAsignar.setid_tipo_transaccion_modulo(detallemoviclienprove.getid_tipo_transaccion_modulo());
		detallemoviclienproveAsignar.settipotransaccionmodulo_descripcion(detallemoviclienprove.gettipotransaccionmodulo_descripcion());	
		detallemoviclienproveAsignar.setid_estado_detalle_cliente(detallemoviclienprove.getid_estado_detalle_cliente());
		detallemoviclienproveAsignar.setestadodetallecliente_descripcion(detallemoviclienprove.getestadodetallecliente_descripcion());	
		detallemoviclienproveAsignar.setfecha_emision(detallemoviclienprove.getfecha_emision());	
		detallemoviclienproveAsignar.setmonto_mone_local(detallemoviclienprove.getmonto_mone_local());	
		detallemoviclienproveAsignar.setmonto_mone_extra(detallemoviclienprove.getmonto_mone_extra());	
		detallemoviclienproveAsignar.setnumero_comprobante(detallemoviclienprove.getnumero_comprobante());	
	}
	
	public static void inicializarDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienprove) throws Exception {
		try {
				detallemoviclienprove.setId(0L);	
					
				detallemoviclienprove.setid_empresa(-1L);	
				detallemoviclienprove.setid_sucursal(-1L);	
				detallemoviclienprove.setid_ejercicio(-1L);	
				detallemoviclienprove.setid_periodo(-1L);	
				detallemoviclienprove.setid_anio(null);	
				detallemoviclienprove.setid_mes(null);	
				detallemoviclienprove.setid_modulo(-1L);	
				detallemoviclienprove.setid_asiento_contable(-1L);	
				detallemoviclienprove.setfecha_vence(new Date());	
				detallemoviclienprove.setid_cliente(-1L);	
				detallemoviclienprove.setid_factura(null);	
				detallemoviclienprove.setnumero_factura("");	
				detallemoviclienprove.setid_transaccion(-1L);	
				detallemoviclienprove.setdebito_mone_local(0.0);	
				detallemoviclienprove.setcredito_mone_local(0.0);	
				detallemoviclienprove.setdebito_mone_extra(0.0);	
				detallemoviclienprove.setcredito_mone_extra(0.0);	
				detallemoviclienprove.setid_moneda(-1L);	
				detallemoviclienprove.setcotizacion(0.0);	
				detallemoviclienprove.setdescripcion("");	
				detallemoviclienprove.setid_sucursal_movimiento(-1L);	
				detallemoviclienprove.setid_tipo_transaccion_modulo(null);	
				detallemoviclienprove.setid_estado_detalle_cliente(-1L);	
				detallemoviclienprove.setfecha_emision(new Date());	
				detallemoviclienprove.setmonto_mone_local(0.0);	
				detallemoviclienprove.setmonto_mone_extra(0.0);	
				detallemoviclienprove.setnumero_comprobante("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleMoviClienProve(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_CREDITOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDSUCURSALMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_IDESTADODETALLECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_MONTOMONEEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleMoviClienProveConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleMoviClienProve(String sTipo,Row row,Workbook workbook,DetalleMoviClienProve detallemoviclienprove,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getdebito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getcredito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getsucursalmovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getestadodetallecliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getmonto_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getmonto_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallemoviclienprove.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleMoviClienProve=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleMoviClienProve() {
		return this.sFinalQueryDetalleMoviClienProve;
	}
	
	public void setsFinalQueryDetalleMoviClienProve(String sFinalQueryDetalleMoviClienProve) {
		this.sFinalQueryDetalleMoviClienProve= sFinalQueryDetalleMoviClienProve;
	}
	
	public Border resaltarSeleccionarDetalleMoviClienProve=null;
	
	public Border setResaltarSeleccionarDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarDetalleMoviClienProve= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleMoviClienProve() {
		return this.resaltarSeleccionarDetalleMoviClienProve;
	}
	
	public void setResaltarSeleccionarDetalleMoviClienProve(Border borderResaltarSeleccionarDetalleMoviClienProve) {
		this.resaltarSeleccionarDetalleMoviClienProve= borderResaltarSeleccionarDetalleMoviClienProve;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleMoviClienProve=null;
	public Boolean mostraridDetalleMoviClienProve=true;
	public Boolean activaridDetalleMoviClienProve=true;

	public Border resaltarid_empresaDetalleMoviClienProve=null;
	public Boolean mostrarid_empresaDetalleMoviClienProve=true;
	public Boolean activarid_empresaDetalleMoviClienProve=true;
	public Boolean cargarid_empresaDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleMoviClienProve=null;
	public Boolean mostrarid_sucursalDetalleMoviClienProve=true;
	public Boolean activarid_sucursalDetalleMoviClienProve=true;
	public Boolean cargarid_sucursalDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleMoviClienProve=null;
	public Boolean mostrarid_ejercicioDetalleMoviClienProve=true;
	public Boolean activarid_ejercicioDetalleMoviClienProve=true;
	public Boolean cargarid_ejercicioDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleMoviClienProve=null;
	public Boolean mostrarid_periodoDetalleMoviClienProve=true;
	public Boolean activarid_periodoDetalleMoviClienProve=true;
	public Boolean cargarid_periodoDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleMoviClienProve=null;
	public Boolean mostrarid_anioDetalleMoviClienProve=true;
	public Boolean activarid_anioDetalleMoviClienProve=false;
	public Boolean cargarid_anioDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleMoviClienProve=null;
	public Boolean mostrarid_mesDetalleMoviClienProve=true;
	public Boolean activarid_mesDetalleMoviClienProve=false;
	public Boolean cargarid_mesDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_moduloDetalleMoviClienProve=null;
	public Boolean mostrarid_moduloDetalleMoviClienProve=true;
	public Boolean activarid_moduloDetalleMoviClienProve=true;
	public Boolean cargarid_moduloDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDetalleMoviClienProve=null;
	public Boolean mostrarid_asiento_contableDetalleMoviClienProve=true;
	public Boolean activarid_asiento_contableDetalleMoviClienProve=true;
	public Boolean cargarid_asiento_contableDetalleMoviClienProve=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarfecha_venceDetalleMoviClienProve=null;
	public Boolean mostrarfecha_venceDetalleMoviClienProve=true;
	public Boolean activarfecha_venceDetalleMoviClienProve=true;

	public Border resaltarid_clienteDetalleMoviClienProve=null;
	public Boolean mostrarid_clienteDetalleMoviClienProve=true;
	public Boolean activarid_clienteDetalleMoviClienProve=true;
	public Boolean cargarid_clienteDetalleMoviClienProve=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_facturaDetalleMoviClienProve=null;
	public Boolean mostrarid_facturaDetalleMoviClienProve=true;
	public Boolean activarid_facturaDetalleMoviClienProve=true;
	public Boolean cargarid_facturaDetalleMoviClienProve=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarnumero_facturaDetalleMoviClienProve=null;
	public Boolean mostrarnumero_facturaDetalleMoviClienProve=true;
	public Boolean activarnumero_facturaDetalleMoviClienProve=false;

	public Border resaltarid_transaccionDetalleMoviClienProve=null;
	public Boolean mostrarid_transaccionDetalleMoviClienProve=true;
	public Boolean activarid_transaccionDetalleMoviClienProve=true;
	public Boolean cargarid_transaccionDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltardebito_mone_localDetalleMoviClienProve=null;
	public Boolean mostrardebito_mone_localDetalleMoviClienProve=true;
	public Boolean activardebito_mone_localDetalleMoviClienProve=true;

	public Border resaltarcredito_mone_localDetalleMoviClienProve=null;
	public Boolean mostrarcredito_mone_localDetalleMoviClienProve=true;
	public Boolean activarcredito_mone_localDetalleMoviClienProve=true;

	public Border resaltardebito_mone_extraDetalleMoviClienProve=null;
	public Boolean mostrardebito_mone_extraDetalleMoviClienProve=true;
	public Boolean activardebito_mone_extraDetalleMoviClienProve=true;

	public Border resaltarcredito_mone_extraDetalleMoviClienProve=null;
	public Boolean mostrarcredito_mone_extraDetalleMoviClienProve=true;
	public Boolean activarcredito_mone_extraDetalleMoviClienProve=true;

	public Border resaltarid_monedaDetalleMoviClienProve=null;
	public Boolean mostrarid_monedaDetalleMoviClienProve=true;
	public Boolean activarid_monedaDetalleMoviClienProve=true;
	public Boolean cargarid_monedaDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarcotizacionDetalleMoviClienProve=null;
	public Boolean mostrarcotizacionDetalleMoviClienProve=true;
	public Boolean activarcotizacionDetalleMoviClienProve=true;

	public Border resaltardescripcionDetalleMoviClienProve=null;
	public Boolean mostrardescripcionDetalleMoviClienProve=true;
	public Boolean activardescripcionDetalleMoviClienProve=true;

	public Border resaltarid_sucursal_movimientoDetalleMoviClienProve=null;
	public Boolean mostrarid_sucursal_movimientoDetalleMoviClienProve=true;
	public Boolean activarid_sucursal_movimientoDetalleMoviClienProve=false;
	public Boolean cargarid_sucursal_movimientoDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursal_movimientoDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloDetalleMoviClienProve=null;
	public Boolean mostrarid_tipo_transaccion_moduloDetalleMoviClienProve=true;
	public Boolean activarid_tipo_transaccion_moduloDetalleMoviClienProve=false;
	public Boolean cargarid_tipo_transaccion_moduloDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarid_estado_detalle_clienteDetalleMoviClienProve=null;
	public Boolean mostrarid_estado_detalle_clienteDetalleMoviClienProve=true;
	public Boolean activarid_estado_detalle_clienteDetalleMoviClienProve=false;
	public Boolean cargarid_estado_detalle_clienteDetalleMoviClienProve=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_clienteDetalleMoviClienProve=false;//ConEventDepend=true

	public Border resaltarfecha_emisionDetalleMoviClienProve=null;
	public Boolean mostrarfecha_emisionDetalleMoviClienProve=true;
	public Boolean activarfecha_emisionDetalleMoviClienProve=false;

	public Border resaltarmonto_mone_localDetalleMoviClienProve=null;
	public Boolean mostrarmonto_mone_localDetalleMoviClienProve=true;
	public Boolean activarmonto_mone_localDetalleMoviClienProve=false;

	public Border resaltarmonto_mone_extraDetalleMoviClienProve=null;
	public Boolean mostrarmonto_mone_extraDetalleMoviClienProve=true;
	public Boolean activarmonto_mone_extraDetalleMoviClienProve=false;

	public Border resaltarnumero_comprobanteDetalleMoviClienProve=null;
	public Boolean mostrarnumero_comprobanteDetalleMoviClienProve=true;
	public Boolean activarnumero_comprobanteDetalleMoviClienProve=false;

	
	

	public Border setResaltaridDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltaridDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleMoviClienProve() {
		return this.resaltaridDetalleMoviClienProve;
	}

	public void setResaltaridDetalleMoviClienProve(Border borderResaltar) {
		this.resaltaridDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostraridDetalleMoviClienProve() {
		return this.mostraridDetalleMoviClienProve;
	}

	public void setMostraridDetalleMoviClienProve(Boolean mostraridDetalleMoviClienProve) {
		this.mostraridDetalleMoviClienProve= mostraridDetalleMoviClienProve;
	}

	public Boolean getActivaridDetalleMoviClienProve() {
		return this.activaridDetalleMoviClienProve;
	}

	public void setActivaridDetalleMoviClienProve(Boolean activaridDetalleMoviClienProve) {
		this.activaridDetalleMoviClienProve= activaridDetalleMoviClienProve;
	}

	public Border setResaltarid_empresaDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleMoviClienProve() {
		return this.resaltarid_empresaDetalleMoviClienProve;
	}

	public void setResaltarid_empresaDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_empresaDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleMoviClienProve() {
		return this.mostrarid_empresaDetalleMoviClienProve;
	}

	public void setMostrarid_empresaDetalleMoviClienProve(Boolean mostrarid_empresaDetalleMoviClienProve) {
		this.mostrarid_empresaDetalleMoviClienProve= mostrarid_empresaDetalleMoviClienProve;
	}

	public Boolean getActivarid_empresaDetalleMoviClienProve() {
		return this.activarid_empresaDetalleMoviClienProve;
	}

	public void setActivarid_empresaDetalleMoviClienProve(Boolean activarid_empresaDetalleMoviClienProve) {
		this.activarid_empresaDetalleMoviClienProve= activarid_empresaDetalleMoviClienProve;
	}

	public Boolean getCargarid_empresaDetalleMoviClienProve() {
		return this.cargarid_empresaDetalleMoviClienProve;
	}

	public void setCargarid_empresaDetalleMoviClienProve(Boolean cargarid_empresaDetalleMoviClienProve) {
		this.cargarid_empresaDetalleMoviClienProve= cargarid_empresaDetalleMoviClienProve;
	}

	public Border setResaltarid_sucursalDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleMoviClienProve() {
		return this.resaltarid_sucursalDetalleMoviClienProve;
	}

	public void setResaltarid_sucursalDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_sucursalDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleMoviClienProve() {
		return this.mostrarid_sucursalDetalleMoviClienProve;
	}

	public void setMostrarid_sucursalDetalleMoviClienProve(Boolean mostrarid_sucursalDetalleMoviClienProve) {
		this.mostrarid_sucursalDetalleMoviClienProve= mostrarid_sucursalDetalleMoviClienProve;
	}

	public Boolean getActivarid_sucursalDetalleMoviClienProve() {
		return this.activarid_sucursalDetalleMoviClienProve;
	}

	public void setActivarid_sucursalDetalleMoviClienProve(Boolean activarid_sucursalDetalleMoviClienProve) {
		this.activarid_sucursalDetalleMoviClienProve= activarid_sucursalDetalleMoviClienProve;
	}

	public Boolean getCargarid_sucursalDetalleMoviClienProve() {
		return this.cargarid_sucursalDetalleMoviClienProve;
	}

	public void setCargarid_sucursalDetalleMoviClienProve(Boolean cargarid_sucursalDetalleMoviClienProve) {
		this.cargarid_sucursalDetalleMoviClienProve= cargarid_sucursalDetalleMoviClienProve;
	}

	public Border setResaltarid_ejercicioDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleMoviClienProve() {
		return this.resaltarid_ejercicioDetalleMoviClienProve;
	}

	public void setResaltarid_ejercicioDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleMoviClienProve() {
		return this.mostrarid_ejercicioDetalleMoviClienProve;
	}

	public void setMostrarid_ejercicioDetalleMoviClienProve(Boolean mostrarid_ejercicioDetalleMoviClienProve) {
		this.mostrarid_ejercicioDetalleMoviClienProve= mostrarid_ejercicioDetalleMoviClienProve;
	}

	public Boolean getActivarid_ejercicioDetalleMoviClienProve() {
		return this.activarid_ejercicioDetalleMoviClienProve;
	}

	public void setActivarid_ejercicioDetalleMoviClienProve(Boolean activarid_ejercicioDetalleMoviClienProve) {
		this.activarid_ejercicioDetalleMoviClienProve= activarid_ejercicioDetalleMoviClienProve;
	}

	public Boolean getCargarid_ejercicioDetalleMoviClienProve() {
		return this.cargarid_ejercicioDetalleMoviClienProve;
	}

	public void setCargarid_ejercicioDetalleMoviClienProve(Boolean cargarid_ejercicioDetalleMoviClienProve) {
		this.cargarid_ejercicioDetalleMoviClienProve= cargarid_ejercicioDetalleMoviClienProve;
	}

	public Border setResaltarid_periodoDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleMoviClienProve() {
		return this.resaltarid_periodoDetalleMoviClienProve;
	}

	public void setResaltarid_periodoDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_periodoDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleMoviClienProve() {
		return this.mostrarid_periodoDetalleMoviClienProve;
	}

	public void setMostrarid_periodoDetalleMoviClienProve(Boolean mostrarid_periodoDetalleMoviClienProve) {
		this.mostrarid_periodoDetalleMoviClienProve= mostrarid_periodoDetalleMoviClienProve;
	}

	public Boolean getActivarid_periodoDetalleMoviClienProve() {
		return this.activarid_periodoDetalleMoviClienProve;
	}

	public void setActivarid_periodoDetalleMoviClienProve(Boolean activarid_periodoDetalleMoviClienProve) {
		this.activarid_periodoDetalleMoviClienProve= activarid_periodoDetalleMoviClienProve;
	}

	public Boolean getCargarid_periodoDetalleMoviClienProve() {
		return this.cargarid_periodoDetalleMoviClienProve;
	}

	public void setCargarid_periodoDetalleMoviClienProve(Boolean cargarid_periodoDetalleMoviClienProve) {
		this.cargarid_periodoDetalleMoviClienProve= cargarid_periodoDetalleMoviClienProve;
	}

	public Border setResaltarid_anioDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_anioDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleMoviClienProve() {
		return this.resaltarid_anioDetalleMoviClienProve;
	}

	public void setResaltarid_anioDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_anioDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleMoviClienProve() {
		return this.mostrarid_anioDetalleMoviClienProve;
	}

	public void setMostrarid_anioDetalleMoviClienProve(Boolean mostrarid_anioDetalleMoviClienProve) {
		this.mostrarid_anioDetalleMoviClienProve= mostrarid_anioDetalleMoviClienProve;
	}

	public Boolean getActivarid_anioDetalleMoviClienProve() {
		return this.activarid_anioDetalleMoviClienProve;
	}

	public void setActivarid_anioDetalleMoviClienProve(Boolean activarid_anioDetalleMoviClienProve) {
		this.activarid_anioDetalleMoviClienProve= activarid_anioDetalleMoviClienProve;
	}

	public Boolean getCargarid_anioDetalleMoviClienProve() {
		return this.cargarid_anioDetalleMoviClienProve;
	}

	public void setCargarid_anioDetalleMoviClienProve(Boolean cargarid_anioDetalleMoviClienProve) {
		this.cargarid_anioDetalleMoviClienProve= cargarid_anioDetalleMoviClienProve;
	}

	public Border setResaltarid_mesDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_mesDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleMoviClienProve() {
		return this.resaltarid_mesDetalleMoviClienProve;
	}

	public void setResaltarid_mesDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_mesDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleMoviClienProve() {
		return this.mostrarid_mesDetalleMoviClienProve;
	}

	public void setMostrarid_mesDetalleMoviClienProve(Boolean mostrarid_mesDetalleMoviClienProve) {
		this.mostrarid_mesDetalleMoviClienProve= mostrarid_mesDetalleMoviClienProve;
	}

	public Boolean getActivarid_mesDetalleMoviClienProve() {
		return this.activarid_mesDetalleMoviClienProve;
	}

	public void setActivarid_mesDetalleMoviClienProve(Boolean activarid_mesDetalleMoviClienProve) {
		this.activarid_mesDetalleMoviClienProve= activarid_mesDetalleMoviClienProve;
	}

	public Boolean getCargarid_mesDetalleMoviClienProve() {
		return this.cargarid_mesDetalleMoviClienProve;
	}

	public void setCargarid_mesDetalleMoviClienProve(Boolean cargarid_mesDetalleMoviClienProve) {
		this.cargarid_mesDetalleMoviClienProve= cargarid_mesDetalleMoviClienProve;
	}

	public Border setResaltarid_moduloDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_moduloDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDetalleMoviClienProve() {
		return this.resaltarid_moduloDetalleMoviClienProve;
	}

	public void setResaltarid_moduloDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_moduloDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_moduloDetalleMoviClienProve() {
		return this.mostrarid_moduloDetalleMoviClienProve;
	}

	public void setMostrarid_moduloDetalleMoviClienProve(Boolean mostrarid_moduloDetalleMoviClienProve) {
		this.mostrarid_moduloDetalleMoviClienProve= mostrarid_moduloDetalleMoviClienProve;
	}

	public Boolean getActivarid_moduloDetalleMoviClienProve() {
		return this.activarid_moduloDetalleMoviClienProve;
	}

	public void setActivarid_moduloDetalleMoviClienProve(Boolean activarid_moduloDetalleMoviClienProve) {
		this.activarid_moduloDetalleMoviClienProve= activarid_moduloDetalleMoviClienProve;
	}

	public Boolean getCargarid_moduloDetalleMoviClienProve() {
		return this.cargarid_moduloDetalleMoviClienProve;
	}

	public void setCargarid_moduloDetalleMoviClienProve(Boolean cargarid_moduloDetalleMoviClienProve) {
		this.cargarid_moduloDetalleMoviClienProve= cargarid_moduloDetalleMoviClienProve;
	}

	public Border setResaltarid_asiento_contableDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_asiento_contableDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetalleMoviClienProve() {
		return this.resaltarid_asiento_contableDetalleMoviClienProve;
	}

	public void setResaltarid_asiento_contableDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_asiento_contableDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetalleMoviClienProve() {
		return this.mostrarid_asiento_contableDetalleMoviClienProve;
	}

	public void setMostrarid_asiento_contableDetalleMoviClienProve(Boolean mostrarid_asiento_contableDetalleMoviClienProve) {
		this.mostrarid_asiento_contableDetalleMoviClienProve= mostrarid_asiento_contableDetalleMoviClienProve;
	}

	public Boolean getActivarid_asiento_contableDetalleMoviClienProve() {
		return this.activarid_asiento_contableDetalleMoviClienProve;
	}

	public void setActivarid_asiento_contableDetalleMoviClienProve(Boolean activarid_asiento_contableDetalleMoviClienProve) {
		this.activarid_asiento_contableDetalleMoviClienProve= activarid_asiento_contableDetalleMoviClienProve;
	}

	public Boolean getCargarid_asiento_contableDetalleMoviClienProve() {
		return this.cargarid_asiento_contableDetalleMoviClienProve;
	}

	public void setCargarid_asiento_contableDetalleMoviClienProve(Boolean cargarid_asiento_contableDetalleMoviClienProve) {
		this.cargarid_asiento_contableDetalleMoviClienProve= cargarid_asiento_contableDetalleMoviClienProve;
	}

	public Border setResaltarfecha_venceDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarfecha_venceDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceDetalleMoviClienProve() {
		return this.resaltarfecha_venceDetalleMoviClienProve;
	}

	public void setResaltarfecha_venceDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarfecha_venceDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarfecha_venceDetalleMoviClienProve() {
		return this.mostrarfecha_venceDetalleMoviClienProve;
	}

	public void setMostrarfecha_venceDetalleMoviClienProve(Boolean mostrarfecha_venceDetalleMoviClienProve) {
		this.mostrarfecha_venceDetalleMoviClienProve= mostrarfecha_venceDetalleMoviClienProve;
	}

	public Boolean getActivarfecha_venceDetalleMoviClienProve() {
		return this.activarfecha_venceDetalleMoviClienProve;
	}

	public void setActivarfecha_venceDetalleMoviClienProve(Boolean activarfecha_venceDetalleMoviClienProve) {
		this.activarfecha_venceDetalleMoviClienProve= activarfecha_venceDetalleMoviClienProve;
	}

	public Border setResaltarid_clienteDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_clienteDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteDetalleMoviClienProve() {
		return this.resaltarid_clienteDetalleMoviClienProve;
	}

	public void setResaltarid_clienteDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_clienteDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_clienteDetalleMoviClienProve() {
		return this.mostrarid_clienteDetalleMoviClienProve;
	}

	public void setMostrarid_clienteDetalleMoviClienProve(Boolean mostrarid_clienteDetalleMoviClienProve) {
		this.mostrarid_clienteDetalleMoviClienProve= mostrarid_clienteDetalleMoviClienProve;
	}

	public Boolean getActivarid_clienteDetalleMoviClienProve() {
		return this.activarid_clienteDetalleMoviClienProve;
	}

	public void setActivarid_clienteDetalleMoviClienProve(Boolean activarid_clienteDetalleMoviClienProve) {
		this.activarid_clienteDetalleMoviClienProve= activarid_clienteDetalleMoviClienProve;
	}

	public Boolean getCargarid_clienteDetalleMoviClienProve() {
		return this.cargarid_clienteDetalleMoviClienProve;
	}

	public void setCargarid_clienteDetalleMoviClienProve(Boolean cargarid_clienteDetalleMoviClienProve) {
		this.cargarid_clienteDetalleMoviClienProve= cargarid_clienteDetalleMoviClienProve;
	}

	public Border setResaltarid_facturaDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_facturaDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaDetalleMoviClienProve() {
		return this.resaltarid_facturaDetalleMoviClienProve;
	}

	public void setResaltarid_facturaDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_facturaDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_facturaDetalleMoviClienProve() {
		return this.mostrarid_facturaDetalleMoviClienProve;
	}

	public void setMostrarid_facturaDetalleMoviClienProve(Boolean mostrarid_facturaDetalleMoviClienProve) {
		this.mostrarid_facturaDetalleMoviClienProve= mostrarid_facturaDetalleMoviClienProve;
	}

	public Boolean getActivarid_facturaDetalleMoviClienProve() {
		return this.activarid_facturaDetalleMoviClienProve;
	}

	public void setActivarid_facturaDetalleMoviClienProve(Boolean activarid_facturaDetalleMoviClienProve) {
		this.activarid_facturaDetalleMoviClienProve= activarid_facturaDetalleMoviClienProve;
	}

	public Boolean getCargarid_facturaDetalleMoviClienProve() {
		return this.cargarid_facturaDetalleMoviClienProve;
	}

	public void setCargarid_facturaDetalleMoviClienProve(Boolean cargarid_facturaDetalleMoviClienProve) {
		this.cargarid_facturaDetalleMoviClienProve= cargarid_facturaDetalleMoviClienProve;
	}

	public Border setResaltarnumero_facturaDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarnumero_facturaDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaDetalleMoviClienProve() {
		return this.resaltarnumero_facturaDetalleMoviClienProve;
	}

	public void setResaltarnumero_facturaDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarnumero_facturaDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaDetalleMoviClienProve() {
		return this.mostrarnumero_facturaDetalleMoviClienProve;
	}

	public void setMostrarnumero_facturaDetalleMoviClienProve(Boolean mostrarnumero_facturaDetalleMoviClienProve) {
		this.mostrarnumero_facturaDetalleMoviClienProve= mostrarnumero_facturaDetalleMoviClienProve;
	}

	public Boolean getActivarnumero_facturaDetalleMoviClienProve() {
		return this.activarnumero_facturaDetalleMoviClienProve;
	}

	public void setActivarnumero_facturaDetalleMoviClienProve(Boolean activarnumero_facturaDetalleMoviClienProve) {
		this.activarnumero_facturaDetalleMoviClienProve= activarnumero_facturaDetalleMoviClienProve;
	}

	public Border setResaltarid_transaccionDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_transaccionDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionDetalleMoviClienProve() {
		return this.resaltarid_transaccionDetalleMoviClienProve;
	}

	public void setResaltarid_transaccionDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_transaccionDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_transaccionDetalleMoviClienProve() {
		return this.mostrarid_transaccionDetalleMoviClienProve;
	}

	public void setMostrarid_transaccionDetalleMoviClienProve(Boolean mostrarid_transaccionDetalleMoviClienProve) {
		this.mostrarid_transaccionDetalleMoviClienProve= mostrarid_transaccionDetalleMoviClienProve;
	}

	public Boolean getActivarid_transaccionDetalleMoviClienProve() {
		return this.activarid_transaccionDetalleMoviClienProve;
	}

	public void setActivarid_transaccionDetalleMoviClienProve(Boolean activarid_transaccionDetalleMoviClienProve) {
		this.activarid_transaccionDetalleMoviClienProve= activarid_transaccionDetalleMoviClienProve;
	}

	public Boolean getCargarid_transaccionDetalleMoviClienProve() {
		return this.cargarid_transaccionDetalleMoviClienProve;
	}

	public void setCargarid_transaccionDetalleMoviClienProve(Boolean cargarid_transaccionDetalleMoviClienProve) {
		this.cargarid_transaccionDetalleMoviClienProve= cargarid_transaccionDetalleMoviClienProve;
	}

	public Border setResaltardebito_mone_localDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltardebito_mone_localDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localDetalleMoviClienProve() {
		return this.resaltardebito_mone_localDetalleMoviClienProve;
	}

	public void setResaltardebito_mone_localDetalleMoviClienProve(Border borderResaltar) {
		this.resaltardebito_mone_localDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localDetalleMoviClienProve() {
		return this.mostrardebito_mone_localDetalleMoviClienProve;
	}

	public void setMostrardebito_mone_localDetalleMoviClienProve(Boolean mostrardebito_mone_localDetalleMoviClienProve) {
		this.mostrardebito_mone_localDetalleMoviClienProve= mostrardebito_mone_localDetalleMoviClienProve;
	}

	public Boolean getActivardebito_mone_localDetalleMoviClienProve() {
		return this.activardebito_mone_localDetalleMoviClienProve;
	}

	public void setActivardebito_mone_localDetalleMoviClienProve(Boolean activardebito_mone_localDetalleMoviClienProve) {
		this.activardebito_mone_localDetalleMoviClienProve= activardebito_mone_localDetalleMoviClienProve;
	}

	public Border setResaltarcredito_mone_localDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarcredito_mone_localDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localDetalleMoviClienProve() {
		return this.resaltarcredito_mone_localDetalleMoviClienProve;
	}

	public void setResaltarcredito_mone_localDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarcredito_mone_localDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localDetalleMoviClienProve() {
		return this.mostrarcredito_mone_localDetalleMoviClienProve;
	}

	public void setMostrarcredito_mone_localDetalleMoviClienProve(Boolean mostrarcredito_mone_localDetalleMoviClienProve) {
		this.mostrarcredito_mone_localDetalleMoviClienProve= mostrarcredito_mone_localDetalleMoviClienProve;
	}

	public Boolean getActivarcredito_mone_localDetalleMoviClienProve() {
		return this.activarcredito_mone_localDetalleMoviClienProve;
	}

	public void setActivarcredito_mone_localDetalleMoviClienProve(Boolean activarcredito_mone_localDetalleMoviClienProve) {
		this.activarcredito_mone_localDetalleMoviClienProve= activarcredito_mone_localDetalleMoviClienProve;
	}

	public Border setResaltardebito_mone_extraDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltardebito_mone_extraDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_extraDetalleMoviClienProve() {
		return this.resaltardebito_mone_extraDetalleMoviClienProve;
	}

	public void setResaltardebito_mone_extraDetalleMoviClienProve(Border borderResaltar) {
		this.resaltardebito_mone_extraDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrardebito_mone_extraDetalleMoviClienProve() {
		return this.mostrardebito_mone_extraDetalleMoviClienProve;
	}

	public void setMostrardebito_mone_extraDetalleMoviClienProve(Boolean mostrardebito_mone_extraDetalleMoviClienProve) {
		this.mostrardebito_mone_extraDetalleMoviClienProve= mostrardebito_mone_extraDetalleMoviClienProve;
	}

	public Boolean getActivardebito_mone_extraDetalleMoviClienProve() {
		return this.activardebito_mone_extraDetalleMoviClienProve;
	}

	public void setActivardebito_mone_extraDetalleMoviClienProve(Boolean activardebito_mone_extraDetalleMoviClienProve) {
		this.activardebito_mone_extraDetalleMoviClienProve= activardebito_mone_extraDetalleMoviClienProve;
	}

	public Border setResaltarcredito_mone_extraDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarcredito_mone_extraDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_extraDetalleMoviClienProve() {
		return this.resaltarcredito_mone_extraDetalleMoviClienProve;
	}

	public void setResaltarcredito_mone_extraDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarcredito_mone_extraDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_extraDetalleMoviClienProve() {
		return this.mostrarcredito_mone_extraDetalleMoviClienProve;
	}

	public void setMostrarcredito_mone_extraDetalleMoviClienProve(Boolean mostrarcredito_mone_extraDetalleMoviClienProve) {
		this.mostrarcredito_mone_extraDetalleMoviClienProve= mostrarcredito_mone_extraDetalleMoviClienProve;
	}

	public Boolean getActivarcredito_mone_extraDetalleMoviClienProve() {
		return this.activarcredito_mone_extraDetalleMoviClienProve;
	}

	public void setActivarcredito_mone_extraDetalleMoviClienProve(Boolean activarcredito_mone_extraDetalleMoviClienProve) {
		this.activarcredito_mone_extraDetalleMoviClienProve= activarcredito_mone_extraDetalleMoviClienProve;
	}

	public Border setResaltarid_monedaDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_monedaDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaDetalleMoviClienProve() {
		return this.resaltarid_monedaDetalleMoviClienProve;
	}

	public void setResaltarid_monedaDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_monedaDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_monedaDetalleMoviClienProve() {
		return this.mostrarid_monedaDetalleMoviClienProve;
	}

	public void setMostrarid_monedaDetalleMoviClienProve(Boolean mostrarid_monedaDetalleMoviClienProve) {
		this.mostrarid_monedaDetalleMoviClienProve= mostrarid_monedaDetalleMoviClienProve;
	}

	public Boolean getActivarid_monedaDetalleMoviClienProve() {
		return this.activarid_monedaDetalleMoviClienProve;
	}

	public void setActivarid_monedaDetalleMoviClienProve(Boolean activarid_monedaDetalleMoviClienProve) {
		this.activarid_monedaDetalleMoviClienProve= activarid_monedaDetalleMoviClienProve;
	}

	public Boolean getCargarid_monedaDetalleMoviClienProve() {
		return this.cargarid_monedaDetalleMoviClienProve;
	}

	public void setCargarid_monedaDetalleMoviClienProve(Boolean cargarid_monedaDetalleMoviClienProve) {
		this.cargarid_monedaDetalleMoviClienProve= cargarid_monedaDetalleMoviClienProve;
	}

	public Border setResaltarcotizacionDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarcotizacionDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionDetalleMoviClienProve() {
		return this.resaltarcotizacionDetalleMoviClienProve;
	}

	public void setResaltarcotizacionDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarcotizacionDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarcotizacionDetalleMoviClienProve() {
		return this.mostrarcotizacionDetalleMoviClienProve;
	}

	public void setMostrarcotizacionDetalleMoviClienProve(Boolean mostrarcotizacionDetalleMoviClienProve) {
		this.mostrarcotizacionDetalleMoviClienProve= mostrarcotizacionDetalleMoviClienProve;
	}

	public Boolean getActivarcotizacionDetalleMoviClienProve() {
		return this.activarcotizacionDetalleMoviClienProve;
	}

	public void setActivarcotizacionDetalleMoviClienProve(Boolean activarcotizacionDetalleMoviClienProve) {
		this.activarcotizacionDetalleMoviClienProve= activarcotizacionDetalleMoviClienProve;
	}

	public Border setResaltardescripcionDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltardescripcionDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleMoviClienProve() {
		return this.resaltardescripcionDetalleMoviClienProve;
	}

	public void setResaltardescripcionDetalleMoviClienProve(Border borderResaltar) {
		this.resaltardescripcionDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleMoviClienProve() {
		return this.mostrardescripcionDetalleMoviClienProve;
	}

	public void setMostrardescripcionDetalleMoviClienProve(Boolean mostrardescripcionDetalleMoviClienProve) {
		this.mostrardescripcionDetalleMoviClienProve= mostrardescripcionDetalleMoviClienProve;
	}

	public Boolean getActivardescripcionDetalleMoviClienProve() {
		return this.activardescripcionDetalleMoviClienProve;
	}

	public void setActivardescripcionDetalleMoviClienProve(Boolean activardescripcionDetalleMoviClienProve) {
		this.activardescripcionDetalleMoviClienProve= activardescripcionDetalleMoviClienProve;
	}

	public Border setResaltarid_sucursal_movimientoDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursal_movimientoDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursal_movimientoDetalleMoviClienProve() {
		return this.resaltarid_sucursal_movimientoDetalleMoviClienProve;
	}

	public void setResaltarid_sucursal_movimientoDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_sucursal_movimientoDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_sucursal_movimientoDetalleMoviClienProve() {
		return this.mostrarid_sucursal_movimientoDetalleMoviClienProve;
	}

	public void setMostrarid_sucursal_movimientoDetalleMoviClienProve(Boolean mostrarid_sucursal_movimientoDetalleMoviClienProve) {
		this.mostrarid_sucursal_movimientoDetalleMoviClienProve= mostrarid_sucursal_movimientoDetalleMoviClienProve;
	}

	public Boolean getActivarid_sucursal_movimientoDetalleMoviClienProve() {
		return this.activarid_sucursal_movimientoDetalleMoviClienProve;
	}

	public void setActivarid_sucursal_movimientoDetalleMoviClienProve(Boolean activarid_sucursal_movimientoDetalleMoviClienProve) {
		this.activarid_sucursal_movimientoDetalleMoviClienProve= activarid_sucursal_movimientoDetalleMoviClienProve;
	}

	public Boolean getCargarid_sucursal_movimientoDetalleMoviClienProve() {
		return this.cargarid_sucursal_movimientoDetalleMoviClienProve;
	}

	public void setCargarid_sucursal_movimientoDetalleMoviClienProve(Boolean cargarid_sucursal_movimientoDetalleMoviClienProve) {
		this.cargarid_sucursal_movimientoDetalleMoviClienProve= cargarid_sucursal_movimientoDetalleMoviClienProve;
	}

	public Border setResaltarid_tipo_transaccion_moduloDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_transaccion_moduloDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloDetalleMoviClienProve() {
		return this.resaltarid_tipo_transaccion_moduloDetalleMoviClienProve;
	}

	public void setResaltarid_tipo_transaccion_moduloDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloDetalleMoviClienProve() {
		return this.mostrarid_tipo_transaccion_moduloDetalleMoviClienProve;
	}

	public void setMostrarid_tipo_transaccion_moduloDetalleMoviClienProve(Boolean mostrarid_tipo_transaccion_moduloDetalleMoviClienProve) {
		this.mostrarid_tipo_transaccion_moduloDetalleMoviClienProve= mostrarid_tipo_transaccion_moduloDetalleMoviClienProve;
	}

	public Boolean getActivarid_tipo_transaccion_moduloDetalleMoviClienProve() {
		return this.activarid_tipo_transaccion_moduloDetalleMoviClienProve;
	}

	public void setActivarid_tipo_transaccion_moduloDetalleMoviClienProve(Boolean activarid_tipo_transaccion_moduloDetalleMoviClienProve) {
		this.activarid_tipo_transaccion_moduloDetalleMoviClienProve= activarid_tipo_transaccion_moduloDetalleMoviClienProve;
	}

	public Boolean getCargarid_tipo_transaccion_moduloDetalleMoviClienProve() {
		return this.cargarid_tipo_transaccion_moduloDetalleMoviClienProve;
	}

	public void setCargarid_tipo_transaccion_moduloDetalleMoviClienProve(Boolean cargarid_tipo_transaccion_moduloDetalleMoviClienProve) {
		this.cargarid_tipo_transaccion_moduloDetalleMoviClienProve= cargarid_tipo_transaccion_moduloDetalleMoviClienProve;
	}

	public Border setResaltarid_estado_detalle_clienteDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarid_estado_detalle_clienteDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_clienteDetalleMoviClienProve() {
		return this.resaltarid_estado_detalle_clienteDetalleMoviClienProve;
	}

	public void setResaltarid_estado_detalle_clienteDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarid_estado_detalle_clienteDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_clienteDetalleMoviClienProve() {
		return this.mostrarid_estado_detalle_clienteDetalleMoviClienProve;
	}

	public void setMostrarid_estado_detalle_clienteDetalleMoviClienProve(Boolean mostrarid_estado_detalle_clienteDetalleMoviClienProve) {
		this.mostrarid_estado_detalle_clienteDetalleMoviClienProve= mostrarid_estado_detalle_clienteDetalleMoviClienProve;
	}

	public Boolean getActivarid_estado_detalle_clienteDetalleMoviClienProve() {
		return this.activarid_estado_detalle_clienteDetalleMoviClienProve;
	}

	public void setActivarid_estado_detalle_clienteDetalleMoviClienProve(Boolean activarid_estado_detalle_clienteDetalleMoviClienProve) {
		this.activarid_estado_detalle_clienteDetalleMoviClienProve= activarid_estado_detalle_clienteDetalleMoviClienProve;
	}

	public Boolean getCargarid_estado_detalle_clienteDetalleMoviClienProve() {
		return this.cargarid_estado_detalle_clienteDetalleMoviClienProve;
	}

	public void setCargarid_estado_detalle_clienteDetalleMoviClienProve(Boolean cargarid_estado_detalle_clienteDetalleMoviClienProve) {
		this.cargarid_estado_detalle_clienteDetalleMoviClienProve= cargarid_estado_detalle_clienteDetalleMoviClienProve;
	}

	public Border setResaltarfecha_emisionDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarfecha_emisionDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionDetalleMoviClienProve() {
		return this.resaltarfecha_emisionDetalleMoviClienProve;
	}

	public void setResaltarfecha_emisionDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarfecha_emisionDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionDetalleMoviClienProve() {
		return this.mostrarfecha_emisionDetalleMoviClienProve;
	}

	public void setMostrarfecha_emisionDetalleMoviClienProve(Boolean mostrarfecha_emisionDetalleMoviClienProve) {
		this.mostrarfecha_emisionDetalleMoviClienProve= mostrarfecha_emisionDetalleMoviClienProve;
	}

	public Boolean getActivarfecha_emisionDetalleMoviClienProve() {
		return this.activarfecha_emisionDetalleMoviClienProve;
	}

	public void setActivarfecha_emisionDetalleMoviClienProve(Boolean activarfecha_emisionDetalleMoviClienProve) {
		this.activarfecha_emisionDetalleMoviClienProve= activarfecha_emisionDetalleMoviClienProve;
	}

	public Border setResaltarmonto_mone_localDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarmonto_mone_localDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_localDetalleMoviClienProve() {
		return this.resaltarmonto_mone_localDetalleMoviClienProve;
	}

	public void setResaltarmonto_mone_localDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarmonto_mone_localDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_localDetalleMoviClienProve() {
		return this.mostrarmonto_mone_localDetalleMoviClienProve;
	}

	public void setMostrarmonto_mone_localDetalleMoviClienProve(Boolean mostrarmonto_mone_localDetalleMoviClienProve) {
		this.mostrarmonto_mone_localDetalleMoviClienProve= mostrarmonto_mone_localDetalleMoviClienProve;
	}

	public Boolean getActivarmonto_mone_localDetalleMoviClienProve() {
		return this.activarmonto_mone_localDetalleMoviClienProve;
	}

	public void setActivarmonto_mone_localDetalleMoviClienProve(Boolean activarmonto_mone_localDetalleMoviClienProve) {
		this.activarmonto_mone_localDetalleMoviClienProve= activarmonto_mone_localDetalleMoviClienProve;
	}

	public Border setResaltarmonto_mone_extraDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarmonto_mone_extraDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_extraDetalleMoviClienProve() {
		return this.resaltarmonto_mone_extraDetalleMoviClienProve;
	}

	public void setResaltarmonto_mone_extraDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarmonto_mone_extraDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_extraDetalleMoviClienProve() {
		return this.mostrarmonto_mone_extraDetalleMoviClienProve;
	}

	public void setMostrarmonto_mone_extraDetalleMoviClienProve(Boolean mostrarmonto_mone_extraDetalleMoviClienProve) {
		this.mostrarmonto_mone_extraDetalleMoviClienProve= mostrarmonto_mone_extraDetalleMoviClienProve;
	}

	public Boolean getActivarmonto_mone_extraDetalleMoviClienProve() {
		return this.activarmonto_mone_extraDetalleMoviClienProve;
	}

	public void setActivarmonto_mone_extraDetalleMoviClienProve(Boolean activarmonto_mone_extraDetalleMoviClienProve) {
		this.activarmonto_mone_extraDetalleMoviClienProve= activarmonto_mone_extraDetalleMoviClienProve;
	}

	public Border setResaltarnumero_comprobanteDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detallemoviclienproveBeanSwingJInternalFrame.jTtoolBarDetalleMoviClienProve.setBorder(borderResaltar);
		*/
		this.resaltarnumero_comprobanteDetalleMoviClienProve= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleMoviClienProve() {
		return this.resaltarnumero_comprobanteDetalleMoviClienProve;
	}

	public void setResaltarnumero_comprobanteDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleMoviClienProve= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleMoviClienProve() {
		return this.mostrarnumero_comprobanteDetalleMoviClienProve;
	}

	public void setMostrarnumero_comprobanteDetalleMoviClienProve(Boolean mostrarnumero_comprobanteDetalleMoviClienProve) {
		this.mostrarnumero_comprobanteDetalleMoviClienProve= mostrarnumero_comprobanteDetalleMoviClienProve;
	}

	public Boolean getActivarnumero_comprobanteDetalleMoviClienProve() {
		return this.activarnumero_comprobanteDetalleMoviClienProve;
	}

	public void setActivarnumero_comprobanteDetalleMoviClienProve(Boolean activarnumero_comprobanteDetalleMoviClienProve) {
		this.activarnumero_comprobanteDetalleMoviClienProve= activarnumero_comprobanteDetalleMoviClienProve;
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
		
		
		this.setMostraridDetalleMoviClienProve(esInicial);
		this.setMostrarid_empresaDetalleMoviClienProve(esInicial);
		this.setMostrarid_sucursalDetalleMoviClienProve(esInicial);
		this.setMostrarid_ejercicioDetalleMoviClienProve(esInicial);
		this.setMostrarid_periodoDetalleMoviClienProve(esInicial);
		this.setMostrarid_anioDetalleMoviClienProve(esInicial);
		this.setMostrarid_mesDetalleMoviClienProve(esInicial);
		this.setMostrarid_moduloDetalleMoviClienProve(esInicial);
		this.setMostrarid_asiento_contableDetalleMoviClienProve(esInicial);
		this.setMostrarfecha_venceDetalleMoviClienProve(esInicial);
		this.setMostrarid_clienteDetalleMoviClienProve(esInicial);
		this.setMostrarid_facturaDetalleMoviClienProve(esInicial);
		this.setMostrarnumero_facturaDetalleMoviClienProve(esInicial);
		this.setMostrarid_transaccionDetalleMoviClienProve(esInicial);
		this.setMostrardebito_mone_localDetalleMoviClienProve(esInicial);
		this.setMostrarcredito_mone_localDetalleMoviClienProve(esInicial);
		this.setMostrardebito_mone_extraDetalleMoviClienProve(esInicial);
		this.setMostrarcredito_mone_extraDetalleMoviClienProve(esInicial);
		this.setMostrarid_monedaDetalleMoviClienProve(esInicial);
		this.setMostrarcotizacionDetalleMoviClienProve(esInicial);
		this.setMostrardescripcionDetalleMoviClienProve(esInicial);
		this.setMostrarid_sucursal_movimientoDetalleMoviClienProve(esInicial);
		this.setMostrarid_tipo_transaccion_moduloDetalleMoviClienProve(esInicial);
		this.setMostrarid_estado_detalle_clienteDetalleMoviClienProve(esInicial);
		this.setMostrarfecha_emisionDetalleMoviClienProve(esInicial);
		this.setMostrarmonto_mone_localDetalleMoviClienProve(esInicial);
		this.setMostrarmonto_mone_extraDetalleMoviClienProve(esInicial);
		this.setMostrarnumero_comprobanteDetalleMoviClienProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.ID)) {
				this.setMostraridDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setMostrardebito_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setMostrarcredito_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setMostrarid_sucursal_movimientoDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setMostrarid_estado_detalle_clienteDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL)) {
				this.setMostrarmonto_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA)) {
				this.setMostrarmonto_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleMoviClienProve(esAsigna);
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
		
		
		this.setActivaridDetalleMoviClienProve(esInicial);
		this.setActivarid_empresaDetalleMoviClienProve(esInicial);
		this.setActivarid_sucursalDetalleMoviClienProve(esInicial);
		this.setActivarid_ejercicioDetalleMoviClienProve(esInicial);
		this.setActivarid_periodoDetalleMoviClienProve(esInicial);
		this.setActivarid_anioDetalleMoviClienProve(esInicial);
		this.setActivarid_mesDetalleMoviClienProve(esInicial);
		this.setActivarid_moduloDetalleMoviClienProve(esInicial);
		this.setActivarid_asiento_contableDetalleMoviClienProve(esInicial);
		this.setActivarfecha_venceDetalleMoviClienProve(esInicial);
		this.setActivarid_clienteDetalleMoviClienProve(esInicial);
		this.setActivarid_facturaDetalleMoviClienProve(esInicial);
		this.setActivarnumero_facturaDetalleMoviClienProve(esInicial);
		this.setActivarid_transaccionDetalleMoviClienProve(esInicial);
		this.setActivardebito_mone_localDetalleMoviClienProve(esInicial);
		this.setActivarcredito_mone_localDetalleMoviClienProve(esInicial);
		this.setActivardebito_mone_extraDetalleMoviClienProve(esInicial);
		this.setActivarcredito_mone_extraDetalleMoviClienProve(esInicial);
		this.setActivarid_monedaDetalleMoviClienProve(esInicial);
		this.setActivarcotizacionDetalleMoviClienProve(esInicial);
		this.setActivardescripcionDetalleMoviClienProve(esInicial);
		this.setActivarid_sucursal_movimientoDetalleMoviClienProve(esInicial);
		this.setActivarid_tipo_transaccion_moduloDetalleMoviClienProve(esInicial);
		this.setActivarid_estado_detalle_clienteDetalleMoviClienProve(esInicial);
		this.setActivarfecha_emisionDetalleMoviClienProve(esInicial);
		this.setActivarmonto_mone_localDetalleMoviClienProve(esInicial);
		this.setActivarmonto_mone_extraDetalleMoviClienProve(esInicial);
		this.setActivarnumero_comprobanteDetalleMoviClienProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.ID)) {
				this.setActivaridDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setActivardebito_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setActivarcredito_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setActivarid_sucursal_movimientoDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setActivarid_estado_detalle_clienteDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL)) {
				this.setActivarmonto_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA)) {
				this.setActivarmonto_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleMoviClienProve(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleMoviClienProve(esInicial);
		this.setResaltarid_empresaDetalleMoviClienProve(esInicial);
		this.setResaltarid_sucursalDetalleMoviClienProve(esInicial);
		this.setResaltarid_ejercicioDetalleMoviClienProve(esInicial);
		this.setResaltarid_periodoDetalleMoviClienProve(esInicial);
		this.setResaltarid_anioDetalleMoviClienProve(esInicial);
		this.setResaltarid_mesDetalleMoviClienProve(esInicial);
		this.setResaltarid_moduloDetalleMoviClienProve(esInicial);
		this.setResaltarid_asiento_contableDetalleMoviClienProve(esInicial);
		this.setResaltarfecha_venceDetalleMoviClienProve(esInicial);
		this.setResaltarid_clienteDetalleMoviClienProve(esInicial);
		this.setResaltarid_facturaDetalleMoviClienProve(esInicial);
		this.setResaltarnumero_facturaDetalleMoviClienProve(esInicial);
		this.setResaltarid_transaccionDetalleMoviClienProve(esInicial);
		this.setResaltardebito_mone_localDetalleMoviClienProve(esInicial);
		this.setResaltarcredito_mone_localDetalleMoviClienProve(esInicial);
		this.setResaltardebito_mone_extraDetalleMoviClienProve(esInicial);
		this.setResaltarcredito_mone_extraDetalleMoviClienProve(esInicial);
		this.setResaltarid_monedaDetalleMoviClienProve(esInicial);
		this.setResaltarcotizacionDetalleMoviClienProve(esInicial);
		this.setResaltardescripcionDetalleMoviClienProve(esInicial);
		this.setResaltarid_sucursal_movimientoDetalleMoviClienProve(esInicial);
		this.setResaltarid_tipo_transaccion_moduloDetalleMoviClienProve(esInicial);
		this.setResaltarid_estado_detalle_clienteDetalleMoviClienProve(esInicial);
		this.setResaltarfecha_emisionDetalleMoviClienProve(esInicial);
		this.setResaltarmonto_mone_localDetalleMoviClienProve(esInicial);
		this.setResaltarmonto_mone_extraDetalleMoviClienProve(esInicial);
		this.setResaltarnumero_comprobanteDetalleMoviClienProve(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.ID)) {
				this.setResaltaridDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setResaltardebito_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA)) {
				this.setResaltarcredito_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO)) {
				this.setResaltarid_sucursal_movimientoDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE)) {
				this.setResaltarid_estado_detalle_clienteDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL)) {
				this.setResaltarmonto_mone_localDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA)) {
				this.setResaltarmonto_mone_extraDetalleMoviClienProve(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleMoviClienProve(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdAsientoContableDetalleMoviClienProve() {
		return this.mostrarFK_IdAsientoContableDetalleMoviClienProve;
	}

	public void setMostrarFK_IdAsientoContableDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdClienteDetalleMoviClienProve() {
		return this.mostrarFK_IdClienteDetalleMoviClienProve;
	}

	public void setMostrarFK_IdClienteDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleMoviClienProveDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdDetalleMoviClienProveDetalleMoviClienProve() {
		return this.mostrarFK_IdDetalleMoviClienProveDetalleMoviClienProve;
	}

	public void setMostrarFK_IdDetalleMoviClienProveDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleMoviClienProveDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdEjercicioDetalleMoviClienProve() {
		return this.mostrarFK_IdEjercicioDetalleMoviClienProve;
	}

	public void setMostrarFK_IdEjercicioDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdEmpresaDetalleMoviClienProve() {
		return this.mostrarFK_IdEmpresaDetalleMoviClienProve;
	}

	public void setMostrarFK_IdEmpresaDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleClienteDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdEstadoDetalleClienteDetalleMoviClienProve() {
		return this.mostrarFK_IdEstadoDetalleClienteDetalleMoviClienProve;
	}

	public void setMostrarFK_IdEstadoDetalleClienteDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleClienteDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdFacturaDetalleMoviClienProve() {
		return this.mostrarFK_IdFacturaDetalleMoviClienProve;
	}

	public void setMostrarFK_IdFacturaDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdModuloDetalleMoviClienProve() {
		return this.mostrarFK_IdModuloDetalleMoviClienProve;
	}

	public void setMostrarFK_IdModuloDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdMonedaDetalleMoviClienProve() {
		return this.mostrarFK_IdMonedaDetalleMoviClienProve;
	}

	public void setMostrarFK_IdMonedaDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdPeriodoDetalleMoviClienProve() {
		return this.mostrarFK_IdPeriodoDetalleMoviClienProve;
	}

	public void setMostrarFK_IdPeriodoDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdSucursalDetalleMoviClienProve() {
		return this.mostrarFK_IdSucursalDetalleMoviClienProve;
	}

	public void setMostrarFK_IdSucursalDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloDetalleMoviClienProve() {
		return this.mostrarFK_IdTipoTransaccionModuloDetalleMoviClienProve;
	}

	public void setMostrarFK_IdTipoTransaccionModuloDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloDetalleMoviClienProve= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionDetalleMoviClienProve=true;

	public Boolean getMostrarFK_IdTransaccionDetalleMoviClienProve() {
		return this.mostrarFK_IdTransaccionDetalleMoviClienProve;
	}

	public void setMostrarFK_IdTransaccionDetalleMoviClienProve(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionDetalleMoviClienProve= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdAsientoContableDetalleMoviClienProve() {
		return this.activarFK_IdAsientoContableDetalleMoviClienProve;
	}

	public void setActivarFK_IdAsientoContableDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdClienteDetalleMoviClienProve() {
		return this.activarFK_IdClienteDetalleMoviClienProve;
	}

	public void setActivarFK_IdClienteDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleMoviClienProveDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdDetalleMoviClienProveDetalleMoviClienProve() {
		return this.activarFK_IdDetalleMoviClienProveDetalleMoviClienProve;
	}

	public void setActivarFK_IdDetalleMoviClienProveDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleMoviClienProveDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdEjercicioDetalleMoviClienProve() {
		return this.activarFK_IdEjercicioDetalleMoviClienProve;
	}

	public void setActivarFK_IdEjercicioDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdEmpresaDetalleMoviClienProve() {
		return this.activarFK_IdEmpresaDetalleMoviClienProve;
	}

	public void setActivarFK_IdEmpresaDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleClienteDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdEstadoDetalleClienteDetalleMoviClienProve() {
		return this.activarFK_IdEstadoDetalleClienteDetalleMoviClienProve;
	}

	public void setActivarFK_IdEstadoDetalleClienteDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleClienteDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdFacturaDetalleMoviClienProve() {
		return this.activarFK_IdFacturaDetalleMoviClienProve;
	}

	public void setActivarFK_IdFacturaDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdModuloDetalleMoviClienProve() {
		return this.activarFK_IdModuloDetalleMoviClienProve;
	}

	public void setActivarFK_IdModuloDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdMonedaDetalleMoviClienProve() {
		return this.activarFK_IdMonedaDetalleMoviClienProve;
	}

	public void setActivarFK_IdMonedaDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdPeriodoDetalleMoviClienProve() {
		return this.activarFK_IdPeriodoDetalleMoviClienProve;
	}

	public void setActivarFK_IdPeriodoDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdSucursalDetalleMoviClienProve() {
		return this.activarFK_IdSucursalDetalleMoviClienProve;
	}

	public void setActivarFK_IdSucursalDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloDetalleMoviClienProve() {
		return this.activarFK_IdTipoTransaccionModuloDetalleMoviClienProve;
	}

	public void setActivarFK_IdTipoTransaccionModuloDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloDetalleMoviClienProve= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionDetalleMoviClienProve=true;

	public Boolean getActivarFK_IdTransaccionDetalleMoviClienProve() {
		return this.activarFK_IdTransaccionDetalleMoviClienProve;
	}

	public void setActivarFK_IdTransaccionDetalleMoviClienProve(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionDetalleMoviClienProve= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDetalleMoviClienProve=null;

	public Border getResaltarFK_IdAsientoContableDetalleMoviClienProve() {
		return this.resaltarFK_IdAsientoContableDetalleMoviClienProve;
	}

	public void setResaltarFK_IdAsientoContableDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdClienteDetalleMoviClienProve=null;

	public Border getResaltarFK_IdClienteDetalleMoviClienProve() {
		return this.resaltarFK_IdClienteDetalleMoviClienProve;
	}

	public void setResaltarFK_IdClienteDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdClienteDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdClienteDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdDetalleMoviClienProveDetalleMoviClienProve=null;

	public Border getResaltarFK_IdDetalleMoviClienProveDetalleMoviClienProve() {
		return this.resaltarFK_IdDetalleMoviClienProveDetalleMoviClienProve;
	}

	public void setResaltarFK_IdDetalleMoviClienProveDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdDetalleMoviClienProveDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdDetalleMoviClienProveDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleMoviClienProveDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleMoviClienProve=null;

	public Border getResaltarFK_IdEjercicioDetalleMoviClienProve() {
		return this.resaltarFK_IdEjercicioDetalleMoviClienProve;
	}

	public void setResaltarFK_IdEjercicioDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleMoviClienProve=null;

	public Border getResaltarFK_IdEmpresaDetalleMoviClienProve() {
		return this.resaltarFK_IdEmpresaDetalleMoviClienProve;
	}

	public void setResaltarFK_IdEmpresaDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleClienteDetalleMoviClienProve=null;

	public Border getResaltarFK_IdEstadoDetalleClienteDetalleMoviClienProve() {
		return this.resaltarFK_IdEstadoDetalleClienteDetalleMoviClienProve;
	}

	public void setResaltarFK_IdEstadoDetalleClienteDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleClienteDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleClienteDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleClienteDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdFacturaDetalleMoviClienProve=null;

	public Border getResaltarFK_IdFacturaDetalleMoviClienProve() {
		return this.resaltarFK_IdFacturaDetalleMoviClienProve;
	}

	public void setResaltarFK_IdFacturaDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdFacturaDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdFacturaDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdModuloDetalleMoviClienProve=null;

	public Border getResaltarFK_IdModuloDetalleMoviClienProve() {
		return this.resaltarFK_IdModuloDetalleMoviClienProve;
	}

	public void setResaltarFK_IdModuloDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdModuloDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdModuloDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdMonedaDetalleMoviClienProve=null;

	public Border getResaltarFK_IdMonedaDetalleMoviClienProve() {
		return this.resaltarFK_IdMonedaDetalleMoviClienProve;
	}

	public void setResaltarFK_IdMonedaDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdMonedaDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdMonedaDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleMoviClienProve=null;

	public Border getResaltarFK_IdPeriodoDetalleMoviClienProve() {
		return this.resaltarFK_IdPeriodoDetalleMoviClienProve;
	}

	public void setResaltarFK_IdPeriodoDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleMoviClienProve=null;

	public Border getResaltarFK_IdSucursalDetalleMoviClienProve() {
		return this.resaltarFK_IdSucursalDetalleMoviClienProve;
	}

	public void setResaltarFK_IdSucursalDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloDetalleMoviClienProve=null;

	public Border getResaltarFK_IdTipoTransaccionModuloDetalleMoviClienProve() {
		return this.resaltarFK_IdTipoTransaccionModuloDetalleMoviClienProve;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloDetalleMoviClienProve= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionDetalleMoviClienProve=null;

	public Border getResaltarFK_IdTransaccionDetalleMoviClienProve() {
		return this.resaltarFK_IdTransaccionDetalleMoviClienProve;
	}

	public void setResaltarFK_IdTransaccionDetalleMoviClienProve(Border borderResaltar) {
		this.resaltarFK_IdTransaccionDetalleMoviClienProve= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionDetalleMoviClienProve(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleMoviClienProveBeanSwingJInternalFrame detallemoviclienproveBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionDetalleMoviClienProve= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}