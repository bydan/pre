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

import com.bydan.erp.inventario.resources.general.AuxiliarGeneral;

import com.bydan.erp.inventario.util.report.ModificacionLineasProductosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ModificacionLineasProductosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ModificacionLineasProductosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ModificacionLineasProductosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ModificacionLineasProductos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ModificacionLineasProductos"+ModificacionLineasProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ModificacionLineasProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ModificacionLineasProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ModificacionLineasProductosConstantesFunciones.SCHEMA+"_"+ModificacionLineasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ModificacionLineasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ModificacionLineasProductosConstantesFunciones.SCHEMA+"_"+ModificacionLineasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ModificacionLineasProductosConstantesFunciones.SCHEMA+"_"+ModificacionLineasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ModificacionLineasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ModificacionLineasProductosConstantesFunciones.SCHEMA+"_"+ModificacionLineasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModificacionLineasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ModificacionLineasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModificacionLineasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModificacionLineasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ModificacionLineasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ModificacionLineasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ModificacionLineasProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ModificacionLineasProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ModificacionLineasProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ModificacionLineasProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Modificacion Lineas Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Modificacion Lineas Productos";
	public static final String SCLASSWEBTITULO_LOWER="Modificacion Lineas Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ModificacionLineasProductos";
	public static final String OBJECTNAME="modificacionlineasproductos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="modificacion_lineas_productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select modificacionlineasproductos from "+ModificacionLineasProductosConstantesFunciones.SPERSISTENCENAME+" modificacionlineasproductos";
	public static String QUERYSELECTNATIVE="select "+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".version_row,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_producto,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea_marca,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea_destino,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea_grupo_destino,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea_categoria_destino,"+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME+".id_linea_marca_destino from "+ModificacionLineasProductosConstantesFunciones.SCHEMA+"."+ModificacionLineasProductosConstantesFunciones.TABLENAME;//+" as "+ModificacionLineasProductosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String IDLINEADESTINO= "id_linea_destino";
    public static final String IDLINEAGRUPODESTINO= "id_linea_grupo_destino";
    public static final String IDLINEACATEGORIADESTINO= "id_linea_categoria_destino";
    public static final String IDLINEAMARCADESTINO= "id_linea_marca_destino";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
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
    	public static final String LABEL_IDLINEADESTINO= "Linea Destino";
		public static final String LABEL_IDLINEADESTINO_LOWER= "Linea Destino";
    	public static final String LABEL_IDLINEAGRUPODESTINO= "Linea Grupo Destino";
		public static final String LABEL_IDLINEAGRUPODESTINO_LOWER= "Linea Grupo Destino";
    	public static final String LABEL_IDLINEACATEGORIADESTINO= "Linea Categoria Destino";
		public static final String LABEL_IDLINEACATEGORIADESTINO_LOWER= "Linea Categoria Destino";
    	public static final String LABEL_IDLINEAMARCADESTINO= "Linea Marca Destino";
		public static final String LABEL_IDLINEAMARCADESTINO_LOWER= "Linea Marca Destino";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getModificacionLineasProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEA)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEADESTINO)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEADESTINO;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPODESTINO)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPODESTINO;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIADESTINO)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIADESTINO;}
		if(sNombreColumna.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCADESTINO)) {sLabelColumna=ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCADESTINO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getModificacionLineasProductosDescripcion(ModificacionLineasProductos modificacionlineasproductos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(modificacionlineasproductos !=null/* && modificacionlineasproductos.getId()!=0*/) {
			if(modificacionlineasproductos.getId()!=null) {
				sDescripcion=modificacionlineasproductos.getId().toString();
			}//modificacionlineasproductosmodificacionlineasproductos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getModificacionLineasProductosDescripcionDetallado(ModificacionLineasProductos modificacionlineasproductos) {
		String sDescripcion="";
			
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.ID+"=";
		sDescripcion+=modificacionlineasproductos.getId().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=modificacionlineasproductos.getVersionRow().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=modificacionlineasproductos.getid_producto().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea_grupo().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea_categoria().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea_marca().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEADESTINO+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea_destino().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPODESTINO+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea_grupo_destino().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIADESTINO+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea_categoria_destino().toString()+",";
		sDescripcion+=ModificacionLineasProductosConstantesFunciones.IDLINEAMARCADESTINO+"=";
		sDescripcion+=modificacionlineasproductos.getid_linea_marca_destino().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setModificacionLineasProductosDescripcion(ModificacionLineasProductos modificacionlineasproductos,String sValor) throws Exception {			
		if(modificacionlineasproductos !=null) {
			//modificacionlineasproductosmodificacionlineasproductos.getId().toString();
		}		
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

	public static String getLineaDestinoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDestinoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDestinoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDestinoDescripcion(Linea linea) {
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
		} else if(sNombreIndice.equals("BusquedaModificacionLineasProductos")) {
			sNombreIndice="Tipo=  Por Producto Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Linea Destino Por Linea Grupo Destino Por Linea Categoria Destino Por Linea Marca Destino";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaCategoriaDestino")) {
			sNombreIndice="Tipo=  Por Linea Categoria Destino";
		} else if(sNombreIndice.equals("FK_IdLineaDestino")) {
			sNombreIndice="Tipo=  Por Linea Destino";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaGrupoDestino")) {
			sNombreIndice="Tipo=  Por Linea Grupo Destino";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdLineaMarcaDestino")) {
			sNombreIndice="Tipo=  Por Linea Marca Destino";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaModificacionLineasProductos(Long id_producto,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_linea_destino,Long id_linea_grupo_destino,Long id_linea_categoria_destino,Long id_linea_marca_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(id_linea_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Destino="+id_linea_destino.toString();}
		if(id_linea_grupo_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo Destino="+id_linea_grupo_destino.toString();}
		if(id_linea_categoria_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria Destino="+id_linea_categoria_destino.toString();}
		if(id_linea_marca_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca Destino="+id_linea_marca_destino.toString();} 

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

	public static String getDetalleIndiceFK_IdLineaCategoriaDestino(Long id_linea_categoria_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria Destino="+id_linea_categoria_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaDestino(Long id_linea_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Destino="+id_linea_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupoDestino(Long id_linea_grupo_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo Destino="+id_linea_grupo_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarcaDestino(Long id_linea_marca_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca_destino!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca Destino="+id_linea_marca_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosModificacionLineasProductos(ModificacionLineasProductos modificacionlineasproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosModificacionLineasProductoss(List<ModificacionLineasProductos> modificacionlineasproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ModificacionLineasProductos modificacionlineasproductos: modificacionlineasproductoss) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresModificacionLineasProductos(ModificacionLineasProductos modificacionlineasproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && modificacionlineasproductos.getConCambioAuxiliar()) {
			modificacionlineasproductos.setIsDeleted(modificacionlineasproductos.getIsDeletedAuxiliar());	
			modificacionlineasproductos.setIsNew(modificacionlineasproductos.getIsNewAuxiliar());	
			modificacionlineasproductos.setIsChanged(modificacionlineasproductos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			modificacionlineasproductos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			modificacionlineasproductos.setIsDeletedAuxiliar(false);	
			modificacionlineasproductos.setIsNewAuxiliar(false);	
			modificacionlineasproductos.setIsChangedAuxiliar(false);
			
			modificacionlineasproductos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresModificacionLineasProductoss(List<ModificacionLineasProductos> modificacionlineasproductoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ModificacionLineasProductos modificacionlineasproductos : modificacionlineasproductoss) {
			if(conAsignarBase && modificacionlineasproductos.getConCambioAuxiliar()) {
				modificacionlineasproductos.setIsDeleted(modificacionlineasproductos.getIsDeletedAuxiliar());	
				modificacionlineasproductos.setIsNew(modificacionlineasproductos.getIsNewAuxiliar());	
				modificacionlineasproductos.setIsChanged(modificacionlineasproductos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				modificacionlineasproductos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				modificacionlineasproductos.setIsDeletedAuxiliar(false);	
				modificacionlineasproductos.setIsNewAuxiliar(false);	
				modificacionlineasproductos.setIsChangedAuxiliar(false);
				
				modificacionlineasproductos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresModificacionLineasProductos(ModificacionLineasProductos modificacionlineasproductos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresModificacionLineasProductoss(List<ModificacionLineasProductos> modificacionlineasproductoss,Boolean conEnteros) throws Exception  {
		
		for(ModificacionLineasProductos modificacionlineasproductos: modificacionlineasproductoss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaModificacionLineasProductos(List<ModificacionLineasProductos> modificacionlineasproductoss,ModificacionLineasProductos modificacionlineasproductosAux) throws Exception  {
		ModificacionLineasProductosConstantesFunciones.InicializarValoresModificacionLineasProductos(modificacionlineasproductosAux,true);
		
		for(ModificacionLineasProductos modificacionlineasproductos: modificacionlineasproductoss) {
			if(modificacionlineasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesModificacionLineasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ModificacionLineasProductosConstantesFunciones.getArrayColumnasGlobalesModificacionLineasProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesModificacionLineasProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoModificacionLineasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ModificacionLineasProductos> modificacionlineasproductoss,ModificacionLineasProductos modificacionlineasproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ModificacionLineasProductos modificacionlineasproductosAux: modificacionlineasproductoss) {
			if(modificacionlineasproductosAux!=null && modificacionlineasproductos!=null) {
				if((modificacionlineasproductosAux.getId()==null && modificacionlineasproductos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(modificacionlineasproductosAux.getId()!=null && modificacionlineasproductos.getId()!=null){
					if(modificacionlineasproductosAux.getId().equals(modificacionlineasproductos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaModificacionLineasProductos(List<ModificacionLineasProductos> modificacionlineasproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ModificacionLineasProductos modificacionlineasproductos: modificacionlineasproductoss) {			
			if(modificacionlineasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaModificacionLineasProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasModificacionLineasProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModificacionLineasProductos() throws Exception  {
		return ModificacionLineasProductosConstantesFunciones.getTiposSeleccionarModificacionLineasProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModificacionLineasProductos(Boolean conFk) throws Exception  {
		return ModificacionLineasProductosConstantesFunciones.getTiposSeleccionarModificacionLineasProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarModificacionLineasProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEADESTINO);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPODESTINO);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPODESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIADESTINO);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCADESTINO);
			reporte.setsDescripcion(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesModificacionLineasProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesModificacionLineasProductos(ModificacionLineasProductos modificacionlineasproductosAux) throws Exception {
		
			modificacionlineasproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(modificacionlineasproductosAux.getProducto()));
			modificacionlineasproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLinea()));
			modificacionlineasproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaGrupo()));
			modificacionlineasproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaCategoria()));
			modificacionlineasproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaMarca()));
			modificacionlineasproductosAux.setlineadestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaDestino()));
			modificacionlineasproductosAux.setlineagrupodestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaGrupoDestino()));
			modificacionlineasproductosAux.setlineacategoriadestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaCategoriaDestino()));
			modificacionlineasproductosAux.setlineamarcadestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaMarcaDestino()));		
	}
	
	public static void refrescarForeignKeysDescripcionesModificacionLineasProductos(List<ModificacionLineasProductos> modificacionlineasproductossTemp) throws Exception {
		for(ModificacionLineasProductos modificacionlineasproductosAux:modificacionlineasproductossTemp) {
			
			modificacionlineasproductosAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(modificacionlineasproductosAux.getProducto()));
			modificacionlineasproductosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLinea()));
			modificacionlineasproductosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaGrupo()));
			modificacionlineasproductosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaCategoria()));
			modificacionlineasproductosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaMarca()));
			modificacionlineasproductosAux.setlineadestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaDestino()));
			modificacionlineasproductosAux.setlineagrupodestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaGrupoDestino()));
			modificacionlineasproductosAux.setlineacategoriadestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaCategoriaDestino()));
			modificacionlineasproductosAux.setlineamarcadestino_descripcion(LineaConstantesFunciones.getLineaDescripcion(modificacionlineasproductosAux.getLineaMarcaDestino()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfModificacionLineasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfModificacionLineasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfModificacionLineasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ModificacionLineasProductosConstantesFunciones.getClassesRelationshipsOfModificacionLineasProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfModificacionLineasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfModificacionLineasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ModificacionLineasProductosConstantesFunciones.getClassesRelationshipsFromStringsOfModificacionLineasProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfModificacionLineasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ModificacionLineasProductos modificacionlineasproductos,List<ModificacionLineasProductos> modificacionlineasproductoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ModificacionLineasProductos modificacionlineasproductos,List<ModificacionLineasProductos> modificacionlineasproductoss) throws Exception {
		try	{			
			for(ModificacionLineasProductos modificacionlineasproductosLocal:modificacionlineasproductoss) {
				if(modificacionlineasproductosLocal.getId().equals(modificacionlineasproductos.getId())) {
					modificacionlineasproductosLocal.setIsSelected(modificacionlineasproductos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesModificacionLineasProductos(List<ModificacionLineasProductos> modificacionlineasproductossAux) throws Exception {
		//this.modificacionlineasproductossAux=modificacionlineasproductossAux;
		
		for(ModificacionLineasProductos modificacionlineasproductosAux:modificacionlineasproductossAux) {
			if(modificacionlineasproductosAux.getIsChanged()) {
				modificacionlineasproductosAux.setIsChanged(false);
			}		
			
			if(modificacionlineasproductosAux.getIsNew()) {
				modificacionlineasproductosAux.setIsNew(false);
			}	
			
			if(modificacionlineasproductosAux.getIsDeleted()) {
				modificacionlineasproductosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesModificacionLineasProductos(ModificacionLineasProductos modificacionlineasproductosAux) throws Exception {
		//this.modificacionlineasproductosAux=modificacionlineasproductosAux;
		
			if(modificacionlineasproductosAux.getIsChanged()) {
				modificacionlineasproductosAux.setIsChanged(false);
			}		
			
			if(modificacionlineasproductosAux.getIsNew()) {
				modificacionlineasproductosAux.setIsNew(false);
			}	
			
			if(modificacionlineasproductosAux.getIsDeleted()) {
				modificacionlineasproductosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ModificacionLineasProductos modificacionlineasproductosAsignar,ModificacionLineasProductos modificacionlineasproductos) throws Exception {
		modificacionlineasproductosAsignar.setId(modificacionlineasproductos.getId());	
		modificacionlineasproductosAsignar.setVersionRow(modificacionlineasproductos.getVersionRow());	
		modificacionlineasproductosAsignar.setid_producto(modificacionlineasproductos.getid_producto());
		modificacionlineasproductosAsignar.setproducto_descripcion(modificacionlineasproductos.getproducto_descripcion());	
		modificacionlineasproductosAsignar.setid_linea(modificacionlineasproductos.getid_linea());
		modificacionlineasproductosAsignar.setlinea_descripcion(modificacionlineasproductos.getlinea_descripcion());	
		modificacionlineasproductosAsignar.setid_linea_grupo(modificacionlineasproductos.getid_linea_grupo());
		modificacionlineasproductosAsignar.setlineagrupo_descripcion(modificacionlineasproductos.getlineagrupo_descripcion());	
		modificacionlineasproductosAsignar.setid_linea_categoria(modificacionlineasproductos.getid_linea_categoria());
		modificacionlineasproductosAsignar.setlineacategoria_descripcion(modificacionlineasproductos.getlineacategoria_descripcion());	
		modificacionlineasproductosAsignar.setid_linea_marca(modificacionlineasproductos.getid_linea_marca());
		modificacionlineasproductosAsignar.setlineamarca_descripcion(modificacionlineasproductos.getlineamarca_descripcion());	
		modificacionlineasproductosAsignar.setid_linea_destino(modificacionlineasproductos.getid_linea_destino());
		modificacionlineasproductosAsignar.setlineadestino_descripcion(modificacionlineasproductos.getlineadestino_descripcion());	
		modificacionlineasproductosAsignar.setid_linea_grupo_destino(modificacionlineasproductos.getid_linea_grupo_destino());
		modificacionlineasproductosAsignar.setlineagrupodestino_descripcion(modificacionlineasproductos.getlineagrupodestino_descripcion());	
		modificacionlineasproductosAsignar.setid_linea_categoria_destino(modificacionlineasproductos.getid_linea_categoria_destino());
		modificacionlineasproductosAsignar.setlineacategoriadestino_descripcion(modificacionlineasproductos.getlineacategoriadestino_descripcion());	
		modificacionlineasproductosAsignar.setid_linea_marca_destino(modificacionlineasproductos.getid_linea_marca_destino());
		modificacionlineasproductosAsignar.setlineamarcadestino_descripcion(modificacionlineasproductos.getlineamarcadestino_descripcion());	
	}
	
	public static void inicializarModificacionLineasProductos(ModificacionLineasProductos modificacionlineasproductos) throws Exception {
		try {
				modificacionlineasproductos.setId(0L);	
					
				modificacionlineasproductos.setid_producto(-1L);	
				modificacionlineasproductos.setid_linea(-1L);	
				modificacionlineasproductos.setid_linea_grupo(-1L);	
				modificacionlineasproductos.setid_linea_categoria(-1L);	
				modificacionlineasproductos.setid_linea_marca(-1L);	
				modificacionlineasproductos.setid_linea_destino(-1L);	
				modificacionlineasproductos.setid_linea_grupo_destino(-1L);	
				modificacionlineasproductos.setid_linea_categoria_destino(-1L);	
				modificacionlineasproductos.setid_linea_marca_destino(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderModificacionLineasProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAGRUPODESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEACATEGORIADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ModificacionLineasProductosConstantesFunciones.LABEL_IDLINEAMARCADESTINO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataModificacionLineasProductos(String sTipo,Row row,Workbook workbook,ModificacionLineasProductos modificacionlineasproductos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlineadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlineagrupodestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlineacategoriadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(modificacionlineasproductos.getlineamarcadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryModificacionLineasProductos="";
	
	public String getsFinalQueryModificacionLineasProductos() {
		return this.sFinalQueryModificacionLineasProductos;
	}
	
	public void setsFinalQueryModificacionLineasProductos(String sFinalQueryModificacionLineasProductos) {
		this.sFinalQueryModificacionLineasProductos= sFinalQueryModificacionLineasProductos;
	}
	
	public Border resaltarSeleccionarModificacionLineasProductos=null;
	
	public Border setResaltarSeleccionarModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarModificacionLineasProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarModificacionLineasProductos() {
		return this.resaltarSeleccionarModificacionLineasProductos;
	}
	
	public void setResaltarSeleccionarModificacionLineasProductos(Border borderResaltarSeleccionarModificacionLineasProductos) {
		this.resaltarSeleccionarModificacionLineasProductos= borderResaltarSeleccionarModificacionLineasProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridModificacionLineasProductos=null;
	public Boolean mostraridModificacionLineasProductos=true;
	public Boolean activaridModificacionLineasProductos=true;

	public Border resaltarid_productoModificacionLineasProductos=null;
	public Boolean mostrarid_productoModificacionLineasProductos=true;
	public Boolean activarid_productoModificacionLineasProductos=true;
	public Boolean cargarid_productoModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_lineaModificacionLineasProductos=null;
	public Boolean mostrarid_lineaModificacionLineasProductos=true;
	public Boolean activarid_lineaModificacionLineasProductos=true;
	public Boolean cargarid_lineaModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoModificacionLineasProductos=null;
	public Boolean mostrarid_linea_grupoModificacionLineasProductos=true;
	public Boolean activarid_linea_grupoModificacionLineasProductos=true;
	public Boolean cargarid_linea_grupoModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaModificacionLineasProductos=null;
	public Boolean mostrarid_linea_categoriaModificacionLineasProductos=true;
	public Boolean activarid_linea_categoriaModificacionLineasProductos=true;
	public Boolean cargarid_linea_categoriaModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaModificacionLineasProductos=null;
	public Boolean mostrarid_linea_marcaModificacionLineasProductos=true;
	public Boolean activarid_linea_marcaModificacionLineasProductos=true;
	public Boolean cargarid_linea_marcaModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_destinoModificacionLineasProductos=null;
	public Boolean mostrarid_linea_destinoModificacionLineasProductos=true;
	public Boolean activarid_linea_destinoModificacionLineasProductos=true;
	public Boolean cargarid_linea_destinoModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_destinoModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupo_destinoModificacionLineasProductos=null;
	public Boolean mostrarid_linea_grupo_destinoModificacionLineasProductos=true;
	public Boolean activarid_linea_grupo_destinoModificacionLineasProductos=true;
	public Boolean cargarid_linea_grupo_destinoModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupo_destinoModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoria_destinoModificacionLineasProductos=null;
	public Boolean mostrarid_linea_categoria_destinoModificacionLineasProductos=true;
	public Boolean activarid_linea_categoria_destinoModificacionLineasProductos=true;
	public Boolean cargarid_linea_categoria_destinoModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoria_destinoModificacionLineasProductos=false;//ConEventDepend=true

	public Border resaltarid_linea_marca_destinoModificacionLineasProductos=null;
	public Boolean mostrarid_linea_marca_destinoModificacionLineasProductos=true;
	public Boolean activarid_linea_marca_destinoModificacionLineasProductos=true;
	public Boolean cargarid_linea_marca_destinoModificacionLineasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marca_destinoModificacionLineasProductos=false;//ConEventDepend=true

	
	

	public Border setResaltaridModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltaridModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridModificacionLineasProductos() {
		return this.resaltaridModificacionLineasProductos;
	}

	public void setResaltaridModificacionLineasProductos(Border borderResaltar) {
		this.resaltaridModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostraridModificacionLineasProductos() {
		return this.mostraridModificacionLineasProductos;
	}

	public void setMostraridModificacionLineasProductos(Boolean mostraridModificacionLineasProductos) {
		this.mostraridModificacionLineasProductos= mostraridModificacionLineasProductos;
	}

	public Boolean getActivaridModificacionLineasProductos() {
		return this.activaridModificacionLineasProductos;
	}

	public void setActivaridModificacionLineasProductos(Boolean activaridModificacionLineasProductos) {
		this.activaridModificacionLineasProductos= activaridModificacionLineasProductos;
	}

	public Border setResaltarid_productoModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_productoModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoModificacionLineasProductos() {
		return this.resaltarid_productoModificacionLineasProductos;
	}

	public void setResaltarid_productoModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_productoModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_productoModificacionLineasProductos() {
		return this.mostrarid_productoModificacionLineasProductos;
	}

	public void setMostrarid_productoModificacionLineasProductos(Boolean mostrarid_productoModificacionLineasProductos) {
		this.mostrarid_productoModificacionLineasProductos= mostrarid_productoModificacionLineasProductos;
	}

	public Boolean getActivarid_productoModificacionLineasProductos() {
		return this.activarid_productoModificacionLineasProductos;
	}

	public void setActivarid_productoModificacionLineasProductos(Boolean activarid_productoModificacionLineasProductos) {
		this.activarid_productoModificacionLineasProductos= activarid_productoModificacionLineasProductos;
	}

	public Boolean getCargarid_productoModificacionLineasProductos() {
		return this.cargarid_productoModificacionLineasProductos;
	}

	public void setCargarid_productoModificacionLineasProductos(Boolean cargarid_productoModificacionLineasProductos) {
		this.cargarid_productoModificacionLineasProductos= cargarid_productoModificacionLineasProductos;
	}

	public Border setResaltarid_lineaModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_lineaModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaModificacionLineasProductos() {
		return this.resaltarid_lineaModificacionLineasProductos;
	}

	public void setResaltarid_lineaModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_lineaModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_lineaModificacionLineasProductos() {
		return this.mostrarid_lineaModificacionLineasProductos;
	}

	public void setMostrarid_lineaModificacionLineasProductos(Boolean mostrarid_lineaModificacionLineasProductos) {
		this.mostrarid_lineaModificacionLineasProductos= mostrarid_lineaModificacionLineasProductos;
	}

	public Boolean getActivarid_lineaModificacionLineasProductos() {
		return this.activarid_lineaModificacionLineasProductos;
	}

	public void setActivarid_lineaModificacionLineasProductos(Boolean activarid_lineaModificacionLineasProductos) {
		this.activarid_lineaModificacionLineasProductos= activarid_lineaModificacionLineasProductos;
	}

	public Boolean getCargarid_lineaModificacionLineasProductos() {
		return this.cargarid_lineaModificacionLineasProductos;
	}

	public void setCargarid_lineaModificacionLineasProductos(Boolean cargarid_lineaModificacionLineasProductos) {
		this.cargarid_lineaModificacionLineasProductos= cargarid_lineaModificacionLineasProductos;
	}

	public Border setResaltarid_linea_grupoModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoModificacionLineasProductos() {
		return this.resaltarid_linea_grupoModificacionLineasProductos;
	}

	public void setResaltarid_linea_grupoModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_linea_grupoModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoModificacionLineasProductos() {
		return this.mostrarid_linea_grupoModificacionLineasProductos;
	}

	public void setMostrarid_linea_grupoModificacionLineasProductos(Boolean mostrarid_linea_grupoModificacionLineasProductos) {
		this.mostrarid_linea_grupoModificacionLineasProductos= mostrarid_linea_grupoModificacionLineasProductos;
	}

	public Boolean getActivarid_linea_grupoModificacionLineasProductos() {
		return this.activarid_linea_grupoModificacionLineasProductos;
	}

	public void setActivarid_linea_grupoModificacionLineasProductos(Boolean activarid_linea_grupoModificacionLineasProductos) {
		this.activarid_linea_grupoModificacionLineasProductos= activarid_linea_grupoModificacionLineasProductos;
	}

	public Boolean getCargarid_linea_grupoModificacionLineasProductos() {
		return this.cargarid_linea_grupoModificacionLineasProductos;
	}

	public void setCargarid_linea_grupoModificacionLineasProductos(Boolean cargarid_linea_grupoModificacionLineasProductos) {
		this.cargarid_linea_grupoModificacionLineasProductos= cargarid_linea_grupoModificacionLineasProductos;
	}

	public Border setResaltarid_linea_categoriaModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaModificacionLineasProductos() {
		return this.resaltarid_linea_categoriaModificacionLineasProductos;
	}

	public void setResaltarid_linea_categoriaModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_linea_categoriaModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaModificacionLineasProductos() {
		return this.mostrarid_linea_categoriaModificacionLineasProductos;
	}

	public void setMostrarid_linea_categoriaModificacionLineasProductos(Boolean mostrarid_linea_categoriaModificacionLineasProductos) {
		this.mostrarid_linea_categoriaModificacionLineasProductos= mostrarid_linea_categoriaModificacionLineasProductos;
	}

	public Boolean getActivarid_linea_categoriaModificacionLineasProductos() {
		return this.activarid_linea_categoriaModificacionLineasProductos;
	}

	public void setActivarid_linea_categoriaModificacionLineasProductos(Boolean activarid_linea_categoriaModificacionLineasProductos) {
		this.activarid_linea_categoriaModificacionLineasProductos= activarid_linea_categoriaModificacionLineasProductos;
	}

	public Boolean getCargarid_linea_categoriaModificacionLineasProductos() {
		return this.cargarid_linea_categoriaModificacionLineasProductos;
	}

	public void setCargarid_linea_categoriaModificacionLineasProductos(Boolean cargarid_linea_categoriaModificacionLineasProductos) {
		this.cargarid_linea_categoriaModificacionLineasProductos= cargarid_linea_categoriaModificacionLineasProductos;
	}

	public Border setResaltarid_linea_marcaModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaModificacionLineasProductos() {
		return this.resaltarid_linea_marcaModificacionLineasProductos;
	}

	public void setResaltarid_linea_marcaModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_linea_marcaModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaModificacionLineasProductos() {
		return this.mostrarid_linea_marcaModificacionLineasProductos;
	}

	public void setMostrarid_linea_marcaModificacionLineasProductos(Boolean mostrarid_linea_marcaModificacionLineasProductos) {
		this.mostrarid_linea_marcaModificacionLineasProductos= mostrarid_linea_marcaModificacionLineasProductos;
	}

	public Boolean getActivarid_linea_marcaModificacionLineasProductos() {
		return this.activarid_linea_marcaModificacionLineasProductos;
	}

	public void setActivarid_linea_marcaModificacionLineasProductos(Boolean activarid_linea_marcaModificacionLineasProductos) {
		this.activarid_linea_marcaModificacionLineasProductos= activarid_linea_marcaModificacionLineasProductos;
	}

	public Boolean getCargarid_linea_marcaModificacionLineasProductos() {
		return this.cargarid_linea_marcaModificacionLineasProductos;
	}

	public void setCargarid_linea_marcaModificacionLineasProductos(Boolean cargarid_linea_marcaModificacionLineasProductos) {
		this.cargarid_linea_marcaModificacionLineasProductos= cargarid_linea_marcaModificacionLineasProductos;
	}

	public Border setResaltarid_linea_destinoModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_destinoModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_destinoModificacionLineasProductos() {
		return this.resaltarid_linea_destinoModificacionLineasProductos;
	}

	public void setResaltarid_linea_destinoModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_linea_destinoModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_destinoModificacionLineasProductos() {
		return this.mostrarid_linea_destinoModificacionLineasProductos;
	}

	public void setMostrarid_linea_destinoModificacionLineasProductos(Boolean mostrarid_linea_destinoModificacionLineasProductos) {
		this.mostrarid_linea_destinoModificacionLineasProductos= mostrarid_linea_destinoModificacionLineasProductos;
	}

	public Boolean getActivarid_linea_destinoModificacionLineasProductos() {
		return this.activarid_linea_destinoModificacionLineasProductos;
	}

	public void setActivarid_linea_destinoModificacionLineasProductos(Boolean activarid_linea_destinoModificacionLineasProductos) {
		this.activarid_linea_destinoModificacionLineasProductos= activarid_linea_destinoModificacionLineasProductos;
	}

	public Boolean getCargarid_linea_destinoModificacionLineasProductos() {
		return this.cargarid_linea_destinoModificacionLineasProductos;
	}

	public void setCargarid_linea_destinoModificacionLineasProductos(Boolean cargarid_linea_destinoModificacionLineasProductos) {
		this.cargarid_linea_destinoModificacionLineasProductos= cargarid_linea_destinoModificacionLineasProductos;
	}

	public Border setResaltarid_linea_grupo_destinoModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupo_destinoModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupo_destinoModificacionLineasProductos() {
		return this.resaltarid_linea_grupo_destinoModificacionLineasProductos;
	}

	public void setResaltarid_linea_grupo_destinoModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_linea_grupo_destinoModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupo_destinoModificacionLineasProductos() {
		return this.mostrarid_linea_grupo_destinoModificacionLineasProductos;
	}

	public void setMostrarid_linea_grupo_destinoModificacionLineasProductos(Boolean mostrarid_linea_grupo_destinoModificacionLineasProductos) {
		this.mostrarid_linea_grupo_destinoModificacionLineasProductos= mostrarid_linea_grupo_destinoModificacionLineasProductos;
	}

	public Boolean getActivarid_linea_grupo_destinoModificacionLineasProductos() {
		return this.activarid_linea_grupo_destinoModificacionLineasProductos;
	}

	public void setActivarid_linea_grupo_destinoModificacionLineasProductos(Boolean activarid_linea_grupo_destinoModificacionLineasProductos) {
		this.activarid_linea_grupo_destinoModificacionLineasProductos= activarid_linea_grupo_destinoModificacionLineasProductos;
	}

	public Boolean getCargarid_linea_grupo_destinoModificacionLineasProductos() {
		return this.cargarid_linea_grupo_destinoModificacionLineasProductos;
	}

	public void setCargarid_linea_grupo_destinoModificacionLineasProductos(Boolean cargarid_linea_grupo_destinoModificacionLineasProductos) {
		this.cargarid_linea_grupo_destinoModificacionLineasProductos= cargarid_linea_grupo_destinoModificacionLineasProductos;
	}

	public Border setResaltarid_linea_categoria_destinoModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoria_destinoModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoria_destinoModificacionLineasProductos() {
		return this.resaltarid_linea_categoria_destinoModificacionLineasProductos;
	}

	public void setResaltarid_linea_categoria_destinoModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_linea_categoria_destinoModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoria_destinoModificacionLineasProductos() {
		return this.mostrarid_linea_categoria_destinoModificacionLineasProductos;
	}

	public void setMostrarid_linea_categoria_destinoModificacionLineasProductos(Boolean mostrarid_linea_categoria_destinoModificacionLineasProductos) {
		this.mostrarid_linea_categoria_destinoModificacionLineasProductos= mostrarid_linea_categoria_destinoModificacionLineasProductos;
	}

	public Boolean getActivarid_linea_categoria_destinoModificacionLineasProductos() {
		return this.activarid_linea_categoria_destinoModificacionLineasProductos;
	}

	public void setActivarid_linea_categoria_destinoModificacionLineasProductos(Boolean activarid_linea_categoria_destinoModificacionLineasProductos) {
		this.activarid_linea_categoria_destinoModificacionLineasProductos= activarid_linea_categoria_destinoModificacionLineasProductos;
	}

	public Boolean getCargarid_linea_categoria_destinoModificacionLineasProductos() {
		return this.cargarid_linea_categoria_destinoModificacionLineasProductos;
	}

	public void setCargarid_linea_categoria_destinoModificacionLineasProductos(Boolean cargarid_linea_categoria_destinoModificacionLineasProductos) {
		this.cargarid_linea_categoria_destinoModificacionLineasProductos= cargarid_linea_categoria_destinoModificacionLineasProductos;
	}

	public Border setResaltarid_linea_marca_destinoModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//modificacionlineasproductosBeanSwingJInternalFrame.jTtoolBarModificacionLineasProductos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marca_destinoModificacionLineasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marca_destinoModificacionLineasProductos() {
		return this.resaltarid_linea_marca_destinoModificacionLineasProductos;
	}

	public void setResaltarid_linea_marca_destinoModificacionLineasProductos(Border borderResaltar) {
		this.resaltarid_linea_marca_destinoModificacionLineasProductos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marca_destinoModificacionLineasProductos() {
		return this.mostrarid_linea_marca_destinoModificacionLineasProductos;
	}

	public void setMostrarid_linea_marca_destinoModificacionLineasProductos(Boolean mostrarid_linea_marca_destinoModificacionLineasProductos) {
		this.mostrarid_linea_marca_destinoModificacionLineasProductos= mostrarid_linea_marca_destinoModificacionLineasProductos;
	}

	public Boolean getActivarid_linea_marca_destinoModificacionLineasProductos() {
		return this.activarid_linea_marca_destinoModificacionLineasProductos;
	}

	public void setActivarid_linea_marca_destinoModificacionLineasProductos(Boolean activarid_linea_marca_destinoModificacionLineasProductos) {
		this.activarid_linea_marca_destinoModificacionLineasProductos= activarid_linea_marca_destinoModificacionLineasProductos;
	}

	public Boolean getCargarid_linea_marca_destinoModificacionLineasProductos() {
		return this.cargarid_linea_marca_destinoModificacionLineasProductos;
	}

	public void setCargarid_linea_marca_destinoModificacionLineasProductos(Boolean cargarid_linea_marca_destinoModificacionLineasProductos) {
		this.cargarid_linea_marca_destinoModificacionLineasProductos= cargarid_linea_marca_destinoModificacionLineasProductos;
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
		
		
		this.setMostraridModificacionLineasProductos(esInicial);
		this.setMostrarid_productoModificacionLineasProductos(esInicial);
		this.setMostrarid_lineaModificacionLineasProductos(esInicial);
		this.setMostrarid_linea_grupoModificacionLineasProductos(esInicial);
		this.setMostrarid_linea_categoriaModificacionLineasProductos(esInicial);
		this.setMostrarid_linea_marcaModificacionLineasProductos(esInicial);
		this.setMostrarid_linea_destinoModificacionLineasProductos(esInicial);
		this.setMostrarid_linea_grupo_destinoModificacionLineasProductos(esInicial);
		this.setMostrarid_linea_categoria_destinoModificacionLineasProductos(esInicial);
		this.setMostrarid_linea_marca_destinoModificacionLineasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.ID)) {
				this.setMostraridModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEADESTINO)) {
				this.setMostrarid_linea_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPODESTINO)) {
				this.setMostrarid_linea_grupo_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIADESTINO)) {
				this.setMostrarid_linea_categoria_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCADESTINO)) {
				this.setMostrarid_linea_marca_destinoModificacionLineasProductos(esAsigna);
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
		
		
		this.setActivaridModificacionLineasProductos(esInicial);
		this.setActivarid_productoModificacionLineasProductos(esInicial);
		this.setActivarid_lineaModificacionLineasProductos(esInicial);
		this.setActivarid_linea_grupoModificacionLineasProductos(esInicial);
		this.setActivarid_linea_categoriaModificacionLineasProductos(esInicial);
		this.setActivarid_linea_marcaModificacionLineasProductos(esInicial);
		this.setActivarid_linea_destinoModificacionLineasProductos(esInicial);
		this.setActivarid_linea_grupo_destinoModificacionLineasProductos(esInicial);
		this.setActivarid_linea_categoria_destinoModificacionLineasProductos(esInicial);
		this.setActivarid_linea_marca_destinoModificacionLineasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.ID)) {
				this.setActivaridModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEADESTINO)) {
				this.setActivarid_linea_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPODESTINO)) {
				this.setActivarid_linea_grupo_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIADESTINO)) {
				this.setActivarid_linea_categoria_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCADESTINO)) {
				this.setActivarid_linea_marca_destinoModificacionLineasProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridModificacionLineasProductos(esInicial);
		this.setResaltarid_productoModificacionLineasProductos(esInicial);
		this.setResaltarid_lineaModificacionLineasProductos(esInicial);
		this.setResaltarid_linea_grupoModificacionLineasProductos(esInicial);
		this.setResaltarid_linea_categoriaModificacionLineasProductos(esInicial);
		this.setResaltarid_linea_marcaModificacionLineasProductos(esInicial);
		this.setResaltarid_linea_destinoModificacionLineasProductos(esInicial);
		this.setResaltarid_linea_grupo_destinoModificacionLineasProductos(esInicial);
		this.setResaltarid_linea_categoria_destinoModificacionLineasProductos(esInicial);
		this.setResaltarid_linea_marca_destinoModificacionLineasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.ID)) {
				this.setResaltaridModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEADESTINO)) {
				this.setResaltarid_linea_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAGRUPODESTINO)) {
				this.setResaltarid_linea_grupo_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEACATEGORIADESTINO)) {
				this.setResaltarid_linea_categoria_destinoModificacionLineasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ModificacionLineasProductosConstantesFunciones.IDLINEAMARCADESTINO)) {
				this.setResaltarid_linea_marca_destinoModificacionLineasProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaModificacionLineasProductosModificacionLineasProductos=true;

	public Boolean getMostrarBusquedaModificacionLineasProductosModificacionLineasProductos() {
		return this.mostrarBusquedaModificacionLineasProductosModificacionLineasProductos;
	}

	public void setMostrarBusquedaModificacionLineasProductosModificacionLineasProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaModificacionLineasProductosModificacionLineasProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaModificacionLineasProductosModificacionLineasProductos=true;

	public Boolean getActivarBusquedaModificacionLineasProductosModificacionLineasProductos() {
		return this.activarBusquedaModificacionLineasProductosModificacionLineasProductos;
	}

	public void setActivarBusquedaModificacionLineasProductosModificacionLineasProductos(Boolean habilitarResaltar) {
		this.activarBusquedaModificacionLineasProductosModificacionLineasProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaModificacionLineasProductosModificacionLineasProductos=null;

	public Border getResaltarBusquedaModificacionLineasProductosModificacionLineasProductos() {
		return this.resaltarBusquedaModificacionLineasProductosModificacionLineasProductos;
	}

	public void setResaltarBusquedaModificacionLineasProductosModificacionLineasProductos(Border borderResaltar) {
		this.resaltarBusquedaModificacionLineasProductosModificacionLineasProductos= borderResaltar;
	}

	public void setResaltarBusquedaModificacionLineasProductosModificacionLineasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ModificacionLineasProductosBeanSwingJInternalFrame modificacionlineasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaModificacionLineasProductosModificacionLineasProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}