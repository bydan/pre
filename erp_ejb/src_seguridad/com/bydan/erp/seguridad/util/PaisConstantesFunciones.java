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


import com.bydan.erp.seguridad.util.PaisConstantesFunciones;
import com.bydan.erp.seguridad.util.PaisParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PaisParameterGeneral;

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
final public class PaisConstantesFunciones extends PaisConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=" order by nombre" ;	
	public static final String SNOMBREOPCION="Pais";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Pais"+PaisConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PaisHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PaisHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PaisConstantesFunciones.SCHEMA+"_"+PaisConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PaisHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PaisConstantesFunciones.SCHEMA+"_"+PaisConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PaisConstantesFunciones.SCHEMA+"_"+PaisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PaisHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PaisConstantesFunciones.SCHEMA+"_"+PaisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaisConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PaisHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaisConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PaisHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaisConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PaisConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PaisConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PaisConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PaisConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Paises";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pais";
	public static final String SCLASSWEBTITULO_LOWER="Pais";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Pais";
	public static final String OBJECTNAME="pais";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="pais";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pais from "+PaisConstantesFunciones.SPERSISTENCENAME+" pais";
	public static String QUERYSELECTNATIVE="select "+PaisConstantesFunciones.SCHEMA+"."+PaisConstantesFunciones.TABLENAME+".id,"+PaisConstantesFunciones.SCHEMA+"."+PaisConstantesFunciones.TABLENAME+".version_row,"+PaisConstantesFunciones.SCHEMA+"."+PaisConstantesFunciones.TABLENAME+".id_continente,"+PaisConstantesFunciones.SCHEMA+"."+PaisConstantesFunciones.TABLENAME+".codigo,"+PaisConstantesFunciones.SCHEMA+"."+PaisConstantesFunciones.TABLENAME+".nombre,"+PaisConstantesFunciones.SCHEMA+"."+PaisConstantesFunciones.TABLENAME+".nacionalidad from "+PaisConstantesFunciones.SCHEMA+"."+PaisConstantesFunciones.TABLENAME;//+" as "+PaisConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PaisConstantesFuncionesAdditional paisConstantesFuncionesAdditional=null;
	
	public PaisConstantesFuncionesAdditional getPaisConstantesFuncionesAdditional() {
		return this.paisConstantesFuncionesAdditional;
	}
	
	public void setPaisConstantesFuncionesAdditional(PaisConstantesFuncionesAdditional paisConstantesFuncionesAdditional) {
		try {
			this.paisConstantesFuncionesAdditional=paisConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCONTINENTE= "id_continente";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NACIONALIDAD= "nacionalidad";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCONTINENTE= "Continente";
		public static final String LABEL_IDCONTINENTE_LOWER= "Continente";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NACIONALIDAD= "Nacionalidad";
		public static final String LABEL_NACIONALIDAD_LOWER= "Nacionalidad";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNACIONALIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNACIONALIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPaisLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PaisConstantesFunciones.IDCONTINENTE)) {sLabelColumna=PaisConstantesFunciones.LABEL_IDCONTINENTE;}
		if(sNombreColumna.equals(PaisConstantesFunciones.CODIGO)) {sLabelColumna=PaisConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PaisConstantesFunciones.NOMBRE)) {sLabelColumna=PaisConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PaisConstantesFunciones.NACIONALIDAD)) {sLabelColumna=PaisConstantesFunciones.LABEL_NACIONALIDAD;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pais !=null/* && pais.getId()!=0*/) {
			sDescripcion=pais.getnombre();//paispais.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPaisDescripcionDetallado(Pais pais) {
		String sDescripcion="";
			
		sDescripcion+=PaisConstantesFunciones.ID+"=";
		sDescripcion+=pais.getId().toString()+",";
		sDescripcion+=PaisConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pais.getVersionRow().toString()+",";
		sDescripcion+=PaisConstantesFunciones.IDCONTINENTE+"=";
		sDescripcion+=pais.getid_continente().toString()+",";
		sDescripcion+=PaisConstantesFunciones.CODIGO+"=";
		sDescripcion+=pais.getcodigo()+",";
		sDescripcion+=PaisConstantesFunciones.NOMBRE+"=";
		sDescripcion+=pais.getnombre()+",";
		sDescripcion+=PaisConstantesFunciones.NACIONALIDAD+"=";
		sDescripcion+=pais.getnacionalidad()+",";
			
		return sDescripcion;
	}
	
	public static void setPaisDescripcion(Pais pais,String sValor) throws Exception {			
		if(pais !=null) {
			pais.setnombre(sValor);;//paispais.getnombre().trim();
		}		
	}
	
		

	public static String getContinenteDescripcion(Continente continente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(continente!=null/*&&continente.getId()>0*/) {
			sDescripcion=ContinenteConstantesFunciones.getContinenteDescripcion(continente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdContinentePorNombre")) {
			sNombreIndice="Tipo=  Por Continente Por Nombre";
		} else if(sNombreIndice.equals("FK_IdContinente")) {
			sNombreIndice="Tipo=  Por Continente";
		} else if(sNombreIndice.equals("PorIdContinentePorNombre")) {
			sNombreIndice="Tipo=  Por Continente Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdContinentePorNombre(Long id_continente,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_continente!=null) {sDetalleIndice+=" Codigo Unico De Continente="+id_continente.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdContinente(Long id_continente) {
		String sDetalleIndice=" Parametros->";
		if(id_continente!=null) {sDetalleIndice+=" Codigo Unico De Continente="+id_continente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdContinentePorNombre(Long id_continente,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_continente!=null) {sDetalleIndice+=" Codigo Unico De Continente="+id_continente.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPais(Pais pais,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pais.setcodigo(pais.getcodigo().trim());
		pais.setnombre(pais.getnombre().trim());
		pais.setnacionalidad(pais.getnacionalidad().trim());
	}
	
	public static void quitarEspaciosPaiss(List<Pais> paiss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Pais pais: paiss) {
			pais.setcodigo(pais.getcodigo().trim());
			pais.setnombre(pais.getnombre().trim());
			pais.setnacionalidad(pais.getnacionalidad().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPais(Pais pais,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pais.getConCambioAuxiliar()) {
			pais.setIsDeleted(pais.getIsDeletedAuxiliar());	
			pais.setIsNew(pais.getIsNewAuxiliar());	
			pais.setIsChanged(pais.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pais.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pais.setIsDeletedAuxiliar(false);	
			pais.setIsNewAuxiliar(false);	
			pais.setIsChangedAuxiliar(false);
			
			pais.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPaiss(List<Pais> paiss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Pais pais : paiss) {
			if(conAsignarBase && pais.getConCambioAuxiliar()) {
				pais.setIsDeleted(pais.getIsDeletedAuxiliar());	
				pais.setIsNew(pais.getIsNewAuxiliar());	
				pais.setIsChanged(pais.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pais.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pais.setIsDeletedAuxiliar(false);	
				pais.setIsNewAuxiliar(false);	
				pais.setIsChangedAuxiliar(false);
				
				pais.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPais(Pais pais,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPaiss(List<Pais> paiss,Boolean conEnteros) throws Exception  {
		
		for(Pais pais: paiss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPais(List<Pais> paiss,Pais paisAux) throws Exception  {
		PaisConstantesFunciones.InicializarValoresPais(paisAux,true);
		
		for(Pais pais: paiss) {
			if(pais.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPais(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PaisConstantesFunciones.getArrayColumnasGlobalesPais(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPais(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPais(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Pais> paiss,Pais pais,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Pais paisAux: paiss) {
			if(paisAux!=null && pais!=null) {
				if((paisAux.getId()==null && pais.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(paisAux.getId()!=null && pais.getId()!=null){
					if(paisAux.getId().equals(pais.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPais(List<Pais> paiss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Pais pais: paiss) {			
			if(pais.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPais() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PaisConstantesFunciones.LABEL_ID, PaisConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaisConstantesFunciones.LABEL_VERSIONROW, PaisConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaisConstantesFunciones.LABEL_IDCONTINENTE, PaisConstantesFunciones.IDCONTINENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaisConstantesFunciones.LABEL_CODIGO, PaisConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaisConstantesFunciones.LABEL_NOMBRE, PaisConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaisConstantesFunciones.LABEL_NACIONALIDAD, PaisConstantesFunciones.NACIONALIDAD,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPais() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PaisConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaisConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaisConstantesFunciones.IDCONTINENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaisConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaisConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaisConstantesFunciones.NACIONALIDAD;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPais() throws Exception  {
		return PaisConstantesFunciones.getTiposSeleccionarPais(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPais(Boolean conFk) throws Exception  {
		return PaisConstantesFunciones.getTiposSeleccionarPais(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPais(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PaisConstantesFunciones.LABEL_IDCONTINENTE);
			reporte.setsDescripcion(PaisConstantesFunciones.LABEL_IDCONTINENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PaisConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PaisConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PaisConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PaisConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PaisConstantesFunciones.LABEL_NACIONALIDAD);
			reporte.setsDescripcion(PaisConstantesFunciones.LABEL_NACIONALIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPais(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPais(Pais paisAux) throws Exception {
		
			paisAux.setcontinente_descripcion(ContinenteConstantesFunciones.getContinenteDescripcion(paisAux.getContinente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPais(List<Pais> paissTemp) throws Exception {
		for(Pais paisAux:paissTemp) {
			
			paisAux.setcontinente_descripcion(ContinenteConstantesFunciones.getContinenteDescripcion(paisAux.getContinente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPais(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Continente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Continente.class)) {
						classes.add(new Classe(Continente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPais(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Continente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Continente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Continente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Continente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPais(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PaisConstantesFunciones.getClassesRelationshipsOfPais(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPais(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Region.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Region.class)) {
						classes.add(new Classe(Region.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPais(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PaisConstantesFunciones.getClassesRelationshipsFromStringsOfPais(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPais(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
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
	public static void actualizarLista(Pais pais,List<Pais> paiss,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Pais paisEncontrado=null;
			
			for(Pais paisLocal:paiss) {
				if(paisLocal.getId().equals(pais.getId())) {
					paisEncontrado=paisLocal;
					
					paisLocal.setIsChanged(pais.getIsChanged());
					paisLocal.setIsNew(pais.getIsNew());
					paisLocal.setIsDeleted(pais.getIsDeleted());
					
					paisLocal.setGeneralEntityOriginal(pais.getGeneralEntityOriginal());
					
					paisLocal.setId(pais.getId());	
					paisLocal.setVersionRow(pais.getVersionRow());	
					paisLocal.setid_continente(pais.getid_continente());	
					paisLocal.setcodigo(pais.getcodigo());	
					paisLocal.setnombre(pais.getnombre());	
					paisLocal.setnacionalidad(pais.getnacionalidad());	
					
					
					paisLocal.setCiudads(pais.getCiudads());
					paisLocal.setProvincias(pais.getProvincias());
					paisLocal.setRegions(pais.getRegions());
					
					existe=true;
					break;
				}
			}
			
			if(!pais.getIsDeleted()) {
				if(!existe) {
					paiss.add(pais);
				}
			} else {
				if(paisEncontrado!=null && permiteQuitar)  {
					paiss.remove(paisEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Pais pais,List<Pais> paiss) throws Exception {
		try	{			
			for(Pais paisLocal:paiss) {
				if(paisLocal.getId().equals(pais.getId())) {
					paisLocal.setIsSelected(pais.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPais(List<Pais> paissAux) throws Exception {
		//this.paissAux=paissAux;
		
		for(Pais paisAux:paissAux) {
			if(paisAux.getIsChanged()) {
				paisAux.setIsChanged(false);
			}		
			
			if(paisAux.getIsNew()) {
				paisAux.setIsNew(false);
			}	
			
			if(paisAux.getIsDeleted()) {
				paisAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPais(Pais paisAux) throws Exception {
		//this.paisAux=paisAux;
		
			if(paisAux.getIsChanged()) {
				paisAux.setIsChanged(false);
			}		
			
			if(paisAux.getIsNew()) {
				paisAux.setIsNew(false);
			}	
			
			if(paisAux.getIsDeleted()) {
				paisAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Pais paisAsignar,Pais pais) throws Exception {
		paisAsignar.setId(pais.getId());	
		paisAsignar.setVersionRow(pais.getVersionRow());	
		paisAsignar.setid_continente(pais.getid_continente());
		paisAsignar.setcontinente_descripcion(pais.getcontinente_descripcion());	
		paisAsignar.setcodigo(pais.getcodigo());	
		paisAsignar.setnombre(pais.getnombre());	
		paisAsignar.setnacionalidad(pais.getnacionalidad());	
	}
	
	public static void inicializarPais(Pais pais) throws Exception {
		try {
				pais.setId(0L);	
					
				pais.setid_continente(-1L);	
				pais.setcodigo("");	
				pais.setnombre("");	
				pais.setnacionalidad("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPais(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PaisConstantesFunciones.LABEL_IDCONTINENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PaisConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PaisConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PaisConstantesFunciones.LABEL_NACIONALIDAD);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPais(String sTipo,Row row,Workbook workbook,Pais pais,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pais.getcontinente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pais.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pais.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pais.getnacionalidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPais=" order by nombre" ;
	
	public String getsFinalQueryPais() {
		return this.sFinalQueryPais;
	}
	
	public void setsFinalQueryPais(String sFinalQueryPais) {
		this.sFinalQueryPais= sFinalQueryPais;
	}
	
	public Border resaltarSeleccionarPais=null;
	
	public Border setResaltarSeleccionarPais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPais= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPais() {
		return this.resaltarSeleccionarPais;
	}
	
	public void setResaltarSeleccionarPais(Border borderResaltarSeleccionarPais) {
		this.resaltarSeleccionarPais= borderResaltarSeleccionarPais;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPais=null;
	public Boolean mostraridPais=true;
	public Boolean activaridPais=true;

	public Border resaltarid_continentePais=null;
	public Boolean mostrarid_continentePais=true;
	public Boolean activarid_continentePais=true;
	public Boolean cargarid_continentePais=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_continentePais=false;//ConEventDepend=true

	public Border resaltarcodigoPais=null;
	public Boolean mostrarcodigoPais=true;
	public Boolean activarcodigoPais=true;

	public Border resaltarnombrePais=null;
	public Boolean mostrarnombrePais=true;
	public Boolean activarnombrePais=true;

	public Border resaltarnacionalidadPais=null;
	public Boolean mostrarnacionalidadPais=true;
	public Boolean activarnacionalidadPais=true;

	
	

	public Border setResaltaridPais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltar);
		
		this.resaltaridPais= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPais() {
		return this.resaltaridPais;
	}

	public void setResaltaridPais(Border borderResaltar) {
		this.resaltaridPais= borderResaltar;
	}

	public Boolean getMostraridPais() {
		return this.mostraridPais;
	}

	public void setMostraridPais(Boolean mostraridPais) {
		this.mostraridPais= mostraridPais;
	}

	public Boolean getActivaridPais() {
		return this.activaridPais;
	}

	public void setActivaridPais(Boolean activaridPais) {
		this.activaridPais= activaridPais;
	}

	public Border setResaltarid_continentePais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltar);
		
		this.resaltarid_continentePais= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_continentePais() {
		return this.resaltarid_continentePais;
	}

	public void setResaltarid_continentePais(Border borderResaltar) {
		this.resaltarid_continentePais= borderResaltar;
	}

	public Boolean getMostrarid_continentePais() {
		return this.mostrarid_continentePais;
	}

	public void setMostrarid_continentePais(Boolean mostrarid_continentePais) {
		this.mostrarid_continentePais= mostrarid_continentePais;
	}

	public Boolean getActivarid_continentePais() {
		return this.activarid_continentePais;
	}

	public void setActivarid_continentePais(Boolean activarid_continentePais) {
		this.activarid_continentePais= activarid_continentePais;
	}

	public Boolean getCargarid_continentePais() {
		return this.cargarid_continentePais;
	}

	public void setCargarid_continentePais(Boolean cargarid_continentePais) {
		this.cargarid_continentePais= cargarid_continentePais;
	}

	public Border setResaltarcodigoPais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltar);
		
		this.resaltarcodigoPais= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPais() {
		return this.resaltarcodigoPais;
	}

	public void setResaltarcodigoPais(Border borderResaltar) {
		this.resaltarcodigoPais= borderResaltar;
	}

	public Boolean getMostrarcodigoPais() {
		return this.mostrarcodigoPais;
	}

	public void setMostrarcodigoPais(Boolean mostrarcodigoPais) {
		this.mostrarcodigoPais= mostrarcodigoPais;
	}

	public Boolean getActivarcodigoPais() {
		return this.activarcodigoPais;
	}

	public void setActivarcodigoPais(Boolean activarcodigoPais) {
		this.activarcodigoPais= activarcodigoPais;
	}

	public Border setResaltarnombrePais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltar);
		
		this.resaltarnombrePais= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePais() {
		return this.resaltarnombrePais;
	}

	public void setResaltarnombrePais(Border borderResaltar) {
		this.resaltarnombrePais= borderResaltar;
	}

	public Boolean getMostrarnombrePais() {
		return this.mostrarnombrePais;
	}

	public void setMostrarnombrePais(Boolean mostrarnombrePais) {
		this.mostrarnombrePais= mostrarnombrePais;
	}

	public Boolean getActivarnombrePais() {
		return this.activarnombrePais;
	}

	public void setActivarnombrePais(Boolean activarnombrePais) {
		this.activarnombrePais= activarnombrePais;
	}

	public Border setResaltarnacionalidadPais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltar);
		
		this.resaltarnacionalidadPais= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnacionalidadPais() {
		return this.resaltarnacionalidadPais;
	}

	public void setResaltarnacionalidadPais(Border borderResaltar) {
		this.resaltarnacionalidadPais= borderResaltar;
	}

	public Boolean getMostrarnacionalidadPais() {
		return this.mostrarnacionalidadPais;
	}

	public void setMostrarnacionalidadPais(Boolean mostrarnacionalidadPais) {
		this.mostrarnacionalidadPais= mostrarnacionalidadPais;
	}

	public Boolean getActivarnacionalidadPais() {
		return this.activarnacionalidadPais;
	}

	public void setActivarnacionalidadPais(Boolean activarnacionalidadPais) {
		this.activarnacionalidadPais= activarnacionalidadPais;
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
		
		
		this.setMostraridPais(esInicial);
		this.setMostrarid_continentePais(esInicial);
		this.setMostrarcodigoPais(esInicial);
		this.setMostrarnombrePais(esInicial);
		this.setMostrarnacionalidadPais(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PaisConstantesFunciones.ID)) {
				this.setMostraridPais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.IDCONTINENTE)) {
				this.setMostrarid_continentePais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.NACIONALIDAD)) {
				this.setMostrarnacionalidadPais(esAsigna);
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
		
		
		this.setActivaridPais(esInicial);
		this.setActivarid_continentePais(esInicial);
		this.setActivarcodigoPais(esInicial);
		this.setActivarnombrePais(esInicial);
		this.setActivarnacionalidadPais(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PaisConstantesFunciones.ID)) {
				this.setActivaridPais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.IDCONTINENTE)) {
				this.setActivarid_continentePais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.NACIONALIDAD)) {
				this.setActivarnacionalidadPais(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPais(esInicial);
		this.setResaltarid_continentePais(esInicial);
		this.setResaltarcodigoPais(esInicial);
		this.setResaltarnombrePais(esInicial);
		this.setResaltarnacionalidadPais(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PaisConstantesFunciones.ID)) {
				this.setResaltaridPais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.IDCONTINENTE)) {
				this.setResaltarid_continentePais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePais(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaisConstantesFunciones.NACIONALIDAD)) {
				this.setResaltarnacionalidadPais(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCiudadPais=null;

	public Border getResaltarCiudadPais() {
		return this.resaltarCiudadPais;
	}

	public void setResaltarCiudadPais(Border borderResaltarCiudad) {
		if(borderResaltarCiudad!=null) {
			this.resaltarCiudadPais= borderResaltarCiudad;
		}
	}

	public Border setResaltarCiudadPais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltarCiudad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltarCiudad);
			
		this.resaltarCiudadPais= borderResaltarCiudad;

		 return borderResaltarCiudad;
	}



	public Boolean mostrarCiudadPais=true;

	public Boolean getMostrarCiudadPais() {
		return this.mostrarCiudadPais;
	}

	public void setMostrarCiudadPais(Boolean visibilidadResaltarCiudad) {
		this.mostrarCiudadPais= visibilidadResaltarCiudad;
	}



	public Boolean activarCiudadPais=true;

	public Boolean gethabilitarResaltarCiudadPais() {
		return this.activarCiudadPais;
	}

	public void setActivarCiudadPais(Boolean habilitarResaltarCiudad) {
		this.activarCiudadPais= habilitarResaltarCiudad;
	}


	public Border resaltarProvinciaPais=null;

	public Border getResaltarProvinciaPais() {
		return this.resaltarProvinciaPais;
	}

	public void setResaltarProvinciaPais(Border borderResaltarProvincia) {
		if(borderResaltarProvincia!=null) {
			this.resaltarProvinciaPais= borderResaltarProvincia;
		}
	}

	public Border setResaltarProvinciaPais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltarProvincia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltarProvincia);
			
		this.resaltarProvinciaPais= borderResaltarProvincia;

		 return borderResaltarProvincia;
	}



	public Boolean mostrarProvinciaPais=true;

	public Boolean getMostrarProvinciaPais() {
		return this.mostrarProvinciaPais;
	}

	public void setMostrarProvinciaPais(Boolean visibilidadResaltarProvincia) {
		this.mostrarProvinciaPais= visibilidadResaltarProvincia;
	}



	public Boolean activarProvinciaPais=true;

	public Boolean gethabilitarResaltarProvinciaPais() {
		return this.activarProvinciaPais;
	}

	public void setActivarProvinciaPais(Boolean habilitarResaltarProvincia) {
		this.activarProvinciaPais= habilitarResaltarProvincia;
	}


	public Border resaltarRegionPais=null;

	public Border getResaltarRegionPais() {
		return this.resaltarRegionPais;
	}

	public void setResaltarRegionPais(Border borderResaltarRegion) {
		if(borderResaltarRegion!=null) {
			this.resaltarRegionPais= borderResaltarRegion;
		}
	}

	public Border setResaltarRegionPais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltarRegion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//paisBeanSwingJInternalFrame.jTtoolBarPais.setBorder(borderResaltarRegion);
			
		this.resaltarRegionPais= borderResaltarRegion;

		 return borderResaltarRegion;
	}



	public Boolean mostrarRegionPais=true;

	public Boolean getMostrarRegionPais() {
		return this.mostrarRegionPais;
	}

	public void setMostrarRegionPais(Boolean visibilidadResaltarRegion) {
		this.mostrarRegionPais= visibilidadResaltarRegion;
	}



	public Boolean activarRegionPais=true;

	public Boolean gethabilitarResaltarRegionPais() {
		return this.activarRegionPais;
	}

	public void setActivarRegionPais(Boolean habilitarResaltarRegion) {
		this.activarRegionPais= habilitarResaltarRegion;
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

		this.setMostrarCiudadPais(esInicial);
		this.setMostrarProvinciaPais(esInicial);
		this.setMostrarRegionPais(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Ciudad.class)) {
				this.setMostrarCiudadPais(esAsigna);
				continue;
			}

			if(clase.clas.equals(Provincia.class)) {
				this.setMostrarProvinciaPais(esAsigna);
				continue;
			}

			if(clase.clas.equals(Region.class)) {
				this.setMostrarRegionPais(esAsigna);
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

		this.setActivarCiudadPais(esInicial);
		this.setActivarProvinciaPais(esInicial);
		this.setActivarRegionPais(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Ciudad.class)) {
				this.setActivarCiudadPais(esAsigna);
				continue;
			}

			if(clase.clas.equals(Provincia.class)) {
				this.setActivarProvinciaPais(esAsigna);
				continue;
			}

			if(clase.clas.equals(Region.class)) {
				this.setActivarRegionPais(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCiudadPais(esInicial);
		this.setResaltarProvinciaPais(esInicial);
		this.setResaltarRegionPais(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Ciudad.class)) {
				this.setResaltarCiudadPais(esAsigna);
				continue;
			}

			if(clase.clas.equals(Provincia.class)) {
				this.setResaltarProvinciaPais(esAsigna);
				continue;
			}

			if(clase.clas.equals(Region.class)) {
				this.setResaltarRegionPais(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdContinentePorNombrePais=true;

	public Boolean getMostrarBusquedaPorIdContinentePorNombrePais() {
		return this.mostrarBusquedaPorIdContinentePorNombrePais;
	}

	public void setMostrarBusquedaPorIdContinentePorNombrePais(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdContinentePorNombrePais= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdContinentePais=true;

	public Boolean getMostrarFK_IdContinentePais() {
		return this.mostrarFK_IdContinentePais;
	}

	public void setMostrarFK_IdContinentePais(Boolean visibilidadResaltar) {
		this.mostrarFK_IdContinentePais= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdContinentePorNombrePais=true;

	public Boolean getActivarBusquedaPorIdContinentePorNombrePais() {
		return this.activarBusquedaPorIdContinentePorNombrePais;
	}

	public void setActivarBusquedaPorIdContinentePorNombrePais(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdContinentePorNombrePais= habilitarResaltar;
	}

	public Boolean activarFK_IdContinentePais=true;

	public Boolean getActivarFK_IdContinentePais() {
		return this.activarFK_IdContinentePais;
	}

	public void setActivarFK_IdContinentePais(Boolean habilitarResaltar) {
		this.activarFK_IdContinentePais= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdContinentePorNombrePais=null;

	public Border getResaltarBusquedaPorIdContinentePorNombrePais() {
		return this.resaltarBusquedaPorIdContinentePorNombrePais;
	}

	public void setResaltarBusquedaPorIdContinentePorNombrePais(Border borderResaltar) {
		this.resaltarBusquedaPorIdContinentePorNombrePais= borderResaltar;
	}

	public void setResaltarBusquedaPorIdContinentePorNombrePais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdContinentePorNombrePais= borderResaltar;
	}

	public Border resaltarFK_IdContinentePais=null;

	public Border getResaltarFK_IdContinentePais() {
		return this.resaltarFK_IdContinentePais;
	}

	public void setResaltarFK_IdContinentePais(Border borderResaltar) {
		this.resaltarFK_IdContinentePais= borderResaltar;
	}

	public void setResaltarFK_IdContinentePais(ParametroGeneralUsuario parametroGeneralUsuario/*PaisBeanSwingJInternalFrame paisBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdContinentePais= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}