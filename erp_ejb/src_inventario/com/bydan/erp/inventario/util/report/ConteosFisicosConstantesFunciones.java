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


import com.bydan.erp.inventario.util.report.ConteosFisicosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ConteosFisicosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ConteosFisicosParameterGeneral;

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
final public class ConteosFisicosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ConteosFisicos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConteosFisicos"+ConteosFisicosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConteosFisicosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConteosFisicosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConteosFisicosConstantesFunciones.SCHEMA+"_"+ConteosFisicosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConteosFisicosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConteosFisicosConstantesFunciones.SCHEMA+"_"+ConteosFisicosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConteosFisicosConstantesFunciones.SCHEMA+"_"+ConteosFisicosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConteosFisicosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConteosFisicosConstantesFunciones.SCHEMA+"_"+ConteosFisicosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConteosFisicosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConteosFisicosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConteosFisicosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConteosFisicosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConteosFisicosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConteosFisicosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConteosFisicosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConteosFisicosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConteosFisicosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConteosFisicosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Conteos Fisicoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Conteos Fisicos";
	public static final String SCLASSWEBTITULO_LOWER="Conteos Fisicos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConteosFisicos";
	public static final String OBJECTNAME="conteosfisicos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="conteos_fisicos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select conteosfisicos from "+ConteosFisicosConstantesFunciones.SPERSISTENCENAME+" conteosfisicos";
	public static String QUERYSELECTNATIVE="select "+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".version_row,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_bodega,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_producto,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_empresa,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_sucursal,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_linea,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".id_linea_marca,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".fecha_ultima_venta_hasta,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".codigo,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".nombre_unidad,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".cantidad_disponible,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".cantidad_fisica,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".codigo_producto,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".nombre,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".ingresos,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".egresos,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".existencia_corte,"+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME+".costo from "+ConteosFisicosConstantesFunciones.SCHEMA+"."+ConteosFisicosConstantesFunciones.TABLENAME;//+" as "+ConteosFisicosConstantesFunciones.TABLENAME;
	
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
    public static final String EXISTENCIACORTE= "existencia_corte";
    public static final String COSTO= "costo";
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
    	public static final String LABEL_EXISTENCIACORTE= "Existencia Corte";
		public static final String LABEL_EXISTENCIACORTE_LOWER= "Existencia Corte";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getConteosFisicosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDBODEGA)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDLINEA)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.CODIGO)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.CANTIDADFISICA)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_CANTIDADFISICA;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.NOMBRE)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.INGRESOS)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_INGRESOS;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.EGRESOS)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_EGRESOS;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.EXISTENCIACORTE)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_EXISTENCIACORTE;}
		if(sNombreColumna.equals(ConteosFisicosConstantesFunciones.COSTO)) {sLabelColumna=ConteosFisicosConstantesFunciones.LABEL_COSTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConteosFisicosDescripcion(ConteosFisicos conteosfisicos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(conteosfisicos !=null/* && conteosfisicos.getId()!=0*/) {
			sDescripcion=conteosfisicos.getcodigo();//conteosfisicosconteosfisicos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConteosFisicosDescripcionDetallado(ConteosFisicos conteosfisicos) {
		String sDescripcion="";
			
		sDescripcion+=ConteosFisicosConstantesFunciones.ID+"=";
		sDescripcion+=conteosfisicos.getId().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=conteosfisicos.getVersionRow().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=conteosfisicos.getid_bodega().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=conteosfisicos.getid_producto().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=conteosfisicos.getid_empresa().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=conteosfisicos.getid_sucursal().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=conteosfisicos.getid_linea().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=conteosfisicos.getid_linea_grupo().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=conteosfisicos.getid_linea_categoria().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=conteosfisicos.getid_linea_marca().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.FECHAULTIMAVENTAHASTA+"=";
		sDescripcion+=conteosfisicos.getfecha_ultima_venta_hasta().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.CODIGO+"=";
		sDescripcion+=conteosfisicos.getcodigo()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=conteosfisicos.getnombre_unidad()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=conteosfisicos.getcantidad_disponible().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.CANTIDADFISICA+"=";
		sDescripcion+=conteosfisicos.getcantidad_fisica().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=conteosfisicos.getcodigo_producto()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=conteosfisicos.getnombre()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.INGRESOS+"=";
		sDescripcion+=conteosfisicos.getingresos().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.EGRESOS+"=";
		sDescripcion+=conteosfisicos.getegresos().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.EXISTENCIACORTE+"=";
		sDescripcion+=conteosfisicos.getexistencia_corte().toString()+",";
		sDescripcion+=ConteosFisicosConstantesFunciones.COSTO+"=";
		sDescripcion+=conteosfisicos.getcosto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConteosFisicosDescripcion(ConteosFisicos conteosfisicos,String sValor) throws Exception {			
		if(conteosfisicos !=null) {
			conteosfisicos.setcodigo(sValor);;//conteosfisicosconteosfisicos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaConteosFisicos")) {
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

	public static String getDetalleIndiceBusquedaConteosFisicos(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosConteosFisicos(ConteosFisicos conteosfisicos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		conteosfisicos.setcodigo(conteosfisicos.getcodigo().trim());
		conteosfisicos.setnombre_unidad(conteosfisicos.getnombre_unidad().trim());
		conteosfisicos.setcodigo_producto(conteosfisicos.getcodigo_producto().trim());
		conteosfisicos.setnombre(conteosfisicos.getnombre().trim());
	}
	
	public static void quitarEspaciosConteosFisicoss(List<ConteosFisicos> conteosfisicoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConteosFisicos conteosfisicos: conteosfisicoss) {
			conteosfisicos.setcodigo(conteosfisicos.getcodigo().trim());
			conteosfisicos.setnombre_unidad(conteosfisicos.getnombre_unidad().trim());
			conteosfisicos.setcodigo_producto(conteosfisicos.getcodigo_producto().trim());
			conteosfisicos.setnombre(conteosfisicos.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConteosFisicos(ConteosFisicos conteosfisicos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && conteosfisicos.getConCambioAuxiliar()) {
			conteosfisicos.setIsDeleted(conteosfisicos.getIsDeletedAuxiliar());	
			conteosfisicos.setIsNew(conteosfisicos.getIsNewAuxiliar());	
			conteosfisicos.setIsChanged(conteosfisicos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			conteosfisicos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			conteosfisicos.setIsDeletedAuxiliar(false);	
			conteosfisicos.setIsNewAuxiliar(false);	
			conteosfisicos.setIsChangedAuxiliar(false);
			
			conteosfisicos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConteosFisicoss(List<ConteosFisicos> conteosfisicoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConteosFisicos conteosfisicos : conteosfisicoss) {
			if(conAsignarBase && conteosfisicos.getConCambioAuxiliar()) {
				conteosfisicos.setIsDeleted(conteosfisicos.getIsDeletedAuxiliar());	
				conteosfisicos.setIsNew(conteosfisicos.getIsNewAuxiliar());	
				conteosfisicos.setIsChanged(conteosfisicos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				conteosfisicos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				conteosfisicos.setIsDeletedAuxiliar(false);	
				conteosfisicos.setIsNewAuxiliar(false);	
				conteosfisicos.setIsChangedAuxiliar(false);
				
				conteosfisicos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConteosFisicos(ConteosFisicos conteosfisicos,Boolean conEnteros) throws Exception  {
		conteosfisicos.setingresos(0.0);
		conteosfisicos.setegresos(0.0);
		conteosfisicos.setexistencia_corte(0.0);
		conteosfisicos.setcosto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			conteosfisicos.setcantidad_disponible(0);
			conteosfisicos.setcantidad_fisica(0);
		}
	}		
	
	public static void InicializarValoresConteosFisicoss(List<ConteosFisicos> conteosfisicoss,Boolean conEnteros) throws Exception  {
		
		for(ConteosFisicos conteosfisicos: conteosfisicoss) {
			conteosfisicos.setingresos(0.0);
			conteosfisicos.setegresos(0.0);
			conteosfisicos.setexistencia_corte(0.0);
			conteosfisicos.setcosto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				conteosfisicos.setcantidad_disponible(0);
				conteosfisicos.setcantidad_fisica(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaConteosFisicos(List<ConteosFisicos> conteosfisicoss,ConteosFisicos conteosfisicosAux) throws Exception  {
		ConteosFisicosConstantesFunciones.InicializarValoresConteosFisicos(conteosfisicosAux,true);
		
		for(ConteosFisicos conteosfisicos: conteosfisicoss) {
			if(conteosfisicos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			conteosfisicosAux.setcantidad_disponible(conteosfisicosAux.getcantidad_disponible()+conteosfisicos.getcantidad_disponible());			
			conteosfisicosAux.setcantidad_fisica(conteosfisicosAux.getcantidad_fisica()+conteosfisicos.getcantidad_fisica());			
			conteosfisicosAux.setingresos(conteosfisicosAux.getingresos()+conteosfisicos.getingresos());			
			conteosfisicosAux.setegresos(conteosfisicosAux.getegresos()+conteosfisicos.getegresos());			
			conteosfisicosAux.setexistencia_corte(conteosfisicosAux.getexistencia_corte()+conteosfisicos.getexistencia_corte());			
			conteosfisicosAux.setcosto(conteosfisicosAux.getcosto()+conteosfisicos.getcosto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConteosFisicos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConteosFisicosConstantesFunciones.getArrayColumnasGlobalesConteosFisicos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConteosFisicos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConteosFisicosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConteosFisicosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConteosFisicosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConteosFisicosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConteosFisicos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConteosFisicos> conteosfisicoss,ConteosFisicos conteosfisicos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConteosFisicos conteosfisicosAux: conteosfisicoss) {
			if(conteosfisicosAux!=null && conteosfisicos!=null) {
				if((conteosfisicosAux.getId()==null && conteosfisicos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(conteosfisicosAux.getId()!=null && conteosfisicos.getId()!=null){
					if(conteosfisicosAux.getId().equals(conteosfisicos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConteosFisicos(List<ConteosFisicos> conteosfisicoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ingresosTotal=0.0;
		Double egresosTotal=0.0;
		Double existencia_corteTotal=0.0;
		Double costoTotal=0.0;
	
		for(ConteosFisicos conteosfisicos: conteosfisicoss) {			
			if(conteosfisicos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ingresosTotal+=conteosfisicos.getingresos();
			egresosTotal+=conteosfisicos.getegresos();
			existencia_corteTotal+=conteosfisicos.getexistencia_corte();
			costoTotal+=conteosfisicos.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConteosFisicosConstantesFunciones.INGRESOS);
		datoGeneral.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_INGRESOS);
		datoGeneral.setdValorDouble(ingresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConteosFisicosConstantesFunciones.EGRESOS);
		datoGeneral.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_EGRESOS);
		datoGeneral.setdValorDouble(egresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConteosFisicosConstantesFunciones.EXISTENCIACORTE);
		datoGeneral.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_EXISTENCIACORTE);
		datoGeneral.setdValorDouble(existencia_corteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConteosFisicosConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConteosFisicos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_ID, ConteosFisicosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_VERSIONROW, ConteosFisicosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_CODIGO, ConteosFisicosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_NOMBREUNIDAD, ConteosFisicosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_CANTIDADDISPONIBLE, ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_CANTIDADFISICA, ConteosFisicosConstantesFunciones.CANTIDADFISICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_CODIGOPRODUCTO, ConteosFisicosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_NOMBRE, ConteosFisicosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_INGRESOS, ConteosFisicosConstantesFunciones.INGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_EGRESOS, ConteosFisicosConstantesFunciones.EGRESOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_EXISTENCIACORTE, ConteosFisicosConstantesFunciones.EXISTENCIACORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConteosFisicosConstantesFunciones.LABEL_COSTO, ConteosFisicosConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConteosFisicos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.CANTIDADFISICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.INGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.EGRESOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.EXISTENCIACORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConteosFisicosConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConteosFisicos() throws Exception  {
		return ConteosFisicosConstantesFunciones.getTiposSeleccionarConteosFisicos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConteosFisicos(Boolean conFk) throws Exception  {
		return ConteosFisicosConstantesFunciones.getTiposSeleccionarConteosFisicos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConteosFisicos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_CANTIDADFISICA);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_CANTIDADFISICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_INGRESOS);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_INGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_EGRESOS);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_EGRESOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_EXISTENCIACORTE);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_EXISTENCIACORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConteosFisicosConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(ConteosFisicosConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConteosFisicos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConteosFisicos(ConteosFisicos conteosfisicosAux) throws Exception {
		
			conteosfisicosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(conteosfisicosAux.getBodega()));
			conteosfisicosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(conteosfisicosAux.getProducto()));
			conteosfisicosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conteosfisicosAux.getEmpresa()));
			conteosfisicosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(conteosfisicosAux.getSucursal()));
			conteosfisicosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLinea()));
			conteosfisicosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLineaGrupo()));
			conteosfisicosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLineaCategoria()));
			conteosfisicosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConteosFisicos(List<ConteosFisicos> conteosfisicossTemp) throws Exception {
		for(ConteosFisicos conteosfisicosAux:conteosfisicossTemp) {
			
			conteosfisicosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(conteosfisicosAux.getBodega()));
			conteosfisicosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(conteosfisicosAux.getProducto()));
			conteosfisicosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(conteosfisicosAux.getEmpresa()));
			conteosfisicosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(conteosfisicosAux.getSucursal()));
			conteosfisicosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLinea()));
			conteosfisicosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLineaGrupo()));
			conteosfisicosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLineaCategoria()));
			conteosfisicosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(conteosfisicosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConteosFisicos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConteosFisicos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConteosFisicos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConteosFisicosConstantesFunciones.getClassesRelationshipsOfConteosFisicos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConteosFisicos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConteosFisicos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConteosFisicosConstantesFunciones.getClassesRelationshipsFromStringsOfConteosFisicos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConteosFisicos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConteosFisicos conteosfisicos,List<ConteosFisicos> conteosfisicoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ConteosFisicos conteosfisicos,List<ConteosFisicos> conteosfisicoss) throws Exception {
		try	{			
			for(ConteosFisicos conteosfisicosLocal:conteosfisicoss) {
				if(conteosfisicosLocal.getId().equals(conteosfisicos.getId())) {
					conteosfisicosLocal.setIsSelected(conteosfisicos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConteosFisicos(List<ConteosFisicos> conteosfisicossAux) throws Exception {
		//this.conteosfisicossAux=conteosfisicossAux;
		
		for(ConteosFisicos conteosfisicosAux:conteosfisicossAux) {
			if(conteosfisicosAux.getIsChanged()) {
				conteosfisicosAux.setIsChanged(false);
			}		
			
			if(conteosfisicosAux.getIsNew()) {
				conteosfisicosAux.setIsNew(false);
			}	
			
			if(conteosfisicosAux.getIsDeleted()) {
				conteosfisicosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConteosFisicos(ConteosFisicos conteosfisicosAux) throws Exception {
		//this.conteosfisicosAux=conteosfisicosAux;
		
			if(conteosfisicosAux.getIsChanged()) {
				conteosfisicosAux.setIsChanged(false);
			}		
			
			if(conteosfisicosAux.getIsNew()) {
				conteosfisicosAux.setIsNew(false);
			}	
			
			if(conteosfisicosAux.getIsDeleted()) {
				conteosfisicosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConteosFisicos conteosfisicosAsignar,ConteosFisicos conteosfisicos) throws Exception {
		conteosfisicosAsignar.setId(conteosfisicos.getId());	
		conteosfisicosAsignar.setVersionRow(conteosfisicos.getVersionRow());	
		conteosfisicosAsignar.setcodigo(conteosfisicos.getcodigo());	
		conteosfisicosAsignar.setnombre_unidad(conteosfisicos.getnombre_unidad());	
		conteosfisicosAsignar.setcantidad_disponible(conteosfisicos.getcantidad_disponible());	
		conteosfisicosAsignar.setcantidad_fisica(conteosfisicos.getcantidad_fisica());	
		conteosfisicosAsignar.setcodigo_producto(conteosfisicos.getcodigo_producto());	
		conteosfisicosAsignar.setnombre(conteosfisicos.getnombre());	
		conteosfisicosAsignar.setingresos(conteosfisicos.getingresos());	
		conteosfisicosAsignar.setegresos(conteosfisicos.getegresos());	
		conteosfisicosAsignar.setexistencia_corte(conteosfisicos.getexistencia_corte());	
		conteosfisicosAsignar.setcosto(conteosfisicos.getcosto());	
	}
	
	public static void inicializarConteosFisicos(ConteosFisicos conteosfisicos) throws Exception {
		try {
				conteosfisicos.setId(0L);	
					
				conteosfisicos.setcodigo("");	
				conteosfisicos.setnombre_unidad("");	
				conteosfisicos.setcantidad_disponible(0);	
				conteosfisicos.setcantidad_fisica(0);	
				conteosfisicos.setcodigo_producto("");	
				conteosfisicos.setnombre("");	
				conteosfisicos.setingresos(0.0);	
				conteosfisicos.setegresos(0.0);	
				conteosfisicos.setexistencia_corte(0.0);	
				conteosfisicos.setcosto(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConteosFisicos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_CANTIDADFISICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_INGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_EGRESOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_EXISTENCIACORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConteosFisicosConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConteosFisicos(String sTipo,Row row,Workbook workbook,ConteosFisicos conteosfisicos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getfecha_ultima_venta_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getcantidad_fisica());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getingresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getegresos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getexistencia_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(conteosfisicos.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConteosFisicos="";
	
	public String getsFinalQueryConteosFisicos() {
		return this.sFinalQueryConteosFisicos;
	}
	
	public void setsFinalQueryConteosFisicos(String sFinalQueryConteosFisicos) {
		this.sFinalQueryConteosFisicos= sFinalQueryConteosFisicos;
	}
	
	public Border resaltarSeleccionarConteosFisicos=null;
	
	public Border setResaltarSeleccionarConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConteosFisicos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConteosFisicos() {
		return this.resaltarSeleccionarConteosFisicos;
	}
	
	public void setResaltarSeleccionarConteosFisicos(Border borderResaltarSeleccionarConteosFisicos) {
		this.resaltarSeleccionarConteosFisicos= borderResaltarSeleccionarConteosFisicos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConteosFisicos=null;
	public Boolean mostraridConteosFisicos=true;
	public Boolean activaridConteosFisicos=true;

	public Border resaltarid_bodegaConteosFisicos=null;
	public Boolean mostrarid_bodegaConteosFisicos=true;
	public Boolean activarid_bodegaConteosFisicos=true;
	public Boolean cargarid_bodegaConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaConteosFisicos=false;//ConEventDepend=true

	public Border resaltarid_productoConteosFisicos=null;
	public Boolean mostrarid_productoConteosFisicos=true;
	public Boolean activarid_productoConteosFisicos=true;
	public Boolean cargarid_productoConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoConteosFisicos=false;//ConEventDepend=true

	public Border resaltarid_empresaConteosFisicos=null;
	public Boolean mostrarid_empresaConteosFisicos=true;
	public Boolean activarid_empresaConteosFisicos=true;
	public Boolean cargarid_empresaConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConteosFisicos=false;//ConEventDepend=true

	public Border resaltarid_sucursalConteosFisicos=null;
	public Boolean mostrarid_sucursalConteosFisicos=true;
	public Boolean activarid_sucursalConteosFisicos=true;
	public Boolean cargarid_sucursalConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalConteosFisicos=false;//ConEventDepend=true

	public Border resaltarid_lineaConteosFisicos=null;
	public Boolean mostrarid_lineaConteosFisicos=true;
	public Boolean activarid_lineaConteosFisicos=true;
	public Boolean cargarid_lineaConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaConteosFisicos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoConteosFisicos=null;
	public Boolean mostrarid_linea_grupoConteosFisicos=true;
	public Boolean activarid_linea_grupoConteosFisicos=true;
	public Boolean cargarid_linea_grupoConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoConteosFisicos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaConteosFisicos=null;
	public Boolean mostrarid_linea_categoriaConteosFisicos=true;
	public Boolean activarid_linea_categoriaConteosFisicos=true;
	public Boolean cargarid_linea_categoriaConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaConteosFisicos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaConteosFisicos=null;
	public Boolean mostrarid_linea_marcaConteosFisicos=true;
	public Boolean activarid_linea_marcaConteosFisicos=true;
	public Boolean cargarid_linea_marcaConteosFisicos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaConteosFisicos=false;//ConEventDepend=true

	public Border resaltarfecha_ultima_venta_hastaConteosFisicos=null;
	public Boolean mostrarfecha_ultima_venta_hastaConteosFisicos=true;
	public Boolean activarfecha_ultima_venta_hastaConteosFisicos=true;

	public Border resaltarcodigoConteosFisicos=null;
	public Boolean mostrarcodigoConteosFisicos=true;
	public Boolean activarcodigoConteosFisicos=true;

	public Border resaltarnombre_unidadConteosFisicos=null;
	public Boolean mostrarnombre_unidadConteosFisicos=true;
	public Boolean activarnombre_unidadConteosFisicos=true;

	public Border resaltarcantidad_disponibleConteosFisicos=null;
	public Boolean mostrarcantidad_disponibleConteosFisicos=true;
	public Boolean activarcantidad_disponibleConteosFisicos=true;

	public Border resaltarcantidad_fisicaConteosFisicos=null;
	public Boolean mostrarcantidad_fisicaConteosFisicos=true;
	public Boolean activarcantidad_fisicaConteosFisicos=true;

	public Border resaltarcodigo_productoConteosFisicos=null;
	public Boolean mostrarcodigo_productoConteosFisicos=true;
	public Boolean activarcodigo_productoConteosFisicos=true;

	public Border resaltarnombreConteosFisicos=null;
	public Boolean mostrarnombreConteosFisicos=true;
	public Boolean activarnombreConteosFisicos=true;

	public Border resaltaringresosConteosFisicos=null;
	public Boolean mostraringresosConteosFisicos=true;
	public Boolean activaringresosConteosFisicos=true;

	public Border resaltaregresosConteosFisicos=null;
	public Boolean mostraregresosConteosFisicos=true;
	public Boolean activaregresosConteosFisicos=true;

	public Border resaltarexistencia_corteConteosFisicos=null;
	public Boolean mostrarexistencia_corteConteosFisicos=true;
	public Boolean activarexistencia_corteConteosFisicos=true;

	public Border resaltarcostoConteosFisicos=null;
	public Boolean mostrarcostoConteosFisicos=true;
	public Boolean activarcostoConteosFisicos=true;

	
	

	public Border setResaltaridConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltaridConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConteosFisicos() {
		return this.resaltaridConteosFisicos;
	}

	public void setResaltaridConteosFisicos(Border borderResaltar) {
		this.resaltaridConteosFisicos= borderResaltar;
	}

	public Boolean getMostraridConteosFisicos() {
		return this.mostraridConteosFisicos;
	}

	public void setMostraridConteosFisicos(Boolean mostraridConteosFisicos) {
		this.mostraridConteosFisicos= mostraridConteosFisicos;
	}

	public Boolean getActivaridConteosFisicos() {
		return this.activaridConteosFisicos;
	}

	public void setActivaridConteosFisicos(Boolean activaridConteosFisicos) {
		this.activaridConteosFisicos= activaridConteosFisicos;
	}

	public Border setResaltarid_bodegaConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaConteosFisicos() {
		return this.resaltarid_bodegaConteosFisicos;
	}

	public void setResaltarid_bodegaConteosFisicos(Border borderResaltar) {
		this.resaltarid_bodegaConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaConteosFisicos() {
		return this.mostrarid_bodegaConteosFisicos;
	}

	public void setMostrarid_bodegaConteosFisicos(Boolean mostrarid_bodegaConteosFisicos) {
		this.mostrarid_bodegaConteosFisicos= mostrarid_bodegaConteosFisicos;
	}

	public Boolean getActivarid_bodegaConteosFisicos() {
		return this.activarid_bodegaConteosFisicos;
	}

	public void setActivarid_bodegaConteosFisicos(Boolean activarid_bodegaConteosFisicos) {
		this.activarid_bodegaConteosFisicos= activarid_bodegaConteosFisicos;
	}

	public Boolean getCargarid_bodegaConteosFisicos() {
		return this.cargarid_bodegaConteosFisicos;
	}

	public void setCargarid_bodegaConteosFisicos(Boolean cargarid_bodegaConteosFisicos) {
		this.cargarid_bodegaConteosFisicos= cargarid_bodegaConteosFisicos;
	}

	public Border setResaltarid_productoConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_productoConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoConteosFisicos() {
		return this.resaltarid_productoConteosFisicos;
	}

	public void setResaltarid_productoConteosFisicos(Border borderResaltar) {
		this.resaltarid_productoConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_productoConteosFisicos() {
		return this.mostrarid_productoConteosFisicos;
	}

	public void setMostrarid_productoConteosFisicos(Boolean mostrarid_productoConteosFisicos) {
		this.mostrarid_productoConteosFisicos= mostrarid_productoConteosFisicos;
	}

	public Boolean getActivarid_productoConteosFisicos() {
		return this.activarid_productoConteosFisicos;
	}

	public void setActivarid_productoConteosFisicos(Boolean activarid_productoConteosFisicos) {
		this.activarid_productoConteosFisicos= activarid_productoConteosFisicos;
	}

	public Boolean getCargarid_productoConteosFisicos() {
		return this.cargarid_productoConteosFisicos;
	}

	public void setCargarid_productoConteosFisicos(Boolean cargarid_productoConteosFisicos) {
		this.cargarid_productoConteosFisicos= cargarid_productoConteosFisicos;
	}

	public Border setResaltarid_empresaConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_empresaConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConteosFisicos() {
		return this.resaltarid_empresaConteosFisicos;
	}

	public void setResaltarid_empresaConteosFisicos(Border borderResaltar) {
		this.resaltarid_empresaConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_empresaConteosFisicos() {
		return this.mostrarid_empresaConteosFisicos;
	}

	public void setMostrarid_empresaConteosFisicos(Boolean mostrarid_empresaConteosFisicos) {
		this.mostrarid_empresaConteosFisicos= mostrarid_empresaConteosFisicos;
	}

	public Boolean getActivarid_empresaConteosFisicos() {
		return this.activarid_empresaConteosFisicos;
	}

	public void setActivarid_empresaConteosFisicos(Boolean activarid_empresaConteosFisicos) {
		this.activarid_empresaConteosFisicos= activarid_empresaConteosFisicos;
	}

	public Boolean getCargarid_empresaConteosFisicos() {
		return this.cargarid_empresaConteosFisicos;
	}

	public void setCargarid_empresaConteosFisicos(Boolean cargarid_empresaConteosFisicos) {
		this.cargarid_empresaConteosFisicos= cargarid_empresaConteosFisicos;
	}

	public Border setResaltarid_sucursalConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalConteosFisicos() {
		return this.resaltarid_sucursalConteosFisicos;
	}

	public void setResaltarid_sucursalConteosFisicos(Border borderResaltar) {
		this.resaltarid_sucursalConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalConteosFisicos() {
		return this.mostrarid_sucursalConteosFisicos;
	}

	public void setMostrarid_sucursalConteosFisicos(Boolean mostrarid_sucursalConteosFisicos) {
		this.mostrarid_sucursalConteosFisicos= mostrarid_sucursalConteosFisicos;
	}

	public Boolean getActivarid_sucursalConteosFisicos() {
		return this.activarid_sucursalConteosFisicos;
	}

	public void setActivarid_sucursalConteosFisicos(Boolean activarid_sucursalConteosFisicos) {
		this.activarid_sucursalConteosFisicos= activarid_sucursalConteosFisicos;
	}

	public Boolean getCargarid_sucursalConteosFisicos() {
		return this.cargarid_sucursalConteosFisicos;
	}

	public void setCargarid_sucursalConteosFisicos(Boolean cargarid_sucursalConteosFisicos) {
		this.cargarid_sucursalConteosFisicos= cargarid_sucursalConteosFisicos;
	}

	public Border setResaltarid_lineaConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_lineaConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaConteosFisicos() {
		return this.resaltarid_lineaConteosFisicos;
	}

	public void setResaltarid_lineaConteosFisicos(Border borderResaltar) {
		this.resaltarid_lineaConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_lineaConteosFisicos() {
		return this.mostrarid_lineaConteosFisicos;
	}

	public void setMostrarid_lineaConteosFisicos(Boolean mostrarid_lineaConteosFisicos) {
		this.mostrarid_lineaConteosFisicos= mostrarid_lineaConteosFisicos;
	}

	public Boolean getActivarid_lineaConteosFisicos() {
		return this.activarid_lineaConteosFisicos;
	}

	public void setActivarid_lineaConteosFisicos(Boolean activarid_lineaConteosFisicos) {
		this.activarid_lineaConteosFisicos= activarid_lineaConteosFisicos;
	}

	public Boolean getCargarid_lineaConteosFisicos() {
		return this.cargarid_lineaConteosFisicos;
	}

	public void setCargarid_lineaConteosFisicos(Boolean cargarid_lineaConteosFisicos) {
		this.cargarid_lineaConteosFisicos= cargarid_lineaConteosFisicos;
	}

	public Border setResaltarid_linea_grupoConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoConteosFisicos() {
		return this.resaltarid_linea_grupoConteosFisicos;
	}

	public void setResaltarid_linea_grupoConteosFisicos(Border borderResaltar) {
		this.resaltarid_linea_grupoConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoConteosFisicos() {
		return this.mostrarid_linea_grupoConteosFisicos;
	}

	public void setMostrarid_linea_grupoConteosFisicos(Boolean mostrarid_linea_grupoConteosFisicos) {
		this.mostrarid_linea_grupoConteosFisicos= mostrarid_linea_grupoConteosFisicos;
	}

	public Boolean getActivarid_linea_grupoConteosFisicos() {
		return this.activarid_linea_grupoConteosFisicos;
	}

	public void setActivarid_linea_grupoConteosFisicos(Boolean activarid_linea_grupoConteosFisicos) {
		this.activarid_linea_grupoConteosFisicos= activarid_linea_grupoConteosFisicos;
	}

	public Boolean getCargarid_linea_grupoConteosFisicos() {
		return this.cargarid_linea_grupoConteosFisicos;
	}

	public void setCargarid_linea_grupoConteosFisicos(Boolean cargarid_linea_grupoConteosFisicos) {
		this.cargarid_linea_grupoConteosFisicos= cargarid_linea_grupoConteosFisicos;
	}

	public Border setResaltarid_linea_categoriaConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaConteosFisicos() {
		return this.resaltarid_linea_categoriaConteosFisicos;
	}

	public void setResaltarid_linea_categoriaConteosFisicos(Border borderResaltar) {
		this.resaltarid_linea_categoriaConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaConteosFisicos() {
		return this.mostrarid_linea_categoriaConteosFisicos;
	}

	public void setMostrarid_linea_categoriaConteosFisicos(Boolean mostrarid_linea_categoriaConteosFisicos) {
		this.mostrarid_linea_categoriaConteosFisicos= mostrarid_linea_categoriaConteosFisicos;
	}

	public Boolean getActivarid_linea_categoriaConteosFisicos() {
		return this.activarid_linea_categoriaConteosFisicos;
	}

	public void setActivarid_linea_categoriaConteosFisicos(Boolean activarid_linea_categoriaConteosFisicos) {
		this.activarid_linea_categoriaConteosFisicos= activarid_linea_categoriaConteosFisicos;
	}

	public Boolean getCargarid_linea_categoriaConteosFisicos() {
		return this.cargarid_linea_categoriaConteosFisicos;
	}

	public void setCargarid_linea_categoriaConteosFisicos(Boolean cargarid_linea_categoriaConteosFisicos) {
		this.cargarid_linea_categoriaConteosFisicos= cargarid_linea_categoriaConteosFisicos;
	}

	public Border setResaltarid_linea_marcaConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaConteosFisicos() {
		return this.resaltarid_linea_marcaConteosFisicos;
	}

	public void setResaltarid_linea_marcaConteosFisicos(Border borderResaltar) {
		this.resaltarid_linea_marcaConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaConteosFisicos() {
		return this.mostrarid_linea_marcaConteosFisicos;
	}

	public void setMostrarid_linea_marcaConteosFisicos(Boolean mostrarid_linea_marcaConteosFisicos) {
		this.mostrarid_linea_marcaConteosFisicos= mostrarid_linea_marcaConteosFisicos;
	}

	public Boolean getActivarid_linea_marcaConteosFisicos() {
		return this.activarid_linea_marcaConteosFisicos;
	}

	public void setActivarid_linea_marcaConteosFisicos(Boolean activarid_linea_marcaConteosFisicos) {
		this.activarid_linea_marcaConteosFisicos= activarid_linea_marcaConteosFisicos;
	}

	public Boolean getCargarid_linea_marcaConteosFisicos() {
		return this.cargarid_linea_marcaConteosFisicos;
	}

	public void setCargarid_linea_marcaConteosFisicos(Boolean cargarid_linea_marcaConteosFisicos) {
		this.cargarid_linea_marcaConteosFisicos= cargarid_linea_marcaConteosFisicos;
	}

	public Border setResaltarfecha_ultima_venta_hastaConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_venta_hastaConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_venta_hastaConteosFisicos() {
		return this.resaltarfecha_ultima_venta_hastaConteosFisicos;
	}

	public void setResaltarfecha_ultima_venta_hastaConteosFisicos(Border borderResaltar) {
		this.resaltarfecha_ultima_venta_hastaConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_venta_hastaConteosFisicos() {
		return this.mostrarfecha_ultima_venta_hastaConteosFisicos;
	}

	public void setMostrarfecha_ultima_venta_hastaConteosFisicos(Boolean mostrarfecha_ultima_venta_hastaConteosFisicos) {
		this.mostrarfecha_ultima_venta_hastaConteosFisicos= mostrarfecha_ultima_venta_hastaConteosFisicos;
	}

	public Boolean getActivarfecha_ultima_venta_hastaConteosFisicos() {
		return this.activarfecha_ultima_venta_hastaConteosFisicos;
	}

	public void setActivarfecha_ultima_venta_hastaConteosFisicos(Boolean activarfecha_ultima_venta_hastaConteosFisicos) {
		this.activarfecha_ultima_venta_hastaConteosFisicos= activarfecha_ultima_venta_hastaConteosFisicos;
	}

	public Border setResaltarcodigoConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarcodigoConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoConteosFisicos() {
		return this.resaltarcodigoConteosFisicos;
	}

	public void setResaltarcodigoConteosFisicos(Border borderResaltar) {
		this.resaltarcodigoConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarcodigoConteosFisicos() {
		return this.mostrarcodigoConteosFisicos;
	}

	public void setMostrarcodigoConteosFisicos(Boolean mostrarcodigoConteosFisicos) {
		this.mostrarcodigoConteosFisicos= mostrarcodigoConteosFisicos;
	}

	public Boolean getActivarcodigoConteosFisicos() {
		return this.activarcodigoConteosFisicos;
	}

	public void setActivarcodigoConteosFisicos(Boolean activarcodigoConteosFisicos) {
		this.activarcodigoConteosFisicos= activarcodigoConteosFisicos;
	}

	public Border setResaltarnombre_unidadConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadConteosFisicos() {
		return this.resaltarnombre_unidadConteosFisicos;
	}

	public void setResaltarnombre_unidadConteosFisicos(Border borderResaltar) {
		this.resaltarnombre_unidadConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadConteosFisicos() {
		return this.mostrarnombre_unidadConteosFisicos;
	}

	public void setMostrarnombre_unidadConteosFisicos(Boolean mostrarnombre_unidadConteosFisicos) {
		this.mostrarnombre_unidadConteosFisicos= mostrarnombre_unidadConteosFisicos;
	}

	public Boolean getActivarnombre_unidadConteosFisicos() {
		return this.activarnombre_unidadConteosFisicos;
	}

	public void setActivarnombre_unidadConteosFisicos(Boolean activarnombre_unidadConteosFisicos) {
		this.activarnombre_unidadConteosFisicos= activarnombre_unidadConteosFisicos;
	}

	public Border setResaltarcantidad_disponibleConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleConteosFisicos() {
		return this.resaltarcantidad_disponibleConteosFisicos;
	}

	public void setResaltarcantidad_disponibleConteosFisicos(Border borderResaltar) {
		this.resaltarcantidad_disponibleConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleConteosFisicos() {
		return this.mostrarcantidad_disponibleConteosFisicos;
	}

	public void setMostrarcantidad_disponibleConteosFisicos(Boolean mostrarcantidad_disponibleConteosFisicos) {
		this.mostrarcantidad_disponibleConteosFisicos= mostrarcantidad_disponibleConteosFisicos;
	}

	public Boolean getActivarcantidad_disponibleConteosFisicos() {
		return this.activarcantidad_disponibleConteosFisicos;
	}

	public void setActivarcantidad_disponibleConteosFisicos(Boolean activarcantidad_disponibleConteosFisicos) {
		this.activarcantidad_disponibleConteosFisicos= activarcantidad_disponibleConteosFisicos;
	}

	public Border setResaltarcantidad_fisicaConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarcantidad_fisicaConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_fisicaConteosFisicos() {
		return this.resaltarcantidad_fisicaConteosFisicos;
	}

	public void setResaltarcantidad_fisicaConteosFisicos(Border borderResaltar) {
		this.resaltarcantidad_fisicaConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarcantidad_fisicaConteosFisicos() {
		return this.mostrarcantidad_fisicaConteosFisicos;
	}

	public void setMostrarcantidad_fisicaConteosFisicos(Boolean mostrarcantidad_fisicaConteosFisicos) {
		this.mostrarcantidad_fisicaConteosFisicos= mostrarcantidad_fisicaConteosFisicos;
	}

	public Boolean getActivarcantidad_fisicaConteosFisicos() {
		return this.activarcantidad_fisicaConteosFisicos;
	}

	public void setActivarcantidad_fisicaConteosFisicos(Boolean activarcantidad_fisicaConteosFisicos) {
		this.activarcantidad_fisicaConteosFisicos= activarcantidad_fisicaConteosFisicos;
	}

	public Border setResaltarcodigo_productoConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoConteosFisicos() {
		return this.resaltarcodigo_productoConteosFisicos;
	}

	public void setResaltarcodigo_productoConteosFisicos(Border borderResaltar) {
		this.resaltarcodigo_productoConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoConteosFisicos() {
		return this.mostrarcodigo_productoConteosFisicos;
	}

	public void setMostrarcodigo_productoConteosFisicos(Boolean mostrarcodigo_productoConteosFisicos) {
		this.mostrarcodigo_productoConteosFisicos= mostrarcodigo_productoConteosFisicos;
	}

	public Boolean getActivarcodigo_productoConteosFisicos() {
		return this.activarcodigo_productoConteosFisicos;
	}

	public void setActivarcodigo_productoConteosFisicos(Boolean activarcodigo_productoConteosFisicos) {
		this.activarcodigo_productoConteosFisicos= activarcodigo_productoConteosFisicos;
	}

	public Border setResaltarnombreConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarnombreConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreConteosFisicos() {
		return this.resaltarnombreConteosFisicos;
	}

	public void setResaltarnombreConteosFisicos(Border borderResaltar) {
		this.resaltarnombreConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarnombreConteosFisicos() {
		return this.mostrarnombreConteosFisicos;
	}

	public void setMostrarnombreConteosFisicos(Boolean mostrarnombreConteosFisicos) {
		this.mostrarnombreConteosFisicos= mostrarnombreConteosFisicos;
	}

	public Boolean getActivarnombreConteosFisicos() {
		return this.activarnombreConteosFisicos;
	}

	public void setActivarnombreConteosFisicos(Boolean activarnombreConteosFisicos) {
		this.activarnombreConteosFisicos= activarnombreConteosFisicos;
	}

	public Border setResaltaringresosConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltaringresosConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringresosConteosFisicos() {
		return this.resaltaringresosConteosFisicos;
	}

	public void setResaltaringresosConteosFisicos(Border borderResaltar) {
		this.resaltaringresosConteosFisicos= borderResaltar;
	}

	public Boolean getMostraringresosConteosFisicos() {
		return this.mostraringresosConteosFisicos;
	}

	public void setMostraringresosConteosFisicos(Boolean mostraringresosConteosFisicos) {
		this.mostraringresosConteosFisicos= mostraringresosConteosFisicos;
	}

	public Boolean getActivaringresosConteosFisicos() {
		return this.activaringresosConteosFisicos;
	}

	public void setActivaringresosConteosFisicos(Boolean activaringresosConteosFisicos) {
		this.activaringresosConteosFisicos= activaringresosConteosFisicos;
	}

	public Border setResaltaregresosConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltaregresosConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaregresosConteosFisicos() {
		return this.resaltaregresosConteosFisicos;
	}

	public void setResaltaregresosConteosFisicos(Border borderResaltar) {
		this.resaltaregresosConteosFisicos= borderResaltar;
	}

	public Boolean getMostraregresosConteosFisicos() {
		return this.mostraregresosConteosFisicos;
	}

	public void setMostraregresosConteosFisicos(Boolean mostraregresosConteosFisicos) {
		this.mostraregresosConteosFisicos= mostraregresosConteosFisicos;
	}

	public Boolean getActivaregresosConteosFisicos() {
		return this.activaregresosConteosFisicos;
	}

	public void setActivaregresosConteosFisicos(Boolean activaregresosConteosFisicos) {
		this.activaregresosConteosFisicos= activaregresosConteosFisicos;
	}

	public Border setResaltarexistencia_corteConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarexistencia_corteConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarexistencia_corteConteosFisicos() {
		return this.resaltarexistencia_corteConteosFisicos;
	}

	public void setResaltarexistencia_corteConteosFisicos(Border borderResaltar) {
		this.resaltarexistencia_corteConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarexistencia_corteConteosFisicos() {
		return this.mostrarexistencia_corteConteosFisicos;
	}

	public void setMostrarexistencia_corteConteosFisicos(Boolean mostrarexistencia_corteConteosFisicos) {
		this.mostrarexistencia_corteConteosFisicos= mostrarexistencia_corteConteosFisicos;
	}

	public Boolean getActivarexistencia_corteConteosFisicos() {
		return this.activarexistencia_corteConteosFisicos;
	}

	public void setActivarexistencia_corteConteosFisicos(Boolean activarexistencia_corteConteosFisicos) {
		this.activarexistencia_corteConteosFisicos= activarexistencia_corteConteosFisicos;
	}

	public Border setResaltarcostoConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//conteosfisicosBeanSwingJInternalFrame.jTtoolBarConteosFisicos.setBorder(borderResaltar);
		
		this.resaltarcostoConteosFisicos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoConteosFisicos() {
		return this.resaltarcostoConteosFisicos;
	}

	public void setResaltarcostoConteosFisicos(Border borderResaltar) {
		this.resaltarcostoConteosFisicos= borderResaltar;
	}

	public Boolean getMostrarcostoConteosFisicos() {
		return this.mostrarcostoConteosFisicos;
	}

	public void setMostrarcostoConteosFisicos(Boolean mostrarcostoConteosFisicos) {
		this.mostrarcostoConteosFisicos= mostrarcostoConteosFisicos;
	}

	public Boolean getActivarcostoConteosFisicos() {
		return this.activarcostoConteosFisicos;
	}

	public void setActivarcostoConteosFisicos(Boolean activarcostoConteosFisicos) {
		this.activarcostoConteosFisicos= activarcostoConteosFisicos;
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
		
		
		this.setMostraridConteosFisicos(esInicial);
		this.setMostrarid_bodegaConteosFisicos(esInicial);
		this.setMostrarid_productoConteosFisicos(esInicial);
		this.setMostrarid_empresaConteosFisicos(esInicial);
		this.setMostrarid_sucursalConteosFisicos(esInicial);
		this.setMostrarid_lineaConteosFisicos(esInicial);
		this.setMostrarid_linea_grupoConteosFisicos(esInicial);
		this.setMostrarid_linea_categoriaConteosFisicos(esInicial);
		this.setMostrarid_linea_marcaConteosFisicos(esInicial);
		this.setMostrarfecha_ultima_venta_hastaConteosFisicos(esInicial);
		this.setMostrarcodigoConteosFisicos(esInicial);
		this.setMostrarnombre_unidadConteosFisicos(esInicial);
		this.setMostrarcantidad_disponibleConteosFisicos(esInicial);
		this.setMostrarcantidad_fisicaConteosFisicos(esInicial);
		this.setMostrarcodigo_productoConteosFisicos(esInicial);
		this.setMostrarnombreConteosFisicos(esInicial);
		this.setMostraringresosConteosFisicos(esInicial);
		this.setMostraregresosConteosFisicos(esInicial);
		this.setMostrarexistencia_corteConteosFisicos(esInicial);
		this.setMostrarcostoConteosFisicos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.ID)) {
				this.setMostraridConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setMostrarfecha_ultima_venta_hastaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CANTIDADFISICA)) {
				this.setMostrarcantidad_fisicaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.INGRESOS)) {
				this.setMostraringresosConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.EGRESOS)) {
				this.setMostraregresosConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.EXISTENCIACORTE)) {
				this.setMostrarexistencia_corteConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.COSTO)) {
				this.setMostrarcostoConteosFisicos(esAsigna);
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
		
		
		this.setActivaridConteosFisicos(esInicial);
		this.setActivarid_bodegaConteosFisicos(esInicial);
		this.setActivarid_productoConteosFisicos(esInicial);
		this.setActivarid_empresaConteosFisicos(esInicial);
		this.setActivarid_sucursalConteosFisicos(esInicial);
		this.setActivarid_lineaConteosFisicos(esInicial);
		this.setActivarid_linea_grupoConteosFisicos(esInicial);
		this.setActivarid_linea_categoriaConteosFisicos(esInicial);
		this.setActivarid_linea_marcaConteosFisicos(esInicial);
		this.setActivarfecha_ultima_venta_hastaConteosFisicos(esInicial);
		this.setActivarcodigoConteosFisicos(esInicial);
		this.setActivarnombre_unidadConteosFisicos(esInicial);
		this.setActivarcantidad_disponibleConteosFisicos(esInicial);
		this.setActivarcantidad_fisicaConteosFisicos(esInicial);
		this.setActivarcodigo_productoConteosFisicos(esInicial);
		this.setActivarnombreConteosFisicos(esInicial);
		this.setActivaringresosConteosFisicos(esInicial);
		this.setActivaregresosConteosFisicos(esInicial);
		this.setActivarexistencia_corteConteosFisicos(esInicial);
		this.setActivarcostoConteosFisicos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.ID)) {
				this.setActivaridConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setActivarfecha_ultima_venta_hastaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CANTIDADFISICA)) {
				this.setActivarcantidad_fisicaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.INGRESOS)) {
				this.setActivaringresosConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.EGRESOS)) {
				this.setActivaregresosConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.EXISTENCIACORTE)) {
				this.setActivarexistencia_corteConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.COSTO)) {
				this.setActivarcostoConteosFisicos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConteosFisicos(esInicial);
		this.setResaltarid_bodegaConteosFisicos(esInicial);
		this.setResaltarid_productoConteosFisicos(esInicial);
		this.setResaltarid_empresaConteosFisicos(esInicial);
		this.setResaltarid_sucursalConteosFisicos(esInicial);
		this.setResaltarid_lineaConteosFisicos(esInicial);
		this.setResaltarid_linea_grupoConteosFisicos(esInicial);
		this.setResaltarid_linea_categoriaConteosFisicos(esInicial);
		this.setResaltarid_linea_marcaConteosFisicos(esInicial);
		this.setResaltarfecha_ultima_venta_hastaConteosFisicos(esInicial);
		this.setResaltarcodigoConteosFisicos(esInicial);
		this.setResaltarnombre_unidadConteosFisicos(esInicial);
		this.setResaltarcantidad_disponibleConteosFisicos(esInicial);
		this.setResaltarcantidad_fisicaConteosFisicos(esInicial);
		this.setResaltarcodigo_productoConteosFisicos(esInicial);
		this.setResaltarnombreConteosFisicos(esInicial);
		this.setResaltaringresosConteosFisicos(esInicial);
		this.setResaltaregresosConteosFisicos(esInicial);
		this.setResaltarexistencia_corteConteosFisicos(esInicial);
		this.setResaltarcostoConteosFisicos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.ID)) {
				this.setResaltaridConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setResaltarfecha_ultima_venta_hastaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CANTIDADFISICA)) {
				this.setResaltarcantidad_fisicaConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.INGRESOS)) {
				this.setResaltaringresosConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.EGRESOS)) {
				this.setResaltaregresosConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.EXISTENCIACORTE)) {
				this.setResaltarexistencia_corteConteosFisicos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConteosFisicosConstantesFunciones.COSTO)) {
				this.setResaltarcostoConteosFisicos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaConteosFisicosConteosFisicos=true;

	public Boolean getMostrarBusquedaConteosFisicosConteosFisicos() {
		return this.mostrarBusquedaConteosFisicosConteosFisicos;
	}

	public void setMostrarBusquedaConteosFisicosConteosFisicos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaConteosFisicosConteosFisicos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaConteosFisicosConteosFisicos=true;

	public Boolean getActivarBusquedaConteosFisicosConteosFisicos() {
		return this.activarBusquedaConteosFisicosConteosFisicos;
	}

	public void setActivarBusquedaConteosFisicosConteosFisicos(Boolean habilitarResaltar) {
		this.activarBusquedaConteosFisicosConteosFisicos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaConteosFisicosConteosFisicos=null;

	public Border getResaltarBusquedaConteosFisicosConteosFisicos() {
		return this.resaltarBusquedaConteosFisicosConteosFisicos;
	}

	public void setResaltarBusquedaConteosFisicosConteosFisicos(Border borderResaltar) {
		this.resaltarBusquedaConteosFisicosConteosFisicos= borderResaltar;
	}

	public void setResaltarBusquedaConteosFisicosConteosFisicos(ParametroGeneralUsuario parametroGeneralUsuario/*ConteosFisicosBeanSwingJInternalFrame conteosfisicosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaConteosFisicosConteosFisicos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}