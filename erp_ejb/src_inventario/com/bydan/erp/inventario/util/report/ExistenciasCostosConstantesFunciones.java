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


import com.bydan.erp.inventario.util.report.ExistenciasCostosConstantesFunciones;
import com.bydan.erp.inventario.util.report.ExistenciasCostosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ExistenciasCostosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ExistenciasCostosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ExistenciasCostos";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ExistenciasCostos"+ExistenciasCostosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ExistenciasCostosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ExistenciasCostosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ExistenciasCostosConstantesFunciones.SCHEMA+"_"+ExistenciasCostosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ExistenciasCostosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ExistenciasCostosConstantesFunciones.SCHEMA+"_"+ExistenciasCostosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ExistenciasCostosConstantesFunciones.SCHEMA+"_"+ExistenciasCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ExistenciasCostosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ExistenciasCostosConstantesFunciones.SCHEMA+"_"+ExistenciasCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasCostosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ExistenciasCostosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasCostosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ExistenciasCostosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ExistenciasCostosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ExistenciasCostosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ExistenciasCostosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ExistenciasCostosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ExistenciasCostosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Existencias Costoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Existencias Costos";
	public static final String SCLASSWEBTITULO_LOWER="Existencias Costos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ExistenciasCostos";
	public static final String OBJECTNAME="existenciascostos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="existencias_costos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select existenciascostos from "+ExistenciasCostosConstantesFunciones.SPERSISTENCENAME+" existenciascostos";
	public static String QUERYSELECTNATIVE="select "+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".id,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".version_row,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".id_empresa,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".id_linea,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".id_linea_grupo,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".id_linea_categoria,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".id_linea_marca,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".nombre_producto,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".nombre_unidad,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".nombre_linea,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".codigo,"+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME+".costo_total from "+ExistenciasCostosConstantesFunciones.SCHEMA+"."+ExistenciasCostosConstantesFunciones.TABLENAME;//+" as "+ExistenciasCostosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CODIGO= "codigo";
    public static final String COSTOTOTAL= "costo_total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
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
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
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
		
	
	public static String getExistenciasCostosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.IDLINEA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.CODIGO)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ExistenciasCostosConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ExistenciasCostosConstantesFunciones.LABEL_COSTOTOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getExistenciasCostosDescripcion(ExistenciasCostos existenciascostos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(existenciascostos !=null/* && existenciascostos.getId()!=0*/) {
			sDescripcion=existenciascostos.getcodigo();//existenciascostosexistenciascostos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getExistenciasCostosDescripcionDetallado(ExistenciasCostos existenciascostos) {
		String sDescripcion="";
			
		sDescripcion+=ExistenciasCostosConstantesFunciones.ID+"=";
		sDescripcion+=existenciascostos.getId().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=existenciascostos.getVersionRow().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=existenciascostos.getid_empresa().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=existenciascostos.getid_linea().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=existenciascostos.getid_linea_grupo().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=existenciascostos.getid_linea_categoria().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=existenciascostos.getid_linea_marca().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=existenciascostos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=existenciascostos.getnombre_producto()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=existenciascostos.getnombre_unidad()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=existenciascostos.getnombre_linea()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=existenciascostos.getnombre_linea_grupo()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=existenciascostos.getnombre_linea_categoria()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=existenciascostos.getnombre_linea_marca()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.CODIGO+"=";
		sDescripcion+=existenciascostos.getcodigo()+",";
		sDescripcion+=ExistenciasCostosConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=existenciascostos.getcosto_total().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setExistenciasCostosDescripcion(ExistenciasCostos existenciascostos,String sValor) throws Exception {			
		if(existenciascostos !=null) {
			existenciascostos.setcodigo(sValor);;//existenciascostosexistenciascostos.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("BusquedaExistenciasCostos")) {
			sNombreIndice="Tipo=  Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Hasta";
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaExistenciasCostos(Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
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
	
	
	
	
	
	
	public static void quitarEspaciosExistenciasCostos(ExistenciasCostos existenciascostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		existenciascostos.setnombre_producto(existenciascostos.getnombre_producto().trim());
		existenciascostos.setnombre_unidad(existenciascostos.getnombre_unidad().trim());
		existenciascostos.setnombre_linea(existenciascostos.getnombre_linea().trim());
		existenciascostos.setnombre_linea_grupo(existenciascostos.getnombre_linea_grupo().trim());
		existenciascostos.setnombre_linea_categoria(existenciascostos.getnombre_linea_categoria().trim());
		existenciascostos.setnombre_linea_marca(existenciascostos.getnombre_linea_marca().trim());
		existenciascostos.setcodigo(existenciascostos.getcodigo().trim());
	}
	
	public static void quitarEspaciosExistenciasCostoss(List<ExistenciasCostos> existenciascostoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ExistenciasCostos existenciascostos: existenciascostoss) {
			existenciascostos.setnombre_producto(existenciascostos.getnombre_producto().trim());
			existenciascostos.setnombre_unidad(existenciascostos.getnombre_unidad().trim());
			existenciascostos.setnombre_linea(existenciascostos.getnombre_linea().trim());
			existenciascostos.setnombre_linea_grupo(existenciascostos.getnombre_linea_grupo().trim());
			existenciascostos.setnombre_linea_categoria(existenciascostos.getnombre_linea_categoria().trim());
			existenciascostos.setnombre_linea_marca(existenciascostos.getnombre_linea_marca().trim());
			existenciascostos.setcodigo(existenciascostos.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresExistenciasCostos(ExistenciasCostos existenciascostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && existenciascostos.getConCambioAuxiliar()) {
			existenciascostos.setIsDeleted(existenciascostos.getIsDeletedAuxiliar());	
			existenciascostos.setIsNew(existenciascostos.getIsNewAuxiliar());	
			existenciascostos.setIsChanged(existenciascostos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			existenciascostos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			existenciascostos.setIsDeletedAuxiliar(false);	
			existenciascostos.setIsNewAuxiliar(false);	
			existenciascostos.setIsChangedAuxiliar(false);
			
			existenciascostos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresExistenciasCostoss(List<ExistenciasCostos> existenciascostoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ExistenciasCostos existenciascostos : existenciascostoss) {
			if(conAsignarBase && existenciascostos.getConCambioAuxiliar()) {
				existenciascostos.setIsDeleted(existenciascostos.getIsDeletedAuxiliar());	
				existenciascostos.setIsNew(existenciascostos.getIsNewAuxiliar());	
				existenciascostos.setIsChanged(existenciascostos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				existenciascostos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				existenciascostos.setIsDeletedAuxiliar(false);	
				existenciascostos.setIsNewAuxiliar(false);	
				existenciascostos.setIsChangedAuxiliar(false);
				
				existenciascostos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresExistenciasCostos(ExistenciasCostos existenciascostos,Boolean conEnteros) throws Exception  {
		existenciascostos.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresExistenciasCostoss(List<ExistenciasCostos> existenciascostoss,Boolean conEnteros) throws Exception  {
		
		for(ExistenciasCostos existenciascostos: existenciascostoss) {
			existenciascostos.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaExistenciasCostos(List<ExistenciasCostos> existenciascostoss,ExistenciasCostos existenciascostosAux) throws Exception  {
		ExistenciasCostosConstantesFunciones.InicializarValoresExistenciasCostos(existenciascostosAux,true);
		
		for(ExistenciasCostos existenciascostos: existenciascostoss) {
			if(existenciascostos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			existenciascostosAux.setcosto_total(existenciascostosAux.getcosto_total()+existenciascostos.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesExistenciasCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ExistenciasCostosConstantesFunciones.getArrayColumnasGlobalesExistenciasCostos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesExistenciasCostos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ExistenciasCostosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ExistenciasCostosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoExistenciasCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ExistenciasCostos> existenciascostoss,ExistenciasCostos existenciascostos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ExistenciasCostos existenciascostosAux: existenciascostoss) {
			if(existenciascostosAux!=null && existenciascostos!=null) {
				if((existenciascostosAux.getId()==null && existenciascostos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(existenciascostosAux.getId()!=null && existenciascostos.getId()!=null){
					if(existenciascostosAux.getId().equals(existenciascostos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaExistenciasCostos(List<ExistenciasCostos> existenciascostoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_totalTotal=0.0;
	
		for(ExistenciasCostos existenciascostos: existenciascostoss) {			
			if(existenciascostos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_totalTotal+=existenciascostos.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ExistenciasCostosConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaExistenciasCostos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_ID, ExistenciasCostosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_VERSIONROW, ExistenciasCostosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_NOMBREPRODUCTO, ExistenciasCostosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_NOMBREUNIDAD, ExistenciasCostosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEA, ExistenciasCostosConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ExistenciasCostosConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ExistenciasCostosConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA, ExistenciasCostosConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_CODIGO, ExistenciasCostosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ExistenciasCostosConstantesFunciones.LABEL_COSTOTOTAL, ExistenciasCostosConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasExistenciasCostos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ExistenciasCostosConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarExistenciasCostos() throws Exception  {
		return ExistenciasCostosConstantesFunciones.getTiposSeleccionarExistenciasCostos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarExistenciasCostos(Boolean conFk) throws Exception  {
		return ExistenciasCostosConstantesFunciones.getTiposSeleccionarExistenciasCostos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarExistenciasCostos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ExistenciasCostosConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesExistenciasCostos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesExistenciasCostos(ExistenciasCostos existenciascostosAux) throws Exception {
		
			existenciascostosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(existenciascostosAux.getEmpresa()));
			existenciascostosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLinea()));
			existenciascostosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLineaGrupo()));
			existenciascostosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLineaCategoria()));
			existenciascostosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesExistenciasCostos(List<ExistenciasCostos> existenciascostossTemp) throws Exception {
		for(ExistenciasCostos existenciascostosAux:existenciascostossTemp) {
			
			existenciascostosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(existenciascostosAux.getEmpresa()));
			existenciascostosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLinea()));
			existenciascostosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLineaGrupo()));
			existenciascostosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLineaCategoria()));
			existenciascostosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(existenciascostosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfExistenciasCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfExistenciasCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfExistenciasCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ExistenciasCostosConstantesFunciones.getClassesRelationshipsOfExistenciasCostos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfExistenciasCostos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfExistenciasCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ExistenciasCostosConstantesFunciones.getClassesRelationshipsFromStringsOfExistenciasCostos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfExistenciasCostos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ExistenciasCostos existenciascostos,List<ExistenciasCostos> existenciascostoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ExistenciasCostos existenciascostos,List<ExistenciasCostos> existenciascostoss) throws Exception {
		try	{			
			for(ExistenciasCostos existenciascostosLocal:existenciascostoss) {
				if(existenciascostosLocal.getId().equals(existenciascostos.getId())) {
					existenciascostosLocal.setIsSelected(existenciascostos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesExistenciasCostos(List<ExistenciasCostos> existenciascostossAux) throws Exception {
		//this.existenciascostossAux=existenciascostossAux;
		
		for(ExistenciasCostos existenciascostosAux:existenciascostossAux) {
			if(existenciascostosAux.getIsChanged()) {
				existenciascostosAux.setIsChanged(false);
			}		
			
			if(existenciascostosAux.getIsNew()) {
				existenciascostosAux.setIsNew(false);
			}	
			
			if(existenciascostosAux.getIsDeleted()) {
				existenciascostosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesExistenciasCostos(ExistenciasCostos existenciascostosAux) throws Exception {
		//this.existenciascostosAux=existenciascostosAux;
		
			if(existenciascostosAux.getIsChanged()) {
				existenciascostosAux.setIsChanged(false);
			}		
			
			if(existenciascostosAux.getIsNew()) {
				existenciascostosAux.setIsNew(false);
			}	
			
			if(existenciascostosAux.getIsDeleted()) {
				existenciascostosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ExistenciasCostos existenciascostosAsignar,ExistenciasCostos existenciascostos) throws Exception {
		existenciascostosAsignar.setId(existenciascostos.getId());	
		existenciascostosAsignar.setVersionRow(existenciascostos.getVersionRow());	
		existenciascostosAsignar.setnombre_producto(existenciascostos.getnombre_producto());	
		existenciascostosAsignar.setnombre_unidad(existenciascostos.getnombre_unidad());	
		existenciascostosAsignar.setnombre_linea(existenciascostos.getnombre_linea());	
		existenciascostosAsignar.setnombre_linea_grupo(existenciascostos.getnombre_linea_grupo());	
		existenciascostosAsignar.setnombre_linea_categoria(existenciascostos.getnombre_linea_categoria());	
		existenciascostosAsignar.setnombre_linea_marca(existenciascostos.getnombre_linea_marca());	
		existenciascostosAsignar.setcodigo(existenciascostos.getcodigo());	
		existenciascostosAsignar.setcosto_total(existenciascostos.getcosto_total());	
	}
	
	public static void inicializarExistenciasCostos(ExistenciasCostos existenciascostos) throws Exception {
		try {
				existenciascostos.setId(0L);	
					
				existenciascostos.setnombre_producto("");	
				existenciascostos.setnombre_unidad("");	
				existenciascostos.setnombre_linea("");	
				existenciascostos.setnombre_linea_grupo("");	
				existenciascostos.setnombre_linea_categoria("");	
				existenciascostos.setnombre_linea_marca("");	
				existenciascostos.setcodigo("");	
				existenciascostos.setcosto_total(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderExistenciasCostos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ExistenciasCostosConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataExistenciasCostos(String sTipo,Row row,Workbook workbook,ExistenciasCostos existenciascostos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(existenciascostos.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryExistenciasCostos="";
	
	public String getsFinalQueryExistenciasCostos() {
		return this.sFinalQueryExistenciasCostos;
	}
	
	public void setsFinalQueryExistenciasCostos(String sFinalQueryExistenciasCostos) {
		this.sFinalQueryExistenciasCostos= sFinalQueryExistenciasCostos;
	}
	
	public Border resaltarSeleccionarExistenciasCostos=null;
	
	public Border setResaltarSeleccionarExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarExistenciasCostos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarExistenciasCostos() {
		return this.resaltarSeleccionarExistenciasCostos;
	}
	
	public void setResaltarSeleccionarExistenciasCostos(Border borderResaltarSeleccionarExistenciasCostos) {
		this.resaltarSeleccionarExistenciasCostos= borderResaltarSeleccionarExistenciasCostos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridExistenciasCostos=null;
	public Boolean mostraridExistenciasCostos=true;
	public Boolean activaridExistenciasCostos=true;

	public Border resaltarid_empresaExistenciasCostos=null;
	public Boolean mostrarid_empresaExistenciasCostos=true;
	public Boolean activarid_empresaExistenciasCostos=true;
	public Boolean cargarid_empresaExistenciasCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaExistenciasCostos=false;//ConEventDepend=true

	public Border resaltarid_lineaExistenciasCostos=null;
	public Boolean mostrarid_lineaExistenciasCostos=true;
	public Boolean activarid_lineaExistenciasCostos=true;
	public Boolean cargarid_lineaExistenciasCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaExistenciasCostos=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoExistenciasCostos=null;
	public Boolean mostrarid_linea_grupoExistenciasCostos=true;
	public Boolean activarid_linea_grupoExistenciasCostos=true;
	public Boolean cargarid_linea_grupoExistenciasCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoExistenciasCostos=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaExistenciasCostos=null;
	public Boolean mostrarid_linea_categoriaExistenciasCostos=true;
	public Boolean activarid_linea_categoriaExistenciasCostos=true;
	public Boolean cargarid_linea_categoriaExistenciasCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaExistenciasCostos=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaExistenciasCostos=null;
	public Boolean mostrarid_linea_marcaExistenciasCostos=true;
	public Boolean activarid_linea_marcaExistenciasCostos=true;
	public Boolean cargarid_linea_marcaExistenciasCostos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaExistenciasCostos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_hastaExistenciasCostos=null;
	public Boolean mostrarfecha_emision_hastaExistenciasCostos=true;
	public Boolean activarfecha_emision_hastaExistenciasCostos=true;

	public Border resaltarnombre_productoExistenciasCostos=null;
	public Boolean mostrarnombre_productoExistenciasCostos=true;
	public Boolean activarnombre_productoExistenciasCostos=true;

	public Border resaltarnombre_unidadExistenciasCostos=null;
	public Boolean mostrarnombre_unidadExistenciasCostos=true;
	public Boolean activarnombre_unidadExistenciasCostos=true;

	public Border resaltarnombre_lineaExistenciasCostos=null;
	public Boolean mostrarnombre_lineaExistenciasCostos=true;
	public Boolean activarnombre_lineaExistenciasCostos=true;

	public Border resaltarnombre_linea_grupoExistenciasCostos=null;
	public Boolean mostrarnombre_linea_grupoExistenciasCostos=true;
	public Boolean activarnombre_linea_grupoExistenciasCostos=true;

	public Border resaltarnombre_linea_categoriaExistenciasCostos=null;
	public Boolean mostrarnombre_linea_categoriaExistenciasCostos=true;
	public Boolean activarnombre_linea_categoriaExistenciasCostos=true;

	public Border resaltarnombre_linea_marcaExistenciasCostos=null;
	public Boolean mostrarnombre_linea_marcaExistenciasCostos=true;
	public Boolean activarnombre_linea_marcaExistenciasCostos=true;

	public Border resaltarcodigoExistenciasCostos=null;
	public Boolean mostrarcodigoExistenciasCostos=true;
	public Boolean activarcodigoExistenciasCostos=true;

	public Border resaltarcosto_totalExistenciasCostos=null;
	public Boolean mostrarcosto_totalExistenciasCostos=true;
	public Boolean activarcosto_totalExistenciasCostos=true;

	
	

	public Border setResaltaridExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltaridExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridExistenciasCostos() {
		return this.resaltaridExistenciasCostos;
	}

	public void setResaltaridExistenciasCostos(Border borderResaltar) {
		this.resaltaridExistenciasCostos= borderResaltar;
	}

	public Boolean getMostraridExistenciasCostos() {
		return this.mostraridExistenciasCostos;
	}

	public void setMostraridExistenciasCostos(Boolean mostraridExistenciasCostos) {
		this.mostraridExistenciasCostos= mostraridExistenciasCostos;
	}

	public Boolean getActivaridExistenciasCostos() {
		return this.activaridExistenciasCostos;
	}

	public void setActivaridExistenciasCostos(Boolean activaridExistenciasCostos) {
		this.activaridExistenciasCostos= activaridExistenciasCostos;
	}

	public Border setResaltarid_empresaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarid_empresaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaExistenciasCostos() {
		return this.resaltarid_empresaExistenciasCostos;
	}

	public void setResaltarid_empresaExistenciasCostos(Border borderResaltar) {
		this.resaltarid_empresaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarid_empresaExistenciasCostos() {
		return this.mostrarid_empresaExistenciasCostos;
	}

	public void setMostrarid_empresaExistenciasCostos(Boolean mostrarid_empresaExistenciasCostos) {
		this.mostrarid_empresaExistenciasCostos= mostrarid_empresaExistenciasCostos;
	}

	public Boolean getActivarid_empresaExistenciasCostos() {
		return this.activarid_empresaExistenciasCostos;
	}

	public void setActivarid_empresaExistenciasCostos(Boolean activarid_empresaExistenciasCostos) {
		this.activarid_empresaExistenciasCostos= activarid_empresaExistenciasCostos;
	}

	public Boolean getCargarid_empresaExistenciasCostos() {
		return this.cargarid_empresaExistenciasCostos;
	}

	public void setCargarid_empresaExistenciasCostos(Boolean cargarid_empresaExistenciasCostos) {
		this.cargarid_empresaExistenciasCostos= cargarid_empresaExistenciasCostos;
	}

	public Border setResaltarid_lineaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarid_lineaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaExistenciasCostos() {
		return this.resaltarid_lineaExistenciasCostos;
	}

	public void setResaltarid_lineaExistenciasCostos(Border borderResaltar) {
		this.resaltarid_lineaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarid_lineaExistenciasCostos() {
		return this.mostrarid_lineaExistenciasCostos;
	}

	public void setMostrarid_lineaExistenciasCostos(Boolean mostrarid_lineaExistenciasCostos) {
		this.mostrarid_lineaExistenciasCostos= mostrarid_lineaExistenciasCostos;
	}

	public Boolean getActivarid_lineaExistenciasCostos() {
		return this.activarid_lineaExistenciasCostos;
	}

	public void setActivarid_lineaExistenciasCostos(Boolean activarid_lineaExistenciasCostos) {
		this.activarid_lineaExistenciasCostos= activarid_lineaExistenciasCostos;
	}

	public Boolean getCargarid_lineaExistenciasCostos() {
		return this.cargarid_lineaExistenciasCostos;
	}

	public void setCargarid_lineaExistenciasCostos(Boolean cargarid_lineaExistenciasCostos) {
		this.cargarid_lineaExistenciasCostos= cargarid_lineaExistenciasCostos;
	}

	public Border setResaltarid_linea_grupoExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoExistenciasCostos() {
		return this.resaltarid_linea_grupoExistenciasCostos;
	}

	public void setResaltarid_linea_grupoExistenciasCostos(Border borderResaltar) {
		this.resaltarid_linea_grupoExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoExistenciasCostos() {
		return this.mostrarid_linea_grupoExistenciasCostos;
	}

	public void setMostrarid_linea_grupoExistenciasCostos(Boolean mostrarid_linea_grupoExistenciasCostos) {
		this.mostrarid_linea_grupoExistenciasCostos= mostrarid_linea_grupoExistenciasCostos;
	}

	public Boolean getActivarid_linea_grupoExistenciasCostos() {
		return this.activarid_linea_grupoExistenciasCostos;
	}

	public void setActivarid_linea_grupoExistenciasCostos(Boolean activarid_linea_grupoExistenciasCostos) {
		this.activarid_linea_grupoExistenciasCostos= activarid_linea_grupoExistenciasCostos;
	}

	public Boolean getCargarid_linea_grupoExistenciasCostos() {
		return this.cargarid_linea_grupoExistenciasCostos;
	}

	public void setCargarid_linea_grupoExistenciasCostos(Boolean cargarid_linea_grupoExistenciasCostos) {
		this.cargarid_linea_grupoExistenciasCostos= cargarid_linea_grupoExistenciasCostos;
	}

	public Border setResaltarid_linea_categoriaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaExistenciasCostos() {
		return this.resaltarid_linea_categoriaExistenciasCostos;
	}

	public void setResaltarid_linea_categoriaExistenciasCostos(Border borderResaltar) {
		this.resaltarid_linea_categoriaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaExistenciasCostos() {
		return this.mostrarid_linea_categoriaExistenciasCostos;
	}

	public void setMostrarid_linea_categoriaExistenciasCostos(Boolean mostrarid_linea_categoriaExistenciasCostos) {
		this.mostrarid_linea_categoriaExistenciasCostos= mostrarid_linea_categoriaExistenciasCostos;
	}

	public Boolean getActivarid_linea_categoriaExistenciasCostos() {
		return this.activarid_linea_categoriaExistenciasCostos;
	}

	public void setActivarid_linea_categoriaExistenciasCostos(Boolean activarid_linea_categoriaExistenciasCostos) {
		this.activarid_linea_categoriaExistenciasCostos= activarid_linea_categoriaExistenciasCostos;
	}

	public Boolean getCargarid_linea_categoriaExistenciasCostos() {
		return this.cargarid_linea_categoriaExistenciasCostos;
	}

	public void setCargarid_linea_categoriaExistenciasCostos(Boolean cargarid_linea_categoriaExistenciasCostos) {
		this.cargarid_linea_categoriaExistenciasCostos= cargarid_linea_categoriaExistenciasCostos;
	}

	public Border setResaltarid_linea_marcaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaExistenciasCostos() {
		return this.resaltarid_linea_marcaExistenciasCostos;
	}

	public void setResaltarid_linea_marcaExistenciasCostos(Border borderResaltar) {
		this.resaltarid_linea_marcaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaExistenciasCostos() {
		return this.mostrarid_linea_marcaExistenciasCostos;
	}

	public void setMostrarid_linea_marcaExistenciasCostos(Boolean mostrarid_linea_marcaExistenciasCostos) {
		this.mostrarid_linea_marcaExistenciasCostos= mostrarid_linea_marcaExistenciasCostos;
	}

	public Boolean getActivarid_linea_marcaExistenciasCostos() {
		return this.activarid_linea_marcaExistenciasCostos;
	}

	public void setActivarid_linea_marcaExistenciasCostos(Boolean activarid_linea_marcaExistenciasCostos) {
		this.activarid_linea_marcaExistenciasCostos= activarid_linea_marcaExistenciasCostos;
	}

	public Boolean getCargarid_linea_marcaExistenciasCostos() {
		return this.cargarid_linea_marcaExistenciasCostos;
	}

	public void setCargarid_linea_marcaExistenciasCostos(Boolean cargarid_linea_marcaExistenciasCostos) {
		this.cargarid_linea_marcaExistenciasCostos= cargarid_linea_marcaExistenciasCostos;
	}

	public Border setResaltarfecha_emision_hastaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaExistenciasCostos() {
		return this.resaltarfecha_emision_hastaExistenciasCostos;
	}

	public void setResaltarfecha_emision_hastaExistenciasCostos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaExistenciasCostos() {
		return this.mostrarfecha_emision_hastaExistenciasCostos;
	}

	public void setMostrarfecha_emision_hastaExistenciasCostos(Boolean mostrarfecha_emision_hastaExistenciasCostos) {
		this.mostrarfecha_emision_hastaExistenciasCostos= mostrarfecha_emision_hastaExistenciasCostos;
	}

	public Boolean getActivarfecha_emision_hastaExistenciasCostos() {
		return this.activarfecha_emision_hastaExistenciasCostos;
	}

	public void setActivarfecha_emision_hastaExistenciasCostos(Boolean activarfecha_emision_hastaExistenciasCostos) {
		this.activarfecha_emision_hastaExistenciasCostos= activarfecha_emision_hastaExistenciasCostos;
	}

	public Border setResaltarnombre_productoExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoExistenciasCostos() {
		return this.resaltarnombre_productoExistenciasCostos;
	}

	public void setResaltarnombre_productoExistenciasCostos(Border borderResaltar) {
		this.resaltarnombre_productoExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoExistenciasCostos() {
		return this.mostrarnombre_productoExistenciasCostos;
	}

	public void setMostrarnombre_productoExistenciasCostos(Boolean mostrarnombre_productoExistenciasCostos) {
		this.mostrarnombre_productoExistenciasCostos= mostrarnombre_productoExistenciasCostos;
	}

	public Boolean getActivarnombre_productoExistenciasCostos() {
		return this.activarnombre_productoExistenciasCostos;
	}

	public void setActivarnombre_productoExistenciasCostos(Boolean activarnombre_productoExistenciasCostos) {
		this.activarnombre_productoExistenciasCostos= activarnombre_productoExistenciasCostos;
	}

	public Border setResaltarnombre_unidadExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadExistenciasCostos() {
		return this.resaltarnombre_unidadExistenciasCostos;
	}

	public void setResaltarnombre_unidadExistenciasCostos(Border borderResaltar) {
		this.resaltarnombre_unidadExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadExistenciasCostos() {
		return this.mostrarnombre_unidadExistenciasCostos;
	}

	public void setMostrarnombre_unidadExistenciasCostos(Boolean mostrarnombre_unidadExistenciasCostos) {
		this.mostrarnombre_unidadExistenciasCostos= mostrarnombre_unidadExistenciasCostos;
	}

	public Boolean getActivarnombre_unidadExistenciasCostos() {
		return this.activarnombre_unidadExistenciasCostos;
	}

	public void setActivarnombre_unidadExistenciasCostos(Boolean activarnombre_unidadExistenciasCostos) {
		this.activarnombre_unidadExistenciasCostos= activarnombre_unidadExistenciasCostos;
	}

	public Border setResaltarnombre_lineaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaExistenciasCostos() {
		return this.resaltarnombre_lineaExistenciasCostos;
	}

	public void setResaltarnombre_lineaExistenciasCostos(Border borderResaltar) {
		this.resaltarnombre_lineaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaExistenciasCostos() {
		return this.mostrarnombre_lineaExistenciasCostos;
	}

	public void setMostrarnombre_lineaExistenciasCostos(Boolean mostrarnombre_lineaExistenciasCostos) {
		this.mostrarnombre_lineaExistenciasCostos= mostrarnombre_lineaExistenciasCostos;
	}

	public Boolean getActivarnombre_lineaExistenciasCostos() {
		return this.activarnombre_lineaExistenciasCostos;
	}

	public void setActivarnombre_lineaExistenciasCostos(Boolean activarnombre_lineaExistenciasCostos) {
		this.activarnombre_lineaExistenciasCostos= activarnombre_lineaExistenciasCostos;
	}

	public Border setResaltarnombre_linea_grupoExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoExistenciasCostos() {
		return this.resaltarnombre_linea_grupoExistenciasCostos;
	}

	public void setResaltarnombre_linea_grupoExistenciasCostos(Border borderResaltar) {
		this.resaltarnombre_linea_grupoExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoExistenciasCostos() {
		return this.mostrarnombre_linea_grupoExistenciasCostos;
	}

	public void setMostrarnombre_linea_grupoExistenciasCostos(Boolean mostrarnombre_linea_grupoExistenciasCostos) {
		this.mostrarnombre_linea_grupoExistenciasCostos= mostrarnombre_linea_grupoExistenciasCostos;
	}

	public Boolean getActivarnombre_linea_grupoExistenciasCostos() {
		return this.activarnombre_linea_grupoExistenciasCostos;
	}

	public void setActivarnombre_linea_grupoExistenciasCostos(Boolean activarnombre_linea_grupoExistenciasCostos) {
		this.activarnombre_linea_grupoExistenciasCostos= activarnombre_linea_grupoExistenciasCostos;
	}

	public Border setResaltarnombre_linea_categoriaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaExistenciasCostos() {
		return this.resaltarnombre_linea_categoriaExistenciasCostos;
	}

	public void setResaltarnombre_linea_categoriaExistenciasCostos(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaExistenciasCostos() {
		return this.mostrarnombre_linea_categoriaExistenciasCostos;
	}

	public void setMostrarnombre_linea_categoriaExistenciasCostos(Boolean mostrarnombre_linea_categoriaExistenciasCostos) {
		this.mostrarnombre_linea_categoriaExistenciasCostos= mostrarnombre_linea_categoriaExistenciasCostos;
	}

	public Boolean getActivarnombre_linea_categoriaExistenciasCostos() {
		return this.activarnombre_linea_categoriaExistenciasCostos;
	}

	public void setActivarnombre_linea_categoriaExistenciasCostos(Boolean activarnombre_linea_categoriaExistenciasCostos) {
		this.activarnombre_linea_categoriaExistenciasCostos= activarnombre_linea_categoriaExistenciasCostos;
	}

	public Border setResaltarnombre_linea_marcaExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaExistenciasCostos() {
		return this.resaltarnombre_linea_marcaExistenciasCostos;
	}

	public void setResaltarnombre_linea_marcaExistenciasCostos(Border borderResaltar) {
		this.resaltarnombre_linea_marcaExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaExistenciasCostos() {
		return this.mostrarnombre_linea_marcaExistenciasCostos;
	}

	public void setMostrarnombre_linea_marcaExistenciasCostos(Boolean mostrarnombre_linea_marcaExistenciasCostos) {
		this.mostrarnombre_linea_marcaExistenciasCostos= mostrarnombre_linea_marcaExistenciasCostos;
	}

	public Boolean getActivarnombre_linea_marcaExistenciasCostos() {
		return this.activarnombre_linea_marcaExistenciasCostos;
	}

	public void setActivarnombre_linea_marcaExistenciasCostos(Boolean activarnombre_linea_marcaExistenciasCostos) {
		this.activarnombre_linea_marcaExistenciasCostos= activarnombre_linea_marcaExistenciasCostos;
	}

	public Border setResaltarcodigoExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarcodigoExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoExistenciasCostos() {
		return this.resaltarcodigoExistenciasCostos;
	}

	public void setResaltarcodigoExistenciasCostos(Border borderResaltar) {
		this.resaltarcodigoExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarcodigoExistenciasCostos() {
		return this.mostrarcodigoExistenciasCostos;
	}

	public void setMostrarcodigoExistenciasCostos(Boolean mostrarcodigoExistenciasCostos) {
		this.mostrarcodigoExistenciasCostos= mostrarcodigoExistenciasCostos;
	}

	public Boolean getActivarcodigoExistenciasCostos() {
		return this.activarcodigoExistenciasCostos;
	}

	public void setActivarcodigoExistenciasCostos(Boolean activarcodigoExistenciasCostos) {
		this.activarcodigoExistenciasCostos= activarcodigoExistenciasCostos;
	}

	public Border setResaltarcosto_totalExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//existenciascostosBeanSwingJInternalFrame.jTtoolBarExistenciasCostos.setBorder(borderResaltar);
		
		this.resaltarcosto_totalExistenciasCostos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalExistenciasCostos() {
		return this.resaltarcosto_totalExistenciasCostos;
	}

	public void setResaltarcosto_totalExistenciasCostos(Border borderResaltar) {
		this.resaltarcosto_totalExistenciasCostos= borderResaltar;
	}

	public Boolean getMostrarcosto_totalExistenciasCostos() {
		return this.mostrarcosto_totalExistenciasCostos;
	}

	public void setMostrarcosto_totalExistenciasCostos(Boolean mostrarcosto_totalExistenciasCostos) {
		this.mostrarcosto_totalExistenciasCostos= mostrarcosto_totalExistenciasCostos;
	}

	public Boolean getActivarcosto_totalExistenciasCostos() {
		return this.activarcosto_totalExistenciasCostos;
	}

	public void setActivarcosto_totalExistenciasCostos(Boolean activarcosto_totalExistenciasCostos) {
		this.activarcosto_totalExistenciasCostos= activarcosto_totalExistenciasCostos;
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
		
		
		this.setMostraridExistenciasCostos(esInicial);
		this.setMostrarid_empresaExistenciasCostos(esInicial);
		this.setMostrarid_lineaExistenciasCostos(esInicial);
		this.setMostrarid_linea_grupoExistenciasCostos(esInicial);
		this.setMostrarid_linea_categoriaExistenciasCostos(esInicial);
		this.setMostrarid_linea_marcaExistenciasCostos(esInicial);
		this.setMostrarfecha_emision_hastaExistenciasCostos(esInicial);
		this.setMostrarnombre_productoExistenciasCostos(esInicial);
		this.setMostrarnombre_unidadExistenciasCostos(esInicial);
		this.setMostrarnombre_lineaExistenciasCostos(esInicial);
		this.setMostrarnombre_linea_grupoExistenciasCostos(esInicial);
		this.setMostrarnombre_linea_categoriaExistenciasCostos(esInicial);
		this.setMostrarnombre_linea_marcaExistenciasCostos(esInicial);
		this.setMostrarcodigoExistenciasCostos(esInicial);
		this.setMostrarcosto_totalExistenciasCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.ID)) {
				this.setMostraridExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalExistenciasCostos(esAsigna);
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
		
		
		this.setActivaridExistenciasCostos(esInicial);
		this.setActivarid_empresaExistenciasCostos(esInicial);
		this.setActivarid_lineaExistenciasCostos(esInicial);
		this.setActivarid_linea_grupoExistenciasCostos(esInicial);
		this.setActivarid_linea_categoriaExistenciasCostos(esInicial);
		this.setActivarid_linea_marcaExistenciasCostos(esInicial);
		this.setActivarfecha_emision_hastaExistenciasCostos(esInicial);
		this.setActivarnombre_productoExistenciasCostos(esInicial);
		this.setActivarnombre_unidadExistenciasCostos(esInicial);
		this.setActivarnombre_lineaExistenciasCostos(esInicial);
		this.setActivarnombre_linea_grupoExistenciasCostos(esInicial);
		this.setActivarnombre_linea_categoriaExistenciasCostos(esInicial);
		this.setActivarnombre_linea_marcaExistenciasCostos(esInicial);
		this.setActivarcodigoExistenciasCostos(esInicial);
		this.setActivarcosto_totalExistenciasCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.ID)) {
				this.setActivaridExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalExistenciasCostos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridExistenciasCostos(esInicial);
		this.setResaltarid_empresaExistenciasCostos(esInicial);
		this.setResaltarid_lineaExistenciasCostos(esInicial);
		this.setResaltarid_linea_grupoExistenciasCostos(esInicial);
		this.setResaltarid_linea_categoriaExistenciasCostos(esInicial);
		this.setResaltarid_linea_marcaExistenciasCostos(esInicial);
		this.setResaltarfecha_emision_hastaExistenciasCostos(esInicial);
		this.setResaltarnombre_productoExistenciasCostos(esInicial);
		this.setResaltarnombre_unidadExistenciasCostos(esInicial);
		this.setResaltarnombre_lineaExistenciasCostos(esInicial);
		this.setResaltarnombre_linea_grupoExistenciasCostos(esInicial);
		this.setResaltarnombre_linea_categoriaExistenciasCostos(esInicial);
		this.setResaltarnombre_linea_marcaExistenciasCostos(esInicial);
		this.setResaltarcodigoExistenciasCostos(esInicial);
		this.setResaltarcosto_totalExistenciasCostos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.ID)) {
				this.setResaltaridExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoExistenciasCostos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ExistenciasCostosConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalExistenciasCostos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaExistenciasCostosExistenciasCostos=true;

	public Boolean getMostrarBusquedaExistenciasCostosExistenciasCostos() {
		return this.mostrarBusquedaExistenciasCostosExistenciasCostos;
	}

	public void setMostrarBusquedaExistenciasCostosExistenciasCostos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaExistenciasCostosExistenciasCostos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaExistenciasCostosExistenciasCostos=true;

	public Boolean getActivarBusquedaExistenciasCostosExistenciasCostos() {
		return this.activarBusquedaExistenciasCostosExistenciasCostos;
	}

	public void setActivarBusquedaExistenciasCostosExistenciasCostos(Boolean habilitarResaltar) {
		this.activarBusquedaExistenciasCostosExistenciasCostos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaExistenciasCostosExistenciasCostos=null;

	public Border getResaltarBusquedaExistenciasCostosExistenciasCostos() {
		return this.resaltarBusquedaExistenciasCostosExistenciasCostos;
	}

	public void setResaltarBusquedaExistenciasCostosExistenciasCostos(Border borderResaltar) {
		this.resaltarBusquedaExistenciasCostosExistenciasCostos= borderResaltar;
	}

	public void setResaltarBusquedaExistenciasCostosExistenciasCostos(ParametroGeneralUsuario parametroGeneralUsuario/*ExistenciasCostosBeanSwingJInternalFrame existenciascostosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaExistenciasCostosExistenciasCostos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}