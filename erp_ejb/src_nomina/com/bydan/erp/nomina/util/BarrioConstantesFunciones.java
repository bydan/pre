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


import com.bydan.erp.nomina.util.BarrioConstantesFunciones;
import com.bydan.erp.nomina.util.BarrioParameterReturnGeneral;
//import com.bydan.erp.nomina.util.BarrioParameterGeneral;

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
final public class BarrioConstantesFunciones extends BarrioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Barrio";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Barrio"+BarrioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BarrioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BarrioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BarrioConstantesFunciones.SCHEMA+"_"+BarrioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BarrioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BarrioConstantesFunciones.SCHEMA+"_"+BarrioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BarrioConstantesFunciones.SCHEMA+"_"+BarrioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BarrioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BarrioConstantesFunciones.SCHEMA+"_"+BarrioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BarrioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BarrioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BarrioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BarrioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BarrioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BarrioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BarrioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BarrioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BarrioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BarrioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Barrios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Barrio";
	public static final String SCLASSWEBTITULO_LOWER="Barrio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Barrio";
	public static final String OBJECTNAME="barrio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="barrio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select barrio from "+BarrioConstantesFunciones.SPERSISTENCENAME+" barrio";
	public static String QUERYSELECTNATIVE="select "+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME+".id,"+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME+".version_row,"+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME+".id_provincia,"+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME+".id_canton,"+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME+".id_parroquia,"+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME+".codigo,"+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME+".nombre from "+BarrioConstantesFunciones.SCHEMA+"."+BarrioConstantesFunciones.TABLENAME;//+" as "+BarrioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BarrioConstantesFuncionesAdditional barrioConstantesFuncionesAdditional=null;
	
	public BarrioConstantesFuncionesAdditional getBarrioConstantesFuncionesAdditional() {
		return this.barrioConstantesFuncionesAdditional;
	}
	
	public void setBarrioConstantesFuncionesAdditional(BarrioConstantesFuncionesAdditional barrioConstantesFuncionesAdditional) {
		try {
			this.barrioConstantesFuncionesAdditional=barrioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCANTON= "id_canton";
    public static final String IDPARROQUIA= "id_parroquia";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCANTON= "Canton";
		public static final String LABEL_IDCANTON_LOWER= "Canton";
    	public static final String LABEL_IDPARROQUIA= "Parroquia";
		public static final String LABEL_IDPARROQUIA_LOWER= "Parroquia";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getBarrioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BarrioConstantesFunciones.IDPROVINCIA)) {sLabelColumna=BarrioConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(BarrioConstantesFunciones.IDCANTON)) {sLabelColumna=BarrioConstantesFunciones.LABEL_IDCANTON;}
		if(sNombreColumna.equals(BarrioConstantesFunciones.IDPARROQUIA)) {sLabelColumna=BarrioConstantesFunciones.LABEL_IDPARROQUIA;}
		if(sNombreColumna.equals(BarrioConstantesFunciones.CODIGO)) {sLabelColumna=BarrioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(BarrioConstantesFunciones.NOMBRE)) {sLabelColumna=BarrioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getBarrioDescripcion(Barrio barrio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(barrio !=null/* && barrio.getId()!=0*/) {
			sDescripcion=barrio.getcodigo();//barriobarrio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getBarrioDescripcionDetallado(Barrio barrio) {
		String sDescripcion="";
			
		sDescripcion+=BarrioConstantesFunciones.ID+"=";
		sDescripcion+=barrio.getId().toString()+",";
		sDescripcion+=BarrioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=barrio.getVersionRow().toString()+",";
		sDescripcion+=BarrioConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=barrio.getid_provincia().toString()+",";
		sDescripcion+=BarrioConstantesFunciones.IDCANTON+"=";
		sDescripcion+=barrio.getid_canton().toString()+",";
		sDescripcion+=BarrioConstantesFunciones.IDPARROQUIA+"=";
		sDescripcion+=barrio.getid_parroquia().toString()+",";
		sDescripcion+=BarrioConstantesFunciones.CODIGO+"=";
		sDescripcion+=barrio.getcodigo()+",";
		sDescripcion+=BarrioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=barrio.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setBarrioDescripcion(Barrio barrio,String sValor) throws Exception {			
		if(barrio !=null) {
			barrio.setcodigo(sValor);;//barriobarrio.getcodigo().trim();
		}		
	}
	
		

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
		}

		return sDescripcion;
	}

	public static String getCantonDescripcion(Canton canton) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(canton!=null/*&&canton.getId()>0*/) {
			sDescripcion=CantonConstantesFunciones.getCantonDescripcion(canton);
		}

		return sDescripcion;
	}

	public static String getParroquiaDescripcion(Parroquia parroquia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(parroquia!=null/*&&parroquia.getId()>0*/) {
			sDescripcion=ParroquiaConstantesFunciones.getParroquiaDescripcion(parroquia);
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
		} else if(sNombreIndice.equals("FK_IdParroquia")) {
			sNombreIndice="Tipo=  Por Parroquia";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
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

	public static String getDetalleIndiceFK_IdParroquia(Long id_parroquia) {
		String sDetalleIndice=" Parametros->";
		if(id_parroquia!=null) {sDetalleIndice+=" Codigo Unico De Parroquia="+id_parroquia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBarrio(Barrio barrio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		barrio.setcodigo(barrio.getcodigo().trim());
		barrio.setnombre(barrio.getnombre().trim());
	}
	
	public static void quitarEspaciosBarrios(List<Barrio> barrios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Barrio barrio: barrios) {
			barrio.setcodigo(barrio.getcodigo().trim());
			barrio.setnombre(barrio.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBarrio(Barrio barrio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && barrio.getConCambioAuxiliar()) {
			barrio.setIsDeleted(barrio.getIsDeletedAuxiliar());	
			barrio.setIsNew(barrio.getIsNewAuxiliar());	
			barrio.setIsChanged(barrio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			barrio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			barrio.setIsDeletedAuxiliar(false);	
			barrio.setIsNewAuxiliar(false);	
			barrio.setIsChangedAuxiliar(false);
			
			barrio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBarrios(List<Barrio> barrios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Barrio barrio : barrios) {
			if(conAsignarBase && barrio.getConCambioAuxiliar()) {
				barrio.setIsDeleted(barrio.getIsDeletedAuxiliar());	
				barrio.setIsNew(barrio.getIsNewAuxiliar());	
				barrio.setIsChanged(barrio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				barrio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				barrio.setIsDeletedAuxiliar(false);	
				barrio.setIsNewAuxiliar(false);	
				barrio.setIsChangedAuxiliar(false);
				
				barrio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBarrio(Barrio barrio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBarrios(List<Barrio> barrios,Boolean conEnteros) throws Exception  {
		
		for(Barrio barrio: barrios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBarrio(List<Barrio> barrios,Barrio barrioAux) throws Exception  {
		BarrioConstantesFunciones.InicializarValoresBarrio(barrioAux,true);
		
		for(Barrio barrio: barrios) {
			if(barrio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBarrio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BarrioConstantesFunciones.getArrayColumnasGlobalesBarrio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBarrio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBarrio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Barrio> barrios,Barrio barrio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Barrio barrioAux: barrios) {
			if(barrioAux!=null && barrio!=null) {
				if((barrioAux.getId()==null && barrio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(barrioAux.getId()!=null && barrio.getId()!=null){
					if(barrioAux.getId().equals(barrio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBarrio(List<Barrio> barrios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Barrio barrio: barrios) {			
			if(barrio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBarrio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BarrioConstantesFunciones.LABEL_ID, BarrioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BarrioConstantesFunciones.LABEL_VERSIONROW, BarrioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BarrioConstantesFunciones.LABEL_IDPROVINCIA, BarrioConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BarrioConstantesFunciones.LABEL_IDCANTON, BarrioConstantesFunciones.IDCANTON,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BarrioConstantesFunciones.LABEL_IDPARROQUIA, BarrioConstantesFunciones.IDPARROQUIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BarrioConstantesFunciones.LABEL_CODIGO, BarrioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BarrioConstantesFunciones.LABEL_NOMBRE, BarrioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBarrio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BarrioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BarrioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BarrioConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BarrioConstantesFunciones.IDCANTON;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BarrioConstantesFunciones.IDPARROQUIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BarrioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BarrioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBarrio() throws Exception  {
		return BarrioConstantesFunciones.getTiposSeleccionarBarrio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBarrio(Boolean conFk) throws Exception  {
		return BarrioConstantesFunciones.getTiposSeleccionarBarrio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBarrio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BarrioConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(BarrioConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BarrioConstantesFunciones.LABEL_IDCANTON);
			reporte.setsDescripcion(BarrioConstantesFunciones.LABEL_IDCANTON);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BarrioConstantesFunciones.LABEL_IDPARROQUIA);
			reporte.setsDescripcion(BarrioConstantesFunciones.LABEL_IDPARROQUIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BarrioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(BarrioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BarrioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(BarrioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBarrio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBarrio(Barrio barrioAux) throws Exception {
		
			barrioAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(barrioAux.getProvincia()));
			barrioAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(barrioAux.getCanton()));
			barrioAux.setparroquia_descripcion(ParroquiaConstantesFunciones.getParroquiaDescripcion(barrioAux.getParroquia()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBarrio(List<Barrio> barriosTemp) throws Exception {
		for(Barrio barrioAux:barriosTemp) {
			
			barrioAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(barrioAux.getProvincia()));
			barrioAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(barrioAux.getCanton()));
			barrioAux.setparroquia_descripcion(ParroquiaConstantesFunciones.getParroquiaDescripcion(barrioAux.getParroquia()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBarrio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Canton.class));
				classes.add(new Classe(Parroquia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Canton.class)) {
						classes.add(new Classe(Canton.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Parroquia.class)) {
						classes.add(new Classe(Parroquia.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBarrio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
					}

					if(Parroquia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Parroquia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBarrio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BarrioConstantesFunciones.getClassesRelationshipsOfBarrio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBarrio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBarrio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BarrioConstantesFunciones.getClassesRelationshipsFromStringsOfBarrio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBarrio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Barrio barrio,List<Barrio> barrios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Barrio barrioEncontrado=null;
			
			for(Barrio barrioLocal:barrios) {
				if(barrioLocal.getId().equals(barrio.getId())) {
					barrioEncontrado=barrioLocal;
					
					barrioLocal.setIsChanged(barrio.getIsChanged());
					barrioLocal.setIsNew(barrio.getIsNew());
					barrioLocal.setIsDeleted(barrio.getIsDeleted());
					
					barrioLocal.setGeneralEntityOriginal(barrio.getGeneralEntityOriginal());
					
					barrioLocal.setId(barrio.getId());	
					barrioLocal.setVersionRow(barrio.getVersionRow());	
					barrioLocal.setid_provincia(barrio.getid_provincia());	
					barrioLocal.setid_canton(barrio.getid_canton());	
					barrioLocal.setid_parroquia(barrio.getid_parroquia());	
					barrioLocal.setcodigo(barrio.getcodigo());	
					barrioLocal.setnombre(barrio.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!barrio.getIsDeleted()) {
				if(!existe) {
					barrios.add(barrio);
				}
			} else {
				if(barrioEncontrado!=null && permiteQuitar)  {
					barrios.remove(barrioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Barrio barrio,List<Barrio> barrios) throws Exception {
		try	{			
			for(Barrio barrioLocal:barrios) {
				if(barrioLocal.getId().equals(barrio.getId())) {
					barrioLocal.setIsSelected(barrio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBarrio(List<Barrio> barriosAux) throws Exception {
		//this.barriosAux=barriosAux;
		
		for(Barrio barrioAux:barriosAux) {
			if(barrioAux.getIsChanged()) {
				barrioAux.setIsChanged(false);
			}		
			
			if(barrioAux.getIsNew()) {
				barrioAux.setIsNew(false);
			}	
			
			if(barrioAux.getIsDeleted()) {
				barrioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBarrio(Barrio barrioAux) throws Exception {
		//this.barrioAux=barrioAux;
		
			if(barrioAux.getIsChanged()) {
				barrioAux.setIsChanged(false);
			}		
			
			if(barrioAux.getIsNew()) {
				barrioAux.setIsNew(false);
			}	
			
			if(barrioAux.getIsDeleted()) {
				barrioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Barrio barrioAsignar,Barrio barrio) throws Exception {
		barrioAsignar.setId(barrio.getId());	
		barrioAsignar.setVersionRow(barrio.getVersionRow());	
		barrioAsignar.setid_provincia(barrio.getid_provincia());
		barrioAsignar.setprovincia_descripcion(barrio.getprovincia_descripcion());	
		barrioAsignar.setid_canton(barrio.getid_canton());
		barrioAsignar.setcanton_descripcion(barrio.getcanton_descripcion());	
		barrioAsignar.setid_parroquia(barrio.getid_parroquia());
		barrioAsignar.setparroquia_descripcion(barrio.getparroquia_descripcion());	
		barrioAsignar.setcodigo(barrio.getcodigo());	
		barrioAsignar.setnombre(barrio.getnombre());	
	}
	
	public static void inicializarBarrio(Barrio barrio) throws Exception {
		try {
				barrio.setId(0L);	
					
				barrio.setid_provincia(-1L);	
				barrio.setid_canton(-1L);	
				barrio.setid_parroquia(-1L);	
				barrio.setcodigo("");	
				barrio.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBarrio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BarrioConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BarrioConstantesFunciones.LABEL_IDCANTON);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BarrioConstantesFunciones.LABEL_IDPARROQUIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BarrioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BarrioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBarrio(String sTipo,Row row,Workbook workbook,Barrio barrio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(barrio.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(barrio.getcanton_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(barrio.getparroquia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(barrio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(barrio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBarrio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBarrio() {
		return this.sFinalQueryBarrio;
	}
	
	public void setsFinalQueryBarrio(String sFinalQueryBarrio) {
		this.sFinalQueryBarrio= sFinalQueryBarrio;
	}
	
	public Border resaltarSeleccionarBarrio=null;
	
	public Border setResaltarSeleccionarBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//barrioBeanSwingJInternalFrame.jTtoolBarBarrio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBarrio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBarrio() {
		return this.resaltarSeleccionarBarrio;
	}
	
	public void setResaltarSeleccionarBarrio(Border borderResaltarSeleccionarBarrio) {
		this.resaltarSeleccionarBarrio= borderResaltarSeleccionarBarrio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBarrio=null;
	public Boolean mostraridBarrio=true;
	public Boolean activaridBarrio=true;

	public Border resaltarid_provinciaBarrio=null;
	public Boolean mostrarid_provinciaBarrio=true;
	public Boolean activarid_provinciaBarrio=true;
	public Boolean cargarid_provinciaBarrio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaBarrio=false;//ConEventDepend=true

	public Border resaltarid_cantonBarrio=null;
	public Boolean mostrarid_cantonBarrio=true;
	public Boolean activarid_cantonBarrio=true;
	public Boolean cargarid_cantonBarrio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cantonBarrio=false;//ConEventDepend=true

	public Border resaltarid_parroquiaBarrio=null;
	public Boolean mostrarid_parroquiaBarrio=true;
	public Boolean activarid_parroquiaBarrio=true;
	public Boolean cargarid_parroquiaBarrio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_parroquiaBarrio=false;//ConEventDepend=true

	public Border resaltarcodigoBarrio=null;
	public Boolean mostrarcodigoBarrio=true;
	public Boolean activarcodigoBarrio=true;

	public Border resaltarnombreBarrio=null;
	public Boolean mostrarnombreBarrio=true;
	public Boolean activarnombreBarrio=true;

	
	

	public Border setResaltaridBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//barrioBeanSwingJInternalFrame.jTtoolBarBarrio.setBorder(borderResaltar);
		
		this.resaltaridBarrio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBarrio() {
		return this.resaltaridBarrio;
	}

	public void setResaltaridBarrio(Border borderResaltar) {
		this.resaltaridBarrio= borderResaltar;
	}

	public Boolean getMostraridBarrio() {
		return this.mostraridBarrio;
	}

	public void setMostraridBarrio(Boolean mostraridBarrio) {
		this.mostraridBarrio= mostraridBarrio;
	}

	public Boolean getActivaridBarrio() {
		return this.activaridBarrio;
	}

	public void setActivaridBarrio(Boolean activaridBarrio) {
		this.activaridBarrio= activaridBarrio;
	}

	public Border setResaltarid_provinciaBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//barrioBeanSwingJInternalFrame.jTtoolBarBarrio.setBorder(borderResaltar);
		
		this.resaltarid_provinciaBarrio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaBarrio() {
		return this.resaltarid_provinciaBarrio;
	}

	public void setResaltarid_provinciaBarrio(Border borderResaltar) {
		this.resaltarid_provinciaBarrio= borderResaltar;
	}

	public Boolean getMostrarid_provinciaBarrio() {
		return this.mostrarid_provinciaBarrio;
	}

	public void setMostrarid_provinciaBarrio(Boolean mostrarid_provinciaBarrio) {
		this.mostrarid_provinciaBarrio= mostrarid_provinciaBarrio;
	}

	public Boolean getActivarid_provinciaBarrio() {
		return this.activarid_provinciaBarrio;
	}

	public void setActivarid_provinciaBarrio(Boolean activarid_provinciaBarrio) {
		this.activarid_provinciaBarrio= activarid_provinciaBarrio;
	}

	public Boolean getCargarid_provinciaBarrio() {
		return this.cargarid_provinciaBarrio;
	}

	public void setCargarid_provinciaBarrio(Boolean cargarid_provinciaBarrio) {
		this.cargarid_provinciaBarrio= cargarid_provinciaBarrio;
	}

	public Border setResaltarid_cantonBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//barrioBeanSwingJInternalFrame.jTtoolBarBarrio.setBorder(borderResaltar);
		
		this.resaltarid_cantonBarrio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cantonBarrio() {
		return this.resaltarid_cantonBarrio;
	}

	public void setResaltarid_cantonBarrio(Border borderResaltar) {
		this.resaltarid_cantonBarrio= borderResaltar;
	}

	public Boolean getMostrarid_cantonBarrio() {
		return this.mostrarid_cantonBarrio;
	}

	public void setMostrarid_cantonBarrio(Boolean mostrarid_cantonBarrio) {
		this.mostrarid_cantonBarrio= mostrarid_cantonBarrio;
	}

	public Boolean getActivarid_cantonBarrio() {
		return this.activarid_cantonBarrio;
	}

	public void setActivarid_cantonBarrio(Boolean activarid_cantonBarrio) {
		this.activarid_cantonBarrio= activarid_cantonBarrio;
	}

	public Boolean getCargarid_cantonBarrio() {
		return this.cargarid_cantonBarrio;
	}

	public void setCargarid_cantonBarrio(Boolean cargarid_cantonBarrio) {
		this.cargarid_cantonBarrio= cargarid_cantonBarrio;
	}

	public Border setResaltarid_parroquiaBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//barrioBeanSwingJInternalFrame.jTtoolBarBarrio.setBorder(borderResaltar);
		
		this.resaltarid_parroquiaBarrio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_parroquiaBarrio() {
		return this.resaltarid_parroquiaBarrio;
	}

	public void setResaltarid_parroquiaBarrio(Border borderResaltar) {
		this.resaltarid_parroquiaBarrio= borderResaltar;
	}

	public Boolean getMostrarid_parroquiaBarrio() {
		return this.mostrarid_parroquiaBarrio;
	}

	public void setMostrarid_parroquiaBarrio(Boolean mostrarid_parroquiaBarrio) {
		this.mostrarid_parroquiaBarrio= mostrarid_parroquiaBarrio;
	}

	public Boolean getActivarid_parroquiaBarrio() {
		return this.activarid_parroquiaBarrio;
	}

	public void setActivarid_parroquiaBarrio(Boolean activarid_parroquiaBarrio) {
		this.activarid_parroquiaBarrio= activarid_parroquiaBarrio;
	}

	public Boolean getCargarid_parroquiaBarrio() {
		return this.cargarid_parroquiaBarrio;
	}

	public void setCargarid_parroquiaBarrio(Boolean cargarid_parroquiaBarrio) {
		this.cargarid_parroquiaBarrio= cargarid_parroquiaBarrio;
	}

	public Border setResaltarcodigoBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//barrioBeanSwingJInternalFrame.jTtoolBarBarrio.setBorder(borderResaltar);
		
		this.resaltarcodigoBarrio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoBarrio() {
		return this.resaltarcodigoBarrio;
	}

	public void setResaltarcodigoBarrio(Border borderResaltar) {
		this.resaltarcodigoBarrio= borderResaltar;
	}

	public Boolean getMostrarcodigoBarrio() {
		return this.mostrarcodigoBarrio;
	}

	public void setMostrarcodigoBarrio(Boolean mostrarcodigoBarrio) {
		this.mostrarcodigoBarrio= mostrarcodigoBarrio;
	}

	public Boolean getActivarcodigoBarrio() {
		return this.activarcodigoBarrio;
	}

	public void setActivarcodigoBarrio(Boolean activarcodigoBarrio) {
		this.activarcodigoBarrio= activarcodigoBarrio;
	}

	public Border setResaltarnombreBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//barrioBeanSwingJInternalFrame.jTtoolBarBarrio.setBorder(borderResaltar);
		
		this.resaltarnombreBarrio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreBarrio() {
		return this.resaltarnombreBarrio;
	}

	public void setResaltarnombreBarrio(Border borderResaltar) {
		this.resaltarnombreBarrio= borderResaltar;
	}

	public Boolean getMostrarnombreBarrio() {
		return this.mostrarnombreBarrio;
	}

	public void setMostrarnombreBarrio(Boolean mostrarnombreBarrio) {
		this.mostrarnombreBarrio= mostrarnombreBarrio;
	}

	public Boolean getActivarnombreBarrio() {
		return this.activarnombreBarrio;
	}

	public void setActivarnombreBarrio(Boolean activarnombreBarrio) {
		this.activarnombreBarrio= activarnombreBarrio;
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
		
		
		this.setMostraridBarrio(esInicial);
		this.setMostrarid_provinciaBarrio(esInicial);
		this.setMostrarid_cantonBarrio(esInicial);
		this.setMostrarid_parroquiaBarrio(esInicial);
		this.setMostrarcodigoBarrio(esInicial);
		this.setMostrarnombreBarrio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BarrioConstantesFunciones.ID)) {
				this.setMostraridBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDCANTON)) {
				this.setMostrarid_cantonBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDPARROQUIA)) {
				this.setMostrarid_parroquiaBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreBarrio(esAsigna);
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
		
		
		this.setActivaridBarrio(esInicial);
		this.setActivarid_provinciaBarrio(esInicial);
		this.setActivarid_cantonBarrio(esInicial);
		this.setActivarid_parroquiaBarrio(esInicial);
		this.setActivarcodigoBarrio(esInicial);
		this.setActivarnombreBarrio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BarrioConstantesFunciones.ID)) {
				this.setActivaridBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDCANTON)) {
				this.setActivarid_cantonBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDPARROQUIA)) {
				this.setActivarid_parroquiaBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreBarrio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBarrio(esInicial);
		this.setResaltarid_provinciaBarrio(esInicial);
		this.setResaltarid_cantonBarrio(esInicial);
		this.setResaltarid_parroquiaBarrio(esInicial);
		this.setResaltarcodigoBarrio(esInicial);
		this.setResaltarnombreBarrio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BarrioConstantesFunciones.ID)) {
				this.setResaltaridBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDCANTON)) {
				this.setResaltarid_cantonBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.IDPARROQUIA)) {
				this.setResaltarid_parroquiaBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoBarrio(esAsigna);
				continue;
			}

			if(campo.clase.equals(BarrioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreBarrio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCantonBarrio=true;

	public Boolean getMostrarFK_IdCantonBarrio() {
		return this.mostrarFK_IdCantonBarrio;
	}

	public void setMostrarFK_IdCantonBarrio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCantonBarrio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParroquiaBarrio=true;

	public Boolean getMostrarFK_IdParroquiaBarrio() {
		return this.mostrarFK_IdParroquiaBarrio;
	}

	public void setMostrarFK_IdParroquiaBarrio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParroquiaBarrio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProvinciaBarrio=true;

	public Boolean getMostrarFK_IdProvinciaBarrio() {
		return this.mostrarFK_IdProvinciaBarrio;
	}

	public void setMostrarFK_IdProvinciaBarrio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProvinciaBarrio= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCantonBarrio=true;

	public Boolean getActivarFK_IdCantonBarrio() {
		return this.activarFK_IdCantonBarrio;
	}

	public void setActivarFK_IdCantonBarrio(Boolean habilitarResaltar) {
		this.activarFK_IdCantonBarrio= habilitarResaltar;
	}

	public Boolean activarFK_IdParroquiaBarrio=true;

	public Boolean getActivarFK_IdParroquiaBarrio() {
		return this.activarFK_IdParroquiaBarrio;
	}

	public void setActivarFK_IdParroquiaBarrio(Boolean habilitarResaltar) {
		this.activarFK_IdParroquiaBarrio= habilitarResaltar;
	}

	public Boolean activarFK_IdProvinciaBarrio=true;

	public Boolean getActivarFK_IdProvinciaBarrio() {
		return this.activarFK_IdProvinciaBarrio;
	}

	public void setActivarFK_IdProvinciaBarrio(Boolean habilitarResaltar) {
		this.activarFK_IdProvinciaBarrio= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCantonBarrio=null;

	public Border getResaltarFK_IdCantonBarrio() {
		return this.resaltarFK_IdCantonBarrio;
	}

	public void setResaltarFK_IdCantonBarrio(Border borderResaltar) {
		this.resaltarFK_IdCantonBarrio= borderResaltar;
	}

	public void setResaltarFK_IdCantonBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCantonBarrio= borderResaltar;
	}

	public Border resaltarFK_IdParroquiaBarrio=null;

	public Border getResaltarFK_IdParroquiaBarrio() {
		return this.resaltarFK_IdParroquiaBarrio;
	}

	public void setResaltarFK_IdParroquiaBarrio(Border borderResaltar) {
		this.resaltarFK_IdParroquiaBarrio= borderResaltar;
	}

	public void setResaltarFK_IdParroquiaBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParroquiaBarrio= borderResaltar;
	}

	public Border resaltarFK_IdProvinciaBarrio=null;

	public Border getResaltarFK_IdProvinciaBarrio() {
		return this.resaltarFK_IdProvinciaBarrio;
	}

	public void setResaltarFK_IdProvinciaBarrio(Border borderResaltar) {
		this.resaltarFK_IdProvinciaBarrio= borderResaltar;
	}

	public void setResaltarFK_IdProvinciaBarrio(ParametroGeneralUsuario parametroGeneralUsuario/*BarrioBeanSwingJInternalFrame barrioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProvinciaBarrio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}