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


import com.bydan.erp.inventario.util.report.PedidosComprasConstantesFunciones;
import com.bydan.erp.inventario.util.report.PedidosComprasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.PedidosComprasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PedidosComprasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PedidosCompras";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PedidosCompras"+PedidosComprasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PedidosComprasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PedidosComprasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PedidosComprasConstantesFunciones.SCHEMA+"_"+PedidosComprasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PedidosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PedidosComprasConstantesFunciones.SCHEMA+"_"+PedidosComprasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PedidosComprasConstantesFunciones.SCHEMA+"_"+PedidosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PedidosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PedidosComprasConstantesFunciones.SCHEMA+"_"+PedidosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PedidosComprasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PedidosComprasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PedidosComprasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PedidosComprasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PedidosComprasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PedidosComprasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pedidos Comprases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pedidos Compras";
	public static final String SCLASSWEBTITULO_LOWER="Pedidos Compras";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PedidosCompras";
	public static final String OBJECTNAME="pedidoscompras";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="pedidos_compras";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pedidoscompras from "+PedidosComprasConstantesFunciones.SPERSISTENCENAME+" pedidoscompras";
	public static String QUERYSELECTNATIVE="select "+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".version_row,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_empresa,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_sucursal,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_producto,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_linea,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_linea_grupo,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_linea_categoria,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_linea_marca,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".secuencial,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".fecha_emision,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".nombre_producto,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".nombre_unidad,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".cantidad_pedido,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".cantidad_entregada,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".cantidad_pendiente,"+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME+".codigo_producto from "+PedidosComprasConstantesFunciones.SCHEMA+"."+PedidosComprasConstantesFunciones.TABLENAME;//+" as "+PedidosComprasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDTIPOPRODUCTOSERVICIO= "id_tipo_producto_servicio";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDADPEDIDO= "cantidad_pedido";
    public static final String CANTIDADENTREGADA= "cantidad_entregada";
    public static final String CANTIDADPENDIENTE= "cantidad_pendiente";
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
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_IDTIPOPRODUCTOSERVICIO= "Tipo Producto Servicio";
		public static final String LABEL_IDTIPOPRODUCTOSERVICIO_LOWER= "Tipo Producto Servicio";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDADPEDIDO= "Cantad Pedo";
		public static final String LABEL_CANTIDADPEDIDO_LOWER= "Cantidad Pedido";
    	public static final String LABEL_CANTIDADENTREGADA= "Cantad Entregada";
		public static final String LABEL_CANTIDADENTREGADA_LOWER= "Cantidad Entregada";
    	public static final String LABEL_CANTIDADPENDIENTE= "Cantad Pendiente";
		public static final String LABEL_CANTIDADPENDIENTE_LOWER= "Cantidad Pendiente";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPedidosComprasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDEMPRESA)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDLINEA)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.SECUENCIAL)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.FECHAEMISION)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.FECHAENTREGA)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.CANTIDADPEDIDO)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_CANTIDADPEDIDO;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.CANTIDADENTREGADA)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_CANTIDADENTREGADA;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.CANTIDADPENDIENTE)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_CANTIDADPENDIENTE;}
		if(sNombreColumna.equals(PedidosComprasConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=PedidosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPedidosComprasDescripcion(PedidosCompras pedidoscompras) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pedidoscompras !=null/* && pedidoscompras.getId()!=0*/) {
			if(pedidoscompras.getId()!=null) {
				sDescripcion=pedidoscompras.getId().toString();
			}//pedidoscompraspedidoscompras.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPedidosComprasDescripcionDetallado(PedidosCompras pedidoscompras) {
		String sDescripcion="";
			
		sDescripcion+=PedidosComprasConstantesFunciones.ID+"=";
		sDescripcion+=pedidoscompras.getId().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pedidoscompras.getVersionRow().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pedidoscompras.getid_empresa().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pedidoscompras.getid_sucursal().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=pedidoscompras.getid_producto().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=pedidoscompras.getid_linea().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=pedidoscompras.getid_linea_grupo().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=pedidoscompras.getid_linea_categoria().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=pedidoscompras.getid_linea_marca().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=pedidoscompras.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=pedidoscompras.getfecha_emision_desde().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=pedidoscompras.getfecha_emision_hasta().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=pedidoscompras.getsecuencial()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pedidoscompras.getfecha_emision().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=pedidoscompras.getfecha_entrega().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=pedidoscompras.getnombre_producto()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=pedidoscompras.getnombre_unidad()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.CANTIDADPEDIDO+"=";
		sDescripcion+=pedidoscompras.getcantidad_pedido().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.CANTIDADENTREGADA+"=";
		sDescripcion+=pedidoscompras.getcantidad_entregada().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.CANTIDADPENDIENTE+"=";
		sDescripcion+=pedidoscompras.getcantidad_pendiente().toString()+",";
		sDescripcion+=PedidosComprasConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=pedidoscompras.getcodigo_producto()+",";
			
		return sDescripcion;
	}
	
	public static void setPedidosComprasDescripcion(PedidosCompras pedidoscompras,String sValor) throws Exception {			
		if(pedidoscompras !=null) {
			//pedidoscompraspedidoscompras.getId().toString();
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

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
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

	public static String getTipoProductoServicioDescripcion(TipoProductoServicio tipoproductoservicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproductoservicio!=null/*&&tipoproductoservicio.getId()>0*/) {
			sDescripcion=TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(tipoproductoservicio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPedidosCompras")) {
			sNombreIndice="Tipo=  Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Tipo Producto Servicio Por Fecha Emision Desde Por Fecha Emision Hasta";
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
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicio")) {
			sNombreIndice="Tipo=  Por Tipo Producto Servicio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPedidosCompras(Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio="+id_tipo_producto_servicio.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProductoServicio(Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPedidosCompras(PedidosCompras pedidoscompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidoscompras.setsecuencial(pedidoscompras.getsecuencial().trim());
		pedidoscompras.setnombre_producto(pedidoscompras.getnombre_producto().trim());
		pedidoscompras.setnombre_unidad(pedidoscompras.getnombre_unidad().trim());
		pedidoscompras.setcodigo_producto(pedidoscompras.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosPedidosComprass(List<PedidosCompras> pedidoscomprass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidosCompras pedidoscompras: pedidoscomprass) {
			pedidoscompras.setsecuencial(pedidoscompras.getsecuencial().trim());
			pedidoscompras.setnombre_producto(pedidoscompras.getnombre_producto().trim());
			pedidoscompras.setnombre_unidad(pedidoscompras.getnombre_unidad().trim());
			pedidoscompras.setcodigo_producto(pedidoscompras.getcodigo_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidosCompras(PedidosCompras pedidoscompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pedidoscompras.getConCambioAuxiliar()) {
			pedidoscompras.setIsDeleted(pedidoscompras.getIsDeletedAuxiliar());	
			pedidoscompras.setIsNew(pedidoscompras.getIsNewAuxiliar());	
			pedidoscompras.setIsChanged(pedidoscompras.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pedidoscompras.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pedidoscompras.setIsDeletedAuxiliar(false);	
			pedidoscompras.setIsNewAuxiliar(false);	
			pedidoscompras.setIsChangedAuxiliar(false);
			
			pedidoscompras.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPedidosComprass(List<PedidosCompras> pedidoscomprass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PedidosCompras pedidoscompras : pedidoscomprass) {
			if(conAsignarBase && pedidoscompras.getConCambioAuxiliar()) {
				pedidoscompras.setIsDeleted(pedidoscompras.getIsDeletedAuxiliar());	
				pedidoscompras.setIsNew(pedidoscompras.getIsNewAuxiliar());	
				pedidoscompras.setIsChanged(pedidoscompras.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pedidoscompras.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pedidoscompras.setIsDeletedAuxiliar(false);	
				pedidoscompras.setIsNewAuxiliar(false);	
				pedidoscompras.setIsChangedAuxiliar(false);
				
				pedidoscompras.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPedidosCompras(PedidosCompras pedidoscompras,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			pedidoscompras.setcantidad_pedido(0);
			pedidoscompras.setcantidad_entregada(0);
			pedidoscompras.setcantidad_pendiente(0);
		}
	}		
	
	public static void InicializarValoresPedidosComprass(List<PedidosCompras> pedidoscomprass,Boolean conEnteros) throws Exception  {
		
		for(PedidosCompras pedidoscompras: pedidoscomprass) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				pedidoscompras.setcantidad_pedido(0);
				pedidoscompras.setcantidad_entregada(0);
				pedidoscompras.setcantidad_pendiente(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPedidosCompras(List<PedidosCompras> pedidoscomprass,PedidosCompras pedidoscomprasAux) throws Exception  {
		PedidosComprasConstantesFunciones.InicializarValoresPedidosCompras(pedidoscomprasAux,true);
		
		for(PedidosCompras pedidoscompras: pedidoscomprass) {
			if(pedidoscompras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pedidoscomprasAux.setcantidad_pedido(pedidoscomprasAux.getcantidad_pedido()+pedidoscompras.getcantidad_pedido());			
			pedidoscomprasAux.setcantidad_entregada(pedidoscomprasAux.getcantidad_entregada()+pedidoscompras.getcantidad_entregada());			
			pedidoscomprasAux.setcantidad_pendiente(pedidoscomprasAux.getcantidad_pendiente()+pedidoscompras.getcantidad_pendiente());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidosCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PedidosComprasConstantesFunciones.getArrayColumnasGlobalesPedidosCompras(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidosCompras(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidosComprasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidosComprasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PedidosComprasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PedidosComprasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPedidosCompras(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidosCompras> pedidoscomprass,PedidosCompras pedidoscompras,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidosCompras pedidoscomprasAux: pedidoscomprass) {
			if(pedidoscomprasAux!=null && pedidoscompras!=null) {
				if((pedidoscomprasAux.getId()==null && pedidoscompras.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pedidoscomprasAux.getId()!=null && pedidoscompras.getId()!=null){
					if(pedidoscomprasAux.getId().equals(pedidoscompras.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidosCompras(List<PedidosCompras> pedidoscomprass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PedidosCompras pedidoscompras: pedidoscomprass) {			
			if(pedidoscompras.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPedidosCompras() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_ID, PedidosComprasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_VERSIONROW, PedidosComprasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_SECUENCIAL, PedidosComprasConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_FECHAEMISION, PedidosComprasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_FECHAENTREGA, PedidosComprasConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO, PedidosComprasConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_NOMBREUNIDAD, PedidosComprasConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_CANTIDADPEDIDO, PedidosComprasConstantesFunciones.CANTIDADPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_CANTIDADENTREGADA, PedidosComprasConstantesFunciones.CANTIDADENTREGADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_CANTIDADPENDIENTE, PedidosComprasConstantesFunciones.CANTIDADPENDIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PedidosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO, PedidosComprasConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPedidosCompras() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.CANTIDADPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.CANTIDADENTREGADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.CANTIDADPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PedidosComprasConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidosCompras() throws Exception  {
		return PedidosComprasConstantesFunciones.getTiposSeleccionarPedidosCompras(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidosCompras(Boolean conFk) throws Exception  {
		return PedidosComprasConstantesFunciones.getTiposSeleccionarPedidosCompras(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPedidosCompras(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_CANTIDADPEDIDO);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_CANTIDADPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_CANTIDADENTREGADA);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_CANTIDADENTREGADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_CANTIDADPENDIENTE);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_CANTIDADPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PedidosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(PedidosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPedidosCompras(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPedidosCompras(PedidosCompras pedidoscomprasAux) throws Exception {
		
			pedidoscomprasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoscomprasAux.getEmpresa()));
			pedidoscomprasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoscomprasAux.getSucursal()));
			pedidoscomprasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(pedidoscomprasAux.getProducto()));
			pedidoscomprasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLinea()));
			pedidoscomprasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLineaGrupo()));
			pedidoscomprasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLineaCategoria()));
			pedidoscomprasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLineaMarca()));
			pedidoscomprasAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(pedidoscomprasAux.getTipoProductoServicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPedidosCompras(List<PedidosCompras> pedidoscomprassTemp) throws Exception {
		for(PedidosCompras pedidoscomprasAux:pedidoscomprassTemp) {
			
			pedidoscomprasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pedidoscomprasAux.getEmpresa()));
			pedidoscomprasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pedidoscomprasAux.getSucursal()));
			pedidoscomprasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(pedidoscomprasAux.getProducto()));
			pedidoscomprasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLinea()));
			pedidoscomprasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLineaGrupo()));
			pedidoscomprasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLineaCategoria()));
			pedidoscomprasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(pedidoscomprasAux.getLineaMarca()));
			pedidoscomprasAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(pedidoscomprasAux.getTipoProductoServicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPedidosCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(TipoProductoServicio.class));
				
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
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProductoServicio.class)) {
						classes.add(new Classe(TipoProductoServicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPedidosCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidosCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidosComprasConstantesFunciones.getClassesRelationshipsOfPedidosCompras(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidosCompras(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidosCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PedidosComprasConstantesFunciones.getClassesRelationshipsFromStringsOfPedidosCompras(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPedidosCompras(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PedidosCompras pedidoscompras,List<PedidosCompras> pedidoscomprass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PedidosCompras pedidoscompras,List<PedidosCompras> pedidoscomprass) throws Exception {
		try	{			
			for(PedidosCompras pedidoscomprasLocal:pedidoscomprass) {
				if(pedidoscomprasLocal.getId().equals(pedidoscompras.getId())) {
					pedidoscomprasLocal.setIsSelected(pedidoscompras.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPedidosCompras(List<PedidosCompras> pedidoscomprassAux) throws Exception {
		//this.pedidoscomprassAux=pedidoscomprassAux;
		
		for(PedidosCompras pedidoscomprasAux:pedidoscomprassAux) {
			if(pedidoscomprasAux.getIsChanged()) {
				pedidoscomprasAux.setIsChanged(false);
			}		
			
			if(pedidoscomprasAux.getIsNew()) {
				pedidoscomprasAux.setIsNew(false);
			}	
			
			if(pedidoscomprasAux.getIsDeleted()) {
				pedidoscomprasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPedidosCompras(PedidosCompras pedidoscomprasAux) throws Exception {
		//this.pedidoscomprasAux=pedidoscomprasAux;
		
			if(pedidoscomprasAux.getIsChanged()) {
				pedidoscomprasAux.setIsChanged(false);
			}		
			
			if(pedidoscomprasAux.getIsNew()) {
				pedidoscomprasAux.setIsNew(false);
			}	
			
			if(pedidoscomprasAux.getIsDeleted()) {
				pedidoscomprasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PedidosCompras pedidoscomprasAsignar,PedidosCompras pedidoscompras) throws Exception {
		pedidoscomprasAsignar.setId(pedidoscompras.getId());	
		pedidoscomprasAsignar.setVersionRow(pedidoscompras.getVersionRow());	
		pedidoscomprasAsignar.setsecuencial(pedidoscompras.getsecuencial());	
		pedidoscomprasAsignar.setfecha_emision(pedidoscompras.getfecha_emision());	
		pedidoscomprasAsignar.setfecha_entrega(pedidoscompras.getfecha_entrega());	
		pedidoscomprasAsignar.setnombre_producto(pedidoscompras.getnombre_producto());	
		pedidoscomprasAsignar.setnombre_unidad(pedidoscompras.getnombre_unidad());	
		pedidoscomprasAsignar.setcantidad_pedido(pedidoscompras.getcantidad_pedido());	
		pedidoscomprasAsignar.setcantidad_entregada(pedidoscompras.getcantidad_entregada());	
		pedidoscomprasAsignar.setcantidad_pendiente(pedidoscompras.getcantidad_pendiente());	
		pedidoscomprasAsignar.setcodigo_producto(pedidoscompras.getcodigo_producto());	
	}
	
	public static void inicializarPedidosCompras(PedidosCompras pedidoscompras) throws Exception {
		try {
				pedidoscompras.setId(0L);	
					
				pedidoscompras.setsecuencial("");	
				pedidoscompras.setfecha_emision(new Date());	
				pedidoscompras.setfecha_entrega(new Date());	
				pedidoscompras.setnombre_producto("");	
				pedidoscompras.setnombre_unidad("");	
				pedidoscompras.setcantidad_pedido(0);	
				pedidoscompras.setcantidad_entregada(0);	
				pedidoscompras.setcantidad_pendiente(0);	
				pedidoscompras.setcodigo_producto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPedidosCompras(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_CANTIDADPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_CANTIDADENTREGADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_CANTIDADPENDIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PedidosComprasConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPedidosCompras(String sTipo,Row row,Workbook workbook,PedidosCompras pedidoscompras,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getcantidad_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getcantidad_entregada());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getcantidad_pendiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pedidoscompras.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPedidosCompras="";
	
	public String getsFinalQueryPedidosCompras() {
		return this.sFinalQueryPedidosCompras;
	}
	
	public void setsFinalQueryPedidosCompras(String sFinalQueryPedidosCompras) {
		this.sFinalQueryPedidosCompras= sFinalQueryPedidosCompras;
	}
	
	public Border resaltarSeleccionarPedidosCompras=null;
	
	public Border setResaltarSeleccionarPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPedidosCompras= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPedidosCompras() {
		return this.resaltarSeleccionarPedidosCompras;
	}
	
	public void setResaltarSeleccionarPedidosCompras(Border borderResaltarSeleccionarPedidosCompras) {
		this.resaltarSeleccionarPedidosCompras= borderResaltarSeleccionarPedidosCompras;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPedidosCompras=null;
	public Boolean mostraridPedidosCompras=true;
	public Boolean activaridPedidosCompras=true;

	public Border resaltarid_empresaPedidosCompras=null;
	public Boolean mostrarid_empresaPedidosCompras=true;
	public Boolean activarid_empresaPedidosCompras=true;
	public Boolean cargarid_empresaPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPedidosCompras=false;//ConEventDepend=true

	public Border resaltarid_sucursalPedidosCompras=null;
	public Boolean mostrarid_sucursalPedidosCompras=true;
	public Boolean activarid_sucursalPedidosCompras=true;
	public Boolean cargarid_sucursalPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPedidosCompras=false;//ConEventDepend=true

	public Border resaltarid_productoPedidosCompras=null;
	public Boolean mostrarid_productoPedidosCompras=true;
	public Boolean activarid_productoPedidosCompras=true;
	public Boolean cargarid_productoPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPedidosCompras=false;//ConEventDepend=true

	public Border resaltarid_lineaPedidosCompras=null;
	public Boolean mostrarid_lineaPedidosCompras=true;
	public Boolean activarid_lineaPedidosCompras=true;
	public Boolean cargarid_lineaPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaPedidosCompras=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoPedidosCompras=null;
	public Boolean mostrarid_linea_grupoPedidosCompras=true;
	public Boolean activarid_linea_grupoPedidosCompras=true;
	public Boolean cargarid_linea_grupoPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoPedidosCompras=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaPedidosCompras=null;
	public Boolean mostrarid_linea_categoriaPedidosCompras=true;
	public Boolean activarid_linea_categoriaPedidosCompras=true;
	public Boolean cargarid_linea_categoriaPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaPedidosCompras=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaPedidosCompras=null;
	public Boolean mostrarid_linea_marcaPedidosCompras=true;
	public Boolean activarid_linea_marcaPedidosCompras=true;
	public Boolean cargarid_linea_marcaPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaPedidosCompras=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioPedidosCompras=null;
	public Boolean mostrarid_tipo_producto_servicioPedidosCompras=true;
	public Boolean activarid_tipo_producto_servicioPedidosCompras=true;
	public Boolean cargarid_tipo_producto_servicioPedidosCompras=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioPedidosCompras=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdePedidosCompras=null;
	public Boolean mostrarfecha_emision_desdePedidosCompras=true;
	public Boolean activarfecha_emision_desdePedidosCompras=true;

	public Border resaltarfecha_emision_hastaPedidosCompras=null;
	public Boolean mostrarfecha_emision_hastaPedidosCompras=true;
	public Boolean activarfecha_emision_hastaPedidosCompras=true;

	public Border resaltarsecuencialPedidosCompras=null;
	public Boolean mostrarsecuencialPedidosCompras=true;
	public Boolean activarsecuencialPedidosCompras=true;

	public Border resaltarfecha_emisionPedidosCompras=null;
	public Boolean mostrarfecha_emisionPedidosCompras=true;
	public Boolean activarfecha_emisionPedidosCompras=true;

	public Border resaltarfecha_entregaPedidosCompras=null;
	public Boolean mostrarfecha_entregaPedidosCompras=true;
	public Boolean activarfecha_entregaPedidosCompras=true;

	public Border resaltarnombre_productoPedidosCompras=null;
	public Boolean mostrarnombre_productoPedidosCompras=true;
	public Boolean activarnombre_productoPedidosCompras=true;

	public Border resaltarnombre_unidadPedidosCompras=null;
	public Boolean mostrarnombre_unidadPedidosCompras=true;
	public Boolean activarnombre_unidadPedidosCompras=true;

	public Border resaltarcantidad_pedidoPedidosCompras=null;
	public Boolean mostrarcantidad_pedidoPedidosCompras=true;
	public Boolean activarcantidad_pedidoPedidosCompras=true;

	public Border resaltarcantidad_entregadaPedidosCompras=null;
	public Boolean mostrarcantidad_entregadaPedidosCompras=true;
	public Boolean activarcantidad_entregadaPedidosCompras=true;

	public Border resaltarcantidad_pendientePedidosCompras=null;
	public Boolean mostrarcantidad_pendientePedidosCompras=true;
	public Boolean activarcantidad_pendientePedidosCompras=true;

	public Border resaltarcodigo_productoPedidosCompras=null;
	public Boolean mostrarcodigo_productoPedidosCompras=true;
	public Boolean activarcodigo_productoPedidosCompras=true;

	
	

	public Border setResaltaridPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltaridPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPedidosCompras() {
		return this.resaltaridPedidosCompras;
	}

	public void setResaltaridPedidosCompras(Border borderResaltar) {
		this.resaltaridPedidosCompras= borderResaltar;
	}

	public Boolean getMostraridPedidosCompras() {
		return this.mostraridPedidosCompras;
	}

	public void setMostraridPedidosCompras(Boolean mostraridPedidosCompras) {
		this.mostraridPedidosCompras= mostraridPedidosCompras;
	}

	public Boolean getActivaridPedidosCompras() {
		return this.activaridPedidosCompras;
	}

	public void setActivaridPedidosCompras(Boolean activaridPedidosCompras) {
		this.activaridPedidosCompras= activaridPedidosCompras;
	}

	public Border setResaltarid_empresaPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_empresaPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPedidosCompras() {
		return this.resaltarid_empresaPedidosCompras;
	}

	public void setResaltarid_empresaPedidosCompras(Border borderResaltar) {
		this.resaltarid_empresaPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_empresaPedidosCompras() {
		return this.mostrarid_empresaPedidosCompras;
	}

	public void setMostrarid_empresaPedidosCompras(Boolean mostrarid_empresaPedidosCompras) {
		this.mostrarid_empresaPedidosCompras= mostrarid_empresaPedidosCompras;
	}

	public Boolean getActivarid_empresaPedidosCompras() {
		return this.activarid_empresaPedidosCompras;
	}

	public void setActivarid_empresaPedidosCompras(Boolean activarid_empresaPedidosCompras) {
		this.activarid_empresaPedidosCompras= activarid_empresaPedidosCompras;
	}

	public Boolean getCargarid_empresaPedidosCompras() {
		return this.cargarid_empresaPedidosCompras;
	}

	public void setCargarid_empresaPedidosCompras(Boolean cargarid_empresaPedidosCompras) {
		this.cargarid_empresaPedidosCompras= cargarid_empresaPedidosCompras;
	}

	public Border setResaltarid_sucursalPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPedidosCompras() {
		return this.resaltarid_sucursalPedidosCompras;
	}

	public void setResaltarid_sucursalPedidosCompras(Border borderResaltar) {
		this.resaltarid_sucursalPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPedidosCompras() {
		return this.mostrarid_sucursalPedidosCompras;
	}

	public void setMostrarid_sucursalPedidosCompras(Boolean mostrarid_sucursalPedidosCompras) {
		this.mostrarid_sucursalPedidosCompras= mostrarid_sucursalPedidosCompras;
	}

	public Boolean getActivarid_sucursalPedidosCompras() {
		return this.activarid_sucursalPedidosCompras;
	}

	public void setActivarid_sucursalPedidosCompras(Boolean activarid_sucursalPedidosCompras) {
		this.activarid_sucursalPedidosCompras= activarid_sucursalPedidosCompras;
	}

	public Boolean getCargarid_sucursalPedidosCompras() {
		return this.cargarid_sucursalPedidosCompras;
	}

	public void setCargarid_sucursalPedidosCompras(Boolean cargarid_sucursalPedidosCompras) {
		this.cargarid_sucursalPedidosCompras= cargarid_sucursalPedidosCompras;
	}

	public Border setResaltarid_productoPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_productoPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPedidosCompras() {
		return this.resaltarid_productoPedidosCompras;
	}

	public void setResaltarid_productoPedidosCompras(Border borderResaltar) {
		this.resaltarid_productoPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_productoPedidosCompras() {
		return this.mostrarid_productoPedidosCompras;
	}

	public void setMostrarid_productoPedidosCompras(Boolean mostrarid_productoPedidosCompras) {
		this.mostrarid_productoPedidosCompras= mostrarid_productoPedidosCompras;
	}

	public Boolean getActivarid_productoPedidosCompras() {
		return this.activarid_productoPedidosCompras;
	}

	public void setActivarid_productoPedidosCompras(Boolean activarid_productoPedidosCompras) {
		this.activarid_productoPedidosCompras= activarid_productoPedidosCompras;
	}

	public Boolean getCargarid_productoPedidosCompras() {
		return this.cargarid_productoPedidosCompras;
	}

	public void setCargarid_productoPedidosCompras(Boolean cargarid_productoPedidosCompras) {
		this.cargarid_productoPedidosCompras= cargarid_productoPedidosCompras;
	}

	public Border setResaltarid_lineaPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_lineaPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaPedidosCompras() {
		return this.resaltarid_lineaPedidosCompras;
	}

	public void setResaltarid_lineaPedidosCompras(Border borderResaltar) {
		this.resaltarid_lineaPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_lineaPedidosCompras() {
		return this.mostrarid_lineaPedidosCompras;
	}

	public void setMostrarid_lineaPedidosCompras(Boolean mostrarid_lineaPedidosCompras) {
		this.mostrarid_lineaPedidosCompras= mostrarid_lineaPedidosCompras;
	}

	public Boolean getActivarid_lineaPedidosCompras() {
		return this.activarid_lineaPedidosCompras;
	}

	public void setActivarid_lineaPedidosCompras(Boolean activarid_lineaPedidosCompras) {
		this.activarid_lineaPedidosCompras= activarid_lineaPedidosCompras;
	}

	public Boolean getCargarid_lineaPedidosCompras() {
		return this.cargarid_lineaPedidosCompras;
	}

	public void setCargarid_lineaPedidosCompras(Boolean cargarid_lineaPedidosCompras) {
		this.cargarid_lineaPedidosCompras= cargarid_lineaPedidosCompras;
	}

	public Border setResaltarid_linea_grupoPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoPedidosCompras() {
		return this.resaltarid_linea_grupoPedidosCompras;
	}

	public void setResaltarid_linea_grupoPedidosCompras(Border borderResaltar) {
		this.resaltarid_linea_grupoPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoPedidosCompras() {
		return this.mostrarid_linea_grupoPedidosCompras;
	}

	public void setMostrarid_linea_grupoPedidosCompras(Boolean mostrarid_linea_grupoPedidosCompras) {
		this.mostrarid_linea_grupoPedidosCompras= mostrarid_linea_grupoPedidosCompras;
	}

	public Boolean getActivarid_linea_grupoPedidosCompras() {
		return this.activarid_linea_grupoPedidosCompras;
	}

	public void setActivarid_linea_grupoPedidosCompras(Boolean activarid_linea_grupoPedidosCompras) {
		this.activarid_linea_grupoPedidosCompras= activarid_linea_grupoPedidosCompras;
	}

	public Boolean getCargarid_linea_grupoPedidosCompras() {
		return this.cargarid_linea_grupoPedidosCompras;
	}

	public void setCargarid_linea_grupoPedidosCompras(Boolean cargarid_linea_grupoPedidosCompras) {
		this.cargarid_linea_grupoPedidosCompras= cargarid_linea_grupoPedidosCompras;
	}

	public Border setResaltarid_linea_categoriaPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaPedidosCompras() {
		return this.resaltarid_linea_categoriaPedidosCompras;
	}

	public void setResaltarid_linea_categoriaPedidosCompras(Border borderResaltar) {
		this.resaltarid_linea_categoriaPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaPedidosCompras() {
		return this.mostrarid_linea_categoriaPedidosCompras;
	}

	public void setMostrarid_linea_categoriaPedidosCompras(Boolean mostrarid_linea_categoriaPedidosCompras) {
		this.mostrarid_linea_categoriaPedidosCompras= mostrarid_linea_categoriaPedidosCompras;
	}

	public Boolean getActivarid_linea_categoriaPedidosCompras() {
		return this.activarid_linea_categoriaPedidosCompras;
	}

	public void setActivarid_linea_categoriaPedidosCompras(Boolean activarid_linea_categoriaPedidosCompras) {
		this.activarid_linea_categoriaPedidosCompras= activarid_linea_categoriaPedidosCompras;
	}

	public Boolean getCargarid_linea_categoriaPedidosCompras() {
		return this.cargarid_linea_categoriaPedidosCompras;
	}

	public void setCargarid_linea_categoriaPedidosCompras(Boolean cargarid_linea_categoriaPedidosCompras) {
		this.cargarid_linea_categoriaPedidosCompras= cargarid_linea_categoriaPedidosCompras;
	}

	public Border setResaltarid_linea_marcaPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaPedidosCompras() {
		return this.resaltarid_linea_marcaPedidosCompras;
	}

	public void setResaltarid_linea_marcaPedidosCompras(Border borderResaltar) {
		this.resaltarid_linea_marcaPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaPedidosCompras() {
		return this.mostrarid_linea_marcaPedidosCompras;
	}

	public void setMostrarid_linea_marcaPedidosCompras(Boolean mostrarid_linea_marcaPedidosCompras) {
		this.mostrarid_linea_marcaPedidosCompras= mostrarid_linea_marcaPedidosCompras;
	}

	public Boolean getActivarid_linea_marcaPedidosCompras() {
		return this.activarid_linea_marcaPedidosCompras;
	}

	public void setActivarid_linea_marcaPedidosCompras(Boolean activarid_linea_marcaPedidosCompras) {
		this.activarid_linea_marcaPedidosCompras= activarid_linea_marcaPedidosCompras;
	}

	public Boolean getCargarid_linea_marcaPedidosCompras() {
		return this.cargarid_linea_marcaPedidosCompras;
	}

	public void setCargarid_linea_marcaPedidosCompras(Boolean cargarid_linea_marcaPedidosCompras) {
		this.cargarid_linea_marcaPedidosCompras= cargarid_linea_marcaPedidosCompras;
	}

	public Border setResaltarid_tipo_producto_servicioPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioPedidosCompras() {
		return this.resaltarid_tipo_producto_servicioPedidosCompras;
	}

	public void setResaltarid_tipo_producto_servicioPedidosCompras(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioPedidosCompras() {
		return this.mostrarid_tipo_producto_servicioPedidosCompras;
	}

	public void setMostrarid_tipo_producto_servicioPedidosCompras(Boolean mostrarid_tipo_producto_servicioPedidosCompras) {
		this.mostrarid_tipo_producto_servicioPedidosCompras= mostrarid_tipo_producto_servicioPedidosCompras;
	}

	public Boolean getActivarid_tipo_producto_servicioPedidosCompras() {
		return this.activarid_tipo_producto_servicioPedidosCompras;
	}

	public void setActivarid_tipo_producto_servicioPedidosCompras(Boolean activarid_tipo_producto_servicioPedidosCompras) {
		this.activarid_tipo_producto_servicioPedidosCompras= activarid_tipo_producto_servicioPedidosCompras;
	}

	public Boolean getCargarid_tipo_producto_servicioPedidosCompras() {
		return this.cargarid_tipo_producto_servicioPedidosCompras;
	}

	public void setCargarid_tipo_producto_servicioPedidosCompras(Boolean cargarid_tipo_producto_servicioPedidosCompras) {
		this.cargarid_tipo_producto_servicioPedidosCompras= cargarid_tipo_producto_servicioPedidosCompras;
	}

	public Border setResaltarfecha_emision_desdePedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdePedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdePedidosCompras() {
		return this.resaltarfecha_emision_desdePedidosCompras;
	}

	public void setResaltarfecha_emision_desdePedidosCompras(Border borderResaltar) {
		this.resaltarfecha_emision_desdePedidosCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdePedidosCompras() {
		return this.mostrarfecha_emision_desdePedidosCompras;
	}

	public void setMostrarfecha_emision_desdePedidosCompras(Boolean mostrarfecha_emision_desdePedidosCompras) {
		this.mostrarfecha_emision_desdePedidosCompras= mostrarfecha_emision_desdePedidosCompras;
	}

	public Boolean getActivarfecha_emision_desdePedidosCompras() {
		return this.activarfecha_emision_desdePedidosCompras;
	}

	public void setActivarfecha_emision_desdePedidosCompras(Boolean activarfecha_emision_desdePedidosCompras) {
		this.activarfecha_emision_desdePedidosCompras= activarfecha_emision_desdePedidosCompras;
	}

	public Border setResaltarfecha_emision_hastaPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaPedidosCompras() {
		return this.resaltarfecha_emision_hastaPedidosCompras;
	}

	public void setResaltarfecha_emision_hastaPedidosCompras(Border borderResaltar) {
		this.resaltarfecha_emision_hastaPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaPedidosCompras() {
		return this.mostrarfecha_emision_hastaPedidosCompras;
	}

	public void setMostrarfecha_emision_hastaPedidosCompras(Boolean mostrarfecha_emision_hastaPedidosCompras) {
		this.mostrarfecha_emision_hastaPedidosCompras= mostrarfecha_emision_hastaPedidosCompras;
	}

	public Boolean getActivarfecha_emision_hastaPedidosCompras() {
		return this.activarfecha_emision_hastaPedidosCompras;
	}

	public void setActivarfecha_emision_hastaPedidosCompras(Boolean activarfecha_emision_hastaPedidosCompras) {
		this.activarfecha_emision_hastaPedidosCompras= activarfecha_emision_hastaPedidosCompras;
	}

	public Border setResaltarsecuencialPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarsecuencialPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialPedidosCompras() {
		return this.resaltarsecuencialPedidosCompras;
	}

	public void setResaltarsecuencialPedidosCompras(Border borderResaltar) {
		this.resaltarsecuencialPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarsecuencialPedidosCompras() {
		return this.mostrarsecuencialPedidosCompras;
	}

	public void setMostrarsecuencialPedidosCompras(Boolean mostrarsecuencialPedidosCompras) {
		this.mostrarsecuencialPedidosCompras= mostrarsecuencialPedidosCompras;
	}

	public Boolean getActivarsecuencialPedidosCompras() {
		return this.activarsecuencialPedidosCompras;
	}

	public void setActivarsecuencialPedidosCompras(Boolean activarsecuencialPedidosCompras) {
		this.activarsecuencialPedidosCompras= activarsecuencialPedidosCompras;
	}

	public Border setResaltarfecha_emisionPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPedidosCompras() {
		return this.resaltarfecha_emisionPedidosCompras;
	}

	public void setResaltarfecha_emisionPedidosCompras(Border borderResaltar) {
		this.resaltarfecha_emisionPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPedidosCompras() {
		return this.mostrarfecha_emisionPedidosCompras;
	}

	public void setMostrarfecha_emisionPedidosCompras(Boolean mostrarfecha_emisionPedidosCompras) {
		this.mostrarfecha_emisionPedidosCompras= mostrarfecha_emisionPedidosCompras;
	}

	public Boolean getActivarfecha_emisionPedidosCompras() {
		return this.activarfecha_emisionPedidosCompras;
	}

	public void setActivarfecha_emisionPedidosCompras(Boolean activarfecha_emisionPedidosCompras) {
		this.activarfecha_emisionPedidosCompras= activarfecha_emisionPedidosCompras;
	}

	public Border setResaltarfecha_entregaPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaPedidosCompras() {
		return this.resaltarfecha_entregaPedidosCompras;
	}

	public void setResaltarfecha_entregaPedidosCompras(Border borderResaltar) {
		this.resaltarfecha_entregaPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaPedidosCompras() {
		return this.mostrarfecha_entregaPedidosCompras;
	}

	public void setMostrarfecha_entregaPedidosCompras(Boolean mostrarfecha_entregaPedidosCompras) {
		this.mostrarfecha_entregaPedidosCompras= mostrarfecha_entregaPedidosCompras;
	}

	public Boolean getActivarfecha_entregaPedidosCompras() {
		return this.activarfecha_entregaPedidosCompras;
	}

	public void setActivarfecha_entregaPedidosCompras(Boolean activarfecha_entregaPedidosCompras) {
		this.activarfecha_entregaPedidosCompras= activarfecha_entregaPedidosCompras;
	}

	public Border setResaltarnombre_productoPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarnombre_productoPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoPedidosCompras() {
		return this.resaltarnombre_productoPedidosCompras;
	}

	public void setResaltarnombre_productoPedidosCompras(Border borderResaltar) {
		this.resaltarnombre_productoPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarnombre_productoPedidosCompras() {
		return this.mostrarnombre_productoPedidosCompras;
	}

	public void setMostrarnombre_productoPedidosCompras(Boolean mostrarnombre_productoPedidosCompras) {
		this.mostrarnombre_productoPedidosCompras= mostrarnombre_productoPedidosCompras;
	}

	public Boolean getActivarnombre_productoPedidosCompras() {
		return this.activarnombre_productoPedidosCompras;
	}

	public void setActivarnombre_productoPedidosCompras(Boolean activarnombre_productoPedidosCompras) {
		this.activarnombre_productoPedidosCompras= activarnombre_productoPedidosCompras;
	}

	public Border setResaltarnombre_unidadPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadPedidosCompras() {
		return this.resaltarnombre_unidadPedidosCompras;
	}

	public void setResaltarnombre_unidadPedidosCompras(Border borderResaltar) {
		this.resaltarnombre_unidadPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadPedidosCompras() {
		return this.mostrarnombre_unidadPedidosCompras;
	}

	public void setMostrarnombre_unidadPedidosCompras(Boolean mostrarnombre_unidadPedidosCompras) {
		this.mostrarnombre_unidadPedidosCompras= mostrarnombre_unidadPedidosCompras;
	}

	public Boolean getActivarnombre_unidadPedidosCompras() {
		return this.activarnombre_unidadPedidosCompras;
	}

	public void setActivarnombre_unidadPedidosCompras(Boolean activarnombre_unidadPedidosCompras) {
		this.activarnombre_unidadPedidosCompras= activarnombre_unidadPedidosCompras;
	}

	public Border setResaltarcantidad_pedidoPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarcantidad_pedidoPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pedidoPedidosCompras() {
		return this.resaltarcantidad_pedidoPedidosCompras;
	}

	public void setResaltarcantidad_pedidoPedidosCompras(Border borderResaltar) {
		this.resaltarcantidad_pedidoPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarcantidad_pedidoPedidosCompras() {
		return this.mostrarcantidad_pedidoPedidosCompras;
	}

	public void setMostrarcantidad_pedidoPedidosCompras(Boolean mostrarcantidad_pedidoPedidosCompras) {
		this.mostrarcantidad_pedidoPedidosCompras= mostrarcantidad_pedidoPedidosCompras;
	}

	public Boolean getActivarcantidad_pedidoPedidosCompras() {
		return this.activarcantidad_pedidoPedidosCompras;
	}

	public void setActivarcantidad_pedidoPedidosCompras(Boolean activarcantidad_pedidoPedidosCompras) {
		this.activarcantidad_pedidoPedidosCompras= activarcantidad_pedidoPedidosCompras;
	}

	public Border setResaltarcantidad_entregadaPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarcantidad_entregadaPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_entregadaPedidosCompras() {
		return this.resaltarcantidad_entregadaPedidosCompras;
	}

	public void setResaltarcantidad_entregadaPedidosCompras(Border borderResaltar) {
		this.resaltarcantidad_entregadaPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarcantidad_entregadaPedidosCompras() {
		return this.mostrarcantidad_entregadaPedidosCompras;
	}

	public void setMostrarcantidad_entregadaPedidosCompras(Boolean mostrarcantidad_entregadaPedidosCompras) {
		this.mostrarcantidad_entregadaPedidosCompras= mostrarcantidad_entregadaPedidosCompras;
	}

	public Boolean getActivarcantidad_entregadaPedidosCompras() {
		return this.activarcantidad_entregadaPedidosCompras;
	}

	public void setActivarcantidad_entregadaPedidosCompras(Boolean activarcantidad_entregadaPedidosCompras) {
		this.activarcantidad_entregadaPedidosCompras= activarcantidad_entregadaPedidosCompras;
	}

	public Border setResaltarcantidad_pendientePedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarcantidad_pendientePedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pendientePedidosCompras() {
		return this.resaltarcantidad_pendientePedidosCompras;
	}

	public void setResaltarcantidad_pendientePedidosCompras(Border borderResaltar) {
		this.resaltarcantidad_pendientePedidosCompras= borderResaltar;
	}

	public Boolean getMostrarcantidad_pendientePedidosCompras() {
		return this.mostrarcantidad_pendientePedidosCompras;
	}

	public void setMostrarcantidad_pendientePedidosCompras(Boolean mostrarcantidad_pendientePedidosCompras) {
		this.mostrarcantidad_pendientePedidosCompras= mostrarcantidad_pendientePedidosCompras;
	}

	public Boolean getActivarcantidad_pendientePedidosCompras() {
		return this.activarcantidad_pendientePedidosCompras;
	}

	public void setActivarcantidad_pendientePedidosCompras(Boolean activarcantidad_pendientePedidosCompras) {
		this.activarcantidad_pendientePedidosCompras= activarcantidad_pendientePedidosCompras;
	}

	public Border setResaltarcodigo_productoPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pedidoscomprasBeanSwingJInternalFrame.jTtoolBarPedidosCompras.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoPedidosCompras= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoPedidosCompras() {
		return this.resaltarcodigo_productoPedidosCompras;
	}

	public void setResaltarcodigo_productoPedidosCompras(Border borderResaltar) {
		this.resaltarcodigo_productoPedidosCompras= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoPedidosCompras() {
		return this.mostrarcodigo_productoPedidosCompras;
	}

	public void setMostrarcodigo_productoPedidosCompras(Boolean mostrarcodigo_productoPedidosCompras) {
		this.mostrarcodigo_productoPedidosCompras= mostrarcodigo_productoPedidosCompras;
	}

	public Boolean getActivarcodigo_productoPedidosCompras() {
		return this.activarcodigo_productoPedidosCompras;
	}

	public void setActivarcodigo_productoPedidosCompras(Boolean activarcodigo_productoPedidosCompras) {
		this.activarcodigo_productoPedidosCompras= activarcodigo_productoPedidosCompras;
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
		
		
		this.setMostraridPedidosCompras(esInicial);
		this.setMostrarid_empresaPedidosCompras(esInicial);
		this.setMostrarid_sucursalPedidosCompras(esInicial);
		this.setMostrarid_productoPedidosCompras(esInicial);
		this.setMostrarid_lineaPedidosCompras(esInicial);
		this.setMostrarid_linea_grupoPedidosCompras(esInicial);
		this.setMostrarid_linea_categoriaPedidosCompras(esInicial);
		this.setMostrarid_linea_marcaPedidosCompras(esInicial);
		this.setMostrarid_tipo_producto_servicioPedidosCompras(esInicial);
		this.setMostrarfecha_emision_desdePedidosCompras(esInicial);
		this.setMostrarfecha_emision_hastaPedidosCompras(esInicial);
		this.setMostrarsecuencialPedidosCompras(esInicial);
		this.setMostrarfecha_emisionPedidosCompras(esInicial);
		this.setMostrarfecha_entregaPedidosCompras(esInicial);
		this.setMostrarnombre_productoPedidosCompras(esInicial);
		this.setMostrarnombre_unidadPedidosCompras(esInicial);
		this.setMostrarcantidad_pedidoPedidosCompras(esInicial);
		this.setMostrarcantidad_entregadaPedidosCompras(esInicial);
		this.setMostrarcantidad_pendientePedidosCompras(esInicial);
		this.setMostrarcodigo_productoPedidosCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidosComprasConstantesFunciones.ID)) {
				this.setMostraridPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdePedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADPEDIDO)) {
				this.setMostrarcantidad_pedidoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADENTREGADA)) {
				this.setMostrarcantidad_entregadaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setMostrarcantidad_pendientePedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoPedidosCompras(esAsigna);
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
		
		
		this.setActivaridPedidosCompras(esInicial);
		this.setActivarid_empresaPedidosCompras(esInicial);
		this.setActivarid_sucursalPedidosCompras(esInicial);
		this.setActivarid_productoPedidosCompras(esInicial);
		this.setActivarid_lineaPedidosCompras(esInicial);
		this.setActivarid_linea_grupoPedidosCompras(esInicial);
		this.setActivarid_linea_categoriaPedidosCompras(esInicial);
		this.setActivarid_linea_marcaPedidosCompras(esInicial);
		this.setActivarid_tipo_producto_servicioPedidosCompras(esInicial);
		this.setActivarfecha_emision_desdePedidosCompras(esInicial);
		this.setActivarfecha_emision_hastaPedidosCompras(esInicial);
		this.setActivarsecuencialPedidosCompras(esInicial);
		this.setActivarfecha_emisionPedidosCompras(esInicial);
		this.setActivarfecha_entregaPedidosCompras(esInicial);
		this.setActivarnombre_productoPedidosCompras(esInicial);
		this.setActivarnombre_unidadPedidosCompras(esInicial);
		this.setActivarcantidad_pedidoPedidosCompras(esInicial);
		this.setActivarcantidad_entregadaPedidosCompras(esInicial);
		this.setActivarcantidad_pendientePedidosCompras(esInicial);
		this.setActivarcodigo_productoPedidosCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidosComprasConstantesFunciones.ID)) {
				this.setActivaridPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdePedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADPEDIDO)) {
				this.setActivarcantidad_pedidoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADENTREGADA)) {
				this.setActivarcantidad_entregadaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setActivarcantidad_pendientePedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoPedidosCompras(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPedidosCompras(esInicial);
		this.setResaltarid_empresaPedidosCompras(esInicial);
		this.setResaltarid_sucursalPedidosCompras(esInicial);
		this.setResaltarid_productoPedidosCompras(esInicial);
		this.setResaltarid_lineaPedidosCompras(esInicial);
		this.setResaltarid_linea_grupoPedidosCompras(esInicial);
		this.setResaltarid_linea_categoriaPedidosCompras(esInicial);
		this.setResaltarid_linea_marcaPedidosCompras(esInicial);
		this.setResaltarid_tipo_producto_servicioPedidosCompras(esInicial);
		this.setResaltarfecha_emision_desdePedidosCompras(esInicial);
		this.setResaltarfecha_emision_hastaPedidosCompras(esInicial);
		this.setResaltarsecuencialPedidosCompras(esInicial);
		this.setResaltarfecha_emisionPedidosCompras(esInicial);
		this.setResaltarfecha_entregaPedidosCompras(esInicial);
		this.setResaltarnombre_productoPedidosCompras(esInicial);
		this.setResaltarnombre_unidadPedidosCompras(esInicial);
		this.setResaltarcantidad_pedidoPedidosCompras(esInicial);
		this.setResaltarcantidad_entregadaPedidosCompras(esInicial);
		this.setResaltarcantidad_pendientePedidosCompras(esInicial);
		this.setResaltarcodigo_productoPedidosCompras(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PedidosComprasConstantesFunciones.ID)) {
				this.setResaltaridPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdePedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADPEDIDO)) {
				this.setResaltarcantidad_pedidoPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADENTREGADA)) {
				this.setResaltarcantidad_entregadaPedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setResaltarcantidad_pendientePedidosCompras(esAsigna);
				continue;
			}

			if(campo.clase.equals(PedidosComprasConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoPedidosCompras(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPedidosComprasPedidosCompras=true;

	public Boolean getMostrarBusquedaPedidosComprasPedidosCompras() {
		return this.mostrarBusquedaPedidosComprasPedidosCompras;
	}

	public void setMostrarBusquedaPedidosComprasPedidosCompras(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPedidosComprasPedidosCompras= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPedidosComprasPedidosCompras=true;

	public Boolean getActivarBusquedaPedidosComprasPedidosCompras() {
		return this.activarBusquedaPedidosComprasPedidosCompras;
	}

	public void setActivarBusquedaPedidosComprasPedidosCompras(Boolean habilitarResaltar) {
		this.activarBusquedaPedidosComprasPedidosCompras= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPedidosComprasPedidosCompras=null;

	public Border getResaltarBusquedaPedidosComprasPedidosCompras() {
		return this.resaltarBusquedaPedidosComprasPedidosCompras;
	}

	public void setResaltarBusquedaPedidosComprasPedidosCompras(Border borderResaltar) {
		this.resaltarBusquedaPedidosComprasPedidosCompras= borderResaltar;
	}

	public void setResaltarBusquedaPedidosComprasPedidosCompras(ParametroGeneralUsuario parametroGeneralUsuario/*PedidosComprasBeanSwingJInternalFrame pedidoscomprasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPedidosComprasPedidosCompras= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}