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


import com.bydan.erp.inventario.util.report.DiferenciasFisicasProductosConstantesFunciones;
import com.bydan.erp.inventario.util.report.DiferenciasFisicasProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.DiferenciasFisicasProductosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DiferenciasFisicasProductosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="DiferenciasFisicasProductos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DiferenciasFisicasProductos"+DiferenciasFisicasProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DiferenciasFisicasProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DiferenciasFisicasProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"_"+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DiferenciasFisicasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"_"+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"_"+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DiferenciasFisicasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"_"+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiferenciasFisicasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiferenciasFisicasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiferenciasFisicasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DiferenciasFisicasProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DiferenciasFisicasProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DiferenciasFisicasProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DiferenciasFisicasProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Diferencias Fisicas Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Diferencias Fisicas Productos";
	public static final String SCLASSWEBTITULO_LOWER="Diferencias Fisicas Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DiferenciasFisicasProductos";
	public static final String OBJECTNAME="diferenciasfisicasproductos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="diferencias_fisicas_productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select diferenciasfisicasproductos from "+DiferenciasFisicasProductosConstantesFunciones.SPERSISTENCENAME+" diferenciasfisicasproductos";
	public static String QUERYSELECTNATIVE="select "+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".version_row,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_bodega,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_producto,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_empresa,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_sucursal,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_linea,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_linea_grupo,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_linea_categoria,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".id_linea_marca,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".fecha_ultima_venta_hasta,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".codigo,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".nombre_unidad,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".cantidad_disponible,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".cantidad_fisica,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".codigo_producto,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".nombre,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".ingresos,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".egresos,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".disponible_corte,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".diferencia,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".costo,"+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME+".total from "+DiferenciasFisicasProductosConstantesFunciones.SCHEMA+"."+DiferenciasFisicasProductosConstantesFunciones.TABLENAME;//+" as "+DiferenciasFisicasProductosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAULTIMAVENTAHASTA= "fecha_ultima_venta_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDADDISPONIBLE= "cantidad_disponible";
    public static final String CANTIDADFISICA= "cantidad_fisica";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String NOMBRE= "nombre";
    public static final String INGRESOS= "ingresos";
    public static final String EGRESOS= "egresos";
    public static final String DISPONIBLECORTE= "disponible_corte";
    public static final String DIFERENCIA= "diferencia";
    public static final String COSTO= "costo";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAULTIMAVENTAHASTA= "Fecha Ultima Venta Hasta";
		public static final String LABEL_FECHAULTIMAVENTAHASTA_LOWER= "Fecha Ultima Venta Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unidad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDADDISPONIBLE= "Cantidad Disponible";
		public static final String LABEL_CANTIDADDISPONIBLE_LOWER= "Cantidad Disponible";
    	public static final String LABEL_CANTIDADFISICA= "Cantidad Fisica";
		public static final String LABEL_CANTIDADFISICA_LOWER= "Cantidad Fisica";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_INGRESOS= "Ingresos";
		public static final String LABEL_INGRESOS_LOWER= "Ingresos";
    	public static final String LABEL_EGRESOS= "Egresos";
		public static final String LABEL_EGRESOS_LOWER= "Egresos";
    	public static final String LABEL_DISPONIBLECORTE= "Disponible Corte";
		public static final String LABEL_DISPONIBLECORTE_LOWER= "Disponible Corte";
    	public static final String LABEL_DIFERENCIA= "Diferencia";
		public static final String LABEL_DIFERENCIA_LOWER= "Diferencia";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getDiferenciasFisicasProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDBODEGA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDEMPRESA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGO)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADFISICA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBRE)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.INGRESOS)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_INGRESOS;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.EGRESOS)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_EGRESOS;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_DISPONIBLECORTE;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_DIFERENCIA;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.COSTO)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DiferenciasFisicasProductosConstantesFunciones.TOTAL)) {sLabelColumna=DiferenciasFisicasProductosConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDiferenciasFisicasProductosDescripcion(DiferenciasFisicasProductos diferenciasfisicasproductos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(diferenciasfisicasproductos !=null/* && diferenciasfisicasproductos.getId()!=0*/) {
			sDescripcion=diferenciasfisicasproductos.getcodigo();//diferenciasfisicasproductosdiferenciasfisicasproductos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDiferenciasFisicasProductosDescripcionDetallado(DiferenciasFisicasProductos diferenciasfisicasproductos) {
		String sDescripcion="";
			
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.ID+"=";
		sDescripcion+=diferenciasfisicasproductos.getId().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=diferenciasfisicasproductos.getVersionRow().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_bodega().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_producto().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_empresa().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_sucursal().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_linea().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_linea_grupo().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_linea_categoria().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=diferenciasfisicasproductos.getid_linea_marca().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.FECHAULTIMAVENTAHASTA+"=";
		sDescripcion+=diferenciasfisicasproductos.getfecha_ultima_venta_hasta().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.CODIGO+"=";
		sDescripcion+=diferenciasfisicasproductos.getcodigo()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=diferenciasfisicasproductos.getnombre_unidad()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=diferenciasfisicasproductos.getcantidad_disponible().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA+"=";
		sDescripcion+=diferenciasfisicasproductos.getcantidad_fisica().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=diferenciasfisicasproductos.getcodigo_producto()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=diferenciasfisicasproductos.getnombre()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.INGRESOS+"=";
		sDescripcion+=diferenciasfisicasproductos.getingresos().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.EGRESOS+"=";
		sDescripcion+=diferenciasfisicasproductos.getegresos().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE+"=";
		sDescripcion+=diferenciasfisicasproductos.getdisponible_corte().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA+"=";
		sDescripcion+=diferenciasfisicasproductos.getdiferencia().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.COSTO+"=";
		sDescripcion+=diferenciasfisicasproductos.getcosto().toString()+",";
		sDescripcion+=DiferenciasFisicasProductosConstantesFunciones.TOTAL+"=";
		sDescripcion+=diferenciasfisicasproductos.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDiferenciasFisicasProductosDescripcion(DiferenciasFisicasProductos diferenciasfisicasproductos,String sValor) throws Exception {			
		if(diferenciasfisicasproductos !=null) {
			diferenciasfisicasproductos.setcodigo(sValor);;//diferenciasfisicasproductosdiferenciasfisicasproductos.getcodigo().trim();
		}		
	}
	
		

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
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
		} else if(sNombreIndice.equals("BusquedaDiferenciasFisicasProductos")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Ultima Venta Hasta";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaDiferenciasFisicasProductos(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_ultima_venta_hasta!=null) {sDetalleIndice+=" Fecha Ultima Venta Hasta="+fecha_ultima_venta_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDiferenciasFisicasProductos(DiferenciasFisicasProductos diferenciasfisicasproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		diferenciasfisicasproductos.setcodigo(diferenciasfisicasproductos.getcodigo().trim());
		diferenciasfisicasproductos.setnombre_unidad(diferenciasfisicasproductos.getnombre_unidad().trim());
		diferenciasfisicasproductos.setcodigo_producto(diferenciasfisicasproductos.getcodigo_producto().trim());
		diferenciasfisicasproductos.setnombre(diferenciasfisicasproductos.getnombre().trim());
	}
	
	public static void quitarEspaciosDiferenciasFisicasProductoss(List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DiferenciasFisicasProductos diferenciasfisicasproductos: diferenciasfisicasproductoss) {
			diferenciasfisicasproductos.setcodigo(diferenciasfisicasproductos.getcodigo().trim());
			diferenciasfisicasproductos.setnombre_unidad(diferenciasfisicasproductos.getnombre_unidad().trim());
			diferenciasfisicasproductos.setcodigo_producto(diferenciasfisicasproductos.getcodigo_producto().trim());
			diferenciasfisicasproductos.setnombre(diferenciasfisicasproductos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiferenciasFisicasProductos(DiferenciasFisicasProductos diferenciasfisicasproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && diferenciasfisicasproductos.getConCambioAuxiliar()) {
			diferenciasfisicasproductos.setIsDeleted(diferenciasfisicasproductos.getIsDeletedAuxiliar());	
			diferenciasfisicasproductos.setIsNew(diferenciasfisicasproductos.getIsNewAuxiliar());	
			diferenciasfisicasproductos.setIsChanged(diferenciasfisicasproductos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			diferenciasfisicasproductos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			diferenciasfisicasproductos.setIsDeletedAuxiliar(false);	
			diferenciasfisicasproductos.setIsNewAuxiliar(false);	
			diferenciasfisicasproductos.setIsChangedAuxiliar(false);
			
			diferenciasfisicasproductos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiferenciasFisicasProductoss(List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DiferenciasFisicasProductos diferenciasfisicasproductos : diferenciasfisicasproductoss) {
			if(conAsignarBase && diferenciasfisicasproductos.getConCambioAuxiliar()) {
				diferenciasfisicasproductos.setIsDeleted(diferenciasfisicasproductos.getIsDeletedAuxiliar());	
				diferenciasfisicasproductos.setIsNew(diferenciasfisicasproductos.getIsNewAuxiliar());	
				diferenciasfisicasproductos.setIsChanged(diferenciasfisicasproductos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				diferenciasfisicasproductos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				diferenciasfisicasproductos.setIsDeletedAuxiliar(false);	
				diferenciasfisicasproductos.setIsNewAuxiliar(false);	
				diferenciasfisicasproductos.setIsChangedAuxiliar(false);
				
				diferenciasfisicasproductos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDiferenciasFisicasProductos(DiferenciasFisicasProductos diferenciasfisicasproductos,Boolean conEnteros) throws Exception  {
		diferenciasfisicasproductos.setingresos(0.0);
		diferenciasfisicasproductos.setegresos(0.0);
		diferenciasfisicasproductos.setdisponible_corte(0.0);
		diferenciasfisicasproductos.setdiferencia(0.0);
		diferenciasfisicasproductos.setcosto(0.0);
		diferenciasfisicasproductos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			diferenciasfisicasproductos.setcantidad_disponible(0);
			diferenciasfisicasproductos.setcantidad_fisica(0);
		}
	}		
	
	public static void InicializarValoresDiferenciasFisicasProductoss(List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,Boolean conEnteros) throws Exception  {
		
		for(DiferenciasFisicasProductos diferenciasfisicasproductos: diferenciasfisicasproductoss) {
			diferenciasfisicasproductos.setingresos(0.0);
			diferenciasfisicasproductos.setegresos(0.0);
			diferenciasfisicasproductos.setdisponible_corte(0.0);
			diferenciasfisicasproductos.setdiferencia(0.0);
			diferenciasfisicasproductos.setcosto(0.0);
			diferenciasfisicasproductos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				diferenciasfisicasproductos.setcantidad_disponible(0);
				diferenciasfisicasproductos.setcantidad_fisica(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDiferenciasFisicasProductos(List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,DiferenciasFisicasProductos diferenciasfisicasproductosAux) throws Exception  {
		DiferenciasFisicasProductosConstantesFunciones.InicializarValoresDiferenciasFisicasProductos(diferenciasfisicasproductosAux,true);
		
		for(DiferenciasFisicasProductos diferenciasfisicasproductos: diferenciasfisicasproductoss) {
			if(diferenciasfisicasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			diferenciasfisicasproductosAux.setcantidad_disponible(diferenciasfisicasproductosAux.getcantidad_disponible()+diferenciasfisicasproductos.getcantidad_disponible());			
			diferenciasfisicasproductosAux.setcantidad_fisica(diferenciasfisicasproductosAux.getcantidad_fisica()+diferenciasfisicasproductos.getcantidad_fisica());			
			diferenciasfisicasproductosAux.setingresos(diferenciasfisicasproductosAux.getingresos()+diferenciasfisicasproductos.getingresos());			
			diferenciasfisicasproductosAux.setegresos(diferenciasfisicasproductosAux.getegresos()+diferenciasfisicasproductos.getegresos());			
			diferenciasfisicasproductosAux.setdisponible_corte(diferenciasfisicasproductosAux.getdisponible_corte()+diferenciasfisicasproductos.getdisponible_corte());			
			diferenciasfisicasproductosAux.setdiferencia(diferenciasfisicasproductosAux.getdiferencia()+diferenciasfisicasproductos.getdiferencia());			
			diferenciasfisicasproductosAux.setcosto(diferenciasfisicasproductosAux.getcosto()+diferenciasfisicasproductos.getcosto());			
			diferenciasfisicasproductosAux.settotal(diferenciasfisicasproductosAux.gettotal()+diferenciasfisicasproductos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDiferenciasFisicasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DiferenciasFisicasProductosConstantesFunciones.getArrayColumnasGlobalesDiferenciasFisicasProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDiferenciasFisicasProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiferenciasFisicasProductosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiferenciasFisicasProductosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiferenciasFisicasProductosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiferenciasFisicasProductosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDiferenciasFisicasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,DiferenciasFisicasProductos diferenciasfisicasproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DiferenciasFisicasProductos diferenciasfisicasproductosAux: diferenciasfisicasproductoss) {
			if(diferenciasfisicasproductosAux!=null && diferenciasfisicasproductos!=null) {
				if((diferenciasfisicasproductosAux.getId()==null && diferenciasfisicasproductos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(diferenciasfisicasproductosAux.getId()!=null && diferenciasfisicasproductos.getId()!=null){
					if(diferenciasfisicasproductosAux.getId().equals(diferenciasfisicasproductos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDiferenciasFisicasProductos(List<DiferenciasFisicasProductos> diferenciasfisicasproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ingresosTotal=0.0;
		Double egresosTotal=0.0;
		Double disponible_corteTotal=0.0;
		Double diferenciaTotal=0.0;
		Double costoTotal=0.0;
		Double totalTotal=0.0;
	
		for(DiferenciasFisicasProductos diferenciasfisicasproductos: diferenciasfisicasproductoss) {			
			if(diferenciasfisicasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ingresosTotal+=diferenciasfisicasproductos.getingresos();
			egresosTotal+=diferenciasfisicasproductos.getegresos();
			disponible_corteTotal+=diferenciasfisicasproductos.getdisponible_corte();
			diferenciaTotal+=diferenciasfisicasproductos.getdiferencia();
			costoTotal+=diferenciasfisicasproductos.getcosto();
			totalTotal+=diferenciasfisicasproductos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.INGRESOS);
		datoGeneral.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_INGRESOS);
		datoGeneral.setdValorDouble(ingresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.EGRESOS);
		datoGeneral.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_EGRESOS);
		datoGeneral.setdValorDouble(egresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE);
		datoGeneral.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_DISPONIBLECORTE);
		datoGeneral.setdValorDouble(disponible_corteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA);
		datoGeneral.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_DIFERENCIA);
		datoGeneral.setdValorDouble(diferenciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDiferenciasFisicasProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_ID, DiferenciasFisicasProductosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_VERSIONROW, DiferenciasFisicasProductosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGO, DiferenciasFisicasProductosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBREUNIDAD, DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE, DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADFISICA, DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGOPRODUCTO, DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBRE, DiferenciasFisicasProductosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_INGRESOS, DiferenciasFisicasProductosConstantesFunciones.INGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_EGRESOS, DiferenciasFisicasProductosConstantesFunciones.EGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_DISPONIBLECORTE, DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_DIFERENCIA, DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_COSTO, DiferenciasFisicasProductosConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiferenciasFisicasProductosConstantesFunciones.LABEL_TOTAL, DiferenciasFisicasProductosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDiferenciasFisicasProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.INGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.EGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiferenciasFisicasProductosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiferenciasFisicasProductos() throws Exception  {
		return DiferenciasFisicasProductosConstantesFunciones.getTiposSeleccionarDiferenciasFisicasProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiferenciasFisicasProductos(Boolean conFk) throws Exception  {
		return DiferenciasFisicasProductosConstantesFunciones.getTiposSeleccionarDiferenciasFisicasProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiferenciasFisicasProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADFISICA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADFISICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_INGRESOS);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_INGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_EGRESOS);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_EGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_DISPONIBLECORTE);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_DISPONIBLECORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_DIFERENCIA);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_DIFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiferenciasFisicasProductosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DiferenciasFisicasProductosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDiferenciasFisicasProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDiferenciasFisicasProductos(DiferenciasFisicasProductos diferenciasfisicasproductosAux) throws Exception {
		
			diferenciasfisicasproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(diferenciasfisicasproductosAux.getBodega()));
			diferenciasfisicasproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(diferenciasfisicasproductosAux.getProducto()));
			diferenciasfisicasproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diferenciasfisicasproductosAux.getEmpresa()));
			diferenciasfisicasproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(diferenciasfisicasproductosAux.getSucursal()));
			diferenciasfisicasproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLinea()));
			diferenciasfisicasproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLineaGrupo()));
			diferenciasfisicasproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLineaCategoria()));
			diferenciasfisicasproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDiferenciasFisicasProductos(List<DiferenciasFisicasProductos> diferenciasfisicasproductossTemp) throws Exception {
		for(DiferenciasFisicasProductos diferenciasfisicasproductosAux:diferenciasfisicasproductossTemp) {
			
			diferenciasfisicasproductosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(diferenciasfisicasproductosAux.getBodega()));
			diferenciasfisicasproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(diferenciasfisicasproductosAux.getProducto()));
			diferenciasfisicasproductosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diferenciasfisicasproductosAux.getEmpresa()));
			diferenciasfisicasproductosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(diferenciasfisicasproductosAux.getSucursal()));
			diferenciasfisicasproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLinea()));
			diferenciasfisicasproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLineaGrupo()));
			diferenciasfisicasproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLineaCategoria()));
			diferenciasfisicasproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(diferenciasfisicasproductosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDiferenciasFisicasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDiferenciasFisicasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiferenciasFisicasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiferenciasFisicasProductosConstantesFunciones.getClassesRelationshipsOfDiferenciasFisicasProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiferenciasFisicasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiferenciasFisicasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiferenciasFisicasProductosConstantesFunciones.getClassesRelationshipsFromStringsOfDiferenciasFisicasProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiferenciasFisicasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DiferenciasFisicasProductos diferenciasfisicasproductos,List<DiferenciasFisicasProductos> diferenciasfisicasproductoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DiferenciasFisicasProductos diferenciasfisicasproductos,List<DiferenciasFisicasProductos> diferenciasfisicasproductoss) throws Exception {
		try	{			
			for(DiferenciasFisicasProductos diferenciasfisicasproductosLocal:diferenciasfisicasproductoss) {
				if(diferenciasfisicasproductosLocal.getId().equals(diferenciasfisicasproductos.getId())) {
					diferenciasfisicasproductosLocal.setIsSelected(diferenciasfisicasproductos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDiferenciasFisicasProductos(List<DiferenciasFisicasProductos> diferenciasfisicasproductossAux) throws Exception {
		//this.diferenciasfisicasproductossAux=diferenciasfisicasproductossAux;
		
		for(DiferenciasFisicasProductos diferenciasfisicasproductosAux:diferenciasfisicasproductossAux) {
			if(diferenciasfisicasproductosAux.getIsChanged()) {
				diferenciasfisicasproductosAux.setIsChanged(false);
			}		
			
			if(diferenciasfisicasproductosAux.getIsNew()) {
				diferenciasfisicasproductosAux.setIsNew(false);
			}	
			
			if(diferenciasfisicasproductosAux.getIsDeleted()) {
				diferenciasfisicasproductosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDiferenciasFisicasProductos(DiferenciasFisicasProductos diferenciasfisicasproductosAux) throws Exception {
		//this.diferenciasfisicasproductosAux=diferenciasfisicasproductosAux;
		
			if(diferenciasfisicasproductosAux.getIsChanged()) {
				diferenciasfisicasproductosAux.setIsChanged(false);
			}		
			
			if(diferenciasfisicasproductosAux.getIsNew()) {
				diferenciasfisicasproductosAux.setIsNew(false);
			}	
			
			if(diferenciasfisicasproductosAux.getIsDeleted()) {
				diferenciasfisicasproductosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DiferenciasFisicasProductos diferenciasfisicasproductosAsignar,DiferenciasFisicasProductos diferenciasfisicasproductos) throws Exception {
		diferenciasfisicasproductosAsignar.setId(diferenciasfisicasproductos.getId());	
		diferenciasfisicasproductosAsignar.setVersionRow(diferenciasfisicasproductos.getVersionRow());	
		diferenciasfisicasproductosAsignar.setcodigo(diferenciasfisicasproductos.getcodigo());	
		diferenciasfisicasproductosAsignar.setnombre_unidad(diferenciasfisicasproductos.getnombre_unidad());	
		diferenciasfisicasproductosAsignar.setcantidad_disponible(diferenciasfisicasproductos.getcantidad_disponible());	
		diferenciasfisicasproductosAsignar.setcantidad_fisica(diferenciasfisicasproductos.getcantidad_fisica());	
		diferenciasfisicasproductosAsignar.setcodigo_producto(diferenciasfisicasproductos.getcodigo_producto());	
		diferenciasfisicasproductosAsignar.setnombre(diferenciasfisicasproductos.getnombre());	
		diferenciasfisicasproductosAsignar.setingresos(diferenciasfisicasproductos.getingresos());	
		diferenciasfisicasproductosAsignar.setegresos(diferenciasfisicasproductos.getegresos());	
		diferenciasfisicasproductosAsignar.setdisponible_corte(diferenciasfisicasproductos.getdisponible_corte());	
		diferenciasfisicasproductosAsignar.setdiferencia(diferenciasfisicasproductos.getdiferencia());	
		diferenciasfisicasproductosAsignar.setcosto(diferenciasfisicasproductos.getcosto());	
		diferenciasfisicasproductosAsignar.settotal(diferenciasfisicasproductos.gettotal());	
	}
	
	public static void inicializarDiferenciasFisicasProductos(DiferenciasFisicasProductos diferenciasfisicasproductos) throws Exception {
		try {
				diferenciasfisicasproductos.setId(0L);	
					
				diferenciasfisicasproductos.setcodigo("");	
				diferenciasfisicasproductos.setnombre_unidad("");	
				diferenciasfisicasproductos.setcantidad_disponible(0);	
				diferenciasfisicasproductos.setcantidad_fisica(0);	
				diferenciasfisicasproductos.setcodigo_producto("");	
				diferenciasfisicasproductos.setnombre("");	
				diferenciasfisicasproductos.setingresos(0.0);	
				diferenciasfisicasproductos.setegresos(0.0);	
				diferenciasfisicasproductos.setdisponible_corte(0.0);	
				diferenciasfisicasproductos.setdiferencia(0.0);	
				diferenciasfisicasproductos.setcosto(0.0);	
				diferenciasfisicasproductos.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDiferenciasFisicasProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_CANTIDADFISICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_INGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_EGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_DISPONIBLECORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_DIFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiferenciasFisicasProductosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDiferenciasFisicasProductos(String sTipo,Row row,Workbook workbook,DiferenciasFisicasProductos diferenciasfisicasproductos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getfecha_ultima_venta_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getcantidad_fisica());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getingresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getegresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getdisponible_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getdiferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diferenciasfisicasproductos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDiferenciasFisicasProductos="";
	
	public String getsFinalQueryDiferenciasFisicasProductos() {
		return this.sFinalQueryDiferenciasFisicasProductos;
	}
	
	public void setsFinalQueryDiferenciasFisicasProductos(String sFinalQueryDiferenciasFisicasProductos) {
		this.sFinalQueryDiferenciasFisicasProductos= sFinalQueryDiferenciasFisicasProductos;
	}
	
	public Border resaltarSeleccionarDiferenciasFisicasProductos=null;
	
	public Border setResaltarSeleccionarDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDiferenciasFisicasProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDiferenciasFisicasProductos() {
		return this.resaltarSeleccionarDiferenciasFisicasProductos;
	}
	
	public void setResaltarSeleccionarDiferenciasFisicasProductos(Border borderResaltarSeleccionarDiferenciasFisicasProductos) {
		this.resaltarSeleccionarDiferenciasFisicasProductos= borderResaltarSeleccionarDiferenciasFisicasProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDiferenciasFisicasProductos=null;
	public Boolean mostraridDiferenciasFisicasProductos=true;
	public Boolean activaridDiferenciasFisicasProductos=true;

	public Border resaltarid_bodegaDiferenciasFisicasProductos=null;
	public Boolean mostrarid_bodegaDiferenciasFisicasProductos=true;
	public Boolean activarid_bodegaDiferenciasFisicasProductos=true;
	public Boolean cargarid_bodegaDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarid_productoDiferenciasFisicasProductos=null;
	public Boolean mostrarid_productoDiferenciasFisicasProductos=true;
	public Boolean activarid_productoDiferenciasFisicasProductos=true;
	public Boolean cargarid_productoDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarid_empresaDiferenciasFisicasProductos=null;
	public Boolean mostrarid_empresaDiferenciasFisicasProductos=true;
	public Boolean activarid_empresaDiferenciasFisicasProductos=true;
	public Boolean cargarid_empresaDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarid_sucursalDiferenciasFisicasProductos=null;
	public Boolean mostrarid_sucursalDiferenciasFisicasProductos=true;
	public Boolean activarid_sucursalDiferenciasFisicasProductos=true;
	public Boolean cargarid_sucursalDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarid_lineaDiferenciasFisicasProductos=null;
	public Boolean mostrarid_lineaDiferenciasFisicasProductos=true;
	public Boolean activarid_lineaDiferenciasFisicasProductos=true;
	public Boolean cargarid_lineaDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoDiferenciasFisicasProductos=null;
	public Boolean mostrarid_linea_grupoDiferenciasFisicasProductos=true;
	public Boolean activarid_linea_grupoDiferenciasFisicasProductos=true;
	public Boolean cargarid_linea_grupoDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaDiferenciasFisicasProductos=null;
	public Boolean mostrarid_linea_categoriaDiferenciasFisicasProductos=true;
	public Boolean activarid_linea_categoriaDiferenciasFisicasProductos=true;
	public Boolean cargarid_linea_categoriaDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaDiferenciasFisicasProductos=null;
	public Boolean mostrarid_linea_marcaDiferenciasFisicasProductos=true;
	public Boolean activarid_linea_marcaDiferenciasFisicasProductos=true;
	public Boolean cargarid_linea_marcaDiferenciasFisicasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaDiferenciasFisicasProductos=false;//ConEventDepend=true

	public Border resaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos=null;
	public Boolean mostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos=true;
	public Boolean activarfecha_ultima_venta_hastaDiferenciasFisicasProductos=true;

	public Border resaltarcodigoDiferenciasFisicasProductos=null;
	public Boolean mostrarcodigoDiferenciasFisicasProductos=true;
	public Boolean activarcodigoDiferenciasFisicasProductos=true;

	public Border resaltarnombre_unidadDiferenciasFisicasProductos=null;
	public Boolean mostrarnombre_unidadDiferenciasFisicasProductos=true;
	public Boolean activarnombre_unidadDiferenciasFisicasProductos=true;

	public Border resaltarcantidad_disponibleDiferenciasFisicasProductos=null;
	public Boolean mostrarcantidad_disponibleDiferenciasFisicasProductos=true;
	public Boolean activarcantidad_disponibleDiferenciasFisicasProductos=true;

	public Border resaltarcantidad_fisicaDiferenciasFisicasProductos=null;
	public Boolean mostrarcantidad_fisicaDiferenciasFisicasProductos=true;
	public Boolean activarcantidad_fisicaDiferenciasFisicasProductos=true;

	public Border resaltarcodigo_productoDiferenciasFisicasProductos=null;
	public Boolean mostrarcodigo_productoDiferenciasFisicasProductos=true;
	public Boolean activarcodigo_productoDiferenciasFisicasProductos=true;

	public Border resaltarnombreDiferenciasFisicasProductos=null;
	public Boolean mostrarnombreDiferenciasFisicasProductos=true;
	public Boolean activarnombreDiferenciasFisicasProductos=true;

	public Border resaltaringresosDiferenciasFisicasProductos=null;
	public Boolean mostraringresosDiferenciasFisicasProductos=true;
	public Boolean activaringresosDiferenciasFisicasProductos=true;

	public Border resaltaregresosDiferenciasFisicasProductos=null;
	public Boolean mostraregresosDiferenciasFisicasProductos=true;
	public Boolean activaregresosDiferenciasFisicasProductos=true;

	public Border resaltardisponible_corteDiferenciasFisicasProductos=null;
	public Boolean mostrardisponible_corteDiferenciasFisicasProductos=true;
	public Boolean activardisponible_corteDiferenciasFisicasProductos=true;

	public Border resaltardiferenciaDiferenciasFisicasProductos=null;
	public Boolean mostrardiferenciaDiferenciasFisicasProductos=true;
	public Boolean activardiferenciaDiferenciasFisicasProductos=true;

	public Border resaltarcostoDiferenciasFisicasProductos=null;
	public Boolean mostrarcostoDiferenciasFisicasProductos=true;
	public Boolean activarcostoDiferenciasFisicasProductos=true;

	public Border resaltartotalDiferenciasFisicasProductos=null;
	public Boolean mostrartotalDiferenciasFisicasProductos=true;
	public Boolean activartotalDiferenciasFisicasProductos=true;

	
	

	public Border setResaltaridDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltaridDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDiferenciasFisicasProductos() {
		return this.resaltaridDiferenciasFisicasProductos;
	}

	public void setResaltaridDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltaridDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostraridDiferenciasFisicasProductos() {
		return this.mostraridDiferenciasFisicasProductos;
	}

	public void setMostraridDiferenciasFisicasProductos(Boolean mostraridDiferenciasFisicasProductos) {
		this.mostraridDiferenciasFisicasProductos= mostraridDiferenciasFisicasProductos;
	}

	public Boolean getActivaridDiferenciasFisicasProductos() {
		return this.activaridDiferenciasFisicasProductos;
	}

	public void setActivaridDiferenciasFisicasProductos(Boolean activaridDiferenciasFisicasProductos) {
		this.activaridDiferenciasFisicasProductos= activaridDiferenciasFisicasProductos;
	}

	public Border setResaltarid_bodegaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDiferenciasFisicasProductos() {
		return this.resaltarid_bodegaDiferenciasFisicasProductos;
	}

	public void setResaltarid_bodegaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_bodegaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDiferenciasFisicasProductos() {
		return this.mostrarid_bodegaDiferenciasFisicasProductos;
	}

	public void setMostrarid_bodegaDiferenciasFisicasProductos(Boolean mostrarid_bodegaDiferenciasFisicasProductos) {
		this.mostrarid_bodegaDiferenciasFisicasProductos= mostrarid_bodegaDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_bodegaDiferenciasFisicasProductos() {
		return this.activarid_bodegaDiferenciasFisicasProductos;
	}

	public void setActivarid_bodegaDiferenciasFisicasProductos(Boolean activarid_bodegaDiferenciasFisicasProductos) {
		this.activarid_bodegaDiferenciasFisicasProductos= activarid_bodegaDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_bodegaDiferenciasFisicasProductos() {
		return this.cargarid_bodegaDiferenciasFisicasProductos;
	}

	public void setCargarid_bodegaDiferenciasFisicasProductos(Boolean cargarid_bodegaDiferenciasFisicasProductos) {
		this.cargarid_bodegaDiferenciasFisicasProductos= cargarid_bodegaDiferenciasFisicasProductos;
	}

	public Border setResaltarid_productoDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_productoDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDiferenciasFisicasProductos() {
		return this.resaltarid_productoDiferenciasFisicasProductos;
	}

	public void setResaltarid_productoDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_productoDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_productoDiferenciasFisicasProductos() {
		return this.mostrarid_productoDiferenciasFisicasProductos;
	}

	public void setMostrarid_productoDiferenciasFisicasProductos(Boolean mostrarid_productoDiferenciasFisicasProductos) {
		this.mostrarid_productoDiferenciasFisicasProductos= mostrarid_productoDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_productoDiferenciasFisicasProductos() {
		return this.activarid_productoDiferenciasFisicasProductos;
	}

	public void setActivarid_productoDiferenciasFisicasProductos(Boolean activarid_productoDiferenciasFisicasProductos) {
		this.activarid_productoDiferenciasFisicasProductos= activarid_productoDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_productoDiferenciasFisicasProductos() {
		return this.cargarid_productoDiferenciasFisicasProductos;
	}

	public void setCargarid_productoDiferenciasFisicasProductos(Boolean cargarid_productoDiferenciasFisicasProductos) {
		this.cargarid_productoDiferenciasFisicasProductos= cargarid_productoDiferenciasFisicasProductos;
	}

	public Border setResaltarid_empresaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_empresaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDiferenciasFisicasProductos() {
		return this.resaltarid_empresaDiferenciasFisicasProductos;
	}

	public void setResaltarid_empresaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_empresaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_empresaDiferenciasFisicasProductos() {
		return this.mostrarid_empresaDiferenciasFisicasProductos;
	}

	public void setMostrarid_empresaDiferenciasFisicasProductos(Boolean mostrarid_empresaDiferenciasFisicasProductos) {
		this.mostrarid_empresaDiferenciasFisicasProductos= mostrarid_empresaDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_empresaDiferenciasFisicasProductos() {
		return this.activarid_empresaDiferenciasFisicasProductos;
	}

	public void setActivarid_empresaDiferenciasFisicasProductos(Boolean activarid_empresaDiferenciasFisicasProductos) {
		this.activarid_empresaDiferenciasFisicasProductos= activarid_empresaDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_empresaDiferenciasFisicasProductos() {
		return this.cargarid_empresaDiferenciasFisicasProductos;
	}

	public void setCargarid_empresaDiferenciasFisicasProductos(Boolean cargarid_empresaDiferenciasFisicasProductos) {
		this.cargarid_empresaDiferenciasFisicasProductos= cargarid_empresaDiferenciasFisicasProductos;
	}

	public Border setResaltarid_sucursalDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDiferenciasFisicasProductos() {
		return this.resaltarid_sucursalDiferenciasFisicasProductos;
	}

	public void setResaltarid_sucursalDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_sucursalDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDiferenciasFisicasProductos() {
		return this.mostrarid_sucursalDiferenciasFisicasProductos;
	}

	public void setMostrarid_sucursalDiferenciasFisicasProductos(Boolean mostrarid_sucursalDiferenciasFisicasProductos) {
		this.mostrarid_sucursalDiferenciasFisicasProductos= mostrarid_sucursalDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_sucursalDiferenciasFisicasProductos() {
		return this.activarid_sucursalDiferenciasFisicasProductos;
	}

	public void setActivarid_sucursalDiferenciasFisicasProductos(Boolean activarid_sucursalDiferenciasFisicasProductos) {
		this.activarid_sucursalDiferenciasFisicasProductos= activarid_sucursalDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_sucursalDiferenciasFisicasProductos() {
		return this.cargarid_sucursalDiferenciasFisicasProductos;
	}

	public void setCargarid_sucursalDiferenciasFisicasProductos(Boolean cargarid_sucursalDiferenciasFisicasProductos) {
		this.cargarid_sucursalDiferenciasFisicasProductos= cargarid_sucursalDiferenciasFisicasProductos;
	}

	public Border setResaltarid_lineaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_lineaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaDiferenciasFisicasProductos() {
		return this.resaltarid_lineaDiferenciasFisicasProductos;
	}

	public void setResaltarid_lineaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_lineaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_lineaDiferenciasFisicasProductos() {
		return this.mostrarid_lineaDiferenciasFisicasProductos;
	}

	public void setMostrarid_lineaDiferenciasFisicasProductos(Boolean mostrarid_lineaDiferenciasFisicasProductos) {
		this.mostrarid_lineaDiferenciasFisicasProductos= mostrarid_lineaDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_lineaDiferenciasFisicasProductos() {
		return this.activarid_lineaDiferenciasFisicasProductos;
	}

	public void setActivarid_lineaDiferenciasFisicasProductos(Boolean activarid_lineaDiferenciasFisicasProductos) {
		this.activarid_lineaDiferenciasFisicasProductos= activarid_lineaDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_lineaDiferenciasFisicasProductos() {
		return this.cargarid_lineaDiferenciasFisicasProductos;
	}

	public void setCargarid_lineaDiferenciasFisicasProductos(Boolean cargarid_lineaDiferenciasFisicasProductos) {
		this.cargarid_lineaDiferenciasFisicasProductos= cargarid_lineaDiferenciasFisicasProductos;
	}

	public Border setResaltarid_linea_grupoDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoDiferenciasFisicasProductos() {
		return this.resaltarid_linea_grupoDiferenciasFisicasProductos;
	}

	public void setResaltarid_linea_grupoDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_linea_grupoDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoDiferenciasFisicasProductos() {
		return this.mostrarid_linea_grupoDiferenciasFisicasProductos;
	}

	public void setMostrarid_linea_grupoDiferenciasFisicasProductos(Boolean mostrarid_linea_grupoDiferenciasFisicasProductos) {
		this.mostrarid_linea_grupoDiferenciasFisicasProductos= mostrarid_linea_grupoDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_linea_grupoDiferenciasFisicasProductos() {
		return this.activarid_linea_grupoDiferenciasFisicasProductos;
	}

	public void setActivarid_linea_grupoDiferenciasFisicasProductos(Boolean activarid_linea_grupoDiferenciasFisicasProductos) {
		this.activarid_linea_grupoDiferenciasFisicasProductos= activarid_linea_grupoDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_linea_grupoDiferenciasFisicasProductos() {
		return this.cargarid_linea_grupoDiferenciasFisicasProductos;
	}

	public void setCargarid_linea_grupoDiferenciasFisicasProductos(Boolean cargarid_linea_grupoDiferenciasFisicasProductos) {
		this.cargarid_linea_grupoDiferenciasFisicasProductos= cargarid_linea_grupoDiferenciasFisicasProductos;
	}

	public Border setResaltarid_linea_categoriaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaDiferenciasFisicasProductos() {
		return this.resaltarid_linea_categoriaDiferenciasFisicasProductos;
	}

	public void setResaltarid_linea_categoriaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_linea_categoriaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaDiferenciasFisicasProductos() {
		return this.mostrarid_linea_categoriaDiferenciasFisicasProductos;
	}

	public void setMostrarid_linea_categoriaDiferenciasFisicasProductos(Boolean mostrarid_linea_categoriaDiferenciasFisicasProductos) {
		this.mostrarid_linea_categoriaDiferenciasFisicasProductos= mostrarid_linea_categoriaDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_linea_categoriaDiferenciasFisicasProductos() {
		return this.activarid_linea_categoriaDiferenciasFisicasProductos;
	}

	public void setActivarid_linea_categoriaDiferenciasFisicasProductos(Boolean activarid_linea_categoriaDiferenciasFisicasProductos) {
		this.activarid_linea_categoriaDiferenciasFisicasProductos= activarid_linea_categoriaDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_linea_categoriaDiferenciasFisicasProductos() {
		return this.cargarid_linea_categoriaDiferenciasFisicasProductos;
	}

	public void setCargarid_linea_categoriaDiferenciasFisicasProductos(Boolean cargarid_linea_categoriaDiferenciasFisicasProductos) {
		this.cargarid_linea_categoriaDiferenciasFisicasProductos= cargarid_linea_categoriaDiferenciasFisicasProductos;
	}

	public Border setResaltarid_linea_marcaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaDiferenciasFisicasProductos() {
		return this.resaltarid_linea_marcaDiferenciasFisicasProductos;
	}

	public void setResaltarid_linea_marcaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarid_linea_marcaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaDiferenciasFisicasProductos() {
		return this.mostrarid_linea_marcaDiferenciasFisicasProductos;
	}

	public void setMostrarid_linea_marcaDiferenciasFisicasProductos(Boolean mostrarid_linea_marcaDiferenciasFisicasProductos) {
		this.mostrarid_linea_marcaDiferenciasFisicasProductos= mostrarid_linea_marcaDiferenciasFisicasProductos;
	}

	public Boolean getActivarid_linea_marcaDiferenciasFisicasProductos() {
		return this.activarid_linea_marcaDiferenciasFisicasProductos;
	}

	public void setActivarid_linea_marcaDiferenciasFisicasProductos(Boolean activarid_linea_marcaDiferenciasFisicasProductos) {
		this.activarid_linea_marcaDiferenciasFisicasProductos= activarid_linea_marcaDiferenciasFisicasProductos;
	}

	public Boolean getCargarid_linea_marcaDiferenciasFisicasProductos() {
		return this.cargarid_linea_marcaDiferenciasFisicasProductos;
	}

	public void setCargarid_linea_marcaDiferenciasFisicasProductos(Boolean cargarid_linea_marcaDiferenciasFisicasProductos) {
		this.cargarid_linea_marcaDiferenciasFisicasProductos= cargarid_linea_marcaDiferenciasFisicasProductos;
	}

	public Border setResaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos() {
		return this.resaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos;
	}

	public void setResaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos() {
		return this.mostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos;
	}

	public void setMostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos(Boolean mostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos) {
		this.mostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos= mostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos;
	}

	public Boolean getActivarfecha_ultima_venta_hastaDiferenciasFisicasProductos() {
		return this.activarfecha_ultima_venta_hastaDiferenciasFisicasProductos;
	}

	public void setActivarfecha_ultima_venta_hastaDiferenciasFisicasProductos(Boolean activarfecha_ultima_venta_hastaDiferenciasFisicasProductos) {
		this.activarfecha_ultima_venta_hastaDiferenciasFisicasProductos= activarfecha_ultima_venta_hastaDiferenciasFisicasProductos;
	}

	public Border setResaltarcodigoDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarcodigoDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDiferenciasFisicasProductos() {
		return this.resaltarcodigoDiferenciasFisicasProductos;
	}

	public void setResaltarcodigoDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarcodigoDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarcodigoDiferenciasFisicasProductos() {
		return this.mostrarcodigoDiferenciasFisicasProductos;
	}

	public void setMostrarcodigoDiferenciasFisicasProductos(Boolean mostrarcodigoDiferenciasFisicasProductos) {
		this.mostrarcodigoDiferenciasFisicasProductos= mostrarcodigoDiferenciasFisicasProductos;
	}

	public Boolean getActivarcodigoDiferenciasFisicasProductos() {
		return this.activarcodigoDiferenciasFisicasProductos;
	}

	public void setActivarcodigoDiferenciasFisicasProductos(Boolean activarcodigoDiferenciasFisicasProductos) {
		this.activarcodigoDiferenciasFisicasProductos= activarcodigoDiferenciasFisicasProductos;
	}

	public Border setResaltarnombre_unidadDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadDiferenciasFisicasProductos() {
		return this.resaltarnombre_unidadDiferenciasFisicasProductos;
	}

	public void setResaltarnombre_unidadDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarnombre_unidadDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadDiferenciasFisicasProductos() {
		return this.mostrarnombre_unidadDiferenciasFisicasProductos;
	}

	public void setMostrarnombre_unidadDiferenciasFisicasProductos(Boolean mostrarnombre_unidadDiferenciasFisicasProductos) {
		this.mostrarnombre_unidadDiferenciasFisicasProductos= mostrarnombre_unidadDiferenciasFisicasProductos;
	}

	public Boolean getActivarnombre_unidadDiferenciasFisicasProductos() {
		return this.activarnombre_unidadDiferenciasFisicasProductos;
	}

	public void setActivarnombre_unidadDiferenciasFisicasProductos(Boolean activarnombre_unidadDiferenciasFisicasProductos) {
		this.activarnombre_unidadDiferenciasFisicasProductos= activarnombre_unidadDiferenciasFisicasProductos;
	}

	public Border setResaltarcantidad_disponibleDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleDiferenciasFisicasProductos() {
		return this.resaltarcantidad_disponibleDiferenciasFisicasProductos;
	}

	public void setResaltarcantidad_disponibleDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarcantidad_disponibleDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleDiferenciasFisicasProductos() {
		return this.mostrarcantidad_disponibleDiferenciasFisicasProductos;
	}

	public void setMostrarcantidad_disponibleDiferenciasFisicasProductos(Boolean mostrarcantidad_disponibleDiferenciasFisicasProductos) {
		this.mostrarcantidad_disponibleDiferenciasFisicasProductos= mostrarcantidad_disponibleDiferenciasFisicasProductos;
	}

	public Boolean getActivarcantidad_disponibleDiferenciasFisicasProductos() {
		return this.activarcantidad_disponibleDiferenciasFisicasProductos;
	}

	public void setActivarcantidad_disponibleDiferenciasFisicasProductos(Boolean activarcantidad_disponibleDiferenciasFisicasProductos) {
		this.activarcantidad_disponibleDiferenciasFisicasProductos= activarcantidad_disponibleDiferenciasFisicasProductos;
	}

	public Border setResaltarcantidad_fisicaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarcantidad_fisicaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_fisicaDiferenciasFisicasProductos() {
		return this.resaltarcantidad_fisicaDiferenciasFisicasProductos;
	}

	public void setResaltarcantidad_fisicaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarcantidad_fisicaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarcantidad_fisicaDiferenciasFisicasProductos() {
		return this.mostrarcantidad_fisicaDiferenciasFisicasProductos;
	}

	public void setMostrarcantidad_fisicaDiferenciasFisicasProductos(Boolean mostrarcantidad_fisicaDiferenciasFisicasProductos) {
		this.mostrarcantidad_fisicaDiferenciasFisicasProductos= mostrarcantidad_fisicaDiferenciasFisicasProductos;
	}

	public Boolean getActivarcantidad_fisicaDiferenciasFisicasProductos() {
		return this.activarcantidad_fisicaDiferenciasFisicasProductos;
	}

	public void setActivarcantidad_fisicaDiferenciasFisicasProductos(Boolean activarcantidad_fisicaDiferenciasFisicasProductos) {
		this.activarcantidad_fisicaDiferenciasFisicasProductos= activarcantidad_fisicaDiferenciasFisicasProductos;
	}

	public Border setResaltarcodigo_productoDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoDiferenciasFisicasProductos() {
		return this.resaltarcodigo_productoDiferenciasFisicasProductos;
	}

	public void setResaltarcodigo_productoDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarcodigo_productoDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoDiferenciasFisicasProductos() {
		return this.mostrarcodigo_productoDiferenciasFisicasProductos;
	}

	public void setMostrarcodigo_productoDiferenciasFisicasProductos(Boolean mostrarcodigo_productoDiferenciasFisicasProductos) {
		this.mostrarcodigo_productoDiferenciasFisicasProductos= mostrarcodigo_productoDiferenciasFisicasProductos;
	}

	public Boolean getActivarcodigo_productoDiferenciasFisicasProductos() {
		return this.activarcodigo_productoDiferenciasFisicasProductos;
	}

	public void setActivarcodigo_productoDiferenciasFisicasProductos(Boolean activarcodigo_productoDiferenciasFisicasProductos) {
		this.activarcodigo_productoDiferenciasFisicasProductos= activarcodigo_productoDiferenciasFisicasProductos;
	}

	public Border setResaltarnombreDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarnombreDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDiferenciasFisicasProductos() {
		return this.resaltarnombreDiferenciasFisicasProductos;
	}

	public void setResaltarnombreDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarnombreDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarnombreDiferenciasFisicasProductos() {
		return this.mostrarnombreDiferenciasFisicasProductos;
	}

	public void setMostrarnombreDiferenciasFisicasProductos(Boolean mostrarnombreDiferenciasFisicasProductos) {
		this.mostrarnombreDiferenciasFisicasProductos= mostrarnombreDiferenciasFisicasProductos;
	}

	public Boolean getActivarnombreDiferenciasFisicasProductos() {
		return this.activarnombreDiferenciasFisicasProductos;
	}

	public void setActivarnombreDiferenciasFisicasProductos(Boolean activarnombreDiferenciasFisicasProductos) {
		this.activarnombreDiferenciasFisicasProductos= activarnombreDiferenciasFisicasProductos;
	}

	public Border setResaltaringresosDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltaringresosDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringresosDiferenciasFisicasProductos() {
		return this.resaltaringresosDiferenciasFisicasProductos;
	}

	public void setResaltaringresosDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltaringresosDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostraringresosDiferenciasFisicasProductos() {
		return this.mostraringresosDiferenciasFisicasProductos;
	}

	public void setMostraringresosDiferenciasFisicasProductos(Boolean mostraringresosDiferenciasFisicasProductos) {
		this.mostraringresosDiferenciasFisicasProductos= mostraringresosDiferenciasFisicasProductos;
	}

	public Boolean getActivaringresosDiferenciasFisicasProductos() {
		return this.activaringresosDiferenciasFisicasProductos;
	}

	public void setActivaringresosDiferenciasFisicasProductos(Boolean activaringresosDiferenciasFisicasProductos) {
		this.activaringresosDiferenciasFisicasProductos= activaringresosDiferenciasFisicasProductos;
	}

	public Border setResaltaregresosDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltaregresosDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaregresosDiferenciasFisicasProductos() {
		return this.resaltaregresosDiferenciasFisicasProductos;
	}

	public void setResaltaregresosDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltaregresosDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostraregresosDiferenciasFisicasProductos() {
		return this.mostraregresosDiferenciasFisicasProductos;
	}

	public void setMostraregresosDiferenciasFisicasProductos(Boolean mostraregresosDiferenciasFisicasProductos) {
		this.mostraregresosDiferenciasFisicasProductos= mostraregresosDiferenciasFisicasProductos;
	}

	public Boolean getActivaregresosDiferenciasFisicasProductos() {
		return this.activaregresosDiferenciasFisicasProductos;
	}

	public void setActivaregresosDiferenciasFisicasProductos(Boolean activaregresosDiferenciasFisicasProductos) {
		this.activaregresosDiferenciasFisicasProductos= activaregresosDiferenciasFisicasProductos;
	}

	public Border setResaltardisponible_corteDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltardisponible_corteDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponible_corteDiferenciasFisicasProductos() {
		return this.resaltardisponible_corteDiferenciasFisicasProductos;
	}

	public void setResaltardisponible_corteDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltardisponible_corteDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrardisponible_corteDiferenciasFisicasProductos() {
		return this.mostrardisponible_corteDiferenciasFisicasProductos;
	}

	public void setMostrardisponible_corteDiferenciasFisicasProductos(Boolean mostrardisponible_corteDiferenciasFisicasProductos) {
		this.mostrardisponible_corteDiferenciasFisicasProductos= mostrardisponible_corteDiferenciasFisicasProductos;
	}

	public Boolean getActivardisponible_corteDiferenciasFisicasProductos() {
		return this.activardisponible_corteDiferenciasFisicasProductos;
	}

	public void setActivardisponible_corteDiferenciasFisicasProductos(Boolean activardisponible_corteDiferenciasFisicasProductos) {
		this.activardisponible_corteDiferenciasFisicasProductos= activardisponible_corteDiferenciasFisicasProductos;
	}

	public Border setResaltardiferenciaDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltardiferenciaDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiferenciaDiferenciasFisicasProductos() {
		return this.resaltardiferenciaDiferenciasFisicasProductos;
	}

	public void setResaltardiferenciaDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltardiferenciaDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrardiferenciaDiferenciasFisicasProductos() {
		return this.mostrardiferenciaDiferenciasFisicasProductos;
	}

	public void setMostrardiferenciaDiferenciasFisicasProductos(Boolean mostrardiferenciaDiferenciasFisicasProductos) {
		this.mostrardiferenciaDiferenciasFisicasProductos= mostrardiferenciaDiferenciasFisicasProductos;
	}

	public Boolean getActivardiferenciaDiferenciasFisicasProductos() {
		return this.activardiferenciaDiferenciasFisicasProductos;
	}

	public void setActivardiferenciaDiferenciasFisicasProductos(Boolean activardiferenciaDiferenciasFisicasProductos) {
		this.activardiferenciaDiferenciasFisicasProductos= activardiferenciaDiferenciasFisicasProductos;
	}

	public Border setResaltarcostoDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltarcostoDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDiferenciasFisicasProductos() {
		return this.resaltarcostoDiferenciasFisicasProductos;
	}

	public void setResaltarcostoDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarcostoDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrarcostoDiferenciasFisicasProductos() {
		return this.mostrarcostoDiferenciasFisicasProductos;
	}

	public void setMostrarcostoDiferenciasFisicasProductos(Boolean mostrarcostoDiferenciasFisicasProductos) {
		this.mostrarcostoDiferenciasFisicasProductos= mostrarcostoDiferenciasFisicasProductos;
	}

	public Boolean getActivarcostoDiferenciasFisicasProductos() {
		return this.activarcostoDiferenciasFisicasProductos;
	}

	public void setActivarcostoDiferenciasFisicasProductos(Boolean activarcostoDiferenciasFisicasProductos) {
		this.activarcostoDiferenciasFisicasProductos= activarcostoDiferenciasFisicasProductos;
	}

	public Border setResaltartotalDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diferenciasfisicasproductosBeanSwingJInternalFrame.jTtoolBarDiferenciasFisicasProductos.setBorder(borderResaltar);
		
		this.resaltartotalDiferenciasFisicasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDiferenciasFisicasProductos() {
		return this.resaltartotalDiferenciasFisicasProductos;
	}

	public void setResaltartotalDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltartotalDiferenciasFisicasProductos= borderResaltar;
	}

	public Boolean getMostrartotalDiferenciasFisicasProductos() {
		return this.mostrartotalDiferenciasFisicasProductos;
	}

	public void setMostrartotalDiferenciasFisicasProductos(Boolean mostrartotalDiferenciasFisicasProductos) {
		this.mostrartotalDiferenciasFisicasProductos= mostrartotalDiferenciasFisicasProductos;
	}

	public Boolean getActivartotalDiferenciasFisicasProductos() {
		return this.activartotalDiferenciasFisicasProductos;
	}

	public void setActivartotalDiferenciasFisicasProductos(Boolean activartotalDiferenciasFisicasProductos) {
		this.activartotalDiferenciasFisicasProductos= activartotalDiferenciasFisicasProductos;
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
		
		
		this.setMostraridDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_bodegaDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_productoDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_empresaDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_sucursalDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_lineaDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_linea_grupoDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_linea_categoriaDiferenciasFisicasProductos(esInicial);
		this.setMostrarid_linea_marcaDiferenciasFisicasProductos(esInicial);
		this.setMostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos(esInicial);
		this.setMostrarcodigoDiferenciasFisicasProductos(esInicial);
		this.setMostrarnombre_unidadDiferenciasFisicasProductos(esInicial);
		this.setMostrarcantidad_disponibleDiferenciasFisicasProductos(esInicial);
		this.setMostrarcantidad_fisicaDiferenciasFisicasProductos(esInicial);
		this.setMostrarcodigo_productoDiferenciasFisicasProductos(esInicial);
		this.setMostrarnombreDiferenciasFisicasProductos(esInicial);
		this.setMostraringresosDiferenciasFisicasProductos(esInicial);
		this.setMostraregresosDiferenciasFisicasProductos(esInicial);
		this.setMostrardisponible_corteDiferenciasFisicasProductos(esInicial);
		this.setMostrardiferenciaDiferenciasFisicasProductos(esInicial);
		this.setMostrarcostoDiferenciasFisicasProductos(esInicial);
		this.setMostrartotalDiferenciasFisicasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.ID)) {
				this.setMostraridDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setMostrarfecha_ultima_venta_hastaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA)) {
				this.setMostrarcantidad_fisicaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.INGRESOS)) {
				this.setMostraringresosDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.EGRESOS)) {
				this.setMostraregresosDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE)) {
				this.setMostrardisponible_corteDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA)) {
				this.setMostrardiferenciaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.COSTO)) {
				this.setMostrarcostoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.TOTAL)) {
				this.setMostrartotalDiferenciasFisicasProductos(esAsigna);
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
		
		
		this.setActivaridDiferenciasFisicasProductos(esInicial);
		this.setActivarid_bodegaDiferenciasFisicasProductos(esInicial);
		this.setActivarid_productoDiferenciasFisicasProductos(esInicial);
		this.setActivarid_empresaDiferenciasFisicasProductos(esInicial);
		this.setActivarid_sucursalDiferenciasFisicasProductos(esInicial);
		this.setActivarid_lineaDiferenciasFisicasProductos(esInicial);
		this.setActivarid_linea_grupoDiferenciasFisicasProductos(esInicial);
		this.setActivarid_linea_categoriaDiferenciasFisicasProductos(esInicial);
		this.setActivarid_linea_marcaDiferenciasFisicasProductos(esInicial);
		this.setActivarfecha_ultima_venta_hastaDiferenciasFisicasProductos(esInicial);
		this.setActivarcodigoDiferenciasFisicasProductos(esInicial);
		this.setActivarnombre_unidadDiferenciasFisicasProductos(esInicial);
		this.setActivarcantidad_disponibleDiferenciasFisicasProductos(esInicial);
		this.setActivarcantidad_fisicaDiferenciasFisicasProductos(esInicial);
		this.setActivarcodigo_productoDiferenciasFisicasProductos(esInicial);
		this.setActivarnombreDiferenciasFisicasProductos(esInicial);
		this.setActivaringresosDiferenciasFisicasProductos(esInicial);
		this.setActivaregresosDiferenciasFisicasProductos(esInicial);
		this.setActivardisponible_corteDiferenciasFisicasProductos(esInicial);
		this.setActivardiferenciaDiferenciasFisicasProductos(esInicial);
		this.setActivarcostoDiferenciasFisicasProductos(esInicial);
		this.setActivartotalDiferenciasFisicasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.ID)) {
				this.setActivaridDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setActivarfecha_ultima_venta_hastaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA)) {
				this.setActivarcantidad_fisicaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.INGRESOS)) {
				this.setActivaringresosDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.EGRESOS)) {
				this.setActivaregresosDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE)) {
				this.setActivardisponible_corteDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA)) {
				this.setActivardiferenciaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.COSTO)) {
				this.setActivarcostoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.TOTAL)) {
				this.setActivartotalDiferenciasFisicasProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_bodegaDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_productoDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_empresaDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_sucursalDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_lineaDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_linea_grupoDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_linea_categoriaDiferenciasFisicasProductos(esInicial);
		this.setResaltarid_linea_marcaDiferenciasFisicasProductos(esInicial);
		this.setResaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos(esInicial);
		this.setResaltarcodigoDiferenciasFisicasProductos(esInicial);
		this.setResaltarnombre_unidadDiferenciasFisicasProductos(esInicial);
		this.setResaltarcantidad_disponibleDiferenciasFisicasProductos(esInicial);
		this.setResaltarcantidad_fisicaDiferenciasFisicasProductos(esInicial);
		this.setResaltarcodigo_productoDiferenciasFisicasProductos(esInicial);
		this.setResaltarnombreDiferenciasFisicasProductos(esInicial);
		this.setResaltaringresosDiferenciasFisicasProductos(esInicial);
		this.setResaltaregresosDiferenciasFisicasProductos(esInicial);
		this.setResaltardisponible_corteDiferenciasFisicasProductos(esInicial);
		this.setResaltardiferenciaDiferenciasFisicasProductos(esInicial);
		this.setResaltarcostoDiferenciasFisicasProductos(esInicial);
		this.setResaltartotalDiferenciasFisicasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.ID)) {
				this.setResaltaridDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setResaltarfecha_ultima_venta_hastaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CANTIDADFISICA)) {
				this.setResaltarcantidad_fisicaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.INGRESOS)) {
				this.setResaltaringresosDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.EGRESOS)) {
				this.setResaltaregresosDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.DISPONIBLECORTE)) {
				this.setResaltardisponible_corteDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.DIFERENCIA)) {
				this.setResaltardiferenciaDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.COSTO)) {
				this.setResaltarcostoDiferenciasFisicasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiferenciasFisicasProductosConstantesFunciones.TOTAL)) {
				this.setResaltartotalDiferenciasFisicasProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos=true;

	public Boolean getMostrarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos() {
		return this.mostrarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos;
	}

	public void setMostrarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos=true;

	public Boolean getActivarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos() {
		return this.activarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos;
	}

	public void setActivarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos(Boolean habilitarResaltar) {
		this.activarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos=null;

	public Border getResaltarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos() {
		return this.resaltarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos;
	}

	public void setResaltarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos(Border borderResaltar) {
		this.resaltarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos= borderResaltar;
	}

	public void setResaltarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*DiferenciasFisicasProductosBeanSwingJInternalFrame diferenciasfisicasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDiferenciasFisicasProductosDiferenciasFisicasProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}