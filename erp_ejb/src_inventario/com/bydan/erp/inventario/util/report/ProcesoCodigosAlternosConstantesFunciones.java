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


import com.bydan.erp.inventario.util.report.ProcesoCodigosAlternosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ProcesoCodigosAlternosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ProcesoCodigosAlternosParameterGeneral;

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
final public class ProcesoCodigosAlternosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoCodigosAlternos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCodigosAlternos"+ProcesoCodigosAlternosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCodigosAlternosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCodigosAlternosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"_"+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCodigosAlternosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"_"+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"_"+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCodigosAlternosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"_"+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCodigosAlternosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCodigosAlternosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCodigosAlternosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCodigosAlternosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCodigosAlternosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCodigosAlternosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCodigosAlternosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Codigos Alternoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Codigos Alternos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Codigos Alternos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCodigosAlternos";
	public static final String OBJECTNAME="procesocodigosalternos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="proceso_codigos_alternos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocodigosalternos from "+ProcesoCodigosAlternosConstantesFunciones.SPERSISTENCENAME+" procesocodigosalternos";
	public static String QUERYSELECTNATIVE="select "+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".version_row,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_bodega,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_producto,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_linea,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".id_linea_marca,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".codigo,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".nombre_unidad,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".codigo_producto,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".nombre,"+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME+".nombre_completo_cliente_proveedor_defecto from "+ProcesoCodigosAlternosConstantesFunciones.SCHEMA+"."+ProcesoCodigosAlternosConstantesFunciones.TABLENAME;//+" as "+ProcesoCodigosAlternosConstantesFunciones.TABLENAME;
	
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
    public static final String CODIGO= "codigo";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String CODIGOPRODUCTO= "codigo_producto";
    public static final String NOMBRE= "nombre";
    public static final String NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO= "nombre_completo_cliente_proveedor_defecto";
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
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unidad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO= "Nombre Completo Cliente Proveedor Defecto";
		public static final String LABEL_NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO_LOWER= "Nombre Completo Cliente Proveedor Defecto";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE_PROVEEDOR_DEFECTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE_PROVEEDOR_DEFECTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProcesoCodigosAlternosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDBODEGA)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEA)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRE)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO)) {sLabelColumna=ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoCodigosAlternosDescripcion(ProcesoCodigosAlternos procesocodigosalternos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocodigosalternos !=null/* && procesocodigosalternos.getId()!=0*/) {
			sDescripcion=procesocodigosalternos.getcodigo();//procesocodigosalternosprocesocodigosalternos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCodigosAlternosDescripcionDetallado(ProcesoCodigosAlternos procesocodigosalternos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.ID+"=";
		sDescripcion+=procesocodigosalternos.getId().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocodigosalternos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=procesocodigosalternos.getid_bodega().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=procesocodigosalternos.getid_producto().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesocodigosalternos.getid_empresa().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesocodigosalternos.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=procesocodigosalternos.getid_linea().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=procesocodigosalternos.getid_linea_grupo().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=procesocodigosalternos.getid_linea_categoria().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=procesocodigosalternos.getid_linea_marca().toString()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesocodigosalternos.getcodigo()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=procesocodigosalternos.getnombre_unidad()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=procesocodigosalternos.getnombre_completo_cliente()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=procesocodigosalternos.getcodigo_producto()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=procesocodigosalternos.getnombre()+",";
		sDescripcion+=ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO+"=";
		sDescripcion+=procesocodigosalternos.getnombre_completo_cliente_proveedor_defecto()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCodigosAlternosDescripcion(ProcesoCodigosAlternos procesocodigosalternos,String sValor) throws Exception {			
		if(procesocodigosalternos !=null) {
			procesocodigosalternos.setcodigo(sValor);;//procesocodigosalternosprocesocodigosalternos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProcesoCodigosAlternos")) {
			sNombreIndice="Tipo=  Por Bodega Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca";
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

	public static String getDetalleIndiceBusquedaProcesoCodigosAlternos(Long id_bodega,Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCodigosAlternos(ProcesoCodigosAlternos procesocodigosalternos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesocodigosalternos.setcodigo(procesocodigosalternos.getcodigo().trim());
		procesocodigosalternos.setnombre_unidad(procesocodigosalternos.getnombre_unidad().trim());
		procesocodigosalternos.setnombre_completo_cliente(procesocodigosalternos.getnombre_completo_cliente().trim());
		procesocodigosalternos.setcodigo_producto(procesocodigosalternos.getcodigo_producto().trim());
		procesocodigosalternos.setnombre(procesocodigosalternos.getnombre().trim());
		procesocodigosalternos.setnombre_completo_cliente_proveedor_defecto(procesocodigosalternos.getnombre_completo_cliente_proveedor_defecto().trim());
	}
	
	public static void quitarEspaciosProcesoCodigosAlternoss(List<ProcesoCodigosAlternos> procesocodigosalternoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCodigosAlternos procesocodigosalternos: procesocodigosalternoss) {
			procesocodigosalternos.setcodigo(procesocodigosalternos.getcodigo().trim());
			procesocodigosalternos.setnombre_unidad(procesocodigosalternos.getnombre_unidad().trim());
			procesocodigosalternos.setnombre_completo_cliente(procesocodigosalternos.getnombre_completo_cliente().trim());
			procesocodigosalternos.setcodigo_producto(procesocodigosalternos.getcodigo_producto().trim());
			procesocodigosalternos.setnombre(procesocodigosalternos.getnombre().trim());
			procesocodigosalternos.setnombre_completo_cliente_proveedor_defecto(procesocodigosalternos.getnombre_completo_cliente_proveedor_defecto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCodigosAlternos(ProcesoCodigosAlternos procesocodigosalternos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocodigosalternos.getConCambioAuxiliar()) {
			procesocodigosalternos.setIsDeleted(procesocodigosalternos.getIsDeletedAuxiliar());	
			procesocodigosalternos.setIsNew(procesocodigosalternos.getIsNewAuxiliar());	
			procesocodigosalternos.setIsChanged(procesocodigosalternos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocodigosalternos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocodigosalternos.setIsDeletedAuxiliar(false);	
			procesocodigosalternos.setIsNewAuxiliar(false);	
			procesocodigosalternos.setIsChangedAuxiliar(false);
			
			procesocodigosalternos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCodigosAlternoss(List<ProcesoCodigosAlternos> procesocodigosalternoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCodigosAlternos procesocodigosalternos : procesocodigosalternoss) {
			if(conAsignarBase && procesocodigosalternos.getConCambioAuxiliar()) {
				procesocodigosalternos.setIsDeleted(procesocodigosalternos.getIsDeletedAuxiliar());	
				procesocodigosalternos.setIsNew(procesocodigosalternos.getIsNewAuxiliar());	
				procesocodigosalternos.setIsChanged(procesocodigosalternos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocodigosalternos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocodigosalternos.setIsDeletedAuxiliar(false);	
				procesocodigosalternos.setIsNewAuxiliar(false);	
				procesocodigosalternos.setIsChangedAuxiliar(false);
				
				procesocodigosalternos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCodigosAlternos(ProcesoCodigosAlternos procesocodigosalternos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCodigosAlternoss(List<ProcesoCodigosAlternos> procesocodigosalternoss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCodigosAlternos procesocodigosalternos: procesocodigosalternoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCodigosAlternos(List<ProcesoCodigosAlternos> procesocodigosalternoss,ProcesoCodigosAlternos procesocodigosalternosAux) throws Exception  {
		ProcesoCodigosAlternosConstantesFunciones.InicializarValoresProcesoCodigosAlternos(procesocodigosalternosAux,true);
		
		for(ProcesoCodigosAlternos procesocodigosalternos: procesocodigosalternoss) {
			if(procesocodigosalternos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCodigosAlternos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCodigosAlternosConstantesFunciones.getArrayColumnasGlobalesProcesoCodigosAlternos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCodigosAlternos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCodigosAlternosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCodigosAlternosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCodigosAlternosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCodigosAlternosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCodigosAlternos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCodigosAlternos> procesocodigosalternoss,ProcesoCodigosAlternos procesocodigosalternos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCodigosAlternos procesocodigosalternosAux: procesocodigosalternoss) {
			if(procesocodigosalternosAux!=null && procesocodigosalternos!=null) {
				if((procesocodigosalternosAux.getId()==null && procesocodigosalternos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocodigosalternosAux.getId()!=null && procesocodigosalternos.getId()!=null){
					if(procesocodigosalternosAux.getId().equals(procesocodigosalternos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCodigosAlternos(List<ProcesoCodigosAlternos> procesocodigosalternoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCodigosAlternos procesocodigosalternos: procesocodigosalternoss) {			
			if(procesocodigosalternos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCodigosAlternos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_ID, ProcesoCodigosAlternosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_VERSIONROW, ProcesoCodigosAlternosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGO, ProcesoCodigosAlternosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBREUNIDAD, ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGOPRODUCTO, ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRE, ProcesoCodigosAlternosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO, ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCodigosAlternos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCodigosAlternos() throws Exception  {
		return ProcesoCodigosAlternosConstantesFunciones.getTiposSeleccionarProcesoCodigosAlternos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCodigosAlternos(Boolean conFk) throws Exception  {
		return ProcesoCodigosAlternosConstantesFunciones.getTiposSeleccionarProcesoCodigosAlternos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCodigosAlternos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO);
			reporte.setsDescripcion(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCodigosAlternos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCodigosAlternos(ProcesoCodigosAlternos procesocodigosalternosAux) throws Exception {
		
			procesocodigosalternosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesocodigosalternosAux.getBodega()));
			procesocodigosalternosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesocodigosalternosAux.getProducto()));
			procesocodigosalternosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocodigosalternosAux.getEmpresa()));
			procesocodigosalternosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocodigosalternosAux.getSucursal()));
			procesocodigosalternosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLinea()));
			procesocodigosalternosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLineaGrupo()));
			procesocodigosalternosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLineaCategoria()));
			procesocodigosalternosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCodigosAlternos(List<ProcesoCodigosAlternos> procesocodigosalternossTemp) throws Exception {
		for(ProcesoCodigosAlternos procesocodigosalternosAux:procesocodigosalternossTemp) {
			
			procesocodigosalternosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(procesocodigosalternosAux.getBodega()));
			procesocodigosalternosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(procesocodigosalternosAux.getProducto()));
			procesocodigosalternosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesocodigosalternosAux.getEmpresa()));
			procesocodigosalternosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesocodigosalternosAux.getSucursal()));
			procesocodigosalternosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLinea()));
			procesocodigosalternosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLineaGrupo()));
			procesocodigosalternosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLineaCategoria()));
			procesocodigosalternosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(procesocodigosalternosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCodigosAlternos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCodigosAlternos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCodigosAlternos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCodigosAlternosConstantesFunciones.getClassesRelationshipsOfProcesoCodigosAlternos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCodigosAlternos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCodigosAlternos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCodigosAlternosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCodigosAlternos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCodigosAlternos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCodigosAlternos procesocodigosalternos,List<ProcesoCodigosAlternos> procesocodigosalternoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCodigosAlternos procesocodigosalternos,List<ProcesoCodigosAlternos> procesocodigosalternoss) throws Exception {
		try	{			
			for(ProcesoCodigosAlternos procesocodigosalternosLocal:procesocodigosalternoss) {
				if(procesocodigosalternosLocal.getId().equals(procesocodigosalternos.getId())) {
					procesocodigosalternosLocal.setIsSelected(procesocodigosalternos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCodigosAlternos(List<ProcesoCodigosAlternos> procesocodigosalternossAux) throws Exception {
		//this.procesocodigosalternossAux=procesocodigosalternossAux;
		
		for(ProcesoCodigosAlternos procesocodigosalternosAux:procesocodigosalternossAux) {
			if(procesocodigosalternosAux.getIsChanged()) {
				procesocodigosalternosAux.setIsChanged(false);
			}		
			
			if(procesocodigosalternosAux.getIsNew()) {
				procesocodigosalternosAux.setIsNew(false);
			}	
			
			if(procesocodigosalternosAux.getIsDeleted()) {
				procesocodigosalternosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCodigosAlternos(ProcesoCodigosAlternos procesocodigosalternosAux) throws Exception {
		//this.procesocodigosalternosAux=procesocodigosalternosAux;
		
			if(procesocodigosalternosAux.getIsChanged()) {
				procesocodigosalternosAux.setIsChanged(false);
			}		
			
			if(procesocodigosalternosAux.getIsNew()) {
				procesocodigosalternosAux.setIsNew(false);
			}	
			
			if(procesocodigosalternosAux.getIsDeleted()) {
				procesocodigosalternosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCodigosAlternos procesocodigosalternosAsignar,ProcesoCodigosAlternos procesocodigosalternos) throws Exception {
		procesocodigosalternosAsignar.setId(procesocodigosalternos.getId());	
		procesocodigosalternosAsignar.setVersionRow(procesocodigosalternos.getVersionRow());	
		procesocodigosalternosAsignar.setcodigo(procesocodigosalternos.getcodigo());	
		procesocodigosalternosAsignar.setnombre_unidad(procesocodigosalternos.getnombre_unidad());	
		procesocodigosalternosAsignar.setnombre_completo_cliente(procesocodigosalternos.getnombre_completo_cliente());	
		procesocodigosalternosAsignar.setcodigo_producto(procesocodigosalternos.getcodigo_producto());	
		procesocodigosalternosAsignar.setnombre(procesocodigosalternos.getnombre());	
		procesocodigosalternosAsignar.setnombre_completo_cliente_proveedor_defecto(procesocodigosalternos.getnombre_completo_cliente_proveedor_defecto());	
	}
	
	public static void inicializarProcesoCodigosAlternos(ProcesoCodigosAlternos procesocodigosalternos) throws Exception {
		try {
				procesocodigosalternos.setId(0L);	
					
				procesocodigosalternos.setcodigo("");	
				procesocodigosalternos.setnombre_unidad("");	
				procesocodigosalternos.setnombre_completo_cliente("");	
				procesocodigosalternos.setcodigo_producto("");	
				procesocodigosalternos.setnombre("");	
				procesocodigosalternos.setnombre_completo_cliente_proveedor_defecto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCodigosAlternos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCodigosAlternosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCodigosAlternos(String sTipo,Row row,Workbook workbook,ProcesoCodigosAlternos procesocodigosalternos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocodigosalternos.getnombre_completo_cliente_proveedor_defecto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCodigosAlternos="";
	
	public String getsFinalQueryProcesoCodigosAlternos() {
		return this.sFinalQueryProcesoCodigosAlternos;
	}
	
	public void setsFinalQueryProcesoCodigosAlternos(String sFinalQueryProcesoCodigosAlternos) {
		this.sFinalQueryProcesoCodigosAlternos= sFinalQueryProcesoCodigosAlternos;
	}
	
	public Border resaltarSeleccionarProcesoCodigosAlternos=null;
	
	public Border setResaltarSeleccionarProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCodigosAlternos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCodigosAlternos() {
		return this.resaltarSeleccionarProcesoCodigosAlternos;
	}
	
	public void setResaltarSeleccionarProcesoCodigosAlternos(Border borderResaltarSeleccionarProcesoCodigosAlternos) {
		this.resaltarSeleccionarProcesoCodigosAlternos= borderResaltarSeleccionarProcesoCodigosAlternos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCodigosAlternos=null;
	public Boolean mostraridProcesoCodigosAlternos=true;
	public Boolean activaridProcesoCodigosAlternos=true;

	public Border resaltarid_bodegaProcesoCodigosAlternos=null;
	public Boolean mostrarid_bodegaProcesoCodigosAlternos=true;
	public Boolean activarid_bodegaProcesoCodigosAlternos=true;
	public Boolean cargarid_bodegaProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarid_productoProcesoCodigosAlternos=null;
	public Boolean mostrarid_productoProcesoCodigosAlternos=true;
	public Boolean activarid_productoProcesoCodigosAlternos=true;
	public Boolean cargarid_productoProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarid_empresaProcesoCodigosAlternos=null;
	public Boolean mostrarid_empresaProcesoCodigosAlternos=true;
	public Boolean activarid_empresaProcesoCodigosAlternos=true;
	public Boolean cargarid_empresaProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoCodigosAlternos=null;
	public Boolean mostrarid_sucursalProcesoCodigosAlternos=true;
	public Boolean activarid_sucursalProcesoCodigosAlternos=true;
	public Boolean cargarid_sucursalProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarid_lineaProcesoCodigosAlternos=null;
	public Boolean mostrarid_lineaProcesoCodigosAlternos=true;
	public Boolean activarid_lineaProcesoCodigosAlternos=true;
	public Boolean cargarid_lineaProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoProcesoCodigosAlternos=null;
	public Boolean mostrarid_linea_grupoProcesoCodigosAlternos=true;
	public Boolean activarid_linea_grupoProcesoCodigosAlternos=true;
	public Boolean cargarid_linea_grupoProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaProcesoCodigosAlternos=null;
	public Boolean mostrarid_linea_categoriaProcesoCodigosAlternos=true;
	public Boolean activarid_linea_categoriaProcesoCodigosAlternos=true;
	public Boolean cargarid_linea_categoriaProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaProcesoCodigosAlternos=null;
	public Boolean mostrarid_linea_marcaProcesoCodigosAlternos=true;
	public Boolean activarid_linea_marcaProcesoCodigosAlternos=true;
	public Boolean cargarid_linea_marcaProcesoCodigosAlternos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaProcesoCodigosAlternos=false;//ConEventDepend=true

	public Border resaltarcodigoProcesoCodigosAlternos=null;
	public Boolean mostrarcodigoProcesoCodigosAlternos=true;
	public Boolean activarcodigoProcesoCodigosAlternos=true;

	public Border resaltarnombre_unidadProcesoCodigosAlternos=null;
	public Boolean mostrarnombre_unidadProcesoCodigosAlternos=true;
	public Boolean activarnombre_unidadProcesoCodigosAlternos=true;

	public Border resaltarnombre_completo_clienteProcesoCodigosAlternos=null;
	public Boolean mostrarnombre_completo_clienteProcesoCodigosAlternos=true;
	public Boolean activarnombre_completo_clienteProcesoCodigosAlternos=true;

	public Border resaltarcodigo_productoProcesoCodigosAlternos=null;
	public Boolean mostrarcodigo_productoProcesoCodigosAlternos=true;
	public Boolean activarcodigo_productoProcesoCodigosAlternos=true;

	public Border resaltarnombreProcesoCodigosAlternos=null;
	public Boolean mostrarnombreProcesoCodigosAlternos=true;
	public Boolean activarnombreProcesoCodigosAlternos=true;

	public Border resaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos=null;
	public Boolean mostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos=true;
	public Boolean activarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos=true;

	
	

	public Border setResaltaridProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltaridProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCodigosAlternos() {
		return this.resaltaridProcesoCodigosAlternos;
	}

	public void setResaltaridProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltaridProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostraridProcesoCodigosAlternos() {
		return this.mostraridProcesoCodigosAlternos;
	}

	public void setMostraridProcesoCodigosAlternos(Boolean mostraridProcesoCodigosAlternos) {
		this.mostraridProcesoCodigosAlternos= mostraridProcesoCodigosAlternos;
	}

	public Boolean getActivaridProcesoCodigosAlternos() {
		return this.activaridProcesoCodigosAlternos;
	}

	public void setActivaridProcesoCodigosAlternos(Boolean activaridProcesoCodigosAlternos) {
		this.activaridProcesoCodigosAlternos= activaridProcesoCodigosAlternos;
	}

	public Border setResaltarid_bodegaProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_bodegaProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaProcesoCodigosAlternos() {
		return this.resaltarid_bodegaProcesoCodigosAlternos;
	}

	public void setResaltarid_bodegaProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_bodegaProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_bodegaProcesoCodigosAlternos() {
		return this.mostrarid_bodegaProcesoCodigosAlternos;
	}

	public void setMostrarid_bodegaProcesoCodigosAlternos(Boolean mostrarid_bodegaProcesoCodigosAlternos) {
		this.mostrarid_bodegaProcesoCodigosAlternos= mostrarid_bodegaProcesoCodigosAlternos;
	}

	public Boolean getActivarid_bodegaProcesoCodigosAlternos() {
		return this.activarid_bodegaProcesoCodigosAlternos;
	}

	public void setActivarid_bodegaProcesoCodigosAlternos(Boolean activarid_bodegaProcesoCodigosAlternos) {
		this.activarid_bodegaProcesoCodigosAlternos= activarid_bodegaProcesoCodigosAlternos;
	}

	public Boolean getCargarid_bodegaProcesoCodigosAlternos() {
		return this.cargarid_bodegaProcesoCodigosAlternos;
	}

	public void setCargarid_bodegaProcesoCodigosAlternos(Boolean cargarid_bodegaProcesoCodigosAlternos) {
		this.cargarid_bodegaProcesoCodigosAlternos= cargarid_bodegaProcesoCodigosAlternos;
	}

	public Border setResaltarid_productoProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_productoProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoProcesoCodigosAlternos() {
		return this.resaltarid_productoProcesoCodigosAlternos;
	}

	public void setResaltarid_productoProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_productoProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_productoProcesoCodigosAlternos() {
		return this.mostrarid_productoProcesoCodigosAlternos;
	}

	public void setMostrarid_productoProcesoCodigosAlternos(Boolean mostrarid_productoProcesoCodigosAlternos) {
		this.mostrarid_productoProcesoCodigosAlternos= mostrarid_productoProcesoCodigosAlternos;
	}

	public Boolean getActivarid_productoProcesoCodigosAlternos() {
		return this.activarid_productoProcesoCodigosAlternos;
	}

	public void setActivarid_productoProcesoCodigosAlternos(Boolean activarid_productoProcesoCodigosAlternos) {
		this.activarid_productoProcesoCodigosAlternos= activarid_productoProcesoCodigosAlternos;
	}

	public Boolean getCargarid_productoProcesoCodigosAlternos() {
		return this.cargarid_productoProcesoCodigosAlternos;
	}

	public void setCargarid_productoProcesoCodigosAlternos(Boolean cargarid_productoProcesoCodigosAlternos) {
		this.cargarid_productoProcesoCodigosAlternos= cargarid_productoProcesoCodigosAlternos;
	}

	public Border setResaltarid_empresaProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoCodigosAlternos() {
		return this.resaltarid_empresaProcesoCodigosAlternos;
	}

	public void setResaltarid_empresaProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_empresaProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoCodigosAlternos() {
		return this.mostrarid_empresaProcesoCodigosAlternos;
	}

	public void setMostrarid_empresaProcesoCodigosAlternos(Boolean mostrarid_empresaProcesoCodigosAlternos) {
		this.mostrarid_empresaProcesoCodigosAlternos= mostrarid_empresaProcesoCodigosAlternos;
	}

	public Boolean getActivarid_empresaProcesoCodigosAlternos() {
		return this.activarid_empresaProcesoCodigosAlternos;
	}

	public void setActivarid_empresaProcesoCodigosAlternos(Boolean activarid_empresaProcesoCodigosAlternos) {
		this.activarid_empresaProcesoCodigosAlternos= activarid_empresaProcesoCodigosAlternos;
	}

	public Boolean getCargarid_empresaProcesoCodigosAlternos() {
		return this.cargarid_empresaProcesoCodigosAlternos;
	}

	public void setCargarid_empresaProcesoCodigosAlternos(Boolean cargarid_empresaProcesoCodigosAlternos) {
		this.cargarid_empresaProcesoCodigosAlternos= cargarid_empresaProcesoCodigosAlternos;
	}

	public Border setResaltarid_sucursalProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoCodigosAlternos() {
		return this.resaltarid_sucursalProcesoCodigosAlternos;
	}

	public void setResaltarid_sucursalProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_sucursalProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoCodigosAlternos() {
		return this.mostrarid_sucursalProcesoCodigosAlternos;
	}

	public void setMostrarid_sucursalProcesoCodigosAlternos(Boolean mostrarid_sucursalProcesoCodigosAlternos) {
		this.mostrarid_sucursalProcesoCodigosAlternos= mostrarid_sucursalProcesoCodigosAlternos;
	}

	public Boolean getActivarid_sucursalProcesoCodigosAlternos() {
		return this.activarid_sucursalProcesoCodigosAlternos;
	}

	public void setActivarid_sucursalProcesoCodigosAlternos(Boolean activarid_sucursalProcesoCodigosAlternos) {
		this.activarid_sucursalProcesoCodigosAlternos= activarid_sucursalProcesoCodigosAlternos;
	}

	public Boolean getCargarid_sucursalProcesoCodigosAlternos() {
		return this.cargarid_sucursalProcesoCodigosAlternos;
	}

	public void setCargarid_sucursalProcesoCodigosAlternos(Boolean cargarid_sucursalProcesoCodigosAlternos) {
		this.cargarid_sucursalProcesoCodigosAlternos= cargarid_sucursalProcesoCodigosAlternos;
	}

	public Border setResaltarid_lineaProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_lineaProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaProcesoCodigosAlternos() {
		return this.resaltarid_lineaProcesoCodigosAlternos;
	}

	public void setResaltarid_lineaProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_lineaProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_lineaProcesoCodigosAlternos() {
		return this.mostrarid_lineaProcesoCodigosAlternos;
	}

	public void setMostrarid_lineaProcesoCodigosAlternos(Boolean mostrarid_lineaProcesoCodigosAlternos) {
		this.mostrarid_lineaProcesoCodigosAlternos= mostrarid_lineaProcesoCodigosAlternos;
	}

	public Boolean getActivarid_lineaProcesoCodigosAlternos() {
		return this.activarid_lineaProcesoCodigosAlternos;
	}

	public void setActivarid_lineaProcesoCodigosAlternos(Boolean activarid_lineaProcesoCodigosAlternos) {
		this.activarid_lineaProcesoCodigosAlternos= activarid_lineaProcesoCodigosAlternos;
	}

	public Boolean getCargarid_lineaProcesoCodigosAlternos() {
		return this.cargarid_lineaProcesoCodigosAlternos;
	}

	public void setCargarid_lineaProcesoCodigosAlternos(Boolean cargarid_lineaProcesoCodigosAlternos) {
		this.cargarid_lineaProcesoCodigosAlternos= cargarid_lineaProcesoCodigosAlternos;
	}

	public Border setResaltarid_linea_grupoProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoProcesoCodigosAlternos() {
		return this.resaltarid_linea_grupoProcesoCodigosAlternos;
	}

	public void setResaltarid_linea_grupoProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_linea_grupoProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoProcesoCodigosAlternos() {
		return this.mostrarid_linea_grupoProcesoCodigosAlternos;
	}

	public void setMostrarid_linea_grupoProcesoCodigosAlternos(Boolean mostrarid_linea_grupoProcesoCodigosAlternos) {
		this.mostrarid_linea_grupoProcesoCodigosAlternos= mostrarid_linea_grupoProcesoCodigosAlternos;
	}

	public Boolean getActivarid_linea_grupoProcesoCodigosAlternos() {
		return this.activarid_linea_grupoProcesoCodigosAlternos;
	}

	public void setActivarid_linea_grupoProcesoCodigosAlternos(Boolean activarid_linea_grupoProcesoCodigosAlternos) {
		this.activarid_linea_grupoProcesoCodigosAlternos= activarid_linea_grupoProcesoCodigosAlternos;
	}

	public Boolean getCargarid_linea_grupoProcesoCodigosAlternos() {
		return this.cargarid_linea_grupoProcesoCodigosAlternos;
	}

	public void setCargarid_linea_grupoProcesoCodigosAlternos(Boolean cargarid_linea_grupoProcesoCodigosAlternos) {
		this.cargarid_linea_grupoProcesoCodigosAlternos= cargarid_linea_grupoProcesoCodigosAlternos;
	}

	public Border setResaltarid_linea_categoriaProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaProcesoCodigosAlternos() {
		return this.resaltarid_linea_categoriaProcesoCodigosAlternos;
	}

	public void setResaltarid_linea_categoriaProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_linea_categoriaProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaProcesoCodigosAlternos() {
		return this.mostrarid_linea_categoriaProcesoCodigosAlternos;
	}

	public void setMostrarid_linea_categoriaProcesoCodigosAlternos(Boolean mostrarid_linea_categoriaProcesoCodigosAlternos) {
		this.mostrarid_linea_categoriaProcesoCodigosAlternos= mostrarid_linea_categoriaProcesoCodigosAlternos;
	}

	public Boolean getActivarid_linea_categoriaProcesoCodigosAlternos() {
		return this.activarid_linea_categoriaProcesoCodigosAlternos;
	}

	public void setActivarid_linea_categoriaProcesoCodigosAlternos(Boolean activarid_linea_categoriaProcesoCodigosAlternos) {
		this.activarid_linea_categoriaProcesoCodigosAlternos= activarid_linea_categoriaProcesoCodigosAlternos;
	}

	public Boolean getCargarid_linea_categoriaProcesoCodigosAlternos() {
		return this.cargarid_linea_categoriaProcesoCodigosAlternos;
	}

	public void setCargarid_linea_categoriaProcesoCodigosAlternos(Boolean cargarid_linea_categoriaProcesoCodigosAlternos) {
		this.cargarid_linea_categoriaProcesoCodigosAlternos= cargarid_linea_categoriaProcesoCodigosAlternos;
	}

	public Border setResaltarid_linea_marcaProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaProcesoCodigosAlternos() {
		return this.resaltarid_linea_marcaProcesoCodigosAlternos;
	}

	public void setResaltarid_linea_marcaProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarid_linea_marcaProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaProcesoCodigosAlternos() {
		return this.mostrarid_linea_marcaProcesoCodigosAlternos;
	}

	public void setMostrarid_linea_marcaProcesoCodigosAlternos(Boolean mostrarid_linea_marcaProcesoCodigosAlternos) {
		this.mostrarid_linea_marcaProcesoCodigosAlternos= mostrarid_linea_marcaProcesoCodigosAlternos;
	}

	public Boolean getActivarid_linea_marcaProcesoCodigosAlternos() {
		return this.activarid_linea_marcaProcesoCodigosAlternos;
	}

	public void setActivarid_linea_marcaProcesoCodigosAlternos(Boolean activarid_linea_marcaProcesoCodigosAlternos) {
		this.activarid_linea_marcaProcesoCodigosAlternos= activarid_linea_marcaProcesoCodigosAlternos;
	}

	public Boolean getCargarid_linea_marcaProcesoCodigosAlternos() {
		return this.cargarid_linea_marcaProcesoCodigosAlternos;
	}

	public void setCargarid_linea_marcaProcesoCodigosAlternos(Boolean cargarid_linea_marcaProcesoCodigosAlternos) {
		this.cargarid_linea_marcaProcesoCodigosAlternos= cargarid_linea_marcaProcesoCodigosAlternos;
	}

	public Border setResaltarcodigoProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoCodigosAlternos() {
		return this.resaltarcodigoProcesoCodigosAlternos;
	}

	public void setResaltarcodigoProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarcodigoProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoCodigosAlternos() {
		return this.mostrarcodigoProcesoCodigosAlternos;
	}

	public void setMostrarcodigoProcesoCodigosAlternos(Boolean mostrarcodigoProcesoCodigosAlternos) {
		this.mostrarcodigoProcesoCodigosAlternos= mostrarcodigoProcesoCodigosAlternos;
	}

	public Boolean getActivarcodigoProcesoCodigosAlternos() {
		return this.activarcodigoProcesoCodigosAlternos;
	}

	public void setActivarcodigoProcesoCodigosAlternos(Boolean activarcodigoProcesoCodigosAlternos) {
		this.activarcodigoProcesoCodigosAlternos= activarcodigoProcesoCodigosAlternos;
	}

	public Border setResaltarnombre_unidadProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProcesoCodigosAlternos() {
		return this.resaltarnombre_unidadProcesoCodigosAlternos;
	}

	public void setResaltarnombre_unidadProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarnombre_unidadProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProcesoCodigosAlternos() {
		return this.mostrarnombre_unidadProcesoCodigosAlternos;
	}

	public void setMostrarnombre_unidadProcesoCodigosAlternos(Boolean mostrarnombre_unidadProcesoCodigosAlternos) {
		this.mostrarnombre_unidadProcesoCodigosAlternos= mostrarnombre_unidadProcesoCodigosAlternos;
	}

	public Boolean getActivarnombre_unidadProcesoCodigosAlternos() {
		return this.activarnombre_unidadProcesoCodigosAlternos;
	}

	public void setActivarnombre_unidadProcesoCodigosAlternos(Boolean activarnombre_unidadProcesoCodigosAlternos) {
		this.activarnombre_unidadProcesoCodigosAlternos= activarnombre_unidadProcesoCodigosAlternos;
	}

	public Border setResaltarnombre_completo_clienteProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteProcesoCodigosAlternos() {
		return this.resaltarnombre_completo_clienteProcesoCodigosAlternos;
	}

	public void setResaltarnombre_completo_clienteProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarnombre_completo_clienteProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteProcesoCodigosAlternos() {
		return this.mostrarnombre_completo_clienteProcesoCodigosAlternos;
	}

	public void setMostrarnombre_completo_clienteProcesoCodigosAlternos(Boolean mostrarnombre_completo_clienteProcesoCodigosAlternos) {
		this.mostrarnombre_completo_clienteProcesoCodigosAlternos= mostrarnombre_completo_clienteProcesoCodigosAlternos;
	}

	public Boolean getActivarnombre_completo_clienteProcesoCodigosAlternos() {
		return this.activarnombre_completo_clienteProcesoCodigosAlternos;
	}

	public void setActivarnombre_completo_clienteProcesoCodigosAlternos(Boolean activarnombre_completo_clienteProcesoCodigosAlternos) {
		this.activarnombre_completo_clienteProcesoCodigosAlternos= activarnombre_completo_clienteProcesoCodigosAlternos;
	}

	public Border setResaltarcodigo_productoProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoProcesoCodigosAlternos() {
		return this.resaltarcodigo_productoProcesoCodigosAlternos;
	}

	public void setResaltarcodigo_productoProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarcodigo_productoProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoProcesoCodigosAlternos() {
		return this.mostrarcodigo_productoProcesoCodigosAlternos;
	}

	public void setMostrarcodigo_productoProcesoCodigosAlternos(Boolean mostrarcodigo_productoProcesoCodigosAlternos) {
		this.mostrarcodigo_productoProcesoCodigosAlternos= mostrarcodigo_productoProcesoCodigosAlternos;
	}

	public Boolean getActivarcodigo_productoProcesoCodigosAlternos() {
		return this.activarcodigo_productoProcesoCodigosAlternos;
	}

	public void setActivarcodigo_productoProcesoCodigosAlternos(Boolean activarcodigo_productoProcesoCodigosAlternos) {
		this.activarcodigo_productoProcesoCodigosAlternos= activarcodigo_productoProcesoCodigosAlternos;
	}

	public Border setResaltarnombreProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarnombreProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProcesoCodigosAlternos() {
		return this.resaltarnombreProcesoCodigosAlternos;
	}

	public void setResaltarnombreProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarnombreProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarnombreProcesoCodigosAlternos() {
		return this.mostrarnombreProcesoCodigosAlternos;
	}

	public void setMostrarnombreProcesoCodigosAlternos(Boolean mostrarnombreProcesoCodigosAlternos) {
		this.mostrarnombreProcesoCodigosAlternos= mostrarnombreProcesoCodigosAlternos;
	}

	public Boolean getActivarnombreProcesoCodigosAlternos() {
		return this.activarnombreProcesoCodigosAlternos;
	}

	public void setActivarnombreProcesoCodigosAlternos(Boolean activarnombreProcesoCodigosAlternos) {
		this.activarnombreProcesoCodigosAlternos= activarnombreProcesoCodigosAlternos;
	}

	public Border setResaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocodigosalternosBeanSwingJInternalFrame.jTtoolBarProcesoCodigosAlternos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos() {
		return this.resaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos;
	}

	public void setResaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos() {
		return this.mostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos;
	}

	public void setMostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(Boolean mostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos) {
		this.mostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos= mostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos;
	}

	public Boolean getActivarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos() {
		return this.activarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos;
	}

	public void setActivarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(Boolean activarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos) {
		this.activarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos= activarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos;
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
		
		
		this.setMostraridProcesoCodigosAlternos(esInicial);
		this.setMostrarid_bodegaProcesoCodigosAlternos(esInicial);
		this.setMostrarid_productoProcesoCodigosAlternos(esInicial);
		this.setMostrarid_empresaProcesoCodigosAlternos(esInicial);
		this.setMostrarid_sucursalProcesoCodigosAlternos(esInicial);
		this.setMostrarid_lineaProcesoCodigosAlternos(esInicial);
		this.setMostrarid_linea_grupoProcesoCodigosAlternos(esInicial);
		this.setMostrarid_linea_categoriaProcesoCodigosAlternos(esInicial);
		this.setMostrarid_linea_marcaProcesoCodigosAlternos(esInicial);
		this.setMostrarcodigoProcesoCodigosAlternos(esInicial);
		this.setMostrarnombre_unidadProcesoCodigosAlternos(esInicial);
		this.setMostrarnombre_completo_clienteProcesoCodigosAlternos(esInicial);
		this.setMostrarcodigo_productoProcesoCodigosAlternos(esInicial);
		this.setMostrarnombreProcesoCodigosAlternos(esInicial);
		this.setMostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.ID)) {
				this.setMostraridProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO)) {
				this.setMostrarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(esAsigna);
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
		
		
		this.setActivaridProcesoCodigosAlternos(esInicial);
		this.setActivarid_bodegaProcesoCodigosAlternos(esInicial);
		this.setActivarid_productoProcesoCodigosAlternos(esInicial);
		this.setActivarid_empresaProcesoCodigosAlternos(esInicial);
		this.setActivarid_sucursalProcesoCodigosAlternos(esInicial);
		this.setActivarid_lineaProcesoCodigosAlternos(esInicial);
		this.setActivarid_linea_grupoProcesoCodigosAlternos(esInicial);
		this.setActivarid_linea_categoriaProcesoCodigosAlternos(esInicial);
		this.setActivarid_linea_marcaProcesoCodigosAlternos(esInicial);
		this.setActivarcodigoProcesoCodigosAlternos(esInicial);
		this.setActivarnombre_unidadProcesoCodigosAlternos(esInicial);
		this.setActivarnombre_completo_clienteProcesoCodigosAlternos(esInicial);
		this.setActivarcodigo_productoProcesoCodigosAlternos(esInicial);
		this.setActivarnombreProcesoCodigosAlternos(esInicial);
		this.setActivarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.ID)) {
				this.setActivaridProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO)) {
				this.setActivarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCodigosAlternos(esInicial);
		this.setResaltarid_bodegaProcesoCodigosAlternos(esInicial);
		this.setResaltarid_productoProcesoCodigosAlternos(esInicial);
		this.setResaltarid_empresaProcesoCodigosAlternos(esInicial);
		this.setResaltarid_sucursalProcesoCodigosAlternos(esInicial);
		this.setResaltarid_lineaProcesoCodigosAlternos(esInicial);
		this.setResaltarid_linea_grupoProcesoCodigosAlternos(esInicial);
		this.setResaltarid_linea_categoriaProcesoCodigosAlternos(esInicial);
		this.setResaltarid_linea_marcaProcesoCodigosAlternos(esInicial);
		this.setResaltarcodigoProcesoCodigosAlternos(esInicial);
		this.setResaltarnombre_unidadProcesoCodigosAlternos(esInicial);
		this.setResaltarnombre_completo_clienteProcesoCodigosAlternos(esInicial);
		this.setResaltarcodigo_productoProcesoCodigosAlternos(esInicial);
		this.setResaltarnombreProcesoCodigosAlternos(esInicial);
		this.setResaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.ID)) {
				this.setResaltaridProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProcesoCodigosAlternos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCodigosAlternosConstantesFunciones.NOMBRECOMPLETOCLIENTEPROVEEDORDEFECTO)) {
				this.setResaltarnombre_completo_cliente_proveedor_defectoProcesoCodigosAlternos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos=true;

	public Boolean getMostrarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos() {
		return this.mostrarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos;
	}

	public void setMostrarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos=true;

	public Boolean getActivarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos() {
		return this.activarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos;
	}

	public void setActivarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos=null;

	public Border getResaltarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos() {
		return this.resaltarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos;
	}

	public void setResaltarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos(Border borderResaltar) {
		this.resaltarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCodigosAlternosBeanSwingJInternalFrame procesocodigosalternosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCodigosAlternosProcesoCodigosAlternos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}