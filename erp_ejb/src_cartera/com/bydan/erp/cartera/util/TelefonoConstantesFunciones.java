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


import com.bydan.erp.cartera.util.TelefonoConstantesFunciones;
import com.bydan.erp.cartera.util.TelefonoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TelefonoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TelefonoConstantesFunciones extends TelefonoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Telefono";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Telefono"+TelefonoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TelefonoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TelefonoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TelefonoConstantesFunciones.SCHEMA+"_"+TelefonoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TelefonoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TelefonoConstantesFunciones.SCHEMA+"_"+TelefonoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TelefonoConstantesFunciones.SCHEMA+"_"+TelefonoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TelefonoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TelefonoConstantesFunciones.SCHEMA+"_"+TelefonoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TelefonoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TelefonoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TelefonoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TelefonoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TelefonoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TelefonoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TelefonoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Telefonos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Telefono";
	public static final String SCLASSWEBTITULO_LOWER="Telefono";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Telefono";
	public static final String OBJECTNAME="telefono";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="telefono";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select telefono from "+TelefonoConstantesFunciones.SPERSISTENCENAME+" telefono";
	public static String QUERYSELECTNATIVE="select "+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".id,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".version_row,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".id_empresa,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".id_cliente,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".id_tipo_telefono,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".id_pais,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".id_ciudad,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".telefono,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".extension,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".es_activo,"+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME+".descripcion from "+TelefonoConstantesFunciones.SCHEMA+"."+TelefonoConstantesFunciones.TABLENAME;//+" as "+TelefonoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TelefonoConstantesFuncionesAdditional telefonoConstantesFuncionesAdditional=null;
	
	public TelefonoConstantesFuncionesAdditional getTelefonoConstantesFuncionesAdditional() {
		return this.telefonoConstantesFuncionesAdditional;
	}
	
	public void setTelefonoConstantesFuncionesAdditional(TelefonoConstantesFuncionesAdditional telefonoConstantesFuncionesAdditional) {
		try {
			this.telefonoConstantesFuncionesAdditional=telefonoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOTELEFO= "id_tipo_telefono";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String TELEFONO= "telefono";
    public static final String EXTENSION= "extension";
    public static final String ESACTIVO= "es_activo";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOTELEFO= "Tipo Telefono";
		public static final String LABEL_IDTIPOTELEFO_LOWER= "Tipo Telefo";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_EXTENSION= "Extension";
		public static final String LABEL_EXTENSION_LOWER= "Extension";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXEXTENSION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEXTENSION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTelefonoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TelefonoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.IDCLIENTE)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.IDTIPOTELEFO)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_IDTIPOTELEFO;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.IDPAIS)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.IDCIUDAD)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.TELEFONO)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.EXTENSION)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_EXTENSION;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.ESACTIVO)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_ESACTIVO;}
		if(sNombreColumna.equals(TelefonoConstantesFunciones.DESCRIPCION)) {sLabelColumna=TelefonoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_activoDescripcion(Telefono telefono) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!telefono.getes_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_activoHtmlDescripcion(Telefono telefono) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(telefono.getId(),telefono.getes_activo());

		return sDescripcion;
	}	
			
	
	public static String getTelefonoDescripcion(Telefono telefono) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(telefono !=null/* && telefono.getId()!=0*/) {
			sDescripcion=telefono.gettelefono();//telefonotelefono.gettelefono().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTelefonoDescripcionDetallado(Telefono telefono) {
		String sDescripcion="";
			
		sDescripcion+=TelefonoConstantesFunciones.ID+"=";
		sDescripcion+=telefono.getId().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=telefono.getVersionRow().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=telefono.getid_empresa().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=telefono.getid_cliente().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.IDTIPOTELEFO+"=";
		sDescripcion+=telefono.getid_tipo_telefono().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=telefono.getid_pais().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=telefono.getid_ciudad().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.TELEFONO+"=";
		sDescripcion+=telefono.gettelefono()+",";
		sDescripcion+=TelefonoConstantesFunciones.EXTENSION+"=";
		sDescripcion+=telefono.getextension()+",";
		sDescripcion+=TelefonoConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=telefono.getes_activo().toString()+",";
		sDescripcion+=TelefonoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=telefono.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTelefonoDescripcion(Telefono telefono,String sValor) throws Exception {			
		if(telefono !=null) {
			telefono.settelefono(sValor);;//telefonotelefono.gettelefono().trim();
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

	public static String getTipoTelefoDescripcion(TipoTelefo tipotelefo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotelefo!=null/*&&tipotelefo.getId()>0*/) {
			sDescripcion=TipoTelefoConstantesFunciones.getTipoTelefoDescripcion(tipotelefo);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdValorTelefono")) {
			sNombreIndice="Tipo=  Por Tipo Telefono";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorTelefono(Long id_tipo_telefono) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_telefono!=null) {sDetalleIndice+=" Codigo Unico De Tipo Telefono="+id_tipo_telefono.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTelefono(Telefono telefono,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		telefono.settelefono(telefono.gettelefono().trim());
		telefono.setextension(telefono.getextension().trim());
		telefono.setdescripcion(telefono.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTelefonos(List<Telefono> telefonos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Telefono telefono: telefonos) {
			telefono.settelefono(telefono.gettelefono().trim());
			telefono.setextension(telefono.getextension().trim());
			telefono.setdescripcion(telefono.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTelefono(Telefono telefono,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && telefono.getConCambioAuxiliar()) {
			telefono.setIsDeleted(telefono.getIsDeletedAuxiliar());	
			telefono.setIsNew(telefono.getIsNewAuxiliar());	
			telefono.setIsChanged(telefono.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			telefono.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			telefono.setIsDeletedAuxiliar(false);	
			telefono.setIsNewAuxiliar(false);	
			telefono.setIsChangedAuxiliar(false);
			
			telefono.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTelefonos(List<Telefono> telefonos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Telefono telefono : telefonos) {
			if(conAsignarBase && telefono.getConCambioAuxiliar()) {
				telefono.setIsDeleted(telefono.getIsDeletedAuxiliar());	
				telefono.setIsNew(telefono.getIsNewAuxiliar());	
				telefono.setIsChanged(telefono.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				telefono.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				telefono.setIsDeletedAuxiliar(false);	
				telefono.setIsNewAuxiliar(false);	
				telefono.setIsChangedAuxiliar(false);
				
				telefono.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTelefono(Telefono telefono,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTelefonos(List<Telefono> telefonos,Boolean conEnteros) throws Exception  {
		
		for(Telefono telefono: telefonos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTelefono(List<Telefono> telefonos,Telefono telefonoAux) throws Exception  {
		TelefonoConstantesFunciones.InicializarValoresTelefono(telefonoAux,true);
		
		for(Telefono telefono: telefonos) {
			if(telefono.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTelefono(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TelefonoConstantesFunciones.getArrayColumnasGlobalesTelefono(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTelefono(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TelefonoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TelefonoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTelefono(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Telefono> telefonos,Telefono telefono,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Telefono telefonoAux: telefonos) {
			if(telefonoAux!=null && telefono!=null) {
				if((telefonoAux.getId()==null && telefono.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(telefonoAux.getId()!=null && telefono.getId()!=null){
					if(telefonoAux.getId().equals(telefono.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTelefono(List<Telefono> telefonos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Telefono telefono: telefonos) {			
			if(telefono.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTelefono() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_ID, TelefonoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_VERSIONROW, TelefonoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_IDEMPRESA, TelefonoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_IDCLIENTE, TelefonoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_IDTIPOTELEFO, TelefonoConstantesFunciones.IDTIPOTELEFO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_IDPAIS, TelefonoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_IDCIUDAD, TelefonoConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_TELEFONO, TelefonoConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_EXTENSION, TelefonoConstantesFunciones.EXTENSION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_ESACTIVO, TelefonoConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TelefonoConstantesFunciones.LABEL_DESCRIPCION, TelefonoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTelefono() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.IDTIPOTELEFO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.EXTENSION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TelefonoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefono() throws Exception  {
		return TelefonoConstantesFunciones.getTiposSeleccionarTelefono(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefono(Boolean conFk) throws Exception  {
		return TelefonoConstantesFunciones.getTiposSeleccionarTelefono(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefono(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_IDTIPOTELEFO);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_IDTIPOTELEFO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_EXTENSION);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_EXTENSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TelefonoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TelefonoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTelefono(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTelefono(Telefono telefonoAux) throws Exception {
		
			telefonoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(telefonoAux.getEmpresa()));
			telefonoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(telefonoAux.getCliente()));
			telefonoAux.settipotelefo_descripcion(TipoTelefoConstantesFunciones.getTipoTelefoDescripcion(telefonoAux.getTipoTelefo()));
			telefonoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(telefonoAux.getPais()));
			telefonoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(telefonoAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTelefono(List<Telefono> telefonosTemp) throws Exception {
		for(Telefono telefonoAux:telefonosTemp) {
			
			telefonoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(telefonoAux.getEmpresa()));
			telefonoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(telefonoAux.getCliente()));
			telefonoAux.settipotelefo_descripcion(TipoTelefoConstantesFunciones.getTipoTelefoDescripcion(telefonoAux.getTipoTelefo()));
			telefonoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(telefonoAux.getPais()));
			telefonoAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(telefonoAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTelefono(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoTelefo.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
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
					if(clas.clas.equals(TipoTelefo.class)) {
						classes.add(new Classe(TipoTelefo.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTelefono(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoTelefo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTelefo.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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

					if(TipoTelefo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTelefo.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefono(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TelefonoConstantesFunciones.getClassesRelationshipsOfTelefono(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefono(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTelefono(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TelefonoConstantesFunciones.getClassesRelationshipsFromStringsOfTelefono(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTelefono(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Telefono telefono,List<Telefono> telefonos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Telefono telefonoEncontrado=null;
			
			for(Telefono telefonoLocal:telefonos) {
				if(telefonoLocal.getId().equals(telefono.getId())) {
					telefonoEncontrado=telefonoLocal;
					
					telefonoLocal.setIsChanged(telefono.getIsChanged());
					telefonoLocal.setIsNew(telefono.getIsNew());
					telefonoLocal.setIsDeleted(telefono.getIsDeleted());
					
					telefonoLocal.setGeneralEntityOriginal(telefono.getGeneralEntityOriginal());
					
					telefonoLocal.setId(telefono.getId());	
					telefonoLocal.setVersionRow(telefono.getVersionRow());	
					telefonoLocal.setid_empresa(telefono.getid_empresa());	
					telefonoLocal.setid_cliente(telefono.getid_cliente());	
					telefonoLocal.setid_tipo_telefono(telefono.getid_tipo_telefono());	
					telefonoLocal.setid_pais(telefono.getid_pais());	
					telefonoLocal.setid_ciudad(telefono.getid_ciudad());	
					telefonoLocal.settelefono(telefono.gettelefono());	
					telefonoLocal.setextension(telefono.getextension());	
					telefonoLocal.setes_activo(telefono.getes_activo());	
					telefonoLocal.setdescripcion(telefono.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!telefono.getIsDeleted()) {
				if(!existe) {
					telefonos.add(telefono);
				}
			} else {
				if(telefonoEncontrado!=null && permiteQuitar)  {
					telefonos.remove(telefonoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Telefono telefono,List<Telefono> telefonos) throws Exception {
		try	{			
			for(Telefono telefonoLocal:telefonos) {
				if(telefonoLocal.getId().equals(telefono.getId())) {
					telefonoLocal.setIsSelected(telefono.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTelefono(List<Telefono> telefonosAux) throws Exception {
		//this.telefonosAux=telefonosAux;
		
		for(Telefono telefonoAux:telefonosAux) {
			if(telefonoAux.getIsChanged()) {
				telefonoAux.setIsChanged(false);
			}		
			
			if(telefonoAux.getIsNew()) {
				telefonoAux.setIsNew(false);
			}	
			
			if(telefonoAux.getIsDeleted()) {
				telefonoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTelefono(Telefono telefonoAux) throws Exception {
		//this.telefonoAux=telefonoAux;
		
			if(telefonoAux.getIsChanged()) {
				telefonoAux.setIsChanged(false);
			}		
			
			if(telefonoAux.getIsNew()) {
				telefonoAux.setIsNew(false);
			}	
			
			if(telefonoAux.getIsDeleted()) {
				telefonoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Telefono telefonoAsignar,Telefono telefono) throws Exception {
		telefonoAsignar.setId(telefono.getId());	
		telefonoAsignar.setVersionRow(telefono.getVersionRow());	
		telefonoAsignar.setid_empresa(telefono.getid_empresa());
		telefonoAsignar.setempresa_descripcion(telefono.getempresa_descripcion());	
		telefonoAsignar.setid_cliente(telefono.getid_cliente());
		telefonoAsignar.setcliente_descripcion(telefono.getcliente_descripcion());	
		telefonoAsignar.setid_tipo_telefono(telefono.getid_tipo_telefono());
		telefonoAsignar.settipotelefo_descripcion(telefono.gettipotelefo_descripcion());	
		telefonoAsignar.setid_pais(telefono.getid_pais());
		telefonoAsignar.setpais_descripcion(telefono.getpais_descripcion());	
		telefonoAsignar.setid_ciudad(telefono.getid_ciudad());
		telefonoAsignar.setciudad_descripcion(telefono.getciudad_descripcion());	
		telefonoAsignar.settelefono(telefono.gettelefono());	
		telefonoAsignar.setextension(telefono.getextension());	
		telefonoAsignar.setes_activo(telefono.getes_activo());	
		telefonoAsignar.setdescripcion(telefono.getdescripcion());	
	}
	
	public static void inicializarTelefono(Telefono telefono) throws Exception {
		try {
				telefono.setId(0L);	
					
				telefono.setid_empresa(-1L);	
				telefono.setid_cliente(-1L);	
				telefono.setid_tipo_telefono(-1L);	
				telefono.setid_pais(-1L);	
				telefono.setid_ciudad(-1L);	
				telefono.settelefono("");	
				telefono.setextension("");	
				telefono.setes_activo(false);	
				telefono.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTelefono(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_IDTIPOTELEFO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_EXTENSION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TelefonoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTelefono(String sTipo,Row row,Workbook workbook,Telefono telefono,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.gettipotelefo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.getextension());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(telefono.getes_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTelefono=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTelefono() {
		return this.sFinalQueryTelefono;
	}
	
	public void setsFinalQueryTelefono(String sFinalQueryTelefono) {
		this.sFinalQueryTelefono= sFinalQueryTelefono;
	}
	
	public Border resaltarSeleccionarTelefono=null;
	
	public Border setResaltarSeleccionarTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTelefono= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTelefono() {
		return this.resaltarSeleccionarTelefono;
	}
	
	public void setResaltarSeleccionarTelefono(Border borderResaltarSeleccionarTelefono) {
		this.resaltarSeleccionarTelefono= borderResaltarSeleccionarTelefono;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTelefono=null;
	public Boolean mostraridTelefono=true;
	public Boolean activaridTelefono=true;

	public Border resaltarid_empresaTelefono=null;
	public Boolean mostrarid_empresaTelefono=true;
	public Boolean activarid_empresaTelefono=true;
	public Boolean cargarid_empresaTelefono=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTelefono=false;//ConEventDepend=true

	public Border resaltarid_clienteTelefono=null;
	public Boolean mostrarid_clienteTelefono=true;
	public Boolean activarid_clienteTelefono=true;
	public Boolean cargarid_clienteTelefono=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteTelefono=false;//ConEventDepend=true

	public Border resaltarid_tipo_telefonoTelefono=null;
	public Boolean mostrarid_tipo_telefonoTelefono=true;
	public Boolean activarid_tipo_telefonoTelefono=true;
	public Boolean cargarid_tipo_telefonoTelefono=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_telefonoTelefono=false;//ConEventDepend=true

	public Border resaltarid_paisTelefono=null;
	public Boolean mostrarid_paisTelefono=true;
	public Boolean activarid_paisTelefono=true;
	public Boolean cargarid_paisTelefono=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTelefono=false;//ConEventDepend=true

	public Border resaltarid_ciudadTelefono=null;
	public Boolean mostrarid_ciudadTelefono=true;
	public Boolean activarid_ciudadTelefono=true;
	public Boolean cargarid_ciudadTelefono=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadTelefono=true;//ConEventDepend=true

	public Border resaltartelefonoTelefono=null;
	public Boolean mostrartelefonoTelefono=true;
	public Boolean activartelefonoTelefono=true;

	public Border resaltarextensionTelefono=null;
	public Boolean mostrarextensionTelefono=true;
	public Boolean activarextensionTelefono=true;

	public Border resaltares_activoTelefono=null;
	public Boolean mostrares_activoTelefono=true;
	public Boolean activares_activoTelefono=true;

	public Border resaltardescripcionTelefono=null;
	public Boolean mostrardescripcionTelefono=true;
	public Boolean activardescripcionTelefono=true;

	
	

	public Border setResaltaridTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltaridTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTelefono() {
		return this.resaltaridTelefono;
	}

	public void setResaltaridTelefono(Border borderResaltar) {
		this.resaltaridTelefono= borderResaltar;
	}

	public Boolean getMostraridTelefono() {
		return this.mostraridTelefono;
	}

	public void setMostraridTelefono(Boolean mostraridTelefono) {
		this.mostraridTelefono= mostraridTelefono;
	}

	public Boolean getActivaridTelefono() {
		return this.activaridTelefono;
	}

	public void setActivaridTelefono(Boolean activaridTelefono) {
		this.activaridTelefono= activaridTelefono;
	}

	public Border setResaltarid_empresaTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltarid_empresaTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTelefono() {
		return this.resaltarid_empresaTelefono;
	}

	public void setResaltarid_empresaTelefono(Border borderResaltar) {
		this.resaltarid_empresaTelefono= borderResaltar;
	}

	public Boolean getMostrarid_empresaTelefono() {
		return this.mostrarid_empresaTelefono;
	}

	public void setMostrarid_empresaTelefono(Boolean mostrarid_empresaTelefono) {
		this.mostrarid_empresaTelefono= mostrarid_empresaTelefono;
	}

	public Boolean getActivarid_empresaTelefono() {
		return this.activarid_empresaTelefono;
	}

	public void setActivarid_empresaTelefono(Boolean activarid_empresaTelefono) {
		this.activarid_empresaTelefono= activarid_empresaTelefono;
	}

	public Boolean getCargarid_empresaTelefono() {
		return this.cargarid_empresaTelefono;
	}

	public void setCargarid_empresaTelefono(Boolean cargarid_empresaTelefono) {
		this.cargarid_empresaTelefono= cargarid_empresaTelefono;
	}

	public Border setResaltarid_clienteTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltarid_clienteTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteTelefono() {
		return this.resaltarid_clienteTelefono;
	}

	public void setResaltarid_clienteTelefono(Border borderResaltar) {
		this.resaltarid_clienteTelefono= borderResaltar;
	}

	public Boolean getMostrarid_clienteTelefono() {
		return this.mostrarid_clienteTelefono;
	}

	public void setMostrarid_clienteTelefono(Boolean mostrarid_clienteTelefono) {
		this.mostrarid_clienteTelefono= mostrarid_clienteTelefono;
	}

	public Boolean getActivarid_clienteTelefono() {
		return this.activarid_clienteTelefono;
	}

	public void setActivarid_clienteTelefono(Boolean activarid_clienteTelefono) {
		this.activarid_clienteTelefono= activarid_clienteTelefono;
	}

	public Boolean getCargarid_clienteTelefono() {
		return this.cargarid_clienteTelefono;
	}

	public void setCargarid_clienteTelefono(Boolean cargarid_clienteTelefono) {
		this.cargarid_clienteTelefono= cargarid_clienteTelefono;
	}

	public Border setResaltarid_tipo_telefonoTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltarid_tipo_telefonoTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_telefonoTelefono() {
		return this.resaltarid_tipo_telefonoTelefono;
	}

	public void setResaltarid_tipo_telefonoTelefono(Border borderResaltar) {
		this.resaltarid_tipo_telefonoTelefono= borderResaltar;
	}

	public Boolean getMostrarid_tipo_telefonoTelefono() {
		return this.mostrarid_tipo_telefonoTelefono;
	}

	public void setMostrarid_tipo_telefonoTelefono(Boolean mostrarid_tipo_telefonoTelefono) {
		this.mostrarid_tipo_telefonoTelefono= mostrarid_tipo_telefonoTelefono;
	}

	public Boolean getActivarid_tipo_telefonoTelefono() {
		return this.activarid_tipo_telefonoTelefono;
	}

	public void setActivarid_tipo_telefonoTelefono(Boolean activarid_tipo_telefonoTelefono) {
		this.activarid_tipo_telefonoTelefono= activarid_tipo_telefonoTelefono;
	}

	public Boolean getCargarid_tipo_telefonoTelefono() {
		return this.cargarid_tipo_telefonoTelefono;
	}

	public void setCargarid_tipo_telefonoTelefono(Boolean cargarid_tipo_telefonoTelefono) {
		this.cargarid_tipo_telefonoTelefono= cargarid_tipo_telefonoTelefono;
	}

	public Border setResaltarid_paisTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltarid_paisTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTelefono() {
		return this.resaltarid_paisTelefono;
	}

	public void setResaltarid_paisTelefono(Border borderResaltar) {
		this.resaltarid_paisTelefono= borderResaltar;
	}

	public Boolean getMostrarid_paisTelefono() {
		return this.mostrarid_paisTelefono;
	}

	public void setMostrarid_paisTelefono(Boolean mostrarid_paisTelefono) {
		this.mostrarid_paisTelefono= mostrarid_paisTelefono;
	}

	public Boolean getActivarid_paisTelefono() {
		return this.activarid_paisTelefono;
	}

	public void setActivarid_paisTelefono(Boolean activarid_paisTelefono) {
		this.activarid_paisTelefono= activarid_paisTelefono;
	}

	public Boolean getCargarid_paisTelefono() {
		return this.cargarid_paisTelefono;
	}

	public void setCargarid_paisTelefono(Boolean cargarid_paisTelefono) {
		this.cargarid_paisTelefono= cargarid_paisTelefono;
	}

	public Border setResaltarid_ciudadTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltarid_ciudadTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadTelefono() {
		return this.resaltarid_ciudadTelefono;
	}

	public void setResaltarid_ciudadTelefono(Border borderResaltar) {
		this.resaltarid_ciudadTelefono= borderResaltar;
	}

	public Boolean getMostrarid_ciudadTelefono() {
		return this.mostrarid_ciudadTelefono;
	}

	public void setMostrarid_ciudadTelefono(Boolean mostrarid_ciudadTelefono) {
		this.mostrarid_ciudadTelefono= mostrarid_ciudadTelefono;
	}

	public Boolean getActivarid_ciudadTelefono() {
		return this.activarid_ciudadTelefono;
	}

	public void setActivarid_ciudadTelefono(Boolean activarid_ciudadTelefono) {
		this.activarid_ciudadTelefono= activarid_ciudadTelefono;
	}

	public Boolean getCargarid_ciudadTelefono() {
		return this.cargarid_ciudadTelefono;
	}

	public void setCargarid_ciudadTelefono(Boolean cargarid_ciudadTelefono) {
		this.cargarid_ciudadTelefono= cargarid_ciudadTelefono;
	}

	public Border setResaltartelefonoTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltartelefonoTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoTelefono() {
		return this.resaltartelefonoTelefono;
	}

	public void setResaltartelefonoTelefono(Border borderResaltar) {
		this.resaltartelefonoTelefono= borderResaltar;
	}

	public Boolean getMostrartelefonoTelefono() {
		return this.mostrartelefonoTelefono;
	}

	public void setMostrartelefonoTelefono(Boolean mostrartelefonoTelefono) {
		this.mostrartelefonoTelefono= mostrartelefonoTelefono;
	}

	public Boolean getActivartelefonoTelefono() {
		return this.activartelefonoTelefono;
	}

	public void setActivartelefonoTelefono(Boolean activartelefonoTelefono) {
		this.activartelefonoTelefono= activartelefonoTelefono;
	}

	public Border setResaltarextensionTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltarextensionTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarextensionTelefono() {
		return this.resaltarextensionTelefono;
	}

	public void setResaltarextensionTelefono(Border borderResaltar) {
		this.resaltarextensionTelefono= borderResaltar;
	}

	public Boolean getMostrarextensionTelefono() {
		return this.mostrarextensionTelefono;
	}

	public void setMostrarextensionTelefono(Boolean mostrarextensionTelefono) {
		this.mostrarextensionTelefono= mostrarextensionTelefono;
	}

	public Boolean getActivarextensionTelefono() {
		return this.activarextensionTelefono;
	}

	public void setActivarextensionTelefono(Boolean activarextensionTelefono) {
		this.activarextensionTelefono= activarextensionTelefono;
	}

	public Border setResaltares_activoTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltares_activoTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_activoTelefono() {
		return this.resaltares_activoTelefono;
	}

	public void setResaltares_activoTelefono(Border borderResaltar) {
		this.resaltares_activoTelefono= borderResaltar;
	}

	public Boolean getMostrares_activoTelefono() {
		return this.mostrares_activoTelefono;
	}

	public void setMostrares_activoTelefono(Boolean mostrares_activoTelefono) {
		this.mostrares_activoTelefono= mostrares_activoTelefono;
	}

	public Boolean getActivares_activoTelefono() {
		return this.activares_activoTelefono;
	}

	public void setActivares_activoTelefono(Boolean activares_activoTelefono) {
		this.activares_activoTelefono= activares_activoTelefono;
	}

	public Border setResaltardescripcionTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefonoBeanSwingJInternalFrame.jTtoolBarTelefono.setBorder(borderResaltar);
		
		this.resaltardescripcionTelefono= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTelefono() {
		return this.resaltardescripcionTelefono;
	}

	public void setResaltardescripcionTelefono(Border borderResaltar) {
		this.resaltardescripcionTelefono= borderResaltar;
	}

	public Boolean getMostrardescripcionTelefono() {
		return this.mostrardescripcionTelefono;
	}

	public void setMostrardescripcionTelefono(Boolean mostrardescripcionTelefono) {
		this.mostrardescripcionTelefono= mostrardescripcionTelefono;
	}

	public Boolean getActivardescripcionTelefono() {
		return this.activardescripcionTelefono;
	}

	public void setActivardescripcionTelefono(Boolean activardescripcionTelefono) {
		this.activardescripcionTelefono= activardescripcionTelefono;
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
		
		
		this.setMostraridTelefono(esInicial);
		this.setMostrarid_empresaTelefono(esInicial);
		this.setMostrarid_clienteTelefono(esInicial);
		this.setMostrarid_tipo_telefonoTelefono(esInicial);
		this.setMostrarid_paisTelefono(esInicial);
		this.setMostrarid_ciudadTelefono(esInicial);
		this.setMostrartelefonoTelefono(esInicial);
		this.setMostrarextensionTelefono(esInicial);
		this.setMostrares_activoTelefono(esInicial);
		this.setMostrardescripcionTelefono(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TelefonoConstantesFunciones.ID)) {
				this.setMostraridTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDTIPOTELEFO)) {
				this.setMostrarid_tipo_telefonoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.EXTENSION)) {
				this.setMostrarextensionTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.ESACTIVO)) {
				this.setMostrares_activoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTelefono(esAsigna);
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
		
		
		this.setActivaridTelefono(esInicial);
		this.setActivarid_empresaTelefono(esInicial);
		this.setActivarid_clienteTelefono(esInicial);
		this.setActivarid_tipo_telefonoTelefono(esInicial);
		this.setActivarid_paisTelefono(esInicial);
		this.setActivarid_ciudadTelefono(esInicial);
		this.setActivartelefonoTelefono(esInicial);
		this.setActivarextensionTelefono(esInicial);
		this.setActivares_activoTelefono(esInicial);
		this.setActivardescripcionTelefono(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TelefonoConstantesFunciones.ID)) {
				this.setActivaridTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDTIPOTELEFO)) {
				this.setActivarid_tipo_telefonoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.EXTENSION)) {
				this.setActivarextensionTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.ESACTIVO)) {
				this.setActivares_activoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTelefono(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTelefono(esInicial);
		this.setResaltarid_empresaTelefono(esInicial);
		this.setResaltarid_clienteTelefono(esInicial);
		this.setResaltarid_tipo_telefonoTelefono(esInicial);
		this.setResaltarid_paisTelefono(esInicial);
		this.setResaltarid_ciudadTelefono(esInicial);
		this.setResaltartelefonoTelefono(esInicial);
		this.setResaltarextensionTelefono(esInicial);
		this.setResaltares_activoTelefono(esInicial);
		this.setResaltardescripcionTelefono(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TelefonoConstantesFunciones.ID)) {
				this.setResaltaridTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDTIPOTELEFO)) {
				this.setResaltarid_tipo_telefonoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.EXTENSION)) {
				this.setResaltarextensionTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.ESACTIVO)) {
				this.setResaltares_activoTelefono(esAsigna);
				continue;
			}

			if(campo.clase.equals(TelefonoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTelefono(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadTelefono=true;

	public Boolean getMostrarFK_IdCiudadTelefono() {
		return this.mostrarFK_IdCiudadTelefono;
	}

	public void setMostrarFK_IdCiudadTelefono(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadTelefono= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteTelefono=true;

	public Boolean getMostrarFK_IdClienteTelefono() {
		return this.mostrarFK_IdClienteTelefono;
	}

	public void setMostrarFK_IdClienteTelefono(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteTelefono= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTelefono=true;

	public Boolean getMostrarFK_IdEmpresaTelefono() {
		return this.mostrarFK_IdEmpresaTelefono;
	}

	public void setMostrarFK_IdEmpresaTelefono(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTelefono= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTelefono=true;

	public Boolean getMostrarFK_IdPaisTelefono() {
		return this.mostrarFK_IdPaisTelefono;
	}

	public void setMostrarFK_IdPaisTelefono(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTelefono= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorTelefonoTelefono=true;

	public Boolean getMostrarFK_IdValorTelefonoTelefono() {
		return this.mostrarFK_IdValorTelefonoTelefono;
	}

	public void setMostrarFK_IdValorTelefonoTelefono(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorTelefonoTelefono= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadTelefono=true;

	public Boolean getActivarFK_IdCiudadTelefono() {
		return this.activarFK_IdCiudadTelefono;
	}

	public void setActivarFK_IdCiudadTelefono(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadTelefono= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteTelefono=true;

	public Boolean getActivarFK_IdClienteTelefono() {
		return this.activarFK_IdClienteTelefono;
	}

	public void setActivarFK_IdClienteTelefono(Boolean habilitarResaltar) {
		this.activarFK_IdClienteTelefono= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTelefono=true;

	public Boolean getActivarFK_IdEmpresaTelefono() {
		return this.activarFK_IdEmpresaTelefono;
	}

	public void setActivarFK_IdEmpresaTelefono(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTelefono= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTelefono=true;

	public Boolean getActivarFK_IdPaisTelefono() {
		return this.activarFK_IdPaisTelefono;
	}

	public void setActivarFK_IdPaisTelefono(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTelefono= habilitarResaltar;
	}

	public Boolean activarFK_IdValorTelefonoTelefono=true;

	public Boolean getActivarFK_IdValorTelefonoTelefono() {
		return this.activarFK_IdValorTelefonoTelefono;
	}

	public void setActivarFK_IdValorTelefonoTelefono(Boolean habilitarResaltar) {
		this.activarFK_IdValorTelefonoTelefono= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadTelefono=null;

	public Border getResaltarFK_IdCiudadTelefono() {
		return this.resaltarFK_IdCiudadTelefono;
	}

	public void setResaltarFK_IdCiudadTelefono(Border borderResaltar) {
		this.resaltarFK_IdCiudadTelefono= borderResaltar;
	}

	public void setResaltarFK_IdCiudadTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadTelefono= borderResaltar;
	}

	public Border resaltarFK_IdClienteTelefono=null;

	public Border getResaltarFK_IdClienteTelefono() {
		return this.resaltarFK_IdClienteTelefono;
	}

	public void setResaltarFK_IdClienteTelefono(Border borderResaltar) {
		this.resaltarFK_IdClienteTelefono= borderResaltar;
	}

	public void setResaltarFK_IdClienteTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteTelefono= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTelefono=null;

	public Border getResaltarFK_IdEmpresaTelefono() {
		return this.resaltarFK_IdEmpresaTelefono;
	}

	public void setResaltarFK_IdEmpresaTelefono(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTelefono= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTelefono= borderResaltar;
	}

	public Border resaltarFK_IdPaisTelefono=null;

	public Border getResaltarFK_IdPaisTelefono() {
		return this.resaltarFK_IdPaisTelefono;
	}

	public void setResaltarFK_IdPaisTelefono(Border borderResaltar) {
		this.resaltarFK_IdPaisTelefono= borderResaltar;
	}

	public void setResaltarFK_IdPaisTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTelefono= borderResaltar;
	}

	public Border resaltarFK_IdValorTelefonoTelefono=null;

	public Border getResaltarFK_IdValorTelefonoTelefono() {
		return this.resaltarFK_IdValorTelefonoTelefono;
	}

	public void setResaltarFK_IdValorTelefonoTelefono(Border borderResaltar) {
		this.resaltarFK_IdValorTelefonoTelefono= borderResaltar;
	}

	public void setResaltarFK_IdValorTelefonoTelefono(ParametroGeneralUsuario parametroGeneralUsuario/*TelefonoBeanSwingJInternalFrame telefonoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorTelefonoTelefono= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}