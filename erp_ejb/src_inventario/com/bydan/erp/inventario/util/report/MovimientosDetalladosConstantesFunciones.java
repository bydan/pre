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
package com.bydan.erp.inventario.util.report;

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


import com.bydan.erp.inventario.util.report.MovimientosDetalladosConstantesFunciones;
import com.bydan.erp.inventario.util.report.MovimientosDetalladosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.MovimientosDetalladosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MovimientosDetalladosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="MovimientosDetallados";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MovimientosDetallados"+MovimientosDetalladosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MovimientosDetalladosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MovimientosDetalladosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MovimientosDetalladosConstantesFunciones.SCHEMA+"_"+MovimientosDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MovimientosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MovimientosDetalladosConstantesFunciones.SCHEMA+"_"+MovimientosDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MovimientosDetalladosConstantesFunciones.SCHEMA+"_"+MovimientosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MovimientosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MovimientosDetalladosConstantesFunciones.SCHEMA+"_"+MovimientosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientosDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientosDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MovimientosDetalladosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MovimientosDetalladosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MovimientosDetalladosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MovimientosDetalladosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Movimientos Detalladoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Movimientos Detallados";
	public static final String SCLASSWEBTITULO_LOWER="Movimientos Detallados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MovimientosDetallados";
	public static final String OBJECTNAME="movimientosdetallados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="movimientos_detallados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select movimientosdetallados from "+MovimientosDetalladosConstantesFunciones.SPERSISTENCENAME+" movimientosdetallados";
	public static String QUERYSELECTNATIVE="select "+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".version_row,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_empresa,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_sucursal,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_cliente,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_transaccion,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_linea,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_linea_grupo,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_linea_categoria,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".id_linea_marca,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".nombre_sucursal,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".nombre_transaccion,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".numero_comprobante,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".numero_factura,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".numero_secuencial,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".fecha_emision,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".nombre_producto,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".nombre_unidad,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".cantidad,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".iva,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".costo_unitario,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".costo_total,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".ice,"+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME+".codigo_producto from "+MovimientosDetalladosConstantesFunciones.SCHEMA+"."+MovimientosDetalladosConstantesFunciones.TABLENAME;//+" as "+MovimientosDetalladosConstantesFunciones.TABLENAME;
	
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
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDAD= "cantidad";
    public static final String IVA= "iva";
    public static final String COSTOUNITARIO= "costo_unitario";
    public static final String COSTOTOTAL= "costo_total";
    public static final String ICE= "ice";
    public static final String CODIGOPRODUCTO= "codigo_producto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_NUMEROSECUENCIAL= "Numero Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_COSTOUNITARIO= "Costo Unitario";
		public static final String LABEL_COSTOUNITARIO_LOWER= "Costo Unitario";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getMovimientosDetalladosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDEMPRESA)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDCLIENTE)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDTRANSACCION)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDLINEA)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISION)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.CANTIDAD)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.IVA)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.COSTOUNITARIO)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_COSTOUNITARIO;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.COSTOTOTAL)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.ICE)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=MovimientosDetalladosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMovimientosDetalladosDescripcion(MovimientosDetallados movimientosdetallados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(movimientosdetallados !=null/* && movimientosdetallados.getId()!=0*/) {
			if(movimientosdetallados.getId()!=null) {
				sDescripcion=movimientosdetallados.getId().toString();
			}//movimientosdetalladosmovimientosdetallados.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMovimientosDetalladosDescripcionDetallado(MovimientosDetallados movimientosdetallados) {
		String sDescripcion="";
			
		sDescripcion+=MovimientosDetalladosConstantesFunciones.ID+"=";
		sDescripcion+=movimientosdetallados.getId().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=movimientosdetallados.getVersionRow().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=movimientosdetallados.getid_empresa().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=movimientosdetallados.getid_sucursal().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=movimientosdetallados.getid_cliente().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=movimientosdetallados.getid_transaccion().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=movimientosdetallados.getid_linea().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=movimientosdetallados.getid_linea_grupo().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=movimientosdetallados.getid_linea_categoria().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=movimientosdetallados.getid_linea_marca().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=movimientosdetallados.getfecha_emision_desde().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=movimientosdetallados.getfecha_emision_hasta().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=movimientosdetallados.getnombre_sucursal()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=movimientosdetallados.getnombre_completo_cliente()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=movimientosdetallados.getnombre_transaccion()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=movimientosdetallados.getnumero_comprobante()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=movimientosdetallados.getnumero_factura()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=movimientosdetallados.getnumero_secuencial()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=movimientosdetallados.getfecha_emision().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=movimientosdetallados.getnombre_producto()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=movimientosdetallados.getnombre_unidad()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=movimientosdetallados.getcantidad().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.IVA+"=";
		sDescripcion+=movimientosdetallados.getiva().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.COSTOUNITARIO+"=";
		sDescripcion+=movimientosdetallados.getcosto_unitario().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=movimientosdetallados.getcosto_total().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.ICE+"=";
		sDescripcion+=movimientosdetallados.getice().toString()+",";
		sDescripcion+=MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=movimientosdetallados.getcodigo_producto()+",";
			
		return sDescripcion;
	}
	
	public static void setMovimientosDetalladosDescripcion(MovimientosDetallados movimientosdetallados,String sValor) throws Exception {			
		if(movimientosdetallados !=null) {
			//movimientosdetalladosmovimientosdetallados.getId().toString();
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaMovimientosDetallados")) {
			sNombreIndice="Tipo=  Por Cliente Por Transaccion Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaMovimientosDetallados(Long id_cliente,Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();}
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMovimientosDetallados(MovimientosDetallados movimientosdetallados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientosdetallados.setnombre_sucursal(movimientosdetallados.getnombre_sucursal().trim());
		movimientosdetallados.setnombre_completo_cliente(movimientosdetallados.getnombre_completo_cliente().trim());
		movimientosdetallados.setnombre_transaccion(movimientosdetallados.getnombre_transaccion().trim());
		movimientosdetallados.setnumero_comprobante(movimientosdetallados.getnumero_comprobante().trim());
		movimientosdetallados.setnumero_factura(movimientosdetallados.getnumero_factura().trim());
		movimientosdetallados.setnumero_secuencial(movimientosdetallados.getnumero_secuencial().trim());
		movimientosdetallados.setnombre_producto(movimientosdetallados.getnombre_producto().trim());
		movimientosdetallados.setnombre_unidad(movimientosdetallados.getnombre_unidad().trim());
		movimientosdetallados.setcodigo_producto(movimientosdetallados.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosMovimientosDetalladoss(List<MovimientosDetallados> movimientosdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientosDetallados movimientosdetallados: movimientosdetalladoss) {
			movimientosdetallados.setnombre_sucursal(movimientosdetallados.getnombre_sucursal().trim());
			movimientosdetallados.setnombre_completo_cliente(movimientosdetallados.getnombre_completo_cliente().trim());
			movimientosdetallados.setnombre_transaccion(movimientosdetallados.getnombre_transaccion().trim());
			movimientosdetallados.setnumero_comprobante(movimientosdetallados.getnumero_comprobante().trim());
			movimientosdetallados.setnumero_factura(movimientosdetallados.getnumero_factura().trim());
			movimientosdetallados.setnumero_secuencial(movimientosdetallados.getnumero_secuencial().trim());
			movimientosdetallados.setnombre_producto(movimientosdetallados.getnombre_producto().trim());
			movimientosdetallados.setnombre_unidad(movimientosdetallados.getnombre_unidad().trim());
			movimientosdetallados.setcodigo_producto(movimientosdetallados.getcodigo_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientosDetallados(MovimientosDetallados movimientosdetallados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && movimientosdetallados.getConCambioAuxiliar()) {
			movimientosdetallados.setIsDeleted(movimientosdetallados.getIsDeletedAuxiliar());	
			movimientosdetallados.setIsNew(movimientosdetallados.getIsNewAuxiliar());	
			movimientosdetallados.setIsChanged(movimientosdetallados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			movimientosdetallados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			movimientosdetallados.setIsDeletedAuxiliar(false);	
			movimientosdetallados.setIsNewAuxiliar(false);	
			movimientosdetallados.setIsChangedAuxiliar(false);
			
			movimientosdetallados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientosDetalladoss(List<MovimientosDetallados> movimientosdetalladoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MovimientosDetallados movimientosdetallados : movimientosdetalladoss) {
			if(conAsignarBase && movimientosdetallados.getConCambioAuxiliar()) {
				movimientosdetallados.setIsDeleted(movimientosdetallados.getIsDeletedAuxiliar());	
				movimientosdetallados.setIsNew(movimientosdetallados.getIsNewAuxiliar());	
				movimientosdetallados.setIsChanged(movimientosdetallados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				movimientosdetallados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				movimientosdetallados.setIsDeletedAuxiliar(false);	
				movimientosdetallados.setIsNewAuxiliar(false);	
				movimientosdetallados.setIsChangedAuxiliar(false);
				
				movimientosdetallados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMovimientosDetallados(MovimientosDetallados movimientosdetallados,Boolean conEnteros) throws Exception  {
		movimientosdetallados.setiva(0.0);
		movimientosdetallados.setcosto_unitario(0.0);
		movimientosdetallados.setcosto_total(0.0);
		movimientosdetallados.setice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			movimientosdetallados.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresMovimientosDetalladoss(List<MovimientosDetallados> movimientosdetalladoss,Boolean conEnteros) throws Exception  {
		
		for(MovimientosDetallados movimientosdetallados: movimientosdetalladoss) {
			movimientosdetallados.setiva(0.0);
			movimientosdetallados.setcosto_unitario(0.0);
			movimientosdetallados.setcosto_total(0.0);
			movimientosdetallados.setice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				movimientosdetallados.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaMovimientosDetallados(List<MovimientosDetallados> movimientosdetalladoss,MovimientosDetallados movimientosdetalladosAux) throws Exception  {
		MovimientosDetalladosConstantesFunciones.InicializarValoresMovimientosDetallados(movimientosdetalladosAux,true);
		
		for(MovimientosDetallados movimientosdetallados: movimientosdetalladoss) {
			if(movimientosdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			movimientosdetalladosAux.setcantidad(movimientosdetalladosAux.getcantidad()+movimientosdetallados.getcantidad());			
			movimientosdetalladosAux.setiva(movimientosdetalladosAux.getiva()+movimientosdetallados.getiva());			
			movimientosdetalladosAux.setcosto_unitario(movimientosdetalladosAux.getcosto_unitario()+movimientosdetallados.getcosto_unitario());			
			movimientosdetalladosAux.setcosto_total(movimientosdetalladosAux.getcosto_total()+movimientosdetallados.getcosto_total());			
			movimientosdetalladosAux.setice(movimientosdetalladosAux.getice()+movimientosdetallados.getice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientosDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MovimientosDetalladosConstantesFunciones.getArrayColumnasGlobalesMovimientosDetallados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientosDetallados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientosDetalladosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientosDetalladosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientosDetalladosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientosDetalladosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMovimientosDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MovimientosDetallados> movimientosdetalladoss,MovimientosDetallados movimientosdetallados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MovimientosDetallados movimientosdetalladosAux: movimientosdetalladoss) {
			if(movimientosdetalladosAux!=null && movimientosdetallados!=null) {
				if((movimientosdetalladosAux.getId()==null && movimientosdetallados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(movimientosdetalladosAux.getId()!=null && movimientosdetallados.getId()!=null){
					if(movimientosdetalladosAux.getId().equals(movimientosdetallados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMovimientosDetallados(List<MovimientosDetallados> movimientosdetalladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
		Double iceTotal=0.0;
	
		for(MovimientosDetallados movimientosdetallados: movimientosdetalladoss) {			
			if(movimientosdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ivaTotal+=movimientosdetallados.getiva();
			costo_unitarioTotal+=movimientosdetallados.getcosto_unitario();
			costo_totalTotal+=movimientosdetallados.getcosto_total();
			iceTotal+=movimientosdetallados.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosDetalladosConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMovimientosDetallados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_ID, MovimientosDetalladosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_VERSIONROW, MovimientosDetalladosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NOMBRESUCURSAL, MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NOMBRETRANSACCION, MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NUMEROCOMPROBANTE, MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NUMEROFACTURA, MovimientosDetalladosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NUMEROSECUENCIAL, MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISION, MovimientosDetalladosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NOMBREPRODUCTO, MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_NOMBREUNIDAD, MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_CANTIDAD, MovimientosDetalladosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_IVA, MovimientosDetalladosConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_COSTOUNITARIO, MovimientosDetalladosConstantesFunciones.COSTOUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_COSTOTOTAL, MovimientosDetalladosConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_ICE, MovimientosDetalladosConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientosDetalladosConstantesFunciones.LABEL_CODIGOPRODUCTO, MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMovimientosDetallados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.COSTOUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientosDetallados() throws Exception  {
		return MovimientosDetalladosConstantesFunciones.getTiposSeleccionarMovimientosDetallados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientosDetallados(Boolean conFk) throws Exception  {
		return MovimientosDetalladosConstantesFunciones.getTiposSeleccionarMovimientosDetallados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientosDetallados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_COSTOUNITARIO);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_COSTOUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientosDetalladosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(MovimientosDetalladosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMovimientosDetallados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientosDetallados(MovimientosDetallados movimientosdetalladosAux) throws Exception {
		
			movimientosdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientosdetalladosAux.getEmpresa()));
			movimientosdetalladosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientosdetalladosAux.getSucursal()));
			movimientosdetalladosAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(movimientosdetalladosAux.getCliente()));
			movimientosdetalladosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(movimientosdetalladosAux.getTransaccion()));
			movimientosdetalladosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLinea()));
			movimientosdetalladosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLineaGrupo()));
			movimientosdetalladosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLineaCategoria()));
			movimientosdetalladosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientosDetallados(List<MovimientosDetallados> movimientosdetalladossTemp) throws Exception {
		for(MovimientosDetallados movimientosdetalladosAux:movimientosdetalladossTemp) {
			
			movimientosdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientosdetalladosAux.getEmpresa()));
			movimientosdetalladosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientosdetalladosAux.getSucursal()));
			movimientosdetalladosAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(movimientosdetalladosAux.getCliente()));
			movimientosdetalladosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(movimientosdetalladosAux.getTransaccion()));
			movimientosdetalladosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLinea()));
			movimientosdetalladosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLineaGrupo()));
			movimientosdetalladosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLineaCategoria()));
			movimientosdetalladosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(movimientosdetalladosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMovimientosDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMovimientosDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientosDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientosDetalladosConstantesFunciones.getClassesRelationshipsOfMovimientosDetallados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientosDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientosDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientosDetalladosConstantesFunciones.getClassesRelationshipsFromStringsOfMovimientosDetallados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientosDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MovimientosDetallados movimientosdetallados,List<MovimientosDetallados> movimientosdetalladoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(MovimientosDetallados movimientosdetallados,List<MovimientosDetallados> movimientosdetalladoss) throws Exception {
		try	{			
			for(MovimientosDetallados movimientosdetalladosLocal:movimientosdetalladoss) {
				if(movimientosdetalladosLocal.getId().equals(movimientosdetallados.getId())) {
					movimientosdetalladosLocal.setIsSelected(movimientosdetallados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMovimientosDetallados(List<MovimientosDetallados> movimientosdetalladossAux) throws Exception {
		//this.movimientosdetalladossAux=movimientosdetalladossAux;
		
		for(MovimientosDetallados movimientosdetalladosAux:movimientosdetalladossAux) {
			if(movimientosdetalladosAux.getIsChanged()) {
				movimientosdetalladosAux.setIsChanged(false);
			}		
			
			if(movimientosdetalladosAux.getIsNew()) {
				movimientosdetalladosAux.setIsNew(false);
			}	
			
			if(movimientosdetalladosAux.getIsDeleted()) {
				movimientosdetalladosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMovimientosDetallados(MovimientosDetallados movimientosdetalladosAux) throws Exception {
		//this.movimientosdetalladosAux=movimientosdetalladosAux;
		
			if(movimientosdetalladosAux.getIsChanged()) {
				movimientosdetalladosAux.setIsChanged(false);
			}		
			
			if(movimientosdetalladosAux.getIsNew()) {
				movimientosdetalladosAux.setIsNew(false);
			}	
			
			if(movimientosdetalladosAux.getIsDeleted()) {
				movimientosdetalladosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MovimientosDetallados movimientosdetalladosAsignar,MovimientosDetallados movimientosdetallados) throws Exception {
		movimientosdetalladosAsignar.setId(movimientosdetallados.getId());	
		movimientosdetalladosAsignar.setVersionRow(movimientosdetallados.getVersionRow());	
		movimientosdetalladosAsignar.setnombre_sucursal(movimientosdetallados.getnombre_sucursal());	
		movimientosdetalladosAsignar.setnombre_completo_cliente(movimientosdetallados.getnombre_completo_cliente());	
		movimientosdetalladosAsignar.setnombre_transaccion(movimientosdetallados.getnombre_transaccion());	
		movimientosdetalladosAsignar.setnumero_comprobante(movimientosdetallados.getnumero_comprobante());	
		movimientosdetalladosAsignar.setnumero_factura(movimientosdetallados.getnumero_factura());	
		movimientosdetalladosAsignar.setnumero_secuencial(movimientosdetallados.getnumero_secuencial());	
		movimientosdetalladosAsignar.setfecha_emision(movimientosdetallados.getfecha_emision());	
		movimientosdetalladosAsignar.setnombre_producto(movimientosdetallados.getnombre_producto());	
		movimientosdetalladosAsignar.setnombre_unidad(movimientosdetallados.getnombre_unidad());	
		movimientosdetalladosAsignar.setcantidad(movimientosdetallados.getcantidad());	
		movimientosdetalladosAsignar.setiva(movimientosdetallados.getiva());	
		movimientosdetalladosAsignar.setcosto_unitario(movimientosdetallados.getcosto_unitario());	
		movimientosdetalladosAsignar.setcosto_total(movimientosdetallados.getcosto_total());	
		movimientosdetalladosAsignar.setice(movimientosdetallados.getice());	
		movimientosdetalladosAsignar.setcodigo_producto(movimientosdetallados.getcodigo_producto());	
	}
	
	public static void inicializarMovimientosDetallados(MovimientosDetallados movimientosdetallados) throws Exception {
		try {
				movimientosdetallados.setId(0L);	
					
				movimientosdetallados.setnombre_sucursal("");	
				movimientosdetallados.setnombre_completo_cliente("");	
				movimientosdetallados.setnombre_transaccion("");	
				movimientosdetallados.setnumero_comprobante("");	
				movimientosdetallados.setnumero_factura("");	
				movimientosdetallados.setnumero_secuencial("");	
				movimientosdetallados.setfecha_emision(new Date());	
				movimientosdetallados.setnombre_producto("");	
				movimientosdetallados.setnombre_unidad("");	
				movimientosdetallados.setcantidad(0);	
				movimientosdetallados.setiva(0.0);	
				movimientosdetallados.setcosto_unitario(0.0);	
				movimientosdetallados.setcosto_total(0.0);	
				movimientosdetallados.setice(0.0);	
				movimientosdetallados.setcodigo_producto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMovimientosDetallados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_COSTOUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientosDetalladosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMovimientosDetallados(String sTipo,Row row,Workbook workbook,MovimientosDetallados movimientosdetallados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getcosto_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientosdetallados.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMovimientosDetallados="";
	
	public String getsFinalQueryMovimientosDetallados() {
		return this.sFinalQueryMovimientosDetallados;
	}
	
	public void setsFinalQueryMovimientosDetallados(String sFinalQueryMovimientosDetallados) {
		this.sFinalQueryMovimientosDetallados= sFinalQueryMovimientosDetallados;
	}
	
	public Border resaltarSeleccionarMovimientosDetallados=null;
	
	public Border setResaltarSeleccionarMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMovimientosDetallados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMovimientosDetallados() {
		return this.resaltarSeleccionarMovimientosDetallados;
	}
	
	public void setResaltarSeleccionarMovimientosDetallados(Border borderResaltarSeleccionarMovimientosDetallados) {
		this.resaltarSeleccionarMovimientosDetallados= borderResaltarSeleccionarMovimientosDetallados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMovimientosDetallados=null;
	public Boolean mostraridMovimientosDetallados=true;
	public Boolean activaridMovimientosDetallados=true;

	public Border resaltarid_empresaMovimientosDetallados=null;
	public Boolean mostrarid_empresaMovimientosDetallados=true;
	public Boolean activarid_empresaMovimientosDetallados=true;
	public Boolean cargarid_empresaMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarid_sucursalMovimientosDetallados=null;
	public Boolean mostrarid_sucursalMovimientosDetallados=true;
	public Boolean activarid_sucursalMovimientosDetallados=true;
	public Boolean cargarid_sucursalMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarid_clienteMovimientosDetallados=null;
	public Boolean mostrarid_clienteMovimientosDetallados=true;
	public Boolean activarid_clienteMovimientosDetallados=true;
	public Boolean cargarid_clienteMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarid_transaccionMovimientosDetallados=null;
	public Boolean mostrarid_transaccionMovimientosDetallados=true;
	public Boolean activarid_transaccionMovimientosDetallados=true;
	public Boolean cargarid_transaccionMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarid_lineaMovimientosDetallados=null;
	public Boolean mostrarid_lineaMovimientosDetallados=true;
	public Boolean activarid_lineaMovimientosDetallados=true;
	public Boolean cargarid_lineaMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoMovimientosDetallados=null;
	public Boolean mostrarid_linea_grupoMovimientosDetallados=true;
	public Boolean activarid_linea_grupoMovimientosDetallados=true;
	public Boolean cargarid_linea_grupoMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaMovimientosDetallados=null;
	public Boolean mostrarid_linea_categoriaMovimientosDetallados=true;
	public Boolean activarid_linea_categoriaMovimientosDetallados=true;
	public Boolean cargarid_linea_categoriaMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaMovimientosDetallados=null;
	public Boolean mostrarid_linea_marcaMovimientosDetallados=true;
	public Boolean activarid_linea_marcaMovimientosDetallados=true;
	public Boolean cargarid_linea_marcaMovimientosDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaMovimientosDetallados=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeMovimientosDetallados=null;
	public Boolean mostrarfecha_emision_desdeMovimientosDetallados=true;
	public Boolean activarfecha_emision_desdeMovimientosDetallados=true;

	public Border resaltarfecha_emision_hastaMovimientosDetallados=null;
	public Boolean mostrarfecha_emision_hastaMovimientosDetallados=true;
	public Boolean activarfecha_emision_hastaMovimientosDetallados=true;

	public Border resaltarnombre_sucursalMovimientosDetallados=null;
	public Boolean mostrarnombre_sucursalMovimientosDetallados=true;
	public Boolean activarnombre_sucursalMovimientosDetallados=true;

	public Border resaltarnombre_completo_clienteMovimientosDetallados=null;
	public Boolean mostrarnombre_completo_clienteMovimientosDetallados=true;
	public Boolean activarnombre_completo_clienteMovimientosDetallados=true;

	public Border resaltarnombre_transaccionMovimientosDetallados=null;
	public Boolean mostrarnombre_transaccionMovimientosDetallados=true;
	public Boolean activarnombre_transaccionMovimientosDetallados=true;

	public Border resaltarnumero_comprobanteMovimientosDetallados=null;
	public Boolean mostrarnumero_comprobanteMovimientosDetallados=true;
	public Boolean activarnumero_comprobanteMovimientosDetallados=true;

	public Border resaltarnumero_facturaMovimientosDetallados=null;
	public Boolean mostrarnumero_facturaMovimientosDetallados=true;
	public Boolean activarnumero_facturaMovimientosDetallados=true;

	public Border resaltarnumero_secuencialMovimientosDetallados=null;
	public Boolean mostrarnumero_secuencialMovimientosDetallados=true;
	public Boolean activarnumero_secuencialMovimientosDetallados=true;

	public Border resaltarfecha_emisionMovimientosDetallados=null;
	public Boolean mostrarfecha_emisionMovimientosDetallados=true;
	public Boolean activarfecha_emisionMovimientosDetallados=true;

	public Border resaltarnombre_productoMovimientosDetallados=null;
	public Boolean mostrarnombre_productoMovimientosDetallados=true;
	public Boolean activarnombre_productoMovimientosDetallados=true;

	public Border resaltarnombre_unidadMovimientosDetallados=null;
	public Boolean mostrarnombre_unidadMovimientosDetallados=true;
	public Boolean activarnombre_unidadMovimientosDetallados=true;

	public Border resaltarcantidadMovimientosDetallados=null;
	public Boolean mostrarcantidadMovimientosDetallados=true;
	public Boolean activarcantidadMovimientosDetallados=true;

	public Border resaltarivaMovimientosDetallados=null;
	public Boolean mostrarivaMovimientosDetallados=true;
	public Boolean activarivaMovimientosDetallados=true;

	public Border resaltarcosto_unitarioMovimientosDetallados=null;
	public Boolean mostrarcosto_unitarioMovimientosDetallados=true;
	public Boolean activarcosto_unitarioMovimientosDetallados=true;

	public Border resaltarcosto_totalMovimientosDetallados=null;
	public Boolean mostrarcosto_totalMovimientosDetallados=true;
	public Boolean activarcosto_totalMovimientosDetallados=true;

	public Border resaltariceMovimientosDetallados=null;
	public Boolean mostrariceMovimientosDetallados=true;
	public Boolean activariceMovimientosDetallados=true;

	public Border resaltarcodigo_productoMovimientosDetallados=null;
	public Boolean mostrarcodigo_productoMovimientosDetallados=true;
	public Boolean activarcodigo_productoMovimientosDetallados=true;

	
	

	public Border setResaltaridMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltaridMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMovimientosDetallados() {
		return this.resaltaridMovimientosDetallados;
	}

	public void setResaltaridMovimientosDetallados(Border borderResaltar) {
		this.resaltaridMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostraridMovimientosDetallados() {
		return this.mostraridMovimientosDetallados;
	}

	public void setMostraridMovimientosDetallados(Boolean mostraridMovimientosDetallados) {
		this.mostraridMovimientosDetallados= mostraridMovimientosDetallados;
	}

	public Boolean getActivaridMovimientosDetallados() {
		return this.activaridMovimientosDetallados;
	}

	public void setActivaridMovimientosDetallados(Boolean activaridMovimientosDetallados) {
		this.activaridMovimientosDetallados= activaridMovimientosDetallados;
	}

	public Border setResaltarid_empresaMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_empresaMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMovimientosDetallados() {
		return this.resaltarid_empresaMovimientosDetallados;
	}

	public void setResaltarid_empresaMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_empresaMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_empresaMovimientosDetallados() {
		return this.mostrarid_empresaMovimientosDetallados;
	}

	public void setMostrarid_empresaMovimientosDetallados(Boolean mostrarid_empresaMovimientosDetallados) {
		this.mostrarid_empresaMovimientosDetallados= mostrarid_empresaMovimientosDetallados;
	}

	public Boolean getActivarid_empresaMovimientosDetallados() {
		return this.activarid_empresaMovimientosDetallados;
	}

	public void setActivarid_empresaMovimientosDetallados(Boolean activarid_empresaMovimientosDetallados) {
		this.activarid_empresaMovimientosDetallados= activarid_empresaMovimientosDetallados;
	}

	public Boolean getCargarid_empresaMovimientosDetallados() {
		return this.cargarid_empresaMovimientosDetallados;
	}

	public void setCargarid_empresaMovimientosDetallados(Boolean cargarid_empresaMovimientosDetallados) {
		this.cargarid_empresaMovimientosDetallados= cargarid_empresaMovimientosDetallados;
	}

	public Border setResaltarid_sucursalMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMovimientosDetallados() {
		return this.resaltarid_sucursalMovimientosDetallados;
	}

	public void setResaltarid_sucursalMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_sucursalMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMovimientosDetallados() {
		return this.mostrarid_sucursalMovimientosDetallados;
	}

	public void setMostrarid_sucursalMovimientosDetallados(Boolean mostrarid_sucursalMovimientosDetallados) {
		this.mostrarid_sucursalMovimientosDetallados= mostrarid_sucursalMovimientosDetallados;
	}

	public Boolean getActivarid_sucursalMovimientosDetallados() {
		return this.activarid_sucursalMovimientosDetallados;
	}

	public void setActivarid_sucursalMovimientosDetallados(Boolean activarid_sucursalMovimientosDetallados) {
		this.activarid_sucursalMovimientosDetallados= activarid_sucursalMovimientosDetallados;
	}

	public Boolean getCargarid_sucursalMovimientosDetallados() {
		return this.cargarid_sucursalMovimientosDetallados;
	}

	public void setCargarid_sucursalMovimientosDetallados(Boolean cargarid_sucursalMovimientosDetallados) {
		this.cargarid_sucursalMovimientosDetallados= cargarid_sucursalMovimientosDetallados;
	}

	public Border setResaltarid_clienteMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_clienteMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteMovimientosDetallados() {
		return this.resaltarid_clienteMovimientosDetallados;
	}

	public void setResaltarid_clienteMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_clienteMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_clienteMovimientosDetallados() {
		return this.mostrarid_clienteMovimientosDetallados;
	}

	public void setMostrarid_clienteMovimientosDetallados(Boolean mostrarid_clienteMovimientosDetallados) {
		this.mostrarid_clienteMovimientosDetallados= mostrarid_clienteMovimientosDetallados;
	}

	public Boolean getActivarid_clienteMovimientosDetallados() {
		return this.activarid_clienteMovimientosDetallados;
	}

	public void setActivarid_clienteMovimientosDetallados(Boolean activarid_clienteMovimientosDetallados) {
		this.activarid_clienteMovimientosDetallados= activarid_clienteMovimientosDetallados;
	}

	public Boolean getCargarid_clienteMovimientosDetallados() {
		return this.cargarid_clienteMovimientosDetallados;
	}

	public void setCargarid_clienteMovimientosDetallados(Boolean cargarid_clienteMovimientosDetallados) {
		this.cargarid_clienteMovimientosDetallados= cargarid_clienteMovimientosDetallados;
	}

	public Border setResaltarid_transaccionMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_transaccionMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionMovimientosDetallados() {
		return this.resaltarid_transaccionMovimientosDetallados;
	}

	public void setResaltarid_transaccionMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_transaccionMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_transaccionMovimientosDetallados() {
		return this.mostrarid_transaccionMovimientosDetallados;
	}

	public void setMostrarid_transaccionMovimientosDetallados(Boolean mostrarid_transaccionMovimientosDetallados) {
		this.mostrarid_transaccionMovimientosDetallados= mostrarid_transaccionMovimientosDetallados;
	}

	public Boolean getActivarid_transaccionMovimientosDetallados() {
		return this.activarid_transaccionMovimientosDetallados;
	}

	public void setActivarid_transaccionMovimientosDetallados(Boolean activarid_transaccionMovimientosDetallados) {
		this.activarid_transaccionMovimientosDetallados= activarid_transaccionMovimientosDetallados;
	}

	public Boolean getCargarid_transaccionMovimientosDetallados() {
		return this.cargarid_transaccionMovimientosDetallados;
	}

	public void setCargarid_transaccionMovimientosDetallados(Boolean cargarid_transaccionMovimientosDetallados) {
		this.cargarid_transaccionMovimientosDetallados= cargarid_transaccionMovimientosDetallados;
	}

	public Border setResaltarid_lineaMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_lineaMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaMovimientosDetallados() {
		return this.resaltarid_lineaMovimientosDetallados;
	}

	public void setResaltarid_lineaMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_lineaMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_lineaMovimientosDetallados() {
		return this.mostrarid_lineaMovimientosDetallados;
	}

	public void setMostrarid_lineaMovimientosDetallados(Boolean mostrarid_lineaMovimientosDetallados) {
		this.mostrarid_lineaMovimientosDetallados= mostrarid_lineaMovimientosDetallados;
	}

	public Boolean getActivarid_lineaMovimientosDetallados() {
		return this.activarid_lineaMovimientosDetallados;
	}

	public void setActivarid_lineaMovimientosDetallados(Boolean activarid_lineaMovimientosDetallados) {
		this.activarid_lineaMovimientosDetallados= activarid_lineaMovimientosDetallados;
	}

	public Boolean getCargarid_lineaMovimientosDetallados() {
		return this.cargarid_lineaMovimientosDetallados;
	}

	public void setCargarid_lineaMovimientosDetallados(Boolean cargarid_lineaMovimientosDetallados) {
		this.cargarid_lineaMovimientosDetallados= cargarid_lineaMovimientosDetallados;
	}

	public Border setResaltarid_linea_grupoMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoMovimientosDetallados() {
		return this.resaltarid_linea_grupoMovimientosDetallados;
	}

	public void setResaltarid_linea_grupoMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_linea_grupoMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoMovimientosDetallados() {
		return this.mostrarid_linea_grupoMovimientosDetallados;
	}

	public void setMostrarid_linea_grupoMovimientosDetallados(Boolean mostrarid_linea_grupoMovimientosDetallados) {
		this.mostrarid_linea_grupoMovimientosDetallados= mostrarid_linea_grupoMovimientosDetallados;
	}

	public Boolean getActivarid_linea_grupoMovimientosDetallados() {
		return this.activarid_linea_grupoMovimientosDetallados;
	}

	public void setActivarid_linea_grupoMovimientosDetallados(Boolean activarid_linea_grupoMovimientosDetallados) {
		this.activarid_linea_grupoMovimientosDetallados= activarid_linea_grupoMovimientosDetallados;
	}

	public Boolean getCargarid_linea_grupoMovimientosDetallados() {
		return this.cargarid_linea_grupoMovimientosDetallados;
	}

	public void setCargarid_linea_grupoMovimientosDetallados(Boolean cargarid_linea_grupoMovimientosDetallados) {
		this.cargarid_linea_grupoMovimientosDetallados= cargarid_linea_grupoMovimientosDetallados;
	}

	public Border setResaltarid_linea_categoriaMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaMovimientosDetallados() {
		return this.resaltarid_linea_categoriaMovimientosDetallados;
	}

	public void setResaltarid_linea_categoriaMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_linea_categoriaMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaMovimientosDetallados() {
		return this.mostrarid_linea_categoriaMovimientosDetallados;
	}

	public void setMostrarid_linea_categoriaMovimientosDetallados(Boolean mostrarid_linea_categoriaMovimientosDetallados) {
		this.mostrarid_linea_categoriaMovimientosDetallados= mostrarid_linea_categoriaMovimientosDetallados;
	}

	public Boolean getActivarid_linea_categoriaMovimientosDetallados() {
		return this.activarid_linea_categoriaMovimientosDetallados;
	}

	public void setActivarid_linea_categoriaMovimientosDetallados(Boolean activarid_linea_categoriaMovimientosDetallados) {
		this.activarid_linea_categoriaMovimientosDetallados= activarid_linea_categoriaMovimientosDetallados;
	}

	public Boolean getCargarid_linea_categoriaMovimientosDetallados() {
		return this.cargarid_linea_categoriaMovimientosDetallados;
	}

	public void setCargarid_linea_categoriaMovimientosDetallados(Boolean cargarid_linea_categoriaMovimientosDetallados) {
		this.cargarid_linea_categoriaMovimientosDetallados= cargarid_linea_categoriaMovimientosDetallados;
	}

	public Border setResaltarid_linea_marcaMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaMovimientosDetallados() {
		return this.resaltarid_linea_marcaMovimientosDetallados;
	}

	public void setResaltarid_linea_marcaMovimientosDetallados(Border borderResaltar) {
		this.resaltarid_linea_marcaMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaMovimientosDetallados() {
		return this.mostrarid_linea_marcaMovimientosDetallados;
	}

	public void setMostrarid_linea_marcaMovimientosDetallados(Boolean mostrarid_linea_marcaMovimientosDetallados) {
		this.mostrarid_linea_marcaMovimientosDetallados= mostrarid_linea_marcaMovimientosDetallados;
	}

	public Boolean getActivarid_linea_marcaMovimientosDetallados() {
		return this.activarid_linea_marcaMovimientosDetallados;
	}

	public void setActivarid_linea_marcaMovimientosDetallados(Boolean activarid_linea_marcaMovimientosDetallados) {
		this.activarid_linea_marcaMovimientosDetallados= activarid_linea_marcaMovimientosDetallados;
	}

	public Boolean getCargarid_linea_marcaMovimientosDetallados() {
		return this.cargarid_linea_marcaMovimientosDetallados;
	}

	public void setCargarid_linea_marcaMovimientosDetallados(Boolean cargarid_linea_marcaMovimientosDetallados) {
		this.cargarid_linea_marcaMovimientosDetallados= cargarid_linea_marcaMovimientosDetallados;
	}

	public Border setResaltarfecha_emision_desdeMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeMovimientosDetallados() {
		return this.resaltarfecha_emision_desdeMovimientosDetallados;
	}

	public void setResaltarfecha_emision_desdeMovimientosDetallados(Border borderResaltar) {
		this.resaltarfecha_emision_desdeMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeMovimientosDetallados() {
		return this.mostrarfecha_emision_desdeMovimientosDetallados;
	}

	public void setMostrarfecha_emision_desdeMovimientosDetallados(Boolean mostrarfecha_emision_desdeMovimientosDetallados) {
		this.mostrarfecha_emision_desdeMovimientosDetallados= mostrarfecha_emision_desdeMovimientosDetallados;
	}

	public Boolean getActivarfecha_emision_desdeMovimientosDetallados() {
		return this.activarfecha_emision_desdeMovimientosDetallados;
	}

	public void setActivarfecha_emision_desdeMovimientosDetallados(Boolean activarfecha_emision_desdeMovimientosDetallados) {
		this.activarfecha_emision_desdeMovimientosDetallados= activarfecha_emision_desdeMovimientosDetallados;
	}

	public Border setResaltarfecha_emision_hastaMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaMovimientosDetallados() {
		return this.resaltarfecha_emision_hastaMovimientosDetallados;
	}

	public void setResaltarfecha_emision_hastaMovimientosDetallados(Border borderResaltar) {
		this.resaltarfecha_emision_hastaMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaMovimientosDetallados() {
		return this.mostrarfecha_emision_hastaMovimientosDetallados;
	}

	public void setMostrarfecha_emision_hastaMovimientosDetallados(Boolean mostrarfecha_emision_hastaMovimientosDetallados) {
		this.mostrarfecha_emision_hastaMovimientosDetallados= mostrarfecha_emision_hastaMovimientosDetallados;
	}

	public Boolean getActivarfecha_emision_hastaMovimientosDetallados() {
		return this.activarfecha_emision_hastaMovimientosDetallados;
	}

	public void setActivarfecha_emision_hastaMovimientosDetallados(Boolean activarfecha_emision_hastaMovimientosDetallados) {
		this.activarfecha_emision_hastaMovimientosDetallados= activarfecha_emision_hastaMovimientosDetallados;
	}

	public Border setResaltarnombre_sucursalMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalMovimientosDetallados() {
		return this.resaltarnombre_sucursalMovimientosDetallados;
	}

	public void setResaltarnombre_sucursalMovimientosDetallados(Border borderResaltar) {
		this.resaltarnombre_sucursalMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalMovimientosDetallados() {
		return this.mostrarnombre_sucursalMovimientosDetallados;
	}

	public void setMostrarnombre_sucursalMovimientosDetallados(Boolean mostrarnombre_sucursalMovimientosDetallados) {
		this.mostrarnombre_sucursalMovimientosDetallados= mostrarnombre_sucursalMovimientosDetallados;
	}

	public Boolean getActivarnombre_sucursalMovimientosDetallados() {
		return this.activarnombre_sucursalMovimientosDetallados;
	}

	public void setActivarnombre_sucursalMovimientosDetallados(Boolean activarnombre_sucursalMovimientosDetallados) {
		this.activarnombre_sucursalMovimientosDetallados= activarnombre_sucursalMovimientosDetallados;
	}

	public Border setResaltarnombre_completo_clienteMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteMovimientosDetallados() {
		return this.resaltarnombre_completo_clienteMovimientosDetallados;
	}

	public void setResaltarnombre_completo_clienteMovimientosDetallados(Border borderResaltar) {
		this.resaltarnombre_completo_clienteMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteMovimientosDetallados() {
		return this.mostrarnombre_completo_clienteMovimientosDetallados;
	}

	public void setMostrarnombre_completo_clienteMovimientosDetallados(Boolean mostrarnombre_completo_clienteMovimientosDetallados) {
		this.mostrarnombre_completo_clienteMovimientosDetallados= mostrarnombre_completo_clienteMovimientosDetallados;
	}

	public Boolean getActivarnombre_completo_clienteMovimientosDetallados() {
		return this.activarnombre_completo_clienteMovimientosDetallados;
	}

	public void setActivarnombre_completo_clienteMovimientosDetallados(Boolean activarnombre_completo_clienteMovimientosDetallados) {
		this.activarnombre_completo_clienteMovimientosDetallados= activarnombre_completo_clienteMovimientosDetallados;
	}

	public Border setResaltarnombre_transaccionMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionMovimientosDetallados() {
		return this.resaltarnombre_transaccionMovimientosDetallados;
	}

	public void setResaltarnombre_transaccionMovimientosDetallados(Border borderResaltar) {
		this.resaltarnombre_transaccionMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionMovimientosDetallados() {
		return this.mostrarnombre_transaccionMovimientosDetallados;
	}

	public void setMostrarnombre_transaccionMovimientosDetallados(Boolean mostrarnombre_transaccionMovimientosDetallados) {
		this.mostrarnombre_transaccionMovimientosDetallados= mostrarnombre_transaccionMovimientosDetallados;
	}

	public Boolean getActivarnombre_transaccionMovimientosDetallados() {
		return this.activarnombre_transaccionMovimientosDetallados;
	}

	public void setActivarnombre_transaccionMovimientosDetallados(Boolean activarnombre_transaccionMovimientosDetallados) {
		this.activarnombre_transaccionMovimientosDetallados= activarnombre_transaccionMovimientosDetallados;
	}

	public Border setResaltarnumero_comprobanteMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteMovimientosDetallados() {
		return this.resaltarnumero_comprobanteMovimientosDetallados;
	}

	public void setResaltarnumero_comprobanteMovimientosDetallados(Border borderResaltar) {
		this.resaltarnumero_comprobanteMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteMovimientosDetallados() {
		return this.mostrarnumero_comprobanteMovimientosDetallados;
	}

	public void setMostrarnumero_comprobanteMovimientosDetallados(Boolean mostrarnumero_comprobanteMovimientosDetallados) {
		this.mostrarnumero_comprobanteMovimientosDetallados= mostrarnumero_comprobanteMovimientosDetallados;
	}

	public Boolean getActivarnumero_comprobanteMovimientosDetallados() {
		return this.activarnumero_comprobanteMovimientosDetallados;
	}

	public void setActivarnumero_comprobanteMovimientosDetallados(Boolean activarnumero_comprobanteMovimientosDetallados) {
		this.activarnumero_comprobanteMovimientosDetallados= activarnumero_comprobanteMovimientosDetallados;
	}

	public Border setResaltarnumero_facturaMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaMovimientosDetallados() {
		return this.resaltarnumero_facturaMovimientosDetallados;
	}

	public void setResaltarnumero_facturaMovimientosDetallados(Border borderResaltar) {
		this.resaltarnumero_facturaMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaMovimientosDetallados() {
		return this.mostrarnumero_facturaMovimientosDetallados;
	}

	public void setMostrarnumero_facturaMovimientosDetallados(Boolean mostrarnumero_facturaMovimientosDetallados) {
		this.mostrarnumero_facturaMovimientosDetallados= mostrarnumero_facturaMovimientosDetallados;
	}

	public Boolean getActivarnumero_facturaMovimientosDetallados() {
		return this.activarnumero_facturaMovimientosDetallados;
	}

	public void setActivarnumero_facturaMovimientosDetallados(Boolean activarnumero_facturaMovimientosDetallados) {
		this.activarnumero_facturaMovimientosDetallados= activarnumero_facturaMovimientosDetallados;
	}

	public Border setResaltarnumero_secuencialMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialMovimientosDetallados() {
		return this.resaltarnumero_secuencialMovimientosDetallados;
	}

	public void setResaltarnumero_secuencialMovimientosDetallados(Border borderResaltar) {
		this.resaltarnumero_secuencialMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialMovimientosDetallados() {
		return this.mostrarnumero_secuencialMovimientosDetallados;
	}

	public void setMostrarnumero_secuencialMovimientosDetallados(Boolean mostrarnumero_secuencialMovimientosDetallados) {
		this.mostrarnumero_secuencialMovimientosDetallados= mostrarnumero_secuencialMovimientosDetallados;
	}

	public Boolean getActivarnumero_secuencialMovimientosDetallados() {
		return this.activarnumero_secuencialMovimientosDetallados;
	}

	public void setActivarnumero_secuencialMovimientosDetallados(Boolean activarnumero_secuencialMovimientosDetallados) {
		this.activarnumero_secuencialMovimientosDetallados= activarnumero_secuencialMovimientosDetallados;
	}

	public Border setResaltarfecha_emisionMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionMovimientosDetallados() {
		return this.resaltarfecha_emisionMovimientosDetallados;
	}

	public void setResaltarfecha_emisionMovimientosDetallados(Border borderResaltar) {
		this.resaltarfecha_emisionMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionMovimientosDetallados() {
		return this.mostrarfecha_emisionMovimientosDetallados;
	}

	public void setMostrarfecha_emisionMovimientosDetallados(Boolean mostrarfecha_emisionMovimientosDetallados) {
		this.mostrarfecha_emisionMovimientosDetallados= mostrarfecha_emisionMovimientosDetallados;
	}

	public Boolean getActivarfecha_emisionMovimientosDetallados() {
		return this.activarfecha_emisionMovimientosDetallados;
	}

	public void setActivarfecha_emisionMovimientosDetallados(Boolean activarfecha_emisionMovimientosDetallados) {
		this.activarfecha_emisionMovimientosDetallados= activarfecha_emisionMovimientosDetallados;
	}

	public Border setResaltarnombre_productoMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_productoMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoMovimientosDetallados() {
		return this.resaltarnombre_productoMovimientosDetallados;
	}

	public void setResaltarnombre_productoMovimientosDetallados(Border borderResaltar) {
		this.resaltarnombre_productoMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_productoMovimientosDetallados() {
		return this.mostrarnombre_productoMovimientosDetallados;
	}

	public void setMostrarnombre_productoMovimientosDetallados(Boolean mostrarnombre_productoMovimientosDetallados) {
		this.mostrarnombre_productoMovimientosDetallados= mostrarnombre_productoMovimientosDetallados;
	}

	public Boolean getActivarnombre_productoMovimientosDetallados() {
		return this.activarnombre_productoMovimientosDetallados;
	}

	public void setActivarnombre_productoMovimientosDetallados(Boolean activarnombre_productoMovimientosDetallados) {
		this.activarnombre_productoMovimientosDetallados= activarnombre_productoMovimientosDetallados;
	}

	public Border setResaltarnombre_unidadMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadMovimientosDetallados() {
		return this.resaltarnombre_unidadMovimientosDetallados;
	}

	public void setResaltarnombre_unidadMovimientosDetallados(Border borderResaltar) {
		this.resaltarnombre_unidadMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadMovimientosDetallados() {
		return this.mostrarnombre_unidadMovimientosDetallados;
	}

	public void setMostrarnombre_unidadMovimientosDetallados(Boolean mostrarnombre_unidadMovimientosDetallados) {
		this.mostrarnombre_unidadMovimientosDetallados= mostrarnombre_unidadMovimientosDetallados;
	}

	public Boolean getActivarnombre_unidadMovimientosDetallados() {
		return this.activarnombre_unidadMovimientosDetallados;
	}

	public void setActivarnombre_unidadMovimientosDetallados(Boolean activarnombre_unidadMovimientosDetallados) {
		this.activarnombre_unidadMovimientosDetallados= activarnombre_unidadMovimientosDetallados;
	}

	public Border setResaltarcantidadMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarcantidadMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadMovimientosDetallados() {
		return this.resaltarcantidadMovimientosDetallados;
	}

	public void setResaltarcantidadMovimientosDetallados(Border borderResaltar) {
		this.resaltarcantidadMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarcantidadMovimientosDetallados() {
		return this.mostrarcantidadMovimientosDetallados;
	}

	public void setMostrarcantidadMovimientosDetallados(Boolean mostrarcantidadMovimientosDetallados) {
		this.mostrarcantidadMovimientosDetallados= mostrarcantidadMovimientosDetallados;
	}

	public Boolean getActivarcantidadMovimientosDetallados() {
		return this.activarcantidadMovimientosDetallados;
	}

	public void setActivarcantidadMovimientosDetallados(Boolean activarcantidadMovimientosDetallados) {
		this.activarcantidadMovimientosDetallados= activarcantidadMovimientosDetallados;
	}

	public Border setResaltarivaMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarivaMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaMovimientosDetallados() {
		return this.resaltarivaMovimientosDetallados;
	}

	public void setResaltarivaMovimientosDetallados(Border borderResaltar) {
		this.resaltarivaMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarivaMovimientosDetallados() {
		return this.mostrarivaMovimientosDetallados;
	}

	public void setMostrarivaMovimientosDetallados(Boolean mostrarivaMovimientosDetallados) {
		this.mostrarivaMovimientosDetallados= mostrarivaMovimientosDetallados;
	}

	public Boolean getActivarivaMovimientosDetallados() {
		return this.activarivaMovimientosDetallados;
	}

	public void setActivarivaMovimientosDetallados(Boolean activarivaMovimientosDetallados) {
		this.activarivaMovimientosDetallados= activarivaMovimientosDetallados;
	}

	public Border setResaltarcosto_unitarioMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarcosto_unitarioMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_unitarioMovimientosDetallados() {
		return this.resaltarcosto_unitarioMovimientosDetallados;
	}

	public void setResaltarcosto_unitarioMovimientosDetallados(Border borderResaltar) {
		this.resaltarcosto_unitarioMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarcosto_unitarioMovimientosDetallados() {
		return this.mostrarcosto_unitarioMovimientosDetallados;
	}

	public void setMostrarcosto_unitarioMovimientosDetallados(Boolean mostrarcosto_unitarioMovimientosDetallados) {
		this.mostrarcosto_unitarioMovimientosDetallados= mostrarcosto_unitarioMovimientosDetallados;
	}

	public Boolean getActivarcosto_unitarioMovimientosDetallados() {
		return this.activarcosto_unitarioMovimientosDetallados;
	}

	public void setActivarcosto_unitarioMovimientosDetallados(Boolean activarcosto_unitarioMovimientosDetallados) {
		this.activarcosto_unitarioMovimientosDetallados= activarcosto_unitarioMovimientosDetallados;
	}

	public Border setResaltarcosto_totalMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarcosto_totalMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalMovimientosDetallados() {
		return this.resaltarcosto_totalMovimientosDetallados;
	}

	public void setResaltarcosto_totalMovimientosDetallados(Border borderResaltar) {
		this.resaltarcosto_totalMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarcosto_totalMovimientosDetallados() {
		return this.mostrarcosto_totalMovimientosDetallados;
	}

	public void setMostrarcosto_totalMovimientosDetallados(Boolean mostrarcosto_totalMovimientosDetallados) {
		this.mostrarcosto_totalMovimientosDetallados= mostrarcosto_totalMovimientosDetallados;
	}

	public Boolean getActivarcosto_totalMovimientosDetallados() {
		return this.activarcosto_totalMovimientosDetallados;
	}

	public void setActivarcosto_totalMovimientosDetallados(Boolean activarcosto_totalMovimientosDetallados) {
		this.activarcosto_totalMovimientosDetallados= activarcosto_totalMovimientosDetallados;
	}

	public Border setResaltariceMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltariceMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceMovimientosDetallados() {
		return this.resaltariceMovimientosDetallados;
	}

	public void setResaltariceMovimientosDetallados(Border borderResaltar) {
		this.resaltariceMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrariceMovimientosDetallados() {
		return this.mostrariceMovimientosDetallados;
	}

	public void setMostrariceMovimientosDetallados(Boolean mostrariceMovimientosDetallados) {
		this.mostrariceMovimientosDetallados= mostrariceMovimientosDetallados;
	}

	public Boolean getActivariceMovimientosDetallados() {
		return this.activariceMovimientosDetallados;
	}

	public void setActivariceMovimientosDetallados(Boolean activariceMovimientosDetallados) {
		this.activariceMovimientosDetallados= activariceMovimientosDetallados;
	}

	public Border setResaltarcodigo_productoMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientosdetalladosBeanSwingJInternalFrame.jTtoolBarMovimientosDetallados.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoMovimientosDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoMovimientosDetallados() {
		return this.resaltarcodigo_productoMovimientosDetallados;
	}

	public void setResaltarcodigo_productoMovimientosDetallados(Border borderResaltar) {
		this.resaltarcodigo_productoMovimientosDetallados= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoMovimientosDetallados() {
		return this.mostrarcodigo_productoMovimientosDetallados;
	}

	public void setMostrarcodigo_productoMovimientosDetallados(Boolean mostrarcodigo_productoMovimientosDetallados) {
		this.mostrarcodigo_productoMovimientosDetallados= mostrarcodigo_productoMovimientosDetallados;
	}

	public Boolean getActivarcodigo_productoMovimientosDetallados() {
		return this.activarcodigo_productoMovimientosDetallados;
	}

	public void setActivarcodigo_productoMovimientosDetallados(Boolean activarcodigo_productoMovimientosDetallados) {
		this.activarcodigo_productoMovimientosDetallados= activarcodigo_productoMovimientosDetallados;
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
		
		
		this.setMostraridMovimientosDetallados(esInicial);
		this.setMostrarid_empresaMovimientosDetallados(esInicial);
		this.setMostrarid_sucursalMovimientosDetallados(esInicial);
		this.setMostrarid_clienteMovimientosDetallados(esInicial);
		this.setMostrarid_transaccionMovimientosDetallados(esInicial);
		this.setMostrarid_lineaMovimientosDetallados(esInicial);
		this.setMostrarid_linea_grupoMovimientosDetallados(esInicial);
		this.setMostrarid_linea_categoriaMovimientosDetallados(esInicial);
		this.setMostrarid_linea_marcaMovimientosDetallados(esInicial);
		this.setMostrarfecha_emision_desdeMovimientosDetallados(esInicial);
		this.setMostrarfecha_emision_hastaMovimientosDetallados(esInicial);
		this.setMostrarnombre_sucursalMovimientosDetallados(esInicial);
		this.setMostrarnombre_completo_clienteMovimientosDetallados(esInicial);
		this.setMostrarnombre_transaccionMovimientosDetallados(esInicial);
		this.setMostrarnumero_comprobanteMovimientosDetallados(esInicial);
		this.setMostrarnumero_facturaMovimientosDetallados(esInicial);
		this.setMostrarnumero_secuencialMovimientosDetallados(esInicial);
		this.setMostrarfecha_emisionMovimientosDetallados(esInicial);
		this.setMostrarnombre_productoMovimientosDetallados(esInicial);
		this.setMostrarnombre_unidadMovimientosDetallados(esInicial);
		this.setMostrarcantidadMovimientosDetallados(esInicial);
		this.setMostrarivaMovimientosDetallados(esInicial);
		this.setMostrarcosto_unitarioMovimientosDetallados(esInicial);
		this.setMostrarcosto_totalMovimientosDetallados(esInicial);
		this.setMostrariceMovimientosDetallados(esInicial);
		this.setMostrarcodigo_productoMovimientosDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.ID)) {
				this.setMostraridMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IVA)) {
				this.setMostrarivaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.COSTOUNITARIO)) {
				this.setMostrarcosto_unitarioMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.ICE)) {
				this.setMostrariceMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoMovimientosDetallados(esAsigna);
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
		
		
		this.setActivaridMovimientosDetallados(esInicial);
		this.setActivarid_empresaMovimientosDetallados(esInicial);
		this.setActivarid_sucursalMovimientosDetallados(esInicial);
		this.setActivarid_clienteMovimientosDetallados(esInicial);
		this.setActivarid_transaccionMovimientosDetallados(esInicial);
		this.setActivarid_lineaMovimientosDetallados(esInicial);
		this.setActivarid_linea_grupoMovimientosDetallados(esInicial);
		this.setActivarid_linea_categoriaMovimientosDetallados(esInicial);
		this.setActivarid_linea_marcaMovimientosDetallados(esInicial);
		this.setActivarfecha_emision_desdeMovimientosDetallados(esInicial);
		this.setActivarfecha_emision_hastaMovimientosDetallados(esInicial);
		this.setActivarnombre_sucursalMovimientosDetallados(esInicial);
		this.setActivarnombre_completo_clienteMovimientosDetallados(esInicial);
		this.setActivarnombre_transaccionMovimientosDetallados(esInicial);
		this.setActivarnumero_comprobanteMovimientosDetallados(esInicial);
		this.setActivarnumero_facturaMovimientosDetallados(esInicial);
		this.setActivarnumero_secuencialMovimientosDetallados(esInicial);
		this.setActivarfecha_emisionMovimientosDetallados(esInicial);
		this.setActivarnombre_productoMovimientosDetallados(esInicial);
		this.setActivarnombre_unidadMovimientosDetallados(esInicial);
		this.setActivarcantidadMovimientosDetallados(esInicial);
		this.setActivarivaMovimientosDetallados(esInicial);
		this.setActivarcosto_unitarioMovimientosDetallados(esInicial);
		this.setActivarcosto_totalMovimientosDetallados(esInicial);
		this.setActivariceMovimientosDetallados(esInicial);
		this.setActivarcodigo_productoMovimientosDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.ID)) {
				this.setActivaridMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IVA)) {
				this.setActivarivaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.COSTOUNITARIO)) {
				this.setActivarcosto_unitarioMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.ICE)) {
				this.setActivariceMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoMovimientosDetallados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMovimientosDetallados(esInicial);
		this.setResaltarid_empresaMovimientosDetallados(esInicial);
		this.setResaltarid_sucursalMovimientosDetallados(esInicial);
		this.setResaltarid_clienteMovimientosDetallados(esInicial);
		this.setResaltarid_transaccionMovimientosDetallados(esInicial);
		this.setResaltarid_lineaMovimientosDetallados(esInicial);
		this.setResaltarid_linea_grupoMovimientosDetallados(esInicial);
		this.setResaltarid_linea_categoriaMovimientosDetallados(esInicial);
		this.setResaltarid_linea_marcaMovimientosDetallados(esInicial);
		this.setResaltarfecha_emision_desdeMovimientosDetallados(esInicial);
		this.setResaltarfecha_emision_hastaMovimientosDetallados(esInicial);
		this.setResaltarnombre_sucursalMovimientosDetallados(esInicial);
		this.setResaltarnombre_completo_clienteMovimientosDetallados(esInicial);
		this.setResaltarnombre_transaccionMovimientosDetallados(esInicial);
		this.setResaltarnumero_comprobanteMovimientosDetallados(esInicial);
		this.setResaltarnumero_facturaMovimientosDetallados(esInicial);
		this.setResaltarnumero_secuencialMovimientosDetallados(esInicial);
		this.setResaltarfecha_emisionMovimientosDetallados(esInicial);
		this.setResaltarnombre_productoMovimientosDetallados(esInicial);
		this.setResaltarnombre_unidadMovimientosDetallados(esInicial);
		this.setResaltarcantidadMovimientosDetallados(esInicial);
		this.setResaltarivaMovimientosDetallados(esInicial);
		this.setResaltarcosto_unitarioMovimientosDetallados(esInicial);
		this.setResaltarcosto_totalMovimientosDetallados(esInicial);
		this.setResaltariceMovimientosDetallados(esInicial);
		this.setResaltarcodigo_productoMovimientosDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.ID)) {
				this.setResaltaridMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.IVA)) {
				this.setResaltarivaMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.COSTOUNITARIO)) {
				this.setResaltarcosto_unitarioMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.ICE)) {
				this.setResaltariceMovimientosDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientosDetalladosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoMovimientosDetallados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaMovimientosDetalladosMovimientosDetallados=true;

	public Boolean getMostrarBusquedaMovimientosDetalladosMovimientosDetallados() {
		return this.mostrarBusquedaMovimientosDetalladosMovimientosDetallados;
	}

	public void setMostrarBusquedaMovimientosDetalladosMovimientosDetallados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaMovimientosDetalladosMovimientosDetallados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaMovimientosDetalladosMovimientosDetallados=true;

	public Boolean getActivarBusquedaMovimientosDetalladosMovimientosDetallados() {
		return this.activarBusquedaMovimientosDetalladosMovimientosDetallados;
	}

	public void setActivarBusquedaMovimientosDetalladosMovimientosDetallados(Boolean habilitarResaltar) {
		this.activarBusquedaMovimientosDetalladosMovimientosDetallados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaMovimientosDetalladosMovimientosDetallados=null;

	public Border getResaltarBusquedaMovimientosDetalladosMovimientosDetallados() {
		return this.resaltarBusquedaMovimientosDetalladosMovimientosDetallados;
	}

	public void setResaltarBusquedaMovimientosDetalladosMovimientosDetallados(Border borderResaltar) {
		this.resaltarBusquedaMovimientosDetalladosMovimientosDetallados= borderResaltar;
	}

	public void setResaltarBusquedaMovimientosDetalladosMovimientosDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientosDetalladosBeanSwingJInternalFrame movimientosdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaMovimientosDetalladosMovimientosDetallados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}