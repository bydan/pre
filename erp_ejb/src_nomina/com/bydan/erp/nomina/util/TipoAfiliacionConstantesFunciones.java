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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoAfiliacionConstantesFunciones;
import com.bydan.erp.nomina.util.TipoAfiliacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoAfiliacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoAfiliacionConstantesFunciones extends TipoAfiliacionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoAfiliacion";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoAfiliacion"+TipoAfiliacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoAfiliacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoAfiliacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoAfiliacionConstantesFunciones.SCHEMA+"_"+TipoAfiliacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoAfiliacionConstantesFunciones.SCHEMA+"_"+TipoAfiliacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoAfiliacionConstantesFunciones.SCHEMA+"_"+TipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoAfiliacionConstantesFunciones.SCHEMA+"_"+TipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAfiliacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAfiliacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoAfiliacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoAfiliacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoAfiliacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoAfiliacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Afiliaciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Afiliacion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Afiliacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoAfiliacion";
	public static final String OBJECTNAME="tipoafiliacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_afiliacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoafiliacion from "+TipoAfiliacionConstantesFunciones.SPERSISTENCENAME+" tipoafiliacion";
	public static String QUERYSELECTNATIVE="select "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".id,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".version_row,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".id_empresa,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".id_cate_tipo_afiliacion,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".codigo,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".nombre,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_emplea,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_patro,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_gene_emplea,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_gene_patro,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_secu,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_iece,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".descripcion from "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME;//+" as "+TipoAfiliacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoAfiliacionConstantesFuncionesAdditional tipoafiliacionConstantesFuncionesAdditional=null;
	
	public TipoAfiliacionConstantesFuncionesAdditional getTipoAfiliacionConstantesFuncionesAdditional() {
		return this.tipoafiliacionConstantesFuncionesAdditional;
	}
	
	public void setTipoAfiliacionConstantesFuncionesAdditional(TipoAfiliacionConstantesFuncionesAdditional tipoafiliacionConstantesFuncionesAdditional) {
		try {
			this.tipoafiliacionConstantesFuncionesAdditional=tipoafiliacionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCATETIPOAFILIACION= "id_cate_tipo_afiliacion";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String PORCENEMPLEA= "porcen_emplea";
    public static final String PORCENPATRO= "porcen_patro";
    public static final String PORCENGENEEMPLEA= "porcen_gene_emplea";
    public static final String PORCENGENEPATRO= "porcen_gene_patro";
    public static final String PORCENSECU= "porcen_secu";
    public static final String PORCENIECE= "porcen_iece";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCATETIPOAFILIACION= "Cate Tipo Afiliacion";
		public static final String LABEL_IDCATETIPOAFILIACION_LOWER= "Cate Tipo Afiliacion";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_PORCENEMPLEA= "Porcen Emplea";
		public static final String LABEL_PORCENEMPLEA_LOWER= "Porcen Emplea";
    	public static final String LABEL_PORCENPATRO= "Porcen Patro";
		public static final String LABEL_PORCENPATRO_LOWER= "Porcen Patro";
    	public static final String LABEL_PORCENGENEEMPLEA= "Porcen Gene Emplea";
		public static final String LABEL_PORCENGENEEMPLEA_LOWER= "Porcen Gene Emplea";
    	public static final String LABEL_PORCENGENEPATRO= "Porcen Gene Patro";
		public static final String LABEL_PORCENGENEPATRO_LOWER= "Porcen Gene Patro";
    	public static final String LABEL_PORCENSECU= "Porcen Secu";
		public static final String LABEL_PORCENSECU_LOWER= "Porcen Secu";
    	public static final String LABEL_PORCENIECE= "Porcen Iece";
		public static final String LABEL_PORCENIECE_LOWER= "Porcen Iece";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoAfiliacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_IDCATETIPOAFILIACION;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.CODIGO)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.PORCENEMPLEA)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_PORCENEMPLEA;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.PORCENPATRO)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_PORCENPATRO;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEEMPLEA;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.PORCENGENEPATRO)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEPATRO;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.PORCENSECU)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_PORCENSECU;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.PORCENIECE)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_PORCENIECE;}
		if(sNombreColumna.equals(TipoAfiliacionConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoAfiliacionConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTipoAfiliacionDescripcion(TipoAfiliacion tipoafiliacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoafiliacion !=null/* && tipoafiliacion.getId()!=0*/) {
			sDescripcion=tipoafiliacion.getnombre();//tipoafiliaciontipoafiliacion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoAfiliacionDescripcionDetallado(TipoAfiliacion tipoafiliacion) {
		String sDescripcion="";
			
		sDescripcion+=TipoAfiliacionConstantesFunciones.ID+"=";
		sDescripcion+=tipoafiliacion.getId().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoafiliacion.getVersionRow().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoafiliacion.getid_empresa().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION+"=";
		sDescripcion+=tipoafiliacion.getid_cate_tipo_afiliacion().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoafiliacion.getcodigo()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoafiliacion.getnombre()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.PORCENEMPLEA+"=";
		sDescripcion+=tipoafiliacion.getporcen_emplea().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.PORCENPATRO+"=";
		sDescripcion+=tipoafiliacion.getporcen_patro().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA+"=";
		sDescripcion+=tipoafiliacion.getporcen_gene_emplea().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.PORCENGENEPATRO+"=";
		sDescripcion+=tipoafiliacion.getporcen_gene_patro().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.PORCENSECU+"=";
		sDescripcion+=tipoafiliacion.getporcen_secu().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.PORCENIECE+"=";
		sDescripcion+=tipoafiliacion.getporcen_iece().toString()+",";
		sDescripcion+=TipoAfiliacionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoafiliacion.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoAfiliacionDescripcion(TipoAfiliacion tipoafiliacion,String sValor) throws Exception {			
		if(tipoafiliacion !=null) {
			tipoafiliacion.setnombre(sValor);;//tipoafiliaciontipoafiliacion.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCateTipoAfiliacionDescripcion(CateTipoAfiliacion catetipoafiliacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(catetipoafiliacion!=null/*&&catetipoafiliacion.getId()>0*/) {
			sDescripcion=CateTipoAfiliacionConstantesFunciones.getCateTipoAfiliacionDescripcion(catetipoafiliacion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCateTipoAfiliacion")) {
			sNombreIndice="Tipo=  Por Cate Tipo Afiliacion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCateTipoAfiliacion(Long id_cate_tipo_afiliacion) {
		String sDetalleIndice=" Parametros->";
		if(id_cate_tipo_afiliacion!=null) {sDetalleIndice+=" Codigo Unico De Cate Tipo Afiliacion="+id_cate_tipo_afiliacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoAfiliacion(TipoAfiliacion tipoafiliacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoafiliacion.setcodigo(tipoafiliacion.getcodigo().trim());
		tipoafiliacion.setnombre(tipoafiliacion.getnombre().trim());
		tipoafiliacion.setdescripcion(tipoafiliacion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoAfiliacions(List<TipoAfiliacion> tipoafiliacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoAfiliacion tipoafiliacion: tipoafiliacions) {
			tipoafiliacion.setcodigo(tipoafiliacion.getcodigo().trim());
			tipoafiliacion.setnombre(tipoafiliacion.getnombre().trim());
			tipoafiliacion.setdescripcion(tipoafiliacion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAfiliacion(TipoAfiliacion tipoafiliacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoafiliacion.getConCambioAuxiliar()) {
			tipoafiliacion.setIsDeleted(tipoafiliacion.getIsDeletedAuxiliar());	
			tipoafiliacion.setIsNew(tipoafiliacion.getIsNewAuxiliar());	
			tipoafiliacion.setIsChanged(tipoafiliacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoafiliacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoafiliacion.setIsDeletedAuxiliar(false);	
			tipoafiliacion.setIsNewAuxiliar(false);	
			tipoafiliacion.setIsChangedAuxiliar(false);
			
			tipoafiliacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAfiliacions(List<TipoAfiliacion> tipoafiliacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoAfiliacion tipoafiliacion : tipoafiliacions) {
			if(conAsignarBase && tipoafiliacion.getConCambioAuxiliar()) {
				tipoafiliacion.setIsDeleted(tipoafiliacion.getIsDeletedAuxiliar());	
				tipoafiliacion.setIsNew(tipoafiliacion.getIsNewAuxiliar());	
				tipoafiliacion.setIsChanged(tipoafiliacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoafiliacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoafiliacion.setIsDeletedAuxiliar(false);	
				tipoafiliacion.setIsNewAuxiliar(false);	
				tipoafiliacion.setIsChangedAuxiliar(false);
				
				tipoafiliacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoAfiliacion(TipoAfiliacion tipoafiliacion,Boolean conEnteros) throws Exception  {
		tipoafiliacion.setporcen_emplea(0.0);
		tipoafiliacion.setporcen_patro(0.0);
		tipoafiliacion.setporcen_gene_emplea(0.0);
		tipoafiliacion.setporcen_gene_patro(0.0);
		tipoafiliacion.setporcen_secu(0.0);
		tipoafiliacion.setporcen_iece(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoAfiliacions(List<TipoAfiliacion> tipoafiliacions,Boolean conEnteros) throws Exception  {
		
		for(TipoAfiliacion tipoafiliacion: tipoafiliacions) {
			tipoafiliacion.setporcen_emplea(0.0);
			tipoafiliacion.setporcen_patro(0.0);
			tipoafiliacion.setporcen_gene_emplea(0.0);
			tipoafiliacion.setporcen_gene_patro(0.0);
			tipoafiliacion.setporcen_secu(0.0);
			tipoafiliacion.setporcen_iece(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoAfiliacion(List<TipoAfiliacion> tipoafiliacions,TipoAfiliacion tipoafiliacionAux) throws Exception  {
		TipoAfiliacionConstantesFunciones.InicializarValoresTipoAfiliacion(tipoafiliacionAux,true);
		
		for(TipoAfiliacion tipoafiliacion: tipoafiliacions) {
			if(tipoafiliacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tipoafiliacionAux.setporcen_emplea(tipoafiliacionAux.getporcen_emplea()+tipoafiliacion.getporcen_emplea());			
			tipoafiliacionAux.setporcen_patro(tipoafiliacionAux.getporcen_patro()+tipoafiliacion.getporcen_patro());			
			tipoafiliacionAux.setporcen_gene_emplea(tipoafiliacionAux.getporcen_gene_emplea()+tipoafiliacion.getporcen_gene_emplea());			
			tipoafiliacionAux.setporcen_gene_patro(tipoafiliacionAux.getporcen_gene_patro()+tipoafiliacion.getporcen_gene_patro());			
			tipoafiliacionAux.setporcen_secu(tipoafiliacionAux.getporcen_secu()+tipoafiliacion.getporcen_secu());			
			tipoafiliacionAux.setporcen_iece(tipoafiliacionAux.getporcen_iece()+tipoafiliacion.getporcen_iece());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAfiliacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoAfiliacionConstantesFunciones.getArrayColumnasGlobalesTipoAfiliacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAfiliacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoAfiliacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoAfiliacionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoAfiliacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoAfiliacion> tipoafiliacions,TipoAfiliacion tipoafiliacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoAfiliacion tipoafiliacionAux: tipoafiliacions) {
			if(tipoafiliacionAux!=null && tipoafiliacion!=null) {
				if((tipoafiliacionAux.getId()==null && tipoafiliacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoafiliacionAux.getId()!=null && tipoafiliacion.getId()!=null){
					if(tipoafiliacionAux.getId().equals(tipoafiliacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoAfiliacion(List<TipoAfiliacion> tipoafiliacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcen_empleaTotal=0.0;
		Double porcen_patroTotal=0.0;
		Double porcen_gene_empleaTotal=0.0;
		Double porcen_gene_patroTotal=0.0;
		Double porcen_secuTotal=0.0;
		Double porcen_ieceTotal=0.0;
	
		for(TipoAfiliacion tipoafiliacion: tipoafiliacions) {			
			if(tipoafiliacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcen_empleaTotal+=tipoafiliacion.getporcen_emplea();
			porcen_patroTotal+=tipoafiliacion.getporcen_patro();
			porcen_gene_empleaTotal+=tipoafiliacion.getporcen_gene_emplea();
			porcen_gene_patroTotal+=tipoafiliacion.getporcen_gene_patro();
			porcen_secuTotal+=tipoafiliacion.getporcen_secu();
			porcen_ieceTotal+=tipoafiliacion.getporcen_iece();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoAfiliacionConstantesFunciones.PORCENEMPLEA);
		datoGeneral.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENEMPLEA);
		datoGeneral.setdValorDouble(porcen_empleaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoAfiliacionConstantesFunciones.PORCENPATRO);
		datoGeneral.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENPATRO);
		datoGeneral.setdValorDouble(porcen_patroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA);
		datoGeneral.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEEMPLEA);
		datoGeneral.setdValorDouble(porcen_gene_empleaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoAfiliacionConstantesFunciones.PORCENGENEPATRO);
		datoGeneral.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEPATRO);
		datoGeneral.setdValorDouble(porcen_gene_patroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoAfiliacionConstantesFunciones.PORCENSECU);
		datoGeneral.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENSECU);
		datoGeneral.setdValorDouble(porcen_secuTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoAfiliacionConstantesFunciones.PORCENIECE);
		datoGeneral.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENIECE);
		datoGeneral.setdValorDouble(porcen_ieceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoAfiliacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_ID, TipoAfiliacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_VERSIONROW, TipoAfiliacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_IDEMPRESA, TipoAfiliacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_IDCATETIPOAFILIACION, TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_CODIGO, TipoAfiliacionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_NOMBRE, TipoAfiliacionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_PORCENEMPLEA, TipoAfiliacionConstantesFunciones.PORCENEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_PORCENPATRO, TipoAfiliacionConstantesFunciones.PORCENPATRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEEMPLEA, TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEPATRO, TipoAfiliacionConstantesFunciones.PORCENGENEPATRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_PORCENSECU, TipoAfiliacionConstantesFunciones.PORCENSECU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_PORCENIECE, TipoAfiliacionConstantesFunciones.PORCENIECE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAfiliacionConstantesFunciones.LABEL_DESCRIPCION, TipoAfiliacionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoAfiliacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.PORCENEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.PORCENPATRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.PORCENGENEPATRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.PORCENSECU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.PORCENIECE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAfiliacionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAfiliacion() throws Exception  {
		return TipoAfiliacionConstantesFunciones.getTiposSeleccionarTipoAfiliacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAfiliacion(Boolean conFk) throws Exception  {
		return TipoAfiliacionConstantesFunciones.getTiposSeleccionarTipoAfiliacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAfiliacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_IDCATETIPOAFILIACION);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_IDCATETIPOAFILIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_PORCENEMPLEA);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_PORCENPATRO);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENPATRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEEMPLEA);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEPATRO);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEPATRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_PORCENSECU);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENSECU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_PORCENIECE);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_PORCENIECE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAfiliacionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoAfiliacionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoAfiliacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAfiliacion(TipoAfiliacion tipoafiliacionAux) throws Exception {
		
			tipoafiliacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoafiliacionAux.getEmpresa()));
			tipoafiliacionAux.setcatetipoafiliacion_descripcion(CateTipoAfiliacionConstantesFunciones.getCateTipoAfiliacionDescripcion(tipoafiliacionAux.getCateTipoAfiliacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAfiliacion(List<TipoAfiliacion> tipoafiliacionsTemp) throws Exception {
		for(TipoAfiliacion tipoafiliacionAux:tipoafiliacionsTemp) {
			
			tipoafiliacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoafiliacionAux.getEmpresa()));
			tipoafiliacionAux.setcatetipoafiliacion_descripcion(CateTipoAfiliacionConstantesFunciones.getCateTipoAfiliacionDescripcion(tipoafiliacionAux.getCateTipoAfiliacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CateTipoAfiliacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CateTipoAfiliacion.class)) {
						classes.add(new Classe(CateTipoAfiliacion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoAfiliacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CateTipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CateTipoAfiliacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CateTipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CateTipoAfiliacion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAfiliacionConstantesFunciones.getClassesRelationshipsOfTipoAfiliacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAfiliacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DatoGeneralEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAfiliacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAfiliacionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoAfiliacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAfiliacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoAfiliacion tipoafiliacion,List<TipoAfiliacion> tipoafiliacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoAfiliacion tipoafiliacionEncontrado=null;
			
			for(TipoAfiliacion tipoafiliacionLocal:tipoafiliacions) {
				if(tipoafiliacionLocal.getId().equals(tipoafiliacion.getId())) {
					tipoafiliacionEncontrado=tipoafiliacionLocal;
					
					tipoafiliacionLocal.setIsChanged(tipoafiliacion.getIsChanged());
					tipoafiliacionLocal.setIsNew(tipoafiliacion.getIsNew());
					tipoafiliacionLocal.setIsDeleted(tipoafiliacion.getIsDeleted());
					
					tipoafiliacionLocal.setGeneralEntityOriginal(tipoafiliacion.getGeneralEntityOriginal());
					
					tipoafiliacionLocal.setId(tipoafiliacion.getId());	
					tipoafiliacionLocal.setVersionRow(tipoafiliacion.getVersionRow());	
					tipoafiliacionLocal.setid_empresa(tipoafiliacion.getid_empresa());	
					tipoafiliacionLocal.setid_cate_tipo_afiliacion(tipoafiliacion.getid_cate_tipo_afiliacion());	
					tipoafiliacionLocal.setcodigo(tipoafiliacion.getcodigo());	
					tipoafiliacionLocal.setnombre(tipoafiliacion.getnombre());	
					tipoafiliacionLocal.setporcen_emplea(tipoafiliacion.getporcen_emplea());	
					tipoafiliacionLocal.setporcen_patro(tipoafiliacion.getporcen_patro());	
					tipoafiliacionLocal.setporcen_gene_emplea(tipoafiliacion.getporcen_gene_emplea());	
					tipoafiliacionLocal.setporcen_gene_patro(tipoafiliacion.getporcen_gene_patro());	
					tipoafiliacionLocal.setporcen_secu(tipoafiliacion.getporcen_secu());	
					tipoafiliacionLocal.setporcen_iece(tipoafiliacion.getporcen_iece());	
					tipoafiliacionLocal.setdescripcion(tipoafiliacion.getdescripcion());	
					
					
					tipoafiliacionLocal.setDatoGeneralEmpleados(tipoafiliacion.getDatoGeneralEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoafiliacion.getIsDeleted()) {
				if(!existe) {
					tipoafiliacions.add(tipoafiliacion);
				}
			} else {
				if(tipoafiliacionEncontrado!=null && permiteQuitar)  {
					tipoafiliacions.remove(tipoafiliacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoAfiliacion tipoafiliacion,List<TipoAfiliacion> tipoafiliacions) throws Exception {
		try	{			
			for(TipoAfiliacion tipoafiliacionLocal:tipoafiliacions) {
				if(tipoafiliacionLocal.getId().equals(tipoafiliacion.getId())) {
					tipoafiliacionLocal.setIsSelected(tipoafiliacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoAfiliacion(List<TipoAfiliacion> tipoafiliacionsAux) throws Exception {
		//this.tipoafiliacionsAux=tipoafiliacionsAux;
		
		for(TipoAfiliacion tipoafiliacionAux:tipoafiliacionsAux) {
			if(tipoafiliacionAux.getIsChanged()) {
				tipoafiliacionAux.setIsChanged(false);
			}		
			
			if(tipoafiliacionAux.getIsNew()) {
				tipoafiliacionAux.setIsNew(false);
			}	
			
			if(tipoafiliacionAux.getIsDeleted()) {
				tipoafiliacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoAfiliacion(TipoAfiliacion tipoafiliacionAux) throws Exception {
		//this.tipoafiliacionAux=tipoafiliacionAux;
		
			if(tipoafiliacionAux.getIsChanged()) {
				tipoafiliacionAux.setIsChanged(false);
			}		
			
			if(tipoafiliacionAux.getIsNew()) {
				tipoafiliacionAux.setIsNew(false);
			}	
			
			if(tipoafiliacionAux.getIsDeleted()) {
				tipoafiliacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoAfiliacion tipoafiliacionAsignar,TipoAfiliacion tipoafiliacion) throws Exception {
		tipoafiliacionAsignar.setId(tipoafiliacion.getId());	
		tipoafiliacionAsignar.setVersionRow(tipoafiliacion.getVersionRow());	
		tipoafiliacionAsignar.setid_empresa(tipoafiliacion.getid_empresa());
		tipoafiliacionAsignar.setempresa_descripcion(tipoafiliacion.getempresa_descripcion());	
		tipoafiliacionAsignar.setid_cate_tipo_afiliacion(tipoafiliacion.getid_cate_tipo_afiliacion());
		tipoafiliacionAsignar.setcatetipoafiliacion_descripcion(tipoafiliacion.getcatetipoafiliacion_descripcion());	
		tipoafiliacionAsignar.setcodigo(tipoafiliacion.getcodigo());	
		tipoafiliacionAsignar.setnombre(tipoafiliacion.getnombre());	
		tipoafiliacionAsignar.setporcen_emplea(tipoafiliacion.getporcen_emplea());	
		tipoafiliacionAsignar.setporcen_patro(tipoafiliacion.getporcen_patro());	
		tipoafiliacionAsignar.setporcen_gene_emplea(tipoafiliacion.getporcen_gene_emplea());	
		tipoafiliacionAsignar.setporcen_gene_patro(tipoafiliacion.getporcen_gene_patro());	
		tipoafiliacionAsignar.setporcen_secu(tipoafiliacion.getporcen_secu());	
		tipoafiliacionAsignar.setporcen_iece(tipoafiliacion.getporcen_iece());	
		tipoafiliacionAsignar.setdescripcion(tipoafiliacion.getdescripcion());	
	}
	
	public static void inicializarTipoAfiliacion(TipoAfiliacion tipoafiliacion) throws Exception {
		try {
				tipoafiliacion.setId(0L);	
					
				tipoafiliacion.setid_empresa(-1L);	
				tipoafiliacion.setid_cate_tipo_afiliacion(-1L);	
				tipoafiliacion.setcodigo("");	
				tipoafiliacion.setnombre("");	
				tipoafiliacion.setporcen_emplea(0.0);	
				tipoafiliacion.setporcen_patro(0.0);	
				tipoafiliacion.setporcen_gene_emplea(0.0);	
				tipoafiliacion.setporcen_gene_patro(0.0);	
				tipoafiliacion.setporcen_secu(0.0);	
				tipoafiliacion.setporcen_iece(0.0);	
				tipoafiliacion.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoAfiliacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_IDCATETIPOAFILIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_PORCENEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_PORCENPATRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_PORCENGENEPATRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_PORCENSECU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_PORCENIECE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAfiliacionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoAfiliacion(String sTipo,Row row,Workbook workbook,TipoAfiliacion tipoafiliacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getcatetipoafiliacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getporcen_emplea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getporcen_patro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getporcen_gene_emplea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getporcen_gene_patro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getporcen_secu());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getporcen_iece());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoafiliacion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoAfiliacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoAfiliacion() {
		return this.sFinalQueryTipoAfiliacion;
	}
	
	public void setsFinalQueryTipoAfiliacion(String sFinalQueryTipoAfiliacion) {
		this.sFinalQueryTipoAfiliacion= sFinalQueryTipoAfiliacion;
	}
	
	public Border resaltarSeleccionarTipoAfiliacion=null;
	
	public Border setResaltarSeleccionarTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoAfiliacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoAfiliacion() {
		return this.resaltarSeleccionarTipoAfiliacion;
	}
	
	public void setResaltarSeleccionarTipoAfiliacion(Border borderResaltarSeleccionarTipoAfiliacion) {
		this.resaltarSeleccionarTipoAfiliacion= borderResaltarSeleccionarTipoAfiliacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoAfiliacion=null;
	public Boolean mostraridTipoAfiliacion=true;
	public Boolean activaridTipoAfiliacion=true;

	public Border resaltarid_empresaTipoAfiliacion=null;
	public Boolean mostrarid_empresaTipoAfiliacion=true;
	public Boolean activarid_empresaTipoAfiliacion=true;
	public Boolean cargarid_empresaTipoAfiliacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoAfiliacion=false;//ConEventDepend=true

	public Border resaltarid_cate_tipo_afiliacionTipoAfiliacion=null;
	public Boolean mostrarid_cate_tipo_afiliacionTipoAfiliacion=true;
	public Boolean activarid_cate_tipo_afiliacionTipoAfiliacion=true;
	public Boolean cargarid_cate_tipo_afiliacionTipoAfiliacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cate_tipo_afiliacionTipoAfiliacion=false;//ConEventDepend=true

	public Border resaltarcodigoTipoAfiliacion=null;
	public Boolean mostrarcodigoTipoAfiliacion=true;
	public Boolean activarcodigoTipoAfiliacion=true;

	public Border resaltarnombreTipoAfiliacion=null;
	public Boolean mostrarnombreTipoAfiliacion=true;
	public Boolean activarnombreTipoAfiliacion=true;

	public Border resaltarporcen_empleaTipoAfiliacion=null;
	public Boolean mostrarporcen_empleaTipoAfiliacion=true;
	public Boolean activarporcen_empleaTipoAfiliacion=true;

	public Border resaltarporcen_patroTipoAfiliacion=null;
	public Boolean mostrarporcen_patroTipoAfiliacion=true;
	public Boolean activarporcen_patroTipoAfiliacion=true;

	public Border resaltarporcen_gene_empleaTipoAfiliacion=null;
	public Boolean mostrarporcen_gene_empleaTipoAfiliacion=true;
	public Boolean activarporcen_gene_empleaTipoAfiliacion=true;

	public Border resaltarporcen_gene_patroTipoAfiliacion=null;
	public Boolean mostrarporcen_gene_patroTipoAfiliacion=true;
	public Boolean activarporcen_gene_patroTipoAfiliacion=true;

	public Border resaltarporcen_secuTipoAfiliacion=null;
	public Boolean mostrarporcen_secuTipoAfiliacion=true;
	public Boolean activarporcen_secuTipoAfiliacion=true;

	public Border resaltarporcen_ieceTipoAfiliacion=null;
	public Boolean mostrarporcen_ieceTipoAfiliacion=true;
	public Boolean activarporcen_ieceTipoAfiliacion=true;

	public Border resaltardescripcionTipoAfiliacion=null;
	public Boolean mostrardescripcionTipoAfiliacion=true;
	public Boolean activardescripcionTipoAfiliacion=true;

	
	

	public Border setResaltaridTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltaridTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoAfiliacion() {
		return this.resaltaridTipoAfiliacion;
	}

	public void setResaltaridTipoAfiliacion(Border borderResaltar) {
		this.resaltaridTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostraridTipoAfiliacion() {
		return this.mostraridTipoAfiliacion;
	}

	public void setMostraridTipoAfiliacion(Boolean mostraridTipoAfiliacion) {
		this.mostraridTipoAfiliacion= mostraridTipoAfiliacion;
	}

	public Boolean getActivaridTipoAfiliacion() {
		return this.activaridTipoAfiliacion;
	}

	public void setActivaridTipoAfiliacion(Boolean activaridTipoAfiliacion) {
		this.activaridTipoAfiliacion= activaridTipoAfiliacion;
	}

	public Border setResaltarid_empresaTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoAfiliacion() {
		return this.resaltarid_empresaTipoAfiliacion;
	}

	public void setResaltarid_empresaTipoAfiliacion(Border borderResaltar) {
		this.resaltarid_empresaTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoAfiliacion() {
		return this.mostrarid_empresaTipoAfiliacion;
	}

	public void setMostrarid_empresaTipoAfiliacion(Boolean mostrarid_empresaTipoAfiliacion) {
		this.mostrarid_empresaTipoAfiliacion= mostrarid_empresaTipoAfiliacion;
	}

	public Boolean getActivarid_empresaTipoAfiliacion() {
		return this.activarid_empresaTipoAfiliacion;
	}

	public void setActivarid_empresaTipoAfiliacion(Boolean activarid_empresaTipoAfiliacion) {
		this.activarid_empresaTipoAfiliacion= activarid_empresaTipoAfiliacion;
	}

	public Boolean getCargarid_empresaTipoAfiliacion() {
		return this.cargarid_empresaTipoAfiliacion;
	}

	public void setCargarid_empresaTipoAfiliacion(Boolean cargarid_empresaTipoAfiliacion) {
		this.cargarid_empresaTipoAfiliacion= cargarid_empresaTipoAfiliacion;
	}

	public Border setResaltarid_cate_tipo_afiliacionTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarid_cate_tipo_afiliacionTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cate_tipo_afiliacionTipoAfiliacion() {
		return this.resaltarid_cate_tipo_afiliacionTipoAfiliacion;
	}

	public void setResaltarid_cate_tipo_afiliacionTipoAfiliacion(Border borderResaltar) {
		this.resaltarid_cate_tipo_afiliacionTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarid_cate_tipo_afiliacionTipoAfiliacion() {
		return this.mostrarid_cate_tipo_afiliacionTipoAfiliacion;
	}

	public void setMostrarid_cate_tipo_afiliacionTipoAfiliacion(Boolean mostrarid_cate_tipo_afiliacionTipoAfiliacion) {
		this.mostrarid_cate_tipo_afiliacionTipoAfiliacion= mostrarid_cate_tipo_afiliacionTipoAfiliacion;
	}

	public Boolean getActivarid_cate_tipo_afiliacionTipoAfiliacion() {
		return this.activarid_cate_tipo_afiliacionTipoAfiliacion;
	}

	public void setActivarid_cate_tipo_afiliacionTipoAfiliacion(Boolean activarid_cate_tipo_afiliacionTipoAfiliacion) {
		this.activarid_cate_tipo_afiliacionTipoAfiliacion= activarid_cate_tipo_afiliacionTipoAfiliacion;
	}

	public Boolean getCargarid_cate_tipo_afiliacionTipoAfiliacion() {
		return this.cargarid_cate_tipo_afiliacionTipoAfiliacion;
	}

	public void setCargarid_cate_tipo_afiliacionTipoAfiliacion(Boolean cargarid_cate_tipo_afiliacionTipoAfiliacion) {
		this.cargarid_cate_tipo_afiliacionTipoAfiliacion= cargarid_cate_tipo_afiliacionTipoAfiliacion;
	}

	public Border setResaltarcodigoTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoAfiliacion() {
		return this.resaltarcodigoTipoAfiliacion;
	}

	public void setResaltarcodigoTipoAfiliacion(Border borderResaltar) {
		this.resaltarcodigoTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoAfiliacion() {
		return this.mostrarcodigoTipoAfiliacion;
	}

	public void setMostrarcodigoTipoAfiliacion(Boolean mostrarcodigoTipoAfiliacion) {
		this.mostrarcodigoTipoAfiliacion= mostrarcodigoTipoAfiliacion;
	}

	public Boolean getActivarcodigoTipoAfiliacion() {
		return this.activarcodigoTipoAfiliacion;
	}

	public void setActivarcodigoTipoAfiliacion(Boolean activarcodigoTipoAfiliacion) {
		this.activarcodigoTipoAfiliacion= activarcodigoTipoAfiliacion;
	}

	public Border setResaltarnombreTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoAfiliacion() {
		return this.resaltarnombreTipoAfiliacion;
	}

	public void setResaltarnombreTipoAfiliacion(Border borderResaltar) {
		this.resaltarnombreTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoAfiliacion() {
		return this.mostrarnombreTipoAfiliacion;
	}

	public void setMostrarnombreTipoAfiliacion(Boolean mostrarnombreTipoAfiliacion) {
		this.mostrarnombreTipoAfiliacion= mostrarnombreTipoAfiliacion;
	}

	public Boolean getActivarnombreTipoAfiliacion() {
		return this.activarnombreTipoAfiliacion;
	}

	public void setActivarnombreTipoAfiliacion(Boolean activarnombreTipoAfiliacion) {
		this.activarnombreTipoAfiliacion= activarnombreTipoAfiliacion;
	}

	public Border setResaltarporcen_empleaTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarporcen_empleaTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_empleaTipoAfiliacion() {
		return this.resaltarporcen_empleaTipoAfiliacion;
	}

	public void setResaltarporcen_empleaTipoAfiliacion(Border borderResaltar) {
		this.resaltarporcen_empleaTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarporcen_empleaTipoAfiliacion() {
		return this.mostrarporcen_empleaTipoAfiliacion;
	}

	public void setMostrarporcen_empleaTipoAfiliacion(Boolean mostrarporcen_empleaTipoAfiliacion) {
		this.mostrarporcen_empleaTipoAfiliacion= mostrarporcen_empleaTipoAfiliacion;
	}

	public Boolean getActivarporcen_empleaTipoAfiliacion() {
		return this.activarporcen_empleaTipoAfiliacion;
	}

	public void setActivarporcen_empleaTipoAfiliacion(Boolean activarporcen_empleaTipoAfiliacion) {
		this.activarporcen_empleaTipoAfiliacion= activarporcen_empleaTipoAfiliacion;
	}

	public Border setResaltarporcen_patroTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarporcen_patroTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_patroTipoAfiliacion() {
		return this.resaltarporcen_patroTipoAfiliacion;
	}

	public void setResaltarporcen_patroTipoAfiliacion(Border borderResaltar) {
		this.resaltarporcen_patroTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarporcen_patroTipoAfiliacion() {
		return this.mostrarporcen_patroTipoAfiliacion;
	}

	public void setMostrarporcen_patroTipoAfiliacion(Boolean mostrarporcen_patroTipoAfiliacion) {
		this.mostrarporcen_patroTipoAfiliacion= mostrarporcen_patroTipoAfiliacion;
	}

	public Boolean getActivarporcen_patroTipoAfiliacion() {
		return this.activarporcen_patroTipoAfiliacion;
	}

	public void setActivarporcen_patroTipoAfiliacion(Boolean activarporcen_patroTipoAfiliacion) {
		this.activarporcen_patroTipoAfiliacion= activarporcen_patroTipoAfiliacion;
	}

	public Border setResaltarporcen_gene_empleaTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarporcen_gene_empleaTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_gene_empleaTipoAfiliacion() {
		return this.resaltarporcen_gene_empleaTipoAfiliacion;
	}

	public void setResaltarporcen_gene_empleaTipoAfiliacion(Border borderResaltar) {
		this.resaltarporcen_gene_empleaTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarporcen_gene_empleaTipoAfiliacion() {
		return this.mostrarporcen_gene_empleaTipoAfiliacion;
	}

	public void setMostrarporcen_gene_empleaTipoAfiliacion(Boolean mostrarporcen_gene_empleaTipoAfiliacion) {
		this.mostrarporcen_gene_empleaTipoAfiliacion= mostrarporcen_gene_empleaTipoAfiliacion;
	}

	public Boolean getActivarporcen_gene_empleaTipoAfiliacion() {
		return this.activarporcen_gene_empleaTipoAfiliacion;
	}

	public void setActivarporcen_gene_empleaTipoAfiliacion(Boolean activarporcen_gene_empleaTipoAfiliacion) {
		this.activarporcen_gene_empleaTipoAfiliacion= activarporcen_gene_empleaTipoAfiliacion;
	}

	public Border setResaltarporcen_gene_patroTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarporcen_gene_patroTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_gene_patroTipoAfiliacion() {
		return this.resaltarporcen_gene_patroTipoAfiliacion;
	}

	public void setResaltarporcen_gene_patroTipoAfiliacion(Border borderResaltar) {
		this.resaltarporcen_gene_patroTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarporcen_gene_patroTipoAfiliacion() {
		return this.mostrarporcen_gene_patroTipoAfiliacion;
	}

	public void setMostrarporcen_gene_patroTipoAfiliacion(Boolean mostrarporcen_gene_patroTipoAfiliacion) {
		this.mostrarporcen_gene_patroTipoAfiliacion= mostrarporcen_gene_patroTipoAfiliacion;
	}

	public Boolean getActivarporcen_gene_patroTipoAfiliacion() {
		return this.activarporcen_gene_patroTipoAfiliacion;
	}

	public void setActivarporcen_gene_patroTipoAfiliacion(Boolean activarporcen_gene_patroTipoAfiliacion) {
		this.activarporcen_gene_patroTipoAfiliacion= activarporcen_gene_patroTipoAfiliacion;
	}

	public Border setResaltarporcen_secuTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarporcen_secuTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_secuTipoAfiliacion() {
		return this.resaltarporcen_secuTipoAfiliacion;
	}

	public void setResaltarporcen_secuTipoAfiliacion(Border borderResaltar) {
		this.resaltarporcen_secuTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarporcen_secuTipoAfiliacion() {
		return this.mostrarporcen_secuTipoAfiliacion;
	}

	public void setMostrarporcen_secuTipoAfiliacion(Boolean mostrarporcen_secuTipoAfiliacion) {
		this.mostrarporcen_secuTipoAfiliacion= mostrarporcen_secuTipoAfiliacion;
	}

	public Boolean getActivarporcen_secuTipoAfiliacion() {
		return this.activarporcen_secuTipoAfiliacion;
	}

	public void setActivarporcen_secuTipoAfiliacion(Boolean activarporcen_secuTipoAfiliacion) {
		this.activarporcen_secuTipoAfiliacion= activarporcen_secuTipoAfiliacion;
	}

	public Border setResaltarporcen_ieceTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltarporcen_ieceTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcen_ieceTipoAfiliacion() {
		return this.resaltarporcen_ieceTipoAfiliacion;
	}

	public void setResaltarporcen_ieceTipoAfiliacion(Border borderResaltar) {
		this.resaltarporcen_ieceTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrarporcen_ieceTipoAfiliacion() {
		return this.mostrarporcen_ieceTipoAfiliacion;
	}

	public void setMostrarporcen_ieceTipoAfiliacion(Boolean mostrarporcen_ieceTipoAfiliacion) {
		this.mostrarporcen_ieceTipoAfiliacion= mostrarporcen_ieceTipoAfiliacion;
	}

	public Boolean getActivarporcen_ieceTipoAfiliacion() {
		return this.activarporcen_ieceTipoAfiliacion;
	}

	public void setActivarporcen_ieceTipoAfiliacion(Boolean activarporcen_ieceTipoAfiliacion) {
		this.activarporcen_ieceTipoAfiliacion= activarporcen_ieceTipoAfiliacion;
	}

	public Border setResaltardescripcionTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoAfiliacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoAfiliacion() {
		return this.resaltardescripcionTipoAfiliacion;
	}

	public void setResaltardescripcionTipoAfiliacion(Border borderResaltar) {
		this.resaltardescripcionTipoAfiliacion= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoAfiliacion() {
		return this.mostrardescripcionTipoAfiliacion;
	}

	public void setMostrardescripcionTipoAfiliacion(Boolean mostrardescripcionTipoAfiliacion) {
		this.mostrardescripcionTipoAfiliacion= mostrardescripcionTipoAfiliacion;
	}

	public Boolean getActivardescripcionTipoAfiliacion() {
		return this.activardescripcionTipoAfiliacion;
	}

	public void setActivardescripcionTipoAfiliacion(Boolean activardescripcionTipoAfiliacion) {
		this.activardescripcionTipoAfiliacion= activardescripcionTipoAfiliacion;
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
		
		
		this.setMostraridTipoAfiliacion(esInicial);
		this.setMostrarid_empresaTipoAfiliacion(esInicial);
		this.setMostrarid_cate_tipo_afiliacionTipoAfiliacion(esInicial);
		this.setMostrarcodigoTipoAfiliacion(esInicial);
		this.setMostrarnombreTipoAfiliacion(esInicial);
		this.setMostrarporcen_empleaTipoAfiliacion(esInicial);
		this.setMostrarporcen_patroTipoAfiliacion(esInicial);
		this.setMostrarporcen_gene_empleaTipoAfiliacion(esInicial);
		this.setMostrarporcen_gene_patroTipoAfiliacion(esInicial);
		this.setMostrarporcen_secuTipoAfiliacion(esInicial);
		this.setMostrarporcen_ieceTipoAfiliacion(esInicial);
		this.setMostrardescripcionTipoAfiliacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.ID)) {
				this.setMostraridTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION)) {
				this.setMostrarid_cate_tipo_afiliacionTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENEMPLEA)) {
				this.setMostrarporcen_empleaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENPATRO)) {
				this.setMostrarporcen_patroTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA)) {
				this.setMostrarporcen_gene_empleaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENGENEPATRO)) {
				this.setMostrarporcen_gene_patroTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENSECU)) {
				this.setMostrarporcen_secuTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENIECE)) {
				this.setMostrarporcen_ieceTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoAfiliacion(esAsigna);
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
		
		
		this.setActivaridTipoAfiliacion(esInicial);
		this.setActivarid_empresaTipoAfiliacion(esInicial);
		this.setActivarid_cate_tipo_afiliacionTipoAfiliacion(esInicial);
		this.setActivarcodigoTipoAfiliacion(esInicial);
		this.setActivarnombreTipoAfiliacion(esInicial);
		this.setActivarporcen_empleaTipoAfiliacion(esInicial);
		this.setActivarporcen_patroTipoAfiliacion(esInicial);
		this.setActivarporcen_gene_empleaTipoAfiliacion(esInicial);
		this.setActivarporcen_gene_patroTipoAfiliacion(esInicial);
		this.setActivarporcen_secuTipoAfiliacion(esInicial);
		this.setActivarporcen_ieceTipoAfiliacion(esInicial);
		this.setActivardescripcionTipoAfiliacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.ID)) {
				this.setActivaridTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION)) {
				this.setActivarid_cate_tipo_afiliacionTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENEMPLEA)) {
				this.setActivarporcen_empleaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENPATRO)) {
				this.setActivarporcen_patroTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA)) {
				this.setActivarporcen_gene_empleaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENGENEPATRO)) {
				this.setActivarporcen_gene_patroTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENSECU)) {
				this.setActivarporcen_secuTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENIECE)) {
				this.setActivarporcen_ieceTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoAfiliacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoAfiliacion(esInicial);
		this.setResaltarid_empresaTipoAfiliacion(esInicial);
		this.setResaltarid_cate_tipo_afiliacionTipoAfiliacion(esInicial);
		this.setResaltarcodigoTipoAfiliacion(esInicial);
		this.setResaltarnombreTipoAfiliacion(esInicial);
		this.setResaltarporcen_empleaTipoAfiliacion(esInicial);
		this.setResaltarporcen_patroTipoAfiliacion(esInicial);
		this.setResaltarporcen_gene_empleaTipoAfiliacion(esInicial);
		this.setResaltarporcen_gene_patroTipoAfiliacion(esInicial);
		this.setResaltarporcen_secuTipoAfiliacion(esInicial);
		this.setResaltarporcen_ieceTipoAfiliacion(esInicial);
		this.setResaltardescripcionTipoAfiliacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.ID)) {
				this.setResaltaridTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION)) {
				this.setResaltarid_cate_tipo_afiliacionTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENEMPLEA)) {
				this.setResaltarporcen_empleaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENPATRO)) {
				this.setResaltarporcen_patroTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA)) {
				this.setResaltarporcen_gene_empleaTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENGENEPATRO)) {
				this.setResaltarporcen_gene_patroTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENSECU)) {
				this.setResaltarporcen_secuTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.PORCENIECE)) {
				this.setResaltarporcen_ieceTipoAfiliacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAfiliacionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoAfiliacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDatoGeneralEmpleadoTipoAfiliacion=null;

	public Border getResaltarDatoGeneralEmpleadoTipoAfiliacion() {
		return this.resaltarDatoGeneralEmpleadoTipoAfiliacion;
	}

	public void setResaltarDatoGeneralEmpleadoTipoAfiliacion(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoTipoAfiliacion= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoafiliacionBeanSwingJInternalFrame.jTtoolBarTipoAfiliacion.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoTipoAfiliacion= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoTipoAfiliacion=true;

	public Boolean getMostrarDatoGeneralEmpleadoTipoAfiliacion() {
		return this.mostrarDatoGeneralEmpleadoTipoAfiliacion;
	}

	public void setMostrarDatoGeneralEmpleadoTipoAfiliacion(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoTipoAfiliacion= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoTipoAfiliacion=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoTipoAfiliacion() {
		return this.activarDatoGeneralEmpleadoTipoAfiliacion;
	}

	public void setActivarDatoGeneralEmpleadoTipoAfiliacion(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoTipoAfiliacion= habilitarResaltarDatoGeneralEmpleado;
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

		this.setMostrarDatoGeneralEmpleadoTipoAfiliacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoTipoAfiliacion(esAsigna);
				continue;
			}
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

		this.setActivarDatoGeneralEmpleadoTipoAfiliacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoTipoAfiliacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDatoGeneralEmpleadoTipoAfiliacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoTipoAfiliacion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCateTipoAfiliacionTipoAfiliacion=true;

	public Boolean getMostrarFK_IdCateTipoAfiliacionTipoAfiliacion() {
		return this.mostrarFK_IdCateTipoAfiliacionTipoAfiliacion;
	}

	public void setMostrarFK_IdCateTipoAfiliacionTipoAfiliacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCateTipoAfiliacionTipoAfiliacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoAfiliacion=true;

	public Boolean getMostrarFK_IdEmpresaTipoAfiliacion() {
		return this.mostrarFK_IdEmpresaTipoAfiliacion;
	}

	public void setMostrarFK_IdEmpresaTipoAfiliacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoAfiliacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCateTipoAfiliacionTipoAfiliacion=true;

	public Boolean getActivarFK_IdCateTipoAfiliacionTipoAfiliacion() {
		return this.activarFK_IdCateTipoAfiliacionTipoAfiliacion;
	}

	public void setActivarFK_IdCateTipoAfiliacionTipoAfiliacion(Boolean habilitarResaltar) {
		this.activarFK_IdCateTipoAfiliacionTipoAfiliacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoAfiliacion=true;

	public Boolean getActivarFK_IdEmpresaTipoAfiliacion() {
		return this.activarFK_IdEmpresaTipoAfiliacion;
	}

	public void setActivarFK_IdEmpresaTipoAfiliacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoAfiliacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCateTipoAfiliacionTipoAfiliacion=null;

	public Border getResaltarFK_IdCateTipoAfiliacionTipoAfiliacion() {
		return this.resaltarFK_IdCateTipoAfiliacionTipoAfiliacion;
	}

	public void setResaltarFK_IdCateTipoAfiliacionTipoAfiliacion(Border borderResaltar) {
		this.resaltarFK_IdCateTipoAfiliacionTipoAfiliacion= borderResaltar;
	}

	public void setResaltarFK_IdCateTipoAfiliacionTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCateTipoAfiliacionTipoAfiliacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoAfiliacion=null;

	public Border getResaltarFK_IdEmpresaTipoAfiliacion() {
		return this.resaltarFK_IdEmpresaTipoAfiliacion;
	}

	public void setResaltarFK_IdEmpresaTipoAfiliacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoAfiliacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoAfiliacion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAfiliacionBeanSwingJInternalFrame tipoafiliacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoAfiliacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}