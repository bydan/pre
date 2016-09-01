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


import com.bydan.erp.inventario.util.report.ExistenciasDisponiblesConstantesFunciones;
import com.bydan.erp.inventario.util.report.ExistenciasDisponiblesParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ExistenciasDisponiblesParameterGeneral;

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
final public class ExistenciasDisponiblesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ExistenciasDisponibles";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ExistenciasDisponibles"+ExistenciasDisponiblesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ExistenciasDisponiblesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ExistenciasDisponiblesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ExistenciasDisponiblesConstantesFunciones.SCHEMA+"_"+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ExistenciasDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ExistenciasDisponiblesConstantesFunciones.SCHEMA+"_"+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ExistenciasDisponiblesConstantesFunciones.SCHEMA+"_"+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ExistenciasDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ExistenciasDisponiblesConstantesFunciones.SCHEMA+"_"+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ExistenciasDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ExistenciasDisponiblesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasDisponiblesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ExistenciasDisponiblesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ExistenciasDisponiblesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ExistenciasDisponiblesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ExistenciasDisponiblesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Existencias Disponibleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Existencias Disponibles";
	public static final String SCLASSWEBTITULO_LOWER="Existencias Disponibles";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ExistenciasDisponibles";
	public static final String OBJECTNAME="existenciasdisponibles";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="existencias_disponibles";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select existenciasdisponibles from "+ExistenciasDisponiblesConstantesFunciones.SPERSISTENCENAME+" existenciasdisponibles";
	public static String QUERYSELECTNATIVE="select "+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".version_row,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_bodega,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_producto,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_empresa,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_sucursal,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_linea,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_linea_grupo,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_linea_categoria,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".id_linea_marca,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".fecha_ultima_venta_hasta,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".codigo,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".nombre_unidad,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".cantidad_disponible,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".cantidad_fisica,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".codigo_producto,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".nombre,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".ingresos,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".egresos,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".disponible_corte,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".diferencia,"+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME+".destino from "+ExistenciasDisponiblesConstantesFunciones.SCHEMA+"."+ExistenciasDisponiblesConstantesFunciones.TABLENAME;//+" as "+ExistenciasDisponiblesConstantesFunciones.TABLENAME;
	
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
    public static final String DESTINO= "destino";
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
    	public static final String LABEL_DESTINO= "Destino";
		public static final String LABEL_DESTINO_LOWER= "Destino";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getExistenciasDisponiblesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDBODEGA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDEMPRESA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.FECHAULTIMAVENTAHASTA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.CODIGO)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADFISICA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.NOMBRE)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.INGRESOS)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_INGRESOS;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.EGRESOS)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_EGRESOS;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_DISPONIBLECORTE;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.DIFERENCIA)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_DIFERENCIA;}
		if(sNombreColumna.equals(ExistenciasDisponiblesConstantesFunciones.DESTINO)) {sLabelColumna=ExistenciasDisponiblesConstantesFunciones.LABEL_DESTINO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getExistenciasDisponiblesDescripcion(ExistenciasDisponibles existenciasdisponibles) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(existenciasdisponibles !=null/* && existenciasdisponibles.getId()!=0*/) {
			sDescripcion=existenciasdisponibles.getcodigo();//existenciasdisponiblesexistenciasdisponibles.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getExistenciasDisponiblesDescripcionDetallado(ExistenciasDisponibles existenciasdisponibles) {
		String sDescripcion="";
			
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.ID+"=";
		sDescripcion+=existenciasdisponibles.getId().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=existenciasdisponibles.getVersionRow().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=existenciasdisponibles.getid_bodega().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=existenciasdisponibles.getid_producto().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=existenciasdisponibles.getid_empresa().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=existenciasdisponibles.getid_sucursal().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDLINEA+"=";
		sDescripcion+=existenciasdisponibles.getid_linea().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=existenciasdisponibles.getid_linea_grupo().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=existenciasdisponibles.getid_linea_categoria().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=existenciasdisponibles.getid_linea_marca().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.FECHAULTIMAVENTAHASTA+"=";
		sDescripcion+=existenciasdisponibles.getfecha_ultima_venta_hasta().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.CODIGO+"=";
		sDescripcion+=existenciasdisponibles.getcodigo()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=existenciasdisponibles.getnombre_unidad()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=existenciasdisponibles.getcantidad_disponible().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA+"=";
		sDescripcion+=existenciasdisponibles.getcantidad_fisica().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=existenciasdisponibles.getcodigo_producto()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.NOMBRE+"=";
		sDescripcion+=existenciasdisponibles.getnombre()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.INGRESOS+"=";
		sDescripcion+=existenciasdisponibles.getingresos().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.EGRESOS+"=";
		sDescripcion+=existenciasdisponibles.getegresos().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE+"=";
		sDescripcion+=existenciasdisponibles.getdisponible_corte().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.DIFERENCIA+"=";
		sDescripcion+=existenciasdisponibles.getdiferencia().toString()+",";
		sDescripcion+=ExistenciasDisponiblesConstantesFunciones.DESTINO+"=";
		sDescripcion+=existenciasdisponibles.getdestino().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setExistenciasDisponiblesDescripcion(ExistenciasDisponibles existenciasdisponibles,String sValor) throws Exception {			
		if(existenciasdisponibles !=null) {
			existenciasdisponibles.setcodigo(sValor);;//existenciasdisponiblesexistenciasdisponibles.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaExistenciasDisponibles")) {
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

	public static String getDetalleIndiceBusquedaExistenciasDisponibles(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosExistenciasDisponibles(ExistenciasDisponibles existenciasdisponibles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		existenciasdisponibles.setcodigo(existenciasdisponibles.getcodigo().trim());
		existenciasdisponibles.setnombre_unidad(existenciasdisponibles.getnombre_unidad().trim());
		existenciasdisponibles.setcodigo_producto(existenciasdisponibles.getcodigo_producto().trim());
		existenciasdisponibles.setnombre(existenciasdisponibles.getnombre().trim());
	}
	
	public static void quitarEspaciosExistenciasDisponibless(List<ExistenciasDisponibles> existenciasdisponibless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ExistenciasDisponibles existenciasdisponibles: existenciasdisponibless) {
			existenciasdisponibles.setcodigo(existenciasdisponibles.getcodigo().trim());
			existenciasdisponibles.setnombre_unidad(existenciasdisponibles.getnombre_unidad().trim());
			existenciasdisponibles.setcodigo_producto(existenciasdisponibles.getcodigo_producto().trim());
			existenciasdisponibles.setnombre(existenciasdisponibles.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresExistenciasDisponibles(ExistenciasDisponibles existenciasdisponibles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && existenciasdisponibles.getConCambioAuxiliar()) {
			existenciasdisponibles.setIsDeleted(existenciasdisponibles.getIsDeletedAuxiliar());	
			existenciasdisponibles.setIsNew(existenciasdisponibles.getIsNewAuxiliar());	
			existenciasdisponibles.setIsChanged(existenciasdisponibles.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			existenciasdisponibles.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			existenciasdisponibles.setIsDeletedAuxiliar(false);	
			existenciasdisponibles.setIsNewAuxiliar(false);	
			existenciasdisponibles.setIsChangedAuxiliar(false);
			
			existenciasdisponibles.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresExistenciasDisponibless(List<ExistenciasDisponibles> existenciasdisponibless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ExistenciasDisponibles existenciasdisponibles : existenciasdisponibless) {
			if(conAsignarBase && existenciasdisponibles.getConCambioAuxiliar()) {
				existenciasdisponibles.setIsDeleted(existenciasdisponibles.getIsDeletedAuxiliar());	
				existenciasdisponibles.setIsNew(existenciasdisponibles.getIsNewAuxiliar());	
				existenciasdisponibles.setIsChanged(existenciasdisponibles.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				existenciasdisponibles.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				existenciasdisponibles.setIsDeletedAuxiliar(false);	
				existenciasdisponibles.setIsNewAuxiliar(false);	
				existenciasdisponibles.setIsChangedAuxiliar(false);
				
				existenciasdisponibles.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresExistenciasDisponibles(ExistenciasDisponibles existenciasdisponibles,Boolean conEnteros) throws Exception  {
		existenciasdisponibles.setingresos(0.0);
		existenciasdisponibles.setegresos(0.0);
		existenciasdisponibles.setdisponible_corte(0.0);
		existenciasdisponibles.setdiferencia(0.0);
		existenciasdisponibles.setdestino(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			existenciasdisponibles.setcantidad_disponible(0);
			existenciasdisponibles.setcantidad_fisica(0);
		}
	}		
	
	public static void InicializarValoresExistenciasDisponibless(List<ExistenciasDisponibles> existenciasdisponibless,Boolean conEnteros) throws Exception  {
		
		for(ExistenciasDisponibles existenciasdisponibles: existenciasdisponibless) {
			existenciasdisponibles.setingresos(0.0);
			existenciasdisponibles.setegresos(0.0);
			existenciasdisponibles.setdisponible_corte(0.0);
			existenciasdisponibles.setdiferencia(0.0);
			existenciasdisponibles.setdestino(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				existenciasdisponibles.setcantidad_disponible(0);
				existenciasdisponibles.setcantidad_fisica(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaExistenciasDisponibles(List<ExistenciasDisponibles> existenciasdisponibless,ExistenciasDisponibles existenciasdisponiblesAux) throws Exception  {
		ExistenciasDisponiblesConstantesFunciones.InicializarValoresExistenciasDisponibles(existenciasdisponiblesAux,true);
		
		for(ExistenciasDisponibles existenciasdisponibles: existenciasdisponibless) {
			if(existenciasdisponibles.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			existenciasdisponiblesAux.setcantidad_disponible(existenciasdisponiblesAux.getcantidad_disponible()+existenciasdisponibles.getcantidad_disponible());			
			existenciasdisponiblesAux.setcantidad_fisica(existenciasdisponiblesAux.getcantidad_fisica()+existenciasdisponibles.getcantidad_fisica());			
			existenciasdisponiblesAux.setingresos(existenciasdisponiblesAux.getingresos()+existenciasdisponibles.getingresos());			
			existenciasdisponiblesAux.setegresos(existenciasdisponiblesAux.getegresos()+existenciasdisponibles.getegresos());			
			existenciasdisponiblesAux.setdisponible_corte(existenciasdisponiblesAux.getdisponible_corte()+existenciasdisponibles.getdisponible_corte());			
			existenciasdisponiblesAux.setdiferencia(existenciasdisponiblesAux.getdiferencia()+existenciasdisponibles.getdiferencia());			
			existenciasdisponiblesAux.setdestino(existenciasdisponiblesAux.getdestino()+existenciasdisponibles.getdestino());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesExistenciasDisponibles(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ExistenciasDisponiblesConstantesFunciones.getArrayColumnasGlobalesExistenciasDisponibles(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesExistenciasDisponibles(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ExistenciasDisponiblesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ExistenciasDisponiblesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ExistenciasDisponiblesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ExistenciasDisponiblesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoExistenciasDisponibles(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ExistenciasDisponibles> existenciasdisponibless,ExistenciasDisponibles existenciasdisponibles,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ExistenciasDisponibles existenciasdisponiblesAux: existenciasdisponibless) {
			if(existenciasdisponiblesAux!=null && existenciasdisponibles!=null) {
				if((existenciasdisponiblesAux.getId()==null && existenciasdisponibles.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(existenciasdisponiblesAux.getId()!=null && existenciasdisponibles.getId()!=null){
					if(existenciasdisponiblesAux.getId().equals(existenciasdisponibles.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaExistenciasDisponibles(List<ExistenciasDisponibles> existenciasdisponibless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ingresosTotal=0.0;
		Double egresosTotal=0.0;
		Double disponible_corteTotal=0.0;
		Double diferenciaTotal=0.0;
		Double destinoTotal=0.0;
	
		for(ExistenciasDisponibles existenciasdisponibles: existenciasdisponibless) {			
			if(existenciasdisponibles.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ingresosTotal+=existenciasdisponibles.getingresos();
			egresosTotal+=existenciasdisponibles.getegresos();
			disponible_corteTotal+=existenciasdisponibles.getdisponible_corte();
			diferenciaTotal+=existenciasdisponibles.getdiferencia();
			destinoTotal+=existenciasdisponibles.getdestino();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ExistenciasDisponiblesConstantesFunciones.INGRESOS);
		datoGeneral.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_INGRESOS);
		datoGeneral.setdValorDouble(ingresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ExistenciasDisponiblesConstantesFunciones.EGRESOS);
		datoGeneral.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_EGRESOS);
		datoGeneral.setdValorDouble(egresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE);
		datoGeneral.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_DISPONIBLECORTE);
		datoGeneral.setdValorDouble(disponible_corteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ExistenciasDisponiblesConstantesFunciones.DIFERENCIA);
		datoGeneral.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_DIFERENCIA);
		datoGeneral.setdValorDouble(diferenciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ExistenciasDisponiblesConstantesFunciones.DESTINO);
		datoGeneral.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_DESTINO);
		datoGeneral.setdValorDouble(destinoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaExistenciasDisponibles() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_ID, ExistenciasDisponiblesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_VERSIONROW, ExistenciasDisponiblesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGO, ExistenciasDisponiblesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD, ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE, ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADFISICA, ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGOPRODUCTO, ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBRE, ExistenciasDisponiblesConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_INGRESOS, ExistenciasDisponiblesConstantesFunciones.INGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_EGRESOS, ExistenciasDisponiblesConstantesFunciones.EGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_DISPONIBLECORTE, ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_DIFERENCIA, ExistenciasDisponiblesConstantesFunciones.DIFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasDisponiblesConstantesFunciones.LABEL_DESTINO, ExistenciasDisponiblesConstantesFunciones.DESTINO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasExistenciasDisponibles() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.INGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.EGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.DIFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasDisponiblesConstantesFunciones.DESTINO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarExistenciasDisponibles() throws Exception  {
		return ExistenciasDisponiblesConstantesFunciones.getTiposSeleccionarExistenciasDisponibles(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarExistenciasDisponibles(Boolean conFk) throws Exception  {
		return ExistenciasDisponiblesConstantesFunciones.getTiposSeleccionarExistenciasDisponibles(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarExistenciasDisponibles(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADFISICA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADFISICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_INGRESOS);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_INGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_EGRESOS);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_EGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_DISPONIBLECORTE);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_DISPONIBLECORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_DIFERENCIA);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_DIFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasDisponiblesConstantesFunciones.LABEL_DESTINO);
			reporte.setsDescripcion(ExistenciasDisponiblesConstantesFunciones.LABEL_DESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesExistenciasDisponibles(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesExistenciasDisponibles(ExistenciasDisponibles existenciasdisponiblesAux) throws Exception {
		
			existenciasdisponiblesAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(existenciasdisponiblesAux.getBodega()));
			existenciasdisponiblesAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(existenciasdisponiblesAux.getProducto()));
			existenciasdisponiblesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(existenciasdisponiblesAux.getEmpresa()));
			existenciasdisponiblesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(existenciasdisponiblesAux.getSucursal()));
			existenciasdisponiblesAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLinea()));
			existenciasdisponiblesAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLineaGrupo()));
			existenciasdisponiblesAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLineaCategoria()));
			existenciasdisponiblesAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesExistenciasDisponibles(List<ExistenciasDisponibles> existenciasdisponiblessTemp) throws Exception {
		for(ExistenciasDisponibles existenciasdisponiblesAux:existenciasdisponiblessTemp) {
			
			existenciasdisponiblesAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(existenciasdisponiblesAux.getBodega()));
			existenciasdisponiblesAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(existenciasdisponiblesAux.getProducto()));
			existenciasdisponiblesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(existenciasdisponiblesAux.getEmpresa()));
			existenciasdisponiblesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(existenciasdisponiblesAux.getSucursal()));
			existenciasdisponiblesAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLinea()));
			existenciasdisponiblesAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLineaGrupo()));
			existenciasdisponiblesAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLineaCategoria()));
			existenciasdisponiblesAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciasdisponiblesAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfExistenciasDisponibles(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfExistenciasDisponibles(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfExistenciasDisponibles(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ExistenciasDisponiblesConstantesFunciones.getClassesRelationshipsOfExistenciasDisponibles(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfExistenciasDisponibles(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfExistenciasDisponibles(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ExistenciasDisponiblesConstantesFunciones.getClassesRelationshipsFromStringsOfExistenciasDisponibles(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfExistenciasDisponibles(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ExistenciasDisponibles existenciasdisponibles,List<ExistenciasDisponibles> existenciasdisponibless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ExistenciasDisponibles existenciasdisponibles,List<ExistenciasDisponibles> existenciasdisponibless) throws Exception {
		try	{			
			for(ExistenciasDisponibles existenciasdisponiblesLocal:existenciasdisponibless) {
				if(existenciasdisponiblesLocal.getId().equals(existenciasdisponibles.getId())) {
					existenciasdisponiblesLocal.setIsSelected(existenciasdisponibles.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesExistenciasDisponibles(List<ExistenciasDisponibles> existenciasdisponiblessAux) throws Exception {
		//this.existenciasdisponiblessAux=existenciasdisponiblessAux;
		
		for(ExistenciasDisponibles existenciasdisponiblesAux:existenciasdisponiblessAux) {
			if(existenciasdisponiblesAux.getIsChanged()) {
				existenciasdisponiblesAux.setIsChanged(false);
			}		
			
			if(existenciasdisponiblesAux.getIsNew()) {
				existenciasdisponiblesAux.setIsNew(false);
			}	
			
			if(existenciasdisponiblesAux.getIsDeleted()) {
				existenciasdisponiblesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesExistenciasDisponibles(ExistenciasDisponibles existenciasdisponiblesAux) throws Exception {
		//this.existenciasdisponiblesAux=existenciasdisponiblesAux;
		
			if(existenciasdisponiblesAux.getIsChanged()) {
				existenciasdisponiblesAux.setIsChanged(false);
			}		
			
			if(existenciasdisponiblesAux.getIsNew()) {
				existenciasdisponiblesAux.setIsNew(false);
			}	
			
			if(existenciasdisponiblesAux.getIsDeleted()) {
				existenciasdisponiblesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ExistenciasDisponibles existenciasdisponiblesAsignar,ExistenciasDisponibles existenciasdisponibles) throws Exception {
		existenciasdisponiblesAsignar.setId(existenciasdisponibles.getId());	
		existenciasdisponiblesAsignar.setVersionRow(existenciasdisponibles.getVersionRow());	
		existenciasdisponiblesAsignar.setcodigo(existenciasdisponibles.getcodigo());	
		existenciasdisponiblesAsignar.setnombre_unidad(existenciasdisponibles.getnombre_unidad());	
		existenciasdisponiblesAsignar.setcantidad_disponible(existenciasdisponibles.getcantidad_disponible());	
		existenciasdisponiblesAsignar.setcantidad_fisica(existenciasdisponibles.getcantidad_fisica());	
		existenciasdisponiblesAsignar.setcodigo_producto(existenciasdisponibles.getcodigo_producto());	
		existenciasdisponiblesAsignar.setnombre(existenciasdisponibles.getnombre());	
		existenciasdisponiblesAsignar.setingresos(existenciasdisponibles.getingresos());	
		existenciasdisponiblesAsignar.setegresos(existenciasdisponibles.getegresos());	
		existenciasdisponiblesAsignar.setdisponible_corte(existenciasdisponibles.getdisponible_corte());	
		existenciasdisponiblesAsignar.setdiferencia(existenciasdisponibles.getdiferencia());	
		existenciasdisponiblesAsignar.setdestino(existenciasdisponibles.getdestino());	
	}
	
	public static void inicializarExistenciasDisponibles(ExistenciasDisponibles existenciasdisponibles) throws Exception {
		try {
				existenciasdisponibles.setId(0L);	
					
				existenciasdisponibles.setcodigo("");	
				existenciasdisponibles.setnombre_unidad("");	
				existenciasdisponibles.setcantidad_disponible(0);	
				existenciasdisponibles.setcantidad_fisica(0);	
				existenciasdisponibles.setcodigo_producto("");	
				existenciasdisponibles.setnombre("");	
				existenciasdisponibles.setingresos(0.0);	
				existenciasdisponibles.setegresos(0.0);	
				existenciasdisponibles.setdisponible_corte(0.0);	
				existenciasdisponibles.setdiferencia(0.0);	
				existenciasdisponibles.setdestino(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderExistenciasDisponibles(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_CANTIDADFISICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_INGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_EGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_DISPONIBLECORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_DIFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasDisponiblesConstantesFunciones.LABEL_DESTINO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataExistenciasDisponibles(String sTipo,Row row,Workbook workbook,ExistenciasDisponibles existenciasdisponibles,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getfecha_ultima_venta_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getcantidad_fisica());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getingresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getegresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getdisponible_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getdiferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciasdisponibles.getdestino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryExistenciasDisponibles="";
	
	public String getsFinalQueryExistenciasDisponibles() {
		return this.sFinalQueryExistenciasDisponibles;
	}
	
	public void setsFinalQueryExistenciasDisponibles(String sFinalQueryExistenciasDisponibles) {
		this.sFinalQueryExistenciasDisponibles= sFinalQueryExistenciasDisponibles;
	}
	
	public Border resaltarSeleccionarExistenciasDisponibles=null;
	
	public Border setResaltarSeleccionarExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarSeleccionarExistenciasDisponibles= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarExistenciasDisponibles() {
		return this.resaltarSeleccionarExistenciasDisponibles;
	}
	
	public void setResaltarSeleccionarExistenciasDisponibles(Border borderResaltarSeleccionarExistenciasDisponibles) {
		this.resaltarSeleccionarExistenciasDisponibles= borderResaltarSeleccionarExistenciasDisponibles;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridExistenciasDisponibles=null;
	public Boolean mostraridExistenciasDisponibles=true;
	public Boolean activaridExistenciasDisponibles=true;

	public Border resaltarid_bodegaExistenciasDisponibles=null;
	public Boolean mostrarid_bodegaExistenciasDisponibles=true;
	public Boolean activarid_bodegaExistenciasDisponibles=true;
	public Boolean cargarid_bodegaExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarid_productoExistenciasDisponibles=null;
	public Boolean mostrarid_productoExistenciasDisponibles=true;
	public Boolean activarid_productoExistenciasDisponibles=true;
	public Boolean cargarid_productoExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarid_empresaExistenciasDisponibles=null;
	public Boolean mostrarid_empresaExistenciasDisponibles=true;
	public Boolean activarid_empresaExistenciasDisponibles=true;
	public Boolean cargarid_empresaExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarid_sucursalExistenciasDisponibles=null;
	public Boolean mostrarid_sucursalExistenciasDisponibles=true;
	public Boolean activarid_sucursalExistenciasDisponibles=true;
	public Boolean cargarid_sucursalExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarid_lineaExistenciasDisponibles=null;
	public Boolean mostrarid_lineaExistenciasDisponibles=true;
	public Boolean activarid_lineaExistenciasDisponibles=true;
	public Boolean cargarid_lineaExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoExistenciasDisponibles=null;
	public Boolean mostrarid_linea_grupoExistenciasDisponibles=true;
	public Boolean activarid_linea_grupoExistenciasDisponibles=true;
	public Boolean cargarid_linea_grupoExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaExistenciasDisponibles=null;
	public Boolean mostrarid_linea_categoriaExistenciasDisponibles=true;
	public Boolean activarid_linea_categoriaExistenciasDisponibles=true;
	public Boolean cargarid_linea_categoriaExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaExistenciasDisponibles=null;
	public Boolean mostrarid_linea_marcaExistenciasDisponibles=true;
	public Boolean activarid_linea_marcaExistenciasDisponibles=true;
	public Boolean cargarid_linea_marcaExistenciasDisponibles=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaExistenciasDisponibles=false;//ConEventDepend=true

	public Border resaltarfecha_ultima_venta_hastaExistenciasDisponibles=null;
	public Boolean mostrarfecha_ultima_venta_hastaExistenciasDisponibles=true;
	public Boolean activarfecha_ultima_venta_hastaExistenciasDisponibles=true;

	public Border resaltarcodigoExistenciasDisponibles=null;
	public Boolean mostrarcodigoExistenciasDisponibles=true;
	public Boolean activarcodigoExistenciasDisponibles=true;

	public Border resaltarnombre_unidadExistenciasDisponibles=null;
	public Boolean mostrarnombre_unidadExistenciasDisponibles=true;
	public Boolean activarnombre_unidadExistenciasDisponibles=true;

	public Border resaltarcantidad_disponibleExistenciasDisponibles=null;
	public Boolean mostrarcantidad_disponibleExistenciasDisponibles=true;
	public Boolean activarcantidad_disponibleExistenciasDisponibles=true;

	public Border resaltarcantidad_fisicaExistenciasDisponibles=null;
	public Boolean mostrarcantidad_fisicaExistenciasDisponibles=true;
	public Boolean activarcantidad_fisicaExistenciasDisponibles=true;

	public Border resaltarcodigo_productoExistenciasDisponibles=null;
	public Boolean mostrarcodigo_productoExistenciasDisponibles=true;
	public Boolean activarcodigo_productoExistenciasDisponibles=true;

	public Border resaltarnombreExistenciasDisponibles=null;
	public Boolean mostrarnombreExistenciasDisponibles=true;
	public Boolean activarnombreExistenciasDisponibles=true;

	public Border resaltaringresosExistenciasDisponibles=null;
	public Boolean mostraringresosExistenciasDisponibles=true;
	public Boolean activaringresosExistenciasDisponibles=true;

	public Border resaltaregresosExistenciasDisponibles=null;
	public Boolean mostraregresosExistenciasDisponibles=true;
	public Boolean activaregresosExistenciasDisponibles=true;

	public Border resaltardisponible_corteExistenciasDisponibles=null;
	public Boolean mostrardisponible_corteExistenciasDisponibles=true;
	public Boolean activardisponible_corteExistenciasDisponibles=true;

	public Border resaltardiferenciaExistenciasDisponibles=null;
	public Boolean mostrardiferenciaExistenciasDisponibles=true;
	public Boolean activardiferenciaExistenciasDisponibles=true;

	public Border resaltardestinoExistenciasDisponibles=null;
	public Boolean mostrardestinoExistenciasDisponibles=true;
	public Boolean activardestinoExistenciasDisponibles=true;

	
	

	public Border setResaltaridExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltaridExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridExistenciasDisponibles() {
		return this.resaltaridExistenciasDisponibles;
	}

	public void setResaltaridExistenciasDisponibles(Border borderResaltar) {
		this.resaltaridExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostraridExistenciasDisponibles() {
		return this.mostraridExistenciasDisponibles;
	}

	public void setMostraridExistenciasDisponibles(Boolean mostraridExistenciasDisponibles) {
		this.mostraridExistenciasDisponibles= mostraridExistenciasDisponibles;
	}

	public Boolean getActivaridExistenciasDisponibles() {
		return this.activaridExistenciasDisponibles;
	}

	public void setActivaridExistenciasDisponibles(Boolean activaridExistenciasDisponibles) {
		this.activaridExistenciasDisponibles= activaridExistenciasDisponibles;
	}

	public Border setResaltarid_bodegaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_bodegaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaExistenciasDisponibles() {
		return this.resaltarid_bodegaExistenciasDisponibles;
	}

	public void setResaltarid_bodegaExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_bodegaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_bodegaExistenciasDisponibles() {
		return this.mostrarid_bodegaExistenciasDisponibles;
	}

	public void setMostrarid_bodegaExistenciasDisponibles(Boolean mostrarid_bodegaExistenciasDisponibles) {
		this.mostrarid_bodegaExistenciasDisponibles= mostrarid_bodegaExistenciasDisponibles;
	}

	public Boolean getActivarid_bodegaExistenciasDisponibles() {
		return this.activarid_bodegaExistenciasDisponibles;
	}

	public void setActivarid_bodegaExistenciasDisponibles(Boolean activarid_bodegaExistenciasDisponibles) {
		this.activarid_bodegaExistenciasDisponibles= activarid_bodegaExistenciasDisponibles;
	}

	public Boolean getCargarid_bodegaExistenciasDisponibles() {
		return this.cargarid_bodegaExistenciasDisponibles;
	}

	public void setCargarid_bodegaExistenciasDisponibles(Boolean cargarid_bodegaExistenciasDisponibles) {
		this.cargarid_bodegaExistenciasDisponibles= cargarid_bodegaExistenciasDisponibles;
	}

	public Border setResaltarid_productoExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_productoExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoExistenciasDisponibles() {
		return this.resaltarid_productoExistenciasDisponibles;
	}

	public void setResaltarid_productoExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_productoExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_productoExistenciasDisponibles() {
		return this.mostrarid_productoExistenciasDisponibles;
	}

	public void setMostrarid_productoExistenciasDisponibles(Boolean mostrarid_productoExistenciasDisponibles) {
		this.mostrarid_productoExistenciasDisponibles= mostrarid_productoExistenciasDisponibles;
	}

	public Boolean getActivarid_productoExistenciasDisponibles() {
		return this.activarid_productoExistenciasDisponibles;
	}

	public void setActivarid_productoExistenciasDisponibles(Boolean activarid_productoExistenciasDisponibles) {
		this.activarid_productoExistenciasDisponibles= activarid_productoExistenciasDisponibles;
	}

	public Boolean getCargarid_productoExistenciasDisponibles() {
		return this.cargarid_productoExistenciasDisponibles;
	}

	public void setCargarid_productoExistenciasDisponibles(Boolean cargarid_productoExistenciasDisponibles) {
		this.cargarid_productoExistenciasDisponibles= cargarid_productoExistenciasDisponibles;
	}

	public Border setResaltarid_empresaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_empresaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaExistenciasDisponibles() {
		return this.resaltarid_empresaExistenciasDisponibles;
	}

	public void setResaltarid_empresaExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_empresaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_empresaExistenciasDisponibles() {
		return this.mostrarid_empresaExistenciasDisponibles;
	}

	public void setMostrarid_empresaExistenciasDisponibles(Boolean mostrarid_empresaExistenciasDisponibles) {
		this.mostrarid_empresaExistenciasDisponibles= mostrarid_empresaExistenciasDisponibles;
	}

	public Boolean getActivarid_empresaExistenciasDisponibles() {
		return this.activarid_empresaExistenciasDisponibles;
	}

	public void setActivarid_empresaExistenciasDisponibles(Boolean activarid_empresaExistenciasDisponibles) {
		this.activarid_empresaExistenciasDisponibles= activarid_empresaExistenciasDisponibles;
	}

	public Boolean getCargarid_empresaExistenciasDisponibles() {
		return this.cargarid_empresaExistenciasDisponibles;
	}

	public void setCargarid_empresaExistenciasDisponibles(Boolean cargarid_empresaExistenciasDisponibles) {
		this.cargarid_empresaExistenciasDisponibles= cargarid_empresaExistenciasDisponibles;
	}

	public Border setResaltarid_sucursalExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_sucursalExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalExistenciasDisponibles() {
		return this.resaltarid_sucursalExistenciasDisponibles;
	}

	public void setResaltarid_sucursalExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_sucursalExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_sucursalExistenciasDisponibles() {
		return this.mostrarid_sucursalExistenciasDisponibles;
	}

	public void setMostrarid_sucursalExistenciasDisponibles(Boolean mostrarid_sucursalExistenciasDisponibles) {
		this.mostrarid_sucursalExistenciasDisponibles= mostrarid_sucursalExistenciasDisponibles;
	}

	public Boolean getActivarid_sucursalExistenciasDisponibles() {
		return this.activarid_sucursalExistenciasDisponibles;
	}

	public void setActivarid_sucursalExistenciasDisponibles(Boolean activarid_sucursalExistenciasDisponibles) {
		this.activarid_sucursalExistenciasDisponibles= activarid_sucursalExistenciasDisponibles;
	}

	public Boolean getCargarid_sucursalExistenciasDisponibles() {
		return this.cargarid_sucursalExistenciasDisponibles;
	}

	public void setCargarid_sucursalExistenciasDisponibles(Boolean cargarid_sucursalExistenciasDisponibles) {
		this.cargarid_sucursalExistenciasDisponibles= cargarid_sucursalExistenciasDisponibles;
	}

	public Border setResaltarid_lineaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_lineaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaExistenciasDisponibles() {
		return this.resaltarid_lineaExistenciasDisponibles;
	}

	public void setResaltarid_lineaExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_lineaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_lineaExistenciasDisponibles() {
		return this.mostrarid_lineaExistenciasDisponibles;
	}

	public void setMostrarid_lineaExistenciasDisponibles(Boolean mostrarid_lineaExistenciasDisponibles) {
		this.mostrarid_lineaExistenciasDisponibles= mostrarid_lineaExistenciasDisponibles;
	}

	public Boolean getActivarid_lineaExistenciasDisponibles() {
		return this.activarid_lineaExistenciasDisponibles;
	}

	public void setActivarid_lineaExistenciasDisponibles(Boolean activarid_lineaExistenciasDisponibles) {
		this.activarid_lineaExistenciasDisponibles= activarid_lineaExistenciasDisponibles;
	}

	public Boolean getCargarid_lineaExistenciasDisponibles() {
		return this.cargarid_lineaExistenciasDisponibles;
	}

	public void setCargarid_lineaExistenciasDisponibles(Boolean cargarid_lineaExistenciasDisponibles) {
		this.cargarid_lineaExistenciasDisponibles= cargarid_lineaExistenciasDisponibles;
	}

	public Border setResaltarid_linea_grupoExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoExistenciasDisponibles() {
		return this.resaltarid_linea_grupoExistenciasDisponibles;
	}

	public void setResaltarid_linea_grupoExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_linea_grupoExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoExistenciasDisponibles() {
		return this.mostrarid_linea_grupoExistenciasDisponibles;
	}

	public void setMostrarid_linea_grupoExistenciasDisponibles(Boolean mostrarid_linea_grupoExistenciasDisponibles) {
		this.mostrarid_linea_grupoExistenciasDisponibles= mostrarid_linea_grupoExistenciasDisponibles;
	}

	public Boolean getActivarid_linea_grupoExistenciasDisponibles() {
		return this.activarid_linea_grupoExistenciasDisponibles;
	}

	public void setActivarid_linea_grupoExistenciasDisponibles(Boolean activarid_linea_grupoExistenciasDisponibles) {
		this.activarid_linea_grupoExistenciasDisponibles= activarid_linea_grupoExistenciasDisponibles;
	}

	public Boolean getCargarid_linea_grupoExistenciasDisponibles() {
		return this.cargarid_linea_grupoExistenciasDisponibles;
	}

	public void setCargarid_linea_grupoExistenciasDisponibles(Boolean cargarid_linea_grupoExistenciasDisponibles) {
		this.cargarid_linea_grupoExistenciasDisponibles= cargarid_linea_grupoExistenciasDisponibles;
	}

	public Border setResaltarid_linea_categoriaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaExistenciasDisponibles() {
		return this.resaltarid_linea_categoriaExistenciasDisponibles;
	}

	public void setResaltarid_linea_categoriaExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_linea_categoriaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaExistenciasDisponibles() {
		return this.mostrarid_linea_categoriaExistenciasDisponibles;
	}

	public void setMostrarid_linea_categoriaExistenciasDisponibles(Boolean mostrarid_linea_categoriaExistenciasDisponibles) {
		this.mostrarid_linea_categoriaExistenciasDisponibles= mostrarid_linea_categoriaExistenciasDisponibles;
	}

	public Boolean getActivarid_linea_categoriaExistenciasDisponibles() {
		return this.activarid_linea_categoriaExistenciasDisponibles;
	}

	public void setActivarid_linea_categoriaExistenciasDisponibles(Boolean activarid_linea_categoriaExistenciasDisponibles) {
		this.activarid_linea_categoriaExistenciasDisponibles= activarid_linea_categoriaExistenciasDisponibles;
	}

	public Boolean getCargarid_linea_categoriaExistenciasDisponibles() {
		return this.cargarid_linea_categoriaExistenciasDisponibles;
	}

	public void setCargarid_linea_categoriaExistenciasDisponibles(Boolean cargarid_linea_categoriaExistenciasDisponibles) {
		this.cargarid_linea_categoriaExistenciasDisponibles= cargarid_linea_categoriaExistenciasDisponibles;
	}

	public Border setResaltarid_linea_marcaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaExistenciasDisponibles() {
		return this.resaltarid_linea_marcaExistenciasDisponibles;
	}

	public void setResaltarid_linea_marcaExistenciasDisponibles(Border borderResaltar) {
		this.resaltarid_linea_marcaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaExistenciasDisponibles() {
		return this.mostrarid_linea_marcaExistenciasDisponibles;
	}

	public void setMostrarid_linea_marcaExistenciasDisponibles(Boolean mostrarid_linea_marcaExistenciasDisponibles) {
		this.mostrarid_linea_marcaExistenciasDisponibles= mostrarid_linea_marcaExistenciasDisponibles;
	}

	public Boolean getActivarid_linea_marcaExistenciasDisponibles() {
		return this.activarid_linea_marcaExistenciasDisponibles;
	}

	public void setActivarid_linea_marcaExistenciasDisponibles(Boolean activarid_linea_marcaExistenciasDisponibles) {
		this.activarid_linea_marcaExistenciasDisponibles= activarid_linea_marcaExistenciasDisponibles;
	}

	public Boolean getCargarid_linea_marcaExistenciasDisponibles() {
		return this.cargarid_linea_marcaExistenciasDisponibles;
	}

	public void setCargarid_linea_marcaExistenciasDisponibles(Boolean cargarid_linea_marcaExistenciasDisponibles) {
		this.cargarid_linea_marcaExistenciasDisponibles= cargarid_linea_marcaExistenciasDisponibles;
	}

	public Border setResaltarfecha_ultima_venta_hastaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_venta_hastaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_venta_hastaExistenciasDisponibles() {
		return this.resaltarfecha_ultima_venta_hastaExistenciasDisponibles;
	}

	public void setResaltarfecha_ultima_venta_hastaExistenciasDisponibles(Border borderResaltar) {
		this.resaltarfecha_ultima_venta_hastaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_venta_hastaExistenciasDisponibles() {
		return this.mostrarfecha_ultima_venta_hastaExistenciasDisponibles;
	}

	public void setMostrarfecha_ultima_venta_hastaExistenciasDisponibles(Boolean mostrarfecha_ultima_venta_hastaExistenciasDisponibles) {
		this.mostrarfecha_ultima_venta_hastaExistenciasDisponibles= mostrarfecha_ultima_venta_hastaExistenciasDisponibles;
	}

	public Boolean getActivarfecha_ultima_venta_hastaExistenciasDisponibles() {
		return this.activarfecha_ultima_venta_hastaExistenciasDisponibles;
	}

	public void setActivarfecha_ultima_venta_hastaExistenciasDisponibles(Boolean activarfecha_ultima_venta_hastaExistenciasDisponibles) {
		this.activarfecha_ultima_venta_hastaExistenciasDisponibles= activarfecha_ultima_venta_hastaExistenciasDisponibles;
	}

	public Border setResaltarcodigoExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarcodigoExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoExistenciasDisponibles() {
		return this.resaltarcodigoExistenciasDisponibles;
	}

	public void setResaltarcodigoExistenciasDisponibles(Border borderResaltar) {
		this.resaltarcodigoExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarcodigoExistenciasDisponibles() {
		return this.mostrarcodigoExistenciasDisponibles;
	}

	public void setMostrarcodigoExistenciasDisponibles(Boolean mostrarcodigoExistenciasDisponibles) {
		this.mostrarcodigoExistenciasDisponibles= mostrarcodigoExistenciasDisponibles;
	}

	public Boolean getActivarcodigoExistenciasDisponibles() {
		return this.activarcodigoExistenciasDisponibles;
	}

	public void setActivarcodigoExistenciasDisponibles(Boolean activarcodigoExistenciasDisponibles) {
		this.activarcodigoExistenciasDisponibles= activarcodigoExistenciasDisponibles;
	}

	public Border setResaltarnombre_unidadExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadExistenciasDisponibles() {
		return this.resaltarnombre_unidadExistenciasDisponibles;
	}

	public void setResaltarnombre_unidadExistenciasDisponibles(Border borderResaltar) {
		this.resaltarnombre_unidadExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadExistenciasDisponibles() {
		return this.mostrarnombre_unidadExistenciasDisponibles;
	}

	public void setMostrarnombre_unidadExistenciasDisponibles(Boolean mostrarnombre_unidadExistenciasDisponibles) {
		this.mostrarnombre_unidadExistenciasDisponibles= mostrarnombre_unidadExistenciasDisponibles;
	}

	public Boolean getActivarnombre_unidadExistenciasDisponibles() {
		return this.activarnombre_unidadExistenciasDisponibles;
	}

	public void setActivarnombre_unidadExistenciasDisponibles(Boolean activarnombre_unidadExistenciasDisponibles) {
		this.activarnombre_unidadExistenciasDisponibles= activarnombre_unidadExistenciasDisponibles;
	}

	public Border setResaltarcantidad_disponibleExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleExistenciasDisponibles() {
		return this.resaltarcantidad_disponibleExistenciasDisponibles;
	}

	public void setResaltarcantidad_disponibleExistenciasDisponibles(Border borderResaltar) {
		this.resaltarcantidad_disponibleExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleExistenciasDisponibles() {
		return this.mostrarcantidad_disponibleExistenciasDisponibles;
	}

	public void setMostrarcantidad_disponibleExistenciasDisponibles(Boolean mostrarcantidad_disponibleExistenciasDisponibles) {
		this.mostrarcantidad_disponibleExistenciasDisponibles= mostrarcantidad_disponibleExistenciasDisponibles;
	}

	public Boolean getActivarcantidad_disponibleExistenciasDisponibles() {
		return this.activarcantidad_disponibleExistenciasDisponibles;
	}

	public void setActivarcantidad_disponibleExistenciasDisponibles(Boolean activarcantidad_disponibleExistenciasDisponibles) {
		this.activarcantidad_disponibleExistenciasDisponibles= activarcantidad_disponibleExistenciasDisponibles;
	}

	public Border setResaltarcantidad_fisicaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarcantidad_fisicaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_fisicaExistenciasDisponibles() {
		return this.resaltarcantidad_fisicaExistenciasDisponibles;
	}

	public void setResaltarcantidad_fisicaExistenciasDisponibles(Border borderResaltar) {
		this.resaltarcantidad_fisicaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarcantidad_fisicaExistenciasDisponibles() {
		return this.mostrarcantidad_fisicaExistenciasDisponibles;
	}

	public void setMostrarcantidad_fisicaExistenciasDisponibles(Boolean mostrarcantidad_fisicaExistenciasDisponibles) {
		this.mostrarcantidad_fisicaExistenciasDisponibles= mostrarcantidad_fisicaExistenciasDisponibles;
	}

	public Boolean getActivarcantidad_fisicaExistenciasDisponibles() {
		return this.activarcantidad_fisicaExistenciasDisponibles;
	}

	public void setActivarcantidad_fisicaExistenciasDisponibles(Boolean activarcantidad_fisicaExistenciasDisponibles) {
		this.activarcantidad_fisicaExistenciasDisponibles= activarcantidad_fisicaExistenciasDisponibles;
	}

	public Border setResaltarcodigo_productoExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoExistenciasDisponibles() {
		return this.resaltarcodigo_productoExistenciasDisponibles;
	}

	public void setResaltarcodigo_productoExistenciasDisponibles(Border borderResaltar) {
		this.resaltarcodigo_productoExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoExistenciasDisponibles() {
		return this.mostrarcodigo_productoExistenciasDisponibles;
	}

	public void setMostrarcodigo_productoExistenciasDisponibles(Boolean mostrarcodigo_productoExistenciasDisponibles) {
		this.mostrarcodigo_productoExistenciasDisponibles= mostrarcodigo_productoExistenciasDisponibles;
	}

	public Boolean getActivarcodigo_productoExistenciasDisponibles() {
		return this.activarcodigo_productoExistenciasDisponibles;
	}

	public void setActivarcodigo_productoExistenciasDisponibles(Boolean activarcodigo_productoExistenciasDisponibles) {
		this.activarcodigo_productoExistenciasDisponibles= activarcodigo_productoExistenciasDisponibles;
	}

	public Border setResaltarnombreExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltarnombreExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreExistenciasDisponibles() {
		return this.resaltarnombreExistenciasDisponibles;
	}

	public void setResaltarnombreExistenciasDisponibles(Border borderResaltar) {
		this.resaltarnombreExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrarnombreExistenciasDisponibles() {
		return this.mostrarnombreExistenciasDisponibles;
	}

	public void setMostrarnombreExistenciasDisponibles(Boolean mostrarnombreExistenciasDisponibles) {
		this.mostrarnombreExistenciasDisponibles= mostrarnombreExistenciasDisponibles;
	}

	public Boolean getActivarnombreExistenciasDisponibles() {
		return this.activarnombreExistenciasDisponibles;
	}

	public void setActivarnombreExistenciasDisponibles(Boolean activarnombreExistenciasDisponibles) {
		this.activarnombreExistenciasDisponibles= activarnombreExistenciasDisponibles;
	}

	public Border setResaltaringresosExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltaringresosExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringresosExistenciasDisponibles() {
		return this.resaltaringresosExistenciasDisponibles;
	}

	public void setResaltaringresosExistenciasDisponibles(Border borderResaltar) {
		this.resaltaringresosExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostraringresosExistenciasDisponibles() {
		return this.mostraringresosExistenciasDisponibles;
	}

	public void setMostraringresosExistenciasDisponibles(Boolean mostraringresosExistenciasDisponibles) {
		this.mostraringresosExistenciasDisponibles= mostraringresosExistenciasDisponibles;
	}

	public Boolean getActivaringresosExistenciasDisponibles() {
		return this.activaringresosExistenciasDisponibles;
	}

	public void setActivaringresosExistenciasDisponibles(Boolean activaringresosExistenciasDisponibles) {
		this.activaringresosExistenciasDisponibles= activaringresosExistenciasDisponibles;
	}

	public Border setResaltaregresosExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltaregresosExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaregresosExistenciasDisponibles() {
		return this.resaltaregresosExistenciasDisponibles;
	}

	public void setResaltaregresosExistenciasDisponibles(Border borderResaltar) {
		this.resaltaregresosExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostraregresosExistenciasDisponibles() {
		return this.mostraregresosExistenciasDisponibles;
	}

	public void setMostraregresosExistenciasDisponibles(Boolean mostraregresosExistenciasDisponibles) {
		this.mostraregresosExistenciasDisponibles= mostraregresosExistenciasDisponibles;
	}

	public Boolean getActivaregresosExistenciasDisponibles() {
		return this.activaregresosExistenciasDisponibles;
	}

	public void setActivaregresosExistenciasDisponibles(Boolean activaregresosExistenciasDisponibles) {
		this.activaregresosExistenciasDisponibles= activaregresosExistenciasDisponibles;
	}

	public Border setResaltardisponible_corteExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltardisponible_corteExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponible_corteExistenciasDisponibles() {
		return this.resaltardisponible_corteExistenciasDisponibles;
	}

	public void setResaltardisponible_corteExistenciasDisponibles(Border borderResaltar) {
		this.resaltardisponible_corteExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrardisponible_corteExistenciasDisponibles() {
		return this.mostrardisponible_corteExistenciasDisponibles;
	}

	public void setMostrardisponible_corteExistenciasDisponibles(Boolean mostrardisponible_corteExistenciasDisponibles) {
		this.mostrardisponible_corteExistenciasDisponibles= mostrardisponible_corteExistenciasDisponibles;
	}

	public Boolean getActivardisponible_corteExistenciasDisponibles() {
		return this.activardisponible_corteExistenciasDisponibles;
	}

	public void setActivardisponible_corteExistenciasDisponibles(Boolean activardisponible_corteExistenciasDisponibles) {
		this.activardisponible_corteExistenciasDisponibles= activardisponible_corteExistenciasDisponibles;
	}

	public Border setResaltardiferenciaExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltardiferenciaExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiferenciaExistenciasDisponibles() {
		return this.resaltardiferenciaExistenciasDisponibles;
	}

	public void setResaltardiferenciaExistenciasDisponibles(Border borderResaltar) {
		this.resaltardiferenciaExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrardiferenciaExistenciasDisponibles() {
		return this.mostrardiferenciaExistenciasDisponibles;
	}

	public void setMostrardiferenciaExistenciasDisponibles(Boolean mostrardiferenciaExistenciasDisponibles) {
		this.mostrardiferenciaExistenciasDisponibles= mostrardiferenciaExistenciasDisponibles;
	}

	public Boolean getActivardiferenciaExistenciasDisponibles() {
		return this.activardiferenciaExistenciasDisponibles;
	}

	public void setActivardiferenciaExistenciasDisponibles(Boolean activardiferenciaExistenciasDisponibles) {
		this.activardiferenciaExistenciasDisponibles= activardiferenciaExistenciasDisponibles;
	}

	public Border setResaltardestinoExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciasdisponiblesBeanSwingJInternalFrame.jTtoolBarExistenciasDisponibles.setBorder(borderResaltar);
		
		this.resaltardestinoExistenciasDisponibles= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardestinoExistenciasDisponibles() {
		return this.resaltardestinoExistenciasDisponibles;
	}

	public void setResaltardestinoExistenciasDisponibles(Border borderResaltar) {
		this.resaltardestinoExistenciasDisponibles= borderResaltar;
	}

	public Boolean getMostrardestinoExistenciasDisponibles() {
		return this.mostrardestinoExistenciasDisponibles;
	}

	public void setMostrardestinoExistenciasDisponibles(Boolean mostrardestinoExistenciasDisponibles) {
		this.mostrardestinoExistenciasDisponibles= mostrardestinoExistenciasDisponibles;
	}

	public Boolean getActivardestinoExistenciasDisponibles() {
		return this.activardestinoExistenciasDisponibles;
	}

	public void setActivardestinoExistenciasDisponibles(Boolean activardestinoExistenciasDisponibles) {
		this.activardestinoExistenciasDisponibles= activardestinoExistenciasDisponibles;
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
		
		
		this.setMostraridExistenciasDisponibles(esInicial);
		this.setMostrarid_bodegaExistenciasDisponibles(esInicial);
		this.setMostrarid_productoExistenciasDisponibles(esInicial);
		this.setMostrarid_empresaExistenciasDisponibles(esInicial);
		this.setMostrarid_sucursalExistenciasDisponibles(esInicial);
		this.setMostrarid_lineaExistenciasDisponibles(esInicial);
		this.setMostrarid_linea_grupoExistenciasDisponibles(esInicial);
		this.setMostrarid_linea_categoriaExistenciasDisponibles(esInicial);
		this.setMostrarid_linea_marcaExistenciasDisponibles(esInicial);
		this.setMostrarfecha_ultima_venta_hastaExistenciasDisponibles(esInicial);
		this.setMostrarcodigoExistenciasDisponibles(esInicial);
		this.setMostrarnombre_unidadExistenciasDisponibles(esInicial);
		this.setMostrarcantidad_disponibleExistenciasDisponibles(esInicial);
		this.setMostrarcantidad_fisicaExistenciasDisponibles(esInicial);
		this.setMostrarcodigo_productoExistenciasDisponibles(esInicial);
		this.setMostrarnombreExistenciasDisponibles(esInicial);
		this.setMostraringresosExistenciasDisponibles(esInicial);
		this.setMostraregresosExistenciasDisponibles(esInicial);
		this.setMostrardisponible_corteExistenciasDisponibles(esInicial);
		this.setMostrardiferenciaExistenciasDisponibles(esInicial);
		this.setMostrardestinoExistenciasDisponibles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.ID)) {
				this.setMostraridExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setMostrarfecha_ultima_venta_hastaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA)) {
				this.setMostrarcantidad_fisicaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.INGRESOS)) {
				this.setMostraringresosExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.EGRESOS)) {
				this.setMostraregresosExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE)) {
				this.setMostrardisponible_corteExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DIFERENCIA)) {
				this.setMostrardiferenciaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DESTINO)) {
				this.setMostrardestinoExistenciasDisponibles(esAsigna);
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
		
		
		this.setActivaridExistenciasDisponibles(esInicial);
		this.setActivarid_bodegaExistenciasDisponibles(esInicial);
		this.setActivarid_productoExistenciasDisponibles(esInicial);
		this.setActivarid_empresaExistenciasDisponibles(esInicial);
		this.setActivarid_sucursalExistenciasDisponibles(esInicial);
		this.setActivarid_lineaExistenciasDisponibles(esInicial);
		this.setActivarid_linea_grupoExistenciasDisponibles(esInicial);
		this.setActivarid_linea_categoriaExistenciasDisponibles(esInicial);
		this.setActivarid_linea_marcaExistenciasDisponibles(esInicial);
		this.setActivarfecha_ultima_venta_hastaExistenciasDisponibles(esInicial);
		this.setActivarcodigoExistenciasDisponibles(esInicial);
		this.setActivarnombre_unidadExistenciasDisponibles(esInicial);
		this.setActivarcantidad_disponibleExistenciasDisponibles(esInicial);
		this.setActivarcantidad_fisicaExistenciasDisponibles(esInicial);
		this.setActivarcodigo_productoExistenciasDisponibles(esInicial);
		this.setActivarnombreExistenciasDisponibles(esInicial);
		this.setActivaringresosExistenciasDisponibles(esInicial);
		this.setActivaregresosExistenciasDisponibles(esInicial);
		this.setActivardisponible_corteExistenciasDisponibles(esInicial);
		this.setActivardiferenciaExistenciasDisponibles(esInicial);
		this.setActivardestinoExistenciasDisponibles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.ID)) {
				this.setActivaridExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setActivarfecha_ultima_venta_hastaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA)) {
				this.setActivarcantidad_fisicaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.NOMBRE)) {
				this.setActivarnombreExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.INGRESOS)) {
				this.setActivaringresosExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.EGRESOS)) {
				this.setActivaregresosExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE)) {
				this.setActivardisponible_corteExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DIFERENCIA)) {
				this.setActivardiferenciaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DESTINO)) {
				this.setActivardestinoExistenciasDisponibles(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridExistenciasDisponibles(esInicial);
		this.setResaltarid_bodegaExistenciasDisponibles(esInicial);
		this.setResaltarid_productoExistenciasDisponibles(esInicial);
		this.setResaltarid_empresaExistenciasDisponibles(esInicial);
		this.setResaltarid_sucursalExistenciasDisponibles(esInicial);
		this.setResaltarid_lineaExistenciasDisponibles(esInicial);
		this.setResaltarid_linea_grupoExistenciasDisponibles(esInicial);
		this.setResaltarid_linea_categoriaExistenciasDisponibles(esInicial);
		this.setResaltarid_linea_marcaExistenciasDisponibles(esInicial);
		this.setResaltarfecha_ultima_venta_hastaExistenciasDisponibles(esInicial);
		this.setResaltarcodigoExistenciasDisponibles(esInicial);
		this.setResaltarnombre_unidadExistenciasDisponibles(esInicial);
		this.setResaltarcantidad_disponibleExistenciasDisponibles(esInicial);
		this.setResaltarcantidad_fisicaExistenciasDisponibles(esInicial);
		this.setResaltarcodigo_productoExistenciasDisponibles(esInicial);
		this.setResaltarnombreExistenciasDisponibles(esInicial);
		this.setResaltaringresosExistenciasDisponibles(esInicial);
		this.setResaltaregresosExistenciasDisponibles(esInicial);
		this.setResaltardisponible_corteExistenciasDisponibles(esInicial);
		this.setResaltardiferenciaExistenciasDisponibles(esInicial);
		this.setResaltardestinoExistenciasDisponibles(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.ID)) {
				this.setResaltaridExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setResaltarfecha_ultima_venta_hastaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CANTIDADFISICA)) {
				this.setResaltarcantidad_fisicaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.INGRESOS)) {
				this.setResaltaringresosExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.EGRESOS)) {
				this.setResaltaregresosExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DISPONIBLECORTE)) {
				this.setResaltardisponible_corteExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DIFERENCIA)) {
				this.setResaltardiferenciaExistenciasDisponibles(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasDisponiblesConstantesFunciones.DESTINO)) {
				this.setResaltardestinoExistenciasDisponibles(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaExistenciasDisponiblesExistenciasDisponibles=true;

	public Boolean getMostrarBusquedaExistenciasDisponiblesExistenciasDisponibles() {
		return this.mostrarBusquedaExistenciasDisponiblesExistenciasDisponibles;
	}

	public void setMostrarBusquedaExistenciasDisponiblesExistenciasDisponibles(Boolean visibilidadResaltar) {
		this.mostrarBusquedaExistenciasDisponiblesExistenciasDisponibles= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaExistenciasDisponiblesExistenciasDisponibles=true;

	public Boolean getActivarBusquedaExistenciasDisponiblesExistenciasDisponibles() {
		return this.activarBusquedaExistenciasDisponiblesExistenciasDisponibles;
	}

	public void setActivarBusquedaExistenciasDisponiblesExistenciasDisponibles(Boolean habilitarResaltar) {
		this.activarBusquedaExistenciasDisponiblesExistenciasDisponibles= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaExistenciasDisponiblesExistenciasDisponibles=null;

	public Border getResaltarBusquedaExistenciasDisponiblesExistenciasDisponibles() {
		return this.resaltarBusquedaExistenciasDisponiblesExistenciasDisponibles;
	}

	public void setResaltarBusquedaExistenciasDisponiblesExistenciasDisponibles(Border borderResaltar) {
		this.resaltarBusquedaExistenciasDisponiblesExistenciasDisponibles= borderResaltar;
	}

	public void setResaltarBusquedaExistenciasDisponiblesExistenciasDisponibles(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasDisponiblesBeanSwingJInternalFrame existenciasdisponiblesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaExistenciasDisponiblesExistenciasDisponibles= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}