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


import com.bydan.erp.seguridad.util.CantonConstantesFunciones;
import com.bydan.erp.seguridad.util.CantonParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.CantonParameterGeneral;

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
final public class CantonConstantesFunciones extends CantonConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Canton";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Canton"+CantonConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CantonHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CantonHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CantonConstantesFunciones.SCHEMA+"_"+CantonConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CantonHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CantonConstantesFunciones.SCHEMA+"_"+CantonConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CantonConstantesFunciones.SCHEMA+"_"+CantonConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CantonHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CantonConstantesFunciones.SCHEMA+"_"+CantonConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CantonConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CantonHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CantonConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CantonConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CantonHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CantonConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CantonConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CantonConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CantonConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CantonConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cantones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Canton";
	public static final String SCLASSWEBTITULO_LOWER="Canton";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Canton";
	public static final String OBJECTNAME="canton";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="canton";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select canton from "+CantonConstantesFunciones.SPERSISTENCENAME+" canton";
	public static String QUERYSELECTNATIVE="select "+CantonConstantesFunciones.SCHEMA+"."+CantonConstantesFunciones.TABLENAME+".id,"+CantonConstantesFunciones.SCHEMA+"."+CantonConstantesFunciones.TABLENAME+".version_row,"+CantonConstantesFunciones.SCHEMA+"."+CantonConstantesFunciones.TABLENAME+".id_provincia,"+CantonConstantesFunciones.SCHEMA+"."+CantonConstantesFunciones.TABLENAME+".codigo,"+CantonConstantesFunciones.SCHEMA+"."+CantonConstantesFunciones.TABLENAME+".nombre,"+CantonConstantesFunciones.SCHEMA+"."+CantonConstantesFunciones.TABLENAME+".es_activo from "+CantonConstantesFunciones.SCHEMA+"."+CantonConstantesFunciones.TABLENAME;//+" as "+CantonConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CantonConstantesFuncionesAdditional cantonConstantesFuncionesAdditional=null;
	
	public CantonConstantesFuncionesAdditional getCantonConstantesFuncionesAdditional() {
		return this.cantonConstantesFuncionesAdditional;
	}
	
	public void setCantonConstantesFuncionesAdditional(CantonConstantesFuncionesAdditional cantonConstantesFuncionesAdditional) {
		try {
			this.cantonConstantesFuncionesAdditional=cantonConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPROVINCIA= "id_provincia";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESACTIVO= "es_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
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
		
	
	public static String getCantonLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CantonConstantesFunciones.IDPROVINCIA)) {sLabelColumna=CantonConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(CantonConstantesFunciones.CODIGO)) {sLabelColumna=CantonConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CantonConstantesFunciones.NOMBRE)) {sLabelColumna=CantonConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CantonConstantesFunciones.ESACTIVO)) {sLabelColumna=CantonConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_activoDescripcion(Canton canton) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!canton.getes_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_activoHtmlDescripcion(Canton canton) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(canton.getId(),canton.getes_activo());

		return sDescripcion;
	}	
	
	public static String getCantonDescripcion(Canton canton) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(canton !=null/* && canton.getId()!=0*/) {
			sDescripcion=canton.getcodigo();//cantoncanton.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCantonDescripcionDetallado(Canton canton) {
		String sDescripcion="";
			
		sDescripcion+=CantonConstantesFunciones.ID+"=";
		sDescripcion+=canton.getId().toString()+",";
		sDescripcion+=CantonConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=canton.getVersionRow().toString()+",";
		sDescripcion+=CantonConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=canton.getid_provincia().toString()+",";
		sDescripcion+=CantonConstantesFunciones.CODIGO+"=";
		sDescripcion+=canton.getcodigo()+",";
		sDescripcion+=CantonConstantesFunciones.NOMBRE+"=";
		sDescripcion+=canton.getnombre()+",";
		sDescripcion+=CantonConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=canton.getes_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCantonDescripcion(Canton canton,String sValor) throws Exception {			
		if(canton !=null) {
			canton.setcodigo(sValor);;//cantoncanton.getcodigo().trim();
		}		
	}
	
		

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCanton(Canton canton,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		canton.setcodigo(canton.getcodigo().trim());
		canton.setnombre(canton.getnombre().trim());
	}
	
	public static void quitarEspaciosCantons(List<Canton> cantons,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Canton canton: cantons) {
			canton.setcodigo(canton.getcodigo().trim());
			canton.setnombre(canton.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCanton(Canton canton,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && canton.getConCambioAuxiliar()) {
			canton.setIsDeleted(canton.getIsDeletedAuxiliar());	
			canton.setIsNew(canton.getIsNewAuxiliar());	
			canton.setIsChanged(canton.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			canton.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			canton.setIsDeletedAuxiliar(false);	
			canton.setIsNewAuxiliar(false);	
			canton.setIsChangedAuxiliar(false);
			
			canton.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCantons(List<Canton> cantons,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Canton canton : cantons) {
			if(conAsignarBase && canton.getConCambioAuxiliar()) {
				canton.setIsDeleted(canton.getIsDeletedAuxiliar());	
				canton.setIsNew(canton.getIsNewAuxiliar());	
				canton.setIsChanged(canton.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				canton.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				canton.setIsDeletedAuxiliar(false);	
				canton.setIsNewAuxiliar(false);	
				canton.setIsChangedAuxiliar(false);
				
				canton.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCanton(Canton canton,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCantons(List<Canton> cantons,Boolean conEnteros) throws Exception  {
		
		for(Canton canton: cantons) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCanton(List<Canton> cantons,Canton cantonAux) throws Exception  {
		CantonConstantesFunciones.InicializarValoresCanton(cantonAux,true);
		
		for(Canton canton: cantons) {
			if(canton.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCanton(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CantonConstantesFunciones.getArrayColumnasGlobalesCanton(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCanton(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCanton(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Canton> cantons,Canton canton,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Canton cantonAux: cantons) {
			if(cantonAux!=null && canton!=null) {
				if((cantonAux.getId()==null && canton.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cantonAux.getId()!=null && canton.getId()!=null){
					if(cantonAux.getId().equals(canton.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCanton(List<Canton> cantons) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Canton canton: cantons) {			
			if(canton.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCanton() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CantonConstantesFunciones.LABEL_ID, CantonConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CantonConstantesFunciones.LABEL_VERSIONROW, CantonConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CantonConstantesFunciones.LABEL_IDPROVINCIA, CantonConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CantonConstantesFunciones.LABEL_CODIGO, CantonConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CantonConstantesFunciones.LABEL_NOMBRE, CantonConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CantonConstantesFunciones.LABEL_ESACTIVO, CantonConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCanton() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CantonConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CantonConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CantonConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CantonConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CantonConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CantonConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCanton() throws Exception  {
		return CantonConstantesFunciones.getTiposSeleccionarCanton(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCanton(Boolean conFk) throws Exception  {
		return CantonConstantesFunciones.getTiposSeleccionarCanton(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCanton(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CantonConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(CantonConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CantonConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CantonConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CantonConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CantonConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CantonConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(CantonConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCanton(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCanton(Canton cantonAux) throws Exception {
		
			cantonAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(cantonAux.getProvincia()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCanton(List<Canton> cantonsTemp) throws Exception {
		for(Canton cantonAux:cantonsTemp) {
			
			cantonAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(cantonAux.getProvincia()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCanton(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Provincia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCanton(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCanton(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CantonConstantesFunciones.getClassesRelationshipsOfCanton(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCanton(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Barrio.class));
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(NumeroPatronal.class));
				classes.add(new Classe(Parroquia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Barrio.class)) {
						classes.add(new Classe(Barrio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Parroquia.class)) {
						classes.add(new Classe(Parroquia.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCanton(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CantonConstantesFunciones.getClassesRelationshipsFromStringsOfCanton(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCanton(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Barrio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Barrio.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(Parroquia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Parroquia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Barrio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Barrio.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(Parroquia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Parroquia.class)); continue;
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
	public static void actualizarLista(Canton canton,List<Canton> cantons,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Canton cantonEncontrado=null;
			
			for(Canton cantonLocal:cantons) {
				if(cantonLocal.getId().equals(canton.getId())) {
					cantonEncontrado=cantonLocal;
					
					cantonLocal.setIsChanged(canton.getIsChanged());
					cantonLocal.setIsNew(canton.getIsNew());
					cantonLocal.setIsDeleted(canton.getIsDeleted());
					
					cantonLocal.setGeneralEntityOriginal(canton.getGeneralEntityOriginal());
					
					cantonLocal.setId(canton.getId());	
					cantonLocal.setVersionRow(canton.getVersionRow());	
					cantonLocal.setid_provincia(canton.getid_provincia());	
					cantonLocal.setcodigo(canton.getcodigo());	
					cantonLocal.setnombre(canton.getnombre());	
					cantonLocal.setes_activo(canton.getes_activo());	
					
					
					cantonLocal.setBarrios(canton.getBarrios());
					cantonLocal.setParroquias(canton.getParroquias());
					
					existe=true;
					break;
				}
			}
			
			if(!canton.getIsDeleted()) {
				if(!existe) {
					cantons.add(canton);
				}
			} else {
				if(cantonEncontrado!=null && permiteQuitar)  {
					cantons.remove(cantonEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Canton canton,List<Canton> cantons) throws Exception {
		try	{			
			for(Canton cantonLocal:cantons) {
				if(cantonLocal.getId().equals(canton.getId())) {
					cantonLocal.setIsSelected(canton.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCanton(List<Canton> cantonsAux) throws Exception {
		//this.cantonsAux=cantonsAux;
		
		for(Canton cantonAux:cantonsAux) {
			if(cantonAux.getIsChanged()) {
				cantonAux.setIsChanged(false);
			}		
			
			if(cantonAux.getIsNew()) {
				cantonAux.setIsNew(false);
			}	
			
			if(cantonAux.getIsDeleted()) {
				cantonAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCanton(Canton cantonAux) throws Exception {
		//this.cantonAux=cantonAux;
		
			if(cantonAux.getIsChanged()) {
				cantonAux.setIsChanged(false);
			}		
			
			if(cantonAux.getIsNew()) {
				cantonAux.setIsNew(false);
			}	
			
			if(cantonAux.getIsDeleted()) {
				cantonAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Canton cantonAsignar,Canton canton) throws Exception {
		cantonAsignar.setId(canton.getId());	
		cantonAsignar.setVersionRow(canton.getVersionRow());	
		cantonAsignar.setid_provincia(canton.getid_provincia());
		cantonAsignar.setprovincia_descripcion(canton.getprovincia_descripcion());	
		cantonAsignar.setcodigo(canton.getcodigo());	
		cantonAsignar.setnombre(canton.getnombre());	
		cantonAsignar.setes_activo(canton.getes_activo());	
	}
	
	public static void inicializarCanton(Canton canton) throws Exception {
		try {
				canton.setId(0L);	
					
				canton.setid_provincia(-1L);	
				canton.setcodigo("");	
				canton.setnombre("");	
				canton.setes_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCanton(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CantonConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CantonConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CantonConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CantonConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCanton(String sTipo,Row row,Workbook workbook,Canton canton,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(canton.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(canton.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(canton.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(canton.getes_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCanton=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCanton() {
		return this.sFinalQueryCanton;
	}
	
	public void setsFinalQueryCanton(String sFinalQueryCanton) {
		this.sFinalQueryCanton= sFinalQueryCanton;
	}
	
	public Border resaltarSeleccionarCanton=null;
	
	public Border setResaltarSeleccionarCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCanton= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCanton() {
		return this.resaltarSeleccionarCanton;
	}
	
	public void setResaltarSeleccionarCanton(Border borderResaltarSeleccionarCanton) {
		this.resaltarSeleccionarCanton= borderResaltarSeleccionarCanton;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCanton=null;
	public Boolean mostraridCanton=true;
	public Boolean activaridCanton=true;

	public Border resaltarid_provinciaCanton=null;
	public Boolean mostrarid_provinciaCanton=true;
	public Boolean activarid_provinciaCanton=true;
	public Boolean cargarid_provinciaCanton=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaCanton=false;//ConEventDepend=true

	public Border resaltarcodigoCanton=null;
	public Boolean mostrarcodigoCanton=true;
	public Boolean activarcodigoCanton=true;

	public Border resaltarnombreCanton=null;
	public Boolean mostrarnombreCanton=true;
	public Boolean activarnombreCanton=true;

	public Border resaltares_activoCanton=null;
	public Boolean mostrares_activoCanton=true;
	public Boolean activares_activoCanton=true;

	
	

	public Border setResaltaridCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltar);
		
		this.resaltaridCanton= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCanton() {
		return this.resaltaridCanton;
	}

	public void setResaltaridCanton(Border borderResaltar) {
		this.resaltaridCanton= borderResaltar;
	}

	public Boolean getMostraridCanton() {
		return this.mostraridCanton;
	}

	public void setMostraridCanton(Boolean mostraridCanton) {
		this.mostraridCanton= mostraridCanton;
	}

	public Boolean getActivaridCanton() {
		return this.activaridCanton;
	}

	public void setActivaridCanton(Boolean activaridCanton) {
		this.activaridCanton= activaridCanton;
	}

	public Border setResaltarid_provinciaCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltar);
		
		this.resaltarid_provinciaCanton= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaCanton() {
		return this.resaltarid_provinciaCanton;
	}

	public void setResaltarid_provinciaCanton(Border borderResaltar) {
		this.resaltarid_provinciaCanton= borderResaltar;
	}

	public Boolean getMostrarid_provinciaCanton() {
		return this.mostrarid_provinciaCanton;
	}

	public void setMostrarid_provinciaCanton(Boolean mostrarid_provinciaCanton) {
		this.mostrarid_provinciaCanton= mostrarid_provinciaCanton;
	}

	public Boolean getActivarid_provinciaCanton() {
		return this.activarid_provinciaCanton;
	}

	public void setActivarid_provinciaCanton(Boolean activarid_provinciaCanton) {
		this.activarid_provinciaCanton= activarid_provinciaCanton;
	}

	public Boolean getCargarid_provinciaCanton() {
		return this.cargarid_provinciaCanton;
	}

	public void setCargarid_provinciaCanton(Boolean cargarid_provinciaCanton) {
		this.cargarid_provinciaCanton= cargarid_provinciaCanton;
	}

	public Border setResaltarcodigoCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltar);
		
		this.resaltarcodigoCanton= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCanton() {
		return this.resaltarcodigoCanton;
	}

	public void setResaltarcodigoCanton(Border borderResaltar) {
		this.resaltarcodigoCanton= borderResaltar;
	}

	public Boolean getMostrarcodigoCanton() {
		return this.mostrarcodigoCanton;
	}

	public void setMostrarcodigoCanton(Boolean mostrarcodigoCanton) {
		this.mostrarcodigoCanton= mostrarcodigoCanton;
	}

	public Boolean getActivarcodigoCanton() {
		return this.activarcodigoCanton;
	}

	public void setActivarcodigoCanton(Boolean activarcodigoCanton) {
		this.activarcodigoCanton= activarcodigoCanton;
	}

	public Border setResaltarnombreCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltar);
		
		this.resaltarnombreCanton= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCanton() {
		return this.resaltarnombreCanton;
	}

	public void setResaltarnombreCanton(Border borderResaltar) {
		this.resaltarnombreCanton= borderResaltar;
	}

	public Boolean getMostrarnombreCanton() {
		return this.mostrarnombreCanton;
	}

	public void setMostrarnombreCanton(Boolean mostrarnombreCanton) {
		this.mostrarnombreCanton= mostrarnombreCanton;
	}

	public Boolean getActivarnombreCanton() {
		return this.activarnombreCanton;
	}

	public void setActivarnombreCanton(Boolean activarnombreCanton) {
		this.activarnombreCanton= activarnombreCanton;
	}

	public Border setResaltares_activoCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltar);
		
		this.resaltares_activoCanton= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_activoCanton() {
		return this.resaltares_activoCanton;
	}

	public void setResaltares_activoCanton(Border borderResaltar) {
		this.resaltares_activoCanton= borderResaltar;
	}

	public Boolean getMostrares_activoCanton() {
		return this.mostrares_activoCanton;
	}

	public void setMostrares_activoCanton(Boolean mostrares_activoCanton) {
		this.mostrares_activoCanton= mostrares_activoCanton;
	}

	public Boolean getActivares_activoCanton() {
		return this.activares_activoCanton;
	}

	public void setActivares_activoCanton(Boolean activares_activoCanton) {
		this.activares_activoCanton= activares_activoCanton;
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
		
		
		this.setMostraridCanton(esInicial);
		this.setMostrarid_provinciaCanton(esInicial);
		this.setMostrarcodigoCanton(esInicial);
		this.setMostrarnombreCanton(esInicial);
		this.setMostrares_activoCanton(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CantonConstantesFunciones.ID)) {
				this.setMostraridCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.ESACTIVO)) {
				this.setMostrares_activoCanton(esAsigna);
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
		
		
		this.setActivaridCanton(esInicial);
		this.setActivarid_provinciaCanton(esInicial);
		this.setActivarcodigoCanton(esInicial);
		this.setActivarnombreCanton(esInicial);
		this.setActivares_activoCanton(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CantonConstantesFunciones.ID)) {
				this.setActivaridCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.ESACTIVO)) {
				this.setActivares_activoCanton(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCanton(esInicial);
		this.setResaltarid_provinciaCanton(esInicial);
		this.setResaltarcodigoCanton(esInicial);
		this.setResaltarnombreCanton(esInicial);
		this.setResaltares_activoCanton(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CantonConstantesFunciones.ID)) {
				this.setResaltaridCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCanton(esAsigna);
				continue;
			}

			if(campo.clase.equals(CantonConstantesFunciones.ESACTIVO)) {
				this.setResaltares_activoCanton(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBarrioCanton=null;

	public Border getResaltarBarrioCanton() {
		return this.resaltarBarrioCanton;
	}

	public void setResaltarBarrioCanton(Border borderResaltarBarrio) {
		if(borderResaltarBarrio!=null) {
			this.resaltarBarrioCanton= borderResaltarBarrio;
		}
	}

	public Border setResaltarBarrioCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltarBarrio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltarBarrio);
			
		this.resaltarBarrioCanton= borderResaltarBarrio;

		 return borderResaltarBarrio;
	}



	public Boolean mostrarBarrioCanton=true;

	public Boolean getMostrarBarrioCanton() {
		return this.mostrarBarrioCanton;
	}

	public void setMostrarBarrioCanton(Boolean visibilidadResaltarBarrio) {
		this.mostrarBarrioCanton= visibilidadResaltarBarrio;
	}



	public Boolean activarBarrioCanton=true;

	public Boolean gethabilitarResaltarBarrioCanton() {
		return this.activarBarrioCanton;
	}

	public void setActivarBarrioCanton(Boolean habilitarResaltarBarrio) {
		this.activarBarrioCanton= habilitarResaltarBarrio;
	}


	public Border resaltarParroquiaCanton=null;

	public Border getResaltarParroquiaCanton() {
		return this.resaltarParroquiaCanton;
	}

	public void setResaltarParroquiaCanton(Border borderResaltarParroquia) {
		if(borderResaltarParroquia!=null) {
			this.resaltarParroquiaCanton= borderResaltarParroquia;
		}
	}

	public Border setResaltarParroquiaCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltarParroquia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cantonBeanSwingJInternalFrame.jTtoolBarCanton.setBorder(borderResaltarParroquia);
			
		this.resaltarParroquiaCanton= borderResaltarParroquia;

		 return borderResaltarParroquia;
	}



	public Boolean mostrarParroquiaCanton=true;

	public Boolean getMostrarParroquiaCanton() {
		return this.mostrarParroquiaCanton;
	}

	public void setMostrarParroquiaCanton(Boolean visibilidadResaltarParroquia) {
		this.mostrarParroquiaCanton= visibilidadResaltarParroquia;
	}



	public Boolean activarParroquiaCanton=true;

	public Boolean gethabilitarResaltarParroquiaCanton() {
		return this.activarParroquiaCanton;
	}

	public void setActivarParroquiaCanton(Boolean habilitarResaltarParroquia) {
		this.activarParroquiaCanton= habilitarResaltarParroquia;
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

		this.setMostrarBarrioCanton(esInicial);
		this.setMostrarParroquiaCanton(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Barrio.class)) {
				this.setMostrarBarrioCanton(esAsigna);
				continue;
			}

			if(clase.clas.equals(Parroquia.class)) {
				this.setMostrarParroquiaCanton(esAsigna);
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

		this.setActivarBarrioCanton(esInicial);
		this.setActivarParroquiaCanton(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Barrio.class)) {
				this.setActivarBarrioCanton(esAsigna);
				continue;
			}

			if(clase.clas.equals(Parroquia.class)) {
				this.setActivarParroquiaCanton(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBarrioCanton(esInicial);
		this.setResaltarParroquiaCanton(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Barrio.class)) {
				this.setResaltarBarrioCanton(esAsigna);
				continue;
			}

			if(clase.clas.equals(Parroquia.class)) {
				this.setResaltarParroquiaCanton(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdProvinciaCanton=true;

	public Boolean getMostrarFK_IdProvinciaCanton() {
		return this.mostrarFK_IdProvinciaCanton;
	}

	public void setMostrarFK_IdProvinciaCanton(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProvinciaCanton= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdProvinciaCanton=true;

	public Boolean getActivarFK_IdProvinciaCanton() {
		return this.activarFK_IdProvinciaCanton;
	}

	public void setActivarFK_IdProvinciaCanton(Boolean habilitarResaltar) {
		this.activarFK_IdProvinciaCanton= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdProvinciaCanton=null;

	public Border getResaltarFK_IdProvinciaCanton() {
		return this.resaltarFK_IdProvinciaCanton;
	}

	public void setResaltarFK_IdProvinciaCanton(Border borderResaltar) {
		this.resaltarFK_IdProvinciaCanton= borderResaltar;
	}

	public void setResaltarFK_IdProvinciaCanton(ParametroGeneralUsuario parametroGeneralUsuario/*CantonBeanSwingJInternalFrame cantonBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProvinciaCanton= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}