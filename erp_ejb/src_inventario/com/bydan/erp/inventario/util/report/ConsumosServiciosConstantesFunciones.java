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


import com.bydan.erp.inventario.util.report.ConsumosServiciosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ConsumosServiciosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ConsumosServiciosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
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
final public class ConsumosServiciosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ConsumosServicios";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConsumosServicios"+ConsumosServiciosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConsumosServiciosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConsumosServiciosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConsumosServiciosConstantesFunciones.SCHEMA+"_"+ConsumosServiciosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConsumosServiciosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConsumosServiciosConstantesFunciones.SCHEMA+"_"+ConsumosServiciosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConsumosServiciosConstantesFunciones.SCHEMA+"_"+ConsumosServiciosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConsumosServiciosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConsumosServiciosConstantesFunciones.SCHEMA+"_"+ConsumosServiciosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosServiciosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsumosServiciosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosServiciosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosServiciosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsumosServiciosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosServiciosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConsumosServiciosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConsumosServiciosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConsumosServiciosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConsumosServiciosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Consumos Servicioses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Consumos Servicios";
	public static final String SCLASSWEBTITULO_LOWER="Consumos Servicios";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConsumosServicios";
	public static final String OBJECTNAME="consumosservicios";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="consumos_servicios";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select consumosservicios from "+ConsumosServiciosConstantesFunciones.SPERSISTENCENAME+" consumosservicios";
	public static String QUERYSELECTNATIVE="select "+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".version_row,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id_empresa,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id_transaccion,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id_linea,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id_linea_marca,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".nombre_unidad,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".nombre_producto,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".cantidad,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".nombre_linea,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".codigo,"+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME+".total from "+ConsumosServiciosConstantesFunciones.SCHEMA+"."+ConsumosServiciosConstantesFunciones.TABLENAME;//+" as "+ConsumosServiciosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDTIPOPRODUCTOSERVICIO= "id_tipo_producto_servicio";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CODIGO= "codigo";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
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
    	public static final String LABEL_IDTIPOPRODUCTOSERVICIO= "Tipo Producto Servicio";
		public static final String LABEL_IDTIPOPRODUCTOSERVICIO_LOWER= "Tipo Producto Servicio";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_NOMBRELINEA= "Nombre Linea";
		public static final String LABEL_NOMBRELINEA_LOWER= "Nombre Linea";
    	public static final String LABEL_NOMBRELINEAGRUPO= "Nombre Linea Grupo";
		public static final String LABEL_NOMBRELINEAGRUPO_LOWER= "Nombre Linea Grupo";
    	public static final String LABEL_NOMBRELINEACATEGORIA= "Nombre Linea Categoria";
		public static final String LABEL_NOMBRELINEACATEGORIA_LOWER= "Nombre Linea Categoria";
    	public static final String LABEL_NOMBRELINEAMARCA= "Nombre Linea Marca";
		public static final String LABEL_NOMBRELINEAMARCA_LOWER= "Nombre Linea Marca";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_LINEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getConsumosServiciosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.IDTRANSACCION)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.IDLINEA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.CANTIDAD)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.CODIGO)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ConsumosServiciosConstantesFunciones.TOTAL)) {sLabelColumna=ConsumosServiciosConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConsumosServiciosDescripcion(ConsumosServicios consumosservicios) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(consumosservicios !=null/* && consumosservicios.getId()!=0*/) {
			sDescripcion=consumosservicios.getcodigo();//consumosserviciosconsumosservicios.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConsumosServiciosDescripcionDetallado(ConsumosServicios consumosservicios) {
		String sDescripcion="";
			
		sDescripcion+=ConsumosServiciosConstantesFunciones.ID+"=";
		sDescripcion+=consumosservicios.getId().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=consumosservicios.getVersionRow().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=consumosservicios.getid_empresa().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=consumosservicios.getid_transaccion().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=consumosservicios.getid_linea().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=consumosservicios.getid_linea_grupo().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=consumosservicios.getid_linea_categoria().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=consumosservicios.getid_linea_marca().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=consumosservicios.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=consumosservicios.getfecha_emision_desde().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=consumosservicios.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=consumosservicios.getnombre_unidad()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=consumosservicios.getnombre_producto()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=consumosservicios.getcantidad().toString()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=consumosservicios.getnombre_linea()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=consumosservicios.getnombre_linea_grupo()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=consumosservicios.getnombre_linea_categoria()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=consumosservicios.getnombre_linea_marca()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.CODIGO+"=";
		sDescripcion+=consumosservicios.getcodigo()+",";
		sDescripcion+=ConsumosServiciosConstantesFunciones.TOTAL+"=";
		sDescripcion+=consumosservicios.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConsumosServiciosDescripcion(ConsumosServicios consumosservicios,String sValor) throws Exception {			
		if(consumosservicios !=null) {
			consumosservicios.setcodigo(sValor);;//consumosserviciosconsumosservicios.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("BusquedaConsumosServicios")) {
			sNombreIndice="Tipo=  Por Transaccion Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Tipo Producto Servicio Por Fecha Emision Desde Por Fecha Emision Hasta";
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
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicio")) {
			sNombreIndice="Tipo=  Por Tipo Producto Servicio";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaConsumosServicios(Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
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

	public static String getDetalleIndiceFK_IdTipoProductoServicio(Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConsumosServicios(ConsumosServicios consumosservicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consumosservicios.setnombre_unidad(consumosservicios.getnombre_unidad().trim());
		consumosservicios.setnombre_producto(consumosservicios.getnombre_producto().trim());
		consumosservicios.setnombre_linea(consumosservicios.getnombre_linea().trim());
		consumosservicios.setnombre_linea_grupo(consumosservicios.getnombre_linea_grupo().trim());
		consumosservicios.setnombre_linea_categoria(consumosservicios.getnombre_linea_categoria().trim());
		consumosservicios.setnombre_linea_marca(consumosservicios.getnombre_linea_marca().trim());
		consumosservicios.setcodigo(consumosservicios.getcodigo().trim());
	}
	
	public static void quitarEspaciosConsumosServicioss(List<ConsumosServicios> consumosservicioss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsumosServicios consumosservicios: consumosservicioss) {
			consumosservicios.setnombre_unidad(consumosservicios.getnombre_unidad().trim());
			consumosservicios.setnombre_producto(consumosservicios.getnombre_producto().trim());
			consumosservicios.setnombre_linea(consumosservicios.getnombre_linea().trim());
			consumosservicios.setnombre_linea_grupo(consumosservicios.getnombre_linea_grupo().trim());
			consumosservicios.setnombre_linea_categoria(consumosservicios.getnombre_linea_categoria().trim());
			consumosservicios.setnombre_linea_marca(consumosservicios.getnombre_linea_marca().trim());
			consumosservicios.setcodigo(consumosservicios.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsumosServicios(ConsumosServicios consumosservicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && consumosservicios.getConCambioAuxiliar()) {
			consumosservicios.setIsDeleted(consumosservicios.getIsDeletedAuxiliar());	
			consumosservicios.setIsNew(consumosservicios.getIsNewAuxiliar());	
			consumosservicios.setIsChanged(consumosservicios.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			consumosservicios.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			consumosservicios.setIsDeletedAuxiliar(false);	
			consumosservicios.setIsNewAuxiliar(false);	
			consumosservicios.setIsChangedAuxiliar(false);
			
			consumosservicios.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsumosServicioss(List<ConsumosServicios> consumosservicioss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConsumosServicios consumosservicios : consumosservicioss) {
			if(conAsignarBase && consumosservicios.getConCambioAuxiliar()) {
				consumosservicios.setIsDeleted(consumosservicios.getIsDeletedAuxiliar());	
				consumosservicios.setIsNew(consumosservicios.getIsNewAuxiliar());	
				consumosservicios.setIsChanged(consumosservicios.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				consumosservicios.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				consumosservicios.setIsDeletedAuxiliar(false);	
				consumosservicios.setIsNewAuxiliar(false);	
				consumosservicios.setIsChangedAuxiliar(false);
				
				consumosservicios.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConsumosServicios(ConsumosServicios consumosservicios,Boolean conEnteros) throws Exception  {
		consumosservicios.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			consumosservicios.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresConsumosServicioss(List<ConsumosServicios> consumosservicioss,Boolean conEnteros) throws Exception  {
		
		for(ConsumosServicios consumosservicios: consumosservicioss) {
			consumosservicios.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				consumosservicios.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaConsumosServicios(List<ConsumosServicios> consumosservicioss,ConsumosServicios consumosserviciosAux) throws Exception  {
		ConsumosServiciosConstantesFunciones.InicializarValoresConsumosServicios(consumosserviciosAux,true);
		
		for(ConsumosServicios consumosservicios: consumosservicioss) {
			if(consumosservicios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			consumosserviciosAux.setcantidad(consumosserviciosAux.getcantidad()+consumosservicios.getcantidad());			
			consumosserviciosAux.settotal(consumosserviciosAux.gettotal()+consumosservicios.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsumosServicios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConsumosServiciosConstantesFunciones.getArrayColumnasGlobalesConsumosServicios(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConsumosServicios(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsumosServiciosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsumosServiciosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConsumosServicios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsumosServicios> consumosservicioss,ConsumosServicios consumosservicios,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsumosServicios consumosserviciosAux: consumosservicioss) {
			if(consumosserviciosAux!=null && consumosservicios!=null) {
				if((consumosserviciosAux.getId()==null && consumosservicios.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(consumosserviciosAux.getId()!=null && consumosservicios.getId()!=null){
					if(consumosserviciosAux.getId().equals(consumosservicios.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsumosServicios(List<ConsumosServicios> consumosservicioss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(ConsumosServicios consumosservicios: consumosservicioss) {			
			if(consumosservicios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=consumosservicios.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsumosServiciosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConsumosServicios() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_ID, ConsumosServiciosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_VERSIONROW, ConsumosServiciosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_NOMBREUNIDAD, ConsumosServiciosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_NOMBREPRODUCTO, ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_CANTIDAD, ConsumosServiciosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEA, ConsumosServiciosConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAMARCA, ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_CODIGO, ConsumosServiciosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosServiciosConstantesFunciones.LABEL_TOTAL, ConsumosServiciosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConsumosServicios() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosServiciosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsumosServicios() throws Exception  {
		return ConsumosServiciosConstantesFunciones.getTiposSeleccionarConsumosServicios(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsumosServicios(Boolean conFk) throws Exception  {
		return ConsumosServiciosConstantesFunciones.getTiposSeleccionarConsumosServicios(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsumosServicios(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosServiciosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConsumosServicios(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConsumosServicios(ConsumosServicios consumosserviciosAux) throws Exception {
		
			consumosserviciosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consumosserviciosAux.getEmpresa()));
			consumosserviciosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(consumosserviciosAux.getTransaccion()));
			consumosserviciosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLinea()));
			consumosserviciosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLineaGrupo()));
			consumosserviciosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLineaCategoria()));
			consumosserviciosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLineaMarca()));
			consumosserviciosAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(consumosserviciosAux.getTipoProductoServicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConsumosServicios(List<ConsumosServicios> consumosserviciossTemp) throws Exception {
		for(ConsumosServicios consumosserviciosAux:consumosserviciossTemp) {
			
			consumosserviciosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consumosserviciosAux.getEmpresa()));
			consumosserviciosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(consumosserviciosAux.getTransaccion()));
			consumosserviciosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLinea()));
			consumosserviciosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLineaGrupo()));
			consumosserviciosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLineaCategoria()));
			consumosserviciosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosserviciosAux.getLineaMarca()));
			consumosserviciosAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(consumosserviciosAux.getTipoProductoServicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConsumosServicios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConsumosServicios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsumosServicios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsumosServiciosConstantesFunciones.getClassesRelationshipsOfConsumosServicios(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsumosServicios(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsumosServicios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsumosServiciosConstantesFunciones.getClassesRelationshipsFromStringsOfConsumosServicios(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsumosServicios(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConsumosServicios consumosservicios,List<ConsumosServicios> consumosservicioss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ConsumosServicios consumosservicios,List<ConsumosServicios> consumosservicioss) throws Exception {
		try	{			
			for(ConsumosServicios consumosserviciosLocal:consumosservicioss) {
				if(consumosserviciosLocal.getId().equals(consumosservicios.getId())) {
					consumosserviciosLocal.setIsSelected(consumosservicios.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConsumosServicios(List<ConsumosServicios> consumosserviciossAux) throws Exception {
		//this.consumosserviciossAux=consumosserviciossAux;
		
		for(ConsumosServicios consumosserviciosAux:consumosserviciossAux) {
			if(consumosserviciosAux.getIsChanged()) {
				consumosserviciosAux.setIsChanged(false);
			}		
			
			if(consumosserviciosAux.getIsNew()) {
				consumosserviciosAux.setIsNew(false);
			}	
			
			if(consumosserviciosAux.getIsDeleted()) {
				consumosserviciosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConsumosServicios(ConsumosServicios consumosserviciosAux) throws Exception {
		//this.consumosserviciosAux=consumosserviciosAux;
		
			if(consumosserviciosAux.getIsChanged()) {
				consumosserviciosAux.setIsChanged(false);
			}		
			
			if(consumosserviciosAux.getIsNew()) {
				consumosserviciosAux.setIsNew(false);
			}	
			
			if(consumosserviciosAux.getIsDeleted()) {
				consumosserviciosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConsumosServicios consumosserviciosAsignar,ConsumosServicios consumosservicios) throws Exception {
		consumosserviciosAsignar.setId(consumosservicios.getId());	
		consumosserviciosAsignar.setVersionRow(consumosservicios.getVersionRow());	
		consumosserviciosAsignar.setnombre_unidad(consumosservicios.getnombre_unidad());	
		consumosserviciosAsignar.setnombre_producto(consumosservicios.getnombre_producto());	
		consumosserviciosAsignar.setcantidad(consumosservicios.getcantidad());	
		consumosserviciosAsignar.setnombre_linea(consumosservicios.getnombre_linea());	
		consumosserviciosAsignar.setnombre_linea_grupo(consumosservicios.getnombre_linea_grupo());	
		consumosserviciosAsignar.setnombre_linea_categoria(consumosservicios.getnombre_linea_categoria());	
		consumosserviciosAsignar.setnombre_linea_marca(consumosservicios.getnombre_linea_marca());	
		consumosserviciosAsignar.setcodigo(consumosservicios.getcodigo());	
		consumosserviciosAsignar.settotal(consumosservicios.gettotal());	
	}
	
	public static void inicializarConsumosServicios(ConsumosServicios consumosservicios) throws Exception {
		try {
				consumosservicios.setId(0L);	
					
				consumosservicios.setnombre_unidad("");	
				consumosservicios.setnombre_producto("");	
				consumosservicios.setcantidad(0);	
				consumosservicios.setnombre_linea("");	
				consumosservicios.setnombre_linea_grupo("");	
				consumosservicios.setnombre_linea_categoria("");	
				consumosservicios.setnombre_linea_marca("");	
				consumosservicios.setcodigo("");	
				consumosservicios.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConsumosServicios(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosServiciosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConsumosServicios(String sTipo,Row row,Workbook workbook,ConsumosServicios consumosservicios,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosservicios.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConsumosServicios="";
	
	public String getsFinalQueryConsumosServicios() {
		return this.sFinalQueryConsumosServicios;
	}
	
	public void setsFinalQueryConsumosServicios(String sFinalQueryConsumosServicios) {
		this.sFinalQueryConsumosServicios= sFinalQueryConsumosServicios;
	}
	
	public Border resaltarSeleccionarConsumosServicios=null;
	
	public Border setResaltarSeleccionarConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConsumosServicios= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConsumosServicios() {
		return this.resaltarSeleccionarConsumosServicios;
	}
	
	public void setResaltarSeleccionarConsumosServicios(Border borderResaltarSeleccionarConsumosServicios) {
		this.resaltarSeleccionarConsumosServicios= borderResaltarSeleccionarConsumosServicios;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConsumosServicios=null;
	public Boolean mostraridConsumosServicios=true;
	public Boolean activaridConsumosServicios=true;

	public Border resaltarid_empresaConsumosServicios=null;
	public Boolean mostrarid_empresaConsumosServicios=true;
	public Boolean activarid_empresaConsumosServicios=true;
	public Boolean cargarid_empresaConsumosServicios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConsumosServicios=false;//ConEventDepend=true

	public Border resaltarid_transaccionConsumosServicios=null;
	public Boolean mostrarid_transaccionConsumosServicios=true;
	public Boolean activarid_transaccionConsumosServicios=true;
	public Boolean cargarid_transaccionConsumosServicios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionConsumosServicios=false;//ConEventDepend=true

	public Border resaltarid_lineaConsumosServicios=null;
	public Boolean mostrarid_lineaConsumosServicios=true;
	public Boolean activarid_lineaConsumosServicios=true;
	public Boolean cargarid_lineaConsumosServicios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaConsumosServicios=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoConsumosServicios=null;
	public Boolean mostrarid_linea_grupoConsumosServicios=true;
	public Boolean activarid_linea_grupoConsumosServicios=true;
	public Boolean cargarid_linea_grupoConsumosServicios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoConsumosServicios=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaConsumosServicios=null;
	public Boolean mostrarid_linea_categoriaConsumosServicios=true;
	public Boolean activarid_linea_categoriaConsumosServicios=true;
	public Boolean cargarid_linea_categoriaConsumosServicios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaConsumosServicios=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaConsumosServicios=null;
	public Boolean mostrarid_linea_marcaConsumosServicios=true;
	public Boolean activarid_linea_marcaConsumosServicios=true;
	public Boolean cargarid_linea_marcaConsumosServicios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaConsumosServicios=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioConsumosServicios=null;
	public Boolean mostrarid_tipo_producto_servicioConsumosServicios=true;
	public Boolean activarid_tipo_producto_servicioConsumosServicios=true;
	public Boolean cargarid_tipo_producto_servicioConsumosServicios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioConsumosServicios=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeConsumosServicios=null;
	public Boolean mostrarfecha_emision_desdeConsumosServicios=true;
	public Boolean activarfecha_emision_desdeConsumosServicios=true;

	public Border resaltarfecha_emision_hastaConsumosServicios=null;
	public Boolean mostrarfecha_emision_hastaConsumosServicios=true;
	public Boolean activarfecha_emision_hastaConsumosServicios=true;

	public Border resaltarnombre_unidadConsumosServicios=null;
	public Boolean mostrarnombre_unidadConsumosServicios=true;
	public Boolean activarnombre_unidadConsumosServicios=true;

	public Border resaltarnombre_productoConsumosServicios=null;
	public Boolean mostrarnombre_productoConsumosServicios=true;
	public Boolean activarnombre_productoConsumosServicios=true;

	public Border resaltarcantidadConsumosServicios=null;
	public Boolean mostrarcantidadConsumosServicios=true;
	public Boolean activarcantidadConsumosServicios=true;

	public Border resaltarnombre_lineaConsumosServicios=null;
	public Boolean mostrarnombre_lineaConsumosServicios=true;
	public Boolean activarnombre_lineaConsumosServicios=true;

	public Border resaltarnombre_linea_grupoConsumosServicios=null;
	public Boolean mostrarnombre_linea_grupoConsumosServicios=true;
	public Boolean activarnombre_linea_grupoConsumosServicios=true;

	public Border resaltarnombre_linea_categoriaConsumosServicios=null;
	public Boolean mostrarnombre_linea_categoriaConsumosServicios=true;
	public Boolean activarnombre_linea_categoriaConsumosServicios=true;

	public Border resaltarnombre_linea_marcaConsumosServicios=null;
	public Boolean mostrarnombre_linea_marcaConsumosServicios=true;
	public Boolean activarnombre_linea_marcaConsumosServicios=true;

	public Border resaltarcodigoConsumosServicios=null;
	public Boolean mostrarcodigoConsumosServicios=true;
	public Boolean activarcodigoConsumosServicios=true;

	public Border resaltartotalConsumosServicios=null;
	public Boolean mostrartotalConsumosServicios=true;
	public Boolean activartotalConsumosServicios=true;

	
	

	public Border setResaltaridConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltaridConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConsumosServicios() {
		return this.resaltaridConsumosServicios;
	}

	public void setResaltaridConsumosServicios(Border borderResaltar) {
		this.resaltaridConsumosServicios= borderResaltar;
	}

	public Boolean getMostraridConsumosServicios() {
		return this.mostraridConsumosServicios;
	}

	public void setMostraridConsumosServicios(Boolean mostraridConsumosServicios) {
		this.mostraridConsumosServicios= mostraridConsumosServicios;
	}

	public Boolean getActivaridConsumosServicios() {
		return this.activaridConsumosServicios;
	}

	public void setActivaridConsumosServicios(Boolean activaridConsumosServicios) {
		this.activaridConsumosServicios= activaridConsumosServicios;
	}

	public Border setResaltarid_empresaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarid_empresaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConsumosServicios() {
		return this.resaltarid_empresaConsumosServicios;
	}

	public void setResaltarid_empresaConsumosServicios(Border borderResaltar) {
		this.resaltarid_empresaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarid_empresaConsumosServicios() {
		return this.mostrarid_empresaConsumosServicios;
	}

	public void setMostrarid_empresaConsumosServicios(Boolean mostrarid_empresaConsumosServicios) {
		this.mostrarid_empresaConsumosServicios= mostrarid_empresaConsumosServicios;
	}

	public Boolean getActivarid_empresaConsumosServicios() {
		return this.activarid_empresaConsumosServicios;
	}

	public void setActivarid_empresaConsumosServicios(Boolean activarid_empresaConsumosServicios) {
		this.activarid_empresaConsumosServicios= activarid_empresaConsumosServicios;
	}

	public Boolean getCargarid_empresaConsumosServicios() {
		return this.cargarid_empresaConsumosServicios;
	}

	public void setCargarid_empresaConsumosServicios(Boolean cargarid_empresaConsumosServicios) {
		this.cargarid_empresaConsumosServicios= cargarid_empresaConsumosServicios;
	}

	public Border setResaltarid_transaccionConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarid_transaccionConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionConsumosServicios() {
		return this.resaltarid_transaccionConsumosServicios;
	}

	public void setResaltarid_transaccionConsumosServicios(Border borderResaltar) {
		this.resaltarid_transaccionConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarid_transaccionConsumosServicios() {
		return this.mostrarid_transaccionConsumosServicios;
	}

	public void setMostrarid_transaccionConsumosServicios(Boolean mostrarid_transaccionConsumosServicios) {
		this.mostrarid_transaccionConsumosServicios= mostrarid_transaccionConsumosServicios;
	}

	public Boolean getActivarid_transaccionConsumosServicios() {
		return this.activarid_transaccionConsumosServicios;
	}

	public void setActivarid_transaccionConsumosServicios(Boolean activarid_transaccionConsumosServicios) {
		this.activarid_transaccionConsumosServicios= activarid_transaccionConsumosServicios;
	}

	public Boolean getCargarid_transaccionConsumosServicios() {
		return this.cargarid_transaccionConsumosServicios;
	}

	public void setCargarid_transaccionConsumosServicios(Boolean cargarid_transaccionConsumosServicios) {
		this.cargarid_transaccionConsumosServicios= cargarid_transaccionConsumosServicios;
	}

	public Border setResaltarid_lineaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarid_lineaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaConsumosServicios() {
		return this.resaltarid_lineaConsumosServicios;
	}

	public void setResaltarid_lineaConsumosServicios(Border borderResaltar) {
		this.resaltarid_lineaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarid_lineaConsumosServicios() {
		return this.mostrarid_lineaConsumosServicios;
	}

	public void setMostrarid_lineaConsumosServicios(Boolean mostrarid_lineaConsumosServicios) {
		this.mostrarid_lineaConsumosServicios= mostrarid_lineaConsumosServicios;
	}

	public Boolean getActivarid_lineaConsumosServicios() {
		return this.activarid_lineaConsumosServicios;
	}

	public void setActivarid_lineaConsumosServicios(Boolean activarid_lineaConsumosServicios) {
		this.activarid_lineaConsumosServicios= activarid_lineaConsumosServicios;
	}

	public Boolean getCargarid_lineaConsumosServicios() {
		return this.cargarid_lineaConsumosServicios;
	}

	public void setCargarid_lineaConsumosServicios(Boolean cargarid_lineaConsumosServicios) {
		this.cargarid_lineaConsumosServicios= cargarid_lineaConsumosServicios;
	}

	public Border setResaltarid_linea_grupoConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoConsumosServicios() {
		return this.resaltarid_linea_grupoConsumosServicios;
	}

	public void setResaltarid_linea_grupoConsumosServicios(Border borderResaltar) {
		this.resaltarid_linea_grupoConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoConsumosServicios() {
		return this.mostrarid_linea_grupoConsumosServicios;
	}

	public void setMostrarid_linea_grupoConsumosServicios(Boolean mostrarid_linea_grupoConsumosServicios) {
		this.mostrarid_linea_grupoConsumosServicios= mostrarid_linea_grupoConsumosServicios;
	}

	public Boolean getActivarid_linea_grupoConsumosServicios() {
		return this.activarid_linea_grupoConsumosServicios;
	}

	public void setActivarid_linea_grupoConsumosServicios(Boolean activarid_linea_grupoConsumosServicios) {
		this.activarid_linea_grupoConsumosServicios= activarid_linea_grupoConsumosServicios;
	}

	public Boolean getCargarid_linea_grupoConsumosServicios() {
		return this.cargarid_linea_grupoConsumosServicios;
	}

	public void setCargarid_linea_grupoConsumosServicios(Boolean cargarid_linea_grupoConsumosServicios) {
		this.cargarid_linea_grupoConsumosServicios= cargarid_linea_grupoConsumosServicios;
	}

	public Border setResaltarid_linea_categoriaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaConsumosServicios() {
		return this.resaltarid_linea_categoriaConsumosServicios;
	}

	public void setResaltarid_linea_categoriaConsumosServicios(Border borderResaltar) {
		this.resaltarid_linea_categoriaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaConsumosServicios() {
		return this.mostrarid_linea_categoriaConsumosServicios;
	}

	public void setMostrarid_linea_categoriaConsumosServicios(Boolean mostrarid_linea_categoriaConsumosServicios) {
		this.mostrarid_linea_categoriaConsumosServicios= mostrarid_linea_categoriaConsumosServicios;
	}

	public Boolean getActivarid_linea_categoriaConsumosServicios() {
		return this.activarid_linea_categoriaConsumosServicios;
	}

	public void setActivarid_linea_categoriaConsumosServicios(Boolean activarid_linea_categoriaConsumosServicios) {
		this.activarid_linea_categoriaConsumosServicios= activarid_linea_categoriaConsumosServicios;
	}

	public Boolean getCargarid_linea_categoriaConsumosServicios() {
		return this.cargarid_linea_categoriaConsumosServicios;
	}

	public void setCargarid_linea_categoriaConsumosServicios(Boolean cargarid_linea_categoriaConsumosServicios) {
		this.cargarid_linea_categoriaConsumosServicios= cargarid_linea_categoriaConsumosServicios;
	}

	public Border setResaltarid_linea_marcaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaConsumosServicios() {
		return this.resaltarid_linea_marcaConsumosServicios;
	}

	public void setResaltarid_linea_marcaConsumosServicios(Border borderResaltar) {
		this.resaltarid_linea_marcaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaConsumosServicios() {
		return this.mostrarid_linea_marcaConsumosServicios;
	}

	public void setMostrarid_linea_marcaConsumosServicios(Boolean mostrarid_linea_marcaConsumosServicios) {
		this.mostrarid_linea_marcaConsumosServicios= mostrarid_linea_marcaConsumosServicios;
	}

	public Boolean getActivarid_linea_marcaConsumosServicios() {
		return this.activarid_linea_marcaConsumosServicios;
	}

	public void setActivarid_linea_marcaConsumosServicios(Boolean activarid_linea_marcaConsumosServicios) {
		this.activarid_linea_marcaConsumosServicios= activarid_linea_marcaConsumosServicios;
	}

	public Boolean getCargarid_linea_marcaConsumosServicios() {
		return this.cargarid_linea_marcaConsumosServicios;
	}

	public void setCargarid_linea_marcaConsumosServicios(Boolean cargarid_linea_marcaConsumosServicios) {
		this.cargarid_linea_marcaConsumosServicios= cargarid_linea_marcaConsumosServicios;
	}

	public Border setResaltarid_tipo_producto_servicioConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioConsumosServicios() {
		return this.resaltarid_tipo_producto_servicioConsumosServicios;
	}

	public void setResaltarid_tipo_producto_servicioConsumosServicios(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioConsumosServicios() {
		return this.mostrarid_tipo_producto_servicioConsumosServicios;
	}

	public void setMostrarid_tipo_producto_servicioConsumosServicios(Boolean mostrarid_tipo_producto_servicioConsumosServicios) {
		this.mostrarid_tipo_producto_servicioConsumosServicios= mostrarid_tipo_producto_servicioConsumosServicios;
	}

	public Boolean getActivarid_tipo_producto_servicioConsumosServicios() {
		return this.activarid_tipo_producto_servicioConsumosServicios;
	}

	public void setActivarid_tipo_producto_servicioConsumosServicios(Boolean activarid_tipo_producto_servicioConsumosServicios) {
		this.activarid_tipo_producto_servicioConsumosServicios= activarid_tipo_producto_servicioConsumosServicios;
	}

	public Boolean getCargarid_tipo_producto_servicioConsumosServicios() {
		return this.cargarid_tipo_producto_servicioConsumosServicios;
	}

	public void setCargarid_tipo_producto_servicioConsumosServicios(Boolean cargarid_tipo_producto_servicioConsumosServicios) {
		this.cargarid_tipo_producto_servicioConsumosServicios= cargarid_tipo_producto_servicioConsumosServicios;
	}

	public Border setResaltarfecha_emision_desdeConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeConsumosServicios() {
		return this.resaltarfecha_emision_desdeConsumosServicios;
	}

	public void setResaltarfecha_emision_desdeConsumosServicios(Border borderResaltar) {
		this.resaltarfecha_emision_desdeConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeConsumosServicios() {
		return this.mostrarfecha_emision_desdeConsumosServicios;
	}

	public void setMostrarfecha_emision_desdeConsumosServicios(Boolean mostrarfecha_emision_desdeConsumosServicios) {
		this.mostrarfecha_emision_desdeConsumosServicios= mostrarfecha_emision_desdeConsumosServicios;
	}

	public Boolean getActivarfecha_emision_desdeConsumosServicios() {
		return this.activarfecha_emision_desdeConsumosServicios;
	}

	public void setActivarfecha_emision_desdeConsumosServicios(Boolean activarfecha_emision_desdeConsumosServicios) {
		this.activarfecha_emision_desdeConsumosServicios= activarfecha_emision_desdeConsumosServicios;
	}

	public Border setResaltarfecha_emision_hastaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaConsumosServicios() {
		return this.resaltarfecha_emision_hastaConsumosServicios;
	}

	public void setResaltarfecha_emision_hastaConsumosServicios(Border borderResaltar) {
		this.resaltarfecha_emision_hastaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaConsumosServicios() {
		return this.mostrarfecha_emision_hastaConsumosServicios;
	}

	public void setMostrarfecha_emision_hastaConsumosServicios(Boolean mostrarfecha_emision_hastaConsumosServicios) {
		this.mostrarfecha_emision_hastaConsumosServicios= mostrarfecha_emision_hastaConsumosServicios;
	}

	public Boolean getActivarfecha_emision_hastaConsumosServicios() {
		return this.activarfecha_emision_hastaConsumosServicios;
	}

	public void setActivarfecha_emision_hastaConsumosServicios(Boolean activarfecha_emision_hastaConsumosServicios) {
		this.activarfecha_emision_hastaConsumosServicios= activarfecha_emision_hastaConsumosServicios;
	}

	public Border setResaltarnombre_unidadConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadConsumosServicios() {
		return this.resaltarnombre_unidadConsumosServicios;
	}

	public void setResaltarnombre_unidadConsumosServicios(Border borderResaltar) {
		this.resaltarnombre_unidadConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadConsumosServicios() {
		return this.mostrarnombre_unidadConsumosServicios;
	}

	public void setMostrarnombre_unidadConsumosServicios(Boolean mostrarnombre_unidadConsumosServicios) {
		this.mostrarnombre_unidadConsumosServicios= mostrarnombre_unidadConsumosServicios;
	}

	public Boolean getActivarnombre_unidadConsumosServicios() {
		return this.activarnombre_unidadConsumosServicios;
	}

	public void setActivarnombre_unidadConsumosServicios(Boolean activarnombre_unidadConsumosServicios) {
		this.activarnombre_unidadConsumosServicios= activarnombre_unidadConsumosServicios;
	}

	public Border setResaltarnombre_productoConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarnombre_productoConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoConsumosServicios() {
		return this.resaltarnombre_productoConsumosServicios;
	}

	public void setResaltarnombre_productoConsumosServicios(Border borderResaltar) {
		this.resaltarnombre_productoConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarnombre_productoConsumosServicios() {
		return this.mostrarnombre_productoConsumosServicios;
	}

	public void setMostrarnombre_productoConsumosServicios(Boolean mostrarnombre_productoConsumosServicios) {
		this.mostrarnombre_productoConsumosServicios= mostrarnombre_productoConsumosServicios;
	}

	public Boolean getActivarnombre_productoConsumosServicios() {
		return this.activarnombre_productoConsumosServicios;
	}

	public void setActivarnombre_productoConsumosServicios(Boolean activarnombre_productoConsumosServicios) {
		this.activarnombre_productoConsumosServicios= activarnombre_productoConsumosServicios;
	}

	public Border setResaltarcantidadConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarcantidadConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadConsumosServicios() {
		return this.resaltarcantidadConsumosServicios;
	}

	public void setResaltarcantidadConsumosServicios(Border borderResaltar) {
		this.resaltarcantidadConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarcantidadConsumosServicios() {
		return this.mostrarcantidadConsumosServicios;
	}

	public void setMostrarcantidadConsumosServicios(Boolean mostrarcantidadConsumosServicios) {
		this.mostrarcantidadConsumosServicios= mostrarcantidadConsumosServicios;
	}

	public Boolean getActivarcantidadConsumosServicios() {
		return this.activarcantidadConsumosServicios;
	}

	public void setActivarcantidadConsumosServicios(Boolean activarcantidadConsumosServicios) {
		this.activarcantidadConsumosServicios= activarcantidadConsumosServicios;
	}

	public Border setResaltarnombre_lineaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaConsumosServicios() {
		return this.resaltarnombre_lineaConsumosServicios;
	}

	public void setResaltarnombre_lineaConsumosServicios(Border borderResaltar) {
		this.resaltarnombre_lineaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaConsumosServicios() {
		return this.mostrarnombre_lineaConsumosServicios;
	}

	public void setMostrarnombre_lineaConsumosServicios(Boolean mostrarnombre_lineaConsumosServicios) {
		this.mostrarnombre_lineaConsumosServicios= mostrarnombre_lineaConsumosServicios;
	}

	public Boolean getActivarnombre_lineaConsumosServicios() {
		return this.activarnombre_lineaConsumosServicios;
	}

	public void setActivarnombre_lineaConsumosServicios(Boolean activarnombre_lineaConsumosServicios) {
		this.activarnombre_lineaConsumosServicios= activarnombre_lineaConsumosServicios;
	}

	public Border setResaltarnombre_linea_grupoConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoConsumosServicios() {
		return this.resaltarnombre_linea_grupoConsumosServicios;
	}

	public void setResaltarnombre_linea_grupoConsumosServicios(Border borderResaltar) {
		this.resaltarnombre_linea_grupoConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoConsumosServicios() {
		return this.mostrarnombre_linea_grupoConsumosServicios;
	}

	public void setMostrarnombre_linea_grupoConsumosServicios(Boolean mostrarnombre_linea_grupoConsumosServicios) {
		this.mostrarnombre_linea_grupoConsumosServicios= mostrarnombre_linea_grupoConsumosServicios;
	}

	public Boolean getActivarnombre_linea_grupoConsumosServicios() {
		return this.activarnombre_linea_grupoConsumosServicios;
	}

	public void setActivarnombre_linea_grupoConsumosServicios(Boolean activarnombre_linea_grupoConsumosServicios) {
		this.activarnombre_linea_grupoConsumosServicios= activarnombre_linea_grupoConsumosServicios;
	}

	public Border setResaltarnombre_linea_categoriaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaConsumosServicios() {
		return this.resaltarnombre_linea_categoriaConsumosServicios;
	}

	public void setResaltarnombre_linea_categoriaConsumosServicios(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaConsumosServicios() {
		return this.mostrarnombre_linea_categoriaConsumosServicios;
	}

	public void setMostrarnombre_linea_categoriaConsumosServicios(Boolean mostrarnombre_linea_categoriaConsumosServicios) {
		this.mostrarnombre_linea_categoriaConsumosServicios= mostrarnombre_linea_categoriaConsumosServicios;
	}

	public Boolean getActivarnombre_linea_categoriaConsumosServicios() {
		return this.activarnombre_linea_categoriaConsumosServicios;
	}

	public void setActivarnombre_linea_categoriaConsumosServicios(Boolean activarnombre_linea_categoriaConsumosServicios) {
		this.activarnombre_linea_categoriaConsumosServicios= activarnombre_linea_categoriaConsumosServicios;
	}

	public Border setResaltarnombre_linea_marcaConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaConsumosServicios() {
		return this.resaltarnombre_linea_marcaConsumosServicios;
	}

	public void setResaltarnombre_linea_marcaConsumosServicios(Border borderResaltar) {
		this.resaltarnombre_linea_marcaConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaConsumosServicios() {
		return this.mostrarnombre_linea_marcaConsumosServicios;
	}

	public void setMostrarnombre_linea_marcaConsumosServicios(Boolean mostrarnombre_linea_marcaConsumosServicios) {
		this.mostrarnombre_linea_marcaConsumosServicios= mostrarnombre_linea_marcaConsumosServicios;
	}

	public Boolean getActivarnombre_linea_marcaConsumosServicios() {
		return this.activarnombre_linea_marcaConsumosServicios;
	}

	public void setActivarnombre_linea_marcaConsumosServicios(Boolean activarnombre_linea_marcaConsumosServicios) {
		this.activarnombre_linea_marcaConsumosServicios= activarnombre_linea_marcaConsumosServicios;
	}

	public Border setResaltarcodigoConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltarcodigoConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoConsumosServicios() {
		return this.resaltarcodigoConsumosServicios;
	}

	public void setResaltarcodigoConsumosServicios(Border borderResaltar) {
		this.resaltarcodigoConsumosServicios= borderResaltar;
	}

	public Boolean getMostrarcodigoConsumosServicios() {
		return this.mostrarcodigoConsumosServicios;
	}

	public void setMostrarcodigoConsumosServicios(Boolean mostrarcodigoConsumosServicios) {
		this.mostrarcodigoConsumosServicios= mostrarcodigoConsumosServicios;
	}

	public Boolean getActivarcodigoConsumosServicios() {
		return this.activarcodigoConsumosServicios;
	}

	public void setActivarcodigoConsumosServicios(Boolean activarcodigoConsumosServicios) {
		this.activarcodigoConsumosServicios= activarcodigoConsumosServicios;
	}

	public Border setResaltartotalConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosserviciosBeanSwingJInternalFrame.jTtoolBarConsumosServicios.setBorder(borderResaltar);
		
		this.resaltartotalConsumosServicios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalConsumosServicios() {
		return this.resaltartotalConsumosServicios;
	}

	public void setResaltartotalConsumosServicios(Border borderResaltar) {
		this.resaltartotalConsumosServicios= borderResaltar;
	}

	public Boolean getMostrartotalConsumosServicios() {
		return this.mostrartotalConsumosServicios;
	}

	public void setMostrartotalConsumosServicios(Boolean mostrartotalConsumosServicios) {
		this.mostrartotalConsumosServicios= mostrartotalConsumosServicios;
	}

	public Boolean getActivartotalConsumosServicios() {
		return this.activartotalConsumosServicios;
	}

	public void setActivartotalConsumosServicios(Boolean activartotalConsumosServicios) {
		this.activartotalConsumosServicios= activartotalConsumosServicios;
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
		
		
		this.setMostraridConsumosServicios(esInicial);
		this.setMostrarid_empresaConsumosServicios(esInicial);
		this.setMostrarid_transaccionConsumosServicios(esInicial);
		this.setMostrarid_lineaConsumosServicios(esInicial);
		this.setMostrarid_linea_grupoConsumosServicios(esInicial);
		this.setMostrarid_linea_categoriaConsumosServicios(esInicial);
		this.setMostrarid_linea_marcaConsumosServicios(esInicial);
		this.setMostrarid_tipo_producto_servicioConsumosServicios(esInicial);
		this.setMostrarfecha_emision_desdeConsumosServicios(esInicial);
		this.setMostrarfecha_emision_hastaConsumosServicios(esInicial);
		this.setMostrarnombre_unidadConsumosServicios(esInicial);
		this.setMostrarnombre_productoConsumosServicios(esInicial);
		this.setMostrarcantidadConsumosServicios(esInicial);
		this.setMostrarnombre_lineaConsumosServicios(esInicial);
		this.setMostrarnombre_linea_grupoConsumosServicios(esInicial);
		this.setMostrarnombre_linea_categoriaConsumosServicios(esInicial);
		this.setMostrarnombre_linea_marcaConsumosServicios(esInicial);
		this.setMostrarcodigoConsumosServicios(esInicial);
		this.setMostrartotalConsumosServicios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.ID)) {
				this.setMostraridConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.TOTAL)) {
				this.setMostrartotalConsumosServicios(esAsigna);
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
		
		
		this.setActivaridConsumosServicios(esInicial);
		this.setActivarid_empresaConsumosServicios(esInicial);
		this.setActivarid_transaccionConsumosServicios(esInicial);
		this.setActivarid_lineaConsumosServicios(esInicial);
		this.setActivarid_linea_grupoConsumosServicios(esInicial);
		this.setActivarid_linea_categoriaConsumosServicios(esInicial);
		this.setActivarid_linea_marcaConsumosServicios(esInicial);
		this.setActivarid_tipo_producto_servicioConsumosServicios(esInicial);
		this.setActivarfecha_emision_desdeConsumosServicios(esInicial);
		this.setActivarfecha_emision_hastaConsumosServicios(esInicial);
		this.setActivarnombre_unidadConsumosServicios(esInicial);
		this.setActivarnombre_productoConsumosServicios(esInicial);
		this.setActivarcantidadConsumosServicios(esInicial);
		this.setActivarnombre_lineaConsumosServicios(esInicial);
		this.setActivarnombre_linea_grupoConsumosServicios(esInicial);
		this.setActivarnombre_linea_categoriaConsumosServicios(esInicial);
		this.setActivarnombre_linea_marcaConsumosServicios(esInicial);
		this.setActivarcodigoConsumosServicios(esInicial);
		this.setActivartotalConsumosServicios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.ID)) {
				this.setActivaridConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.TOTAL)) {
				this.setActivartotalConsumosServicios(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConsumosServicios(esInicial);
		this.setResaltarid_empresaConsumosServicios(esInicial);
		this.setResaltarid_transaccionConsumosServicios(esInicial);
		this.setResaltarid_lineaConsumosServicios(esInicial);
		this.setResaltarid_linea_grupoConsumosServicios(esInicial);
		this.setResaltarid_linea_categoriaConsumosServicios(esInicial);
		this.setResaltarid_linea_marcaConsumosServicios(esInicial);
		this.setResaltarid_tipo_producto_servicioConsumosServicios(esInicial);
		this.setResaltarfecha_emision_desdeConsumosServicios(esInicial);
		this.setResaltarfecha_emision_hastaConsumosServicios(esInicial);
		this.setResaltarnombre_unidadConsumosServicios(esInicial);
		this.setResaltarnombre_productoConsumosServicios(esInicial);
		this.setResaltarcantidadConsumosServicios(esInicial);
		this.setResaltarnombre_lineaConsumosServicios(esInicial);
		this.setResaltarnombre_linea_grupoConsumosServicios(esInicial);
		this.setResaltarnombre_linea_categoriaConsumosServicios(esInicial);
		this.setResaltarnombre_linea_marcaConsumosServicios(esInicial);
		this.setResaltarcodigoConsumosServicios(esInicial);
		this.setResaltartotalConsumosServicios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.ID)) {
				this.setResaltaridConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoConsumosServicios(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosServiciosConstantesFunciones.TOTAL)) {
				this.setResaltartotalConsumosServicios(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaConsumosServiciosConsumosServicios=true;

	public Boolean getMostrarBusquedaConsumosServiciosConsumosServicios() {
		return this.mostrarBusquedaConsumosServiciosConsumosServicios;
	}

	public void setMostrarBusquedaConsumosServiciosConsumosServicios(Boolean visibilidadResaltar) {
		this.mostrarBusquedaConsumosServiciosConsumosServicios= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaConsumosServiciosConsumosServicios=true;

	public Boolean getActivarBusquedaConsumosServiciosConsumosServicios() {
		return this.activarBusquedaConsumosServiciosConsumosServicios;
	}

	public void setActivarBusquedaConsumosServiciosConsumosServicios(Boolean habilitarResaltar) {
		this.activarBusquedaConsumosServiciosConsumosServicios= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaConsumosServiciosConsumosServicios=null;

	public Border getResaltarBusquedaConsumosServiciosConsumosServicios() {
		return this.resaltarBusquedaConsumosServiciosConsumosServicios;
	}

	public void setResaltarBusquedaConsumosServiciosConsumosServicios(Border borderResaltar) {
		this.resaltarBusquedaConsumosServiciosConsumosServicios= borderResaltar;
	}

	public void setResaltarBusquedaConsumosServiciosConsumosServicios(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosServiciosBeanSwingJInternalFrame consumosserviciosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaConsumosServiciosConsumosServicios= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}