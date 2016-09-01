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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.ParametroInventarioDefectoConstantesFunciones;
import com.bydan.erp.inventario.util.ParametroInventarioDefectoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ParametroInventarioDefectoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroInventarioDefectoConstantesFunciones extends ParametroInventarioDefectoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroInventarioDefecto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroInventarioDefecto"+ParametroInventarioDefectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroInventarioDefectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroInventarioDefectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroInventarioDefectoConstantesFunciones.SCHEMA+"_"+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroInventarioDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroInventarioDefectoConstantesFunciones.SCHEMA+"_"+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroInventarioDefectoConstantesFunciones.SCHEMA+"_"+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroInventarioDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroInventarioDefectoConstantesFunciones.SCHEMA+"_"+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroInventarioDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroInventarioDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroInventarioDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroInventarioDefectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroInventarioDefectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroInventarioDefectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroInventarioDefectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Inventario Defectos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Inventario Defecto";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Inventario Defecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroInventarioDefecto";
	public static final String OBJECTNAME="parametroinventariodefecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="parametro_inventario_defecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroinventariodefecto from "+ParametroInventarioDefectoConstantesFunciones.SPERSISTENCENAME+" parametroinventariodefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_grupo_bodega,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_calidad_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_servicio,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio_inven,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_costeo,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_rango_unidad_venta,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_pais,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_ciudad,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_color_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_clase_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_efecto_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_marca_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_modelo_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_material_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_segmento_producto,"+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME+".id_talla_producto from "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+"."+ParametroInventarioDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroInventarioDefectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroInventarioDefectoConstantesFuncionesAdditional parametroinventariodefectoConstantesFuncionesAdditional=null;
	
	public ParametroInventarioDefectoConstantesFuncionesAdditional getParametroInventarioDefectoConstantesFuncionesAdditional() {
		return this.parametroinventariodefectoConstantesFuncionesAdditional;
	}
	
	public void setParametroInventarioDefectoConstantesFuncionesAdditional(ParametroInventarioDefectoConstantesFuncionesAdditional parametroinventariodefectoConstantesFuncionesAdditional) {
		try {
			this.parametroinventariodefectoConstantesFuncionesAdditional=parametroinventariodefectoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDGRUPOBODEGA= "id_grupo_bodega";
    public static final String IDCALIDADPRODUCTO= "id_calidad_producto";
    public static final String IDTIPOSERVICIO= "id_tipo_servicio";
    public static final String IDTIPOPRODUCTOSERVICIOINVEN= "id_tipo_producto_servicio_inven";
    public static final String IDTIPOPRODUCTOSERVICIO= "id_tipo_producto_servicio";
    public static final String IDTIPOCOSTEO= "id_tipo_costeo";
    public static final String IDTIPOPRODUCTO= "id_tipo_producto";
    public static final String IDTIPOVIATRANSPORTE= "id_tipo_via_transporte";
    public static final String IDRANGOUNIDADVENTA= "id_rango_unidad_venta";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDCOLORPRODUCTO= "id_color_producto";
    public static final String IDCLASEPRODUCTO= "id_clase_producto";
    public static final String IDEFECTOPRODUCTO= "id_efecto_producto";
    public static final String IDMARCAPRODUCTO= "id_marca_producto";
    public static final String IDMODELOPRODUCTO= "id_modelo_producto";
    public static final String IDMATERIALPRODUCTO= "id_material_producto";
    public static final String IDSEGMENTOPRODUCTO= "id_segmento_producto";
    public static final String IDTALLAPRODUCTO= "id_talla_producto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDGRUPOBODEGA= "Grupo Bodega";
		public static final String LABEL_IDGRUPOBODEGA_LOWER= "Grupo Bodega";
    	public static final String LABEL_IDCALIDADPRODUCTO= "Calidad Producto";
		public static final String LABEL_IDCALIDADPRODUCTO_LOWER= "Calidad Producto";
    	public static final String LABEL_IDTIPOSERVICIO= "Tipo Servicio";
		public static final String LABEL_IDTIPOSERVICIO_LOWER= "Tipo Servicio";
    	public static final String LABEL_IDTIPOPRODUCTOSERVICIOINVEN= "Tipo Producto Servicio.";
		public static final String LABEL_IDTIPOPRODUCTOSERVICIOINVEN_LOWER= "Tipo Producto Servicio Inven";
    	public static final String LABEL_IDTIPOPRODUCTOSERVICIO= "Tipo Producto Servicio";
		public static final String LABEL_IDTIPOPRODUCTOSERVICIO_LOWER= "Tipo Producto Servicio";
    	public static final String LABEL_IDTIPOCOSTEO= "Tipo Costeo";
		public static final String LABEL_IDTIPOCOSTEO_LOWER= "Tipo Costeo";
    	public static final String LABEL_IDTIPOPRODUCTO= "Tipo Producto";
		public static final String LABEL_IDTIPOPRODUCTO_LOWER= "Tipo Producto";
    	public static final String LABEL_IDTIPOVIATRANSPORTE= "Tipo Via Transporte";
		public static final String LABEL_IDTIPOVIATRANSPORTE_LOWER= "Tipo Via Transporte";
    	public static final String LABEL_IDRANGOUNIDADVENTA= "Rango Unidad Venta";
		public static final String LABEL_IDRANGOUNIDADVENTA_LOWER= "Rango Unidad Venta";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDCOLORPRODUCTO= "Color Producto";
		public static final String LABEL_IDCOLORPRODUCTO_LOWER= "Color Producto";
    	public static final String LABEL_IDCLASEPRODUCTO= "Clase Producto";
		public static final String LABEL_IDCLASEPRODUCTO_LOWER= "Clase Producto";
    	public static final String LABEL_IDEFECTOPRODUCTO= "Efecto Producto";
		public static final String LABEL_IDEFECTOPRODUCTO_LOWER= "Efecto Producto";
    	public static final String LABEL_IDMARCAPRODUCTO= "Marca Producto";
		public static final String LABEL_IDMARCAPRODUCTO_LOWER= "Marca Producto";
    	public static final String LABEL_IDMODELOPRODUCTO= "Modelo Producto";
		public static final String LABEL_IDMODELOPRODUCTO_LOWER= "Modelo Producto";
    	public static final String LABEL_IDMATERIALPRODUCTO= "Material Producto";
		public static final String LABEL_IDMATERIALPRODUCTO_LOWER= "Material Producto";
    	public static final String LABEL_IDSEGMENTOPRODUCTO= "Segmento Producto";
		public static final String LABEL_IDSEGMENTOPRODUCTO_LOWER= "Segmento Producto";
    	public static final String LABEL_IDTALLAPRODUCTO= "Talla Producto";
		public static final String LABEL_IDTALLAPRODUCTO_LOWER= "Talla Producto";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroInventarioDefectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDGRUPOBODEGA;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDCALIDADPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOSERVICIO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOCOSTEO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDRANGOUNIDADVENTA;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDPAIS)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDCIUDAD)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDCOLORPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDCLASEPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDEFECTOPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDMARCAPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDMODELOPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDMATERIALPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO;}
		if(sNombreColumna.equals(ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO)) {sLabelColumna=ParametroInventarioDefectoConstantesFunciones.LABEL_IDTALLAPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroInventarioDefectoDescripcion(ParametroInventarioDefecto parametroinventariodefecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroinventariodefecto !=null/* && parametroinventariodefecto.getId()!=0*/) {
			if(parametroinventariodefecto.getId()!=null) {
				sDescripcion=parametroinventariodefecto.getId().toString();
			}//parametroinventariodefectoparametroinventariodefecto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroInventarioDefectoDescripcionDetallado(ParametroInventarioDefecto parametroinventariodefecto) {
		String sDescripcion="";
			
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.ID+"=";
		sDescripcion+=parametroinventariodefecto.getId().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroinventariodefecto.getVersionRow().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroinventariodefecto.getid_empresa().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametroinventariodefecto.getid_sucursal().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA+"=";
		sDescripcion+=parametroinventariodefecto.getid_grupo_bodega().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_calidad_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO+"=";
		sDescripcion+=parametroinventariodefecto.getid_tipo_servicio().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN+"=";
		sDescripcion+=parametroinventariodefecto.getid_tipo_producto_servicio_inven().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=parametroinventariodefecto.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO+"=";
		sDescripcion+=parametroinventariodefecto.getid_tipo_costeo().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_tipo_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE+"=";
		sDescripcion+=parametroinventariodefecto.getid_tipo_via_transporte().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA+"=";
		sDescripcion+=parametroinventariodefecto.getid_rango_unidad_venta().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=parametroinventariodefecto.getid_pais().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=parametroinventariodefecto.getid_ciudad().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_color_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_clase_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_efecto_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_marca_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_modelo_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_material_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_segmento_producto().toString()+",";
		sDescripcion+=ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO+"=";
		sDescripcion+=parametroinventariodefecto.getid_talla_producto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroInventarioDefectoDescripcion(ParametroInventarioDefecto parametroinventariodefecto,String sValor) throws Exception {			
		if(parametroinventariodefecto !=null) {
			//parametroinventariodefectoparametroinventariodefecto.getId().toString();
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

	public static String getGrupoBodegaDescripcion(GrupoBodega grupobodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupobodega!=null/*&&grupobodega.getId()>0*/) {
			sDescripcion=GrupoBodegaConstantesFunciones.getGrupoBodegaDescripcion(grupobodega);
		}

		return sDescripcion;
	}

	public static String getCalidadProductoDescripcion(CalidadProducto calidadproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(calidadproducto!=null/*&&calidadproducto.getId()>0*/) {
			sDescripcion=CalidadProductoConstantesFunciones.getCalidadProductoDescripcion(calidadproducto);
		}

		return sDescripcion;
	}

	public static String getTipoServicioDescripcion(TipoServicio tiposervicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiposervicio!=null/*&&tiposervicio.getId()>0*/) {
			sDescripcion=TipoServicioConstantesFunciones.getTipoServicioDescripcion(tiposervicio);
		}

		return sDescripcion;
	}

	public static String getTipoProductoServicioInvenDescripcion(TipoProductoServicioInven tipoproductoservicioinven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproductoservicioinven!=null/*&&tipoproductoservicioinven.getId()>0*/) {
			sDescripcion=TipoProductoServicioInvenConstantesFunciones.getTipoProductoServicioInvenDescripcion(tipoproductoservicioinven);
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

	public static String getTipoCosteoDescripcion(TipoCosteo tipocosteo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocosteo!=null/*&&tipocosteo.getId()>0*/) {
			sDescripcion=TipoCosteoConstantesFunciones.getTipoCosteoDescripcion(tipocosteo);
		}

		return sDescripcion;
	}

	public static String getTipoProductoDescripcion(TipoProducto tipoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproducto!=null/*&&tipoproducto.getId()>0*/) {
			sDescripcion=TipoProductoConstantesFunciones.getTipoProductoDescripcion(tipoproducto);
		}

		return sDescripcion;
	}

	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoviatransporte!=null/*&&tipoviatransporte.getId()>0*/) {
			sDescripcion=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(tipoviatransporte);
		}

		return sDescripcion;
	}

	public static String getRangoUnidadVentaDescripcion(RangoUnidadVenta rangounidadventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rangounidadventa!=null/*&&rangounidadventa.getId()>0*/) {
			sDescripcion=RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcion(rangounidadventa);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getColorProductoDescripcion(ColorProducto colorproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(colorproducto!=null/*&&colorproducto.getId()>0*/) {
			sDescripcion=ColorProductoConstantesFunciones.getColorProductoDescripcion(colorproducto);
		}

		return sDescripcion;
	}

	public static String getClaseProductoDescripcion(ClaseProducto claseproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(claseproducto!=null/*&&claseproducto.getId()>0*/) {
			sDescripcion=ClaseProductoConstantesFunciones.getClaseProductoDescripcion(claseproducto);
		}

		return sDescripcion;
	}

	public static String getEfectoProductoDescripcion(EfectoProducto efectoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(efectoproducto!=null/*&&efectoproducto.getId()>0*/) {
			sDescripcion=EfectoProductoConstantesFunciones.getEfectoProductoDescripcion(efectoproducto);
		}

		return sDescripcion;
	}

	public static String getMarcaProductoDescripcion(MarcaProducto marcaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(marcaproducto!=null/*&&marcaproducto.getId()>0*/) {
			sDescripcion=MarcaProductoConstantesFunciones.getMarcaProductoDescripcion(marcaproducto);
		}

		return sDescripcion;
	}

	public static String getModeloProductoDescripcion(ModeloProducto modeloproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modeloproducto!=null/*&&modeloproducto.getId()>0*/) {
			sDescripcion=ModeloProductoConstantesFunciones.getModeloProductoDescripcion(modeloproducto);
		}

		return sDescripcion;
	}

	public static String getMaterialProductoDescripcion(MaterialProducto materialproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(materialproducto!=null/*&&materialproducto.getId()>0*/) {
			sDescripcion=MaterialProductoConstantesFunciones.getMaterialProductoDescripcion(materialproducto);
		}

		return sDescripcion;
	}

	public static String getSegmentoProductoDescripcion(SegmentoProducto segmentoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(segmentoproducto!=null/*&&segmentoproducto.getId()>0*/) {
			sDescripcion=SegmentoProductoConstantesFunciones.getSegmentoProductoDescripcion(segmentoproducto);
		}

		return sDescripcion;
	}

	public static String getTallaProductoDescripcion(TallaProducto tallaproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tallaproducto!=null/*&&tallaproducto.getId()>0*/) {
			sDescripcion=TallaProductoConstantesFunciones.getTallaProductoDescripcion(tallaproducto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCalidadProducto")) {
			sNombreIndice="Tipo=  Por Calidad Producto";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdClaseProducto")) {
			sNombreIndice="Tipo=  Por Clase Producto";
		} else if(sNombreIndice.equals("FK_IdColorProducto")) {
			sNombreIndice="Tipo=  Por Color Producto";
		} else if(sNombreIndice.equals("FK_IdEfectoProducto")) {
			sNombreIndice="Tipo=  Por Efecto Producto";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoBodega")) {
			sNombreIndice="Tipo=  Por Grupo Bodega";
		} else if(sNombreIndice.equals("FK_IdMarcaProducto")) {
			sNombreIndice="Tipo=  Por Marca Producto";
		} else if(sNombreIndice.equals("FK_IdMaterialProducto")) {
			sNombreIndice="Tipo=  Por Material Producto";
		} else if(sNombreIndice.equals("FK_IdModeloProducto")) {
			sNombreIndice="Tipo=  Por Modelo Producto";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdRangoUnidadVenta")) {
			sNombreIndice="Tipo=  Por Rango Unidad Venta";
		} else if(sNombreIndice.equals("FK_IdSegmentoProducto")) {
			sNombreIndice="Tipo=  Por Segmento Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTallaProducto")) {
			sNombreIndice="Tipo=  Por Talla Producto";
		} else if(sNombreIndice.equals("FK_IdTipoCosteo")) {
			sNombreIndice="Tipo=  Por Tipo Costeo";
		} else if(sNombreIndice.equals("FK_IdTipoProducto")) {
			sNombreIndice="Tipo=  Por Tipo Producto";
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicio")) {
			sNombreIndice="Tipo=  Por Tipo Producto Servicio";
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicioInven")) {
			sNombreIndice="Tipo=  Por Tipo Producto Servicio.";
		} else if(sNombreIndice.equals("FK_IdTipoServicio")) {
			sNombreIndice="Tipo=  Por Tipo Servicio";
		} else if(sNombreIndice.equals("FK_IdTipoViaTransporte")) {
			sNombreIndice="Tipo=  Por Tipo Via Transporte";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCalidadProducto(Long id_calidad_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_calidad_producto!=null) {sDetalleIndice+=" Codigo Unico De Calidad Producto="+id_calidad_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdClaseProducto(Long id_clase_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_clase_producto!=null) {sDetalleIndice+=" Codigo Unico De Clase Producto="+id_clase_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdColorProducto(Long id_color_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_color_producto!=null) {sDetalleIndice+=" Codigo Unico De Color Producto="+id_color_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEfectoProducto(Long id_efecto_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_efecto_producto!=null) {sDetalleIndice+=" Codigo Unico De Efecto Producto="+id_efecto_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoBodega(Long id_grupo_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_bodega!=null) {sDetalleIndice+=" Codigo Unico De Grupo Bodega="+id_grupo_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMarcaProducto(Long id_marca_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_marca_producto!=null) {sDetalleIndice+=" Codigo Unico De Marca Producto="+id_marca_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMaterialProducto(Long id_material_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_material_producto!=null) {sDetalleIndice+=" Codigo Unico De Material Producto="+id_material_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModeloProducto(Long id_modelo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_modelo_producto!=null) {sDetalleIndice+=" Codigo Unico De Modelo Producto="+id_modelo_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRangoUnidadVenta(Long id_rango_unidad_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_rango_unidad_venta!=null) {sDetalleIndice+=" Codigo Unico De Rango Unidad Venta="+id_rango_unidad_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSegmentoProducto(Long id_segmento_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_segmento_producto!=null) {sDetalleIndice+=" Codigo Unico De Segmento Producto="+id_segmento_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTallaProducto(Long id_talla_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_talla_producto!=null) {sDetalleIndice+=" Codigo Unico De Talla Producto="+id_talla_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCosteo(Long id_tipo_costeo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_costeo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Costeo="+id_tipo_costeo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProducto(Long id_tipo_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto="+id_tipo_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProductoServicio(Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProductoServicioInven(Long id_tipo_producto_servicio_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio_inven!=null) {sDetalleIndice+=" Codigo Unico De Tipo Producto Servicio.="+id_tipo_producto_servicio_inven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoServicio(Long id_tipo_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_servicio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Servicio="+id_tipo_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoViaTransporte(Long id_tipo_via_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_via_transporte!=null) {sDetalleIndice+=" Codigo Unico De Tipo Via Transporte="+id_tipo_via_transporte.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroInventarioDefectos(List<ParametroInventarioDefecto> parametroinventariodefectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroInventarioDefecto parametroinventariodefecto: parametroinventariodefectos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroinventariodefecto.getConCambioAuxiliar()) {
			parametroinventariodefecto.setIsDeleted(parametroinventariodefecto.getIsDeletedAuxiliar());	
			parametroinventariodefecto.setIsNew(parametroinventariodefecto.getIsNewAuxiliar());	
			parametroinventariodefecto.setIsChanged(parametroinventariodefecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroinventariodefecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroinventariodefecto.setIsDeletedAuxiliar(false);	
			parametroinventariodefecto.setIsNewAuxiliar(false);	
			parametroinventariodefecto.setIsChangedAuxiliar(false);
			
			parametroinventariodefecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroInventarioDefectos(List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroInventarioDefecto parametroinventariodefecto : parametroinventariodefectos) {
			if(conAsignarBase && parametroinventariodefecto.getConCambioAuxiliar()) {
				parametroinventariodefecto.setIsDeleted(parametroinventariodefecto.getIsDeletedAuxiliar());	
				parametroinventariodefecto.setIsNew(parametroinventariodefecto.getIsNewAuxiliar());	
				parametroinventariodefecto.setIsChanged(parametroinventariodefecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroinventariodefecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroinventariodefecto.setIsDeletedAuxiliar(false);	
				parametroinventariodefecto.setIsNewAuxiliar(false);	
				parametroinventariodefecto.setIsChangedAuxiliar(false);
				
				parametroinventariodefecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefecto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroInventarioDefectos(List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conEnteros) throws Exception  {
		
		for(ParametroInventarioDefecto parametroinventariodefecto: parametroinventariodefectos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroInventarioDefecto(List<ParametroInventarioDefecto> parametroinventariodefectos,ParametroInventarioDefecto parametroinventariodefectoAux) throws Exception  {
		ParametroInventarioDefectoConstantesFunciones.InicializarValoresParametroInventarioDefecto(parametroinventariodefectoAux,true);
		
		for(ParametroInventarioDefecto parametroinventariodefecto: parametroinventariodefectos) {
			if(parametroinventariodefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroInventarioDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroInventarioDefectoConstantesFunciones.getArrayColumnasGlobalesParametroInventarioDefecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroInventarioDefecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroInventarioDefectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroInventarioDefectoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroInventarioDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroInventarioDefecto> parametroinventariodefectos,ParametroInventarioDefecto parametroinventariodefecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroInventarioDefecto parametroinventariodefectoAux: parametroinventariodefectos) {
			if(parametroinventariodefectoAux!=null && parametroinventariodefecto!=null) {
				if((parametroinventariodefectoAux.getId()==null && parametroinventariodefecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroinventariodefectoAux.getId()!=null && parametroinventariodefecto.getId()!=null){
					if(parametroinventariodefectoAux.getId().equals(parametroinventariodefecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroInventarioDefecto(List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroInventarioDefecto parametroinventariodefecto: parametroinventariodefectos) {			
			if(parametroinventariodefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroInventarioDefecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_ID, ParametroInventarioDefectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_VERSIONROW, ParametroInventarioDefectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDEMPRESA, ParametroInventarioDefectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDSUCURSAL, ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDGRUPOBODEGA, ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDCALIDADPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOSERVICIO, ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN, ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO, ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOCOSTEO, ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE, ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDRANGOUNIDADVENTA, ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDPAIS, ParametroInventarioDefectoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDCIUDAD, ParametroInventarioDefectoConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDCOLORPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDCLASEPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDEFECTOPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDMARCAPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDMODELOPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDMATERIALPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroInventarioDefectoConstantesFunciones.LABEL_IDTALLAPRODUCTO, ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroInventarioDefecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroInventarioDefecto() throws Exception  {
		return ParametroInventarioDefectoConstantesFunciones.getTiposSeleccionarParametroInventarioDefecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroInventarioDefecto(Boolean conFk) throws Exception  {
		return ParametroInventarioDefectoConstantesFunciones.getTiposSeleccionarParametroInventarioDefecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroInventarioDefecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDGRUPOBODEGA);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDGRUPOBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCALIDADPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCALIDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOSERVICIO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOCOSTEO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOCOSTEO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDRANGOUNIDADVENTA);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDRANGOUNIDADVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCOLORPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCOLORPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCLASEPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCLASEPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDEFECTOPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDEFECTOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMARCAPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMARCAPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMODELOPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMODELOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMATERIALPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMATERIALPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTALLAPRODUCTO);
			reporte.setsDescripcion(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTALLAPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroInventarioDefecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefectoAux) throws Exception {
		
			parametroinventariodefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroinventariodefectoAux.getEmpresa()));
			parametroinventariodefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametroinventariodefectoAux.getSucursal()));
			parametroinventariodefectoAux.setgrupobodega_descripcion(GrupoBodegaConstantesFunciones.getGrupoBodegaDescripcion(parametroinventariodefectoAux.getGrupoBodega()));
			parametroinventariodefectoAux.setcalidadproducto_descripcion(CalidadProductoConstantesFunciones.getCalidadProductoDescripcion(parametroinventariodefectoAux.getCalidadProducto()));
			parametroinventariodefectoAux.settiposervicio_descripcion(TipoServicioConstantesFunciones.getTipoServicioDescripcion(parametroinventariodefectoAux.getTipoServicio()));
			parametroinventariodefectoAux.settipoproductoservicioinven_descripcion(TipoProductoServicioInvenConstantesFunciones.getTipoProductoServicioInvenDescripcion(parametroinventariodefectoAux.getTipoProductoServicioInven()));
			parametroinventariodefectoAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(parametroinventariodefectoAux.getTipoProductoServicio()));
			parametroinventariodefectoAux.settipocosteo_descripcion(TipoCosteoConstantesFunciones.getTipoCosteoDescripcion(parametroinventariodefectoAux.getTipoCosteo()));
			parametroinventariodefectoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(parametroinventariodefectoAux.getTipoProducto()));
			parametroinventariodefectoAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(parametroinventariodefectoAux.getTipoViaTransporte()));
			parametroinventariodefectoAux.setrangounidadventa_descripcion(RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcion(parametroinventariodefectoAux.getRangoUnidadVenta()));
			parametroinventariodefectoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametroinventariodefectoAux.getPais()));
			parametroinventariodefectoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(parametroinventariodefectoAux.getCiudad()));
			parametroinventariodefectoAux.setcolorproducto_descripcion(ColorProductoConstantesFunciones.getColorProductoDescripcion(parametroinventariodefectoAux.getColorProducto()));
			parametroinventariodefectoAux.setclaseproducto_descripcion(ClaseProductoConstantesFunciones.getClaseProductoDescripcion(parametroinventariodefectoAux.getClaseProducto()));
			parametroinventariodefectoAux.setefectoproducto_descripcion(EfectoProductoConstantesFunciones.getEfectoProductoDescripcion(parametroinventariodefectoAux.getEfectoProducto()));
			parametroinventariodefectoAux.setmarcaproducto_descripcion(MarcaProductoConstantesFunciones.getMarcaProductoDescripcion(parametroinventariodefectoAux.getMarcaProducto()));
			parametroinventariodefectoAux.setmodeloproducto_descripcion(ModeloProductoConstantesFunciones.getModeloProductoDescripcion(parametroinventariodefectoAux.getModeloProducto()));
			parametroinventariodefectoAux.setmaterialproducto_descripcion(MaterialProductoConstantesFunciones.getMaterialProductoDescripcion(parametroinventariodefectoAux.getMaterialProducto()));
			parametroinventariodefectoAux.setsegmentoproducto_descripcion(SegmentoProductoConstantesFunciones.getSegmentoProductoDescripcion(parametroinventariodefectoAux.getSegmentoProducto()));
			parametroinventariodefectoAux.settallaproducto_descripcion(TallaProductoConstantesFunciones.getTallaProductoDescripcion(parametroinventariodefectoAux.getTallaProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroInventarioDefecto(List<ParametroInventarioDefecto> parametroinventariodefectosTemp) throws Exception {
		for(ParametroInventarioDefecto parametroinventariodefectoAux:parametroinventariodefectosTemp) {
			
			parametroinventariodefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroinventariodefectoAux.getEmpresa()));
			parametroinventariodefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametroinventariodefectoAux.getSucursal()));
			parametroinventariodefectoAux.setgrupobodega_descripcion(GrupoBodegaConstantesFunciones.getGrupoBodegaDescripcion(parametroinventariodefectoAux.getGrupoBodega()));
			parametroinventariodefectoAux.setcalidadproducto_descripcion(CalidadProductoConstantesFunciones.getCalidadProductoDescripcion(parametroinventariodefectoAux.getCalidadProducto()));
			parametroinventariodefectoAux.settiposervicio_descripcion(TipoServicioConstantesFunciones.getTipoServicioDescripcion(parametroinventariodefectoAux.getTipoServicio()));
			parametroinventariodefectoAux.settipoproductoservicioinven_descripcion(TipoProductoServicioInvenConstantesFunciones.getTipoProductoServicioInvenDescripcion(parametroinventariodefectoAux.getTipoProductoServicioInven()));
			parametroinventariodefectoAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(parametroinventariodefectoAux.getTipoProductoServicio()));
			parametroinventariodefectoAux.settipocosteo_descripcion(TipoCosteoConstantesFunciones.getTipoCosteoDescripcion(parametroinventariodefectoAux.getTipoCosteo()));
			parametroinventariodefectoAux.settipoproducto_descripcion(TipoProductoConstantesFunciones.getTipoProductoDescripcion(parametroinventariodefectoAux.getTipoProducto()));
			parametroinventariodefectoAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(parametroinventariodefectoAux.getTipoViaTransporte()));
			parametroinventariodefectoAux.setrangounidadventa_descripcion(RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcion(parametroinventariodefectoAux.getRangoUnidadVenta()));
			parametroinventariodefectoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametroinventariodefectoAux.getPais()));
			parametroinventariodefectoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(parametroinventariodefectoAux.getCiudad()));
			parametroinventariodefectoAux.setcolorproducto_descripcion(ColorProductoConstantesFunciones.getColorProductoDescripcion(parametroinventariodefectoAux.getColorProducto()));
			parametroinventariodefectoAux.setclaseproducto_descripcion(ClaseProductoConstantesFunciones.getClaseProductoDescripcion(parametroinventariodefectoAux.getClaseProducto()));
			parametroinventariodefectoAux.setefectoproducto_descripcion(EfectoProductoConstantesFunciones.getEfectoProductoDescripcion(parametroinventariodefectoAux.getEfectoProducto()));
			parametroinventariodefectoAux.setmarcaproducto_descripcion(MarcaProductoConstantesFunciones.getMarcaProductoDescripcion(parametroinventariodefectoAux.getMarcaProducto()));
			parametroinventariodefectoAux.setmodeloproducto_descripcion(ModeloProductoConstantesFunciones.getModeloProductoDescripcion(parametroinventariodefectoAux.getModeloProducto()));
			parametroinventariodefectoAux.setmaterialproducto_descripcion(MaterialProductoConstantesFunciones.getMaterialProductoDescripcion(parametroinventariodefectoAux.getMaterialProducto()));
			parametroinventariodefectoAux.setsegmentoproducto_descripcion(SegmentoProductoConstantesFunciones.getSegmentoProductoDescripcion(parametroinventariodefectoAux.getSegmentoProducto()));
			parametroinventariodefectoAux.settallaproducto_descripcion(TallaProductoConstantesFunciones.getTallaProductoDescripcion(parametroinventariodefectoAux.getTallaProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroInventarioDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(GrupoBodega.class));
				classes.add(new Classe(CalidadProducto.class));
				classes.add(new Classe(TipoServicio.class));
				classes.add(new Classe(TipoProductoServicioInven.class));
				classes.add(new Classe(TipoProductoServicio.class));
				classes.add(new Classe(TipoCosteo.class));
				classes.add(new Classe(TipoProducto.class));
				classes.add(new Classe(TipoViaTransporte.class));
				classes.add(new Classe(RangoUnidadVenta.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(ColorProducto.class));
				classes.add(new Classe(ClaseProducto.class));
				classes.add(new Classe(EfectoProducto.class));
				classes.add(new Classe(MarcaProducto.class));
				classes.add(new Classe(ModeloProducto.class));
				classes.add(new Classe(MaterialProducto.class));
				classes.add(new Classe(SegmentoProducto.class));
				classes.add(new Classe(TallaProducto.class));
				
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
					if(clas.clas.equals(GrupoBodega.class)) {
						classes.add(new Classe(GrupoBodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CalidadProducto.class)) {
						classes.add(new Classe(CalidadProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoServicio.class)) {
						classes.add(new Classe(TipoServicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProductoServicioInven.class)) {
						classes.add(new Classe(TipoProductoServicioInven.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProductoServicio.class)) {
						classes.add(new Classe(TipoProductoServicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCosteo.class)) {
						classes.add(new Classe(TipoCosteo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProducto.class)) {
						classes.add(new Classe(TipoProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoViaTransporte.class)) {
						classes.add(new Classe(TipoViaTransporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RangoUnidadVenta.class)) {
						classes.add(new Classe(RangoUnidadVenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ColorProducto.class)) {
						classes.add(new Classe(ColorProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ClaseProducto.class)) {
						classes.add(new Classe(ClaseProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EfectoProducto.class)) {
						classes.add(new Classe(EfectoProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MarcaProducto.class)) {
						classes.add(new Classe(MarcaProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ModeloProducto.class)) {
						classes.add(new Classe(ModeloProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MaterialProducto.class)) {
						classes.add(new Classe(MaterialProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SegmentoProducto.class)) {
						classes.add(new Classe(SegmentoProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TallaProducto.class)) {
						classes.add(new Classe(TallaProducto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroInventarioDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(GrupoBodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoBodega.class)); continue;
					}

					if(CalidadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalidadProducto.class)); continue;
					}

					if(TipoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoServicio.class)); continue;
					}

					if(TipoProductoServicioInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicioInven.class)); continue;
					}

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
					}

					if(TipoCosteo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosteo.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(RangoUnidadVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RangoUnidadVenta.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
					}

					if(ClaseProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClaseProducto.class)); continue;
					}

					if(EfectoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EfectoProducto.class)); continue;
					}

					if(MarcaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MarcaProducto.class)); continue;
					}

					if(ModeloProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ModeloProducto.class)); continue;
					}

					if(MaterialProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MaterialProducto.class)); continue;
					}

					if(SegmentoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SegmentoProducto.class)); continue;
					}

					if(TallaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaProducto.class)); continue;
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

					if(GrupoBodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoBodega.class)); continue;
					}

					if(CalidadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CalidadProducto.class)); continue;
					}

					if(TipoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoServicio.class)); continue;
					}

					if(TipoProductoServicioInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicioInven.class)); continue;
					}

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
					}

					if(TipoCosteo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosteo.class)); continue;
					}

					if(TipoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProducto.class)); continue;
					}

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
					}

					if(RangoUnidadVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RangoUnidadVenta.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
					}

					if(ClaseProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ClaseProducto.class)); continue;
					}

					if(EfectoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EfectoProducto.class)); continue;
					}

					if(MarcaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MarcaProducto.class)); continue;
					}

					if(ModeloProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ModeloProducto.class)); continue;
					}

					if(MaterialProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MaterialProducto.class)); continue;
					}

					if(SegmentoProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SegmentoProducto.class)); continue;
					}

					if(TallaProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TallaProducto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroInventarioDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroInventarioDefectoConstantesFunciones.getClassesRelationshipsOfParametroInventarioDefecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroInventarioDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroInventarioDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroInventarioDefectoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroInventarioDefecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroInventarioDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroInventarioDefecto parametroinventariodefecto,List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroInventarioDefecto parametroinventariodefectoEncontrado=null;
			
			for(ParametroInventarioDefecto parametroinventariodefectoLocal:parametroinventariodefectos) {
				if(parametroinventariodefectoLocal.getId().equals(parametroinventariodefecto.getId())) {
					parametroinventariodefectoEncontrado=parametroinventariodefectoLocal;
					
					parametroinventariodefectoLocal.setIsChanged(parametroinventariodefecto.getIsChanged());
					parametroinventariodefectoLocal.setIsNew(parametroinventariodefecto.getIsNew());
					parametroinventariodefectoLocal.setIsDeleted(parametroinventariodefecto.getIsDeleted());
					
					parametroinventariodefectoLocal.setGeneralEntityOriginal(parametroinventariodefecto.getGeneralEntityOriginal());
					
					parametroinventariodefectoLocal.setId(parametroinventariodefecto.getId());	
					parametroinventariodefectoLocal.setVersionRow(parametroinventariodefecto.getVersionRow());	
					parametroinventariodefectoLocal.setid_empresa(parametroinventariodefecto.getid_empresa());	
					parametroinventariodefectoLocal.setid_sucursal(parametroinventariodefecto.getid_sucursal());	
					parametroinventariodefectoLocal.setid_grupo_bodega(parametroinventariodefecto.getid_grupo_bodega());	
					parametroinventariodefectoLocal.setid_calidad_producto(parametroinventariodefecto.getid_calidad_producto());	
					parametroinventariodefectoLocal.setid_tipo_servicio(parametroinventariodefecto.getid_tipo_servicio());	
					parametroinventariodefectoLocal.setid_tipo_producto_servicio_inven(parametroinventariodefecto.getid_tipo_producto_servicio_inven());	
					parametroinventariodefectoLocal.setid_tipo_producto_servicio(parametroinventariodefecto.getid_tipo_producto_servicio());	
					parametroinventariodefectoLocal.setid_tipo_costeo(parametroinventariodefecto.getid_tipo_costeo());	
					parametroinventariodefectoLocal.setid_tipo_producto(parametroinventariodefecto.getid_tipo_producto());	
					parametroinventariodefectoLocal.setid_tipo_via_transporte(parametroinventariodefecto.getid_tipo_via_transporte());	
					parametroinventariodefectoLocal.setid_rango_unidad_venta(parametroinventariodefecto.getid_rango_unidad_venta());	
					parametroinventariodefectoLocal.setid_pais(parametroinventariodefecto.getid_pais());	
					parametroinventariodefectoLocal.setid_ciudad(parametroinventariodefecto.getid_ciudad());	
					parametroinventariodefectoLocal.setid_color_producto(parametroinventariodefecto.getid_color_producto());	
					parametroinventariodefectoLocal.setid_clase_producto(parametroinventariodefecto.getid_clase_producto());	
					parametroinventariodefectoLocal.setid_efecto_producto(parametroinventariodefecto.getid_efecto_producto());	
					parametroinventariodefectoLocal.setid_marca_producto(parametroinventariodefecto.getid_marca_producto());	
					parametroinventariodefectoLocal.setid_modelo_producto(parametroinventariodefecto.getid_modelo_producto());	
					parametroinventariodefectoLocal.setid_material_producto(parametroinventariodefecto.getid_material_producto());	
					parametroinventariodefectoLocal.setid_segmento_producto(parametroinventariodefecto.getid_segmento_producto());	
					parametroinventariodefectoLocal.setid_talla_producto(parametroinventariodefecto.getid_talla_producto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametroinventariodefecto.getIsDeleted()) {
				if(!existe) {
					parametroinventariodefectos.add(parametroinventariodefecto);
				}
			} else {
				if(parametroinventariodefectoEncontrado!=null && permiteQuitar)  {
					parametroinventariodefectos.remove(parametroinventariodefectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroInventarioDefecto parametroinventariodefecto,List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception {
		try	{			
			for(ParametroInventarioDefecto parametroinventariodefectoLocal:parametroinventariodefectos) {
				if(parametroinventariodefectoLocal.getId().equals(parametroinventariodefecto.getId())) {
					parametroinventariodefectoLocal.setIsSelected(parametroinventariodefecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroInventarioDefecto(List<ParametroInventarioDefecto> parametroinventariodefectosAux) throws Exception {
		//this.parametroinventariodefectosAux=parametroinventariodefectosAux;
		
		for(ParametroInventarioDefecto parametroinventariodefectoAux:parametroinventariodefectosAux) {
			if(parametroinventariodefectoAux.getIsChanged()) {
				parametroinventariodefectoAux.setIsChanged(false);
			}		
			
			if(parametroinventariodefectoAux.getIsNew()) {
				parametroinventariodefectoAux.setIsNew(false);
			}	
			
			if(parametroinventariodefectoAux.getIsDeleted()) {
				parametroinventariodefectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefectoAux) throws Exception {
		//this.parametroinventariodefectoAux=parametroinventariodefectoAux;
		
			if(parametroinventariodefectoAux.getIsChanged()) {
				parametroinventariodefectoAux.setIsChanged(false);
			}		
			
			if(parametroinventariodefectoAux.getIsNew()) {
				parametroinventariodefectoAux.setIsNew(false);
			}	
			
			if(parametroinventariodefectoAux.getIsDeleted()) {
				parametroinventariodefectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroInventarioDefecto parametroinventariodefectoAsignar,ParametroInventarioDefecto parametroinventariodefecto) throws Exception {
		parametroinventariodefectoAsignar.setId(parametroinventariodefecto.getId());	
		parametroinventariodefectoAsignar.setVersionRow(parametroinventariodefecto.getVersionRow());	
		parametroinventariodefectoAsignar.setid_empresa(parametroinventariodefecto.getid_empresa());
		parametroinventariodefectoAsignar.setempresa_descripcion(parametroinventariodefecto.getempresa_descripcion());	
		parametroinventariodefectoAsignar.setid_sucursal(parametroinventariodefecto.getid_sucursal());
		parametroinventariodefectoAsignar.setsucursal_descripcion(parametroinventariodefecto.getsucursal_descripcion());	
		parametroinventariodefectoAsignar.setid_grupo_bodega(parametroinventariodefecto.getid_grupo_bodega());
		parametroinventariodefectoAsignar.setgrupobodega_descripcion(parametroinventariodefecto.getgrupobodega_descripcion());	
		parametroinventariodefectoAsignar.setid_calidad_producto(parametroinventariodefecto.getid_calidad_producto());
		parametroinventariodefectoAsignar.setcalidadproducto_descripcion(parametroinventariodefecto.getcalidadproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_tipo_servicio(parametroinventariodefecto.getid_tipo_servicio());
		parametroinventariodefectoAsignar.settiposervicio_descripcion(parametroinventariodefecto.gettiposervicio_descripcion());	
		parametroinventariodefectoAsignar.setid_tipo_producto_servicio_inven(parametroinventariodefecto.getid_tipo_producto_servicio_inven());
		parametroinventariodefectoAsignar.settipoproductoservicioinven_descripcion(parametroinventariodefecto.gettipoproductoservicioinven_descripcion());	
		parametroinventariodefectoAsignar.setid_tipo_producto_servicio(parametroinventariodefecto.getid_tipo_producto_servicio());
		parametroinventariodefectoAsignar.settipoproductoservicio_descripcion(parametroinventariodefecto.gettipoproductoservicio_descripcion());	
		parametroinventariodefectoAsignar.setid_tipo_costeo(parametroinventariodefecto.getid_tipo_costeo());
		parametroinventariodefectoAsignar.settipocosteo_descripcion(parametroinventariodefecto.gettipocosteo_descripcion());	
		parametroinventariodefectoAsignar.setid_tipo_producto(parametroinventariodefecto.getid_tipo_producto());
		parametroinventariodefectoAsignar.settipoproducto_descripcion(parametroinventariodefecto.gettipoproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_tipo_via_transporte(parametroinventariodefecto.getid_tipo_via_transporte());
		parametroinventariodefectoAsignar.settipoviatransporte_descripcion(parametroinventariodefecto.gettipoviatransporte_descripcion());	
		parametroinventariodefectoAsignar.setid_rango_unidad_venta(parametroinventariodefecto.getid_rango_unidad_venta());
		parametroinventariodefectoAsignar.setrangounidadventa_descripcion(parametroinventariodefecto.getrangounidadventa_descripcion());	
		parametroinventariodefectoAsignar.setid_pais(parametroinventariodefecto.getid_pais());
		parametroinventariodefectoAsignar.setpais_descripcion(parametroinventariodefecto.getpais_descripcion());	
		parametroinventariodefectoAsignar.setid_ciudad(parametroinventariodefecto.getid_ciudad());
		parametroinventariodefectoAsignar.setciudad_descripcion(parametroinventariodefecto.getciudad_descripcion());	
		parametroinventariodefectoAsignar.setid_color_producto(parametroinventariodefecto.getid_color_producto());
		parametroinventariodefectoAsignar.setcolorproducto_descripcion(parametroinventariodefecto.getcolorproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_clase_producto(parametroinventariodefecto.getid_clase_producto());
		parametroinventariodefectoAsignar.setclaseproducto_descripcion(parametroinventariodefecto.getclaseproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_efecto_producto(parametroinventariodefecto.getid_efecto_producto());
		parametroinventariodefectoAsignar.setefectoproducto_descripcion(parametroinventariodefecto.getefectoproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_marca_producto(parametroinventariodefecto.getid_marca_producto());
		parametroinventariodefectoAsignar.setmarcaproducto_descripcion(parametroinventariodefecto.getmarcaproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_modelo_producto(parametroinventariodefecto.getid_modelo_producto());
		parametroinventariodefectoAsignar.setmodeloproducto_descripcion(parametroinventariodefecto.getmodeloproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_material_producto(parametroinventariodefecto.getid_material_producto());
		parametroinventariodefectoAsignar.setmaterialproducto_descripcion(parametroinventariodefecto.getmaterialproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_segmento_producto(parametroinventariodefecto.getid_segmento_producto());
		parametroinventariodefectoAsignar.setsegmentoproducto_descripcion(parametroinventariodefecto.getsegmentoproducto_descripcion());	
		parametroinventariodefectoAsignar.setid_talla_producto(parametroinventariodefecto.getid_talla_producto());
		parametroinventariodefectoAsignar.settallaproducto_descripcion(parametroinventariodefecto.gettallaproducto_descripcion());	
	}
	
	public static void inicializarParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefecto) throws Exception {
		try {
				parametroinventariodefecto.setId(0L);	
					
				parametroinventariodefecto.setid_empresa(-1L);	
				parametroinventariodefecto.setid_sucursal(-1L);	
				parametroinventariodefecto.setid_grupo_bodega(-1L);	
				parametroinventariodefecto.setid_calidad_producto(-1L);	
				parametroinventariodefecto.setid_tipo_servicio(-1L);	
				parametroinventariodefecto.setid_tipo_producto_servicio_inven(-1L);	
				parametroinventariodefecto.setid_tipo_producto_servicio(-1L);	
				parametroinventariodefecto.setid_tipo_costeo(-1L);	
				parametroinventariodefecto.setid_tipo_producto(-1L);	
				parametroinventariodefecto.setid_tipo_via_transporte(-1L);	
				parametroinventariodefecto.setid_rango_unidad_venta(-1L);	
				parametroinventariodefecto.setid_pais(-1L);	
				parametroinventariodefecto.setid_ciudad(-1L);	
				parametroinventariodefecto.setid_color_producto(-1L);	
				parametroinventariodefecto.setid_clase_producto(-1L);	
				parametroinventariodefecto.setid_efecto_producto(-1L);	
				parametroinventariodefecto.setid_marca_producto(-1L);	
				parametroinventariodefecto.setid_modelo_producto(-1L);	
				parametroinventariodefecto.setid_material_producto(-1L);	
				parametroinventariodefecto.setid_segmento_producto(-1L);	
				parametroinventariodefecto.setid_talla_producto(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroInventarioDefecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDGRUPOBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCALIDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIOINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOCOSTEO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDRANGOUNIDADVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCOLORPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDCLASEPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDEFECTOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMARCAPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMODELOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDMATERIALPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDSEGMENTOPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroInventarioDefectoConstantesFunciones.LABEL_IDTALLAPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroInventarioDefecto(String sTipo,Row row,Workbook workbook,ParametroInventarioDefecto parametroinventariodefecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getgrupobodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getcalidadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.gettiposervicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.gettipoproductoservicioinven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.gettipocosteo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.gettipoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.gettipoviatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getrangounidadventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getcolorproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getclaseproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getefectoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getmarcaproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getmodeloproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getmaterialproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.getsegmentoproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroinventariodefecto.gettallaproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroInventarioDefecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroInventarioDefecto() {
		return this.sFinalQueryParametroInventarioDefecto;
	}
	
	public void setsFinalQueryParametroInventarioDefecto(String sFinalQueryParametroInventarioDefecto) {
		this.sFinalQueryParametroInventarioDefecto= sFinalQueryParametroInventarioDefecto;
	}
	
	public Border resaltarSeleccionarParametroInventarioDefecto=null;
	
	public Border setResaltarSeleccionarParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroInventarioDefecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroInventarioDefecto() {
		return this.resaltarSeleccionarParametroInventarioDefecto;
	}
	
	public void setResaltarSeleccionarParametroInventarioDefecto(Border borderResaltarSeleccionarParametroInventarioDefecto) {
		this.resaltarSeleccionarParametroInventarioDefecto= borderResaltarSeleccionarParametroInventarioDefecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroInventarioDefecto=null;
	public Boolean mostraridParametroInventarioDefecto=true;
	public Boolean activaridParametroInventarioDefecto=true;

	public Border resaltarid_empresaParametroInventarioDefecto=null;
	public Boolean mostrarid_empresaParametroInventarioDefecto=true;
	public Boolean activarid_empresaParametroInventarioDefecto=true;
	public Boolean cargarid_empresaParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroInventarioDefecto=null;
	public Boolean mostrarid_sucursalParametroInventarioDefecto=true;
	public Boolean activarid_sucursalParametroInventarioDefecto=true;
	public Boolean cargarid_sucursalParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_grupo_bodegaParametroInventarioDefecto=null;
	public Boolean mostrarid_grupo_bodegaParametroInventarioDefecto=true;
	public Boolean activarid_grupo_bodegaParametroInventarioDefecto=true;
	public Boolean cargarid_grupo_bodegaParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_bodegaParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_calidad_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_calidad_productoParametroInventarioDefecto=true;
	public Boolean activarid_calidad_productoParametroInventarioDefecto=true;
	public Boolean cargarid_calidad_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_calidad_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_servicioParametroInventarioDefecto=null;
	public Boolean mostrarid_tipo_servicioParametroInventarioDefecto=true;
	public Boolean activarid_tipo_servicioParametroInventarioDefecto=true;
	public Boolean cargarid_tipo_servicioParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_servicioParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicio_invenParametroInventarioDefecto=null;
	public Boolean mostrarid_tipo_producto_servicio_invenParametroInventarioDefecto=true;
	public Boolean activarid_tipo_producto_servicio_invenParametroInventarioDefecto=true;
	public Boolean cargarid_tipo_producto_servicio_invenParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicio_invenParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioParametroInventarioDefecto=null;
	public Boolean mostrarid_tipo_producto_servicioParametroInventarioDefecto=true;
	public Boolean activarid_tipo_producto_servicioParametroInventarioDefecto=true;
	public Boolean cargarid_tipo_producto_servicioParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_costeoParametroInventarioDefecto=null;
	public Boolean mostrarid_tipo_costeoParametroInventarioDefecto=true;
	public Boolean activarid_tipo_costeoParametroInventarioDefecto=true;
	public Boolean cargarid_tipo_costeoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_costeoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_tipo_productoParametroInventarioDefecto=true;
	public Boolean activarid_tipo_productoParametroInventarioDefecto=true;
	public Boolean cargarid_tipo_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_via_transporteParametroInventarioDefecto=null;
	public Boolean mostrarid_tipo_via_transporteParametroInventarioDefecto=true;
	public Boolean activarid_tipo_via_transporteParametroInventarioDefecto=true;
	public Boolean cargarid_tipo_via_transporteParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_via_transporteParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_rango_unidad_ventaParametroInventarioDefecto=null;
	public Boolean mostrarid_rango_unidad_ventaParametroInventarioDefecto=true;
	public Boolean activarid_rango_unidad_ventaParametroInventarioDefecto=true;
	public Boolean cargarid_rango_unidad_ventaParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rango_unidad_ventaParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_paisParametroInventarioDefecto=null;
	public Boolean mostrarid_paisParametroInventarioDefecto=true;
	public Boolean activarid_paisParametroInventarioDefecto=true;
	public Boolean cargarid_paisParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_ciudadParametroInventarioDefecto=null;
	public Boolean mostrarid_ciudadParametroInventarioDefecto=true;
	public Boolean activarid_ciudadParametroInventarioDefecto=true;
	public Boolean cargarid_ciudadParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_color_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_color_productoParametroInventarioDefecto=true;
	public Boolean activarid_color_productoParametroInventarioDefecto=true;
	public Boolean cargarid_color_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_color_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_clase_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_clase_productoParametroInventarioDefecto=true;
	public Boolean activarid_clase_productoParametroInventarioDefecto=true;
	public Boolean cargarid_clase_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clase_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_efecto_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_efecto_productoParametroInventarioDefecto=true;
	public Boolean activarid_efecto_productoParametroInventarioDefecto=true;
	public Boolean cargarid_efecto_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_efecto_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_marca_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_marca_productoParametroInventarioDefecto=true;
	public Boolean activarid_marca_productoParametroInventarioDefecto=true;
	public Boolean cargarid_marca_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_marca_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_modelo_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_modelo_productoParametroInventarioDefecto=true;
	public Boolean activarid_modelo_productoParametroInventarioDefecto=true;
	public Boolean cargarid_modelo_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_modelo_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_material_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_material_productoParametroInventarioDefecto=true;
	public Boolean activarid_material_productoParametroInventarioDefecto=true;
	public Boolean cargarid_material_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_material_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_segmento_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_segmento_productoParametroInventarioDefecto=true;
	public Boolean activarid_segmento_productoParametroInventarioDefecto=true;
	public Boolean cargarid_segmento_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_segmento_productoParametroInventarioDefecto=false;//ConEventDepend=true

	public Border resaltarid_talla_productoParametroInventarioDefecto=null;
	public Boolean mostrarid_talla_productoParametroInventarioDefecto=true;
	public Boolean activarid_talla_productoParametroInventarioDefecto=true;
	public Boolean cargarid_talla_productoParametroInventarioDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_talla_productoParametroInventarioDefecto=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltaridParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroInventarioDefecto() {
		return this.resaltaridParametroInventarioDefecto;
	}

	public void setResaltaridParametroInventarioDefecto(Border borderResaltar) {
		this.resaltaridParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostraridParametroInventarioDefecto() {
		return this.mostraridParametroInventarioDefecto;
	}

	public void setMostraridParametroInventarioDefecto(Boolean mostraridParametroInventarioDefecto) {
		this.mostraridParametroInventarioDefecto= mostraridParametroInventarioDefecto;
	}

	public Boolean getActivaridParametroInventarioDefecto() {
		return this.activaridParametroInventarioDefecto;
	}

	public void setActivaridParametroInventarioDefecto(Boolean activaridParametroInventarioDefecto) {
		this.activaridParametroInventarioDefecto= activaridParametroInventarioDefecto;
	}

	public Border setResaltarid_empresaParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroInventarioDefecto() {
		return this.resaltarid_empresaParametroInventarioDefecto;
	}

	public void setResaltarid_empresaParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_empresaParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroInventarioDefecto() {
		return this.mostrarid_empresaParametroInventarioDefecto;
	}

	public void setMostrarid_empresaParametroInventarioDefecto(Boolean mostrarid_empresaParametroInventarioDefecto) {
		this.mostrarid_empresaParametroInventarioDefecto= mostrarid_empresaParametroInventarioDefecto;
	}

	public Boolean getActivarid_empresaParametroInventarioDefecto() {
		return this.activarid_empresaParametroInventarioDefecto;
	}

	public void setActivarid_empresaParametroInventarioDefecto(Boolean activarid_empresaParametroInventarioDefecto) {
		this.activarid_empresaParametroInventarioDefecto= activarid_empresaParametroInventarioDefecto;
	}

	public Boolean getCargarid_empresaParametroInventarioDefecto() {
		return this.cargarid_empresaParametroInventarioDefecto;
	}

	public void setCargarid_empresaParametroInventarioDefecto(Boolean cargarid_empresaParametroInventarioDefecto) {
		this.cargarid_empresaParametroInventarioDefecto= cargarid_empresaParametroInventarioDefecto;
	}

	public Border setResaltarid_sucursalParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroInventarioDefecto() {
		return this.resaltarid_sucursalParametroInventarioDefecto;
	}

	public void setResaltarid_sucursalParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_sucursalParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroInventarioDefecto() {
		return this.mostrarid_sucursalParametroInventarioDefecto;
	}

	public void setMostrarid_sucursalParametroInventarioDefecto(Boolean mostrarid_sucursalParametroInventarioDefecto) {
		this.mostrarid_sucursalParametroInventarioDefecto= mostrarid_sucursalParametroInventarioDefecto;
	}

	public Boolean getActivarid_sucursalParametroInventarioDefecto() {
		return this.activarid_sucursalParametroInventarioDefecto;
	}

	public void setActivarid_sucursalParametroInventarioDefecto(Boolean activarid_sucursalParametroInventarioDefecto) {
		this.activarid_sucursalParametroInventarioDefecto= activarid_sucursalParametroInventarioDefecto;
	}

	public Boolean getCargarid_sucursalParametroInventarioDefecto() {
		return this.cargarid_sucursalParametroInventarioDefecto;
	}

	public void setCargarid_sucursalParametroInventarioDefecto(Boolean cargarid_sucursalParametroInventarioDefecto) {
		this.cargarid_sucursalParametroInventarioDefecto= cargarid_sucursalParametroInventarioDefecto;
	}

	public Border setResaltarid_grupo_bodegaParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_grupo_bodegaParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_bodegaParametroInventarioDefecto() {
		return this.resaltarid_grupo_bodegaParametroInventarioDefecto;
	}

	public void setResaltarid_grupo_bodegaParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_grupo_bodegaParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_grupo_bodegaParametroInventarioDefecto() {
		return this.mostrarid_grupo_bodegaParametroInventarioDefecto;
	}

	public void setMostrarid_grupo_bodegaParametroInventarioDefecto(Boolean mostrarid_grupo_bodegaParametroInventarioDefecto) {
		this.mostrarid_grupo_bodegaParametroInventarioDefecto= mostrarid_grupo_bodegaParametroInventarioDefecto;
	}

	public Boolean getActivarid_grupo_bodegaParametroInventarioDefecto() {
		return this.activarid_grupo_bodegaParametroInventarioDefecto;
	}

	public void setActivarid_grupo_bodegaParametroInventarioDefecto(Boolean activarid_grupo_bodegaParametroInventarioDefecto) {
		this.activarid_grupo_bodegaParametroInventarioDefecto= activarid_grupo_bodegaParametroInventarioDefecto;
	}

	public Boolean getCargarid_grupo_bodegaParametroInventarioDefecto() {
		return this.cargarid_grupo_bodegaParametroInventarioDefecto;
	}

	public void setCargarid_grupo_bodegaParametroInventarioDefecto(Boolean cargarid_grupo_bodegaParametroInventarioDefecto) {
		this.cargarid_grupo_bodegaParametroInventarioDefecto= cargarid_grupo_bodegaParametroInventarioDefecto;
	}

	public Border setResaltarid_calidad_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_calidad_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_calidad_productoParametroInventarioDefecto() {
		return this.resaltarid_calidad_productoParametroInventarioDefecto;
	}

	public void setResaltarid_calidad_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_calidad_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_calidad_productoParametroInventarioDefecto() {
		return this.mostrarid_calidad_productoParametroInventarioDefecto;
	}

	public void setMostrarid_calidad_productoParametroInventarioDefecto(Boolean mostrarid_calidad_productoParametroInventarioDefecto) {
		this.mostrarid_calidad_productoParametroInventarioDefecto= mostrarid_calidad_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_calidad_productoParametroInventarioDefecto() {
		return this.activarid_calidad_productoParametroInventarioDefecto;
	}

	public void setActivarid_calidad_productoParametroInventarioDefecto(Boolean activarid_calidad_productoParametroInventarioDefecto) {
		this.activarid_calidad_productoParametroInventarioDefecto= activarid_calidad_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_calidad_productoParametroInventarioDefecto() {
		return this.cargarid_calidad_productoParametroInventarioDefecto;
	}

	public void setCargarid_calidad_productoParametroInventarioDefecto(Boolean cargarid_calidad_productoParametroInventarioDefecto) {
		this.cargarid_calidad_productoParametroInventarioDefecto= cargarid_calidad_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_tipo_servicioParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_servicioParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_servicioParametroInventarioDefecto() {
		return this.resaltarid_tipo_servicioParametroInventarioDefecto;
	}

	public void setResaltarid_tipo_servicioParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_tipo_servicioParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_servicioParametroInventarioDefecto() {
		return this.mostrarid_tipo_servicioParametroInventarioDefecto;
	}

	public void setMostrarid_tipo_servicioParametroInventarioDefecto(Boolean mostrarid_tipo_servicioParametroInventarioDefecto) {
		this.mostrarid_tipo_servicioParametroInventarioDefecto= mostrarid_tipo_servicioParametroInventarioDefecto;
	}

	public Boolean getActivarid_tipo_servicioParametroInventarioDefecto() {
		return this.activarid_tipo_servicioParametroInventarioDefecto;
	}

	public void setActivarid_tipo_servicioParametroInventarioDefecto(Boolean activarid_tipo_servicioParametroInventarioDefecto) {
		this.activarid_tipo_servicioParametroInventarioDefecto= activarid_tipo_servicioParametroInventarioDefecto;
	}

	public Boolean getCargarid_tipo_servicioParametroInventarioDefecto() {
		return this.cargarid_tipo_servicioParametroInventarioDefecto;
	}

	public void setCargarid_tipo_servicioParametroInventarioDefecto(Boolean cargarid_tipo_servicioParametroInventarioDefecto) {
		this.cargarid_tipo_servicioParametroInventarioDefecto= cargarid_tipo_servicioParametroInventarioDefecto;
	}

	public Border setResaltarid_tipo_producto_servicio_invenParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicio_invenParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicio_invenParametroInventarioDefecto() {
		return this.resaltarid_tipo_producto_servicio_invenParametroInventarioDefecto;
	}

	public void setResaltarid_tipo_producto_servicio_invenParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicio_invenParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicio_invenParametroInventarioDefecto() {
		return this.mostrarid_tipo_producto_servicio_invenParametroInventarioDefecto;
	}

	public void setMostrarid_tipo_producto_servicio_invenParametroInventarioDefecto(Boolean mostrarid_tipo_producto_servicio_invenParametroInventarioDefecto) {
		this.mostrarid_tipo_producto_servicio_invenParametroInventarioDefecto= mostrarid_tipo_producto_servicio_invenParametroInventarioDefecto;
	}

	public Boolean getActivarid_tipo_producto_servicio_invenParametroInventarioDefecto() {
		return this.activarid_tipo_producto_servicio_invenParametroInventarioDefecto;
	}

	public void setActivarid_tipo_producto_servicio_invenParametroInventarioDefecto(Boolean activarid_tipo_producto_servicio_invenParametroInventarioDefecto) {
		this.activarid_tipo_producto_servicio_invenParametroInventarioDefecto= activarid_tipo_producto_servicio_invenParametroInventarioDefecto;
	}

	public Boolean getCargarid_tipo_producto_servicio_invenParametroInventarioDefecto() {
		return this.cargarid_tipo_producto_servicio_invenParametroInventarioDefecto;
	}

	public void setCargarid_tipo_producto_servicio_invenParametroInventarioDefecto(Boolean cargarid_tipo_producto_servicio_invenParametroInventarioDefecto) {
		this.cargarid_tipo_producto_servicio_invenParametroInventarioDefecto= cargarid_tipo_producto_servicio_invenParametroInventarioDefecto;
	}

	public Border setResaltarid_tipo_producto_servicioParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioParametroInventarioDefecto() {
		return this.resaltarid_tipo_producto_servicioParametroInventarioDefecto;
	}

	public void setResaltarid_tipo_producto_servicioParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioParametroInventarioDefecto() {
		return this.mostrarid_tipo_producto_servicioParametroInventarioDefecto;
	}

	public void setMostrarid_tipo_producto_servicioParametroInventarioDefecto(Boolean mostrarid_tipo_producto_servicioParametroInventarioDefecto) {
		this.mostrarid_tipo_producto_servicioParametroInventarioDefecto= mostrarid_tipo_producto_servicioParametroInventarioDefecto;
	}

	public Boolean getActivarid_tipo_producto_servicioParametroInventarioDefecto() {
		return this.activarid_tipo_producto_servicioParametroInventarioDefecto;
	}

	public void setActivarid_tipo_producto_servicioParametroInventarioDefecto(Boolean activarid_tipo_producto_servicioParametroInventarioDefecto) {
		this.activarid_tipo_producto_servicioParametroInventarioDefecto= activarid_tipo_producto_servicioParametroInventarioDefecto;
	}

	public Boolean getCargarid_tipo_producto_servicioParametroInventarioDefecto() {
		return this.cargarid_tipo_producto_servicioParametroInventarioDefecto;
	}

	public void setCargarid_tipo_producto_servicioParametroInventarioDefecto(Boolean cargarid_tipo_producto_servicioParametroInventarioDefecto) {
		this.cargarid_tipo_producto_servicioParametroInventarioDefecto= cargarid_tipo_producto_servicioParametroInventarioDefecto;
	}

	public Border setResaltarid_tipo_costeoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_costeoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_costeoParametroInventarioDefecto() {
		return this.resaltarid_tipo_costeoParametroInventarioDefecto;
	}

	public void setResaltarid_tipo_costeoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_tipo_costeoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_costeoParametroInventarioDefecto() {
		return this.mostrarid_tipo_costeoParametroInventarioDefecto;
	}

	public void setMostrarid_tipo_costeoParametroInventarioDefecto(Boolean mostrarid_tipo_costeoParametroInventarioDefecto) {
		this.mostrarid_tipo_costeoParametroInventarioDefecto= mostrarid_tipo_costeoParametroInventarioDefecto;
	}

	public Boolean getActivarid_tipo_costeoParametroInventarioDefecto() {
		return this.activarid_tipo_costeoParametroInventarioDefecto;
	}

	public void setActivarid_tipo_costeoParametroInventarioDefecto(Boolean activarid_tipo_costeoParametroInventarioDefecto) {
		this.activarid_tipo_costeoParametroInventarioDefecto= activarid_tipo_costeoParametroInventarioDefecto;
	}

	public Boolean getCargarid_tipo_costeoParametroInventarioDefecto() {
		return this.cargarid_tipo_costeoParametroInventarioDefecto;
	}

	public void setCargarid_tipo_costeoParametroInventarioDefecto(Boolean cargarid_tipo_costeoParametroInventarioDefecto) {
		this.cargarid_tipo_costeoParametroInventarioDefecto= cargarid_tipo_costeoParametroInventarioDefecto;
	}

	public Border setResaltarid_tipo_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_productoParametroInventarioDefecto() {
		return this.resaltarid_tipo_productoParametroInventarioDefecto;
	}

	public void setResaltarid_tipo_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_tipo_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_productoParametroInventarioDefecto() {
		return this.mostrarid_tipo_productoParametroInventarioDefecto;
	}

	public void setMostrarid_tipo_productoParametroInventarioDefecto(Boolean mostrarid_tipo_productoParametroInventarioDefecto) {
		this.mostrarid_tipo_productoParametroInventarioDefecto= mostrarid_tipo_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_tipo_productoParametroInventarioDefecto() {
		return this.activarid_tipo_productoParametroInventarioDefecto;
	}

	public void setActivarid_tipo_productoParametroInventarioDefecto(Boolean activarid_tipo_productoParametroInventarioDefecto) {
		this.activarid_tipo_productoParametroInventarioDefecto= activarid_tipo_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_tipo_productoParametroInventarioDefecto() {
		return this.cargarid_tipo_productoParametroInventarioDefecto;
	}

	public void setCargarid_tipo_productoParametroInventarioDefecto(Boolean cargarid_tipo_productoParametroInventarioDefecto) {
		this.cargarid_tipo_productoParametroInventarioDefecto= cargarid_tipo_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_tipo_via_transporteParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_via_transporteParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_via_transporteParametroInventarioDefecto() {
		return this.resaltarid_tipo_via_transporteParametroInventarioDefecto;
	}

	public void setResaltarid_tipo_via_transporteParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_tipo_via_transporteParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_via_transporteParametroInventarioDefecto() {
		return this.mostrarid_tipo_via_transporteParametroInventarioDefecto;
	}

	public void setMostrarid_tipo_via_transporteParametroInventarioDefecto(Boolean mostrarid_tipo_via_transporteParametroInventarioDefecto) {
		this.mostrarid_tipo_via_transporteParametroInventarioDefecto= mostrarid_tipo_via_transporteParametroInventarioDefecto;
	}

	public Boolean getActivarid_tipo_via_transporteParametroInventarioDefecto() {
		return this.activarid_tipo_via_transporteParametroInventarioDefecto;
	}

	public void setActivarid_tipo_via_transporteParametroInventarioDefecto(Boolean activarid_tipo_via_transporteParametroInventarioDefecto) {
		this.activarid_tipo_via_transporteParametroInventarioDefecto= activarid_tipo_via_transporteParametroInventarioDefecto;
	}

	public Boolean getCargarid_tipo_via_transporteParametroInventarioDefecto() {
		return this.cargarid_tipo_via_transporteParametroInventarioDefecto;
	}

	public void setCargarid_tipo_via_transporteParametroInventarioDefecto(Boolean cargarid_tipo_via_transporteParametroInventarioDefecto) {
		this.cargarid_tipo_via_transporteParametroInventarioDefecto= cargarid_tipo_via_transporteParametroInventarioDefecto;
	}

	public Border setResaltarid_rango_unidad_ventaParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_rango_unidad_ventaParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rango_unidad_ventaParametroInventarioDefecto() {
		return this.resaltarid_rango_unidad_ventaParametroInventarioDefecto;
	}

	public void setResaltarid_rango_unidad_ventaParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_rango_unidad_ventaParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_rango_unidad_ventaParametroInventarioDefecto() {
		return this.mostrarid_rango_unidad_ventaParametroInventarioDefecto;
	}

	public void setMostrarid_rango_unidad_ventaParametroInventarioDefecto(Boolean mostrarid_rango_unidad_ventaParametroInventarioDefecto) {
		this.mostrarid_rango_unidad_ventaParametroInventarioDefecto= mostrarid_rango_unidad_ventaParametroInventarioDefecto;
	}

	public Boolean getActivarid_rango_unidad_ventaParametroInventarioDefecto() {
		return this.activarid_rango_unidad_ventaParametroInventarioDefecto;
	}

	public void setActivarid_rango_unidad_ventaParametroInventarioDefecto(Boolean activarid_rango_unidad_ventaParametroInventarioDefecto) {
		this.activarid_rango_unidad_ventaParametroInventarioDefecto= activarid_rango_unidad_ventaParametroInventarioDefecto;
	}

	public Boolean getCargarid_rango_unidad_ventaParametroInventarioDefecto() {
		return this.cargarid_rango_unidad_ventaParametroInventarioDefecto;
	}

	public void setCargarid_rango_unidad_ventaParametroInventarioDefecto(Boolean cargarid_rango_unidad_ventaParametroInventarioDefecto) {
		this.cargarid_rango_unidad_ventaParametroInventarioDefecto= cargarid_rango_unidad_ventaParametroInventarioDefecto;
	}

	public Border setResaltarid_paisParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_paisParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisParametroInventarioDefecto() {
		return this.resaltarid_paisParametroInventarioDefecto;
	}

	public void setResaltarid_paisParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_paisParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_paisParametroInventarioDefecto() {
		return this.mostrarid_paisParametroInventarioDefecto;
	}

	public void setMostrarid_paisParametroInventarioDefecto(Boolean mostrarid_paisParametroInventarioDefecto) {
		this.mostrarid_paisParametroInventarioDefecto= mostrarid_paisParametroInventarioDefecto;
	}

	public Boolean getActivarid_paisParametroInventarioDefecto() {
		return this.activarid_paisParametroInventarioDefecto;
	}

	public void setActivarid_paisParametroInventarioDefecto(Boolean activarid_paisParametroInventarioDefecto) {
		this.activarid_paisParametroInventarioDefecto= activarid_paisParametroInventarioDefecto;
	}

	public Boolean getCargarid_paisParametroInventarioDefecto() {
		return this.cargarid_paisParametroInventarioDefecto;
	}

	public void setCargarid_paisParametroInventarioDefecto(Boolean cargarid_paisParametroInventarioDefecto) {
		this.cargarid_paisParametroInventarioDefecto= cargarid_paisParametroInventarioDefecto;
	}

	public Border setResaltarid_ciudadParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_ciudadParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadParametroInventarioDefecto() {
		return this.resaltarid_ciudadParametroInventarioDefecto;
	}

	public void setResaltarid_ciudadParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_ciudadParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_ciudadParametroInventarioDefecto() {
		return this.mostrarid_ciudadParametroInventarioDefecto;
	}

	public void setMostrarid_ciudadParametroInventarioDefecto(Boolean mostrarid_ciudadParametroInventarioDefecto) {
		this.mostrarid_ciudadParametroInventarioDefecto= mostrarid_ciudadParametroInventarioDefecto;
	}

	public Boolean getActivarid_ciudadParametroInventarioDefecto() {
		return this.activarid_ciudadParametroInventarioDefecto;
	}

	public void setActivarid_ciudadParametroInventarioDefecto(Boolean activarid_ciudadParametroInventarioDefecto) {
		this.activarid_ciudadParametroInventarioDefecto= activarid_ciudadParametroInventarioDefecto;
	}

	public Boolean getCargarid_ciudadParametroInventarioDefecto() {
		return this.cargarid_ciudadParametroInventarioDefecto;
	}

	public void setCargarid_ciudadParametroInventarioDefecto(Boolean cargarid_ciudadParametroInventarioDefecto) {
		this.cargarid_ciudadParametroInventarioDefecto= cargarid_ciudadParametroInventarioDefecto;
	}

	public Border setResaltarid_color_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_color_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_color_productoParametroInventarioDefecto() {
		return this.resaltarid_color_productoParametroInventarioDefecto;
	}

	public void setResaltarid_color_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_color_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_color_productoParametroInventarioDefecto() {
		return this.mostrarid_color_productoParametroInventarioDefecto;
	}

	public void setMostrarid_color_productoParametroInventarioDefecto(Boolean mostrarid_color_productoParametroInventarioDefecto) {
		this.mostrarid_color_productoParametroInventarioDefecto= mostrarid_color_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_color_productoParametroInventarioDefecto() {
		return this.activarid_color_productoParametroInventarioDefecto;
	}

	public void setActivarid_color_productoParametroInventarioDefecto(Boolean activarid_color_productoParametroInventarioDefecto) {
		this.activarid_color_productoParametroInventarioDefecto= activarid_color_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_color_productoParametroInventarioDefecto() {
		return this.cargarid_color_productoParametroInventarioDefecto;
	}

	public void setCargarid_color_productoParametroInventarioDefecto(Boolean cargarid_color_productoParametroInventarioDefecto) {
		this.cargarid_color_productoParametroInventarioDefecto= cargarid_color_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_clase_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_clase_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clase_productoParametroInventarioDefecto() {
		return this.resaltarid_clase_productoParametroInventarioDefecto;
	}

	public void setResaltarid_clase_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_clase_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_clase_productoParametroInventarioDefecto() {
		return this.mostrarid_clase_productoParametroInventarioDefecto;
	}

	public void setMostrarid_clase_productoParametroInventarioDefecto(Boolean mostrarid_clase_productoParametroInventarioDefecto) {
		this.mostrarid_clase_productoParametroInventarioDefecto= mostrarid_clase_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_clase_productoParametroInventarioDefecto() {
		return this.activarid_clase_productoParametroInventarioDefecto;
	}

	public void setActivarid_clase_productoParametroInventarioDefecto(Boolean activarid_clase_productoParametroInventarioDefecto) {
		this.activarid_clase_productoParametroInventarioDefecto= activarid_clase_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_clase_productoParametroInventarioDefecto() {
		return this.cargarid_clase_productoParametroInventarioDefecto;
	}

	public void setCargarid_clase_productoParametroInventarioDefecto(Boolean cargarid_clase_productoParametroInventarioDefecto) {
		this.cargarid_clase_productoParametroInventarioDefecto= cargarid_clase_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_efecto_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_efecto_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_efecto_productoParametroInventarioDefecto() {
		return this.resaltarid_efecto_productoParametroInventarioDefecto;
	}

	public void setResaltarid_efecto_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_efecto_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_efecto_productoParametroInventarioDefecto() {
		return this.mostrarid_efecto_productoParametroInventarioDefecto;
	}

	public void setMostrarid_efecto_productoParametroInventarioDefecto(Boolean mostrarid_efecto_productoParametroInventarioDefecto) {
		this.mostrarid_efecto_productoParametroInventarioDefecto= mostrarid_efecto_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_efecto_productoParametroInventarioDefecto() {
		return this.activarid_efecto_productoParametroInventarioDefecto;
	}

	public void setActivarid_efecto_productoParametroInventarioDefecto(Boolean activarid_efecto_productoParametroInventarioDefecto) {
		this.activarid_efecto_productoParametroInventarioDefecto= activarid_efecto_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_efecto_productoParametroInventarioDefecto() {
		return this.cargarid_efecto_productoParametroInventarioDefecto;
	}

	public void setCargarid_efecto_productoParametroInventarioDefecto(Boolean cargarid_efecto_productoParametroInventarioDefecto) {
		this.cargarid_efecto_productoParametroInventarioDefecto= cargarid_efecto_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_marca_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_marca_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_marca_productoParametroInventarioDefecto() {
		return this.resaltarid_marca_productoParametroInventarioDefecto;
	}

	public void setResaltarid_marca_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_marca_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_marca_productoParametroInventarioDefecto() {
		return this.mostrarid_marca_productoParametroInventarioDefecto;
	}

	public void setMostrarid_marca_productoParametroInventarioDefecto(Boolean mostrarid_marca_productoParametroInventarioDefecto) {
		this.mostrarid_marca_productoParametroInventarioDefecto= mostrarid_marca_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_marca_productoParametroInventarioDefecto() {
		return this.activarid_marca_productoParametroInventarioDefecto;
	}

	public void setActivarid_marca_productoParametroInventarioDefecto(Boolean activarid_marca_productoParametroInventarioDefecto) {
		this.activarid_marca_productoParametroInventarioDefecto= activarid_marca_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_marca_productoParametroInventarioDefecto() {
		return this.cargarid_marca_productoParametroInventarioDefecto;
	}

	public void setCargarid_marca_productoParametroInventarioDefecto(Boolean cargarid_marca_productoParametroInventarioDefecto) {
		this.cargarid_marca_productoParametroInventarioDefecto= cargarid_marca_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_modelo_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_modelo_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_modelo_productoParametroInventarioDefecto() {
		return this.resaltarid_modelo_productoParametroInventarioDefecto;
	}

	public void setResaltarid_modelo_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_modelo_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_modelo_productoParametroInventarioDefecto() {
		return this.mostrarid_modelo_productoParametroInventarioDefecto;
	}

	public void setMostrarid_modelo_productoParametroInventarioDefecto(Boolean mostrarid_modelo_productoParametroInventarioDefecto) {
		this.mostrarid_modelo_productoParametroInventarioDefecto= mostrarid_modelo_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_modelo_productoParametroInventarioDefecto() {
		return this.activarid_modelo_productoParametroInventarioDefecto;
	}

	public void setActivarid_modelo_productoParametroInventarioDefecto(Boolean activarid_modelo_productoParametroInventarioDefecto) {
		this.activarid_modelo_productoParametroInventarioDefecto= activarid_modelo_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_modelo_productoParametroInventarioDefecto() {
		return this.cargarid_modelo_productoParametroInventarioDefecto;
	}

	public void setCargarid_modelo_productoParametroInventarioDefecto(Boolean cargarid_modelo_productoParametroInventarioDefecto) {
		this.cargarid_modelo_productoParametroInventarioDefecto= cargarid_modelo_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_material_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_material_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_material_productoParametroInventarioDefecto() {
		return this.resaltarid_material_productoParametroInventarioDefecto;
	}

	public void setResaltarid_material_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_material_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_material_productoParametroInventarioDefecto() {
		return this.mostrarid_material_productoParametroInventarioDefecto;
	}

	public void setMostrarid_material_productoParametroInventarioDefecto(Boolean mostrarid_material_productoParametroInventarioDefecto) {
		this.mostrarid_material_productoParametroInventarioDefecto= mostrarid_material_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_material_productoParametroInventarioDefecto() {
		return this.activarid_material_productoParametroInventarioDefecto;
	}

	public void setActivarid_material_productoParametroInventarioDefecto(Boolean activarid_material_productoParametroInventarioDefecto) {
		this.activarid_material_productoParametroInventarioDefecto= activarid_material_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_material_productoParametroInventarioDefecto() {
		return this.cargarid_material_productoParametroInventarioDefecto;
	}

	public void setCargarid_material_productoParametroInventarioDefecto(Boolean cargarid_material_productoParametroInventarioDefecto) {
		this.cargarid_material_productoParametroInventarioDefecto= cargarid_material_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_segmento_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_segmento_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_segmento_productoParametroInventarioDefecto() {
		return this.resaltarid_segmento_productoParametroInventarioDefecto;
	}

	public void setResaltarid_segmento_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_segmento_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_segmento_productoParametroInventarioDefecto() {
		return this.mostrarid_segmento_productoParametroInventarioDefecto;
	}

	public void setMostrarid_segmento_productoParametroInventarioDefecto(Boolean mostrarid_segmento_productoParametroInventarioDefecto) {
		this.mostrarid_segmento_productoParametroInventarioDefecto= mostrarid_segmento_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_segmento_productoParametroInventarioDefecto() {
		return this.activarid_segmento_productoParametroInventarioDefecto;
	}

	public void setActivarid_segmento_productoParametroInventarioDefecto(Boolean activarid_segmento_productoParametroInventarioDefecto) {
		this.activarid_segmento_productoParametroInventarioDefecto= activarid_segmento_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_segmento_productoParametroInventarioDefecto() {
		return this.cargarid_segmento_productoParametroInventarioDefecto;
	}

	public void setCargarid_segmento_productoParametroInventarioDefecto(Boolean cargarid_segmento_productoParametroInventarioDefecto) {
		this.cargarid_segmento_productoParametroInventarioDefecto= cargarid_segmento_productoParametroInventarioDefecto;
	}

	public Border setResaltarid_talla_productoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroinventariodefectoBeanSwingJInternalFrame.jTtoolBarParametroInventarioDefecto.setBorder(borderResaltar);
		
		this.resaltarid_talla_productoParametroInventarioDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_talla_productoParametroInventarioDefecto() {
		return this.resaltarid_talla_productoParametroInventarioDefecto;
	}

	public void setResaltarid_talla_productoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarid_talla_productoParametroInventarioDefecto= borderResaltar;
	}

	public Boolean getMostrarid_talla_productoParametroInventarioDefecto() {
		return this.mostrarid_talla_productoParametroInventarioDefecto;
	}

	public void setMostrarid_talla_productoParametroInventarioDefecto(Boolean mostrarid_talla_productoParametroInventarioDefecto) {
		this.mostrarid_talla_productoParametroInventarioDefecto= mostrarid_talla_productoParametroInventarioDefecto;
	}

	public Boolean getActivarid_talla_productoParametroInventarioDefecto() {
		return this.activarid_talla_productoParametroInventarioDefecto;
	}

	public void setActivarid_talla_productoParametroInventarioDefecto(Boolean activarid_talla_productoParametroInventarioDefecto) {
		this.activarid_talla_productoParametroInventarioDefecto= activarid_talla_productoParametroInventarioDefecto;
	}

	public Boolean getCargarid_talla_productoParametroInventarioDefecto() {
		return this.cargarid_talla_productoParametroInventarioDefecto;
	}

	public void setCargarid_talla_productoParametroInventarioDefecto(Boolean cargarid_talla_productoParametroInventarioDefecto) {
		this.cargarid_talla_productoParametroInventarioDefecto= cargarid_talla_productoParametroInventarioDefecto;
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
		
		
		this.setMostraridParametroInventarioDefecto(esInicial);
		this.setMostrarid_empresaParametroInventarioDefecto(esInicial);
		this.setMostrarid_sucursalParametroInventarioDefecto(esInicial);
		this.setMostrarid_grupo_bodegaParametroInventarioDefecto(esInicial);
		this.setMostrarid_calidad_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_tipo_servicioParametroInventarioDefecto(esInicial);
		this.setMostrarid_tipo_producto_servicio_invenParametroInventarioDefecto(esInicial);
		this.setMostrarid_tipo_producto_servicioParametroInventarioDefecto(esInicial);
		this.setMostrarid_tipo_costeoParametroInventarioDefecto(esInicial);
		this.setMostrarid_tipo_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_tipo_via_transporteParametroInventarioDefecto(esInicial);
		this.setMostrarid_rango_unidad_ventaParametroInventarioDefecto(esInicial);
		this.setMostrarid_paisParametroInventarioDefecto(esInicial);
		this.setMostrarid_ciudadParametroInventarioDefecto(esInicial);
		this.setMostrarid_color_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_clase_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_efecto_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_marca_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_modelo_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_material_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_segmento_productoParametroInventarioDefecto(esInicial);
		this.setMostrarid_talla_productoParametroInventarioDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.ID)) {
				this.setMostraridParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA)) {
				this.setMostrarid_grupo_bodegaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO)) {
				this.setMostrarid_calidad_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO)) {
				this.setMostrarid_tipo_servicioParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {
				this.setMostrarid_tipo_producto_servicio_invenParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO)) {
				this.setMostrarid_tipo_costeoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setMostrarid_tipo_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setMostrarid_tipo_via_transporteParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA)) {
				this.setMostrarid_rango_unidad_ventaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO)) {
				this.setMostrarid_color_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO)) {
				this.setMostrarid_clase_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO)) {
				this.setMostrarid_efecto_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO)) {
				this.setMostrarid_marca_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO)) {
				this.setMostrarid_modelo_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO)) {
				this.setMostrarid_material_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO)) {
				this.setMostrarid_segmento_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO)) {
				this.setMostrarid_talla_productoParametroInventarioDefecto(esAsigna);
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
		
		
		this.setActivaridParametroInventarioDefecto(esInicial);
		this.setActivarid_empresaParametroInventarioDefecto(esInicial);
		this.setActivarid_sucursalParametroInventarioDefecto(esInicial);
		this.setActivarid_grupo_bodegaParametroInventarioDefecto(esInicial);
		this.setActivarid_calidad_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_tipo_servicioParametroInventarioDefecto(esInicial);
		this.setActivarid_tipo_producto_servicio_invenParametroInventarioDefecto(esInicial);
		this.setActivarid_tipo_producto_servicioParametroInventarioDefecto(esInicial);
		this.setActivarid_tipo_costeoParametroInventarioDefecto(esInicial);
		this.setActivarid_tipo_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_tipo_via_transporteParametroInventarioDefecto(esInicial);
		this.setActivarid_rango_unidad_ventaParametroInventarioDefecto(esInicial);
		this.setActivarid_paisParametroInventarioDefecto(esInicial);
		this.setActivarid_ciudadParametroInventarioDefecto(esInicial);
		this.setActivarid_color_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_clase_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_efecto_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_marca_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_modelo_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_material_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_segmento_productoParametroInventarioDefecto(esInicial);
		this.setActivarid_talla_productoParametroInventarioDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.ID)) {
				this.setActivaridParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA)) {
				this.setActivarid_grupo_bodegaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO)) {
				this.setActivarid_calidad_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO)) {
				this.setActivarid_tipo_servicioParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {
				this.setActivarid_tipo_producto_servicio_invenParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO)) {
				this.setActivarid_tipo_costeoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setActivarid_tipo_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setActivarid_tipo_via_transporteParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA)) {
				this.setActivarid_rango_unidad_ventaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO)) {
				this.setActivarid_color_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO)) {
				this.setActivarid_clase_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO)) {
				this.setActivarid_efecto_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO)) {
				this.setActivarid_marca_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO)) {
				this.setActivarid_modelo_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO)) {
				this.setActivarid_material_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO)) {
				this.setActivarid_segmento_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO)) {
				this.setActivarid_talla_productoParametroInventarioDefecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroInventarioDefecto(esInicial);
		this.setResaltarid_empresaParametroInventarioDefecto(esInicial);
		this.setResaltarid_sucursalParametroInventarioDefecto(esInicial);
		this.setResaltarid_grupo_bodegaParametroInventarioDefecto(esInicial);
		this.setResaltarid_calidad_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_tipo_servicioParametroInventarioDefecto(esInicial);
		this.setResaltarid_tipo_producto_servicio_invenParametroInventarioDefecto(esInicial);
		this.setResaltarid_tipo_producto_servicioParametroInventarioDefecto(esInicial);
		this.setResaltarid_tipo_costeoParametroInventarioDefecto(esInicial);
		this.setResaltarid_tipo_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_tipo_via_transporteParametroInventarioDefecto(esInicial);
		this.setResaltarid_rango_unidad_ventaParametroInventarioDefecto(esInicial);
		this.setResaltarid_paisParametroInventarioDefecto(esInicial);
		this.setResaltarid_ciudadParametroInventarioDefecto(esInicial);
		this.setResaltarid_color_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_clase_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_efecto_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_marca_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_modelo_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_material_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_segmento_productoParametroInventarioDefecto(esInicial);
		this.setResaltarid_talla_productoParametroInventarioDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.ID)) {
				this.setResaltaridParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA)) {
				this.setResaltarid_grupo_bodegaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO)) {
				this.setResaltarid_calidad_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO)) {
				this.setResaltarid_tipo_servicioParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN)) {
				this.setResaltarid_tipo_producto_servicio_invenParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO)) {
				this.setResaltarid_tipo_costeoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO)) {
				this.setResaltarid_tipo_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setResaltarid_tipo_via_transporteParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA)) {
				this.setResaltarid_rango_unidad_ventaParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO)) {
				this.setResaltarid_color_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO)) {
				this.setResaltarid_clase_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO)) {
				this.setResaltarid_efecto_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO)) {
				this.setResaltarid_marca_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO)) {
				this.setResaltarid_modelo_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO)) {
				this.setResaltarid_material_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO)) {
				this.setResaltarid_segmento_productoParametroInventarioDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO)) {
				this.setResaltarid_talla_productoParametroInventarioDefecto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCalidadProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdCalidadProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdCalidadProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdCalidadProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCalidadProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCiudadParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdCiudadParametroInventarioDefecto() {
		return this.mostrarFK_IdCiudadParametroInventarioDefecto;
	}

	public void setMostrarFK_IdCiudadParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClaseProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdClaseProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdClaseProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdClaseProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClaseProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdColorProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdColorProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdColorProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdColorProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdColorProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEfectoProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdEfectoProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdEfectoProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdEfectoProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEfectoProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdEmpresaParametroInventarioDefecto() {
		return this.mostrarFK_IdEmpresaParametroInventarioDefecto;
	}

	public void setMostrarFK_IdEmpresaParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdGrupoBodegaParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdGrupoBodegaParametroInventarioDefecto() {
		return this.mostrarFK_IdGrupoBodegaParametroInventarioDefecto;
	}

	public void setMostrarFK_IdGrupoBodegaParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdGrupoBodegaParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMarcaProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdMarcaProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdMarcaProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdMarcaProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMarcaProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMaterialProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdMaterialProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdMaterialProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdMaterialProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMaterialProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModeloProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdModeloProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdModeloProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdModeloProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModeloProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdPaisParametroInventarioDefecto() {
		return this.mostrarFK_IdPaisParametroInventarioDefecto;
	}

	public void setMostrarFK_IdPaisParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRangoUnidadVentaParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdRangoUnidadVentaParametroInventarioDefecto() {
		return this.mostrarFK_IdRangoUnidadVentaParametroInventarioDefecto;
	}

	public void setMostrarFK_IdRangoUnidadVentaParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRangoUnidadVentaParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSegmentoProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdSegmentoProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdSegmentoProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdSegmentoProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSegmentoProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdSucursalParametroInventarioDefecto() {
		return this.mostrarFK_IdSucursalParametroInventarioDefecto;
	}

	public void setMostrarFK_IdSucursalParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTallaProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdTallaProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdTallaProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdTallaProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTallaProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCosteoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdTipoCosteoParametroInventarioDefecto() {
		return this.mostrarFK_IdTipoCosteoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdTipoCosteoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCosteoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdTipoProductoParametroInventarioDefecto() {
		return this.mostrarFK_IdTipoProductoParametroInventarioDefecto;
	}

	public void setMostrarFK_IdTipoProductoParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoServicioParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdTipoProductoServicioParametroInventarioDefecto() {
		return this.mostrarFK_IdTipoProductoServicioParametroInventarioDefecto;
	}

	public void setMostrarFK_IdTipoProductoServicioParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoServicioParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoServicioInvenParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdTipoProductoServicioInvenParametroInventarioDefecto() {
		return this.mostrarFK_IdTipoProductoServicioInvenParametroInventarioDefecto;
	}

	public void setMostrarFK_IdTipoProductoServicioInvenParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoServicioInvenParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoServicioParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdTipoServicioParametroInventarioDefecto() {
		return this.mostrarFK_IdTipoServicioParametroInventarioDefecto;
	}

	public void setMostrarFK_IdTipoServicioParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoServicioParametroInventarioDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoViaTransporteParametroInventarioDefecto=true;

	public Boolean getMostrarFK_IdTipoViaTransporteParametroInventarioDefecto() {
		return this.mostrarFK_IdTipoViaTransporteParametroInventarioDefecto;
	}

	public void setMostrarFK_IdTipoViaTransporteParametroInventarioDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoViaTransporteParametroInventarioDefecto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCalidadProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdCalidadProductoParametroInventarioDefecto() {
		return this.activarFK_IdCalidadProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdCalidadProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdCalidadProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdCiudadParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdCiudadParametroInventarioDefecto() {
		return this.activarFK_IdCiudadParametroInventarioDefecto;
	}

	public void setActivarFK_IdCiudadParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdClaseProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdClaseProductoParametroInventarioDefecto() {
		return this.activarFK_IdClaseProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdClaseProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdClaseProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdColorProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdColorProductoParametroInventarioDefecto() {
		return this.activarFK_IdColorProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdColorProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdColorProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEfectoProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdEfectoProductoParametroInventarioDefecto() {
		return this.activarFK_IdEfectoProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdEfectoProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEfectoProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdEmpresaParametroInventarioDefecto() {
		return this.activarFK_IdEmpresaParametroInventarioDefecto;
	}

	public void setActivarFK_IdEmpresaParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdGrupoBodegaParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdGrupoBodegaParametroInventarioDefecto() {
		return this.activarFK_IdGrupoBodegaParametroInventarioDefecto;
	}

	public void setActivarFK_IdGrupoBodegaParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdGrupoBodegaParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdMarcaProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdMarcaProductoParametroInventarioDefecto() {
		return this.activarFK_IdMarcaProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdMarcaProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdMarcaProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdMaterialProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdMaterialProductoParametroInventarioDefecto() {
		return this.activarFK_IdMaterialProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdMaterialProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdMaterialProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdModeloProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdModeloProductoParametroInventarioDefecto() {
		return this.activarFK_IdModeloProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdModeloProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdModeloProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdPaisParametroInventarioDefecto() {
		return this.activarFK_IdPaisParametroInventarioDefecto;
	}

	public void setActivarFK_IdPaisParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdPaisParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdRangoUnidadVentaParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdRangoUnidadVentaParametroInventarioDefecto() {
		return this.activarFK_IdRangoUnidadVentaParametroInventarioDefecto;
	}

	public void setActivarFK_IdRangoUnidadVentaParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdRangoUnidadVentaParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdSegmentoProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdSegmentoProductoParametroInventarioDefecto() {
		return this.activarFK_IdSegmentoProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdSegmentoProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdSegmentoProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdSucursalParametroInventarioDefecto() {
		return this.activarFK_IdSucursalParametroInventarioDefecto;
	}

	public void setActivarFK_IdSucursalParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTallaProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdTallaProductoParametroInventarioDefecto() {
		return this.activarFK_IdTallaProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdTallaProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTallaProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCosteoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdTipoCosteoParametroInventarioDefecto() {
		return this.activarFK_IdTipoCosteoParametroInventarioDefecto;
	}

	public void setActivarFK_IdTipoCosteoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCosteoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdTipoProductoParametroInventarioDefecto() {
		return this.activarFK_IdTipoProductoParametroInventarioDefecto;
	}

	public void setActivarFK_IdTipoProductoParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoServicioParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdTipoProductoServicioParametroInventarioDefecto() {
		return this.activarFK_IdTipoProductoServicioParametroInventarioDefecto;
	}

	public void setActivarFK_IdTipoProductoServicioParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoServicioParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoServicioInvenParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdTipoProductoServicioInvenParametroInventarioDefecto() {
		return this.activarFK_IdTipoProductoServicioInvenParametroInventarioDefecto;
	}

	public void setActivarFK_IdTipoProductoServicioInvenParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoServicioInvenParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoServicioParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdTipoServicioParametroInventarioDefecto() {
		return this.activarFK_IdTipoServicioParametroInventarioDefecto;
	}

	public void setActivarFK_IdTipoServicioParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoServicioParametroInventarioDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoViaTransporteParametroInventarioDefecto=true;

	public Boolean getActivarFK_IdTipoViaTransporteParametroInventarioDefecto() {
		return this.activarFK_IdTipoViaTransporteParametroInventarioDefecto;
	}

	public void setActivarFK_IdTipoViaTransporteParametroInventarioDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoViaTransporteParametroInventarioDefecto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCalidadProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdCalidadProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdCalidadProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdCalidadProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdCalidadProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdCalidadProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCalidadProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdCiudadParametroInventarioDefecto=null;

	public Border getResaltarFK_IdCiudadParametroInventarioDefecto() {
		return this.resaltarFK_IdCiudadParametroInventarioDefecto;
	}

	public void setResaltarFK_IdCiudadParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdCiudadParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdCiudadParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdClaseProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdClaseProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdClaseProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdClaseProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdClaseProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdClaseProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClaseProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdColorProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdColorProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdColorProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdColorProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdColorProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdColorProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdColorProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdEfectoProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdEfectoProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdEfectoProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdEfectoProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdEfectoProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEfectoProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEfectoProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroInventarioDefecto=null;

	public Border getResaltarFK_IdEmpresaParametroInventarioDefecto() {
		return this.resaltarFK_IdEmpresaParametroInventarioDefecto;
	}

	public void setResaltarFK_IdEmpresaParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdGrupoBodegaParametroInventarioDefecto=null;

	public Border getResaltarFK_IdGrupoBodegaParametroInventarioDefecto() {
		return this.resaltarFK_IdGrupoBodegaParametroInventarioDefecto;
	}

	public void setResaltarFK_IdGrupoBodegaParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdGrupoBodegaParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdGrupoBodegaParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdGrupoBodegaParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdMarcaProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdMarcaProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdMarcaProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdMarcaProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdMarcaProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdMarcaProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMarcaProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdMaterialProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdMaterialProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdMaterialProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdMaterialProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdMaterialProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdMaterialProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMaterialProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdModeloProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdModeloProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdModeloProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdModeloProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdModeloProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdModeloProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModeloProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdPaisParametroInventarioDefecto=null;

	public Border getResaltarFK_IdPaisParametroInventarioDefecto() {
		return this.resaltarFK_IdPaisParametroInventarioDefecto;
	}

	public void setResaltarFK_IdPaisParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdPaisParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdPaisParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdRangoUnidadVentaParametroInventarioDefecto=null;

	public Border getResaltarFK_IdRangoUnidadVentaParametroInventarioDefecto() {
		return this.resaltarFK_IdRangoUnidadVentaParametroInventarioDefecto;
	}

	public void setResaltarFK_IdRangoUnidadVentaParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdRangoUnidadVentaParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdRangoUnidadVentaParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRangoUnidadVentaParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdSegmentoProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdSegmentoProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdSegmentoProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdSegmentoProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdSegmentoProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdSegmentoProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSegmentoProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroInventarioDefecto=null;

	public Border getResaltarFK_IdSucursalParametroInventarioDefecto() {
		return this.resaltarFK_IdSucursalParametroInventarioDefecto;
	}

	public void setResaltarFK_IdSucursalParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTallaProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdTallaProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdTallaProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdTallaProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdTallaProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTallaProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTallaProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoCosteoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdTipoCosteoParametroInventarioDefecto() {
		return this.resaltarFK_IdTipoCosteoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdTipoCosteoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoCosteoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoCosteoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCosteoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoParametroInventarioDefecto=null;

	public Border getResaltarFK_IdTipoProductoParametroInventarioDefecto() {
		return this.resaltarFK_IdTipoProductoParametroInventarioDefecto;
	}

	public void setResaltarFK_IdTipoProductoParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoServicioParametroInventarioDefecto=null;

	public Border getResaltarFK_IdTipoProductoServicioParametroInventarioDefecto() {
		return this.resaltarFK_IdTipoProductoServicioParametroInventarioDefecto;
	}

	public void setResaltarFK_IdTipoProductoServicioParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoServicioParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoServicioParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoServicioParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoServicioInvenParametroInventarioDefecto=null;

	public Border getResaltarFK_IdTipoProductoServicioInvenParametroInventarioDefecto() {
		return this.resaltarFK_IdTipoProductoServicioInvenParametroInventarioDefecto;
	}

	public void setResaltarFK_IdTipoProductoServicioInvenParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoServicioInvenParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoServicioInvenParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoServicioInvenParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoServicioParametroInventarioDefecto=null;

	public Border getResaltarFK_IdTipoServicioParametroInventarioDefecto() {
		return this.resaltarFK_IdTipoServicioParametroInventarioDefecto;
	}

	public void setResaltarFK_IdTipoServicioParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoServicioParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoServicioParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoServicioParametroInventarioDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoViaTransporteParametroInventarioDefecto=null;

	public Border getResaltarFK_IdTipoViaTransporteParametroInventarioDefecto() {
		return this.resaltarFK_IdTipoViaTransporteParametroInventarioDefecto;
	}

	public void setResaltarFK_IdTipoViaTransporteParametroInventarioDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoViaTransporteParametroInventarioDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoViaTransporteParametroInventarioDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroInventarioDefectoBeanSwingJInternalFrame parametroinventariodefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoViaTransporteParametroInventarioDefecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}