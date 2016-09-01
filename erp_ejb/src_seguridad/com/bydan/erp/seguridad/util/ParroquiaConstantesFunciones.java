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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.ParroquiaConstantesFunciones;
import com.bydan.erp.seguridad.util.ParroquiaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParroquiaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParroquiaConstantesFunciones extends ParroquiaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Parroquia";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Parroquia"+ParroquiaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParroquiaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParroquiaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParroquiaConstantesFunciones.SCHEMA+"_"+ParroquiaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParroquiaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParroquiaConstantesFunciones.SCHEMA+"_"+ParroquiaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParroquiaConstantesFunciones.SCHEMA+"_"+ParroquiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParroquiaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParroquiaConstantesFunciones.SCHEMA+"_"+ParroquiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParroquiaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParroquiaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParroquiaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParroquiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParroquiaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParroquiaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParroquiaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParroquiaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParroquiaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParroquiaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parroquias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parroquia";
	public static final String SCLASSWEBTITULO_LOWER="Parroquia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Parroquia";
	public static final String OBJECTNAME="parroquia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="parroquia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parroquia from "+ParroquiaConstantesFunciones.SPERSISTENCENAME+" parroquia";
	public static String QUERYSELECTNATIVE="select "+ParroquiaConstantesFunciones.SCHEMA+"."+ParroquiaConstantesFunciones.TABLENAME+".id,"+ParroquiaConstantesFunciones.SCHEMA+"."+ParroquiaConstantesFunciones.TABLENAME+".version_row,"+ParroquiaConstantesFunciones.SCHEMA+"."+ParroquiaConstantesFunciones.TABLENAME+".id_canton,"+ParroquiaConstantesFunciones.SCHEMA+"."+ParroquiaConstantesFunciones.TABLENAME+".codigo,"+ParroquiaConstantesFunciones.SCHEMA+"."+ParroquiaConstantesFunciones.TABLENAME+".nombre,"+ParroquiaConstantesFunciones.SCHEMA+"."+ParroquiaConstantesFunciones.TABLENAME+".es_activo from "+ParroquiaConstantesFunciones.SCHEMA+"."+ParroquiaConstantesFunciones.TABLENAME;//+" as "+ParroquiaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParroquiaConstantesFuncionesAdditional parroquiaConstantesFuncionesAdditional=null;
	
	public ParroquiaConstantesFuncionesAdditional getParroquiaConstantesFuncionesAdditional() {
		return this.parroquiaConstantesFuncionesAdditional;
	}
	
	public void setParroquiaConstantesFuncionesAdditional(ParroquiaConstantesFuncionesAdditional parroquiaConstantesFuncionesAdditional) {
		try {
			this.parroquiaConstantesFuncionesAdditional=parroquiaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCANTON= "id_canton";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESACTIVO= "es_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCANTON= "Canton";
		public static final String LABEL_IDCANTON_LOWER= "Canton";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getParroquiaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParroquiaConstantesFunciones.IDCANTON)) {sLabelColumna=ParroquiaConstantesFunciones.LABEL_IDCANTON;}
		if(sNombreColumna.equals(ParroquiaConstantesFunciones.CODIGO)) {sLabelColumna=ParroquiaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ParroquiaConstantesFunciones.NOMBRE)) {sLabelColumna=ParroquiaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ParroquiaConstantesFunciones.ESACTIVO)) {sLabelColumna=ParroquiaConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_activoDescripcion(Parroquia parroquia) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parroquia.getes_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_activoHtmlDescripcion(Parroquia parroquia) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parroquia.getId(),parroquia.getes_activo());

		return sDescripcion;
	}	
	
	public static String getParroquiaDescripcion(Parroquia parroquia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parroquia !=null/* && parroquia.getId()!=0*/) {
			sDescripcion=parroquia.getcodigo();//parroquiaparroquia.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getParroquiaDescripcionDetallado(Parroquia parroquia) {
		String sDescripcion="";
			
		sDescripcion+=ParroquiaConstantesFunciones.ID+"=";
		sDescripcion+=parroquia.getId().toString()+",";
		sDescripcion+=ParroquiaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parroquia.getVersionRow().toString()+",";
		sDescripcion+=ParroquiaConstantesFunciones.IDCANTON+"=";
		sDescripcion+=parroquia.getid_canton().toString()+",";
		sDescripcion+=ParroquiaConstantesFunciones.CODIGO+"=";
		sDescripcion+=parroquia.getcodigo()+",";
		sDescripcion+=ParroquiaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=parroquia.getnombre()+",";
		sDescripcion+=ParroquiaConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=parroquia.getes_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParroquiaDescripcion(Parroquia parroquia,String sValor) throws Exception {			
		if(parroquia !=null) {
			parroquia.setcodigo(sValor);;//parroquiaparroquia.getcodigo().trim();
		}		
	}
	
		

	public static String getCantonDescripcion(Canton canton) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(canton!=null/*&&canton.getId()>0*/) {
			sDescripcion=CantonConstantesFunciones.getCantonDescripcion(canton);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCanton")) {
			sNombreIndice="Tipo=  Por Canton";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCanton(Long id_canton) {
		String sDetalleIndice=" Parametros->";
		if(id_canton!=null) {sDetalleIndice+=" Codigo Unico De Canton="+id_canton.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParroquia(Parroquia parroquia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parroquia.setcodigo(parroquia.getcodigo().trim());
		parroquia.setnombre(parroquia.getnombre().trim());
	}
	
	public static void quitarEspaciosParroquias(List<Parroquia> parroquias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Parroquia parroquia: parroquias) {
			parroquia.setcodigo(parroquia.getcodigo().trim());
			parroquia.setnombre(parroquia.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParroquia(Parroquia parroquia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parroquia.getConCambioAuxiliar()) {
			parroquia.setIsDeleted(parroquia.getIsDeletedAuxiliar());	
			parroquia.setIsNew(parroquia.getIsNewAuxiliar());	
			parroquia.setIsChanged(parroquia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parroquia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parroquia.setIsDeletedAuxiliar(false);	
			parroquia.setIsNewAuxiliar(false);	
			parroquia.setIsChangedAuxiliar(false);
			
			parroquia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParroquias(List<Parroquia> parroquias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Parroquia parroquia : parroquias) {
			if(conAsignarBase && parroquia.getConCambioAuxiliar()) {
				parroquia.setIsDeleted(parroquia.getIsDeletedAuxiliar());	
				parroquia.setIsNew(parroquia.getIsNewAuxiliar());	
				parroquia.setIsChanged(parroquia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parroquia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parroquia.setIsDeletedAuxiliar(false);	
				parroquia.setIsNewAuxiliar(false);	
				parroquia.setIsChangedAuxiliar(false);
				
				parroquia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParroquia(Parroquia parroquia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParroquias(List<Parroquia> parroquias,Boolean conEnteros) throws Exception  {
		
		for(Parroquia parroquia: parroquias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParroquia(List<Parroquia> parroquias,Parroquia parroquiaAux) throws Exception  {
		ParroquiaConstantesFunciones.InicializarValoresParroquia(parroquiaAux,true);
		
		for(Parroquia parroquia: parroquias) {
			if(parroquia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParroquia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParroquiaConstantesFunciones.getArrayColumnasGlobalesParroquia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParroquia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParroquia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Parroquia> parroquias,Parroquia parroquia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Parroquia parroquiaAux: parroquias) {
			if(parroquiaAux!=null && parroquia!=null) {
				if((parroquiaAux.getId()==null && parroquia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parroquiaAux.getId()!=null && parroquia.getId()!=null){
					if(parroquiaAux.getId().equals(parroquia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParroquia(List<Parroquia> parroquias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Parroquia parroquia: parroquias) {			
			if(parroquia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParroquia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParroquiaConstantesFunciones.LABEL_ID, ParroquiaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParroquiaConstantesFunciones.LABEL_VERSIONROW, ParroquiaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParroquiaConstantesFunciones.LABEL_IDCANTON, ParroquiaConstantesFunciones.IDCANTON,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParroquiaConstantesFunciones.LABEL_CODIGO, ParroquiaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParroquiaConstantesFunciones.LABEL_NOMBRE, ParroquiaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParroquiaConstantesFunciones.LABEL_ESACTIVO, ParroquiaConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParroquia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParroquiaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParroquiaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParroquiaConstantesFunciones.IDCANTON;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParroquiaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParroquiaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParroquiaConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParroquia() throws Exception  {
		return ParroquiaConstantesFunciones.getTiposSeleccionarParroquia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParroquia(Boolean conFk) throws Exception  {
		return ParroquiaConstantesFunciones.getTiposSeleccionarParroquia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParroquia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParroquiaConstantesFunciones.LABEL_IDCANTON);
			reporte.setsDescripcion(ParroquiaConstantesFunciones.LABEL_IDCANTON);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParroquiaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ParroquiaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParroquiaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ParroquiaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParroquiaConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(ParroquiaConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParroquia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParroquia(Parroquia parroquiaAux) throws Exception {
		
			parroquiaAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(parroquiaAux.getCanton()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParroquia(List<Parroquia> parroquiasTemp) throws Exception {
		for(Parroquia parroquiaAux:parroquiasTemp) {
			
			parroquiaAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(parroquiaAux.getCanton()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParroquia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Canton.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Canton.class)) {
						classes.add(new Classe(Canton.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParroquia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParroquia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParroquiaConstantesFunciones.getClassesRelationshipsOfParroquia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParroquia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParroquia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParroquiaConstantesFunciones.getClassesRelationshipsFromStringsOfParroquia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParroquia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Parroquia parroquia,List<Parroquia> parroquias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Parroquia parroquiaEncontrado=null;
			
			for(Parroquia parroquiaLocal:parroquias) {
				if(parroquiaLocal.getId().equals(parroquia.getId())) {
					parroquiaEncontrado=parroquiaLocal;
					
					parroquiaLocal.setIsChanged(parroquia.getIsChanged());
					parroquiaLocal.setIsNew(parroquia.getIsNew());
					parroquiaLocal.setIsDeleted(parroquia.getIsDeleted());
					
					parroquiaLocal.setGeneralEntityOriginal(parroquia.getGeneralEntityOriginal());
					
					parroquiaLocal.setId(parroquia.getId());	
					parroquiaLocal.setVersionRow(parroquia.getVersionRow());	
					parroquiaLocal.setid_canton(parroquia.getid_canton());	
					parroquiaLocal.setcodigo(parroquia.getcodigo());	
					parroquiaLocal.setnombre(parroquia.getnombre());	
					parroquiaLocal.setes_activo(parroquia.getes_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parroquia.getIsDeleted()) {
				if(!existe) {
					parroquias.add(parroquia);
				}
			} else {
				if(parroquiaEncontrado!=null && permiteQuitar)  {
					parroquias.remove(parroquiaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Parroquia parroquia,List<Parroquia> parroquias) throws Exception {
		try	{			
			for(Parroquia parroquiaLocal:parroquias) {
				if(parroquiaLocal.getId().equals(parroquia.getId())) {
					parroquiaLocal.setIsSelected(parroquia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParroquia(List<Parroquia> parroquiasAux) throws Exception {
		//this.parroquiasAux=parroquiasAux;
		
		for(Parroquia parroquiaAux:parroquiasAux) {
			if(parroquiaAux.getIsChanged()) {
				parroquiaAux.setIsChanged(false);
			}		
			
			if(parroquiaAux.getIsNew()) {
				parroquiaAux.setIsNew(false);
			}	
			
			if(parroquiaAux.getIsDeleted()) {
				parroquiaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParroquia(Parroquia parroquiaAux) throws Exception {
		//this.parroquiaAux=parroquiaAux;
		
			if(parroquiaAux.getIsChanged()) {
				parroquiaAux.setIsChanged(false);
			}		
			
			if(parroquiaAux.getIsNew()) {
				parroquiaAux.setIsNew(false);
			}	
			
			if(parroquiaAux.getIsDeleted()) {
				parroquiaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Parroquia parroquiaAsignar,Parroquia parroquia) throws Exception {
		parroquiaAsignar.setId(parroquia.getId());	
		parroquiaAsignar.setVersionRow(parroquia.getVersionRow());	
		parroquiaAsignar.setid_canton(parroquia.getid_canton());
		parroquiaAsignar.setcanton_descripcion(parroquia.getcanton_descripcion());	
		parroquiaAsignar.setcodigo(parroquia.getcodigo());	
		parroquiaAsignar.setnombre(parroquia.getnombre());	
		parroquiaAsignar.setes_activo(parroquia.getes_activo());	
	}
	
	public static void inicializarParroquia(Parroquia parroquia) throws Exception {
		try {
				parroquia.setId(0L);	
					
				parroquia.setid_canton(-1L);	
				parroquia.setcodigo("");	
				parroquia.setnombre("");	
				parroquia.setes_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParroquia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParroquiaConstantesFunciones.LABEL_IDCANTON);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParroquiaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParroquiaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParroquiaConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParroquia(String sTipo,Row row,Workbook workbook,Parroquia parroquia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parroquia.getcanton_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parroquia.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parroquia.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parroquia.getes_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParroquia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParroquia() {
		return this.sFinalQueryParroquia;
	}
	
	public void setsFinalQueryParroquia(String sFinalQueryParroquia) {
		this.sFinalQueryParroquia= sFinalQueryParroquia;
	}
	
	public Border resaltarSeleccionarParroquia=null;
	
	public Border setResaltarSeleccionarParroquia(ParametroGeneralUsuario parametroGeneralUsuario/*ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parroquiaBeanSwingJInternalFrame.jTtoolBarParroquia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParroquia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParroquia() {
		return this.resaltarSeleccionarParroquia;
	}
	
	public void setResaltarSeleccionarParroquia(Border borderResaltarSeleccionarParroquia) {
		this.resaltarSeleccionarParroquia= borderResaltarSeleccionarParroquia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParroquia=null;
	public Boolean mostraridParroquia=true;
	public Boolean activaridParroquia=true;

	public Border resaltarid_cantonParroquia=null;
	public Boolean mostrarid_cantonParroquia=true;
	public Boolean activarid_cantonParroquia=true;
	public Boolean cargarid_cantonParroquia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cantonParroquia=false;//ConEventDepend=true

	public Border resaltarcodigoParroquia=null;
	public Boolean mostrarcodigoParroquia=true;
	public Boolean activarcodigoParroquia=true;

	public Border resaltarnombreParroquia=null;
	public Boolean mostrarnombreParroquia=true;
	public Boolean activarnombreParroquia=true;

	public Border resaltares_activoParroquia=null;
	public Boolean mostrares_activoParroquia=true;
	public Boolean activares_activoParroquia=true;

	
	

	public Border setResaltaridParroquia(ParametroGeneralUsuario parametroGeneralUsuario/*ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parroquiaBeanSwingJInternalFrame.jTtoolBarParroquia.setBorder(borderResaltar);
		
		this.resaltaridParroquia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParroquia() {
		return this.resaltaridParroquia;
	}

	public void setResaltaridParroquia(Border borderResaltar) {
		this.resaltaridParroquia= borderResaltar;
	}

	public Boolean getMostraridParroquia() {
		return this.mostraridParroquia;
	}

	public void setMostraridParroquia(Boolean mostraridParroquia) {
		this.mostraridParroquia= mostraridParroquia;
	}

	public Boolean getActivaridParroquia() {
		return this.activaridParroquia;
	}

	public void setActivaridParroquia(Boolean activaridParroquia) {
		this.activaridParroquia= activaridParroquia;
	}

	public Border setResaltarid_cantonParroquia(ParametroGeneralUsuario parametroGeneralUsuario/*ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parroquiaBeanSwingJInternalFrame.jTtoolBarParroquia.setBorder(borderResaltar);
		
		this.resaltarid_cantonParroquia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cantonParroquia() {
		return this.resaltarid_cantonParroquia;
	}

	public void setResaltarid_cantonParroquia(Border borderResaltar) {
		this.resaltarid_cantonParroquia= borderResaltar;
	}

	public Boolean getMostrarid_cantonParroquia() {
		return this.mostrarid_cantonParroquia;
	}

	public void setMostrarid_cantonParroquia(Boolean mostrarid_cantonParroquia) {
		this.mostrarid_cantonParroquia= mostrarid_cantonParroquia;
	}

	public Boolean getActivarid_cantonParroquia() {
		return this.activarid_cantonParroquia;
	}

	public void setActivarid_cantonParroquia(Boolean activarid_cantonParroquia) {
		this.activarid_cantonParroquia= activarid_cantonParroquia;
	}

	public Boolean getCargarid_cantonParroquia() {
		return this.cargarid_cantonParroquia;
	}

	public void setCargarid_cantonParroquia(Boolean cargarid_cantonParroquia) {
		this.cargarid_cantonParroquia= cargarid_cantonParroquia;
	}

	public Border setResaltarcodigoParroquia(ParametroGeneralUsuario parametroGeneralUsuario/*ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parroquiaBeanSwingJInternalFrame.jTtoolBarParroquia.setBorder(borderResaltar);
		
		this.resaltarcodigoParroquia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoParroquia() {
		return this.resaltarcodigoParroquia;
	}

	public void setResaltarcodigoParroquia(Border borderResaltar) {
		this.resaltarcodigoParroquia= borderResaltar;
	}

	public Boolean getMostrarcodigoParroquia() {
		return this.mostrarcodigoParroquia;
	}

	public void setMostrarcodigoParroquia(Boolean mostrarcodigoParroquia) {
		this.mostrarcodigoParroquia= mostrarcodigoParroquia;
	}

	public Boolean getActivarcodigoParroquia() {
		return this.activarcodigoParroquia;
	}

	public void setActivarcodigoParroquia(Boolean activarcodigoParroquia) {
		this.activarcodigoParroquia= activarcodigoParroquia;
	}

	public Border setResaltarnombreParroquia(ParametroGeneralUsuario parametroGeneralUsuario/*ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parroquiaBeanSwingJInternalFrame.jTtoolBarParroquia.setBorder(borderResaltar);
		
		this.resaltarnombreParroquia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreParroquia() {
		return this.resaltarnombreParroquia;
	}

	public void setResaltarnombreParroquia(Border borderResaltar) {
		this.resaltarnombreParroquia= borderResaltar;
	}

	public Boolean getMostrarnombreParroquia() {
		return this.mostrarnombreParroquia;
	}

	public void setMostrarnombreParroquia(Boolean mostrarnombreParroquia) {
		this.mostrarnombreParroquia= mostrarnombreParroquia;
	}

	public Boolean getActivarnombreParroquia() {
		return this.activarnombreParroquia;
	}

	public void setActivarnombreParroquia(Boolean activarnombreParroquia) {
		this.activarnombreParroquia= activarnombreParroquia;
	}

	public Border setResaltares_activoParroquia(ParametroGeneralUsuario parametroGeneralUsuario/*ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parroquiaBeanSwingJInternalFrame.jTtoolBarParroquia.setBorder(borderResaltar);
		
		this.resaltares_activoParroquia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_activoParroquia() {
		return this.resaltares_activoParroquia;
	}

	public void setResaltares_activoParroquia(Border borderResaltar) {
		this.resaltares_activoParroquia= borderResaltar;
	}

	public Boolean getMostrares_activoParroquia() {
		return this.mostrares_activoParroquia;
	}

	public void setMostrares_activoParroquia(Boolean mostrares_activoParroquia) {
		this.mostrares_activoParroquia= mostrares_activoParroquia;
	}

	public Boolean getActivares_activoParroquia() {
		return this.activares_activoParroquia;
	}

	public void setActivares_activoParroquia(Boolean activares_activoParroquia) {
		this.activares_activoParroquia= activares_activoParroquia;
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
		
		
		this.setMostraridParroquia(esInicial);
		this.setMostrarid_cantonParroquia(esInicial);
		this.setMostrarcodigoParroquia(esInicial);
		this.setMostrarnombreParroquia(esInicial);
		this.setMostrares_activoParroquia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParroquiaConstantesFunciones.ID)) {
				this.setMostraridParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.IDCANTON)) {
				this.setMostrarid_cantonParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.ESACTIVO)) {
				this.setMostrares_activoParroquia(esAsigna);
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
		
		
		this.setActivaridParroquia(esInicial);
		this.setActivarid_cantonParroquia(esInicial);
		this.setActivarcodigoParroquia(esInicial);
		this.setActivarnombreParroquia(esInicial);
		this.setActivares_activoParroquia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParroquiaConstantesFunciones.ID)) {
				this.setActivaridParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.IDCANTON)) {
				this.setActivarid_cantonParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.ESACTIVO)) {
				this.setActivares_activoParroquia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParroquia(esInicial);
		this.setResaltarid_cantonParroquia(esInicial);
		this.setResaltarcodigoParroquia(esInicial);
		this.setResaltarnombreParroquia(esInicial);
		this.setResaltares_activoParroquia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParroquiaConstantesFunciones.ID)) {
				this.setResaltaridParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.IDCANTON)) {
				this.setResaltarid_cantonParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreParroquia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParroquiaConstantesFunciones.ESACTIVO)) {
				this.setResaltares_activoParroquia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCantonParroquia=true;

	public Boolean getMostrarFK_IdCantonParroquia() {
		return this.mostrarFK_IdCantonParroquia;
	}

	public void setMostrarFK_IdCantonParroquia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCantonParroquia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCantonParroquia=true;

	public Boolean getActivarFK_IdCantonParroquia() {
		return this.activarFK_IdCantonParroquia;
	}

	public void setActivarFK_IdCantonParroquia(Boolean habilitarResaltar) {
		this.activarFK_IdCantonParroquia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCantonParroquia=null;

	public Border getResaltarFK_IdCantonParroquia() {
		return this.resaltarFK_IdCantonParroquia;
	}

	public void setResaltarFK_IdCantonParroquia(Border borderResaltar) {
		this.resaltarFK_IdCantonParroquia= borderResaltar;
	}

	public void setResaltarFK_IdCantonParroquia(ParametroGeneralUsuario parametroGeneralUsuario/*ParroquiaBeanSwingJInternalFrame parroquiaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCantonParroquia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}