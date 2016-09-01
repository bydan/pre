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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.HobbyClienteConstantesFunciones;
import com.bydan.erp.cartera.util.HobbyClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.HobbyClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class HobbyClienteConstantesFunciones extends HobbyClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="HobbyCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="HobbyCliente"+HobbyClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="HobbyClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="HobbyClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=HobbyClienteConstantesFunciones.SCHEMA+"_"+HobbyClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/HobbyClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=HobbyClienteConstantesFunciones.SCHEMA+"_"+HobbyClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=HobbyClienteConstantesFunciones.SCHEMA+"_"+HobbyClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/HobbyClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=HobbyClienteConstantesFunciones.SCHEMA+"_"+HobbyClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HobbyClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/HobbyClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+HobbyClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=HobbyClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+HobbyClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=HobbyClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+HobbyClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Hobby Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Hobby Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Hobby Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="HobbyCliente";
	public static final String OBJECTNAME="hobbycliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="hobby_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select hobbycliente from "+HobbyClienteConstantesFunciones.SPERSISTENCENAME+" hobbycliente";
	public static String QUERYSELECTNATIVE="select "+HobbyClienteConstantesFunciones.SCHEMA+"."+HobbyClienteConstantesFunciones.TABLENAME+".id,"+HobbyClienteConstantesFunciones.SCHEMA+"."+HobbyClienteConstantesFunciones.TABLENAME+".version_row,"+HobbyClienteConstantesFunciones.SCHEMA+"."+HobbyClienteConstantesFunciones.TABLENAME+".id_empresa,"+HobbyClienteConstantesFunciones.SCHEMA+"."+HobbyClienteConstantesFunciones.TABLENAME+".id_cliente,"+HobbyClienteConstantesFunciones.SCHEMA+"."+HobbyClienteConstantesFunciones.TABLENAME+".id_hobby,"+HobbyClienteConstantesFunciones.SCHEMA+"."+HobbyClienteConstantesFunciones.TABLENAME+".descripcion from "+HobbyClienteConstantesFunciones.SCHEMA+"."+HobbyClienteConstantesFunciones.TABLENAME;//+" as "+HobbyClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected HobbyClienteConstantesFuncionesAdditional hobbyclienteConstantesFuncionesAdditional=null;
	
	public HobbyClienteConstantesFuncionesAdditional getHobbyClienteConstantesFuncionesAdditional() {
		return this.hobbyclienteConstantesFuncionesAdditional;
	}
	
	public void setHobbyClienteConstantesFuncionesAdditional(HobbyClienteConstantesFuncionesAdditional hobbyclienteConstantesFuncionesAdditional) {
		try {
			this.hobbyclienteConstantesFuncionesAdditional=hobbyclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDHOBBY= "id_hobby";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDHOBBY= "Hobby";
		public static final String LABEL_IDHOBBY_LOWER= "Hobby";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getHobbyClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(HobbyClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=HobbyClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(HobbyClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=HobbyClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(HobbyClienteConstantesFunciones.IDHOBBY)) {sLabelColumna=HobbyClienteConstantesFunciones.LABEL_IDHOBBY;}
		if(sNombreColumna.equals(HobbyClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=HobbyClienteConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getHobbyClienteDescripcion(HobbyCliente hobbycliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(hobbycliente !=null/* && hobbycliente.getId()!=0*/) {
			if(hobbycliente.getId()!=null) {
				sDescripcion=hobbycliente.getId().toString();
			}//hobbyclientehobbycliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getHobbyClienteDescripcionDetallado(HobbyCliente hobbycliente) {
		String sDescripcion="";
			
		sDescripcion+=HobbyClienteConstantesFunciones.ID+"=";
		sDescripcion+=hobbycliente.getId().toString()+",";
		sDescripcion+=HobbyClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=hobbycliente.getVersionRow().toString()+",";
		sDescripcion+=HobbyClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=hobbycliente.getid_empresa().toString()+",";
		sDescripcion+=HobbyClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=hobbycliente.getid_cliente().toString()+",";
		sDescripcion+=HobbyClienteConstantesFunciones.IDHOBBY+"=";
		sDescripcion+=hobbycliente.getid_hobby().toString()+",";
		sDescripcion+=HobbyClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=hobbycliente.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setHobbyClienteDescripcion(HobbyCliente hobbycliente,String sValor) throws Exception {			
		if(hobbycliente !=null) {
			//hobbyclientehobbycliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getHobbyDescripcion(Hobby hobby) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(hobby!=null/*&&hobby.getId()>0*/) {
			sDescripcion=HobbyConstantesFunciones.getHobbyDescripcion(hobby);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdHobby")) {
			sNombreIndice="Tipo=  Por Hobby";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdHobby(Long id_hobby) {
		String sDetalleIndice=" Parametros->";
		if(id_hobby!=null) {sDetalleIndice+=" Codigo Unico De Hobby="+id_hobby.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosHobbyCliente(HobbyCliente hobbycliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		hobbycliente.setdescripcion(hobbycliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosHobbyClientes(List<HobbyCliente> hobbyclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HobbyCliente hobbycliente: hobbyclientes) {
			hobbycliente.setdescripcion(hobbycliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHobbyCliente(HobbyCliente hobbycliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && hobbycliente.getConCambioAuxiliar()) {
			hobbycliente.setIsDeleted(hobbycliente.getIsDeletedAuxiliar());	
			hobbycliente.setIsNew(hobbycliente.getIsNewAuxiliar());	
			hobbycliente.setIsChanged(hobbycliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			hobbycliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			hobbycliente.setIsDeletedAuxiliar(false);	
			hobbycliente.setIsNewAuxiliar(false);	
			hobbycliente.setIsChangedAuxiliar(false);
			
			hobbycliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresHobbyClientes(List<HobbyCliente> hobbyclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(HobbyCliente hobbycliente : hobbyclientes) {
			if(conAsignarBase && hobbycliente.getConCambioAuxiliar()) {
				hobbycliente.setIsDeleted(hobbycliente.getIsDeletedAuxiliar());	
				hobbycliente.setIsNew(hobbycliente.getIsNewAuxiliar());	
				hobbycliente.setIsChanged(hobbycliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				hobbycliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				hobbycliente.setIsDeletedAuxiliar(false);	
				hobbycliente.setIsNewAuxiliar(false);	
				hobbycliente.setIsChangedAuxiliar(false);
				
				hobbycliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresHobbyCliente(HobbyCliente hobbycliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresHobbyClientes(List<HobbyCliente> hobbyclientes,Boolean conEnteros) throws Exception  {
		
		for(HobbyCliente hobbycliente: hobbyclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaHobbyCliente(List<HobbyCliente> hobbyclientes,HobbyCliente hobbyclienteAux) throws Exception  {
		HobbyClienteConstantesFunciones.InicializarValoresHobbyCliente(hobbyclienteAux,true);
		
		for(HobbyCliente hobbycliente: hobbyclientes) {
			if(hobbycliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHobbyCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=HobbyClienteConstantesFunciones.getArrayColumnasGlobalesHobbyCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesHobbyCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(HobbyClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(HobbyClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoHobbyCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HobbyCliente> hobbyclientes,HobbyCliente hobbycliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HobbyCliente hobbyclienteAux: hobbyclientes) {
			if(hobbyclienteAux!=null && hobbycliente!=null) {
				if((hobbyclienteAux.getId()==null && hobbycliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(hobbyclienteAux.getId()!=null && hobbycliente.getId()!=null){
					if(hobbyclienteAux.getId().equals(hobbycliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHobbyCliente(List<HobbyCliente> hobbyclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(HobbyCliente hobbycliente: hobbyclientes) {			
			if(hobbycliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaHobbyCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,HobbyClienteConstantesFunciones.LABEL_ID, HobbyClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyClienteConstantesFunciones.LABEL_VERSIONROW, HobbyClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyClienteConstantesFunciones.LABEL_IDEMPRESA, HobbyClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyClienteConstantesFunciones.LABEL_IDCLIENTE, HobbyClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyClienteConstantesFunciones.LABEL_IDHOBBY, HobbyClienteConstantesFunciones.IDHOBBY,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,HobbyClienteConstantesFunciones.LABEL_DESCRIPCION, HobbyClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasHobbyCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=HobbyClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyClienteConstantesFunciones.IDHOBBY;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=HobbyClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHobbyCliente() throws Exception  {
		return HobbyClienteConstantesFunciones.getTiposSeleccionarHobbyCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHobbyCliente(Boolean conFk) throws Exception  {
		return HobbyClienteConstantesFunciones.getTiposSeleccionarHobbyCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarHobbyCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(HobbyClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(HobbyClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyClienteConstantesFunciones.LABEL_IDHOBBY);
			reporte.setsDescripcion(HobbyClienteConstantesFunciones.LABEL_IDHOBBY);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(HobbyClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(HobbyClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesHobbyCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesHobbyCliente(HobbyCliente hobbyclienteAux) throws Exception {
		
			hobbyclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(hobbyclienteAux.getEmpresa()));
			hobbyclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(hobbyclienteAux.getCliente()));
			hobbyclienteAux.sethobby_descripcion(HobbyConstantesFunciones.getHobbyDescripcion(hobbyclienteAux.getHobby()));		
	}
	
	public static void refrescarForeignKeysDescripcionesHobbyCliente(List<HobbyCliente> hobbyclientesTemp) throws Exception {
		for(HobbyCliente hobbyclienteAux:hobbyclientesTemp) {
			
			hobbyclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(hobbyclienteAux.getEmpresa()));
			hobbyclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(hobbyclienteAux.getCliente()));
			hobbyclienteAux.sethobby_descripcion(HobbyConstantesFunciones.getHobbyDescripcion(hobbyclienteAux.getHobby()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfHobbyCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Hobby.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Hobby.class)) {
						classes.add(new Classe(Hobby.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfHobbyCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Hobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Hobby.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Hobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Hobby.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfHobbyCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return HobbyClienteConstantesFunciones.getClassesRelationshipsOfHobbyCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHobbyCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHobbyCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return HobbyClienteConstantesFunciones.getClassesRelationshipsFromStringsOfHobbyCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfHobbyCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(HobbyCliente hobbycliente,List<HobbyCliente> hobbyclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			HobbyCliente hobbyclienteEncontrado=null;
			
			for(HobbyCliente hobbyclienteLocal:hobbyclientes) {
				if(hobbyclienteLocal.getId().equals(hobbycliente.getId())) {
					hobbyclienteEncontrado=hobbyclienteLocal;
					
					hobbyclienteLocal.setIsChanged(hobbycliente.getIsChanged());
					hobbyclienteLocal.setIsNew(hobbycliente.getIsNew());
					hobbyclienteLocal.setIsDeleted(hobbycliente.getIsDeleted());
					
					hobbyclienteLocal.setGeneralEntityOriginal(hobbycliente.getGeneralEntityOriginal());
					
					hobbyclienteLocal.setId(hobbycliente.getId());	
					hobbyclienteLocal.setVersionRow(hobbycliente.getVersionRow());	
					hobbyclienteLocal.setid_empresa(hobbycliente.getid_empresa());	
					hobbyclienteLocal.setid_cliente(hobbycliente.getid_cliente());	
					hobbyclienteLocal.setid_hobby(hobbycliente.getid_hobby());	
					hobbyclienteLocal.setdescripcion(hobbycliente.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!hobbycliente.getIsDeleted()) {
				if(!existe) {
					hobbyclientes.add(hobbycliente);
				}
			} else {
				if(hobbyclienteEncontrado!=null && permiteQuitar)  {
					hobbyclientes.remove(hobbyclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(HobbyCliente hobbycliente,List<HobbyCliente> hobbyclientes) throws Exception {
		try	{			
			for(HobbyCliente hobbyclienteLocal:hobbyclientes) {
				if(hobbyclienteLocal.getId().equals(hobbycliente.getId())) {
					hobbyclienteLocal.setIsSelected(hobbycliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesHobbyCliente(List<HobbyCliente> hobbyclientesAux) throws Exception {
		//this.hobbyclientesAux=hobbyclientesAux;
		
		for(HobbyCliente hobbyclienteAux:hobbyclientesAux) {
			if(hobbyclienteAux.getIsChanged()) {
				hobbyclienteAux.setIsChanged(false);
			}		
			
			if(hobbyclienteAux.getIsNew()) {
				hobbyclienteAux.setIsNew(false);
			}	
			
			if(hobbyclienteAux.getIsDeleted()) {
				hobbyclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesHobbyCliente(HobbyCliente hobbyclienteAux) throws Exception {
		//this.hobbyclienteAux=hobbyclienteAux;
		
			if(hobbyclienteAux.getIsChanged()) {
				hobbyclienteAux.setIsChanged(false);
			}		
			
			if(hobbyclienteAux.getIsNew()) {
				hobbyclienteAux.setIsNew(false);
			}	
			
			if(hobbyclienteAux.getIsDeleted()) {
				hobbyclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(HobbyCliente hobbyclienteAsignar,HobbyCliente hobbycliente) throws Exception {
		hobbyclienteAsignar.setId(hobbycliente.getId());	
		hobbyclienteAsignar.setVersionRow(hobbycliente.getVersionRow());	
		hobbyclienteAsignar.setid_empresa(hobbycliente.getid_empresa());
		hobbyclienteAsignar.setempresa_descripcion(hobbycliente.getempresa_descripcion());	
		hobbyclienteAsignar.setid_cliente(hobbycliente.getid_cliente());
		hobbyclienteAsignar.setcliente_descripcion(hobbycliente.getcliente_descripcion());	
		hobbyclienteAsignar.setid_hobby(hobbycliente.getid_hobby());
		hobbyclienteAsignar.sethobby_descripcion(hobbycliente.gethobby_descripcion());	
		hobbyclienteAsignar.setdescripcion(hobbycliente.getdescripcion());	
	}
	
	public static void inicializarHobbyCliente(HobbyCliente hobbycliente) throws Exception {
		try {
				hobbycliente.setId(0L);	
					
				hobbycliente.setid_empresa(-1L);	
				hobbycliente.setid_cliente(-1L);	
				hobbycliente.setid_hobby(-1L);	
				hobbycliente.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderHobbyCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyClienteConstantesFunciones.LABEL_IDHOBBY);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(HobbyClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataHobbyCliente(String sTipo,Row row,Workbook workbook,HobbyCliente hobbycliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(hobbycliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(hobbycliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(hobbycliente.gethobby_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(hobbycliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryHobbyCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryHobbyCliente() {
		return this.sFinalQueryHobbyCliente;
	}
	
	public void setsFinalQueryHobbyCliente(String sFinalQueryHobbyCliente) {
		this.sFinalQueryHobbyCliente= sFinalQueryHobbyCliente;
	}
	
	public Border resaltarSeleccionarHobbyCliente=null;
	
	public Border setResaltarSeleccionarHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//hobbyclienteBeanSwingJInternalFrame.jTtoolBarHobbyCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarHobbyCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarHobbyCliente() {
		return this.resaltarSeleccionarHobbyCliente;
	}
	
	public void setResaltarSeleccionarHobbyCliente(Border borderResaltarSeleccionarHobbyCliente) {
		this.resaltarSeleccionarHobbyCliente= borderResaltarSeleccionarHobbyCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridHobbyCliente=null;
	public Boolean mostraridHobbyCliente=true;
	public Boolean activaridHobbyCliente=true;

	public Border resaltarid_empresaHobbyCliente=null;
	public Boolean mostrarid_empresaHobbyCliente=true;
	public Boolean activarid_empresaHobbyCliente=true;
	public Boolean cargarid_empresaHobbyCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaHobbyCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteHobbyCliente=null;
	public Boolean mostrarid_clienteHobbyCliente=true;
	public Boolean activarid_clienteHobbyCliente=true;
	public Boolean cargarid_clienteHobbyCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteHobbyCliente=false;//ConEventDepend=true

	public Border resaltarid_hobbyHobbyCliente=null;
	public Boolean mostrarid_hobbyHobbyCliente=true;
	public Boolean activarid_hobbyHobbyCliente=true;
	public Boolean cargarid_hobbyHobbyCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_hobbyHobbyCliente=false;//ConEventDepend=true

	public Border resaltardescripcionHobbyCliente=null;
	public Boolean mostrardescripcionHobbyCliente=true;
	public Boolean activardescripcionHobbyCliente=true;

	
	

	public Border setResaltaridHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyclienteBeanSwingJInternalFrame.jTtoolBarHobbyCliente.setBorder(borderResaltar);
		
		this.resaltaridHobbyCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridHobbyCliente() {
		return this.resaltaridHobbyCliente;
	}

	public void setResaltaridHobbyCliente(Border borderResaltar) {
		this.resaltaridHobbyCliente= borderResaltar;
	}

	public Boolean getMostraridHobbyCliente() {
		return this.mostraridHobbyCliente;
	}

	public void setMostraridHobbyCliente(Boolean mostraridHobbyCliente) {
		this.mostraridHobbyCliente= mostraridHobbyCliente;
	}

	public Boolean getActivaridHobbyCliente() {
		return this.activaridHobbyCliente;
	}

	public void setActivaridHobbyCliente(Boolean activaridHobbyCliente) {
		this.activaridHobbyCliente= activaridHobbyCliente;
	}

	public Border setResaltarid_empresaHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyclienteBeanSwingJInternalFrame.jTtoolBarHobbyCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaHobbyCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaHobbyCliente() {
		return this.resaltarid_empresaHobbyCliente;
	}

	public void setResaltarid_empresaHobbyCliente(Border borderResaltar) {
		this.resaltarid_empresaHobbyCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaHobbyCliente() {
		return this.mostrarid_empresaHobbyCliente;
	}

	public void setMostrarid_empresaHobbyCliente(Boolean mostrarid_empresaHobbyCliente) {
		this.mostrarid_empresaHobbyCliente= mostrarid_empresaHobbyCliente;
	}

	public Boolean getActivarid_empresaHobbyCliente() {
		return this.activarid_empresaHobbyCliente;
	}

	public void setActivarid_empresaHobbyCliente(Boolean activarid_empresaHobbyCliente) {
		this.activarid_empresaHobbyCliente= activarid_empresaHobbyCliente;
	}

	public Boolean getCargarid_empresaHobbyCliente() {
		return this.cargarid_empresaHobbyCliente;
	}

	public void setCargarid_empresaHobbyCliente(Boolean cargarid_empresaHobbyCliente) {
		this.cargarid_empresaHobbyCliente= cargarid_empresaHobbyCliente;
	}

	public Border setResaltarid_clienteHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyclienteBeanSwingJInternalFrame.jTtoolBarHobbyCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteHobbyCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteHobbyCliente() {
		return this.resaltarid_clienteHobbyCliente;
	}

	public void setResaltarid_clienteHobbyCliente(Border borderResaltar) {
		this.resaltarid_clienteHobbyCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteHobbyCliente() {
		return this.mostrarid_clienteHobbyCliente;
	}

	public void setMostrarid_clienteHobbyCliente(Boolean mostrarid_clienteHobbyCliente) {
		this.mostrarid_clienteHobbyCliente= mostrarid_clienteHobbyCliente;
	}

	public Boolean getActivarid_clienteHobbyCliente() {
		return this.activarid_clienteHobbyCliente;
	}

	public void setActivarid_clienteHobbyCliente(Boolean activarid_clienteHobbyCliente) {
		this.activarid_clienteHobbyCliente= activarid_clienteHobbyCliente;
	}

	public Boolean getCargarid_clienteHobbyCliente() {
		return this.cargarid_clienteHobbyCliente;
	}

	public void setCargarid_clienteHobbyCliente(Boolean cargarid_clienteHobbyCliente) {
		this.cargarid_clienteHobbyCliente= cargarid_clienteHobbyCliente;
	}

	public Border setResaltarid_hobbyHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyclienteBeanSwingJInternalFrame.jTtoolBarHobbyCliente.setBorder(borderResaltar);
		
		this.resaltarid_hobbyHobbyCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_hobbyHobbyCliente() {
		return this.resaltarid_hobbyHobbyCliente;
	}

	public void setResaltarid_hobbyHobbyCliente(Border borderResaltar) {
		this.resaltarid_hobbyHobbyCliente= borderResaltar;
	}

	public Boolean getMostrarid_hobbyHobbyCliente() {
		return this.mostrarid_hobbyHobbyCliente;
	}

	public void setMostrarid_hobbyHobbyCliente(Boolean mostrarid_hobbyHobbyCliente) {
		this.mostrarid_hobbyHobbyCliente= mostrarid_hobbyHobbyCliente;
	}

	public Boolean getActivarid_hobbyHobbyCliente() {
		return this.activarid_hobbyHobbyCliente;
	}

	public void setActivarid_hobbyHobbyCliente(Boolean activarid_hobbyHobbyCliente) {
		this.activarid_hobbyHobbyCliente= activarid_hobbyHobbyCliente;
	}

	public Boolean getCargarid_hobbyHobbyCliente() {
		return this.cargarid_hobbyHobbyCliente;
	}

	public void setCargarid_hobbyHobbyCliente(Boolean cargarid_hobbyHobbyCliente) {
		this.cargarid_hobbyHobbyCliente= cargarid_hobbyHobbyCliente;
	}

	public Border setResaltardescripcionHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//hobbyclienteBeanSwingJInternalFrame.jTtoolBarHobbyCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionHobbyCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionHobbyCliente() {
		return this.resaltardescripcionHobbyCliente;
	}

	public void setResaltardescripcionHobbyCliente(Border borderResaltar) {
		this.resaltardescripcionHobbyCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionHobbyCliente() {
		return this.mostrardescripcionHobbyCliente;
	}

	public void setMostrardescripcionHobbyCliente(Boolean mostrardescripcionHobbyCliente) {
		this.mostrardescripcionHobbyCliente= mostrardescripcionHobbyCliente;
	}

	public Boolean getActivardescripcionHobbyCliente() {
		return this.activardescripcionHobbyCliente;
	}

	public void setActivardescripcionHobbyCliente(Boolean activardescripcionHobbyCliente) {
		this.activardescripcionHobbyCliente= activardescripcionHobbyCliente;
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
		
		
		this.setMostraridHobbyCliente(esInicial);
		this.setMostrarid_empresaHobbyCliente(esInicial);
		this.setMostrarid_clienteHobbyCliente(esInicial);
		this.setMostrarid_hobbyHobbyCliente(esInicial);
		this.setMostrardescripcionHobbyCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HobbyClienteConstantesFunciones.ID)) {
				this.setMostraridHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDHOBBY)) {
				this.setMostrarid_hobbyHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionHobbyCliente(esAsigna);
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
		
		
		this.setActivaridHobbyCliente(esInicial);
		this.setActivarid_empresaHobbyCliente(esInicial);
		this.setActivarid_clienteHobbyCliente(esInicial);
		this.setActivarid_hobbyHobbyCliente(esInicial);
		this.setActivardescripcionHobbyCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HobbyClienteConstantesFunciones.ID)) {
				this.setActivaridHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDHOBBY)) {
				this.setActivarid_hobbyHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionHobbyCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridHobbyCliente(esInicial);
		this.setResaltarid_empresaHobbyCliente(esInicial);
		this.setResaltarid_clienteHobbyCliente(esInicial);
		this.setResaltarid_hobbyHobbyCliente(esInicial);
		this.setResaltardescripcionHobbyCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(HobbyClienteConstantesFunciones.ID)) {
				this.setResaltaridHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.IDHOBBY)) {
				this.setResaltarid_hobbyHobbyCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(HobbyClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionHobbyCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteHobbyCliente=true;

	public Boolean getMostrarFK_IdClienteHobbyCliente() {
		return this.mostrarFK_IdClienteHobbyCliente;
	}

	public void setMostrarFK_IdClienteHobbyCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteHobbyCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaHobbyCliente=true;

	public Boolean getMostrarFK_IdEmpresaHobbyCliente() {
		return this.mostrarFK_IdEmpresaHobbyCliente;
	}

	public void setMostrarFK_IdEmpresaHobbyCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaHobbyCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdHobbyHobbyCliente=true;

	public Boolean getMostrarFK_IdHobbyHobbyCliente() {
		return this.mostrarFK_IdHobbyHobbyCliente;
	}

	public void setMostrarFK_IdHobbyHobbyCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdHobbyHobbyCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteHobbyCliente=true;

	public Boolean getActivarFK_IdClienteHobbyCliente() {
		return this.activarFK_IdClienteHobbyCliente;
	}

	public void setActivarFK_IdClienteHobbyCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteHobbyCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaHobbyCliente=true;

	public Boolean getActivarFK_IdEmpresaHobbyCliente() {
		return this.activarFK_IdEmpresaHobbyCliente;
	}

	public void setActivarFK_IdEmpresaHobbyCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaHobbyCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdHobbyHobbyCliente=true;

	public Boolean getActivarFK_IdHobbyHobbyCliente() {
		return this.activarFK_IdHobbyHobbyCliente;
	}

	public void setActivarFK_IdHobbyHobbyCliente(Boolean habilitarResaltar) {
		this.activarFK_IdHobbyHobbyCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteHobbyCliente=null;

	public Border getResaltarFK_IdClienteHobbyCliente() {
		return this.resaltarFK_IdClienteHobbyCliente;
	}

	public void setResaltarFK_IdClienteHobbyCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteHobbyCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteHobbyCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaHobbyCliente=null;

	public Border getResaltarFK_IdEmpresaHobbyCliente() {
		return this.resaltarFK_IdEmpresaHobbyCliente;
	}

	public void setResaltarFK_IdEmpresaHobbyCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaHobbyCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaHobbyCliente= borderResaltar;
	}

	public Border resaltarFK_IdHobbyHobbyCliente=null;

	public Border getResaltarFK_IdHobbyHobbyCliente() {
		return this.resaltarFK_IdHobbyHobbyCliente;
	}

	public void setResaltarFK_IdHobbyHobbyCliente(Border borderResaltar) {
		this.resaltarFK_IdHobbyHobbyCliente= borderResaltar;
	}

	public void setResaltarFK_IdHobbyHobbyCliente(ParametroGeneralUsuario parametroGeneralUsuario/*HobbyClienteBeanSwingJInternalFrame hobbyclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdHobbyHobbyCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}